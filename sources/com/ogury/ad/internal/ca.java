package com.ogury.ad.internal;

import android.webkit.WebView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ca {
    public static final void a(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        Intrinsics.checkNotNullParameter(webView, "<this>");
        if (webView.isAttachedToWindow()) {
            return;
        }
        webView.destroy();
    }

    public static final void b(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
    }

    public static final void c(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        webView.setHorizontalScrollBarEnabled(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setScrollContainer(false);
    }

    public static final boolean b(d5 d5Var) {
        Intrinsics.checkNotNullParameter(d5Var, "<this>");
        return d5Var.isAttachedToWindow();
    }

    public static final void a(d5 d5Var) {
        Intrinsics.checkNotNullParameter(d5Var, "<this>");
        d5Var.getSettings().setJavaScriptEnabled(true);
        d5Var.getSettings().setDomStorageEnabled(true);
    }

    public static final void a(WebView webView, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (webView.getHeight() <= 0 && webView.getWidth() <= 0) {
            webView.post(new Runnable() { // from class: com.ogury.ad.internal.ca$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ca.a(callback);
                }
            });
        } else {
            callback.invoke();
        }
    }

    public static final void a(Function0 function0) {
        function0.invoke();
    }
}
