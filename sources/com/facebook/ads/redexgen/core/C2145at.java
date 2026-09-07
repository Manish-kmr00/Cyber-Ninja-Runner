package com.facebook.ads.redexgen.core;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.at, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2145at implements InterfaceC1669Iq {
    public static byte[] A06;
    public ValueAnimator A00;
    public EnumC1668Ip A01 = EnumC1668Ip.A04;
    public final int A02;
    public final int A03;
    public final int A04;
    public final View A05;

    static {
        A05();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 16);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A06 = new byte[]{49, 32, Base64.padSymbol, 49, 6, 42, 41, 42, 55};
    }

    public C2145at(View view, int i, int i2, int i3) {
        this.A02 = i;
        this.A05 = view;
        this.A04 = i2;
        this.A03 = i3;
    }

    private void A06(int i, int i2) {
        this.A01 = i == this.A04 ? EnumC1668Ip.A03 : EnumC1668Ip.A05;
        this.A00 = ObjectAnimator.ofInt((TextView) this.A05, A04(0, 9, 85), i, i2);
        this.A00.setEvaluator(new ArgbEvaluator());
        this.A00.setDuration(this.A02);
        this.A00.addListener(new C1675Iw(this, i, i2));
        this.A00.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(int i, int i2, boolean z) {
        if (z) {
            A06(i, i2);
        } else {
            ((TextView) this.A05).setTextColor(i2);
            this.A01 = i2 == this.A03 ? EnumC1668Ip.A02 : EnumC1668Ip.A04;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1669Iq
    public final void A40(boolean z, boolean z2) {
        int endColor = z2 ? this.A03 : this.A04;
        int startColor = z2 ? this.A04 : this.A03;
        A07(endColor, startColor, z);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1669Iq
    public final EnumC1668Ip A91() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1669Iq
    public final void cancel() {
        if (this.A00 != null) {
            this.A00.cancel();
        }
    }
}
