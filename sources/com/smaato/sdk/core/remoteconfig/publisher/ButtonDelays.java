package com.smaato.sdk.core.remoteconfig.publisher;

import android.util.Log;
import com.smaato.sdk.core.util.Objects;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ButtonDelays {
    private static final Boolean DEFAULT_DELAY_ENABLED = Boolean.FALSE;
    private final int displayAdDelaySeconds;
    private final Map fixedDelaysMap;
    private final int videoAdDelaySeconds;

    public enum ButtonDelay {
        LARGE,
        MID
    }

    private ButtonDelays(int i, int i2, Map map) {
        this.videoAdDelaySeconds = i;
        this.displayAdDelaySeconds = i2;
        this.fixedDelaysMap = map;
    }

    public boolean isButtonDelayEnabled(ButtonDelay buttonDelay) {
        Boolean bool = (Boolean) this.fixedDelaysMap.get(buttonDelay.name());
        if (bool != null) {
            return bool.booleanValue();
        }
        return DEFAULT_DELAY_ENABLED.booleanValue();
    }

    public int getVideoAdDelaySeconds() {
        return this.videoAdDelaySeconds;
    }

    public int getDisplayAdDelaySeconds() {
        return this.displayAdDelaySeconds;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ButtonDelays buttonDelays = (ButtonDelays) obj;
        return this.videoAdDelaySeconds == buttonDelays.videoAdDelaySeconds && this.displayAdDelaySeconds == buttonDelays.getDisplayAdDelaySeconds() && this.fixedDelaysMap == buttonDelays.fixedDelaysMap;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.videoAdDelaySeconds), Integer.valueOf(this.displayAdDelaySeconds), this.fixedDelaysMap);
    }

    static final class Builder {
        private Integer displayAdDelaySeconds;
        private Map fixedDelaysMap;
        private Integer videoAdDelaySeconds;

        Builder() {
        }

        Builder(JSONObject jSONObject) {
            if (jSONObject.optInt("videoSkip", -1) != -1) {
                this.videoAdDelaySeconds = Integer.valueOf(jSONObject.optInt("videoSkip"));
            }
            if (jSONObject.optInt("displayClose", -1) != -1) {
                this.displayAdDelaySeconds = Integer.valueOf(jSONObject.optInt("displayClose"));
            }
            if (jSONObject.has("fixDelays")) {
                parseButtonDelays(jSONObject.optJSONArray("fixDelays"));
            }
        }

        ButtonDelays build() {
            Integer num = this.videoAdDelaySeconds;
            if (num == null || num.intValue() < 0) {
                this.videoAdDelaySeconds = 5;
            }
            Integer num2 = this.displayAdDelaySeconds;
            if (num2 == null || num2.intValue() < 0) {
                this.displayAdDelaySeconds = 3;
            }
            Map map = this.fixedDelaysMap;
            if (map == null) {
                map = new HashMap();
            }
            this.fixedDelaysMap = map;
            return new ButtonDelays(this.videoAdDelaySeconds.intValue(), this.displayAdDelaySeconds.intValue(), this.fixedDelaysMap);
        }

        private void parseButtonDelays(JSONArray jSONArray) {
            if (jSONArray == null) {
                return;
            }
            this.fixedDelaysMap = new HashMap();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (isValidDelayJson(jSONObject)) {
                        this.fixedDelaysMap.put(jSONObject.getString("type"), Boolean.valueOf(jSONObject.getBoolean("enabled")));
                    }
                } catch (JSONException unused) {
                    Log.d(Builder.class.getSimpleName(), "Failed to Parse Json Array");
                }
            }
        }

        private boolean isValidDelayJson(JSONObject jSONObject) {
            return jSONObject != null && jSONObject.has("type") && jSONObject.has("enabled");
        }
    }
}
