package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import com.bytedance.sdk.openadsdk.core.TV;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Wx;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes9.dex */
public class TTAdActivity extends TTBaseActivity {
    private Og pA;

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.u, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.bytedance.sdk.openadsdk.pA.ML.pA pAVarKZx = TV.pA().KZx();
        com.bytedance.sdk.openadsdk.pA.KZx.Og ogZZv = TV.pA().ZZv();
        yFO yfoPA = com.bytedance.sdk.openadsdk.component.reward.pA.Og.pA(getIntent(), bundle, (com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og) null);
        if (yfoPA != null) {
            Og og = new Og(this, yfoPA);
            this.pA = og;
            og.pA(this, bundle, pAVarKZx, ogZZv);
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Og og = this.pA;
        if (og != null) {
            og.pA(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Og og = this.pA;
        if (og != null) {
            og.pA((Activity) this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        Og og = this.pA;
        if (og != null) {
            og.ZZv(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        Og og = this.pA;
        if (og != null) {
            og.KZx(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        Og og = this.pA;
        if (og != null) {
            og.Og(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        Og og = this.pA;
        if (og != null) {
            og.pA(z);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Og og = this.pA;
        if (og != null) {
            og.ML(this);
        }
        TV.pA().pA((com.bytedance.sdk.openadsdk.pA.ML.pA) null);
        TV.pA().pA((com.bytedance.sdk.openadsdk.pA.KZx.Og) null);
        Wx.pA();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Og og = this.pA;
        if (og != null) {
            og.pA(this, bundle);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Og og = this.pA;
        if (og == null) {
            super.onBackPressed();
        } else {
            og.ZZv();
        }
    }
}
