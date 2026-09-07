package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class m80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ls0 f9606a;
    private final l80 b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static m80 f9607a;

        @JvmStatic
        public static final synchronized m80 a(Context context) {
            m80 m80Var;
            Intrinsics.checkNotNullParameter(context, "context");
            m80Var = f9607a;
            if (m80Var == null) {
                m80Var = new m80(context, 0);
                f9607a = m80Var;
            }
            return m80Var;
        }
    }

    private m80(Context context) {
        this(ns0.a(context, "FalseClickDataStorage"));
    }

    public /* synthetic */ m80(Context context, int i) {
        this(context);
    }

    public final List<k80> b() {
        Set<String> setKeySet = this.f9606a.a().keySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setKeySet.iterator();
        while (it.hasNext()) {
            String strD = this.f9606a.d((String) it.next());
            if (strD != null) {
                arrayList.add(strD);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            k80 k80VarA = this.b.a((String) it2.next());
            if (k80VarA != null) {
                arrayList2.add(k80VarA);
            }
        }
        return CollectionsKt.toList(arrayList2);
    }

    public /* synthetic */ m80(ls0 ls0Var) {
        this(ls0Var, new l80(0));
    }

    @VisibleForTesting
    public m80(ls0 localStorage, l80 falseClickDataFormatter) {
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        Intrinsics.checkNotNullParameter(falseClickDataFormatter, "falseClickDataFormatter");
        this.f9606a = localStorage;
        this.b = falseClickDataFormatter;
    }

    public final void a() {
        this.f9606a.clear();
    }

    public final void a(long j) {
        this.f9606a.a(String.valueOf(j));
    }

    public final void a(k80 falseClickData) {
        Intrinsics.checkNotNullParameter(falseClickData, "falseClickData");
        this.f9606a.a(String.valueOf(falseClickData.f()), this.b.a(falseClickData));
    }
}
