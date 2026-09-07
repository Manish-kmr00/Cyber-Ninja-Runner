package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.extensions.TaskExtensionsKt;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
import com.unity3d.services.core.properties.SdkProperties;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InitializeStateLoadWeb.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb$LoadWebResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2", f = "InitializeStateLoadWeb.kt", i = {0, 0, 1}, l = {46, 64, 71}, m = "invokeSuspend", n = {"$this$withContext", "request", "request"}, s = {"L$0", "L$3", "L$2"})
final class InitializeStateLoadWeb$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends InitializeStateLoadWeb.LoadWebResult>>, Object> {
    final /* synthetic */ InitializeStateLoadWeb.Params $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ InitializeStateLoadWeb this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateLoadWeb$doWork$2(InitializeStateLoadWeb.Params params, InitializeStateLoadWeb initializeStateLoadWeb, Continuation<? super InitializeStateLoadWeb$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
        this.this$0 = initializeStateLoadWeb;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateLoadWeb$doWork$2 initializeStateLoadWeb$doWork$2 = new InitializeStateLoadWeb$doWork$2(this.$params, this.this$0, continuation);
        initializeStateLoadWeb$doWork$2.L$0 = obj;
        return initializeStateLoadWeb$doWork$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends InitializeStateLoadWeb.LoadWebResult>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<InitializeStateLoadWeb.LoadWebResult>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<InitializeStateLoadWeb.LoadWebResult>> continuation) {
        return ((InitializeStateLoadWeb$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x016f A[Catch: all -> 0x01f9, CancellationException -> 0x0226, TryCatch #6 {CancellationException -> 0x0226, all -> 0x01f9, blocks: (B:8:0x001a, B:51:0x0192, B:55:0x01b5, B:57:0x01bf, B:60:0x01ca, B:61:0x01dc, B:63:0x01df, B:64:0x01eb, B:46:0x0169, B:48:0x016f, B:52:0x0195, B:53:0x01a7, B:45:0x015f, B:38:0x012d, B:54:0x01a8, B:37:0x0123, B:23:0x0071, B:13:0x0039, B:43:0x0156, B:40:0x0133), top: B:80:0x000e, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0191 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x0195 A[Catch: all -> 0x01f9, CancellationException -> 0x0226, TryCatch #6 {CancellationException -> 0x0226, all -> 0x01f9, blocks: (B:8:0x001a, B:51:0x0192, B:55:0x01b5, B:57:0x01bf, B:60:0x01ca, B:61:0x01dc, B:63:0x01df, B:64:0x01eb, B:46:0x0169, B:48:0x016f, B:52:0x0195, B:53:0x01a7, B:45:0x015f, B:38:0x012d, B:54:0x01a8, B:37:0x0123, B:23:0x0071, B:13:0x0039, B:43:0x0156, B:40:0x0133), top: B:80:0x000e, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01df A[Catch: all -> 0x01f9, CancellationException -> 0x0226, TryCatch #6 {CancellationException -> 0x0226, all -> 0x01f9, blocks: (B:8:0x001a, B:51:0x0192, B:55:0x01b5, B:57:0x01bf, B:60:0x01ca, B:61:0x01dc, B:63:0x01df, B:64:0x01eb, B:46:0x0169, B:48:0x016f, B:52:0x0195, B:53:0x01a7, B:45:0x015f, B:38:0x012d, B:54:0x01a8, B:37:0x0123, B:23:0x0071, B:13:0x0039, B:43:0x0156, B:40:0x0133), top: B:80:0x000e, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x020a  */
    /* JADX WARN: Code duplicated, block: B:71:0x0211  */
    /* JADX WARN: Code duplicated, block: B:73:0x0217  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.unity3d.services.core.network.model.HttpRequest] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.unity3d.services.core.domain.task.InitializeStateLoadWeb] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM7904constructorimpl;
        Object objM7904constructorimpl2;
        ?? r2;
        ?? r1;
        Object objWithContext;
        Throwable thM7907exceptionOrNullimpl;
        InitializeStateLoadWeb.Params params;
        String string;
        String webViewHash;
        HttpRequest httpRequest;
        HttpRequest httpRequest2;
        InitializeStateLoadWeb initializeStateLoadWeb;
        Object objWithRetry;
        Object objM7904constructorimpl3;
        InitializeStateLoadWeb initializeStateLoadWeb2;
        HttpRequest httpRequest3;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r3 = this.label;
        ?? r4 = 1;
        try {
            try {
                if (r3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    InitializeStateLoadWeb.Params params2 = this.$params;
                    InitializeStateLoadWeb initializeStateLoadWeb3 = this.this$0;
                    Result.Companion companion = Result.INSTANCE;
                    DeviceLog.info("Unity Ads init: loading webapp from " + params2.getConfig().getWebViewUrl());
                    String webViewUrl = params2.getConfig().getWebViewUrl();
                    Intrinsics.checkNotNullExpressionValue(webViewUrl, "params.config.webViewUrl");
                    HttpRequest httpRequest4 = new HttpRequest(webViewUrl, null, RequestType.GET, null, null, null, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131066, null);
                    try {
                        Result.Companion companion2 = Result.INSTANCE;
                        int maxRetries = params2.getConfig().getMaxRetries();
                        double retryScalingFactor = params2.getConfig().getRetryScalingFactor();
                        long retryDelay = params2.getConfig().getRetryDelay();
                        InitializationException initializationException = new InitializationException(ErrorState.NetworkWebviewRequest, new Exception(), params2.getConfig());
                        InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1 initializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1 = new InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1(initializeStateLoadWeb3, httpRequest4, null);
                        this.L$0 = coroutineScope;
                        this.L$1 = params2;
                        this.L$2 = initializeStateLoadWeb3;
                        this.L$3 = httpRequest4;
                        this.label = 1;
                        httpRequest = httpRequest4;
                        try {
                            objWithRetry = TaskExtensionsKt.withRetry(retryDelay, maxRetries, retryScalingFactor, initializationException, initializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1, this);
                            if (objWithRetry == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            httpRequest2 = httpRequest;
                            params = params2;
                            initializeStateLoadWeb = initializeStateLoadWeb3;
                        } catch (Throwable th) {
                            th = th;
                            httpRequest2 = httpRequest;
                            params = params2;
                            initializeStateLoadWeb = initializeStateLoadWeb3;
                            Result.Companion companion3 = Result.INSTANCE;
                            objM7904constructorimpl3 = Result.m7904constructorimpl(ResultKt.createFailure(th));
                            httpRequest3 = httpRequest2;
                            initializeStateLoadWeb2 = initializeStateLoadWeb;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpRequest = httpRequest4;
                    }
                } else {
                    if (r3 == 1) {
                        httpRequest2 = (HttpRequest) this.L$3;
                        initializeStateLoadWeb = (InitializeStateLoadWeb) this.L$2;
                        params = (InitializeStateLoadWeb.Params) this.L$1;
                        try {
                            ResultKt.throwOnFailure(obj);
                            objWithRetry = obj;
                            httpRequest2 = httpRequest2;
                            initializeStateLoadWeb = initializeStateLoadWeb;
                        } catch (Throwable th3) {
                            th = th3;
                            Result.Companion companion4 = Result.INSTANCE;
                            objM7904constructorimpl3 = Result.m7904constructorimpl(ResultKt.createFailure(th));
                            httpRequest3 = httpRequest2;
                            initializeStateLoadWeb2 = initializeStateLoadWeb;
                        }
                    } else if (r3 == 2) {
                        HttpRequest httpRequest5 = (HttpRequest) this.L$2;
                        InitializeStateLoadWeb initializeStateLoadWeb4 = (InitializeStateLoadWeb) this.L$1;
                        params = (InitializeStateLoadWeb.Params) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        value = ((Result) obj).getValue();
                        r3 = httpRequest5;
                        r4 = initializeStateLoadWeb4;
                        r3 = httpRequest3;
                        r4 = initializeStateLoadWeb2;
                        objM7904constructorimpl2 = Result.m7904constructorimpl(Result.m7903boximpl(value));
                        r1 = r3;
                        r2 = r4;
                        if (Result.m7911isSuccessimpl(objM7904constructorimpl2)) {
                            CoroutineDispatcher io2 = ((InitializeStateLoadWeb) r2).dispatchers.getIo();
                            InitializeStateLoadWeb$doWork$2$1$webViewData$1 initializeStateLoadWeb$doWork$2$1$webViewData$1 = new InitializeStateLoadWeb$doWork$2$1$webViewData$1(r2, r1, null);
                            this.L$0 = params;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 3;
                            objWithContext = BuildersKt.withContext(io2, initializeStateLoadWeb$doWork$2$1$webViewData$1, this);
                            if (objWithContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            throw new InitializationException(ErrorState.NetworkWebviewRequest, new Exception("No connected events within the timeout!"), params.getConfig());
                        }
                    } else {
                        if (r3 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        InitializeStateLoadWeb.Params params3 = (InitializeStateLoadWeb.Params) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        params = params3;
                        objWithContext = obj;
                    }
                    string = (String) objWithContext;
                    webViewHash = params.getConfig().getWebViewHash();
                    if (webViewHash != null && !Intrinsics.areEqual(Utilities.Sha256(string), webViewHash)) {
                        throw new InitializationException(ErrorState.InvalidHash, new Exception("Invalid webViewHash"), params.getConfig());
                    }
                    if (webViewHash != null) {
                        Utilities.writeFile(new File(SdkProperties.getLocalWebViewFile()), string);
                    }
                    objM7904constructorimpl = Result.m7904constructorimpl(new InitializeStateLoadWeb.LoadWebResult(params.getConfig(), string));
                    if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                        Result.Companion companion5 = Result.INSTANCE;
                        objM7904constructorimpl = Result.m7904constructorimpl(objM7904constructorimpl);
                    } else {
                        thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                        if (thM7907exceptionOrNullimpl != null) {
                            Result.Companion companion6 = Result.INSTANCE;
                            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
                        }
                    }
                    return Result.m7903boximpl(objM7904constructorimpl);
                }
                objM7904constructorimpl3 = Result.m7904constructorimpl((HttpResponse) objWithRetry);
                httpRequest3 = httpRequest2;
                initializeStateLoadWeb2 = initializeStateLoadWeb;
                if (Result.m7910isFailureimpl(objM7904constructorimpl3)) {
                    Result.Companion companion7 = Result.INSTANCE;
                    InitializeStateNetworkError initializeStateNetworkError = initializeStateLoadWeb2.initializeStateNetworkError;
                    InitializeStateNetworkError.Params params4 = new InitializeStateNetworkError.Params(params.getConfig());
                    this.L$0 = params;
                    this.L$1 = initializeStateLoadWeb2;
                    this.L$2 = httpRequest3;
                    this.L$3 = null;
                    this.label = 2;
                    value = initializeStateNetworkError.mo5927invokegIAlus(params4, this);
                    if (value == coroutine_suspended) {
                        r3 = httpRequest3;
                        r4 = initializeStateLoadWeb2;
                        return coroutine_suspended;
                    }
                    r3 = httpRequest3;
                    r4 = initializeStateLoadWeb2;
                    objM7904constructorimpl2 = Result.m7904constructorimpl(Result.m7903boximpl(value));
                    r1 = r3;
                    r2 = r4;
                    if (Result.m7911isSuccessimpl(objM7904constructorimpl2)) {
                        CoroutineDispatcher io3 = ((InitializeStateLoadWeb) r2).dispatchers.getIo();
                        InitializeStateLoadWeb$doWork$2$1$webViewData$1 initializeStateLoadWeb$doWork$2$1$webViewData$2 = new InitializeStateLoadWeb$doWork$2$1$webViewData$1(r2, r1, null);
                        this.L$0 = params;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 3;
                        objWithContext = BuildersKt.withContext(io3, initializeStateLoadWeb$doWork$2$1$webViewData$2, this);
                        if (objWithContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        string = (String) objWithContext;
                    } else {
                        throw new InitializationException(ErrorState.NetworkWebviewRequest, new Exception("No connected events within the timeout!"), params.getConfig());
                    }
                } else {
                    ResultKt.throwOnFailure(objM7904constructorimpl3);
                    string = ((HttpResponse) objM7904constructorimpl3).getBody().toString();
                }
            } catch (CancellationException e) {
                throw e;
            } catch (Throwable th4) {
                Result.Companion companion8 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th4));
            }
        } catch (Throwable th5) {
            Result.Companion companion9 = Result.INSTANCE;
            objM7904constructorimpl2 = Result.m7904constructorimpl(ResultKt.createFailure(th5));
            r1 = r3;
            r2 = r4;
        }
        webViewHash = params.getConfig().getWebViewHash();
        if (webViewHash != null) {
            throw new InitializationException(ErrorState.InvalidHash, new Exception("Invalid webViewHash"), params.getConfig());
        }
        if (webViewHash != null) {
            Utilities.writeFile(new File(SdkProperties.getLocalWebViewFile()), string);
        }
        objM7904constructorimpl = Result.m7904constructorimpl(new InitializeStateLoadWeb.LoadWebResult(params.getConfig(), string));
        if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
            Result.Companion companion10 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(objM7904constructorimpl);
        } else {
            thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
            if (thM7907exceptionOrNullimpl != null) {
                Result.Companion companion11 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
            }
        }
        return Result.m7903boximpl(objM7904constructorimpl);
    }
}
