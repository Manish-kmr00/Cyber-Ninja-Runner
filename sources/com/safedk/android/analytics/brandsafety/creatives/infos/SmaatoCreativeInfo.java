package com.safedk.android.analytics.brandsafety.creatives.infos;

import android.os.Bundle;
import android.text.TextUtils;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.annotations.AdNetworkIdentifier;
import com.safedk.android.utils.h;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@AdNetworkIdentifier(packageName = h.v)
public class SmaatoCreativeInfo extends CreativeInfo {
    private static final String E = "iurl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8091a = "SmaatoCreativeInfo";
    private static final long serialVersionUID = 0;
    private String Y;

    public SmaatoCreativeInfo() {
    }

    public SmaatoCreativeInfo(String id, String creativeId, BrandSafetyUtils.AdType adType, BrandSafetyEvent.AdFormatType adFormat, String placementId, String adDomain, String iurl, String downstreamStruct, String sdkVersion, String clickUrl) {
        super(adType, h.v, id, creativeId, clickUrl, null, downstreamStruct, sdkVersion);
        a(adFormat);
        this.K = placementId;
        this.aZ = adDomain;
        this.Y = iurl;
    }

    public String aq() {
        return this.Y;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    public Bundle b() {
        Bundle bundleB = super.b();
        if (!TextUtils.isEmpty(this.Y)) {
            bundleB.putString(E, this.Y);
        }
        return bundleB;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public JSONObject i() throws JSONException {
        JSONObject jSONObjectI = super.i();
        if (!TextUtils.isEmpty(this.Y)) {
            jSONObjectI.put(E, this.Y);
        }
        return jSONObjectI;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.a(jSONObject);
            this.Y = jSONObject.optString(E, "");
        }
    }
}
