package com.smaato.sdk.banner.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.smaato.sdk.banner.ad.AutoReloadInterval;
import com.smaato.sdk.banner.ad.BannerAdSize;
import com.smaato.sdk.banner.view.BannerViewDelegate;
import com.smaato.sdk.core.AndroidsInjector;
import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.ad.AdRequestParams;
import com.smaato.sdk.core.ad.KeyValuePairs;
import com.smaato.sdk.core.util.LogUtil;
import com.smaato.sdk.core.util.diinjection.Inject;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class BannerView extends FrameLayout {

    @Inject
    protected BannerViewDelegate bannerViewDelegate;

    public interface EventListener {
        default void onAdClicked(BannerView bannerView) {
        }

        default void onAdFailedToLoad(BannerView bannerView, BannerError bannerError) {
        }

        default void onAdImpression(BannerView bannerView) {
        }

        default void onAdLoaded(BannerView bannerView) {
        }

        default void onAdTTLExpired(BannerView bannerView) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.v, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public BannerView(Context context) {
        super(context);
        init();
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public BannerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    private void init() {
        if (!SmaatoSdk.isSmaatoSdkInitialised()) {
            LogUtil.logSmaatoInitMissing();
            return;
        }
        AndroidsInjector.inject(this);
        BannerViewDelegate bannerViewDelegate = this.bannerViewDelegate;
        if (bannerViewDelegate != null) {
            bannerViewDelegate.init(this);
        }
    }

    public void setEventListener(EventListener eventListener) {
        BannerViewDelegate bannerViewDelegate = this.bannerViewDelegate;
        if (bannerViewDelegate != null) {
            bannerViewDelegate.setEventListener(eventListener);
        }
    }

    public String getSessionId() {
        BannerViewDelegate bannerViewDelegate = this.bannerViewDelegate;
        return bannerViewDelegate != null ? bannerViewDelegate.getSessionId() : "";
    }

    public String getCreativeId() {
        BannerViewDelegate bannerViewDelegate = this.bannerViewDelegate;
        return bannerViewDelegate != null ? bannerViewDelegate.getCreativeId() : "";
    }

    public String getAdSpaceId() {
        BannerViewDelegate bannerViewDelegate = this.bannerViewDelegate;
        return bannerViewDelegate != null ? bannerViewDelegate.getAdSpaceId() : "";
    }

    public BannerAdSize getBannerAdSize() {
        BannerViewDelegate bannerViewDelegate = this.bannerViewDelegate;
        if (bannerViewDelegate != null) {
            return bannerViewDelegate.getBannerAdSize();
        }
        return null;
    }

    public void loadAd(String str, BannerAdSize bannerAdSize) {
        loadAd(str, bannerAdSize, null);
    }

    public void loadAd(String str, BannerAdSize bannerAdSize, AdRequestParams adRequestParams) {
        if (!SmaatoSdk.isSmaatoSdkInitialised()) {
            LogUtil.logSmaatoInitMissing();
            return;
        }
        BannerViewDelegate bannerViewDelegate = this.bannerViewDelegate;
        if (bannerViewDelegate != null) {
            bannerViewDelegate.loadAd(str, AdFormat.DISPLAY, bannerAdSize, adRequestParams != null ? adRequestParams.getUBUniqueId() : null);
        }
    }

    public void setMediationNetworkName(String str) {
        BannerViewDelegate bannerViewDelegate = this.bannerViewDelegate;
        if (bannerViewDelegate != null) {
            bannerViewDelegate.setMediationNetworkName(str);
        }
    }

    public void setMediationNetworkSDKVersion(String str) {
        BannerViewDelegate bannerViewDelegate = this.bannerViewDelegate;
        if (bannerViewDelegate != null) {
            bannerViewDelegate.setMediationNetworkSDKVersion(str);
        }
    }

    public void setMediationAdapterVersion(String str) {
        BannerViewDelegate bannerViewDelegate = this.bannerViewDelegate;
        if (bannerViewDelegate != null) {
            bannerViewDelegate.setMediationAdapterVersion(str);
        }
    }

    public KeyValuePairs getKeyValuePairs() {
        BannerViewDelegate bannerViewDelegate = this.bannerViewDelegate;
        if (bannerViewDelegate != null) {
            return bannerViewDelegate.getKeyValuePairs();
        }
        return null;
    }

    public void setKeyValuePairs(KeyValuePairs keyValuePairs) {
        BannerViewDelegate bannerViewDelegate = this.bannerViewDelegate;
        if (bannerViewDelegate != null) {
            bannerViewDelegate.setKeyValuePairs(keyValuePairs);
        }
    }

    public AutoReloadInterval getAutoReloadInterval() {
        BannerViewDelegate bannerViewDelegate = this.bannerViewDelegate;
        return bannerViewDelegate != null ? bannerViewDelegate.getAutoReloadInterval() : AutoReloadInterval.DISABLED;
    }

    public void setAutoReloadInterval(AutoReloadInterval autoReloadInterval) {
        BannerViewDelegate bannerViewDelegate = this.bannerViewDelegate;
        if (bannerViewDelegate != null) {
            bannerViewDelegate.setAutoReloadInterval(autoReloadInterval);
        }
    }

    public void setObjectExtras(Map<String, Object> map) {
        BannerViewDelegate bannerViewDelegate;
        if (map == null || (bannerViewDelegate = this.bannerViewDelegate) == null) {
            return;
        }
        bannerViewDelegate.setObjectExtras(map);
    }

    public void destroy() {
        BannerViewDelegate bannerViewDelegate = this.bannerViewDelegate;
        if (bannerViewDelegate != null) {
            bannerViewDelegate.destroy();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        BannerViewDelegate bannerViewDelegate = this.bannerViewDelegate;
        if (bannerViewDelegate != null) {
            bannerViewDelegate.onWindowFocusChanged(z);
        }
    }
}
