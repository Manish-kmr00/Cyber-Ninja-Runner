package com.amazon.aps.ads.util.adview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.amazon.aps.ads.util.ApsAdExtensionsKt;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.amazon.device.ads.DTBAdView;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ApsAdWebViewSupportClient.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J&\u0010\u0014\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0017J\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u001d\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0004\n\u0002\b\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/amazon/aps/ads/util/adview/ApsAdWebViewSupportClient;", "Lcom/amazon/aps/ads/util/adview/ApsAdWebViewSupportClientBase;", "webviewClientListener", "Lcom/amazon/aps/ads/util/adview/ApsAdWebViewClientListener;", "(Lcom/amazon/aps/ads/util/adview/ApsAdWebViewClientListener;)V", "AMAZON_APP_STORE_LINK", "", "AMAZON_APP_STORE_LINK$1", "schemeHandler", "Lcom/amazon/aps/ads/util/adview/ApsAdWebViewSchemeHandler;", "createImageInjectionResponse", "Landroid/webkit/WebResourceResponse;", "jsScript", "matchesLocalInjectionUrl", "", "url", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "onRenderProcessGone", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "shouldInterceptRequest", "shouldOverrideUrlLoading", "Companion", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ApsAdWebViewSupportClient extends ApsAdWebViewSupportClientBase {
    public static final String AMAZON_APP_STORE_LINK = "https://www.amazon.com/gp/mas/dl/android?";
    public static final String AMAZON_SCHEME = "amzn";
    public static final String GOOGLE_PLAY_STORE_LINK = "https://play.google.com/store/apps/";
    public static final String MARKET_SCHEME = "market";
    public static final String MOBILE_SHOPPING_SCHEME = "com.amazon.mobile.shopping";
    public static final String MOBILE_SHOPPING_WEB_SCHEME = "com.amazon.mobile.shopping.web";

    /* JADX INFO: renamed from: AMAZON_APP_STORE_LINK$1, reason: from kotlin metadata */
    private final String AMAZON_APP_STORE_LINK;
    private final ApsAdWebViewSchemeHandler schemeHandler;
    private final ApsAdWebViewClientListener webviewClientListener;

    @Override // com.amazon.aps.ads.util.adview.ApsAdWebViewSupportClientBase, android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(h.A, view, url);
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdWebViewSupportClientBase, android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        Logger.d("AmazonPublisherServices|SafeDK: Execution> Lcom/amazon/aps/ads/util/adview/ApsAdWebViewSupportClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(h.A, view, url);
        safedk_ApsAdWebViewSupportClient_onPageFinished_29cbba74c68de4544e4d0559fe52f9d2(view, url);
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdWebViewSupportClientBase, android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted(h.A, view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        Logger.d("AmazonPublisherServices|SafeDK: Execution> Lcom/amazon/aps/ads/util/adview/ApsAdWebViewSupportClient;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
        BrandSafetyUtils.onWebViewReceivedError(h.A, view, request, error);
        safedk_ApsAdWebViewSupportClient_onReceivedError_df6497f05dc68dcf467c6473605f1bc9(view, request, error);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        Logger.d("AmazonPublisherServices|SafeDK: Execution> Lcom/amazon/aps/ads/util/adview/ApsAdWebViewSupportClient;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;");
        return CreativeInfoManager.onWebViewResponse(h.A, view, url, safedk_ApsAdWebViewSupportClient_shouldInterceptRequest_2d19ff974b73ab310e5fa1d634e6f061(view, url));
    }

    @Override // com.amazon.aps.ads.util.adview.ApsAdWebViewSupportClientBase, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Logger.d("AmazonPublisherServices|SafeDK: Execution> Lcom/amazon/aps/ads/util/adview/ApsAdWebViewSupportClient;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_ApsAdWebViewSupportClient_shouldOverrideUrlLoading_7f0ed92397371aad89e44a693d369e55 = safedk_ApsAdWebViewSupportClient_shouldOverrideUrlLoading_7f0ed92397371aad89e44a693d369e55(view, url);
        BrandSafetyUtils.onShouldOverrideUrlLoading(h.A, view, url, zSafedk_ApsAdWebViewSupportClient_shouldOverrideUrlLoading_7f0ed92397371aad89e44a693d369e55);
        return zSafedk_ApsAdWebViewSupportClient_shouldOverrideUrlLoading_7f0ed92397371aad89e44a693d369e55;
    }

    public ApsAdWebViewSupportClient(ApsAdWebViewClientListener webviewClientListener) {
        Intrinsics.checkNotNullParameter(webviewClientListener, "webviewClientListener");
        this.webviewClientListener = webviewClientListener;
        this.AMAZON_APP_STORE_LINK = AMAZON_APP_STORE_LINK;
        this.schemeHandler = new ApsAdWebViewSchemeHandler(webviewClientListener);
    }

    public WebResourceResponse safedk_ApsAdWebViewSupportClient_shouldInterceptRequest_2d19ff974b73ab310e5fa1d634e6f061(WebView p0, String p1) {
        try {
            ApsAdExtensionsKt.d(this, Intrinsics.stringPlus("Should intercept Resource url: ", p1));
            if (p1 != null && matchesLocalInjectionUrl(p1)) {
                String strSubstring = p1.substring(StringsKt.lastIndexOf$default((CharSequence) p1, '/', 0, false, 6, (Object) null) + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                return createImageInjectionResponse(strSubstring);
            }
            return super.shouldInterceptRequest(p0, p1);
        } catch (RuntimeException e) {
            ApsAdExtensionsKt.logEvent(this, APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute shouldInterceptRequest method", e);
            return null;
        }
    }

    public boolean safedk_ApsAdWebViewSupportClient_shouldOverrideUrlLoading_7f0ed92397371aad89e44a693d369e55(WebView p0, String p1) {
        if (p1 != null) {
            try {
                if (this.webviewClientListener.isTwoPartExpand()) {
                    return false;
                }
                return this.schemeHandler.openUrl(p1);
            } catch (RuntimeException e) {
                ApsAdExtensionsKt.logEvent(this, APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute shouldOverrideUrlLoading method", e);
            }
        }
        return false;
    }

    public void safedk_ApsAdWebViewSupportClient_onPageFinished_29cbba74c68de4544e4d0559fe52f9d2(WebView p0, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        ApsAdExtensionsKt.d(this, Intrinsics.stringPlus("Page load completed: ", url));
        this.webviewClientListener.onPageFinished(url, p0);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        String str;
        Intrinsics.checkNotNullParameter(detail, "detail");
        super.onRenderProcessGone(view, detail);
        setCrashed(true);
        ApsAdExtensionsKt.e(this, "WebView client crashed");
        StringBuilder sb = new StringBuilder("Fail to render ad due to webView crash.");
        if (view != null) {
            if (!(view instanceof DTBAdView)) {
                str = "";
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                str = String.format("Webview didCrash :%s , Webview rendererPriorityAtExit : %d", Arrays.copyOf(new Object[]{Boolean.valueOf(detail.didCrash()), Integer.valueOf(detail.rendererPriorityAtExit())}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            }
            this.webviewClientListener.onCrash(view, sb, str);
        }
        return true;
    }

    public void safedk_ApsAdWebViewSupportClient_onReceivedError_df6497f05dc68dcf467c6473605f1bc9(WebView p0, WebResourceRequest p1, WebResourceError p2) {
        super.onReceivedError(p0, p1, p2);
        ApsAdExtensionsKt.e(this, "WebView client received OnReceivedError");
        try {
            this.webviewClientListener.onLoadError();
        } catch (RuntimeException e) {
            ApsAdExtensionsKt.logEvent(this, APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute onReceivedError method", e);
        }
    }

    private final boolean matchesLocalInjectionUrl(String url) {
        try {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = url.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Uri uri = Uri.parse(lowerCase);
            if (uri == null) {
                return false;
            }
            return Intrinsics.areEqual("local", uri.getScheme());
        } catch (RuntimeException unused) {
            return false;
        }
    }

    private final WebResourceResponse createImageInjectionResponse(String jsScript) {
        try {
            InputStream inputStreamOpen = this.webviewClientListener.getAdViewContext().getAssets().open(jsScript);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "webviewClientListener.ad…ext.assets.open(jsScript)");
            return new WebResourceResponse("image/png", "UTF-8", inputStreamOpen);
        } catch (Exception e) {
            ApsAdExtensionsKt.logEvent(this, APSEventSeverity.ERROR, APSEventType.EXCEPTION, Intrinsics.stringPlus("Failed to get injection response: ", jsScript), e);
            return null;
        }
    }
}
