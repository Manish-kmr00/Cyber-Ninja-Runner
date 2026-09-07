package com.unity3d.services.core.configuration;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class ExperimentObject {
    private static final String APPLIED_KEY = "applied";
    private static final String VALUE_KEY = "value";
    private final JSONObject _experimentData;

    public ExperimentObject(JSONObject jSONObject) {
        this._experimentData = jSONObject == null ? new JSONObject() : jSONObject;
    }

    public String getStringValue() {
        return this._experimentData.optString("value");
    }

    public boolean getBooleanValue() {
        return this._experimentData.optBoolean("value");
    }

    public ExperimentAppliedRule getAppliedRule() {
        ExperimentAppliedRule experimentAppliedRule = ExperimentAppliedRule.NEXT;
        String strOptString = this._experimentData.optString(APPLIED_KEY);
        if (strOptString.isEmpty()) {
            return experimentAppliedRule;
        }
        try {
            return ExperimentAppliedRule.valueOf(strOptString.toUpperCase());
        } catch (IllegalArgumentException unused) {
            return experimentAppliedRule;
        }
    }
}
