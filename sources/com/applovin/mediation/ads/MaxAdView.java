package com.applovin.mediation.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.b8;
import com.applovin.impl.mediation.ads.MaxAdViewImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.s;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxAdViewConfiguration;
import com.applovin.sdk.AppLovinSdk;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.events.base.StatsEvent;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: loaded from: classes6.dex */
public class MaxAdView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MaxAdViewImpl f786a;
    private View b;
    private int c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaxAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (StatsEvent) null);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V");
        CreativeInfoManager.onMaxAdViewCreated(this, getAdFormat(), getAdUnitId());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaxAdView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, (StatsEvent) null);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V");
        CreativeInfoManager.onMaxAdViewCreated(this, getAdFormat(), getAdUnitId());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaxAdView(String str) {
        this(str, (StatsEvent) null);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;)V");
        CreativeInfoManager.onMaxAdViewCreated(this, getAdFormat(), getAdUnitId());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public MaxAdView(String str, Context context) {
        this(str, context, (StatsEvent) null);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Landroid/content/Context;)V");
        CreativeInfoManager.onMaxAdViewCreated(this, getAdFormat(), getAdUnitId());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaxAdView(String str, MaxAdFormat maxAdFormat) {
        this(str, maxAdFormat, (StatsEvent) null);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Lcom/applovin/mediation/MaxAdFormat;)V");
        CreativeInfoManager.onMaxAdViewCreated(this, getAdFormat(), getAdUnitId());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public MaxAdView(String str, MaxAdFormat maxAdFormat, Context context) {
        this(str, maxAdFormat, context, (StatsEvent) null);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Lcom/applovin/mediation/MaxAdFormat;Landroid/content/Context;)V");
        CreativeInfoManager.onMaxAdViewCreated(this, getAdFormat(), getAdUnitId());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaxAdView(String str, MaxAdFormat maxAdFormat, MaxAdViewConfiguration maxAdViewConfiguration) {
        this(str, maxAdFormat, maxAdViewConfiguration, (StatsEvent) null);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Lcom/applovin/mediation/MaxAdFormat;Lcom/applovin/mediation/MaxAdViewConfiguration;)V");
        CreativeInfoManager.onMaxAdViewCreated(this, getAdFormat(), getAdUnitId());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public MaxAdView(String str, MaxAdFormat maxAdFormat, AppLovinSdk appLovinSdk, Context context) {
        this(str, maxAdFormat, appLovinSdk, context, null);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Lcom/applovin/mediation/MaxAdFormat;Lcom/applovin/sdk/AppLovinSdk;Landroid/content/Context;)V");
        CreativeInfoManager.onMaxAdViewCreated(this, getAdFormat(), getAdUnitId());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaxAdView(String str, MaxAdViewConfiguration maxAdViewConfiguration) {
        this(str, maxAdViewConfiguration, (StatsEvent) null);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Lcom/applovin/mediation/MaxAdViewConfiguration;)V");
        CreativeInfoManager.onMaxAdViewCreated(this, getAdFormat(), getAdUnitId());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public MaxAdView(String str, AppLovinSdk appLovinSdk, Context context) {
        this(str, appLovinSdk, context, (StatsEvent) null);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Lcom/applovin/sdk/AppLovinSdk;Landroid/content/Context;)V");
        CreativeInfoManager.onMaxAdViewCreated(this, getAdFormat(), getAdUnitId());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private MaxAdView(String p1, StatsEvent p2) {
        this(p1, (MaxAdViewConfiguration) null);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;)V");
        if ("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;)V" == 0) {
        } else {
            this(p1, (MaxAdViewConfiguration) null);
        }
    }

    private void a(String str, MaxAdFormat maxAdFormat, MaxAdViewConfiguration maxAdViewConfiguration, int i, Context context) {
        View view = new View(context.getApplicationContext());
        this.b = view;
        view.setBackgroundColor(0);
        addView(this.b);
        this.b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.c = getVisibility();
        this.f786a = new MaxAdViewImpl(str.trim(), maxAdFormat, maxAdViewConfiguration, this, this.b, context);
        setGravity(i);
        if (getBackground() instanceof ColorDrawable) {
            setBackgroundColor(((ColorDrawable) getBackground()).getColor());
        }
        super.setBackgroundColor(0);
    }

    public void destroy() {
        this.f786a.logApiCall("destroy()");
        this.f786a.destroy();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.f8160a, this, me);
        return super.dispatchTouchEvent(me);
    }

    public MaxAdFormat getAdFormat() {
        return this.f786a.getAdFormat();
    }

    public String getAdUnitId() {
        return this.f786a.getAdUnitId();
    }

    public String getPlacement() {
        this.f786a.logApiCall("getPlacement()");
        return this.f786a.getPlacement();
    }

    public void loadAd() {
        this.f786a.logApiCall("loadAd()");
        this.f786a.loadAd();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (isInEditMode()) {
            return;
        }
        this.f786a.logApiCall("onWindowVisibilityChanged(visibility=" + i + ")");
        if (this.f786a != null && b8.a(this.c, i)) {
            this.f786a.onWindowVisibilityChanged(i);
        }
        this.c = i;
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f786a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f786a.setAdReviewListener(maxAdReviewListener);
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        this.f786a.logApiCall("setAlpha(alpha=" + f + ")");
        View view = this.b;
        if (view != null) {
            view.setAlpha(f);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f786a.logApiCall("setBackgroundColor(color=" + i + ")");
        MaxAdViewImpl maxAdViewImpl = this.f786a;
        if (maxAdViewImpl != null) {
            maxAdViewImpl.setPublisherBackgroundColor(i);
        }
        View view = this.b;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setCustomData(String str) {
        this.f786a.logApiCall("setCustomData(value=" + str + ")");
        this.f786a.setCustomData(str);
    }

    public void setExtraParameter(String str, String str2) {
        this.f786a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f786a.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdViewAdListener maxAdViewAdListener) {
        this.f786a.logApiCall("setListener(listener=" + maxAdViewAdListener + ")");
        this.f786a.setListener(maxAdViewAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f786a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f786a.setLocalExtraParameter(str, obj);
    }

    public void setPlacement(String str) {
        this.f786a.logApiCall("setPlacement(placement=" + str + ")");
        this.f786a.setPlacement(str);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.f786a.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.f786a.setRequestListener(maxAdRequestListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f786a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f786a.setRevenueListener(maxAdRevenueListener);
    }

    public void startAutoRefresh() {
        this.f786a.logApiCall("startAutoRefresh()");
        this.f786a.startAutoRefresh();
    }

    public void stopAutoRefresh() {
        this.f786a.logApiCall("stopAutoRefresh()");
        this.f786a.stopAutoRefresh();
    }

    @Override // android.view.View
    public String toString() {
        MaxAdViewImpl maxAdViewImpl = this.f786a;
        return maxAdViewImpl != null ? maxAdViewImpl.toString() : "MaxAdView";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private MaxAdView(String p1, MaxAdFormat p2, StatsEvent p3) {
        this(p1, p2, (MaxAdViewConfiguration) null);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Lcom/applovin/mediation/MaxAdFormat;)V");
        if ("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Lcom/applovin/mediation/MaxAdFormat;)V" == 0) {
        } else {
            this(p1, p2, (MaxAdViewConfiguration) null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private MaxAdView(String p1, MaxAdViewConfiguration p2, StatsEvent p3) {
        this(p1, s.a(k.o()), p2);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Lcom/applovin/mediation/MaxAdViewConfiguration;)V");
        if ("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Lcom/applovin/mediation/MaxAdViewConfiguration;)V" == 0) {
        } else {
            this(p1, s.a(k.o()), p2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private MaxAdView(String p1, MaxAdFormat p2, MaxAdViewConfiguration p3, StatsEvent p4) {
        super(k.o());
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Lcom/applovin/mediation/MaxAdFormat;Lcom/applovin/mediation/MaxAdViewConfiguration;)V");
        if ("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Lcom/applovin/mediation/MaxAdFormat;Lcom/applovin/mediation/MaxAdViewConfiguration;)V" == 0) {
            return;
        }
        super(k.o());
        a.logApiCall("MaxAdView", "MaxAdView(adUnitId=" + p1 + ", adFormat=" + p2 + ", configuration=" + p3 + ")");
        a(p1, p2, p3, 49, k.o());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private MaxAdView(Context p1, AttributeSet p2, StatsEvent p3) {
        this(p1, p2, 0);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V");
        if ("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V" == 0) {
        } else {
            this(p1, p2, 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private MaxAdView(Context p1, AttributeSet p2, int p3, StatsEvent p4) {
        MaxAdFormat maxAdFormatA;
        super(p1, p2, p3);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V");
        if ("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V" == 0) {
            return;
        }
        super(p1, p2, p3);
        String strA = s.a(p1, p2, AppLovinAdView.NAMESPACE, "adUnitId");
        String strA2 = s.a(p1, p2, AppLovinAdView.NAMESPACE, ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT);
        if (StringUtils.isValidString(strA2)) {
            maxAdFormatA = MaxAdFormat.formatFromString(strA2);
        } else {
            maxAdFormatA = s.a(p1);
        }
        MaxAdFormat maxAdFormat = maxAdFormatA;
        int attributeIntValue = p2.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 49);
        if (strA != null) {
            if (!TextUtils.isEmpty(strA)) {
                if (isInEditMode()) {
                    a(p1);
                    return;
                } else {
                    a(strA, maxAdFormat, null, attributeIntValue, p1);
                    return;
                }
            }
            throw new IllegalArgumentException("Empty ad unit ID specified");
        }
        throw new IllegalArgumentException("No ad unit ID specified");
    }

    private void a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE));
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setText("AppLovin MAX Ad");
        textView.setGravity(17);
        addView(textView, i, i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private MaxAdView(String p1, Context p2, StatsEvent p3) {
        this(p1, AppLovinSdk.getInstance(p2), p2);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Landroid/content/Context;)V");
        if ("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Landroid/content/Context;)V" == 0) {
        } else {
            this(p1, AppLovinSdk.getInstance(p2), p2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private MaxAdView(String p1, AppLovinSdk p2, Context p3, StatsEvent p4) {
        this(p1, s.a(p3), p3);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Lcom/applovin/sdk/AppLovinSdk;Landroid/content/Context;)V");
        if ("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Lcom/applovin/sdk/AppLovinSdk;Landroid/content/Context;)V" == 0) {
        } else {
            this(p1, s.a(p3), p3);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private MaxAdView(String p1, MaxAdFormat p2, Context p3, StatsEvent p4) {
        this(p1, p2, AppLovinSdk.getInstance(p3), p3);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Lcom/applovin/mediation/MaxAdFormat;Landroid/content/Context;)V");
        if ("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Lcom/applovin/mediation/MaxAdFormat;Landroid/content/Context;)V" == 0) {
        } else {
            this(p1, p2, AppLovinSdk.getInstance(p3), p3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private MaxAdView(String p1, MaxAdFormat p2, AppLovinSdk p3, Context p4, StatsEvent p5) {
        super(p4);
        Logger.d("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Lcom/applovin/mediation/MaxAdFormat;Lcom/applovin/sdk/AppLovinSdk;Landroid/content/Context;)V");
        if ("AppLovin|SafeDK: Execution> Lcom/applovin/mediation/ads/MaxAdView;-><init>(Ljava/lang/String;Lcom/applovin/mediation/MaxAdFormat;Lcom/applovin/sdk/AppLovinSdk;Landroid/content/Context;)V" == 0) {
            return;
        }
        super(p4);
        a.logApiCall("MaxAdView", "MaxAdView(adUnitId=" + p1 + ", adFormat=" + p2 + ")");
        a(p1, p2, null, 49, p4);
    }
}
