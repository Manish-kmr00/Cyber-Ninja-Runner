package com.amazon.device.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MraidProperty.java */
/* JADX INFO: loaded from: classes3.dex */
class ExpandProperty extends MraidProperty {
    int height;
    int width;

    @Override // com.amazon.device.ads.MraidProperty
    void formJSON(JSONObject jSONObject) throws JSONException {
    }

    ExpandProperty(JSONObject jSONObject) throws JSONException {
        super("expandProperty");
        this.width = jSONObject.getInt("width");
        this.height = jSONObject.getInt("height");
    }
}
