package com.pubmatic.sdk.monitor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.internal.AssetHelper;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.taskhandler.POBTaskHandler;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.PubMaticNetworkBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class POBMonitorWebView extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f7672a;
    public boolean isLoaded;

    class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f7673a;

        a(e eVar) {
            this.f7673a = eVar;
        }

        @Override // com.pubmatic.sdk.monitor.POBMonitorWebView.e
        public void a() {
            POBMonitorWebView.this.isLoaded = true;
            this.f7673a.a();
        }

        @Override // com.pubmatic.sdk.monitor.POBMonitorWebView.e
        public void b() {
            this.f7673a.b();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7674a;

        class a implements ValueCallback {
            a() {
            }

            @Override // android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
            }
        }

        b(String str) {
            this.f7674a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            POBMonitorWebView.this.evaluateJavascript(String.format("pmMonitor.broadcast('%s')", this.f7674a), new a());
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Context f7676a;

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ JSONObject f7677a;

            a(JSONObject jSONObject) {
                this.f7677a = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                POBMonitorWebView.a(c.this.f7676a, this.f7677a.optString("body", ""));
            }
        }

        /* synthetic */ c(Context context, a aVar) {
            this(context);
        }

        @JavascriptInterface
        public void nativeCall(String str) {
            JSONObject jSONObject;
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                if (!jSONObject2.optString("name", "").startsWith("share") || (jSONObject = jSONObject2.getJSONObject("params")) == null) {
                    return;
                }
                POBTaskHandler.getInstance().runOnMainThread(new a(jSONObject));
            } catch (JSONException e) {
                POBLog.debug("POBMonitorWebView", e.getLocalizedMessage(), new Object[0]);
            }
        }

        private c(Context context) {
            this.f7676a = context;
        }
    }

    private static class d extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        e f7678a;

        /* synthetic */ d(e eVar, a aVar) {
            this(eVar);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(h.F, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Logger.d("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/monitor/POBMonitorWebView$d;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewPageFinished(h.F, webView, str);
            safedk_POBMonitorWebView$d_onPageFinished_31d49df09c8a2f24289636733bc2bdc2(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            BrandSafetyUtils.onWebViewPageStarted(h.F, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            BrandSafetyUtils.onWebViewReceivedError(h.F, view, errorCode, description, failingUrl);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            POBLog.warn("POBMonitorWebView", "WebView Render process gone.", new Object[0]);
            this.f7678a.b();
            return true;
        }

        public void safedk_POBMonitorWebView$d_onPageFinished_31d49df09c8a2f24289636733bc2bdc2(WebView p0, String p1) {
            super.onPageFinished(p0, p1);
            this.f7678a.a();
        }

        public boolean safedk_POBMonitorWebView$d_shouldOverrideUrlLoading_1deae56c8840cf0a3f6227a2dcafe6e2(WebView p0, WebResourceRequest p1) {
            return super.shouldOverrideUrlLoading(p0, p1);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            return CreativeInfoManager.onWebViewResponseWithHeaders(h.F, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Logger.d("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/monitor/POBMonitorWebView$d;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z");
            boolean zSafedk_POBMonitorWebView$d_shouldOverrideUrlLoading_1deae56c8840cf0a3f6227a2dcafe6e2 = safedk_POBMonitorWebView$d_shouldOverrideUrlLoading_1deae56c8840cf0a3f6227a2dcafe6e2(webView, webResourceRequest);
            BrandSafetyUtils.onShouldOverrideUrlLoading(h.F, webView, webResourceRequest, zSafedk_POBMonitorWebView$d_shouldOverrideUrlLoading_1deae56c8840cf0a3f6227a2dcafe6e2);
            return zSafedk_POBMonitorWebView$d_shouldOverrideUrlLoading_1deae56c8840cf0a3f6227a2dcafe6e2;
        }

        private d(e eVar) {
            this.f7678a = eVar;
        }
    }

    interface e {
        void a();

        void b();
    }

    public POBMonitorWebView(Context context) {
        super(context);
        this.isLoaded = false;
        this.f7672a = new ArrayList();
    }

    static void a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
        intent.setFlags(268435456);
        try {
            safedk_POBUtils_startActivity_77a045103a3f673fe5e6fdc8c1e6b82c(context, intent);
        } catch (Exception e2) {
            POBLog.warn("POBMonitorWebView", "Unable to share data via intent. Error: %s", e2.getMessage());
        }
    }

    public static void safedk_POBUtils_startActivity_77a045103a3f673fe5e6fdc8c1e6b82c(Context p0, Intent p1) throws Exception {
        Logger.d("SafeDK-Special|SafeDK: Call> Lcom/pubmatic/sdk/common/utility/POBUtils;->startActivity(Landroid/content/Context;Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.F);
        POBUtils.startActivity(p0, p1);
    }

    public void appendData(JSONObject jSONObject) {
        String string = jSONObject.toString();
        if (!a(string)) {
            this.f7672a.add(string);
            return;
        }
        Iterator it = this.f7672a.iterator();
        while (it.hasNext()) {
            a((String) it.next());
            it.remove();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.F, this, me);
        return super.dispatchTouchEvent(me);
    }

    public void initWebView(e eVar) {
        getSettings().setJavaScriptEnabled(true);
        clearCache(true);
        clearHistory();
        a aVar = new a(eVar);
        a aVar2 = null;
        setWebViewClient(new d(aVar, aVar2));
        setWebChromeClient(new WebChromeClient());
        PubMaticNetworkBridge.onAddedJavascriptInterface(this, new c(getContext(), aVar2), "nativeBridge");
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    private boolean a(String str) {
        if (!this.isLoaded) {
            return false;
        }
        post(new b(str));
        return true;
    }
}
