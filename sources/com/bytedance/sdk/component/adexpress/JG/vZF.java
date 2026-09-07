package com.bytedance.sdk.component.adexpress.JG;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class vZF extends yFO {
    private TextView pA;

    @Override // com.bytedance.sdk.component.adexpress.JG.yFO, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.component.adexpress.JG.yFO, android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public vZF(Context context, View view, int i, int i2, int i3, JSONObject jSONObject) {
        super(context, view, i, i2, i3, jSONObject);
    }

    @Override // com.bytedance.sdk.component.adexpress.JG.yFO
    protected void pA(Context context, View view) {
        addView(view);
        this.pA = (TextView) findViewById(2097610747);
    }

    @Override // com.bytedance.sdk.component.adexpress.JG.yFO
    public void setShakeText(String str) {
        if (this.pA == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            try {
                this.pA.setText(com.bytedance.sdk.component.utils.yFO.Og(this.pA.getContext(), "tt_splash_default_click_shake"));
                return;
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.WV.pA("shakeClickView", e.getMessage());
                return;
            }
        }
        this.pA.setText(str);
    }
}
