package sg.bigo.ads.controller.landing;

import android.content.Context;
import android.os.SystemClock;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import sg.bigo.ads.core.h.e;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final sg.bigo.ads.api.core.c f13474a;
    public final sg.bigo.ads.api.core.c.b b;
    public final int c;
    boolean d = false;
    String e = "";
    e f;
    long g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: sg.bigo.ads.controller.landing.a$a, reason: collision with other inner class name */
    public interface InterfaceC0888a {
        void a(String str);

        void a(String str, long j, boolean z, int i);
    }

    public a(sg.bigo.ads.api.core.c cVar) {
        this.f13474a = cVar;
        sg.bigo.ads.api.core.c.b bVarN = cVar.N();
        this.b = bVarN;
        this.c = bVarN.f();
    }

    static /* synthetic */ void a(a aVar, Context context, final String str, int i, final InterfaceC0888a interfaceC0888a) {
        if (i == 0) {
            aVar.a(context, str, interfaceC0888a);
            return;
        }
        if (i != 2) {
            sg.bigo.ads.common.t.a.a(0, "Preload", "PreloadLand: error open type.");
            return;
        }
        aVar.g = SystemClock.elapsedRealtime();
        sg.bigo.ads.a.a.C0805a c0805a = new sg.bigo.ads.a.a.C0805a();
        c0805a.f12464a = str;
        sg.bigo.ads.a.a aVarA = c0805a.a();
        sg.bigo.ads.a.c.a(context, aVarA.f12463a, new sg.bigo.ads.a.a.b() { // from class: sg.bigo.ads.controller.landing.a.1
            @Override // sg.bigo.ads.a.a.b
            public final void a(Context context2, String str2, final int i2, String str3) {
                sg.bigo.ads.common.t.a.a(0, 3, "Preload", "Preload by chrome tabs failed, using webView.");
                a.this.a(context2, str2, new InterfaceC0888a() { // from class: sg.bigo.ads.controller.landing.a.1.1
                    @Override // sg.bigo.ads.controller.landing.a.InterfaceC0888a
                    public final void a(String str4) {
                        if (interfaceC0888a != null) {
                            interfaceC0888a.a(str4);
                        }
                    }

                    @Override // sg.bigo.ads.controller.landing.a.InterfaceC0888a
                    public final void a(String str4, long j, boolean z, int i3) {
                        if (interfaceC0888a != null) {
                            interfaceC0888a.a(str4, j, z, d.a(i2));
                        }
                    }
                });
            }

            @Override // sg.bigo.ads.a.a.b
            public final void a(String str2, String str3, String str4) {
                InterfaceC0888a interfaceC0888a2 = interfaceC0888a;
                if (interfaceC0888a2 != null) {
                    interfaceC0888a2.a(str, SystemClock.elapsedRealtime() - a.this.g, true, 2);
                }
            }
        });
    }

    public final void a() {
        sg.bigo.ads.common.t.a.a(0, 3, "Preload", "recycleLandWebView isPreloadWebViewReady=" + this.d);
        e eVar = this.f;
        if (eVar != null) {
            eVar.destroy();
            this.f = null;
        }
    }

    final void a(Context context, final String str, final InterfaceC0888a interfaceC0888a) {
        this.g = SystemClock.elapsedRealtime();
        interfaceC0888a.a(str);
        e eVarA = e.a(context);
        this.f = eVarA;
        if (eVarA == null) {
            return;
        }
        eVarA.setWebChromeClient(new sg.bigo.ads.core.h.c());
        this.f.setWebViewClient(new sg.bigo.ads.core.h.d() { // from class: sg.bigo.ads.controller.landing.a.2
            @Override // sg.bigo.ads.core.h.d
            public final void a(RenderProcessGoneDetail renderProcessGoneDetail) {
                a.this.f = null;
                interfaceC0888a.a(str, SystemClock.elapsedRealtime() - a.this.g, false, 0);
            }

            @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str2) {
                super.onPageFinished(webView, str2);
                sg.bigo.ads.common.t.a.a(0, 3, "Preload", "onPageFinished: url=" + webView.getUrl());
                interfaceC0888a.a(str2, SystemClock.elapsedRealtime() - a.this.g, true, 0);
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i, String str2, String str3) {
                super.onReceivedError(webView, i, str2, str3);
                sg.bigo.ads.common.t.a.b("Preload", "onReceivedError: " + i + " " + str2);
                interfaceC0888a.a(str, SystemClock.elapsedRealtime() - a.this.g, false, 0);
            }

            @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
                }
            }

            @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
            public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (webResourceRequest.isForMainFrame()) {
                    onReceivedError(webView, webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceRequest.getUrl().toString());
                }
            }
        });
        this.f.setLeft(0);
        this.f.setTop(0);
        this.f.setRight(sg.bigo.ads.common.utils.e.b(context));
        this.f.setBottom(sg.bigo.ads.common.utils.e.c(context) - sg.bigo.ads.common.utils.e.a(context, 55));
        this.f.loadUrl(str);
    }

    final boolean b() {
        int i = this.c;
        return i == 3 || i == 4;
    }
}
