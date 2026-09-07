package com.bytedance.sdk.openadsdk.BSW.pA;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.pA.aBv;
import com.bytedance.sdk.openadsdk.core.IG;
import com.json.b9;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class SD extends com.bytedance.sdk.component.pA.ML<JSONObject, JSONObject> {
    private final IG Og;
    private final String pA;

    public SD(String str, IG ig) {
        this.Og = ig;
        this.pA = str;
    }

    public static void pA(aBv abv, IG ig) {
        abv.pA("appInfo", new SD("appInfo", ig));
        abv.pA("adInfo", new SD("adInfo", ig));
        abv.pA("sendLog", new SD("sendLog", ig));
        abv.pA("playable_style", new SD("playable_style", ig));
        abv.pA("getTemplateInfo", new SD("getTemplateInfo", ig));
        abv.pA("getTeMaiAds", new SD("getTeMaiAds", ig));
        abv.pA(b9.h.o, new SD(b9.h.o, ig));
        abv.pA("getScreenSize", new SD("getScreenSize", ig));
        abv.pA("getCloseButtonInfo", new SD("getCloseButtonInfo", ig));
        abv.pA("getVolume", new SD("getVolume", ig));
        abv.pA("removeLoading", new SD("removeLoading", ig));
        abv.pA("sendReward", new SD("sendReward", ig));
        abv.pA("subscribe_app_ad", new SD("subscribe_app_ad", ig));
        abv.pA("download_app_ad", new SD("download_app_ad", ig));
        abv.pA("cancel_download_app_ad", new SD("cancel_download_app_ad", ig));
        abv.pA("unsubscribe_app_ad", new SD("unsubscribe_app_ad", ig));
        abv.pA("landscape_click", new SD("landscape_click", ig));
        abv.pA("clickEvent", new SD("clickEvent", ig));
        abv.pA("renderDidFinish", new SD("renderDidFinish", ig));
        abv.pA("dynamicTrack", new SD("dynamicTrack", ig));
        abv.pA("skipVideo", new SD("skipVideo", ig));
        abv.pA("muteVideo", new SD("muteVideo", ig));
        abv.pA("changeVideoState", new SD("changeVideoState", ig));
        abv.pA("getCurrentVideoState", new SD("getCurrentVideoState", ig));
        abv.pA("send_temai_product_ids", new SD("send_temai_product_ids", ig));
        abv.pA("getMaterialMeta", new SD("getMaterialMeta", ig));
        abv.pA("endcard_load", new SD("endcard_load", ig));
        abv.pA("pauseWebView", new SD("pauseWebView", ig));
        abv.pA("pauseWebViewTimers", new SD("pauseWebViewTimers", ig));
        abv.pA("webview_time_track", new SD("webview_time_track", ig));
        abv.pA("openPrivacy", new SD("openPrivacy", ig));
        abv.pA("openAdLandPageLinks", new SD("openAdLandPageLinks", ig));
        abv.pA("getNativeSiteCustomData", new SD("getNativeSiteCustomData", ig));
        abv.pA("close", new SD("close", ig));
    }

    @Override // com.bytedance.sdk.component.pA.ML
    public JSONObject pA(JSONObject jSONObject, com.bytedance.sdk.component.pA.JG jg) throws Exception {
        IG.Og og = new IG.Og();
        og.pA = NotificationCompat.CATEGORY_CALL;
        og.KZx = this.pA;
        og.ZZv = jSONObject;
        return this.Og.pA(og, 3);
    }
}
