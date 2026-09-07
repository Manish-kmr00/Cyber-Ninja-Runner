package com.json;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.json.mediationsdk.logger.IronLog;
import com.json.sdk.controller.OpenUrlActivity;
import com.json.sdk.controller.k;
import com.json.sdk.utils.Logger;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import com.safedk.android.utils.h;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class ah implements vh {
    private static final String g = "loadWithUrl | webView is not null";
    private static final String h = "ah";
    private static final String i = "file://";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3520a;
    private String b;
    private WebView c;
    private yg d;
    private tg e;
    private Context f;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3521a;
        final /* synthetic */ JSONObject b;
        final /* synthetic */ String c;

        a(String str, JSONObject jSONObject, String str2) {
            this.f3521a = str;
            this.b = jSONObject;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ah.this.c != null) {
                lh.a(er.q, new gh().a(cc.A, ah.g).a());
            }
            try {
                ah.this.b(this.f3521a);
                IronSourceNetworkBridge.webviewLoadUrl(ah.this.c, ah.this.a(this.b.getString("urlForWebView")));
                JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
                jSONObjectJsonObjectInit.put("adViewId", ah.this.f3520a);
                ah.this.d.a(this.c, jSONObjectJsonObjectInit);
            } catch (Exception e) {
                o9.d().a(e);
                ah.this.b(this.f3521a, e.getMessage());
                lh.a(er.q, new gh().a(cc.A, e.getMessage()).a());
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3522a;
        final /* synthetic */ String b;

        b(String str, String str2) {
            this.f3522a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (ah.this.c != null) {
                    ah.this.c.destroy();
                }
                JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
                jSONObjectJsonObjectInit.put("adViewId", ah.this.f3520a);
                if (ah.this.d != null) {
                    ah.this.d.a(this.f3522a, jSONObjectJsonObjectInit);
                    ah.this.d.b();
                }
                ah.this.d = null;
                ah.this.f = null;
            } catch (Exception e) {
                o9.d().a(e);
                Log.e(ah.h, "performCleanup | could not destroy ISNAdView webView ID: " + ah.this.f3520a);
                lh.a(er.r, new gh().a(cc.A, e.getMessage()).a());
                ah.this.b(this.b, e.getMessage());
            }
        }
    }

    class c implements vh.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3523a;

        c(String str) {
            this.f3523a = str;
        }

        @Override // com.ironsource.vh.a
        public void a(String str) {
            Logger.i(ah.h, "ISNAdViewWebPresenter | WebViewClient | reportOnError: " + str);
            ah.this.b(this.f3523a, str);
        }

        @Override // com.ironsource.vh.a
        public void b(String str) {
            Logger.i(ah.h, "ISNAdViewWebPresenter | WebViewClient | onRenderProcessGone: " + str);
            try {
                ((ViewGroup) ah.this.c.getParent()).removeView(ah.this.c);
            } catch (Exception e) {
                o9.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
            ah.this.e();
        }
    }

    private class d extends WebChromeClient {
        private d() {
        }

        /* synthetic */ d(ah ahVar, a aVar) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            com.safedk.android.utils.Logger.d("IronSource|SafeDK: Execution> Lcom/ironsource/ah$d;->onCreateWindow(Landroid/webkit/WebView;ZZLandroid/os/Message;)Z");
            boolean zSafedk_ah$d_onCreateWindow_075ba65d92d76d4f6ad4cd7aae074d5c = safedk_ah$d_onCreateWindow_075ba65d92d76d4f6ad4cd7aae074d5c(webView, z, z2, message);
            BrandSafetyUtils.onWebChromeClientCreateWindow(h.f, webView, message, zSafedk_ah$d_onCreateWindow_075ba65d92d76d4f6ad4cd7aae074d5c);
            return zSafedk_ah$d_onCreateWindow_075ba65d92d76d4f6ad4cd7aae074d5c;
        }

        public boolean safedk_ah$d_onCreateWindow_075ba65d92d76d4f6ad4cd7aae074d5c(WebView p0, boolean p1, boolean p2, Message p3) {
            WebView webView = new WebView(p0.getContext());
            webView.setWebChromeClient(ah.this.new d());
            webView.setWebViewClient(new e(ah.this, null));
            ((WebView.WebViewTransport) p3.obj).setWebView(webView);
            p3.sendToTarget();
            Logger.i("onCreateWindow", "onCreateWindow");
            return true;
        }
    }

    private class e extends WebViewClient {
        private e() {
        }

        /* synthetic */ e(ah ahVar, a aVar) {
            this();
        }

        public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
            com.safedk.android.utils.Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
            if (p1 == null) {
                return;
            }
            BrandSafetyUtils.detectAdClick(p1, h.f);
            p0.startActivity(p1);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(h.f, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            BrandSafetyUtils.onWebViewPageFinished(h.f, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            BrandSafetyUtils.onWebViewPageStarted(h.f, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            BrandSafetyUtils.onWebViewReceivedError(h.f, view, errorCode, description, failingUrl);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Logger.e(ah.h, "Chromium process crashed - detail.didCrash(): " + renderProcessGoneDetail.didCrash());
            return true;
        }

        public boolean safedk_ah$e_shouldOverrideUrlLoading_ad7532e2555c800d0b8b49bea75c58d0(WebView p0, String p1) {
            Context context = p0.getContext();
            Intent intentA = new OpenUrlActivity.e(new k.b()).a(p1).b(false).a(context);
            intentA.addFlags(268435456);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intentA);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            return CreativeInfoManager.onWebViewResponseWithHeaders(h.f, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            com.safedk.android.utils.Logger.d("IronSource|SafeDK: Execution> Lcom/ironsource/ah$e;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
            boolean zSafedk_ah$e_shouldOverrideUrlLoading_ad7532e2555c800d0b8b49bea75c58d0 = safedk_ah$e_shouldOverrideUrlLoading_ad7532e2555c800d0b8b49bea75c58d0(webView, str);
            BrandSafetyUtils.onShouldOverrideUrlLoading(h.f, webView, str, zSafedk_ah$e_shouldOverrideUrlLoading_ad7532e2555c800d0b8b49bea75c58d0);
            return zSafedk_ah$e_shouldOverrideUrlLoading_ad7532e2555c800d0b8b49bea75c58d0;
        }
    }

    public ah(wg wgVar, Context context, String str, tg tgVar) {
        this.f = context;
        yg ygVar = new yg();
        this.d = ygVar;
        ygVar.g(str);
        this.f3520a = str;
        this.d.a(wgVar);
        this.e = tgVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return c(str) ? "file://" + this.b + d(str) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Logger.i(h, "ISNAdViewWebPresenter | createWebView");
        WebView webView = new WebView(this.f);
        this.c = webView;
        IronSourceNetworkBridge.onAddedJavascriptInterface(webView, new xg(this), ug.e);
        this.c.setWebViewClient(new zg(new c(str)));
        this.c.setWebChromeClient(new d(this, null));
        kw.a(this.c);
        this.d.a(this.c);
    }

    private boolean c(String str) {
        return str.startsWith(".");
    }

    private String d(String str) {
        String strSubstring = str.substring(str.indexOf(RemoteSettings.FORWARD_SLASH_STRING) + 1);
        return strSubstring.substring(strSubstring.indexOf(RemoteSettings.FORWARD_SLASH_STRING));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        a("", "");
    }

    @Override // com.json.vh
    public synchronized void a(String str, String str2) {
        if (this.f == null) {
            return;
        }
        Logger.i(h, "performCleanup");
        hg.f3748a.d(new b(str, str2));
    }

    @Override // com.json.vh
    public void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            b(str3, b9.c.D);
            return;
        }
        Logger.i(h, "trying to perform WebView Action: " + str);
        try {
            if (str.equals(b9.h.t0)) {
                this.c.onPause();
            } else {
                if (!str.equals(b9.h.u0)) {
                    b(str3, b9.c.C);
                    return;
                }
                this.c.onResume();
            }
            this.d.f(str2);
        } catch (Exception e2) {
            o9.d().a(e2);
            b(str3, b9.c.E);
        }
    }

    @Override // com.json.vh
    public void a(JSONObject jSONObject, String str, String str2) {
        try {
            this.d.e(str);
        } catch (Exception e2) {
            o9.d().a(e2);
            Logger.i(h, "sendHandleGetViewVisibility fail with reason: " + e2.getMessage());
        }
    }

    public String b() {
        return this.f3520a;
    }

    public void b(String str, String str2) {
        yg ygVar = this.d;
        if (ygVar != null) {
            ygVar.a(str, str2);
        }
    }

    @Override // com.json.vh
    public void b(JSONObject jSONObject, String str, String str2) {
        hg.f3748a.d(new a(str2, jSONObject, str));
    }

    public yg c() {
        return this.d;
    }

    @Override // com.json.vh
    public void c(JSONObject jSONObject, String str, String str2) throws JSONException {
        try {
            this.d.a(jSONObject.getString("params"), str, str2);
        } catch (Exception e2) {
            o9.d().a(e2);
            Logger.i(h, "sendMessageToAd fail message: " + e2.getMessage());
            throw e2;
        }
    }

    public tg d() {
        return this.e;
    }

    public void e(String str) {
        this.b = str;
    }

    @Override // com.json.vh
    public WebView getPresentingView() {
        return this.c;
    }

    @JavascriptInterface
    public void handleMessageFromAd(String str) {
        this.d.c(str);
    }
}
