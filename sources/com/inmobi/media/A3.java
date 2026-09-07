package com.inmobi.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.view.ViewParent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.playon.bridge.AdUnit;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
public final class A3 extends I1 {
    public final String f;
    public final Lambda g;
    public final Lambda h;
    public Z5 i;
    public W5 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public A3(String api, Function0 onUserLandingCompleted, Function2 fireLandingPageTracker, L4 l4) {
        super(l4);
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(onUserLandingCompleted, "onUserLandingCompleted");
        Intrinsics.checkNotNullParameter(fireLandingPageTracker, "fireLandingPageTracker");
        this.f = api;
        this.g = (Lambda) onUserLandingCompleted;
        this.h = (Lambda) fireLandingPageTracker;
    }

    public final boolean a(WebView webView, String str) {
        Integer num;
        int i;
        InterfaceC3649z3 interfaceC3649z3;
        Cc userLeftApplicationListener;
        if (this.e.get()) {
            return true;
        }
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).a("EmbeddedBrowserViewClient", S.a("onShouldOverrideUrlLoading: ", str));
        }
        if (webView instanceof H1) {
            S5 s5A = U5.a(((H1) webView).getLandingPageHandler(), this.f, null, str, this.i, false, 16);
            num = s5A.b;
            i = s5A.f3190a;
        } else {
            num = null;
            i = 0;
        }
        if (i != 1) {
            if (i != 2 && i != 3) {
                return false;
            }
            a(3, false, str, Integer.valueOf(num != null ? num.intValue() : 10));
            return true;
        }
        boolean z = webView instanceof E3;
        if (z) {
            ViewParent parent = ((E3) webView).getParent();
            if ((parent instanceof C3607w3) && (userLeftApplicationListener = ((C3607w3) parent).getUserLeftApplicationListener()) != null) {
                userLeftApplicationListener.a();
            }
        }
        a(webView);
        if (!AbstractC3392h2.a(str)) {
            if (webView.canGoBack()) {
                webView.goBack();
            } else if (z) {
                ViewParent parent2 = ((E3) webView).getParent();
                if ((parent2 instanceof C3607w3) && (interfaceC3649z3 = ((C3607w3) parent2).d) != null) {
                    C3594v4.a(((C3580u4) interfaceC3649z3).f3442a);
                }
            }
        }
        a(this, 2, false, str, 8);
        return true;
    }

    @Override // com.inmobi.media.I1, android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.i, view, url);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageCommitVisible(WebView webView, String str) {
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).a("EmbeddedBrowserViewClient", S.a("onPageCommitVisible: ", str));
        }
        a(this, 4, true, str, 8);
    }

    @Override // com.inmobi.media.I1, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/A3;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.i, webView, str);
        safedk_A3_onPageFinished_ec76392cbcb19f89741116fd7e0e4fd2(webView, str);
    }

    @Override // com.inmobi.media.I1, android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/A3;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
        BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.i, webView, str);
        safedk_A3_onPageStarted_1335b7603e252a5ed39de34156ec95d4(webView, str, bitmap);
    }

    @Override // com.inmobi.media.I1, android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/A3;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.i, webView, i, str, str2);
        safedk_A3_onReceivedError_44a7313ffc514b11d4a761e2ed84f177(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/A3;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
        BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.i, webView, webResourceRequest, webResourceError);
        safedk_A3_onReceivedError_c47e90b10da9de295b5a6c02f944c121(webView, webResourceRequest, webResourceError);
    }

    @Override // com.inmobi.media.I1, android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(detail, "detail");
        boolean zOnRenderProcessGone = super.onRenderProcessGone(view, detail);
        if (Build.VERSION.SDK_INT >= 26) {
            a(3, true, null, Integer.valueOf(AdUnit.ERROR_LOADING_IN_PROGRESS));
            Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("source", "embedded_browser"), TuplesKt.to("isCrashed", Boolean.valueOf(detail.didCrash())));
            Ob ob = Ob.f3160a;
            Ob.b("WebViewRenderProcessGoneEvent", mapMutableMapOf, Sb.SDK);
        }
        return zOnRenderProcessGone;
    }

    public void safedk_A3_onPageFinished_ec76392cbcb19f89741116fd7e0e4fd2(WebView p0, String p1) {
        super.onPageFinished(p0, p1);
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).a("EmbeddedBrowserViewClient", S.a("onPageFinished: ", p1));
        }
        a(this, 2, true, p1, 8);
    }

    public void safedk_A3_onPageStarted_1335b7603e252a5ed39de34156ec95d4(WebView p0, String p1, Bitmap p2) {
        super.onPageStarted(p0, p1, p2);
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).a("EmbeddedBrowserViewClient", S.a("onPageStarted: ", p1));
        }
        a(this, 1, true, p1, 8);
    }

    public void safedk_A3_onReceivedError_44a7313ffc514b11d4a761e2ed84f177(WebView view, int p1, String description, String failingUrl) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
        a(3, false, failingUrl, Integer.valueOf(p1));
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).a("EmbeddedBrowserViewClient", S.a("onReceivedError: ", failingUrl));
        }
    }

    public boolean safedk_A3_shouldOverrideUrlLoading_2f29058286a3a598b0ce324a89b29c50(WebView p0, WebResourceRequest p1) {
        String string;
        Uri url;
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).a("EmbeddedBrowserViewClient", "shouldOverrideUrlLoading Called");
        }
        if (!C3435k3.G()) {
            return false;
        }
        if (p1 == null || (url = p1.getUrl()) == null || (string = url.toString()) == null) {
            string = "";
        }
        if (p0 == null || string.length() <= 0) {
            return false;
        }
        return a(p0, string);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/A3;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z");
        boolean zSafedk_A3_shouldOverrideUrlLoading_2f29058286a3a598b0ce324a89b29c50 = safedk_A3_shouldOverrideUrlLoading_2f29058286a3a598b0ce324a89b29c50(webView, webResourceRequest);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.i, webView, webResourceRequest, zSafedk_A3_shouldOverrideUrlLoading_2f29058286a3a598b0ce324a89b29c50);
        return zSafedk_A3_shouldOverrideUrlLoading_2f29058286a3a598b0ce324a89b29c50;
    }

    @Override // com.inmobi.media.I1, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/A3;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
        boolean zSafedk_A3_shouldOverrideUrlLoading_19b3d717ce5eba2203807716bee8a7be = safedk_A3_shouldOverrideUrlLoading_19b3d717ce5eba2203807716bee8a7be(webView, str);
        BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.i, webView, str, zSafedk_A3_shouldOverrideUrlLoading_19b3d717ce5eba2203807716bee8a7be);
        return zSafedk_A3_shouldOverrideUrlLoading_19b3d717ce5eba2203807716bee8a7be;
    }

    public boolean safedk_A3_shouldOverrideUrlLoading_19b3d717ce5eba2203807716bee8a7be(WebView p0, String p1) {
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).a("EmbeddedBrowserViewClient", "shouldOverrideUrlLoading Called");
        }
        if (p0 == null || p1 == null) {
            return false;
        }
        return a(p0, p1);
    }

    public static /* synthetic */ void a(A3 a3, int i, boolean z, String str, int i2) {
        if ((i2 & 4) != 0) {
            str = null;
        }
        a3.a(i, z, str, null);
    }

    /* JADX WARN: Type inference failed for: r9v11, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r9v15, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r9v17, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r9v23, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r9v3, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r9v7, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r9v9, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    public final void a(int i, boolean z, String str, Integer num) {
        W5 w5 = this.j;
        if (w5 != null) {
            try {
                if (w5.e) {
                    return;
                }
                Z5 z5 = w5.f3225a;
                if (z5 != null) {
                    z5.g = "IN_CUSTOM";
                }
                int i2 = 8100;
                switch (i) {
                    case 1:
                        if (z) {
                            w5.d = str;
                            A3 a3 = w5.b;
                            N5 funnelState = N5.LPPageStart;
                            a3.getClass();
                            Intrinsics.checkNotNullParameter(funnelState, "funnelState");
                            R5.a(funnelState, z5, (Integer) null, (Function2) a3.h);
                        }
                        break;
                    case 2:
                        if (z) {
                            w5.d = str;
                            w5.e = true;
                            if (!w5.c.contains(1)) {
                                A3 a4 = w5.b;
                                N5 funnelState2 = N5.LPPageStart;
                                Z5 z6 = w5.f3225a;
                                a4.getClass();
                                Intrinsics.checkNotNullParameter(funnelState2, "funnelState");
                                R5.a(funnelState2, z6, (Integer) 8006, (Function2) a4.h);
                            }
                            w5.b.g.invoke();
                            A3 a5 = w5.b;
                            N5 funnelState3 = N5.LPCompleteSuccess;
                            Z5 z7 = w5.f3225a;
                            a5.getClass();
                            Intrinsics.checkNotNullParameter(funnelState3, "funnelState");
                            R5.a(funnelState3, z7, (Integer) null, (Function2) a5.h);
                        }
                        break;
                    case 3:
                        if (z || (str != null && Intrinsics.areEqual(str, w5.d))) {
                            w5.e = true;
                            if (!w5.c.contains(1)) {
                                A3 a6 = w5.b;
                                N5 funnelState4 = N5.LPPageStart;
                                Z5 z8 = w5.f3225a;
                                a6.getClass();
                                Intrinsics.checkNotNullParameter(funnelState4, "funnelState");
                                R5.a(funnelState4, z8, (Integer) 8006, (Function2) a6.h);
                            }
                            A3 a7 = w5.b;
                            N5 funnelState5 = N5.LPCompleteFailed;
                            Z5 z9 = w5.f3225a;
                            Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : 8100);
                            a7.getClass();
                            Intrinsics.checkNotNullParameter(funnelState5, "funnelState");
                            R5.a(funnelState5, z9, numValueOf, (Function2) a7.h);
                        }
                        break;
                    case 4:
                        if (z) {
                            w5.d = str;
                        }
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        w5.e = true;
                        switch (i) {
                            case 5:
                                i2 = 8200;
                                break;
                            case 6:
                                i2 = 8300;
                                break;
                            case 7:
                                i2 = 8400;
                                break;
                            case 8:
                                i2 = 8600;
                                break;
                            case 9:
                                i2 = 8500;
                                break;
                        }
                        int i3 = 4;
                        if (!w5.c.contains(4)) {
                            i3 = 0;
                        }
                        int i4 = i2 + i3;
                        A3 a8 = w5.b;
                        N5 funnelState6 = N5.LPCompleteFailed;
                        Z5 z10 = w5.f3225a;
                        Integer numValueOf2 = Integer.valueOf(i4);
                        a8.getClass();
                        Intrinsics.checkNotNullParameter(funnelState6, "funnelState");
                        R5.a(funnelState6, z10, numValueOf2, (Function2) a8.h);
                        break;
                }
                w5.c.add(Integer.valueOf(i));
            } catch (Exception e) {
                e.toString();
            }
        }
    }

    public void safedk_A3_onReceivedError_c47e90b10da9de295b5a6c02f944c121(WebView view, WebResourceRequest request, WebResourceError error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(error, "error");
        L4 l4 = this.f3093a;
        if (l4 != null) {
            ((M4) l4).a("EmbeddedBrowserViewClient", "onReceivedError: " + request.getUrl());
        }
        if (request.isForMainFrame()) {
            a(3, true, request.getUrl().toString(), Integer.valueOf(error.getErrorCode()));
        }
    }
}
