package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2084Zq implements InterfaceC1775Nb {
    public static byte[] A06;
    public static String[] A07 = {"WPBdzWamhvSQDIpyY36lLYQCDXRvjCD6", "EA6CYIl0OXqr5k1m7aj18riu2gt7KhHK", "toK0ySp7xUCED0anzJ0jTsPHDrHAJknN", "iPWl5pYUzpZap39t5ED9KC1NkQc9urRA", "F88XwVkn", "O9hJia4JcpHijJZbbCz79SFc7awyK90f", "ytPSpYsrEpraXkxTGBBPR", "GoCkg8n1c9QdB1CWvyGCuKLUg3ikT"};
    public static final C2084Zq A08;
    public static final InterfaceC1774Na<C2084Zq> A09;
    public static final C2085Zr A0A;
    public static final String A0B;
    public static final String A0C;
    public static final String A0D;
    public static final String A0E;
    public final int A00;
    public final int A01;
    public final long A02;
    public final long A03;
    public final Object A04;

    @MetaExoPlayerCustomization("Change back to private after AdsMediaSource fully upgraded")
    public final C2085Zr[] A05;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C2084Zq A00(Bundle bundle) {
        C2085Zr[] c2085ZrArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(A0B);
        if (parcelableArrayList == null) {
            c2085ZrArr = new C2085Zr[0];
        } else {
            c2085ZrArr = new C2085Zr[parcelableArrayList.size()];
            for (int i = 0; i < parcelableArrayList.size(); i++) {
                c2085ZrArr[i] = (C2085Zr) C2085Zr.A09.A6V((Bundle) parcelableArrayList.get(i));
            }
        }
        return new C2084Zq(null, c2085ZrArr, bundle.getLong(A0C, A08.A02), bundle.getLong(A0D, A08.A03), bundle.getInt(A0E, A08.A01));
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 96);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A06 = new byte[]{94, 82, Ascii.FS, Ascii.DLE, 81, 84, 119, 66, 95, 69, SignedBytes.MAX_POWER_OF_TWO, 67, Ascii.CR, 107, 97, 109, 44, 41, Ascii.US, 40, 62, 56, 32, 40, Ascii.GS, 34, 62, 36, 57, 36, 34, 35, Ascii.CAN, 62, 112, Ascii.VT, 7, 70, 67, 84, Ascii.SUB, 124, Ascii.SYN, Ascii.SUB, 94, 79, 72, 91, 78, 83, 85, 84, 111, 73, 7, 84, 113, 69, 121, 116, 108, 119, 116, 118, 126, 70, 97, 116, 97, 112, Base64.padSymbol, 116, 113, 102, 92, 113, 40, Ascii.GS, 105, 66, 71, Ascii.VT, 80, 87, 66, 87, 70, Ascii.RS, 43, 46, Ascii.CR, 56, 37, 63, 58, 98, 62, 35, 39, 47, Ascii.US, 57, 119};
    }

    static {
        A03();
        A08 = new C2084Zq(null, new C2085Zr[0], 0L, -9223372036854775807L, 0);
        A0A = new C2085Zr(0L).A06(0);
        A0B = AbstractC2471gE.A0h(1);
        A0C = AbstractC2471gE.A0h(2);
        A0D = AbstractC2471gE.A0h(3);
        A0E = AbstractC2471gE.A0h(4);
        A09 = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.Zt
            @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
            public final InterfaceC1775Nb A6V(Bundle bundle) {
                return C2084Zq.A00(bundle);
            }
        };
    }

    public C2084Zq(Object obj, C2085Zr[] c2085ZrArr, long j, long j2, int i) {
        this.A04 = obj;
        this.A02 = j;
        this.A03 = j2;
        this.A00 = c2085ZrArr.length + i;
        this.A05 = c2085ZrArr;
        this.A01 = i;
    }

    private boolean A04(long j, long j2, int i) {
        if (j == Long.MIN_VALUE) {
            return false;
        }
        long j3 = A07(i).A03;
        if (j3 == Long.MIN_VALUE) {
            return j2 == -9223372036854775807L || j < j2;
        }
        return j < j3;
    }

    public final int A05(long j, long j2) {
        if (j == Long.MIN_VALUE || (j2 != -9223372036854775807L && j >= j2)) {
            return -1;
        }
        int index = this.A01;
        while (index < this.A00 && ((A07(index).A03 != Long.MIN_VALUE && A07(index).A03 <= j) || !A07(index).A08())) {
            index++;
        }
        if (index < this.A00) {
            return index;
        }
        return -1;
    }

    public final int A06(long j, long j2) {
        int i = this.A00 - 1;
        while (i >= 0 && A04(j, j2, i)) {
            i--;
        }
        if (i < 0 || !A07(i).A07()) {
            return -1;
        }
        return i;
    }

    public final C2085Zr A07(int i) {
        if (i < this.A01) {
            return A0A;
        }
        return this.A05[i - this.A01];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2084Zq c2084Zq = (C2084Zq) obj;
        if (AbstractC2471gE.A1E(this.A04, c2084Zq.A04) && this.A00 == c2084Zq.A00 && this.A02 == c2084Zq.A02 && this.A03 == c2084Zq.A03 && this.A01 == c2084Zq.A01 && Arrays.equals(this.A05, c2084Zq.A05)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int result;
        int result2 = this.A00;
        int i = result2 * 31;
        if (this.A04 == null) {
            result = 0;
        } else {
            Object obj = this.A04;
            int result3 = A07[0].charAt(28);
            if (result3 != 106) {
                throw new RuntimeException();
            }
            A07[6] = "x90YzFW8ozjOQXEcLhWngXGhW4fRT";
            result = obj.hashCode();
        }
        int i2 = (((i + result) * 31) + ((int) this.A02)) * 31;
        int result4 = (int) this.A03;
        int result5 = (((i2 + result4) * 31) + this.A01) * 31;
        int result6 = Arrays.hashCode(this.A05);
        return result5 + result6;
    }

    public final String toString() {
        String strA02;
        StringBuilder sb = new StringBuilder();
        sb.append(A02(55, 22, 117));
        sb.append(this.A04);
        sb.append(A02(14, 21, 45));
        sb.append(this.A02);
        sb.append(A02(2, 12, 80));
        int i = 0;
        while (true) {
            int length = this.A05.length;
            String strA03 = A02(77, 2, 32);
            if (i < length) {
                sb.append(A02(88, 15, 42));
                sb.append(this.A05[i].A03);
                sb.append(A02(35, 7, 71));
                int i2 = 0;
                while (true) {
                    int length2 = this.A05[i].A05.length;
                    strA02 = A02(0, 2, 18);
                    if (i2 < length2) {
                        sb.append(A02(79, 9, 67));
                        switch (this.A05[i].A05[i2]) {
                            case 0:
                                sb.append('_');
                                break;
                            case 1:
                                sb.append('R');
                                break;
                            case 2:
                                sb.append('S');
                                break;
                            case 3:
                                sb.append('P');
                                break;
                            case 4:
                                sb.append('!');
                                break;
                            default:
                                int i3 = A07[7].length();
                                if (i3 == 27) {
                                    throw new RuntimeException();
                                }
                                A07[0] = "KYlwpvJLKaywXbh6OmFmB21BsoJ5j1iA";
                                sb.append('?');
                                break;
                                break;
                        }
                        sb.append(A02(42, 13, 90));
                        sb.append(this.A05[i].A06[i2]);
                        sb.append(')');
                        if (i2 < this.A05[i].A05.length - 1) {
                            sb.append(strA02);
                        }
                        i2++;
                    }
                }
                sb.append(strA03);
                if (i < this.A05.length - 1) {
                    sb.append(strA02);
                }
                i++;
            } else {
                sb.append(strA03);
                return sb.toString();
            }
        }
    }
}
