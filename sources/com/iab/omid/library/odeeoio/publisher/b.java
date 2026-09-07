package com.iab.omid.library.odeeoio.publisher;

import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.odeeoio.adsession.AdSessionContext;
import com.iab.omid.library.odeeoio.adsession.VerificationScriptResource;
import com.iab.omid.library.odeeoio.b.e;
import com.iab.omid.library.odeeoio.d.d;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class b extends AdSessionStatePublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f2784a;
    private Long b = null;
    private final Map<String, VerificationScriptResource> c;
    private final String d;

    public b(Map<String, VerificationScriptResource> map, String str) {
        this.c = map;
        this.d = str;
    }

    @Override // com.iab.omid.library.odeeoio.publisher.AdSessionStatePublisher
    public void a() {
        super.a();
        j();
    }

    @Override // com.iab.omid.library.odeeoio.publisher.AdSessionStatePublisher
    public void a(com.iab.omid.library.odeeoio.adsession.a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String str : injectedResourcesMap.keySet()) {
            com.iab.omid.library.odeeoio.d.b.a(jSONObject, str, injectedResourcesMap.get(str));
        }
        a(aVar, adSessionContext, jSONObject);
    }

    @Override // com.iab.omid.library.odeeoio.publisher.AdSessionStatePublisher
    public void b() {
        super.b();
        new Handler().postDelayed(new Runnable() { // from class: com.iab.omid.library.odeeoio.publisher.b.1
            private final WebView b;

            {
                this.b = b.this.f2784a;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.b.destroy();
            }
        }, Math.max(4000 - (this.b == null ? 4000L : TimeUnit.MILLISECONDS.convert(d.a() - this.b.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.f2784a = null;
    }

    void j() {
        WebView webView = new WebView(com.iab.omid.library.odeeoio.b.d.a().b());
        this.f2784a = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        a(this.f2784a);
        e.a().a(this.f2784a, this.d);
        for (String str : this.c.keySet()) {
            e.a().a(this.f2784a, this.c.get(str).getResourceUrl().toExternalForm(), str);
        }
        this.b = Long.valueOf(d.a());
    }
}
