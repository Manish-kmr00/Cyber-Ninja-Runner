package com.facebook.ads.redexgen.core;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ax, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2149ax implements InterfaceC1669Iq {
    public TransitionDrawable A00;
    public TransitionDrawable A01;
    public final int A03;
    public final Drawable A04;
    public final Drawable A05;
    public final View A07;
    public final Handler A06 = new Handler();
    public EnumC1668Ip A02 = EnumC1668Ip.A04;

    public C2149ax(View view, int i, Drawable drawable, Drawable drawable2) {
        this.A03 = i;
        this.A07 = view;
        this.A05 = drawable;
        this.A04 = drawable2;
        this.A01 = new TransitionDrawable(new Drawable[]{drawable, drawable2});
        this.A01.setCrossFadeEnabled(true);
        this.A00 = new TransitionDrawable(new Drawable[]{drawable2, drawable});
        this.A00.setCrossFadeEnabled(true);
        D3.A0Q(this.A07, this.A01);
    }

    private void A04(boolean z) {
        this.A06.removeCallbacksAndMessages(null);
        if (z) {
            this.A02 = EnumC1668Ip.A05;
            D3.A0Q(this.A07, this.A00);
            this.A00.startTransition(this.A03);
            this.A06.postDelayed(new b0(this), this.A03);
            return;
        }
        D3.A0Q(this.A07, this.A05);
        this.A02 = EnumC1668Ip.A04;
    }

    private void A05(boolean z) {
        this.A06.removeCallbacksAndMessages(null);
        if (z) {
            this.A02 = EnumC1668Ip.A03;
            D3.A0Q(this.A07, this.A01);
            this.A01.startTransition(this.A03);
            this.A06.postDelayed(new b1(this), this.A03);
            return;
        }
        D3.A0Q(this.A07, this.A04);
        this.A02 = EnumC1668Ip.A02;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1669Iq
    public final void A40(boolean z, boolean z2) {
        if (z2) {
            A04(z);
        } else {
            A05(z);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1669Iq
    public final EnumC1668Ip A91() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1669Iq
    public final void cancel() {
        EnumC1668Ip enumC1668Ip;
        this.A06.removeCallbacksAndMessages(null);
        this.A01.resetTransition();
        this.A00.resetTransition();
        if (this.A02 == EnumC1668Ip.A03) {
            enumC1668Ip = EnumC1668Ip.A04;
        } else {
            enumC1668Ip = EnumC1668Ip.A02;
        }
        this.A02 = enumC1668Ip;
    }
}
