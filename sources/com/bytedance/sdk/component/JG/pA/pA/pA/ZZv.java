package com.bytedance.sdk.component.JG.pA.pA.pA;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.JG.pA.omh;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ZZv extends SQLiteOpenHelper {
    final Context pA;

    public ZZv(Context context) {
        super(context, "ttadlog.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.pA = context;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            pA(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    private void pA(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.JG.pA.pA.pA.pA.pA.Og(omh.SD().ZZv().Og()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.JG.pA.pA.pA.pA.ZZv.KZx(omh.SD().ZZv().pA()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.JG.pA.pA.pA.pA.SD.KZx(omh.SD().ZZv().ZZv()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.JG.pA.pA.pA.pA.JG.pA(omh.SD().ZZv().ML()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.JG.pA.JG.JG.Og());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (i > i2) {
                Og(sQLiteDatabase);
                pA(sQLiteDatabase);
            } else {
                pA(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }

    private void Og(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayListKZx = KZx(sQLiteDatabase);
        if (arrayListKZx == null || arrayListKZx.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayListKZx.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
        }
    }

    private ArrayList<String> KZx(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    String string = cursorRawQuery.getString(0);
                    if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                cursorRawQuery.close();
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
