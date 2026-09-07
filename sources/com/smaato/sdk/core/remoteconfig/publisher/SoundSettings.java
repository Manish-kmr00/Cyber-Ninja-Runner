package com.smaato.sdk.core.remoteconfig.publisher;

import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SoundSettings {
    private final boolean isSoundOn;

    private SoundSettings(boolean z) {
        this.isSoundOn = z;
    }

    public boolean isSoundOn() {
        return this.isSoundOn;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SoundSettings) && isSoundOn() == ((SoundSettings) obj).isSoundOn();
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(isSoundOn()));
    }

    static final class Builder {
        private Boolean isSoundOn;

        Builder() {
        }

        Builder(JSONObject jSONObject) {
            if (jSONObject.has("soundOn")) {
                this.isSoundOn = Boolean.valueOf(jSONObject.optBoolean("soundOn"));
            }
        }

        SoundSettings build() {
            if (this.isSoundOn == null) {
                this.isSoundOn = Boolean.TRUE;
            }
            return new SoundSettings(this.isSoundOn.booleanValue());
        }
    }
}
