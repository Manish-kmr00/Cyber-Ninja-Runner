package com.ogury.ad.internal;

import android.webkit.WebView;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class m3 extends x0 {
    public final /* synthetic */ n3 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m3(n3 n3Var, Pattern pattern) {
        super(pattern);
        this.c = n3Var;
        Intrinsics.checkNotNull(pattern);
    }

    @Override // com.ogury.ad.internal.f5
    public final void a() {
        n3 n3Var = this.c;
        l3 l3Var = n3Var.c;
        if (l3Var != null) {
            l3Var.c(n3Var.b);
        }
        d5 d5Var = n3Var.f7363a;
        Pattern whitelistPattern = n3Var.d;
        Intrinsics.checkNotNullExpressionValue(whitelistPattern, "whitelistPattern");
        d5Var.setClientAdapter(new x0(whitelistPattern));
        n3Var.f7363a.setDestroyed(true);
        ca.a((WebView) n3Var.f7363a);
    }

    @Override // com.ogury.ad.internal.f5
    public final void b(WebView webView, String url) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(url, "url");
        u3.f7411a.getClass();
        n3 n3Var = this.c;
        n3Var.e = true;
        l3 l3Var = n3Var.c;
        if (l3Var != null) {
            l3Var.c(n3Var.b);
        }
        d5 d5Var = n3Var.f7363a;
        Pattern whitelistPattern = n3Var.d;
        Intrinsics.checkNotNullExpressionValue(whitelistPattern, "whitelistPattern");
        d5Var.setClientAdapter(new x0(whitelistPattern));
        n3Var.f7363a.setDestroyed(true);
        ca.a((WebView) n3Var.f7363a);
    }

    @Override // com.ogury.ad.internal.f5
    public final void a(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        n3 n3Var = this.c;
        l3 l3Var = n3Var.c;
        if (l3Var != null) {
            l3Var.c(n3Var.b);
        }
        d5 d5Var = n3Var.f7363a;
        Pattern whitelistPattern = n3Var.d;
        Intrinsics.checkNotNullExpressionValue(whitelistPattern, "whitelistPattern");
        d5Var.setClientAdapter(new x0(whitelistPattern));
        n3Var.f7363a.setDestroyed(true);
        ca.a((WebView) n3Var.f7363a);
    }
}
