package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1590Fp implements View.OnClickListener {
    public final /* synthetic */ ViewOnClickListenerC2488gW A00;
    public final /* synthetic */ String A01;

    public ViewOnClickListenerC1590Fp(ViewOnClickListenerC2488gW viewOnClickListenerC2488gW, String str) {
        this.A00 = viewOnClickListenerC2488gW;
        this.A01 = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            this.A00.A0A(this.A01);
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
