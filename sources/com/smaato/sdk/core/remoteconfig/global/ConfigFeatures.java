package com.smaato.sdk.core.remoteconfig.global;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class ConfigFeatures {
    private static final Boolean DEFAULT_FEATURED_ENABLED = Boolean.TRUE;
    private final Map featuresMap;

    public enum Feature {
        BUTTON_SIZE("ButtonSize"),
        BUTTON_DELAY("ButtonDelay");

        public final String label;

        Feature(String str) {
            this.label = str;
        }
    }

    private ConfigFeatures(Map map) {
        this.featuresMap = map;
    }

    public boolean isFeatureEnabled(Feature feature) {
        Config config = (Config) this.featuresMap.get(feature.label);
        if (config != null) {
            return config.isEnabled.booleanValue() && getCurrentVersion().compareTo(config.minVersionSupport) >= 0;
        }
        return DEFAULT_FEATURED_ENABLED.booleanValue();
    }

    private static class Config {
        private final Boolean isEnabled;
        private final String minVersionSupport;

        public Config(String str, Boolean bool) {
            this.minVersionSupport = str;
            this.isEnabled = bool;
        }
    }

    static final class Builder {
        private Map featuresMap;

        Builder() {
        }

        Builder(JSONArray jSONArray) {
            parseFeatures(jSONArray);
        }

        ConfigFeatures build() {
            Map map = this.featuresMap;
            if (map == null) {
                map = new HashMap();
            }
            return new ConfigFeatures(map);
        }

        private void parseFeatures(JSONArray jSONArray) {
            if (jSONArray == null) {
                return;
            }
            this.featuresMap = new HashMap();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (isValidFeatureJson(jSONObject)) {
                        String string = jSONObject.getString("featureName");
                        JSONObject jSONObject2 = jSONObject.getJSONObject("android");
                        if (isValidAndroidObject(jSONObject2)) {
                            this.featuresMap.put(string, new Config(jSONObject2.optString("minVersionSupport"), Boolean.valueOf(jSONObject2.optBoolean("enabled"))));
                        }
                    }
                } catch (JSONException unused) {
                    Log.d(Builder.class.getSimpleName(), "Failed to Parse Json Array");
                }
            }
        }

        private boolean isValidFeatureJson(JSONObject jSONObject) {
            return jSONObject != null && jSONObject.has("featureName") && jSONObject.has("android");
        }

        private boolean isValidAndroidObject(JSONObject jSONObject) {
            return jSONObject != null && jSONObject.has("minVersionSupport") && jSONObject.has("enabled");
        }
    }

    protected static String getCurrentVersion() {
        try {
            String[] strArrSplit = "22.7.2".split("-");
            return strArrSplit.length > 1 ? strArrSplit[0] : "22.7.2";
        } catch (Exception unused) {
            return "22.7.2";
        }
    }
}
