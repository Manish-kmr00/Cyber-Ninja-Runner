package com.facebook.ads.redexgen.core;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RR implements ZX {
    public MediaCodecInfo[] A00;
    public final int A01;

    public RR(boolean z, boolean z2) {
        int i;
        if (z || z2) {
            i = 1;
        } else {
            i = 0;
        }
        this.A01 = i;
    }

    @EnsuresNonNull({"mediaCodecInfos"})
    private void A00() {
        if (this.A00 == null) {
            this.A00 = new MediaCodecList(this.A01).getCodecInfos();
        }
    }

    @Override // com.facebook.ads.redexgen.core.ZX
    public final int A7F() {
        A00();
        return this.A00.length;
    }

    @Override // com.facebook.ads.redexgen.core.ZX
    public final MediaCodecInfo A7G(int i) {
        A00();
        return this.A00[i];
    }

    @Override // com.facebook.ads.redexgen.core.ZX
    public final boolean AAG(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }

    @Override // com.facebook.ads.redexgen.core.ZX
    public final boolean AAH(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    @Override // com.facebook.ads.redexgen.core.ZX
    public final boolean AIA() {
        return true;
    }
}
