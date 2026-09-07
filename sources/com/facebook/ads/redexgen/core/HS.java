package com.facebook.ads.redexgen.core;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class HS implements View.OnTouchListener {
    public final /* synthetic */ C1714Kj A00;

    public HS(C1714Kj c1714Kj) {
        this.A00 = c1714Kj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getX() < this.A00.A0H.getX() || motionEvent.getX() > this.A00.A0H.getX() + this.A00.A0H.getWidth() || motionEvent.getY() < this.A00.A0H.getY() || motionEvent.getY() > this.A00.A0H.getY() + this.A00.A0H.getHeight()) {
            return false;
        }
        if (this.A00.A03 == null) {
            return true;
        }
        this.A00.A03.dispatchTouchEvent(motionEvent);
        return true;
    }
}
