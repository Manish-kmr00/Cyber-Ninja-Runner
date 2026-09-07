package com.smaato.sdk.core.remoteconfig.publisher;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ButtonSizes {
    private static final Boolean DEFAULT_SIZE_ENABLED = Boolean.FALSE;
    private final Map fixedSizesMap;

    public enum ButtonSize {
        SMALL,
        MID
    }

    private ButtonSizes(Map map) {
        this.fixedSizesMap = map;
    }

    public boolean isButtonSizeEnabled(ButtonSize buttonSize) {
        Boolean bool = (Boolean) this.fixedSizesMap.get(buttonSize.name());
        if (bool != null) {
            return bool.booleanValue();
        }
        return DEFAULT_SIZE_ENABLED.booleanValue();
    }

    static final class Builder {
        private Map fixedSizesMap;

        Builder() {
        }

        Builder(JSONObject jSONObject) {
            if (jSONObject.has("fixSizes")) {
                parseButtonSizes(jSONObject.optJSONArray("fixSizes"));
            }
        }

        ButtonSizes build() {
            Map map = this.fixedSizesMap;
            if (map == null) {
                map = new HashMap();
            }
            return new ButtonSizes(map);
        }

        private void parseButtonSizes(JSONArray jSONArray) {
            if (jSONArray == null) {
                return;
            }
            this.fixedSizesMap = new HashMap();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (isValidSizeJson(jSONObject)) {
                        this.fixedSizesMap.put(jSONObject.getString("type"), Boolean.valueOf(jSONObject.getBoolean("enabled")));
                    }
                } catch (JSONException unused) {
                    Log.d(Builder.class.getSimpleName(), "Failed to Parse Json Array");
                }
            }
        }

        private boolean isValidSizeJson(JSONObject jSONObject) {
            return jSONObject != null && jSONObject.has("type") && jSONObject.has("enabled");
        }
    }
}
