package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.u;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.plugins.HttpRequestRetryKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.util.cio.FileChannelsKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteWriteChannel;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: loaded from: classes6.dex */
public final class d implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f6586a;
    public final com.moloco.sdk.internal.error.b b;
    public final HttpClient c;
    public final String d;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.LegacyMediaDownloader$downloadMedia$2", f = "LegacyMediaDownloader.kt", i = {0, 1, 2, 2, 3, 3}, l = {42, 52, 63, 63}, m = "invokeSuspend", n = {"httpRequestComplete", "httpRequestComplete", "response", "httpRequestComplete", "response", "httpRequestComplete"}, s = {"I$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super i.a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6587a;
        public Object b;
        public int c;
        public final /* synthetic */ String e;
        public final /* synthetic */ File f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, File file, Continuation<? super a> continuation) {
            super(2, continuation);
            this.e = str;
            this.f = file;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super i.a> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return d.this.new a(this.e, this.f, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0097 A[Catch: TimeoutCancellationException -> 0x01d1, Exception -> 0x01d3, TryCatch #3 {TimeoutCancellationException -> 0x01d1, blocks: (B:37:0x00cb, B:27:0x008f, B:29:0x0097, B:31:0x009a, B:33:0x00a2, B:34:0x00bc), top: B:81:0x008f }] */
        /* JADX WARN: Code duplicated, block: B:31:0x009a A[Catch: TimeoutCancellationException -> 0x01d1, Exception -> 0x01d3, TryCatch #3 {TimeoutCancellationException -> 0x01d1, blocks: (B:37:0x00cb, B:27:0x008f, B:29:0x0097, B:31:0x009a, B:33:0x00a2, B:34:0x00bc), top: B:81:0x008f }] */
        /* JADX WARN: Code duplicated, block: B:33:0x00a2 A[Catch: TimeoutCancellationException -> 0x01d1, Exception -> 0x01d3, TryCatch #3 {TimeoutCancellationException -> 0x01d1, blocks: (B:37:0x00cb, B:27:0x008f, B:29:0x0097, B:31:0x009a, B:33:0x00a2, B:34:0x00bc), top: B:81:0x008f }] */
        /* JADX WARN: Code duplicated, block: B:36:0x00ca A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:41:0x00dd A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:46:0x011a  */
        /* JADX WARN: Code duplicated, block: B:52:0x015b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:53:0x015c  */
        /* JADX WARN: Code duplicated, block: B:56:0x017e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:57:0x017f  */
        /* JADX WARN: Code duplicated, block: B:69:0x0207  */
        /* JADX WARN: Code duplicated, block: B:72:0x0211  */
        /* JADX WARN: Code duplicated, block: B:73:0x0236  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v30 */
        /* JADX WARN: Type inference failed for: r1v34 */
        /* JADX WARN: Type inference failed for: r1v43 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            int i;
            Object objA;
            Object objA2;
            int i2;
            HttpResponse httpResponse;
            Object objBodyAsChannel;
            HttpResponse httpResponse2;
            Object objCopyAndClose$default;
            HttpResponse httpResponse3;
            HttpResponse httpResponse4;
            int value;
            int value2;
            ?? r1 = "Fetching asset from network: ";
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.c;
            try {
                if (i3 != 0) {
                    try {
                        if (i3 == 1) {
                            int i4 = this.f6587a;
                            ResultKt.throwOnFailure(obj);
                            i = i4;
                            objA = obj;
                            try {
                                if (!((Boolean) objA).booleanValue()) {
                                    return i.a.AbstractC0600a.n.c;
                                }
                                if (this.f.exists()) {
                                    MolocoLogger.info$default(MolocoLogger.INSTANCE, d.this.d, "Deleting existing file and re-downloading it", null, false, 12, null);
                                    this.f.delete();
                                }
                                d dVar = d.this;
                                String str = this.e;
                                this.f6587a = i;
                                this.c = 2;
                                objA2 = dVar.a(str, this);
                                if (objA2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                httpResponse4 = (HttpResponse) objA2;
                                value = httpResponse4.getStatus().getValue();
                                if (400 > value) {
                                }
                                value2 = httpResponse4.getStatus().getValue();
                                if (500 > value2) {
                                }
                                this.b = httpResponse4;
                                this.f6587a = 1;
                                this.c = 3;
                                objBodyAsChannel = HttpResponseKt.bodyAsChannel(httpResponse4, this);
                                if (objBodyAsChannel == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                httpResponse = httpResponse4;
                                i2 = 1;
                                ByteReadChannel byteReadChannel = (ByteReadChannel) objBodyAsChannel;
                                ByteWriteChannel byteWriteChannelWriteChannel$default = FileChannelsKt.writeChannel$default(this.f, null, 1, null);
                                this.b = httpResponse;
                                this.f6587a = i2;
                                this.c = 4;
                                httpResponse3 = httpResponse;
                                objCopyAndClose$default = ByteReadChannelKt.copyAndClose$default(byteReadChannel, byteWriteChannelWriteChannel$default, 0L, this, 2, null);
                                if (objCopyAndClose$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                httpResponse2 = httpResponse3;
                            } catch (TimeoutCancellationException unused) {
                                r1 = i;
                                com.moloco.sdk.internal.error.b.a.a(d.this.b, d.this.a(r1 != 0), null, 2, null);
                                if (r1 != 0) {
                                    MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.d, "Timeout occurred after request had completed: " + this.e, null, false, 12, null);
                                } else {
                                    MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.d, "Timeout occurred when still waiting for request to complete: " + this.e, null, false, 12, null);
                                }
                                throw new p();
                            }
                        } else if (i3 == 2) {
                            int i5 = this.f6587a;
                            ResultKt.throwOnFailure(obj);
                            objA2 = obj;
                            httpResponse4 = (HttpResponse) objA2;
                            try {
                                value = httpResponse4.getStatus().getValue();
                                if (400 > value && value < 500) {
                                    MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.d, "Failed to fetch media from url: " + this.e + ", status: " + httpResponse4.getStatus(), null, false, 12, null);
                                    return i.a.AbstractC0600a.e.c;
                                }
                                value2 = httpResponse4.getStatus().getValue();
                                if (500 > value2 && value2 < 600) {
                                    MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.d, "Failed to fetch media from url: " + this.e + ", status: " + httpResponse4.getStatus(), null, false, 12, null);
                                    return i.a.AbstractC0600a.h.c;
                                }
                                this.b = httpResponse4;
                                this.f6587a = 1;
                                this.c = 3;
                                objBodyAsChannel = HttpResponseKt.bodyAsChannel(httpResponse4, this);
                                if (objBodyAsChannel == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                httpResponse = httpResponse4;
                                i2 = 1;
                                ByteReadChannel byteReadChannel2 = (ByteReadChannel) objBodyAsChannel;
                                ByteWriteChannel byteWriteChannelWriteChannel$default2 = FileChannelsKt.writeChannel$default(this.f, null, 1, null);
                                this.b = httpResponse;
                                this.f6587a = i2;
                                this.c = 4;
                                httpResponse3 = httpResponse;
                                objCopyAndClose$default = ByteReadChannelKt.copyAndClose$default(byteReadChannel2, byteWriteChannelWriteChannel$default2, 0L, this, 2, null);
                                if (objCopyAndClose$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                httpResponse2 = httpResponse3;
                            } catch (TimeoutCancellationException unused2) {
                                r1 = 1;
                                com.moloco.sdk.internal.error.b.a.a(d.this.b, d.this.a(r1 != 0), null, 2, null);
                                if (r1 != 0) {
                                    MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.d, "Timeout occurred after request had completed: " + this.e, null, false, 12, null);
                                } else {
                                    MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.d, "Timeout occurred when still waiting for request to complete: " + this.e, null, false, 12, null);
                                }
                                throw new p();
                            }
                        } else if (i3 == 3) {
                            int i6 = this.f6587a;
                            HttpResponse httpResponse5 = (HttpResponse) this.b;
                            ResultKt.throwOnFailure(obj);
                            i2 = i6;
                            httpResponse = httpResponse5;
                            objBodyAsChannel = obj;
                            try {
                                ByteReadChannel byteReadChannel3 = (ByteReadChannel) objBodyAsChannel;
                                ByteWriteChannel byteWriteChannelWriteChannel$default3 = FileChannelsKt.writeChannel$default(this.f, null, 1, null);
                                this.b = httpResponse;
                                this.f6587a = i2;
                                this.c = 4;
                                httpResponse3 = httpResponse;
                                objCopyAndClose$default = ByteReadChannelKt.copyAndClose$default(byteReadChannel3, byteWriteChannelWriteChannel$default3, 0L, this, 2, null);
                                if (objCopyAndClose$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                httpResponse2 = httpResponse3;
                            } catch (TimeoutCancellationException unused3) {
                                r1 = i2;
                                com.moloco.sdk.internal.error.b.a.a(d.this.b, d.this.a(r1 != 0), null, 2, null);
                                if (r1 != 0) {
                                    MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.d, "Timeout occurred after request had completed: " + this.e, null, false, 12, null);
                                } else {
                                    MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.d, "Timeout occurred when still waiting for request to complete: " + this.e, null, false, 12, null);
                                }
                                throw new p();
                            }
                        } else {
                            if (i3 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i7 = this.f6587a;
                            httpResponse2 = (HttpResponse) this.b;
                            ResultKt.throwOnFailure(obj);
                            i2 = i7;
                            objCopyAndClose$default = obj;
                        }
                    } catch (TimeoutCancellationException unused4) {
                        com.moloco.sdk.internal.error.b.a.a(d.this.b, d.this.a(r1 != 0), null, 2, null);
                        if (r1 != 0) {
                            MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.d, "Timeout occurred after request had completed: " + this.e, null, false, 12, null);
                        } else {
                            MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.d, "Timeout occurred when still waiting for request to complete: " + this.e, null, false, 12, null);
                        }
                        throw new p();
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, d.this.d, "Fetching asset from network: " + this.e, null, false, 12, null);
                        u uVar = d.this.f6586a;
                        this.f6587a = 0;
                        this.c = 1;
                        objA = uVar.a(5000L, this);
                        if (objA == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i = 0;
                        if (!((Boolean) objA).booleanValue()) {
                            return i.a.AbstractC0600a.n.c;
                        }
                        if (this.f.exists()) {
                            MolocoLogger.info$default(MolocoLogger.INSTANCE, d.this.d, "Deleting existing file and re-downloading it", null, false, 12, null);
                            this.f.delete();
                        }
                        d dVar2 = d.this;
                        String str2 = this.e;
                        this.f6587a = i;
                        this.c = 2;
                        objA2 = dVar2.a(str2, this);
                        if (objA2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        httpResponse4 = (HttpResponse) objA2;
                        value = httpResponse4.getStatus().getValue();
                        if (400 > value) {
                        }
                        value2 = httpResponse4.getStatus().getValue();
                        if (500 > value2) {
                        }
                        this.b = httpResponse4;
                        this.f6587a = 1;
                        this.c = 3;
                        objBodyAsChannel = HttpResponseKt.bodyAsChannel(httpResponse4, this);
                        if (objBodyAsChannel == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        httpResponse = httpResponse4;
                        i2 = 1;
                        ByteReadChannel byteReadChannel4 = (ByteReadChannel) objBodyAsChannel;
                        ByteWriteChannel byteWriteChannelWriteChannel$default4 = FileChannelsKt.writeChannel$default(this.f, null, 1, null);
                        this.b = httpResponse;
                        this.f6587a = i2;
                        this.c = 4;
                        httpResponse3 = httpResponse;
                        objCopyAndClose$default = ByteReadChannelKt.copyAndClose$default(byteReadChannel4, byteWriteChannelWriteChannel$default4, 0L, this, 2, null);
                        if (objCopyAndClose$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        httpResponse2 = httpResponse3;
                    } catch (TimeoutCancellationException unused5) {
                        r1 = 0;
                        com.moloco.sdk.internal.error.b.a.a(d.this.b, d.this.a(r1 != 0), null, 2, null);
                        if (r1 != 0) {
                            MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.d, "Timeout occurred after request had completed: " + this.e, null, false, 12, null);
                        } else {
                            MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.d, "Timeout occurred when still waiting for request to complete: " + this.e, null, false, 12, null);
                        }
                        throw new p();
                    }
                }
                MolocoLogger.info$default(MolocoLogger.INSTANCE, d.this.d, "Downloaded full response: " + HttpMessagePropertiesKt.contentLength(httpResponse2) + " and saved to disk: " + ((Number) objCopyAndClose$default).longValue() + " bytes, file size: " + this.f.length(), null, false, 12, null);
                return new i.a.b(this.f);
            } catch (Exception e) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, d.this.d, "Failed to fetch media from url: " + this.e, e, false, 8, null);
                return o.a(e);
            }
        }
    }

    public static final class b extends Lambda implements Function1<HttpRequestRetry.Configuration, Unit> {

        public static final class a extends Lambda implements Function2<HttpRequestRetry.DelayContext, Integer, Long> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f6589a = new a();

            public a() {
                super(2);
            }

            public final Long a(HttpRequestRetry.DelayContext delayMillis, int i) {
                Intrinsics.checkNotNullParameter(delayMillis, "$this$delayMillis");
                return 100L;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Long invoke(HttpRequestRetry.DelayContext delayContext, Integer num) {
                return a(delayContext, num.intValue());
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.d$b$b, reason: collision with other inner class name */
        public static final class C0599b extends Lambda implements Function2<HttpRequestRetry.ModifyRequestContext, HttpRequestBuilder, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f6590a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0599b(d dVar) {
                super(2);
                this.f6590a = dVar;
            }

            public final void a(HttpRequestRetry.ModifyRequestContext modifyRequest, HttpRequestBuilder it) {
                Intrinsics.checkNotNullParameter(modifyRequest, "$this$modifyRequest");
                Intrinsics.checkNotNullParameter(it, "it");
                MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f6590a.d, "Retry attempt #" + modifyRequest.getRetryCount() + " for " + modifyRequest.getRequest().getUrl(), null, false, 12, null);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestRetry.ModifyRequestContext modifyRequestContext, HttpRequestBuilder httpRequestBuilder) {
                a(modifyRequestContext, httpRequestBuilder);
                return Unit.INSTANCE;
            }
        }

        public b() {
            super(1);
        }

        public final void a(HttpRequestRetry.Configuration retry) {
            Intrinsics.checkNotNullParameter(retry, "$this$retry");
            retry.setMaxRetries(10);
            HttpRequestRetry.Configuration.delayMillis$default(retry, false, a.f6589a, 1, null);
            retry.retryOnException(10, true);
            retry.retryOnServerErrors(10);
            retry.modifyRequest(new C0599b(d.this));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HttpRequestRetry.Configuration configuration) {
            a(configuration);
            return Unit.INSTANCE;
        }
    }

    public d(u connectivityService, com.moloco.sdk.internal.error.b errorReportingService, HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(connectivityService, "connectivityService");
        Intrinsics.checkNotNullParameter(errorReportingService, "errorReportingService");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.f6586a = connectivityService;
        this.b = errorReportingService;
        this.c = httpClient;
        this.d = "LegacyMediaDownloader";
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.n
    public Object a(String str, File file, Continuation<? super i.a> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new a(str, file, null), continuation);
    }

    public final Object a(String str, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.c;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        HttpRequestRetryKt.retry(httpRequestBuilder, new b());
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public final String a(boolean z) {
        if (z) {
            return e.f6591a;
        }
        return e.b;
    }
}
