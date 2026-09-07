package com.smaato.sdk.core.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes13.dex */
class RealCall implements Call, Callable<Response> {
    private Future future;
    private final HttpClient httpClient;
    private final Request request;

    RealCall(HttpClient httpClient, Request request) {
        this.httpClient = httpClient;
        this.request = request;
    }

    @Override // com.smaato.sdk.core.network.Call
    public Request request() {
        return this.request;
    }

    @Override // com.smaato.sdk.core.network.Call
    public Response execute() throws IOException {
        Future futureSubmit;
        synchronized (this) {
            if (this.future == null) {
                futureSubmit = this.httpClient.executor().submit(this);
                this.future = futureSubmit;
            } else {
                throw new IllegalStateException("Already executed");
            }
        }
        try {
            return (Response) futureSubmit.get();
        } catch (Exception e) {
            throw findExceptionRoot(e);
        }
    }

    @Override // com.smaato.sdk.core.network.Call
    public void enqueue(final Callback callback) {
        synchronized (this) {
            if (this.future == null) {
                this.future = this.httpClient.executor().submit(new Runnable() { // from class: com.smaato.sdk.core.network.RealCall$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m5571lambda$enqueue$0$comsmaatosdkcorenetworkRealCall(callback);
                    }
                });
            } else {
                throw new IllegalStateException("Already enqueued");
            }
        }
    }

    /* JADX INFO: renamed from: lambda$enqueue$0$com-smaato-sdk-core-network-RealCall, reason: not valid java name */
    /* synthetic */ void m5571lambda$enqueue$0$comsmaatosdkcorenetworkRealCall(Callback callback) {
        try {
            Response responseCall = call();
            try {
                callback.onResponse(this, responseCall);
                if (responseCall != null) {
                    responseCall.close();
                }
            } catch (Throwable th) {
                if (responseCall != null) {
                    try {
                        responseCall.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            callback.onFailure(this, findExceptionRoot(e));
        }
    }

    @Override // com.smaato.sdk.core.network.Call
    public void cancel() {
        synchronized (this) {
            Future future = this.future;
            if (future != null && !future.isCancelled()) {
                this.future.cancel(true);
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Response call() throws Exception {
        ArrayList arrayList = new ArrayList(this.httpClient.interceptors());
        arrayList.add(HttpCaller.INSTANCE);
        return RealChain.builder().readTimeoutMillis(this.httpClient.readTimeoutMillis()).connectTimeoutMillis(this.httpClient.connectTimeoutMillis()).interceptors(arrayList).request(this.request).call(this).build().proceed(this.request);
    }

    private IOException findExceptionRoot(Throwable th) {
        while (th != null) {
            if (th instanceof IOException) {
                return (IOException) th;
            }
            th = th.getCause();
        }
        return new IOException(new Throwable("Unknown Error"));
    }
}
