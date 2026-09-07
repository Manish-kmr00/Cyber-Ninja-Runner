package com.fyber.inneractive.sdk.protobuf;

import com.amazon.device.ads.DtbConstants;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes13.dex */
public final class D1 extends A1 {
    public static int a(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            A1 a1 = E1.f2253a;
            if (i > -12) {
                return -1;
            }
            return i;
        }
        if (i2 == 1) {
            return E1.a(i, y1.c.b(bArr, y1.f + j));
        }
        if (i2 != 2) {
            throw new AssertionError();
        }
        x1 x1Var = y1.c;
        long j2 = y1.f;
        return E1.a(i, x1Var.b(bArr, j2 + j), x1Var.b(bArr, j + 1 + j2));
    }

    @Override // com.fyber.inneractive.sdk.protobuf.A1
    public final String b(ByteBuffer byteBuffer, int i, int i2) throws C3211o0 {
        long j;
        if ((i | i2 | ((byteBuffer.limit() - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        long j2 = y1.c.f2303a.getLong(byteBuffer, y1.g) + ((long) i);
        long j3 = ((long) i2) + j2;
        char[] cArr = new char[i2];
        int i3 = 0;
        while (true) {
            j = 1;
            if (j2 >= j3) {
                break;
            }
            byte bA = y1.c.a(j2);
            if (!z1.a(bA)) {
                break;
            }
            j2++;
            cArr[i3] = (char) bA;
            i3++;
        }
        int i4 = i3;
        while (j2 < j3) {
            long j4 = j2 + j;
            x1 x1Var = y1.c;
            byte bA2 = x1Var.a(j2);
            if (z1.a(bA2)) {
                cArr[i4] = (char) bA2;
                i4++;
                j2 = j4;
                while (j2 < j3) {
                    byte bA3 = y1.c.a(j2);
                    if (!z1.a(bA3)) {
                        break;
                    }
                    j2 += j;
                    cArr[i4] = (char) bA3;
                    i4++;
                }
            } else if (bA2 < -32) {
                if (j4 >= j3) {
                    throw new C3211o0("Protocol message had invalid UTF-8.");
                }
                j2 += 2;
                z1.a(bA2, x1Var.a(j4), cArr, i4);
                i4++;
            } else if (bA2 < -16) {
                if (j4 >= j3 - j) {
                    throw new C3211o0("Protocol message had invalid UTF-8.");
                }
                long j5 = j2 + 2;
                j2 += 3;
                z1.a(bA2, x1Var.a(j4), x1Var.a(j5), cArr, i4);
                i4++;
            } else {
                if (j4 >= j3 - 2) {
                    throw new C3211o0("Protocol message had invalid UTF-8.");
                }
                byte bA4 = x1Var.a(j4);
                long j6 = j2 + 3;
                byte bA5 = x1Var.a(j2 + 2);
                j2 += 4;
                z1.a(bA2, bA4, bA5, x1Var.a(j6), cArr, i4);
                i4 += 2;
                j = 1;
            }
        }
        return new String(cArr, 0, i4);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.A1
    public final int c(byte[] bArr, int i, int i2) {
        int i3;
        if ((i | i2 | (bArr.length - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        long j = i;
        int i4 = (int) (((long) i2) - j);
        long j2 = 1;
        if (i4 >= 16) {
            long j3 = j;
            i3 = 0;
            while (true) {
                if (i3 >= i4) {
                    i3 = i4;
                    break;
                }
                long j4 = j3 + 1;
                if (y1.c.b(bArr, y1.f + j3) < 0) {
                    break;
                }
                i3++;
                j3 = j4;
            }
        } else {
            i3 = 0;
        }
        int i5 = i4 - i3;
        long j5 = j + ((long) i3);
        while (true) {
            byte b = 0;
            while (i5 > 0) {
                long j6 = j5 + j2;
                b = y1.c.b(bArr, y1.f + j5);
                if (b < 0) {
                    j5 = j6;
                    break;
                }
                i5--;
                j5 = j6;
            }
            if (i5 == 0) {
                return 0;
            }
            int i6 = i5 - 1;
            if (b < -32) {
                if (i6 == 0) {
                    return b;
                }
                i5 -= 2;
                if (b >= -62) {
                    long j7 = j5 + j2;
                    if (y1.c.b(bArr, y1.f + j5) <= -65) {
                        j5 = j7;
                    }
                }
                return -1;
            }
            if (b < -16) {
                if (i6 < 2) {
                    return a(bArr, b, j5, i6);
                }
                i5 -= 3;
                long j8 = j5 + j2;
                x1 x1Var = y1.c;
                long j9 = y1.f;
                byte b2 = x1Var.b(bArr, j9 + j5);
                if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                    j5 += 2;
                    if (x1Var.b(bArr, j9 + j8) > -65) {
                    }
                    j2 = 1;
                }
                return -1;
            }
            if (i6 < 3) {
                return a(bArr, b, j5, i6);
            }
            i5 -= 4;
            long j10 = j5 + 1;
            x1 x1Var2 = y1.c;
            long j11 = y1.f;
            byte b3 = x1Var2.b(bArr, j11 + j5);
            if (b3 <= -65) {
                if ((((b3 + 112) + (b << Ascii.FS)) >> 30) == 0) {
                    long j12 = 2 + j5;
                    if (x1Var2.b(bArr, j10 + j11) <= -65) {
                        j5 += 3;
                        if (x1Var2.b(bArr, j11 + j12) > -65) {
                        }
                        j2 = 1;
                    }
                }
            }
            return -1;
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.A1
    public final String a(byte[] bArr, int i, int i2) throws C3211o0 {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte b = y1.c.b(bArr, y1.f + ((long) i));
                if (!z1.a(b)) {
                    break;
                }
                i++;
                cArr[i4] = (char) b;
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                x1 x1Var = y1.c;
                long j = y1.f;
                byte b2 = x1Var.b(bArr, ((long) i) + j);
                if (z1.a(b2)) {
                    cArr[i5] = (char) b2;
                    i5++;
                    i = i6;
                    while (i < i3) {
                        byte b3 = y1.c.b(bArr, y1.f + ((long) i));
                        if (!z1.a(b3)) {
                            break;
                        }
                        i++;
                        cArr[i5] = (char) b3;
                        i5++;
                    }
                } else if (b2 < -32) {
                    if (i6 < i3) {
                        i += 2;
                        z1.a(b2, x1Var.b(bArr, j + ((long) i6)), cArr, i5);
                        i5++;
                    } else {
                        throw new C3211o0("Protocol message had invalid UTF-8.");
                    }
                } else if (b2 < -16) {
                    if (i6 < i3 - 1) {
                        int i7 = i + 2;
                        i += 3;
                        z1.a(b2, x1Var.b(bArr, ((long) i6) + j), x1Var.b(bArr, j + ((long) i7)), cArr, i5);
                        i5++;
                    } else {
                        throw new C3211o0("Protocol message had invalid UTF-8.");
                    }
                } else if (i6 < i3 - 2) {
                    byte b4 = x1Var.b(bArr, ((long) i6) + j);
                    int i8 = i + 3;
                    byte b5 = x1Var.b(bArr, ((long) (i + 2)) + j);
                    i += 4;
                    z1.a(b2, b4, b5, x1Var.b(bArr, j + ((long) i8)), cArr, i5);
                    i5 += 2;
                } else {
                    throw new C3211o0("Protocol message had invalid UTF-8.");
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // com.fyber.inneractive.sdk.protobuf.A1
    public final int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        char c;
        String str;
        String str2;
        long j2;
        int i3;
        long j3;
        char cCharAt;
        long j4 = i;
        long j5 = ((long) i2) + j4;
        int length = charSequence.length();
        String str3 = " at index ";
        String str4 = "Failed writing ";
        if (length > i2 || bArr.length - i2 < i) {
            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i + i2));
        }
        int i4 = 0;
        while (true) {
            j = 1;
            c = 128;
            if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            y1.c.a((Object) bArr, y1.f + j4, (byte) cCharAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char cCharAt2 = charSequence.charAt(i4);
            if (cCharAt2 >= c || j4 >= j5) {
                if (cCharAt2 >= 2048 || j4 > j5 - 2) {
                    str = str3;
                    str2 = str4;
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j4 > j5 - 3) {
                        if (j4 <= j5 - 4) {
                            int i5 = i4 + 1;
                            if (i5 != length) {
                                char cCharAt3 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    j3 = 1;
                                    x1 x1Var = y1.c;
                                    long j6 = y1.f;
                                    x1Var.a((Object) bArr, j6 + j4, (byte) ((codePoint >>> 18) | 240));
                                    x1Var.a((Object) bArr, j6 + j4 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j7 = j4 + 3;
                                    c = 128;
                                    x1Var.a((Object) bArr, j6 + 2 + j4, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j4 += 4;
                                    x1Var.a((Object) bArr, j6 + j7, (byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                } else {
                                    i4 = i5;
                                }
                            }
                            throw new C1(i4 - 1, length);
                        }
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i3)))) {
                            throw new C1(i4, length);
                        }
                        throw new ArrayIndexOutOfBoundsException(str2 + cCharAt2 + str + j4);
                    }
                    byte b = (byte) ((cCharAt2 >>> '\f') | DtbConstants.DEFAULT_PLAYER_HEIGHT);
                    x1 x1Var2 = y1.c;
                    long j8 = y1.f;
                    x1Var2.a((Object) bArr, j8 + j4, b);
                    x1Var2.a((Object) bArr, j8 + j4 + 1, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    x1Var2.a((Object) bArr, j8 + 2 + j4, (byte) ((cCharAt2 & '?') | 128));
                    j2 = j4 + 3;
                } else {
                    long j9 = j4 + j;
                    x1 x1Var3 = y1.c;
                    long j10 = y1.f;
                    str = str3;
                    str2 = str4;
                    x1Var3.a((Object) bArr, j10 + j4, (byte) ((cCharAt2 >>> 6) | 960));
                    j4 += 2;
                    x1Var3.a((Object) bArr, j10 + j9, (byte) ((cCharAt2 & '?') | 128));
                    c = 128;
                    j3 = 1;
                }
                i4++;
                str3 = str;
                j = j3;
                str4 = str2;
            } else {
                j2 = j4 + j;
                y1.c.a((Object) bArr, y1.f + j4, (byte) cCharAt2);
                str = str3;
                str2 = str4;
            }
            j4 = j2;
            c = 128;
            j3 = 1;
            i4++;
            str3 = str;
            j = j3;
            str4 = str2;
        }
        return (int) j4;
    }
}
