package com.smaato.sdk.core.network;

import java.io.IOException;

/* JADX INFO: loaded from: classes11.dex */
public class HttpNoResponseBodyException extends IOException {
    private final Headers headers;
    private final int responseCode;

    HttpNoResponseBodyException(Throwable th, int i, Headers headers) {
        super(th);
        this.responseCode = i;
        this.headers = headers;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public Headers getHeaders() {
        return this.headers;
    }
}
