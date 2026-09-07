package com.ogury.core.internal.network;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.ogury.core.internal.g;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkRequest.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/ogury/core/internal/network/NetworkRequest;", "", "", "url", "method", "body", "Lcom/ogury/core/internal/network/HeadersLoader;", "headers", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ogury/core/internal/network/HeadersLoader;)V", "a", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getMethod", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "getBody", "d", "Lcom/ogury/core/internal/network/HeadersLoader;", "getHeaders", "()Lcom/ogury/core/internal/network/HeadersLoader;", "sdk-core_prodRelease"}, k = 1, mv = {2, 0, 0})
public final class NetworkRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String url;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String method;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String body;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final HeadersLoader headers;

    public NetworkRequest(String url, String method, String body, HeadersLoader headers) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.url = url;
        this.method = method;
        this.body = body;
        this.headers = headers;
    }

    public final String getBody() {
        return this.body;
    }

    public final HeadersLoader getHeaders() {
        return this.headers;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getUrl() {
        return this.url;
    }

    public /* synthetic */ NetworkRequest(String str, String str2, String str3, HeadersLoader headersLoader, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? g.f7490a : headersLoader);
    }
}
