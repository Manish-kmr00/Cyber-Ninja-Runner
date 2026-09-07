package com.yandex.mobile.ads.impl;

import android.view.View;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class dh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Collection<String> f8693a;

    public final g71 a(View view, f41 viewProvider) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewProvider, "viewProvider");
        g71.a aVar = new g71.a(view, b81.c, MapsKt.emptyMap());
        g71.a aVarE = aVar.a(viewProvider.h(view)).b(viewProvider.a(view)).c(viewProvider.e(view)).d(viewProvider.n(view)).a(viewProvider.g(view)).b(viewProvider.l(view)).c(viewProvider.o(view)).a(viewProvider.c(view)).a(viewProvider.b(view)).a(viewProvider.k(view)).e(viewProvider.d(view));
        View viewI = viewProvider.i(view);
        if (!(viewI instanceof fn1)) {
            viewI = null;
        }
        aVarE.a(viewI).f(viewProvider.p(view)).g(viewProvider.m(view)).h(viewProvider.j(view)).i(viewProvider.f(view));
        for (String str : this.f8693a) {
            View viewA = viewProvider.a(view, str);
            if (viewA != null) {
                aVar.a(viewA, str);
            }
        }
        return new g71(aVar, 0);
    }

    public /* synthetic */ dh() {
        this(CollectionsKt.emptyList());
    }

    public dh(Collection<String> supportedAssetNames) {
        Intrinsics.checkNotNullParameter(supportedAssetNames, "supportedAssetNames");
        this.f8693a = supportedAssetNames;
    }
}
