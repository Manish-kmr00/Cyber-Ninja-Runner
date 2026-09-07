package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i61 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c41 f9182a;
    private final pj0 b;
    private final zb1 c;
    private final hj0 d;
    private final bk0 e;
    private final j41 f;
    private final Set<rt> g;

    public static final class a implements dk0 {
        a() {
        }

        @Override // com.yandex.mobile.ads.impl.dk0
        public final void a(String url, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        }

        @Override // com.yandex.mobile.ads.impl.dk0
        public final void a(Map<String, Bitmap> images) {
            Intrinsics.checkNotNullParameter(images, "images");
            i61.this.b.a(images);
            i61.this.c.a();
            Iterator it = i61.this.g.iterator();
            while (it.hasNext()) {
                ((rt) it.next()).onFinishLoadingImages();
            }
        }
    }

    public /* synthetic */ i61(Context context, c41 c41Var, pj0 pj0Var, zb1 zb1Var) {
        this(context, c41Var, pj0Var, zb1Var, new hj0(context), new bk0(), new j41(pj0Var), new CopyOnWriteArraySet());
    }

    public i61(Context context, c41 nativeAd, pj0 imageProvider, zb1 nativeAdViewRenderer, hj0 imageLoadManager, bk0 imageValuesProvider, j41 nativeAdAssetsCreator, Set<rt> imageLoadingListeners) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(nativeAdViewRenderer, "nativeAdViewRenderer");
        Intrinsics.checkNotNullParameter(imageLoadManager, "imageLoadManager");
        Intrinsics.checkNotNullParameter(imageValuesProvider, "imageValuesProvider");
        Intrinsics.checkNotNullParameter(nativeAdAssetsCreator, "nativeAdAssetsCreator");
        Intrinsics.checkNotNullParameter(imageLoadingListeners, "imageLoadingListeners");
        this.f9182a = nativeAd;
        this.b = imageProvider;
        this.c = nativeAdViewRenderer;
        this.d = imageLoadManager;
        this.e = imageValuesProvider;
        this.f = nativeAdAssetsCreator;
        this.g = imageLoadingListeners;
    }

    public final void a(rt listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.g.add(listener);
    }

    public final void d() {
        List<c41> nativeAds = CollectionsKt.listOf(this.f9182a);
        bk0 bk0Var = this.e;
        bk0Var.getClass();
        Intrinsics.checkNotNullParameter(nativeAds, "nativeAds");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(nativeAds, 10));
        for (c41 c41Var : nativeAds) {
            arrayList.add(bk0Var.a(c41Var.b(), c41Var.e()));
        }
        this.d.a(CollectionsKt.toSet(CollectionsKt.flatten(arrayList)), new a());
    }

    public final zq1 b() {
        return this.f9182a.g();
    }

    public final void b(rt listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.g.remove(listener);
    }

    public final String c() {
        return this.f9182a.d();
    }

    public final ot a() {
        return this.f.a(this.f9182a);
    }
}
