package com.facebook.ads.redexgen.core;

import android.os.Handler;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CH {
    public float A00;
    public float A01;
    public long A02;
    public boolean A03;
    public boolean A04;
    public final Handler A05;
    public final CG A06;

    public CH(int i, float f, long j, Handler handler, CG cg) {
        this(i, cg, handler);
        this.A02 = j;
        this.A01 = f;
    }

    public CH(int i, CG cg) {
        this(i, cg, new Handler());
    }

    public CH(int i, CG cg, Handler handler) {
        this.A04 = false;
        this.A00 = i;
        this.A06 = cg;
        this.A05 = handler;
        this.A02 = 250L;
        this.A01 = 0.25f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        this.A00 -= this.A01;
        this.A06.AEg(this.A00);
        if (this.A00 <= 0.0f && !this.A03) {
            this.A03 = true;
            this.A06.ACi();
            this.A04 = false;
        }
    }

    public final boolean A04() {
        return this.A00 <= 0.0f;
    }

    public final boolean A05() {
        return this.A04;
    }

    public final boolean A06() {
        if (!A05()) {
            return false;
        }
        this.A04 = false;
        return true;
    }

    public final boolean A07() {
        if (A04() && !this.A03) {
            this.A03 = true;
            this.A06.ACi();
        }
        if (A04() || A05()) {
            return false;
        }
        this.A04 = true;
        this.A06.AEg(this.A00);
        this.A05.postDelayed(new C2593iH(this), this.A02);
        return true;
    }
}
