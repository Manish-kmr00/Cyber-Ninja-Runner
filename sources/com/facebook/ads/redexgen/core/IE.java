package com.facebook.ads.redexgen.core;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class IE implements View.OnTouchListener {
    public final /* synthetic */ C2232cL A00;

    public IE(C2232cL c2232cL) {
        this.A00 = c2232cL;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.A00.A0C.A02(new C2198bn(view, motionEvent));
        return false;
    }
}
