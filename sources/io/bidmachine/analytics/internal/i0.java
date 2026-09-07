package io.bidmachine.analytics.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
public final class i0 {
    public static final a b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteOpenHelper f12095a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static final class b extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SQLiteDatabase f12096a;
        final /* synthetic */ ContentValues b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
            super(1);
            this.f12096a = sQLiteDatabase;
            this.b = contentValues;
        }

        public final void a(List list) {
            SQLiteDatabase sQLiteDatabase = this.f12096a;
            ContentValues contentValues = this.b;
            String[] strArrA = null;
            String strA = list != null ? AbstractC4641q.a(list, "id IN") : null;
            if (list != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((j0) it.next()).c());
                }
                strArrA = AbstractC4641q.a(arrayList);
            }
            sQLiteDatabase.update("reader_record", contentValues, strA, strArrA);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((List) obj);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SQLiteDatabase f12097a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(SQLiteDatabase sQLiteDatabase) {
            super(1);
            this.f12097a = sQLiteDatabase;
        }

        public final void a(List list) {
            SQLiteDatabase sQLiteDatabase = this.f12097a;
            String[] strArrA = null;
            String strA = list != null ? AbstractC4641q.a(list, "id IN") : null;
            if (list != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((j0) it.next()).c());
                }
                strArrA = AbstractC4641q.a(arrayList);
            }
            sQLiteDatabase.delete("reader_record", strA, strArrA);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((List) obj);
            return Unit.INSTANCE;
        }
    }

    public i0(SQLiteOpenHelper sQLiteOpenHelper) {
        this.f12095a = sQLiteOpenHelper;
    }

    private final Object a(boolean z, List list) {
        Object objM7904constructorimpl;
        synchronized (this.f12095a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase writableDatabase = this.f12095a.getWritableDatabase();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("is_reserved", Boolean.valueOf(z));
                    AbstractC4641q.a(list, writableDatabase, 0, new b(writableDatabase, contentValues), 2, null);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(writableDatabase, null);
                    objM7904constructorimpl = Result.m7904constructorimpl(unit);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(writableDatabase, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th3));
            }
        }
        return objM7904constructorimpl;
    }

    public final Object b(List list) {
        Object objM7904constructorimpl;
        synchronized (this.f12095a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase writableDatabase = this.f12095a.getWritableDatabase();
                try {
                    writableDatabase.delete("reader_record", AbstractC4641q.a(list, "name NOT IN"), AbstractC4641q.a(list));
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(writableDatabase, null);
                    objM7904constructorimpl = Result.m7904constructorimpl(unit);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(writableDatabase, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th3));
            }
        }
        return objM7904constructorimpl;
    }

    public final Object c(List list) {
        Object objM7904constructorimpl;
        synchronized (this.f12095a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(s0.c((String) it.next()));
                }
                SQLiteDatabase writableDatabase = this.f12095a.getWritableDatabase();
                try {
                    writableDatabase.delete("reader_record", AbstractC4641q.a(arrayList, "rule NOT IN"), AbstractC4641q.a(arrayList));
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(writableDatabase, null);
                    objM7904constructorimpl = Result.m7904constructorimpl(unit);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(writableDatabase, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th3));
            }
        }
        return objM7904constructorimpl;
    }

    public final Object d(List list) {
        return a(false, list);
    }

    public final Object e(List list) {
        return a(true, list);
    }

    public final Object a(List list) {
        Object objM7904constructorimpl;
        synchronized (this.f12095a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase writableDatabase = this.f12095a.getWritableDatabase();
                try {
                    AbstractC4641q.a(list, writableDatabase, 0, new c(writableDatabase), 2, null);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(writableDatabase, null);
                    objM7904constructorimpl = Result.m7904constructorimpl(unit);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(writableDatabase, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th3));
            }
        }
        return objM7904constructorimpl;
    }

    public final Object b() {
        return a(false, (List) null);
    }

    public final Object c(j0 j0Var) {
        Object objM7904constructorimpl;
        synchronized (this.f12095a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase writableDatabase = this.f12095a.getWritableDatabase();
                try {
                    writableDatabase.update("reader_record", b(j0Var), "id = ?", new String[]{j0Var.c()});
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(writableDatabase, null);
                    objM7904constructorimpl = Result.m7904constructorimpl(unit);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(writableDatabase, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th3));
            }
        }
        return objM7904constructorimpl;
    }

    private final ContentValues b(j0 j0Var) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", j0Var.c());
        contentValues.put("name", j0Var.d());
        contentValues.put("timestamp", Long.valueOf(j0Var.f()));
        contentValues.put("data_hash", j0Var.a());
        contentValues.put("rule", s0.c(j0Var.e()));
        contentValues.put("error", s0.b(j0Var.b(), j0Var.c()));
        contentValues.put("is_dirty", Boolean.valueOf(j0Var.g()));
        return contentValues;
    }

    public final Object a(String str, List list) {
        Object objM7904constructorimpl;
        synchronized (this.f12095a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(s0.c((String) it.next()));
                }
                SQLiteDatabase writableDatabase = this.f12095a.getWritableDatabase();
                try {
                    writableDatabase.delete("reader_record", "name = ? AND " + a() + " AND " + AbstractC4641q.a(arrayList, "rule IN"), AbstractC4641q.a(CollectionsKt.plus((Collection) CollectionsKt.listOf(str), (Iterable) arrayList)));
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(writableDatabase, null);
                    objM7904constructorimpl = Result.m7904constructorimpl(unit);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(writableDatabase, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th3));
            }
        }
        return objM7904constructorimpl;
    }

    private final String a() {
        return "(LENGTH(error) = 0 OR error IS NULL)";
    }

    private final Object a(String str, String[] strArr, String str2) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f12095a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase readableDatabase = this.f12095a.getReadableDatabase();
                try {
                    Cursor cursorQuery = readableDatabase.query("reader_record", new String[]{"id", "name", "timestamp", "data_hash", "rule", "error", "is_dirty"}, str, strArr, null, null, "timestamp DESC", str2);
                    while (cursorQuery.moveToNext()) {
                        try {
                            try {
                                Result.Companion companion2 = Result.INSTANCE;
                                String string = cursorQuery.getString(0);
                                try {
                                    try {
                                        try {
                                            try {
                                                Result.m7904constructorimpl(Boolean.valueOf(arrayList.add(new j0(string, cursorQuery.getString(1), cursorQuery.getLong(2), cursorQuery.getString(3), s0.a(cursorQuery.getString(4)), s0.a(cursorQuery.getBlob(5), string), cursorQuery.getInt(6) == 1))));
                                            } catch (Throwable th) {
                                                th = th;
                                                Result.Companion companion3 = Result.INSTANCE;
                                                Result.m7904constructorimpl(ResultKt.createFailure(th));
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            Result.Companion companion4 = Result.INSTANCE;
                                            Result.m7904constructorimpl(ResultKt.createFailure(th));
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        Result.Companion companion5 = Result.INSTANCE;
                                        Result.m7904constructorimpl(ResultKt.createFailure(th));
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    Result.Companion companion6 = Result.INSTANCE;
                                    Result.m7904constructorimpl(ResultKt.createFailure(th));
                                }
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } catch (Throwable th6) {
                            try {
                                throw th6;
                            } catch (Throwable th7) {
                                CloseableKt.closeFinally(cursorQuery, th6);
                                throw th7;
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursorQuery, null);
                    CloseableKt.closeFinally(readableDatabase, null);
                    Result.m7904constructorimpl(unit);
                } catch (Throwable th8) {
                    try {
                        throw th8;
                    } catch (Throwable th9) {
                        CloseableKt.closeFinally(readableDatabase, th8);
                        throw th9;
                    }
                }
            } catch (Throwable th10) {
                Result.Companion companion7 = Result.INSTANCE;
                Result.m7904constructorimpl(ResultKt.createFailure(th10));
            }
        }
        Result.Companion companion8 = Result.INSTANCE;
        return Result.m7904constructorimpl(arrayList);
    }

    static /* synthetic */ Object a(i0 i0Var, String str, String[] strArr, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            strArr = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return i0Var.a(str, strArr, str2);
    }

    public final Object a(String str) {
        return a(this, "name = ? AND is_reserved = 0 AND is_dirty = 1", new String[]{str}, null, 4, null);
    }

    public final Object a(String str, String str2) {
        Object objA = a(this, "name = ? AND rule = ? AND " + a(), new String[]{str, s0.c(str2)}, null, 4, null);
        if (Result.m7910isFailureimpl(objA)) {
            Result.Companion companion = Result.INSTANCE;
            Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objA);
            if (thM7907exceptionOrNullimpl == null) {
                thM7907exceptionOrNullimpl = new Exception();
            }
            return Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
        }
        Result.Companion companion2 = Result.INSTANCE;
        if (Result.m7910isFailureimpl(objA)) {
            objA = null;
        }
        List list = (List) objA;
        return Result.m7904constructorimpl(list != null ? (j0) CollectionsKt.firstOrNull(list) : null);
    }

    public final Object a(j0 j0Var) {
        Object objM7904constructorimpl;
        synchronized (this.f12095a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase writableDatabase = this.f12095a.getWritableDatabase();
                try {
                    writableDatabase.insert("reader_record", null, b(j0Var));
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(writableDatabase, null);
                    objM7904constructorimpl = Result.m7904constructorimpl(unit);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(writableDatabase, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th3));
            }
        }
        return objM7904constructorimpl;
    }
}
