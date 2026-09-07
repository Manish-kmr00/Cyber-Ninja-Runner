package com.pubmatic.sdk.video;

import com.amazon.device.ads.DTBAdLoader;
import com.playon.bridge.Ad;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class POBVastPlayerConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7785a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private final int i;
    private final boolean j;
    private final boolean k;

    public static class ConfigBuilder {
        public static final int DEFAULT_ENDCARD_SKIP_AFTER = 5;
        public static final int DEFAULT_MEDIA_URI_TIMEOUT = 20000;
        public static final boolean DEFAULT_PLAY_ON_MUTE = true;
        public static final int DEFAULT_SKIP = 1;
        public static final int DEFAULT_VIDEO_SKIP_AFTER = 7;
        public static final int DEFAULT_WRAPPER_URI_TIMEOUT = 5000;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7786a;
        private int b;
        private int d;
        private boolean h = true;
        private int i = 5;
        private boolean j = false;
        private boolean k = false;
        private int c = 1;
        private int e = 7;
        private int f = 5000;
        private int g = 20000;

        public ConfigBuilder(int i, int i2) {
            this.f7786a = i;
            this.b = i2;
        }

        private static int a(boolean z) {
            return z ? 0 : 7;
        }

        public static POBVastPlayerConfig createVastConfig(JSONObject jSONObject, boolean z, boolean z2, boolean z3, String str) {
            POBVastPlayerConfig pOBVastPlayerConfigBuild = new ConfigBuilder(0, 0).build(z);
            if (jSONObject == null) {
                return pOBVastPlayerConfigBuild;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ext");
            if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) {
                POBLog.warn("ConfigBuilder", "Null/empty extension response parameter.", new Object[0]);
                return pOBVastPlayerConfigBuild;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("video");
            if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.length() <= 0) {
                POBLog.warn("ConfigBuilder", "Null/empty video response parameter.", new Object[0]);
                return pOBVastPlayerConfigBuild;
            }
            POBLog.info("ConfigBuilder", "Video config: " + jSONObjectOptJSONObject2, new Object[0]);
            ConfigBuilder configBuilder = new ConfigBuilder(jSONObjectOptJSONObject2.optInt("minduration"), jSONObjectOptJSONObject2.optInt("maxduration"));
            configBuilder.skip(jSONObjectOptJSONObject2.optInt(EventConstants.SKIP, 1));
            configBuilder.skipMin(jSONObjectOptJSONObject2.optInt("skipmin"));
            configBuilder.setSkipAfterCompletionEnabled(z2);
            if (-9999 != jSONObjectOptJSONObject2.optInt(DTBAdLoader.APS_VIDEO_SKIP_AFTER, POBCommonConstants.DEFAULT_INVALID_SKIP_AFTER_VALUE)) {
                configBuilder.setSkipAfterCompletionEnabled(false);
            }
            configBuilder.skipAfter(jSONObjectOptJSONObject2.optInt(DTBAdLoader.APS_VIDEO_SKIP_AFTER, a(z2)));
            configBuilder.setPlayOnMute(z3);
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("playbackmethod");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                try {
                    int iIntValue = ((Integer) jSONArrayOptJSONArray.get(0)).intValue();
                    if ("interstitial".equals(str)) {
                        if (iIntValue == 1) {
                            configBuilder.setPlayOnMute(false);
                        } else if (iIntValue == 2) {
                            configBuilder.setPlayOnMute(true);
                        }
                    } else if (iIntValue == 5) {
                        configBuilder.setPlayOnMute(false);
                    } else if (iIntValue == 6) {
                        configBuilder.setPlayOnMute(true);
                    }
                } catch (JSONException e) {
                    POBLog.warn("ConfigBuilder", "Failed to parse playbackmethod, %s", e.toString());
                }
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(POBConstants.KEY_CLIENT_CONFIG);
            if (jSONObjectOptJSONObject3 != null && jSONObjectOptJSONObject3.length() > 0) {
                configBuilder.setBackButtonEnabled(jSONObjectOptJSONObject3.optBoolean("enablehardwarebackbutton", false));
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("timeouts");
                if (jSONObjectOptJSONObject4 != null) {
                    configBuilder.wrapperUriTimeout(jSONObjectOptJSONObject4.optInt("wrapperTagURI"));
                    configBuilder.mediaUriTimeout(jSONObjectOptJSONObject4.optInt("mediaFileURI"));
                }
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject3.optJSONObject(Ad.COMPANION);
                if (jSONObjectOptJSONObject5 != null) {
                    configBuilder.endCardSkipAfter(jSONObjectOptJSONObject5.optInt(DTBAdLoader.APS_VIDEO_SKIP_AFTER, 5));
                }
            }
            return configBuilder.build(z);
        }

        public POBVastPlayerConfig build(boolean z) {
            return new POBVastPlayerConfig(this, z);
        }

        public ConfigBuilder endCardSkipAfter(int i) {
            this.i = i;
            return this;
        }

        public ConfigBuilder mediaUriTimeout(int i) {
            if (i > this.g) {
                this.g = i;
            }
            return this;
        }

        public ConfigBuilder setBackButtonEnabled(boolean z) {
            this.j = z;
            return this;
        }

        public ConfigBuilder setPlayOnMute(boolean z) {
            this.h = z;
            return this;
        }

        public ConfigBuilder setSkipAfterCompletionEnabled(boolean z) {
            this.k = z;
            return this;
        }

        public ConfigBuilder skip(int i) {
            this.c = i;
            return this;
        }

        public ConfigBuilder skipAfter(int i) {
            this.e = i;
            return this;
        }

        public ConfigBuilder skipMin(int i) {
            this.d = i;
            return this;
        }

        public ConfigBuilder wrapperUriTimeout(int i) {
            if (i > this.f) {
                this.f = i;
            }
            return this;
        }
    }

    public int getEndCardSkipAfter() {
        return this.i;
    }

    public int getMaxDuration() {
        return this.b;
    }

    public int getMediaUriTimeout() {
        return this.g;
    }

    public int getMinDuration() {
        return this.f7785a;
    }

    public int getSkip() {
        return this.c;
    }

    public int getSkipAfter() {
        return this.e;
    }

    public int getSkipMin() {
        return this.d;
    }

    public int getWrapperUriTimeout() {
        return this.f;
    }

    public boolean isBackButtonEnabled() {
        return this.j;
    }

    public boolean isPlayOnMute() {
        return this.h;
    }

    public boolean isSkipAfterCompletionEnabled() {
        return this.k;
    }

    private POBVastPlayerConfig(ConfigBuilder configBuilder, boolean z) {
        this.f7785a = configBuilder.f7786a;
        this.b = configBuilder.b;
        if (z) {
            this.c = configBuilder.c;
        }
        this.d = configBuilder.d;
        this.e = configBuilder.e;
        this.f = configBuilder.f;
        this.g = configBuilder.g;
        this.h = configBuilder.h;
        this.i = configBuilder.i;
        this.j = configBuilder.j;
        this.k = configBuilder.k;
    }
}
