package com.facebook.ads.redexgen.core;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.Metadata;
import com.google.android.exoplayer2.extractor.metadata.flac.PictureFrame;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class UU {
    public static byte[] A0C;
    public static String[] A0D = {"gmGjlUWd39TEywXOqID", "hebf6bgKNOoXcjpugfwwIPLEQ0B", "F4S29HqvgZJEmgf", "eJ0fC2ckzfJAlPLY1MlmfeW12IfV8nLl", "TXXznkbZr50LutAogWB", "DhQVEpxfG9pllAOAitOA5VLWglOHs0jE", "IQiSDdeWLAnKdh5G17ZqrVWrOfb", "5wYOajJVSx7sSMQ3BpCwuOUv9wAHOYWa"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final long A09;
    public final UT A0A;
    public final Metadata A0B;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 6);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0C = new byte[]{5, 17, 0, Ascii.CR, Ascii.VT, 75, 2, 8, 5, 7};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 14
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final UU A0A(List<PictureFrame> list) {
        return new UU(this.A05, this.A03, this.A06, this.A04, this.A07, this.A02, this.A00, this.A09, this.A0A, A02(new Metadata(list)));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 14
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final UU A0B(List<String> list) {
        return new UU(this.A05, this.A03, this.A06, this.A04, this.A07, this.A02, this.A00, this.A09, this.A0A, A02(AbstractC1964Uv.A02(list)));
    }

    static {
        A04();
    }

    public UU(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, UT ut, Metadata metadata) {
        this.A05 = i;
        this.A03 = i2;
        this.A06 = i3;
        this.A04 = i4;
        this.A07 = i5;
        this.A08 = A01(i5);
        this.A02 = i6;
        this.A00 = i7;
        this.A01 = A00(i7);
        this.A09 = j;
        this.A0A = ut;
        this.A0B = metadata;
    }

    public UU(byte[] bArr, int i) {
        C2446fp c2446fp = new C2446fp(bArr);
        c2446fp.A08(i * 8);
        this.A05 = c2446fp.A04(16);
        this.A03 = c2446fp.A04(16);
        this.A06 = c2446fp.A04(24);
        this.A04 = c2446fp.A04(24);
        this.A07 = c2446fp.A04(20);
        this.A08 = A01(this.A07);
        this.A02 = c2446fp.A04(3) + 1;
        this.A00 = c2446fp.A04(5) + 1;
        this.A01 = A00(this.A00);
        this.A09 = c2446fp.A05(36);
        this.A0A = null;
        this.A0B = null;
    }

    public static int A00(int i) {
        switch (i) {
            case 8:
                return 1;
            case 12:
                return 2;
            case 16:
                return 4;
            case 20:
                if (A0D[2].length() != 15) {
                    throw new RuntimeException();
                }
                A0D[2] = "3KgzNAOULujhlpP";
                return 5;
            case 24:
                if (A0D[2].length() != 15) {
                    throw new RuntimeException();
                }
                String[] strArr = A0D;
                strArr[7] = "KgaIQ1oLw7ASXkaFlA2tK4vXxmSRAcwk";
                strArr[3] = "xUJMJytchP7WMl05y163Nougx9Nzvk38";
                return 6;
            default:
                return -1;
        }
    }

    public static int A01(int i) {
        switch (i) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                String[] strArr = A0D;
                if (strArr[7].charAt(20) == strArr[3].charAt(20)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0D;
                strArr2[7] = "KxoNQWWPknlwo3IevgCHETQmA2B1U6op";
                strArr2[3] = "H9G6i8jHzM0HKPaalbC8JlzSqXvomgh9";
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    private final Metadata A02(Metadata metadata) {
        if (this.A0B == null) {
            return metadata;
        }
        Metadata metadata2 = this.A0B;
        if (A0D[5].charAt(2) == 'r') {
            throw new RuntimeException();
        }
        String[] strArr = A0D;
        strArr[1] = "utaC7lQxtOyrIDheZea6cZxcWJt";
        strArr[6] = "NDdML0TK7oSUyuCwiFQHQnVsSoO";
        return metadata2.A04(metadata);
    }

    public final long A05() {
        long j;
        if (this.A04 > 0) {
            long j2 = (((long) this.A04) + ((long) this.A06)) / 2;
            String[] strArr = A0D;
            if (strArr[7].charAt(20) == strArr[3].charAt(20)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[7] = "IcXKopfgeq8eZG0VDSo9QToXpwxm1Idx";
            strArr2[3] = "cfNcku25oxCWUk7rPDznrVmNJ7Uib23G";
            return j2 + 1;
        }
        if (this.A05 == this.A03 && this.A05 > 0) {
            j = this.A05;
        } else {
            j = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        long j3 = ((long) this.A02) * j;
        long blockSizeSamples = this.A00;
        return ((j3 * blockSizeSamples) / 8) + 64;
    }

    public final long A06() {
        if (this.A09 == 0) {
            return -9223372036854775807L;
        }
        return (this.A09 * 1000000) / ((long) this.A07);
    }

    public final long A07(long j) {
        long sampleNumber = AbstractC2471gE.A0T((((long) this.A07) * j) / 1000000, 0L, this.A09 - 1);
        return sampleNumber;
    }

    public final ZM A08(byte[] bArr, Metadata metadata) {
        bArr[4] = -128;
        int i = this.A04 > 0 ? this.A04 : -1;
        Metadata metadataA02 = A02(metadata);
        P5 p5A0h = new P5().A11(A03(0, 10, 98)).A0h(i);
        int maxInputSize = this.A02;
        P5 p5A0b = p5A0h.A0b(maxInputSize);
        int maxInputSize2 = this.A07;
        return p5A0b.A0m(maxInputSize2).A12(Collections.singletonList(bArr)).A0v(metadataA02).A14();
    }

    public final UU A09(UT ut) {
        return new UU(this.A05, this.A03, this.A06, this.A04, this.A07, this.A02, this.A00, this.A09, ut, this.A0B);
    }
}
