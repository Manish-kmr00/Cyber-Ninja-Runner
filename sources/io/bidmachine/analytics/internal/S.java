package io.bidmachine.analytics.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
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

/* JADX INFO: loaded from: classes.dex */
public final class S {
    public static final a b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteOpenHelper f12059a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static final class b extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SQLiteDatabase f12060a;
        final /* synthetic */ ContentValues b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
            super(1);
            this.f12060a = sQLiteDatabase;
            this.b = contentValues;
        }

        public final void a(List list) {
            SQLiteDatabase sQLiteDatabase = this.f12060a;
            ContentValues contentValues = this.b;
            String[] strArrA = null;
            String strA = list != null ? AbstractC4641q.a(list, "id IN") : null;
            if (list != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((T) it.next()).c());
                }
                strArrA = AbstractC4641q.a(arrayList);
            }
            sQLiteDatabase.update("monitor_record", contentValues, strA, strArrA);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((List) obj);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SQLiteDatabase f12061a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(SQLiteDatabase sQLiteDatabase) {
            super(1);
            this.f12061a = sQLiteDatabase;
        }

        public final void a(List list) {
            SQLiteDatabase sQLiteDatabase = this.f12061a;
            String[] strArrA = null;
            String strA = list != null ? AbstractC4641q.a(list, "id IN") : null;
            if (list != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((T) it.next()).c());
                }
                strArrA = AbstractC4641q.a(arrayList);
            }
            sQLiteDatabase.delete("monitor_record", strA, strArrA);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((List) obj);
            return Unit.INSTANCE;
        }
    }

    public S(SQLiteOpenHelper sQLiteOpenHelper) {
        this.f12059a = sQLiteOpenHelper;
    }

    private final Object a(boolean z, List list) {
        Object objM7904constructorimpl;
        synchronized (this.f12059a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase writableDatabase = this.f12059a.getWritableDatabase();
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
        return a(false, list);
    }

    public final Object c(List list) {
        return a(true, list);
    }

    public final Object a(List list) {
        Object objM7904constructorimpl;
        synchronized (this.f12059a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase writableDatabase = this.f12059a.getWritableDatabase();
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

    public final Object a(String str, List list) {
        Object objM7904constructorimpl;
        synchronized (this.f12059a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase writableDatabase = this.f12059a.getWritableDatabase();
                try {
                    writableDatabase.delete("monitor_record", "session_id != ? OR " + AbstractC4641q.a(list, "name NOT IN"), AbstractC4641q.a(CollectionsKt.plus((Collection) CollectionsKt.listOf(str), (Iterable) list)));
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

    private final Object a(String str, String[] strArr, String str2) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f12059a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase readableDatabase = this.f12059a.getReadableDatabase();
                try {
                    int i = 0;
                    Cursor cursorQuery = readableDatabase.query("monitor_record", new String[]{"id", "name", "timestamp", SDKAnalyticsEvents.PARAMETER_SESSION_ID, "data", "error"}, str, strArr, null, null, "timestamp DESC", str2);
                    while (cursorQuery.moveToNext()) {
                        try {
                            try {
                                Result.Companion companion2 = Result.INSTANCE;
                                String string = cursorQuery.getString(i);
                                try {
                                    try {
                                        try {
                                            try {
                                                Result.m7904constructorimpl(Boolean.valueOf(arrayList.add(new T(string, cursorQuery.getString(1), cursorQuery.getString(3), cursorQuery.getLong(2), s0.a(cursorQuery.getBlob(4), string), s0.a(cursorQuery.getBlob(5), string)))));
                                            } catch (Throwable th) {
                                                th = th;
                                                Result.Companion companion3 = Result.INSTANCE;
                                                Result.m7904constructorimpl(ResultKt.createFailure(th));
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                            }
                            i = 0;
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
                Result.Companion companion4 = Result.INSTANCE;
                Result.m7904constructorimpl(ResultKt.createFailure(th10));
            }
        }
        Result.Companion companion5 = Result.INSTANCE;
        return Result.m7904constructorimpl(arrayList);
    }

    public final Object a(String str, String str2) {
        return a(str, str2, (Integer) null);
    }

    public final Object a(String str, String str2, Integer num) {
        return a("name = ? AND session_id = ? AND is_reserved = 0", new String[]{str, str2}, num != null ? num.toString() : null);
    }

    public final Object a(T t) {
        Object objM7904constructorimpl;
        synchronized (this.f12059a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase writableDatabase = this.f12059a.getWritableDatabase();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("id", t.c());
                    contentValues.put("name", t.d());
                    contentValues.put("timestamp", Long.valueOf(t.f()));
                    contentValues.put(SDKAnalyticsEvents.PARAMETER_SESSION_ID, t.e());
                    contentValues.put("data", s0.b(t.a(), t.c()));
                    contentValues.put("error", s0.b(t.b(), t.c()));
                    writableDatabase.insert("monitor_record", null, contentValues);
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

    public final Object a() {
        return a(false, (List) null);
    }
}
