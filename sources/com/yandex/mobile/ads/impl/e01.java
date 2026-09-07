package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e01 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f8749a = CollectionsKt.emptyList();

    public static boolean a(Context context, String adapterName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adapterName, "adapterName");
        return !f8749a.contains(adapterName) || u80.a(context, t80.d);
    }
}
