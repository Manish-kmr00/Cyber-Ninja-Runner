package com.bytedance.sdk.component.JG.pA.pA.pA;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.component.JG.pA.omh;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
class Og {
    private Context Og;
    private C0189Og pA;

    Og(Context context) {
        try {
            this.Og = context.getApplicationContext();
            if (this.pA == null) {
                this.pA = new C0189Og();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.JG.pA.pA.pA.Og$Og, reason: collision with other inner class name */
    public class C0189Og {
        private volatile SQLiteDatabase Og = null;

        public C0189Og() {
        }

        private void pA() {
            try {
                if (this.Og != null && this.Og.isOpen()) {
                    return;
                }
                synchronized (this) {
                    if (this.Og == null || !this.Og.isOpen()) {
                        this.Og = omh.SD().ZZv().pA(omh.SD().JG());
                        this.Og.setLockingEnabled(false);
                    }
                }
            } catch (Throwable th) {
                if (Og()) {
                    throw th;
                }
            }
        }

        public void pA(String str) throws SQLException {
            try {
                pA();
                this.Og.execSQL(str);
            } catch (Throwable th) {
                if (Og()) {
                    throw th;
                }
            }
        }

        public Cursor pA(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            try {
                pA();
                return this.Og.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                pA pAVar = new pA();
                if (Og()) {
                    throw th;
                }
                return pAVar;
            }
        }

        public int pA(String str, ContentValues contentValues, String str2, String[] strArr) throws Exception {
            try {
                pA();
                return this.Og.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                if (Og()) {
                    throw e;
                }
                return 0;
            }
        }

        public long pA(String str, String str2, ContentValues contentValues) throws Exception {
            try {
                pA();
                return this.Og.insert(str, str2, contentValues);
            } catch (Exception e) {
                if (Og()) {
                    throw e;
                }
                return -1L;
            }
        }

        public synchronized void pA(String str, String str2, List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list) {
            JSONObject jSONObjectSD;
            try {
                try {
                    pA();
                    this.Og.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    for (int i = 0; i < list.size(); i++) {
                        com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar = list.get(i);
                        if (pAVar != null && (jSONObjectSD = pAVar.SD()) != null) {
                            contentValues.put("id", pAVar.KZx());
                            String strOg = omh.SD().oX().Og(jSONObjectSD.toString());
                            if (!TextUtils.isEmpty(strOg)) {
                                contentValues.put("value", strOg);
                                contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                                contentValues.put("retry", (Integer) 0);
                                contentValues.put("encrypt", (Integer) 1);
                                if (com.bytedance.sdk.component.JG.pA.KZx.pA.ZZv() && pAVar.SGo() > 0 && (pAVar.ZZv() == 0 || pAVar.ZZv() == 3)) {
                                    contentValues.put("channel", Integer.valueOf(pAVar.SGo()));
                                }
                                this.Og.insert(str, str2, contentValues);
                            }
                            contentValues.clear();
                        }
                    }
                    this.Og.setTransactionSuccessful();
                    new StringBuilder().append(str).append(" insert list size=");
                    list.size();
                    if (this.Og != null) {
                        this.Og.endTransaction();
                    }
                } catch (Exception e) {
                    new StringBuilder().append(str).append(" insert list error=");
                    list.size();
                    if (Og()) {
                        throw e;
                    }
                    if (this.Og != null) {
                        this.Og.endTransaction();
                    }
                }
            } catch (Throwable th) {
                if (this.Og != null) {
                    this.Og.endTransaction();
                }
                throw th;
            }
        }

        public int pA(String str, String str2, String[] strArr) throws Exception {
            try {
                pA();
                return this.Og.delete(str, str2, strArr);
            } catch (Exception e) {
                if (Og()) {
                    throw e;
                }
                return 0;
            }
        }

        private boolean Og() {
            SQLiteDatabase sQLiteDatabase = this.Og;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }
    }

    public C0189Og pA() {
        return this.pA;
    }

    private class pA extends AbstractCursor {
        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i) {
            return true;
        }

        private pA() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }
    }
}
