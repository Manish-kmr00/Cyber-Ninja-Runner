package com.bytedance.sdk.component.Og.pA.Og;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class pA implements KZx, Og, Cloneable, ByteChannel {
    private static final byte[] KZx = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    long Og;
    ML pA;

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public boolean pA() {
        return this.Og == 0;
    }

    public byte Og() {
        if (this.Og == 0) {
            throw new IllegalStateException("size == 0");
        }
        ML ml = this.pA;
        int i = ml.Og;
        int i2 = ml.KZx;
        int i3 = i + 1;
        byte b = ml.pA[i];
        this.Og--;
        if (i3 == i2) {
            this.pA = ml.Og();
            JG.pA(ml);
        } else {
            ml.Og = i3;
        }
        return b;
    }

    public String KZx() {
        try {
            return pA(this.Og, Bzk.pA);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String pA(long j, Charset charset) throws EOFException {
        Bzk.pA(this.Og, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        ML ml = this.pA;
        if (((long) ml.Og) + j > ml.KZx) {
            return new String(pA(j), charset);
        }
        String str = new String(ml.pA, ml.Og, (int) j, charset);
        ml.Og = (int) (((long) ml.Og) + j);
        this.Og -= j;
        if (ml.Og == ml.KZx) {
            this.pA = ml.Og();
            JG.pA(ml);
        }
        return str;
    }

    public byte[] pA(long j) throws EOFException {
        Bzk.pA(this.Og, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        byte[] bArr = new byte[(int) j];
        pA(bArr);
        return bArr;
    }

    public void pA(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iPA = pA(bArr, i, bArr.length - i);
            if (iPA == -1) {
                throw new EOFException();
            }
            i += iPA;
        }
    }

    public int pA(byte[] bArr, int i, int i2) {
        Bzk.pA(bArr.length, i, i2);
        ML ml = this.pA;
        if (ml == null) {
            return -1;
        }
        int iMin = Math.min(i2, ml.KZx - ml.Og);
        System.arraycopy(ml.pA, ml.Og, bArr, i, iMin);
        ml.Og += iMin;
        this.Og -= (long) iMin;
        if (ml.Og == ml.KZx) {
            this.pA = ml.Og();
            JG.pA(ml);
        }
        return iMin;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        ML ml = this.pA;
        if (ml == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), ml.KZx - ml.Og);
        byteBuffer.put(ml.pA, ml.Og, iMin);
        ml.Og += iMin;
        this.Og -= (long) iMin;
        if (ml.Og == ml.KZx) {
            this.pA = ml.Og();
            JG.pA(ml);
        }
        return iMin;
    }

    public pA pA(String str) {
        return pA(str, 0, str.length());
    }

    public pA pA(String str, int i, int i2) {
        char cCharAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                ML mlKZx = KZx(1);
                byte[] bArr = mlKZx.pA;
                int i3 = mlKZx.KZx - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = (i3 + i) - mlKZx.KZx;
                mlKZx.KZx += i5;
                this.Og += (long) i5;
            } else {
                if (cCharAt2 < 2048) {
                    Og((cCharAt2 >> 6) | 192);
                    Og((cCharAt2 & '?') | 128);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    Og((cCharAt2 >> '\f') | 224);
                    Og(((cCharAt2 >> 6) & 63) | 128);
                    Og((cCharAt2 & '?') | 128);
                } else {
                    int i6 = i + 1;
                    char cCharAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                    if (cCharAt2 > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        Og(63);
                        i = i6;
                    } else {
                        int i7 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        Og((i7 >> 18) | 240);
                        Og(((i7 >> 12) & 63) | 128);
                        Og(((i7 >> 6) & 63) | 128);
                        Og((i7 & 63) | 128);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    public pA pA(int i) {
        if (i < 128) {
            Og(i);
        } else if (i < 2048) {
            Og((i >> 6) | 192);
            Og((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                Og(63);
            } else {
                Og((i >> 12) | 224);
                Og(((i >> 6) & 63) | 128);
                Og((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            Og((i >> 18) | 240);
            Og(((i >> 12) & 63) | 128);
            Og(((i >> 6) & 63) | 128);
            Og((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public pA pA(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(Bzk.pA)) {
            return pA(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return Og(bytes, 0, bytes.length);
    }

    public pA Og(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        Bzk.pA(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            ML mlKZx = KZx(1);
            int iMin = Math.min(i3 - i, 8192 - mlKZx.KZx);
            System.arraycopy(bArr, i, mlKZx.pA, mlKZx.KZx, iMin);
            i += iMin;
            mlKZx.KZx += iMin;
        }
        this.Og += j;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            ML mlKZx = KZx(1);
            int iMin = Math.min(i, 8192 - mlKZx.KZx);
            byteBuffer.get(mlKZx.pA, mlKZx.KZx, iMin);
            i -= iMin;
            mlKZx.KZx += iMin;
        }
        this.Og += (long) iRemaining;
        return iRemaining;
    }

    public pA Og(int i) {
        ML mlKZx = KZx(1);
        byte[] bArr = mlKZx.pA;
        int i2 = mlKZx.KZx;
        mlKZx.KZx = i2 + 1;
        bArr[i2] = (byte) i;
        this.Og++;
        return this;
    }

    public pA Og(long j) {
        if (j == 0) {
            return Og(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        ML mlKZx = KZx(iNumberOfTrailingZeros);
        byte[] bArr = mlKZx.pA;
        int i = mlKZx.KZx;
        for (int i2 = (mlKZx.KZx + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = KZx[(int) (15 & j)];
            j >>>= 4;
        }
        mlKZx.KZx += iNumberOfTrailingZeros;
        this.Og += (long) iNumberOfTrailingZeros;
        return this;
    }

    ML KZx(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        ML ml = this.pA;
        if (ml == null) {
            ML mlPA = JG.pA();
            this.pA = mlPA;
            mlPA.SD = mlPA;
            mlPA.JG = mlPA;
            return mlPA;
        }
        ML ml2 = ml.SD;
        return (ml2.KZx + i > 8192 || !ml2.ML) ? ml2.pA(JG.pA()) : ml2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pA)) {
            return false;
        }
        pA pAVar = (pA) obj;
        long j = this.Og;
        if (j != pAVar.Og) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        ML ml = this.pA;
        ML ml2 = pAVar.pA;
        int i = ml.Og;
        int i2 = ml2.Og;
        while (j2 < this.Og) {
            long jMin = Math.min(ml.KZx - i, ml2.KZx - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (ml.pA[i] != ml2.pA[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == ml.KZx) {
                ml = ml.JG;
                i = ml.Og;
            }
            if (i2 == ml2.KZx) {
                ml2 = ml2.JG;
                i2 = ml2.Og;
            }
            j2 += jMin;
        }
        return true;
    }

    public int hashCode() {
        ML ml = this.pA;
        if (ml == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = ml.KZx;
            for (int i3 = ml.Og; i3 < i2; i3++) {
                i = (i * 31) + ml.pA[i3];
            }
            ml = ml.JG;
        } while (ml != this.pA);
        return i;
    }

    public String toString() {
        return ML().toString();
    }

    /* JADX INFO: renamed from: ZZv, reason: merged with bridge method [inline-methods] */
    public pA clone() {
        pA pAVar = new pA();
        if (this.Og == 0) {
            return pAVar;
        }
        ML mlPA = this.pA.pA();
        pAVar.pA = mlPA;
        mlPA.SD = mlPA;
        mlPA.JG = mlPA;
        ML ml = this.pA;
        while (true) {
            ml = ml.JG;
            if (ml != this.pA) {
                pAVar.pA.SD.pA(ml.pA());
            } else {
                pAVar.Og = this.Og;
                return pAVar;
            }
        }
    }

    public final ZZv ML() {
        long j = this.Og;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.Og);
        }
        return ZZv((int) j);
    }

    public final ZZv ZZv(int i) {
        if (i == 0) {
            return ZZv.KZx;
        }
        return new SD(this, i);
    }
}
