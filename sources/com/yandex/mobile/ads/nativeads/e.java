package com.yandex.mobile.ads.nativeads;

import com.yandex.mobile.ads.impl.a61;
import com.yandex.mobile.ads.impl.im2;
import com.yandex.mobile.ads.impl.jm2;
import com.yandex.mobile.ads.impl.lm2;
import com.yandex.mobile.ads.impl.m61;
import com.yandex.mobile.ads.impl.o61;
import com.yandex.mobile.ads.impl.om2;
import com.yandex.mobile.ads.impl.pl2;
import com.yandex.mobile.ads.impl.pm2;
import com.yandex.mobile.ads.impl.pt;
import com.yandex.mobile.ads.impl.vt;
import com.yandex.mobile.ads.impl.zq1;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public class e implements NativeAd, CustomClickable, com.yandex.mobile.ads.nativeads.video.a, o61 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m61 f10890a;
    private final g b;
    private final om2 c;

    @Override // com.yandex.mobile.ads.nativeads.NativeAd
    public final void addImageLoadingListener(NativeAdImageLoadingListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f10890a.b(new lm2(listener));
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAd
    public final void bindNativeAd(NativeAdViewBinder viewBinder) throws NativeAdException {
        Intrinsics.checkNotNullParameter(viewBinder, "viewBinder");
        try {
            this.b.getClass();
            this.f10890a.b(g.a(viewBinder));
        } catch (a61 e) {
            throw new NativeAdException(e.a(), e);
        } catch (Throwable th) {
            throw new NativeAdException("Ad binding failed with unexpected exception", th);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && Intrinsics.areEqual(((e) obj).f10890a, this.f10890a);
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAd
    public final NativeAdAssets getAdAssets() {
        return new im2(this.f10890a.getAdAssets());
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAd
    public final NativeAdType getAdType() {
        om2 om2Var = this.c;
        zq1 responseNativeType = this.f10890a.getAdType();
        om2Var.getClass();
        Intrinsics.checkNotNullParameter(responseNativeType, "responseNativeType");
        int iOrdinal = responseNativeType.ordinal();
        if (iOrdinal == 0) {
            return NativeAdType.CONTENT;
        }
        if (iOrdinal == 1) {
            return NativeAdType.APP_INSTALL;
        }
        if (iOrdinal == 2) {
            return NativeAdType.MEDIA;
        }
        if (iOrdinal == 3) {
            return NativeAdType.CONTENT;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAd
    public final String getInfo() {
        return this.f10890a.getInfo();
    }

    @Override // com.yandex.mobile.ads.nativeads.video.NativeAdVideoControllerProvider
    public final com.yandex.mobile.ads.nativeads.video.b getNativeAdVideoController() {
        vt nativeAdVideoController = this.f10890a.getNativeAdVideoController();
        if (nativeAdVideoController != null) {
            return new pm2(nativeAdVideoController);
        }
        return null;
    }

    public int hashCode() {
        return this.f10890a.hashCode();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAd
    public final void loadImages() {
        this.f10890a.loadImages();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAd
    public final void removeImageLoadingListener(NativeAdImageLoadingListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f10890a.a(new lm2(listener));
    }

    @Override // com.yandex.mobile.ads.nativeads.CustomClickable
    public final void setCustomClickHandler(CustomClickHandler customClickHandler) {
        this.f10890a.a(customClickHandler != null ? new c(customClickHandler) : null);
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAd
    public final void setNativeAdEventListener(NativeAdEventListener nativeAdEventListener) {
        pt jm2Var;
        if (nativeAdEventListener instanceof ClosableNativeAdEventListener) {
            jm2Var = new pl2((ClosableNativeAdEventListener) nativeAdEventListener);
        } else {
            jm2Var = nativeAdEventListener != null ? new jm2(nativeAdEventListener) : null;
        }
        this.f10890a.a(jm2Var);
    }

    public /* synthetic */ e(m61 m61Var) {
        this(m61Var, new h(), new g(), new om2());
    }

    public e(m61 nativeAdPrivate, h nativePromoAdViewAdapter, g nativeAdViewBinderAdapter, om2 nativeAdTypeConverter) {
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(nativePromoAdViewAdapter, "nativePromoAdViewAdapter");
        Intrinsics.checkNotNullParameter(nativeAdViewBinderAdapter, "nativeAdViewBinderAdapter");
        Intrinsics.checkNotNullParameter(nativeAdTypeConverter, "nativeAdTypeConverter");
        this.f10890a = nativeAdPrivate;
        this.b = nativeAdViewBinderAdapter;
        this.c = nativeAdTypeConverter;
    }

    @Override // com.yandex.mobile.ads.impl.o61
    public final m61 a() {
        return this.f10890a;
    }
}
