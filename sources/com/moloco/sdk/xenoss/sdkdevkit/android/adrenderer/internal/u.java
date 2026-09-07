package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes12.dex */
public final class u implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6687a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t b;
    public final s c;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e d;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j e;
    public final MraidActivity.Companion f;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h g;
    public final CoroutineScope h;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a i;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d j;
    public boolean k;
    public final MutableStateFlow<Boolean> l;
    public final StateFlow<Boolean> m;
    public final MutableStateFlow<Boolean> n;
    public final StateFlow<Boolean> o;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, Unit> {
        public a(Object obj) {
            super(1, obj, u.class, "onError", "onError(Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/errors/MraidAdError;)V", 0);
        }

        public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((u) this.receiver).a(p0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar) {
            a(dVar);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d f6688a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d dVar) {
            super(0);
            this.f6688a = dVar;
        }

        public final void a() {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d dVar = this.f6688a;
            if (dVar != null) {
                dVar.a();
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function0<Unit> {
        public c(Object obj) {
            super(0, obj, u.class, "destroy", "destroy()V", 0);
        }

        public final void a() {
            ((u) this.receiver).destroy();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function0<Unit> {
        public d(Object obj) {
            super(0, obj, u.class, "onForciblyClosed", "onForciblyClosed()V", 0);
        }

        public final void a() {
            ((u) this.receiver).n();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public u(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t watermark, s mraidAdLoader, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e mraidBaseAd, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j mraidFullscreenController, MraidActivity.Companion mraidActivity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(mraidAdLoader, "mraidAdLoader");
        Intrinsics.checkNotNullParameter(mraidBaseAd, "mraidBaseAd");
        Intrinsics.checkNotNullParameter(mraidFullscreenController, "mraidFullscreenController");
        Intrinsics.checkNotNullParameter(mraidActivity, "mraidActivity");
        this.f6687a = context;
        this.b = watermark;
        this.c = mraidAdLoader;
        this.d = mraidBaseAd;
        this.e = mraidFullscreenController;
        this.f = mraidActivity;
        this.g = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.MRAID;
        this.h = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        Boolean bool = Boolean.FALSE;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(bool);
        this.l = MutableStateFlow;
        this.m = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(bool);
        this.n = MutableStateFlow2;
        this.o = MutableStateFlow2;
    }

    public static Object b(u uVar) {
        return Reflection.property0(new PropertyReference0Impl(uVar.c, s.class, "isLoaded", "isLoaded()Lkotlinx/coroutines/flow/StateFlow;", 0));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.h, null, 1, null);
        this.d.destroy();
        this.l.setValue(Boolean.FALSE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h getCreativeType() {
        return this.g;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    public StateFlow<Boolean> isLoaded() {
        return this.c.isLoaded();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l
    public StateFlow<Boolean> j() {
        return this.o;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a
    public StateFlow<Boolean> l() {
        return this.m;
    }

    public final void n() {
        this.n.setValue(Boolean.TRUE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    public void a(long j, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar) {
        this.i = aVar;
        this.d.a(new a(this));
        this.c.a(j, aVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e options, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d dVar) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.d.a(new b(dVar));
        this.j = dVar;
        this.k = true;
        com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> vVarA = this.c.a();
        if (vVarA instanceof com.moloco.sdk.internal.v.a) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d) ((com.moloco.sdk.internal.v.a) vVarA).a();
            if (dVar != null) {
                dVar.a(dVar2);
                return;
            }
            return;
        }
        if (vVarA instanceof com.moloco.sdk.internal.v.b) {
            if (this.f.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c) ((com.moloco.sdk.internal.v.b) vVarA).a(), this.e, this.f6687a, options, this.b, new c(this), new d(this))) {
                this.l.setValue(Boolean.TRUE);
                return;
            } else {
                if (dVar != null) {
                    dVar.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.MRAID_FULLSCREEN_AD_ACTIVITY_SHOW_FAILED_ERROR);
                    return;
                }
                return;
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar) {
        if (this.k) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d dVar2 = this.j;
            if (dVar2 != null) {
                dVar2.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.e.b(dVar));
                return;
            }
            return;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b.a aVar = this.i;
        if (aVar != null) {
            aVar.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.e.b(dVar));
        }
    }
}
