package com.smaato.sdk.core.network;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_RealChain extends RealChain {
    private final Call call;
    private final long connectTimeoutMillis;
    private final int index;
    private final List interceptors;
    private final long readTimeoutMillis;
    private final Request request;

    private AutoValue_RealChain(Call call, Request request, long j, long j2, List list, int i) {
        this.call = call;
        this.request = request;
        this.connectTimeoutMillis = j;
        this.readTimeoutMillis = j2;
        this.interceptors = list;
        this.index = i;
    }

    @Override // com.smaato.sdk.core.network.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // com.smaato.sdk.core.network.Interceptor.Chain
    public Request request() {
        return this.request;
    }

    @Override // com.smaato.sdk.core.network.Interceptor.Chain
    public long connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override // com.smaato.sdk.core.network.Interceptor.Chain
    public long readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Override // com.smaato.sdk.core.network.RealChain
    List<Interceptor> interceptors() {
        return this.interceptors;
    }

    @Override // com.smaato.sdk.core.network.RealChain
    int index() {
        return this.index;
    }

    public String toString() {
        return "RealChain{call=" + this.call + ", request=" + this.request + ", connectTimeoutMillis=" + this.connectTimeoutMillis + ", readTimeoutMillis=" + this.readTimeoutMillis + ", interceptors=" + this.interceptors + ", index=" + this.index + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RealChain)) {
            return false;
        }
        RealChain realChain = (RealChain) obj;
        return this.call.equals(realChain.call()) && this.request.equals(realChain.request()) && this.connectTimeoutMillis == realChain.connectTimeoutMillis() && this.readTimeoutMillis == realChain.readTimeoutMillis() && this.interceptors.equals(realChain.interceptors()) && this.index == realChain.index();
    }

    public int hashCode() {
        int iHashCode = (((this.call.hashCode() ^ 1000003) * 1000003) ^ this.request.hashCode()) * 1000003;
        long j = this.connectTimeoutMillis;
        int i = (iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.readTimeoutMillis;
        return ((((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.interceptors.hashCode()) * 1000003) ^ this.index;
    }

    static final class Builder extends RealChain.Builder {
        private Call call;
        private Long connectTimeoutMillis;
        private Integer index;
        private List interceptors;
        private Long readTimeoutMillis;
        private Request request;

        Builder() {
        }

        @Override // com.smaato.sdk.core.network.RealChain.Builder
        RealChain.Builder call(Call call) {
            if (call == null) {
                throw new NullPointerException("Null call");
            }
            this.call = call;
            return this;
        }

        @Override // com.smaato.sdk.core.network.RealChain.Builder
        RealChain.Builder request(Request request) {
            if (request == null) {
                throw new NullPointerException("Null request");
            }
            this.request = request;
            return this;
        }

        @Override // com.smaato.sdk.core.network.RealChain.Builder
        RealChain.Builder connectTimeoutMillis(long j) {
            this.connectTimeoutMillis = Long.valueOf(j);
            return this;
        }

        @Override // com.smaato.sdk.core.network.RealChain.Builder
        RealChain.Builder readTimeoutMillis(long j) {
            this.readTimeoutMillis = Long.valueOf(j);
            return this;
        }

        @Override // com.smaato.sdk.core.network.RealChain.Builder
        RealChain.Builder interceptors(List<Interceptor> list) {
            if (list == null) {
                throw new NullPointerException("Null interceptors");
            }
            this.interceptors = list;
            return this;
        }

        @Override // com.smaato.sdk.core.network.RealChain.Builder
        RealChain.Builder index(int i) {
            this.index = Integer.valueOf(i);
            return this;
        }

        @Override // com.smaato.sdk.core.network.RealChain.Builder
        RealChain build() {
            String str;
            if (this.call != null) {
                str = "";
            } else {
                str = " call";
            }
            if (this.request == null) {
                str = str + " request";
            }
            if (this.connectTimeoutMillis == null) {
                str = str + " connectTimeoutMillis";
            }
            if (this.readTimeoutMillis == null) {
                str = str + " readTimeoutMillis";
            }
            if (this.interceptors == null) {
                str = str + " interceptors";
            }
            if (this.index == null) {
                str = str + " index";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_RealChain(this.call, this.request, this.connectTimeoutMillis.longValue(), this.readTimeoutMillis.longValue(), this.interceptors, this.index.intValue());
        }
    }
}
