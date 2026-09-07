package io.bidmachine.iab.utils;

import com.google.common.base.Ascii;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes9.dex */
public class Base32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f12229a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM};

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f12230a;
        byte[] b;
        int c;
        int d;
        boolean e;
        int f;

        private b() {
        }
    }

    private int a(int i, int i2) {
        int i3 = i - Integer.MIN_VALUE;
        int i4 = i2 - Integer.MIN_VALUE;
        if (i3 < i4) {
            return -1;
        }
        return i3 == i4 ? 0 : 1;
    }

    private int a(b bVar) {
        if (bVar.b != null) {
            return bVar.c - bVar.d;
        }
        return 0;
    }

    public String decode(final String encoded) {
        return decode(encoded.getBytes(Charset.forName("UTF-8")));
    }

    public String decode(final byte[] encodedBytes) {
        if (encodedBytes == null || encodedBytes.length == 0) {
            return new String(encodedBytes);
        }
        b bVar = new b();
        a(encodedBytes, 0, encodedBytes.length, bVar);
        a(encodedBytes, 0, -1, bVar);
        int i = bVar.c;
        byte[] bArr = new byte[i];
        a(bArr, i, bVar);
        return new String(bArr);
    }

    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v20 */
    private void a(byte[] bArr, int i, int i2, b bVar) {
        byte b2;
        if (bVar.e) {
            return;
        }
        ?? r3 = 1;
        if (i2 < 0) {
            bVar.e = true;
        }
        int i3 = 0;
        int i4 = i;
        while (i3 < i2) {
            int i5 = i4 + 1;
            byte b3 = bArr[i4];
            if (b3 == 61) {
                bVar.e = r3;
                break;
            }
            byte[] bArrA = a(7, bVar);
            if (b3 >= 0) {
                byte[] bArr2 = f12229a;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    int i6 = (bVar.f + r3) % 8;
                    bVar.f = i6;
                    long j = (bVar.f12230a << 5) + ((long) b2);
                    bVar.f12230a = j;
                    if (i6 == 0) {
                        int i7 = bVar.c;
                        bArrA[i7] = (byte) ((j >> 32) & 255);
                        bArrA[i7 + 1] = (byte) ((j >> 24) & 255);
                        bArrA[i7 + 2] = (byte) ((j >> 16) & 255);
                        bArrA[i7 + 3] = (byte) ((j >> 8) & 255);
                        bVar.c = i7 + 5;
                        bArrA[i7 + 4] = (byte) (j & 255);
                    }
                }
            }
            i3++;
            i4 = i5;
            r3 = 1;
        }
        if (!bVar.e || bVar.f <= 0) {
            return;
        }
        byte[] bArrA2 = a(7, bVar);
        switch (bVar.f) {
            case 1:
            case 2:
                int i8 = bVar.c;
                bVar.c = i8 + 1;
                bArrA2[i8] = (byte) ((bVar.f12230a >> 2) & 255);
                return;
            case 3:
                int i9 = bVar.c;
                bVar.c = i9 + 1;
                bArrA2[i9] = (byte) ((bVar.f12230a >> 7) & 255);
                return;
            case 4:
                long j2 = bVar.f12230a;
                long j3 = j2 >> 4;
                bVar.f12230a = j3;
                int i10 = bVar.c;
                bArrA2[i10] = (byte) ((j2 >> 12) & 255);
                bVar.c = i10 + 2;
                bArrA2[i10 + 1] = (byte) (j3 & 255);
                return;
            case 5:
                long j4 = bVar.f12230a;
                long j5 = j4 >> 1;
                bVar.f12230a = j5;
                int i11 = bVar.c;
                bArrA2[i11] = (byte) ((j4 >> 17) & 255);
                bArrA2[i11 + 1] = (byte) ((j4 >> 9) & 255);
                bVar.c = i11 + 3;
                bArrA2[i11 + 2] = (byte) (j5 & 255);
                return;
            case 6:
                long j6 = bVar.f12230a;
                long j7 = j6 >> 6;
                bVar.f12230a = j7;
                int i12 = bVar.c;
                bArrA2[i12] = (byte) ((j6 >> 22) & 255);
                bArrA2[i12 + 1] = (byte) ((j6 >> 14) & 255);
                bVar.c = i12 + 3;
                bArrA2[i12 + 2] = (byte) (j7 & 255);
                return;
            case 7:
                long j8 = bVar.f12230a;
                long j9 = j8 >> 3;
                bVar.f12230a = j9;
                int i13 = bVar.c;
                bArrA2[i13] = (byte) ((j8 >> 27) & 255);
                bArrA2[i13 + 1] = (byte) ((j8 >> 19) & 255);
                bArrA2[i13 + 2] = (byte) ((j8 >> 11) & 255);
                bVar.c = i13 + 4;
                bArrA2[i13 + 3] = (byte) (j9 & 255);
                return;
            default:
                throw new IllegalStateException("Impossible modulus " + bVar.f);
        }
    }

    private byte[] a(int i, b bVar) {
        byte[] bArr = bVar.b;
        if (bArr == null) {
            bVar.b = new byte[Math.max(i, 8192)];
            bVar.c = 0;
            bVar.d = 0;
        } else {
            int i2 = bVar.c + i;
            if (i2 - bArr.length > 0) {
                return a(bVar, i2);
            }
        }
        return bVar.b;
    }

    private void a(byte[] bArr, int i, b bVar) {
        if (bVar.b != null) {
            int iMin = Math.min(a(bVar), i);
            System.arraycopy(bVar.b, bVar.d, bArr, 0, iMin);
            int i2 = bVar.d + iMin;
            bVar.d = i2;
            if (i2 >= bVar.c) {
                bVar.b = null;
            }
        }
    }

    private byte[] a(b bVar, int i) {
        int length = bVar.b.length * 2;
        if (a(length, i) < 0) {
            length = i;
        }
        if (a(length, 2147483639) > 0) {
            length = Math.max(i, 2147483639);
        }
        byte[] bArr = new byte[length];
        byte[] bArr2 = bVar.b;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        bVar.b = bArr;
        return bArr;
    }
}
