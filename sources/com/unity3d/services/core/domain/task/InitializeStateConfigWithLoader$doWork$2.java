package com.unity3d.services.core.domain.task;

import com.amazon.device.ads.DTBMetricsConfiguration;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ConfigurationLoader;
import com.unity3d.services.core.configuration.ConfigurationRequestFactory;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.configuration.IConfigurationLoader;
import com.unity3d.services.core.configuration.InitRequestType;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.configuration.PrivacyConfigStorage;
import com.unity3d.services.core.configuration.PrivacyConfigurationLoader;
import com.unity3d.services.core.device.reader.DeviceInfoDataFactory;
import com.unity3d.services.core.extensions.AbortRetryException;
import com.unity3d.services.core.extensions.TaskExtensionsKt;
import com.unity3d.services.core.network.core.HttpClient;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InitializeStateConfigWithLoader.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/unity3d/services/core/configuration/Configuration;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2", f = "InitializeStateConfigWithLoader.kt", i = {0, 0, 0, 1, 1, 2}, l = {TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER, 101, 109}, m = "invokeSuspend", n = {"$this$withContext", "configurationLoader", DTBMetricsConfiguration.CONFIG_DIR, "configurationLoader", DTBMetricsConfiguration.CONFIG_DIR, DTBMetricsConfiguration.CONFIG_DIR}, s = {"L$0", "L$3", "L$4", "L$2", "L$3", "L$0"})
final class InitializeStateConfigWithLoader$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Configuration>>, Object> {
    final /* synthetic */ InitializeStateConfigWithLoader.Params $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ InitializeStateConfigWithLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateConfigWithLoader$doWork$2(InitializeStateConfigWithLoader initializeStateConfigWithLoader, InitializeStateConfigWithLoader.Params params, Continuation<? super InitializeStateConfigWithLoader$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateConfigWithLoader;
        this.$params = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateConfigWithLoader$doWork$2 initializeStateConfigWithLoader$doWork$2 = new InitializeStateConfigWithLoader$doWork$2(this.this$0, this.$params, continuation);
        initializeStateConfigWithLoader$doWork$2.L$0 = obj;
        return initializeStateConfigWithLoader$doWork$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Configuration>> continuation) {
        return ((InitializeStateConfigWithLoader$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x01c0 A[Catch: all -> 0x022e, CancellationException -> 0x025b, TryCatch #7 {CancellationException -> 0x025b, all -> 0x022e, blocks: (B:8:0x001d, B:57:0x01f2, B:63:0x0223, B:51:0x01b8, B:53:0x01c0, B:58:0x01fc, B:59:0x020e, B:50:0x01ae, B:38:0x016c, B:40:0x0175, B:60:0x020f, B:61:0x021c, B:62:0x021d, B:37:0x0162, B:23:0x007e), top: B:87:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:55:0x01ef A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:58:0x01fc A[Catch: all -> 0x022e, CancellationException -> 0x025b, TryCatch #7 {CancellationException -> 0x025b, all -> 0x022e, blocks: (B:8:0x001d, B:57:0x01f2, B:63:0x0223, B:51:0x01b8, B:53:0x01c0, B:58:0x01fc, B:59:0x020e, B:50:0x01ae, B:38:0x016c, B:40:0x0175, B:60:0x020f, B:61:0x021c, B:62:0x021d, B:37:0x0162, B:23:0x007e), top: B:87:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:69:0x023f  */
    /* JADX WARN: Code duplicated, block: B:70:0x0246  */
    /* JADX WARN: Code duplicated, block: B:72:0x024c  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, com.unity3d.services.core.configuration.Configuration] */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, com.unity3d.services.core.configuration.ConfigurationLoader] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, com.unity3d.services.core.configuration.PrivacyConfigurationLoader] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM7904constructorimpl;
        Throwable thM7907exceptionOrNullimpl;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        InitializeStateConfigWithLoader initializeStateConfigWithLoader;
        InitializeStateConfigWithLoader.Params params;
        Object objM7904constructorimpl2;
        InitializeStateConfigWithLoader initializeStateConfigWithLoader2;
        InitializeStateConfigWithLoader.Params params2;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        Ref.ObjectRef objectRef6;
        Object value;
        Object objM7904constructorimpl3;
        Ref.ObjectRef objectRef7;
        InitializeStateConfigWithLoader.Params params3;
        CoroutineDispatcher io2;
        InitializeStateConfigWithLoader$doWork$2$1$1 initializeStateConfigWithLoader$doWork$2$1$1;
        Ref.ObjectRef objectRef8;
        Ref.ObjectRef objectRef9;
        T t;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                InitializeStateConfigWithLoader initializeStateConfigWithLoader3 = this.this$0;
                InitializeStateConfigWithLoader.Params params4 = this.$params;
                Result.Companion companion = Result.INSTANCE;
                PrivacyConfigStorage privacyConfigStorage = PrivacyConfigStorage.getInstance();
                DeviceInfoDataFactory deviceInfoDataFactory = new DeviceInfoDataFactory(initializeStateConfigWithLoader3.sdkMetricsSender);
                Ref.ObjectRef objectRef10 = new Ref.ObjectRef();
                objectRef10.element = new ConfigurationLoader(new ConfigurationRequestFactory(params4.getConfig(), deviceInfoDataFactory.getDeviceInfoData(InitRequestType.TOKEN)), initializeStateConfigWithLoader3.sdkMetricsSender, (HttpClient) initializeStateConfigWithLoader3.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(HttpClient.class)));
                objectRef10.element = new PrivacyConfigurationLoader((IConfigurationLoader) objectRef10.element, new ConfigurationRequestFactory(params4.getConfig(), deviceInfoDataFactory.getDeviceInfoData(InitRequestType.PRIVACY)), privacyConfigStorage, (HttpClient) initializeStateConfigWithLoader3.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(HttpClient.class)));
                Ref.ObjectRef objectRef11 = new Ref.ObjectRef();
                objectRef11.element = new Configuration();
                try {
                    Result.Companion companion2 = Result.INSTANCE;
                    int maxRetries = params4.getConfig().getMaxRetries();
                    double retryScalingFactor = params4.getConfig().getRetryScalingFactor();
                    long retryDelay = params4.getConfig().getRetryDelay();
                    InitializationException initializationException = new InitializationException(ErrorState.NetworkConfigRequest, new Exception(), params4.getConfig());
                    InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1 initializeStateConfigWithLoader$doWork$2$1$configResult$1$1 = new InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1(initializeStateConfigWithLoader3, objectRef10, objectRef11, null);
                    this.L$0 = coroutineScope;
                    this.L$1 = initializeStateConfigWithLoader3;
                    this.L$2 = params4;
                    this.L$3 = objectRef10;
                    this.L$4 = objectRef11;
                    this.label = 1;
                    objectRef = objectRef10;
                    try {
                        if (TaskExtensionsKt.withRetry(retryDelay, maxRetries, retryScalingFactor, initializationException, initializeStateConfigWithLoader$doWork$2$1$configResult$1$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef2 = objectRef11;
                        objectRef3 = objectRef;
                        initializeStateConfigWithLoader = initializeStateConfigWithLoader3;
                        params = params4;
                    } catch (Throwable th) {
                        th = th;
                        objectRef2 = objectRef11;
                        objectRef3 = objectRef;
                        initializeStateConfigWithLoader = initializeStateConfigWithLoader3;
                        params = params4;
                        Result.Companion companion3 = Result.INSTANCE;
                        objM7904constructorimpl2 = Result.m7904constructorimpl(ResultKt.createFailure(th));
                    }
                } catch (Throwable th2) {
                    th = th2;
                    objectRef = objectRef10;
                }
            } else {
                if (i == 1) {
                    objectRef2 = (Ref.ObjectRef) this.L$4;
                    objectRef3 = (Ref.ObjectRef) this.L$3;
                    params = (InitializeStateConfigWithLoader.Params) this.L$2;
                    initializeStateConfigWithLoader = (InitializeStateConfigWithLoader) this.L$1;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        Result.Companion companion4 = Result.INSTANCE;
                        objM7904constructorimpl2 = Result.m7904constructorimpl(ResultKt.createFailure(th));
                    }
                } else if (i == 2) {
                    objectRef2 = (Ref.ObjectRef) this.L$4;
                    objectRef6 = (Ref.ObjectRef) this.L$3;
                    objectRef4 = (Ref.ObjectRef) this.L$2;
                    params2 = (InitializeStateConfigWithLoader.Params) this.L$1;
                    initializeStateConfigWithLoader2 = (InitializeStateConfigWithLoader) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        value = ((Result) obj).getValue();
                        objM7904constructorimpl3 = Result.m7904constructorimpl(Result.m7903boximpl(value));
                    } catch (Throwable th4) {
                        th = th4;
                        Result.Companion companion5 = Result.INSTANCE;
                        objM7904constructorimpl3 = Result.m7904constructorimpl(ResultKt.createFailure(th));
                    }
                    objectRef7 = objectRef6;
                    params3 = params2;
                    if (Result.m7911isSuccessimpl(objM7904constructorimpl3)) {
                        InitializeEventsMetricSender.getInstance().onRetryConfig();
                        io2 = initializeStateConfigWithLoader2.dispatchers.getIo();
                        initializeStateConfigWithLoader$doWork$2$1$1 = new InitializeStateConfigWithLoader$doWork$2$1$1(objectRef4, objectRef7, initializeStateConfigWithLoader2, params3, null);
                        this.L$0 = objectRef7;
                        this.L$1 = objectRef2;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.label = 3;
                        if (BuildersKt.withContext(io2, initializeStateConfigWithLoader$doWork$2$1$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef8 = objectRef2;
                        objectRef9 = objectRef7;
                    } else {
                        throw new InitializationException(ErrorState.NetworkConfigRequest, new Exception("No connected events within the timeout!"), params3.getConfig());
                    }
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef8 = (Ref.ObjectRef) this.L$1;
                    objectRef9 = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Configuration configuration = (Configuration) objectRef9.element;
                Ref.ObjectRef objectRef12 = objectRef9;
                objectRef2 = objectRef8;
                objectRef5 = objectRef12;
                t = configuration;
                objectRef2.element = t;
                objM7904constructorimpl = Result.m7904constructorimpl((Configuration) objectRef5.element);
                if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                    Result.Companion companion6 = Result.INSTANCE;
                    objM7904constructorimpl = Result.m7904constructorimpl(objM7904constructorimpl);
                } else {
                    thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                    if (thM7907exceptionOrNullimpl != null) {
                        Result.Companion companion7 = Result.INSTANCE;
                        objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
                    }
                }
                return Result.m7903boximpl(objM7904constructorimpl);
            }
            objM7904constructorimpl2 = Result.m7904constructorimpl(Unit.INSTANCE);
            initializeStateConfigWithLoader2 = initializeStateConfigWithLoader;
            params2 = params;
            objectRef4 = objectRef3;
            if (Result.m7910isFailureimpl(objM7904constructorimpl2)) {
                Throwable thM7907exceptionOrNullimpl2 = Result.m7907exceptionOrNullimpl(objM7904constructorimpl2);
                if (thM7907exceptionOrNullimpl2 instanceof AbortRetryException) {
                    throw new InitializationException(ErrorState.NetworkConfigRequest, (Exception) thM7907exceptionOrNullimpl2, params2.getConfig());
                }
                try {
                    Result.Companion companion8 = Result.INSTANCE;
                    InitializeStateNetworkError initializeStateNetworkError = initializeStateConfigWithLoader2.initializeStateNetworkError;
                    InitializeStateNetworkError.Params params5 = new InitializeStateNetworkError.Params(params2.getConfig());
                    this.L$0 = initializeStateConfigWithLoader2;
                    this.L$1 = params2;
                    this.L$2 = objectRef4;
                    this.L$3 = objectRef2;
                    this.L$4 = objectRef2;
                    this.label = 2;
                    value = initializeStateNetworkError.mo5927invokegIAlus(params5, this);
                    if (value == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef6 = objectRef2;
                    objM7904constructorimpl3 = Result.m7904constructorimpl(Result.m7903boximpl(value));
                    objectRef7 = objectRef6;
                    params3 = params2;
                    if (Result.m7911isSuccessimpl(objM7904constructorimpl3)) {
                        InitializeEventsMetricSender.getInstance().onRetryConfig();
                        io2 = initializeStateConfigWithLoader2.dispatchers.getIo();
                        initializeStateConfigWithLoader$doWork$2$1$1 = new InitializeStateConfigWithLoader$doWork$2$1$1(objectRef4, objectRef7, initializeStateConfigWithLoader2, params3, null);
                        this.L$0 = objectRef7;
                        this.L$1 = objectRef2;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.label = 3;
                        if (BuildersKt.withContext(io2, initializeStateConfigWithLoader$doWork$2$1$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef8 = objectRef2;
                        objectRef9 = objectRef7;
                        Configuration configuration2 = (Configuration) objectRef9.element;
                        Ref.ObjectRef objectRef13 = objectRef9;
                        objectRef2 = objectRef8;
                        objectRef5 = objectRef13;
                        t = configuration2;
                    } else {
                        throw new InitializationException(ErrorState.NetworkConfigRequest, new Exception("No connected events within the timeout!"), params3.getConfig());
                    }
                } catch (Throwable th5) {
                    th = th5;
                    objectRef6 = objectRef2;
                    Result.Companion companion9 = Result.INSTANCE;
                    objM7904constructorimpl3 = Result.m7904constructorimpl(ResultKt.createFailure(th));
                }
            } else {
                objectRef5 = objectRef2;
                t = (Configuration) objectRef2.element;
            }
            objectRef2.element = t;
            objM7904constructorimpl = Result.m7904constructorimpl((Configuration) objectRef5.element);
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th6) {
            Result.Companion companion10 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th6));
        }
        if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
            Result.Companion companion11 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(objM7904constructorimpl);
        } else {
            thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
            if (thM7907exceptionOrNullimpl != null) {
                Result.Companion companion12 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
            }
        }
        return Result.m7903boximpl(objM7904constructorimpl);
    }
}
