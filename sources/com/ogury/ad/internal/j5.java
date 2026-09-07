package com.ogury.ad.internal;

import android.webkit.WebView;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j5 extends f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7330a = "";
    public boolean b;
    public final /* synthetic */ i5 c;
    public final /* synthetic */ d5 d;

    public j5(i5 i5Var, d5 d5Var) {
        this.c = i5Var;
        this.d = d5Var;
    }

    @Override // com.ogury.ad.internal.f5
    public final void a(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        i5 i5Var = this.c;
        String str = this.f7330a;
        aa aaVar = i5Var.c.get(z0.a(view));
        if (aaVar != null && !aaVar.f && i5Var.f7321a.j.length() > 0 && i5Var.k.matcher(url).matches()) {
            z3 z3Var = z3.f7460a;
            c cVar = i5Var.f7321a;
            z3.a(new f(cVar, str, cVar.j, url));
            aaVar.f = true;
        }
    }

    @Override // com.ogury.ad.internal.f5
    public final void b(WebView webView, String url) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(url, "url");
        i5 i5Var = this.c;
        boolean z3 = this.b;
        k5 k5Var = i5Var.e;
        Iterator<d5> it = i5Var.b.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (it.next().canGoForward()) {
                z = true;
                break;
            }
        }
        Iterator<d5> it2 = i5Var.b.values().iterator();
        while (true) {
            if (!it2.hasNext()) {
                z2 = false;
                break;
            } else if (it2.next().canGoBack()) {
                z2 = true;
                break;
            }
        }
        String webViewId = z0.a(webView);
        String title = webView.getTitle();
        k5Var.getClass();
        String str = "finished";
        Intrinsics.checkNotNullParameter("finished", "event");
        Intrinsics.checkNotNullParameter(webViewId, "webViewId");
        Intrinsics.checkNotNullParameter(url, "url");
        Iterator it3 = k5Var.a().iterator();
        while (it3.hasNext()) {
            h5.a((d5) it3.next(), o4.a(str, z, z2, webViewId, url, title));
            str = str;
        }
        aa aaVar = i5Var.c.get(z0.a(webView));
        if (aaVar != null) {
            boolean z4 = !(aaVar.e && Intrinsics.areEqual(aaVar.c, url)) && aaVar.f7263a;
            if (z3 && z4 && i5Var.f7321a.j.length() == 0) {
                z3 z3Var = z3.f7460a;
                z3.a(new f(i5Var.f7321a, url, null, null));
            }
            aaVar.e = true;
        }
        this.b = false;
    }

    @Override // com.ogury.ad.internal.f5
    public final void c(WebView webView, String url) {
        boolean z;
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(url, "url");
        this.f7330a = url;
        boolean z2 = true;
        this.b = true;
        i5 i5Var = this.c;
        k5 k5Var = i5Var.e;
        Iterator<d5> it = i5Var.b.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (it.next().canGoForward()) {
                z = true;
                break;
            }
        }
        Iterator<d5> it2 = i5Var.b.values().iterator();
        do {
            if (!it2.hasNext()) {
                z2 = false;
                break;
            }
        } while (!it2.next().canGoBack());
        String webViewId = z0.a(webView);
        k5Var.getClass();
        Intrinsics.checkNotNullParameter(com.ironsource.b9.h.d0, "event");
        Intrinsics.checkNotNullParameter(webViewId, "webViewId");
        Intrinsics.checkNotNullParameter(url, "url");
        Iterator it3 = k5Var.a().iterator();
        while (it3.hasNext()) {
            h5.a((d5) it3.next(), o4.a(com.ironsource.b9.h.d0, z, z2, webViewId, url, ""));
        }
    }

    @Override // com.ogury.ad.internal.f5
    public final boolean d(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        return false;
    }

    @Override // com.ogury.ad.internal.f5
    public final void b(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        aa aaVar = this.c.c.get(z0.a(webView));
        if (aaVar != null) {
            aaVar.d = true;
        }
        d5 webView2 = this.d;
        w4 w4Var = webView2.p;
        w4Var.getClass();
        Intrinsics.checkNotNullParameter(webView2, "webView");
        w4Var.f7429a.a(webView2.getMraidCommandExecutor());
    }
}
