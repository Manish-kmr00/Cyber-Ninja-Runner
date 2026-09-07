package com.smaato.sdk.core.network;

import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes12.dex */
final class AutoValue_HttpClient extends HttpClient {
    private final long connectTimeoutMillis;
    private final ExecutorService executor;
    private final List interceptors;
    private final long readTimeoutMillis;

    AutoValue_HttpClient(ExecutorService executorService, List<Interceptor> list, long j, long j2) {
        if (executorService == null) {
            throw new NullPointerException("Null executor");
        }
        this.executor = executorService;
        if (list == null) {
            throw new NullPointerException("Null interceptors");
        }
        this.interceptors = list;
        this.connectTimeoutMillis = j;
        this.readTimeoutMillis = j2;
    }

    @Override // com.smaato.sdk.core.network.HttpClient
    ExecutorService executor() {
        return this.executor;
    }

    @Override // com.smaato.sdk.core.network.HttpClient
    List<Interceptor> interceptors() {
        return this.interceptors;
    }

    @Override // com.smaato.sdk.core.network.HttpClient
    long connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override // com.smaato.sdk.core.network.HttpClient
    long readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public String toString() {
        return "HttpClient{executor=" + this.executor + ", interceptors=" + this.interceptors + ", connectTimeoutMillis=" + this.connectTimeoutMillis + ", readTimeoutMillis=" + this.readTimeoutMillis + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HttpClient)) {
            return false;
        }
        HttpClient httpClient = (HttpClient) obj;
        return this.executor.equals(httpClient.executor()) && this.interceptors.equals(httpClient.interceptors()) && this.connectTimeoutMillis == httpClient.connectTimeoutMillis() && this.readTimeoutMillis == httpClient.readTimeoutMillis();
    }

    public int hashCode() {
        int iHashCode = (((this.executor.hashCode() ^ 1000003) * 1000003) ^ this.interceptors.hashCode()) * 1000003;
        long j = this.connectTimeoutMillis;
        long j2 = this.readTimeoutMillis;
        return ((iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }
}
