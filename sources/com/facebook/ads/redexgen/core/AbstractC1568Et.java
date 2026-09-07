package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Et, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1568Et implements InterfaceC2059Yq, InterfaceC1854Qi {
    public static String[] A0E = {"oB8o3Th5", "AnBFzSQbBg7XonHstrV3SXteCYipj8mo", "WENq94c1TqAN1gNb1fPTxU5Kb6Tz0I9", "", "Eik8wychv9XYh12j89wk1XzQBHMCrxnW", "ZFvCNUCB", "84HfrcJvuRCzsvJUAR9q", "8Dt8DsXmJbmtS34K0KUNF631ZMZAqH3y"};
    public int A00;
    public int A01;
    public long A02;
    public long A04;
    public C1857Ql A05;
    public RK A06;
    public InterfaceC2180bV A07;
    public boolean A08;
    public boolean A09;
    public ZM[] A0A;
    public final int A0C;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D18870411: Adding start stall debug reason")
    public MI A0B = MI.A09;
    public final P6 A0D = new P6();
    public long A03 = Long.MIN_VALUE;

    public abstract void A1Z();

    public abstract void A1a(long j, boolean z) throws EK;

    public abstract void A1c(ZM[] zmArr, long j, long j2) throws EK;

    public AbstractC1568Et(int i) {
        this.A0C = i;
    }

    private final int A1O() {
        return this.A00;
    }

    private void A1P(long j, boolean z) throws EK {
        this.A08 = false;
        this.A02 = j;
        this.A03 = j;
        A1a(j, z);
    }

    public final int A1Q(long j) {
        return ((InterfaceC2180bV) AbstractC2388es.A01(this.A07)).AJ8(j - this.A04);
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Keep track of the non-adjusted timestamp")
    public final int A1R(P6 p6, C2014Ww c2014Ww, int i) {
        int iAGX = ((InterfaceC2180bV) AbstractC2388es.A01(this.A07)).AGX(p6, c2014Ww, i);
        if (iAGX == -4) {
            if (c2014Ww.A05()) {
                this.A03 = Long.MIN_VALUE;
                return this.A08 ? -4 : -3;
            }
            c2014Ww.A00 = c2014Ww.A01;
            c2014Ww.A01 += this.A04;
            this.A03 = Math.max(this.A03, c2014Ww.A01);
        } else if (iAGX == -5) {
            Object objA01 = AbstractC2388es.A01(p6.A00);
            String[] strArr = A0E;
            String str = strArr[5];
            String str2 = strArr[0];
            int length = str.length();
            int result = str2.length();
            if (length != result) {
                throw new RuntimeException();
            }
            A0E[6] = "ZS";
            ZM zm = (ZM) objA01;
            if (zm.A0M != Long.MAX_VALUE) {
                p6.A00 = zm.A07().A0s(zm.A0M + this.A04).A14();
            }
        }
        return iAGX;
    }

    public final EK A1S(Throwable th, ZM zm, int i) {
        return A1T(th, zm, false, i);
    }

    public final EK A1T(Throwable th, ZM zm, boolean z, int i) {
        int iA03 = 4;
        if (zm != null && !this.A09) {
            this.A09 = true;
            try {
                int formatSupport = AJR(zm);
                iA03 = AbstractC1847Qb.A03(formatSupport);
            } catch (EK unused) {
            } finally {
                this.A09 = false;
            }
        }
        return EK.A04(th, getName(), A1O(), zm, iA03, z, i);
    }

    public final P6 A1U() {
        this.A0D.A00();
        return this.A0D;
    }

    public final C1857Ql A1V() {
        return (C1857Ql) AbstractC2388es.A01(this.A05);
    }

    public final RK A1W() {
        return (RK) AbstractC2388es.A01(this.A06);
    }

    public void A1X() throws EK {
    }

    public void A1Y() {
    }

    public void A1b(boolean z, boolean z2) throws EK {
    }

    public final boolean A1d() {
        return A9f() ? this.A08 : ((InterfaceC2180bV) AbstractC2388es.A01(this.A07)).AAT();
    }

    public final ZM[] A1e() {
        return (ZM[]) AbstractC2388es.A01(this.A0A);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final void A5n() {
        AbstractC2388es.A08(this.A01 == 1);
        this.A0D.A00();
        this.A01 = 0;
        this.A07 = null;
        this.A0A = null;
        this.A08 = false;
        A1Z();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final void A6B(C1857Ql c1857Ql, ZM[] zmArr, InterfaceC2180bV interfaceC2180bV, long j, boolean z, boolean z2, long j2, long j3) throws EK {
        AbstractC2388es.A08(this.A01 == 0);
        this.A05 = c1857Ql;
        this.A01 = 1;
        A1b(z, z2);
        AHg(zmArr, interfaceC2180bV, j2, j3);
        A1P(j, z);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final InterfaceC1854Qi A73() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public PD A8J() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "D18870411: Adding start stall debug reason")
    public final MI A8z() {
        return this.A0B;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final int A90() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final InterfaceC2180bV A93() {
        return this.A07;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq, com.facebook.ads.redexgen.core.InterfaceC1854Qi
    public final int A9D() {
        return this.A0C;
    }

    @Override // com.facebook.ads.redexgen.core.QS
    public void A9Y(int i, Object obj) throws EK {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final boolean A9f() {
        return this.A03 == Long.MIN_VALUE;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final void A9z(int i, RK rk) {
        this.A00 = i;
        this.A06 = rk;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final boolean AAC() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final void ABp() throws IOException {
        ((InterfaceC2180bV) AbstractC2388es.A01(this.A07)).ABm();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final void AHg(ZM[] zmArr, InterfaceC2180bV interfaceC2180bV, long j, long j2) throws EK {
        AbstractC2388es.A08(!this.A08);
        this.A07 = interfaceC2180bV;
        if (this.A03 == Long.MIN_VALUE) {
            this.A03 = j;
        }
        this.A0A = zmArr;
        this.A04 = j2;
        A1c(zmArr, j, j2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final void AHs(long j) throws EK {
        A1P(j, false);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final void AIT() {
        this.A08 = true;
    }

    public int AJT() throws EK {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final void start() throws EK {
        AbstractC2388es.A08(this.A01 == 1);
        this.A01 = 2;
        A1X();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final void stop() {
        AbstractC2388es.A08(this.A01 == 2);
        this.A01 = 1;
        String[] strArr = A0E;
        if (strArr[5].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        A0E[2] = "cRJyAHvNnFjWqvJO5qcvTUpDvTM";
        A1Y();
    }
}
