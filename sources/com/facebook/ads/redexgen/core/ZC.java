package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ZC implements InterfaceC1775Nb {
    public final Uri A00;
    public final Uri A01;
    public final Bundle A02;
    public final AbstractC2060Yr A03;
    public final AbstractC2060Yr A04;
    public final Boolean A05;
    public final CharSequence A06;
    public final CharSequence A07;
    public final CharSequence A08;
    public final CharSequence A09;
    public final CharSequence A0A;
    public final CharSequence A0B;
    public final CharSequence A0C;
    public final CharSequence A0D;
    public final CharSequence A0E;
    public final CharSequence A0F;
    public final CharSequence A0G;
    public final CharSequence A0H;
    public final CharSequence A0I;
    public final Integer A0J;
    public final Integer A0K;
    public final Integer A0L;
    public final Integer A0M;
    public final Integer A0N;
    public final Integer A0O;
    public final Integer A0P;
    public final Integer A0Q;
    public final Integer A0R;
    public final Integer A0S;
    public final Integer A0T;
    public final Integer A0U;

    @Deprecated
    public final Integer A0V;
    public final byte[] A0W;
    public static String[] A0X = {"VY1DJf0N6L4sQR48HVK3jrVp1Pa805RC", "iEZSI0lz", "X", "O1s09cZ5MkDUKHwcWkxI9VjG9LJmu3Ck", "ErvO9S7NOqK5bAWsuK0HnJM6np62C50w", "YJW9", "kpViBs2rdt8C4LSV7G8lX", "iUZIJzsLgy7B2qWCd4rJx"};
    public static final ZC A0Z = new PU().A11();
    public static final InterfaceC1774Na<ZC> A0Y = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.ZD
        @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
        public final InterfaceC1775Nb A6V(Bundle bundle) {
            return ZC.A00(bundle);
        }
    };

    public ZC(PU pu) {
        this.A0H = pu.A0H;
        this.A08 = pu.A08;
        this.A07 = pu.A07;
        this.A06 = pu.A06;
        this.A0D = pu.A0D;
        this.A0G = pu.A0G;
        this.A0C = pu.A0C;
        this.A01 = pu.A01;
        this.A04 = pu.A04;
        this.A03 = pu.A03;
        this.A0W = pu.A0V;
        this.A0J = pu.A0J;
        this.A00 = pu.A00;
        this.A0U = pu.A0U;
        this.A0T = pu.A0T;
        this.A0L = pu.A0L;
        this.A05 = pu.A05;
        this.A0V = pu.A0O;
        this.A0O = pu.A0O;
        this.A0N = pu.A0N;
        this.A0M = pu.A0M;
        this.A0R = pu.A0R;
        this.A0Q = pu.A0Q;
        this.A0P = pu.A0P;
        this.A0I = pu.A0I;
        this.A0A = pu.A0A;
        this.A0B = pu.A0B;
        this.A0K = pu.A0K;
        this.A0S = pu.A0S;
        this.A0E = pu.A0E;
        this.A09 = pu.A09;
        this.A0F = pu.A0F;
        this.A02 = pu.A02;
    }

    public static ZC A00(Bundle bundle) {
        Integer numValueOf;
        Bundle fieldBundle;
        Bundle fieldBundle2;
        PU pu = new PU();
        PU puA0X = pu.A0n(bundle.getCharSequence(A02(0))).A0e(bundle.getCharSequence(A02(1))).A0d(bundle.getCharSequence(A02(2))).A0c(bundle.getCharSequence(A02(3))).A0j(bundle.getCharSequence(A02(4))).A0m(bundle.getCharSequence(A02(5))).A0i(bundle.getCharSequence(A02(6))).A0X((Uri) bundle.getParcelable(A02(7)));
        byte[] byteArray = bundle.getByteArray(A02(10));
        if (bundle.containsKey(A02(29))) {
            numValueOf = Integer.valueOf(bundle.getInt(A02(29)));
        } else {
            numValueOf = null;
        }
        puA0X.A10(byteArray, numValueOf).A0W((Uri) bundle.getParcelable(A02(11))).A0o(bundle.getCharSequence(A02(22))).A0g(bundle.getCharSequence(A02(23))).A0h(bundle.getCharSequence(A02(24))).A0k(bundle.getCharSequence(A02(27))).A0f(bundle.getCharSequence(A02(28))).A0l(bundle.getCharSequence(A02(30))).A0Y(bundle.getBundle(A02(1000)));
        if (bundle.containsKey(A02(8)) && (fieldBundle2 = bundle.getBundle(A02(8))) != null) {
            pu.A0a((AbstractC2060Yr) AbstractC2060Yr.A03.A6V(fieldBundle2));
        }
        if (bundle.containsKey(A02(9)) && (fieldBundle = bundle.getBundle(A02(9))) != null) {
            pu.A0Z((AbstractC2060Yr) AbstractC2060Yr.A03.A6V(fieldBundle));
        }
        if (bundle.containsKey(A02(12))) {
            pu.A0z(Integer.valueOf(bundle.getInt(A02(12))));
        }
        if (bundle.containsKey(A02(13))) {
            String strA02 = A02(13);
            String[] strArr = A0X;
            if (strArr[2].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0X;
            strArr2[4] = "gKJlQjSvKllP1pf8gJ1xzo8kDgILuNzO";
            strArr2[3] = "UEr9bdRuWWpxs2mQ0G3A8m4ftwpGRbMt";
            pu.A0y(Integer.valueOf(bundle.getInt(strA02)));
        }
        if (bundle.containsKey(A02(14))) {
            pu.A0q(Integer.valueOf(bundle.getInt(A02(14))));
        }
        if (bundle.containsKey(A02(15))) {
            pu.A0b(Boolean.valueOf(bundle.getBoolean(A02(15))));
        }
        if (A0X[7].length() != 21) {
            throw new RuntimeException();
        }
        A0X[5] = "0l3";
        if (bundle.containsKey(A02(16))) {
            String strA03 = A02(16);
            if (A0X[7].length() != 21) {
                A0X[5] = "";
                pu.A0t(Integer.valueOf(bundle.getInt(strA03)));
            } else {
                A0X[1] = "Q1xnt0kP";
                pu.A0t(Integer.valueOf(bundle.getInt(strA03)));
            }
        }
        if (bundle.containsKey(A02(17))) {
            pu.A0s(Integer.valueOf(bundle.getInt(A02(17))));
        }
        if (bundle.containsKey(A02(18))) {
            pu.A0r(Integer.valueOf(bundle.getInt(A02(18))));
        }
        if (bundle.containsKey(A02(19))) {
            pu.A0w(Integer.valueOf(bundle.getInt(A02(19))));
        }
        if (bundle.containsKey(A02(20))) {
            pu.A0v(Integer.valueOf(bundle.getInt(A02(20))));
        }
        if (bundle.containsKey(A02(21))) {
            pu.A0u(Integer.valueOf(bundle.getInt(A02(21))));
        }
        if (bundle.containsKey(A02(25))) {
            pu.A0p(Integer.valueOf(bundle.getInt(A02(25))));
        }
        if (bundle.containsKey(A02(26))) {
            pu.A0x(Integer.valueOf(bundle.getInt(A02(26))));
        }
        return pu.A11();
    }

    public static String A02(int i) {
        return Integer.toString(i, 36);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ZC zc = (ZC) obj;
        if (AbstractC2471gE.A1E(this.A0H, zc.A0H) && AbstractC2471gE.A1E(this.A08, zc.A08)) {
            CharSequence charSequence = this.A07;
            if (A0X[1].length() == 8) {
                String[] strArr = A0X;
                strArr[2] = "Z";
                strArr[6] = "GQ6dkUBuBxp9SyTYiZNL5";
                if (AbstractC2471gE.A1E(charSequence, zc.A07) && AbstractC2471gE.A1E(this.A06, zc.A06) && AbstractC2471gE.A1E(this.A0D, zc.A0D) && AbstractC2471gE.A1E(this.A0G, zc.A0G) && AbstractC2471gE.A1E(this.A0C, zc.A0C) && AbstractC2471gE.A1E(this.A01, zc.A01) && AbstractC2471gE.A1E(this.A04, zc.A04) && AbstractC2471gE.A1E(this.A03, zc.A03) && Arrays.equals(this.A0W, zc.A0W) && AbstractC2471gE.A1E(this.A0J, zc.A0J) && AbstractC2471gE.A1E(this.A00, zc.A00) && AbstractC2471gE.A1E(this.A0U, zc.A0U) && AbstractC2471gE.A1E(this.A0T, zc.A0T) && AbstractC2471gE.A1E(this.A0L, zc.A0L) && AbstractC2471gE.A1E(this.A05, zc.A05)) {
                    Integer num = this.A0O;
                    if (A0X[1].length() == 8) {
                        A0X[5] = "8XXLUYzUYaKI8lEPjnnWUCVyOu9jQ";
                        if (AbstractC2471gE.A1E(num, zc.A0O) && AbstractC2471gE.A1E(this.A0N, zc.A0N) && AbstractC2471gE.A1E(this.A0M, zc.A0M) && AbstractC2471gE.A1E(this.A0R, zc.A0R) && AbstractC2471gE.A1E(this.A0Q, zc.A0Q) && AbstractC2471gE.A1E(this.A0P, zc.A0P) && AbstractC2471gE.A1E(this.A0I, zc.A0I) && AbstractC2471gE.A1E(this.A0A, zc.A0A) && AbstractC2471gE.A1E(this.A0B, zc.A0B) && AbstractC2471gE.A1E(this.A0K, zc.A0K) && AbstractC2471gE.A1E(this.A0S, zc.A0S) && AbstractC2471gE.A1E(this.A0E, zc.A0E) && AbstractC2471gE.A1E(this.A09, zc.A09) && AbstractC2471gE.A1E(this.A0F, zc.A0F)) {
                            return true;
                        }
                    }
                }
            }
            throw new RuntimeException();
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC1813Or.A00(this.A0H, this.A08, this.A07, this.A06, this.A0D, this.A0G, this.A0C, this.A01, this.A04, this.A03, Integer.valueOf(Arrays.hashCode(this.A0W)), this.A0J, this.A00, this.A0U, this.A0T, this.A0L, this.A05, this.A0O, this.A0N, this.A0M, this.A0R, this.A0Q, this.A0P, this.A0I, this.A0A, this.A0B, this.A0K, this.A0S, this.A0E, this.A09, this.A0F);
    }
}
