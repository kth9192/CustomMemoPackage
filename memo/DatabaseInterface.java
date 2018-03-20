package com.noname.alarmhelperlib.memo;

import java.util.ArrayList;

/**
 * Created by kth919 on 2018-03-19.
 */

public interface DatabaseInterface {
    void connectDB();
    void saveMemo(MemoModelInterface memoModelInterface);
    ArrayList<MemoModelInterface> loadMemo();
    void deleteMemoInDB(String memoTxt);
    void closeDB();
}
