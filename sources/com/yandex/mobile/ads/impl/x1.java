package com.yandex.mobile.ads.impl;

import com.monetization.ads.nativeads.ExtendedNativeAdView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m61 f10613a;
    private final wr b;
    private final pt c;
    private final f41 d;
    private final dh e;

    public final boolean a(ExtendedNativeAdView nativeAdView) {
        Intrinsics.checkNotNullParameter(nativeAdView, "nativeAdView");
        try {
            if (this.f10613a instanceof uz1) {
                ((uz1) this.f10613a).a(this.e.a(nativeAdView, this.d));
                ((uz1) this.f10613a).b(this.c);
            }
            return true;
        } catch (a61 unused) {
            this.b.f();
            return false;
        }
    }

    public /* synthetic */ x1(m61 m61Var, wr wrVar, pt ptVar) {
        this(m61Var, wrVar, ptVar, new h41(), new dh());
    }

    public x1(m61 nativeAdPrivate, wr contentCloseListener, pt adEventListener, f41 nativeAdAssetViewProvider, dh assetsNativeAdViewProviderCreator) {
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(adEventListener, "adEventListener");
        Intrinsics.checkNotNullParameter(nativeAdAssetViewProvider, "nativeAdAssetViewProvider");
        Intrinsics.checkNotNullParameter(assetsNativeAdViewProviderCreator, "assetsNativeAdViewProviderCreator");
        this.f10613a = nativeAdPrivate;
        this.b = contentCloseListener;
        this.c = adEventListener;
        this.d = nativeAdAssetViewProvider;
        this.e = assetsNativeAdViewProviderCreator;
    }

    public final void a() {
        m61 m61Var = this.f10613a;
        if (m61Var instanceof uz1) {
            ((uz1) m61Var).b((pt) null);
        }
    }
}
