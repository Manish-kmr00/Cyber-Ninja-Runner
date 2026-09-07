package com.json.sdk.controller;

import android.os.Bundle;
import android.view.MotionEvent;
import com.json.b9;
import com.json.sdk.utils.Logger;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes12.dex */
public class InterstitialActivity extends ControllerActivity {
    private static final String r = "InterstitialActivity";

    @Override // com.json.sdk.controller.ControllerActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.f, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.json.sdk.controller.ControllerActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.i(r, "onCreate");
    }

    @Override // com.json.sdk.controller.ControllerActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        Logger.i(r, b9.h.t0);
    }

    @Override // com.json.sdk.controller.ControllerActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        Logger.i(r, b9.h.u0);
    }
}
