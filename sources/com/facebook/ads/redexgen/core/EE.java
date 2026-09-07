package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class EE implements View.OnClickListener {
    public final /* synthetic */ EG A00;

    public EE(EG eg) {
        this.A00 = eg;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            this.A00.A04.AAe();
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
