package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class hg0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final iw1 f9090a;
    private final it0 b;

    public final List<String> a(Context context) {
        String strD;
        Intrinsics.checkNotNullParameter(context, "context");
        cu1 cu1VarA = this.f9090a.a(context);
        if (cu1VarA == null || (strD = cu1VarA.d()) == null) {
            return CollectionsKt.emptyList();
        }
        this.b.getClass();
        List<String> listB = it0.b(context);
        if (listB == null) {
            listB = cu1VarA.x();
        }
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(strD), (Iterable) listB);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hg0() {
        this(iw1.a.a(), new it0());
        int i = iw1.l;
    }

    public hg0(iw1 sdkSettings, it0 manifestAnalyzer) {
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        Intrinsics.checkNotNullParameter(manifestAnalyzer, "manifestAnalyzer");
        this.f9090a = sdkSettings;
        this.b = manifestAnalyzer;
    }
}
