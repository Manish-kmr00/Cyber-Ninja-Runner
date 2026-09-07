package com.applovin.mediation;

import android.view.MotionEvent;
import com.applovin.impl.f7;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes.dex */
public class MaxDebuggerUnifiedFlowActivity extends f7 {
    @Override // com.applovin.impl.f7, com.applovin.impl.k3, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.f8160a, me);
        return super.dispatchTouchEvent(me);
    }
}
