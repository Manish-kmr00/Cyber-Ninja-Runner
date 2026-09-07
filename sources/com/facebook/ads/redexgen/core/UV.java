package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.Metadata;
import com.google.android.exoplayer2.extractor.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.extractor.metadata.id3.InternalFrame;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class UV {
    public static byte[] A02;
    public static final Pattern A03;
    public int A00 = -1;
    public int A01 = -1;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 27);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{Ascii.SUB, 100, Ascii.US, 116, 105, 125, 37, 105, 34, 5, 105, 2, Ascii.EM, 63, 124, 57, 100, 108, Ascii.US, 116, 105, 125, 37, 105, 34, 5, 105, 2, Ascii.EM, 63, 124, 57, 109, 100, 108, Ascii.US, 116, 105, 125, 37, 105, 34, 5, 105, 2, Ascii.EM, 63, 124, 57, 109, Ascii.ETB, Ascii.ESC, Ascii.EM, 90, Ascii.NAK, 4, 4, Ascii.CAN, 17, 90, Ascii.GS, 32, 1, Ascii.SUB, 17, 7, 104, 85, 116, 111, 82, 76, 81, 67};
    }

    static {
        A01();
        A03 = Pattern.compile(A00(0, 50, 95));
    }

    private boolean A02(String str) {
        Matcher matcher = A03.matcher(str);
        if (matcher.find()) {
            try {
                int i = Integer.parseInt((String) AbstractC2471gE.A0f(matcher.group(1)), 16);
                int i2 = Integer.parseInt((String) AbstractC2471gE.A0f(matcher.group(2)), 16);
                if (i > 0 || i2 > 0) {
                    this.A00 = i;
                    this.A01 = i2;
                    return true;
                }
                return false;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return false;
    }

    public final boolean A03() {
        return (this.A00 == -1 || this.A01 == -1) ? false : true;
    }

    public final boolean A04(int i) {
        int encoderPadding = i >> 12;
        int encoderDelay = i & 4095;
        if (encoderPadding > 0 || encoderDelay > 0) {
            this.A00 = encoderPadding;
            this.A01 = encoderDelay;
            return true;
        }
        return false;
    }

    public final boolean A05(Metadata metadata) {
        for (int i = 0; i < i; i++) {
            Metadata.Entry entryA03 = metadata.A03(i);
            boolean z = entryA03 instanceof CommentFrame;
            String strA00 = A00(66, 8, 26);
            if (z) {
                CommentFrame commentFrame = (CommentFrame) entryA03;
                if (strA00.equals(commentFrame.A00) && A02(commentFrame.A02)) {
                    return true;
                }
            } else if (entryA03 instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) entryA03;
                if (A00(50, 16, 111).equals(internalFrame.A01) && strA00.equals(internalFrame.A00) && A02(internalFrame.A02)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
