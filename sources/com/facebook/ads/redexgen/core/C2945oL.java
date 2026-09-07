package com.facebook.ads.redexgen.core;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2945oL {
    public final InterfaceC2949oP A00;
    public final String A01;
    public final Collection<C2959oc> A02;
    public final Collection<C2959oc> A03;
    public final List<Rect> A04;

    public C2945oL(String str, InterfaceC2949oP interfaceC2949oP, List<Rect> rects, Collection<C2959oc> collection, Collection<C2959oc> collection2) {
        this.A01 = str;
        this.A00 = interfaceC2949oP;
        this.A04 = new ArrayList(rects);
        this.A02 = collection;
        this.A03 = collection2;
    }
}
