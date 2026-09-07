package com.applovin.impl;

import com.applovin.impl.sdk.utils.CollectionUtils;
import com.safedk.android.internal.partials.AppLovinNetworkBridge;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class g2 implements f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f421a;
    private final com.applovin.impl.sdk.o b;

    public g2(com.applovin.impl.sdk.k kVar) {
        this.f421a = kVar;
        this.b = kVar.O();
    }

    @Override // com.applovin.impl.f2
    public InputStream a(String str, Map map) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(((Integer) this.f421a.a(v4.R2)).intValue());
        httpURLConnection.setReadTimeout(((Integer) this.f421a.a(v4.S2)).intValue());
        httpURLConnection.setDefaultUseCaches(true);
        httpURLConnection.setUseCaches(true);
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        int iHttpUrlConnectionGetResponseCode = AppLovinNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
        this.f421a.E().a("loadResource", str, iHttpUrlConnectionGetResponseCode, httpURLConnection.getResponseMessage());
        if (r0.a(iHttpUrlConnectionGetResponseCode)) {
            return null;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.b.a("HttpUrlConnectionLoader", "Opened stream to resource " + str);
        }
        InputStream inputStreamUrlConnectionGetInputStream = AppLovinNetworkBridge.urlConnectionGetInputStream(httpURLConnection);
        HashMap<String, String> mapHashMap = CollectionUtils.hashMap("url", str);
        mapHashMap.putAll(map);
        CollectionUtils.putStringIfValid("source", "HttpUrlConnectionLoader", mapHashMap);
        this.f421a.g().d(c2.C, mapHashMap);
        return inputStreamUrlConnectionGetInputStream;
    }
}
