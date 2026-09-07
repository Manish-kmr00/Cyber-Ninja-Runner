package net.pubnative.lite.sdk.consent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.VerveNetworkBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import net.pubnative.lite.sdk.HyBid;

/* JADX INFO: loaded from: classes5.dex */
public class UserConsentActivity extends Activity {
    private static final String REDIRECT_ACCEPT = "https://cdn.pubnative.net/static/consent/GDPR-consent-dialog-accept.html";
    private static final String REDIRECT_CLOSE = "https://pubnative.net/";
    private static final String REDIRECT_REJECT = "https://cdn.pubnative.net/static/consent/GDPR-consent-dialog-reject.html";
    public static final int RESULT_CONSENT_ACCEPTED = 200;
    public static final int RESULT_CONSENT_REJECTED = 201;
    private static final String TAG = "UserConsentActivity";
    private final WebViewClient webViewClient = new WebViewClient() { // from class: net.pubnative.lite.sdk.consent.UserConsentActivity.1
        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(h.C, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Logger.d("Verve|SafeDK: Execution> Lnet/pubnative/lite/sdk/consent/UserConsentActivity$1;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewPageFinished(h.C, webView, str);
            safedk_UserConsentActivity$1_onPageFinished_b1f554cf2b3522a65a72c46de8e72931(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Logger.d("Verve|SafeDK: Execution> Lnet/pubnative/lite/sdk/consent/UserConsentActivity$1;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
            BrandSafetyUtils.onWebViewPageStarted(h.C, webView, str);
            safedk_UserConsentActivity$1_onPageStarted_6b56eef99e8990333a1048880580febd(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            BrandSafetyUtils.onWebViewReceivedError(h.C, view, errorCode, description, failingUrl);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            return CreativeInfoManager.onWebViewResponseWithHeaders(h.C, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger.d("Verve|SafeDK: Execution> Lnet/pubnative/lite/sdk/consent/UserConsentActivity$1;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
            boolean zSafedk_UserConsentActivity$1_shouldOverrideUrlLoading_5aa5802cbb0fd3a276d73154983e7527 = safedk_UserConsentActivity$1_shouldOverrideUrlLoading_5aa5802cbb0fd3a276d73154983e7527(webView, str);
            BrandSafetyUtils.onShouldOverrideUrlLoading(h.C, webView, str, zSafedk_UserConsentActivity$1_shouldOverrideUrlLoading_5aa5802cbb0fd3a276d73154983e7527);
            return zSafedk_UserConsentActivity$1_shouldOverrideUrlLoading_5aa5802cbb0fd3a276d73154983e7527;
        }

        public void safedk_UserConsentActivity$1_onPageStarted_6b56eef99e8990333a1048880580febd(WebView p0, String p1, Bitmap p2) {
            super.onPageStarted(p0, p1, p2);
        }

        public void safedk_UserConsentActivity$1_onPageFinished_b1f554cf2b3522a65a72c46de8e72931(WebView p0, String p1) {
            super.onPageFinished(p0, p1);
        }

        public boolean safedk_UserConsentActivity$1_shouldOverrideUrlLoading_5aa5802cbb0fd3a276d73154983e7527(WebView p0, String p1) {
            p1.hashCode();
            switch (p1) {
                case "https://pubnative.net/":
                    UserConsentActivity.this.finish();
                    return false;
                case "https://cdn.pubnative.net/static/consent/GDPR-consent-dialog-accept.html":
                    HyBid.getUserDataManager().grantConsent();
                    UserConsentActivity.this.setResult(200);
                    return false;
                case "https://cdn.pubnative.net/static/consent/GDPR-consent-dialog-reject.html":
                    HyBid.getUserDataManager().denyConsent();
                    UserConsentActivity.this.setResult(201);
                    return false;
                default:
                    return super.shouldOverrideUrlLoading(p0, p1);
            }
        }
    };

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.C, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WebView webView = new WebView(this);
        setupWebView(webView);
        loadConsentPage(webView);
    }

    private void setupWebView(WebView webView) {
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setLoadWithOverviewMode(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        webView.setWebViewClient(this.webViewClient);
        setContentView(webView, new FrameLayout.LayoutParams(-1, -1));
    }

    private void loadConsentPage(WebView webView) {
        if (HyBid.isInitialized() && HyBid.getUserDataManager() != null) {
            String consentPageLink = HyBid.getUserDataManager().getConsentPageLink();
            if (TextUtils.isEmpty(consentPageLink)) {
                net.pubnative.lite.sdk.utils.Logger.e(TAG, "Invalid consent page URL. Dropping call.");
                finish();
                return;
            } else {
                VerveNetworkBridge.webviewLoadUrl(webView, consentPageLink);
                return;
            }
        }
        net.pubnative.lite.sdk.utils.Logger.e(TAG, "HyBid SDK has not been initialised yet. Dropping call.");
        finish();
    }
}
