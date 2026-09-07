package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.IModuleConfiguration;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.webview.WebViewApp;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: InitializeStateReset.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/unity3d/services/core/configuration/Configuration;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2", f = "InitializeStateReset.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
final class InitializeStateReset$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Configuration>>, Object> {
    final /* synthetic */ InitializeStateReset.Params $params;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ InitializeStateReset this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateReset$doWork$2(InitializeStateReset.Params params, InitializeStateReset initializeStateReset, Continuation<? super InitializeStateReset$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
        this.this$0 = initializeStateReset;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateReset$doWork$2(this.$params, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Configuration>> continuation) {
        return ((InitializeStateReset$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007c A[Catch: all -> 0x00c8, CancellationException -> 0x00f5, TryCatch #2 {CancellationException -> 0x00f5, all -> 0x00c8, blocks: (B:6:0x0014, B:22:0x005f, B:27:0x006d, B:29:0x007c, B:31:0x0082, B:33:0x0090, B:34:0x0092, B:36:0x0095, B:38:0x00a1, B:39:0x00ac, B:40:0x00af, B:41:0x00b8, B:42:0x00bf, B:43:0x00c0, B:44:0x00c7, B:25:0x0065, B:26:0x006c, B:11:0x0027, B:13:0x0034, B:15:0x0039, B:18:0x0041), top: B:57:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0082 A[Catch: all -> 0x00c8, CancellationException -> 0x00f5, TryCatch #2 {CancellationException -> 0x00f5, all -> 0x00c8, blocks: (B:6:0x0014, B:22:0x005f, B:27:0x006d, B:29:0x007c, B:31:0x0082, B:33:0x0090, B:34:0x0092, B:36:0x0095, B:38:0x00a1, B:39:0x00ac, B:40:0x00af, B:41:0x00b8, B:42:0x00bf, B:43:0x00c0, B:44:0x00c7, B:25:0x0065, B:26:0x006c, B:11:0x0027, B:13:0x0034, B:15:0x0039, B:18:0x0041), top: B:57:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0090 A[Catch: all -> 0x00c8, CancellationException -> 0x00f5, TryCatch #2 {CancellationException -> 0x00f5, all -> 0x00c8, blocks: (B:6:0x0014, B:22:0x005f, B:27:0x006d, B:29:0x007c, B:31:0x0082, B:33:0x0090, B:34:0x0092, B:36:0x0095, B:38:0x00a1, B:39:0x00ac, B:40:0x00af, B:41:0x00b8, B:42:0x00bf, B:43:0x00c0, B:44:0x00c7, B:25:0x0065, B:26:0x006c, B:11:0x0027, B:13:0x0034, B:15:0x0039, B:18:0x0041), top: B:57:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0095 A[Catch: all -> 0x00c8, CancellationException -> 0x00f5, TryCatch #2 {CancellationException -> 0x00f5, all -> 0x00c8, blocks: (B:6:0x0014, B:22:0x005f, B:27:0x006d, B:29:0x007c, B:31:0x0082, B:33:0x0090, B:34:0x0092, B:36:0x0095, B:38:0x00a1, B:39:0x00ac, B:40:0x00af, B:41:0x00b8, B:42:0x00bf, B:43:0x00c0, B:44:0x00c7, B:25:0x0065, B:26:0x006c, B:11:0x0027, B:13:0x0034, B:15:0x0039, B:18:0x0041), top: B:57:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a1 A[Catch: all -> 0x00c8, CancellationException -> 0x00f5, TryCatch #2 {CancellationException -> 0x00f5, all -> 0x00c8, blocks: (B:6:0x0014, B:22:0x005f, B:27:0x006d, B:29:0x007c, B:31:0x0082, B:33:0x0090, B:34:0x0092, B:36:0x0095, B:38:0x00a1, B:39:0x00ac, B:40:0x00af, B:41:0x00b8, B:42:0x00bf, B:43:0x00c0, B:44:0x00c7, B:25:0x0065, B:26:0x006c, B:11:0x0027, B:13:0x0034, B:15:0x0039, B:18:0x0041), top: B:57:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b8 A[Catch: all -> 0x00c8, CancellationException -> 0x00f5, TryCatch #2 {CancellationException -> 0x00f5, all -> 0x00c8, blocks: (B:6:0x0014, B:22:0x005f, B:27:0x006d, B:29:0x007c, B:31:0x0082, B:33:0x0090, B:34:0x0092, B:36:0x0095, B:38:0x00a1, B:39:0x00ac, B:40:0x00af, B:41:0x00b8, B:42:0x00bf, B:43:0x00c0, B:44:0x00c7, B:25:0x0065, B:26:0x006c, B:11:0x0027, B:13:0x0034, B:15:0x0039, B:18:0x0041), top: B:57:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00c0 A[Catch: all -> 0x00c8, CancellationException -> 0x00f5, TryCatch #2 {CancellationException -> 0x00f5, all -> 0x00c8, blocks: (B:6:0x0014, B:22:0x005f, B:27:0x006d, B:29:0x007c, B:31:0x0082, B:33:0x0090, B:34:0x0092, B:36:0x0095, B:38:0x00a1, B:39:0x00ac, B:40:0x00af, B:41:0x00b8, B:42:0x00bf, B:43:0x00c0, B:44:0x00c7, B:25:0x0065, B:26:0x006c, B:11:0x0027, B:13:0x0034, B:15:0x0039, B:18:0x0041), top: B:57:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ac A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM7904constructorimpl;
        Throwable thM7907exceptionOrNullimpl;
        InitializeStateReset.Params params;
        InitializeStateReset initializeStateReset;
        InitializeStateReset initializeStateReset2;
        int i;
        Class[] moduleConfigurationList;
        IModuleConfiguration moduleConfiguration;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                params = this.$params;
                initializeStateReset = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                DeviceLog.debug("Unity Ads init: starting init");
                WebViewApp currentApp = WebViewApp.getCurrentApp();
                if (currentApp != null) {
                    currentApp.resetWebViewAppInitialization();
                }
                if ((currentApp != null ? currentApp.getWebView() : null) != null) {
                    long webViewAppCreateTimeout = params.getConfig().getWebViewAppCreateTimeout();
                    InitializeStateReset$doWork$2$1$success$1 initializeStateReset$doWork$2$1$success$1 = new InitializeStateReset$doWork$2$1$success$1(initializeStateReset, currentApp, null);
                    this.L$0 = params;
                    this.L$1 = initializeStateReset;
                    this.label = 1;
                    Object objWithTimeoutOrNull = TimeoutKt.withTimeoutOrNull(webViewAppCreateTimeout, initializeStateReset$doWork$2$1$success$1, this);
                    if (objWithTimeoutOrNull == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    initializeStateReset2 = initializeStateReset;
                    obj = objWithTimeoutOrNull;
                }
                initializeStateReset.unregisterLifecycleCallbacks();
                SdkProperties.setCacheDirectory(null);
                SdkProperties.setWebViewCacheDirectory(null);
                if (SdkProperties.getCacheDirectory() != null) {
                    throw new Exception("Cache directory is NULL");
                }
                if (SdkProperties.getWebViewCacheDirectory() != null) {
                    throw new Exception("WebView cache directory is NULL");
                }
                SdkProperties.setInitialized(false);
                moduleConfigurationList = params.getConfig().getModuleConfigurationList();
                if (moduleConfigurationList == null) {
                    moduleConfigurationList = new Class[0];
                }
                for (Class cls : moduleConfigurationList) {
                    moduleConfiguration = params.getConfig().getModuleConfiguration(cls);
                    if (moduleConfiguration != null) {
                        Boxing.boxBoolean(moduleConfiguration.resetState(params.getConfig()));
                    }
                }
                objM7904constructorimpl = Result.m7904constructorimpl(params.getConfig());
                if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7904constructorimpl = Result.m7904constructorimpl(objM7904constructorimpl);
                } else {
                    thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                    if (thM7907exceptionOrNullimpl != null) {
                        Result.Companion companion3 = Result.INSTANCE;
                        objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
                    }
                }
                return Result.m7903boximpl(objM7904constructorimpl);
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            initializeStateReset2 = (InitializeStateReset) this.L$1;
            params = (InitializeStateReset.Params) this.L$0;
            ResultKt.throwOnFailure(obj);
            if (((Unit) obj) != null) {
                initializeStateReset = initializeStateReset2;
                initializeStateReset.unregisterLifecycleCallbacks();
                SdkProperties.setCacheDirectory(null);
                SdkProperties.setWebViewCacheDirectory(null);
                if (SdkProperties.getCacheDirectory() != null) {
                    throw new Exception("Cache directory is NULL");
                }
                if (SdkProperties.getWebViewCacheDirectory() != null) {
                    throw new Exception("WebView cache directory is NULL");
                }
                SdkProperties.setInitialized(false);
                moduleConfigurationList = params.getConfig().getModuleConfigurationList();
                if (moduleConfigurationList == null) {
                    moduleConfigurationList = new Class[0];
                }
                while (i < r2) {
                    moduleConfiguration = params.getConfig().getModuleConfiguration(cls);
                    if (moduleConfiguration != null) {
                        Boxing.boxBoolean(moduleConfiguration.resetState(params.getConfig()));
                    }
                }
                objM7904constructorimpl = Result.m7904constructorimpl(params.getConfig());
                if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM7904constructorimpl = Result.m7904constructorimpl(objM7904constructorimpl);
                } else {
                    thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                    if (thM7907exceptionOrNullimpl != null) {
                        Result.Companion companion5 = Result.INSTANCE;
                        objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
                    }
                }
                return Result.m7903boximpl(objM7904constructorimpl);
            }
            throw new Exception("Reset failed on opening ConditionVariable");
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion6 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }
}
