package com.safedk.android.analytics.brandsafety.creatives.infos;

import android.os.Bundle;
import android.text.TextUtils;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.g;
import com.safedk.android.utils.annotations.AdNetworkIdentifier;
import com.safedk.android.utils.h;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@AdNetworkIdentifier(packageName = h.c)
public class ChartboostCreativeInfo extends CreativeInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8085a = "advertised_content";
    private static final long serialVersionUID = 0;
    private String E;

    public ChartboostCreativeInfo() {
    }

    public ChartboostCreativeInfo(BrandSafetyUtils.AdType adType, String sdk, String sdkVersion) {
        super(adType, sdk, null, null, null, null, null, sdkVersion);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    public Bundle b() {
        Bundle bundleB = super.b();
        if (!TextUtils.isEmpty(this.E)) {
            bundleB.putString(f8085a, this.E);
        }
        return bundleB;
    }

    public void a(String str) {
        this.E = str;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public JSONObject i() throws JSONException {
        JSONObject jSONObjectI = super.i();
        if (!TextUtils.isEmpty(this.E)) {
            jSONObjectI.put(g.c, this.E);
        }
        return jSONObjectI;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.a(jSONObject);
            this.E = jSONObject.optString(g.c, "");
        }
    }
}
