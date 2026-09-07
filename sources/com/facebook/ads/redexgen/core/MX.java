package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.RewardData;
import java.util.EnumSet;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class MX extends AbstractC2822m5 {
    public static final C3J A02 = new C2810ls();
    public C2816ly A00;
    public final C2812lu A01;

    public MX(C2812lu c2812lu, String str) {
        super(c2812lu.A05(), str, A02.A5J(c2812lu));
        this.A01 = c2812lu;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2822m5
    public final void A08() {
        if (this.A00 != null) {
            this.A00.destroy();
        }
        super.A00.AIS(C3D.A03);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2822m5
    public final void A09() {
        this.A00 = new C2816ly(this.A01, this, A04());
        this.A00.A0G(this.A01.A0B(), this.A01.A07());
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2822m5
    public final void A0D(boolean z) {
        this.A05.AIt(z);
    }

    public final void A0E(InterstitialAd interstitialAd, EnumSet<CacheFlag> cacheFlags, String str) {
        if (super.A00.A6K()) {
            return;
        }
        this.A01.A0D(interstitialAd);
        if (this.A00 != null) {
            this.A00.A0G(cacheFlags, str);
            return;
        }
        this.A01.A0K(cacheFlags);
        this.A01.A0H(str);
        if (AbstractC14529p.A07(this.A02) && AbstractC14529p.A08(this.A02)) {
            A05();
        } else {
            A09();
        }
    }

    public final void A0F(RewardData rewardData) {
        this.A01.A0F(rewardData);
        if (super.A01.A01) {
            super.A01.A0F(1013, C3Y.A00(new Bundle(), rewardData));
        }
    }

    public final boolean A0G() {
        if (this.A00 != null) {
            return this.A00.A0H();
        }
        return this.A01.A00() > 0 && C1517Cu.A00() > this.A01.A00();
    }

    public final boolean A0H() {
        if (this.A00 != null) {
            return this.A00.A0I();
        }
        return super.A00.A6f() == C3D.A05;
    }

    public final boolean A0I(InterstitialAd interstitialAd, InterstitialAd.InterstitialShowAdConfig interstitialShowAdConfig) {
        if (super.A00.A6L()) {
            return false;
        }
        this.A01.A0D(interstitialAd);
        if (super.A01.A01) {
            A0A(-1);
            return true;
        }
        if (this.A00 != null) {
            return this.A00.A0J();
        }
        this.A00 = new C2816ly(this.A01, this, A04());
        this.A00.A0J();
        return false;
    }
}
