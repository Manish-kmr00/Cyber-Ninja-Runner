package com.smaato.sdk.core.remoteconfig.global;

import com.safedk.android.internal.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class ConfigProperties {
    private final Long locationValidForPeriodMin;
    private final Integer numOfRetriesAfterNetErrorInUb;
    private final Integer sessionIdFrequencyMin;
    private final Double vastAdVisibilityRatio;
    private final Long vastAdVisibilityTimeMillis;

    private ConfigProperties(Integer num, Long l, Double d, Long l2, Integer num2) {
        this.sessionIdFrequencyMin = num;
        this.locationValidForPeriodMin = l;
        this.vastAdVisibilityRatio = d;
        this.vastAdVisibilityTimeMillis = l2;
        this.numOfRetriesAfterNetErrorInUb = num2;
    }

    public Integer getSessionIdFrequencyMin() {
        return this.sessionIdFrequencyMin;
    }

    public Long getLocationValidForPeriodMin() {
        return this.locationValidForPeriodMin;
    }

    public Double getVastAdVisibilityRatio() {
        return this.vastAdVisibilityRatio;
    }

    public Long getVastAdVisibilityTimeMillis() {
        return this.vastAdVisibilityTimeMillis;
    }

    public Integer getNumOfRetriesAfterNetErrorInUb() {
        return this.numOfRetriesAfterNetErrorInUb;
    }

    static final class Builder {
        private Long locationValidForPeriodMin;
        private Integer numOfRetriesAfterNetErrorInUb;
        private Integer sessionIdFrequencyMin;
        private Double vastAdVisibilityRatio;
        private Long vastAdVisibilityTimeMillis;

        Builder() {
        }

        Builder(JSONObject jSONObject) {
            parseProperties(jSONObject);
        }

        ConfigProperties build() {
            Integer num = this.sessionIdFrequencyMin;
            this.sessionIdFrequencyMin = Integer.valueOf(num == null ? 1440 : num.intValue());
            Long l = this.locationValidForPeriodMin;
            this.locationValidForPeriodMin = Long.valueOf(l == null ? d.N : l.longValue());
            Double d = this.vastAdVisibilityRatio;
            this.vastAdVisibilityRatio = Double.valueOf(d == null ? 0.01d : d.doubleValue());
            Long l2 = this.vastAdVisibilityTimeMillis;
            this.vastAdVisibilityTimeMillis = Long.valueOf(l2 == null ? 0L : l2.longValue());
            Integer num2 = this.numOfRetriesAfterNetErrorInUb;
            Integer numValueOf = Integer.valueOf(num2 == null ? 5 : num2.intValue());
            this.numOfRetriesAfterNetErrorInUb = numValueOf;
            return new ConfigProperties(this.sessionIdFrequencyMin, this.locationValidForPeriodMin, this.vastAdVisibilityRatio, this.vastAdVisibilityTimeMillis, numValueOf);
        }

        private void parseProperties(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.sessionIdFrequencyMin = jSONObject.has("sessionidfrequencyinmins") ? Integer.valueOf(jSONObject.optInt("sessionidfrequencyinmins")) : null;
            this.locationValidForPeriodMin = jSONObject.has("loactionvalidforperiodinmins") ? Long.valueOf(jSONObject.optLong("loactionvalidforperiodinmins")) : null;
            this.vastAdVisibilityRatio = jSONObject.has("vastadvisibilityratio") ? Double.valueOf(jSONObject.optDouble("vastadvisibilityratio") / 100.0d) : null;
            this.vastAdVisibilityTimeMillis = jSONObject.has("vastadvisibilitytimeinmillis") ? Long.valueOf(jSONObject.optLong("vastadvisibilitytimeinmillis")) : null;
            this.numOfRetriesAfterNetErrorInUb = jSONObject.has("noretriesafternetworkerrorinub") ? Integer.valueOf(jSONObject.optInt("noretriesafternetworkerrorinub")) : null;
        }
    }
}
