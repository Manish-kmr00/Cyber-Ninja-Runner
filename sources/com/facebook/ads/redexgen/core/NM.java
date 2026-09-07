package com.facebook.ads.redexgen.core;

import android.media.AudioAttributes;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class NM {
    public final AudioAttributes A00;

    public NM(C2080Zm c2080Zm) {
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(c2080Zm.A02).setFlags(c2080Zm.A03).setUsage(c2080Zm.A05);
        if (AbstractC2471gE.A02 >= 29) {
            NK.A00(usage, c2080Zm.A01);
        }
        if (AbstractC2471gE.A02 >= 32) {
            NL.A00(usage, c2080Zm.A04);
        }
        this.A00 = usage.build();
    }
}
