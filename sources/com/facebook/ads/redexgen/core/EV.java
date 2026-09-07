package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class EV implements View.OnClickListener {
    public final /* synthetic */ C12963k A00;
    public final /* synthetic */ EL A01;
    public final /* synthetic */ C2532hE A02;

    public EV(C2532hE c2532hE, EL el, C12963k c12963k) {
        this.A02 = c2532hE;
        this.A01 = el;
        this.A00 = c12963k;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            this.A01.A01();
            this.A02.A0B.AEJ(this.A00);
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
