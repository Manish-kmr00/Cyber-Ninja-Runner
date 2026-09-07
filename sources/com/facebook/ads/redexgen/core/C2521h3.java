package com.facebook.ads.redexgen.core;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.h3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2521h3 extends AbstractC13515q<C2282d9> {
    public int A00;
    public int A01;
    public int A02;
    public DR A03;
    public JL A04;
    public String A05;
    public List<C1629Hc> A06;
    public final SparseBooleanArray A07 = new SparseBooleanArray();
    public final AbstractC2855md A08;
    public final C14067t A09;
    public final C2699k1 A0A;
    public final A7 A0B;
    public final C2615ie A0C;
    public final C1518Cv A0D;
    public final C1734Ld A0E;
    public final C2154b5 A0F;

    public C2521h3(C2699k1 c2699k1, List<C1629Hc> list, AbstractC2855md abstractC2855md, A7 a7, C2615ie c2615ie, DR dr, String str, C1734Ld c1734Ld, C2154b5 c2154b5) {
        this.A0A = c2699k1;
        this.A0B = a7;
        this.A0C = c2615ie;
        this.A09 = c2615ie.A11();
        this.A04 = c2615ie.A1B();
        this.A0D = c2615ie.A1A();
        this.A03 = dr;
        this.A08 = abstractC2855md;
        this.A06 = list;
        this.A05 = str;
        this.A0E = c1734Ld;
        this.A0F = c2154b5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC13515q
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final C2282d9 A0D(ViewGroup viewGroup, int i) {
        return new C2282d9(FR.A00(new C1597Fw(this.A0A, this.A0B, this.A03, this.A08, null, this.A04, this.A0D).A0O(this.A0F).A0K(this.A0C).A0Q(), this.A0C, this.A05, this.A0E), this.A07, this.A04, this.A06.size(), this.A0A, this.A08.A1c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC13515q
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A0E(C2282d9 c2282d9, int i) {
        C1629Hc c1629Hc = this.A06.get(i);
        c2282d9.A0k(this.A04);
        c2282d9.A0j(c1629Hc, this.A0B, this.A09, this.A0D, this.A05, this.A00, this.A02, this.A01);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC13515q
    public final int A0C() {
        return this.A06.size();
    }

    public final void A0G(int i, int i2, int i3) {
        boolean needsUpdate = i != this.A00;
        this.A00 = i;
        this.A02 = i2;
        this.A01 = i3;
        if (needsUpdate) {
            A06();
        }
    }

    public final void A0H(JL jl) {
        this.A04 = jl;
    }
}
