package com.applovin.adview;

import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes3.dex */
public class AppLovinFullscreenImmersiveActivity extends AppLovinFullscreenActivity {
    @Override // com.applovin.adview.AppLovinFullscreenActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.f8160a, me);
        return super.dispatchTouchEvent(me);
    }
}
