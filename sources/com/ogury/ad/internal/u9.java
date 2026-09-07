package com.ogury.ad.internal;

import android.net.Uri;
import android.webkit.WebView;
import com.ogury.core.internal.IntegrationLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class u9 extends f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t9 f7415a;

    public u9(t9 t9Var) {
        this.f7415a = t9Var;
    }

    @Override // com.ogury.ad.internal.f5
    public final void a(boolean z, Uri failingUri) {
        Intrinsics.checkNotNullParameter(failingUri, "failingUri");
        this.f7415a.c.invoke(Boolean.valueOf(z), failingUri);
    }

    @Override // com.ogury.ad.internal.f5
    public final void b(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        d5 webView2 = this.f7415a.d;
        if (webView2 != null) {
            w4 w4Var = webView2.p;
            w4Var.getClass();
            Intrinsics.checkNotNullParameter(webView2, "webView");
            w4Var.f7429a.a(webView2.getMraidCommandExecutor());
        }
    }

    @Override // com.ogury.ad.internal.f5
    public final void a(String errorMessage) {
        p pVarB;
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        o.a aVar = o.c;
        c cVar = this.f7415a.e;
        String strD = (cVar == null || (pVarB = cVar.b()) == null) ? null : pVarB.d();
        aVar.getClass();
        IntegrationLogger.w("[Ads][" + o.a.a(strD) + "][show] Error while showing ad: " + errorMessage);
    }
}
