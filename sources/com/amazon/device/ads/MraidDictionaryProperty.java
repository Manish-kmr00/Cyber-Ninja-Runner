package com.amazon.device.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MraidProperty.java */
/* JADX INFO: loaded from: classes11.dex */
class MraidDictionaryProperty extends MraidProperty {
    JSONObject data;

    MraidDictionaryProperty(String str) {
        super(str);
        this.data = new JSONObject();
    }

    @Override // com.amazon.device.ads.MraidProperty
    void formJSON(JSONObject jSONObject) throws JSONException {
        jSONObject.put(this.name, this.data);
    }

    JSONObject getData() {
        return this.data;
    }
}
