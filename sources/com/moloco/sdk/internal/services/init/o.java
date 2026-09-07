package com.moloco.sdk.internal.services.init;

import android.net.Uri;
import com.moloco.sdk.MetricsRequest;
import com.moloco.sdk.internal.MolocoLogger;
import io.ktor.http.ContentType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6416a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6417a;

        static {
            int[] iArr = new int[b.values().length];
            try {
                iArr[b.Unknown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b.RequestTimeout.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[b.UnknownHostHttpError.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[b.HttpSocketError.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[b.HttpSslError.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[b.PersistentHttpUnavailableError.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f6417a = iArr;
        }
    }

    public o(String endpoint, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d httpRequestClient) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(httpRequestClient, "httpRequestClient");
        this.f6416a = endpoint;
        this.b = httpRequestClient;
    }

    @Override // com.moloco.sdk.internal.services.init.n
    public Object a(long j, Continuation<? super Unit> continuation) {
        try {
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            MolocoLogger.debug$default(molocoLogger, p.f6418a, "Reporting InitTracking success", false, 4, null);
            if (this.f6416a.length() == 0) {
                MolocoLogger.debug$default(molocoLogger, p.f6418a, "SDK InitTracking disabled", false, 4, null);
                return Unit.INSTANCE;
            }
            Uri uriBuild = Uri.parse(this.f6416a).buildUpon().build();
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d dVar = this.b;
            String string = uriBuild.toString();
            Intrinsics.checkNotNullExpressionValue(string, "preparedUrl.toString()");
            dVar.a(string, a(j), ContentType.Application.INSTANCE.getProtoBuf());
            return Unit.INSTANCE;
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, p.f6418a, "Failed to send notifySuccess post request", e, false, 8, null);
        }
    }

    @Override // com.moloco.sdk.internal.services.init.n
    public Object a(j jVar, long j, Continuation<? super Unit> continuation) {
        try {
            if (jVar instanceof j.a) {
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, p.f6418a, "Reporting InitTracking client failure: " + ((j.a) jVar).a(), false, 4, null);
            } else if (jVar instanceof j.b) {
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, p.f6418a, "Reporting InitTracking server failure: " + ((j.b) jVar).a(), false, 4, null);
            }
            if (this.f6416a.length() == 0) {
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, p.f6418a, "SDK InitTracking disabled", false, 4, null);
                return Unit.INSTANCE;
            }
            Uri uriBuild = Uri.parse(this.f6416a).buildUpon().build();
            byte[] bArrA = a(jVar, j);
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d dVar = this.b;
            String string = uriBuild.toString();
            Intrinsics.checkNotNullExpressionValue(string, "preparedUrl.toString()");
            dVar.a(string, bArrA, ContentType.Application.INSTANCE.getProtoBuf());
            return Unit.INSTANCE;
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, p.f6418a, "Failed to send notifyFailure post request", e, false, 8, null);
        }
    }

    public final byte[] a(long j) {
        MetricsRequest.SDKInitTrackingRequest.Builder builderNewBuilder = MetricsRequest.SDKInitTrackingRequest.newBuilder();
        builderNewBuilder.setLatencyMs(j);
        builderNewBuilder.setSuccess(MetricsRequest.SDKInitSuccessTrackingRequest.newBuilder().build());
        byte[] byteArray = builderNewBuilder.build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "newBuilder().apply {\n   …  }.build().toByteArray()");
        return byteArray;
    }

    public final byte[] a(j jVar, long j) {
        MetricsRequest.SDKInitTrackingRequest.Builder builderNewBuilder = MetricsRequest.SDKInitTrackingRequest.newBuilder();
        MetricsRequest.SDKInitFailureTrackingRequest.Builder builderNewBuilder2 = MetricsRequest.SDKInitFailureTrackingRequest.newBuilder();
        if (jVar instanceof j.a) {
            MetricsRequest.SDKInitFailureTrackingRequest.ClientError.Builder builderNewBuilder3 = MetricsRequest.SDKInitFailureTrackingRequest.ClientError.newBuilder();
            builderNewBuilder3.setClientFailureType(a(((j.a) jVar).a()));
            builderNewBuilder2.setClientError(builderNewBuilder3.build());
        } else if (jVar instanceof j.b) {
            MetricsRequest.SDKInitFailureTrackingRequest.ServerError.Builder builderNewBuilder4 = MetricsRequest.SDKInitFailureTrackingRequest.ServerError.newBuilder();
            builderNewBuilder4.setServerHttpStatus(((j.b) jVar).a());
            builderNewBuilder2.setServerError(builderNewBuilder4.build());
        }
        builderNewBuilder.setFailure(builderNewBuilder2.build());
        builderNewBuilder.setLatencyMs(j);
        byte[] byteArray = builderNewBuilder.build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "newBuilder().apply {\n   …  }.build().toByteArray()");
        return byteArray;
    }

    public final MetricsRequest.SDKInitFailureTrackingRequest.ClientError.ClientErrorTypes a(b bVar) {
        switch (a.f6417a[bVar.ordinal()]) {
            case 1:
                return MetricsRequest.SDKInitFailureTrackingRequest.ClientError.ClientErrorTypes.UNKNOWN;
            case 2:
                return MetricsRequest.SDKInitFailureTrackingRequest.ClientError.ClientErrorTypes.HTTP_REQUEST_TIMEOUT;
            case 3:
                return MetricsRequest.SDKInitFailureTrackingRequest.ClientError.ClientErrorTypes.HTTP_UKNOWN_HOST;
            case 4:
                return MetricsRequest.SDKInitFailureTrackingRequest.ClientError.ClientErrorTypes.HTTP_SOCKET;
            case 5:
                return MetricsRequest.SDKInitFailureTrackingRequest.ClientError.ClientErrorTypes.HTTP_SSL_ERROR;
            case 6:
                return MetricsRequest.SDKInitFailureTrackingRequest.ClientError.ClientErrorTypes.ANDROID_WORK_MANAGER_ISSUE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
