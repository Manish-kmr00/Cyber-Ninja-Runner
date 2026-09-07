package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1533Dk implements View.OnClickListener {
    public final /* synthetic */ C1536Dn A00;

    public ViewOnClickListenerC1533Dk(C1536Dn c1536Dn) {
        this.A00 = c1536Dn;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            this.A00.A0D();
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
