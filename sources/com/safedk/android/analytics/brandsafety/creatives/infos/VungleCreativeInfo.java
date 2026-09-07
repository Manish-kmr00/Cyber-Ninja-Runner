package com.safedk.android.analytics.brandsafety.creatives.infos;

import android.text.TextUtils;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.annotations.AdNetworkIdentifier;
import com.safedk.android.utils.h;
import java.sql.Timestamp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@AdNetworkIdentifier(packageName = h.d)
public class VungleCreativeInfo extends CreativeInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8094a = "vungle_mraid";
    private static final long serialVersionUID = 0;
    private boolean Y;

    public VungleCreativeInfo() {
        this.Y = false;
    }

    public VungleCreativeInfo(BrandSafetyUtils.AdType adType, String id, String creativeId, String clickUrl, String videoUrl, BrandSafetyEvent.AdFormatType adFormat, String placement_id, String sdkVersion, long expiry, String struct) {
        super(adType, h.d, id, creativeId, clickUrl, videoUrl, struct, sdkVersion);
        this.Y = false;
        a(adFormat);
        this.K = placement_id;
        this.R = new Timestamp(expiry);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    public boolean a() {
        return TextUtils.isEmpty(P()) || TextUtils.isEmpty(O());
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    public void b(boolean z) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    public boolean u(String str) {
        return super.u(str);
    }

    public boolean aq() {
        return this.Y;
    }

    public void k(boolean z) {
        this.Y = z;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public JSONObject i() throws JSONException {
        JSONObject jSONObjectI = super.i();
        jSONObjectI.put("isLoopingVideo", this.Y);
        return jSONObjectI;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.a(jSONObject);
            this.Y = jSONObject.optBoolean("isLoopingVideo", false);
        }
    }
}
