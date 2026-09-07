package com.fyber.inneractive.sdk.network;

import com.safedk.android.internal.partials.DTExchangeNetworkBridge;
import java.io.FilterInputStream;
import java.net.HttpURLConnection;
import java.util.Map;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.network.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3134j extends C3136l {
    public final HttpURLConnection g;

    public C3134j(HttpURLConnection httpURLConnection, int i, FilterInputStream filterInputStream, Map map, String str) {
        this.g = httpURLConnection;
        this.f1924a = i;
        this.c = filterInputStream;
        this.d = map;
        this.e = str;
    }

    @Override // com.fyber.inneractive.sdk.network.C3136l
    public final void a() {
        try {
            HttpURLConnection httpURLConnection = this.g;
            if (httpURLConnection != null) {
                DTExchangeNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
            }
        } catch (Throwable unused) {
        }
        super.a();
    }
}
