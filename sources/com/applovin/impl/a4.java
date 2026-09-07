package com.applovin.impl;

import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.shadow.okhttp3.OkHttpClient;
import com.applovin.shadow.okhttp3.Request;
import com.applovin.shadow.okhttp3.Response;
import com.applovin.shadow.okhttp3.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes7.dex */
public class a4 implements f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f321a;
    private final com.applovin.impl.sdk.o b;
    private final AtomicReference c = new AtomicReference();

    public a4(com.applovin.impl.sdk.k kVar) {
        this.f321a = kVar;
        this.b = kVar.O();
    }

    private OkHttpClient a() {
        Object objBuild = this.c.get();
        if (objBuild == null) {
            synchronized (this.c) {
                objBuild = this.c.get();
                if (objBuild == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    long jIntValue = ((Integer) this.f321a.a(v4.R2)).intValue();
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    objBuild = builder.connectTimeout(jIntValue, timeUnit).readTimeout(((Integer) this.f321a.a(v4.S2)).intValue(), timeUnit).followRedirects(true).followSslRedirects(true).build();
                    if (objBuild == null) {
                        objBuild = this.c;
                    }
                    this.c.set(objBuild);
                }
            }
        }
        if (objBuild == this.c) {
            objBuild = null;
        }
        return (OkHttpClient) objBuild;
    }

    @Override // com.applovin.impl.f2
    public InputStream a(String str, Map map) throws IOException {
        Response responseExecute = a().newCall(new Request.Builder().url(str).get().build()).execute();
        int iCode = responseExecute.code();
        this.f321a.E().a("loadResource", str, iCode, responseExecute.message());
        if (r0.a(iCode)) {
            return null;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.b.a("OkHttpLoader", "Opened stream to resource " + str);
        }
        ResponseBody responseBodyBody = responseExecute.body();
        if (responseBodyBody == null) {
            return null;
        }
        HashMap<String, String> mapHashMap = CollectionUtils.hashMap("url", str);
        mapHashMap.putAll(map);
        CollectionUtils.putStringIfValid("source", "OkHttpLoader", mapHashMap);
        CollectionUtils.putStringIfValid("details", responseExecute.protocol().name(), mapHashMap);
        this.f321a.g().d(c2.C, mapHashMap);
        return responseBodyBody.byteStream();
    }
}
