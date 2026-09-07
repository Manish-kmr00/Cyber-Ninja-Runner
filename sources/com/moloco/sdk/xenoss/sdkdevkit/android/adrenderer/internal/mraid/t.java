package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes7.dex */
public final class t implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f6656a;
    public final CoroutineScope b;
    public Job c;
    public final View.OnLayoutChangeListener d;
    public final MutableStateFlow<Boolean> e;
    public final StateFlow<Boolean> f;
    public final r g;
    public final MutableStateFlow<a> h;
    public final StateFlow<a> i;

    public static final class a {
        public static final int b = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r f6657a;

        public a(r value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.f6657a = value;
        }

        public final r a() {
            return this.f6657a;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidViewVisualMetricsTracker$layoutChangeListener$1$1", f = "MraidViewVisualMetricsTracker.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6658a;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i, int i2, int i3, int i4, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return t.this.new b(this.c, this.d, this.e, this.f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6658a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.f6658a = 1;
                if (DelayKt.delay(200L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            t.this.n();
            t.this.a(this.c, this.d, this.e, this.f);
            return Unit.INSTANCE;
        }
    }

    public t(View view, Context context, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f6656a = view;
        this.b = CoroutineScopeKt.plus(scope, com.moloco.sdk.internal.scheduling.b.a().getMain());
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.t$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                t.a(this.f$0, view2, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
        this.d = onLayoutChangeListener;
        view.addOnLayoutChangeListener(onLayoutChangeListener);
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.e = MutableStateFlow;
        this.f = MutableStateFlow;
        r rVar = new r(context);
        this.g = rVar;
        MutableStateFlow<a> MutableStateFlow2 = StateFlowKt.MutableStateFlow(new a(rVar));
        this.h = MutableStateFlow2;
        this.i = MutableStateFlow2;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public void destroy() {
        Job job = this.c;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.f6656a.removeOnLayoutChangeListener(this.d);
    }

    public final StateFlow<a> j() {
        return this.i;
    }

    public final StateFlow<Boolean> l() {
        return this.f;
    }

    public final void n() {
        this.e.setValue(Boolean.valueOf(this.f6656a.isShown()));
    }

    public static final void a(t this$0, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Job job = this$0.c;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this$0.c = BuildersKt__Builders_commonKt.launch$default(this$0.b, null, null, this$0.new b(i, i2, i3, i4, null), 3, null);
    }

    public final void a(int i, int i2, int i3, int i4) {
        Rect rect = new Rect(i, i2, i3, i4);
        int iWidth = rect.width();
        int iHeight = rect.height();
        r rVar = this.g;
        rVar.a(i, i2, iWidth, iHeight);
        rVar.b(i, i2, iWidth, iHeight);
        rVar.c(i, i2, iWidth, iHeight);
        rVar.a(iWidth, iHeight);
        this.h.setValue(new a(this.g));
    }
}
