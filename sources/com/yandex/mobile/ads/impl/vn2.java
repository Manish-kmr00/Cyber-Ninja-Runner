package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class vn2 extends g9 {
    private WebView f;
    private Long g = null;
    private final Map<String, wa2> h;
    private final String i;

    final class a implements Runnable {
        private final WebView b;

        a(vn2 vn2Var) {
            this.b = vn2Var.f;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.destroy();
        }
    }

    @Override // com.yandex.mobile.ads.impl.g9
    public final void b() {
        super.b();
        new Handler().postDelayed(new a(this), Math.max(4000 - (this.g == null ? 4000L : TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.g.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.f = null;
    }

    public vn2(String str, Map map) {
        this.h = map;
        this.i = str;
    }

    @Override // com.yandex.mobile.ads.impl.g9
    public final void a() {
        WebView webView = new WebView(io2.a().b());
        this.f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        a(this.f);
        WebView webView2 = this.f;
        String str = this.i;
        if (webView2 != null && !TextUtils.isEmpty(str)) {
            webView2.loadUrl("javascript: " + str);
        }
        for (String str2 : this.h.keySet()) {
            String externalForm = this.h.get(str2).a().toExternalForm();
            WebView webView3 = this.f;
            if (externalForm != null && !TextUtils.isEmpty(str2)) {
                String strReplace = "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};this.omidVerificationProperties.injectionId = '%INJECTION_ID%';var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", externalForm).replace("%INJECTION_ID%", str2);
                if (webView3 != null && !TextUtils.isEmpty(strReplace)) {
                    webView3.loadUrl("javascript: " + strReplace);
                }
            }
        }
        this.g = Long.valueOf(System.nanoTime());
    }

    @Override // com.yandex.mobile.ads.impl.g9
    public final void a(mn2 mn2Var, d9 d9Var) {
        JSONObject jSONObject = new JSONObject();
        Map<String, wa2> mapD = d9Var.d();
        for (String str : mapD.keySet()) {
            zn2.a(jSONObject, str, mapD.get(str));
        }
        a(mn2Var, d9Var, jSONObject);
    }
}
