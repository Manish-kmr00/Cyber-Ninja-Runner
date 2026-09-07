package com.fyber.inneractive.sdk.network;

import okhttp3.Response;

/* JADX INFO: loaded from: classes13.dex */
public final class o0 extends C3136l {
    public final Response g;

    public o0(C3136l c3136l, Response response) {
        this.g = response;
        this.d = c3136l.d;
        this.c = c3136l.c;
        this.e = c3136l.e;
        this.f1924a = c3136l.f1924a;
    }

    @Override // com.fyber.inneractive.sdk.network.C3136l
    public final void a() {
        super.a();
        Response response = this.g;
        if (response != null) {
            response.close();
        }
    }
}
