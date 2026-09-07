package io.bidmachine.analytics.internal;

import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
public final class m0 implements l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteOpenHelper f12116a;
    private final Lazy b = LazyKt.lazy(new a());

    static final class a extends Lambda implements Function0 {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i0 invoke() {
            return new i0(m0.this.f12116a);
        }
    }

    public m0(SQLiteOpenHelper sQLiteOpenHelper) {
        this.f12116a = sQLiteOpenHelper;
    }

    @Override // io.bidmachine.analytics.internal.l0
    public Object b(List list) {
        i0 i0VarA = a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(k0.a((h0) it.next()));
        }
        return i0VarA.a(arrayList);
    }

    @Override // io.bidmachine.analytics.internal.l0
    public Object c(List list) {
        i0 i0VarA = a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(k0.a((h0) it.next()));
        }
        return i0VarA.d(arrayList);
    }

    @Override // io.bidmachine.analytics.internal.l0
    public Object a(List list, List list2) {
        a().b(list);
        i0 i0VarA = a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(k0.a((h0.a) it.next()).toString());
        }
        i0VarA.c(arrayList);
        Result.Companion companion = Result.INSTANCE;
        return Result.m7904constructorimpl(Unit.INSTANCE);
    }

    public final Object b() {
        return a().b();
    }

    @Override // io.bidmachine.analytics.internal.l0
    public Object a(String str) {
        return a(a().a(str));
    }

    @Override // io.bidmachine.analytics.internal.l0
    public Object b(h0 h0Var) {
        return a().a(k0.a(h0Var));
    }

    private final i0 a() {
        return (i0) this.b.getValue();
    }

    @Override // io.bidmachine.analytics.internal.l0
    public Object a(String str, h0.a aVar) {
        Object objA = a().a(str, k0.a(aVar).toString());
        try {
            Result.Companion companion = Result.INSTANCE;
            ResultKt.throwOnFailure(objA);
            j0 j0Var = (j0) objA;
            return Result.m7904constructorimpl(j0Var != null ? k0.a(j0Var) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final Object a(Object obj) {
        try {
            Result.Companion companion = Result.INSTANCE;
            ResultKt.throwOnFailure(obj);
            Iterable iterable = (Iterable) obj;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(k0.a((j0) it.next()));
            }
            return Result.m7904constructorimpl(arrayList);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // io.bidmachine.analytics.internal.l0
    public Object a(String str, List list) {
        i0 i0VarA = a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(k0.a((h0.a) it.next()).toString());
        }
        return i0VarA.a(str, arrayList);
    }

    @Override // io.bidmachine.analytics.internal.l0
    public Object a(List list) {
        i0 i0VarA = a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(k0.a((h0) it.next()));
        }
        return i0VarA.e(arrayList);
    }

    @Override // io.bidmachine.analytics.internal.l0
    public Object a(h0 h0Var) {
        return a().c(k0.a(h0Var));
    }
}
