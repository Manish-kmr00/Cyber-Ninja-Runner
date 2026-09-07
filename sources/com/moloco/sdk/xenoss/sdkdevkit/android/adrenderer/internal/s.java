package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes4.dex */
public final class s implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f6667a;
    public final com.moloco.sdk.internal.ortb.model.c b;
    public final j c;
    public final Function1<Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> d;
    public final MutableStateFlow<Boolean> e;
    public final StateFlow<Boolean> f;
    public com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> g;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.MraidAdLoad$load$1", f = "MraidAdLoad.kt", i = {0}, l = {60, 80}, m = "invokeSuspend", n = {"decDeferred"}, s = {"L$0"})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6668a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a e;
        public final /* synthetic */ long f;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.MraidAdLoad$load$1$decDeferred$1", f = "MraidAdLoad.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0610a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super i>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6669a;
            public final /* synthetic */ long b;
            public final /* synthetic */ i c;
            public final /* synthetic */ s d;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s$a$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.MraidAdLoad$load$1$decDeferred$1$1", f = "MraidAdLoad.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0611a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super i>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public Object f6670a;
                public int b;
                public final /* synthetic */ i c;
                public final /* synthetic */ s d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0611a(i iVar, s sVar, Continuation<? super C0611a> continuation) {
                    super(2, continuation);
                    this.c = iVar;
                    this.d = sVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super i> continuation) {
                    return ((C0611a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0611a(this.c, this.d, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    i iVar;
                    com.moloco.sdk.internal.ortb.model.d dVarE;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.b;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        i iVar2 = this.c;
                        String strC = null;
                        if (iVar2 == null) {
                            return null;
                        }
                        s sVar = this.d;
                        try {
                            j jVar = sVar.c;
                            com.moloco.sdk.internal.ortb.model.c cVar = sVar.b;
                            if (cVar != null && (dVarE = cVar.e()) != null) {
                                strC = dVarE.c();
                            }
                            this.f6670a = iVar2;
                            this.b = 1;
                            Object objA = jVar.a(iVar2, strC, this);
                            if (objA == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            iVar = iVar2;
                            obj = objA;
                        } catch (Exception unused) {
                            return iVar2;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        iVar = (i) this.f6670a;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Exception unused2) {
                            return iVar;
                        }
                    }
                    return (i) obj;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0610a(long j, i iVar, s sVar, Continuation<? super C0610a> continuation) {
                super(2, continuation);
                this.b = j;
                this.c = iVar;
                this.d = sVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super i> continuation) {
                return ((C0610a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0610a(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f6669a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.b;
                    C0611a c0611a = new C0611a(this.c, this.d, null);
                    this.f6669a = 1;
                    obj = TimeoutKt.m9406withTimeoutOrNullKLykuaI(j, c0611a, this);
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

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.MraidAdLoad$load$1$mraidLoadResultDeferred$1", f = "MraidAdLoad.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6671a;
            public final /* synthetic */ long b;
            public final /* synthetic */ s c;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s$a$b$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.MraidAdLoad$load$1$mraidLoadResultDeferred$1$1", f = "MraidAdLoad.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0612a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f6672a;
                public final /* synthetic */ s b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0612a(s sVar, Continuation<? super C0612a> continuation) {
                    super(2, continuation);
                    this.b = sVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> continuation) {
                    return ((C0612a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0612a(this.b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f6672a;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function1 function1 = this.b.d;
                        this.f6672a = 1;
                        obj = function1.invoke(this);
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
            public b(long j, s sVar, Continuation<? super b> continuation) {
                super(2, continuation);
                this.b = j;
                this.c = sVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new b(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f6671a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.b;
                    C0612a c0612a = new C0612a(this.c, null);
                    this.f6671a = 1;
                    obj = TimeoutKt.m9406withTimeoutOrNullKLykuaI(j, c0612a, this);
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
            this.e = aVar;
            this.f = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = s.this.new a(this.e, this.f, continuation);
            aVar.c = obj;
            return aVar;
        }

        /* JADX WARN: Code duplicated, block: B:53:0x0100  */
        /* JADX WARN: Code duplicated, block: B:59:0x011c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Deferred deferred;
            com.moloco.sdk.internal.ortb.model.d dVarE;
            com.moloco.sdk.internal.ortb.model.o oVarE;
            com.moloco.sdk.internal.ortb.model.j jVarI;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a aVar;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar2;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c cVar;
            s sVar;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i != 0) {
                if (i == 1) {
                    deferred = (Deferred) this.c;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (TimeoutCancellationException unused) {
                        Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
                        aVar = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.MRAID_FULLSCREEN_AD_LOAD_INTERNAL_TIMEOUT_ERROR;
                        s.this.a(new com.moloco.sdk.internal.v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.MRAID_WEBVIEW_INTERNAL_TIMEOUT_ERROR));
                        aVar2 = this.e;
                        if (aVar2 != null) {
                            aVar2.a(aVar);
                        }
                        return Unit.INSTANCE;
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c) this.f6668a;
                    sVar = (s) this.c;
                    ResultKt.throwOnFailure(obj);
                }
                sVar.a(new com.moloco.sdk.internal.v.b(cVar.a((i) obj)));
                s.this.e.setValue(Boxing.boxBoolean(true));
                aVar3 = this.e;
                if (aVar3 != null) {
                    aVar3.a();
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.c;
            if (s.this.a() instanceof com.moloco.sdk.internal.v.b) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar4 = this.e;
                if (aVar4 != null) {
                    aVar4.a();
                }
                return Unit.INSTANCE;
            }
            Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new b(this.f, s.this, null), 3, null);
            com.moloco.sdk.internal.ortb.model.c cVar2 = s.this.b;
            Deferred deferredAsync$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new C0610a(this.f, (cVar2 == null || (dVarE = cVar2.e()) == null || (oVarE = dVarE.e()) == null || (jVarI = oVarE.i()) == null) ? null : com.moloco.sdk.internal.l.a(jVarI), s.this, null), 3, null);
            try {
                this.c = deferredAsync$default2;
                this.b = 1;
                Object objAwait = deferredAsync$default.await(this);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
                deferred = deferredAsync$default2;
                obj = objAwait;
            } catch (TimeoutCancellationException unused2) {
                deferred = deferredAsync$default2;
                Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
                aVar = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.MRAID_FULLSCREEN_AD_LOAD_INTERNAL_TIMEOUT_ERROR;
                s.this.a(new com.moloco.sdk.internal.v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.MRAID_WEBVIEW_INTERNAL_TIMEOUT_ERROR));
                aVar2 = this.e;
                if (aVar2 != null) {
                    aVar2.a(aVar);
                }
                return Unit.INSTANCE;
            }
            com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) obj;
            if (vVar == null) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar5 = this.e;
                if (aVar5 != null) {
                    aVar5.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.MRAID_AD_LOAD_INTERNAL_TIMEOUT_ERROR);
                }
            } else if (vVar instanceof com.moloco.sdk.internal.v.a) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar6 = this.e;
                if (aVar6 != null) {
                    aVar6.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((com.moloco.sdk.internal.v.a) vVar).a());
                }
                Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
            } else if (vVar instanceof com.moloco.sdk.internal.v.b) {
                s sVar2 = s.this;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c cVar3 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c) ((com.moloco.sdk.internal.v.b) vVar).a();
                this.c = sVar2;
                this.f6668a = cVar3;
                this.b = 2;
                Object objAwait2 = deferred.await(this);
                if (objAwait2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                cVar = cVar3;
                obj = objAwait2;
                sVar = sVar2;
                sVar.a(new com.moloco.sdk.internal.v.b(cVar.a((i) obj)));
                s.this.e.setValue(Boxing.boxBoolean(true));
                aVar3 = this.e;
                if (aVar3 != null) {
                    aVar3.a();
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(CoroutineScope scope, com.moloco.sdk.internal.ortb.model.c cVar, j decLoader, Function1<? super Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, ? extends Object> loadAndReadyMraid) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(decLoader, "decLoader");
        Intrinsics.checkNotNullParameter(loadAndReadyMraid, "loadAndReadyMraid");
        this.f6667a = scope;
        this.b = cVar;
        this.c = decLoader;
        this.d = loadAndReadyMraid;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.e = MutableStateFlow;
        this.f = MutableStateFlow;
        this.g = new com.moloco.sdk.internal.v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.MRAID_FULLSCREEN_WEBVIEW_CLIENT_UNRECOVERABLE_ERROR);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    public StateFlow<Boolean> isLoaded() {
        return this.f;
    }

    public final com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> a() {
        return this.g;
    }

    public final void a(com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> vVar) {
        Intrinsics.checkNotNullParameter(vVar, "<set-?>");
        this.g = vVar;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    public void a(long j, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar) {
        BuildersKt__Builders_commonKt.launch$default(this.f6667a, null, null, new a(aVar, j, null), 3, null);
    }
}
