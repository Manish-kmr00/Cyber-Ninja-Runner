package io.ktor.client.plugins.cache;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.cache.storage.CachedResponseData;
import io.ktor.client.plugins.cache.storage.HttpCacheStorageKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.HttpStatusCodeKt;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "response"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache$Companion$install$2", f = "HttpCache.kt", i = {1, 1, 3, 3}, l = {188, 194, 198, 206, 210}, m = "invokeSuspend", n = {"$this$intercept", "response", "$this$intercept", "response"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class HttpCache$Companion$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpCache $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HttpCache$Companion$install$2(HttpCache httpCache, HttpClient httpClient, Continuation<? super HttpCache$Companion$install$2> continuation) {
        super(3, continuation);
        this.$plugin = httpCache;
        this.$scope = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        HttpCache$Companion$install$2 httpCache$Companion$install$2 = new HttpCache$Companion$install$2(this.$plugin, this.$scope, continuation);
        httpCache$Companion$install$2.L$0 = pipelineContext;
        httpCache$Companion$install$2.L$1 = httpResponse;
        return httpCache$Companion$install$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ed A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:43:0x0102  */
    /* JADX WARN: Code duplicated, block: B:45:0x0146 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x0147  */
    /* JADX WARN: Code duplicated, block: B:49:0x014e  */
    /* JADX WARN: Code duplicated, block: B:51:0x016c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x016d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PipelineContext pipelineContext;
        HttpResponse httpResponse;
        PipelineContext pipelineContext2;
        Object objFindAndRefresh;
        PipelineContext pipelineContext3;
        CachedResponseData cachedResponseData;
        HttpResponse httpResponse2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            pipelineContext = (PipelineContext) this.L$0;
            httpResponse = (HttpResponse) this.L$1;
            if (!Intrinsics.areEqual(httpResponse.getCall().getRequest().getMethod(), HttpMethod.INSTANCE.getGet())) {
                return Unit.INSTANCE;
            }
            if (this.$plugin.useOldStorage) {
                this.L$0 = null;
                this.label = 1;
                if (HttpCacheLegacyKt.interceptReceiveLegacy(pipelineContext, httpResponse, this.$plugin, this.$scope, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                HttpCacheKt.getLOGGER().trace("Caching response for " + httpResponse.getCall().getRequest().getUrl());
                this.L$0 = pipelineContext;
                this.L$1 = httpResponse;
                this.label = 2;
                Object objCacheResponse = this.$plugin.cacheResponse(httpResponse, this);
                if (objCacheResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pipelineContext2 = pipelineContext;
                obj = objCacheResponse;
                cachedResponseData = (CachedResponseData) obj;
                if (cachedResponseData != null) {
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 3;
                    if (pipelineContext2.proceedWith(HttpCacheStorageKt.createResponse(cachedResponseData, this.$scope, HttpResponseKt.getRequest(httpResponse), httpResponse.getCoroutineContext()), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                pipelineContext = pipelineContext2;
                if (Intrinsics.areEqual(httpResponse.getStatus(), HttpStatusCode.INSTANCE.getNotModified())) {
                    HttpCacheKt.getLOGGER().trace("Not modified response for " + httpResponse.getCall().getRequest().getUrl() + ", replying from cache");
                    HttpResponseKt.complete(httpResponse);
                    this.L$0 = pipelineContext;
                    this.L$1 = httpResponse;
                    this.label = 4;
                    objFindAndRefresh = this.$plugin.findAndRefresh(httpResponse.getCall().getRequest(), httpResponse, this);
                    if (objFindAndRefresh == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pipelineContext3 = pipelineContext;
                    obj = objFindAndRefresh;
                    httpResponse2 = (HttpResponse) obj;
                    if (httpResponse2 != null) {
                        throw new InvalidCacheStateException(httpResponse.getCall().getRequest().getUrl());
                    }
                    this.$scope.getMonitor().raise(HttpCache.INSTANCE.getHttpResponseFromCache(), httpResponse2);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 5;
                    if (pipelineContext3.proceedWith(httpResponse2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (Intrinsics.areEqual(httpResponse.getStatus(), HttpStatusCode.INSTANCE.getNotModified())) {
                HttpCacheKt.getLOGGER().trace("Not modified response for " + httpResponse.getCall().getRequest().getUrl() + ", replying from cache");
                HttpResponseKt.complete(httpResponse);
                this.L$0 = pipelineContext;
                this.L$1 = httpResponse;
                this.label = 4;
                objFindAndRefresh = this.$plugin.findAndRefresh(httpResponse.getCall().getRequest(), httpResponse, this);
                if (objFindAndRefresh == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pipelineContext3 = pipelineContext;
                obj = objFindAndRefresh;
                httpResponse2 = (HttpResponse) obj;
                if (httpResponse2 != null) {
                    throw new InvalidCacheStateException(httpResponse.getCall().getRequest().getUrl());
                }
                this.$scope.getMonitor().raise(HttpCache.INSTANCE.getHttpResponseFromCache(), httpResponse2);
                this.L$0 = null;
                this.L$1 = null;
                this.label = 5;
                if (pipelineContext3.proceedWith(httpResponse2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i == 2) {
                httpResponse = (HttpResponse) this.L$1;
                pipelineContext2 = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure(obj);
                cachedResponseData = (CachedResponseData) obj;
                if (cachedResponseData != null) {
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 3;
                    if (pipelineContext2.proceedWith(HttpCacheStorageKt.createResponse(cachedResponseData, this.$scope, HttpResponseKt.getRequest(httpResponse), httpResponse.getCoroutineContext()), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                pipelineContext = pipelineContext2;
                if (Intrinsics.areEqual(httpResponse.getStatus(), HttpStatusCode.INSTANCE.getNotModified())) {
                    HttpCacheKt.getLOGGER().trace("Not modified response for " + httpResponse.getCall().getRequest().getUrl() + ", replying from cache");
                    HttpResponseKt.complete(httpResponse);
                    this.L$0 = pipelineContext;
                    this.L$1 = httpResponse;
                    this.label = 4;
                    objFindAndRefresh = this.$plugin.findAndRefresh(httpResponse.getCall().getRequest(), httpResponse, this);
                    if (objFindAndRefresh == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pipelineContext3 = pipelineContext;
                    obj = objFindAndRefresh;
                    httpResponse2 = (HttpResponse) obj;
                    if (httpResponse2 != null) {
                        throw new InvalidCacheStateException(httpResponse.getCall().getRequest().getUrl());
                    }
                    this.$scope.getMonitor().raise(HttpCache.INSTANCE.getHttpResponseFromCache(), httpResponse2);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 5;
                    if (pipelineContext3.proceedWith(httpResponse2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i == 3) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i == 4) {
                    httpResponse = (HttpResponse) this.L$1;
                    pipelineContext3 = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    httpResponse2 = (HttpResponse) obj;
                    if (httpResponse2 != null) {
                        throw new InvalidCacheStateException(httpResponse.getCall().getRequest().getUrl());
                    }
                    this.$scope.getMonitor().raise(HttpCache.INSTANCE.getHttpResponseFromCache(), httpResponse2);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 5;
                    if (pipelineContext3.proceedWith(httpResponse2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
