package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.a5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3983a5 extends DatabaseScript {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11458a = "sessions";
    public final int b = 200;
    public final String c = "id";
    public final String d = "start_time";
    public final String e = "report_request_parameters";
    public final String f = "server_time_offset";
    public final String g = "type";
    public final String h = "obtained_before_first_sync";
    public final B7 i = new B7(null, 1, 0 == true ? 1 : 0);

    public final A7 a(Cursor cursor) {
        try {
            Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.c)));
            int i = cursor.getInt(cursor.getColumnIndexOrThrow(this.g));
            EnumC4621zk enumC4621zk = EnumC4621zk.FOREGROUND;
            boolean z = true;
            if (i != 0) {
                enumC4621zk = EnumC4621zk.BACKGROUND;
                if (i != 1) {
                    enumC4621zk = null;
                }
            }
            String string = cursor.getString(cursor.getColumnIndexOrThrow(this.e));
            Long lValueOf2 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.d)));
            Long lValueOf3 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.f)));
            if (cursor.getInt(cursor.getColumnIndexOrThrow(this.h)) != 1) {
                z = false;
            }
            return new A7(lValueOf, enumC4621zk, string, new C4608z7(lValueOf2, lValueOf3, Boolean.valueOf(z)));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0083  */
    @Override // io.appmetrica.analytics.coreapi.internal.db.DatabaseScript
    public final void runScript(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery;
        Iterator it;
        Long l;
        String str;
        Long l2;
        ArrayList arrayList = new ArrayList();
        try {
            cursorQuery = sQLiteDatabase.query(this.f11458a, null, null, null, null, null, null, String.valueOf(this.b));
            while (cursorQuery.moveToNext()) {
                try {
                    A7 a7A = a(cursorQuery);
                    if (a7A != null && (l = a7A.f11055a) != null && l.longValue() >= 0 && a7A.b != null && (str = a7A.c) != null && str.length() != 0 && (l2 = a7A.d.f11871a) != null && l2.longValue() > 0) {
                        arrayList.add(this.i.fromModel(a7A));
                    }
                } catch (Throwable unused) {
                    if (cursorQuery != null) {
                    }
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.f11458a);
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sessions (id INTEGER,type INTEGER,report_request_parameters TEXT,session_description BLOB )");
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        try {
                            sQLiteDatabase.insertOrThrow("sessions", null, (ContentValues) it.next());
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        } catch (Throwable unused3) {
            cursorQuery = null;
        }
        cursorQuery.close();
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.f11458a);
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sessions (id INTEGER,type INTEGER,report_request_parameters TEXT,session_description BLOB )");
        it = arrayList.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.insertOrThrow("sessions", null, (ContentValues) it.next());
        }
    }
}
