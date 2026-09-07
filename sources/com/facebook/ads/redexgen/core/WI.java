package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.DrmInitData;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WI {
    public static String[] A0A = {"6iG2pzuEQycoVFq725g4qJVnVpIWZtlR", "55l141mBLH5WkPDbxXMnALrHQI6q7lEr", "qJTDm2F9TSXG", "DtWX", "J", "d1C1KGlOvszMCpNlse9bACflAWEVGthH", "0mTI1KWBNfYIDi0cnokbmIS0fHm5LYjn", "iC8Ub00tDVOO7seA02PucuhNsAEH3abh"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public WC A04;
    public WZ A05;
    public final InterfaceC1957Uo A06;
    public final C1994Wb A07 = new C1994Wb();
    public final C2447fq A09 = new C2447fq(1);
    public final C2447fq A08 = new C2447fq();

    public WI(InterfaceC1957Uo interfaceC1957Uo) {
        this.A06 = interfaceC1957Uo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C1993Wa A00() {
        C1993Wa encryptionBox;
        int i = this.A07.A06.A02;
        if (this.A07.A07 != null) {
            encryptionBox = this.A07.A07;
        } else {
            encryptionBox = this.A05.A00(i);
        }
        if (encryptionBox == null || !encryptionBox.A03) {
            return null;
        }
        return encryptionBox;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        C1993Wa c1993WaA00 = A00();
        if (c1993WaA00 == null) {
            return;
        }
        C2447fq c2447fq = this.A07.A0H;
        if (c1993WaA00.A00 != 0) {
            c2447fq.A0g(c1993WaA00.A00);
        }
        if (this.A07.A06(this.A01)) {
            c2447fq.A0g(c2447fq.A0M() * 6);
        }
    }

    public final int A04() {
        C2447fq c2447fq;
        int vectorSize;
        C1993Wa c1993WaA00 = A00();
        if (c1993WaA00 == null) {
            return 0;
        }
        if (c1993WaA00.A00 != 0) {
            c2447fq = this.A07.A0H;
            vectorSize = c1993WaA00.A00;
        } else {
            byte[] initVectorData = c1993WaA00.A04;
            this.A08.A0j(initVectorData, initVectorData.length);
            c2447fq = this.A08;
            vectorSize = initVectorData.length;
        }
        boolean zA06 = this.A07.A06(this.A01);
        this.A09.A00[0] = (byte) ((zA06 ? 128 : 0) | vectorSize);
        this.A09.A0f(0);
        InterfaceC1957Uo interfaceC1957Uo = this.A06;
        C2447fq initializationVectorData = this.A09;
        interfaceC1957Uo.AHx(initializationVectorData, 1);
        this.A06.AHx(c2447fq, vectorSize);
        if (!zA06) {
            return vectorSize + 1;
        }
        C2447fq c2447fq2 = this.A07.A0H;
        int iA0M = c2447fq2.A0M();
        c2447fq2.A0g(-2);
        int i = (iA0M * 6) + 2;
        this.A06.AHx(c2447fq2, i);
        return vectorSize + 1 + i;
    }

    public final void A05() {
        this.A07.A01();
        this.A01 = 0;
        this.A02 = 0;
        this.A00 = 0;
        this.A03 = 0;
    }

    public final void A06(long j) {
        for (int i = this.A01; i < searchIndex && this.A07.A00(i) < j; i++) {
            if (this.A07.A0G[i]) {
                this.A03 = i;
            }
        }
    }

    public final void A07(DrmInitData drmInitData) {
        C1993Wa encryptionBox = this.A05.A00(this.A07.A06.A02);
        String str = encryptionBox != null ? encryptionBox.A02 : null;
        InterfaceC1957Uo interfaceC1957Uo = this.A06;
        ZM zm = this.A05.A07;
        String[] strArr = A0A;
        String schemeType = strArr[0];
        if (schemeType.charAt(0) == strArr[1].charAt(0)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0A;
        strArr2[6] = "lpqHmBvcUgjM3Ysqc1Ebun64n1SVP7eZ";
        strArr2[5] = "0GYMuHaUcEVaktTpZSAbFa1nNlov1DMX";
        interfaceC1957Uo.A6U(zm.A09(drmInitData.A01(str)));
    }

    public final void A08(WZ wz, WC wc) {
        this.A05 = (WZ) AbstractC2388es.A01(wz);
        this.A04 = (WC) AbstractC2388es.A01(wc);
        this.A06.A6U(wz.A07);
        A05();
    }

    public final boolean A09() {
        this.A01++;
        this.A00++;
        if (this.A00 != this.A07.A0C[this.A02]) {
            return true;
        }
        this.A02++;
        this.A00 = 0;
        return false;
    }
}
