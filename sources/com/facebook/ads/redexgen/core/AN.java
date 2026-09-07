package com.facebook.ads.redexgen.core;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class AN implements View.OnTouchListener {
    public final /* synthetic */ C2626iq A00;
    public final /* synthetic */ boolean A01;

    public AN(C2626iq c2626iq, boolean z) {
        this.A00 = c2626iq;
        this.A01 = z;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.A01) {
            return false;
        }
        return true;
    }
}
