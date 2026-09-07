package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1597Fw {
    public boolean A00;
    public View A03;
    public AF A04;
    public C2615ie A05;
    public CZ A06;
    public DQ A07;
    public DQ A08;
    public C2154b5 A09;
    public final View A0A;
    public final AbstractC2855md A0B;
    public final C2699k1 A0C;
    public final A7 A0D;
    public final C1518Cv A0E;
    public final DR A0F;
    public final JL A0G;
    public int A02 = 0;
    public int A01 = 1;

    public C1597Fw(C2699k1 c2699k1, A7 a7, DR dr, AbstractC2855md abstractC2855md, View view, JL jl, C1518Cv c1518Cv) {
        this.A0C = c2699k1;
        this.A0D = a7;
        this.A0F = dr;
        this.A0B = abstractC2855md;
        this.A0A = view;
        this.A0G = jl;
        this.A0E = c1518Cv;
    }

    public final C1597Fw A0G(int i) {
        this.A01 = i;
        return this;
    }

    public final C1597Fw A0H(int i) {
        this.A02 = i;
        return this;
    }

    public final C1597Fw A0I(View view) {
        this.A03 = view;
        return this;
    }

    public final C1597Fw A0J(AF af) {
        this.A04 = af;
        return this;
    }

    public final C1597Fw A0K(C2615ie c2615ie) {
        this.A05 = c2615ie;
        return this;
    }

    public final C1597Fw A0L(CZ cz) {
        this.A06 = cz;
        return this;
    }

    public final C1597Fw A0M(DQ dq) {
        this.A07 = dq;
        return this;
    }

    public final C1597Fw A0N(DQ dq) {
        this.A08 = dq;
        return this;
    }

    public final C1597Fw A0O(C2154b5 c2154b5) {
        this.A09 = c2154b5;
        return this;
    }

    public final C1597Fw A0P(boolean z) {
        this.A00 = z;
        return this;
    }

    public final C1598Fx A0Q() {
        return new C1598Fx(this);
    }
}
