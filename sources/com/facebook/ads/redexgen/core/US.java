package com.facebook.ads.redexgen.core;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.Metadata;
import com.google.android.exoplayer2.extractor.metadata.flac.PictureFrame;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
@MetaExoPlayerCustomization("Replaces ImmutableList.of with MetaExoPlayerCustomizedCollections")
public abstract class US {
    public static byte[] A00;
    public static String[] A01 = {"7xrPmsNNd1unvJpEfGKxRElcl", "UF6TMW5ECNWn0ZgVy6X49cXfyO7gkJiE", ExifInterface.LONGITUDE_EAST, "RDu94cFDn72yF7GpK0dr", "Y", "Ii87nBGvK8Q0hhczZRY1", "vqoXMgf1LSeO3kCxRF8sJspBkbslDPq2", "Jk0EpoMWrnH7PRkGzB"};

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = (bArrCopyOfRange[i4] - i3) - 47;
            String[] strArr = A01;
            if (strArr[2].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            A01[6] = "hZwP6y6oyh76aU1TPWI3XaYDcV3tuEqo";
            bArrCopyOfRange[i4] = (byte) i5;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{-47, -20, -12, -9, -16, -17, -85, -1, -6, -85, -3, -16, -20, -17, -85, -47, -41, -52, -50, -85, -2, -1, -3, -16, -20, -8, -85, -8, -20, -3, -10, -16, -3, -71, -58, -23, -14, -13, -12, -96, -26, -14, -31, -19, -27, -96, -28, -17, -27, -13, -96, -18, -17, -12, -96, -13, -12, -31, -14, -12, -96, -9, -23, -12, -24, -96, -13, -7, -18, -29, -96, -29, -17, -28, -27, -82};
    }

    static {
        A08();
    }

    public static int A00(WJ wj) throws IOException {
        wj.AHr();
        C2447fq c2447fq = new C2447fq(2);
        wj.AG1(c2447fq.A0l(), 0, 2);
        int syncCode = c2447fq.A0M();
        int frameStartMarker = syncCode >> 2;
        if (frameStartMarker == 16382) {
            wj.AHr();
            return syncCode;
        }
        wj.AHr();
        throw Q6.A01(A06(34, 42, 81), null);
    }

    public static Metadata A01(WJ wj, boolean z) throws IOException {
        VP id3FramePredicate;
        if (z) {
            id3FramePredicate = null;
        } else {
            id3FramePredicate = B2.A03;
        }
        Metadata metadataA00 = new UX().A00(wj, id3FramePredicate);
        if (metadataA00 == null || metadataA00.A02() == 0) {
            return null;
        }
        return metadataA00;
    }

    public static Metadata A02(WJ wj, boolean z) throws IOException {
        wj.AHr();
        long jA8Y = wj.A8Y();
        Metadata metadataA01 = A01(wj, z);
        wj.AJ9((int) (wj.A8Y() - jA8Y));
        return metadataA01;
    }

    public static UT A03(WJ wj, int i) throws IOException {
        C2447fq c2447fq = new C2447fq(i);
        wj.readFully(c2447fq.A0l(), 0, i);
        return A04(c2447fq);
    }

    public static UT A04(C2447fq c2447fq) {
        c2447fq.A0g(1);
        int iA0K = c2447fq.A0K();
        int length = c2447fq.A09();
        long j = ((long) length) + ((long) iA0K);
        int i = iA0K / 18;
        long[] jArrCopyOf = new long[i];
        long[] jArrCopyOf2 = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            long jA0P = c2447fq.A0P();
            if (jA0P == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                break;
            }
            jArrCopyOf[i2] = jA0P;
            jArrCopyOf2[i2] = c2447fq.A0P();
            c2447fq.A0g(2);
        }
        int length2 = c2447fq.A09();
        c2447fq.A0g((int) (j - ((long) length2)));
        return new UT(jArrCopyOf, jArrCopyOf2);
    }

    public static UU A05(WJ wj) throws IOException {
        byte[] bArr = new byte[38];
        wj.readFully(bArr, 0, 38);
        return new UU(bArr, 4);
    }

    public static List<String> A07(WJ wj, int i) throws IOException {
        C2447fq c2447fq = new C2447fq(i);
        wj.readFully(c2447fq.A0l(), 0, i);
        c2447fq.A0g(4);
        return Arrays.asList(AbstractC1964Uv.A05(c2447fq, false, false).A02);
    }

    public static void A09(WJ wj) throws IOException {
        C2447fq c2447fq = new C2447fq(4);
        wj.readFully(c2447fq.A0l(), 0, 4);
        if (c2447fq.A0Q() == 1716281667) {
        } else {
            throw Q6.A01(A06(0, 34, 92), null);
        }
    }

    public static boolean A0A(WJ wj) throws IOException {
        C2447fq c2447fq = new C2447fq(4);
        wj.AG1(c2447fq.A0l(), 0, 4);
        return c2447fq.A0Q() == 1716281667;
    }

    public static boolean A0B(WJ wj, UR ur) throws IOException {
        wj.AHr();
        C2446fp c2446fp = new C2446fp(new byte[4]);
        wj.AG1(c2446fp.A00, 0, 4);
        boolean zA0H = c2446fp.A0H();
        int iA04 = c2446fp.A04(7);
        int iA05 = c2446fp.A04(24) + 4;
        if (iA04 == 0) {
            UU uuA05 = A05(wj);
            String[] strArr = A01;
            if (strArr[3].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[3] = "4gxQC6i9k4AoNZbM3f30";
            strArr2[5] = "AhWhbFWdu27jwwP6x47z";
            ur.A00 = uuA05;
        } else {
            UU uu = ur.A00;
            if (uu != null) {
                if (iA04 != 3) {
                    if (iA04 == 4) {
                        ur.A00 = uu.A0B(A07(wj, iA05));
                    } else if (iA04 == 6) {
                        C2447fq c2447fq = new C2447fq(iA05);
                        wj.readFully(c2447fq.A0l(), 0, iA05);
                        c2447fq.A0g(4);
                        PictureFrame pictureFrame = PictureFrame.A00(c2447fq);
                        ur.A00 = uu.A0A(MetaExoPlayerCustomizedCollections.A03(pictureFrame));
                    } else {
                        wj.AJ9(iA05);
                    }
                } else {
                    ur.A00 = uu.A09(A03(wj, iA05));
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        return zA0H;
    }
}
