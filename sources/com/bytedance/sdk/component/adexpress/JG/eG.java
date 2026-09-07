package com.bytedance.sdk.component.adexpress.JG;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes5.dex */
public class eG extends LinearLayout {
    private com.bytedance.adsdk.Og.JG JG;
    private TextView KZx;
    private LinearLayout ML;
    private com.bytedance.sdk.component.utils.vZF Og;
    private com.bytedance.sdk.component.adexpress.dynamic.ZZv.SGo SD;
    private pA ZZv;
    private TextView pA;

    public interface pA {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
    }

    public eG(Context context, View view, com.bytedance.sdk.component.adexpress.dynamic.ZZv.SGo sGo) {
        super(context);
        this.SD = sGo;
        pA(context, view);
    }

    private void pA(Context context, View view) {
        setClipChildren(false);
        addView(view);
        this.ML = (LinearLayout) findViewById(2097610722);
        this.pA = (TextView) findViewById(2097610719);
        this.KZx = (TextView) findViewById(2097610718);
        com.bytedance.adsdk.Og.JG jg = (com.bytedance.adsdk.Og.JG) findViewById(2097610706);
        this.JG = jg;
        jg.setAnimation("lottie_json/twist_multi_angle.json");
        this.JG.setImageAssetsFolder("images/");
        this.JG.pA(true);
    }

    public void setShakeText(String str) {
        this.KZx.setText(str);
    }

    public LinearLayout getWriggleLayout() {
        return this.ML;
    }

    public View getWriggleProgressIv() {
        return this.JG;
    }

    public TextView getTopTextView() {
        return this.pA;
    }

    public void setOnShakeViewListener(pA pAVar) {
        this.ZZv = pAVar;
    }

    public void pA() {
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.JG.eG.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    eG.this.JG.pA();
                } catch (Throwable unused) {
                }
            }
        }, 500L);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.Og == null) {
                this.Og = new com.bytedance.sdk.component.utils.vZF(getContext().getApplicationContext(), 2);
            }
            new Object() { // from class: com.bytedance.sdk.component.adexpress.JG.eG.2
            };
            com.bytedance.sdk.component.adexpress.dynamic.ZZv.SGo sGo = this.SD;
            if (sGo != null) {
                sGo.KZx();
                this.SD.ML();
                this.SD.JG();
                this.SD.omh();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            com.bytedance.adsdk.Og.JG jg = this.JG;
            if (jg != null) {
                jg.ML();
            }
        } catch (Exception unused) {
        }
    }
}
