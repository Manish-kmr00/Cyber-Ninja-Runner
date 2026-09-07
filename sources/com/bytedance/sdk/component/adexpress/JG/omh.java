package com.bytedance.sdk.component.adexpress.JG;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class omh extends BF {
    private AnimatorSet JG;
    private ImageView KZx;
    private int ML;
    private ImageView Og;
    private ImageView ZZv;
    private TextView pA;

    @Override // com.bytedance.sdk.component.adexpress.JG.BF, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.component.adexpress.JG.BF, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.JG.BF
    protected void pA(Context context) {
    }

    public omh(Context context) {
        super(context);
        this.JG = new AnimatorSet();
        Og(context);
    }

    private void Og(Context context) {
        addView(com.bytedance.sdk.component.adexpress.KZx.pA.Og(context));
        this.Og = (ImageView) findViewById(2097610751);
        this.KZx = (ImageView) findViewById(2097610750);
        this.ZZv = (ImageView) findViewById(2097610749);
        this.pA = (TextView) findViewById(2097610748);
    }

    public void setButtonText(String str) {
        if (this.pA == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.pA.setText(str);
    }

    private void ZZv() {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "alphaColor", 0, 60);
        objectAnimatorOfInt.setInterpolator(new LinearInterpolator());
        objectAnimatorOfInt.setDuration(2000L);
        objectAnimatorOfInt.setRepeatCount(-1);
        objectAnimatorOfInt.start();
    }

    public float getAlphaColor() {
        return this.ML;
    }

    public void setAlphaColor(int i) {
        if (i < 0 || i > 60) {
            return;
        }
        int i2 = i + 195;
        this.ZZv.setColorFilter(Color.rgb(i2, i2, i2), PorterDuff.Mode.SRC_IN);
        int i3 = ((i + 20) % 60) + 195;
        this.KZx.setColorFilter(Color.rgb(i3, i3, i3), PorterDuff.Mode.SRC_IN);
        int i4 = ((i + 40) % 60) + 195;
        this.Og.setColorFilter(Color.rgb(i4, i4, i4), PorterDuff.Mode.SRC_IN);
    }

    @Override // com.bytedance.sdk.component.adexpress.JG.BF
    public void pA() {
        ZZv();
    }

    @Override // com.bytedance.sdk.component.adexpress.JG.BF
    public void Og() {
        this.JG.cancel();
    }
}
