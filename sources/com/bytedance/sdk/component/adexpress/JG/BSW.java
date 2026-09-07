package com.bytedance.sdk.component.adexpress.JG;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes7.dex */
public class BSW extends FrameLayout {
    private final WV KZx;
    private final ImageView Og;
    private final RotateAnimation ZZv;
    private final TextView pA;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public BSW(Context context) {
        super(context);
        addView(com.bytedance.sdk.component.adexpress.KZx.pA.ZZv(context));
        this.pA = (TextView) findViewById(2097610742);
        this.Og = (ImageView) findViewById(2097610745);
        this.KZx = (WV) findViewById(2097610744);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 30.0f, 1, 0.65f, 1, 0.9f);
        this.ZZv = rotateAnimation;
        rotateAnimation.setDuration(300L);
        rotateAnimation.setRepeatMode(2);
        rotateAnimation.setRepeatCount(1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Slide or click to jump to the details page or third-party application";
        }
        TextView textView = this.pA;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void pA() {
        postDelayed(getHaloAnimation(), 300L);
    }

    public void Og() {
        this.ZZv.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable getHaloAnimation() {
        return new Runnable() { // from class: com.bytedance.sdk.component.adexpress.JG.BSW.1
            @Override // java.lang.Runnable
            public void run() {
                BSW.this.Og.startAnimation(BSW.this.ZZv);
                BSW.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.JG.BSW.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BSW.this.KZx.pA(4);
                    }
                }, 100L);
                BSW.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.JG.BSW.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        BSW.this.KZx.pA(4);
                    }
                }, 300L);
                BSW bsw = BSW.this;
                bsw.postDelayed(bsw.getHaloAnimation(), 1200L);
            }
        };
    }
}
