package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import java.io.IOException;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SV implements UK {
    public static String[] A0B = {"K8f68S9rBefm7hcO9rgtzzhmiKpcntQw", "zUi58", "", "CkekzyRW7v", "r8Mk", "LEa3VFljyVwCAGl8ASDI6ctSJGwLabvi", "BaPMVYNostpFPwoU7P3CV4hjiD1zwl8M", "gsDK"};
    public static final UO A0C = new UO() { // from class: com.facebook.ads.redexgen.X.SW
        @Override // com.facebook.ads.redexgen.core.UO
        public final UK[] A5D() {
            return SV.A01();
        }

        @Override // com.facebook.ads.redexgen.core.UO
        public final /* synthetic */ UK[] A5E(Uri uri, Map map) {
            return UN.A01(this, uri, map);
        }
    };
    public long A00;
    public UL A01;
    public SX A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public final SparseArray<YJ> A07;
    public final YI A08;
    public final C2447fq A09;
    public final C2461g4 A0A;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.UK
    public final int AGT(WJ wj, C1952Ug c1952Ug) throws IOException {
        AbstractC2388es.A02(this.A01);
        long jA8E = wj.A8E();
        if ((jA8E != -1) && !this.A08.A0E()) {
            int iA0B = this.A08.A0B(wj, c1952Ug);
            if (A0B[2].length() != 0) {
                throw new RuntimeException();
            }
            A0B[2] = "";
            return iA0B;
        }
        A00(jA8E);
        if (this.A02 != null && this.A02.A0B()) {
            return this.A02.A08(wj, c1952Ug);
        }
        wj.AHr();
        long jA8Y = jA8E != -1 ? jA8E - wj.A8Y() : -1L;
        if ((jA8Y != -1 && jA8Y < 4) || !wj.AG2(this.A09.A0l(), 0, 4, true)) {
            return -1;
        }
        this.A09.A0f(0);
        int iA0C = this.A09.A0C();
        if (iA0C == 441) {
            return -1;
        }
        if (iA0C == 442) {
            wj.AG1(this.A09.A0l(), 0, 10);
            this.A09.A0f(9);
            wj.AJ9((this.A09.A0I() & 7) + 14);
            return 0;
        }
        if (iA0C == 443) {
            wj.AG1(this.A09.A0l(), 0, 2);
            this.A09.A0f(0);
            wj.AJ9(this.A09.A0M() + 6);
            return 0;
        }
        if (((iA0C & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            wj.AJ9(1);
            return 0;
        }
        int i = iA0C & 255;
        YJ yj = this.A07.get(i);
        if (!this.A03) {
            if (yj == null) {
                Y7 c1918Sv = null;
                if (i == 189) {
                    c1918Sv = new T5();
                    this.A04 = true;
                    this.A00 = wj.A8d();
                } else if ((i & 224) == 192) {
                    c1918Sv = new C1904Sh();
                    this.A04 = true;
                    this.A00 = wj.A8d();
                } else if ((i & 240) == 224) {
                    c1918Sv = new C1918Sv();
                    this.A05 = true;
                    this.A00 = wj.A8d();
                }
                if (c1918Sv != null) {
                    c1918Sv.A5S(this.A01, new YS(i, 256));
                    yj = new YJ(c1918Sv, this.A0A);
                    this.A07.put(i, yj);
                }
            }
            if (wj.A8d() > ((this.A04 && this.A05) ? this.A00 + PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                this.A03 = true;
                this.A01.A6E();
            }
        }
        wj.AG1(this.A09.A0l(), 0, 2);
        this.A09.A0f(0);
        int iA0M = this.A09.A0M() + 6;
        if (yj == null) {
            wj.AJ9(iA0M);
            return 0;
        }
        this.A09.A0d(iA0M);
        wj.readFully(this.A09.A0l(), 0, iA0M);
        this.A09.A0f(6);
        yj.A03(this.A09);
        this.A09.A0e(this.A09.A08());
        return 0;
    }

    public SV() {
        this(new C2461g4(0L));
    }

    public SV(C2461g4 c2461g4) {
        this.A0A = c2461g4;
        this.A09 = new C2447fq(4096);
        this.A07 = new SparseArray<>();
        this.A08 = new YI();
    }

    @RequiresNonNull({"output"})
    private void A00(long j) {
        if (!this.A06) {
            this.A06 = true;
            if (this.A08.A0C() != -9223372036854775807L) {
                this.A02 = new SX(this.A08.A0D(), this.A08.A0C(), j);
                this.A01.AID(this.A02.A09());
            } else {
                this.A01.AID(new C1991Vy(this.A08.A0C()));
            }
        }
    }

    public static /* synthetic */ UK[] A01() {
        return new UK[]{new SV()};
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final void AA0(UL ul) {
        this.A01 = ul;
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final void AGj() {
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final void AIC(long j, long j2) {
        boolean z = false;
        boolean resetTimestampAdjuster = this.A0A.A04() == -9223372036854775807L;
        if (!resetTimestampAdjuster) {
            long jA02 = this.A0A.A02();
            if (jA02 != -9223372036854775807L && jA02 != 0 && jA02 != j2) {
                z = true;
            }
            resetTimestampAdjuster = z;
        }
        if (resetTimestampAdjuster) {
            this.A0A.A07(j2);
        }
        if (this.A02 != null) {
            this.A02.A0A(j2);
        }
        for (int i = 0; i < this.A07.size(); i++) {
            this.A07.valueAt(i).A02();
        }
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final boolean AJB(WJ wj) throws IOException {
        byte[] bArr = new byte[14];
        wj.AG1(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        int packStuffingLength = bArr[13] & 7;
        wj.A3x(packStuffingLength);
        wj.AG1(bArr, 0, 3);
        int packStuffingLength2 = bArr[0];
        int i = (packStuffingLength2 & 255) << 16;
        int packStuffingLength3 = bArr[1];
        int i2 = i | ((packStuffingLength3 & 255) << 8);
        int packStuffingLength4 = bArr[2];
        return 1 == ((packStuffingLength4 & 255) | i2);
    }
}
