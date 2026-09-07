package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ke, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2738ke extends AnonymousClass24 {
    public static byte[] A03;
    public static String[] A04 = {"G2rh", "Fb5x", "6CyVQJjLjUxkB4NOtEwwqOuY7kB2daf", "v2svMG5ZVzKjVXyH1MXvdM9krQWCKsNq", "oRWr7RpHwOoI3beQIRyDA09DO9LlUwST", "SjgxBMhR0kRV74MEQavsGpgIJGrbvWLl", "8l9W", "lapvzpZuNASF"};
    public View A00;
    public final C13646d A01;
    public final M5 A02;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 16);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        byte[] bArr = {69, 103, 104, 104, 105, 114, 38, 118, 116, 99, 117, 99, 104, 114, 38, 104, 115, 106, 106, 38, 103, 98, 80, 111, 99, 113};
        if (A04[7].length() == 31) {
            throw new RuntimeException();
        }
        A04[0] = "ScK1";
        A03 = bArr;
    }

    static {
        A03();
    }

    public C2738ke(C13646d c13646d) {
        this.A02 = c13646d.A09();
        this.A01 = c13646d;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass24
    public final void A0C() {
        this.A02.A0F().A4K();
        BP.A00(new C2740kg(this));
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass24
    public final void A0D() {
        this.A02.A0F().A4N();
        BP.A00(new C2739kf(this));
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass24
    public final void A0E(View view) {
        if (view != null) {
            M5 m5 = this.A02;
            String[] strArr = A04;
            if (strArr[6].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            A04[0] = "eqHc";
            m5.A0F().A4M();
            this.A00 = view;
            this.A01.A07().removeAllViews();
            this.A01.A07().addView(this.A00);
            if ((this.A00 instanceof C2496ge) || (this.A00 instanceof C1536Dn)) {
                AbstractC1473An.A01(this.A01.A05(), this.A00, this.A01.A0A());
            }
            C1768Mt controller = this.A01.A08();
            if (controller != null) {
                controller.A0L();
            }
            BP.A00(new C2741kh(this));
            this.A01.A0B(this.A01.A07(), this.A00);
            if (C14499m.A1A(this.A01.A07().getContext())) {
                final F9 f9 = new F9();
                this.A01.A0D(f9);
                f9.A0C(this.A01.getPlacementId());
                f9.A0B(this.A01.A07().getContext().getPackageName());
                if (this.A01.A08() != null && this.A01.A08().A0J() != null) {
                    f9.A09(this.A01.A08().A0J().A0C());
                }
                if (this.A00 instanceof C2496ge) {
                    f9.A0A(((C2496ge) this.A00).getViewabilityChecker());
                }
                this.A00.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.facebook.ads.redexgen.X.6l
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view2) {
                        if (this.A00.A00 != null) {
                            f9.setBounds(0, 0, this.A00.A00.getWidth(), this.A00.A00.getHeight());
                            f9.A0D(!f9.A0E());
                        }
                        return true;
                    }
                });
                this.A00.getOverlay().add(f9);
                return;
            }
            return;
        }
        throw new IllegalStateException(A02(0, 26, 22));
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass24
    public final void A0F(AnonymousClass23 anonymousClass23) {
        this.A02.A0F().A4L(this.A01.A08() != null);
        if (this.A01.A08() != null) {
            this.A01.A08().A0M();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass24
    public final void A0G(C1468Ag c1468Ag) {
        this.A02.A0F().A3D(C1517Cu.A01(this.A01.A04()), c1468Ag.A03().getErrorCode(), c1468Ag.A04());
        BP.A00(new C2742ki(this, c1468Ag));
    }
}
