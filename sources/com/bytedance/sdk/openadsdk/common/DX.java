package com.bytedance.sdk.openadsdk.common;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes2.dex */
public class DX extends com.bytedance.sdk.openadsdk.core.ML.KZx implements com.bytedance.sdk.openadsdk.KZx.SGo.Og {
    private boolean JG;
    private pA KZx;
    private String ML;
    private yFO Og;
    private final com.bytedance.sdk.openadsdk.KZx.SGo SD;
    private Context ZZv;
    private View pA;

    public interface pA {
        void Og(View view);

        void pA(View view);

        void pA(FilterWord filterWord);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.KZx, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public DX(Context context, yFO yfo) {
        this(context.getApplicationContext());
        this.Og = yfo;
        this.ZZv = context;
        ZZv();
        ML();
    }

    private void ZZv() {
        this.SD.pA(this.Og.tM());
        this.SD.pA(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DX(Context context) {
        this(context, (AttributeSet) null);
    }

    public DX(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DX(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.JG = false;
        this.SD = new com.bytedance.sdk.openadsdk.KZx.SGo();
        pA(context, attributeSet);
    }

    private void pA(Context context, AttributeSet attributeSet) {
        setClickable(true);
        setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.DX.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/common/DX$1;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_DX$1_onClick_8144c6d6ef925bf9bc31f18c3eac2342(view);
            }

            public void safedk_DX$1_onClick_8144c6d6ef925bf9bc31f18c3eac2342(View p0) {
                if (DX.this.SD != null) {
                    DX.this.SD.ML();
                } else {
                    DX.this.Og();
                }
            }
        });
        setBackgroundColor(Color.parseColor("#80000000"));
        this.pA = new com.bytedance.sdk.openadsdk.KZx.Bzk(context, this.SD);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = Vgu.KZx(getContext(), 20.0f);
        layoutParams.rightMargin = Vgu.KZx(getContext(), 20.0f);
        this.pA.setLayoutParams(layoutParams);
        this.pA.setClickable(true);
        ML();
    }

    private void ML() {
        com.bytedance.sdk.openadsdk.KZx.SGo sGo;
        yFO yfo = this.Og;
        if (yfo == null || (sGo = this.SD) == null) {
            return;
        }
        sGo.pA(yfo.QI());
    }

    public void setDislikeSource(String str) {
        this.ML = str;
        this.SD.Og(str);
    }

    public void pA() {
        if (this.pA.getParent() == null) {
            addView(this.pA);
        }
        setVisibility(0);
        this.JG = true;
        pA pAVar = this.KZx;
        if (pAVar != null) {
            pAVar.pA(this);
        }
    }

    public void Og() {
        setVisibility(8);
        this.JG = false;
        pA pAVar = this.KZx;
        if (pAVar != null) {
            pAVar.Og(this);
        }
    }

    public void setCallback(pA pAVar) {
        this.KZx = pAVar;
    }

    @Override // com.bytedance.sdk.openadsdk.KZx.SGo.Og
    public void pA(int i) {
        if (com.bytedance.sdk.openadsdk.KZx.SGo.Og == i) {
            FilterWord filterWordOg = this.SD.Og();
            if (filterWordOg == null || com.bytedance.sdk.openadsdk.KZx.SGo.pA.equals(filterWordOg)) {
                return;
            }
            pA pAVar = this.KZx;
            if (pAVar != null) {
                try {
                    pAVar.pA(filterWordOg);
                } catch (Throwable unused) {
                }
            }
            Og();
            return;
        }
        if (com.bytedance.sdk.openadsdk.KZx.SGo.KZx == i) {
            Og();
        } else if (com.bytedance.sdk.openadsdk.KZx.SGo.ML == i) {
            KZx();
        }
    }

    public void KZx() {
        Context context = this.ZZv;
        if (context instanceof Activity) {
            boolean zIsFinishing = ((Activity) context).isFinishing();
            com.bytedance.sdk.openadsdk.KZx.WV wv = new com.bytedance.sdk.openadsdk.KZx.WV(this.ZZv, this.SD);
            wv.pA(JG());
            wv.pA(this.Og.tM(), this.Og.jO().toString());
            wv.pA(this.ML);
            if (zIsFinishing || wv.isShowing()) {
                return;
            }
            wv.show();
        }
    }

    private com.bytedance.sdk.openadsdk.KZx.WV.pA JG() {
        return new com.bytedance.sdk.openadsdk.KZx.WV.pA() { // from class: com.bytedance.sdk.openadsdk.common.DX.2
            @Override // com.bytedance.sdk.openadsdk.KZx.WV.pA
            public void pA() {
                DX.this.setVisibility(8);
            }

            @Override // com.bytedance.sdk.openadsdk.KZx.WV.pA
            public void Og() {
                DX.this.setVisibility(0);
            }

            @Override // com.bytedance.sdk.openadsdk.KZx.WV.pA
            public void KZx() {
                DX.this.setVisibility(0);
            }

            @Override // com.bytedance.sdk.openadsdk.KZx.WV.pA
            public void pA(int i, FilterWord filterWord, String str) {
                DX.this.SD.KZx(str);
                DX.this.setVisibility(0);
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.sdk.openadsdk.KZx.SGo sGo = this.SD;
        if (sGo != null) {
            sGo.pA();
        }
    }
}
