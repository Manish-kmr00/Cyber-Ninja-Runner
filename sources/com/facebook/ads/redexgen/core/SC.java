package com.facebook.ads.redexgen.core;

import android.media.AudioTrack;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SC {
    public static void A00(AudioTrack audioTrack, SE se) {
        audioTrack.setPreferredDevice(se == null ? null : se.A00);
    }
}
