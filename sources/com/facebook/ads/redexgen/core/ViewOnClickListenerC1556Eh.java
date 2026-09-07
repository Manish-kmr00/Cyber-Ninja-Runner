package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Eh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1556Eh implements View.OnClickListener {
    public final /* synthetic */ C1561Em A00;

    public ViewOnClickListenerC1556Eh(C1561Em c1561Em) {
        this.A00 = c1561Em;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            this.A00.A0A.A0F().A9m();
            if (this.A00.A05 == null) {
                return;
            }
            this.A00.A05.ACe();
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
