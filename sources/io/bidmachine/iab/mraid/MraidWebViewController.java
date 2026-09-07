package io.bidmachine.iab.mraid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.common.base.Ascii;
import com.json.b9;
import com.json.sdk.controller.f;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.BidMachineNetworkBridge;
import com.safedk.android.utils.Logger;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.bridge.JsBridgeHandler;
import io.bidmachine.iab.utils.Utils;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class MraidWebViewController {
    public static final String TAG = "MraidWebViewController";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Callback f12218a;
    final MraidWebView b;
    private boolean c;
    private boolean d;
    private boolean e;
    private MraidOrientationProperties f;

    public interface Callback {
        void onCalendarEvent(String eventJson);

        void onClose();

        void onError(IabError iabError);

        void onExpand(String url);

        void onLoaded();

        void onOpen(String url);

        void onOpenPrivacySheet(String json);

        void onOrientation(MraidOrientationProperties orientationProperties);

        void onPageFinished(String url);

        void onPlayVideo(String url);

        void onResize(MraidResizeProperties resizeProperties);

        void onStorePicture(String url);

        void onUseCustomClose(boolean use);

        void onViewableChanged(boolean viewable);
    }

    class a implements MraidWebView.MraidWebViewListener {
        a() {
        }

        @Override // io.bidmachine.iab.mraid.MraidWebView.MraidWebViewListener
        public void onViewableChanged(boolean z) {
            if (MraidWebViewController.this.c) {
                MraidWebViewController.this.applyViewable(z);
            }
            MraidWebViewController.this.f12218a.onViewableChanged(z);
        }
    }

    private class b extends WebViewClient {
        private b() {
        }

        private WebResourceResponse a() {
            String strB = MraidUtils.b();
            Charset charset = StandardCharsets.UTF_8;
            return new WebResourceResponse(POBCommonConstants.CONTENT_TYPE_JAVASCRIPT, charset.name(), new ByteArrayInputStream(strB.getBytes(charset)));
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded("io.bidmachine", view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Logger.d("BidMachine|SafeDK: Execution> Lio/bidmachine/iab/mraid/MraidWebViewController$b;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewPageFinished("io.bidmachine", webView, str);
            safedk_MraidWebViewController$b_onPageFinished_e2cc48465f4b606374da32ca39333c9f(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Logger.d("BidMachine|SafeDK: Execution> Lio/bidmachine/iab/mraid/MraidWebViewController$b;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
            BrandSafetyUtils.onWebViewPageStarted("io.bidmachine", webView, str);
            safedk_MraidWebViewController$b_onPageStarted_30055bcb5b79239473faf332dfb0f4dd(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Logger.d("BidMachine|SafeDK: Execution> Lio/bidmachine/iab/mraid/MraidWebViewController$b;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewReceivedError("io.bidmachine", webView, i, str, str2);
            safedk_MraidWebViewController$b_onReceivedError_f9d73168955d6bdc42cadf42f414e25f(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Logger.d("BidMachine|SafeDK: Execution> Lio/bidmachine/iab/mraid/MraidWebViewController$b;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
            BrandSafetyUtils.onWebViewReceivedError("io.bidmachine", webView, webResourceRequest, webResourceError);
            safedk_MraidWebViewController$b_onReceivedError_ba7fb2e7d7514c5d835c60190d597943(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            MraidLog.d(MraidWebViewController.TAG, "onRenderProcessGone", new Object[0]);
            MraidWebViewController.this.destroy();
            MraidWebViewController.this.f12218a.onError(IabError.internal("WebViewClient - onRenderProcessGone"));
            return true;
        }

        public void safedk_MraidWebViewController$b_onPageFinished_e2cc48465f4b606374da32ca39333c9f(WebView p0, String p1) {
            super.onPageFinished(p0, p1);
            MraidLog.d(MraidWebViewController.TAG, "onPageFinished", new Object[0]);
            if (MraidWebViewController.this.c) {
                return;
            }
            MraidWebViewController.this.c = true;
            MraidWebViewController.this.f12218a.onPageFinished(p1);
            MraidWebViewController.this.getWebView().onPageFinished();
        }

        public void safedk_MraidWebViewController$b_onPageStarted_30055bcb5b79239473faf332dfb0f4dd(WebView p0, String p1, Bitmap p2) {
            super.onPageStarted(p0, p1, p2);
            MraidLog.d(MraidWebViewController.TAG, "onPageStarted", new Object[0]);
        }

        public void safedk_MraidWebViewController$b_onReceivedError_f9d73168955d6bdc42cadf42f414e25f(WebView p0, int p1, String p2, String p3) {
            a(p3, p2, p1);
            super.onReceivedError(p0, p1, p2, p3);
        }

        public WebResourceResponse safedk_MraidWebViewController$b_shouldInterceptRequest_70371e720b5f85f4d885541ae7b04fd8(WebView p0, WebResourceRequest p1) {
            return a(p1.getUrl()) ? a() : super.shouldInterceptRequest(p0, p1);
        }

        public boolean safedk_MraidWebViewController$b_shouldOverrideUrlLoading_b4596206bcc70fc15c09a1adb02f299f(WebView p0, String p1) {
            if (p1.startsWith("mraid://")) {
                MraidWebViewController.this.a(p1);
                return true;
            }
            if (JsBridgeHandler.isHandled(p1)) {
                JsBridgeHandler.handleJsCommand(MraidWebViewController.this.b, p1);
                return true;
            }
            MraidWebViewController.this.c(p1);
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            Logger.d("BidMachine|SafeDK: Execution> Lio/bidmachine/iab/mraid/MraidWebViewController$b;->shouldInterceptRequest(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;");
            return CreativeInfoManager.onWebViewResponseWithHeaders("io.bidmachine", webView, webResourceRequest, safedk_MraidWebViewController$b_shouldInterceptRequest_70371e720b5f85f4d885541ae7b04fd8(webView, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            Logger.d("BidMachine|SafeDK: Execution> Lio/bidmachine/iab/mraid/MraidWebViewController$b;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;");
            return CreativeInfoManager.onWebViewResponse("io.bidmachine", webView, str, safedk_MraidWebViewController$b_shouldInterceptRequest_f9a37b326fb6782bea01bbc53ca95772(webView, str));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger.d("BidMachine|SafeDK: Execution> Lio/bidmachine/iab/mraid/MraidWebViewController$b;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
            boolean zSafedk_MraidWebViewController$b_shouldOverrideUrlLoading_b4596206bcc70fc15c09a1adb02f299f = safedk_MraidWebViewController$b_shouldOverrideUrlLoading_b4596206bcc70fc15c09a1adb02f299f(webView, str);
            BrandSafetyUtils.onShouldOverrideUrlLoading("io.bidmachine", webView, str, zSafedk_MraidWebViewController$b_shouldOverrideUrlLoading_b4596206bcc70fc15c09a1adb02f299f);
            return zSafedk_MraidWebViewController$b_shouldOverrideUrlLoading_b4596206bcc70fc15c09a1adb02f299f;
        }

        /* synthetic */ b(MraidWebViewController mraidWebViewController, a aVar) {
            this();
        }

        private void a(String str, String str2, int i) {
            MraidLog.d(MraidWebViewController.TAG, "onError: %s / %s / %d", str, str2, Integer.valueOf(i));
            if (str2 == null || !str2.contains("ERR_INTERNET_DISCONNECTED")) {
                return;
            }
            MraidWebViewController.this.e = true;
        }

        public void safedk_MraidWebViewController$b_onReceivedError_ba7fb2e7d7514c5d835c60190d597943(WebView p0, WebResourceRequest p1, WebResourceError p2) {
            Uri url = p1.getUrl();
            a(url != null ? url.toString() : null, p2.getDescription().toString(), p2.getErrorCode());
            super.onReceivedError(p0, p1, p2);
        }

        public WebResourceResponse safedk_MraidWebViewController$b_shouldInterceptRequest_f9a37b326fb6782bea01bbc53ca95772(WebView p0, String p1) {
            return a(p1) ? a() : super.shouldInterceptRequest(p0, p1);
        }

        boolean a(Uri uri) {
            return "mraid.js".equals(uri.getLastPathSegment());
        }

        boolean a(String str) {
            return a(Uri.parse(str.toLowerCase(Locale.US)));
        }
    }

    public MraidWebViewController(Context context, Callback callback) {
        this.f12218a = callback;
        MraidWebView mraidWebView = new MraidWebView(context);
        this.b = mraidWebView;
        mraidWebView.setWebViewClient(new b(this, null));
        mraidWebView.setListener(new a());
        this.d = false;
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (!this.b.wasClicked()) {
            MraidLog.d(TAG, "Can't open url because webView wasn't clicked", new Object[0]);
        } else {
            this.f12218a.onOpen(str);
            this.b.resetClicked();
        }
    }

    public void applyClick(int x, int y) {
        b(String.format("(function click(x, y) {var ev = new MouseEvent('click', {    'view': window,    'bubbles': true,    'cancelable': true,    'screenX': x,    'screenY': y});var el = document.elementFromPoint(x, y);if (el !== null) {      el.dispatchEvent(ev); }})(%s, %s)", Integer.valueOf(x), Integer.valueOf(y)));
    }

    public void applyLogLevel(io.bidmachine.iab.utils.Logger.LogLevel level) {
        String str;
        if (level == io.bidmachine.iab.utils.Logger.LogLevel.debug) {
            str = "mraid.logLevel = mraid.LogLevelEnum.DEBUG;";
        } else if (level == io.bidmachine.iab.utils.Logger.LogLevel.info) {
            str = "mraid.logLevel = mraid.LogLevelEnum.INFO;";
        } else if (level == io.bidmachine.iab.utils.Logger.LogLevel.warning) {
            str = "mraid.logLevel = mraid.LogLevelEnum.WARNING;";
        } else if (level == io.bidmachine.iab.utils.Logger.LogLevel.error) {
            str = "mraid.logLevel = mraid.LogLevelEnum.ERROR;";
        } else if (level != io.bidmachine.iab.utils.Logger.LogLevel.none) {
            return;
        } else {
            str = "mraid.logLevel = mraid.LogLevelEnum.NONE;";
        }
        b(str);
    }

    public void applyPlacement(MraidPlacementType placement) {
        b("mraid.setPlacementType('" + placement.b() + "');");
    }

    public void applyScreenMetrics(MraidScreenMetrics screenMetrics) {
        Rect rectE = screenMetrics.e();
        Rect rectD = screenMetrics.d();
        b("mraid.setScreenSize(" + rectE.width() + StringUtils.COMMA + rectE.height() + ");mraid.setMaxSize(" + rectD.width() + StringUtils.COMMA + rectD.height() + ");mraid.setCurrentPosition(" + Utils.stringifyRect(screenMetrics.a()) + ");mraid.setDefaultPosition(" + Utils.stringifyRect(screenMetrics.c()) + ");mraid.fireSizeChangeEvent(" + Utils.stringifySize(screenMetrics.a()) + ");");
    }

    public void applyState(MraidViewState state) {
        b("mraid.fireStateChangeEvent('" + state.toJsString() + "');");
    }

    public void applySupportedServices(MraidNativeFeatureManager nativeFeatureManager) {
        b("mraid.setSupports(mraid.SUPPORTED_FEATURES.CALENDAR, " + nativeFeatureManager.isCalendarFeatureAvailable() + ");mraid.setSupports(mraid.SUPPORTED_FEATURES.INLINEVIDEO, " + nativeFeatureManager.isInlineVideoFeatureAvailable() + ");mraid.setSupports(mraid.SUPPORTED_FEATURES.SMS, " + nativeFeatureManager.isSmsFeatureAvailable() + ");mraid.setSupports(mraid.SUPPORTED_FEATURES.STOREPICTURE, " + nativeFeatureManager.isStorePictureFeatureAvailable() + ");mraid.setSupports(mraid.SUPPORTED_FEATURES.TEL, " + nativeFeatureManager.isTelFeatureAvailable() + ");");
    }

    public void applyViewable(boolean viewable) {
        b("mraid.fireViewableChangeEvent(" + viewable + ");");
    }

    public void destroy() {
        MraidWebView webView = getWebView();
        Utils.removeFromParent(webView);
        webView.destroy();
    }

    public MraidOrientationProperties getLastOrientationProperties() {
        return this.f;
    }

    public MraidWebView getWebView() {
        return this.b;
    }

    public boolean isReceivedJsError() {
        return this.e;
    }

    public boolean isUseCustomClose() {
        return this.d;
    }

    public boolean isViewable() {
        return this.b.isViewable();
    }

    public void load(String url) {
        this.c = false;
        BidMachineNetworkBridge.webviewLoadUrl(getWebView(), url);
    }

    public void notifyReady() {
        b("mraid.fireReadyEvent();");
    }

    public void reset() {
        getWebView().reset();
    }

    public void load(String baseUrl, String data, String mimeType, String encoding) {
        this.c = false;
        BidMachineNetworkBridge.webviewLoadDataWithBaseURL(getWebView(), baseUrl, data, mimeType, encoding, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        MraidLog.d(TAG, "handleJsCommand - %s", str);
        try {
            Map<String, String> commandUrl = MraidUtils.parseCommandUrl(str);
            if (commandUrl == null) {
                return;
            }
            String str2 = commandUrl.get(f.b.COMMAND);
            if (str2 == null) {
                MraidLog.w(TAG, "handleJsCommand not found", new Object[0]);
            } else {
                a(str2, commandUrl);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    void b(String str) {
        this.b.injectJs(str);
    }

    private void a() {
        b("mraid.nativeCallComplete();");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void a(String str, Map map) {
        str.hashCode();
        str.hashCode();
        byte b2 = -1;
        switch (str.hashCode()) {
            case -1886160473:
                if (str.equals(MraidJsMethods.PLAY_VIDEO)) {
                    b2 = 0;
                }
                break;
            case -1700226527:
                if (str.equals(MraidUtils.COMMAND_OPEN_PRIVACY_SHEET)) {
                    b2 = 1;
                }
                break;
            case -1289167206:
                if (str.equals("expand")) {
                    b2 = 2;
                }
                break;
            case -1097519099:
                if (str.equals(b9.h.r)) {
                    b2 = 3;
                }
                break;
            case -1041060124:
                if (str.equals("noFill")) {
                    b2 = 4;
                }
                break;
            case -934437708:
                if (str.equals("resize")) {
                    b2 = 5;
                }
                break;
            case -733616544:
                if (str.equals("createCalendarEvent")) {
                    b2 = 6;
                }
                break;
            case 3417674:
                if (str.equals("open")) {
                    b2 = 7;
                }
                break;
            case 94756344:
                if (str.equals("close")) {
                    b2 = 8;
                }
                break;
            case 133423073:
                if (str.equals("setOrientationProperties")) {
                    b2 = 9;
                }
                break;
            case 459238621:
                if (str.equals("storePicture")) {
                    b2 = 10;
                }
                break;
            case 1614272768:
                if (str.equals(MraidJsMethods.USE_CUSTOM_CLOSE)) {
                    b2 = Ascii.VT;
                }
                break;
        }
        switch (b2) {
            case 0:
                this.f12218a.onPlayVideo((String) map.get("url"));
                break;
            case 1:
                String str2 = (String) map.get("data");
                if (TextUtils.isEmpty(str2)) {
                    MraidLog.e(TAG, "data is null or empty", new Object[0]);
                } else {
                    try {
                        this.f12218a.onOpenPrivacySheet(new String(Base64.decode(str2, 2)));
                    } catch (Throwable unused) {
                        MraidLog.e(TAG, "data must be base64 encoded json", new Object[0]);
                        return;
                    }
                }
                break;
            case 2:
                MraidLog.d(TAG, "mraid.expand is not supported", new Object[0]);
                break;
            case 3:
                this.f12218a.onLoaded();
                break;
            case 4:
                this.f12218a.onError(IabError.noFIll("Fired noFill event from mraid.js"));
                break;
            case 5:
                MraidLog.d(TAG, "mraid.resize is not supported", new Object[0]);
                break;
            case 6:
                this.f12218a.onCalendarEvent((String) map.get("eventJSON"));
                break;
            case 7:
                String str3 = (String) map.get("url");
                if (!TextUtils.isEmpty(str3)) {
                    c(str3);
                } else {
                    MraidLog.e(TAG, "url is null or empty", new Object[0]);
                }
                break;
            case 8:
                this.f12218a.onClose();
                break;
            case 9:
                MraidOrientationProperties mraidOrientationProperties = new MraidOrientationProperties(Boolean.parseBoolean((String) map.get("allowOrientationChange")), MraidOrientationProperties.forceOrientationFromString((String) map.get("forceOrientation")));
                this.f = mraidOrientationProperties;
                this.f12218a.onOrientation(mraidOrientationProperties);
                break;
            case 10:
                this.f12218a.onStorePicture((String) map.get("url"));
                break;
            case 11:
                boolean z = Boolean.parseBoolean((String) map.get(MraidJsMethods.USE_CUSTOM_CLOSE));
                if (this.d != z) {
                    this.d = z;
                    this.f12218a.onUseCustomClose(z);
                }
                break;
        }
    }
}
