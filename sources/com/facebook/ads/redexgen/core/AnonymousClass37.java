package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdExperienceType;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.37, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass37 {
    public static String[] A0E = {"e4QKd0vFJKlBfNQUlIHhfqQvs", "ktN6BUw9VrN2JTOHJ8TIrrXahMZ3fTmV", "DLbbL7kcZ5O", "9b4HlLYHdUSJ33wbgi9UrYdebMHGJs2L", "z1qfKPKzPcrrDsrmM", "3k9SvbOHIOGx0S2BWPTRCyg1cNUtQJE0", "0GDGJhxXKJqU0yOd0NeRuUkLVmalwgCj", "KW1MjCrhBg"};
    public int A00;
    public long A01;
    public RewardData A02;
    public AQ A03;
    public String A04;
    public String A05;
    public boolean A06;
    public final AnonymousClass90 A07;
    public final EnumC1470Aj A08;
    public final EnumC1472Al A09;
    public final String A0A;
    public final EnumSet<CacheFlag> A0B;
    public final int A0C;
    public final AdPlacementType A0D;

    public AnonymousClass37(String str, EnumC1472Al enumC1472Al, AdPlacementType adPlacementType, EnumC1470Aj enumC1470Aj, int i, AnonymousClass90 anonymousClass90) {
        this(str, enumC1472Al, adPlacementType, enumC1470Aj, i, EnumSet.of(CacheFlag.NONE), anonymousClass90);
    }

    public AnonymousClass37(String str, EnumC1472Al enumC1472Al, AdPlacementType adPlacementType, EnumC1470Aj enumC1470Aj, int i, EnumSet<CacheFlag> cacheFlags, AnonymousClass90 anonymousClass90) {
        this.A0A = str;
        this.A0D = adPlacementType;
        this.A08 = enumC1470Aj;
        this.A0C = i;
        this.A0B = cacheFlags;
        this.A09 = enumC1472Al;
        this.A00 = -1;
        this.A07 = anonymousClass90;
    }

    public final B6 A00(C2699k1 c2699k1, C1476Aq c1476Aq, AdExperienceType adExperienceType) {
        return new B6(c2699k1, this.A0A, this.A08 != null ? new C1502Cf(this.A08.A04(), this.A08.A03()) : null, this.A09, this.A0C, c1476Aq, AbstractC1508Cl.A01(C14499m.A0M(c2699k1)), this.A04, adExperienceType != null ? adExperienceType.getAdExperienceType() : null, this.A07);
    }

    public final Set<AdPlacementType> A01() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(2);
        if (this.A0D == AdPlacementType.BANNER && this.A09 == EnumC1472Al.A0D) {
            linkedHashSet.add(AdPlacementType.BANNER);
            AdPlacementType adPlacementType = AdPlacementType.MEDIUM_RECTANGLE;
            String[] strArr = A0E;
            if (strArr[4].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[4] = "dJCx3L7RUa0HYA9jO";
            strArr2[0] = "pYtnX6DZAplUTv76Lm34k0kqX";
            linkedHashSet.add(adPlacementType);
            return linkedHashSet;
        }
        if (this.A0D != null) {
            linkedHashSet.add(this.A0D);
            return linkedHashSet;
        }
        if (this.A08 == null) {
            linkedHashSet.add(AdPlacementType.NATIVE);
            return linkedHashSet;
        }
        if (this.A08 == EnumC1470Aj.A08) {
            linkedHashSet.add(AdPlacementType.INTERSTITIAL);
            return linkedHashSet;
        }
        linkedHashSet.add(AdPlacementType.BANNER);
        return linkedHashSet;
    }

    public final void A02(int i) {
        this.A00 = i;
    }

    public final void A03(long j) {
        this.A01 = j;
    }

    public final void A04(RewardData rewardData) {
        this.A02 = rewardData;
    }

    public final void A05(AQ aq) {
        this.A03 = aq;
    }

    public final void A06(String str) {
        this.A04 = str;
    }

    public final void A07(String str) {
        this.A05 = str;
    }

    public final void A08(boolean z) {
        this.A06 = z;
    }
}
