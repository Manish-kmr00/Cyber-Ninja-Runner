package com.facebook.ads.redexgen.core;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnTouchListenerC1640Hn implements View.OnTouchListener {
    public final /* synthetic */ C1641Ho A00;

    public ViewOnTouchListenerC1640Hn(C1641Ho c1641Ho) {
        this.A00 = c1641Ho;
    }

    public /* synthetic */ ViewOnTouchListenerC1640Hn(C1641Ho c1641Ho, C1712Kh c1712Kh) {
        this(c1641Ho);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.A00.A01 = System.currentTimeMillis();
            C1641Ho.A00(this.A00);
            this.A00.A07.ABE(this.A00.A04.A1g(), new FB().A03(this.A00.getViewabilityChecker()).A02(this.A00.getTouchDataRecorder()).A05());
            return false;
        }
        return false;
    }
}
