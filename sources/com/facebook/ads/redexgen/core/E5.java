package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class E5 implements View.OnClickListener {
    public final /* synthetic */ C2537hJ A00;

    public E5(C2537hJ c2537hJ) {
        this.A00 = c2537hJ;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            this.A00.A07.ADA();
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
