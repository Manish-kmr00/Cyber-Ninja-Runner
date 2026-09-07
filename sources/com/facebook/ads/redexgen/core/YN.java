package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.List;
import net.pubnative.lite.sdk.models.Protocol;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class YN implements InterfaceC1775Nb {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final int A09;
    public final int A0A;
    public final int A0B;
    public final int A0C;
    public final int A0D;
    public final int A0E;
    public final int A0F;
    public final AbstractC2804lm<C2046Yc, YW> A0G;
    public final OG<Integer> A0H;
    public final List<String> A0I;
    public final List<String> A0J;
    public final List<String> A0K;

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D56211926, support language flag in video track")
    public final List<String> A0L;
    public final List<String> A0M;
    public final boolean A0N;
    public final boolean A0O;
    public final boolean A0P;
    public final boolean A0Q;
    public static String[] A0R = {"3flTCt6Ahfq1piwneKFx5b7teRo2XFm1", "bOLRonAZjSivNY3pEIWSn6pHj18ozExm", "S6noHKJfzkHMg7dUBICsxcz4aDA6Lld1", "gmAwNXqfhYb7ghakdEuZQMcQTZ0gXXxk", "H", "Gvp2H0dUXvpdMKRABuH0YUpllZZIbEMC", "W5D7Lki0itbDxywftuvRprYj6BxoApgi", Protocol.VAST_1_0_WRAPPER};
    public static final YN A0U = new C1868Qx().A0u();

    @Deprecated
    public static final YN A0T = A0U;
    public static final String A0j = AbstractC2471gE.A0h(1);
    public static final String A0l = AbstractC2471gE.A0h(2);
    public static final String A0m = AbstractC2471gE.A0h(3);
    public static final String A0n = AbstractC2471gE.A0h(4);
    public static final String A0s = AbstractC2471gE.A0h(5);
    public static final String A0e = AbstractC2471gE.A0h(6);
    public static final String A0d = AbstractC2471gE.A0h(7);
    public static final String A0c = AbstractC2471gE.A0h(8);
    public static final String A0b = AbstractC2471gE.A0h(9);
    public static final String A0i = AbstractC2471gE.A0h(10);
    public static final String A0h = AbstractC2471gE.A0h(11);
    public static final String A0g = AbstractC2471gE.A0h(12);
    public static final String A0f = AbstractC2471gE.A0h(13);
    public static final String A0v = AbstractC2471gE.A0h(14);
    public static final String A0t = AbstractC2471gE.A0h(15);
    public static final String A0u = AbstractC2471gE.A0h(16);
    public static final String A0p = AbstractC2471gE.A0h(17);
    public static final String A0a = AbstractC2471gE.A0h(18);
    public static final String A0Z = AbstractC2471gE.A0h(19);
    public static final String A0k = AbstractC2471gE.A0h(20);
    public static final String A0X = AbstractC2471gE.A0h(21);
    public static final String A0W = AbstractC2471gE.A0h(22);
    public static final String A0r = AbstractC2471gE.A0h(23);
    public static final String A0V = AbstractC2471gE.A0h(24);
    public static final String A0q = AbstractC2471gE.A0h(25);
    public static final String A0Y = AbstractC2471gE.A0h(26);

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D56211926, support language flag in video track")
    public static final String A0o = AbstractC2471gE.A0h(27);

    @Deprecated
    public static final InterfaceC1774Na<YN> A0S = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.YR
        @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
        public final InterfaceC1775Nb A6V(Bundle bundle) {
            return YN.A0P(bundle);
        }
    };

    public YN(C1868Qx c1868Qx) {
        this.A06 = c1868Qx.A06;
        this.A05 = c1868Qx.A05;
        this.A04 = c1868Qx.A04;
        this.A03 = c1868Qx.A03;
        this.A0A = c1868Qx.A0A;
        this.A09 = c1868Qx.A09;
        this.A08 = c1868Qx.A08;
        this.A07 = c1868Qx.A07;
        this.A0F = c1868Qx.A0F;
        this.A0E = c1868Qx.A0E;
        this.A0Q = c1868Qx.A0Q;
        this.A0M = c1868Qx.A0M;
        this.A0D = c1868Qx.A0D;
        this.A0L = c1868Qx.A0L;
        this.A0I = c1868Qx.A0I;
        this.A0B = c1868Qx.A0B;
        this.A02 = c1868Qx.A02;
        this.A01 = c1868Qx.A01;
        this.A0J = c1868Qx.A0J;
        this.A0K = c1868Qx.A0K;
        this.A0C = c1868Qx.A0C;
        this.A00 = c1868Qx.A00;
        this.A0P = c1868Qx.A0P;
        this.A0O = c1868Qx.A0O;
        this.A0N = c1868Qx.A0N;
        this.A0G = AbstractC2804lm.A06(c1868Qx.A0G);
        this.A0H = OG.A07(c1868Qx.A0H);
    }

    public static YN A0P(Bundle bundle) {
        return new C1868Qx(bundle).A0u();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        YN yn = (YN) obj;
        if (this.A06 == yn.A06) {
            int i = this.A05;
            int i2 = yn.A05;
            String[] strArr = A0R;
            if (strArr[3].charAt(8) != strArr[0].charAt(8)) {
                throw new RuntimeException();
            }
            A0R[2] = "m123ZjxDyH6FVeAPvauFPaUT8Dyqb1yS";
            if (i == i2 && this.A04 == yn.A04 && this.A03 == yn.A03) {
                int i3 = this.A0A;
                if (A0R[6].charAt(23) == 'J') {
                    throw new RuntimeException();
                }
                A0R[2] = "3FISEUX4NWBULZmOMUzRIp5QNDlvcSwU";
                if (i3 == yn.A0A && this.A09 == yn.A09 && this.A08 == yn.A08 && this.A07 == yn.A07 && this.A0Q == yn.A0Q && this.A0F == yn.A0F && this.A0E == yn.A0E && this.A0M.equals(yn.A0M) && this.A0D == yn.A0D && this.A0L.equals(yn.A0L) && this.A0I.equals(yn.A0I) && this.A0B == yn.A0B && this.A02 == yn.A02 && this.A01 == yn.A01 && this.A0J.equals(yn.A0J) && this.A0K.equals(yn.A0K) && this.A0C == yn.A0C && this.A00 == yn.A00 && this.A0P == yn.A0P && this.A0O == yn.A0O && this.A0N == yn.A0N && this.A0G.equals(yn.A0G) && this.A0H.equals(yn.A0H)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((1 * 31) + this.A06) * 31) + this.A05) * 31) + this.A04) * 31) + this.A03) * 31) + this.A0A) * 31) + this.A09) * 31) + this.A08) * 31) + this.A07) * 31) + (this.A0Q ? 1 : 0)) * 31) + this.A0F) * 31) + this.A0E) * 31) + this.A0M.hashCode()) * 31) + this.A0D) * 31) + this.A0L.hashCode()) * 31) + this.A0I.hashCode()) * 31) + this.A0B) * 31) + this.A02) * 31) + this.A01) * 31) + this.A0J.hashCode()) * 31) + this.A0K.hashCode()) * 31) + this.A0C) * 31) + this.A00) * 31) + (this.A0P ? 1 : 0)) * 31) + (this.A0O ? 1 : 0)) * 31) + (this.A0N ? 1 : 0)) * 31) + this.A0G.hashCode()) * 31) + this.A0H.hashCode();
    }
}
