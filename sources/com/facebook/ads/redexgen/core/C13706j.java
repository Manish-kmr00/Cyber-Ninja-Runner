package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.os.Build;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13706j {
    public static byte[] A04;
    public static String[] A05 = {"MJXAzUwyiLvMzZCrP1QJf8uMs9b", "sHuNTXgsBnW3HGqskl7KH5QkikNWpABj", "q8u9vKEVkpk3dMxroB1EFzM5kwDKfJOq", "eyGwnlQBA4bCraIcft5FxvFgN7f8TC5N", "FmmRYKiwjJl3dX1FB2pV6kIWJpsNLC6h", "flBitaWG3wpDSjkerYNuTkR3r5UhRox3", "xkUQOvOGGj42jMnQjSDdoLzQvdQiYUba", "XqZ9VL6XKZ5Y"};
    public final Intent A00;
    public final C13656e A01;
    public final C2699k1 A02;
    public final A7 A03;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private C2540hM A06() {
        C1771Mw c1771MwA02 = A02();
        if (c1771MwA02 == null) {
            return null;
        }
        C2536hI c2536hI = new C2536hI();
        return new C2540hM(this.A02, this.A03, new C2744kk(this.A01), c1771MwA02, null, c2536hI, A0K(c2536hI, c1771MwA02));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private C2540hM A07() {
        C1769Mu c1769MuA03 = A03();
        if (c1769MuA03 == null) {
            return null;
        }
        C2535hH c2535hH = new C2535hH();
        return new C2540hM(this.A02, this.A03, new M6(this.A01), c1769MuA03, c1769MuA03.A0s(), c2535hH, A0K(c2535hH, c1769MuA03));
    }

    public static String A0L(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 59);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0M() {
        A04 = new byte[]{99, 127, 4, 1, 58, 1, 4, 17, 4, 58, 7, Ascii.DLE, Ascii.VT, 1, 9, 0, 43, 41, 36, 36, 45, 58, Ascii.FS, 49, 56, 45, 119, 124, 117, 125, 122, 113, 112, 85, 112, 80, 117, 96, 117, 86, 97, 122, 112, 120, 113, 35, 44, 41, 49, 32, 55, 32, 33, Ascii.SUB, 38, 41, 44, 38, 46, Ascii.SUB, 33, 32, 41, 36, 60, Ascii.SUB, 40, 54, 124, 115, 102, 123, 100, 119, 83, 118, 86, 115, 102, 115, 80, 103, 124, 118, 126, 119, 106, 118, 123, 121, 127, 119, 127, 116, 110, 32, 55, 37, 51, 32, 54, 55, 54, 4, 59, 54, 55, Base64.padSymbol, 19, 54, Ascii.SYN, 51, 38, 51, Ascii.DLE, 39, 60, 54, 62, 55, Ascii.SYN, 9, 4, 5, Ascii.SI, 63, Ascii.DC4, 9, Ascii.CR, 5, 63, Ascii.DLE, Ascii.SI, Ascii.FF, Ascii.FF, 9, Ascii.SO, 7, 63, 9, Ascii.SO, Ascii.DC4, 5, Ascii.DC2, Ascii.SYN, 1, Ascii.FF};
    }

    static {
        A0M();
    }

    public C13706j(C13656e c13656e, Intent intent, A7 a7, C2699k1 c2699k1) {
        this.A01 = c13656e;
        this.A00 = intent;
        this.A03 = a7;
        this.A02 = c2699k1;
    }

    private AbstractC2855md A00() {
        int i = Build.VERSION.SDK_INT;
        String strA0L = A0L(68, 18, 41);
        if (i >= 33) {
            return (AbstractC2855md) this.A00.getSerializableExtra(strA0L, AbstractC2855md.class);
        }
        Intent intent = this.A00;
        String[] strArr = A05;
        if (strArr[6].charAt(13) != strArr[2].charAt(13)) {
            throw new RuntimeException();
        }
        A05[1] = "LmjecX6z1NXmevkMdudhCsYVgseeBlBL";
        return (AbstractC2855md) intent.getSerializableExtra(strA0L);
    }

    private C2853mb A01() {
        int i = Build.VERSION.SDK_INT;
        String strA0L = A0L(26, 19, 47);
        if (i >= 33) {
            return (C2853mb) this.A00.getSerializableExtra(strA0L, C2853mb.class);
        }
        return (C2853mb) this.A00.getSerializableExtra(strA0L);
    }

    private C1771Mw A02() {
        int i = Build.VERSION.SDK_INT;
        String strA0L = A0L(2, 14, 94);
        if (i >= 33) {
            return (C1771Mw) this.A00.getSerializableExtra(strA0L, C1771Mw.class);
        }
        return (C1771Mw) this.A00.getSerializableExtra(strA0L);
    }

    private C1769Mu A03() {
        int i = Build.VERSION.SDK_INT;
        String strA0L = A0L(95, 25, 105);
        if (i >= 33) {
            return (C1769Mu) this.A00.getSerializableExtra(strA0L, C1769Mu.class);
        }
        return (C1769Mu) this.A00.getSerializableExtra(strA0L);
    }

    private DS A05() {
        if (C14499m.A2m(this.A02)) {
            String stringExtra = this.A00.getStringExtra(A0L(45, 23, 126));
            C13656e c13656e = this.A01;
            C2699k1 c2699k1 = this.A02;
            A7 a7 = this.A03;
            C2744kk c2744kk = new C2744kk(this.A01);
            Intent intent = this.A00;
            String clickDelayMs = A0L(16, 10, 115);
            String stringExtra2 = intent.getStringExtra(clickDelayMs);
            if (stringExtra == null) {
                stringExtra = A0L(0, 2, 117);
            }
            int i = Integer.parseInt(stringExtra);
            if (A05[5].charAt(3) != 'i') {
                throw new RuntimeException();
            }
            A05[4] = "YY09SF1W0j6b6KfCSgRusx8TJPca7HgC";
            return new ViewOnClickListenerC1755Lz(c13656e, c2699k1, a7, c2744kk, stringExtra2, i);
        }
        return new C2572hu(this.A01, this.A02, this.A03, new C2744kk(this.A01));
    }

    private final C2539hL A08() {
        return new C2539hL(this.A02, this.A01);
    }

    private C2537hJ A09(RelativeLayout relativeLayout) {
        C2537hJ c2537hJ = new C2537hJ(this.A02, new C2743kj(this), this.A03, new C2744kk(this.A01));
        c2537hJ.A05(relativeLayout);
        c2537hJ.A04(this.A00.getIntExtra(A0L(120, 27, 91), 200));
        D3.A0K(relativeLayout, ViewCompat.MEASURED_STATE_MASK);
        return c2537hJ;
    }

    private LJ A0A() {
        C1771Mw c1771MwA02 = A02();
        if (c1771MwA02 == null) {
            return null;
        }
        return new LJ(this.A02, this.A03, new C2744kk(this.A01), c1771MwA02, new C2536hI(), 1);
    }

    private LJ A0B() {
        C1769Mu c1769MuA03 = A03();
        if (c1769MuA03 == null) {
            return null;
        }
        return new LJ(this.A02, this.A03, new C2744kk(this.A01), c1769MuA03, new C2535hH(), 0);
    }

    private C2416fL A0C() {
        C1618Gr c1618GrA02;
        AbstractC2855md abstractC2855mdA00 = A00();
        if (abstractC2855mdA00 == null || (c1618GrA02 = AbstractC1619Gs.A02(abstractC2855mdA00.A0r())) == null) {
            return null;
        }
        return new C2416fL(this.A02, new C2744kk(this.A01), c1618GrA02, abstractC2855mdA00.A1g());
    }

    private C2333dz A0D(BG bg) {
        EC c2535hH;
        DR m6;
        C2853mb c2853mbA01 = A01();
        if (c2853mbA01 == null) {
            return null;
        }
        if (bg == BG.A04) {
            c2535hH = new C2536hI();
            m6 = new C2744kk(this.A01);
        } else {
            c2535hH = new C2535hH();
            m6 = new M6(this.A01);
        }
        return new C2333dz(this.A02, c2535hH, this.A03, c2853mbA01, new C14067t(this.A02), m6);
    }

    private C1721Kq A0E() {
        C1771Mw c1771MwA02 = A02();
        if (c1771MwA02 != null) {
            return new C1721Kq(this.A02, new C2536hI(), this.A03, c1771MwA02, new C14067t(this.A02), new C2744kk(this.A01));
        }
        if (A05[1].charAt(5) != 'X') {
            throw new RuntimeException();
        }
        A05[3] = "TvLwsmu9uaa0faVP4fF8b7PGg31O8U7I";
        return null;
    }

    private C1714Kj A0F() {
        C1771Mw c1771MwA02 = A02();
        if (c1771MwA02 == null) {
            return null;
        }
        return new C1714Kj(this.A02, new C2536hI(), this.A03, c1771MwA02, new C14067t(this.A02), new C2744kk(this.A01));
    }

    private C1714Kj A0G() {
        C1769Mu c1769MuA03 = A03();
        if (c1769MuA03 == null) {
            return null;
        }
        return new C1714Kj(this.A02, new C2535hH(), this.A03, c1769MuA03, new C14067t(this.A02), new M6(this.A01));
    }

    private C2302dT A0H() {
        C1769Mu c1769MuA03;
        C1769Mu c1769MuA04 = A03();
        if (c1769MuA04 == null || (c1769MuA03 = A03()) == null) {
            return null;
        }
        return new C2302dT(this.A02, this.A03, c1769MuA04, c1769MuA03, new M6(this.A01), this.A01);
    }

    private C1713Ki A0I() {
        C1771Mw dataBundle = A02();
        if (dataBundle == null) {
            return null;
        }
        dataBundle.A0y(this.A01.A08());
        return new C1713Ki(this.A02, this.A03, new C14067t(this.A02), new C2744kk(this.A01), dataBundle);
    }

    private C1713Ki A0J() {
        C1769Mu dataBundle = A03();
        if (dataBundle == null) {
            return null;
        }
        dataBundle.A0y(this.A01.A08());
        return new C1713Ki(this.A02, this.A03, new C14067t(this.A02), new C2744kk(this.A01), dataBundle);
    }

    private C1641Ho A0K(EC ec, AbstractC2855md abstractC2855md) {
        C12752p c12752pA07 = abstractC2855md.A1b().A0F().A07();
        if (c12752pA07 == null || !c12752pA07.A0M()) {
            return null;
        }
        HashMap map = new HashMap();
        map.put(A0L(86, 9, 33), ec.A8b());
        return new C1641Ho(this.A02, abstractC2855md, c12752pA07, this.A03, null, map);
    }

    public final DS A0N(BG bg, RelativeLayout relativeLayout) {
        if (bg == null) {
            return null;
        }
        switch (C13696i.A00[bg.ordinal()]) {
            case 1:
                if (relativeLayout != null) {
                    return A09(relativeLayout);
                }
                return null;
            case 2:
                return A0J();
            case 3:
                return A0G();
            case 4:
                return A07();
            case 5:
                return A05();
            case 6:
                C1714Kj c1714KjA0F = A0F();
                if (A05[4].charAt(13) != '3') {
                    A05[1] = "IIJ0HXviRARge0yizoGTY0JUA2Nzjczv";
                    return c1714KjA0F;
                }
                String[] strArr = A05;
                strArr[6] = "UHMFNKnwuKHYyMbevaCPtufG1H9dhH1t";
                strArr[2] = "s6UgSHR7PtydXMVItCKPjBxPhDp7nABU";
                return c1714KjA0F;
            case 7:
                return A0E();
            case 8:
                return A0I();
            case 9:
                return A06();
            case 10:
                return A0C();
            case 11:
                LJ ljA0A = A0A();
                if (A05[5].charAt(3) != 'i') {
                    throw new RuntimeException();
                }
                A05[3] = "7AQwH6OZkLua7JLoKEhUfmskdEmJStMK";
                return ljA0A;
            case 12:
                return A0B();
            case 13:
            case 14:
                return A0D(bg);
            case 15:
                return A08();
            case 16:
                return A0H();
            default:
                return null;
        }
    }
}
