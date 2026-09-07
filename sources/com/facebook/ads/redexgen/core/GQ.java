package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class GQ implements View.OnClickListener {
    public final /* synthetic */ C2448fr A00;

    public GQ(C2448fr c2448fr) {
        this.A00 = c2448fr;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            if (this.A00.A02 == null) {
                return;
            }
            this.A00.A02.A9b();
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
