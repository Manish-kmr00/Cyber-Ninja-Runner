package com.pubmatic.sdk.webrendering.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.pubmatic.sdk.common.utility.POBCountdownTimer;
import com.pubmatic.sdk.webrendering.POBUIUtil;
import com.pubmatic.sdk.webrendering.R;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes10.dex */
public class POBCountdownView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private POBCountdownTimer f7925a;
    private TextView b;
    private boolean c;
    private int d;
    private final Resources e;
    private OnTimerExhaustedListener f;

    public interface OnTimerExhaustedListener {
        void onTimerExhausted();
    }

    class a extends POBCountdownTimer {
        a(long j, long j2, Looper looper) {
            super(j, j2, looper);
        }

        @Override // com.pubmatic.sdk.common.utility.POBCountdownTimer
        public void onFinish() {
            if (POBCountdownView.this.f != null) {
                POBCountdownView.this.f.onTimerExhausted();
            }
        }

        @Override // com.pubmatic.sdk.common.utility.POBCountdownTimer
        public void onTick(long j) {
            POBCountdownView.this.setTimeToTimerTextView(j);
        }
    }

    private POBCountdownView(Context context) {
        super(context);
        this.c = false;
        this.e = context.getResources();
        TextView textViewB = b();
        this.b = textViewB;
        addView(textViewB);
    }

    private TextView b() {
        this.b = POBUIUtil.createSkipDurationTextView(getContext(), R.id.pob_skip_duration_timer);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.e.getDimensionPixelOffset(R.dimen.pob_control_width), this.e.getDimensionPixelOffset(R.dimen.pob_control_height));
        layoutParams.gravity = 17;
        this.b.setLayoutParams(layoutParams);
        return this.b;
    }

    private void c() {
        POBCountdownTimer pOBCountdownTimer = this.f7925a;
        if (pOBCountdownTimer != null) {
            pOBCountdownTimer.pause();
        }
    }

    private void d() {
        POBCountdownTimer pOBCountdownTimer = this.f7925a;
        if (pOBCountdownTimer != null) {
            pOBCountdownTimer.resume();
        }
    }

    private void e() {
        if (this.f7925a == null) {
            a aVar = new a(this.d, 1L, Looper.getMainLooper());
            this.f7925a = aVar;
            aVar.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeToTimerTextView(long j) {
        this.b.setText(String.valueOf(j));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.F, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.c && hasWindowFocus()) {
            e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.c) {
            a();
        }
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
        if (this.c) {
            if (!z) {
                c();
            } else {
                e();
                d();
            }
        }
    }

    public void setTimerExhaustedListener(OnTimerExhaustedListener onTimerExhaustedListener) {
        this.f = onTimerExhaustedListener;
    }

    private void a() {
        POBCountdownTimer pOBCountdownTimer = this.f7925a;
        if (pOBCountdownTimer != null) {
            pOBCountdownTimer.cancel();
        }
    }

    public POBCountdownView(Context context, int i) {
        this(context);
        if (i > 0) {
            this.d = i;
            this.c = true;
        }
        setLayoutParams(POBUIUtil.getLayoutParamsForTopRightPosition(context));
        setTimeToTimerTextView(i);
    }
}
