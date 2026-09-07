package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import com.moloco.sdk.internal.MolocoLogger;
import com.vungle.ads.internal.protos.Sdk;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes5.dex */
public final class e0 implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.internal.ortb.model.c f6541a;
    public final CoroutineScope b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d c;
    public final j d;
    public final boolean e;
    public com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c> f;
    public final MutableStateFlow<Boolean> g;
    public final StateFlow<Boolean> h;
    public Job i;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1", f = "VastAdLoad.kt", i = {0}, l = {80, 94}, m = "invokeSuspend", n = {"decDeferred"}, s = {"L$0"})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6542a;
        public /* synthetic */ Object b;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a d;
        public final /* synthetic */ long e;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.e0$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1$decDeferred$1", f = "VastAdLoad.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0591a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super i>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6543a;
            public final /* synthetic */ long b;
            public final /* synthetic */ i c;
            public final /* synthetic */ e0 d;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.e0$a$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1$decDeferred$1$1", f = "VastAdLoad.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0592a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super i>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f6544a;
                public final /* synthetic */ i b;
                public final /* synthetic */ e0 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0592a(i iVar, e0 e0Var, Continuation<? super C0592a> continuation) {
                    super(2, continuation);
                    this.b = iVar;
                    this.c = e0Var;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super i> continuation) {
                    return ((C0592a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0592a(this.b, this.c, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f6544a;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        i iVar = this.b;
                        if (iVar == null) {
                            return null;
                        }
                        e0 e0Var = this.c;
                        j jVar = e0Var.d;
                        com.moloco.sdk.internal.ortb.model.d dVarE = e0Var.f6541a.e();
                        String strC = dVarE != null ? dVarE.c() : null;
                        this.f6544a = 1;
                        obj = jVar.a(iVar, strC, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return (i) obj;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0591a(long j, i iVar, e0 e0Var, Continuation<? super C0591a> continuation) {
                super(2, continuation);
                this.b = j;
                this.c = iVar;
                this.d = e0Var;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super i> continuation) {
                return ((C0591a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0591a(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f6543a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.b;
                    C0592a c0592a = new C0592a(this.c, this.d, null);
                    this.f6543a = 1;
                    obj = TimeoutKt.m9406withTimeoutOrNullKLykuaI(j, c0592a, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                i iVar = (i) obj;
                return iVar == null ? this.c : iVar;
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1$vastAdDeferred$1", f = "VastAdLoad.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6545a;
            public final /* synthetic */ long b;
            public final /* synthetic */ e0 c;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.e0$a$b$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1$vastAdDeferred$1$1", f = "VastAdLoad.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0593a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f6546a;
                public final /* synthetic */ e0 b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0593a(e0 e0Var, Continuation<? super C0593a> continuation) {
                    super(2, continuation);
                    this.b = e0Var;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) {
                    return ((C0593a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0593a(this.b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f6546a;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d dVar = this.b.c;
                        String strA = this.b.f6541a.a();
                        String strA2 = com.moloco.sdk.internal.ortb.model.f.a(this.b.f6541a);
                        this.f6546a = 1;
                        obj = dVar.a(strA, strA2, false, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return obj;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(long j, e0 e0Var, Continuation<? super b> continuation) {
                super(2, continuation);
                this.b = j;
                this.c = e0Var;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new b(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f6545a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.b;
                    C0593a c0593a = new C0593a(this.c, null);
                    this.f6545a = 1;
                    obj = TimeoutKt.m9405withTimeoutKLykuaI(j, c0593a, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return obj;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar, long j, Continuation<? super a> continuation) {
            super(2, continuation);
            this.d = aVar;
            this.e = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = e0.this.new a(this.d, this.e, continuation);
            aVar.b = obj;
            return aVar;
        }

        /* JADX WARN: Code duplicated, block: B:41:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:50:0x0117  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Deferred deferred;
            com.moloco.sdk.internal.ortb.model.o oVarE;
            com.moloco.sdk.internal.ortb.model.j jVarI;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a aVar;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar2;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar3;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6542a;
            if (i != 0) {
                if (i == 1) {
                    deferred = (Deferred) this.b;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (TimeoutCancellationException unused) {
                        MolocoLogger.debug$default(MolocoLogger.INSTANCE, f0.f6562a, "main VAST ad didn't load due to timeout", false, 4, null);
                        Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
                        aVar = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.VAST_AD_LOAD_INTERNAL_TIMEOUT_ERROR;
                        e0.this.a(new com.moloco.sdk.internal.v.a(aVar));
                        aVar2 = this.d;
                        if (aVar2 != null) {
                            aVar2.a(aVar);
                        }
                        return Unit.INSTANCE;
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar5 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) this.b;
                    ResultKt.throwOnFailure(obj);
                    aVar3 = aVar5;
                }
                e0.this.a(new com.moloco.sdk.internal.v.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a.a(aVar3, null, null, null, null, (i) obj, 15, null)));
                e0.this.g.setValue(Boxing.boxBoolean(true));
                aVar4 = this.d;
                if (aVar4 != null) {
                    aVar4.a();
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.b;
            if (e0.this.a() instanceof com.moloco.sdk.internal.v.b) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar6 = this.d;
                if (aVar6 != null) {
                    aVar6.a();
                }
                return Unit.INSTANCE;
            }
            Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new b(this.e, e0.this, null), 3, null);
            com.moloco.sdk.internal.ortb.model.d dVarE = e0.this.f6541a.e();
            Deferred deferredAsync$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new C0591a(this.e, (dVarE == null || (oVarE = dVarE.e()) == null || (jVarI = oVarE.i()) == null) ? null : com.moloco.sdk.internal.l.a(jVarI), e0.this, null), 3, null);
            try {
                this.b = deferredAsync$default2;
                this.f6542a = 1;
                Object objAwait = deferredAsync$default.await(this);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
                deferred = deferredAsync$default2;
                obj = objAwait;
            } catch (TimeoutCancellationException unused2) {
                deferred = deferredAsync$default2;
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, f0.f6562a, "main VAST ad didn't load due to timeout", false, 4, null);
                Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
                aVar = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.VAST_AD_LOAD_INTERNAL_TIMEOUT_ERROR;
                e0.this.a(new com.moloco.sdk.internal.v.a(aVar));
                aVar2 = this.d;
                if (aVar2 != null) {
                    aVar2.a(aVar);
                }
                return Unit.INSTANCE;
            }
            com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) obj;
            if (vVar instanceof com.moloco.sdk.internal.v.b) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar7 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((com.moloco.sdk.internal.v.b) vVar).a();
                this.b = aVar7;
                this.f6542a = 2;
                Object objAwait2 = deferred.await(this);
                if (objAwait2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                aVar3 = aVar7;
                obj = objAwait2;
                e0.this.a(new com.moloco.sdk.internal.v.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a.a(aVar3, null, null, null, null, (i) obj, 15, null)));
                e0.this.g.setValue(Boxing.boxBoolean(true));
                aVar4 = this.d;
                if (aVar4 != null) {
                    aVar4.a();
                }
            } else if (vVar instanceof com.moloco.sdk.internal.v.a) {
                e0.this.a(deferred, this.d, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((com.moloco.sdk.internal.v.a) vVar).a());
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$streamedLoad$1", f = "VastAdLoad.kt", i = {0, 1, 1}, l = {Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 135}, m = "invokeSuspend", n = {"$this$launch", "vastAdDeferred", "decDeferred"}, s = {"L$0", "L$0", "L$1"})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6547a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a e;
        public final /* synthetic */ long f;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$streamedLoad$1$decDeferred$1", f = "VastAdLoad.kt", i = {}, l = {Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super i>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6548a;
            public final /* synthetic */ long b;
            public final /* synthetic */ i c;
            public final /* synthetic */ e0 d;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.e0$b$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$streamedLoad$1$decDeferred$1$1", f = "VastAdLoad.kt", i = {}, l = {Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0594a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super i>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f6549a;
                public final /* synthetic */ i b;
                public final /* synthetic */ e0 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0594a(i iVar, e0 e0Var, Continuation<? super C0594a> continuation) {
                    super(2, continuation);
                    this.b = iVar;
                    this.c = e0Var;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super i> continuation) {
                    return ((C0594a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0594a(this.b, this.c, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f6549a;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        i iVar = this.b;
                        if (iVar == null) {
                            return null;
                        }
                        e0 e0Var = this.c;
                        j jVar = e0Var.d;
                        com.moloco.sdk.internal.ortb.model.d dVarE = e0Var.f6541a.e();
                        String strC = dVarE != null ? dVarE.c() : null;
                        this.f6549a = 1;
                        obj = jVar.a(iVar, strC, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return (i) obj;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(long j, i iVar, e0 e0Var, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = j;
                this.c = iVar;
                this.d = e0Var;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super i> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f6548a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.b;
                    C0594a c0594a = new C0594a(this.c, this.d, null);
                    this.f6548a = 1;
                    obj = TimeoutKt.m9406withTimeoutOrNullKLykuaI(j, c0594a, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                i iVar = (i) obj;
                return iVar == null ? this.c : iVar;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar, long j, Continuation<? super b> continuation) {
            super(2, continuation);
            this.e = aVar;
            this.f = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = e0.this.new b(this.e, this.f, continuation);
            bVar.c = obj;
            return bVar;
        }

        /* JADX WARN: Code duplicated, block: B:39:0x00de  */
        /* JADX WARN: Code duplicated, block: B:41:0x00f4 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:42:0x00f5  */
        /* JADX WARN: Code duplicated, block: B:45:0x0120  */
        /* JADX WARN: Code duplicated, block: B:46:0x0124  */
        /* JADX WARN: Code duplicated, block: B:48:0x0128  */
        /* JADX WARN: Code duplicated, block: B:50:0x0142  */
        /* JADX WARN: Code duplicated, block: B:51:0x0150  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CoroutineScope coroutineScope;
            Deferred deferredAsync$default;
            com.moloco.sdk.internal.v vVar;
            com.moloco.sdk.internal.ortb.model.o oVarE;
            com.moloco.sdk.internal.ortb.model.j jVarI;
            com.moloco.sdk.internal.v vVar2;
            com.moloco.sdk.internal.v.a aVar;
            e0 e0Var;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar2;
            Object objAwait;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar3;
            e0 e0Var2;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i != 0) {
                if (i == 1) {
                    coroutineScope = (CoroutineScope) this.c;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i == 2) {
                        deferredAsync$default = (Deferred) this.f6547a;
                        vVar = (com.moloco.sdk.internal.v) this.c;
                        ResultKt.throwOnFailure(obj);
                        vVar2 = (com.moloco.sdk.internal.v) obj;
                        if (vVar2 instanceof com.moloco.sdk.internal.v.b) {
                            e0Var = e0.this;
                            aVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((com.moloco.sdk.internal.v.b) vVar).a();
                            this.c = e0Var;
                            this.f6547a = aVar2;
                            this.b = 3;
                            objAwait = deferredAsync$default.await(this);
                            if (objAwait == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            aVar3 = aVar2;
                            e0Var2 = e0Var;
                            obj = objAwait;
                        } else if (vVar2 instanceof com.moloco.sdk.internal.v.a) {
                            MolocoLogger.debug$default(MolocoLogger.INSTANCE, f0.f6562a, "main VAST ad didn't load due to failure or timeout", false, 4, null);
                            aVar = (com.moloco.sdk.internal.v.a) vVar2;
                            if (((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k) aVar.a()).c()) {
                                e0.this.b(deferredAsync$default, this.e, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) aVar.a());
                            } else {
                                e0.this.a(deferredAsync$default, this.e, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) aVar.a());
                            }
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar5 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) this.f6547a;
                    e0Var2 = (e0) this.c;
                    ResultKt.throwOnFailure(obj);
                    aVar3 = aVar5;
                }
                e0Var2.a(new com.moloco.sdk.internal.v.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a.a(aVar3, null, null, null, null, (i) obj, 15, null)));
                e0.this.g.setValue(Boxing.boxBoolean(true));
                aVar4 = this.e;
                if (aVar4 != null) {
                    aVar4.a();
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.c;
            if (e0.this.a() instanceof com.moloco.sdk.internal.v.b) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar6 = this.e;
                if (aVar6 != null) {
                    aVar6.a();
                }
                return Unit.INSTANCE;
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d dVar = e0.this.c;
            String strA = e0.this.f6541a.a();
            String strA2 = com.moloco.sdk.internal.ortb.model.f.a(e0.this.f6541a);
            this.c = coroutineScope;
            this.b = 1;
            obj = dVar.a(strA, strA2, true, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            CoroutineScope coroutineScope2 = coroutineScope;
            com.moloco.sdk.internal.v vVar3 = (com.moloco.sdk.internal.v) obj;
            com.moloco.sdk.internal.ortb.model.d dVarE = e0.this.f6541a.e();
            deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope2, null, null, new a(this.f, (dVarE == null || (oVarE = dVarE.e()) == null || (jVarI = oVarE.i()) == null) ? null : com.moloco.sdk.internal.l.a(jVarI), e0.this, null), 3, null);
            if (vVar3 instanceof com.moloco.sdk.internal.v.b) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d dVar2 = e0.this.c;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar7 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((com.moloco.sdk.internal.v.b) vVar3).a();
                long j = this.f;
                this.c = vVar3;
                this.f6547a = deferredAsync$default;
                this.b = 2;
                Object objA = dVar2.a(aVar7, j, this);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                vVar = vVar3;
                obj = objA;
                vVar2 = (com.moloco.sdk.internal.v) obj;
                if (vVar2 instanceof com.moloco.sdk.internal.v.b) {
                    e0Var = e0.this;
                    aVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((com.moloco.sdk.internal.v.b) vVar).a();
                    this.c = e0Var;
                    this.f6547a = aVar2;
                    this.b = 3;
                    objAwait = deferredAsync$default.await(this);
                    if (objAwait == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar3 = aVar2;
                    e0Var2 = e0Var;
                    obj = objAwait;
                    e0Var2.a(new com.moloco.sdk.internal.v.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a.a(aVar3, null, null, null, null, (i) obj, 15, null)));
                    e0.this.g.setValue(Boxing.boxBoolean(true));
                    aVar4 = this.e;
                    if (aVar4 != null) {
                        aVar4.a();
                    }
                } else if (vVar2 instanceof com.moloco.sdk.internal.v.a) {
                    MolocoLogger.debug$default(MolocoLogger.INSTANCE, f0.f6562a, "main VAST ad didn't load due to failure or timeout", false, 4, null);
                    aVar = (com.moloco.sdk.internal.v.a) vVar2;
                    if (((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k) aVar.a()).c()) {
                        e0.this.b(deferredAsync$default, this.e, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) aVar.a());
                    } else {
                        e0.this.a(deferredAsync$default, this.e, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) aVar.a());
                    }
                    return Unit.INSTANCE;
                }
            } else if (vVar3 instanceof com.moloco.sdk.internal.v.a) {
                e0.this.a(deferredAsync$default, this.e, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((com.moloco.sdk.internal.v.a) vVar3).a());
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    public e0(com.moloco.sdk.internal.ortb.model.c bid, CoroutineScope scope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d loadVast, j decLoader, boolean z) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(loadVast, "loadVast");
        Intrinsics.checkNotNullParameter(decLoader, "decLoader");
        this.f6541a = bid;
        this.b = scope;
        this.c = loadVast;
        this.d = decLoader;
        this.e = z;
        this.f = new com.moloco.sdk.internal.v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_INCOMPLETE_ERROR);
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.g = MutableStateFlow;
        this.h = FlowKt.asStateFlow(MutableStateFlow);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    public StateFlow<Boolean> isLoaded() {
        return this.h;
    }

    public final void c(long j, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar) {
        Job job = this.i;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.i = BuildersKt__Builders_commonKt.launch$default(this.b, null, null, new b(aVar, j, null), 3, null);
    }

    public final com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c> a() {
        return this.f;
    }

    public final void b(long j, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar) {
        Job job = this.i;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.i = BuildersKt__Builders_commonKt.launch$default(this.b, null, null, new a(aVar, j, null), 3, null);
    }

    public final void a(com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c> vVar) {
        Intrinsics.checkNotNullParameter(vVar, "<set-?>");
        this.f = vVar;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    public void a(long j, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar) {
        if (this.e) {
            c(j, aVar);
        } else {
            b(j, aVar);
        }
    }

    public final void b(Deferred<i> deferred, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar) {
        Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a aVar2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.VAST_AD_LOAD_INTERNAL_TIMEOUT_ERROR;
        this.f = new com.moloco.sdk.internal.v.a(cVar);
        if (aVar != null) {
            aVar.a(aVar2);
        }
    }

    public final void a(Deferred<i> deferred, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar) {
        MolocoLogger.error$default(MolocoLogger.INSTANCE, f0.f6562a, "Vast AD failed to load: " + cVar, null, false, 12, null);
        Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
        this.f = new com.moloco.sdk.internal.v.a(cVar);
        if (aVar != null) {
            aVar.a(cVar);
        }
    }
}
