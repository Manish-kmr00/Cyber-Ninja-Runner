package com.mbridge.msdk.foundation.same.report.campaignreport;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.h;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.tracker.e;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseCampaignRequestTimeUtil.java */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f5006a;
    protected h b;

    public a(h hVar) {
        this.b = hVar;
        Context contextD = c.m().d();
        this.f5006a = contextD;
        if (this.b == null || contextD == null) {
            return;
        }
        int iS = k0.s(contextD);
        this.b.c(iS);
        this.b.a(k0.a(this.f5006a, iS));
    }

    public void a() {
        if (this.b != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("time", this.b.f());
                jSONObject.put(CampaignEx.JSON_KEY_HB, this.b.i());
                jSONObject.put("fb", this.b.b());
                jSONObject.put("num", this.b.e());
                jSONObject.put(CampaignEx.JSON_KEY_AD_SOURCE_ID, this.b.a());
                jSONObject.put("timeout", this.b.g());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.b.h());
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put("network_type", this.b.d());
                    jSONObject.put("network_str", this.b.c());
                }
                e eVar = new e("2000006");
                eVar.a(0);
                eVar.b(0);
                eVar.a(jSONObject);
                eVar.a(com.mbridge.msdk.foundation.same.report.c.d());
                d.b().d().d(eVar);
            } catch (Throwable unused) {
            }
        }
    }

    public void b(int i) {
        h hVar = this.b;
        if (hVar != null) {
            hVar.a(i);
        }
    }

    public void c(int i) {
        h hVar = this.b;
        if (hVar != null) {
            hVar.b(i);
        }
    }

    public void b(String str) {
        h hVar = this.b;
        if (hVar != null) {
            hVar.c(str);
        }
    }

    public void a(int i) {
        h hVar = this.b;
        if (hVar != null) {
            hVar.d(i);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.b(str);
    }
}
