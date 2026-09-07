package com.applovin.creative;

import android.view.MotionEvent;
import com.applovin.impl.b1;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes5.dex */
public final class MaxCreativeDebuggerActivity extends b1 {
    @Override // com.applovin.impl.b1, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.f8160a, me);
        return super.dispatchTouchEvent(me);
    }
}
