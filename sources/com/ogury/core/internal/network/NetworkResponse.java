package com.ogury.core.internal.network;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkResponse.kt */
/* JADX INFO: loaded from: classes6.dex */
public abstract class NetworkResponse {

    /* JADX INFO: compiled from: NetworkResponse.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0010\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR+\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/ogury/core/internal/network/NetworkResponse$Failure;", "Lcom/ogury/core/internal/network/NetworkResponse;", "", "responseBody", "", "", "responseHeaders", "", "exception", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/Throwable;)V", "a", "Ljava/lang/String;", "getResponseBody", "()Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/Map;", "getResponseHeaders", "()Ljava/util/Map;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/lang/Throwable;", "getException", "()Ljava/lang/Throwable;", "sdk-core_prodRelease"}, k = 1, mv = {2, 0, 0})
    public static final class Failure extends NetworkResponse {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String responseBody;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final Map<String, List<String>> responseHeaders;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public final Throwable exception;

        public /* synthetic */ Failure(String str, Map map, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : map, th);
        }

        public final Throwable getException() {
            return this.exception;
        }

        public final String getResponseBody() {
            return this.responseBody;
        }

        public final Map<String, List<String>> getResponseHeaders() {
            return this.responseHeaders;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(String responseBody, Map<String, List<String>> map, Throwable exception) {
            super(null);
            Intrinsics.checkNotNullParameter(responseBody, "responseBody");
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.responseBody = responseBody;
            this.responseHeaders = map;
            this.exception = exception;
        }
    }

    /* JADX INFO: compiled from: NetworkResponse.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\f\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR+\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/ogury/core/internal/network/NetworkResponse$Success;", "Lcom/ogury/core/internal/network/NetworkResponse;", "", "responseBody", "", "", "responseHeaders", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "a", "Ljava/lang/String;", "getResponseBody", "()Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/Map;", "getResponseHeaders", "()Ljava/util/Map;", "sdk-core_prodRelease"}, k = 1, mv = {2, 0, 0})
    public static final class Success extends NetworkResponse {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String responseBody;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final Map<String, List<String>> responseHeaders;

        public /* synthetic */ Success(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : map);
        }

        public final String getResponseBody() {
            return this.responseBody;
        }

        public final Map<String, List<String>> getResponseHeaders() {
            return this.responseHeaders;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String responseBody, Map<String, List<String>> map) {
            super(null);
            Intrinsics.checkNotNullParameter(responseBody, "responseBody");
            this.responseBody = responseBody;
            this.responseHeaders = map;
        }
    }

    public /* synthetic */ NetworkResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private NetworkResponse() {
    }
}
