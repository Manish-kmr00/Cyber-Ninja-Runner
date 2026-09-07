package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1576Fb implements View.OnClickListener {
    public final /* synthetic */ C1578Fd A00;

    public ViewOnClickListenerC1576Fb(C1578Fd c1578Fd) {
        this.A00 = c1578Fd;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            this.A00.A05();
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
