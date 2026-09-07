package com.amazon.device.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class MraidExpandCommand extends MraidCommand {
    static final String NAME = "expand";

    @Override // com.amazon.device.ads.MraidCommand
    public String getName() {
        return "expand";
    }

    static String getMraidName() {
        return "expand";
    }

    @Override // com.amazon.device.ads.MraidCommand
    public void execute(JSONObject jSONObject, DTBAdMRAIDController dTBAdMRAIDController) throws JSONException {
        dTBAdMRAIDController.expand(SDKUtilities.convertJSONObjectToMap(jSONObject));
    }
}
