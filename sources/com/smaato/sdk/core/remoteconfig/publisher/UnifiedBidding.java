package com.smaato.sdk.core.remoteconfig.publisher;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.collections.CollectionUtils;
import com.smaato.sdk.core.util.collections.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class UnifiedBidding {
    private final long bidTimeoutMillis;
    private final Set partners;
    private final double priceGranularity;
    private final String typeOfBidsToSend;

    private UnifiedBidding(double d, String str, long j, Set set) {
        this.typeOfBidsToSend = (String) Objects.requireNonNull(str);
        this.partners = Sets.toImmutableSet((Collection) Objects.requireNonNull(set));
        this.priceGranularity = d;
        this.bidTimeoutMillis = j;
    }

    public double getPriceGranularity() {
        return this.priceGranularity;
    }

    public String getTypeOfBidsToSend() {
        return this.typeOfBidsToSend;
    }

    public long getBidTimeoutMillis() {
        return this.bidTimeoutMillis;
    }

    public Set<Partner> getPartners() {
        return this.partners;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UnifiedBidding unifiedBidding = (UnifiedBidding) obj;
        if (Double.compare(unifiedBidding.priceGranularity, this.priceGranularity) == 0 && this.bidTimeoutMillis == unifiedBidding.bidTimeoutMillis && this.typeOfBidsToSend.equals(unifiedBidding.typeOfBidsToSend)) {
            return CollectionUtils.equalsByElements(this.partners, unifiedBidding.partners);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Double.valueOf(this.priceGranularity), Long.valueOf(this.bidTimeoutMillis), this.typeOfBidsToSend, this.partners);
    }

    static final class Builder {
        private static final Set DEFAULT_PARTNER_SET = Collections.singleton(new Partner.Builder().build());
        private Set partners;
        private Double priceGranularity;
        private Long timeoutMillis;
        private String typeOfBidsToSend;

        Builder() {
        }

        Builder(JSONObject jSONObject) {
            if (jSONObject.optDouble("priceGranularity", -1.0d) != -1.0d) {
                this.priceGranularity = Double.valueOf(jSONObject.optDouble("priceGranularity"));
            }
            if (jSONObject.optLong("timeout", -1L) != -1) {
                this.timeoutMillis = Long.valueOf(jSONObject.optLong("timeout"));
            }
            this.typeOfBidsToSend = jSONObject.optString("bidsSent", null);
            this.partners = Partner.getPartners(jSONObject.optJSONArray("partners"));
        }

        UnifiedBidding build() {
            Double d = this.priceGranularity;
            if (d == null || d.doubleValue() < 0.01d || this.priceGranularity.doubleValue() > 10.0d) {
                this.priceGranularity = Double.valueOf(0.1d);
            }
            Long l = this.timeoutMillis;
            if (l == null || l.longValue() < 500 || this.timeoutMillis.longValue() > 5000) {
                this.timeoutMillis = 1000L;
            }
            if (TextUtils.isEmpty(this.typeOfBidsToSend)) {
                this.typeOfBidsToSend = "WINNER";
            }
            if (this.partners == null) {
                this.partners = DEFAULT_PARTNER_SET;
            }
            return new UnifiedBidding(this.priceGranularity.doubleValue(), this.typeOfBidsToSend, this.timeoutMillis.longValue(), this.partners);
        }
    }
}
