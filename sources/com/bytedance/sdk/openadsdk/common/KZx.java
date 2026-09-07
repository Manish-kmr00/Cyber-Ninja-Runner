package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes8.dex */
public class KZx extends WV {
    @Override // com.bytedance.sdk.openadsdk.common.WV, com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.common.WV, com.bytedance.sdk.openadsdk.core.ML.KZx, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public KZx(Context context) {
        super(context);
        this.Og = false;
    }

    @Override // com.bytedance.sdk.openadsdk.common.WV
    public void pA() {
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.KZx.1
            @Override // java.lang.Runnable
            public void run() {
                if (KZx.this.pA != null) {
                    KZx.this.setVisibility(0);
                }
            }
        });
    }

    public void pA(yFO yfo, String str, int i, String str2, long j, boolean z, int i2, long j2) {
        if (getVisibility() != 8) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str, i, str2, SystemClock.elapsedRealtime() - j, z, i2, j2);
            super.Og();
        }
    }
}
