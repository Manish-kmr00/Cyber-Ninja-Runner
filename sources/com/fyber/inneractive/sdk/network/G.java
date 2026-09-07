package com.fyber.inneractive.sdk.network;

import com.unity3d.services.core.network.core.OkHttp3Client;

/* JADX INFO: loaded from: classes7.dex */
public final class G {
    public static final G c = new G();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3135k f1906a = new C3135k();
    public p0 b;

    public final InterfaceC3132h a() {
        String property;
        if (this.b == null) {
            try {
                property = System.getProperty("fyber.marketplace.http_executor_stack_name");
            } catch (Throwable unused) {
                property = "hurl";
            }
            if (property != null && property.equals(OkHttp3Client.NETWORK_CLIENT_OKHTTP)) {
                try {
                    Class.forName("okhttp3.OkHttpClient");
                    this.b = new p0();
                } catch (ClassNotFoundException unused2) {
                }
            }
        }
        p0 p0Var = this.b;
        return p0Var != null ? p0Var : this.f1906a;
    }
}
