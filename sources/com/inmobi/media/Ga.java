package com.inmobi.media;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class Ga extends WebViewRenderProcessClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L4 f3082a;
    public final Ia b;

    public Ga(L4 l4, Ia ia) {
        this.f3082a = l4;
        this.b = ia;
    }

    @Override // android.webkit.WebViewRenderProcessClient
    public final void onRenderProcessResponsive(WebView view, WebViewRenderProcess webViewRenderProcess) {
        Intrinsics.checkNotNullParameter(view, "view");
        L4 l4 = this.f3082a;
        if (l4 != null) {
            ((M4) l4).a("RenderViewRenderProcessClient", "onRenderProcessResponsive " + view + ' ' + webViewRenderProcess);
        }
        Ia ia = this.b;
        if (ia != null) {
            Map mapA = ia.a();
            mapA.put("creativeId", ia.f3098a.f);
            int i = ia.d + 1;
            ia.d = i;
            mapA.put("count", Integer.valueOf(i));
            Ob ob = Ob.f3160a;
            Ob.b("RenderProcessResponsive", mapA, Sb.SDK);
        }
    }

    @Override // android.webkit.WebViewRenderProcessClient
    public final void onRenderProcessUnresponsive(WebView view, WebViewRenderProcess webViewRenderProcess) {
        Intrinsics.checkNotNullParameter(view, "view");
        L4 l4 = this.f3082a;
        if (l4 != null) {
            ((M4) l4).a("RenderViewRenderProcessClient", "onRenderProcessUnresponsive " + view + ' ' + webViewRenderProcess);
        }
        Ia ia = this.b;
        if (ia != null) {
            Map mapA = ia.a();
            mapA.put("creativeId", ia.f3098a.f);
            int i = ia.c + 1;
            ia.c = i;
            mapA.put("count", Integer.valueOf(i));
            Ob ob = Ob.f3160a;
            Ob.b("RenderProcessUnResponsive", mapA, Sb.SDK);
        }
    }
}
