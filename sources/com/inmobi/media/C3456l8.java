package com.inmobi.media;

import android.R;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.l8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3456l8 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3370a;
    public C3398h8 b;
    public final HandlerC3440k8 c;
    public C3556s8 d;
    public boolean e;
    public final Z2 f;
    public final Z2 g;
    public final ProgressBar h;
    public final RelativeLayout i;
    public boolean j;
    public final float k;
    public final View.OnClickListener l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3456l8(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f3370a = "l8";
        this.k = AbstractC3565t3.d().c;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.i = relativeLayout;
        this.f = new Z2(context, (byte) 9, null);
        this.g = new Z2(context, (byte) 10, null);
        ProgressBar progressBar = new ProgressBar(context, null, R.attr.progressBarStyleHorizontal);
        this.h = progressBar;
        progressBar.setScaleY(0.8f);
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setPadding(0, 0, 0, 0);
        a();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12, -1);
        float f = AbstractC3565t3.d().c;
        layoutParams.setMargins(0, (int) ((-6) * f), 0, (int) ((-8) * f));
        Drawable progressDrawable = progressBar.getProgressDrawable();
        LayerDrawable layerDrawable = progressDrawable instanceof LayerDrawable ? (LayerDrawable) progressDrawable : null;
        if (layerDrawable != null) {
            Drawable drawable = layerDrawable.getDrawable(0);
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
            drawable.setColorFilter(new PorterDuffColorFilter(-1, mode));
            layerDrawable.getDrawable(2).setColorFilter(new PorterDuffColorFilter(-327674, mode));
        }
        relativeLayout.addView(progressBar, layoutParams);
        this.c = new HandlerC3440k8(this);
        this.l = new View.OnClickListener() { // from class: com.inmobi.media.l8$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/l8$$ExternalSyntheticLambda0;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(com.safedk.android.utils.h.i, view);
                safedk_l8$$ExternalSyntheticLambda0_onClick_91145c05a20041cfe9e7ecf66fc27b82(view);
            }

            public void safedk_l8$$ExternalSyntheticLambda0_onClick_91145c05a20041cfe9e7ecf66fc27b82(View p0) {
                C3456l8.a(this.f$0, p0);
            }
        };
    }

    public final void a() {
        int i = (int) (30 * this.k);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(12, -1);
        this.i.addView(this.f, layoutParams);
        this.f.setOnClickListener(this.l);
    }

    public final void b() {
        int i = (int) (30 * this.k);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(12, -1);
        this.i.addView(this.g, layoutParams);
        this.g.setOnClickListener(this.l);
    }

    public final void c() {
        if (this.e) {
            try {
                HandlerC3440k8 handlerC3440k8 = this.c;
                if (handlerC3440k8 != null) {
                    handlerC3440k8.removeMessages(2);
                }
                setVisibility(8);
            } catch (IllegalArgumentException e) {
                String TAG = this.f3370a;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                C3339d5 c3339d5 = C3339d5.f3292a;
                P1 event = new P1(e);
                Intrinsics.checkNotNullParameter(event, "event");
                C3339d5.c.a(event);
            }
            this.e = false;
        }
    }

    public final void d() {
        if (!this.e) {
            C3556s8 c3556s8 = this.d;
            if (c3556s8 != null) {
                int currentPosition = c3556s8.getCurrentPosition();
                int duration = c3556s8.getDuration();
                if (duration != 0) {
                    this.h.setProgress((currentPosition * 100) / duration);
                }
            }
            this.e = true;
            C3556s8 c3556s9 = this.d;
            Object tag = c3556s9 != null ? c3556s9.getTag() : null;
            C3426j8 c3426j8 = tag instanceof C3426j8 ? (C3426j8) tag : null;
            if (c3426j8 != null) {
                this.f.setVisibility(c3426j8.A ? 0 : 4);
                this.h.setVisibility(c3426j8.C ? 0 : 4);
            }
            setVisibility(0);
        }
        HandlerC3440k8 handlerC3440k8 = this.c;
        if (handlerC3440k8 != null) {
            handlerC3440k8.sendEmptyMessage(2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent event) {
        C3556s8 c3556s8;
        C3556s8 c3556s9;
        Intrinsics.checkNotNullParameter(event, "event");
        int keyCode = event.getKeyCode();
        boolean z = event.getRepeatCount() == 0 && event.getAction() == 0;
        if (keyCode != 24 && keyCode != 25 && keyCode != 27) {
            if (keyCode != 62 && keyCode != 79) {
                if (keyCode != 164) {
                    if (keyCode != 85) {
                        if (keyCode != 86) {
                            if (keyCode == 126) {
                                if (z && (c3556s9 = this.d) != null && !c3556s9.isPlaying()) {
                                    C3556s8 c3556s10 = this.d;
                                    if (c3556s10 != null) {
                                        c3556s10.start();
                                    }
                                    d();
                                }
                                return true;
                            }
                            if (keyCode != 127) {
                                d();
                                return super.dispatchKeyEvent(event);
                            }
                        }
                        if (z && (c3556s8 = this.d) != null && c3556s8.isPlaying()) {
                            C3556s8 c3556s11 = this.d;
                            if (c3556s11 != null) {
                                c3556s11.pause();
                            }
                            d();
                        }
                        return true;
                    }
                }
            }
            if (z) {
                C3556s8 c3556s12 = this.d;
                if (c3556s12 != null) {
                    if (c3556s12.isPlaying()) {
                        c3556s12.pause();
                    } else {
                        c3556s12.start();
                    }
                }
                d();
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.i, this, me);
        return super.dispatchTouchEvent(me);
    }

    public final Map<View, FriendlyObstructionPurpose> getFriendlyViews() {
        ProgressBar progressBar = this.h;
        FriendlyObstructionPurpose friendlyObstructionPurpose = FriendlyObstructionPurpose.VIDEO_CONTROLS;
        return MapsKt.hashMapOf(TuplesKt.to(progressBar, friendlyObstructionPurpose), TuplesKt.to(this.f, friendlyObstructionPurpose), TuplesKt.to(this.g, friendlyObstructionPurpose));
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(C3456l8.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(C3456l8.class.getName());
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
    public final boolean onTrackballEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        C3556s8 c3556s8 = this.d;
        if (c3556s8 == null || !c3556s8.a()) {
            return false;
        }
        if (this.e) {
            c();
            return false;
        }
        d();
        return false;
    }

    public final void setMediaPlayer(C3556s8 videoView) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        this.d = videoView;
        Object tag = videoView != null ? videoView.getTag() : null;
        C3426j8 c3426j8 = tag instanceof C3426j8 ? (C3426j8) tag : null;
        if (c3426j8 == null || !c3426j8.A || c3426j8.c()) {
            return;
        }
        this.j = true;
        this.i.removeView(this.g);
        this.i.removeView(this.f);
        b();
    }

    public final void setVideoAd(C3398h8 c3398h8) {
        this.b = c3398h8;
    }

    public static final void a(C3456l8 this$0, View view) {
        C3398h8 c3398h8;
        C3398h8 c3398h9;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C3556s8 c3556s8 = this$0.d;
        if (c3556s8 != null) {
            Object tag = c3556s8.getTag();
            C3426j8 c3426j8 = tag instanceof C3426j8 ? (C3426j8) tag : null;
            if (this$0.j) {
                C3556s8 c3556s9 = this$0.d;
                if (c3556s9 != null) {
                    c3556s9.k();
                }
                this$0.j = false;
                this$0.i.removeView(this$0.g);
                this$0.i.removeView(this$0.f);
                this$0.a();
                if (c3426j8 == null || (c3398h9 = this$0.b) == null) {
                    return;
                }
                try {
                    c3398h9.i(c3426j8);
                    c3426j8.z = true;
                    return;
                } catch (Exception e) {
                    String TAG = this$0.f3370a;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    C3339d5 c3339d5 = C3339d5.f3292a;
                    C3339d5.c.a(I4.a(e, "event"));
                    return;
                }
            }
            C3556s8 c3556s10 = this$0.d;
            if (c3556s10 != null) {
                c3556s10.c();
            }
            this$0.j = true;
            this$0.i.removeView(this$0.f);
            this$0.i.removeView(this$0.g);
            this$0.b();
            if (c3426j8 == null || (c3398h8 = this$0.b) == null) {
                return;
            }
            try {
                c3398h8.e(c3426j8);
                c3426j8.z = false;
            } catch (Exception e2) {
                String TAG2 = this$0.f3370a;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                C3339d5 c3339d6 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e2, "event"));
            }
        }
    }
}
