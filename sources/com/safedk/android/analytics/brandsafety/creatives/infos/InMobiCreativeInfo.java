package com.safedk.android.analytics.brandsafety.creatives.infos;

import android.os.Bundle;
import android.text.TextUtils;
import com.json.b9;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.g;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.h;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class InMobiCreativeInfo extends CreativeInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8087a = "advertised_content";
    private static final String aa = "InMobiCreativeInfo";
    private static final long serialVersionUID = 0;
    private int E;
    private String Y;
    private String Z;

    public InMobiCreativeInfo() {
    }

    public InMobiCreativeInfo(String id, String creativeId, String placementId, String sdkVersion, BrandSafetyUtils.AdType adType, int multiAds, BrandSafetyEvent.AdFormatType adFormat, String eventId, String advertisedContent) {
        BrandSafetyEvent.AdFormatType adFormat2;
        super(adType, h.i, id, creativeId, null, null, null, sdkVersion);
        this.K = placementId;
        this.Y = id;
        this.E = multiAds;
        if (adFormat != null) {
            a(adFormat);
        } else if (adType != null && (adFormat2 = BrandSafetyUtils.a(adType)) != null) {
            a(adFormat2);
        }
        h(eventId);
        this.Z = advertisedContent;
    }

    public String aq() {
        return this.Y;
    }

    public int ar() {
        return this.E;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    public Bundle b() {
        Bundle bundleB = super.b();
        if (this.bh != null && !this.bh.isEmpty()) {
            synchronized (this.bh) {
                bundleB.putStringArrayList(BrandSafetyEvent.u, new ArrayList<>(this.bh));
            }
        }
        if (!TextUtils.isEmpty(this.Z)) {
            bundleB.putString(f8087a, this.Z);
        }
        return bundleB;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    protected boolean b(String str) {
        if (str == null) {
            return false;
        }
        return super.b(str.split(b9.i.c)[0]);
    }

    public InMobiCreativeInfo as() {
        return new InMobiCreativeInfo(N(), P(), this.K, this.Q, M(), this.E, BrandSafetyEvent.AdFormatType.valueOf(K()), n(), this.Z);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public JSONObject i() throws JSONException {
        JSONObject jSONObjectI = super.i();
        if (!TextUtils.isEmpty(this.Y)) {
            jSONObjectI.put("impressionId", this.Y);
        }
        jSONObjectI.put("multiAds", this.E);
        if (!TextUtils.isEmpty(this.Z)) {
            jSONObjectI.put(g.c, this.Z);
        }
        return jSONObjectI;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.a(jSONObject);
            this.Y = jSONObject.optString("impressionId", "");
            this.E = jSONObject.optInt("multiAds", 0);
            this.Z = jSONObject.optString(g.c, "");
        }
    }
}
