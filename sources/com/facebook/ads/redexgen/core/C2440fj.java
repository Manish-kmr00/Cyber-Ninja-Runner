package com.facebook.ads.redexgen.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2440fj extends BroadcastReceiver {
    public final /* synthetic */ C2441fk A00;

    public C2440fj(C2441fk c2441fk) {
        this.A00 = c2441fk;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int iA00 = C2441fk.A00(context);
        if (AbstractC2471gE.A02 >= 31 && iA00 == 5) {
            C2438fh.A02(context, this.A00);
        } else {
            this.A00.A07(iA00);
        }
    }
}
