package com.facebook.ads.redexgen.core;

import android.content.DialogInterface;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class DF implements DialogInterface.OnClickListener {
    public final /* synthetic */ C2577hz A00;

    public DF(C2577hz c2577hz) {
        this.A00 = c2577hz;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
