package com.fyber.inneractive.sdk.protobuf;

import com.amazon.device.ads.DtbConstants;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes12.dex */
public final class B1 extends A1 {
    @Override // com.fyber.inneractive.sdk.protobuf.A1
    public final String a(byte[] bArr, int i, int i2) throws C3211o0 {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte b = bArr[i];
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
            byte b2 = bArr[i];
            if (z1.a(b2)) {
                cArr[i5] = (char) b2;
                i5++;
                i = i6;
                while (i < i3) {
                    byte b3 = bArr[i];
                    if (!z1.a(b3)) {
                        break;
                    }
                    i++;
                    cArr[i5] = (char) b3;
                    i5++;
                }
            } else if (b2 < -32) {
                if (i6 >= i3) {
                    throw new C3211o0("Protocol message had invalid UTF-8.");
                }
                i += 2;
                z1.a(b2, bArr[i6], cArr, i5);
                i5++;
            } else if (b2 < -16) {
                if (i6 >= i3 - 1) {
                    throw new C3211o0("Protocol message had invalid UTF-8.");
                }
                int i7 = i + 2;
                i += 3;
                z1.a(b2, bArr[i6], bArr[i7], cArr, i5);
                i5++;
            } else {
                if (i6 >= i3 - 2) {
                    throw new C3211o0("Protocol message had invalid UTF-8.");
                }
                byte b4 = bArr[i6];
                int i8 = i + 3;
                byte b5 = bArr[i + 2];
                i += 4;
                z1.a(b2, b4, b5, bArr[i8], cArr, i5);
                i5 += 2;
            }
        }
        return new String(cArr, 0, i5);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.A1
    public final String b(ByteBuffer byteBuffer, int i, int i2) {
        return A1.a(byteBuffer, i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005a, code lost:
    
        if (r1 > (-12)) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0098, code lost:
    
        if (r1 > (-12)) goto L66;
     */
    @Override // com.fyber.inneractive.sdk.protobuf.A1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int c(byte[] r10, int r11, int r12) {
        /*
            r9 = this;
        L0:
            if (r11 >= r12) goto L9
            r0 = r10[r11]
            if (r0 < 0) goto L9
            int r11 = r11 + 1
            goto L0
        L9:
            if (r11 < r12) goto Lc
            goto Le
        Lc:
            if (r11 < r12) goto L11
        Le:
            r10 = 0
            goto Lb7
        L11:
            int r0 = r11 + 1
            r1 = r10[r11]
            if (r1 >= 0) goto Lb8
            r2 = -1
            r3 = -32
            r4 = -65
            if (r1 >= r3) goto L2f
            if (r0 < r12) goto L23
        L20:
            r10 = r1
            goto Lb7
        L23:
            r3 = -62
            if (r1 < r3) goto Lb6
            int r11 = r11 + 2
            r0 = r10[r0]
            if (r0 <= r4) goto Lc
            goto Lb6
        L2f:
            r5 = -16
            r6 = -12
            r7 = 1
            r8 = 2
            if (r1 >= r5) goto L76
            int r5 = r12 + (-1)
            if (r0 < r5) goto L5d
            int r12 = r12 - r0
            if (r12 == 0) goto L5a
            if (r12 == r7) goto L53
            if (r12 != r8) goto L4d
            r12 = r10[r0]
            int r11 = r11 + r8
            r10 = r10[r11]
            int r10 = com.fyber.inneractive.sdk.protobuf.E1.a(r1, r12, r10)
            goto Lb7
        L4d:
            java.lang.AssertionError r10 = new java.lang.AssertionError
            r10.<init>()
            throw r10
        L53:
            r10 = r10[r0]
            int r10 = com.fyber.inneractive.sdk.protobuf.E1.a(r1, r10)
            goto Lb7
        L5a:
            if (r1 <= r6) goto L20
            goto L9a
        L5d:
            int r5 = r11 + 2
            r0 = r10[r0]
            if (r0 > r4) goto Lb6
            r6 = -96
            if (r1 != r3) goto L69
            if (r0 < r6) goto Lb6
        L69:
            r3 = -19
            if (r1 != r3) goto L6f
            if (r0 >= r6) goto Lb6
        L6f:
            int r11 = r11 + 3
            r0 = r10[r5]
            if (r0 <= r4) goto Lc
            goto Lb6
        L76:
            int r3 = r12 + (-2)
            if (r0 < r3) goto L9b
            int r12 = r12 - r0
            if (r12 == 0) goto L98
            if (r12 == r7) goto L91
            if (r12 != r8) goto L8b
            r12 = r10[r0]
            int r11 = r11 + r8
            r10 = r10[r11]
            int r10 = com.fyber.inneractive.sdk.protobuf.E1.a(r1, r12, r10)
            goto Lb7
        L8b:
            java.lang.AssertionError r10 = new java.lang.AssertionError
            r10.<init>()
            throw r10
        L91:
            r10 = r10[r0]
            int r10 = com.fyber.inneractive.sdk.protobuf.E1.a(r1, r10)
            goto Lb7
        L98:
            if (r1 <= r6) goto L20
        L9a:
            goto Lb6
        L9b:
            int r3 = r11 + 2
            r0 = r10[r0]
            if (r0 > r4) goto Lb6
            int r1 = r1 << 28
            int r0 = r0 + 112
            int r0 = r0 + r1
            int r0 = r0 >> 30
            if (r0 != 0) goto Lb6
            int r0 = r11 + 3
            r1 = r10[r3]
            if (r1 > r4) goto Lb6
            int r11 = r11 + 4
            r0 = r10[r0]
            if (r0 <= r4) goto Lc
        Lb6:
            r10 = r2
        Lb7:
            return r10
        Lb8:
            r11 = r0
            goto Lc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.B1.c(byte[], int, int):int");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.A1
    public final int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        char cCharAt;
        int length = charSequence.length();
        int i5 = i2 + i;
        int i6 = 0;
        while (i6 < length && (i4 = i6 + i) < i5 && (cCharAt = charSequence.charAt(i6)) < 128) {
            bArr[i4] = (byte) cCharAt;
            i6++;
        }
        if (i6 == length) {
            return i + length;
        }
        int i7 = i + i6;
        while (i6 < length) {
            char cCharAt2 = charSequence.charAt(i6);
            if (cCharAt2 < 128 && i7 < i5) {
                bArr[i7] = (byte) cCharAt2;
                i7++;
            } else if (cCharAt2 < 2048 && i7 <= i5 - 2) {
                int i8 = i7 + 1;
                bArr[i7] = (byte) ((cCharAt2 >>> 6) | 960);
                i7 += 2;
                bArr[i8] = (byte) ((cCharAt2 & '?') | 128);
            } else {
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i7 > i5 - 3) {
                    if (i7 <= i5 - 4) {
                        int i9 = i6 + 1;
                        if (i9 != charSequence.length()) {
                            char cCharAt3 = charSequence.charAt(i9);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i7 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i10 = i7 + 3;
                                bArr[i7 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i7 += 4;
                                bArr[i10] = (byte) ((codePoint & 63) | 128);
                                i6 = i9;
                            } else {
                                i6 = i9;
                            }
                        }
                        throw new C1(i6 - 1, length);
                    }
                    if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i3 = i6 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i3)))) {
                        throw new C1(i6, length);
                    }
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i7);
                }
                bArr[i7] = (byte) ((cCharAt2 >>> '\f') | DtbConstants.DEFAULT_PLAYER_HEIGHT);
                int i11 = i7 + 2;
                bArr[i7 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                i7 += 3;
                bArr[i11] = (byte) ((cCharAt2 & '?') | 128);
            }
            i6++;
        }
        return i7;
    }
}
