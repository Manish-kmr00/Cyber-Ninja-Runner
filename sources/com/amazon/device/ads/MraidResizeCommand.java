package com.amazon.device.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class MraidResizeCommand extends MraidCommand {
    static final String NAME = "resize";

    @Override // com.amazon.device.ads.MraidCommand
    public String getName() {
        return "resize";
    }

    static String getMraidName() {
        return "resize";
    }

    @Override // com.amazon.device.ads.MraidCommand
    public void execute(JSONObject jSONObject, DTBAdMRAIDController dTBAdMRAIDController) throws JSONException {
        dTBAdMRAIDController.onResize(SDKUtilities.convertJSONObjectToMap(jSONObject));
    }
}
