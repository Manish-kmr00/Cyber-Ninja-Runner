package com.facebook.ads.redexgen.core;

import android.view.View;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2838mL implements C2B {
    public static byte[] A02;
    public static String[] A03 = {"ebJtInVgM8lwtLsL8CqjQvfHZTFWXyTj", "MRT4Iz3aNiJEaKRUIrDApfghDq01n6sB", "qhIcWii6jOsLbVLe4G", "jd0Ec4CahT7YYBjB568owPC0gY4s3zOU", "RPiMcfQYBdHC0SSG6XvNc0NsjlYurq5U", "E74vSWGMqEH8Jt4WlgBEkdQ8nTEO7fKB", "DEVdv4rr1ByH9p4ezSF9ryFdFyWOGnGy", "23RYwIDt1nJrIBpc57"};
    public final /* synthetic */ C1768Mt A00;
    public final /* synthetic */ Runnable A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{90, 93, 91, Ascii.SI, 10, Ascii.SO, Ascii.CR, 10, 32, 3, Ascii.FF, Ascii.FF, 7, Ascii.DLE, 66, Ascii.VT, Ascii.SI, Ascii.DC2, Ascii.DLE, 7, 17, 17, Ascii.VT, Ascii.CR, Ascii.FF, 66, 4, Ascii.VT, Ascii.DLE, 7, 6, Ascii.FS, Ascii.GS, 49, Ascii.DC2, Ascii.GS, Ascii.GS, Ascii.SYN, 1, 63, Ascii.FS, Ascii.DC4, Ascii.DC4, Ascii.SUB, Ascii.GS, Ascii.DC4, 58, Ascii.RS, 3, 1, Ascii.SYN, 0, 0, Ascii.SUB, Ascii.FS, Ascii.GS};
    }

    static {
        A01();
    }

    public C2838mL(C1768Mt c1768Mt, Runnable runnable) {
        this.A00 = c1768Mt;
        this.A01 = runnable;
    }

    @Override // com.facebook.ads.redexgen.core.C2B
    public final void ACU(InterfaceC2887n9 interfaceC2887n9) {
        this.A00.A02.A0F().A4Q();
        this.A00.A07.A0C();
    }

    @Override // com.facebook.ads.redexgen.core.C2B
    public final void ACV(InterfaceC2887n9 interfaceC2887n9, View view) {
        this.A00.A02.A0F().A4P(interfaceC2887n9 == ((AbstractC2835mI) this.A00).A00);
        if (interfaceC2887n9 != ((AbstractC2835mI) this.A00).A00) {
            return;
        }
        this.A00.A0H().removeCallbacks(this.A01);
        AnonymousClass23 anonymousClass23 = ((AbstractC2835mI) this.A00).A01;
        C1768Mt c1768Mt = this.A00;
        String[] strArr = A03;
        if (strArr[6].charAt(14) != strArr[5].charAt(14)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[0] = "gfJNIdbF2FrCa8qL8kuytpSS0QUlrsrj";
        strArr2[1] = "KzSpIsxhAVssntgB7OlLodebxm4ynnXJ";
        ((AbstractC2835mI) c1768Mt).A01 = interfaceC2887n9;
        this.A00.A01 = view;
        if (!this.A00.A0C) {
            this.A00.A07.A0F(interfaceC2887n9);
        } else {
            this.A00.A07.A0E(view);
            this.A00.A0Q(anonymousClass23);
        }
    }

    @Override // com.facebook.ads.redexgen.core.C2B
    public final void ACW(InterfaceC2887n9 interfaceC2887n9) {
        AbstractC1477Au.A05(A00(31, 25, 61), A00(8, 23, 44), A00(0, 8, 37));
        this.A00.A02.A0F().A4S();
        this.A00.A07.A0D();
        this.A00.A0O();
    }

    @Override // com.facebook.ads.redexgen.core.C2B
    public final void ADc(InterfaceC2887n9 interfaceC2887n9, C1468Ag c1468Ag) {
        this.A00.A02.A0F().A4R(interfaceC2887n9 == ((AbstractC2835mI) this.A00).A00, c1468Ag.A03().getErrorCode());
        if (interfaceC2887n9 != ((AbstractC2835mI) this.A00).A00) {
            return;
        }
        this.A00.A0H().removeCallbacks(this.A01);
        this.A00.A0Q(interfaceC2887n9);
        this.A00.AD4(c1468Ag);
    }
}
