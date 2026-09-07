package com.ogury.ad.internal;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z0 {
    public static final void a(d5 d5Var) {
        Intrinsics.checkNotNullParameter(d5Var, "<this>");
        d5Var.getSettings().setJavaScriptEnabled(true);
        d5Var.getSettings().setBuiltInZoomControls(true);
        d5Var.getSettings().setDisplayZoomControls(false);
        d5Var.getSettings().setUseWideViewPort(true);
        d5Var.getSettings().setLoadWithOverviewMode(true);
        d5Var.getSettings().setDomStorageEnabled(true);
        d5Var.getSettings().setDatabaseEnabled(true);
        d5Var.getSettings().setSupportMultipleWindows(true);
        d5Var.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(d5Var, true);
        d5Var.getSettings().setMixedContentMode(2);
        d5Var.getSettings().setLoadsImagesAutomatically(true);
        d5Var.getSettings().setMediaPlaybackRequiresUserGesture(false);
        d5Var.getSettings().setSaveFormData(true);
        d5Var.getSettings().setSupportZoom(true);
        Context context = d5Var.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        d5Var.setDownloadListener(new l5(context));
    }

    public static final String a(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        Object tag = webView.getTag();
        String str = tag instanceof String ? (String) tag : null;
        return str == null ? "" : str;
    }
}
