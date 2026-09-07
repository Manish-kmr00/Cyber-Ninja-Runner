package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XE {
    public static byte[] A07;
    public static String[] A08 = {"qaVNF3cuOQ2TShKUfBd8wTxxX16un2aj", "DHz1HpLj16CbV8kgqNXleZgBYWEDfTGB", "zh4dgPP", "", "i7EfpclWWzBPOSlmcpUZDTE93tNbJx57", "chfqfdzSYKizTJc1RlSxkoLzX6vYJPdw", "EpROsiYjRE43AFJBJj57TgI", "PC28fV4Mm0GGwYfYo2Zbp0GEbNYdPasF"};
    public static final byte[] A09;
    public static final byte[] A0A;
    public static final byte[] A0B;
    public Bitmap A00;
    public final Canvas A01;
    public final Paint A02 = new Paint();
    public final Paint A03;
    public final X6 A04;
    public final X7 A05;
    public final XD A06;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static X6 A04(C2446fp c2446fp, int i) {
        int[] iArr;
        int iA04;
        int iA05;
        int iA06;
        int iA07;
        int i2 = 8;
        int iA08 = c2446fp.A04(8);
        c2446fp.A09(8);
        int i3 = i - 2;
        int[] iArrA0F = A0F();
        int[] iArrA0G = A0G();
        int[] iArrA0H = A0H();
        while (i3 > 0) {
            int iA09 = c2446fp.A04(i2);
            int iA010 = c2446fp.A04(i2);
            int i4 = i3 - 2;
            if ((iA010 & 128) != 0) {
                iArr = iArrA0F;
            } else {
                iArr = (iA010 & 64) != 0 ? iArrA0G : iArrA0H;
            }
            if ((iA010 & 1) != 0) {
                iA04 = c2446fp.A04(i2);
                iA05 = c2446fp.A04(i2);
                if (A08[0].charAt(28) == '0') {
                    throw new RuntimeException();
                }
                String[] strArr = A08;
                strArr[5] = "HMcwXsRxCBdugXDYoLFekeNu97sTcfdg";
                strArr[1] = "h3BrkjhHflgBsgKJ8ktatJXtnWvKSPBP";
                iA06 = c2446fp.A04(i2);
                iA07 = c2446fp.A04(i2);
                i3 = i4 - 4;
            } else {
                iA04 = c2446fp.A04(6) << 2;
                iA05 = c2446fp.A04(4) << 4;
                if (A08[3].length() != 0) {
                    throw new RuntimeException();
                }
                A08[3] = "";
                iA06 = c2446fp.A04(4) << 4;
                iA07 = c2446fp.A04(2) << 6;
                i3 = i4 - 2;
            }
            if (iA04 == 0) {
                iA05 = 0;
                iA06 = 0;
                iA07 = 255;
            }
            iArr[iA09] = A00((byte) (255 - (iA07 & 255)), AbstractC2471gE.A07((int) (((double) iA04) + (((double) (iA05 - 128)) * 1.402d)), 0, 255), AbstractC2471gE.A07((int) ((((double) iA04) - (((double) (iA06 - 128)) * 0.34414d)) - (((double) (iA05 - 128)) * 0.71414d)), 0, 255), AbstractC2471gE.A07((int) (((double) iA04) + (((double) (iA06 - 128)) * 1.772d)), 0, 255));
            i2 = 8;
        }
        return new X6(iA08, iArrA0F, iArrA0G, iArrA0H);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static X7 A05(C2446fp c2446fp) {
        int iA04;
        int iA05;
        int iA06;
        int iA07;
        c2446fp.A09(4);
        boolean zA0H = c2446fp.A0H();
        c2446fp.A09(3);
        int iA08 = c2446fp.A04(16);
        int iA09 = c2446fp.A04(16);
        if (zA0H) {
            iA04 = c2446fp.A04(16);
            iA07 = c2446fp.A04(16);
            iA05 = c2446fp.A04(16);
            iA06 = c2446fp.A04(16);
        } else {
            iA04 = 0;
            iA05 = 0;
            iA06 = iA09;
            iA07 = iA08;
        }
        return new X7(iA08, iA09, iA04, iA07, iA05, iA06);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static XB A08(C2446fp c2446fp, int i) {
        int i2 = 8;
        int iA04 = c2446fp.A04(8);
        c2446fp.A09(4);
        boolean zA0H = c2446fp.A0H();
        c2446fp.A09(3);
        int iA05 = c2446fp.A04(16);
        int iA06 = c2446fp.A04(16);
        int iA07 = c2446fp.A04(3);
        int iA08 = c2446fp.A04(3);
        c2446fp.A09(2);
        int iA09 = c2446fp.A04(8);
        int iA010 = c2446fp.A04(8);
        int iA011 = c2446fp.A04(4);
        int iA012 = c2446fp.A04(2);
        c2446fp.A09(2);
        int i3 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i3 > 0) {
            int iA013 = c2446fp.A04(16);
            int iA014 = c2446fp.A04(2);
            int iA015 = c2446fp.A04(2);
            int iA016 = c2446fp.A04(12);
            c2446fp.A09(4);
            int iA017 = c2446fp.A04(12);
            i3 -= 6;
            int iA018 = 0;
            int iA019 = 0;
            if (iA014 == 1 || iA014 == 2) {
                iA018 = c2446fp.A04(i2);
                iA019 = c2446fp.A04(i2);
                i3 -= 2;
                if (A08[0].charAt(28) == '0') {
                    throw new RuntimeException();
                }
                A08[3] = "";
            }
            sparseArray.put(iA013, new XC(iA014, iA015, iA016, iA017, iA018, iA019));
            i2 = 8;
        }
        return new XB(iA04, zA0H, iA05, iA06, iA07, iA08, iA09, iA010, iA011, iA012, sparseArray);
    }

    public static String A09(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A08[3].length() != 0) {
                throw new RuntimeException();
            }
            A08[3] = "";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 9);
            i4++;
        }
    }

    public static void A0A() {
        A07 = new byte[]{Ascii.SYN, 51, 38, 51, 114, 52, 59, 55, 62, 54, 114, 62, 55, 60, 53, 38, 58, 114, 55, 42, 49, 55, 55, 54, 33, 114, 62, 59, 63, 59, 38, 48, 2, Ascii.SYN, 36, Ascii.NAK, 6, 7, 17, 6};
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0072  */
    /* JADX WARN: Code duplicated, block: B:29:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:33:0x010d  */
    /* JADX WARN: Code duplicated, block: B:38:0x012e  */
    /* JADX WARN: Code duplicated, block: B:41:0x013c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0152  */
    /* JADX WARN: Code duplicated, block: B:45:0x015e  */
    /* JADX WARN: Code duplicated, block: B:47:0x016c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x016e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0189  */
    /* JADX WARN: Code duplicated, block: B:54:0x0193  */
    /* JADX WARN: Code duplicated, block: B:57:0x019a  */
    /* JADX WARN: Code duplicated, block: B:59:0x019f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0216  */
    /* JADX WARN: Code duplicated, block: B:64:0x021b  */
    /* JADX WARN: Code duplicated, block: B:65:0x0222  */
    /* JADX WARN: Code duplicated, block: B:66:0x022a  */
    /* JADX WARN: Code duplicated, block: B:81:0x024a A[EDGE_INSN: B:81:0x024a->B:75:0x024a BREAK  A[LOOP:1: B:27:0x00a9->B:61:0x01bb], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x024a A[EDGE_INSN: B:82:0x024a->B:75:0x024a BREAK  A[LOOP:1: B:27:0x00a9->B:61:0x01bb], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x0244 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x01bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x0186 A[SYNTHETIC] */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final List<C1853Qh> A0I(byte[] bArr, int i) {
        ArrayList arrayList;
        SparseArray<XA> sparseArray;
        int i2;
        int size;
        XB xb;
        int i3;
        int i4;
        X6 x6;
        SparseArray<XC> sparseArray2;
        int i5;
        int i6;
        int iKeyAt;
        XC xcValueAt;
        X8 x8;
        boolean z;
        Paint paint;
        C2446fp c2446fp = new C2446fp(bArr, i);
        while (c2446fp.A01() >= 48 && c2446fp.A04(8) == 15) {
            A0C(c2446fp, this.A06);
        }
        XD xd = this.A06;
        String[] strArr = A08;
        if (strArr[5].charAt(31) == strArr[1].charAt(31)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[7] = "mgC0T2wkMjSkqn4bR35HCoGRUmnAM0ap";
        strArr2[4] = "43e78zkTMQlhhRdvv6XHJWBrGehGB3ZN";
        X9 x9 = xd.A01;
        if (x9 == null) {
            return Collections.emptyList();
        }
        X7 x7 = this.A06.A00 != null ? this.A06.A00 : this.A05;
        Bitmap bitmap = this.A00;
        if (A08[0].charAt(28) != '0') {
            A08[0] = "slnk6gxAsmOM3Rrc261rCYBOzDF3NEqL";
            if (bitmap != null) {
                if (x7.A05 + 1 == this.A00.getWidth() || x7.A00 + 1 != this.A00.getHeight()) {
                }
            }
            arrayList = new ArrayList();
            sparseArray = x9.A03;
            i2 = 0;
            while (true) {
                size = sparseArray.size();
                if (A08[0].charAt(28) != '0') {
                    A08[0] = "yo8SPYAH6dKQEHTbCxocPMd5Ujl9JVv5";
                    if (i2 >= size) {
                        break;
                    }
                    this.A01.save();
                    XA xaValueAt = sparseArray.valueAt(i2);
                    xb = this.A06.A08.get(sparseArray.keyAt(i2));
                    i3 = xaValueAt.A00 + x7.A02;
                    i4 = xaValueAt.A01 + x7.A04;
                    this.A01.clipRect(i3, i4, Math.min(xb.A08 + i3, x7.A01), Math.min(xb.A02 + i4, x7.A03));
                    x6 = this.A06.A06.get(xb.A00);
                    if (x6 == null && (x6 = this.A06.A04.get(xb.A00)) == null) {
                        x6 = this.A04;
                    }
                    sparseArray2 = xb.A09;
                    if (A08[0].charAt(28) != '0') {
                        throw new RuntimeException();
                    }
                    A08[3] = "";
                    for (i5 = 0; i5 < sparseArray2.size(); i5++) {
                        iKeyAt = sparseArray2.keyAt(i5);
                        xcValueAt = sparseArray2.valueAt(i5);
                        x8 = this.A06.A07.get(iKeyAt);
                        if (x8 == null) {
                            x8 = this.A06.A05.get(iKeyAt);
                        }
                        if (x8 != null) {
                            z = x8.A01;
                            if (A08[3].length() != 0) {
                                A08[3] = "";
                                if (z) {
                                    paint = null;
                                } else {
                                    paint = this.A02;
                                }
                            } else if (z) {
                                paint = null;
                            } else {
                                paint = this.A02;
                            }
                            A0B(x8, x6, xb.A01, i3 + xcValueAt.A02, i4 + xcValueAt.A05, paint, this.A01);
                        }
                    }
                    if (!xb.A0A) {
                        if (xb.A01 == 3) {
                            i6 = x6.A03[xb.A07];
                        } else if (xb.A01 == 2) {
                            i6 = x6.A02[xb.A06];
                        } else {
                            i6 = x6.A01[xb.A05];
                        }
                        this.A03.setColor(i6);
                        this.A01.drawRect(i3, i4, xb.A08 + i3, xb.A02 + i4, this.A03);
                    }
                    arrayList.add(new C2245cY().A0D(Bitmap.createBitmap(this.A00, i3, i4, xb.A08, xb.A02)).A04(i3 / x7.A05).A0A(0).A07(i4 / x7.A00, 0).A09(0).A06(xb.A08 / x7.A05).A03(xb.A02 / x7.A00).A0H());
                    this.A01.drawColor(0, PorterDuff.Mode.CLEAR);
                    this.A01.restore();
                    i2++;
                } else {
                    A08[3] = "";
                    if (i2 >= size) {
                        break;
                    }
                    this.A01.save();
                    XA xaValueAt2 = sparseArray.valueAt(i2);
                    xb = this.A06.A08.get(sparseArray.keyAt(i2));
                    i3 = xaValueAt2.A00 + x7.A02;
                    i4 = xaValueAt2.A01 + x7.A04;
                    this.A01.clipRect(i3, i4, Math.min(xb.A08 + i3, x7.A01), Math.min(xb.A02 + i4, x7.A03));
                    x6 = this.A06.A06.get(xb.A00);
                    if (x6 == null) {
                        x6 = this.A04;
                    }
                    sparseArray2 = xb.A09;
                    if (A08[0].charAt(28) != '0') {
                        throw new RuntimeException();
                    }
                    A08[3] = "";
                    while (i5 < sparseArray2.size()) {
                        iKeyAt = sparseArray2.keyAt(i5);
                        xcValueAt = sparseArray2.valueAt(i5);
                        x8 = this.A06.A07.get(iKeyAt);
                        if (x8 == null) {
                            x8 = this.A06.A05.get(iKeyAt);
                        }
                        if (x8 != null) {
                            z = x8.A01;
                            if (A08[3].length() != 0) {
                                A08[3] = "";
                                if (z) {
                                    paint = null;
                                } else {
                                    paint = this.A02;
                                }
                            } else if (z) {
                                paint = null;
                            } else {
                                paint = this.A02;
                            }
                            A0B(x8, x6, xb.A01, i3 + xcValueAt.A02, i4 + xcValueAt.A05, paint, this.A01);
                        }
                    }
                    if (!xb.A0A) {
                        if (xb.A01 == 3) {
                            i6 = x6.A03[xb.A07];
                        } else if (xb.A01 == 2) {
                            i6 = x6.A02[xb.A06];
                        } else {
                            i6 = x6.A01[xb.A05];
                        }
                        this.A03.setColor(i6);
                        this.A01.drawRect(i3, i4, xb.A08 + i3, xb.A02 + i4, this.A03);
                    }
                    arrayList.add(new C2245cY().A0D(Bitmap.createBitmap(this.A00, i3, i4, xb.A08, xb.A02)).A04(i3 / x7.A05).A0A(0).A07(i4 / x7.A00, 0).A09(0).A06(xb.A08 / x7.A05).A03(xb.A02 / x7.A00).A0H());
                    this.A01.drawColor(0, PorterDuff.Mode.CLEAR);
                    this.A01.restore();
                    i2++;
                }
            }
            return Collections.unmodifiableList(arrayList);
        }
        A08[0] = "QEXYghJAG1js24i29eraFrLddLmVMhqI";
        if (bitmap != null) {
            if (x7.A05 + 1 == this.A00.getWidth()) {
            }
        }
        arrayList = new ArrayList();
        sparseArray = x9.A03;
        i2 = 0;
        while (true) {
            size = sparseArray.size();
            if (A08[0].charAt(28) != '0') {
                A08[0] = "yo8SPYAH6dKQEHTbCxocPMd5Ujl9JVv5";
                if (i2 >= size) {
                    break;
                    break;
                }
                this.A01.save();
                XA xaValueAt3 = sparseArray.valueAt(i2);
                xb = this.A06.A08.get(sparseArray.keyAt(i2));
                i3 = xaValueAt3.A00 + x7.A02;
                i4 = xaValueAt3.A01 + x7.A04;
                this.A01.clipRect(i3, i4, Math.min(xb.A08 + i3, x7.A01), Math.min(xb.A02 + i4, x7.A03));
                x6 = this.A06.A06.get(xb.A00);
                if (x6 == null) {
                    x6 = this.A04;
                }
                sparseArray2 = xb.A09;
                if (A08[0].charAt(28) != '0') {
                    throw new RuntimeException();
                }
                A08[3] = "";
                while (i5 < sparseArray2.size()) {
                    iKeyAt = sparseArray2.keyAt(i5);
                    xcValueAt = sparseArray2.valueAt(i5);
                    x8 = this.A06.A07.get(iKeyAt);
                    if (x8 == null) {
                        x8 = this.A06.A05.get(iKeyAt);
                    }
                    if (x8 != null) {
                        z = x8.A01;
                        if (A08[3].length() != 0) {
                            A08[3] = "";
                            if (z) {
                                paint = null;
                            } else {
                                paint = this.A02;
                            }
                        } else if (z) {
                            paint = null;
                        } else {
                            paint = this.A02;
                        }
                        A0B(x8, x6, xb.A01, i3 + xcValueAt.A02, i4 + xcValueAt.A05, paint, this.A01);
                    }
                }
                if (!xb.A0A) {
                    if (xb.A01 == 3) {
                        i6 = x6.A03[xb.A07];
                    } else if (xb.A01 == 2) {
                        i6 = x6.A02[xb.A06];
                    } else {
                        i6 = x6.A01[xb.A05];
                    }
                    this.A03.setColor(i6);
                    this.A01.drawRect(i3, i4, xb.A08 + i3, xb.A02 + i4, this.A03);
                }
                arrayList.add(new C2245cY().A0D(Bitmap.createBitmap(this.A00, i3, i4, xb.A08, xb.A02)).A04(i3 / x7.A05).A0A(0).A07(i4 / x7.A00, 0).A09(0).A06(xb.A08 / x7.A05).A03(xb.A02 / x7.A00).A0H());
                this.A01.drawColor(0, PorterDuff.Mode.CLEAR);
                this.A01.restore();
                i2++;
            } else {
                A08[3] = "";
                if (i2 >= size) {
                    break;
                    break;
                }
                this.A01.save();
                XA xaValueAt4 = sparseArray.valueAt(i2);
                xb = this.A06.A08.get(sparseArray.keyAt(i2));
                i3 = xaValueAt4.A00 + x7.A02;
                i4 = xaValueAt4.A01 + x7.A04;
                this.A01.clipRect(i3, i4, Math.min(xb.A08 + i3, x7.A01), Math.min(xb.A02 + i4, x7.A03));
                x6 = this.A06.A06.get(xb.A00);
                if (x6 == null) {
                    x6 = this.A04;
                }
                sparseArray2 = xb.A09;
                if (A08[0].charAt(28) != '0') {
                    throw new RuntimeException();
                }
                A08[3] = "";
                while (i5 < sparseArray2.size()) {
                    iKeyAt = sparseArray2.keyAt(i5);
                    xcValueAt = sparseArray2.valueAt(i5);
                    x8 = this.A06.A07.get(iKeyAt);
                    if (x8 == null) {
                        x8 = this.A06.A05.get(iKeyAt);
                    }
                    if (x8 != null) {
                        z = x8.A01;
                        if (A08[3].length() != 0) {
                            A08[3] = "";
                            if (z) {
                                paint = null;
                            } else {
                                paint = this.A02;
                            }
                        } else if (z) {
                            paint = null;
                        } else {
                            paint = this.A02;
                        }
                        A0B(x8, x6, xb.A01, i3 + xcValueAt.A02, i4 + xcValueAt.A05, paint, this.A01);
                    }
                }
                if (!xb.A0A) {
                    if (xb.A01 == 3) {
                        i6 = x6.A03[xb.A07];
                    } else if (xb.A01 == 2) {
                        i6 = x6.A02[xb.A06];
                    } else {
                        i6 = x6.A01[xb.A05];
                    }
                    this.A03.setColor(i6);
                    this.A01.drawRect(i3, i4, xb.A08 + i3, xb.A02 + i4, this.A03);
                }
                arrayList.add(new C2245cY().A0D(Bitmap.createBitmap(this.A00, i3, i4, xb.A08, xb.A02)).A04(i3 / x7.A05).A0A(0).A07(i4 / x7.A00, 0).A09(0).A06(xb.A08 / x7.A05).A03(xb.A02 / x7.A00).A0H());
                this.A01.drawColor(0, PorterDuff.Mode.CLEAR);
                this.A01.restore();
                i2++;
            }
        }
        return Collections.unmodifiableList(arrayList);
        this.A00 = Bitmap.createBitmap(x7.A05 + 1, x7.A00 + 1, Bitmap.Config.ARGB_8888);
        this.A01.setBitmap(this.A00);
        arrayList = new ArrayList();
        sparseArray = x9.A03;
        i2 = 0;
        while (true) {
            size = sparseArray.size();
            if (A08[0].charAt(28) != '0') {
                A08[0] = "yo8SPYAH6dKQEHTbCxocPMd5Ujl9JVv5";
                if (i2 >= size) {
                    break;
                    break;
                }
                this.A01.save();
                XA xaValueAt5 = sparseArray.valueAt(i2);
                xb = this.A06.A08.get(sparseArray.keyAt(i2));
                i3 = xaValueAt5.A00 + x7.A02;
                i4 = xaValueAt5.A01 + x7.A04;
                this.A01.clipRect(i3, i4, Math.min(xb.A08 + i3, x7.A01), Math.min(xb.A02 + i4, x7.A03));
                x6 = this.A06.A06.get(xb.A00);
                if (x6 == null) {
                    x6 = this.A04;
                }
                sparseArray2 = xb.A09;
                if (A08[0].charAt(28) != '0') {
                    throw new RuntimeException();
                }
                A08[3] = "";
                while (i5 < sparseArray2.size()) {
                    iKeyAt = sparseArray2.keyAt(i5);
                    xcValueAt = sparseArray2.valueAt(i5);
                    x8 = this.A06.A07.get(iKeyAt);
                    if (x8 == null) {
                        x8 = this.A06.A05.get(iKeyAt);
                    }
                    if (x8 != null) {
                        z = x8.A01;
                        if (A08[3].length() != 0) {
                            A08[3] = "";
                            if (z) {
                                paint = null;
                            } else {
                                paint = this.A02;
                            }
                        } else if (z) {
                            paint = null;
                        } else {
                            paint = this.A02;
                        }
                        A0B(x8, x6, xb.A01, i3 + xcValueAt.A02, i4 + xcValueAt.A05, paint, this.A01);
                    }
                }
                if (!xb.A0A) {
                    if (xb.A01 == 3) {
                        i6 = x6.A03[xb.A07];
                    } else if (xb.A01 == 2) {
                        i6 = x6.A02[xb.A06];
                    } else {
                        i6 = x6.A01[xb.A05];
                    }
                    this.A03.setColor(i6);
                    this.A01.drawRect(i3, i4, xb.A08 + i3, xb.A02 + i4, this.A03);
                }
                arrayList.add(new C2245cY().A0D(Bitmap.createBitmap(this.A00, i3, i4, xb.A08, xb.A02)).A04(i3 / x7.A05).A0A(0).A07(i4 / x7.A00, 0).A09(0).A06(xb.A08 / x7.A05).A03(xb.A02 / x7.A00).A0H());
                this.A01.drawColor(0, PorterDuff.Mode.CLEAR);
                this.A01.restore();
                i2++;
            } else {
                A08[3] = "";
                if (i2 >= size) {
                    break;
                    break;
                }
                this.A01.save();
                XA xaValueAt6 = sparseArray.valueAt(i2);
                xb = this.A06.A08.get(sparseArray.keyAt(i2));
                i3 = xaValueAt6.A00 + x7.A02;
                i4 = xaValueAt6.A01 + x7.A04;
                this.A01.clipRect(i3, i4, Math.min(xb.A08 + i3, x7.A01), Math.min(xb.A02 + i4, x7.A03));
                x6 = this.A06.A06.get(xb.A00);
                if (x6 == null) {
                    x6 = this.A04;
                }
                sparseArray2 = xb.A09;
                if (A08[0].charAt(28) != '0') {
                    throw new RuntimeException();
                }
                A08[3] = "";
                while (i5 < sparseArray2.size()) {
                    iKeyAt = sparseArray2.keyAt(i5);
                    xcValueAt = sparseArray2.valueAt(i5);
                    x8 = this.A06.A07.get(iKeyAt);
                    if (x8 == null) {
                        x8 = this.A06.A05.get(iKeyAt);
                    }
                    if (x8 != null) {
                        z = x8.A01;
                        if (A08[3].length() != 0) {
                            A08[3] = "";
                            if (z) {
                                paint = null;
                            } else {
                                paint = this.A02;
                            }
                        } else if (z) {
                            paint = null;
                        } else {
                            paint = this.A02;
                        }
                        A0B(x8, x6, xb.A01, i3 + xcValueAt.A02, i4 + xcValueAt.A05, paint, this.A01);
                    }
                }
                if (!xb.A0A) {
                    if (xb.A01 == 3) {
                        i6 = x6.A03[xb.A07];
                    } else if (xb.A01 == 2) {
                        i6 = x6.A02[xb.A06];
                    } else {
                        i6 = x6.A01[xb.A05];
                    }
                    this.A03.setColor(i6);
                    this.A01.drawRect(i3, i4, xb.A08 + i3, xb.A02 + i4, this.A03);
                }
                arrayList.add(new C2245cY().A0D(Bitmap.createBitmap(this.A00, i3, i4, xb.A08, xb.A02)).A04(i3 / x7.A05).A0A(0).A07(i4 / x7.A00, 0).A09(0).A06(xb.A08 / x7.A05).A03(xb.A02 / x7.A00).A0H());
                this.A01.drawColor(0, PorterDuff.Mode.CLEAR);
                this.A01.restore();
                i2++;
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    static {
        A0A();
        A09 = new byte[]{0, 7, 8, Ascii.SI};
        A0A = new byte[]{0, 119, -120, -1};
        A0B = new byte[]{0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    }

    public XE(int i, int i2) {
        this.A02.setStyle(Paint.Style.FILL_AND_STROKE);
        this.A02.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.A02.setPathEffect(null);
        this.A03 = new Paint();
        this.A03.setStyle(Paint.Style.FILL);
        this.A03.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.A03.setPathEffect(null);
        this.A01 = new Canvas();
        this.A05 = new X7(719, 575, 0, 719, 0, 575);
        this.A04 = new X6(0, A0F(), A0G(), A0H());
        this.A06 = new XD(i, i2);
    }

    public static int A00(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    public static int A01(C2446fp c2446fp, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        boolean z = false;
        do {
            int runLength = 0;
            if (A08[3].length() != 0) {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[2] = "nWzirQr";
            strArr[6] = "Cla0GqFoswjTn2ioQMTrmjR";
            int iA04 = c2446fp.A04(2);
            if (iA04 != 0) {
                runLength = 1;
            } else if (c2446fp.A0H()) {
                runLength = c2446fp.A04(3) + 3;
                iA04 = c2446fp.A04(2);
            } else if (c2446fp.A0H()) {
                runLength = 1;
                iA04 = 0;
            } else {
                switch (c2446fp.A04(2)) {
                    case 0:
                        z = true;
                        iA04 = 0;
                        break;
                    case 1:
                        runLength = 2;
                        iA04 = 0;
                        break;
                    case 2:
                        runLength = c2446fp.A04(4) + 12;
                        iA04 = c2446fp.A04(2);
                        break;
                    case 3:
                        runLength = c2446fp.A04(8) + 29;
                        iA04 = c2446fp.A04(2);
                        break;
                    default:
                        iA04 = 0;
                        break;
                }
            }
            if (runLength != 0 && paint != null) {
                if (bArr != null) {
                    iA04 = bArr[iA04];
                }
                paint.setColor(iArr[iA04]);
                canvas.drawRect(i, i2, i + runLength, i2 + 1, paint);
            }
            i += runLength;
        } while (!z);
        return i;
    }

    public static int A02(C2446fp c2446fp, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        boolean z = false;
        do {
            int iA04 = 0;
            int iA05 = c2446fp.A04(4);
            if (iA05 != 0) {
                iA04 = 1;
            } else if (!c2446fp.A0H()) {
                int iA06 = c2446fp.A04(3);
                if (iA06 != 0) {
                    iA04 = iA06 + 2;
                    iA05 = 0;
                } else {
                    z = true;
                    iA05 = 0;
                }
            } else if (!c2446fp.A0H()) {
                iA04 = c2446fp.A04(2) + 4;
                iA05 = c2446fp.A04(4);
            } else {
                switch (c2446fp.A04(2)) {
                    case 0:
                        iA04 = 1;
                        iA05 = 0;
                        break;
                    case 1:
                        iA04 = 2;
                        iA05 = 0;
                        break;
                    case 2:
                        iA04 = c2446fp.A04(4) + 9;
                        iA05 = c2446fp.A04(4);
                        break;
                    case 3:
                        iA04 = c2446fp.A04(8) + 25;
                        iA05 = c2446fp.A04(4);
                        break;
                    default:
                        iA05 = 0;
                        break;
                }
            }
            if (iA04 != 0 && paint != null) {
                if (bArr != null) {
                    iA05 = bArr[iA05];
                }
                paint.setColor(iArr[iA05]);
                canvas.drawRect(i, i2, i + iA04, i2 + 1, paint);
            }
            i += iA04;
        } while (!z);
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0065  */
    /* JADX WARN: Code duplicated, block: B:26:0x0071  */
    /* JADX WARN: Code duplicated, block: B:28:0x0081  */
    /* JADX WARN: Code duplicated, block: B:29:0x008b  */
    public static int A03(C2446fp c2446fp, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int iA04;
        int i3 = i;
        boolean z = false;
        while (A08[0].charAt(28) != '0') {
            String[] strArr = A08;
            strArr[2] = "RPr3iSh";
            strArr[6] = "mmnyY9nEiTFwLEV0VaqWLpi";
            int iA05 = c2446fp.A04(8);
            if (iA05 != 0) {
                iA04 = 1;
            } else if (!c2446fp.A0H()) {
                iA04 = c2446fp.A04(7);
                if (A08[3].length() != 0) {
                    if (iA04 != 0) {
                        iA05 = 0;
                    } else {
                        z = true;
                        if (A08[0].charAt(28) != '0') {
                            A08[0] = "JR2PXvDBNiT4Go9AEf7iO44JeiKvjv0y";
                            iA04 = 0;
                            iA05 = 0;
                        } else {
                            String[] strArr2 = A08;
                            strArr2[2] = "8kbkRhN";
                            strArr2[6] = "0VH0XTauscYbLoQ5guVPnmN";
                            iA04 = 0;
                            iA05 = 0;
                        }
                    }
                } else {
                    A08[0] = "JW2AP1Va5d4lvQWKw62GBHvBi0bUtjOb";
                    if (iA04 != 0) {
                        iA05 = 0;
                    } else {
                        z = true;
                        if (A08[0].charAt(28) != '0') {
                            A08[0] = "JR2PXvDBNiT4Go9AEf7iO44JeiKvjv0y";
                            iA04 = 0;
                            iA05 = 0;
                        } else {
                            String[] strArr3 = A08;
                            strArr3[2] = "8kbkRhN";
                            strArr3[6] = "0VH0XTauscYbLoQ5guVPnmN";
                            iA04 = 0;
                            iA05 = 0;
                        }
                    }
                }
            } else {
                iA04 = c2446fp.A04(7);
                iA05 = c2446fp.A04(8);
                String[] strArr4 = A08;
                if (strArr4[7].charAt(1) != strArr4[4].charAt(1)) {
                    String[] strArr5 = A08;
                    strArr5[5] = "aBxLcRDW2Dv0MXG0NbRPKMo3h9mqw9Iy";
                    strArr5[1] = "6PwvVbnmXFynah963SyEDLjdgI4kxqKF";
                } else {
                    A08[0] = "h921C7KiufzecLg4ijQNvu8ZqESpn573";
                }
            }
            if (iA04 != 0 && paint != null) {
                if (bArr != null) {
                    iA05 = bArr[iA05];
                }
                paint.setColor(iArr[iA05]);
                canvas.drawRect(i3, i2, i3 + iA04, i2 + 1, paint);
            }
            i3 += iA04;
            if (z) {
                return i3;
            }
        }
        throw new RuntimeException();
    }

    public static X8 A06(C2446fp c2446fp) {
        int iA04 = c2446fp.A04(16);
        c2446fp.A09(4);
        int objectId = c2446fp.A04(2);
        boolean zA0H = c2446fp.A0H();
        c2446fp.A09(1);
        byte[] bArr = AbstractC2471gE.A07;
        byte[] bArr2 = AbstractC2471gE.A07;
        if (objectId == 1) {
            int numberOfCodes = c2446fp.A04(8);
            c2446fp.A09(numberOfCodes * 16);
        } else if (objectId == 0) {
            int objectCodingMethod = c2446fp.A04(16);
            int objectId2 = c2446fp.A04(16);
            if (objectCodingMethod > 0) {
                bArr = new byte[objectCodingMethod];
                c2446fp.A0G(bArr, 0, objectCodingMethod);
            }
            if (objectId2 > 0) {
                bArr2 = new byte[objectId2];
                c2446fp.A0G(bArr2, 0, objectId2);
            } else {
                bArr2 = bArr;
            }
        }
        return new X8(iA04, zA0H, bArr, bArr2);
    }

    public static X9 A07(C2446fp c2446fp, int i) {
        int iA04 = c2446fp.A04(8);
        int iA05 = c2446fp.A04(4);
        int iA06 = c2446fp.A04(2);
        c2446fp.A09(2);
        int i2 = i - 2;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int remainingLength = c2446fp.A04(8);
            c2446fp.A09(8);
            int version = c2446fp.A04(16);
            int timeoutSecs = c2446fp.A04(16);
            i2 -= 6;
            sparseArray.put(remainingLength, new XA(version, timeoutSecs));
        }
        return new X9(iA04, iA05, iA06, sparseArray);
    }

    public static void A0B(X8 x8, X6 x6, int i, int i2, int i3, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i == 3) {
            iArr = x6.A03;
        } else if (i == 2) {
            iArr = x6.A02;
        } else {
            iArr = x6.A01;
        }
        A0D(x8.A03, iArr, i, i2, i3, paint, canvas);
        A0D(x8.A02, iArr, i, i2, i3 + 1, paint, canvas);
        String[] strArr = A08;
        if (strArr[5].charAt(31) == strArr[1].charAt(31)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[2] = "24tCzYY";
        strArr2[6] = "UgY6TZfrXiaaMkQCR3ibsXD";
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0096  */
    /* JADX WARN: Code duplicated, block: B:21:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a9  */
    public static void A0C(C2446fp c2446fp, XD xd) {
        int segmentType;
        int iA04 = c2446fp.A04(8);
        int iA05 = c2446fp.A04(16);
        int pageId = c2446fp.A04(16);
        int dataFieldLimit = c2446fp.A02() + pageId;
        int dataFieldLength = pageId * 8;
        int segmentType2 = c2446fp.A01();
        if (dataFieldLength > segmentType2) {
            AbstractC2432fb.A07(A09(31, 9, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), A09(0, 31, 91));
            int segmentType3 = c2446fp.A01();
            c2446fp.A09(segmentType3);
            return;
        }
        switch (iA04) {
            case 16:
                int segmentType4 = xd.A03;
                if (iA05 == segmentType4) {
                    X9 x9 = xd.A01;
                    X9 x9A07 = A07(c2446fp, pageId);
                    int segmentType5 = x9A07.A00;
                    if (segmentType5 != 0) {
                        xd.A01 = x9A07;
                        xd.A08.clear();
                        xd.A06.clear();
                        xd.A07.clear();
                    } else if (x9 != null) {
                        int dataFieldLength2 = x9.A02;
                        int segmentType6 = x9A07.A02;
                        if (dataFieldLength2 != segmentType6) {
                            xd.A01 = x9A07;
                        }
                    }
                }
                break;
            case 17:
                X9 x10 = xd.A01;
                int segmentType7 = xd.A03;
                if (iA05 == segmentType7 && x10 != null) {
                    XB xbA08 = A08(c2446fp, pageId);
                    int segmentType8 = x10.A00;
                    if (segmentType8 == 0) {
                        SparseArray<XB> sparseArray = xd.A08;
                        int segmentType9 = xbA08.A03;
                        XB xb = sparseArray.get(segmentType9);
                        if (xb != null) {
                            xbA08.A00(xb);
                        }
                    }
                    SparseArray<XB> sparseArray2 = xd.A08;
                    int segmentType10 = xbA08.A03;
                    sparseArray2.put(segmentType10, xbA08);
                }
                break;
            case 18:
                int segmentType11 = xd.A03;
                if (iA05 == segmentType11) {
                    X6 x6A04 = A04(c2446fp, pageId);
                    SparseArray<X6> sparseArray3 = xd.A06;
                    int segmentType12 = x6A04.A00;
                    sparseArray3.put(segmentType12, x6A04);
                } else {
                    int segmentType13 = xd.A02;
                    if (iA05 == segmentType13) {
                        X6 x6A05 = A04(c2446fp, pageId);
                        SparseArray<X6> sparseArray4 = xd.A04;
                        int segmentType14 = x6A05.A00;
                        sparseArray4.put(segmentType14, x6A05);
                    }
                }
                break;
            case 19:
                int i = xd.A03;
                String[] strArr = A08;
                String str = strArr[5];
                String str2 = strArr[1];
                int dataFieldLength3 = str.charAt(31);
                int segmentType15 = str2.charAt(31);
                if (dataFieldLength3 != segmentType15) {
                    String[] strArr2 = A08;
                    strArr2[2] = "4chUtLt";
                    strArr2[6] = "Q6MdXQCZRTNI7bkO8A5Gaoi";
                    if (iA05 == i) {
                        X8 x8A06 = A06(c2446fp);
                        SparseArray<X8> sparseArray5 = xd.A07;
                        int segmentType16 = x8A06.A00;
                        sparseArray5.put(segmentType16, x8A06);
                    } else {
                        segmentType = xd.A02;
                        if (iA05 == segmentType) {
                            X8 x8A07 = A06(c2446fp);
                            SparseArray<X8> sparseArray6 = xd.A05;
                            int segmentType17 = x8A07.A00;
                            sparseArray6.put(segmentType17, x8A07);
                        }
                    }
                } else if (iA05 == i) {
                    X8 x8A08 = A06(c2446fp);
                    SparseArray<X8> sparseArray7 = xd.A07;
                    int segmentType18 = x8A08.A00;
                    sparseArray7.put(segmentType18, x8A08);
                } else {
                    segmentType = xd.A02;
                    if (iA05 == segmentType) {
                        X8 x8A09 = A06(c2446fp);
                        SparseArray<X8> sparseArray8 = xd.A05;
                        int segmentType19 = x8A09.A00;
                        sparseArray8.put(segmentType19, x8A09);
                    }
                }
                break;
            case 20:
                int i2 = xd.A03;
                String[] strArr3 = A08;
                String str3 = strArr3[5];
                String str4 = strArr3[1];
                int dataFieldLength4 = str3.charAt(31);
                int segmentType20 = str4.charAt(31);
                if (dataFieldLength4 == segmentType20) {
                    throw new RuntimeException();
                }
                String[] strArr4 = A08;
                strArr4[7] = "ochpV7eecJX6Y83FzP4r6s4rrFYIe851";
                strArr4[4] = "Nrp1f8eQvUjtDGoRP4vywaCDjBEw4DvZ";
                if (iA05 == i2) {
                    xd.A00 = A05(c2446fp);
                }
                break;
                break;
        }
        int segmentType21 = c2446fp.A02();
        c2446fp.A0A(dataFieldLimit - segmentType21);
    }

    public static void A0D(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        int i4 = i3;
        C2446fp c2446fp = new C2446fp(bArr);
        byte[] clutMapTable2To8 = null;
        byte[] clutMapTable2To4 = null;
        byte[] bArrA0E = null;
        int line = i2;
        while (c2446fp.A01() != 0) {
            switch (c2446fp.A04(8)) {
                case 16:
                    if (i == 3) {
                        bArr2 = clutMapTable2To4 == null ? A0A : clutMapTable2To4;
                    } else if (i == 2) {
                        bArr2 = clutMapTable2To8 == null ? A09 : clutMapTable2To8;
                    } else {
                        bArr2 = null;
                    }
                    line = A01(c2446fp, iArr, bArr2, line, i4, paint, canvas);
                    c2446fp.A06();
                    break;
                case 17:
                    if (i == 3) {
                        bArr3 = bArrA0E == null ? A0B : bArrA0E;
                    } else {
                        bArr3 = null;
                    }
                    line = A02(c2446fp, iArr, bArr3, line, i4, paint, canvas);
                    c2446fp.A06();
                    break;
                case 18:
                    line = A03(c2446fp, iArr, null, line, i4, paint, canvas);
                    break;
                case 32:
                    clutMapTable2To8 = A0E(4, 4, c2446fp);
                    break;
                case 33:
                    clutMapTable2To4 = A0E(4, 8, c2446fp);
                    break;
                case 34:
                    bArrA0E = A0E(16, 8, c2446fp);
                    break;
                case 240:
                    i4 += 2;
                    line = i2;
                    break;
            }
        }
    }

    public static byte[] A0E(int i, int i2, C2446fp c2446fp) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) c2446fp.A04(i2);
        }
        return bArr;
    }

    public static int[] A0F() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    public static int[] A0G() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < iArr.length; i++) {
            if (i < 8) {
                int i2 = (i & 1) != 0 ? 255 : 0;
                int i3 = i & 2;
                if (A08[0].charAt(28) == '0') {
                    throw new RuntimeException();
                }
                String[] strArr = A08;
                strArr[5] = "kx4t5eQeHdC4Yc4pFTaPy19HDG208J4y";
                strArr[1] = "eKg8tV5nreQ9eRXYxGxdaqFNP9wqRVRp";
                iArr[i] = A00(255, i2, i3 != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                int i4 = (i & 1) != 0 ? 127 : 0;
                iArr[i] = A00(255, i4, (i & 2) != 0 ? 127 : 0, (i & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    public static int[] A0H() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < iArr.length; i++) {
            if (i < 8) {
                int i2 = (i & 1) != 0 ? 255 : 0;
                iArr[i] = A00(63, i2, (i & 2) != 0 ? 255 : 0, (i & 4) == 0 ? 0 : 255);
            } else {
                switch (i & 136) {
                    case 0:
                        int i3 = (i & 1) != 0 ? 85 : 0;
                        iArr[i] = A00(255, i3 + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                        continue;
                    case 8:
                        int i4 = i & 1;
                        String[] strArr = A08;
                        if (strArr[5].charAt(31) != strArr[1].charAt(31)) {
                            A08[3] = "";
                            int i5 = i4 != 0 ? 85 : 0;
                            iArr[i] = A00(127, i5 + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                        }
                        break;
                    case 128:
                        int i6 = i & 1;
                        String[] strArr2 = A08;
                        if (strArr2[7].charAt(1) != strArr2[4].charAt(1)) {
                            A08[3] = "";
                            int i7 = i6 != 0 ? 43 : 0;
                            iArr[i] = A00(255, i7 + 127 + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + 127 + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + 127 + ((i & 64) == 0 ? 0 : 85));
                            continue;
                        } else {
                            throw new RuntimeException();
                        }
                        break;
                    case 136:
                        int i8 = ((i & 1) != 0 ? 43 : 0) + ((i & 16) != 0 ? 85 : 0);
                        int i9 = ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0);
                        String[] strArr3 = A08;
                        if (strArr3[5].charAt(31) != strArr3[1].charAt(31)) {
                            String[] strArr4 = A08;
                            strArr4[2] = "EeiC7Ey";
                            strArr4[6] = "jckV3kZjND1Sm0wKRElfQvD";
                            iArr[i] = A00(255, i8, i9, ((i & 4) == 0 ? 0 : 43) + ((i & 64) == 0 ? 0 : 85));
                        }
                        break;
                    default:
                        continue;
                }
                throw new RuntimeException();
            }
        }
        return iArr;
    }

    public final void A0J() {
        this.A06.A00();
    }
}
