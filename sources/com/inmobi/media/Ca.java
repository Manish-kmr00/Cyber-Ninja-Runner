package com.inmobi.media;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.SystemClock;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.events.RedirectEvent;
import com.safedk.android.internal.partials.InMobiNetworkBridge;
import com.safedk.android.utils.Logger;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class Ca extends I1 {
    public final Ia f;
    public final C3586ua g;
    public boolean h;
    public final String i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ca(Ia ia, L4 l4, C3586ua onRenderViewProcessGone) {
        super(l4);
        Intrinsics.checkNotNullParameter(onRenderViewProcessGone, "onRenderViewProcessGone");
        this.f = ia;
        this.g = onRenderViewProcessGone;
        this.i = RedirectEvent.b;
    }

    public final boolean a(WebView webView, String str) {
        boolean z;
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).a("RenderViewClient", S.a("onShouldOverrideUrlLoading  - url - ", str));
        }
        if (webView instanceof Ba) {
            Ba ba = (Ba) webView;
            z = true;
            if (ba.v) {
                InMobiNetworkBridge.webviewLoadUrl(webView, str);
                return true;
            }
            if (!ba.l()) {
                ba.a(this.i);
                return true;
            }
            L4 l5 = this.f3093a;
            if (l5 != null) {
                ((M4) l5).a("RenderViewClient", "Placement type:  " + ((int) ba.getPlacementType()) + "  url:" + str);
            }
            L4 l6 = this.f3093a;
            if (l6 != null) {
                ((M4) l6).a("RenderViewClient", S.a("Override URL loading :", str));
            }
            ba.j();
            S5 s5A = U5.a(ba.getLandingPageHandler(), this.i, null, str, null, false, 24);
            L4 l7 = this.f3093a;
            if (l7 != null) {
                ((M4) l7).a("RenderViewClient", "Current Index :" + ba.copyBackForwardList().getCurrentIndex() + " Original Url :" + ba.getOriginalUrl() + " URL: " + str);
            }
            L4 l8 = this.f3093a;
            if (l8 != null) {
                ((M4) l8).c("RenderViewClient", "landingPage process result - " + s5A.f3190a);
            }
        } else {
            z = false;
        }
        L4 l9 = this.f3093a;
        if (l9 != null) {
            ((M4) l9).a("RenderViewClient", "Override URL loading :" + str + " returned " + z);
        }
        return z;
    }

    @Override // com.inmobi.media.I1, android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/Ca;->onLoadResource(Landroid/webkit/WebView;Ljava/lang/String;)V");
        CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.i, webView, str);
        safedk_Ca_onLoadResource_d67838c5a043196289ced010946bde59(webView, str);
    }

    @Override // com.inmobi.media.I1, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/Ca;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.i, webView, str);
        safedk_Ca_onPageFinished_f31c306c21492a03bcb2a6f8a722f7a8(webView, str);
    }

    @Override // com.inmobi.media.I1, android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/Ca;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
        BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.i, webView, str);
        safedk_Ca_onPageStarted_235459467aa3a333cee0b3ae84531c48(webView, str, bitmap);
    }

    @Override // com.inmobi.media.I1, android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/Ca;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.i, webView, i, str, str2);
        safedk_Ca_onReceivedError_f7983c99161aa8979e3cb32006c23684(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/Ca;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.i, webView, webResourceRequest, webResourceError);
        safedk_Ca_onReceivedError_b3b851dffcc3ec4cff7032f061052b8d(webView, webResourceRequest, webResourceError);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).b("RenderViewClient", "ReceivedHttpError - error - " + (webResourceResponse != null ? webResourceResponse.getReasonPhrase() : null) + ", statusCode - " + (webResourceResponse != null ? Integer.valueOf(webResourceResponse.getStatusCode()) : null) + " url - " + (webResourceRequest != null ? webResourceRequest.getUrl() : null) + " isMainFrame - " + (webResourceRequest != null ? Boolean.valueOf(webResourceRequest.isForMainFrame()) : null));
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).b("RenderViewClient", "onReceivedSSLError - error - " + (sslError != null ? Integer.valueOf(sslError.getPrimaryError()) : null) + " - url - " + (sslError != null ? sslError.getUrl() : null));
        }
    }

    @Override // com.inmobi.media.I1, android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(detail, "detail");
        if (Build.VERSION.SDK_INT >= 26) {
            L4 l4 = this.f3093a;
            if (l4 != null) {
                ((M4) l4).c("RenderViewClient", "onRenderProcessGone detail did crash- " + detail.didCrash() + " priority - " + detail.rendererPriorityAtExit());
            }
            this.g.invoke(Boolean.valueOf(detail.didCrash()));
        } else {
            L4 l5 = this.f3093a;
            if (l5 != null) {
                ((M4) l5).c("RenderViewClient", "onRenderProcessGone");
            }
        }
        return super.onRenderProcessGone(view, detail);
    }

    public void safedk_Ca_onLoadResource_d67838c5a043196289ced010946bde59(WebView p0, String p1) {
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).a("RenderViewClient", S.a("Resource loading:", p1));
        }
        if (p0 instanceof Ba) {
            Ba ba = (Ba) p0;
            String url = ba.getUrl();
            if (p1 == null || url == null || StringsKt.startsWith$default(url, "file:", false, 2, (Object) null)) {
                return;
            }
            a(ba);
        }
    }

    public void safedk_Ca_onPageFinished_f31c306c21492a03bcb2a6f8a722f7a8(WebView p0, String p1) {
        Ia ia = this.f;
        if (ia != null) {
            Map mapA = ia.a();
            long j = ia.b;
            ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
            mapA.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
            Ob ob = Ob.f3160a;
            Ob.b("WebViewLoadFinished", mapA, Sb.SDK);
        }
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).a("RenderViewClient", S.a("Page load finished:", p1));
        }
        if (p0 instanceof Ba) {
            Ba ba = (Ba) p0;
            a(ba);
            String p2 = ba.p;
            if (Intrinsics.areEqual("Loading", p2)) {
                ba.b("window.imaiview.broadcastEvent('ready');");
                ba.b("window.mraidview.broadcastEvent('ready');");
                ba.x();
            }
        }
        L4 l5 = this.f3093a;
        if (l5 != null) {
            ((M4) l5).a("RenderViewClient", "==== CHECKPOINT REACHED - PAGE FINISHED ====");
        }
        L4 l6 = this.f3093a;
        if (l6 != null) {
            ((M4) l6).b();
        }
    }

    public void safedk_Ca_onPageStarted_235459467aa3a333cee0b3ae84531c48(WebView p0, String p1, Bitmap p2) {
        Ia ia = this.f;
        if (ia != null) {
            Map mapA = ia.a();
            long j = ia.b;
            ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
            mapA.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
            Ob ob = Ob.f3160a;
            Ob.b("PageStarted", mapA, Sb.SDK);
        }
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).a("RenderViewClient", S.a("Page load started:", p1));
        }
        if (p0 instanceof Ba) {
            L4 l5 = this.f3093a;
            if (l5 != null) {
                ((M4) l5).a("RenderViewClient", "Page load started renderview: " + ((Ba) p0).getMarkupType());
            }
            Ba ba = (Ba) p0;
            a(ba);
            ba.setAndUpdateViewState("Loading");
        }
        L4 l6 = this.f3093a;
        if (l6 != null) {
            ((M4) l6).a("RenderViewClient", "==== CHECKPOINT REACHED - PAGE STARTED ====");
        }
        L4 l7 = this.f3093a;
        if (l7 != null) {
            ((M4) l7).b();
        }
    }

    public void safedk_Ca_onReceivedError_f7983c99161aa8979e3cb32006c23684(WebView view, int p1, String description, String failingUrl) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).b("RenderViewClient", "OnReceivedError - errorCode - " + p1 + ", description - " + description + ", url - " + failingUrl);
        }
        super.onReceivedError(view, p1, description, failingUrl);
    }

    public boolean safedk_Ca_shouldOverrideUrlLoading_6843e0d8ab6669739a40ce3154674649(WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).a("RenderViewClient", "shouldOverrideUrlLoading Called");
        }
        if (!C3435k3.G()) {
            return false;
        }
        String string = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return a(view, string);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/Ca;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z");
        boolean zSafedk_Ca_shouldOverrideUrlLoading_6843e0d8ab6669739a40ce3154674649 = safedk_Ca_shouldOverrideUrlLoading_6843e0d8ab6669739a40ce3154674649(webView, webResourceRequest);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.i, webView, webResourceRequest, zSafedk_Ca_shouldOverrideUrlLoading_6843e0d8ab6669739a40ce3154674649);
        return zSafedk_Ca_shouldOverrideUrlLoading_6843e0d8ab6669739a40ce3154674649;
    }

    @Override // com.inmobi.media.I1, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/Ca;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_Ca_shouldOverrideUrlLoading_e7e8b4b1eff2ba4893357c2190513958 = safedk_Ca_shouldOverrideUrlLoading_e7e8b4b1eff2ba4893357c2190513958(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.i, webView, str, zSafedk_Ca_shouldOverrideUrlLoading_e7e8b4b1eff2ba4893357c2190513958);
        return zSafedk_Ca_shouldOverrideUrlLoading_e7e8b4b1eff2ba4893357c2190513958;
    }

    public void safedk_Ca_onReceivedError_b3b851dffcc3ec4cff7032f061052b8d(WebView view, WebResourceRequest request, WebResourceError error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(error, "error");
        super.onReceivedError(view, request, error);
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).b("RenderViewClient", "OnReceivedError - errorCode - " + error.getErrorCode() + ", description - " + ((Object) error.getDescription()) + ", url - " + request.getUrl() + ", method - " + request.getMethod() + ", isMainFrame - " + request.isForMainFrame());
        }
    }

    public boolean safedk_Ca_shouldOverrideUrlLoading_e7e8b4b1eff2ba4893357c2190513958(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).a("RenderViewClient", S.a("shouldOverrideUrlLoading Called ", url));
        }
        return a(view, url);
    }

    public final void a(Ba ba) {
        if (this.h || ba.e) {
            return;
        }
        this.h = true;
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).a("RenderViewClient", "Injecting MRAID javascript for two piece creatives.");
        }
        ba.b(ba.getMraidJsString());
    }
}
