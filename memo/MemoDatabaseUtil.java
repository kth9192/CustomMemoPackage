package com.noname.alarmhelperlib.memo;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by kth919 on 2017-06-02.
 */

public class MemoDatabaseUtil implements DatabaseInterface {

    private static String TAG = MemoDatabaseUtil.class.getName();

    private Context context;
    private Realm realm;

    public MemoDatabaseUtil(Context context) {
        this.context = context;
        connectDB();
    }

    public void connectDB() {
        realm = Realm.getDefaultInstance();
    }

    public void saveMemo(MemoModelInterface s){

        final MemoModel tmpModel = (MemoModel) s;

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {

                MemoModel memoModel = bgRealm.createObject(MemoModel.class);
                memoModel.setMemo(tmpModel.getMemo());
                memoModel.setTime(tmpModel.getTime());
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // 트랜잭션이 성공하였습니다.
                Log.d(TAG, "TRANSACTION SUCCESS");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // 트랜잭션이 실패했고 자동으로 취소되었습니다.
                Log.d(TAG, "TRANSACTION FAILED");
            }
        });
    }

    private RealmResults<MemoModel> loadData(){
        return  realm.where(MemoModel.class).findAll();
    }

    public ArrayList<MemoModelInterface> loadMemo(){

        RealmResults source = loadData();
        ArrayList<MemoModelInterface> resultList = new ArrayList<>();

        for (Object memoModel : source){
            resultList.add((MemoModel) memoModel);
        }

        return resultList;
    }

    public void deleteMemoInDB(final String deleteTxt){

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<MemoModel> source = realm.where(MemoModel.class).equalTo("memo" , deleteTxt).findAll();
                source.deleteAllFromRealm();
            }
        });
    }

    public void closeDB(){
        realm.close();
    }
}
