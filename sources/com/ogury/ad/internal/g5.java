package com.ogury.ad.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import java.io.ByteArrayInputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class g5 extends e5 {
    public final d5 e;
    public f5 f;

    public g5(d5 mraidWebView) {
        Intrinsics.checkNotNullParameter(mraidWebView, "mraidWebView");
        this.e = mraidWebView;
    }

    @Override // com.ogury.ad.internal.s9
    public final void a(String type, int i, String str, Uri failingUri) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(failingUri, "failingUri");
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(failingUri.getScheme());
        builder.authority(failingUri.getAuthority());
        builder.path(failingUri.getPath());
        String str2 = "errorType: " + type + " errorCode: " + i + ", description: " + str + ", failingUrl: " + builder.build();
        String str3 = "onReceivedError " + str2;
        u3.f7411a.getClass();
        f5 f5Var = this.f;
        if (f5Var != null) {
            f5Var.a(str2);
        }
    }

    @Override // com.ogury.ad.internal.s9
    public final boolean b(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        d5 d5Var = this.e;
        d5Var.getClass();
        Intrinsics.checkNotNullParameter(url, "url");
        n4 mraidCommandExecutor = d5Var.getMraidCommandExecutor();
        mraidCommandExecutor.getClass();
        Intrinsics.checkNotNullParameter(url, "url");
        h5.a(mraidCommandExecutor.f7364a, o4.a(url));
        f5 f5Var = this.f;
        if (f5Var != null) {
            return f5Var.d(view, url);
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        return true;
    }

    @Override // com.ogury.ad.internal.e5, com.ogury.ad.internal.s9, android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        CreativeInfoManager.onResourceLoaded("io.presage", view, url);
    }

    @Override // com.ogury.ad.internal.e5, com.ogury.ad.internal.s9, android.webkit.WebViewClient
    public final void onPageFinished(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        f5 f5Var = this.f;
        if (f5Var != null) {
            f5Var.b(view, url);
        }
    }

    @Override // com.ogury.ad.internal.e5, com.ogury.ad.internal.s9, android.webkit.WebViewClient
    public final void onPageStarted(WebView view, String url, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        f5 f5Var = this.f;
        if (f5Var != null) {
            f5Var.c(view, url);
        }
    }

    @Override // com.ogury.ad.internal.e5, com.ogury.ad.internal.s9
    public final WebResourceResponse a(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        f5 f5Var = this.f;
        if (f5Var != null) {
            f5Var.a(view, url);
        }
        f5 f5Var2 = this.f;
        if (f5Var2 != null && f5Var2.b(url)) {
            u3.f7411a.getClass();
            byte[] bytes = "".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return new WebResourceResponse("text/image", "UTF-8", new ByteArrayInputStream(bytes));
        }
        return super.a(view, url);
    }
}
