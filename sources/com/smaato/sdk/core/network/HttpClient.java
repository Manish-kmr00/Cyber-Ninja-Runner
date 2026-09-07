package com.smaato.sdk.core.network;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public abstract class HttpClient implements Call.Factory {
    abstract long connectTimeoutMillis();

    abstract ExecutorService executor();

    abstract List<Interceptor> interceptors();

    abstract long readTimeoutMillis();

    public static Builder builder() {
        Builder builderExecutor = new Builder(Collections.emptyList()).executor(Executors.newFixedThreadPool(10));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builderExecutor.connectTimeout(10L, timeUnit).readTimeout(10L, timeUnit);
    }

    public Builder buildUpon() {
        Builder builderExecutor = new Builder(interceptors()).executor(executor());
        long jConnectTimeoutMillis = connectTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return builderExecutor.connectTimeout(jConnectTimeoutMillis, timeUnit).readTimeout(connectTimeoutMillis(), timeUnit);
    }

    @Override // com.smaato.sdk.core.network.Call.Factory
    public Call newCall(Request request) {
        return new RealCall(this, request);
    }

    public static class Builder {
        private long connectTimeout;
        private ExecutorService executor;
        private final ArrayList interceptors;
        private long readTimeout;

        Builder(List<Interceptor> list) {
            ArrayList arrayList = new ArrayList();
            this.interceptors = arrayList;
            arrayList.addAll(list);
        }

        public Builder executor(ExecutorService executorService) {
            this.executor = executorService;
            return this;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            this.interceptors.add(interceptor);
            return this;
        }

        public Builder addAsFirstInterceptor(Interceptor interceptor) {
            this.interceptors.add(0, interceptor);
            return this;
        }

        public Builder connectTimeout(long j, TimeUnit timeUnit) {
            this.connectTimeout = timeUnit.toMillis(j);
            return this;
        }

        public Builder readTimeout(long j, TimeUnit timeUnit) {
            this.readTimeout = timeUnit.toMillis(j);
            return this;
        }

        public HttpClient build() {
            return new AutoValue_HttpClient(this.executor, Collections.unmodifiableList(this.interceptors), this.connectTimeout, this.readTimeout);
        }
    }
}
