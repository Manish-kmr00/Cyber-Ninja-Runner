package com.amazon.device.ads;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class DTBAdInterstitial {
    protected static final String INTERSTITIAL_CACHE_KEY = "INTERSTITIAL_CACHE_KEY";
    private static final String LOG_TAG = "DTBAdInterstitial";
    private static Map<Integer, DTBAdInterstitial> dtbAdInterstitialCache = Collections.synchronizedMap(new HashMap());
    DTBAdView adView;
    private Context context;

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.A);
        p0.startActivity(p1);
    }

    DTBAdView getAdView() {
        return this.adView;
    }

    private static int putInCache(DTBAdInterstitial dTBAdInterstitial) {
        dtbAdInterstitialCache.put(Integer.valueOf(dTBAdInterstitial.hashCode()), dTBAdInterstitial);
        return dTBAdInterstitial.hashCode();
    }

    static void removeFromCache(int i) {
        dtbAdInterstitialCache.remove(Integer.valueOf(i));
    }

    static DTBAdInterstitial getFromCache(int i) {
        if (dtbAdInterstitialCache.containsKey(Integer.valueOf(i))) {
            return dtbAdInterstitialCache.get(Integer.valueOf(i));
        }
        return null;
    }

    public DTBAdInterstitial(Context context, DTBAdInterstitialListener dTBAdInterstitialListener) {
        try {
            this.context = context;
            this.adView = new DTBAdView(context, dTBAdInterstitialListener);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to initialize DTBAdInterstitial class", e);
        }
    }

    protected DTBAdInterstitial(Context context) {
        this.context = context;
    }

    protected void setDtbAdInterstitialListener(DTBAdInterstitialListener dTBAdInterstitialListener) {
        try {
            this.adView = new DTBAdView(this.context, dTBAdInterstitialListener);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to initialize DTBAdInterstitial class", e);
        }
    }

    private DTBAdMRAIDInterstitialController getInterstitialController() {
        return (DTBAdMRAIDInterstitialController) this.adView.getController();
    }

    private DTBAdInterstitialListener getInterstitialListener() {
        return getInterstitialController().getInterstitialListener();
    }

    void setListener(DTBAdInterstitialListener dTBAdInterstitialListener) {
        getInterstitialController().setInterstitialListener(dTBAdInterstitialListener);
    }

    public void fetchAd(Map<String, Object> map) {
        this.adView.fetchAd((Map<String, ? extends Object>) map);
    }

    public void fetchAd(Bundle bundle) {
        try {
            this.adView.fetchAd(bundle.getString("bid_html_template", ""), bundle);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute fetchAd method with extraData argument", e);
        }
    }

    public void fetchAd(String str) {
        try {
            this.adView.fetchAd(str);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute fetchAd method with adHtml argument", e);
        }
    }

    public void fetchAd(String str, Bundle bundle) {
        try {
            this.adView.fetchAd(str, bundle);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute fetchAd method with adHtml and  bundle argument", e);
        }
    }

    public void show() {
        try {
            if (getInterstitialController() == null) {
                APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "There is no controller before showing the interstitial ad");
                return;
            }
            Intent intent = new Intent(this.context, (Class<?>) DTBInterstitialActivity.class);
            intent.putExtra(INTERSTITIAL_CACHE_KEY, putInCache(this));
            getInterstitialController().startOMSDKSession();
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.context, intent);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute show method", e);
        }
    }

    public static int getWidth(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute getWidth method", e);
            return 0;
        }
    }

    void onAdClosed() {
        DTBAdInterstitialListener interstitialListener = getInterstitialListener();
        if (interstitialListener != null) {
            interstitialListener.onAdClosed(this.adView);
        }
    }
}
