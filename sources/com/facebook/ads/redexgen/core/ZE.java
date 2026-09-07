package com.facebook.ads.redexgen.core;

import android.os.Bundle;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ZE implements InterfaceC1775Nb {
    public final ZI A00;

    @Deprecated
    public final E1 A01;
    public final ZG A02;
    public final PP A03;

    @Deprecated
    public final ZF A04;
    public final ZC A05;
    public final String A06;
    public static String[] A07 = {"75xJFduIMxyPuYUkVz483sJBnAcsAGMt", "TRlLUM7UN7d6ZMpgKgKtaSof78G6koYS", "QzsC9zybTqk1FRWX4xvOCDJWDQUStUU5", "7", "vby9mdVdCOnOHbl0WKbwu7GFn2k2d8Kf", "RTPWPqup43k0H5h14hfzvYa9TxJMYAZX", "Oumckoc1zDinSUsB0wRSQGt6gXPsEBlZ", "aaUdNUfilNdKQDVoR1mlcUyZ7NAG5upS"};
    public static final ZE A09 = new PH().A05();
    public static final InterfaceC1774Na<ZE> A08 = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.ZK
        @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
        public final InterfaceC1775Nb A6V(Bundle bundle) {
            return ZE.A00(bundle);
        }
    };

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static ZE A00(Bundle bundle) {
        String str = (String) AbstractC2388es.A01(bundle.getString(A02(0), ""));
        Bundle bundle2 = bundle.getBundle(A02(1));
        ZG zg = bundle2 == null ? ZG.A07 : (ZG) ZG.A06.A6V(bundle2);
        Bundle bundle3 = bundle.getBundle(A02(2));
        ZC zc = bundle3 == null ? ZC.A0Z : (ZC) ZC.A0Y.A6V(bundle3);
        String strA02 = A02(3);
        String[] strArr = A07;
        if (strArr[0].charAt(15) == strArr[5].charAt(15)) {
            throw new RuntimeException();
        }
        A07[4] = "7tcWmieQ6urbX1gsYJsT08orlnHIuPr9";
        Bundle bundle4 = bundle.getBundle(strA02);
        return new ZE(str, bundle4 == null ? E1.A00 : (E1) ZI.A06.A6V(bundle4), null, zg, zc);
    }

    public ZE(String str, E1 e1, ZF zf, ZG zg, ZC zc) {
        this.A06 = str;
        this.A03 = zf;
        this.A04 = zf;
        this.A02 = zg;
        this.A05 = zc;
        this.A00 = e1;
        this.A01 = e1;
    }

    public static String A02(int i) {
        return Integer.toString(i, 36);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZE)) {
            return false;
        }
        ZE ze = (ZE) obj;
        if (AbstractC2471gE.A1E(this.A06, ze.A06) && this.A00.equals(ze.A00) && AbstractC2471gE.A1E(this.A03, ze.A03) && AbstractC2471gE.A1E(this.A02, ze.A02) && AbstractC2471gE.A1E(this.A05, ze.A05)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A06.hashCode();
        int i = result * 31;
        int result2 = this.A03 != null ? this.A03.hashCode() : 0;
        int result3 = (((i + result2) * 31) + this.A02.hashCode()) * 31;
        int result4 = this.A00.hashCode();
        return ((result3 + result4) * 31) + this.A05.hashCode();
    }
}
