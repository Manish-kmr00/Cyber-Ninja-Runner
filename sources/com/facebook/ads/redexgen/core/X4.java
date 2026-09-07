package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class X4 {
    public static byte[] A00;
    public static String[] A01 = {"syy2YLTEoSHA6gZzlMZFoSQC8vM85u1k", "RxK3hUaCMXKO7jp9FT69Lb9LkCxBqg2s", "4OIf9JKZD5wis4wt466xtrtUTnaFzGnC", "00A31XwQgMKFLLSudmzniQWjKf8nhHhB", "m2lveFqK2AEPuiH3tK1d10tr5Wykory1", "KoCHp8eIFClrJLIiWlN2i0mZ8wvpBqJf", "FwPcHPFmYTq2JbSc9R4dbSYtpp5SWJh0", "7XkTgTbGbrkDhANgQFeMAvhAsDDVVz2Q"};

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 85);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        byte[] bArr = {77, 107, 111, 91, 122, 103, 98, Ascii.VT, 51, 49, 40, 40, 49, 54, 63, 120, 42, Base64.padSymbol, 53, 57, 49, 54, 60, Base64.padSymbol, 42, 120, 55, 62, 120, 53, 57, 52, 62, 55, 42, 53, Base64.padSymbol, 60, 120, Ascii.VT, Ascii.GS, 17, 120, Ascii.SYN, Ascii.EM, Ascii.DC4, 120, 45, 54, 49, 44, 118};
        String[] strArr = A01;
        if (strArr[1].charAt(30) != strArr[7].charAt(30)) {
            throw new RuntimeException();
        }
        A01[4] = "1kDvwBDRCyDV4MCkcv1yWlFX0w9qMHVl";
        A00 = bArr;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A04(long j, C2447fq c2447fq, InterfaceC1957Uo[] interfaceC1957UoArr) {
        int iA0I = c2447fq.A0I();
        if ((iA0I & 64) != 0) {
            c2447fq.A0g(1);
            int i = (iA0I & 31) * 3;
            int iA09 = c2447fq.A09();
            for (InterfaceC1957Uo interfaceC1957Uo : interfaceC1957UoArr) {
                c2447fq.A0f(iA09);
                interfaceC1957Uo.AHx(c2447fq, i);
                interfaceC1957Uo.AI0(j, 1, i, 0, null);
            }
        }
    }

    static {
        A02();
    }

    public static int A00(C2447fq c2447fq) {
        int i = 0;
        while (value != 0) {
            int b = c2447fq.A0I();
            i += b;
            if (b != 255) {
                return i;
            }
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    public static void A03(long j, C2447fq c2447fq, InterfaceC1957Uo[] interfaceC1957UoArr) {
        while (true) {
            if (c2447fq.A07() > 1) {
                int iA00 = A00(c2447fq);
                int iA01 = A00(c2447fq);
                int iA09 = c2447fq.A09() + iA01;
                if (iA01 != -1) {
                    int payloadType = c2447fq.A07();
                    if (iA01 > payloadType) {
                        AbstractC2432fb.A07(A01(0, 7, 91), A01(7, 45, 13));
                        iA09 = c2447fq.A0A();
                    } else if (iA00 == 4 && iA01 >= 8) {
                        int userIdentifier = c2447fq.A0I();
                        int providerCode = c2447fq.A0M();
                        int countryCode = 0;
                        if (providerCode == 49) {
                            countryCode = c2447fq.A0C();
                        }
                        int iA0I = c2447fq.A0I();
                        if (providerCode == 47) {
                            c2447fq.A0g(1);
                        }
                        int i = (userIdentifier == 181 && (providerCode == 49 || providerCode == 47) && iA0I == 3) ? 1 : 0;
                        if (providerCode == 49) {
                            int userDataTypeCode = countryCode != 1195456820 ? 0 : 1;
                            i &= userDataTypeCode;
                        }
                        if (i != 0) {
                            A04(j, c2447fq, interfaceC1957UoArr);
                        }
                    }
                } else {
                    AbstractC2432fb.A07(A01(0, 7, 91), A01(7, 45, 13));
                    iA09 = c2447fq.A0A();
                }
                c2447fq.A0f(iA09);
            } else {
                return;
            }
        }
    }
}
