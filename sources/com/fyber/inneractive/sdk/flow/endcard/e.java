package com.fyber.inneractive.sdk.flow.endcard;

import android.view.MotionEvent;
import android.view.View;
import com.fyber.inneractive.sdk.player.controller.z;
import com.fyber.inneractive.sdk.util.h0;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class e implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1790a;
    public final com.fyber.inneractive.sdk.player.ui.n b;
    public final int[] c = new int[2];
    public final h0 d = new h0();

    public e(int i, com.fyber.inneractive.sdk.player.ui.n nVar) {
        this.f1790a = i;
        this.b = nVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Logger.d("DTExchange|SafeDK: Execution> Lcom/fyber/inneractive/sdk/flow/endcard/e;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        CreativeInfoManager.onViewTouched(com.safedk.android.utils.h.p, view, motionEvent);
        return safedk_e_onTouch_09b2f5dae9685246cf1ab3a81f789e70(view, motionEvent);
    }

    public boolean safedk_e_onTouch_09b2f5dae9685246cf1ab3a81f789e70(View p0, MotionEvent p1) {
        if (p1.getActionMasked() != 0) {
            return false;
        }
        p0.getRootView().getLocationOnScreen(this.c);
        float rawX = p1.getRawX() - this.c[0];
        float rawY = p1.getRawY() - this.c[1];
        h0 h0Var = this.d;
        h0Var.f2364a = rawX;
        h0Var.b = rawY;
        ((z) this.b).a(this.f1790a, h0Var);
        return true;
    }
}
