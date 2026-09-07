package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes3.dex */
public class JG {
    private static final Object KZx = new Object();
    private Context Og;
    private KZx pA;

    JG(Context context) {
        try {
            this.Og = context == null ? aBv.pA() : context.getApplicationContext();
            if (this.pA == null) {
                this.pA = new KZx();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context KZx() {
        Context context = this.Og;
        return context == null ? aBv.pA() : context;
    }

    public class KZx {
        private SQLiteDatabase Og = null;

        public KZx() {
        }

        private synchronized void ML() {
            try {
                synchronized (JG.KZx) {
                    SQLiteDatabase sQLiteDatabase = this.Og;
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        JG jg = JG.this;
                        SQLiteDatabase writableDatabase = jg.new pA(jg.KZx()).getWritableDatabase();
                        this.Og = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    }
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("DBHelper", th.getMessage());
                if (JG()) {
                    throw th;
                }
            }
        }

        public SQLiteDatabase pA() {
            ML();
            return this.Og;
        }

        public synchronized void pA(String str) throws SQLException {
            try {
                ML();
                this.Og.execSQL(str);
            } catch (Throwable th) {
                if (JG()) {
                    throw th;
                }
            }
        }

        public synchronized Cursor pA(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursorQuery;
            try {
                ML();
                cursorQuery = this.Og.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("DBHelper", th.getMessage());
                Og og = new Og();
                if (JG()) {
                    throw th;
                }
                cursorQuery = og;
            }
            return cursorQuery;
        }

        public synchronized int pA(String str, ContentValues contentValues, String str2, String[] strArr) {
            int iUpdate;
            try {
                ML();
                iUpdate = this.Og.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.WV.pA("DBHelper", e.getMessage());
                if (JG()) {
                    throw e;
                }
                iUpdate = 0;
            }
            return iUpdate;
        }

        public synchronized long pA(String str, String str2, ContentValues contentValues) {
            long jReplace;
            try {
                ML();
                jReplace = this.Og.replace(str, str2, contentValues);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.WV.pA("DBHelper", e.getMessage());
                if (JG()) {
                    throw e;
                }
                jReplace = -1;
            }
            return jReplace;
        }

        public synchronized int pA(String str, String str2, String[] strArr) {
            int iDelete;
            try {
                ML();
                iDelete = this.Og.delete(str, str2, strArr);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.WV.pA("DBHelper", e.getMessage());
                if (JG()) {
                    throw e;
                }
                iDelete = 0;
            }
            return iDelete;
        }

        public synchronized void Og() {
            ML();
            SQLiteDatabase sQLiteDatabase = this.Og;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.beginTransaction();
        }

        public synchronized void KZx() {
            ML();
            SQLiteDatabase sQLiteDatabase = this.Og;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.setTransactionSuccessful();
        }

        public synchronized void ZZv() {
            ML();
            SQLiteDatabase sQLiteDatabase = this.Og;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.endTransaction();
        }

        private synchronized boolean JG() {
            SQLiteDatabase sQLiteDatabase = this.Og;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }
    }

    private class pA extends SQLiteOpenHelper {
        final Context pA;

        public pA(Context context) {
            super(context, "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 11);
            this.pA = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                pA(sQLiteDatabase, this.pA);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("DBHelper", th.getMessage());
            }
        }

        private void pA(SQLiteDatabase sQLiteDatabase, Context context) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.ZZv.ZZv.pA());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.ZZv.Bzk.KZx());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.ZZv.Sn.pA());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.ZZv.Wx.pA());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.BF.Og.pA());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.ZZv.oX.KZx());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.pA.Og.Og.KZx());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.BSW.pA.KZx.KZx());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.ZZv.DX.pA());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i > i2) {
                try {
                    KZx(sQLiteDatabase);
                    pA(sQLiteDatabase, JG.this.Og);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.Og(th.getMessage());
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:10:0x002c A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0002, B:4:0x0005, B:5:0x000e, B:7:0x0012, B:8:0x0016, B:9:0x0021, B:10:0x002c, B:11:0x0037, B:12:0x0040), top: B:21:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:11:0x0037 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0002, B:4:0x0005, B:5:0x000e, B:7:0x0012, B:8:0x0016, B:9:0x0021, B:10:0x002c, B:11:0x0037, B:12:0x0040), top: B:21:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:12:0x0040 A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0002, B:4:0x0005, B:5:0x000e, B:7:0x0012, B:8:0x0016, B:9:0x0021, B:10:0x002c, B:11:0x0037, B:12:0x0040), top: B:21:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:6:0x0011 A[DONT_GENERATE] */
        /* JADX WARN: Code duplicated, block: B:7:0x0012 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0002, B:4:0x0005, B:5:0x000e, B:7:0x0012, B:8:0x0016, B:9:0x0021, B:10:0x002c, B:11:0x0037, B:12:0x0040), top: B:21:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:8:0x0016 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0002, B:4:0x0005, B:5:0x000e, B:7:0x0012, B:8:0x0016, B:9:0x0021, B:10:0x002c, B:11:0x0037, B:12:0x0040), top: B:21:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:9:0x0021 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0002, B:4:0x0005, B:5:0x000e, B:7:0x0012, B:8:0x0016, B:9:0x0021, B:10:0x002c, B:11:0x0037, B:12:0x0040), top: B:21:0x0002 }] */
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i <= i2) {
                pA(sQLiteDatabase, JG.this.Og);
                switch (i) {
                    case 1:
                        pA(sQLiteDatabase);
                        break;
                    case 2:
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                        pA(sQLiteDatabase);
                        break;
                    case 3:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.ZZv.Sn.pA());
                        pA(sQLiteDatabase);
                        break;
                    case 4:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.pA.Og.Og.KZx());
                        pA(sQLiteDatabase);
                        break;
                    case 5:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.ZZv.Wx.pA());
                        pA(sQLiteDatabase);
                        break;
                    case 6:
                        pA(sQLiteDatabase);
                        break;
                }
            } else {
                try {
                    KZx(sQLiteDatabase);
                    pA(sQLiteDatabase, JG.this.Og);
                    switch (i) {
                        case 1:
                            pA(sQLiteDatabase);
                            break;
                        case 2:
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                            pA(sQLiteDatabase);
                            break;
                        case 3:
                            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.ZZv.Sn.pA());
                            pA(sQLiteDatabase);
                            break;
                        case 4:
                            sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.pA.Og.Og.KZx());
                            pA(sQLiteDatabase);
                            break;
                        case 5:
                            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.ZZv.Wx.pA());
                            pA(sQLiteDatabase);
                            break;
                        case 6:
                            pA(sQLiteDatabase);
                            break;
                    }
                } catch (Throwable unused) {
                }
            }
            if (i < 11) {
                try {
                    Og(sQLiteDatabase);
                    com.bytedance.sdk.openadsdk.BF.Og.pA(sQLiteDatabase);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.pA("DBHelper", th.getMessage());
                }
            }
        }

        private void pA(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.ZZv.ZZv.Og());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.ZZv.Bzk.ZZv());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.ZZv.Sn.Og());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.ZZv.Wx.Og());
        }

        private void Og(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.BSW.pA.KZx.ZZv());
        }

        private void KZx(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayListZZv = ZZv(sQLiteDatabase);
            if (arrayListZZv == null || arrayListZZv.size() <= 0) {
                return;
            }
            Iterator<String> it = arrayListZZv.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
            }
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0039 A[PHI: r1
  0x0039: PHI (r1v3 android.database.Cursor) = (r1v2 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:19:0x0037, B:13:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
        private ArrayList<String> ZZv(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayList = new ArrayList<>();
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
                if (cursorRawQuery != null) {
                    while (cursorRawQuery.moveToNext()) {
                        String string = cursorRawQuery.getString(0);
                        if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                            arrayList.add(string);
                        }
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Exception unused) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th;
            }
            return arrayList;
        }
    }

    public KZx pA() {
        return this.pA;
    }

    private class Og extends AbstractCursor {
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

        private Og() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }
    }
}
