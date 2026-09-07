package com.fyber.inneractive.sdk.measurement;

import android.content.Context;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.network.V;
import com.iab.omid.library.fyber.Omid;
import com.iab.omid.library.fyber.adsession.Partner;

/* JADX INFO: loaded from: classes12.dex */
public final class e {
    public String b;
    public String c;
    public String d;
    public Partner e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1859a = false;
    public final com.fyber.inneractive.sdk.measurement.tracker.g f = new com.fyber.inneractive.sdk.measurement.tracker.g();
    public final a g = new a(this);
    public final b h = new b(this);
    public final c i = new c(this);

    public static void a(e eVar, Context context) {
        eVar.getClass();
        V v = new V(eVar.g, context, new com.fyber.inneractive.sdk.cache.e("https://cdn2.inner-active.mobi/client/ia-js-tags/omsdk/" + Omid.getVersion() + ".js", "omid-latest.js"));
        IAConfigManager iAConfigManager = IAConfigManager.O;
        iAConfigManager.s.b(v);
        iAConfigManager.s.b(new V(eVar.h, context, new com.fyber.inneractive.sdk.cache.e("https://cdn2.inner-active.mobi/client/ia-js-tags/omsdk/omid-session-client-" + Omid.getVersion() + ".js", "omid-session-client-latest.js")));
        iAConfigManager.s.b(new V(eVar.i, context, new com.fyber.inneractive.sdk.cache.e("https://cdn2.inner-active.mobi/client/ia-js-tags/omsdk/dt-omsdk-mraid-video-tracker.js", "dt-omsdk-mraid-video-tracker.js")));
    }
}
