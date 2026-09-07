package com.moloco.sdk.internal.services;

import com.moloco.sdk.internal.MolocoLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes9.dex */
public final class t implements s {
    public static final a c = new a(null);
    public static final String d = "ClickthroughService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m f6425a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.ClickthroughServiceImpl", f = "ClickthroughService.kt", i = {0, 0}, l = {63, 67}, m = "runBannerClickThrough", n = {"this", "clickthroughEvent"}, s = {"L$0", "L$1"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6426a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return t.this.a(null, null, null, null, this);
        }
    }

    public t(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService) {
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        this.f6425a = externalLinkHandler;
        this.b = customUserEventBuilderService;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    @Override // com.moloco.sdk.internal.services.s
    public Object a(String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a aVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h hVar, MutableSharedFlow<Unit> mutableSharedFlow, Continuation<? super Unit> continuation) throws Throwable {
        b bVar;
        MutableSharedFlow mutableSharedFlow2;
        Object objA;
        t tVar;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.e = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object obj = bVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.e;
        if (i2 != 0) {
            if (i2 == 1) {
                MutableSharedFlow mutableSharedFlow3 = (MutableSharedFlow) bVar.b;
                tVar = (t) bVar.f6426a;
                ResultKt.throwOnFailure(obj);
                objA = obj;
                mutableSharedFlow2 = mutableSharedFlow3;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.c cVar = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.c.f6784a;
        com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.d dVar = new com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.d(new com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.f(cVar.a(aVar.g()), cVar.a(aVar.h())), new com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.f(cVar.a(aVar.i()), cVar.a(aVar.j())), new com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.g(cVar.a(aVar.l()), cVar.a(aVar.k())), hVar.p());
        com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar2 = this.b;
        bVar.f6426a = this;
        mutableSharedFlow2 = mutableSharedFlow;
        bVar.b = mutableSharedFlow2;
        bVar.e = 1;
        objA = aVar2.a(jCurrentTimeMillis, dVar, str, bVar);
        if (objA == coroutine_suspended) {
            return coroutine_suspended;
        }
        tVar = this;
        String str2 = (String) objA;
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, d, "Launching url: " + str2, false, 4, null);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar = tVar.f6425a;
        if (str2 == null) {
            str2 = "";
        }
        if (!mVar.a(str2) || mutableSharedFlow2 == null) {
            return Unit.INSTANCE;
        }
        Unit unit = Unit.INSTANCE;
        bVar.f6426a = null;
        bVar.b = null;
        bVar.e = 2;
        if (mutableSharedFlow2.emit(unit, bVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
