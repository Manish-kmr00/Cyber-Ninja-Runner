package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class ED implements View.OnClickListener {
    public final /* synthetic */ EG A00;

    public ED(EG eg) {
        this.A00 = eg;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            if (this.A00.A05) {
                this.A00.A04.A4t();
            } else {
                this.A00.A04.A4u();
            }
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
