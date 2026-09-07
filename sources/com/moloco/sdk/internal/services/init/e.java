package com.moloco.sdk.internal.services.init;

import android.net.Uri;
import com.facebook.login.LoginLogger;
import com.mbridge.msdk.MBridgeConstans;
import com.moloco.sdk.Init;
import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.x;
import com.moloco.sdk.internal.services.y;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.publisher.MediationInfo;
import com.pubmatic.sdk.crashanalytics.POBCrashAnalyticsConstants;
import com.vungle.ads.internal.protos.Sdk;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpRequestTimeoutException;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements d {
    public final y c;
    public final com.moloco.sdk.internal.services.k d;
    public final com.moloco.sdk.internal.services.usertracker.f e;
    public final String f;
    public final long g;
    public final HttpClient h;
    public final Uri i;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitApiImpl", f = "InitApi.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 2, 2}, l = {65, 141, 93}, m = "invoke", n = {"this", "appKey", "mediationInfo", "httpRequestTimerEvent", POBCrashAnalyticsConstants.DEVICE_INFO_KEY, "appInfo", "this", "httpRequestTimerEvent", "this", "httpRequestTimerEvent"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$0", "L$1"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6397a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public /* synthetic */ Object g;
        public int i;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return e.this.a(null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitApiImpl$invoke$2", f = "InitApi.kt", i = {}, l = {Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Init.SDKInitResponse>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6398a;
        public final /* synthetic */ HttpResponse b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HttpResponse httpResponse, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = httpResponse;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Init.SDKInitResponse> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6398a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, f.f6400a, "Successful Init", null, false, 12, null);
                HttpClientCall call = this.b.getCall();
                KType kTypeTypeOf = Reflection.typeOf(byte[].class);
                TypeInfo typeInfoTypeInfoImpl = TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(kTypeTypeOf), Reflection.getOrCreateKotlinClass(byte[].class), kTypeTypeOf);
                this.f6398a = 1;
                obj = call.bodyNullable(typeInfoTypeInfoImpl, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (obj != null) {
                return Init.SDKInitResponse.parseFrom((byte[]) obj);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
        }
    }

    public static final class c extends Lambda implements Function1<HeadersBuilder, Unit> {
        public final /* synthetic */ x b;
        public final /* synthetic */ MediationInfo c;
        public final /* synthetic */ com.moloco.sdk.internal.services.j d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(x xVar, MediationInfo mediationInfo, com.moloco.sdk.internal.services.j jVar) {
            super(1);
            this.b = xVar;
            this.c = mediationInfo;
            this.d = jVar;
        }

        public final void a(HeadersBuilder headers) {
            Intrinsics.checkNotNullParameter(headers, "$this$headers");
            com.moloco.sdk.internal.n.a(headers, e.this.f, this.b.t(), this.c);
            headers.append("X-Moloco-App-Bundle", this.d.b());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HeadersBuilder headersBuilder) {
            a(headersBuilder);
            return Unit.INSTANCE;
        }
    }

    public e(y deviceInfoService, com.moloco.sdk.internal.services.k appInfoService, com.moloco.sdk.internal.services.usertracker.f userTrackerService, String sdkVersion, String endpoint, long j, HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(deviceInfoService, "deviceInfoService");
        Intrinsics.checkNotNullParameter(appInfoService, "appInfoService");
        Intrinsics.checkNotNullParameter(userTrackerService, "userTrackerService");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.c = deviceInfoService;
        this.d = appInfoService;
        this.e = userTrackerService;
        this.f = sdkVersion;
        this.g = j;
        this.h = httpClient;
        this.i = Uri.parse(endpoint);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x015c A[Catch: Exception -> 0x023b, TRY_LEAVE, TryCatch #2 {Exception -> 0x023b, blocks: (B:38:0x014a, B:40:0x015c, B:46:0x0196, B:49:0x01a2, B:50:0x01f1), top: B:64:0x014a }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0187 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x0188  */
    /* JADX WARN: Code duplicated, block: B:46:0x0196 A[Catch: Exception -> 0x023b, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x023b, blocks: (B:38:0x014a, B:40:0x015c, B:46:0x0196, B:49:0x01a2, B:50:0x01f1), top: B:64:0x014a }] */
    /* JADX WARN: Code duplicated, block: B:49:0x01a2 A[Catch: Exception -> 0x023b, TRY_ENTER, TryCatch #2 {Exception -> 0x023b, blocks: (B:38:0x014a, B:40:0x015c, B:46:0x0196, B:49:0x01a2, B:50:0x01f1), top: B:64:0x014a }] */
    /* JADX WARN: Code duplicated, block: B:50:0x01f1 A[Catch: Exception -> 0x023b, TRY_LEAVE, TryCatch #2 {Exception -> 0x023b, blocks: (B:38:0x014a, B:40:0x015c, B:46:0x0196, B:49:0x01a2, B:50:0x01f1), top: B:64:0x014a }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    @Override // com.moloco.sdk.internal.services.init.d
    public Object a(String str, MediationInfo mediationInfo, Continuation<? super v<Init.SDKInitResponse, j>> continuation) throws Throwable {
        a aVar;
        TimerEvent timerEventStartTimerEvent;
        e eVar;
        com.moloco.sdk.internal.services.j jVarInvoke;
        String str2;
        MediationInfo mediationInfo2;
        x xVar;
        TimerEvent timerEvent;
        e eVar2;
        HttpResponse httpResponse;
        HttpStatusCode status;
        HttpStatusCode.Companion companion;
        v.a aVar2;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.i = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objExecute = aVar.g;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.i;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecute);
                timerEventStartTimerEvent = AndroidClientMetrics.INSTANCE.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.SDKInitHttpRequest.b());
                try {
                    x xVarInvoke = this.c.invoke();
                    jVarInvoke = this.d.invoke();
                    com.moloco.sdk.internal.services.usertracker.f fVar = this.e;
                    aVar.f6397a = this;
                    str2 = str;
                    aVar.b = str2;
                    aVar.c = mediationInfo;
                    aVar.d = timerEventStartTimerEvent;
                    aVar.e = xVarInvoke;
                    aVar.f = jVarInvoke;
                    aVar.i = 1;
                    Object objB = fVar.b(aVar);
                    if (objB == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mediationInfo2 = mediationInfo;
                    eVar = this;
                    xVar = xVarInvoke;
                    objExecute = objB;
                } catch (Exception e) {
                    e = e;
                    eVar = this;
                    return eVar.a(e, timerEventStartTimerEvent);
                }
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        timerEvent = (TimerEvent) aVar.b;
                        eVar2 = (e) aVar.f6397a;
                        try {
                            ResultKt.throwOnFailure(objExecute);
                            Intrinsics.checkNotNullExpressionValue(objExecute, "response = httpClient.ge…                        }");
                            return new v.b(objExecute);
                        } catch (Exception e2) {
                            e = e2;
                            timerEventStartTimerEvent = timerEvent;
                            eVar = eVar2;
                            return eVar.a(e, timerEventStartTimerEvent);
                        }
                    }
                    TimerEvent timerEvent2 = (TimerEvent) aVar.b;
                    e eVar3 = (e) aVar.f6397a;
                    try {
                        ResultKt.throwOnFailure(objExecute);
                        timerEventStartTimerEvent = timerEvent2;
                        eVar = eVar3;
                        httpResponse = (HttpResponse) objExecute;
                        status = httpResponse.getStatus();
                        companion = HttpStatusCode.INSTANCE;
                        if (Intrinsics.areEqual(status, companion.getOK())) {
                            if (Intrinsics.areEqual(status, companion.getNotFound())) {
                                AndroidClientMetrics.INSTANCE.recordTimerEvent(timerEventStartTimerEvent.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(com.moloco.sdk.internal.client_metrics_data.c.Reason.b(), String.valueOf(status.getValue())));
                                MolocoLogger.error$default(MolocoLogger.INSTANCE, f.f6400a, "http status " + status + ": App not found or AppKey is not correct", null, false, 12, null);
                                aVar2 = new v.a(new j.b(status.getValue()));
                            } else {
                                AndroidClientMetrics.INSTANCE.recordTimerEvent(timerEventStartTimerEvent.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(com.moloco.sdk.internal.client_metrics_data.c.Reason.b(), String.valueOf(status.getValue())));
                                MolocoLogger.error$default(MolocoLogger.INSTANCE, f.f6400a, "SDK Init failed with status code: " + status, null, false, 12, null);
                                aVar2 = new v.a(new j.b(status.getValue()));
                            }
                            return aVar2;
                        }
                        AndroidClientMetrics.INSTANCE.recordTimerEvent(timerEventStartTimerEvent.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), "success"));
                        CoroutineContext io2 = com.moloco.sdk.internal.scheduling.b.a().getIo();
                        b bVar = new b(httpResponse, null);
                        aVar.f6397a = eVar;
                        aVar.b = timerEventStartTimerEvent;
                        aVar.i = 3;
                        objExecute = BuildersKt.withContext(io2, bVar, aVar);
                        if (objExecute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        timerEvent = timerEventStartTimerEvent;
                        eVar2 = eVar;
                        Intrinsics.checkNotNullExpressionValue(objExecute, "response = httpClient.ge…                        }");
                        return new v.b(objExecute);
                    } catch (Exception e3) {
                        e = e3;
                        timerEvent = timerEvent2;
                        eVar2 = eVar3;
                        timerEventStartTimerEvent = timerEvent;
                        eVar = eVar2;
                        return eVar.a(e, timerEventStartTimerEvent);
                    }
                }
                jVarInvoke = (com.moloco.sdk.internal.services.j) aVar.f;
                xVar = (x) aVar.e;
                timerEventStartTimerEvent = (TimerEvent) aVar.d;
                mediationInfo2 = (MediationInfo) aVar.c;
                str2 = (String) aVar.b;
                eVar = (e) aVar.f6397a;
                try {
                    ResultKt.throwOnFailure(objExecute);
                } catch (Exception e4) {
                    e = e4;
                    return eVar.a(e, timerEventStartTimerEvent);
                }
            }
            httpResponse = (HttpResponse) objExecute;
            status = httpResponse.getStatus();
            companion = HttpStatusCode.INSTANCE;
            if (Intrinsics.areEqual(status, companion.getOK())) {
                if (Intrinsics.areEqual(status, companion.getNotFound())) {
                    AndroidClientMetrics.INSTANCE.recordTimerEvent(timerEventStartTimerEvent.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(com.moloco.sdk.internal.client_metrics_data.c.Reason.b(), String.valueOf(status.getValue())));
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, f.f6400a, "http status " + status + ": App not found or AppKey is not correct", null, false, 12, null);
                    aVar2 = new v.a(new j.b(status.getValue()));
                } else {
                    AndroidClientMetrics.INSTANCE.recordTimerEvent(timerEventStartTimerEvent.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(com.moloco.sdk.internal.client_metrics_data.c.Reason.b(), String.valueOf(status.getValue())));
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, f.f6400a, "SDK Init failed with status code: " + status, null, false, 12, null);
                    aVar2 = new v.a(new j.b(status.getValue()));
                }
                return aVar2;
            }
            AndroidClientMetrics.INSTANCE.recordTimerEvent(timerEventStartTimerEvent.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), "success"));
            CoroutineContext io3 = com.moloco.sdk.internal.scheduling.b.a().getIo();
            b bVar2 = new b(httpResponse, null);
            aVar.f6397a = eVar;
            aVar.b = timerEventStartTimerEvent;
            aVar.i = 3;
            objExecute = BuildersKt.withContext(io3, bVar2, aVar);
            if (objExecute == coroutine_suspended) {
                return coroutine_suspended;
            }
            timerEvent = timerEventStartTimerEvent;
            eVar2 = eVar;
            Intrinsics.checkNotNullExpressionValue(objExecute, "response = httpClient.ge…                        }");
            return new v.b(objExecute);
        } catch (Exception e5) {
            e = e5;
            timerEvent = timerEventStartTimerEvent;
            eVar2 = eVar;
            timerEventStartTimerEvent = timerEvent;
            eVar = eVar2;
            return eVar.a(e, timerEventStartTimerEvent);
        }
        String str3 = (String) objExecute;
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, f.f6400a, "Requesting Init with appKey: " + str2 + ", mref: " + str3 + ", url: " + eVar.i, false, 4, null);
        HttpClient httpClient = eVar.h;
        String string = eVar.i.buildUpon().appendQueryParameter(MBridgeConstans.APP_KEY, str2).appendQueryParameter(com.safedk.android.analytics.brandsafety.l.x, str3).build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "endpointUri.buildUpon()\n…              .toString()");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, string);
        HttpRequestKt.headers(httpRequestBuilder, eVar.new c(xVar, mediationInfo2, jVarInvoke));
        com.moloco.sdk.xenoss.sdkdevkit.android.core.a.a(httpRequestBuilder, eVar.g);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        aVar.f6397a = eVar;
        aVar.b = timerEventStartTimerEvent;
        aVar.c = null;
        aVar.d = null;
        aVar.e = null;
        aVar.f = null;
        aVar.i = 2;
        objExecute = httpStatement.execute(aVar);
        if (objExecute == coroutine_suspended) {
            return coroutine_suspended;
        }
    }

    public final v<Init.SDKInitResponse, j> a(Exception exc, TimerEvent timerEvent) {
        com.moloco.sdk.internal.services.init.b bVar;
        if (exc instanceof HttpRequestTimeoutException) {
            bVar = com.moloco.sdk.internal.services.init.b.RequestTimeout;
        } else if (exc instanceof SSLHandshakeException) {
            bVar = com.moloco.sdk.internal.services.init.b.HttpSslError;
        } else if (exc instanceof SocketException) {
            bVar = com.moloco.sdk.internal.services.init.b.HttpSocketError;
        } else {
            bVar = exc instanceof UnknownHostException ? com.moloco.sdk.internal.services.init.b.UnknownHostHttpError : com.moloco.sdk.internal.services.init.b.Unknown;
        }
        MolocoLogger.error$default(MolocoLogger.INSTANCE, f.f6400a, "SDK Init failed with client exception", exc, false, 8, null);
        AndroidClientMetrics.INSTANCE.recordTimerEvent(timerEvent.withTag(com.moloco.sdk.internal.client_metrics_data.c.Result.b(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(com.moloco.sdk.internal.client_metrics_data.c.Reason.b(), bVar.name()));
        return new v.a(new j.a(bVar));
    }
}
