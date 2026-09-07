package com.amazon.device.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class MraidCloseCommand extends MraidCommand {
    static final String NAME = "close";

    @Override // com.amazon.device.ads.MraidCommand
    public String getName() {
        return "close";
    }

    static String getMraidName() {
        return "close";
    }

    @Override // com.amazon.device.ads.MraidCommand
    public void execute(JSONObject jSONObject, DTBAdMRAIDController dTBAdMRAIDController) {
        dTBAdMRAIDController.onMRAIDClose();
    }
}
