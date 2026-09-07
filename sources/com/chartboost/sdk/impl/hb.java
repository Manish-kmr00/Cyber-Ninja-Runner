package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/chartboost/sdk/impl/hb;", "Lcom/chartboost/sdk/impl/i9;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()V", "Landroid/view/SurfaceView;", "e", "Landroid/view/SurfaceView;", "surface", "Landroid/widget/FrameLayout;", InneractiveMediationDefs.GENDER_FEMALE, "Landroid/widget/FrameLayout;", "videoBackground", "Landroid/content/Context;", "context", "", "html", "Lcom/chartboost/sdk/impl/t3;", "callback", "Lcom/chartboost/sdk/impl/i6;", "impressionInterface", "Lcom/chartboost/sdk/impl/g7;", "nativeBridgeCommand", "baseExternalPathURL", "Lcom/chartboost/sdk/impl/l4;", "eventTracker", "Lkotlin/Function1;", "Lcom/chartboost/sdk/impl/p2;", "cbWebViewFactory", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/chartboost/sdk/impl/t3;Lcom/chartboost/sdk/impl/i6;Lcom/chartboost/sdk/impl/g7;Ljava/lang/String;Landroid/view/SurfaceView;Landroid/widget/FrameLayout;Lcom/chartboost/sdk/impl/l4;Lkotlin/jvm/functions/Function1;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class hb extends i9 {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public SurfaceView surface;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public FrameLayout videoBackground;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/Context;", "it", "Lcom/chartboost/sdk/impl/p2;", "a", "(Landroid/content/Context;)Lcom/chartboost/sdk/impl/p2;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function1<Context, p2> {
        public static final a b = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p2 invoke(Context it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new p2(it);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hb(Context context, String html, t3 callback, i6 impressionInterface, g7 nativeBridgeCommand, String str, SurfaceView surfaceView, FrameLayout videoBackground, l4 eventTracker, Function1<? super Context, ? extends p2> cbWebViewFactory) {
        super(context, html, callback, impressionInterface, str, nativeBridgeCommand, null, eventTracker, cbWebViewFactory, 64, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(html, "html");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(impressionInterface, "impressionInterface");
        Intrinsics.checkNotNullParameter(nativeBridgeCommand, "nativeBridgeCommand");
        Intrinsics.checkNotNullParameter(videoBackground, "videoBackground");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(cbWebViewFactory, "cbWebViewFactory");
        this.surface = surfaceView;
        this.videoBackground = videoBackground;
        if (surfaceView == null) {
            throw new IllegalStateException("SurfaceView is not ready. Cannot display video.".toString());
        }
        videoBackground.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        videoBackground.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.videoBackground);
        this.videoBackground.addView(this.surface);
        addView(getWebViewContainer());
        callback.a();
        callback.b();
    }

    @Override // com.chartboost.sdk.impl.i9, com.chartboost.sdk.impl.h3, com.chartboost.sdk.impl.vb, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.c, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.chartboost.sdk.impl.i9, com.chartboost.sdk.impl.h3, com.chartboost.sdk.impl.vb, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public final void b() {
        SurfaceView surfaceView = this.surface;
        if (surfaceView != null) {
            if (surfaceView != null) {
                surfaceView.setVisibility(8);
            }
            this.videoBackground.removeView(this.surface);
            removeView(this.videoBackground);
        }
    }

    public /* synthetic */ hb(Context context, String str, t3 t3Var, i6 i6Var, g7 g7Var, String str2, SurfaceView surfaceView, FrameLayout frameLayout, l4 l4Var, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, t3Var, i6Var, g7Var, str2, surfaceView, (i & 128) != 0 ? new FrameLayout(context) : frameLayout, l4Var, (i & 512) != 0 ? a.b : function1);
    }
}
