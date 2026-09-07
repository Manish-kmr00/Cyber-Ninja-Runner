package com.pubmatic.sdk.openwrap.core;

import com.pubmatic.sdk.common.ui.POBCoreReward;
import java.util.Objects;

/* JADX INFO: loaded from: classes13.dex */
public class POBReward implements POBCoreReward {
    public static final int DEFAULT_REWARD_AMOUNT_VALUE = 0;
    public static final String DEFAULT_REWARD_TYPE_LABEL = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7737a;
    private final int b;

    public POBReward(String str, int i) {
        this.f7737a = str;
        this.b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        POBReward pOBReward = (POBReward) obj;
        return this.b == pOBReward.b && this.f7737a.equals(pOBReward.f7737a);
    }

    @Override // com.pubmatic.sdk.common.ui.POBCoreReward
    public int getAmount() {
        return this.b;
    }

    @Override // com.pubmatic.sdk.common.ui.POBCoreReward
    public String getCurrencyType() {
        return this.f7737a;
    }

    public int hashCode() {
        return Objects.hash(this.f7737a, Integer.valueOf(this.b));
    }

    public String toString() {
        return "POBReward{currencyType='" + this.f7737a + "', amount='" + this.b + "'}";
    }
}
