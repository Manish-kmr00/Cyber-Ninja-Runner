package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: loaded from: classes.dex */
public final class ab1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f00 f8389a;
    private final gb0 b;
    private final s41 c;

    @DebugMetadata(c = "com.monetization.ads.nativeads.video.cache.NativeVideoLoadController", f = "NativeVideoLoadController.kt", i = {0, 0, 0, 0, 1}, l = {38, 44}, m = "loadVideo", n = {"this", "context", "debugEventsReporter", "loadAutomatically", "updatedNativeAdBlock"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0"})
    static final class a extends ContinuationImpl {
        Object b;
        Context c;
        aw d;
        boolean e;
        /* synthetic */ Object f;
        int h;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return ab1.this.a(false, null, null, null, this);
        }
    }

    public /* synthetic */ ab1(o3 o3Var, Context context, g5 g5Var) {
        this(o3Var, context, g5Var, new f00(context, g5Var), new gb0(context, g5Var), new s41(context, o3Var));
    }

    public ab1(o3 adConfiguration, Context context, g5 adLoadingPhasesManager, f00 defaultNativeVideoLoader, gb0 firstNativeVideoLoader, s41 nativeAdBlockVideoWrapperLoader) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(defaultNativeVideoLoader, "defaultNativeVideoLoader");
        Intrinsics.checkNotNullParameter(firstNativeVideoLoader, "firstNativeVideoLoader");
        Intrinsics.checkNotNullParameter(nativeAdBlockVideoWrapperLoader, "nativeAdBlockVideoWrapperLoader");
        this.f8389a = defaultNativeVideoLoader;
        this.b = firstNativeVideoLoader;
        this.c = nativeAdBlockVideoWrapperLoader;
    }

    public final void a() {
        this.f8389a.a();
        this.b.a();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(boolean z, Context context, o41 o41Var, aw awVar, Continuation<? super o41> continuation) throws Throwable {
        a aVar;
        ab1 ab1Var;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.h;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.h = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objA = aVar.f;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.h;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            s41 s41Var = this.c;
            aVar.b = this;
            aVar.c = context;
            aVar.d = awVar;
            aVar.e = z;
            aVar.h = 1;
            objA = s41Var.a(context, o41Var, aVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            ab1Var = this;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                o41 o41Var2 = (o41) aVar.b;
                ResultKt.throwOnFailure(objA);
                return o41Var2;
            }
            z = aVar.e;
            awVar = aVar.d;
            context = aVar.c;
            ab1Var = (ab1) aVar.b;
            ResultKt.throwOnFailure(objA);
        }
        o41 o41Var3 = (o41) objA;
        if (o41Var3 == null) {
            return null;
        }
        if (z) {
            o8<?> o8VarB = o41Var3.b();
            if (o8VarB.R()) {
                aVar.b = o41Var3;
                aVar.c = null;
                aVar.d = null;
                aVar.h = 2;
                ab1Var.getClass();
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(aVar), 1);
                cancellableContinuationImpl.initCancellability();
                bb1 bb1Var = new bb1(cancellableContinuationImpl);
                boolean zA = u80.a(context, t80.c);
                if (Intrinsics.areEqual(ib1.FIRST_VIDEO_PRELOADING_STRATEGY.a(), o8VarB.F()) && zA) {
                    ab1Var.b.a(o41Var3, bb1Var, awVar);
                } else {
                    ab1Var.f8389a.a(o41Var3, bb1Var, awVar);
                }
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(aVar);
                }
                if (result != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    result = Unit.INSTANCE;
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return o41Var3;
    }

    public final void a(Context context, rb2<gb1> videoAdInfo, o8<?> adResponse) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        boolean zA = u80.a(context, t80.c);
        if (Intrinsics.areEqual(ib1.FIRST_VIDEO_PRELOADING_STRATEGY.a(), adResponse.F()) && zA) {
            this.b.a(videoAdInfo.e());
        }
    }
}
