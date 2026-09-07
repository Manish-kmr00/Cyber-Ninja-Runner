package com.bytedance.sdk.openadsdk.ZZv;

/* JADX INFO: loaded from: classes14.dex */
public class Sn {
    public static String pA() {
        return "CREATE TABLE IF NOT EXISTS logstats (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , encrypt INTEGER default 0 , retry INTEGER default 0)";
    }

    public static String Og() {
        return "ALTER TABLE logstats ADD COLUMN encrypt INTEGER default 0";
    }
}
