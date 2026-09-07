package com.bytedance.sdk.component.adexpress.JG;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JG extends BF {
    private vZF pA;

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

    public JG(Context context, int i, int i2, int i3, JSONObject jSONObject) {
        super(context);
        pA(context, i, i2, i3, jSONObject);
    }

    private void pA(Context context, int i, int i2, int i3, JSONObject jSONObject) {
        vZF vzf = new vZF(context, com.bytedance.sdk.component.adexpress.KZx.pA.KZx(context), i, i2, i3, jSONObject);
        this.pA = vzf;
        addView(vzf);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.pA.setLayoutParams(layoutParams);
    }

    public vZF getShakeView() {
        return this.pA;
    }

    public void setShakeText(String str) {
        if (this.pA == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.pA.setShakeText("");
        } else {
            this.pA.setShakeText(str);
        }
    }
}
