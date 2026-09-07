package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import android.webkit.WebView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class m extends e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g {
    public final Function0<Unit> m;
    public final Function0<Unit> n;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h o;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidInline", f = "MraidInline.kt", i = {0}, l = {41}, m = "load", n = {"this"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6649a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return m.this.c(this);
        }
    }

    public /* synthetic */ m(Context context, String str, Function0 function0, Function0 function1, Function0 function2, Function1 function3, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, f fVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h hVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, function0, function1, function2, function3, z, mVar, fVar, (i & 512) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.j.a() : hVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e
    public void S() {
        super.S();
        this.m.invoke();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c button) {
        Intrinsics.checkNotNullParameter(button, "button");
        this.o.a(button);
    }

    public final WebView c() {
        return t().c();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e
    public void l() {
        super.l();
        this.n.invoke();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a buttonType) {
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        this.o.a(buttonType);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object c(Continuation<? super WebView> continuation) {
        a aVar;
        m mVar;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.d = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objB = aVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objB);
            aVar.f6649a = this;
            aVar.d = 1;
            objB = b(aVar);
            if (objB == coroutine_suspended) {
                return coroutine_suspended;
            }
            mVar = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mVar = (m) aVar.f6649a;
            ResultKt.throwOnFailure(objB);
        }
        if (objB instanceof com.moloco.sdk.internal.v.b) {
            return mVar.t().c();
        }
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Context context, String adm, Function0<Unit> onNeedToDetachAdViewBeforeExpand, Function0<Unit> onExpandAdViewClosed, Function0<Unit> onClick, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, Unit> onError, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m externalLinkHandler, f mraidBridge, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h buttonTracker) {
        super(context, adm, q.Inline, onClick, onError, externalLinkHandler, z, mraidBridge);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(onNeedToDetachAdViewBeforeExpand, "onNeedToDetachAdViewBeforeExpand");
        Intrinsics.checkNotNullParameter(onExpandAdViewClosed, "onExpandAdViewClosed");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(mraidBridge, "mraidBridge");
        Intrinsics.checkNotNullParameter(buttonTracker, "buttonTracker");
        this.m = onNeedToDetachAdViewBeforeExpand;
        this.n = onExpandAdViewClosed;
        this.o = buttonTracker;
    }
}
