package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBAdLoader;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import net.pubnative.lite.sdk.models.AdExperience;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseDomainDeviceInfo.java */
/* JADX INFO: loaded from: classes13.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5053a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String j;
    public String k;
    public int m;
    public String n;
    public String o;
    public String p;
    public String r;
    public String s;
    public String t;
    public String v;
    public String q = "android";
    public String i = k0.t();
    public String u = k0.q();
    public String l = f.d();

    public d(Context context) {
        int iS = k0.s(context);
        this.n = String.valueOf(iS);
        this.o = k0.a(context, iS);
        this.j = k0.l(context);
        this.e = com.mbridge.msdk.foundation.controller.c.m().c();
        this.d = com.mbridge.msdk.foundation.controller.c.m().b();
        this.t = String.valueOf(t0.g(context));
        this.s = String.valueOf(t0.f(context));
        this.r = String.valueOf(t0.d(context));
        this.v = com.mbridge.msdk.foundation.controller.c.m().j().toString();
        this.g = k0.s();
        this.m = t0.a();
        if (context.getResources().getConfiguration().orientation == 2) {
            this.p = "landscape";
        } else {
            this.p = "portrait";
        }
        this.f = com.mbridge.msdk.foundation.same.a.V;
        this.h = com.mbridge.msdk.foundation.same.a.g;
        this.k = k0.u();
        this.c = f.e();
        this.f5053a = f.a();
        this.b = com.mbridge.msdk.foundation.controller.authoritycontroller.b.j() ? 1 : 0;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("device", this.i);
                jSONObject.put("system_version", this.u);
                jSONObject.put("network_type", this.n);
                jSONObject.put("network_type_str", this.o);
                jSONObject.put("device_ua", this.j);
                jSONObject.put("has_wx", k0.D(com.mbridge.msdk.foundation.controller.c.m().d()));
                jSONObject.put("integrated_wx", k0.D());
                jSONObject.put("opensdk_ver", k0.B() + "");
                jSONObject.put("wx_api_ver", k0.e(com.mbridge.msdk.foundation.controller.c.m().i()) + "");
                jSONObject.put(AdExperience.BRAND, this.g);
                jSONObject.put("mnc", k0.r(com.mbridge.msdk.foundation.controller.c.m().d()));
                jSONObject.put("mcc", k0.q(com.mbridge.msdk.foundation.controller.c.m().d()));
                jSONObject.put("adid_limit", this.f5053a);
                jSONObject.put("adid_limit_dev", this.b);
            }
            jSONObject.put("plantform", this.q);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.l);
                jSONObject.put("az_aid_info", this.c);
            }
            jSONObject.put(DTBAdLoader.APS_VIDEO_APP_KEY, this.e);
            jSONObject.put(RemoteConfigConstants.RequestFieldKey.APP_ID, this.d);
            jSONObject.put(CommonUrlParts.SCREEN_WIDTH, this.t);
            jSONObject.put(CommonUrlParts.SCREEN_HEIGHT, this.s);
            jSONObject.put("orientation", this.p);
            jSONObject.put("scale", this.r);
            jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, this.f);
            jSONObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, this.h);
            jSONObject.put("web_env", this.v);
            jSONObject.put(InneractiveMediationDefs.GENDER_FEMALE, this.k);
            jSONObject.put("misk_spt", this.m);
            if (k0.y() != 0) {
                jSONObject.put("tun", k0.y());
            }
            jSONObject.put(com.mbridge.msdk.foundation.same.net.wrapper.e.f, com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c() + "");
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("adid_limit", this.f5053a);
                jSONObject2.put("adid_limit_dev", this.b);
                jSONObject.put("dvi", i0.b(jSONObject2.toString()));
            }
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.i()) {
                jSONObject.put("dev_source", "2");
            }
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
