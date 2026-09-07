package com.ogury.core.internal.network;

import com.safedk.android.a.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkClient.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0016\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/ogury/core/internal/network/NetworkClient;", "", "", "readTimeout", "connectTimeout", "<init>", "(II)V", "Lcom/ogury/core/internal/network/NetworkRequest;", "request", "Lcom/ogury/core/internal/network/Call;", "newCall", "(Lcom/ogury/core/internal/network/NetworkRequest;)Lcom/ogury/core/internal/network/Call;", "", "url", "body", "Lcom/ogury/core/internal/network/HeadersLoader;", "headers", "Lcom/ogury/core/internal/network/NetworkResponse;", "post", "(Ljava/lang/String;Ljava/lang/String;Lcom/ogury/core/internal/network/HeadersLoader;)Lcom/ogury/core/internal/network/NetworkResponse;", "get", "(Ljava/lang/String;Lcom/ogury/core/internal/network/HeadersLoader;)Lcom/ogury/core/internal/network/NetworkResponse;", "put", "sdk-core_prodRelease"}, k = 1, mv = {2, 0, 0})
public final class NetworkClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7493a;
    public final int b;

    public NetworkClient(int i, int i2) {
        this.f7493a = i;
        this.b = i2;
    }

    public final NetworkResponse get(String url, HeadersLoader headers) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return newCall(new NetworkRequest(url, "GET", "", headers)).execute();
    }

    public final Call newCall(NetworkRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new a(request, this.f7493a, this.b);
    }

    public final NetworkResponse post(String url, String body, HeadersLoader headers) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return newCall(new NetworkRequest(url, "POST", body, headers)).execute();
    }

    public final NetworkResponse put(String url, String body, HeadersLoader headers) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return newCall(new NetworkRequest(url, g.f, body, headers)).execute();
    }
}
