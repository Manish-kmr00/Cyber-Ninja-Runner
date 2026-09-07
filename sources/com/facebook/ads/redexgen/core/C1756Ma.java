package com.facebook.ads.redexgen.core;

import android.os.Handler;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ma, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1756Ma extends AbstractC2835mI {
    public static byte[] A00;
    public static String[] A01 = {"vV6RQP0QGAizSnvHrhrEiTJKYqnkk7vR", "gVueu7WJkm8gI", "", "raAPQvYZN3qaAVuN8G4E0NVfm2Y0LRUe", "w5hc", "", "RHGb3VvP2c2qxldOqnFEpaAIYmVmOJg8", "ZdfM9COnhESAyQW1NqvAdN1Ku5n51qre"};

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-43, -45, -32, -110, -31, -32, -34, -21, -110, -27, -41, -26, -110, -31, -32, -110, -28, -41, -23, -45, -28, -42, -41, -42, -110, -24, -37, -42, -41, -31, -110, -45, -42, -27, -80, -79, 98, -93, -90, -93, -78, -74, -89, -76, 98, -76, -89, -93, -90, -69, 98, -74, -79, 98, -75, -89, -74, 98, -76, -89, -71, -93, -76, -90, 98, -79, -80};
    }

    static {
        A02();
    }

    public C1756Ma(C2699k1 c2699k1, AnonymousClass37 anonymousClass37) {
        super(c2699k1, anonymousClass37);
    }

    private C2826m9 A00(Runnable runnable) {
        return new C2826m9(this, runnable);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2835mI
    public final void A0P() {
        AbstractC2859mh abstractC2859mh = (AbstractC2859mh) this.A01;
        abstractC2859mh.A00(this.A08.A00);
        abstractC2859mh.A01(this.A08.A01);
        abstractC2859mh.A0J();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2835mI
    public final void A0R(AnonymousClass23 anonymousClass23, C14318t c14318t, C14298r c14298r, AnonymousClass38 anonymousClass38) {
        N0 n0 = (N0) anonymousClass23;
        C2827mA c2827mA = new C2827mA(this, anonymousClass38, n0);
        if (C14499m.A2V(this.A0B)) {
            Handler handlerA0H = A0H();
            C14328u c14328uA05 = c14318t.A05();
            String[] strArr = A01;
            if (strArr[3].charAt(31) != strArr[7].charAt(31)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[5] = "";
            strArr2[2] = "";
            handlerA0H.postDelayed(c2827mA, c14328uA05.A05());
        }
        n0.A0K(this.A0B, A00(c2827mA), anonymousClass38, this.A08.A06, this.A08.A04, this.A08.A05);
    }

    public final void A0a(RewardData rewardData) {
        if (this.A01 != null) {
            if (this.A01.A8a() == AdPlacementType.REWARDED_VIDEO) {
                AbstractC2859mh rewardedVideoAdapter = (AbstractC2859mh) this.A01;
                rewardedVideoAdapter.A02(rewardData);
                return;
            }
            throw new IllegalStateException(A01(0, 34, 82));
        }
        throw new IllegalStateException(A01(34, 33, 34));
    }
}
