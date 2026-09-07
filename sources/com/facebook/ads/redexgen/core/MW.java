package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.facebook.ads.Ad;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class MW extends AbstractC2822m5 {
    public static String[] A02 = {"eAQfPHHoyWilLfBxOFaJj1G06pGOxPq", "94FVrmFRVghPmyms9ar5cFWRdDurlkVe", "0NqQX4CUu3LD8PHaDMvmRAbh4clEtoM7", "DpSRaNejvtQ52XA7I6oeLqqk6ldlwRKU", "AVeirdKHq7BiC91JmOFjEM59wAwHTkmS", "1THCMBeh6DIPctxeAaB65wntvUu4aFha", "yEsJBiLTEnojRHdtAiiv5fZXbmAhiMSc", "YuG6RWvr5fcVmyx3SnaQUPOafyGz2fG"};
    public C2813lv A00;
    public final C2800li A01;

    public MW(C2800li c2800li, String str) {
        super(c2800li.A0B, str, A00(c2800li));
        this.A01 = c2800li;
    }

    public static C2799lh A00(C2800li c2800li) {
        return new C2799lh(c2800li);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2822m5
    public final void A08() {
        if (super.A01.A01) {
            this.A05.A5l();
        }
        if (this.A00 != null) {
            this.A00.destroy();
        }
        super.A00.AIS(C3D.A03);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2822m5
    public final void A09() {
        this.A00 = new C2813lv(this.A01, this, A04());
        this.A00.A0J(this.A01.A05, this.A01.A02, this.A01.A08);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2822m5
    public final void A0D(boolean z) {
        this.A05.AIt(z);
    }

    public final void A0E(Ad ad, String str, AdExperienceType adExperienceType, boolean z) {
        if (super.A00.A6K()) {
            return;
        }
        this.A01.A02(ad);
        if (this.A00 != null) {
            this.A00.A0J(str, adExperienceType, z);
            return;
        }
        this.A01.A05 = str;
        this.A01.A02 = adExperienceType;
        this.A01.A08 = z;
        if (AbstractC14529p.A07(this.A02) && AbstractC14529p.A09(this.A02)) {
            A05();
        } else {
            A09();
        }
    }

    public final void A0F(RewardData rewardData) {
        this.A01.A03 = rewardData;
        if (super.A01.A01) {
            super.A01.A0F(2003, C3Y.A00(new Bundle(), rewardData));
        } else if (this.A00 != null) {
            this.A00.A0I(rewardData);
        }
    }

    public final boolean A0G() {
        if (this.A00 != null) {
            return this.A00.A0K();
        }
        return this.A01.A01 > 0 && C1517Cu.A00() > this.A01.A01;
    }

    public final boolean A0H() {
        if (this.A00 != null) {
            return this.A00.A0L();
        }
        return super.A00.A6f() == C3D.A05;
    }

    public final boolean A0I(Ad ad, RewardedVideoAd.RewardedVideoShowAdConfig rewardedVideoShowAdConfig) {
        int iA00 = ((C7F) rewardedVideoShowAdConfig).A00();
        long jA01 = ((C7F) rewardedVideoShowAdConfig).A01();
        if (super.A00.A6L()) {
            return false;
        }
        this.A01.A02(ad);
        String[] strArr = A02;
        String str = strArr[7];
        String str2 = strArr[0];
        int length = str.length();
        int appOrientation = str2.length();
        if (length == appOrientation) {
            String[] strArr2 = A02;
            strArr2[5] = "m9KaRECdYgffkM0tCirP5ynC5R03VfN7";
            strArr2[6] = "WVyWW47u948M29zNqYDy5rdzHxlGG88k";
            if (super.A01.A01) {
                A0A(iA00);
                return true;
            }
            C2813lv c2813lv = this.A00;
            String[] strArr3 = A02;
            String str3 = strArr3[2];
            String str4 = strArr3[1];
            int iCharAt = str3.charAt(27);
            int appOrientation2 = str4.charAt(27);
            if (iCharAt != appOrientation2) {
                String[] strArr4 = A02;
                strArr4[7] = "SVQKcBS7FHKRAHC3EplGepZBNeGcwFJ";
                strArr4[0] = "IfCkczTPSOxE6DmqSLPQVuiWAstWVdL";
                if (c2813lv != null) {
                    return this.A00.A0M(iA00, jA01);
                }
                this.A00 = new C2813lv(this.A01, this, A04());
                this.A00.A0M(iA00, jA01);
                return false;
            }
        }
        throw new RuntimeException();
    }
}
