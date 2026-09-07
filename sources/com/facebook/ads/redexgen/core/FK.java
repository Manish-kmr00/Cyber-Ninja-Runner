package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class FK implements View.OnClickListener {
    public final /* synthetic */ AbstractC2493gb A00;

    public FK(AbstractC2493gb abstractC2493gb) {
        this.A00 = abstractC2493gb;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            if (this.A00.A0F.getVisibility() == 8) {
                this.A00.A0R(0);
                this.A00.A0D.postDelayed(this.A00.A0Q, 1500L);
            } else {
                this.A00.A0K();
                this.A00.A0D.removeCallbacks(this.A00.A0Q);
                this.A00.A0R(8);
            }
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
