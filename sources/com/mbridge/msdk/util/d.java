package com.mbridge.msdk.util;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: MBridgeDatabaseUtils.java */
/* JADX INFO: loaded from: classes13.dex */
public final class d {
    public static boolean a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return false;
        }
        try {
            return sQLiteDatabase.isOpen() && !sQLiteDatabase.isReadOnly();
        } catch (Exception unused) {
            return false;
        }
    }
}
