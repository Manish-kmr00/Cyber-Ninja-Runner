package com.smaato.sdk.core.mvvm.model.imagead;

import com.smaato.sdk.core.util.Objects;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class Extension {
    private static final String EXT_CONF_KEY = "conf";
    private static final String EXT_CONF_VENDOR_KEY = "vendorKey";
    private static final String EXT_CONF_VERIFICATION_KEY = "verification_parameters";
    private static final String EXT_NAME_KEY = "name";
    private static final String EXT_SCRIPT_KEY = "script";
    public static final String OM = "OM";
    private ExtConfig mExtConfig;
    private String mName = "";
    private String mScript = "";

    public String getName() {
        return this.mName;
    }

    public String getScript() {
        return this.mScript;
    }

    public ExtConfig getExtConfig() {
        return this.mExtConfig;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setScript(String str) {
        this.mScript = str;
    }

    public void setExtConfig(ExtConfig extConfig) {
        this.mExtConfig = extConfig;
    }

    public static List<Extension> getExtensionList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Extension extension = new Extension();
            extension.setName(jSONArray.getJSONObject(i).optString("name", ""));
            extension.setScript(jSONArray.getJSONObject(i).optString(EXT_SCRIPT_KEY, ""));
            extension.setName(jSONArray.getJSONObject(i).optString("name", ""));
            extension.setExtConfig((JSONObject) Objects.requireNonNull(jSONArray.getJSONObject(i).optJSONObject(EXT_CONF_KEY)));
            arrayList.add(extension);
        }
        return arrayList;
    }

    private void setExtConfig(JSONObject jSONObject) {
        ExtConfig extConfig = new ExtConfig();
        extConfig.setVendorKey(jSONObject.optString("vendorKey", ""));
        extConfig.setVerificationParam(jSONObject.optString("verification_parameters", ""));
        this.mExtConfig = extConfig;
    }
}
