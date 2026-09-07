package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2576hy implements InterfaceC1570Ev {
    public static byte[] A01;
    public final /* synthetic */ ViewOnClickListenerC1755Lz A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 72);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-36, -38, -52, -39, -58, -55, -36, -51, -51, -52, -39, -52, -53, -58, -54, -45, -48, -54, -46, -58, -48, -56, -55, -58, -43, -56, -35, -48, -50, -56, -37, -48, -42, -43};
    }

    public C2576hy(ViewOnClickListenerC1755Lz viewOnClickListenerC1755Lz) {
        this.A00 = viewOnClickListenerC1755Lz;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1570Ev
    public final void AEM(String str) {
        this.A00.A0C.setProgress(100);
        ((C2572hu) this.A00).A05 = false;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1570Ev
    public final void AEO(String str) {
        ((C2572hu) this.A00).A05 = true;
        this.A00.A0B.setUrl(str);
        if (this.A00.A00 > 1) {
            this.A00.A0H(A00(0, 34, 31));
        }
        ViewOnClickListenerC1755Lz.A02(this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1570Ev
    public final void AEj(int i) {
        if (((C2572hu) this.A00).A05) {
            this.A00.A0C.setProgress(i);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1570Ev
    public final void AEl(String str) {
        this.A00.A0B.setTitle(str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1570Ev
    public final void AEo() {
        this.A00.A0A.ACY(14);
    }
}
