package com.bytedance.sdk.openadsdk.ZZv;

/* JADX INFO: loaded from: classes13.dex */
public class ZZv {
    public static String pA() {
        return "CREATE TABLE IF NOT EXISTS adevent (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0 , channel INTEGER default 0)";
    }

    public static String Og() {
        return "ALTER TABLE adevent ADD COLUMN encrypt INTEGER default 0";
    }
}
