package com.bytedance.sdk.openadsdk.ZZv;

/* JADX INFO: loaded from: classes6.dex */
public class oX extends ZZv {
    public static String KZx() {
        return "CREATE TABLE IF NOT EXISTS adevent_applog (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0, channel INTEGER default 0)";
    }
}
