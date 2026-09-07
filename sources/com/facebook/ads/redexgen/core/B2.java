package com.facebook.ads.redexgen.core;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.Metadata;
import com.google.android.exoplayer2.extractor.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.extractor.metadata.id3.BinaryFrame;
import com.google.android.exoplayer2.extractor.metadata.id3.ChapterFrame;
import com.google.android.exoplayer2.extractor.metadata.id3.ChapterTocFrame;
import com.google.android.exoplayer2.extractor.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.extractor.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.extractor.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.extractor.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.extractor.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.extractor.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.extractor.metadata.id3.UrlLinkFrame;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class B2 extends V4 {
    public static byte[] A01;
    public static String[] A02 = {"4PUX10uapdAKfZ8re8Io2", "jNB", "IBbtYh0A9gNC1TrvC14nL43TzD7dWWko", "yQM15z", "lDa6K5W2t1sAKPEcLi9zi", "hY7ujEfoQ16D93Wi6K4rNPNHebqBzoW5", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "dV"};
    public static final VP A03;
    public final VP A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static ApicFrame A04(C2447fq c2447fq, int i, int i2) {
        int iA02;
        String strA01;
        int iA0I = c2447fq.A0I();
        Charset charsetA0M = A0M(iA0I);
        byte[] bArr = new byte[i - 1];
        c2447fq.A0k(bArr, 0, i - 1);
        String strA0J = A0J(402, 6, 88);
        if (i2 == 2) {
            iA02 = 2;
            strA01 = strA0J + AbstractC2555hb.A01(new String(bArr, 0, 3, AbstractC2557hd.A01));
            if (A0J(418, 9, 93).equals(strA01)) {
                strA01 = A0J(408, 10, 93);
            }
        } else {
            iA02 = A02(bArr, 0);
            strA01 = AbstractC2555hb.A01(new String(bArr, 0, iA02, AbstractC2557hd.A01));
            if (strA01.indexOf(47) == -1) {
                strA01 = strA0J + strA01;
            }
        }
        int i3 = bArr[iA02 + 1] & 255;
        int i4 = iA02 + 2;
        int iA03 = A03(bArr, i4, iA0I);
        return new ApicFrame(strA01, new String(bArr, i4, iA03 - i4, charsetA0M), i3, A0Q(bArr, A00(iA0I) + iA03, bArr.length));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static ChapterFrame A06(C2447fq c2447fq, int i, int i2, boolean z, int i3, VP vp) {
        int iA09 = c2447fq.A09();
        int iA02 = A02(c2447fq.A0l(), iA09);
        String str = new String(c2447fq.A0l(), iA09, iA02 - iA09, AbstractC2557hd.A01);
        c2447fq.A0f(iA02 + 1);
        int iA0C = c2447fq.A0C();
        int iA0C2 = c2447fq.A0C();
        long jA0Q = c2447fq.A0Q();
        if (jA0Q == 4294967295L) {
            jA0Q = -1;
        }
        long jA0Q2 = c2447fq.A0Q();
        if (jA0Q2 == 4294967295L) {
            jA0Q2 = -1;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = iA09 + i;
        while (c2447fq.A09() < i4) {
            Id3Frame id3FrameA0B = A0B(i2, c2447fq, z, i3, vp);
            if (id3FrameA0B != null) {
                arrayList.add(id3FrameA0B);
            }
        }
        return new ChapterFrame(str, iA0C, iA0C2, jA0Q, jA0Q2, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static GeobFrame A09(C2447fq c2447fq, int i) {
        int iA0I = c2447fq.A0I();
        Charset charsetA0M = A0M(iA0I);
        byte[] bArr = new byte[i - 1];
        c2447fq.A0k(bArr, 0, i - 1);
        int iA02 = A02(bArr, 0);
        String str = new String(bArr, 0, iA02, AbstractC2557hd.A01);
        int i2 = iA02 + 1;
        int iA03 = A03(bArr, i2, iA0I);
        String strA0L = A0L(bArr, i2, iA03, charsetA0M);
        int iA00 = A00(iA0I) + iA03;
        int iA04 = A03(bArr, iA00, iA0I);
        return new GeobFrame(str, strA0L, A0L(bArr, iA00, iA04, charsetA0M), A0Q(bArr, A00(iA0I) + iA04, bArr.length));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static MlltFrame A0C(C2447fq c2447fq, int i) {
        int iA0M = c2447fq.A0M();
        int iA0K = c2447fq.A0K();
        int iA0K2 = c2447fq.A0K();
        int iA0I = c2447fq.A0I();
        int iA0I2 = c2447fq.A0I();
        C2446fp c2446fp = new C2446fp();
        c2446fp.A0C(c2447fq);
        int i2 = ((i - 10) * 8) / (iA0I + iA0I2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int iA04 = c2446fp.A04(iA0I);
            int iA05 = c2446fp.A04(iA0I2);
            iArr[i3] = iA04;
            iArr2[i3] = iA05;
        }
        return new MlltFrame(iA0M, iA0K, iA0K2, iArr, iArr2);
    }

    public static String A0J(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0N() {
        A01 = new byte[]{-99, -88, -82, -48, 73, -121, 73, -121, 73, -121, 105, -89, 105, -89, 105, -89, 105, -89, 101, 89, -97, -85, -102, -90, -98, -116, -94, -77, -98, 118, -44, -15, 4, -15, -80, 4, -1, -1, -80, 3, -8, -1, 2, 4, -80, 4, -1, -80, -14, -11, -80, -15, -2, -80, -39, -44, -61, -80, 4, -15, -9, -49, -22, -14, -11, -18, -19, -87, -3, -8, -87, -19, -18, -20, -8, -19, -18, -87, -17, -5, -22, -10, -18, -61, -87, -14, -19, -58, -45, -18, -10, -7, -14, -15, -83, 1, -4, -83, 3, -18, -7, -10, -15, -18, 1, -14, -83, -42, -47, -64, -83, 1, -18, -12, -83, 4, -10, 1, -11, -83, -6, -18, -9, -4, -1, -29, -14, -1, 0, -10, -4, -5, -54, -93, -49, -66, -54, -62, 125, -48, -58, -41, -62, 125, -62, -43, -64, -62, -62, -63, -48, 125, -49, -62, -54, -66, -58, -53, -58, -53, -60, 125, -47, -66, -60, 125, -63, -66, -47, -66, -45, -18, -67, -50, -17, -19, -7, -18, -17, -4, -17, 7, 5, Ascii.FF, Ascii.FF, 1, 0, -68, -27, -32, -49, -68, Ascii.DLE, -3, 3, -68, 19, 5, Ascii.DLE, 4, -68, 9, -3, 6, Ascii.VT, Ascii.SO, -14, 1, Ascii.SO, Ascii.SI, 5, Ascii.VT, 10, -39, -50, -68, -3, 10, 0, -68, 17, 10, 0, 1, 2, 5, 10, 1, 0, -68, -1, Ascii.VT, 9, Ascii.FF, Ascii.SO, 1, Ascii.SI, Ascii.SI, 5, Ascii.VT, 10, -68, Ascii.SI, -1, 4, 1, 9, 1, -71, -47, -49, -42, -42, -53, -54, -122, -81, -86, -103, -122, -38, -57, -51, -122, -35, -49, -38, -50, -122, -37, -44, -39, -37, -42, -42, -43, -40, -38, -53, -54, -122, -45, -57, -48, -43, -40, -68, -53, -40, -39, -49, -43, -44, -93, -18, 6, 4, Ascii.VT, Ascii.VT, 4, 9, 2, -69, Ascii.DLE, 9, Ascii.SO, Ascii.DLE, Ascii.VT, Ascii.VT, 10, Ascii.CR, Ascii.SI, 0, -1, -69, -2, 10, 8, Ascii.VT, Ascii.CR, 0, Ascii.SO, Ascii.SO, 0, -1, -69, 10, Ascii.CR, -69, 0, 9, -2, Ascii.CR, Ascii.DC4, Ascii.VT, Ascii.SI, 0, -1, -69, 1, Ascii.CR, -4, 8, 0, -41, -37, -37, -37, -97, -72, -81, -62, -70, -81, -83, -66, -81, -82, 106, -80, -77, -68, -67, -66, 106, -66, -78, -68, -81, -81, 106, -84, -61, -66, -81, -67, 106, -71, -80, 106, -109, -114, 125, 106, -66, -85, -79, 106, -78, -81, -85, -82, -81, -68, -124, 106, 122, -62, -70, -69, -69, -69, -31, -27, -39, -33, -35, -89, -26, -22, -34, -28, -30, -84, -25, -19, -30, -28, -26, -22, -34, -28, -30, -84, -25, -19, -28};
    }

    static {
        A0N();
        A03 = new VP() { // from class: com.facebook.ads.redexgen.X.Ux
            @Override // com.facebook.ads.redexgen.core.VP
            public final boolean A6G(int i, int i2, int i3, int i4, int i5) {
                return B2.A0O(i, i2, i3, i4, i5);
            }
        };
    }

    public B2() {
        this(null);
    }

    public B2(VP vp) {
        this.A00 = vp;
    }

    public static int A00(int i) {
        if (i == 0 || i == 3) {
            return 1;
        }
        return 2;
    }

    public static int A01(C2447fq c2447fq, int i) {
        byte[] bArrA0l = c2447fq.A0l();
        int iA09 = c2447fq.A09();
        int i2 = iA09;
        while (startPosition < iA09 + i) {
            byte b = bArrA0l[i2];
            int startPosition = A02[7].length();
            if (startPosition != 2) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[4] = "Qmz29gqSj5oBgAAaGkuyA";
            strArr[0] = "P5RtE9KGbm2BLtYsqTEc0";
            if ((b & 255) == 255 && bArrA0l[i2 + 1] == 0) {
                int i3 = i2 + 2;
                int startPosition2 = i2 + 1;
                System.arraycopy(bArrA0l, i3, bArrA0l, startPosition2, (i - (i2 - iA09)) - 2);
                i--;
            }
            i2++;
        }
        return i;
    }

    public static int A02(byte[] bArr, int i) {
        while (i < i) {
            int i2 = bArr[i];
            if (i2 == 0) {
                return i;
            }
            i++;
        }
        int i3 = bArr.length;
        return i3;
    }

    public static int A03(byte[] bArr, int i, int i2) {
        int iA02 = A02(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iA02;
        }
        while (iA02 < terminationPos - 1) {
            int terminationPos = iA02 - i;
            int i3 = terminationPos % 2;
            if (A02[6].length() == 29) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[4] = "oKHflXQomRqlrTFJytXlQ";
            strArr[0] = "ptdZMHzR0IlJCy8h8ia0k";
            if (i3 == 0) {
                int terminationPos2 = iA02 + 1;
                if (bArr[terminationPos2] == 0) {
                    return iA02;
                }
            }
            int terminationPos3 = iA02 + 1;
            iA02 = A02(bArr, terminationPos3);
        }
        int terminationPos4 = bArr.length;
        return terminationPos4;
    }

    public static BinaryFrame A05(C2447fq c2447fq, int i, String str) {
        byte[] bArr = new byte[i];
        c2447fq.A0k(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    public static ChapterTocFrame A07(C2447fq c2447fq, int i, int i2, boolean z, int elementIdEndIndex, VP vp) {
        int iA09 = c2447fq.A09();
        int iA02 = A02(c2447fq.A0l(), iA09);
        String str = new String(c2447fq.A0l(), iA09, iA02 - iA09, AbstractC2557hd.A01);
        c2447fq.A0f(iA02 + 1);
        int framePosition = c2447fq.A0I();
        boolean z2 = (framePosition & 2) != 0;
        boolean z3 = (framePosition & 1) != 0;
        int iA0I = c2447fq.A0I();
        String[] strArr = new String[iA0I];
        for (int i3 = 0; i3 < iA0I; i3++) {
            int startIndex = c2447fq.A09();
            int iA03 = A02(c2447fq.A0l(), startIndex);
            int elementIdEndIndex2 = iA03 - startIndex;
            strArr[i3] = new String(c2447fq.A0l(), startIndex, elementIdEndIndex2, AbstractC2557hd.A01);
            c2447fq.A0f(iA03 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i4 = iA09 + i;
        while (c2447fq.A09() < i4) {
            Id3Frame id3FrameA0B = A0B(i2, c2447fq, z, elementIdEndIndex, vp);
            if (id3FrameA0B != null) {
                arrayList.add(id3FrameA0B);
            }
        }
        return new ChapterTocFrame(str, z2, z3, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    public static CommentFrame A08(C2447fq c2447fq, int i) {
        if (i < 4) {
            return null;
        }
        int textStartIndex = c2447fq.A0I();
        Charset charsetA0M = A0M(textStartIndex);
        byte[] bArr = new byte[3];
        c2447fq.A0k(bArr, 0, 3);
        String description = new String(bArr, 0, 3);
        int encoding = i - 4;
        byte[] data = new byte[encoding];
        int encoding2 = i - 4;
        c2447fq.A0k(data, 0, encoding2);
        int encoding3 = A03(data, 0, textStartIndex);
        String language = new String(data, 0, encoding3, charsetA0M);
        int iA00 = A00(textStartIndex) + encoding3;
        int encoding4 = A03(data, iA00, textStartIndex);
        return new CommentFrame(description, language, A0L(data, iA00, encoding4, charsetA0M));
    }

    public static VQ A0A(C2447fq c2447fq) {
        int iA07 = c2447fq.A07();
        String strA0J = A0J(170, 10, 106);
        if (iA07 < 10) {
            String strA0J2 = A0J(30, 31, 112);
            if (A02[6].length() != 29) {
                A02[7] = "ft";
                AbstractC2432fb.A07(strA0J, strA0J2);
                return null;
            }
        } else {
            int iA0K = c2447fq.A0K();
            boolean z = false;
            if (iA0K != 4801587) {
                AbstractC2432fb.A07(strA0J, A0J(348, 50, 42) + String.format(A0J(0, 4, 88), Integer.valueOf(iA0K)));
                return null;
            }
            int flags = c2447fq.A0I();
            c2447fq.A0g(1);
            int iA0I = c2447fq.A0I();
            int iA0H = c2447fq.A0H();
            if (flags == 2) {
                int id = iA0I & 64;
                int id2 = id != 0 ? 1 : 0;
                if (id2 != 0) {
                    AbstractC2432fb.A07(strA0J, A0J(180, 68, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE));
                    return null;
                }
            } else {
                if (A02[7].length() != 2) {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[4] = "OqMHXY7CQ0TcT8fFOzpkR";
                strArr[0] = "15NoodIVrIzM0pd7Jtwuw";
                if (flags == 3) {
                    int id3 = iA0I & 64;
                    int id4 = id3 != 0 ? 1 : 0;
                    if (id4 != 0) {
                        int iA0C = c2447fq.A0C();
                        String[] strArr2 = A02;
                        String str = strArr2[3];
                        String str2 = strArr2[1];
                        int majorVersion = str.length();
                        int id5 = str2.length();
                        if (majorVersion != id5) {
                            String[] strArr3 = A02;
                            strArr3[4] = "gxSfxc1ujN4pN2WOYfwTj";
                            strArr3[0] = "u0kRLxyagpkvuBkC8M7TC";
                            c2447fq.A0g(iA0C);
                            int id6 = iA0C + 4;
                            iA0H -= id6;
                        }
                    }
                } else if (flags == 4) {
                    int id7 = iA0I & 64;
                    int id8 = id7 != 0 ? 1 : 0;
                    if (id8 != 0) {
                        int majorVersion2 = c2447fq.A0H();
                        int id9 = majorVersion2 - 4;
                        c2447fq.A0g(id9);
                        iA0H -= majorVersion2;
                    }
                    int id10 = iA0I & 16;
                    int id11 = id10 != 0 ? 1 : 0;
                    if (id11 != 0) {
                        iA0H -= 10;
                    }
                } else {
                    AbstractC2432fb.A07(strA0J, A0J(248, 46, 70) + flags);
                    return null;
                }
            }
            if (flags < 4) {
                int id12 = iA0I & 128;
                if (id12 != 0) {
                    z = true;
                }
            }
            return new VQ(flags, z, iA0H);
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Code duplicated, block: B:142:0x0213  */
    /* JADX WARN: Code duplicated, block: B:149:0x0224  */
    /* JADX WARN: Code duplicated, block: B:151:0x0228  */
    /* JADX WARN: Code duplicated, block: B:156:0x023a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:157:0x023c  */
    /* JADX WARN: Code duplicated, block: B:162:0x024e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:163:0x0250  */
    /* JADX WARN: Code duplicated, block: B:169:0x025f A[Catch: all -> 0x02a1, TryCatch #0 {all -> 0x02a1, blocks: (B:102:0x019c, B:171:0x0269, B:104:0x01a4, B:111:0x01ba, B:113:0x01c2, B:121:0x01dc, B:130:0x01f4, B:141:0x020e, B:148:0x021f, B:155:0x0230, B:161:0x0244, B:168:0x025a, B:169:0x025f), top: B:179:0x018c }] */
    public static Id3Frame A0B(int frameId3, C2447fq c2447fq, boolean z, int i, VP vp) {
        int iA0I;
        int iA0K;
        int iA0M;
        Id3Frame id3FrameA05;
        int frameId2 = c2447fq.A0I();
        int frameId1 = c2447fq.A0I();
        int frameId0 = c2447fq.A0I();
        if (frameId3 >= 3) {
            iA0I = c2447fq.A0I();
        } else {
            iA0I = 0;
        }
        if (frameId3 == 4) {
            int frameSize = c2447fq.A0L();
            if (!z) {
                iA0K = (frameSize & 255) | (((frameSize >> 8) & 255) << 7) | (((frameSize >> 16) & 255) << 14) | (((frameSize >> 24) & 255) << 21);
            } else {
                iA0K = frameSize;
            }
        } else if (frameId3 == 3) {
            iA0K = c2447fq.A0L();
        } else {
            iA0K = c2447fq.A0K();
        }
        if (frameId3 >= 3) {
            iA0M = c2447fq.A0M();
        } else {
            iA0M = 0;
        }
        if (frameId2 == 0 && frameId1 == 0 && frameId0 == 0 && iA0I == 0 && iA0K == 0 && iA0M == 0) {
            c2447fq.A0f(c2447fq.A0A());
            String[] strArr = A02;
            String str = strArr[4];
            String str2 = strArr[0];
            int frameSize2 = str.length();
            if (frameSize2 == str2.length()) {
                A02[6] = "hqqzui2Ec48kmnrER";
                return null;
            }
        } else {
            int flags = c2447fq.A09() + iA0K;
            int iA0A = c2447fq.A0A();
            String strA0J = A0J(170, 10, 106);
            if (flags > iA0A) {
                AbstractC2432fb.A07(strA0J, A0J(Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 37, 61));
                c2447fq.A0f(c2447fq.A0A());
                return null;
            }
            if (vp != null) {
                int frameSize3 = A02[6].length();
                if (frameSize3 != 29) {
                    String[] strArr2 = A02;
                    strArr2[4] = "EHsQpASNLDjBF1JppFDpB";
                    strArr2[0] = "QoCYtxWXeEwWTFFLKWn7J";
                    if (!vp.A6G(frameId3, frameId2, frameId1, frameId0, iA0I)) {
                        c2447fq.A0f(flags);
                        return null;
                    }
                }
            }
            int frameSize4 = 0;
            boolean isCompressed = false;
            int nextFramePosition = 0;
            int i2 = 0;
            boolean z2 = false;
            if (frameId3 == 3) {
                i2 = (iA0M & 128) != 0 ? 1 : 0;
                isCompressed = (iA0M & 64) != 0;
                z2 = (iA0M & 32) != 0;
                frameSize4 = i2;
            } else if (frameId3 == 4) {
                int i3 = iA0M & 64;
                if (A02[6].length() == 29) {
                    throw new RuntimeException();
                }
                A02[6] = "C78dM7aoSSux75pzu";
                z2 = i3 != 0;
                frameSize4 = (iA0M & 8) != 0 ? 1 : 0;
                isCompressed = (iA0M & 4) != 0;
                nextFramePosition = (iA0M & 2) != 0 ? 1 : 0;
                i2 = (iA0M & 1) != 0 ? 1 : 0;
            }
            if (frameSize4 != 0 || isCompressed) {
                AbstractC2432fb.A07(strA0J, A0J(294, 50, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE));
                c2447fq.A0f(flags);
                return null;
            }
            if (z2) {
                iA0K--;
                if (A02[6].length() == 29) {
                    c2447fq.A0g(1);
                } else {
                    String[] strArr3 = A02;
                    strArr3[3] = "CJjnzN";
                    strArr3[1] = "ht9";
                    c2447fq.A0g(1);
                }
            }
            if (i2 != 0) {
                iA0K -= 4;
                c2447fq.A0g(4);
            }
            if (nextFramePosition != 0) {
                iA0K = A01(c2447fq, iA0K);
            }
            try {
                if (frameId2 == 84 && frameId1 == 88 && frameId0 == 88 && (frameId3 == 2 || iA0I == 88)) {
                    id3FrameA05 = A0E(c2447fq, iA0K);
                } else if (frameId2 == 84) {
                    id3FrameA05 = A0F(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                } else if (frameId2 == 87 && frameId1 == 88 && frameId0 == 88 && (frameId3 == 2 || iA0I == 88)) {
                    id3FrameA05 = A0G(c2447fq, iA0K);
                } else if (frameId2 == 87) {
                    id3FrameA05 = A0H(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                } else if (frameId2 == 80 && frameId1 == 82 && frameId0 == 73 && iA0I == 86) {
                    id3FrameA05 = A0D(c2447fq, iA0K);
                } else if (frameId2 == 71 && frameId1 == 69 && frameId0 == 79 && (iA0I == 66 || frameId3 == 2)) {
                    id3FrameA05 = A09(c2447fq, iA0K);
                } else if (frameId3 == 2) {
                    if (frameId2 == 80 && frameId1 == 73 && frameId0 == 67) {
                        id3FrameA05 = A04(c2447fq, iA0K, frameId3);
                    } else if (frameId2 == 67 || frameId1 != 79 || frameId0 != 77 || (iA0I != 77 && frameId3 != 2)) {
                        if (frameId2 != 67 && frameId1 == 72 && frameId0 == 65 && iA0I == 80) {
                            id3FrameA05 = A06(c2447fq, iA0K, frameId3, z, i, vp);
                        } else if (frameId2 != 67 && frameId1 == 84 && frameId0 == 79 && iA0I == 67) {
                            id3FrameA05 = A07(c2447fq, iA0K, frameId3, z, i, vp);
                        } else if (frameId2 != 77 && frameId1 == 76 && frameId0 == 76 && iA0I == 84) {
                            id3FrameA05 = A0C(c2447fq, iA0K);
                        } else {
                            id3FrameA05 = A05(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                        }
                    } else {
                        id3FrameA05 = A08(c2447fq, iA0K);
                    }
                } else if (frameId2 == 65 && frameId1 == 80 && frameId0 == 73 && iA0I == 67) {
                    id3FrameA05 = A04(c2447fq, iA0K, frameId3);
                } else if (frameId2 == 67) {
                    if (frameId2 != 67) {
                        if (frameId2 != 67) {
                            if (frameId2 != 77) {
                                id3FrameA05 = A05(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                            } else {
                                id3FrameA05 = A05(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                            }
                        } else if (frameId2 != 77) {
                            id3FrameA05 = A05(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                        } else {
                            id3FrameA05 = A05(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                        }
                    } else if (frameId2 != 67) {
                        if (frameId2 != 77) {
                            id3FrameA05 = A05(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                        } else {
                            id3FrameA05 = A05(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                        }
                    } else if (frameId2 != 77) {
                        id3FrameA05 = A05(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                    } else {
                        id3FrameA05 = A05(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                    }
                } else if (frameId2 != 67) {
                    if (frameId2 != 67) {
                        if (frameId2 != 77) {
                            id3FrameA05 = A05(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                        } else {
                            id3FrameA05 = A05(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                        }
                    } else if (frameId2 != 77) {
                        id3FrameA05 = A05(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                    } else {
                        id3FrameA05 = A05(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                    }
                } else if (frameId2 != 67) {
                    if (frameId2 != 77) {
                        id3FrameA05 = A05(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                    } else {
                        id3FrameA05 = A05(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                    }
                } else if (frameId2 != 77) {
                    id3FrameA05 = A05(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                } else {
                    id3FrameA05 = A05(c2447fq, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                }
                if (id3FrameA05 == null) {
                    AbstractC2432fb.A07(strA0J, A0J(61, 27, 105) + A0K(frameId3, frameId2, frameId1, frameId0, iA0I) + A0J(18, 12, 25) + iA0K);
                }
                c2447fq.A0f(flags);
                return id3FrameA05;
            } catch (Throwable th) {
                c2447fq.A0f(flags);
                throw th;
            }
        }
        throw new RuntimeException();
    }

    public static PrivFrame A0D(C2447fq c2447fq, int i) {
        byte[] bArr = new byte[i];
        c2447fq.A0k(bArr, 0, i);
        int iA02 = A02(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iA02, AbstractC2557hd.A01), A0Q(bArr, iA02 + 1, bArr.length));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OI != com.google.common.collect.ImmutableList<java.lang.String> */
    public static TextInformationFrame A0E(C2447fq c2447fq, int i) {
        if (i < 1) {
            return null;
        }
        int iA0I = c2447fq.A0I();
        int encoding = i - 1;
        byte[] bArr = new byte[encoding];
        int encoding2 = i - 1;
        c2447fq.A0k(bArr, 0, encoding2);
        int iA03 = A03(bArr, 0, iA0I);
        String str = new String(bArr, 0, iA03, A0M(iA0I));
        int encoding3 = A00(iA0I);
        return new TextInformationFrame(A0J(344, 4, 99), str, A0I(bArr, iA0I, encoding3 + iA03));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OI != com.google.common.collect.ImmutableList<java.lang.String> */
    public static TextInformationFrame A0F(C2447fq c2447fq, int i, String str) {
        if (i < 1) {
            return null;
        }
        int iA0I = c2447fq.A0I();
        int encoding = i - 1;
        byte[] data = new byte[encoding];
        c2447fq.A0k(data, 0, i - 1);
        return new TextInformationFrame(str, null, A0I(data, iA0I, 0));
    }

    public static UrlLinkFrame A0G(C2447fq c2447fq, int i) {
        if (i < 1) {
            return null;
        }
        int iA0I = c2447fq.A0I();
        int encoding = i - 1;
        byte[] bArr = new byte[encoding];
        int encoding2 = i - 1;
        c2447fq.A0k(bArr, 0, encoding2);
        int iA03 = A03(bArr, 0, iA0I);
        String str = new String(bArr, 0, iA03, A0M(iA0I));
        int descriptionEndIndex = A00(iA0I) + iA03;
        String description = A0L(bArr, descriptionEndIndex, A02(bArr, descriptionEndIndex), AbstractC2557hd.A01);
        return new UrlLinkFrame(A0J(398, 4, 67), str, description);
    }

    public static UrlLinkFrame A0H(C2447fq c2447fq, int i, String str) {
        byte[] bArr = new byte[i];
        c2447fq.A0k(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, A02(bArr, 0), AbstractC2557hd.A01));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4T != com.google.common.collect.ImmutableList$Builder<java.lang.String> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OI != com.google.common.collect.ImmutableList<java.lang.String> */
    public static OI<String> A0I(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        String strA0J = A0J(0, 0, 116);
        if (i2 >= length) {
            return OI.A04(strA0J);
        }
        C4T c4tA01 = OI.A01();
        int valueEndIndex = A03(bArr, i2, i);
        while (i2 < valueEndIndex) {
            int valueStartIndex = valueEndIndex - i2;
            c4tA01.A04(new String(bArr, i2, valueStartIndex, A0M(i)));
            i2 = valueEndIndex + A00(i);
            valueEndIndex = A03(bArr, i2, i);
        }
        OI<String> oiA05 = c4tA01.A05();
        return oiA05.isEmpty() ? OI.A04(strA0J) : oiA05;
    }

    public static String A0K(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, A0J(4, 6, 4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, A0J(10, 8, 36), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static String A0L(byte[] bArr, int i, int i2, Charset charset) {
        if (i2 <= i || i2 > bArr.length) {
            return A0J(0, 0, 116);
        }
        return new String(bArr, i, i2 - i, charset);
    }

    public static Charset A0M(int i) {
        switch (i) {
            case 1:
                return AbstractC2557hd.A03;
            case 2:
                return AbstractC2557hd.A04;
            case 3:
                return AbstractC2557hd.A06;
            default:
                return AbstractC2557hd.A01;
        }
    }

    public static /* synthetic */ boolean A0O(int i, int i2, int i3, int i4, int i5) {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x006b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x011c  */
    /* JADX WARN: Code duplicated, block: B:68:0x0136  */
    /* JADX WARN: Code duplicated, block: B:88:0x006d A[SYNTHETIC] */
    public static boolean A0P(C2447fq c2447fq, int flags, int i, boolean z) throws Throwable {
        int iA0C;
        long jA0Q;
        int iA0M;
        int id = c2447fq.A09();
        while (true) {
            try {
                if (c2447fq.A07() < i) {
                    c2447fq.A0f(id);
                    return true;
                }
                if (A02[7].length() == 2) {
                    String[] strArr = A02;
                    strArr[4] = "KWhqyBvFEBs6TSmGtoSns";
                    strArr[0] = "06Wxov2v3g4g2bBHEeO4e";
                    if (flags >= 3) {
                        try {
                            iA0C = c2447fq.A0C();
                            jA0Q = c2447fq.A0Q();
                            iA0M = c2447fq.A0M();
                        } catch (Throwable th) {
                            th = th;
                            c2447fq.A0f(id);
                            throw th;
                        }
                    } else {
                        iA0C = c2447fq.A0K();
                        jA0Q = c2447fq.A0K();
                        iA0M = 0;
                    }
                    if (iA0C == 0) {
                        String[] strArr2 = A02;
                        if (strArr2[4].length() != strArr2[0].length()) {
                            A02[7] = "Fo";
                            if (jA0Q == 0) {
                                if (iA0M == 0) {
                                    c2447fq.A0f(id);
                                    return true;
                                }
                            }
                        } else {
                            String[] strArr3 = A02;
                            strArr3[2] = "CPjmKHNr4LAkTagRVs4TTRLqB1MOnfx1";
                            strArr3[5] = "zG78r8EiJxjBcUmmx44D9WwhZrWYYeh1";
                            if (jA0Q == 0) {
                                if (iA0M == 0) {
                                    c2447fq.A0f(id);
                                    return true;
                                }
                            }
                        }
                    }
                    if (flags == 4 && !z) {
                        long j = 8421504 & jA0Q;
                        String[] strArr4 = A02;
                        if (strArr4[2].charAt(18) == strArr4[5].charAt(18)) {
                            String[] strArr5 = A02;
                            strArr5[4] = "8Xwu2F5ZCbeokj8HlMYHf";
                            strArr5[0] = "Hny8xcKoSixBfsCfMmOqv";
                            if (j != 0) {
                                c2447fq.A0f(id);
                                return false;
                            }
                            jA0Q = (((jA0Q >> 24) & 255) << 21) | (jA0Q & 255) | (((jA0Q >> 8) & 255) << 7) | (((jA0Q >> 16) & 255) << 14);
                        }
                    }
                    boolean z2 = false;
                    boolean z3 = false;
                    if (flags == 4) {
                        z2 = (iA0M & 64) != 0;
                        z3 = (iA0M & 1) != 0;
                    } else if (flags == 3) {
                        int i2 = iA0M & 32;
                        String[] strArr6 = A02;
                        String str = strArr6[3];
                        String str2 = strArr6[1];
                        int length = str.length();
                        int minimumFrameSize = str2.length();
                        if (length != minimumFrameSize) {
                            String[] strArr7 = A02;
                            strArr7[4] = "CYFGXQbDzoSzy2JqHcDJX";
                            strArr7[0] = "Okz82bMIrADsMsGVaoEfc";
                            if (i2 != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        } else {
                            String[] strArr8 = A02;
                            strArr8[4] = "z11zadk4ObR0wJQgMefXg";
                            strArr8[0] = "W7GNumIkvsmP3TKE498gN";
                            if (i2 != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        }
                        int minimumFrameSize2 = iA0M & 128;
                        z3 = minimumFrameSize2 != 0;
                    }
                    int minimumFrameSize3 = 0;
                    if (z2) {
                        minimumFrameSize3 = 0 + 1;
                    }
                    if (z3) {
                        minimumFrameSize3 += 4;
                    }
                    if (jA0Q < minimumFrameSize3) {
                        c2447fq.A0f(id);
                        return false;
                    }
                    int minimumFrameSize4 = c2447fq.A07();
                    if (minimumFrameSize4 >= jA0Q) {
                        int minimumFrameSize5 = (int) jA0Q;
                        c2447fq.A0g(minimumFrameSize5);
                    } else {
                        c2447fq.A0f(id);
                        return false;
                    }
                }
                throw new RuntimeException();
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static byte[] A0Q(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return AbstractC2471gE.A07;
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    @Override // com.facebook.ads.redexgen.core.V4
    public final Metadata A0R(Bi bi, ByteBuffer byteBuffer) {
        return A0S(byteBuffer.array(), byteBuffer.limit());
    }

    public final Metadata A0S(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        C2447fq c2447fq = new C2447fq(bArr, i);
        VQ vqA0A = A0A(c2447fq);
        if (vqA0A == null) {
            return null;
        }
        int startPosition = c2447fq.A09();
        int frameHeaderSize = vqA0A.A01 == 2 ? 6 : 10;
        int iA01 = vqA0A.A00;
        if (vqA0A.A02) {
            iA01 = A01(c2447fq, vqA0A.A00);
        }
        c2447fq.A0e(startPosition + iA01);
        boolean z = false;
        if (!A0P(c2447fq, vqA0A.A01, frameHeaderSize, false)) {
            if (vqA0A.A01 == 4 && A0P(c2447fq, 4, frameHeaderSize, true)) {
                z = true;
            } else {
                AbstractC2432fb.A07(A0J(170, 10, 106), A0J(88, 45, 109) + vqA0A.A01);
                return null;
            }
        }
        while (c2447fq.A07() >= frameHeaderSize) {
            Id3Frame id3FrameA0B = A0B(vqA0A.A01, c2447fq, z, frameHeaderSize, this.A00);
            if (id3FrameA0B != null) {
                arrayList.add(id3FrameA0B);
            }
        }
        return new Metadata(arrayList);
    }
}
