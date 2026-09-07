package com.safedk.android.analytics.brandsafety.creatives.infos;

import android.text.TextUtils;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.annotations.AdNetworkIdentifier;
import com.safedk.android.utils.h;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@AdNetworkIdentifier(packageName = h.f)
public class IronSourceCreativeInfo extends CreativeInfo {
    private static final String Y = "playableAd";
    private static final String Z = "creativeURL&quot;:&quot;";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8088a = "cpvi";
    private static final long serialVersionUID = 0;
    private String aa;
    private String ab;
    private String ac;

    public IronSourceCreativeInfo() {
    }

    public IronSourceCreativeInfo(String id, String creativeId, String clickUrl, String videoUrl, String sdkAdType, String playableAd, BrandSafetyEvent.AdFormatType adFormat, String placementId, String endCardUrl, String sdkVersion, String buyerID) {
        super(BrandSafetyUtils.AdType.INTERSTITIAL, h.f, id, creativeId, clickUrl, videoUrl, sdkAdType, sdkVersion);
        this.aa = playableAd;
        x(this.aa);
        a(adFormat);
        this.K = placementId;
        this.ab = sdkAdType;
        this.ar = buyerID;
        this.T = false;
        this.W = !TextUtils.isEmpty(playableAd);
        this.at = endCardUrl;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    public boolean a() {
        boolean z = TextUtils.isEmpty(P()) || TextUtils.isEmpty(O());
        if (!z) {
            switch (this.ab) {
                case "cpvi":
                    return TextUtils.isEmpty(this.J);
                case "playableAd":
                    return TextUtils.isEmpty(this.aa);
                default:
                    return z;
            }
        }
        return z;
    }

    public String aq() {
        return this.ac;
    }

    public String ar() {
        return this.ab;
    }

    public String as() {
        return this.aa;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    public void E(String str) {
        super.E(str);
        if (str != null && str.indexOf(Z) > -1) {
            this.ac = str.split(Z)[1].split("&quot;,&quot;")[0];
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public JSONObject i() throws JSONException {
        JSONObject jSONObjectI = super.i();
        if (!TextUtils.isEmpty(this.aa)) {
            jSONObjectI.put("playableUrl", this.aa);
        }
        if (!TextUtils.isEmpty(this.ab)) {
            jSONObjectI.put("sdkAdType", this.ab);
        }
        if (!TextUtils.isEmpty(this.ac)) {
            jSONObjectI.put("creativeUrl", this.ac);
        }
        return jSONObjectI;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.a(jSONObject);
            this.aa = jSONObject.optString("playableUrl", "");
            this.ab = jSONObject.optString("sdkAdType", "");
            this.ac = jSONObject.optString("creativeUrl", "");
        }
    }
}
