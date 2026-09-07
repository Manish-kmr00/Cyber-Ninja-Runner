package com.safedk.android.analytics.brandsafety.creatives.infos;

import android.text.TextUtils;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.annotations.AdNetworkIdentifier;
import com.safedk.android.utils.h;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@AdNetworkIdentifier(packageName = h.C)
public class VerveCreativeInfo extends CreativeInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8093a = "VerveCreativeInfo";
    private static final long serialVersionUID = 0;
    private String E;
    private String Y;
    private String Z;

    public VerveCreativeInfo() {
        this.E = null;
        this.Y = null;
        this.Z = null;
    }

    public VerveCreativeInfo(BrandSafetyUtils.AdType adType, String id, String creativeId, String clickUrl, String videoUrl, BrandSafetyEvent.AdFormatType adFormatType, String placementId, String sdkVersion, String downstreamStruct, String dspName, String eventId, String appPackageName, boolean isVideoAd, boolean isPlayable) {
        super(adType, h.C, id, creativeId, clickUrl, videoUrl, downstreamStruct, sdkVersion);
        this.E = null;
        this.Y = null;
        this.Z = null;
        this.K = placementId;
        a(adFormatType);
        this.ar = dspName;
        this.T = isVideoAd;
        this.W = isPlayable;
        h(eventId);
    }

    public void a(String str) {
        this.E = str;
    }

    public String aq() {
        return this.E;
    }

    public void H(String str) {
        this.Y = str;
    }

    public String ar() {
        return this.Y;
    }

    public void I(String str) {
        this.Z = str;
    }

    public String as() {
        return this.Z;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public JSONObject i() throws JSONException {
        JSONObject jSONObjectI = super.i();
        if (!TextUtils.isEmpty(this.E)) {
            jSONObjectI.put("innerDspCreativeId", this.E);
        }
        if (!TextUtils.isEmpty(this.Y)) {
            jSONObjectI.put("innerImpressionUrl", this.Y);
        }
        if (!TextUtils.isEmpty(this.Z)) {
            jSONObjectI.put("impIdCrid", this.Z);
        }
        return jSONObjectI;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.a(jSONObject);
            this.E = jSONObject.optString("innerDspCreativeId", "");
            this.Y = jSONObject.optString("innerImpressionUrl", "");
            this.Z = jSONObject.optString("impIdCrid", "");
        }
    }
}
