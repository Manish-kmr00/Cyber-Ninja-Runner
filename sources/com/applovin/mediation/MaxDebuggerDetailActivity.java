package com.applovin.mediation;

import android.view.MotionEvent;
import com.applovin.impl.c3;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes8.dex */
public final class MaxDebuggerDetailActivity extends c3 {
    @Override // com.applovin.impl.c3, com.applovin.impl.k3, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.f8160a, me);
        return super.dispatchTouchEvent(me);
    }
}
