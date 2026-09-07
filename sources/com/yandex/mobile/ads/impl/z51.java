package com.yandex.mobile.ads.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bl0 f10790a;

    public /* synthetic */ z51() {
        this(new bl0());
    }

    public z51(bl0 formatter) {
        Intrinsics.checkNotNullParameter(formatter, "formatter");
        this.f10790a = formatter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Iterable, java.lang.Object, java.util.List] */
    public final String a(m61 m61Var) {
        ?? ListOfNotNull;
        if (m61Var instanceof uz1) {
            ArrayList arrayListD = ((uz1) m61Var).d();
            ListOfNotNull = new ArrayList();
            Iterator it = arrayListD.iterator();
            while (it.hasNext()) {
                String info = ((m61) it.next()).getInfo();
                if (info != null) {
                    ListOfNotNull.add(info);
                }
            }
        } else {
            ListOfNotNull = CollectionsKt.listOfNotNull(m61Var != null ? m61Var.getInfo() : null);
        }
        ?? list = ListOfNotNull;
        this.f10790a.getClass();
        Intrinsics.checkNotNullParameter(list, "list");
        if (list.isEmpty()) {
            return null;
        }
        return CollectionsKt.joinToString$default(list, StringUtils.COMMA, com.ironsource.b9.i.d, com.ironsource.b9.i.e, 0, null, null, 56, null);
    }
}
