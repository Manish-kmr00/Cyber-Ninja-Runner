package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class qv1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10052a;
    private final e11 b;

    public qv1(Context context, e11 integrationChecker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(integrationChecker, "integrationChecker");
        this.f10052a = context;
        this.b = integrationChecker;
    }

    public final vx a() {
        e11 e11Var = this.b;
        Context context = this.f10052a;
        e11Var.getClass();
        e11.a aVarA = e11.a(context);
        if (Intrinsics.areEqual(aVarA, e11.a.C0741a.f8751a)) {
            return new vx(true, CollectionsKt.emptyList());
        }
        if (aVarA instanceof e11.a.b) {
            List<xo0> listA = ((e11.a.b) aVarA).a();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(((xo0) it.next()).getMessage());
            }
            return new vx(false, arrayList);
        }
        throw new NoWhenBranchMatchedException();
    }
}
