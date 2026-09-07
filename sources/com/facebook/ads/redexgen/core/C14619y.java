package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14619y {
    public static String[] A04 = {"VndfGBIDInq1AmGKWEXIYtH", "X1ufgR44W1Z84U", "n", "", "za8Aa", "xjBfTCMiG1bFh7NB9hwMlLVXQHNbTqdl", "vkDSrNK7CnANJUjGZxXcCXY", "njWPP"};
    public EnumC14589v A01 = EnumC14589v.A03;
    public EnumC14599w A02 = EnumC14599w.A06;
    public EnumC14609x A03 = EnumC14609x.A02;
    public EnumC14579u A00 = EnumC14579u.A02;

    public final void A00() {
        this.A00 = EnumC14579u.A03;
    }

    public final void A01() {
        this.A02 = EnumC14599w.A04;
    }

    public final void A02() {
        this.A02 = EnumC14599w.A05;
    }

    public final void A03() {
        this.A03 = EnumC14609x.A03;
    }

    public final boolean A04() {
        if (this.A02 != EnumC14599w.A06) {
            EnumC14599w enumC14599w = this.A02;
            String[] strArr = A04;
            if (strArr[6].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[6] = "r152EQyYeE04Ovy9QYMfnLx";
            strArr2[0] = "I6yTYbMajK96Zgvn6mn7gLC";
            if (enumC14599w != EnumC14599w.A02 && this.A02 != EnumC14599w.A05) {
                return false;
            }
        }
        return true;
    }

    public final boolean A05() {
        return this.A02 == EnumC14599w.A06 || this.A02 == EnumC14599w.A02;
    }

    public final boolean A06() {
        return this.A03 == EnumC14609x.A03;
    }

    public final boolean A07() {
        return this.A00 == EnumC14579u.A03;
    }
}
