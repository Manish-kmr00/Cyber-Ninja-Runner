package com.safedk.android.analytics.brandsafety.creatives.infos;

import android.text.TextUtils;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.h;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class PangleCreativeInfo extends CreativeInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8089a = "/dynamic_";
    private static final long serialVersionUID = 0;
    private String E;
    private int Y;

    public PangleCreativeInfo() {
    }

    public PangleCreativeInfo(BrandSafetyUtils.AdType adType, String id, String creativeId, String clickUrl, String videoUrl, String endCardUrl, boolean isPlayable, String placementId, String sdkVersion, String packageName, String downstreamStruct) {
        super(adType, h.u, id, creativeId, clickUrl, videoUrl, downstreamStruct, sdkVersion);
        this.K = placementId;
        this.W = isPlayable;
        this.at = endCardUrl;
        this.M = packageName;
        this.E = null;
        this.Y = 0;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public JSONObject i() throws JSONException {
        JSONObject jSONObjectI = super.i();
        if (!TextUtils.isEmpty(this.E)) {
            jSONObjectI.put("commonMultiAdUuid", this.E);
        }
        jSONObjectI.put("dynamicCreativesCount", this.Y);
        return jSONObjectI;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.a(jSONObject);
            this.E = jSONObject.optString("commonMultiAdUuid", "");
            this.Y = jSONObject.optInt("dynamicCreativesCount", 0);
        }
    }

    public void a(String str) {
        this.E = str;
    }

    public String aq() {
        return this.E;
    }

    public int ar() {
        return this.Y;
    }

    public void b(int i) {
        this.Y = i;
    }
}
