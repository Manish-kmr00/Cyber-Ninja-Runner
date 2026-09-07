package com.applovin.mediation;

import android.view.MotionEvent;
import com.applovin.impl.j3;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes5.dex */
public final class MaxDebuggerActivity extends j3 {
    @Override // com.applovin.impl.j3, com.applovin.impl.k3, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.f8160a, me);
        return super.dispatchTouchEvent(me);
    }
}
