package com.moloco.sdk.internal.publisher.nativead.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.ComposeView;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.a0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.j;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
public final class d extends FrameLayout {
    public static final a d = new a(null);
    public static final String e = "VideoContainer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a f6262a;
    public final a0 b;
    public ComposeView c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends Lambda implements Function3<Modifier, Composer, Integer, Unit> {
        public final /* synthetic */ Function0<Unit> b;
        public final /* synthetic */ j0 c;
        public final /* synthetic */ t d;

        public static final class a extends Lambda implements Function2<Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Unit f6264a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Unit unit) {
                super(2);
                this.f6264a = unit;
            }

            public final void a(Composer composer, int i) {
                if ((i & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1921737700, i, -1, "com.moloco.sdk.internal.publisher.nativead.ui.NativeAdVideoContainer.videoView.<anonymous>.<anonymous>.<anonymous> (NativeAdVideoContainer.kt:74)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                a(composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Function0<Unit> function0, j0 j0Var, t tVar) {
            super(3);
            this.b = function0;
            this.c = j0Var;
            this.d = tVar;
        }

        public final void a(Modifier modifier, Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(modifier, "modifier");
            if ((i & 14) == 0) {
                i2 = i | (composer.changed(modifier) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1867022133, i2, -1, "com.moloco.sdk.internal.publisher.nativead.ui.NativeAdVideoContainer.videoView.<anonymous> (NativeAdVideoContainer.kt:55)");
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar = d.this.f6262a;
            long jM1657getBlack0d7_KjU = Color.INSTANCE.m1657getBlack0d7_KjU();
            Function0<Unit> function0 = this.b;
            n.a(aVar, modifier, jM1657getBlack0d7_KjU, e.a(composer, 0), null, null, null, new i(function0, function0, function0), null, null, j.a(f.a(), composer, 6, 0), this.c, composer, ((i2 << 3) & 112) | 102457728, 0, 512);
            this.d.a(ComposableLambdaKt.composableLambda(composer, 1921737700, true, new a(Unit.INSTANCE)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
            a(modifier, composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a vastAdController, j0 viewVisibilityTracker, a0 viewLifecycleOwner, t watermark, Function0<Unit> function0) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vastAdController, "vastAdController");
        Intrinsics.checkNotNullParameter(viewVisibilityTracker, "viewVisibilityTracker");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        this.f6262a = vastAdController;
        this.b = viewLifecycleOwner;
        ComposeView composeViewA = com.moloco.sdk.internal.publisher.nativead.ui.b.a(context, ComposableLambdaKt.composableLambdaInstance(1867022133, true, new b(function0, viewVisibilityTracker, watermark)));
        addView(composeViewA, new ViewGroup.LayoutParams(-1, -1));
        this.c = composeViewA;
    }

    public static /* synthetic */ void getVideoView$annotations() {
    }

    public final void b() {
        removeAllViews();
        ComposeView composeView = this.c;
        if (composeView != null) {
            composeView.disposeComposition();
        }
        this.c = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.D, this, me);
        return super.dispatchTouchEvent(me);
    }

    public final ComposeView getVideoView() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MolocoLogger.info$default(MolocoLogger.INSTANCE, e, "onAttachedToWindow", null, false, 12, null);
        this.b.a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MolocoLogger.info$default(MolocoLogger.INSTANCE, e, "onDetachedFromWindow", null, false, 12, null);
        this.b.b(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.b.d(this);
        } else {
            this.b.c(this);
        }
    }

    public final void setVideoView(ComposeView composeView) {
        this.c = composeView;
    }

    public final void a() {
        this.f6262a.destroy();
        b();
    }
}
