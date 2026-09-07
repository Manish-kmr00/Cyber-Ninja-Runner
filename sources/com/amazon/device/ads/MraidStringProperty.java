package com.amazon.device.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MraidProperty.java */
/* JADX INFO: loaded from: classes5.dex */
class MraidStringProperty extends MraidProperty {
    String value;

    MraidStringProperty(String str) {
        super(str);
    }

    String getValue() {
        return this.value;
    }

    @Override // com.amazon.device.ads.MraidProperty
    void formJSON(JSONObject jSONObject) throws JSONException {
        jSONObject.put(this.name, getValue());
    }
}
