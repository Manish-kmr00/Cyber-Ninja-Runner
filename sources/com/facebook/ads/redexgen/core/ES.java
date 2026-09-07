package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class ES implements View.OnClickListener {
    public final /* synthetic */ EL A00;
    public final /* synthetic */ C2532hE A01;

    public ES(C2532hE c2532hE, EL el) {
        this.A01 = c2532hE;
        this.A00 = el;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            this.A00.A01();
            this.A01.A0B.AE6(EnumC12943i.A06);
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
