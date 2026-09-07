package com.moloco.sdk.acm.http;

import com.json.mediationsdk.utils.IronSourceConstants;
import com.moloco.sdk.MetricsRequest;
import com.vungle.ads.internal.protos.Sdk;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfoJvmKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpClient f6043a;
    public final String b;
    public final String c;

    @DebugMetadata(c = "com.moloco.sdk.acm.http.PostMetricsRequestImpl", f = "PostMetricsRequest.kt", i = {}, l = {54}, m = "execute-0E7RQCE", n = {}, s = {})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f6044a;
        public int c;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.f6044a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objA = f.this.a(null, null, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7903boximpl(objA);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.http.PostMetricsRequestImpl", f = "PostMetricsRequest.kt", i = {0, 1, 1}, l = {Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_WAS_ALREADY_INITIALIZED_EVENT}, m = "makeMetricsRequest-BWLJW6A", n = {"this", "this", "responseStatus"}, s = {"L$0", "L$0", "L$1"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6045a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            Object objA = f.this.a(0L, null, null, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7903boximpl(objA);
        }
    }

    public static final class c extends Lambda implements Function1<HttpTimeout.HttpTimeoutCapabilityConfiguration, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f6046a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(long j) {
            super(1);
            this.f6046a = j;
        }

        public final void a(HttpTimeout.HttpTimeoutCapabilityConfiguration timeout) {
            Intrinsics.checkNotNullParameter(timeout, "$this$timeout");
            timeout.setRequestTimeoutMillis(Long.valueOf(this.f6046a));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
            a(httpTimeoutCapabilityConfiguration);
            return Unit.INSTANCE;
        }
    }

    public f(HttpClient httpClient, String apiUrl) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(apiUrl, "apiUrl");
        this.f6043a = httpClient;
        this.b = apiUrl;
        this.c = "PostMetricsRequest";
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.moloco.sdk.acm.http.e
    public Object a(d dVar, Function1<? super HeadersBuilder, Unit> function1, Continuation<? super Result<String>> continuation) throws Throwable {
        a aVar;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.c;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.c = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        a aVar2 = aVar;
        Object obj = aVar2.f6044a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar2.c;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        aVar2.c = 1;
        Object objA = a(5000L, dVar, function1, aVar2);
        return objA == coroutine_suspended ? coroutine_suspended : objA;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00fe A[Catch: Exception -> 0x003f, TryCatch #0 {Exception -> 0x003f, blocks: (B:13:0x003a, B:41:0x00f0, B:43:0x00fe, B:44:0x011c), top: B:51:0x003a }] */
    /* JADX WARN: Code duplicated, block: B:44:0x011c A[Catch: Exception -> 0x003f, TRY_LEAVE, TryCatch #0 {Exception -> 0x003f, blocks: (B:13:0x003a, B:41:0x00f0, B:43:0x00fe, B:44:0x011c), top: B:51:0x003a }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    public final Object a(long j, d dVar, Function1<? super HeadersBuilder, Unit> function1, Continuation<? super Result<String>> continuation) throws Throwable {
        b bVar;
        f fVar;
        f fVar2;
        HttpStatusCode httpStatusCode;
        String str;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.e = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object objExecute = bVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecute);
            try {
                HttpClient httpClient = this.f6043a;
                String str2 = this.b;
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder, str2);
                HttpTimeoutKt.timeout(httpRequestBuilder, new c(j));
                HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getProtoBuf());
                HttpRequestKt.headers(httpRequestBuilder, function1);
                byte[] bArrA = a(dVar);
                if (bArrA == null) {
                    httpRequestBuilder.setBody(NullBody.INSTANCE);
                    KType kTypeTypeOf = Reflection.typeOf(byte[].class);
                    httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(kTypeTypeOf), Reflection.getOrCreateKotlinClass(byte[].class), kTypeTypeOf));
                } else if (bArrA instanceof OutgoingContent) {
                    httpRequestBuilder.setBody(bArrA);
                    httpRequestBuilder.setBodyType(null);
                } else {
                    httpRequestBuilder.setBody(bArrA);
                    KType kTypeTypeOf2 = Reflection.typeOf(byte[].class);
                    httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(kTypeTypeOf2), Reflection.getOrCreateKotlinClass(byte[].class), kTypeTypeOf2));
                }
                httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                bVar.f6045a = this;
                bVar.e = 1;
                objExecute = httpStatement.execute(bVar);
                if (objExecute == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fVar = this;
            } catch (Exception e) {
                e = e;
                fVar = this;
                fVar2 = fVar;
                com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f6053a, fVar2.c, "Post Metrics Request Exception", e, false, 8, null);
                Result.Companion companion = Result.INSTANCE;
                return Result.m7904constructorimpl(ResultKt.createFailure(e));
            }
        } else {
            if (i2 == 1) {
                fVar = (f) bVar.f6045a;
                try {
                    ResultKt.throwOnFailure(objExecute);
                } catch (Exception e2) {
                    e = e2;
                    fVar2 = fVar;
                    com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f6053a, fVar2.c, "Post Metrics Request Exception", e, false, 8, null);
                    Result.Companion companion2 = Result.INSTANCE;
                    return Result.m7904constructorimpl(ResultKt.createFailure(e));
                }
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                httpStatusCode = (HttpStatusCode) bVar.b;
                fVar2 = (f) bVar.f6045a;
                try {
                    ResultKt.throwOnFailure(objExecute);
                } catch (Exception e3) {
                    e = e3;
                    com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f6053a, fVar2.c, "Post Metrics Request Exception", e, false, 8, null);
                    Result.Companion companion3 = Result.INSTANCE;
                    return Result.m7904constructorimpl(ResultKt.createFailure(e));
                }
            }
            str = (String) objExecute;
            if (Intrinsics.areEqual(httpStatusCode, HttpStatusCode.INSTANCE.getOK())) {
                com.moloco.sdk.acm.services.e.b(com.moloco.sdk.acm.services.e.f6053a, fVar2.c, "Post Metrics Request Success: " + str, false, 4, null);
                Result.Companion companion4 = Result.INSTANCE;
                return Result.m7904constructorimpl(str);
            }
            com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f6053a, fVar2.c, "Post Metrics Request Error: " + str, null, false, 12, null);
            Result.Companion companion5 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(new Exception("PostMetricsRequest Error: " + httpStatusCode)));
        }
        HttpResponse httpResponse = (HttpResponse) objExecute;
        HttpStatusCode status = httpResponse.getStatus();
        bVar.f6045a = fVar;
        bVar.b = status;
        bVar.e = 2;
        objExecute = HttpResponseKt.bodyAsText$default(httpResponse, null, bVar, 1, null);
        if (objExecute == coroutine_suspended) {
            return coroutine_suspended;
        }
        fVar2 = fVar;
        httpStatusCode = status;
        str = (String) objExecute;
        if (Intrinsics.areEqual(httpStatusCode, HttpStatusCode.INSTANCE.getOK())) {
            com.moloco.sdk.acm.services.e.b(com.moloco.sdk.acm.services.e.f6053a, fVar2.c, "Post Metrics Request Success: " + str, false, 4, null);
            Result.Companion companion6 = Result.INSTANCE;
            return Result.m7904constructorimpl(str);
        }
        com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f6053a, fVar2.c, "Post Metrics Request Error: " + str, null, false, 12, null);
        Result.Companion companion7 = Result.INSTANCE;
        return Result.m7904constructorimpl(ResultKt.createFailure(new Exception("PostMetricsRequest Error: " + httpStatusCode)));
    }

    public final byte[] a(d dVar) {
        MetricsRequest.PostMetricsRequest postMetricsRequestBuild = MetricsRequest.PostMetricsRequest.newBuilder().addAllCounts(dVar.a()).addAllDurations(dVar.b()).build();
        Intrinsics.checkNotNullExpressionValue(postMetricsRequestBuild, "newBuilder()\n           …ers)\n            .build()");
        byte[] byteArray = postMetricsRequestBuild.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "metricsRequest.toByteArray()");
        return byteArray;
    }
}
