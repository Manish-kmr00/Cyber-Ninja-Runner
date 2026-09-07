package io.appmetrica.analytics.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;

/* JADX INFO: loaded from: classes7.dex */
public final class Z4 extends DatabaseScript {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11446a = 2000;
    public final String b = "number";
    public final String c = "global_number";
    public final String d = "number_of_type";
    public final String e = "name";
    public final String f = "value";
    public final String g = "type";
    public final String h = "time";
    public final String i = SDKAnalyticsEvents.PARAMETER_SESSION_ID;
    public final String j = "error_environment";
    public final String k = "session_type";
    public final String l = "app_environment";
    public final String m = "app_environment_revision";
    public final String n = "truncated";
    public final String o = "custom_type";
    public final String p = "encrypting_mode";
    public final String q = "profile_id";
    public final String r = "first_occurrence_status";
    public final String s = "source";
    public final String t = "attribution_id_changed";
    public final String u = "open_id";
    public final String v = "extras";
    public final String w = "reports";
    public final C4309n7 x = new C4309n7(null, 1, 0 == true ? 1 : 0);

    public static boolean a(C4284m7 c4284m7) {
        Long l;
        EnumC4164hb enumC4164hb;
        Long l2;
        Long l3;
        Long l4;
        Integer num;
        Long l5 = c4284m7.f11666a;
        return (l5 == null || l5.longValue() < 10000000000L || c4284m7.b == null || (l = c4284m7.c) == null || l.longValue() < 0 || (enumC4164hb = c4284m7.d) == null || enumC4164hb == EnumC4164hb.EVENT_TYPE_UNDEFINED || (l2 = c4284m7.e) == null || l2.longValue() < 0 || (l3 = c4284m7.f) == null || l3.longValue() < 0 || ((l4 = c4284m7.g.d) != null && l4.longValue() < 0) || ((num = c4284m7.g.i) != null && num.intValue() < 0)) ? false : true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.db.DatabaseScript
    public final void runScript(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery;
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (id INTEGER PRIMARY KEY,session_id INTEGER,session_type INTEGER,number_in_session INTEGER,type INTEGER,global_number INTEGER,time INTEGER,event_description BLOB )");
        Cursor cursor = null;
        try {
            cursorQuery = sQLiteDatabase.query(this.w, null, null, null, null, null, null, String.valueOf(this.f11446a));
            while (cursorQuery.moveToNext()) {
                try {
                    C4284m7 c4284m7A = a(cursorQuery);
                    if (c4284m7A != null && a(c4284m7A)) {
                        try {
                            sQLiteDatabase.insertOrThrow("events", null, this.x.fromModel(c4284m7A));
                        } catch (Throwable unused) {
                        }
                    }
                } catch (Throwable unused2) {
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursorQuery = cursor;
                    }
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.w);
                }
            }
        } catch (Throwable unused3) {
        }
        cursorQuery.close();
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.w);
    }

    /* JADX WARN: Code duplicated, block: B:57:0x015e A[PHI: r3
  0x015e: PHI (r3v44 io.appmetrica.analytics.impl.s9) = (r3v43 io.appmetrica.analytics.impl.s9), (r3v45 io.appmetrica.analytics.impl.s9) binds: [B:56:0x015c, B:62:0x016a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:70:0x0181  */
    /* JADX WARN: Code duplicated, block: B:77:0x019e  */
    /* JADX WARN: Code duplicated, block: B:78:0x01a1 A[Catch: all -> 0x01bb, TryCatch #4 {all -> 0x01bb, blocks: (B:3:0x0004, B:9:0x002e, B:16:0x003b, B:22:0x00f0, B:28:0x00fc, B:35:0x010c, B:71:0x0182, B:75:0x0192, B:79:0x01a7, B:78:0x01a1, B:65:0x0170, B:50:0x0141, B:31:0x0101, B:25:0x00f5, B:19:0x00e7, B:12:0x0033, B:6:0x0026, B:52:0x0145, B:58:0x0161, B:61:0x0166, B:55:0x0158, B:36:0x0116, B:42:0x0132, B:48:0x013e, B:45:0x0137, B:39:0x0129), top: B:92:0x0004, inners: #0, #3 }] */
    public final C4284m7 a(Cursor cursor) {
        EnumC4621zk enumC4621zk;
        M8 m8;
        EnumC4237ka enumC4237ka;
        EnumC4237ka enumC4237ka2;
        EnumC4435s9 enumC4435s9;
        int i;
        int columnIndex;
        byte[] blob;
        Integer numValueOf;
        EnumC4435s9 enumC4435s10;
        try {
            Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.i)));
            Integer numValueOf2 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.k)));
            EnumC4621zk enumC4621zk2 = EnumC4621zk.FOREGROUND;
            if (numValueOf2 == null || numValueOf2.intValue() != 0) {
                enumC4621zk2 = EnumC4621zk.BACKGROUND;
                enumC4621zk = (numValueOf2 != null && numValueOf2.intValue() == 1) ? enumC4621zk2 : null;
            }
            Long lValueOf2 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.b)));
            EnumC4164hb enumC4164hbA = EnumC4164hb.a(cursor.getInt(cursor.getColumnIndexOrThrow(this.g)));
            Long lValueOf3 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.c)));
            Long lValueOf4 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.h)));
            Integer numValueOf3 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.o)));
            String string = cursor.getString(cursor.getColumnIndexOrThrow(this.e));
            String string2 = cursor.getString(cursor.getColumnIndexOrThrow(this.f));
            Long lValueOf5 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.d)));
            String string3 = cursor.getString(cursor.getColumnIndexOrThrow(this.j));
            String string4 = cursor.getString(cursor.getColumnIndexOrThrow(this.l));
            Long lValueOf6 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.m)));
            Integer numValueOf4 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.n)));
            Integer numValueOf5 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.p)));
            M8 m9 = M8.NONE;
            if (numValueOf5 != null && numValueOf5.intValue() == 0) {
                m8 = m9;
            } else {
                m9 = M8.AES_VALUE_ENCRYPTION;
                if (numValueOf5 != null && numValueOf5.intValue() == 2) {
                    m8 = m9;
                } else {
                    m8 = (numValueOf5 != null && numValueOf5.intValue() == 1) ? M8.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER : null;
                }
            }
            String string5 = cursor.getString(cursor.getColumnIndexOrThrow(this.q));
            try {
                Integer numValueOf6 = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.r)));
                EnumC4237ka enumC4237ka3 = EnumC4237ka.FIRST_OCCURRENCE;
                try {
                    try {
                        try {
                            if (numValueOf6 == null || numValueOf6.intValue() != 1) {
                                enumC4237ka3 = EnumC4237ka.NON_FIRST_OCCURENCE;
                                if (numValueOf6 == null || numValueOf6.intValue() != 2) {
                                    enumC4237ka = EnumC4237ka.UNKNOWN;
                                    enumC4237ka2 = enumC4237ka;
                                    numValueOf = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.s)));
                                    enumC4435s10 = EnumC4435s9.NATIVE;
                                    if (numValueOf != null && numValueOf.intValue() == 0) {
                                        enumC4435s9 = enumC4435s10;
                                    } else {
                                        enumC4435s10 = EnumC4435s9.JS;
                                        if (numValueOf != null && numValueOf.intValue() == 1) {
                                            enumC4435s9 = enumC4435s10;
                                        } else {
                                            enumC4435s9 = null;
                                        }
                                    }
                                    boolean z = cursor.getInt(cursor.getColumnIndexOrThrow(this.t)) == 1;
                                    Boolean boolValueOf = Boolean.valueOf(z);
                                    i = cursor.getInt(cursor.getColumnIndexOrThrow(this.u));
                                    Integer numValueOf7 = Integer.valueOf(i);
                                    columnIndex = cursor.getColumnIndex(this.v);
                                    if (columnIndex < 0) {
                                        blob = null;
                                    } else {
                                        blob = cursor.getBlob(columnIndex);
                                    }
                                    return new C4284m7(lValueOf, enumC4621zk, lValueOf2, enumC4164hbA, lValueOf3, lValueOf4, new C4259l7(numValueOf3, string, string2, lValueOf5, null, string3, string4, lValueOf6, numValueOf4, null, null, m8, string5, enumC4237ka2, enumC4435s9, boolValueOf, numValueOf7, blob));
                                }
                                return null;
                            }
                            numValueOf = Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(this.s)));
                            enumC4435s10 = EnumC4435s9.NATIVE;
                            if (numValueOf != null) {
                                enumC4435s9 = enumC4435s10;
                                if (cursor.getInt(cursor.getColumnIndexOrThrow(this.t)) == 1) {
                                }
                                Boolean boolValueOf2 = Boolean.valueOf(z);
                                i = cursor.getInt(cursor.getColumnIndexOrThrow(this.u));
                                Integer numValueOf8 = Integer.valueOf(i);
                                columnIndex = cursor.getColumnIndex(this.v);
                                if (columnIndex < 0) {
                                    blob = null;
                                } else {
                                    blob = cursor.getBlob(columnIndex);
                                }
                                return new C4284m7(lValueOf, enumC4621zk, lValueOf2, enumC4164hbA, lValueOf3, lValueOf4, new C4259l7(numValueOf3, string, string2, lValueOf5, null, string3, string4, lValueOf6, numValueOf4, null, null, m8, string5, enumC4237ka2, enumC4435s9, boolValueOf2, numValueOf8, blob));
                            }
                            enumC4435s10 = EnumC4435s9.JS;
                            if (numValueOf != null) {
                                enumC4435s9 = enumC4435s10;
                                if (cursor.getInt(cursor.getColumnIndexOrThrow(this.t)) == 1) {
                                }
                                Boolean boolValueOf3 = Boolean.valueOf(z);
                                i = cursor.getInt(cursor.getColumnIndexOrThrow(this.u));
                                Integer numValueOf9 = Integer.valueOf(i);
                                columnIndex = cursor.getColumnIndex(this.v);
                                if (columnIndex < 0) {
                                    blob = null;
                                } else {
                                    blob = cursor.getBlob(columnIndex);
                                }
                                return new C4284m7(lValueOf, enumC4621zk, lValueOf2, enumC4164hbA, lValueOf3, lValueOf4, new C4259l7(numValueOf3, string, string2, lValueOf5, null, string3, string4, lValueOf6, numValueOf4, null, null, m8, string5, enumC4237ka2, enumC4435s9, boolValueOf3, numValueOf9, blob));
                            }
                            enumC4435s9 = null;
                        } catch (Throwable unused) {
                            enumC4435s9 = EnumC4435s9.NATIVE;
                        }
                        i = cursor.getInt(cursor.getColumnIndexOrThrow(this.u));
                    } catch (Throwable unused2) {
                        i = -1;
                    }
                    if (cursor.getInt(cursor.getColumnIndexOrThrow(this.t)) == 1) {
                    }
                } catch (Throwable unused3) {
                }
                enumC4237ka2 = enumC4237ka3;
            } catch (Throwable unused4) {
                enumC4237ka = EnumC4237ka.UNKNOWN;
            }
            Boolean boolValueOf4 = Boolean.valueOf(z);
            Integer numValueOf10 = Integer.valueOf(i);
            columnIndex = cursor.getColumnIndex(this.v);
            if (columnIndex < 0) {
                blob = null;
            } else {
                blob = cursor.getBlob(columnIndex);
            }
            return new C4284m7(lValueOf, enumC4621zk, lValueOf2, enumC4164hbA, lValueOf3, lValueOf4, new C4259l7(numValueOf3, string, string2, lValueOf5, null, string3, string4, lValueOf6, numValueOf4, null, null, m8, string5, enumC4237ka2, enumC4435s9, boolValueOf4, numValueOf10, blob));
        } catch (Throwable unused5) {
            return null;
        }
    }
}
