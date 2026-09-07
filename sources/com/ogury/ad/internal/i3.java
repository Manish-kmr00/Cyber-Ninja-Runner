package com.ogury.ad.internal;

import android.net.Uri;
import android.webkit.WebView;
import com.ogury.core.internal.IntegrationLogger;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i3 extends f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j3 f7320a;

    public i3(j3 j3Var) {
        this.f7320a = j3Var;
    }

    @Override // com.ogury.ad.internal.f5
    public final void a() {
        IntegrationLogger.d("[Ads][" + this.f7320a.b.k().b() + "][load][" + this.f7320a.b.b().a() + "][" + this.f7320a.b.e() + "] A problem occurred on the format side (unloading required)");
        j3 j3Var = this.f7320a;
        j3.a(j3Var, j3Var.f7327a, this.f7320a.b);
        j3.g(this.f7320a);
    }

    @Override // com.ogury.ad.internal.f5
    public final void b(WebView webView, String url) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(url, "url");
        u3.f7411a.getClass();
        this.f7320a.g = true;
        IntegrationLogger.d("[Ads][" + this.f7320a.b.k().b() + "][load][" + this.f7320a.b.b().a() + "][" + this.f7320a.b.e() + "] WebView -> OK");
        l3 l3Var = this.f7320a.f;
        if (l3Var != null) {
            l3Var.a(w9.a.HTML);
        }
        this.f7320a.e.a(o7.LI_006_SDK_EVENT_AD_PRECACHED_IN_WEBVIEW, this.f7320a.b, p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(this.f7320a.b.f())), TuplesKt.to("loaded_source", s3.a(this.f7320a.b.h().a())), TuplesKt.to("reload", Boolean.valueOf(this.f7320a.b.l())), TuplesKt.to("webview_termination", this.f7320a.k > 0 ? Integer.valueOf(this.f7320a.k) : null)));
        j3.f(this.f7320a);
    }

    @Override // com.ogury.ad.internal.f5
    public final void a(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        j3 j3Var = this.f7320a;
        boolean z = j3Var.g;
        l3 l3Var = j3Var.f;
        if (l3Var != null) {
            l3Var.a(j3Var.b, errorMessage, z);
        }
        if (z) {
            return;
        }
        z3 z3Var = z3.f7460a;
        z3.a(new h9("loaded_error", j3Var.b));
        j3Var.a();
    }

    @Override // com.ogury.ad.internal.f5
    public final void a(boolean z, Uri failingUri) {
        Intrinsics.checkNotNullParameter(failingUri, "failingUri");
        ca.a((WebView) this.f7320a.f7327a);
        j3 j3Var = this.f7320a;
        l3 l3Var = j3Var.f;
        if (l3Var != null) {
            l3Var.a(j3Var.b, z, failingUri);
        }
    }

    @Override // com.ogury.ad.internal.f5
    public final void a(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.f7320a.i = true;
        IntegrationLogger.d("[Ads][" + this.f7320a.b.k().b() + "][load][" + this.f7320a.b.b().a() + "][" + this.f7320a.b.e() + "] Format -> OK");
        l3 l3Var = this.f7320a.f;
        if (l3Var != null) {
            l3Var.a(w9.a.FORMAT);
        }
        if (this.f7320a.b.h().a() == r3.LOADED_SOURCE_FORMAT) {
            this.f7320a.e.a(o7.LI_007_SDK_EVENT_AD_PRECACHED_ON_FORMAT, this.f7320a.b, p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(this.f7320a.b.f())), TuplesKt.to("loaded_source", s3.a(this.f7320a.b.h().a())), TuplesKt.to("reload", Boolean.valueOf(this.f7320a.b.l())), TuplesKt.to("webview_termination", this.f7320a.k > 0 ? Integer.valueOf(this.f7320a.k) : null)));
        }
        j3.f(this.f7320a);
    }

    @Override // com.ogury.ad.internal.f5
    public final void b(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.f7320a.h = true;
        IntegrationLogger.d("[Ads][" + this.f7320a.b.k().b() + "][load][" + this.f7320a.b.b().a() + "][" + this.f7320a.b.e() + "] Mraid -> OK");
        l3 l3Var = this.f7320a.f;
        if (l3Var != null) {
            l3Var.a(w9.a.MRAID);
        }
        j3.f(this.f7320a);
    }
}
