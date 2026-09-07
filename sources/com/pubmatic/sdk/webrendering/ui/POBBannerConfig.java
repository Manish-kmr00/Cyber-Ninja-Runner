package com.pubmatic.sdk.webrendering.ui;

import com.amazon.device.ads.DTBAdLoader;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class POBBannerConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7923a;
    private final boolean b;

    public static class ConfigBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f7924a = false;
        private int b = 5;

        public static POBBannerConfig createBannerConfig(JSONObject jSONObject, String str) {
            ConfigBuilder configBuilder = new ConfigBuilder();
            if (jSONObject != null) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ext");
                if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) {
                    POBLog.warn("ConfigBuilder", "Null/empty extension response parameter.", new Object[0]);
                } else {
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("banner");
                    if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.length() <= 0) {
                        POBLog.warn("ConfigBuilder", "Null/empty banner response parameter.", new Object[0]);
                    } else {
                        POBLog.info("ConfigBuilder", "Banner config: " + jSONObjectOptJSONObject2, new Object[0]);
                        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(POBConstants.KEY_CLIENT_CONFIG);
                        if (jSONObjectOptJSONObject3 != null) {
                            configBuilder.setSkipAfter(jSONObjectOptJSONObject3.optInt(DTBAdLoader.APS_VIDEO_SKIP_AFTER, 5));
                            if ("interstitial".equals(str)) {
                                configBuilder.setBackButtonEnabled(jSONObjectOptJSONObject3.optBoolean("enablehardwarebackbutton", false));
                            }
                        }
                    }
                }
            }
            return configBuilder.build();
        }

        public POBBannerConfig build() {
            return new POBBannerConfig(this);
        }

        public ConfigBuilder setBackButtonEnabled(boolean z) {
            this.f7924a = z;
            return this;
        }

        public ConfigBuilder setSkipAfter(int i) {
            this.b = i;
            return this;
        }
    }

    public int getSkipAfter() {
        return this.f7923a;
    }

    public boolean isBackButtonEnabled() {
        return this.b;
    }

    private POBBannerConfig(ConfigBuilder configBuilder) {
        this.f7923a = configBuilder.b;
        this.b = configBuilder.f7924a;
    }
}
