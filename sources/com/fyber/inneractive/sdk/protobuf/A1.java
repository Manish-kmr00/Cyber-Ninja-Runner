package com.fyber.inneractive.sdk.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes12.dex */
public abstract class A1 {
    public static String a(ByteBuffer byteBuffer, int i, int i2) throws C3211o0 {
        if ((i | i2 | ((byteBuffer.limit() - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte b = byteBuffer.get(i);
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
            byte b2 = byteBuffer.get(i);
            if (z1.a(b2)) {
                cArr[i5] = (char) b2;
                i5++;
                i = i6;
                while (i < i3) {
                    byte b3 = byteBuffer.get(i);
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
                z1.a(b2, byteBuffer.get(i6), cArr, i5);
                i5++;
            } else if (b2 < -16) {
                if (i6 >= i3 - 1) {
                    throw new C3211o0("Protocol message had invalid UTF-8.");
                }
                int i7 = i + 2;
                i += 3;
                z1.a(b2, byteBuffer.get(i6), byteBuffer.get(i7), cArr, i5);
                i5++;
            } else {
                if (i6 >= i3 - 2) {
                    throw new C3211o0("Protocol message had invalid UTF-8.");
                }
                byte b4 = byteBuffer.get(i6);
                int i8 = i + 3;
                byte b5 = byteBuffer.get(i + 2);
                i += 4;
                z1.a(b2, b4, b5, byteBuffer.get(i8), cArr, i5);
                i5 += 2;
            }
        }
        return new String(cArr, 0, i5);
    }

    public abstract int a(CharSequence charSequence, byte[] bArr, int i, int i2);

    public abstract String a(byte[] bArr, int i, int i2);

    public abstract String b(ByteBuffer byteBuffer, int i, int i2);

    public final boolean b(byte[] bArr, int i, int i2) {
        return c(bArr, i, i2) == 0;
    }

    public abstract int c(byte[] bArr, int i, int i2);
}
