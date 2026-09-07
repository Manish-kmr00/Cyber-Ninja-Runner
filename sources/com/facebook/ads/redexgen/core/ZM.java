package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.ColorInfo;
import com.google.android.exoplayer2.DrmInitData;
import com.google.android.exoplayer2.Metadata;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ZM implements InterfaceC1775Nb {
    public static byte[] A0Z;
    public static String[] A0a = {"IhGyJJpIdzXpTFbZZ", "SJPXPkbq3kDt05pDs", "2UTcMrpXiEorK", "RLA8igv7oYs9DSC3tg9b3oMVOt", "inFtX", "N61GXI4Rl1nCA", "mLYWszSA8kxwzVA0oCZFYAxgyxpFQOwi", "RFN2MzIQPtfzv"};
    public static final InterfaceC1774Na<ZM> A0b;
    public static final ZM A0c;
    public static final String A0d;
    public static final String A0e;
    public static final String A0f;
    public static final String A0g;
    public static final String A0h;
    public static final String A0i;
    public static final String A0j;
    public static final String A0k;
    public static final String A0l;
    public static final String A0m;
    public static final String A0n;
    public static final String A0o;
    public static final String A0p;
    public static final String A0q;
    public static final String A0r;
    public static final String A0s;
    public static final String A0t;
    public static final String A0u;
    public static final String A0v;
    public static final String A0w;
    public static final String A0x;
    public static final String A0y;
    public static final String A0z;
    public static final String A10;
    public static final String A11;
    public static final String A12;
    public static final String A13;
    public static final String A14;
    public static final String A15;
    public static final String A16;
    public static final String A17;
    public static final String A18;
    public static final String A19;
    public int A00;
    public final float A01;
    public final float A02;
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
    public final int A0G;
    public final int A0H;
    public final int A0I;
    public final int A0J;
    public final int A0K;
    public final int A0L;
    public final long A0M;
    public final ColorInfo A0N;
    public final DrmInitData A0O;
    public final Metadata A0P;
    public final Object A0Q;
    public final String A0R;
    public final String A0S;
    public final String A0T;
    public final String A0U;
    public final String A0V;
    public final String A0W;
    public final List<byte[]> A0X;
    public final byte[] A0Y;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static <T> T A02(T t, T t2) {
        return t != null ? t : t2;
    }

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0Z, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 1);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A0Z = new byte[]{85, 73, 94, 82, -115, -64, -23, -20, -25, -37, -18, -94, 110, 58, -46, -95, -107, -48, 121};
    }

    static {
        A05();
        A0c = new P5().A14();
        A0q = AbstractC2471gE.A0h(0);
        A0s = AbstractC2471gE.A0h(1);
        A0t = AbstractC2471gE.A0h(2);
        A14 = AbstractC2471gE.A0h(3);
        A10 = AbstractC2471gE.A0h(4);
        A0e = AbstractC2471gE.A0h(5);
        A0x = AbstractC2471gE.A0h(6);
        A0g = AbstractC2471gE.A0h(7);
        A0v = AbstractC2471gE.A0h(8);
        A0i = AbstractC2471gE.A0h(9);
        A12 = AbstractC2471gE.A0h(10);
        A0u = AbstractC2471gE.A0h(11);
        A0r = AbstractC2471gE.A0h(12);
        A0k = AbstractC2471gE.A0h(13);
        A16 = AbstractC2471gE.A0h(14);
        A19 = AbstractC2471gE.A0h(15);
        A0p = AbstractC2471gE.A0h(16);
        A0o = AbstractC2471gE.A0h(17);
        A11 = AbstractC2471gE.A0h(18);
        A0y = AbstractC2471gE.A0h(19);
        A0z = AbstractC2471gE.A0h(20);
        A15 = AbstractC2471gE.A0h(21);
        A0h = AbstractC2471gE.A0h(22);
        A0f = AbstractC2471gE.A0h(23);
        A13 = AbstractC2471gE.A0h(24);
        A0w = AbstractC2471gE.A0h(25);
        A0l = AbstractC2471gE.A0h(26);
        A0m = AbstractC2471gE.A0h(27);
        A0d = AbstractC2471gE.A0h(28);
        A0j = AbstractC2471gE.A0h(29);
        A17 = AbstractC2471gE.A0h(30);
        A18 = AbstractC2471gE.A0h(31);
        A0n = AbstractC2471gE.A0h(32);
        A0b = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.ZN
            @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
            public final InterfaceC1775Nb A6V(Bundle bundle) {
                return ZM.A00(bundle);
            }
        };
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Language is not normalized")
    public ZM(P5 p5) {
        this.A0T = p5.A0R;
        this.A0U = p5.A0S;
        if (MetaExoPlayerUpgradeConfig.A03(EnumC1764Mn.A0k)) {
            this.A0V = AbstractC2471gE.A0k(p5.A0T);
        } else {
            this.A0V = p5.A0T;
        }
        this.A0H = p5.A0F;
        this.A0E = p5.A0C;
        this.A04 = p5.A03;
        this.A0D = p5.A0B;
        this.A05 = this.A0D != -1 ? this.A0D : this.A04;
        this.A0R = p5.A0P;
        this.A0P = p5.A0N;
        this.A0Q = p5.A0O;
        this.A0S = p5.A0Q;
        this.A0W = p5.A0U;
        this.A0B = p5.A09;
        this.A0X = p5.A0V == null ? Collections.emptyList() : p5.A0V;
        this.A0O = p5.A0M;
        this.A0M = p5.A0K;
        this.A0L = p5.A0J;
        this.A0A = p5.A08;
        this.A01 = p5.A00;
        this.A0F = p5.A0D == -1 ? 0 : p5.A0D;
        this.A02 = p5.A01 == -1.0f ? 1.0f : p5.A01;
        this.A0Y = p5.A0W;
        this.A0I = p5.A0G;
        this.A0N = p5.A0L;
        this.A06 = p5.A04;
        this.A0G = p5.A0E;
        this.A0C = p5.A0A;
        this.A08 = p5.A06 == -1 ? 0 : p5.A06;
        this.A09 = p5.A07 != -1 ? p5.A07 : 0;
        this.A03 = p5.A02;
        this.A0J = p5.A0H;
        this.A0K = p5.A0I;
        if (p5.A05 != 0 || this.A0O == null) {
            this.A07 = p5.A05;
        } else {
            this.A07 = 1;
        }
    }

    public static ZM A00(Bundle bundle) {
        P5 p5 = new P5();
        C2394ey.A02(bundle);
        p5.A0y((String) A02(bundle.getString(A0q), A0c.A0T)).A0z((String) A02(bundle.getString(A0s), A0c.A0U)).A10((String) A02(bundle.getString(A0t), A0c.A0V)).A0n(bundle.getInt(A14, A0c.A0H)).A0k(bundle.getInt(A10, A0c.A0E)).A0a(bundle.getInt(A0e, A0c.A04)).A0j(bundle.getInt(A0x, A0c.A0D)).A0w((String) A02(bundle.getString(A0g), A0c.A0R)).A0v((Metadata) A02((Metadata) bundle.getParcelable(A0v), A0c.A0P)).A0x((String) A02(bundle.getString(A0i), A0c.A0S)).A11((String) A02(bundle.getString(A12), A0c.A0W)).A0h(bundle.getInt(A0u, A0c.A0B));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            byte[] byteArray = bundle.getByteArray(A03(i));
            if (byteArray == null) {
                break;
            }
            arrayList.add(byteArray);
            i++;
        }
        p5.A12(arrayList).A0u((DrmInitData) bundle.getParcelable(A0k)).A0s(bundle.getLong(A16, A0c.A0M)).A0r(bundle.getInt(A19, A0c.A0L)).A0f(bundle.getInt(A0p, A0c.A0A)).A0X(bundle.getFloat(A0o, A0c.A01)).A0l(bundle.getInt(A11, A0c.A0F)).A0Y(bundle.getFloat(A0y, A0c.A02)).A13(bundle.getByteArray(A0z)).A0o(bundle.getInt(A15, A0c.A0I));
        Bundle bundle2 = bundle.getBundle(A0h);
        if (bundle2 != null) {
            p5.A0t((ColorInfo) ColorInfo.A08.A6V(bundle2));
        }
        p5.A0b(bundle.getInt(A0f, A0c.A06)).A0m(bundle.getInt(A13, A0c.A0G)).A0i(bundle.getInt(A0w, A0c.A0C)).A0d(bundle.getInt(A0l, A0c.A08)).A0e(bundle.getInt(A0m, A0c.A09)).A0Z(bundle.getInt(A0d, A0c.A03)).A0p(bundle.getInt(A17, A0c.A0J)).A0q(bundle.getInt(A18, A0c.A0K)).A0c(bundle.getInt(A0j, A0c.A07));
        return p5.A14();
    }

    public static String A03(int i) {
        return A0r + A04(18, 1, 25) + Integer.toString(i, 36);
    }

    public final int A06() {
        if (this.A0L == -1 || this.A0A == -1) {
            return -1;
        }
        return this.A0A * this.A0L;
    }

    public final P5 A07() {
        return new P5(this);
    }

    public final ZM A08(int i) {
        return A07().A0c(i).A14();
    }

    @Deprecated
    public final ZM A09(DrmInitData drmInitData) {
        return A07().A0u(drmInitData).A14();
    }

    public final boolean A0A(ZM zm) {
        if (this.A0X.size() != zm.A0X.size()) {
            return false;
        }
        for (int i = 0; i < i; i++) {
            if (!Arrays.equals(this.A0X.get(i), zm.A0X.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ZM zm = (ZM) obj;
        if ((this.A00 == 0 || zm.A00 == 0 || this.A00 == zm.A00) && this.A0H == zm.A0H && this.A0E == zm.A0E && this.A04 == zm.A04 && this.A0D == zm.A0D && this.A0B == zm.A0B && this.A0M == zm.A0M && this.A0L == zm.A0L && this.A0A == zm.A0A && this.A0F == zm.A0F && this.A0I == zm.A0I && this.A06 == zm.A06 && this.A0G == zm.A0G && this.A0C == zm.A0C && this.A08 == zm.A08 && this.A09 == zm.A09 && this.A03 == zm.A03 && this.A0J == zm.A0J && this.A0K == zm.A0K && this.A07 == zm.A07 && Float.compare(this.A01, zm.A01) == 0 && Float.compare(this.A02, zm.A02) == 0 && AbstractC2471gE.A1E(this.A0T, zm.A0T) && AbstractC2471gE.A1E(this.A0U, zm.A0U) && AbstractC2471gE.A1E(this.A0R, zm.A0R) && AbstractC2471gE.A1E(this.A0S, zm.A0S)) {
            boolean zA1E = AbstractC2471gE.A1E(this.A0W, zm.A0W);
            if (A0a[3].length() != 6) {
                A0a[4] = "nG6HCFSp8c766cr1voUDj";
                if (zA1E && AbstractC2471gE.A1E(this.A0V, zm.A0V) && Arrays.equals(this.A0Y, zm.A0Y) && AbstractC2471gE.A1E(this.A0P, zm.A0P)) {
                    ColorInfo colorInfo = this.A0N;
                    ColorInfo colorInfo2 = zm.A0N;
                    String[] strArr = A0a;
                    if (strArr[1].length() == strArr[0].length()) {
                        A0a[2] = "HTpgcJ44puf5X";
                        if (AbstractC2471gE.A1E(colorInfo, colorInfo2) && AbstractC2471gE.A1E(this.A0O, zm.A0O) && A0A(zm)) {
                            boolean zA1E2 = AbstractC2471gE.A1E(this.A0Q, zm.A0Q);
                            String[] strArr2 = A0a;
                            if (strArr2[1].length() != strArr2[0].length()) {
                                throw new RuntimeException();
                            }
                            A0a[2] = "h5nQYT3Rl4hjq";
                            if (zA1E2) {
                                return true;
                            }
                        }
                    }
                }
            }
            throw new RuntimeException();
        }
        return false;
    }

    public final int hashCode() {
        int result;
        if (this.A00 == 0) {
            int i = 17 * 31;
            if (this.A0T == null) {
                result = 0;
            } else {
                String str = this.A0T;
                if (A0a[6].charAt(14) != 'X') {
                    String[] strArr = A0a;
                    strArr[7] = "zmW8E8Ny1kxg0";
                    strArr[5] = "VIitTNc94RYS1";
                    result = str.hashCode();
                } else {
                    result = str.hashCode();
                }
            }
            int i2 = i + result;
            if (A0a[2].length() != 13) {
                throw new RuntimeException();
            }
            A0a[4] = "8AIBPZBfP8ojcV7rqooUELhh3jRU";
            int result2 = i2 * 31;
            int result3 = (result2 + (this.A0U != null ? this.A0U.hashCode() : 0)) * 31;
            int result4 = this.A0V == null ? 0 : this.A0V.hashCode();
            int result5 = (((result3 + result4) * 31) + this.A0H) * 31;
            int result6 = this.A0E;
            int result7 = (((result5 + result6) * 31) + this.A04) * 31;
            int result8 = this.A0D;
            int result9 = (((result7 + result8) * 31) + (this.A0R == null ? 0 : this.A0R.hashCode())) * 31;
            int result10 = this.A0P == null ? 0 : this.A0P.hashCode();
            int result11 = (((result9 + result10) * 31) + (this.A0Q == null ? 0 : this.A0Q.hashCode())) * 31;
            int result12 = this.A0S == null ? 0 : this.A0S.hashCode();
            int result13 = (result11 + result12) * 31;
            int iHashCode = this.A0W != null ? this.A0W.hashCode() : 0;
            int result14 = this.A0B;
            int result15 = (((((result13 + iHashCode) * 31) + result14) * 31) + ((int) this.A0M)) * 31;
            int result16 = this.A0L;
            int result17 = (((result15 + result16) * 31) + this.A0A) * 31;
            int result18 = Float.floatToIntBits(this.A01);
            int result19 = (((result17 + result18) * 31) + this.A0F) * 31;
            int result20 = Float.floatToIntBits(this.A02);
            int result21 = (((result19 + result20) * 31) + this.A0I) * 31;
            int result22 = this.A06;
            int result23 = (((result21 + result22) * 31) + this.A0G) * 31;
            int result24 = this.A0C;
            int result25 = (((result23 + result24) * 31) + this.A08) * 31;
            int result26 = this.A09;
            int result27 = (((result25 + result26) * 31) + this.A03) * 31;
            int result28 = this.A0J;
            int result29 = (((result27 + result28) * 31) + this.A0K) * 31;
            int result30 = this.A07;
            this.A00 = result29 + result30;
        }
        return this.A00;
    }

    public final String toString() {
        StringBuilder sbAppend = new StringBuilder().append(A04(5, 7, Sdk.SDKError.Reason.TPAT_ERROR_VALUE)).append(this.A0T);
        String strA04 = A04(0, 2, 40);
        return sbAppend.append(strA04).append(this.A0U).append(strA04).append(this.A0S).append(strA04).append(this.A0W).append(strA04).append(this.A0R).append(strA04).append(this.A05).append(strA04).append(this.A0V).append(A04(2, 3, 49)).append(this.A0L).append(strA04).append(this.A0A).append(strA04).append(this.A01).append(A04(14, 4, 116)).append(this.A06).append(strA04).append(this.A0G).append(A04(12, 2, 16)).toString();
    }
}
