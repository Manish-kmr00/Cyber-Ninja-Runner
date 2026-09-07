package com.bytedance.sdk.component.Og.pA.Og;

import com.google.common.base.Ascii;
import com.json.b9;
import io.ktor.util.date.GMTDateParser;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class ZZv implements Serializable, Comparable<ZZv> {
    transient String JG;
    transient int ML;
    final byte[] ZZv;
    static final char[] pA = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};
    public static final Charset Og = Charset.forName("UTF-8");
    public static final ZZv KZx = pA(new byte[0]);

    ZZv(byte[] bArr) {
        this.ZZv = bArr;
    }

    public static ZZv pA(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new ZZv((byte[]) bArr.clone());
    }

    public String pA() {
        String str = this.JG;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.ZZv, Og);
        this.JG = str2;
        return str2;
    }

    public String Og() {
        byte[] bArr = this.ZZv;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = pA;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }

    public ZZv pA(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.ZZv;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.ZZv.length + ")");
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i2 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return new ZZv(bArr2);
    }

    public byte pA(int i) {
        return this.ZZv[i];
    }

    public int KZx() {
        return this.ZZv.length;
    }

    public byte[] ZZv() {
        return (byte[]) this.ZZv.clone();
    }

    public boolean pA(int i, ZZv zZv, int i2, int i3) {
        return zZv.pA(i2, this.ZZv, i, i3);
    }

    public boolean pA(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.ZZv;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && Bzk.pA(bArr2, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ZZv) {
            ZZv zZv = (ZZv) obj;
            int iKZx = zZv.KZx();
            byte[] bArr = this.ZZv;
            if (iKZx == bArr.length && zZv.pA(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.ML;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.ZZv);
        this.ML = iHashCode;
        return iHashCode;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public int compareTo(ZZv zZv) {
        int iKZx = KZx();
        int iKZx2 = zZv.KZx();
        int iMin = Math.min(iKZx, iKZx2);
        for (int i = 0; i < iMin; i++) {
            int iPA = pA(i) & 255;
            int iPA2 = zZv.pA(i) & 255;
            if (iPA != iPA2) {
                return iPA < iPA2 ? -1 : 1;
            }
        }
        if (iKZx == iKZx2) {
            return 0;
        }
        return iKZx < iKZx2 ? -1 : 1;
    }

    public String toString() {
        if (this.ZZv.length == 0) {
            return "[size=0]";
        }
        String strPA = pA();
        int iPA = pA(strPA, 64);
        if (iPA == -1) {
            if (this.ZZv.length > 64) {
                return "[size=" + this.ZZv.length + " hex=" + pA(0, 64).Og() + "…]";
            }
            return "[hex=" + Og() + b9.i.e;
        }
        String strReplace = strPA.substring(0, iPA).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        return iPA < strPA.length() ? "[size=" + this.ZZv.length + " text=" + strReplace + "…]" : "[text=" + strReplace + b9.i.e;
    }

    static int pA(String str, int i) {
        int length = str.length();
        int iCharCount = 0;
        int i2 = 0;
        while (iCharCount < length) {
            if (i2 == i) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i2++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }
}
