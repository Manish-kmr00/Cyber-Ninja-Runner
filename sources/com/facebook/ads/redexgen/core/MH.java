package com.facebook.ads.redexgen.core;

import android.media.MediaCodec;
import android.os.Build;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nullable;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class MH {

    @Nullable
    public static Boolean A00;
    public static byte[] A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{106, 77, 69, SignedBytes.MAX_POWER_OF_TWO, 73, 72, Ascii.FF, 88, 67, Ascii.FF, 75, 73, 88, Ascii.FF, 65, 73, 72, 69, 77, Ascii.FF, 111, 67, 72, 73, 79, 7, 42, Base64.padSymbol, 32, 10, 55, 32, Ascii.SUB, 59, 38, 35, 97, 114, 121, 115, 120, 101, 57, 100, 114, 116, 58, 118, 126, 113, 101, 116, 58, 99, 101, 118, 121, 100, 113, 114, 101, 58, 101, 114, 102, 98, 114, 100, 99, 57, 97, 118, 123, 98, 114, 65, 94, 83, 82, 88, Ascii.CAN, 86, 65, 84};
    }

    static {
        A01();
        A00 = null;
    }

    public static boolean A02() {
        if (A00 != null) {
            return A00.booleanValue();
        }
        A00 = false;
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(A00(75, 9, 74));
                for (String param : mediaCodecCreateDecoderByType.getSupportedVendorParameters()) {
                    if (param.equals(A00(36, 39, 106))) {
                        A00 = true;
                        break;
                    }
                }
                mediaCodecCreateDecoderByType.release();
            }
        } catch (IOException e) {
            String param2 = A00(25, 11, 50);
            L4.A02(param2, A00(0, 25, 81), e);
        }
        return A00.booleanValue();
    }

    public static boolean A03(int i, int i2) {
        if (i >= 480 && i2 >= 480 && i <= 3840 && i2 <= 2160) {
            return true;
        }
        return false;
    }
}
