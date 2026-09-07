package com.yandex.mobile.ads.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.yandex.mobile.ads.common.AdRequest;
import com.yandex.mobile.ads.common.VideoController;
import com.yandex.mobile.ads.impl.aj;
import com.yandex.mobile.ads.impl.bj;
import com.yandex.mobile.ads.impl.dp0;
import com.yandex.mobile.ads.impl.el2;
import com.yandex.mobile.ads.impl.g5;
import com.yandex.mobile.ads.impl.ie2;
import com.yandex.mobile.ads.impl.jp0;
import com.yandex.mobile.ads.impl.kl2;
import com.yandex.mobile.ads.impl.o3;
import com.yandex.mobile.ads.impl.ol2;
import com.yandex.mobile.ads.impl.pg0;
import com.yandex.mobile.ads.impl.qs;
import com.yandex.mobile.ads.impl.vs;
import com.yandex.mobile.ads.impl.wm2;
import com.yandex.mobile.ads.impl.ws;
import com.yandex.mobile.ads.impl.yi;
import com.yandex.mobile.ads.impl.zi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#B\u001b\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b\"\u0010&B#\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b\"\u0010)J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006*"}, d2 = {"Lcom/yandex/mobile/ads/banner/BannerAdView;", "Lcom/yandex/mobile/ads/impl/jp0;", "Lcom/yandex/mobile/ads/common/AdRequest;", "adRequest", "", "loadAd", "(Lcom/yandex/mobile/ads/common/AdRequest;)V", "Lcom/yandex/mobile/ads/banner/BannerAdEventListener;", "bannerAdEventListener", "setBannerAdEventListener", "(Lcom/yandex/mobile/ads/banner/BannerAdEventListener;)V", "Lcom/yandex/mobile/ads/banner/BannerAdSize;", "adSize", "setAdSize", "(Lcom/yandex/mobile/ads/banner/BannerAdSize;)V", "", "adUnitId", "setAdUnitId", "(Ljava/lang/String;)V", "destroy", "()V", "Lcom/yandex/mobile/ads/common/VideoController;", "l", "Lcom/yandex/mobile/ads/common/VideoController;", "getVideoController", "()Lcom/yandex/mobile/ads/common/VideoController;", "videoController", "getAdSize", "()Lcom/yandex/mobile/ads/banner/BannerAdSize;", "getInfo", "()Ljava/lang/String;", "info", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class BannerAdView extends jp0 {
    private final el2 j;
    private String k;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final VideoController videoController;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BannerAdView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.yandex.mobile.ads.impl.jp0
    protected final zi a(Context context, yi bannerAdListener, g5 phasesManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bannerAdListener, "bannerAdListener");
        Intrinsics.checkNotNullParameter(phasesManager, "phasesManager");
        return new zi(context, this, bannerAdListener, phasesManager, new ie2(), new bj(), new aj(getAdConfiguration$mobileads_externalRelease().q()), new pg0());
    }

    @Override // com.yandex.mobile.ads.impl.jp0
    public void destroy() {
        super.destroy();
    }

    @Override // com.yandex.mobile.ads.impl.jp0, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.y, this, me);
        return super.dispatchTouchEvent(me);
    }

    public final BannerAdSize getAdSize() {
        ws coreBannerAdSize = b();
        if (coreBannerAdSize == null) {
            return null;
        }
        Intrinsics.checkNotNullParameter(coreBannerAdSize, "coreBannerAdSize");
        return new BannerAdSize(coreBannerAdSize.a());
    }

    public final String getInfo() {
        return c();
    }

    public final VideoController getVideoController() {
        return this.videoController;
    }

    public final void loadAd(AdRequest adRequest) {
        Intrinsics.checkNotNullParameter(adRequest, "adRequest");
        String str = this.k;
        if (str == null || str.length() <= 0) {
            dp0.a("Failed to load ad with empty ad unit id", new Object[0]);
        } else {
            a(this.j.a(str, adRequest));
        }
    }

    public final void setAdSize(BannerAdSize adSize) {
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        a(a.a(adSize));
    }

    @Override // com.yandex.mobile.ads.impl.jp0
    public void setAdUnitId(String adUnitId) {
        this.k = adUnitId;
        super.setAdUnitId(adUnitId);
    }

    public final void setBannerAdEventListener(BannerAdEventListener bannerAdEventListener) {
        vs kl2Var;
        if (bannerAdEventListener instanceof ClosableBannerAdEventListener) {
            kl2Var = new ol2((ClosableBannerAdEventListener) bannerAdEventListener);
        } else {
            kl2Var = bannerAdEventListener != null ? new kl2(bannerAdEventListener) : null;
        }
        a(kl2Var);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BannerAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, new o3(qs.d, new wm2(context)), null, null, null, null, null, 496, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.j = new el2();
        this.videoController = new VideoController(d());
    }
}
