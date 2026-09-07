package com.smaato.sdk.core.remoteconfig.global;

import com.adjust.sdk.Constants;
import com.smaato.sdk.core.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class ConfigButtonDelays {
    private final DelayOptions displayAdDelay;
    private final DelayOptions videoAdDelay;

    private ConfigButtonDelays(DelayOptions delayOptions, DelayOptions delayOptions2) {
        this.videoAdDelay = delayOptions;
        this.displayAdDelay = delayOptions2;
    }

    public DelayOptions getVideoAdDelay() {
        return this.videoAdDelay;
    }

    public DelayOptions getDisplayAdDelay() {
        return this.displayAdDelay;
    }

    public static class DelayOptions {
        private final int largeInSec;
        private final int midInSec;

        public DelayOptions(int i, int i2) {
            this.largeInSec = i;
            this.midInSec = i2;
        }

        public int getLargeInSec() {
            return this.largeInSec;
        }

        public int getMidInSec() {
            return this.midInSec;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ConfigButtonDelays configButtonDelays = (ConfigButtonDelays) obj;
        return this.videoAdDelay == configButtonDelays.getVideoAdDelay() && this.displayAdDelay == configButtonDelays.getDisplayAdDelay();
    }

    public int hashCode() {
        return Objects.hash(this.videoAdDelay, this.displayAdDelay);
    }

    static final class Builder {
        private DelayOptions displayAdDelaySeconds;
        private DelayOptions videoAdDelaySeconds;

        Builder() {
        }

        Builder(JSONObject jSONObject) {
            if (jSONObject.has("videoSkip")) {
                this.videoAdDelaySeconds = getDelayOptions(jSONObject.optJSONObject("videoSkip"));
            }
            if (jSONObject.has("displayClose")) {
                this.displayAdDelaySeconds = getDelayOptions(jSONObject.optJSONObject("displayClose"));
            }
        }

        ConfigButtonDelays build() {
            if (this.videoAdDelaySeconds == null) {
                this.videoAdDelaySeconds = new DelayOptions(8, 5);
            }
            if (this.displayAdDelaySeconds == null) {
                this.displayAdDelaySeconds = new DelayOptions(5, 3);
            }
            return new ConfigButtonDelays(this.videoAdDelaySeconds, this.displayAdDelaySeconds);
        }

        private DelayOptions getDelayOptions(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt(Constants.LARGE, -1);
            int iOptInt2 = jSONObject.optInt("mid", -1);
            if (iOptInt == -1 || iOptInt2 == -1) {
                return null;
            }
            return new DelayOptions(iOptInt, iOptInt2);
        }
    }
}
