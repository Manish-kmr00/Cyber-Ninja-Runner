package com.moloco.sdk.internal.services.bidtoken;

import com.google.protobuf.InvalidProtocolBufferException;
import com.moloco.sdk.BidToken;
import com.moloco.sdk.internal.MolocoLogger;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpRequestTimeoutException;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import java.net.UnknownHostException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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

/* JADX INFO: loaded from: classes12.dex */
public final class c implements com.moloco.sdk.internal.services.bidtoken.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6311a;
    public final HttpClient b;
    public final j c;
    public final g d;
    public final String e;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.BidTokenApiImpl$fetchBidToken$2", f = "BidTokenApi.kt", i = {0, 0, 0, 1}, l = {80, 127}, m = "invokeSuspend", n = {"lastResult", "serverBidTokenApiTimer", "attempt", "lastResult"}, s = {"L$0", "L$2", "I$2", "L$0"})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<k, com.moloco.sdk.internal.m>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6312a;
        public Object b;
        public Object c;
        public int d;
        public int e;
        public int f;
        public int g;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<k, com.moloco.sdk.internal.m>> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new a(continuation);
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0082  */
        /* JADX WARN: Code duplicated, block: B:14:0x00c1 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:15:0x00c2  */
        /* JADX WARN: Code duplicated, block: B:18:0x00ed  */
        /* JADX WARN: Code duplicated, block: B:20:0x015b  */
        /* JADX WARN: Code duplicated, block: B:27:0x01ab  */
        /* JADX WARN: Code duplicated, block: B:29:0x01b1  */
        /* JADX WARN: Code duplicated, block: B:33:0x0233 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x0234  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [T, com.moloco.sdk.internal.v$a] */
        /* JADX WARN: Type inference failed for: r9v1, types: [T, com.moloco.sdk.internal.v, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0234 -> B:35:0x0237). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r23) {
            /*
                Method dump skipped, instruction units count: 578
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.bidtoken.c.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.BidTokenApiImpl", f = "BidTokenApi.kt", i = {0}, l = {197, 198}, m = "fetchBidTokenWork", n = {"this"}, s = {"L$0"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6313a;
        public /* synthetic */ Object b;
        public int d;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return c.this.a(null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.services.bidtoken.c$c, reason: collision with other inner class name */
    public static final class C0558c extends Lambda implements Function1<HeadersBuilder, Unit> {
        public C0558c() {
            super(1);
        }

        public final void a(HeadersBuilder headers) {
            Intrinsics.checkNotNullParameter(headers, "$this$headers");
            com.moloco.sdk.internal.n.a(headers, c.this.f6311a, c.this.d.j(), null, 4, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HeadersBuilder headersBuilder) {
            a(headersBuilder);
            return Unit.INSTANCE;
        }
    }

    public c(String sdkVersion, HttpClient httpClient, j httpRequestInfo, g deviceRequestInfo) {
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(httpRequestInfo, "httpRequestInfo");
        Intrinsics.checkNotNullParameter(deviceRequestInfo, "deviceRequestInfo");
        this.f6311a = sdkVersion;
        this.b = httpClient;
        this.c = httpRequestInfo;
        this.d = deviceRequestInfo;
        this.e = "BidTokenApi";
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.a
    public Object a(Continuation<? super com.moloco.sdk.internal.v<k, com.moloco.sdk.internal.m>> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new a(null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0101 A[Catch: InvalidProtocolBufferException -> 0x0030, TryCatch #3 {InvalidProtocolBufferException -> 0x0030, blocks: (B:12:0x002b, B:46:0x0101, B:47:0x012d, B:48:0x0134, B:42:0x00e0), top: B:64:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x012d A[Catch: InvalidProtocolBufferException -> 0x0030, TryCatch #3 {InvalidProtocolBufferException -> 0x0030, blocks: (B:12:0x002b, B:46:0x0101, B:47:0x012d, B:48:0x0134, B:42:0x00e0), top: B:64:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(String str, Continuation<? super com.moloco.sdk.internal.v<k, com.moloco.sdk.internal.m>> continuation) throws Throwable {
        b bVar;
        c cVar;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.d = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object objExecute = bVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.d;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    cVar = (c) bVar.f6313a;
                    try {
                        ResultKt.throwOnFailure(objExecute);
                    } catch (HttpRequestTimeoutException e) {
                        e = e;
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, cVar.e, "Request timeout exception", e, false, 8, null);
                        return new com.moloco.sdk.internal.v.a(new com.moloco.sdk.internal.m("bidtoken request failed due to timeout", com.moloco.sdk.internal.services.bidtoken.b.HTTP_REQUEST_TIMEOUT.b()));
                    } catch (UnknownHostException e2) {
                        e = e2;
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, cVar.e, "Unknown Host Request exception", e, false, 8, null);
                        return new com.moloco.sdk.internal.v.a(new com.moloco.sdk.internal.m("bidtoken request failed due to not being able to connect to host", com.moloco.sdk.internal.services.bidtoken.b.UNKNOWN_HOST.b()));
                    } catch (Exception e3) {
                        e = e3;
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, cVar.e, "Bid Token API Request exception", e, false, 8, null);
                        return new com.moloco.sdk.internal.v.a(new com.moloco.sdk.internal.m("bidtoken request failed due to unknown exception", com.moloco.sdk.internal.services.bidtoken.b.UNKNOWN.b()));
                    }
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objExecute);
                }
                if (objExecute != null) {
                    BidToken.BidTokenResponseV3 bidResponse = BidToken.BidTokenResponseV3.parseFrom((byte[]) objExecute);
                    String bidToken = bidResponse.getBidToken();
                    Intrinsics.checkNotNullExpressionValue(bidToken, "bidResponse.bidToken");
                    String pk = bidResponse.getPk();
                    Intrinsics.checkNotNullExpressionValue(pk, "bidResponse.pk");
                    Intrinsics.checkNotNullExpressionValue(bidResponse, "bidResponse");
                    return new com.moloco.sdk.internal.v.b(new k(bidToken, pk, e.a(bidResponse)));
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
            }
            ResultKt.throwOnFailure(objExecute);
            try {
                HttpClient httpClient = this.b;
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder, str);
                HttpRequestKt.headers(httpRequestBuilder, new C0558c());
                HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getProtoBuf());
                byte[] bArrA = a();
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
                com.moloco.sdk.xenoss.sdkdevkit.android.core.a.a(httpRequestBuilder, this.c.f());
                httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                bVar.f6313a = this;
                bVar.d = 1;
                objExecute = httpStatement.execute(bVar);
                if (objExecute == coroutine_suspended) {
                    return coroutine_suspended;
                }
                cVar = this;
            } catch (HttpRequestTimeoutException e4) {
                e = e4;
                cVar = this;
                MolocoLogger.error$default(MolocoLogger.INSTANCE, cVar.e, "Request timeout exception", e, false, 8, null);
                return new com.moloco.sdk.internal.v.a(new com.moloco.sdk.internal.m("bidtoken request failed due to timeout", com.moloco.sdk.internal.services.bidtoken.b.HTTP_REQUEST_TIMEOUT.b()));
            } catch (UnknownHostException e5) {
                e = e5;
                cVar = this;
                MolocoLogger.error$default(MolocoLogger.INSTANCE, cVar.e, "Unknown Host Request exception", e, false, 8, null);
                return new com.moloco.sdk.internal.v.a(new com.moloco.sdk.internal.m("bidtoken request failed due to not being able to connect to host", com.moloco.sdk.internal.services.bidtoken.b.UNKNOWN_HOST.b()));
            } catch (Exception e6) {
                e = e6;
                cVar = this;
                MolocoLogger.error$default(MolocoLogger.INSTANCE, cVar.e, "Bid Token API Request exception", e, false, 8, null);
                return new com.moloco.sdk.internal.v.a(new com.moloco.sdk.internal.m("bidtoken request failed due to unknown exception", com.moloco.sdk.internal.services.bidtoken.b.UNKNOWN.b()));
            }
            HttpResponse httpResponse = (HttpResponse) objExecute;
            if (Intrinsics.areEqual(httpResponse.getStatus(), HttpStatusCode.INSTANCE.getOK())) {
                HttpClientCall call = httpResponse.getCall();
                KType kTypeTypeOf3 = Reflection.typeOf(byte[].class);
                TypeInfo typeInfoTypeInfoImpl = TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(kTypeTypeOf3), Reflection.getOrCreateKotlinClass(byte[].class), kTypeTypeOf3);
                bVar.f6313a = null;
                bVar.d = 2;
                objExecute = call.bodyNullable(typeInfoTypeInfoImpl, bVar);
                if (objExecute == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (objExecute != null) {
                    BidToken.BidTokenResponseV3 bidResponse2 = BidToken.BidTokenResponseV3.parseFrom((byte[]) objExecute);
                    String bidToken2 = bidResponse2.getBidToken();
                    Intrinsics.checkNotNullExpressionValue(bidToken2, "bidResponse.bidToken");
                    String pk2 = bidResponse2.getPk();
                    Intrinsics.checkNotNullExpressionValue(pk2, "bidResponse.pk");
                    Intrinsics.checkNotNullExpressionValue(bidResponse2, "bidResponse");
                    return new com.moloco.sdk.internal.v.b(new k(bidToken2, pk2, e.a(bidResponse2)));
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
            }
            return new com.moloco.sdk.internal.v.a(new com.moloco.sdk.internal.m("bidtoken request failed", httpResponse.getStatus().getValue()));
        } catch (InvalidProtocolBufferException e7) {
            return new com.moloco.sdk.internal.v.a(new com.moloco.sdk.internal.m("Bidtoken parsing failed. Reason: " + e7, HttpStatusCode.INSTANCE.getBadRequest().getValue()));
        }
    }

    public final byte[] a() {
        byte[] byteArray = BidToken.BidTokenRequestV3.newBuilder().build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "newBuilder().build().toByteArray()");
        return byteArray;
    }
}
