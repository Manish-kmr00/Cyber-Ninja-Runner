package com.fyber.inneractive.sdk.protobuf;

import com.google.common.base.Ascii;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public abstract class AbstractC3186g {
    public static int a(int i, byte[] bArr, int i2, C3183f c3183f) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            c3183f.f2283a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            c3183f.f2283a = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            c3183f.f2283a = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            c3183f.f2283a = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                c3183f.f2283a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static long b(int i, byte[] bArr) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static int c(byte[] bArr, int i, C3183f c3183f) {
        int iD = d(bArr, i, c3183f);
        int i2 = c3183f.f2283a;
        if (i2 < 0) {
            throw new C3211o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 == 0) {
            c3183f.c = "";
            return iD;
        }
        c3183f.c = E1.f2253a.a(bArr, iD, i2);
        return iD + i2;
    }

    public static int d(byte[] bArr, int i, C3183f c3183f) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return a(b, bArr, i2, c3183f);
        }
        c3183f.f2283a = b;
        return i2;
    }

    public static int e(byte[] bArr, int i, C3183f c3183f) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            c3183f.b = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & 127)) << i4;
            b = b2;
            i3 = i5;
        }
        c3183f.b = j2;
        return i3;
    }

    public static int b(byte[] bArr, int i, C3183f c3183f) {
        int iD = d(bArr, i, c3183f);
        int i2 = c3183f.f2283a;
        if (i2 < 0) {
            throw new C3211o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 == 0) {
            c3183f.c = "";
            return iD;
        }
        c3183f.c = new String(bArr, iD, i2, AbstractC3205m0.f2291a);
        return iD + i2;
    }

    public static int c(int i, byte[] bArr, int i2, int i3, InterfaceC3202l0 interfaceC3202l0, C3183f c3183f) {
        C3172b0 c3172b0 = (C3172b0) interfaceC3202l0;
        int iD = d(bArr, i2, c3183f);
        c3172b0.c(c3183f.f2283a);
        while (iD < i3) {
            int iA = iD + 1;
            byte b = bArr[iD];
            if (b >= 0) {
                c3183f.f2283a = b;
            } else {
                iA = a(b, bArr, iA, c3183f);
            }
            if (i != c3183f.f2283a) {
                break;
            }
            iD = iA + 1;
            byte b2 = bArr[iA];
            if (b2 >= 0) {
                c3183f.f2283a = b2;
            } else {
                iD = a(b2, bArr, iD, c3183f);
            }
            c3172b0.c(c3183f.f2283a);
        }
        return iD;
    }

    public static int b(int i, byte[] bArr, int i2, int i3, InterfaceC3202l0 interfaceC3202l0, C3183f c3183f) throws C3211o0 {
        int iD = d(bArr, i2, c3183f);
        int i4 = c3183f.f2283a;
        if (i4 < 0) {
            throw new C3211o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i4 == 0) {
            interfaceC3202l0.add("");
        } else {
            int i5 = iD + i4;
            if (E1.f2253a.b(bArr, iD, i5)) {
                interfaceC3202l0.add(new String(bArr, iD, i4, AbstractC3205m0.f2291a));
                iD = i5;
            } else {
                throw new C3211o0("Protocol message had invalid UTF-8.");
            }
        }
        while (iD < i3) {
            int iA = iD + 1;
            byte b = bArr[iD];
            if (b >= 0) {
                c3183f.f2283a = b;
            } else {
                iA = a(b, bArr, iA, c3183f);
            }
            if (i != c3183f.f2283a) {
                break;
            }
            iD = iA + 1;
            byte b2 = bArr[iA];
            if (b2 >= 0) {
                c3183f.f2283a = b2;
            } else {
                iD = a(b2, bArr, iD, c3183f);
            }
            int i6 = c3183f.f2283a;
            if (i6 < 0) {
                throw new C3211o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i6 == 0) {
                interfaceC3202l0.add("");
            } else {
                int i7 = iD + i6;
                if (E1.f2253a.b(bArr, iD, i7)) {
                    interfaceC3202l0.add(new String(bArr, iD, i6, AbstractC3205m0.f2291a));
                    iD = i7;
                } else {
                    throw new C3211o0("Protocol message had invalid UTF-8.");
                }
            }
        }
        return iD;
    }

    public static int a(int i, byte[] bArr, int i2, int i3, C3212o1 c3212o1, C3183f c3183f) {
        if ((i >>> 3) == 0) {
            throw new C3211o0("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iE = e(bArr, i2, c3183f);
            c3212o1.a(i, Long.valueOf(c3183f.b));
            return iE;
        }
        if (i4 == 1) {
            c3212o1.a(i, Long.valueOf(b(i2, bArr)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iD = d(bArr, i2, c3183f);
            int i5 = c3183f.f2283a;
            if (i5 >= 0) {
                if (i5 > bArr.length - iD) {
                    throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                if (i5 == 0) {
                    c3212o1.a(i, AbstractC3221s.b);
                } else {
                    AbstractC3221s.a(iD, iD + i5, bArr.length);
                    c3212o1.a(i, new C3216q(AbstractC3221s.c.a(bArr, iD, i5)));
                }
                return iD + i5;
            }
            throw new C3211o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new C3211o0("Protocol message contained an invalid tag (zero).");
            }
            c3212o1.a(i, Integer.valueOf(a(i2, bArr)));
            return i2 + 4;
        }
        C3212o1 c3212o2 = new C3212o1();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (i2 < i3) {
            int iD2 = d(bArr, i2, c3183f);
            int i8 = c3183f.f2283a;
            if (i8 == i6) {
                i7 = i8;
                i2 = iD2;
                break;
            }
            i7 = i8;
            i2 = a(i8, bArr, iD2, i3, c3212o2, c3183f);
        }
        if (i2 <= i3 && i7 == i6) {
            c3212o1.a(i, c3212o2);
            return i2;
        }
        throw new C3211o0("Failed to parse the message.");
    }

    public static int a(int i, byte[] bArr, int i2, int i3, C3183f c3183f) {
        if ((i >>> 3) == 0) {
            throw new C3211o0("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return e(bArr, i2, c3183f);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return d(bArr, i2, c3183f) + c3183f.f2283a;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw new C3211o0("Protocol message contained an invalid tag (zero).");
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = d(bArr, i2, c3183f);
            i6 = c3183f.f2283a;
            if (i6 == i5) {
                break;
            }
            i2 = a(i6, bArr, i2, i3, c3183f);
        }
        if (i2 > i3 || i6 != i5) {
            throw new C3211o0("Failed to parse the message.");
        }
        return i2;
    }

    public static int a(int i, byte[] bArr) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int a(byte[] bArr, int i, C3183f c3183f) {
        int iD = d(bArr, i, c3183f);
        int i2 = c3183f.f2283a;
        if (i2 >= 0) {
            if (i2 > bArr.length - iD) {
                throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i2 == 0) {
                c3183f.c = AbstractC3221s.b;
                return iD;
            }
            int i3 = iD + i2;
            AbstractC3221s.a(iD, i3, bArr.length);
            c3183f.c = new C3216q(AbstractC3221s.c.a(bArr, iD, i2));
            return i3;
        }
        throw new C3211o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static int a(U0 u0, byte[] bArr, int i, int i2, C3183f c3183f) {
        int iA = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iA = a(i3, bArr, iA, c3183f);
            i3 = c3183f.f2283a;
        }
        int i4 = iA;
        if (i3 >= 0 && i3 <= i2 - i4) {
            Object objA = u0.a();
            int i5 = i3 + i4;
            u0.a(objA, bArr, i4, i5, c3183f);
            u0.c(objA);
            c3183f.c = objA;
            return i5;
        }
        throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int a(U0 u0, byte[] bArr, int i, int i2, int i3, C3183f c3183f) {
        J0 j0 = (J0) u0;
        Object objA = j0.a();
        int iA = j0.a(objA, bArr, i, i2, i3, c3183f);
        j0.c(objA);
        c3183f.c = objA;
        return iA;
    }

    public static int a(byte[] bArr, int i, InterfaceC3202l0 interfaceC3202l0, C3183f c3183f) {
        C3172b0 c3172b0 = (C3172b0) interfaceC3202l0;
        int iD = d(bArr, i, c3183f);
        int i2 = c3183f.f2283a + iD;
        while (iD < i2) {
            int i3 = iD + 1;
            byte b = bArr[iD];
            if (b >= 0) {
                c3183f.f2283a = b;
                iD = i3;
            } else {
                iD = a(b, bArr, i3, c3183f);
            }
            c3172b0.c(c3183f.f2283a);
        }
        if (iD == i2) {
            return iD;
        }
        throw new C3211o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int a(int i, byte[] bArr, int i2, int i3, InterfaceC3202l0 interfaceC3202l0, C3183f c3183f) throws C3211o0 {
        int iD = d(bArr, i2, c3183f);
        int i4 = c3183f.f2283a;
        if (i4 < 0) {
            throw new C3211o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i4 == 0) {
            interfaceC3202l0.add("");
        } else {
            interfaceC3202l0.add(new String(bArr, iD, i4, AbstractC3205m0.f2291a));
            iD += i4;
        }
        while (iD < i3) {
            int iA = iD + 1;
            byte b = bArr[iD];
            if (b >= 0) {
                c3183f.f2283a = b;
            } else {
                iA = a(b, bArr, iA, c3183f);
            }
            if (i != c3183f.f2283a) {
                break;
            }
            iD = iA + 1;
            byte b2 = bArr[iA];
            if (b2 >= 0) {
                c3183f.f2283a = b2;
            } else {
                iD = a(b2, bArr, iD, c3183f);
            }
            int i5 = c3183f.f2283a;
            if (i5 < 0) {
                throw new C3211o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i5 == 0) {
                interfaceC3202l0.add("");
            } else {
                interfaceC3202l0.add(new String(bArr, iD, i5, AbstractC3205m0.f2291a));
                iD += i5;
            }
        }
        return iD;
    }
}
