package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Looper;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.Timeline;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6O, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6O extends RC implements InterfaceC2169bK {
    public long A00;
    public InterfaceC2357eN A01;
    public InterfaceC2600iP<InterfaceExecutorC2450ft> A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final int A06;
    public final PP A07;
    public final ZE A08;
    public final TO A09;
    public final InterfaceC2163bE A0A;
    public final InterfaceC2308dZ A0B;
    public final InterfaceC2335e1 A0C;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.iP != com.google.common.base.Supplier<com.google.android.exoplayer2.util.ReleasableExecutor> */
    @MetaExoPlayerCustomization("Allow for passing a new drmSessionManager")
    public C6O(ZE ze, InterfaceC2308dZ interfaceC2308dZ, InterfaceC2163bE interfaceC2163bE, TO to, InterfaceC2335e1 interfaceC2335e1, int i, InterfaceC2600iP<InterfaceExecutorC2450ft> interfaceC2600iP) {
        this.A07 = (PP) AbstractC2388es.A01(ze.A03);
        this.A08 = ze;
        this.A0B = interfaceC2308dZ;
        this.A0A = interfaceC2163bE;
        this.A09 = to == null ? TO.A00 : to;
        this.A0C = interfaceC2335e1;
        this.A06 = i;
        this.A04 = true;
        this.A00 = -9223372036854775807L;
        this.A02 = interfaceC2600iP;
    }

    private void A00() {
        final Timeline c6g = new C6G(this.A00, this.A05, false, this.A03, null, this.A08);
        if (this.A04) {
            Timeline timeline = new C8W(c6g) { // from class: com.facebook.ads.redexgen.X.0y
                @Override // com.facebook.ads.redexgen.core.C8W
                public final C2050Yh A0I(int i, C2050Yh c2050Yh, boolean z) {
                    super.A0I(i, c2050Yh, z);
                    c2050Yh.A05 = true;
                    return c2050Yh;
                }

                @Override // com.facebook.ads.redexgen.core.C8W
                public final C2048Yf A0L(int i, C2048Yf c2048Yf, long j) {
                    super.A0L(i, c2048Yf, j);
                    c2048Yf.A0F = true;
                    return c2048Yf;
                }
            };
            c6g = timeline;
        }
        A05(c6g);
    }

    @Override // com.facebook.ads.redexgen.core.RC
    public final void A09() {
    }

    @Override // com.facebook.ads.redexgen.core.RC
    public final void A0A(InterfaceC2357eN interfaceC2357eN) {
        this.A01 = interfaceC2357eN;
        this.A09.AGC();
        this.A09.AIk((Looper) AbstractC2388es.A01(Looper.myLooper()), A00());
        A00();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2151az
    @MetaExoPlayerCustomization("PlayerId needs to be set")
    public final R7 A5M(R5 r5, InterfaceC2295dM interfaceC2295dM, long j) {
        InterfaceExecutorC2450ft interfaceExecutorC2450ft;
        Q7 q7A58 = this.A0B.A58();
        if (this.A01 != null) {
            q7A58.A3t(this.A01);
        }
        Uri uri = this.A07.A00;
        InterfaceC2164bF interfaceC2164bFA5N = this.A0A.A5N(RK.A03);
        TO to = this.A09;
        TJ tjA01 = A01(r5);
        InterfaceC2335e1 interfaceC2335e1 = this.A0C;
        C2159bA c2159bAA02 = A02(r5);
        String str = this.A07.A04;
        int i = this.A06;
        if (this.A02 != null) {
            interfaceExecutorC2450ft = this.A02.get();
        } else {
            interfaceExecutorC2450ft = null;
        }
        return new C13947h(uri, q7A58, interfaceC2164bFA5N, to, tjA01, interfaceC2335e1, c2159bAA02, this, interfaceC2295dM, str, i, interfaceExecutorC2450ft);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2151az
    public final void ABo() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2169bK
    public final void AF9(long j, boolean z, boolean z2) {
        if (j == -9223372036854775807L) {
            j = this.A00;
        }
        if (!this.A04 && this.A00 == j && this.A05 == z && this.A03 == z2) {
            return;
        }
        this.A00 = j;
        this.A05 = z;
        this.A03 = z2;
        this.A04 = false;
        A00();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2151az
    public final void AGs(R7 r7) {
        ((C13947h) r7).A0a();
    }
}
