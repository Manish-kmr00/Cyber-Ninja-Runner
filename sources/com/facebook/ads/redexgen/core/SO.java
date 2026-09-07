package com.facebook.ads.redexgen.core;

import android.media.AudioTrack;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class SO extends AudioTrack.StreamEventCallback {
    public final /* synthetic */ SP A00;
    public final /* synthetic */ XM A01;

    public SO(SP sp, XM xm) {
        this.A00 = sp;
        this.A01 = xm;
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onDataRequest(AudioTrack audioTrack, int i) {
        if (!audioTrack.equals(this.A00.A02.A0D) || this.A00.A02.A0I == null || !this.A00.A02.A0X) {
            return;
        }
        this.A00.A02.A0I.AEH();
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onTearDown(AudioTrack audioTrack) {
        if (!audioTrack.equals(this.A00.A02.A0D) || this.A00.A02.A0I == null || !this.A00.A02.A0X) {
            return;
        }
        this.A00.A02.A0I.AEH();
    }
}
