package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.ColorInfo;
import com.google.android.exoplayer2.DrmInitData;
import com.google.android.exoplayer2.Metadata;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class P5 {
    public static String[] A0X = {"rGJukjjAR04jQXJehxGTHIzKTpyrQvgF", "lmiZMexKxePfRvOASCj5HerkIdrkaegT", "TM8KVStfmv02KXkpsDrHX1FsOgZWe", "48vFTLAxvOhgld", "QA7MMs7ABiGvPN", "RTH8DIgSradTAe", "AjnQs56Q3jcsZI", "lCCAdKlFideSXfJCYCsvDUrbYRT8uLt8"};
    public float A00;
    public float A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public int A0E;
    public int A0F;
    public int A0G;
    public int A0H;
    public int A0I;
    public int A0J;
    public long A0K;
    public ColorInfo A0L;
    public DrmInitData A0M;
    public Metadata A0N;
    public Object A0O;
    public String A0P;
    public String A0Q;
    public String A0R;
    public String A0S;
    public String A0T;
    public String A0U;
    public List<byte[]> A0V;
    public byte[] A0W;

    public P5() {
        this.A03 = -1;
        this.A0B = -1;
        this.A09 = -1;
        this.A0K = Long.MAX_VALUE;
        this.A0J = -1;
        this.A08 = -1;
        this.A00 = -1.0f;
        this.A01 = 1.0f;
        this.A0G = -1;
        this.A04 = -1;
        this.A0E = -1;
        this.A0A = -1;
        this.A02 = -1;
        this.A0H = -1;
        this.A0I = -1;
        this.A05 = 0;
    }

    public P5(ZM zm) {
        this.A0R = zm.A0T;
        this.A0S = zm.A0U;
        this.A0T = zm.A0V;
        this.A0F = zm.A0H;
        this.A0C = zm.A0E;
        this.A03 = zm.A04;
        this.A0B = zm.A0D;
        this.A0P = zm.A0R;
        this.A0N = zm.A0P;
        this.A0Q = zm.A0S;
        this.A0U = zm.A0W;
        this.A09 = zm.A0B;
        this.A0V = zm.A0X;
        this.A0M = zm.A0O;
        this.A0K = zm.A0M;
        this.A0J = zm.A0L;
        this.A08 = zm.A0A;
        this.A00 = zm.A01;
        this.A0D = zm.A0F;
        this.A01 = zm.A02;
        this.A0W = zm.A0Y;
        this.A0G = zm.A0I;
        this.A0L = zm.A0N;
        this.A04 = zm.A06;
        this.A0E = zm.A0G;
        this.A0A = zm.A0C;
        this.A06 = zm.A08;
        this.A07 = zm.A09;
        this.A02 = zm.A03;
        this.A0H = zm.A0J;
        this.A0I = zm.A0K;
        this.A05 = zm.A07;
        this.A0O = zm.A0Q;
    }

    public final P5 A0X(float f) {
        this.A00 = f;
        return this;
    }

    public final P5 A0Y(float f) {
        this.A01 = f;
        return this;
    }

    public final P5 A0Z(int i) {
        this.A02 = i;
        return this;
    }

    public final P5 A0a(int i) {
        this.A03 = i;
        return this;
    }

    public final P5 A0b(int i) {
        this.A04 = i;
        return this;
    }

    public final P5 A0c(int i) {
        this.A05 = i;
        return this;
    }

    public final P5 A0d(int i) {
        this.A06 = i;
        return this;
    }

    public final P5 A0e(int i) {
        this.A07 = i;
        return this;
    }

    public final P5 A0f(int i) {
        this.A08 = i;
        return this;
    }

    public final P5 A0g(int i) {
        this.A0R = Integer.toString(i);
        return this;
    }

    public final P5 A0h(int i) {
        this.A09 = i;
        return this;
    }

    public final P5 A0i(int i) {
        this.A0A = i;
        return this;
    }

    public final P5 A0j(int i) {
        this.A0B = i;
        return this;
    }

    public final P5 A0k(int i) {
        this.A0C = i;
        return this;
    }

    public final P5 A0l(int i) {
        this.A0D = i;
        return this;
    }

    public final P5 A0m(int i) {
        this.A0E = i;
        return this;
    }

    public final P5 A0n(int i) {
        this.A0F = i;
        return this;
    }

    public final P5 A0o(int i) {
        this.A0G = i;
        return this;
    }

    public final P5 A0p(int i) {
        this.A0H = i;
        return this;
    }

    public final P5 A0q(int i) {
        this.A0I = i;
        return this;
    }

    public final P5 A0r(int i) {
        this.A0J = i;
        return this;
    }

    public final P5 A0s(long j) {
        this.A0K = j;
        return this;
    }

    public final P5 A0t(ColorInfo colorInfo) {
        this.A0L = colorInfo;
        return this;
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Processing CryptoType for callers that don't know about it")
    public final P5 A0u(DrmInitData drmInitData) {
        this.A0M = drmInitData;
        if (drmInitData != null) {
            int i = this.A05;
            String[] strArr = A0X;
            if (strArr[6].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            A0X[2] = "NGqOHp6XyVcs4I0b5PCo8jkn4zg3f";
            if (i == 0) {
                if (A0X[1].charAt(15) != 'A') {
                    A0X[7] = "LAyAJuDixFldFY3htGtLGeLhkuhnX6hq";
                    A0c(2);
                } else {
                    A0X[7] = "rNyAjrC5TEzMa0EqvC2Fvpnma0A5Rta5";
                    A0c(2);
                }
            }
        }
        return this;
    }

    public final P5 A0v(Metadata metadata) {
        this.A0N = metadata;
        return this;
    }

    public final P5 A0w(String str) {
        this.A0P = str;
        return this;
    }

    public final P5 A0x(String str) {
        this.A0Q = str;
        return this;
    }

    public final P5 A0y(String str) {
        this.A0R = str;
        return this;
    }

    public final P5 A0z(String str) {
        this.A0S = str;
        return this;
    }

    public final P5 A10(String str) {
        this.A0T = str;
        return this;
    }

    public final P5 A11(String str) {
        this.A0U = str;
        return this;
    }

    public final P5 A12(List<byte[]> initializationData) {
        this.A0V = initializationData;
        return this;
    }

    public final P5 A13(byte[] bArr) {
        this.A0W = bArr;
        return this;
    }

    public final ZM A14() {
        return new ZM(this);
    }
}
