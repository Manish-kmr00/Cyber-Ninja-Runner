package com.amazon.device.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class MraidUnloadCommand extends MraidCommand {
    static final String NAME = "unload";

    @Override // com.amazon.device.ads.MraidCommand
    public String getName() {
        return "unload";
    }

    static String getMraidName() {
        return "unload";
    }

    @Override // com.amazon.device.ads.MraidCommand
    public void execute(JSONObject jSONObject, DTBAdMRAIDController dTBAdMRAIDController) throws JSONException {
        dTBAdMRAIDController.onMRAIDUnload();
    }
}
