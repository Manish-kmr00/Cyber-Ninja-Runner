package com.mbridge.msdk.tracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.List;

/* JADX INFO: compiled from: DatabaseManager.java */
/* JADX INFO: loaded from: classes7.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f5614a;
    private final String b;
    private final Object c = new Object();

    public c(b bVar, String str) {
        this.f5614a = bVar;
        this.b = str;
    }

    private static boolean c(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase == null || !sQLiteDatabase.isOpen() || sQLiteDatabase.isReadOnly();
    }

    private static void d(SQLiteDatabase sQLiteDatabase) {
        if (y.b(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            if (a.f5612a) {
                Log.e("TrackManager", "transactionSuccess: ", e);
            }
        }
    }

    public long a(i iVar) {
        SQLiteDatabase writableDatabase;
        synchronized (this.c) {
            long jInsert = -1;
            if (y.b(this.f5614a)) {
                return -1L;
            }
            try {
                writableDatabase = this.f5614a.getWritableDatabase();
            } catch (Exception e) {
                if (a.f5612a) {
                    Log.e("TrackManager", "insert getWritableDatabase: " + e.getMessage());
                }
                writableDatabase = null;
            }
            try {
                if (c(writableDatabase)) {
                    return -1L;
                }
                a(writableDatabase);
                ContentValues contentValues = new ContentValues(16);
                e eVarA = iVar.a();
                contentValues.put("name", eVarA.b());
                contentValues.put("type", Integer.valueOf(eVarA.h()));
                contentValues.put("time_stamp", Long.valueOf(eVarA.g()));
                contentValues.put("properties", eVarA.d().toString());
                contentValues.put(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, Integer.valueOf(eVarA.c()));
                contentValues.put("state", Integer.valueOf(iVar.e()));
                contentValues.put("report_count", Integer.valueOf(iVar.c()));
                contentValues.put(CommonUrlParts.UUID, eVarA.i());
                contentValues.put("ignore_max_timeout", Integer.valueOf(!eVarA.k() ? 1 : 0));
                contentValues.put("ignore_max_retry_times", Integer.valueOf(!eVarA.j() ? 1 : 0));
                contentValues.put("invalid_time", Long.valueOf(iVar.b()));
                jInsert = writableDatabase.insert(this.b, null, contentValues);
                d(writableDatabase);
                return jInsert;
            } catch (Exception e2) {
                if (a.f5612a) {
                    Log.e("TrackManager", "insert: " + e2.getMessage());
                }
            } finally {
                b(writableDatabase);
            }
        }
    }

    public int b() {
        SQLiteDatabase writableDatabase;
        synchronized (this.c) {
            int iMax = 0;
            if (y.b(this.f5614a)) {
                return 0;
            }
            Cursor cursorQuery = null;
            try {
                writableDatabase = this.f5614a.getWritableDatabase();
            } catch (Exception e) {
                if (a.f5612a) {
                    Log.e("TrackManager", "getAvailableCount getWritableDatabase: " + e.getMessage());
                }
                writableDatabase = null;
            }
            if (c(writableDatabase)) {
                return 0;
            }
            try {
                try {
                    a(writableDatabase);
                    cursorQuery = writableDatabase.query(this.b, null, "state = ? OR state = ?", new String[]{String.valueOf(3), String.valueOf(0)}, null, null, null, null);
                    if (cursorQuery != null && cursorQuery.moveToNext()) {
                        iMax = Math.max(cursorQuery.getCount(), 0);
                    }
                    d(writableDatabase);
                    b(writableDatabase);
                    y.a(cursorQuery);
                } catch (Throwable th) {
                    b(writableDatabase);
                    y.a(cursorQuery);
                    throw th;
                }
            } catch (Exception e2) {
                if (a.f5612a) {
                    Log.e("TrackManager", "getAvailableCount: " + e2.getMessage());
                }
                b(writableDatabase);
                y.a(cursorQuery);
            }
            return iMax;
        }
    }

    public void c(List<i> list) {
        SQLiteDatabase writableDatabase;
        synchronized (this.c) {
            if (y.b(this.f5614a) || y.b((List<?>) list)) {
                return;
            }
            try {
                writableDatabase = this.f5614a.getWritableDatabase();
            } catch (Exception e) {
                if (a.f5612a) {
                    Log.e("TrackManager", "updateReportStateSuccess getWritableDatabase: " + e.getMessage());
                }
                writableDatabase = null;
            }
            if (c(writableDatabase)) {
                return;
            }
            try {
                try {
                    a(writableDatabase);
                    for (i iVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", (Integer) 2);
                        writableDatabase.update(this.b, contentValues, "uuid = ?", new String[]{iVar.f()});
                    }
                    d(writableDatabase);
                    b(writableDatabase);
                } catch (Throwable th) {
                    b(writableDatabase);
                    throw th;
                }
            } catch (Exception e2) {
                if (a.f5612a) {
                    Log.e("TrackManager", "updateReportStateSuccess: " + e2.getMessage());
                }
                b(writableDatabase);
            }
        }
    }

    public void b(List<i> list) {
        SQLiteDatabase writableDatabase;
        synchronized (this.c) {
            if (y.b(this.f5614a) || y.b((List<?>) list)) {
                return;
            }
            try {
                writableDatabase = this.f5614a.getWritableDatabase();
            } catch (Exception e) {
                if (a.f5612a) {
                    Log.e("TrackManager", "updateReportStateReporting getWritableDatabase: " + e.getMessage());
                }
                writableDatabase = null;
            }
            if (c(writableDatabase)) {
                return;
            }
            try {
                try {
                    a(writableDatabase);
                    for (i iVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", (Integer) 1);
                        writableDatabase.update(this.b, contentValues, "uuid = ?", new String[]{iVar.f()});
                    }
                    d(writableDatabase);
                    b(writableDatabase);
                } catch (Throwable th) {
                    b(writableDatabase);
                    throw th;
                }
            } catch (Exception e2) {
                if (a.f5612a) {
                    Log.e("TrackManager", "updateReportStateReporting: " + e2.getMessage());
                }
                b(writableDatabase);
            }
        }
    }

    public List<i> a(int i) {
        SQLiteDatabase writableDatabase;
        Exception exc;
        List<i> list;
        synchronized (this.c) {
            Cursor cursor = null;
            List<i> listB = null;
            Cursor cursor2 = null;
            if (y.b(this.f5614a)) {
                return null;
            }
            try {
                writableDatabase = this.f5614a.getWritableDatabase();
            } catch (Exception e) {
                if (a.f5612a) {
                    Log.e("TrackManager", "getAvailable getWritableDatabase: " + e.getMessage());
                }
                writableDatabase = null;
            }
            try {
                if (c(writableDatabase)) {
                    return null;
                }
                try {
                    a(writableDatabase);
                    Cursor cursorQuery = writableDatabase.query(this.b, null, "state = ? OR state = ?", new String[]{String.valueOf(0), String.valueOf(3)}, null, null, "priority DESC", String.valueOf(i));
                    try {
                        listB = y.b(cursorQuery);
                        d(writableDatabase);
                        b(writableDatabase);
                        y.a(cursorQuery);
                    } catch (Exception e2) {
                        exc = e2;
                        list = listB;
                        cursor2 = cursorQuery;
                        if (a.f5612a) {
                            Log.e("TrackManager", "getAvailable: " + exc.getMessage());
                        }
                        b(writableDatabase);
                        y.a(cursor2);
                        listB = list;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        b(writableDatabase);
                        y.a(cursor);
                        throw th;
                    }
                } catch (Exception e3) {
                    exc = e3;
                    list = null;
                }
                return listB;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public void c() {
        SQLiteDatabase writableDatabase;
        synchronized (this.c) {
            if (y.b(this.f5614a)) {
                return;
            }
            try {
                writableDatabase = this.f5614a.getWritableDatabase();
            } catch (Exception e) {
                if (a.f5612a) {
                    Log.e("TrackManager", "updateReportStateForReporting getWritableDatabase: " + e.getMessage());
                }
                writableDatabase = null;
            }
            if (c(writableDatabase)) {
                return;
            }
            try {
                try {
                    a(writableDatabase);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("state", (Integer) 3);
                    contentValues.put("report_error_message", "update from reporting");
                    writableDatabase.update(this.b, contentValues, "state = ?", new String[]{String.valueOf(1)});
                    d(writableDatabase);
                    b(writableDatabase);
                } catch (Throwable th) {
                    b(writableDatabase);
                    throw th;
                }
            } catch (Exception e2) {
                if (a.f5612a) {
                    Log.e("TrackManager", "updateReportStateForReporting: " + e2.getMessage());
                }
                b(writableDatabase);
            }
        }
    }

    public void a(List<i> list) {
        SQLiteDatabase writableDatabase;
        synchronized (this.c) {
            if (y.b(this.f5614a) || y.b((List<?>) list)) {
                return;
            }
            try {
                writableDatabase = this.f5614a.getWritableDatabase();
            } catch (Exception e) {
                if (a.f5612a) {
                    Log.e("TrackManager", "updateReportStateFailed getWritableDatabase: " + e.getMessage());
                }
                writableDatabase = null;
            }
            if (c(writableDatabase)) {
                return;
            }
            try {
                try {
                    a(writableDatabase);
                    for (i iVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", Integer.valueOf(iVar.e()));
                        contentValues.put("report_count", Integer.valueOf(iVar.c()));
                        String strD = iVar.d();
                        if (!TextUtils.isEmpty(strD)) {
                            contentValues.put("report_error_message", strD);
                        }
                        writableDatabase.update(this.b, contentValues, "uuid = ?", new String[]{iVar.f()});
                    }
                    d(writableDatabase);
                    b(writableDatabase);
                } catch (Throwable th) {
                    b(writableDatabase);
                    throw th;
                }
            } catch (Exception e2) {
                if (a.f5612a) {
                    Log.e("TrackManager", "updateReportStateFailed: " + e2.getMessage());
                }
                b(writableDatabase);
            }
        }
    }

    private static void b(SQLiteDatabase sQLiteDatabase) {
        if (y.b(sQLiteDatabase) || !sQLiteDatabase.inTransaction()) {
            return;
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Exception e) {
            if (a.f5612a) {
                Log.e("TrackManager", "endTransaction: ", e);
            }
        }
    }

    public int a() {
        SQLiteDatabase writableDatabase;
        synchronized (this.c) {
            int iDelete = -1;
            if (y.b(this.f5614a)) {
                return -1;
            }
            try {
                writableDatabase = this.f5614a.getWritableDatabase();
            } catch (Exception e) {
                if (a.f5612a) {
                    Log.e("TrackManager", "deleteInvalidEvents getWritableDatabase: " + e.getMessage());
                }
                writableDatabase = null;
            }
            try {
                if (c(writableDatabase)) {
                    return -1;
                }
                a(writableDatabase);
                iDelete = writableDatabase.delete(this.b, "state = ? OR state = ?", new String[]{String.valueOf(-1), String.valueOf(2)});
                d(writableDatabase);
                return iDelete;
            } catch (Exception e2) {
                if (a.f5612a) {
                    Log.e("TrackManager", "deleteInvalidEvents: " + e2.getMessage());
                }
            } finally {
                b(writableDatabase);
            }
        }
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        if (y.b(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
        } catch (Exception e) {
            if (a.f5612a) {
                Log.e("TrackManager", "beginTransaction: ", e);
            }
        }
    }
}
