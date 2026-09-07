package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes3.dex */
public class aBv {
    public static void pA(Uri uri, com.bytedance.sdk.openadsdk.core.IG ig) {
        if (ig == null || !ig.pA(uri)) {
            return;
        }
        try {
            ig.Og(uri);
        } catch (Exception e) {
            new StringBuilder("TTAndroidObj handleUri exception: ").append(e);
        }
    }

    public static String pA(WebView webView, int i) {
        if (webView == null) {
            return "";
        }
        String userAgentString = webView.getSettings().getUserAgentString();
        if (TextUtils.isEmpty(userAgentString)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(userAgentString);
        sb.append(" open_news open_news_u_s/").append(i);
        return sb.toString();
    }
}
