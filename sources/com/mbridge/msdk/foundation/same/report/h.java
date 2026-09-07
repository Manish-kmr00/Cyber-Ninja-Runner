package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.json.cc;
import com.json.fe;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.Campaign;
import java.net.URLEncoder;
import org.json.JSONObject;

/* JADX INFO: compiled from: ReportController.java */
/* JADX INFO: loaded from: classes11.dex */
public class h {
    public static final String b = "h";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5017a;

    public h(Context context, int i) {
        this.f5017a = context;
    }

    public void a(String str, com.mbridge.msdk.foundation.entity.e eVar, String str2) {
        JSONObject jSONObjectA = com.mbridge.msdk.foundation.entity.e.a(eVar);
        if (jSONObjectA != null) {
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(jSONObjectA);
        }
    }

    public void b(String str, String str2, String str3, String str4, String str5, boolean z) {
        try {
            if (TextUtils.isEmpty(str5)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (z) {
                jSONObject.put(CampaignEx.JSON_KEY_HB, 1);
            }
            jSONObject.put("key", URLEncoder.encode("2000066", cc.N));
            jSONObject.put(com.safedk.android.analytics.brandsafety.l.x, URLEncoder.encode(str, cc.N));
            jSONObject.put("rid_n", URLEncoder.encode(str2, cc.N));
            jSONObject.put("cid", URLEncoder.encode(str3, cc.N));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, URLEncoder.encode(str4, cc.N));
            jSONObject.put("err_method", str5);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(jSONObject);
        } catch (Exception e) {
            o0.b(b, e.getMessage());
        }
    }

    public h(Context context) {
        this.f5017a = context.getApplicationContext();
    }

    public void a(int i, int i2, String str, String str2, String str3) {
        i.a(this.f5017a, i, i2, str, str2, str3);
    }

    public void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                jSONObject.put(CampaignEx.JSON_KEY_HB, 1);
            }
            jSONObject.put("key", URLEncoder.encode("2000065", cc.N));
            jSONObject.put(com.safedk.android.analytics.brandsafety.l.x, URLEncoder.encode(str, cc.N));
            jSONObject.put("rid_n", URLEncoder.encode(str2, cc.N));
            jSONObject.put("cid", URLEncoder.encode(str3, cc.N));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, URLEncoder.encode(str4, cc.N));
            jSONObject.put("click_url", URLEncoder.encode(str5, cc.N));
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(jSONObject);
        } catch (Exception e) {
            o0.b(b, e.getMessage());
        }
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        try {
            int iS = k0.s(this.f5017a);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", URLEncoder.encode("2000071", cc.N));
            jSONObject.put(com.safedk.android.analytics.brandsafety.l.x, URLEncoder.encode(str, cc.N));
            jSONObject.put("rid_n", URLEncoder.encode(str2, cc.N));
            jSONObject.put("cid", URLEncoder.encode(str3, cc.N));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, URLEncoder.encode(str4, cc.N));
            jSONObject.put("reason", URLEncoder.encode(str5, cc.N));
            jSONObject.put("network_type", URLEncoder.encode(String.valueOf(iS), cc.N));
            jSONObject.put("result", URLEncoder.encode("0", cc.N));
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(jSONObject);
        } catch (Exception e) {
            o0.b(b, e.getMessage());
        }
    }

    public void a() {
        try {
            if (j.a()) {
                String strB = com.mbridge.msdk.foundation.controller.c.m().b();
                com.mbridge.msdk.setting.g gVarD = com.mbridge.msdk.setting.h.b().d(strB);
                if (gVarD == null) {
                    gVarD = com.mbridge.msdk.setting.h.b().a();
                }
                String strD = com.mbridge.msdk.foundation.tools.f.d();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "2000053");
                jSONObject.put("Appid", strB);
                jSONObject.put("uptips2", gVarD.r0());
                jSONObject.put("info_status", com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().g());
                jSONObject.put("iseu", gVarD.F());
                if (!TextUtils.isEmpty(strD)) {
                    jSONObject.put(fe.Q0, strD);
                }
                jSONObject.put("GDPR_area", gVarD.E0());
                jSONObject.put("GDPR_consent", com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().e());
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a(jSONObject);
                j.c();
            }
        } catch (Throwable th) {
            o0.b(b, th.getMessage());
        }
    }

    public void a(int i, String str) {
        com.mbridge.msdk.foundation.same.report.metrics.d.b().a(j.a((Campaign) null, i, "request"));
    }

    public void a(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("click_type", "1");
            jSONObject.put("cid", str);
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
            jSONObject.put("key", "2000027");
            jSONObject.put("http_url", str3);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(jSONObject);
        } catch (Exception e) {
            o0.b(b, e.getMessage());
        }
    }
}
