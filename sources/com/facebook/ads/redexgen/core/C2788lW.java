package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2788lW implements InterfaceC13063u {
    private C13073v A00(InterfaceC13053t interfaceC13053t) {
        return (C13073v) interfaceC13053t.A74();
    }

    public final void A01(InterfaceC13053t interfaceC13053t) {
        if (!interfaceC13053t.A9H()) {
            interfaceC13053t.AIr(0, 0, 0, 0);
            return;
        }
        float fA8I = A8I(interfaceC13053t);
        float fA8h = A8h(interfaceC13053t);
        float elevation = AbstractC13093x.A00(fA8I, fA8h, interfaceC13053t.A8g());
        int vPadding = (int) Math.ceil(elevation);
        float elevation2 = AbstractC13093x.A01(fA8I, fA8h, interfaceC13053t.A8g());
        int iCeil = (int) Math.ceil(elevation2);
        interfaceC13053t.AIr(vPadding, iCeil, vPadding, iCeil);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13063u
    public final ColorStateList A6r(InterfaceC13053t interfaceC13053t) {
        return A00(interfaceC13053t).A05();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13063u
    public final float A7l(InterfaceC13053t interfaceC13053t) {
        return interfaceC13053t.A75().getElevation();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13063u
    public final float A8I(InterfaceC13053t interfaceC13053t) {
        return A00(interfaceC13053t).A03();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13063u
    public final float A8N(InterfaceC13053t interfaceC13053t) {
        return A8h(interfaceC13053t) * 2.0f;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13063u
    public final float A8O(InterfaceC13053t interfaceC13053t) {
        return A8h(interfaceC13053t) * 2.0f;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13063u
    public final float A8h(InterfaceC13053t interfaceC13053t) {
        return A00(interfaceC13053t).A04();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13063u
    public final void AA4() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13063u
    public final void AA6(InterfaceC13053t interfaceC13053t, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        C13073v background = new C13073v(colorStateList, f);
        interfaceC13053t.AIQ(background);
        View view = interfaceC13053t.A75();
        view.setClipToOutline(true);
        view.setElevation(f2);
        AId(interfaceC13053t, f3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13063u
    public final void ACf(InterfaceC13053t interfaceC13053t) {
        AId(interfaceC13053t, A8I(interfaceC13053t));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13063u
    public final void AEe(InterfaceC13053t interfaceC13053t) {
        AId(interfaceC13053t, A8I(interfaceC13053t));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13063u
    public final void AIP(InterfaceC13053t interfaceC13053t, ColorStateList colorStateList) {
        A00(interfaceC13053t).A08(colorStateList);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13063u
    public final void AIV(InterfaceC13053t interfaceC13053t, float f) {
        interfaceC13053t.A75().setElevation(f);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13063u
    public final void AId(InterfaceC13053t interfaceC13053t, float f) {
        A00(interfaceC13053t).A07(f, interfaceC13053t.A9H(), interfaceC13053t.A8g());
        A01(interfaceC13053t);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13063u
    public final void AIp(InterfaceC13053t interfaceC13053t, float f) {
        A00(interfaceC13053t).A06(f);
    }
}
