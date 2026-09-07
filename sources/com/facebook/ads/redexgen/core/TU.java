package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TU implements UK {
    public static byte[] A03;
    public static final UO A04;
    public UL A00;
    public AbstractC2005Wm A01;
    public boolean A02;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 112);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{Ascii.DLE, 55, 63, 58, 51, 50, 118, 34, 57, 118, 50, 51, 34, 51, 36, 59, 63, 56, 51, 118, 52, 63, 34, 37, 34, 36, 51, 55, 59, 118, 34, 47, 38, 51};
    }

    static {
        A02();
        A04 = new UO() { // from class: com.facebook.ads.redexgen.X.TV
            @Override // com.facebook.ads.redexgen.core.UO
            public final UK[] A5D() {
                return TU.A04();
            }

            @Override // com.facebook.ads.redexgen.core.UO
            public final /* synthetic */ UK[] A5E(Uri uri, Map map) {
                return UN.A01(this, uri, map);
            }
        };
    }

    public static C2447fq A00(C2447fq c2447fq) {
        c2447fq.A0f(0);
        return c2447fq;
    }

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    private boolean A03(WJ wj) throws IOException {
        C2001Wi c2001Wi = new C2001Wi();
        if (!c2001Wi.A05(wj, true) || (c2001Wi.A04 & 2) != 2) {
            return false;
        }
        int length = Math.min(c2001Wi.A00, 8);
        C2447fq c2447fq = new C2447fq(length);
        wj.AG1(c2447fq.A0l(), 0, length);
        if (TW.A01(A00(c2447fq))) {
            this.A01 = new TW();
        } else if (TR.A06(A00(c2447fq))) {
            this.A01 = new TR();
        } else {
            if (!TT.A02(A00(c2447fq))) {
                return false;
            }
            this.A01 = new TT();
        }
        return true;
    }

    public static /* synthetic */ UK[] A04() {
        return new UK[]{new TU()};
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final void AA0(UL ul) {
        this.A00 = ul;
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final int AGT(WJ wj, C1952Ug c1952Ug) throws IOException {
        AbstractC2388es.A02(this.A00);
        if (this.A01 == null) {
            if (A03(wj)) {
                wj.AHr();
            } else {
                throw Q6.A01(A01(0, 34, 38), null);
            }
        }
        if (!this.A02) {
            InterfaceC1957Uo interfaceC1957UoAJX = this.A00.AJX(0, 1);
            this.A00.A6E();
            this.A01.A0H(this.A00, interfaceC1957UoAJX);
            this.A02 = true;
        }
        return this.A01.A0B(wj, c1952Ug);
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final void AGj() {
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final void AIC(long j, long j2) {
        if (this.A01 != null) {
            this.A01.A0G(j, j2);
        }
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final boolean AJB(WJ wj) throws IOException {
        try {
            return A03(wj);
        } catch (Q6 unused) {
            return false;
        }
    }
}
