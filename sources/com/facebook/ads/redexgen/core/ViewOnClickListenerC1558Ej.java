package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ej, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1558Ej implements View.OnClickListener {
    public final /* synthetic */ C1561Em A00;

    public ViewOnClickListenerC1558Ej(C1561Em c1561Em) {
        this.A00 = c1561Em;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            if (!this.A00.A09.canGoForward()) {
                return;
            }
            this.A00.A09.goForward();
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
