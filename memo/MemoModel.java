package com.noname.alarmhelperlib.memo;

import io.realm.RealmObject;

/**
 * Created by kth919 on 2017-12-11.
 */

public class MemoModel extends RealmObject implements MemoModelInterface{

    private String memo;
    private String time;
    private String day;
    private boolean isOnAlarm;

    public MemoModel( ) {
    }

    public MemoModel(String memo, boolean isOnAlarm ) {
        this.memo = memo;
        this.isOnAlarm = isOnAlarm;
    }

    public String getMemo() {
        return memo;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getId(){

        StringBuilder sb = new StringBuilder();
        sb.append(memo.charAt(0)).append(time.split(":")[1]);

        return sb.toString().trim();
    }

    public boolean getOnAlarm() {
        return isOnAlarm;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setOnAlarm(boolean onAlarm) {
        isOnAlarm = onAlarm;
    }
}
