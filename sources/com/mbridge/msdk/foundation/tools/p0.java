package com.mbridge.msdk.foundation.tools;

import com.json.cc;
import io.ktor.util.date.GMTDateParser;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: SameMVEncoder.java */
/* JADX INFO: loaded from: classes5.dex */
public class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f5067a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', GMTDateParser.MONTH, 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', GMTDateParser.YEAR, 'Z', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f', 'g', GMTDateParser.HOURS, 'i', 'j', 'k', 'l', GMTDateParser.MINUTES, 'n', 'o', 'p', 'q', 'r', GMTDateParser.SECONDS, 't', AbstractJsonLexerKt.UNICODE_ESC, 'v', 'w', 'x', 'y', GMTDateParser.ZONE, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] b = new byte[128];
    private static Map<Character, Character> c;
    private static char[] d;

    static {
        HashMap map = new HashMap();
        c = map;
        map.put('A', 'v');
        c.put('B', 'S');
        c.put('C', 'o');
        c.put('D', 'a');
        c.put('E', 'j');
        c.put('F', 'c');
        c.put('G', '7');
        c.put('H', Character.valueOf(GMTDateParser.DAY_OF_MONTH));
        c.put('I', 'R');
        c.put('J', Character.valueOf(GMTDateParser.ZONE));
        c.put('K', 'p');
        c.put('L', 'W');
        Map<Character, Character> map2 = c;
        Character chValueOf = Character.valueOf(GMTDateParser.MONTH);
        map2.put(chValueOf, 'i');
        c.put('N', 'f');
        c.put('O', 'G');
        c.put('P', 'y');
        c.put('Q', 'N');
        c.put('R', 'x');
        c.put('S', 'Z');
        c.put('T', 'n');
        c.put('U', 'V');
        c.put('V', '5');
        c.put('W', 'k');
        c.put('X', '+');
        c.put(Character.valueOf(GMTDateParser.YEAR), 'D');
        c.put('Z', 'H');
        c.put('a', 'L');
        c.put('b', Character.valueOf(GMTDateParser.YEAR));
        c.put('c', Character.valueOf(GMTDateParser.HOURS));
        c.put(Character.valueOf(GMTDateParser.DAY_OF_MONTH), 'J');
        c.put('e', '4');
        c.put('f', '6');
        c.put('g', 'l');
        c.put(Character.valueOf(GMTDateParser.HOURS), 't');
        c.put('i', '0');
        c.put('j', 'U');
        c.put('k', '3');
        c.put('l', 'Q');
        c.put(Character.valueOf(GMTDateParser.MINUTES), 'r');
        c.put('n', 'g');
        c.put('o', 'E');
        c.put('p', Character.valueOf(AbstractJsonLexerKt.UNICODE_ESC));
        c.put('q', 'q');
        c.put('r', '8');
        c.put(Character.valueOf(GMTDateParser.SECONDS), Character.valueOf(GMTDateParser.SECONDS));
        c.put('t', 'w');
        c.put(Character.valueOf(AbstractJsonLexerKt.UNICODE_ESC), '/');
        c.put('v', 'X');
        c.put('w', chValueOf);
        c.put('x', 'e');
        c.put('y', 'B');
        c.put(Character.valueOf(GMTDateParser.ZONE), 'A');
        c.put('0', 'T');
        c.put('1', '2');
        c.put('2', 'F');
        c.put('3', 'b');
        c.put('4', '9');
        c.put('5', 'P');
        c.put('6', '1');
        c.put('7', 'O');
        c.put('8', 'I');
        c.put('9', 'K');
        c.put('+', Character.valueOf(GMTDateParser.MINUTES));
        c.put('/', 'C');
        d = new char[64];
        int i = 0;
        while (true) {
            char[] cArr = f5067a;
            if (i >= cArr.length) {
                break;
            }
            d[i] = c.get(Character.valueOf(cArr[i])).charValue();
            i++;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr = b;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = 127;
            i2++;
        }
        int i3 = 0;
        while (true) {
            char[] cArr2 = d;
            if (i3 >= cArr2.length) {
                return;
            }
            b[cArr2[i3]] = (byte) i3;
            i3++;
        }
    }

    private static int a(char[] cArr, byte[] bArr, int i) {
        try {
            char c2 = cArr[3];
            char c3 = c2 == '=' ? (char) 2 : (char) 3;
            char c4 = cArr[2];
            if (c4 == '=') {
                c3 = 1;
            }
            byte[] bArr2 = b;
            byte b2 = bArr2[cArr[0]];
            byte b3 = bArr2[cArr[1]];
            byte b4 = bArr2[c4];
            byte b5 = bArr2[c2];
            if (c3 == 1) {
                bArr[i] = (byte) (((b3 >> 4) & 3) | ((b2 << 2) & 252));
                return 1;
            }
            if (c3 == 2) {
                bArr[i] = (byte) ((3 & (b3 >> 4)) | ((b2 << 2) & 252));
                bArr[i + 1] = (byte) (((b3 << 4) & 240) | ((b4 >> 2) & 15));
                return 2;
            }
            if (c3 != 3) {
                throw new RuntimeException("Internal Error");
            }
            bArr[i] = (byte) (((b2 << 2) & 252) | ((b3 >> 4) & 3));
            bArr[i + 1] = (byte) (((b3 << 4) & 240) | ((b4 >> 2) & 15));
            bArr[i + 2] = (byte) (((b4 << 6) & 192) | (b5 & 63));
            return 3;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String b(String str) {
        byte[] bArrA = a(str);
        if (bArrA == null || bArrA.length <= 0) {
            return null;
        }
        return new String(bArrA);
    }

    public static String c(String str) {
        return a(str.getBytes());
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003d A[Catch: Exception -> 0x005b, TryCatch #0 {Exception -> 0x005b, blocks: (B:2:0x0000, B:5:0x0009, B:7:0x0019, B:9:0x001d, B:13:0x002c, B:15:0x0032, B:17:0x0037, B:23:0x004c, B:19:0x003d, B:21:0x0044, B:10:0x0023, B:27:0x0055), top: B:31:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0044 A[Catch: Exception -> 0x005b, TryCatch #0 {Exception -> 0x005b, blocks: (B:2:0x0000, B:5:0x0009, B:7:0x0019, B:9:0x001d, B:13:0x002c, B:15:0x0032, B:17:0x0037, B:23:0x004c, B:19:0x003d, B:21:0x0044, B:10:0x0023, B:27:0x0055), top: B:31:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x004b  */
    public static byte[] a(String str) {
        int i;
        int i2;
        try {
            int length = str.length();
            char[] cArr = new char[length < 259 ? length : 259];
            int i3 = ((length >> 2) * 3) + 3;
            byte[] bArr = new byte[i3];
            int i4 = 0;
            int iA = 0;
            int i5 = 0;
            while (i4 < length) {
                int i6 = i4 + 256;
                if (i6 <= length) {
                    str.getChars(i4, i6, cArr, i5);
                    i = i5 + 256;
                } else {
                    str.getChars(i4, length, cArr, i5);
                    i = (length - i4) + i5;
                }
                int i7 = i5;
                while (i5 < i) {
                    char c2 = cArr[i5];
                    if (c2 != '=') {
                        byte[] bArr2 = b;
                        if (c2 < bArr2.length && bArr2[c2] != 127) {
                            i2 = i7 + 1;
                            cArr[i7] = c2;
                            if (i2 == 4) {
                                iA += a(cArr, bArr, iA);
                                i7 = 0;
                            } else {
                                i7 = i2;
                            }
                        }
                    } else {
                        i2 = i7 + 1;
                        cArr[i7] = c2;
                        if (i2 == 4) {
                            iA += a(cArr, bArr, iA);
                            i7 = 0;
                        } else {
                            i7 = i2;
                        }
                    }
                    i5++;
                }
                i4 = i6;
                i5 = i7;
            }
            if (iA == i3) {
                return bArr;
            }
            byte[] bArr3 = new byte[iA];
            System.arraycopy(bArr, 0, bArr3, 0, iA);
            return bArr3;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static String a(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return "";
        }
        try {
            char[] cArr = new char[((i2 / 3) << 2) + 4];
            int i3 = 0;
            while (i2 >= 3) {
                int i4 = ((bArr[i] & 255) << 16) + ((bArr[i + 1] & 255) << 8) + (bArr[i + 2] & 255);
                char[] cArr2 = d;
                cArr[i3] = cArr2[i4 >> 18];
                cArr[i3 + 1] = cArr2[(i4 >> 12) & 63];
                int i5 = i3 + 3;
                cArr[i3 + 2] = cArr2[(i4 >> 6) & 63];
                i3 += 4;
                cArr[i5] = cArr2[i4 & 63];
                i += 3;
                i2 -= 3;
            }
            if (i2 == 1) {
                int i6 = bArr[i] & 255;
                char[] cArr3 = d;
                cArr[i3] = cArr3[i6 >> 2];
                cArr[i3 + 1] = cArr3[(i6 << 4) & 63];
                int i7 = i3 + 3;
                cArr[i3 + 2] = cc.T;
                i3 += 4;
                cArr[i7] = cc.T;
            } else if (i2 == 2) {
                int i8 = ((bArr[i] & 255) << 8) + (bArr[i + 1] & 255);
                char[] cArr4 = d;
                cArr[i3] = cArr4[i8 >> 10];
                cArr[i3 + 1] = cArr4[(i8 >> 4) & 63];
                int i9 = i3 + 3;
                cArr[i3 + 2] = cArr4[(i8 << 2) & 63];
                i3 += 4;
                cArr[i9] = cc.T;
            }
            return new String(cArr, 0, i3);
        } catch (Exception unused) {
            return null;
        }
    }
}
