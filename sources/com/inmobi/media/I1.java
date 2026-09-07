package com.inmobi.media;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class I1 extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L4 f3093a;
    public boolean c;
    public boolean d;
    public int b = -1;
    public final AtomicBoolean e = new AtomicBoolean(false);

    public I1(L4 l4) {
        this.f3093a = l4;
    }

    public final void a(WebView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.e.set(true);
        view.postDelayed(new Runnable() { // from class: com.inmobi.media.I1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                I1.a(this.f$0);
            }
        }, 1000L);
    }

    public final void b(WebView webView) {
        J j;
        String strB;
        String str;
        J j2;
        String strM;
        D0 d0;
        int i = this.b;
        if (-1 != i) {
            if (i > 0) {
                this.b = i - 1;
                return;
            }
            if (this.c) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new N8(webView));
            this.c = true;
            if (webView instanceof Ba) {
                Ba ba = (Ba) webView;
                L4 l4 = ba.i;
                if (l4 != null) {
                    String str2 = Ba.O0;
                    ((M4) l4).a(str2, AbstractC3474ma.a(ba, str2, "TAG", "sendTelemetryEventForNetworkLoad "));
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String creativeId = ba.getCreativeId();
                if (creativeId != null) {
                    linkedHashMap.put("creativeId", creativeId);
                }
                String impressionId = ba.getImpressionId();
                if (impressionId != null) {
                    linkedHashMap.put("impressionId", impressionId);
                }
                linkedHashMap.put("errorCode", Short.valueOf(ba.p0 ? (short) 2212 : (short) 2211));
                Ea ea = ba.h;
                if (ea != null && (d0 = ea.i) != null) {
                    linkedHashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - d0.f3044a.c));
                }
                Ea ea2 = ba.h;
                if (ea2 != null && (j2 = ea2.f3060a) != null && (strM = j2.m()) != null) {
                    linkedHashMap.put("plType", strM);
                }
                Ea ea3 = ba.h;
                if (ea3 != null) {
                    linkedHashMap.put("creativeType", ea3.e);
                }
                Ea ea4 = ba.h;
                if (ea4 != null && (str = ea4.b) != null) {
                    linkedHashMap.put("markupType", str);
                }
                Ea ea5 = ba.h;
                if (ea5 != null && (j = ea5.f3060a) != null && (strB = j.b()) != null) {
                    linkedHashMap.put(com.smaato.sdk.video.vast.model.Ad.AD_TYPE, strB);
                }
                Ea ea6 = ba.h;
                if (ea6 != null) {
                    linkedHashMap.put("metadataBlob", ea6.c);
                }
                Ea ea7 = ba.h;
                if (ea7 != null) {
                    linkedHashMap.put("isRewarded", Boolean.valueOf(ea7.g));
                }
                L4 l5 = ba.i;
                if (l5 != null) {
                    String str3 = Ba.O0;
                    ((M4) l5).a(str3, AbstractC3474ma.a(ba, str3, "TAG", "processTelemetryEvent "));
                }
                ba.getListener().a("NetworkLoadLimitExceeded", linkedHashMap);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.i, view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/I1;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.i, webView, str);
        safedk_I1_onPageFinished_a935d2215939582490e55eb6fbc050b4(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.i, view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.i, view, errorCode, description, failingUrl);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(detail, "detail");
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        AbstractC3498o6.a((byte) 1, "BaseWebViewClient", "WebView crash detected, destroying ad");
        view.destroy();
        return true;
    }

    public void safedk_I1_onPageFinished_a935d2215939582490e55eb6fbc050b4(WebView p0, String p1) {
        if (this.d) {
            this.d = false;
            if (p0 != null) {
                p0.clearHistory();
            }
        }
        super.onPageFinished(p0, p1);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/I1;->shouldInterceptRequest(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;");
        return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.i, webView, webResourceRequest, safedk_I1_shouldInterceptRequest_873a0b008f9283eaadf0252b61398bda(webView, webResourceRequest));
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/I1;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;");
        return CreativeInfoManager.onWebViewResponse(com.safedk.android.utils.h.i, webView, str, safedk_I1_shouldInterceptRequest_17b448be02a51e536f5b6565c7bf9bb1(webView, str));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        boolean zShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(view, url);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.i, view, url, zShouldOverrideUrlLoading);
        return zShouldOverrideUrlLoading;
    }

    public static final void a(I1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e.set(false);
    }

    public WebResourceResponse safedk_I1_shouldInterceptRequest_17b448be02a51e536f5b6565c7bf9bb1(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        WebResourceResponse webResourceResponseA = kd.a(url, this.f3093a);
        return webResourceResponseA == null ? super.shouldInterceptRequest(view, url) : webResourceResponseA;
    }

    public WebResourceResponse safedk_I1_shouldInterceptRequest_873a0b008f9283eaadf0252b61398bda(WebView view, WebResourceRequest request) {
        WebResourceResponse webResourceResponseA;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        b(view);
        L4 l4 = this.f3093a;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(request, "<this>");
        if (StringsKt.equals("GET", request.getMethod(), true)) {
            String string = request.getUrl().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            webResourceResponseA = kd.a(string, l4);
        } else {
            webResourceResponseA = null;
        }
        return webResourceResponseA == null ? super.shouldInterceptRequest(view, request) : webResourceResponseA;
    }
}
