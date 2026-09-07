package com.amazon.device.ads;

import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class MraidOpenCommand extends MraidCommand {
    static final String NAME = "open";

    @Override // com.amazon.device.ads.MraidCommand
    public void execute(JSONObject jSONObject, DTBAdMRAIDController dTBAdMRAIDController) throws JSONException {
        Logger.d("AmazonPublisherServices|SafeDK: Execution> Lcom/amazon/device/ads/MraidOpenCommand;->execute(Lorg/json/JSONObject;Lcom/amazon/device/ads/DTBAdMRAIDController;)V");
        safedk_MraidOpenCommand_execute_be19ef29dcc291f5adc6c15cd0fbf9b9(jSONObject, dTBAdMRAIDController);
        BrandSafetyUtils.onMraidOpen(h.A, jSONObject, dTBAdMRAIDController, "openUrl");
    }

    @Override // com.amazon.device.ads.MraidCommand
    public String getName() {
        return "open";
    }

    static String getMraidName() {
        return "open";
    }

    public void safedk_MraidOpenCommand_execute_be19ef29dcc291f5adc6c15cd0fbf9b9(JSONObject p0, DTBAdMRAIDController p1) throws JSONException {
        if (p0.has(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS) && p0.getJSONObject(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS).has("inAppNativeBrowser")) {
            JSONObject jSONObject = p0.getJSONObject(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS).getJSONObject("inAppNativeBrowser");
            try {
                if (jSONObject.has("enabled") && jSONObject.getBoolean("enabled")) {
                    p1.openUrl(p0.getString("url"), jSONObject.getBoolean("enabled"));
                    return;
                }
                return;
            } catch (Exception e) {
                APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Failed to execute Open command with inAppNativeBrowser", e);
                return;
            }
        }
        p1.openUrl(p0.getString("url"));
    }
}
