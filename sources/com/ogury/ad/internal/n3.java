package com.ogury.ad.internal;

import android.webkit.WebView;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class n3 implements v9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d5 f7363a;
    public final c b;
    public l3 c;
    public final Pattern d;
    public boolean e;

    public n3(d5 webView, c ad) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.f7363a = webView;
        this.b = ad;
        Pattern patternCompile = Pattern.compile(ad.u);
        this.d = patternCompile;
        webView.setClientAdapter(new m3(this, patternCompile));
    }

    @Override // com.ogury.ad.internal.v9
    public final void a(l3 loadCallback, int i) {
        Intrinsics.checkNotNullParameter(loadCallback, "loadCallback");
        this.c = loadCallback;
        if (this.b.t) {
            this.f7363a.getSettings().setJavaScriptEnabled(false);
        }
        this.f7363a.loadUrl(this.b.s);
    }

    @Override // com.ogury.ad.internal.v9
    public final boolean b() {
        return this.e;
    }

    @Override // com.ogury.ad.internal.v9
    public final void a() {
        this.c = null;
        d5 d5Var = this.f7363a;
        Pattern whitelistPattern = this.d;
        Intrinsics.checkNotNullExpressionValue(whitelistPattern, "whitelistPattern");
        d5Var.setClientAdapter(new x0(whitelistPattern));
        this.f7363a.setDestroyed(true);
        ca.a((WebView) this.f7363a);
    }
}
