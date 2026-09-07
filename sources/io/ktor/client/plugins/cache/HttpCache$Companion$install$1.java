package io.ktor.client.plugins.cache;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.cache.storage.CachedResponseData;
import io.ktor.client.plugins.cache.storage.HttpCacheStorageKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpCache.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "content"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache$Companion$install$1", f = "HttpCache.kt", i = {1}, l = {145, 149, 155, 165, 170}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
final class HttpCache$Companion$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpCache $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HttpCache$Companion$install$1(HttpCache httpCache, HttpClient httpClient, Continuation<? super HttpCache$Companion$install$1> continuation) {
        super(3, continuation);
        this.$plugin = httpCache;
        this.$scope = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpCache$Companion$install$1 httpCache$Companion$install$1 = new HttpCache$Companion$install$1(this.$plugin, this.$scope, continuation);
        httpCache$Companion$install$1.L$0 = pipelineContext;
        httpCache$Companion$install$1.L$1 = obj;
        return httpCache$Companion$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:40:0x0100  */
    /* JADX WARN: Code duplicated, block: B:42:0x0131 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:45:0x0135  */
    /* JADX WARN: Code duplicated, block: B:47:0x014b  */
    /* JADX WARN: Code duplicated, block: B:49:0x0183 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x0187  */
    /* JADX WARN: Code duplicated, block: B:54:0x018b  */
    /* JADX WARN: Code duplicated, block: B:56:0x01a9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:61:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:64:0x0206  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PipelineContext<Object, HttpRequestBuilder> pipelineContext;
        PipelineContext<Object, HttpRequestBuilder> pipelineContext2;
        CachedResponseData cachedResponseData;
        ValidateStatus validateStatusShouldValidate;
        String str;
        String str2;
        HttpClientCall call;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i != 2) {
                if (i == 3) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i == 4) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            pipelineContext = (PipelineContext) this.L$0;
            ResultKt.throwOnFailure(obj);
            pipelineContext2 = pipelineContext;
            cachedResponseData = (CachedResponseData) obj;
            if (cachedResponseData == null) {
                HttpCacheKt.getLOGGER().trace("No cached response for " + pipelineContext2.getContext().getUrl() + " found");
                if (HttpHeaderValueParserKt.parseHeaderValue(pipelineContext2.getContext().getHeaders().get(HttpHeaders.INSTANCE.getCacheControl())).contains(CacheControl.INSTANCE.getONLY_IF_CACHED$ktor_client_core())) {
                    HttpCacheKt.getLOGGER().trace("No cache found and \"only-if-cached\" set for " + pipelineContext2.getContext().getUrl());
                    this.L$0 = null;
                    this.label = 3;
                    if (HttpCache.INSTANCE.proceedWithMissingCache$ktor_client_core(pipelineContext2, this.$scope, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            validateStatusShouldValidate = HttpCacheEntryKt.shouldValidate(cachedResponseData.getExpires(), cachedResponseData.getHeaders(), pipelineContext2.getContext());
            if (validateStatusShouldValidate == ValidateStatus.ShouldNotValidate) {
                call = HttpCacheStorageKt.createResponse(cachedResponseData, this.$scope, new RequestForCache(pipelineContext2.getContext().build()), pipelineContext2.getContext().getExecutionContext()).getCall();
                this.L$0 = null;
                this.label = 4;
                if (HttpCache.INSTANCE.proceedWithCache$ktor_client_core(pipelineContext2, this.$scope, call, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            if (validateStatusShouldValidate == ValidateStatus.ShouldWarn) {
                this.L$0 = null;
                this.label = 5;
                if (HttpCache.INSTANCE.proceedWithWarning(pipelineContext2, cachedResponseData, this.$scope, pipelineContext2.getContext().getExecutionContext(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            str = cachedResponseData.getHeaders().get(HttpHeaders.INSTANCE.getETag());
            if (str != null) {
                HttpCacheKt.getLOGGER().trace("Adding If-None-Match=" + str + " for " + pipelineContext2.getContext().getUrl());
                UtilsKt.header(pipelineContext2.getContext(), HttpHeaders.INSTANCE.getIfNoneMatch(), str);
            }
            str2 = cachedResponseData.getHeaders().get(HttpHeaders.INSTANCE.getLastModified());
            if (str2 != null) {
                HttpCacheKt.getLOGGER().trace("Adding If-Modified-Since=" + str2 + " for " + pipelineContext2.getContext().getUrl());
                UtilsKt.header(pipelineContext2.getContext(), HttpHeaders.INSTANCE.getIfModifiedSince(), str2);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        pipelineContext = (PipelineContext) this.L$0;
        Object obj2 = this.L$1;
        if (!(obj2 instanceof OutgoingContent.NoContent)) {
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(pipelineContext.getContext().getMethod(), HttpMethod.INSTANCE.getGet()) && HttpCacheKt.canStore(pipelineContext.getContext().getUrl().getProtocol())) {
            if (!this.$plugin.useOldStorage) {
                this.L$0 = pipelineContext;
                this.label = 2;
                obj = this.$plugin.findResponse(pipelineContext.getContext(), (OutgoingContent) obj2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pipelineContext2 = pipelineContext;
                cachedResponseData = (CachedResponseData) obj;
                if (cachedResponseData == null) {
                    HttpCacheKt.getLOGGER().trace("No cached response for " + pipelineContext2.getContext().getUrl() + " found");
                    if (HttpHeaderValueParserKt.parseHeaderValue(pipelineContext2.getContext().getHeaders().get(HttpHeaders.INSTANCE.getCacheControl())).contains(CacheControl.INSTANCE.getONLY_IF_CACHED$ktor_client_core())) {
                        HttpCacheKt.getLOGGER().trace("No cache found and \"only-if-cached\" set for " + pipelineContext2.getContext().getUrl());
                        this.L$0 = null;
                        this.label = 3;
                        if (HttpCache.INSTANCE.proceedWithMissingCache$ktor_client_core(pipelineContext2, this.$scope, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
                validateStatusShouldValidate = HttpCacheEntryKt.shouldValidate(cachedResponseData.getExpires(), cachedResponseData.getHeaders(), pipelineContext2.getContext());
                if (validateStatusShouldValidate == ValidateStatus.ShouldNotValidate) {
                    call = HttpCacheStorageKt.createResponse(cachedResponseData, this.$scope, new RequestForCache(pipelineContext2.getContext().build()), pipelineContext2.getContext().getExecutionContext()).getCall();
                    this.L$0 = null;
                    this.label = 4;
                    if (HttpCache.INSTANCE.proceedWithCache$ktor_client_core(pipelineContext2, this.$scope, call, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                if (validateStatusShouldValidate == ValidateStatus.ShouldWarn) {
                    this.L$0 = null;
                    this.label = 5;
                    if (HttpCache.INSTANCE.proceedWithWarning(pipelineContext2, cachedResponseData, this.$scope, pipelineContext2.getContext().getExecutionContext(), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                str = cachedResponseData.getHeaders().get(HttpHeaders.INSTANCE.getETag());
                if (str != null) {
                    HttpCacheKt.getLOGGER().trace("Adding If-None-Match=" + str + " for " + pipelineContext2.getContext().getUrl());
                    UtilsKt.header(pipelineContext2.getContext(), HttpHeaders.INSTANCE.getIfNoneMatch(), str);
                }
                str2 = cachedResponseData.getHeaders().get(HttpHeaders.INSTANCE.getLastModified());
                if (str2 != null) {
                    HttpCacheKt.getLOGGER().trace("Adding If-Modified-Since=" + str2 + " for " + pipelineContext2.getContext().getUrl());
                    UtilsKt.header(pipelineContext2.getContext(), HttpHeaders.INSTANCE.getIfModifiedSince(), str2);
                }
                return Unit.INSTANCE;
            }
            this.L$0 = null;
            this.label = 1;
            if (HttpCacheLegacyKt.interceptSendLegacy(pipelineContext, this.$plugin, (OutgoingContent) obj2, this.$scope, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
