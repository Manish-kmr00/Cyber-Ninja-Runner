package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Button;
import com.bytedance.sdk.component.utils.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes4.dex */
public class SD extends Button {
    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public SD(Context context) {
        super(context);
        pA();
    }

    private void pA() {
        setId(com.bytedance.sdk.openadsdk.utils.Sn.sk);
        Context context = getContext();
        setLayoutParams(new ViewGroup.LayoutParams(-1, Vgu.KZx(context, 48.0f)));
        setBackground(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_browser_download_selector"));
        setText(yFO.pA(context, "tt_video_download_apk"));
        setTextColor(-1);
        setTextSize(2, 16.0f);
    }
}
