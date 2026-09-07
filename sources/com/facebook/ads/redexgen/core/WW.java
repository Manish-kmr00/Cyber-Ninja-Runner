package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.Metadata;
import com.google.android.exoplayer2.extractor.metadata.mp4.SlowMotionData;
import com.google.common.base.Ascii;
import io.ktor.util.date.GMTDateParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WW {
    public static byte[] A03;
    public static String[] A04 = {"xVv6a3kBgHP291y1mY3efrymRkAiXkaQ", "FTwpQIugICtYOWGkZwYZthxUL7HKEmyC", "s3us1ScbO6rGbl466sPykO4ixE9i", "93pxYvyEPedWD4X2BuFQjC1zpHbmfg", "mmgF18", "CGAsalvoWJx0Das9bhiV8YnFSBpu1Qq0", "aeq4LsRlfFrzZtlLm07ekl9NPEbmriYf", "NwzOnY7JkM9Q7fUISy9jkeWQndblTKKo"};
    public static final C2596iK A05;
    public static final C2596iK A06;
    public int A01;
    public final List<WT> A02 = new ArrayList();
    public int A00 = 0;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 122);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        byte[] bArr = {55, 92, 100, 79, 90, 87, 82, Ascii.SO, 65, 51, 52, Ascii.SO, 92, 79, 91, 83, 48, 73, 76, 84, 42, 76, 81, 70, 76, 75, 60, 33, 62, 81, 62, 19, 53, 48, 37, 50, Ascii.US, 19, 44, 47, 55, Ascii.CR, 47, 52, 41, 47, 46, Ascii.US, 2, 7, Ascii.CR, 10, 44, 39, Ascii.FS, 41, Ascii.SYN, 10, 35, 38, 46, 4, 38, 43, 32, 38, 37, Ascii.SYN, -5, Ascii.CAN, 43, Ascii.CAN, Ascii.DLE, 50, 45, 34, 47, Ascii.FS, Ascii.DLE, 41, 44, 52, 10, 44, 49, 38, 44, 43, Ascii.FS, 1, 34, 35, 41, 38, 32, 40, 34, 47, 38, 43, 36, Ascii.FS, Ascii.FF, 43, -44, -10, -15, -26, -13, -32, -44, -19, -16, -8, -50, -16, -11, -22, -16, -17, -32, -58, -27, -22, -11, -32, -59, -30, -11, -30};
        String[] strArr = A04;
        if (strArr[0].charAt(23) == strArr[5].charAt(23)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[4] = "V1SfVw";
        strArr2[3] = "YMS7HvlwTDyXKOqSWiRbw5ErY8r3aH";
        A03 = bArr;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A06(WJ wj, List<Metadata.Entry> list) throws IOException {
        long jA8d = wj.A8d();
        int iA8E = (int) ((wj.A8E() - wj.A8d()) - ((long) this.A01));
        C2447fq c2447fq = new C2447fq(iA8E);
        wj.readFully(c2447fq.A0l(), 0, iA8E);
        for (int i = 0; i < this.A02.size(); i++) {
            WT wt = this.A02.get(i);
            c2447fq.A0f((int) (wt.A02 - jA8d));
            c2447fq.A0g(4);
            int iA0E = c2447fq.A0E();
            int iA00 = A00(c2447fq.A0W(iA0E));
            int i2 = wt.A01 - (iA0E + 8);
            switch (iA00) {
                case 2192:
                    list.add(A01(c2447fq, i2));
                    break;
                case 2816:
                case 2817:
                case 2819:
                case 2820:
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    static {
        A03();
        A06 = C2596iK.A02(AbstractJsonLexerKt.COLON);
        A05 = C2596iK.A02(GMTDateParser.ANY);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0007  */
    public static int A00(String str) throws Q6 {
        byte b;
        switch (str.hashCode()) {
            case -1711564334:
                if (!str.equals(A02(16, 15, 99))) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            case -1332107749:
                if (!str.equals(A02(104, 26, 7))) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            case -1251387154:
                if (!str.equals(A02(51, 21, 61))) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case -830665521:
                if (!str.equals(A02(72, 32, 67))) {
                    b = -1;
                } else {
                    b = 4;
                }
                break;
            case 1760745220:
                if (!str.equals(A02(31, 20, 70))) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                return 2192;
            case 1:
                return 2816;
            case 2:
                return 2817;
            case 3:
                return 2819;
            case 4:
                return 2820;
            default:
                throw Q6.A01(A02(0, 16, 116), null);
        }
    }

    public static SlowMotionData A01(C2447fq c2447fq, int i) throws Q6 {
        List<SlowMotionData.Segment> segments = new ArrayList<>();
        String dataString = c2447fq.A0W(i);
        List<String> listA06 = A05.A06(dataString);
        for (int i2 = 0; i2 < listA06.size(); i2++) {
            List<String> listA07 = A06.A06(listA06.get(i2));
            if (listA07.size() == 3) {
                try {
                    long j = Long.parseLong(listA07.get(0));
                    long startTimeMs = Long.parseLong(listA07.get(1));
                    segments.add(new SlowMotionData.Segment(j, startTimeMs, 1 << (Integer.parseInt(listA07.get(2)) - 1)));
                } catch (NumberFormatException e) {
                    throw Q6.A01(null, e);
                }
            } else {
                throw Q6.A01(null, null);
            }
        }
        return new SlowMotionData(segments);
    }

    private void A04(WJ wj, C1952Ug c1952Ug) throws IOException {
        C2447fq c2447fq = new C2447fq(8);
        wj.readFully(c2447fq.A0l(), 0, 8);
        this.A01 = c2447fq.A0E() + 8;
        if (c2447fq.A0C() != 1397048916) {
            c1952Ug.A00 = 0L;
        } else {
            c1952Ug.A00 = wj.A8d() - ((long) (this.A01 - 12));
            this.A00 = 2;
        }
    }

    private void A05(WJ wj, C1952Ug c1952Ug) throws IOException {
        long jA8E = wj.A8E();
        int i = (this.A01 - 12) - 8;
        C2447fq c2447fq = new C2447fq(i);
        wj.readFully(c2447fq.A0l(), 0, i);
        for (int i2 = 0; i2 < i / 12; i2++) {
            c2447fq.A0g(2);
            int i3 = c2447fq.A0a();
            switch (i3) {
                case 2192:
                case 2816:
                case 2817:
                case 2819:
                case 2820:
                    long streamLength = this.A01;
                    long j = jA8E - streamLength;
                    long streamLength2 = c2447fq.A0E();
                    int size = c2447fq.A0E();
                    this.A02.add(new WT(i3, j - streamLength2, size));
                    break;
                default:
                    c2447fq.A0g(8);
                    break;
            }
        }
        if (this.A02.isEmpty()) {
            c1952Ug.A00 = 0L;
            return;
        }
        this.A00 = 3;
        long streamLength3 = this.A02.get(0).A02;
        c1952Ug.A00 = streamLength3;
    }

    public final int A07(WJ wj, C1952Ug c1952Ug, List<Metadata.Entry> slowMotionMetadataEntries) throws IOException {
        long j = 0;
        switch (this.A00) {
            case 0:
                long jA8E = wj.A8E();
                if (jA8E != -1 && jA8E >= 8) {
                    j = jA8E - 8;
                }
                c1952Ug.A00 = j;
                this.A00 = 1;
                return 1;
            case 1:
                A04(wj, c1952Ug);
                return 1;
            case 2:
                A05(wj, c1952Ug);
                return 1;
            case 3:
                A06(wj, slowMotionMetadataEntries);
                if (A04[7].charAt(2) != 'z') {
                    throw new RuntimeException();
                }
                A04[2] = "bsIVJfH6fCpgF02bzpDTwrDyie4t";
                c1952Ug.A00 = 0L;
                return 1;
            default:
                throw new IllegalStateException();
        }
    }

    public final void A08() {
        this.A02.clear();
        this.A00 = 0;
    }
}
