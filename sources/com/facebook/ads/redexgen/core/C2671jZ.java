package com.facebook.ads.redexgen.core;

import android.content.Context;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jZ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2671jZ implements AnonymousClass87 {
    public static C2671jZ A07;
    public static byte[] A08;
    public InterfaceC12431j A00;
    public InterfaceC14107x A01;
    public AnonymousClass86 A02;
    public C8M A03;
    public AnonymousClass94 A04;
    public AJ A05;
    public InterfaceC2107aF A06;

    static {
        A07();
    }

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A08 = new byte[]{Ascii.CR, Ascii.SI, 59, Base64.padSymbol, Ascii.FF, Ascii.DC2, 62, 60, Ascii.CR, Ascii.US, 45, 45, 35, 41, 40, -38, Ascii.RS, Ascii.ESC, 46, Ascii.ESC, -38, 35, 40, 35, 46, 35, Ascii.ESC, 38, 35, 52, Ascii.US, Ascii.RS, Ascii.FS, Ascii.SI, Ascii.SUB, Ascii.EM, Ascii.FS, Ascii.RS, -3, Ascii.SI, Ascii.GS, Ascii.GS, 19, Ascii.EM, Ascii.CAN, -18, Ascii.VT, Ascii.RS, Ascii.VT, -13, Ascii.CAN, 19, Ascii.RS, 19, Ascii.VT, Ascii.SYN, 19, 36, Ascii.SI, Ascii.SO};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized void A0C(C2698k0 c2698k0) {
        if (this.A06 != null) {
            return;
        }
        this.A03 = A01(c2698k0);
        this.A06 = A05(c2698k0, this.A03, A03(c2698k0));
        A09(c2698k0, A00(c2698k0, this.A06));
        A0A(c2698k0, this.A06);
        A0B(c2698k0, this.A06);
        if (this.A06 != null) {
            this.A06.A6T();
        }
    }

    public static C7N A00(C2698k0 c2698k0, InterfaceC2107aF interfaceC2107aF) {
        if (!C14499m.A1k(c2698k0) || interfaceC2107aF == null) {
            return null;
        }
        return C7O.A00().A00(interfaceC2107aF);
    }

    public static C8M A01(C2698k0 c2698k0) {
        return C8N.A00().A00(c2698k0, new C2678jg());
    }

    public static synchronized C2671jZ A02() {
        if (A07 == null) {
            A07 = new C2671jZ();
        }
        return A07;
    }

    public static JR A03(C2698k0 c2698k0) {
        if (!C14499m.A1g(c2698k0)) {
            return null;
        }
        return C1688Jj.A01(c2698k0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AnonymousClass87
    /* JADX INFO: renamed from: A04, reason: merged with bridge method [inline-methods] */
    public final synchronized InterfaceC2107aF A95() {
        return this.A06;
    }

    public static InterfaceC2107aF A05(C2698k0 c2698k0, C8M c8m, JR jr) {
        if (!C14499m.A2c(c2698k0) || jr == null || ProcessUtils.isRemoteRenderingProcess()) {
            return null;
        }
        return K6.A00().A00(c2698k0, c8m, jr, BE.A04(c2698k0), new C2672ja(new B6(c2698k0, A06(0, 0, 9), null, EnumC1472Al.A08, 0, new C1476Aq(), AbstractC1508Cl.A01(C14499m.A0M(c2698k0)), null, null, new C2821m4()), c2698k0), K4.A00().A00());
    }

    public static void A08() {
        AbstractC1477Au.A05(A06(32, 28, 52), A06(8, 24, 68), A06(0, 8, 99));
    }

    public static void A09(C2698k0 c2698k0, C7N c7n) {
        if (!C14499m.A1k(c2698k0) || c7n == null) {
            return;
        }
        C7L.A00().A00(c7n, c2698k0);
    }

    public static void A0A(C2698k0 c2698k0, InterfaceC2107aF interfaceC2107aF) {
        if (!C14499m.A0l(c2698k0) || interfaceC2107aF == null) {
            return;
        }
        new C13957i(c2698k0, interfaceC2107aF, new C13967j(), DynamicLoaderImpl.getBidderTokenProviderApi().A00());
    }

    public static void A0B(C2698k0 c2698k0, InterfaceC2107aF interfaceC2107aF) {
        if (interfaceC2107aF == null) {
            return;
        }
        AbstractC14539q.A00(c2698k0, interfaceC2107aF);
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass87
    public final A7 A6d(C2698k0 c2698k0) {
        return C2639j3.A01(c2698k0);
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass87
    public final synchronized AnonymousClass86 A6u(AnonymousClass85 anonymousClass85) {
        if (this.A02 == null) {
            this.A02 = new C2673jb(this);
        }
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass87
    public final synchronized InterfaceC14107x A76() {
        if (this.A01 == null) {
            this.A01 = new C2700k2();
        }
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass87
    public final synchronized C8M A7b(AnonymousClass85 anonymousClass85) {
        if (this.A03 == null) {
            this.A03 = A01(anonymousClass85.A02());
        }
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass87
    public final synchronized C8Z A7d(AnonymousClass85 anonymousClass85) {
        return new C2687jp(anonymousClass85);
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass87
    public final synchronized AnonymousClass88 A7n(AnonymousClass85 anonymousClass85) {
        return new M3(this, anonymousClass85);
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass87
    public final synchronized InterfaceC12431j A82(AnonymousClass85 anonymousClass85) {
        if (!C14499m.A12(anonymousClass85)) {
            return null;
        }
        if (this.A00 == null) {
            this.A00 = AbstractC12441k.A00().A00(new C2676je(anonymousClass85));
        }
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass87
    public final synchronized C8A A8o(AnonymousClass85 anonymousClass85) {
        return new C2674jc(anonymousClass85);
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass87
    public final C2698k0 A8p(Context context) {
        C2698k0 sdkContext = AnonymousClass84.A00();
        if (sdkContext == null) {
            C2698k0 sdkContext2 = new C2698k0(context, this);
            AnonymousClass84.A01(sdkContext2);
            return sdkContext2;
        }
        return sdkContext;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass87
    public final synchronized AJ A8q(C2698k0 c2698k0) {
        if (this.A05 == null) {
            this.A05 = new C2647jB(c2698k0);
        }
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass87
    public final synchronized AnonymousClass94 A8w() {
        if (this.A04 == null) {
            this.A04 = new AnonymousClass94();
            A08();
        }
        return this.A04;
    }
}
