package com.amazon.aps.ads.util.adview;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.amazon.aps.ads.util.ApsAdExtensionsKt;
import com.amazon.aps.ads.util.ApsUtils;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.ApsMetrics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.amazon.aps.shared.metrics.ApsMetricsPerfEventModelBuilder;
import com.amazon.device.ads.DTBAdMRAIDBannerController;
import com.amazon.device.ads.DTBAdMRAIDController;
import com.amazon.device.ads.DTBAdView;
import com.amazon.device.ads.DtbOmSdkSessionManager;
import com.amazon.device.ads.WebResourceOptions;
import com.amazon.device.ads.WebResourceService;
import com.json.nu;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.SafeDKWebAppInterface;
import com.safedk.android.internal.partials.AmazonPublisherServicesNetworkBridge;
import com.safedk.android.internal.partials.NetworkBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ApsAdViewImpl.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J$\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010!\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010!\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010\u001e2\b\u0010&\u001a\u0004\u0018\u00010#J(\u0010!\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010\u001e2\u0014\u0010'\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020)0(H\u0016J\"\u0010!\u001a\u00020\u00182\u0018\u0010*\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010(H\u0016J\u0010\u0010+\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010\u001eJ\u0016\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020#J\n\u00100\u001a\u0004\u0018\u000101H\u0016J\u0018\u00102\u001a\u0002032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00104\u001a\u000203H\u0002J\b\u00105\u001a\u00020\u0018H\u0014J\b\u00106\u001a\u00020\u000bH\u0016J\u0018\u00107\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:H\u0004J\u0010\u0010;\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u001eH\u0016J\b\u0010<\u001a\u00020\u0018H\u0016J\b\u0010=\u001a\u00020\u0018H\u0014J\u0006\u0010>\u001a\u00020\u0018J$\u0010?\u001a\u00020\u00182\u0006\u0010@\u001a\u00020A2\n\u0010B\u001a\u00060:j\u0002`C2\u0006\u0010D\u001a\u00020\u001eH\u0016J\u0018\u0010E\u001a\u00020\u00182\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0014J\b\u0010J\u001a\u00020\u0018H\u0016J\u001a\u0010K\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u001e2\b\u0010L\u001a\u0004\u0018\u00010AH\u0016J\b\u0010M\u001a\u00020\u0018H\u0016J\u0010\u0010N\u001a\u00020\u00182\u0006\u0010H\u001a\u00020IH\u0014J\u0010\u0010O\u001a\u00020\u00182\u0006\u0010P\u001a\u00020\u000bH\u0014J\b\u0010Q\u001a\u00020\u0018H\u0014J\u0006\u0010R\u001a\u00020\u0018R\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006S"}, d2 = {"Lcom/amazon/aps/ads/util/adview/ApsAdViewImpl;", "Lcom/amazon/aps/ads/util/adview/ApsAdViewBase;", "Lcom/amazon/aps/ads/util/adview/ApsWebBridgeListener;", "Lcom/amazon/aps/ads/util/adview/ApsAdWebViewClientListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adViewContext", "getAdViewContext", "()Landroid/content/Context;", "localOnly", "", "getLocalOnly", "()Z", "webBridge", "Lcom/amazon/aps/ads/util/adview/ApsAdViewWebBridge;", "value", "Lcom/amazon/aps/ads/util/adview/ApsAdWebViewSupportClientBase;", "webClient", "getWebClient", "()Lcom/amazon/aps/ads/util/adview/ApsAdWebViewSupportClientBase;", "setWebClient", "(Lcom/amazon/aps/ads/util/adview/ApsAdWebViewSupportClientBase;)V", "cleanup", "", "detectAdClick", "event", "Landroid/view/MotionEvent;", "evaluateApsJavascript", "script", "", "resultCallback", "Landroid/webkit/ValueCallback;", "fetchAd", "extras", "Landroid/os/Bundle;", "adHtml", "adHtmlArg", "extraData", "extra", "", "", "extraMap", "fetchAdWithLocation", "url", "getAdInfo", "adhtml", "adInfoBundle", "getApsMraidHandler", "Lcom/amazon/device/ads/DTBAdMRAIDController;", "handleClick", "", "time", "initWebView", "isTwoPartExpand", "loadLocalFile", ContentDisposition.Parameters.FileName, "sb", "Ljava/lang/StringBuilder;", "loadUrl", nu.k, nu.c, "onAdRemoved", "onCrash", "webView", "Landroid/webkit/WebView;", "errorInfo", "Lkotlin/text/StringBuilder;", "errorDetail", "onExposureChange", "exposurePercentage", "", "adViewRect", "Landroid/graphics/Rect;", "onLoadError", "onPageFinished", "view", "onPageLoaded", "onPositionChanged", "onViewabilityChanged", "isChanged", "setCurrentPositionProperty", "setIgnoreDetachment", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ApsAdViewImpl extends ApsAdViewBase implements ApsWebBridgeListener, ApsAdWebViewClientListener {
    private final Context adViewContext;
    private final boolean localOnly;
    protected ApsAdViewWebBridge webBridge;
    private ApsAdWebViewSupportClientBase webClient;

    private void safedk_webview_ApsAdViewImpl_webviewLoadUrl_e3177bcd2c23ea94d3766e04b80fd51e(String p1) {
        Logger.d("AmazonPublisherServicesNetwork|SafeDK: Partial-Network> Lcom/amazon/aps/ads/util/adview/ApsAdViewImpl;->safedk_webview_ApsAdViewImpl_webviewLoadUrl_e3177bcd2c23ea94d3766e04b80fd51e(Ljava/lang/String;)V");
        Logger.d("SafeDKNetwork", "webviewLoadUrl2. url: " + p1 + ", WebView address : " + toString() + "  SDK_PACKAGE_NAME = " + h.A);
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            if (TextUtils.isEmpty(p1) || p1.startsWith("javascript:")) {
                Logger.d("SafeDKNetwork", "webviewLoadUrl2 loadUrl url is null or a javascript command : " + p1);
            } else {
                NetworkBridge.logWebviewLoadURLRequest(h.A, this, p1);
                AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(h.A);
                if (adNetworkDiscoveryI != null && adNetworkDiscoveryI.d().b(AdNetworkConfiguration.USE_WEBVIEW_LOADURL_AS_RESOURCE_LOADED_INDICATION)) {
                    CreativeInfoManager.a(p1, (String) null, this, h.A);
                }
                SafeDKWebAppInterface.a(h.A, (WebView) this, p1, true);
            }
        }
        super.loadUrl(p1);
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdViewBase, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.A, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdViewBase, android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApsAdViewImpl(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.localOnly = WebResourceOptions.isLocalSourcesOnly();
        this.adViewContext = context;
    }

    public final boolean getLocalOnly() {
        return this.localOnly;
    }

    public final ApsAdWebViewSupportClientBase getWebClient() {
        return this.webClient;
    }

    protected final void setWebClient(ApsAdWebViewSupportClientBase apsAdWebViewSupportClientBase) {
        if (apsAdWebViewSupportClientBase == null) {
            return;
        }
        this.webClient = apsAdWebViewSupportClientBase;
        setWebViewClient(apsAdWebViewSupportClientBase);
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdViewBase
    protected void initWebView() {
        super.initWebView();
        ApsAdWebViewSupportClient apsAdWebViewSupportClient = new ApsAdWebViewSupportClient(this);
        setWebViewClient(apsAdWebViewSupportClient);
        setWebClient(apsAdWebViewSupportClient);
        setAdViewScrollEnabled(false);
        ApsAdViewWebBridge apsAdViewWebBridge = new ApsAdViewWebBridge(this);
        this.webBridge = apsAdViewWebBridge;
        AmazonPublisherServicesNetworkBridge.onAddedJavascriptInterface(this, apsAdViewWebBridge, "amzn_bridge");
        WebResourceService.init();
        initLayoutListeners();
        setOnTouchListener(new View.OnTouchListener() { // from class: com.amazon.aps.ads.util.adview.ApsAdViewImpl$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ApsAdViewImpl.m4374initWebView$lambda3(this.f$0, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initWebView$lambda-3, reason: not valid java name */
    public static final boolean m4374initWebView$lambda3(ApsAdViewImpl this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.detectAdClick(motionEvent);
    }

    public final void getAdInfo(String adhtml, Bundle adInfoBundle) {
        Intrinsics.checkNotNullParameter(adhtml, "adhtml");
        Intrinsics.checkNotNullParameter(adInfoBundle, "adInfoBundle");
        ApsAdViewFetchUtils.INSTANCE.getAdInfo(adhtml, adInfoBundle);
    }

    public void fetchAd(String adHtml, Map<String, ? extends Object> extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        ApsAdViewFetchUtils.INSTANCE.fetchAd(this, adHtml, extra);
    }

    public final void fetchAdWithLocation(String url) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        ApsAdViewFetchUtils.INSTANCE.fetchAdWithLocation(context, this, getLocalOnly(), url);
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdViewBase
    public void cleanup() {
        try {
            super.cleanup();
            removeJavascriptInterface("amzn_bridge");
            DtbOmSdkSessionManager omSdkManager = getOmSdkManager();
            if (omSdkManager != null) {
                omSdkManager.stopOmAdSession();
            }
            DTBAdMRAIDController mraidHandler = getMraidHandler();
            if (mraidHandler != null) {
                mraidHandler.cleanup();
            }
            setMraidHandler(null);
        } catch (RuntimeException e) {
            ApsAdExtensionsKt.logEvent(this, APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error in ApsAdView cleanup", e);
        }
    }

    public final void onAdRemoved() {
        if (getMraidHandler() != null) {
            DTBAdMRAIDController mraidHandler = getMraidHandler();
            Intrinsics.checkNotNull(mraidHandler);
            mraidHandler.onAdRemoved();
            return;
        }
        ApsAdExtensionsKt.logEvent(this, APSEventSeverity.FATAL, APSEventType.LOG, "Null controller instance onAdRemoved");
    }

    public void fetchAd(Map<String, ? extends Object> extraMap) {
        if (extraMap == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String?, kotlin.Any>");
        }
        fetchAd((String) null, extraMap);
    }

    public void fetchAd(String adHtml) {
        fetchAd(adHtml, (Bundle) null);
    }

    public void fetchAd(Bundle extras) {
        fetchAd((String) null, extras);
    }

    public final void fetchAd(String adHtmlArg, Bundle extraData) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (ApsUtils.INSTANCE.isNullOrEmpty(adHtmlArg)) {
            adHtmlArg = null;
            if (extraData != null) {
                adHtmlArg = extraData.getString("bid_html_template", null);
            }
        }
        DTBAdMRAIDController mraidHandler = getMraidHandler();
        if (mraidHandler != null) {
            Bundle bundleForFetchAd = ApsAdViewFetchUtils.INSTANCE.getBundleForFetchAd(mraidHandler, adHtmlArg, extraData);
            if (bundleForFetchAd != null) {
                setBidId(bundleForFetchAd.getString("bid_identifier"));
                setHostname(bundleForFetchAd.getString("hostname_identifier"));
                setVideo(bundleForFetchAd.getBoolean("video_flag"));
            }
            setStartTime(new Date().getTime());
            ApsAdViewFetchUtils.INSTANCE.fetchAd(this, mraidHandler, adHtmlArg, extraData);
        }
        ApsMetrics.INSTANCE.adEvent(getBidId(), new ApsMetricsPerfEventModelBuilder().withBidId(getBidId()).withAdFetchStartTime(jCurrentTimeMillis));
    }

    public boolean detectAdClick(MotionEvent event) {
        if (getIsVideo() || event == null) {
            return false;
        }
        int action = event.getAction();
        long time = new Date().getTime();
        if (action != 0) {
            if (action == 1) {
                time = handleClick(event, time);
            } else {
                time = this.timePressed;
            }
        }
        this.timePressed = time;
        return false;
    }

    private final long handleClick(MotionEvent event, long time) {
        if (time - this.timeClicked < 1000) {
            return this.timePressed;
        }
        if (time - this.timePressed >= 500) {
            return 0L;
        }
        this.timeClicked = time;
        if (getMraidHandler() != null) {
            DTBAdMRAIDController mraidHandler = getMraidHandler();
            Intrinsics.checkNotNull(mraidHandler);
            mraidHandler.onAdClicked();
            return 0L;
        }
        APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.LOG, "Null controller instance onAdClick callback");
        return 0L;
    }

    public final void setIgnoreDetachment() {
        this.ignoreDetachment = true;
    }

    protected final void loadLocalFile(String filename, StringBuilder sb) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(sb, "sb");
        ApsAdViewFetchUtils.Companion companion = ApsAdViewFetchUtils.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.loadLocalFile(context, this.localOnly, filename, sb);
    }

    @Override // android.webkit.WebView
    public void loadUrl(final String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            ApsAdWebViewSupportClientBase apsAdWebViewSupportClientBase = this.webClient;
            if (apsAdWebViewSupportClientBase == null) {
                return;
            }
            if (apsAdWebViewSupportClientBase.getIsCrashed()) {
                ApsAdExtensionsKt.logEvent(this, APSEventSeverity.FATAL, APSEventType.LOG, Intrinsics.stringPlus("WebView is corrupted. loadUrl method will not be executed. URL:", url));
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.aps.ads.util.adview.ApsAdViewImpl$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ApsAdViewImpl.m4375loadUrl$lambda9$lambda8(this.f$0, url);
                    }
                });
            }
        } catch (RuntimeException e) {
            ApsAdExtensionsKt.logEvent(this, APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Failed to execute loadUrl method", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadUrl$lambda-9$lambda-8, reason: not valid java name */
    public static final void m4375loadUrl$lambda9$lambda8(ApsAdViewImpl this$0, String url) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        try {
            this$0.safedk_webview_ApsAdViewImpl_webviewLoadUrl_e3177bcd2c23ea94d3766e04b80fd51e(url);
        } catch (Exception e) {
            ApsAdExtensionsKt.logEvent(this$0, APSEventSeverity.FATAL, APSEventType.EXCEPTION, Intrinsics.stringPlus("WebView crash noticed during super.loadUrl method. URL:", url), e);
        }
    }

    @Override // com.amazon.aps.ads.util.adview.ApsWebBridgeListener
    public DTBAdMRAIDController getApsMraidHandler() {
        return getMraidHandler();
    }

    @Override // com.amazon.aps.ads.util.adview.ApsWebBridgeListener
    public void evaluateApsJavascript(final String script, final ValueCallback<String> resultCallback) {
        if (script == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.aps.ads.util.adview.ApsAdViewImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ApsAdViewImpl.m4373evaluateApsJavascript$lambda11$lambda10(this.f$0, script, resultCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: evaluateApsJavascript$lambda-11$lambda-10, reason: not valid java name */
    public static final void m4373evaluateApsJavascript$lambda11$lambda10(ApsAdViewImpl this$0, String str, ValueCallback valueCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.evaluateJavascript(str, valueCallback);
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdViewBase
    protected void onPositionChanged(Rect adViewRect) {
        Intrinsics.checkNotNullParameter(adViewRect, "adViewRect");
        DTBAdMRAIDController mraidHandler = getMraidHandler();
        if (mraidHandler == null) {
            return;
        }
        mraidHandler.onPositionChanged(adViewRect);
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdViewBase
    protected void setCurrentPositionProperty() {
        DTBAdMRAIDController mraidHandler = getMraidHandler();
        if (mraidHandler == null) {
            return;
        }
        mraidHandler.setCurrentPositionProperty();
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdViewBase
    protected void onAdOpened() {
        DTBAdMRAIDController mraidHandler = getMraidHandler();
        if (mraidHandler == null) {
            return;
        }
        mraidHandler.onAdOpened();
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdViewBase
    protected void onViewabilityChanged(boolean isChanged) {
        DTBAdMRAIDController mraidHandler = getMraidHandler();
        if (mraidHandler == null) {
            return;
        }
        mraidHandler.onViewabilityChanged(isChanged);
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdViewBase
    protected void onExposureChange(int exposurePercentage, Rect adViewRect) {
        Intrinsics.checkNotNullParameter(adViewRect, "adViewRect");
        DTBAdMRAIDController mraidHandler = getMraidHandler();
        if (mraidHandler == null) {
            return;
        }
        mraidHandler.fireExposureChange(exposurePercentage, adViewRect);
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdWebViewClientListener
    public void onPageLoaded() {
        DTBAdMRAIDController mraidHandler = getMraidHandler();
        if (mraidHandler == null) {
            return;
        }
        mraidHandler.onPageLoad();
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdWebViewClientListener
    public void onAdLeftApplication() {
        DTBAdMRAIDController mraidHandler = getMraidHandler();
        if (mraidHandler == null) {
            return;
        }
        mraidHandler.onAdLeftApplication();
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdWebViewClientListener
    public void onLoadError() {
        DTBAdMRAIDController mraidHandler = getMraidHandler();
        if (mraidHandler == null) {
            return;
        }
        mraidHandler.onLoadError();
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdWebViewClientListener
    public void onCrash(WebView webView, StringBuilder errorInfo, String errorDetail) {
        DtbOmSdkSessionManager omSdkManager;
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(errorInfo, "errorInfo");
        Intrinsics.checkNotNullParameter(errorDetail, "errorDetail");
        try {
            if (webView instanceof DTBAdView) {
                String userAgentString = ((DTBAdView) webView).getSettings().getUserAgentString();
                if (userAgentString != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str = String.format("webViewUserAgentInfo = %s;", Arrays.copyOf(new Object[]{userAgentString}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                    errorInfo.append(str);
                }
                if (getBidId() != null) {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String str2 = String.format("webViewBidId = %s;", Arrays.copyOf(new Object[]{getBidId()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                    errorInfo.append(str2);
                }
                onAdRemoved();
                if (getMraidHandler() != null && (omSdkManager = getOmSdkManager()) != null) {
                    omSdkManager.stopOmAdSession();
                }
                ViewParent parent = ((DTBAdView) webView).getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this);
                }
                DTBAdMRAIDController mraidHandler = getMraidHandler();
                if (mraidHandler != null) {
                    mraidHandler.onLoadError();
                    cleanup();
                }
                webView.removeAllViews();
            }
            String strSubstring = errorDetail.substring(0, Math.min(100, errorDetail.length()));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String str3 = String.format("webViewErrorDetail = %s", Arrays.copyOf(new Object[]{strSubstring}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
            errorInfo.append(str3);
            ApsAdExtensionsKt.logEvent(this, APSEventSeverity.FATAL, APSEventType.EXCEPTION, errorInfo.toString());
        } catch (RuntimeException e) {
            ApsAdExtensionsKt.logEvent(this, APSEventSeverity.FATAL, APSEventType.EXCEPTION, errorInfo.toString(), e);
        }
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdWebViewClientListener
    public Context getAdViewContext() {
        return this.adViewContext;
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdWebViewClientListener
    public void onPageFinished(String url, WebView view) {
        DtbOmSdkSessionManager omSdkManager;
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            ApsAdExtensionsKt.d(this, Intrinsics.stringPlus("Page finished:", url));
            if (view instanceof DTBAdView) {
                if (StringsKt.contains$default((CharSequence) url, (CharSequence) "MRAID_ENV", false, 2, (Object) null)) {
                    onPageLoaded();
                    return;
                }
                if (url.equals("https://c.amazon-adsystem.com/")) {
                    if ((getMraidHandler() instanceof DTBAdMRAIDBannerController) && (omSdkManager = getOmSdkManager()) != null) {
                        omSdkManager.stopOmAdSession();
                        if (getIsVideo()) {
                            omSdkManager.initJavaScriptOmAdSession(this, url);
                        } else {
                            omSdkManager.initHtmlDisplayOmAdSession(this, url);
                        }
                        omSdkManager.registerAdView(this);
                        omSdkManager.startAdSession();
                        if (!getIsVideo()) {
                            omSdkManager.displayAdEventLoaded();
                        }
                    }
                    onPageLoaded();
                }
            }
        } catch (RuntimeException e) {
            ApsAdExtensionsKt.logEvent(this, APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute onPageFinished method", e);
        }
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdWebViewClientListener
    public boolean isTwoPartExpand() {
        if (getMraidHandler() == null) {
            return false;
        }
        DTBAdMRAIDController mraidHandler = getMraidHandler();
        if (mraidHandler != null) {
            return mraidHandler.isTwoPartExpand();
        }
        throw new NullPointerException("null cannot be cast to non-null type com.amazon.device.ads.DTBAdMRAIDController");
    }
}
