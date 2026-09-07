package com.smaato.sdk.core.network;

import java.io.IOException;

/* JADX INFO: loaded from: classes9.dex */
public interface Interceptor {

    public interface Chain {
        Call call();

        long connectTimeoutMillis();

        Response proceed(Request request) throws IOException;

        long readTimeoutMillis();

        Request request();
    }

    Response intercept(Chain chain) throws IOException;
}
