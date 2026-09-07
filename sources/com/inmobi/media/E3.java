package com.inmobi.media;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.inmobi.commons.core.configs.AdConfig;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.SafeDKWebAppInterface;
import com.safedk.android.internal.partials.NetworkBridge;
import com.safedk.android.utils.Logger;
import com.yandex.div.core.DivActionHandler;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class E3 extends H1 implements InterfaceC3386ga {
    public long b;
    public final String c;
    public final String d;
    public final String e;
    public final L4 f;
    public final A3 g;
    public final String h;
    public final AdConfig.RenderingConfig i;
    public final Lazy j;
    public Z5 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E3(Context context, long j, String placementType, String impressionId, String creativeId, L4 l4) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(placementType, "placementType");
        Intrinsics.checkNotNullParameter(impressionId, "impressionId");
        Intrinsics.checkNotNullParameter(creativeId, "creativeId");
        this.b = j;
        this.c = placementType;
        this.d = impressionId;
        this.e = creativeId;
        this.f = l4;
        this.h = "E3";
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        this.i = ((AdConfig) B4.a("ads", "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig", null)).getRendering();
        this.j = LazyKt.lazy(B3.f3031a);
        setImportantForAccessibility(2);
        getSettings().setJavaScriptEnabled(true);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        A3 a3 = new A3("IN_CUSTOM_EXPAND", new C3(this), new D3(this), l4);
        setWebViewClient(a3);
        this.g = a3;
        if (getAdConfig().getEnableCookiesOnInAppBrowser()) {
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setAcceptThirdPartyCookies(this, true);
        }
    }

    private final AdConfig getAdConfig() {
        return (AdConfig) this.j.getValue();
    }

    private void safedk_webview_E3_webviewLoadData_172d49d32092f6f80826f3dca3960029(String p1, String p2, String p3) {
        Logger.d("InMobiNetwork|SafeDK: Partial-Network> Lcom/inmobi/media/E3;->safedk_webview_E3_webviewLoadData_172d49d32092f6f80826f3dca3960029(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V");
        boolean z = SafeDK.getInstance() != null && SafeDK.getInstance().p();
        Logger.d("SafeDKNetwork", "webviewLoadData invoked, WebView address : " + this + ", isSafeDKInitialized = " + z + ", SDK_PACKAGE_NAME = " + com.safedk.android.utils.h.i);
        if (z) {
            CreativeInfoManager.a((String) null, p1, this, com.safedk.android.utils.h.i);
            SafeDKWebAppInterface.a(com.safedk.android.utils.h.i, (WebView) this, p1, true);
        }
        super.loadData(p1, p2, p3);
    }

    private void safedk_webview_E3_webviewLoadUrl_e3177bcd2c23ea94d3766e04b80fd51e(String p1) {
        Logger.d("InMobiNetwork|SafeDK: Partial-Network> Lcom/inmobi/media/E3;->safedk_webview_E3_webviewLoadUrl_e3177bcd2c23ea94d3766e04b80fd51e(Ljava/lang/String;)V");
        Logger.d("SafeDKNetwork", "webviewLoadUrl2. url: " + p1 + ", WebView address : " + toString() + "  SDK_PACKAGE_NAME = " + com.safedk.android.utils.h.i);
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            if (TextUtils.isEmpty(p1) || p1.startsWith("javascript:")) {
                Logger.d("SafeDKNetwork", "webviewLoadUrl2 loadUrl url is null or a javascript command : " + p1);
            } else {
                NetworkBridge.logWebviewLoadURLRequest(com.safedk.android.utils.h.i, this, p1);
                AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(com.safedk.android.utils.h.i);
                if (adNetworkDiscoveryI != null && adNetworkDiscoveryI.d().b(AdNetworkConfiguration.USE_WEBVIEW_LOADURL_AS_RESOURCE_LOADED_INDICATION)) {
                    CreativeInfoManager.a(p1, (String) null, this, com.safedk.android.utils.h.i);
                }
                SafeDKWebAppInterface.a(com.safedk.android.utils.h.i, (WebView) this, p1, true);
            }
        }
        super.loadUrl(p1);
    }

    @Override // com.inmobi.media.InterfaceC3386ga
    public final void a(String triggerApi) {
        Intrinsics.checkNotNullParameter(triggerApi, "triggerApi");
        HashMap map = new HashMap();
        map.put("creativeId", this.e);
        map.put(DivActionHandler.DivActionReason.TRIGGER, triggerApi);
        map.put("impressionId", this.d);
        map.put(com.smaato.sdk.video.vast.model.Ad.AD_TYPE, this.c);
        Ob ob = Ob.f3160a;
        Ob.b("BlockAutoRedirection", map, Sb.SDK);
    }

    @Override // com.inmobi.media.InterfaceC3386ga
    public final boolean d() {
        String TAG = this.h;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        return !this.i.getAutoRedirectionEnforcement() || ((getViewTouchTimestamp() > (-1L) ? 1 : (getViewTouchTimestamp() == (-1L) ? 0 : -1)) != 0 && ((SystemClock.elapsedRealtime() - getViewTouchTimestamp()) > this.i.getUserTouchResetTime() ? 1 : ((SystemClock.elapsedRealtime() - getViewTouchTimestamp()) == this.i.getUserTouchResetTime() ? 0 : -1)) < 0);
    }

    @Override // com.inmobi.media.H1, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.i, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.inmobi.media.H1
    public final U5 g() {
        V5 v5 = new V5(true, "DEFAULT", getAdConfig().getCctEnabled());
        Context context = getContext();
        L4 l4 = this.f;
        Intrinsics.checkNotNull(context);
        return new U5(context, v5, null, null, this, null, l4);
    }

    public final Z5 getLandingPageTelemetryControlInfo() {
        return this.k;
    }

    @Override // com.inmobi.media.InterfaceC3386ga
    public long getViewTouchTimestamp() {
        return this.b;
    }

    @Override // android.webkit.WebView
    public final void loadData(String data, String str, String str2) {
        Intrinsics.checkNotNullParameter(data, "data");
        safedk_webview_E3_webviewLoadData_172d49d32092f6f80826f3dca3960029(data, str, str2);
        A3 a3 = this.g;
        if (a3 != null) {
            a3.d = true;
        }
    }

    @Override // android.webkit.WebView
    public final void loadUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        safedk_webview_E3_webviewLoadUrl_e3177bcd2c23ea94d3766e04b80fd51e(url);
        A3 a3 = this.g;
        if (a3 != null) {
            a3.d = true;
        }
    }

    @Override // com.inmobi.media.H1, android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        setViewTouchTimestamp(SystemClock.elapsedRealtime());
        return super.onTouchEvent(motionEvent);
    }

    public final void setLandingPageTelemetryControlInfo(Z5 z5) {
        this.k = z5;
        A3 a3 = this.g;
        if (a3 == null) {
            return;
        }
        a3.i = z5;
        a3.j = new W5(z5, a3);
    }

    public void setViewTouchTimestamp(long j) {
        this.b = j;
    }
}
