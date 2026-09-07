package com.yandex.mobile.ads.impl;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class ij2 implements v30.c {
    static final /* synthetic */ KProperty<Object>[] c = {ta.a(ij2.class, "cacheListener", "getCacheListener()Lcom/monetization/ads/nativeads/video/cache/VideoCacheListener;", 0)};
    private static final List<Integer> d;
    private static final List<Integer> e;
    private static final List<Integer> f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9229a;
    private final zn1 b;

    static {
        List<Integer> listListOf = CollectionsKt.listOf((Object[]) new Integer[]{3, 4});
        d = listListOf;
        List<Integer> listListOf2 = CollectionsKt.listOf((Object[]) new Integer[]{1, 5});
        e = listListOf2;
        f = CollectionsKt.plus((Collection) listListOf, (Iterable) listListOf2);
    }

    public ij2(String requestId, wd2 videoCacheListener) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(videoCacheListener, "videoCacheListener");
        this.f9229a = requestId;
        this.b = ao1.a(videoCacheListener);
    }

    @Override // com.yandex.mobile.ads.impl.v30.c
    public final void a(v30 downloadManager, t30 download) {
        wd2 wd2Var;
        wd2 wd2Var2;
        Intrinsics.checkNotNullParameter(downloadManager, "downloadManager");
        Intrinsics.checkNotNullParameter(download, "download");
        if (Intrinsics.areEqual(download.f10264a.b, this.f9229a)) {
            if (d.contains(Integer.valueOf(download.b)) && (wd2Var2 = (wd2) this.b.getValue(this, c[0])) != null) {
                wd2Var2.a();
            }
            if (e.contains(Integer.valueOf(download.b)) && (wd2Var = (wd2) this.b.getValue(this, c[0])) != null) {
                wd2Var.c();
            }
            if (f.contains(Integer.valueOf(download.b))) {
                downloadManager.a((v30.c) this);
            }
        }
    }
}
