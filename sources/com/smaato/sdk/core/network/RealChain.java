package com.smaato.sdk.core.network;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
abstract class RealChain implements Interceptor.Chain {
    abstract int index();

    abstract List<Interceptor> interceptors();

    RealChain() {
    }

    static Builder builder() {
        return new AutoValue_RealChain.Builder().index(0);
    }

    @Override // com.smaato.sdk.core.network.Interceptor.Chain
    public Response proceed(Request request) throws IOException {
        if (index() >= interceptors().size()) {
            throw new IndexOutOfBoundsException("index = " + index() + ", interceptors = " + interceptors().size());
        }
        RealChain realChainBuild = builder().readTimeoutMillis(readTimeoutMillis()).connectTimeoutMillis(connectTimeoutMillis()).interceptors(interceptors()).index(index() + 1).request(request).call(call()).build();
        Interceptor interceptor = interceptors().get(index());
        Response responseIntercept = interceptor.intercept(realChainBuild);
        if (responseIntercept == null) {
            throw new IOException("interceptor " + interceptor + " returned null");
        }
        if (responseIntercept.body() != null) {
            return responseIntercept;
        }
        throw new IOException("interceptor " + interceptor + " returned response with null body");
    }

    static abstract class Builder {
        abstract RealChain build();

        abstract Builder call(Call call);

        abstract Builder connectTimeoutMillis(long j);

        abstract Builder index(int i);

        abstract Builder interceptors(List<Interceptor> list);

        abstract Builder readTimeoutMillis(long j);

        abstract Builder request(Request request);

        Builder() {
        }
    }
}
