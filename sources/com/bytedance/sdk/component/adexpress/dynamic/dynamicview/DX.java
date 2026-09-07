package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes.dex */
public class DX extends JG {
    com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh Og;
    String pA;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public DX(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar, String str) {
        super(context, dynamicRootView, omhVar);
        this.pA = str;
        this.Og = omhVar;
        com.bytedance.sdk.component.adexpress.JG.SGo lottieView = getLottieView();
        if (lottieView != null) {
            addView(lottieView, getWidgetLayoutParams());
        }
    }

    private com.bytedance.sdk.component.adexpress.JG.SGo getLottieView() {
        String strNCO;
        if (this.Wx == null || this.Wx.SGo() == null || this.BSW == null || TextUtils.isEmpty(this.pA)) {
            return null;
        }
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jgML = this.Wx.SGo().ML();
        if (jgML == null) {
            strNCO = "";
        } else {
            strNCO = jgML.nCO();
        }
        if (TextUtils.isEmpty(strNCO)) {
            return null;
        }
        String str = this.pA + "static/lotties/" + strNCO + ".json";
        com.bytedance.sdk.component.adexpress.JG.SGo sGo = new com.bytedance.sdk.component.adexpress.JG.SGo(this.BSW);
        sGo.setImageLottieTosPath(str);
        sGo.omh();
        return sGo;
    }
}
