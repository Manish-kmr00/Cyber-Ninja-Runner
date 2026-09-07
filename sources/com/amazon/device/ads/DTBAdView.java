package com.amazon.device.ads;

import android.content.Context;
import android.view.MotionEvent;
import com.amazon.aps.ads.metrics.ApsMetricsBannerListenerAdapter;
import com.amazon.aps.ads.metrics.ApsMetricsInterstitialListenerAdapter;
import com.amazon.aps.ads.util.adview.ApsAdViewConstants;
import com.amazon.aps.ads.util.adview.ApsAdViewImpl;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes11.dex */
public class DTBAdView extends ApsAdViewImpl implements ApsAdViewConstants {
    static final String LOG_TAG = "DTBAdView";

    @Override // com.amazon.aps.ads.util.adview.ApsAdViewImpl, com.amazon.aps.ads.util.adview.ApsAdViewBase, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.A, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdViewImpl, com.amazon.aps.ads.util.adview.ApsAdViewBase, android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    protected DTBAdView(Context context) {
        super(context);
    }

    public DTBAdView(Context context, DTBAdInterstitialListener dTBAdInterstitialListener) {
        super(context);
        initAdInterstitialListener(dTBAdInterstitialListener);
    }

    public DTBAdView(Context context, DTBAdBannerListener dTBAdBannerListener) {
        super(context);
        initAdBannerListener(dTBAdBannerListener);
    }

    public DTBAdView(Context context, DTBAdExpandedListener dTBAdExpandedListener) {
        this(context, dTBAdExpandedListener, 0);
    }

    public DTBAdView(Context context, DTBAdExpandedListener dTBAdExpandedListener, int i) {
        super(context);
        initAdExpandedListener(dTBAdExpandedListener, i);
    }

    protected void initAdInterstitialListener(DTBAdInterstitialListener dTBAdInterstitialListener) {
        try {
            setMraidListenerAdapter(new ApsMetricsInterstitialListenerAdapter(getBidId(), dTBAdInterstitialListener));
            setMraidHandler(new DTBAdMRAIDInterstitialController(this, (ApsMetricsInterstitialListenerAdapter) getMraidListenerAdapter()));
            initWebView();
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to initialize DTBAdView class with DTBAdInterstitialListener", e);
        }
    }

    protected void initAdBannerListener(DTBAdBannerListener dTBAdBannerListener) {
        try {
            setMraidListenerAdapter(new ApsMetricsBannerListenerAdapter(getBidId(), dTBAdBannerListener));
            setMraidHandler(new DTBAdMRAIDBannerController(this, (ApsMetricsBannerListenerAdapter) getMraidListenerAdapter()));
            initWebView();
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to initialize DTBAdView class with DTBAdBannerListener", e);
        }
    }

    protected void initAdExpandedListener(DTBAdExpandedListener dTBAdExpandedListener, int i) {
        try {
            DTBAdMRAIDExpandedController dTBAdMRAIDExpandedController = new DTBAdMRAIDExpandedController(this);
            setMraidHandler(dTBAdMRAIDExpandedController);
            dTBAdMRAIDExpandedController.setMasterController(DTBAdMRAIDBannerController.findControllerByIndex(i));
            dTBAdExpandedListener.onCreateExpandedController((DTBAdMRAIDExpandedController) getMraidHandler());
            initWebView();
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to initialize DTBAdView class with DTBAdExpandedListener", e);
        }
    }

    public DTBAdMRAIDController getController() {
        return super.getMraidHandler();
    }
}
