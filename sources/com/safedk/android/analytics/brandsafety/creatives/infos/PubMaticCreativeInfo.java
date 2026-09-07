package com.safedk.android.analytics.brandsafety.creatives.infos;

import android.text.TextUtils;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.annotations.AdNetworkIdentifier;
import com.safedk.android.utils.h;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@AdNetworkIdentifier(packageName = h.C)
public class PubMaticCreativeInfo extends CreativeInfo {
    private String E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8090a;

    public PubMaticCreativeInfo(BrandSafetyUtils.AdType adType, String id, String creativeId, String clickUrl, String videoUrl, BrandSafetyEvent.AdFormatType adFormatType, String placementId, String sdkVersion, String downstreamStruct, String dspName, String eventId, String appPackageName, boolean isVideoAd, boolean isPlayable) {
        super(adType, h.F, id, creativeId, clickUrl, videoUrl, downstreamStruct, sdkVersion);
        this.E = null;
        this.K = placementId;
        a(adFormatType);
        this.ar = dspName;
        this.T = isVideoAd;
        this.W = isPlayable;
        h(eventId);
    }

    public String aq() {
        return this.f8090a;
    }

    public void d(List<String> list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                sb.append(list.get(i2));
                if (i2 != list.size() - 1) {
                    sb.append(StringUtils.COMMA);
                }
                i = i2 + 1;
            } else {
                this.f8090a = sb.toString();
                return;
            }
        }
    }

    public String ar() {
        return this.E;
    }

    public void a(String str) {
        this.E = str;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public JSONObject i() throws JSONException {
        JSONObject jSONObjectI = super.i();
        if (!TextUtils.isEmpty(this.f8090a)) {
            jSONObjectI.put("allMediaUrls", this.f8090a);
        }
        if (!TextUtils.isEmpty(this.E)) {
            jSONObjectI.put("innerImpressionUrl", this.E);
        }
        return jSONObjectI;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.a(jSONObject);
            this.f8090a = jSONObject.optString("allMediaUrls", "");
            this.E = jSONObject.optString("innerImpressionUrl", "");
        }
    }
}
