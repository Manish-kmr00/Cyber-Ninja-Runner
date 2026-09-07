package com.amazon.device.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class MraidFirePixelCommand extends MraidCommand {
    static final String NAME = "impFired";

    @Override // com.amazon.device.ads.MraidCommand
    public String getName() {
        return NAME;
    }

    static String getMraidName() {
        return NAME;
    }

    @Override // com.amazon.device.ads.MraidCommand
    public void execute(JSONObject jSONObject, DTBAdMRAIDController dTBAdMRAIDController) throws JSONException {
        dTBAdMRAIDController.impressionFired();
    }
}
