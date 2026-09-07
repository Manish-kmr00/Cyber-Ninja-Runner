package com.smaato.sdk.core.remoteconfig.publisher;

import com.adjust.sdk.Constants;
import com.smaato.sdk.core.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class Configuration {
    private final ButtonDelays buttonDelays;
    private final ButtonSizes buttonSizes;
    private final ErrorLoggingRate errorLoggingRate;
    private final SoundSettings soundSettings;
    private final long ttlMillis;
    private final UnifiedBidding unifiedBidding;

    private Configuration(SoundSettings soundSettings, ButtonDelays buttonDelays, ButtonSizes buttonSizes, UnifiedBidding unifiedBidding, ErrorLoggingRate errorLoggingRate, long j) {
        this.soundSettings = soundSettings;
        this.buttonDelays = buttonDelays;
        this.buttonSizes = buttonSizes;
        this.unifiedBidding = unifiedBidding;
        this.errorLoggingRate = (ErrorLoggingRate) Objects.requireNonNull(errorLoggingRate);
        this.ttlMillis = j;
    }

    public static Configuration create() {
        return new Builder().build();
    }

    public static Configuration create(JSONObject jSONObject) {
        return new Builder(jSONObject).build();
    }

    public SoundSettings getSoundSettings() {
        return this.soundSettings;
    }

    public ButtonDelays getButtonDelays() {
        return this.buttonDelays;
    }

    public ButtonSizes getButtonSizes() {
        return this.buttonSizes;
    }

    public UnifiedBidding getUnifiedBidding() {
        return this.unifiedBidding;
    }

    public ErrorLoggingRate getErrorLoggingRate() {
        return this.errorLoggingRate;
    }

    public long getTtlMillis() {
        return this.ttlMillis;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Configuration.class != obj.getClass()) {
            return false;
        }
        Configuration configuration = (Configuration) obj;
        if (this.ttlMillis != configuration.ttlMillis) {
            return false;
        }
        return this.soundSettings.equals(configuration.soundSettings) && this.buttonDelays.equals(configuration.buttonDelays) && this.buttonSizes.equals(configuration.buttonSizes) && this.unifiedBidding.equals(configuration.unifiedBidding) && this.errorLoggingRate.equals(configuration.errorLoggingRate);
    }

    public int hashCode() {
        return Objects.hash(this.soundSettings, this.buttonDelays, this.buttonSizes, this.unifiedBidding, this.errorLoggingRate, Long.valueOf(this.ttlMillis));
    }

    private static final class Builder {
        private ButtonDelays.Builder buttonDelaysBuilder;
        private ButtonSizes.Builder buttonSizesBuilder;
        private ErrorLoggingRate.Builder errorLoggingRateBuilder;
        private SoundSettings.Builder soundSettingsBuilder;
        private Long ttlMillis;
        private UnifiedBidding.Builder unifiedBiddingBuilder;

        private Builder() {
            this.ttlMillis = 0L;
        }

        private Builder(JSONObject jSONObject) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(Constants.REFERRER_API_META);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optInt("ttl", -1) != -1) {
                this.ttlMillis = Long.valueOf(((long) (jSONObjectOptJSONObject.optInt("ttl") * 3600)) * 1000);
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("soundSettings");
            if (jSONObjectOptJSONObject2 != null) {
                this.soundSettingsBuilder = new SoundSettings.Builder(jSONObjectOptJSONObject2);
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("buttonDelays");
            if (jSONObjectOptJSONObject3 != null) {
                this.buttonDelaysBuilder = new ButtonDelays.Builder(jSONObjectOptJSONObject3);
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("buttonSizes");
            if (jSONObjectOptJSONObject4 != null) {
                this.buttonSizesBuilder = new ButtonSizes.Builder(jSONObjectOptJSONObject4);
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("unifiedBidding");
            if (jSONObjectOptJSONObject5 != null) {
                this.unifiedBiddingBuilder = new UnifiedBidding.Builder(jSONObjectOptJSONObject5);
            }
            JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("errorLoggingRates");
            if (jSONObjectOptJSONObject6 != null) {
                this.errorLoggingRateBuilder = new ErrorLoggingRate.Builder(jSONObjectOptJSONObject6);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Configuration build() {
            Long l = this.ttlMillis;
            if (l == null || l.longValue() < 0 || this.ttlMillis.longValue() > 86400000) {
                this.ttlMillis = 86400000L;
            }
            SoundSettings.Builder builder = this.soundSettingsBuilder;
            if (builder == null) {
                builder = new SoundSettings.Builder();
            }
            this.soundSettingsBuilder = builder;
            ButtonDelays.Builder builder2 = this.buttonDelaysBuilder;
            if (builder2 == null) {
                builder2 = new ButtonDelays.Builder();
            }
            this.buttonDelaysBuilder = builder2;
            ButtonSizes.Builder builder3 = this.buttonSizesBuilder;
            if (builder3 == null) {
                builder3 = new ButtonSizes.Builder();
            }
            this.buttonSizesBuilder = builder3;
            UnifiedBidding.Builder builder4 = this.unifiedBiddingBuilder;
            if (builder4 == null) {
                builder4 = new UnifiedBidding.Builder();
            }
            this.unifiedBiddingBuilder = builder4;
            ErrorLoggingRate.Builder builder5 = this.errorLoggingRateBuilder;
            if (builder5 == null) {
                builder5 = new ErrorLoggingRate.Builder();
            }
            this.errorLoggingRateBuilder = builder5;
            return new Configuration(this.soundSettingsBuilder.build(), this.buttonDelaysBuilder.build(), this.buttonSizesBuilder.build(), this.unifiedBiddingBuilder.build(), this.errorLoggingRateBuilder.build(), this.ttlMillis.longValue());
        }
    }
}
