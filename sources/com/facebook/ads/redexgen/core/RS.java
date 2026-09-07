package com.facebook.ads.redexgen.core;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RS implements ZX {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 52);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{67, 85, 83, 69, 66, 85, Ascii.GS, SignedBytes.MAX_POWER_OF_TWO, 92, 81, 73, 82, 81, 83, 91, 3, Ascii.FS, 17, Ascii.DLE, Ascii.SUB, 90, Ascii.DC4, 3, Ascii.SYN};
    }

    public RS() {
    }

    @Override // com.facebook.ads.redexgen.core.ZX
    public final int A7F() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.facebook.ads.redexgen.core.ZX
    public final MediaCodecInfo A7G(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    @Override // com.facebook.ads.redexgen.core.ZX
    public final boolean AAG(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.ZX
    public final boolean AAH(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return A00(0, 15, 4).equals(str) && A00(15, 9, 65).equals(str2);
    }

    @Override // com.facebook.ads.redexgen.core.ZX
    public final boolean AIA() {
        return false;
    }
}
