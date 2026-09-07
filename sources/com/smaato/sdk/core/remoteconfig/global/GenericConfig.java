package com.smaato.sdk.core.remoteconfig.global;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class GenericConfig {
    private final ConfigButtonDelays configButtonDelays;
    private final ConfigButtonSizes configButtonSizes;
    private final ConfigFeatures configFeatures;
    private final ConfigProperties configProperties;
    private final ConfigUrls configUrls;

    private GenericConfig(ConfigUrls configUrls, ConfigProperties configProperties, ConfigFeatures configFeatures, ConfigButtonSizes configButtonSizes, ConfigButtonDelays configButtonDelays) {
        this.configUrls = configUrls;
        this.configProperties = configProperties;
        this.configFeatures = configFeatures;
        this.configButtonSizes = configButtonSizes;
        this.configButtonDelays = configButtonDelays;
    }

    public ConfigUrls getConfigUrls() {
        return this.configUrls;
    }

    public ConfigProperties getConfigProperties() {
        return this.configProperties;
    }

    public ConfigFeatures getConfigFeatures() {
        return this.configFeatures;
    }

    public ConfigButtonSizes getConfigButtonSizes() {
        return this.configButtonSizes;
    }

    public ConfigButtonDelays getConfigButtonDelays() {
        return this.configButtonDelays;
    }

    public static GenericConfig create() {
        return new Builder().build();
    }

    public static GenericConfig create(JSONObject jSONObject) {
        return new Builder(jSONObject).build();
    }

    private static final class Builder {
        private ConfigButtonDelays.Builder configButtonDelaysBuilder;
        private ConfigButtonSizes.Builder configButtonSizeBuilder;
        private ConfigFeatures.Builder configFeaturesBuilder;
        private ConfigProperties.Builder configPropertiesBuilder;
        private ConfigUrls.Builder configUrlsBuilder;

        private Builder() {
        }

        private Builder(JSONObject jSONObject) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("remoteconfig");
            if (jSONObjectOptJSONObject != null) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("urls");
                if (jSONObjectOptJSONObject2 != null) {
                    this.configUrlsBuilder = new ConfigUrls.Builder(jSONObjectOptJSONObject2);
                }
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("properties");
                if (jSONObjectOptJSONObject3 != null) {
                    this.configPropertiesBuilder = new ConfigProperties.Builder(jSONObjectOptJSONObject3);
                }
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("features");
                if (jSONArrayOptJSONArray != null) {
                    this.configFeaturesBuilder = new ConfigFeatures.Builder(jSONArrayOptJSONArray);
                }
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("buttonSize");
                if (jSONObjectOptJSONObject4 != null) {
                    this.configButtonSizeBuilder = new ConfigButtonSizes.Builder(jSONObjectOptJSONObject4);
                }
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject.optJSONObject("buttonDelay");
                if (jSONObjectOptJSONObject5 != null) {
                    this.configButtonDelaysBuilder = new ConfigButtonDelays.Builder(jSONObjectOptJSONObject5);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GenericConfig build() {
            ConfigUrls.Builder builder = this.configUrlsBuilder;
            if (builder == null) {
                builder = new ConfigUrls.Builder();
            }
            this.configUrlsBuilder = builder;
            ConfigProperties.Builder builder2 = this.configPropertiesBuilder;
            if (builder2 == null) {
                builder2 = new ConfigProperties.Builder();
            }
            this.configPropertiesBuilder = builder2;
            ConfigFeatures.Builder builder3 = this.configFeaturesBuilder;
            if (builder3 == null) {
                builder3 = new ConfigFeatures.Builder();
            }
            this.configFeaturesBuilder = builder3;
            ConfigButtonSizes.Builder builder4 = this.configButtonSizeBuilder;
            if (builder4 == null) {
                builder4 = new ConfigButtonSizes.Builder();
            }
            this.configButtonSizeBuilder = builder4;
            ConfigButtonDelays.Builder builder5 = this.configButtonDelaysBuilder;
            if (builder5 == null) {
                builder5 = new ConfigButtonDelays.Builder();
            }
            this.configButtonDelaysBuilder = builder5;
            return new GenericConfig(this.configUrlsBuilder.build(), this.configPropertiesBuilder.build(), this.configFeaturesBuilder.build(), this.configButtonSizeBuilder.build(), this.configButtonDelaysBuilder.build());
        }
    }
}
