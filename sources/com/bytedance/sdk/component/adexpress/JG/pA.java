package com.bytedance.sdk.component.adexpress.JG;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class pA extends TextSwitcher implements ViewSwitcher.ViewFactory, com.bytedance.sdk.component.utils.TV.pA {
    private int BSW;
    private float Bzk;
    private TextView JG;
    private int KZx;
    private Context ML;
    private List<String> Og;
    private int SD;
    private int SGo;
    private Handler Sn;
    private int WV;
    private int Wx;
    private final int ZZv;
    private int omh;
    Animation.AnimationListener pA;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public pA(Context context, int i, float f, int i2, int i3) {
        super(context);
        this.Og = new ArrayList();
        this.KZx = 0;
        this.ZZv = 1;
        this.Sn = new com.bytedance.sdk.component.utils.TV(Looper.getMainLooper(), this);
        this.pA = new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.JG.pA.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (pA.this.JG != null) {
                    pA.this.JG.setText("");
                }
            }
        };
        this.ML = context;
        this.omh = i;
        this.Bzk = f;
        this.SGo = i2;
        this.Wx = i3;
        KZx();
    }

    private void KZx() {
        setFactory(this);
    }

    public void setAnimationType(int i) {
        this.WV = i;
    }

    public void setAnimationDuration(int i) {
        this.SD = i;
    }

    public void pA() {
        int i = this.WV;
        if (i == 1) {
            setInAnimation(getContext(), com.bytedance.sdk.component.utils.yFO.Bzk(this.ML, "tt_text_animation_y_in"));
            setOutAnimation(getContext(), com.bytedance.sdk.component.utils.yFO.Bzk(this.ML, "tt_text_animation_y_out"));
        } else if (i == 0) {
            setInAnimation(getContext(), com.bytedance.sdk.component.utils.yFO.Bzk(this.ML, "tt_text_animation_x_in"));
            setOutAnimation(getContext(), com.bytedance.sdk.component.utils.yFO.Bzk(this.ML, "tt_text_animation_x_in"));
            getInAnimation().setInterpolator(new LinearInterpolator());
            getOutAnimation().setInterpolator(new LinearInterpolator());
            getInAnimation().setAnimationListener(this.pA);
            getOutAnimation().setAnimationListener(this.pA);
        }
        this.Sn.sendEmptyMessage(1);
    }

    public void setAnimationText(List<String> list) {
        this.Og = list;
    }

    public void Og() {
        List<String> list = this.Og;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = this.KZx;
        this.KZx = i + 1;
        this.BSW = i;
        setText(this.Og.get(i));
        if (this.KZx > this.Og.size() - 1) {
            this.KZx = 0;
        }
    }

    public void setTextColor(int i) {
        this.omh = i;
    }

    public void setTextSize(float f) {
        this.Bzk = f;
    }

    public void setMaxLines(int i) {
        this.SGo = i;
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        this.JG = textView;
        textView.setTextColor(this.omh);
        this.JG.setTextSize(this.Bzk);
        this.JG.setMaxLines(this.SGo);
        this.JG.setTextAlignment(this.Wx);
        return this.JG;
    }

    @Override // com.bytedance.sdk.component.utils.TV.pA
    public void pA(Message message) {
        if (message.what != 1) {
            return;
        }
        Og();
        this.Sn.sendEmptyMessageDelayed(1, this.SD);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(com.bytedance.sdk.component.adexpress.dynamic.ML.BSW.Og(this.Og.get(this.BSW), this.Bzk, false)[0], 1073741824), i);
        } catch (Exception unused) {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.Sn.removeMessages(1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Sn.sendEmptyMessageDelayed(1, this.SD);
    }
}
