package com.pubmatic.sdk.webrendering.ui;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.pubmatic.sdk.common.R;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.utility.POBCountdownTimer;
import com.pubmatic.sdk.common.viewability.POBObstructionUpdateListener;
import com.pubmatic.sdk.webrendering.POBUIUtil;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class POBMraidViewContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageView f7937a;
    private int b;
    private POBOnSkipOptionUpdateListener c;
    private POBCountdownView d;
    private boolean e;
    private POBObstructionUpdateListener f;
    private POBMraidViewContainerListener g;
    private boolean h;
    private POBCountdownTimer i;
    private boolean j;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pob_close_btn) {
                if (POBMraidViewContainer.this.g != null) {
                    POBMraidViewContainer.this.g.onClose();
                }
            } else if (view.getId() == R.id.pob_forward_btn) {
                POBUIUtil.updateSkipButtonToCloseButton((ImageButton) view);
                if (POBMraidViewContainer.this.g != null) {
                    POBMraidViewContainer.this.g.onForward();
                }
                view.bringToFront();
            }
        }
    }

    class b extends POBCountdownTimer {
        b(long j, long j2, Looper looper) {
            super(j, j2, looper);
        }

        @Override // com.pubmatic.sdk.common.utility.POBCountdownTimer
        public void onFinish() {
            POBMraidViewContainer.this.handleShowSkip();
            POBLog.debug("POBMraidViewContainer", "Skip button timer exhausted, Skip button is shown", new Object[0]);
        }

        @Override // com.pubmatic.sdk.common.utility.POBCountdownTimer
        public void onTick(long j) {
        }
    }

    class c implements POBCountdownView.OnTimerExhaustedListener {
        c() {
        }

        @Override // com.pubmatic.sdk.webrendering.ui.POBCountdownView.OnTimerExhaustedListener
        public void onTimerExhausted() {
            POBMraidViewContainer.this.a();
            POBLog.debug("POBMraidViewContainer", "Countdown view timer exhausted, Skip button is shown", new Object[0]);
        }
    }

    public POBMraidViewContainer(Context context, boolean z) {
        super(context);
        this.h = false;
        if (z) {
            this.f7937a = POBUIUtil.createSkipButton(context, R.id.pob_forward_btn, com.pubmatic.sdk.webrendering.R.drawable.pob_ic_forward_24);
        } else {
            this.f7937a = POBUIUtil.createSkipButton(context, R.id.pob_close_btn, com.pubmatic.sdk.webrendering.R.drawable.pob_ic_close_black_24dp);
        }
    }

    private void c() {
        POBCountdownTimer pOBCountdownTimer = this.i;
        if (pOBCountdownTimer != null) {
            this.j = true;
            pOBCountdownTimer.start();
            POBLog.debug("POBMraidViewContainer", "Skip button timer started", new Object[0]);
        }
    }

    public void configureSkippability(int i) {
        this.b = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.F, this, me);
        return super.dispatchTouchEvent(me);
    }

    public ImageView getSkipBtn() {
        return this.f7937a;
    }

    public void handleShowSkip() {
        this.f7937a.setVisibility(0);
        a(true);
    }

    public void handleSkipTimer(long j) {
        if (this.h) {
            b();
            this.i = new b(TimeUnit.MILLISECONDS.toSeconds(j), 1L, Looper.getMainLooper());
            if (hasWindowFocus()) {
                c();
                return;
            }
            return;
        }
        int seconds = this.b - ((int) TimeUnit.MILLISECONDS.toSeconds(j));
        if (!this.e || seconds <= 0) {
            a();
            return;
        }
        POBCountdownView pOBCountdownView = new POBCountdownView(getContext(), seconds);
        this.d = pOBCountdownView;
        pOBCountdownView.setTimerExhaustedListener(new c());
        addView(this.d);
        POBLog.debug("POBMraidViewContainer", "Countdown view timer started", new Object[0]);
        POBObstructionUpdateListener pOBObstructionUpdateListener = this.f;
        if (pOBObstructionUpdateListener != null) {
            pOBObstructionUpdateListener.addFriendlyObstructions(this.d, POBObstructionUpdateListener.POBFriendlyObstructionPurpose.OTHER);
        }
    }

    public void onAdViewClicked() {
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        POBLog.debug("POBMraidViewContainer", "Display interstitial skipOffset: " + this.b, new Object[0]);
        POBObstructionUpdateListener pOBObstructionUpdateListener = this.f;
        if (pOBObstructionUpdateListener != null) {
            pOBObstructionUpdateListener.addFriendlyObstructions(this.f7937a, POBObstructionUpdateListener.POBFriendlyObstructionPurpose.CLOSE_AD);
        }
        if (this.e || this.h) {
            this.f7937a.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
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
        POBCountdownTimer pOBCountdownTimer = this.i;
        if (pOBCountdownTimer == null) {
            return;
        }
        if (!z) {
            pOBCountdownTimer.pause();
        } else if (this.j) {
            pOBCountdownTimer.resume();
        } else {
            c();
        }
    }

    public void setCustomCloseEnabled(boolean z) {
        this.h = z;
    }

    public void setEnableSkipTimer(boolean z) {
        this.e = z;
    }

    public void setMraidViewContainerListener(POBMraidViewContainerListener pOBMraidViewContainerListener) {
        this.g = pOBMraidViewContainerListener;
    }

    public void setObstructionUpdateListener(POBObstructionUpdateListener pOBObstructionUpdateListener) {
        this.f = pOBObstructionUpdateListener;
    }

    public void setSkipOptionUpdateListener(POBOnSkipOptionUpdateListener pOBOnSkipOptionUpdateListener) {
        this.c = pOBOnSkipOptionUpdateListener;
    }

    public void updateSkipButtonToCloseButton() {
        b();
        POBUIUtil.updateSkipButtonToCloseButton((ImageButton) this.f7937a);
        a();
        this.f7937a.bringToFront();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        POBCountdownView pOBCountdownView = this.d;
        if (pOBCountdownView != null && pOBCountdownView.getParent() != null) {
            removeView(this.d);
        }
        handleShowSkip();
    }

    private void b() {
        POBCountdownTimer pOBCountdownTimer = this.i;
        if (pOBCountdownTimer != null) {
            pOBCountdownTimer.cancel();
            this.i = null;
        }
    }

    private void a(boolean z) {
        POBOnSkipOptionUpdateListener pOBOnSkipOptionUpdateListener = this.c;
        if (pOBOnSkipOptionUpdateListener != null) {
            pOBOnSkipOptionUpdateListener.onSkipOptionUpdate(z);
        }
    }

    public POBMraidViewContainer(Context context, ViewGroup viewGroup, boolean z, boolean z2) {
        this(context, viewGroup, z);
        if (z2) {
            POBUIUtil.updateSkipBtnColor(context, this.f7937a, com.pubmatic.sdk.webrendering.R.color.pob_controls_stroke_color);
        }
    }

    public POBMraidViewContainer(Context context, ViewGroup viewGroup, boolean z) {
        this(context, z);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        layoutParams.setMargins(0, 0, 0, 0);
        addView(viewGroup, layoutParams);
        this.f7937a.setOnClickListener(new a());
        addView(this.f7937a);
    }
}
