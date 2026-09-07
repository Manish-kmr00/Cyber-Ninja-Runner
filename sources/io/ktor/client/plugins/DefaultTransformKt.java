package io.ktor.client.plugins;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.internal.protos.Sdk;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.util.ByteChannelsKt;
import io.ktor.util.PlatformUtils;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.WriterJob;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.slf4j.Logger;

/* JADX INFO: compiled from: DefaultTransform.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\"\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "defaultTransformers", "", "Lio/ktor/client/HttpClient;", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DefaultTransformKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.defaultTransformers");

    /* JADX INFO: renamed from: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultTransform.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "body"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1", f = "DefaultTransform.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = pipelineContext;
            anonymousClass1.L$1 = obj;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            OutgoingContent.ReadChannelContent readChannelContentPlatformRequestDefaultTransform;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final PipelineContext pipelineContext = (PipelineContext) this.L$0;
                final Object obj2 = this.L$1;
                if (((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().get(HttpHeaders.INSTANCE.getAccept()) == null) {
                    ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().append(HttpHeaders.INSTANCE.getAccept(), "*/*");
                }
                final ContentType contentType = HttpMessagePropertiesKt.contentType((HttpMessageBuilder) pipelineContext.getContext());
                if (obj2 instanceof String) {
                    String str = (String) obj2;
                    if (contentType == null) {
                        contentType = ContentType.Text.INSTANCE.getPlain();
                    }
                    readChannelContentPlatformRequestDefaultTransform = new TextContent(str, contentType, null, 4, null);
                } else if (obj2 instanceof byte[]) {
                    readChannelContentPlatformRequestDefaultTransform = new OutgoingContent.ByteArrayContent(contentType, obj2) { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$1
                        final /* synthetic */ Object $body;
                        private final long contentLength;
                        private final ContentType contentType;

                        {
                            this.$body = obj2;
                            this.contentType = contentType == null ? ContentType.Application.INSTANCE.getOctetStream() : contentType;
                            this.contentLength = ((byte[]) obj2).length;
                        }

                        @Override // io.ktor.http.content.OutgoingContent
                        public ContentType getContentType() {
                            return this.contentType;
                        }

                        @Override // io.ktor.http.content.OutgoingContent
                        public Long getContentLength() {
                            return Long.valueOf(this.contentLength);
                        }

                        @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
                        /* JADX INFO: renamed from: bytes */
                        public byte[] getBytes() {
                            return (byte[]) this.$body;
                        }
                    };
                } else if (obj2 instanceof ByteReadChannel) {
                    readChannelContentPlatformRequestDefaultTransform = new OutgoingContent.ReadChannelContent(pipelineContext, contentType, obj2) { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$2
                        final /* synthetic */ Object $body;
                        private final Long contentLength;
                        private final ContentType contentType;

                        {
                            this.$body = obj2;
                            String str2 = pipelineContext.getContext().getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
                            this.contentLength = str2 != null ? Long.valueOf(Long.parseLong(str2)) : null;
                            this.contentType = contentType == null ? ContentType.Application.INSTANCE.getOctetStream() : contentType;
                        }

                        @Override // io.ktor.http.content.OutgoingContent
                        public Long getContentLength() {
                            return this.contentLength;
                        }

                        @Override // io.ktor.http.content.OutgoingContent
                        public ContentType getContentType() {
                            return this.contentType;
                        }

                        @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                        public ByteReadChannel readFrom() {
                            return (ByteReadChannel) this.$body;
                        }
                    };
                } else {
                    readChannelContentPlatformRequestDefaultTransform = obj2 instanceof OutgoingContent ? (OutgoingContent) obj2 : DefaultTransformersJvmKt.platformRequestDefaultTransform(contentType, (HttpRequestBuilder) pipelineContext.getContext(), obj2);
                }
                if ((readChannelContentPlatformRequestDefaultTransform != null ? readChannelContentPlatformRequestDefaultTransform.getContentType() : null) != null) {
                    ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().remove(HttpHeaders.INSTANCE.getContentType());
                    DefaultTransformKt.LOGGER.trace("Transformed with default transformers request body for " + ((HttpRequestBuilder) pipelineContext.getContext()).getUrl() + " from " + Reflection.getOrCreateKotlinClass(obj2.getClass()));
                    this.L$0 = null;
                    this.label = 1;
                    if (pipelineContext.proceedWith(readChannelContentPlatformRequestDefaultTransform, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static final void defaultTransformers(HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "<this>");
        httpClient.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getRender(), new AnonymousClass1(null));
        httpClient.getResponsePipeline().intercept(HttpResponsePipeline.INSTANCE.getParse(), new AnonymousClass2(null));
        DefaultTransformersJvmKt.platformResponseDefaultTransformers(httpClient);
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultTransform.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "<name for destructuring parameter 0>"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2", f = "DefaultTransform.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6, 6, 7, 7, 8, 8}, l = {TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER, 72, 72, 78, 78, IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_WAS_ALREADY_INITIALIZED_EVENT, 90, 116, Sdk.SDKError.Reason.TPAT_ERROR_VALUE}, m = "invokeSuspend", n = {"$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info", "response", "$this$intercept", "info", "$this$intercept", "info", "$this$intercept", "info"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    static final class AnonymousClass2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        Object L$3;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = pipelineContext;
            anonymousClass2.L$1 = httpResponseContainer;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x0162 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:36:0x0163  */
        /* JADX WARN: Code duplicated, block: B:49:0x01bd A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:50:0x01be  */
        /* JADX WARN: Code duplicated, block: B:63:0x020f  */
        /* JADX WARN: Code duplicated, block: B:73:0x0241  */
        /* JADX WARN: Code duplicated, block: B:76:0x0245  */
        /* JADX WARN: Code duplicated, block: B:80:0x0280 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:81:0x0281  */
        /* JADX WARN: Code duplicated, block: B:98:0x031c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            PipelineContext pipelineContext;
            TypeInfo expectedType;
            Object objProceedWith;
            TypeInfo typeInfo;
            Object objProceedWith2;
            Object byteArray;
            PipelineContext pipelineContext2;
            HttpResponse httpResponse;
            Object remaining$default;
            PipelineContext pipelineContext3;
            TypeInfo typeInfo2;
            TypeInfo typeInfo3;
            PipelineContext pipelineContext4;
            Object remaining$default2;
            PipelineContext pipelineContext5;
            TypeInfo typeInfo4;
            TypeInfo typeInfo5;
            PipelineContext pipelineContext6;
            Object objProceedWith3;
            Object objProceedWith4;
            Object objProceedWith5;
            TypeInfo typeInfo6;
            byte[] bArr;
            Long lContentLength;
            boolean z;
            Object objProceedWith6;
            TypeInfo typeInfo7;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            HttpResponseContainer httpResponseContainer = null;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    pipelineContext = (PipelineContext) this.L$0;
                    HttpResponseContainer httpResponseContainer2 = (HttpResponseContainer) this.L$1;
                    expectedType = httpResponseContainer2.getExpectedType();
                    Object response = httpResponseContainer2.getResponse();
                    if (!(response instanceof ByteReadChannel)) {
                        return Unit.INSTANCE;
                    }
                    HttpResponse response2 = ((HttpClientCall) pipelineContext.getContext()).getResponse();
                    KClass<?> type = expectedType.getType();
                    if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Unit.class))) {
                        ByteReadChannelKt.cancel((ByteReadChannel) response);
                        this.L$0 = pipelineContext;
                        this.L$1 = expectedType;
                        this.label = 1;
                        objProceedWith3 = pipelineContext.proceedWith(new HttpResponseContainer(expectedType, Unit.INSTANCE), this);
                        if (objProceedWith3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        typeInfo = expectedType;
                        httpResponseContainer = (HttpResponseContainer) objProceedWith3;
                        expectedType = typeInfo;
                    } else if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        this.L$0 = pipelineContext;
                        this.L$1 = expectedType;
                        this.L$2 = pipelineContext;
                        this.L$3 = expectedType;
                        this.label = 2;
                        remaining$default2 = ByteReadChannel.DefaultImpls.readRemaining$default((ByteReadChannel) response, 0L, this, 1, null);
                        if (remaining$default2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pipelineContext5 = pipelineContext;
                        typeInfo4 = expectedType;
                        typeInfo5 = typeInfo4;
                        pipelineContext6 = pipelineContext5;
                        this.L$0 = pipelineContext6;
                        this.L$1 = typeInfo4;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 3;
                        objProceedWith4 = pipelineContext5.proceedWith(new HttpResponseContainer(typeInfo5, Boxing.boxInt(Integer.parseInt(Input.readText$default((Input) remaining$default2, 0, 0, 3, null)))), this);
                        if (objProceedWith4 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        typeInfo = typeInfo4;
                        httpResponseContainer = (HttpResponseContainer) objProceedWith4;
                        pipelineContext = pipelineContext6;
                        expectedType = typeInfo;
                    } else {
                        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(ByteReadPacket.class)) ? true : Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Input.class))) {
                            this.L$0 = pipelineContext;
                            this.L$1 = expectedType;
                            this.L$2 = pipelineContext;
                            this.L$3 = expectedType;
                            this.label = 4;
                            remaining$default = ByteReadChannel.DefaultImpls.readRemaining$default((ByteReadChannel) response, 0L, this, 1, null);
                            if (remaining$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            pipelineContext3 = pipelineContext;
                            typeInfo2 = expectedType;
                            typeInfo3 = typeInfo2;
                            pipelineContext4 = pipelineContext3;
                            this.L$0 = pipelineContext3;
                            this.L$1 = typeInfo2;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 5;
                            objProceedWith5 = pipelineContext4.proceedWith(new HttpResponseContainer(typeInfo3, remaining$default), this);
                            if (objProceedWith5 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            typeInfo6 = typeInfo2;
                            httpResponseContainer = (HttpResponseContainer) objProceedWith5;
                            expectedType = typeInfo6;
                            pipelineContext = pipelineContext3;
                        } else if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(byte[].class))) {
                            this.L$0 = pipelineContext;
                            this.L$1 = expectedType;
                            this.L$2 = response2;
                            this.label = 6;
                            byteArray = ByteChannelsKt.toByteArray((ByteReadChannel) response, this);
                            if (byteArray == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            pipelineContext2 = pipelineContext;
                            httpResponse = response2;
                            bArr = (byte[]) byteArray;
                            lContentLength = HttpMessagePropertiesKt.contentLength(httpResponse);
                            if (PlatformUtils.INSTANCE.getIS_BROWSER() && httpResponse.getHeaders().get(HttpHeaders.INSTANCE.getContentEncoding()) == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            boolean zAreEqual = Intrinsics.areEqual(((HttpClientCall) pipelineContext2.getContext()).getRequest().getMethod(), HttpMethod.INSTANCE.getHead());
                            if (z && !zAreEqual && lContentLength != null && lContentLength.longValue() > 0) {
                                if (!(bArr.length == ((int) lContentLength.longValue()))) {
                                    throw new IllegalStateException(("Expected " + lContentLength + ", actual " + bArr.length).toString());
                                }
                            }
                            this.L$0 = pipelineContext2;
                            this.L$1 = expectedType;
                            this.L$2 = null;
                            this.label = 7;
                            objProceedWith6 = pipelineContext2.proceedWith(new HttpResponseContainer(expectedType, bArr), this);
                            if (objProceedWith6 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            typeInfo7 = expectedType;
                            httpResponseContainer = (HttpResponseContainer) objProceedWith6;
                            expectedType = typeInfo7;
                            pipelineContext = pipelineContext2;
                        } else if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(ByteReadChannel.class))) {
                            final CompletableJob completableJobJob = JobKt.Job((Job) response2.getCoroutineContext().get(Job.INSTANCE));
                            WriterJob writerJobWriter$default = CoroutinesKt.writer$default((CoroutineScope) pipelineContext, response2.getCoroutineContext(), false, (Function2) new DefaultTransformKt$defaultTransformers$2$result$channel$1(response, response2, null), 2, (Object) null);
                            writerJobWriter$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2$result$channel$2$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                    invoke2(th);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable th) {
                                    completableJobJob.complete();
                                }
                            });
                            this.L$0 = pipelineContext;
                            this.L$1 = expectedType;
                            this.label = 8;
                            objProceedWith2 = pipelineContext.proceedWith(new HttpResponseContainer(expectedType, writerJobWriter$default.getChannel()), this);
                            if (objProceedWith2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            typeInfo = expectedType;
                            httpResponseContainer = (HttpResponseContainer) objProceedWith2;
                            expectedType = typeInfo;
                        } else if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(HttpStatusCode.class))) {
                            ByteReadChannelKt.cancel((ByteReadChannel) response);
                            this.L$0 = pipelineContext;
                            this.L$1 = expectedType;
                            this.label = 9;
                            objProceedWith = pipelineContext.proceedWith(new HttpResponseContainer(expectedType, response2.getStatus()), this);
                            if (objProceedWith == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            typeInfo = expectedType;
                            httpResponseContainer = (HttpResponseContainer) objProceedWith;
                            expectedType = typeInfo;
                        }
                    }
                    if (httpResponseContainer != null) {
                        DefaultTransformKt.LOGGER.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                    }
                    return Unit.INSTANCE;
                case 1:
                    typeInfo = (TypeInfo) this.L$1;
                    pipelineContext = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objProceedWith3 = obj;
                    httpResponseContainer = (HttpResponseContainer) objProceedWith3;
                    expectedType = typeInfo;
                    if (httpResponseContainer != null) {
                        DefaultTransformKt.LOGGER.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                    }
                    return Unit.INSTANCE;
                case 2:
                    typeInfo5 = (TypeInfo) this.L$3;
                    PipelineContext pipelineContext7 = (PipelineContext) this.L$2;
                    typeInfo4 = (TypeInfo) this.L$1;
                    pipelineContext6 = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    pipelineContext5 = pipelineContext7;
                    remaining$default2 = obj;
                    this.L$0 = pipelineContext6;
                    this.L$1 = typeInfo4;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 3;
                    objProceedWith4 = pipelineContext5.proceedWith(new HttpResponseContainer(typeInfo5, Boxing.boxInt(Integer.parseInt(Input.readText$default((Input) remaining$default2, 0, 0, 3, null)))), this);
                    if (objProceedWith4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    typeInfo = typeInfo4;
                    httpResponseContainer = (HttpResponseContainer) objProceedWith4;
                    pipelineContext = pipelineContext6;
                    expectedType = typeInfo;
                    if (httpResponseContainer != null) {
                        DefaultTransformKt.LOGGER.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                    }
                    return Unit.INSTANCE;
                case 3:
                    typeInfo = (TypeInfo) this.L$1;
                    PipelineContext pipelineContext8 = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    pipelineContext6 = pipelineContext8;
                    objProceedWith4 = obj;
                    httpResponseContainer = (HttpResponseContainer) objProceedWith4;
                    pipelineContext = pipelineContext6;
                    expectedType = typeInfo;
                    if (httpResponseContainer != null) {
                        DefaultTransformKt.LOGGER.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                    }
                    return Unit.INSTANCE;
                case 4:
                    typeInfo3 = (TypeInfo) this.L$3;
                    PipelineContext pipelineContext9 = (PipelineContext) this.L$2;
                    typeInfo2 = (TypeInfo) this.L$1;
                    pipelineContext3 = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    pipelineContext4 = pipelineContext9;
                    remaining$default = obj;
                    this.L$0 = pipelineContext3;
                    this.L$1 = typeInfo2;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 5;
                    objProceedWith5 = pipelineContext4.proceedWith(new HttpResponseContainer(typeInfo3, remaining$default), this);
                    if (objProceedWith5 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    typeInfo6 = typeInfo2;
                    httpResponseContainer = (HttpResponseContainer) objProceedWith5;
                    expectedType = typeInfo6;
                    pipelineContext = pipelineContext3;
                    if (httpResponseContainer != null) {
                        DefaultTransformKt.LOGGER.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                    }
                    return Unit.INSTANCE;
                case 5:
                    typeInfo6 = (TypeInfo) this.L$1;
                    PipelineContext pipelineContext10 = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    pipelineContext3 = pipelineContext10;
                    objProceedWith5 = obj;
                    httpResponseContainer = (HttpResponseContainer) objProceedWith5;
                    expectedType = typeInfo6;
                    pipelineContext = pipelineContext3;
                    if (httpResponseContainer != null) {
                        DefaultTransformKt.LOGGER.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                    }
                    return Unit.INSTANCE;
                case 6:
                    httpResponse = (HttpResponse) this.L$2;
                    TypeInfo typeInfo8 = (TypeInfo) this.L$1;
                    PipelineContext pipelineContext11 = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    pipelineContext2 = pipelineContext11;
                    expectedType = typeInfo8;
                    byteArray = obj;
                    bArr = (byte[]) byteArray;
                    lContentLength = HttpMessagePropertiesKt.contentLength(httpResponse);
                    if (PlatformUtils.INSTANCE.getIS_BROWSER()) {
                        z = false;
                    } else {
                        z = false;
                    }
                    boolean zAreEqual2 = Intrinsics.areEqual(((HttpClientCall) pipelineContext2.getContext()).getRequest().getMethod(), HttpMethod.INSTANCE.getHead());
                    if (z) {
                        if (!(bArr.length == ((int) lContentLength.longValue()))) {
                            throw new IllegalStateException(("Expected " + lContentLength + ", actual " + bArr.length).toString());
                        }
                    }
                    this.L$0 = pipelineContext2;
                    this.L$1 = expectedType;
                    this.L$2 = null;
                    this.label = 7;
                    objProceedWith6 = pipelineContext2.proceedWith(new HttpResponseContainer(expectedType, bArr), this);
                    if (objProceedWith6 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    typeInfo7 = expectedType;
                    httpResponseContainer = (HttpResponseContainer) objProceedWith6;
                    expectedType = typeInfo7;
                    pipelineContext = pipelineContext2;
                    if (httpResponseContainer != null) {
                        DefaultTransformKt.LOGGER.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                    }
                    return Unit.INSTANCE;
                case 7:
                    typeInfo7 = (TypeInfo) this.L$1;
                    PipelineContext pipelineContext12 = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    pipelineContext2 = pipelineContext12;
                    objProceedWith6 = obj;
                    httpResponseContainer = (HttpResponseContainer) objProceedWith6;
                    expectedType = typeInfo7;
                    pipelineContext = pipelineContext2;
                    if (httpResponseContainer != null) {
                        DefaultTransformKt.LOGGER.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                    }
                    return Unit.INSTANCE;
                case 8:
                    typeInfo = (TypeInfo) this.L$1;
                    pipelineContext = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objProceedWith2 = obj;
                    httpResponseContainer = (HttpResponseContainer) objProceedWith2;
                    expectedType = typeInfo;
                    if (httpResponseContainer != null) {
                        DefaultTransformKt.LOGGER.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                    }
                    return Unit.INSTANCE;
                case 9:
                    typeInfo = (TypeInfo) this.L$1;
                    pipelineContext = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objProceedWith = obj;
                    httpResponseContainer = (HttpResponseContainer) objProceedWith;
                    expectedType = typeInfo;
                    if (httpResponseContainer != null) {
                        DefaultTransformKt.LOGGER.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
