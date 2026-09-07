package com.applovin.mediation;

import android.view.MotionEvent;
import com.applovin.impl.t6;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes11.dex */
public class MaxDebuggerTcfConsentStatusesListActivity extends t6 {
    @Override // com.applovin.impl.t6, com.applovin.impl.k3, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.f8160a, me);
        return super.dispatchTouchEvent(me);
    }
}
