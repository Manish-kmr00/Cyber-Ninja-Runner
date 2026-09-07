package com.safedk.android.analytics.brandsafety.creatives.infos;

import android.os.Bundle;
import android.text.TextUtils;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.r;
import com.safedk.android.analytics.brandsafety.creatives.g;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.annotations.AdNetworkIdentifier;
import com.safedk.android.utils.h;
import com.safedk.android.utils.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@AdNetworkIdentifier(packageName = "com.unity3d.ads")
public class UnityAdsCreativeInfo extends CreativeInfo {
    private static final String E = "UnityAdsCreativeInfo";
    private static final String Z = "playableUrl";
    private static final String[] ah = {h.h, "com.unity3d.ads"};
    private static final long serialVersionUID = 0;
    private String Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8092a;
    private String ac;
    private String ae;
    private String af;
    private String ag;

    public UnityAdsCreativeInfo() {
        this.f8092a = null;
    }

    public UnityAdsCreativeInfo(String id, String creativeId, String clickUrl, String videoUrl, String playableAd, String contentType, String adDomain, BrandSafetyEvent.AdFormatType adFormat, String placementId, String sdkVersion, String bundleId, String buyerId, String endCardUrl) {
        super(BrandSafetyUtils.a(adFormat), "com.unity3d.ads", id, creativeId, clickUrl, videoUrl, contentType, sdkVersion);
        this.f8092a = null;
        this.ac = playableAd;
        this.aZ = adDomain;
        a(adFormat);
        this.K = placementId;
        if (TextUtils.isEmpty(this.M)) {
            this.M = bundleId;
        }
        this.ar = buyerId;
        this.at = endCardUrl;
        this.W = !TextUtils.isEmpty(this.ac);
    }

    public String aq() {
        return this.f8092a;
    }

    public String ar() {
        return this.ae;
    }

    public String as() {
        return this.af;
    }

    public String at() {
        return this.at;
    }

    public String au() {
        return this.ac;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    public String o() {
        return this.aZ;
    }

    public void d(String str, String str2) {
        this.ae = str;
        this.af = str2;
        if (!TextUtils.isEmpty(str2)) {
            this.T = true;
        }
    }

    public void a(String str) {
        this.ag = str;
        if (!TextUtils.isEmpty(str)) {
            this.T = true;
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    public Bundle b() {
        Bundle bundleB = super.b();
        if (P() == null || (this.I && !TextUtils.isEmpty(this.ae))) {
            bundleB.putString("creative_id", this.ae);
        }
        if (TextUtils.isEmpty(this.J) || (this.I && !TextUtils.isEmpty(this.af))) {
            bundleB.putString("video_url", this.af);
        }
        return bundleB;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    public boolean a() {
        return TextUtils.isEmpty(P()) || TextUtils.isEmpty(O());
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    protected boolean u(String str) {
        return (this.F.contains(r.b) || this.F.contains(r.c) || this.F.contains(r.d)) ? g.a(ah, str) : super.u(str);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    protected boolean b(String str) {
        if (this.F.contains(r.b) || this.F.contains(r.c) || this.F.contains(r.d)) {
            return AdMobCreativeInfo.a(str) || n.a(str, (Map<String, String>) null) || n.i(str);
        }
        return super.b(str);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    public String ad() {
        return P() + (this.ae != null ? ", " + this.ae : "");
    }

    public void H(String str) {
        this.f8092a = str;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    public void a(CreativeInfo creativeInfo) {
        Logger.d(E, "merge scar-admob CI started");
        n(creativeInfo.S());
        c(new ArrayList(creativeInfo.r()));
        Iterator<String> it = creativeInfo.q().iterator();
        while (it.hasNext()) {
            w(it.next());
        }
        Iterator<String> it2 = creativeInfo.u().iterator();
        while (it2.hasNext()) {
            B(it2.next());
        }
        Logger.d(E, "merge scar-admob CI admob's click url is: " + creativeInfo.O());
        if (creativeInfo.O() != null) {
            a(creativeInfo.O(), creativeInfo.an());
        }
        if (creativeInfo.v()) {
            f(true);
        }
        Logger.d(E, "merge scar-admob CI admob's video url is: " + creativeInfo.J());
        if (creativeInfo.J() != null) {
            p(creativeInfo.J());
        }
        if (creativeInfo.g()) {
            ac();
            E(creativeInfo.C());
        }
        if (creativeInfo.P() != null) {
            k(creativeInfo.P());
        }
        if (creativeInfo.X() != null) {
            t(creativeInfo.X());
        }
    }

    public String av() {
        return this.Y;
    }

    public void I(String str) {
        this.Y = str;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public JSONObject i() throws JSONException {
        JSONObject jSONObjectI = super.i();
        if (!TextUtils.isEmpty(this.ac)) {
            jSONObjectI.put(Z, this.ac);
        }
        if (!TextUtils.isEmpty(this.f8092a)) {
            jSONObjectI.put("clickString", this.f8092a);
        }
        if (!TextUtils.isEmpty(this.ae)) {
            jSONObjectI.put("portraitCreativeId", this.ae);
        }
        if (!TextUtils.isEmpty(this.af)) {
            jSONObjectI.put("portraitVideoUrl", this.af);
        }
        if (!TextUtils.isEmpty(this.ag)) {
            jSONObjectI.put("streamVideoUrl", this.ag);
        }
        if (!TextUtils.isEmpty(this.Y)) {
            jSONObjectI.put("debugBundleId", this.Y);
        }
        return jSONObjectI;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo, com.safedk.android.utils.f
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.a(jSONObject);
            this.ac = jSONObject.optString(Z, "");
            this.f8092a = jSONObject.optString("clickString", "");
            this.ae = jSONObject.optString("portraitCreativeId", "");
            this.af = jSONObject.optString("portraitVideoUrl", "");
            this.ag = jSONObject.optString("streamVideoUrl", "");
            this.Y = jSONObject.optString("debugBundleId", "");
        }
    }
}
