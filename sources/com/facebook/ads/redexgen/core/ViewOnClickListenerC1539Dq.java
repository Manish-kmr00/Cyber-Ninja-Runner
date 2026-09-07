package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1539Dq implements View.OnClickListener {
    public final /* synthetic */ C2540hM A00;

    public ViewOnClickListenerC1539Dq(C2540hM c2540hM) {
        this.A00 = c2540hM;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            this.A00.A0N.A04(AE.A07, null);
            this.A00.A0Q.A4Z(this.A00.A0R.A7m());
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
