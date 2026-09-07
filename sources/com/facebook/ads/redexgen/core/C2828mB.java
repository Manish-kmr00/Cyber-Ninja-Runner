package com.facebook.ads.redexgen.core;

import android.os.Handler;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mB, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2828mB implements B8 {
    public static byte[] A0E;
    public static String[] A0F = {"gvO2SkJ6judPPNAAbU10EdMFrysfMOoq", "C8fayNw08H03MAMa0MYSKK0pyo1qSvcR", "zD", "tQ435k35SGtCPZ", "PU5xmRYaUesfDikXgdcM0c", "Sj", "IzP0LuOvX3krWKzZjoX9w767Mf8waFqk", "fiC8qpcDm8TluoxAfEpO8PomLrdxugFO"};
    public C3B A00;
    public C14318t A01;
    public String A02;
    public boolean A03;
    public final int A04;
    public final Handler A05;
    public final AdSize A06;
    public final AnonymousClass28 A07;
    public final C2699k1 A08;
    public final A7 A09;
    public final EnumC1472Al A0A;
    public final B9 A0B;
    public final Runnable A0C;
    public final String A0D;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A0E = new byte[]{-47, -46, -125, -45, -49, -60, -58, -56, -48, -56, -47, -41, -125, -52, -47, -125, -43, -56, -42, -45, -46, -47, -42, -56};
    }

    static {
        A05();
        D5.A02();
    }

    public C2828mB(C2699k1 c2699k1, String str, EnumC1472Al enumC1472Al, AdSize adSize, int i) {
        this.A08 = c2699k1;
        this.A0D = str;
        this.A0A = enumC1472Al;
        this.A06 = adSize;
        this.A04 = i;
        this.A0B = new B9(this.A08);
        this.A0B.A0R(this);
        this.A07 = new AnonymousClass28();
        this.A03 = true;
        this.A05 = new Handler();
        this.A0C = new C1761Mh(this);
        this.A09 = c2699k1.A0A();
        DynamicLoaderFactory.makeLoader(this.A08).getInitApi().onAdLoadInvoked(this.A08);
    }

    private List<C2873mv> A04() {
        C14318t c14318t = this.A01;
        ArrayList arrayList = new ArrayList(c14318t.A02());
        for (C14298r c14298rA04 = c14318t.A04(); c14298rA04 != null; c14298rA04 = c14318t.A04()) {
            AnonymousClass23 anonymousClass23A00 = this.A07.A00(this.A08, AdPlacementType.NATIVE);
            if (anonymousClass23A00 != null && anonymousClass23A00.A8a() == AdPlacementType.NATIVE) {
                C2873mv nativeAdapter = (C2873mv) anonymousClass23A00;
                nativeAdapter.A0L(this.A08, new C1762Mi(this, arrayList, nativeAdapter), this.A09, new AnonymousClass38(c14298rA04.A04(), c14318t.A05(), this.A0D, c14318t.A05().A0C()), C2615ie.A0K());
            }
        }
        return arrayList;
    }

    public final void A06() {
        this.A03 = false;
        this.A05.removeCallbacks(this.A0C);
    }

    public final void A07() {
        try {
            this.A0B.A0Q(new B6(this.A08, this.A0D, this.A06 != null ? new C1502Cf(this.A06.getWidth(), this.A06.getHeight()) : null, this.A0A, this.A04, new C1476Aq(this.A08, null, null, null), AbstractC1508Cl.A01(C14499m.A0M(this.A08)), this.A02, null, new C2821m4()));
        } catch (C1469Ah e) {
            AD4(C1468Ag.A02(e));
        }
    }

    public final void A08(C3B c3b) {
        this.A00 = c3b;
    }

    public final void A09(String str) {
        this.A02 = str;
    }

    public final boolean A0A() {
        return this.A01 == null || this.A01.A0I();
    }

    @Override // com.facebook.ads.redexgen.core.B8
    public final void AD4(C1468Ag c1468Ag) {
        if (this.A03) {
            this.A05.postDelayed(this.A0C, 1800000L);
        }
        if (this.A00 != null) {
            this.A00.AD4(c1468Ag);
        }
    }

    @Override // com.facebook.ads.redexgen.core.B8
    public final void AFG(C2602iR c2602iR) {
        C14318t c14318tA00 = c2602iR.A00();
        if (c14318tA00 != null) {
            if (this.A03) {
                long jA0A = c14318tA00.A05().A0A();
                if (jA0A == 0) {
                    jA0A = 1800000;
                }
                this.A05.postDelayed(this.A0C, jA0A);
            }
            this.A01 = c14318tA00;
            List<C2873mv> listA04 = A04();
            if (this.A00 != null) {
                boolean zIsEmpty = listA04.isEmpty();
                String[] strArr = A0F;
                if (strArr[7].charAt(9) == strArr[6].charAt(9)) {
                    throw new RuntimeException();
                }
                A0F[0] = "Ma8ASQR7F1ZvPn5hHoXinNcVvjUetiuh";
                if (zIsEmpty) {
                    this.A00.AD4(C1468Ag.A01(AdErrorType.NO_FILL, A03(0, 0, 63)));
                    return;
                } else {
                    this.A00.AED(listA04);
                    return;
                }
            }
            return;
        }
        throw new IllegalStateException(A03(0, 24, 18));
    }
}
