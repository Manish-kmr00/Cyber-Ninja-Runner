package com.facebook.ads.redexgen.core;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.d7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2280d7 extends AbstractC13515q<C2255ci> {
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public DQ A04;
    public DR A05;
    public String A06;
    public List<C1629Hc> A07;
    public boolean A08;
    public final SparseBooleanArray A09 = new SparseBooleanArray();
    public final AbstractC2855md A0A;
    public final C14067t A0B;
    public final C2699k1 A0C;
    public final A7 A0D;
    public final C1518Cv A0E;
    public final C2291dI A0F;
    public final JL A0G;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public C2280d7(C2699k1 c2699k1, List<C1629Hc> list, AbstractC2855md abstractC2855md, A7 a7, C14067t c14067t, JL jl, C1518Cv c1518Cv, DR dr, String str, int i, int i2, int i3, int i4, C2291dI c2291dI, DQ dq) {
        this.A0C = c2699k1;
        this.A0D = a7;
        this.A0B = c14067t;
        this.A0G = jl;
        this.A0E = c1518Cv;
        this.A05 = dr;
        this.A0A = abstractC2855md;
        this.A07 = list;
        this.A00 = i;
        this.A03 = i4;
        this.A06 = str;
        this.A01 = i3;
        this.A02 = i2;
        this.A0F = c2291dI;
        this.A04 = dq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC13515q
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final C2255ci A0D(ViewGroup viewGroup, int i) {
        return new C2255ci(AbstractC1604Gd.A00(new C1597Fw(this.A0C, this.A0D, this.A05, this.A0A, null, this.A0G, this.A0E).A0N(this.A04).A0Q(), this.A03, this.A06, this.A0F), this.A09, this.A0G, this.A00, this.A01, this.A02, this.A07.size(), this.A0C, this.A0A.A1c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC13515q
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A0E(C2255ci c2255ci, int i) {
        c2255ci.A0k(this.A07.get(i), this.A0D, this.A0B, this.A0E, this.A06);
        if (!this.A08 && i == 0) {
            c2255ci.AIL();
            this.A08 = true;
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC13515q
    public final int A0C() {
        return this.A07.size();
    }
}
