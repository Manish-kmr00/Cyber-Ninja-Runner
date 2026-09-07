package com.inmobi.media;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.b3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3309b3 {
    public static final SQLiteDatabase b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3309b3 f3272a = new C3309b3();
    public static final Object c = new Object();

    static {
        try {
            b = new C3294a3(C3517pb.d()).getWritableDatabase();
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final int a(String tableName, ContentValues contentValues, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        synchronized (c) {
            long jA = a(tableName, contentValues);
            if (jA == -1) {
                return b(tableName, contentValues, str, strArr);
            }
            return (int) jA;
        }
    }

    @JvmStatic
    public static final int b(String tableName, ContentValues contentValues, String str, String[] strArr) {
        int iUpdateWithOnConflict;
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        synchronized (c) {
            SQLiteDatabase sQLiteDatabase = b;
            if (sQLiteDatabase != null) {
                iUpdateWithOnConflict = sQLiteDatabase.updateWithOnConflict(tableName, contentValues, str, strArr, 4);
            } else {
                Intrinsics.checkNotNullExpressionValue("b3", "TAG");
                iUpdateWithOnConflict = -1;
            }
        }
        return iUpdateWithOnConflict;
    }

    @JvmStatic
    public static final long a(String tableName, ContentValues contentValues) {
        long jInsertWithOnConflict;
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        synchronized (c) {
            SQLiteDatabase sQLiteDatabase = b;
            if (sQLiteDatabase != null) {
                jInsertWithOnConflict = sQLiteDatabase.insertWithOnConflict(tableName, null, contentValues, 4);
            } else {
                Intrinsics.checkNotNullExpressionValue("b3", "TAG");
                jInsertWithOnConflict = -1;
            }
        }
        return jInsertWithOnConflict;
    }

    @JvmStatic
    public static final List<ContentValues> b(String tableName, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        Cursor cursorQuery;
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        synchronized (c) {
            SQLiteDatabase sQLiteDatabase = b;
            cursorQuery = sQLiteDatabase != null ? sQLiteDatabase.query(tableName, strArr, str, strArr2, str2, str3, str4, str5) : null;
            Unit unit = Unit.INSTANCE;
        }
        if (cursorQuery != null) {
            try {
                ArrayList arrayList = new ArrayList();
                if (cursorQuery.moveToFirst()) {
                    do {
                        ContentValues contentValues = new ContentValues();
                        DatabaseUtils.cursorRowToContentValues(cursorQuery, contentValues);
                        arrayList.add(contentValues);
                    } while (cursorQuery.moveToNext());
                }
                CloseableKt.closeFinally(cursorQuery, null);
                return arrayList;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }
        return CollectionsKt.emptyList();
    }

    @JvmStatic
    public static final int a(String tableName, String str, String[] strArr) {
        int iDelete;
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        synchronized (c) {
            SQLiteDatabase sQLiteDatabase = b;
            if (sQLiteDatabase != null) {
                iDelete = sQLiteDatabase.delete(tableName, str, strArr);
            } else {
                Intrinsics.checkNotNullExpressionValue("b3", "TAG");
                iDelete = 0;
            }
        }
        return iDelete;
    }

    @JvmStatic
    public static final void a(String tableName) {
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        String str = "DROP TABLE IF EXISTS \"" + tableName + '\"';
        synchronized (c) {
            SQLiteDatabase sQLiteDatabase = b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.execSQL(str);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void a(String tableName, String tableSchema) {
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        Intrinsics.checkNotNullParameter(tableSchema, "tableSchema");
        String str = "CREATE TABLE IF NOT EXISTS " + tableName + tableSchema + ';';
        synchronized (c) {
            SQLiteDatabase sQLiteDatabase = b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.execSQL(str);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @JvmStatic
    public static final int a(String tableName, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        int i;
        Cursor cursorQuery;
        int columnIndex;
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        synchronized (c) {
            SQLiteDatabase sQLiteDatabase = b;
            i = 0;
            cursorQuery = sQLiteDatabase != null ? sQLiteDatabase.query(tableName, new String[]{"COUNT(*) AS count"}, str, strArr2, str2, str3, str4, str5) : null;
            Unit unit = Unit.INSTANCE;
        }
        if (cursorQuery != null) {
            try {
                try {
                    if (cursorQuery.moveToFirst() && (columnIndex = cursorQuery.getColumnIndex("count")) >= 0) {
                        i = cursorQuery.getInt(columnIndex);
                    }
                    CloseableKt.closeFinally(cursorQuery, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursorQuery, th);
                        throw th2;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return i;
    }
}
