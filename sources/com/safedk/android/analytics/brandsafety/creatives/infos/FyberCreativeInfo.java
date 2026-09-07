package com.safedk.android.analytics.brandsafety.creatives.infos;

import android.os.Bundle;
import android.text.TextUtils;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.annotations.AdNetworkIdentifier;
import com.safedk.android.utils.h;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@AdNetworkIdentifier(packageName = h.p)
public class FyberCreativeInfo extends CreativeInfo {
    private static final String Y = "FyberCreativeInfo";
    private static final String aa = "alternative_click_url";
    private static final List<String> ac = Arrays.asList("www.serveroute.com/log_string", "column=", "line=", "ad_exchange=inneractive&mraid_version=");
    private static final long serialVersionUID = 0;
    private String ad;
    private String ag;

    public FyberCreativeInfo() {
    }

    public FyberCreativeInfo(String id, String creativeId, String campaignId, String clickUrl, String videoUrl, BrandSafetyEvent.AdFormatType adFormat, BrandSafetyUtils.AdType adType, String spotId, String sdkVersion, String adNetwork, String adDomain, String alternativeClickUrl, String eventId) {
        super(adType, h.p, id, creativeId, clickUrl, videoUrl, "", sdkVersion);
        this.K = spotId;
        Logger.d(Y, "FyberCreativeInfo ctor started");
        a(adFormat);
        this.ad = campaignId;
        this.ar = adNetwork;
        this.aZ = adDomain;
        this.ag = alternativeClickUrl;
        h(eventId);
    }

    public String aq() {
        return this.ad;
    }

    public String ar() {
        return this.ag;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    public boolean a() {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    public Bundle b() {
        Bundle bundleB = super.b();
        if (!TextUtils.isEmpty(this.ad)) {
            bundleB.putString("campaign_id", this.ad);
        }
        if (!TextUtils.isEmpty(this.ag)) {
            bundleB.putString(aa, this.ag);
        }
        return bundleB;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    public void b(List<String> list) {
        Logger.d(Y, "classifyPrefetchUrl started, urlList=" + list);
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String strC = C(it.next());
                boolean z = false;
                if (!TextUtils.isEmpty(strC)) {
                    if (b(strC)) {
                        x(strC);
                        z = true;
                    } else if (u(strC) && !strC.equals(O())) {
                        w(strC);
                        z = true;
                    }
                    if (!z) {
                        Logger.d(Y, "classifyPrefetchUrl url is unclassified and will be dropped : " + strC);
                    }
                }
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public JSONObject i() throws JSONException {
        JSONObject jSONObjectI = super.i();
        if (!TextUtils.isEmpty(this.ad)) {
            jSONObjectI.put("campaignId", this.ad);
        }
        if (!TextUtils.isEmpty(this.ag)) {
            jSONObjectI.put("alternativeClickUrl", this.ag);
        }
        return jSONObjectI;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.a(jSONObject);
            this.ad = jSONObject.optString("campaignId", "");
            this.ag = jSONObject.optString("alternativeClickUrl", "");
        }
    }
}
