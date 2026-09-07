package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2079Zl implements QQ {
    public static String[] A01 = {"", "", "iCliAypVoqzC0fx0BJXwi", "cFtA", "ks94OJZY24YP0W", "zWHYKq", "smr4D72sS6PujANkMfaeYcGk", "ag4eND"};
    public final C2048Yf A00 = new C2048Yf();

    @MetaExoPlayerCustomization("Should be final")
    public abstract void A0H(int i, long j);

    public final int A00() {
        long jA6x = A6x();
        long jA7i = A7i();
        if (jA6x == -9223372036854775807L || jA7i == -9223372036854775807L) {
            return 0;
        }
        if (jA7i == 0) {
            return 100;
        }
        long j = 100 * jA6x;
        if (A01[3].length() != 4) {
            throw new RuntimeException();
        }
        A01[4] = "KOrcxd9hxYrcdf";
        return AbstractC2471gE.A07((int) (j / jA7i), 0, 100);
    }

    public void A01() {
        AJL(false);
    }

    public final void A02() {
        A03(A7X());
    }

    public final void A03(int i) {
        A0H(i, -9223372036854775807L);
    }

    public final void A04(long j) {
        A0H(A7X(), j);
    }
}
