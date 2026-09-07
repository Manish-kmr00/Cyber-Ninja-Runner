package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.moloco.sdk.internal.MolocoLogger;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> {
    public final Context g;
    public final com.moloco.sdk.internal.ortb.model.c h;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g i;
    public final m j;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t k;
    public final com.moloco.sdk.internal.a0 l;
    public final CoroutineScope m;
    public final com.moloco.sdk.internal.services.s n;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h o;
    public final String p;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h q;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f r;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r> s;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d> t;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d> u;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b v;
    public final MutableStateFlow<Boolean> w;
    public final StateFlow<Boolean> x;

    public static final class a implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MutableStateFlow<Boolean> f6519a;
        public final StateFlow<Boolean> b;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a d;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0584a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f6520a;

            static {
                int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.values().length];
                try {
                    iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.VAST.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.MRAID.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.STATIC.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f6520a = iArr;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$b, reason: collision with other inner class name */
        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedBanner$adLoader$1$load$1", f = "AggregatedBanner.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0585b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6521a;
            public final /* synthetic */ b c;
            public final /* synthetic */ long d;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a e;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$b$a, reason: collision with other inner class name */
            public static final class C0586a implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a f6522a;
                public final /* synthetic */ b b;

                /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$b$a$a, reason: collision with other inner class name */
                public /* synthetic */ class C0587a {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f6523a;

                    static {
                        int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.values().length];
                        try {
                            iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.VAST.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.MRAID.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.STATIC.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        f6523a = iArr;
                    }
                }

                public C0586a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar, b bVar) {
                    this.f6522a = aVar;
                    this.b = bVar;
                }

                @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a
                public void a() {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar = this.f6522a;
                    if (aVar != null) {
                        aVar.a();
                    }
                }

                @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a
                public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a timeoutError) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar;
                    Intrinsics.checkNotNullParameter(timeoutError, "timeoutError");
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h creativeType = this.b.getCreativeType();
                    int i = creativeType == null ? -1 : C0587a.f6523a[creativeType.ordinal()];
                    if (i == -1) {
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, this.b.p, "creativeType is null", new Throwable(), false, 8, null);
                        return;
                    }
                    if (i == 1) {
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar2 = this.f6522a;
                        if (aVar2 != null) {
                            aVar2.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.VAST_BANNER_AD_LOAD_INTERNAL_TIMEOUT_ERROR);
                            return;
                        }
                        return;
                    }
                    if (i != 2) {
                        if (i == 3 && (aVar = this.f6522a) != null) {
                            aVar.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.STATIC_BANNER_AD_LOAD_INTERNAL_TIMEOUT_ERROR);
                            return;
                        }
                        return;
                    }
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar3 = this.f6522a;
                    if (aVar3 != null) {
                        aVar3.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.MRAID_BANNER_AD_LOAD_INTERNAL_TIMEOUT_ERROR);
                    }
                }

                @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a
                public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalError) {
                    Intrinsics.checkNotNullParameter(internalError, "internalError");
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar = this.f6522a;
                    if (aVar != null) {
                        aVar.a(internalError);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0585b(b bVar, long j, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar, Continuation<? super C0585b> continuation) {
                super(2, continuation);
                this.c = bVar;
                this.d = j;
                this.e = aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0585b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return a.this.new C0585b(this.c, this.d, this.e, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f6521a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    a aVar = a.this;
                    this.f6521a = 1;
                    if (aVar.a(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w bannerImpl = this.c.getBannerImpl();
                if (bannerImpl != null) {
                    bannerImpl.a(this.d, new C0586a(this.e, this.c));
                }
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedBanner$adLoader$1", f = "AggregatedBanner.kt", i = {0}, l = {151}, m = "prepareBanner", n = {"this"}, s = {"L$0"})
        public static final class c extends ContinuationImpl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f6524a;
            public /* synthetic */ Object b;
            public int d;

            public c(Continuation<? super c> continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.b = obj;
                this.d |= Integer.MIN_VALUE;
                return a.this.a(this);
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedBanner$adLoader$1$prepareBanner$2", f = "AggregatedBanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class d extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6525a;
            public /* synthetic */ boolean b;

            public d(Continuation<? super d> continuation) {
                super(2, continuation);
            }

            public final Object a(boolean z, Continuation<? super Unit> continuation) {
                return ((d) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                d dVar = a.this.new d(continuation);
                dVar.b = ((Boolean) obj).booleanValue();
                return dVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                return a(bool.booleanValue(), continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f6525a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                a.this.f6519a.setValue(Boxing.boxBoolean(this.b));
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedBanner$adLoader$1$prepareBanner$3", f = "AggregatedBanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class e extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6526a;
            public /* synthetic */ boolean b;
            public final /* synthetic */ b c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(b bVar, Continuation<? super e> continuation) {
                super(2, continuation);
                this.c = bVar;
            }

            public final Object a(boolean z, Continuation<? super Unit> continuation) {
                return ((e) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                e eVar = new e(this.c, continuation);
                eVar.b = ((Boolean) obj).booleanValue();
                return eVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                return a(bool.booleanValue(), continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f6526a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.c.w.setValue(Boxing.boxBoolean(this.b));
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedBanner$adLoader$1$prepareBanner$crType$1", f = "AggregatedBanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6527a;
            public final /* synthetic */ b b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(b bVar, Continuation<? super f> continuation) {
                super(2, continuation);
                this.b = bVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h> continuation) {
                return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new f(this.b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f6527a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h hVarC = h.f6567a.c(this.b.h.a());
                this.b.q = hVarC;
                return hVarC;
            }
        }

        public a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar) {
            this.d = aVar;
            MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
            this.f6519a = MutableStateFlow;
            this.b = FlowKt.asStateFlow(MutableStateFlow);
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
        public StateFlow<Boolean> isLoaded() {
            return this.b;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
        public void a(long j, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar) {
            BuildersKt__Builders_commonKt.launch$default(b.this.m, null, null, new C0585b(b.this, j, aVar, null), 3, null);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x007e  */
        /* JADX WARN: Code duplicated, block: B:26:0x0081  */
        /* JADX WARN: Code duplicated, block: B:29:0x0086  */
        /* JADX WARN: Code duplicated, block: B:31:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:32:0x00af  */
        /* JADX WARN: Code duplicated, block: B:35:0x00b3  */
        /* JADX WARN: Code duplicated, block: B:37:0x00f5  */
        /* JADX WARN: Code duplicated, block: B:38:0x0127  */
        /* JADX WARN: Code duplicated, block: B:7:0x0017  */
        public final Object a(Continuation<? super Unit> continuation) throws Throwable {
            c cVar;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h creativeType;
            a aVar;
            int i;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w bannerImpl;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w bannerImpl2;
            StateFlow<Boolean> stateFlowL;
            Flow flowOnEach;
            StateFlow<Boolean> stateFlowIsLoaded;
            Flow flowOnEach2;
            com.moloco.sdk.internal.ortb.model.m mVarA;
            com.moloco.sdk.internal.ortb.model.b bVarA;
            if (continuation instanceof c) {
                cVar = (c) continuation;
                int i2 = cVar.d;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    cVar.d = i2 - Integer.MIN_VALUE;
                } else {
                    cVar = new c(continuation);
                }
            } else {
                cVar = new c(continuation);
            }
            Object objWithContext = cVar.b;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = cVar.d;
            if (i3 == 0) {
                ResultKt.throwOnFailure(objWithContext);
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, b.this.p, "Preparing banner", false, 4, null);
                creativeType = b.this.getCreativeType();
                if (creativeType == null) {
                    CoroutineContext coroutineContext = com.moloco.sdk.internal.scheduling.b.a().getDefault();
                    f fVar = new f(b.this, null);
                    cVar.f6524a = this;
                    cVar.d = 1;
                    objWithContext = BuildersKt.withContext(coroutineContext, fVar, cVar);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar = this;
                } else {
                    aVar = this;
                }
                i = C0584a.f6520a[creativeType.ordinal()];
                if (i != 1) {
                    b.this.l.a(b.this);
                    b.this.s = new g0(b.this.g, aVar.d, b.this.i.c(), b.this.j, b.this.m, new e0(b.this.h, b.this.m, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.f.a(b.this.g), com.moloco.sdk.service_locator.a.C0569a.f6452a.a(), false));
                } else if (i != 2) {
                    b.this.t = new t(b.this.g, b.this.h.a(), b.this.j, b.this.k, null, b.this.m, 16, null);
                } else if (i == 3) {
                    Context context = b.this.g;
                    com.moloco.sdk.internal.services.s sVar = b.this.n;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h hVar = b.this.o;
                    mVarA = b.this.h.e().a();
                    if (mVarA != null) {
                        bVarA = mVarA.a();
                    } else {
                        bVarA = null;
                    }
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a(context, null, sVar, hVar, bVarA != null, null, 34, null);
                    b.this.u = new z(b.this.g, b.this.k, aVar2, new y(b.this.h.a(), b.this.m, aVar2), b.this.m, null, 32, null);
                }
                bannerImpl = b.this.getBannerImpl();
                if (bannerImpl != null && (stateFlowIsLoaded = bannerImpl.isLoaded()) != null && (flowOnEach2 = FlowKt.onEach(stateFlowIsLoaded, aVar.new d(null))) != null) {
                    FlowKt.launchIn(flowOnEach2, b.this.m);
                }
                bannerImpl2 = b.this.getBannerImpl();
                if (bannerImpl2 != null && (stateFlowL = bannerImpl2.l()) != null && (flowOnEach = FlowKt.onEach(stateFlowL, new e(b.this, null))) != null) {
                    FlowKt.launchIn(flowOnEach, b.this.m);
                }
                b bVar = b.this;
                bVar.setAdShowListener(bVar.getAdShowListener());
                return Unit.INSTANCE;
            }
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar = (a) cVar.f6524a;
            ResultKt.throwOnFailure(objWithContext);
            creativeType = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h) objWithContext;
            i = C0584a.f6520a[creativeType.ordinal()];
            if (i != 1) {
                b.this.l.a(b.this);
                b.this.s = new g0(b.this.g, aVar.d, b.this.i.c(), b.this.j, b.this.m, new e0(b.this.h, b.this.m, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.f.a(b.this.g), com.moloco.sdk.service_locator.a.C0569a.f6452a.a(), false));
            } else if (i != 2) {
                b.this.t = new t(b.this.g, b.this.h.a(), b.this.j, b.this.k, null, b.this.m, 16, null);
            } else if (i == 3) {
                Context context2 = b.this.g;
                com.moloco.sdk.internal.services.s sVar2 = b.this.n;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h hVar2 = b.this.o;
                mVarA = b.this.h.e().a();
                if (mVarA != null) {
                    bVarA = mVarA.a();
                } else {
                    bVarA = null;
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar3 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a(context2, null, sVar2, hVar2, bVarA != null, null, 34, null);
                b.this.u = new z(b.this.g, b.this.k, aVar3, new y(b.this.h.a(), b.this.m, aVar3), b.this.m, null, 32, null);
            }
            bannerImpl = b.this.getBannerImpl();
            if (bannerImpl != null) {
                FlowKt.launchIn(flowOnEach2, b.this.m);
            }
            bannerImpl2 = b.this.getBannerImpl();
            if (bannerImpl2 != null) {
                FlowKt.launchIn(flowOnEach, b.this.m);
            }
            b bVar2 = b.this;
            bVar2.setAdShowListener(bVar2.getAdShowListener());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$b, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedBanner$destroy$1", f = "AggregatedBanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0588b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6528a;

        public C0588b(Continuation<? super C0588b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0588b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new C0588b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6528a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            b.super.destroy();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w bannerImpl = b.this.getBannerImpl();
            if (bannerImpl != null) {
                bannerImpl.destroy();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h hVar, com.moloco.sdk.internal.ortb.model.c bid, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g options, m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t watermark, com.moloco.sdk.internal.a0 viewLifecycleOwner, CoroutineScope scope, com.moloco.sdk.internal.services.s clickthroughService, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h buttonTracker) {
        super(context, scope);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(clickthroughService, "clickthroughService");
        Intrinsics.checkNotNullParameter(buttonTracker, "buttonTracker");
        this.g = context;
        this.h = bid;
        this.i = options;
        this.j = externalLinkHandler;
        this.k = watermark;
        this.l = viewLifecycleOwner;
        this.m = scope;
        this.n = clickthroughService;
        this.o = buttonTracker;
        this.p = "AggregatedBanner";
        setTag("MolocoAggregatedBannerView");
        this.q = hVar;
        this.v = new a(customUserEventBuilderService);
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.w = MutableStateFlow;
        this.x = FlowKt.asStateFlow(MutableStateFlow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<?> getBannerImpl() {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r> wVar = this.s;
        if (wVar != null) {
            return wVar;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d> wVar2 = this.t;
        return wVar2 == null ? this.u : wVar2;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public void destroy() {
        BuildersKt__Builders_commonKt.launch$default(this.m, null, null, new C0588b(null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.D, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b getAdLoader() {
        return this.v;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h getCreativeType() {
        return this.q;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f getAdShowListener() {
        return this.r;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w
    public void j() {
        setAdView(getBannerImpl());
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a
    public StateFlow<Boolean> l() {
        return this.x;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w
    public void setAdShowListener(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f fVar) {
        Unit unit;
        this.r = fVar;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r> wVar = this.s;
        if (wVar != null) {
            wVar.setAdShowListener(fVar);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d> wVar2 = this.t;
            if (wVar2 == null) {
                wVar2 = this.u;
            }
            if (wVar2 == null) {
                return;
            }
            wVar2.setAdShowListener(fVar);
        }
    }
}
