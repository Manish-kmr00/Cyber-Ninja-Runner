package com.amazon.device.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
abstract class MraidProperty {
    String name;
    static final StateProperty STATE_LOADING_PROPERTY = new StateProperty(MraidStateType.LOADING);
    static final StateProperty STATE_DEFAULT_PROPERTY = new StateProperty(MraidStateType.DEFAULT);
    static final StateProperty STATE_HIDDEN_PROPERTY = new StateProperty(MraidStateType.HIDDEN);
    static final StateProperty STATE_RESIZED_PROPERTY = new StateProperty(MraidStateType.RESIZED);
    static final StateProperty STATE_EXPANDED_PROPERTY = new StateProperty(MraidStateType.EXPANDED);
    static final SupportsProperty SUPPORTS_PROPERTY = new SupportsProperty();

    abstract void formJSON(JSONObject jSONObject) throws JSONException;

    String getName() {
        return this.name;
    }

    MraidProperty(String str) {
        this.name = str;
    }
}
