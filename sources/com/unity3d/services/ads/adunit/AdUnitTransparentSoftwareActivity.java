package com.unity3d.services.ads.adunit;

import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes12.dex */
public class AdUnitTransparentSoftwareActivity extends AdUnitTransparentActivity {
    @Override // com.unity3d.services.ads.adunit.AdUnitTransparentActivity, com.unity3d.services.ads.adunit.AdUnitActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch("com.unity3d.ads", me);
        return super.dispatchTouchEvent(me);
    }
}
