package com.five_corp.ad.internal.view;

import android.net.Uri;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.internal.partials.LINENetworkBridge;
import com.vungle.ads.internal.model.AdPayload;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1580a = 0;

    public static boolean a(Uri uri, com.five_corp.ad.internal.layouter.e eVar, com.five_corp.ad.internal.logger.a aVar) {
        boolean z = true;
        try {
            if (uri.equals(Uri.parse("https://macro.fivecdm.com/click"))) {
                eVar.h.a();
            } else if (uri.equals(Uri.parse("https://macro.fivecdm.com/closeDeprecated"))) {
                eVar.h.b();
            } else {
                z = false;
            }
        } catch (Throwable th) {
            aVar.a(th);
        }
        return z;
    }

    public static void a(WebView webView, com.five_corp.ad.internal.cache.q qVar, com.five_corp.ad.internal.ad.format_config.b bVar, com.five_corp.ad.internal.layouter.e eVar, com.five_corp.ad.internal.logger.a aVar) {
        WebViewClient pVar;
        StringBuilder sb = new StringBuilder("<html><head><meta charset='utf-8' />");
        sb.append(String.format("<meta name='viewport' content='width=%dpx' />", Integer.valueOf(bVar.f1290a)));
        sb.append("</head><body style='margin:0;padding:0'>");
        String strReplace = bVar.c.replace("{{install-url}}", "https://macro.fivecdm.com/click").replace("{{back-url}}", "https://macro.fivecdm.com/closeDeprecated").replace("{{replay-url}}", "https://macro.fivecdm.com/replay");
        ArrayList<com.five_corp.ad.internal.ad.s> arrayList = bVar.b;
        if (arrayList != null) {
            for (com.five_corp.ad.internal.ad.s sVar : arrayList) {
                com.five_corp.ad.internal.cache.o oVar = (com.five_corp.ad.internal.cache.o) qVar.f1349a.get(sVar);
                if (oVar != null && oVar.d()) {
                    strReplace = strReplace.replace("{{resource:" + sVar.b + "}}", AdPayload.FILE_SCHEME + oVar.c());
                }
            }
        }
        sb.append(strReplace);
        sb.append("</body></html>");
        String string = sb.toString();
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(false);
        webView.setBackgroundColor(-1);
        webView.setScrollBarStyle(0);
        webView.setVisibility(8);
        webView.setLayerType(1, null);
        webView.setOnLongClickListener(new n());
        if (Build.VERSION.SDK_INT >= 26) {
            pVar = new q(eVar, aVar);
        } else {
            pVar = new p(eVar, aVar);
        }
        webView.setWebViewClient(pVar);
        LINENetworkBridge.webviewLoadDataWithBaseURL(webView, "", string, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8", "");
    }
}
