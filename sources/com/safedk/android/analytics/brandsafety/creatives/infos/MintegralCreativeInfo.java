package com.safedk.android.analytics.brandsafety.creatives.infos;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.h;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class MintegralCreativeInfo extends CreativeInfo {
    private static final String aa = "MintegralCreativeInfo";
    private static final long serialVersionUID = 0;
    private String Z;

    public MintegralCreativeInfo() {
        this.Z = null;
    }

    public MintegralCreativeInfo(String id, BrandSafetyUtils.AdType adType, String creativeId, String clickUrl, String videoUrl, String imageUrl, BrandSafetyEvent.AdFormatType adFormat, String placementId, String sdkVersion, String downstreamStruct, boolean playableAd, String packageName) {
        super(adType, h.o, id, creativeId, clickUrl, videoUrl, downstreamStruct, sdkVersion);
        this.Z = null;
        a(adFormat);
        this.K = placementId;
        this.M = packageName;
        this.W = playableAd;
        x(imageUrl);
    }

    public String aq() {
        return this.Z;
    }

    public void a(String str) {
        this.Z = str;
        t("k=" + str);
    }

    public void b(String str, Set<String> set) {
        a(str, set);
        d();
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public JSONObject i() throws JSONException {
        JSONObject jSONObjectI = super.i();
        if (!TextUtils.isEmpty(this.Z)) {
            jSONObjectI.put(CampaignEx.JSON_KEY_AD_K, this.Z);
        }
        return jSONObjectI;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.a(jSONObject);
            this.Z = jSONObject.optString(CampaignEx.JSON_KEY_AD_K, "");
        }
    }
}
