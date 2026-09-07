package com.mbridge.msdk.foundation.same.net;

import com.mbridge.msdk.foundation.entity.h;
import com.mbridge.msdk.foundation.tools.o0;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import org.json.JSONObject;

/* JADX INFO: compiled from: Listener.java */
/* JADX INFO: loaded from: classes14.dex */
public class c<T> implements b<T> {
    private long startTime;
    public int adType = 0;
    public String placementId = "";
    public String unitId = "";
    private com.mbridge.msdk.foundation.same.report.campaignreport.b mRequestTime = null;

    public void calcRequestTime(long j) {
        com.mbridge.msdk.foundation.same.report.campaignreport.b bVar = new com.mbridge.msdk.foundation.same.report.campaignreport.b(new h());
        this.mRequestTime = bVar;
        bVar.b(this.unitId);
        this.mRequestTime.b(1);
        this.mRequestTime.a((j - this.startTime) + "");
    }

    public void onCancel() {
    }

    @Override // com.mbridge.msdk.foundation.same.net.b
    public void onError(com.mbridge.msdk.foundation.same.net.exception.a aVar) {
    }

    public void onFinish() {
    }

    public void onNetworking() {
    }

    public void onPreExecute() {
        this.startTime = System.currentTimeMillis();
    }

    public void onProgressChange(long j, long j2) {
    }

    public void onRetry() {
    }

    @Override // com.mbridge.msdk.foundation.same.net.b
    public void onSuccess(e<T> eVar) {
        try {
            String str = com.mbridge.msdk.foundation.controller.c.m().b() + "_" + this.placementId + "_" + this.unitId + "_" + this.adType;
            com.mbridge.msdk.setting.h.b().a(this.unitId);
            o0.b("Listener", eVar.c + " " + str);
            T t = eVar.c;
            if (t instanceof JSONObject) {
                com.mbridge.msdk.foundation.same.net.utils.c.b().a(str, ((JSONObject) t).optInt("status"), ((JSONObject) eVar.c).toString(), System.currentTimeMillis());
            }
            if (eVar.c instanceof String) {
                com.mbridge.msdk.foundation.same.net.utils.c.b().a(str, MintegralNetworkBridge.jsonObjectInit((String) eVar.c).optInt("status"), (String) eVar.c, System.currentTimeMillis());
            }
        } catch (Exception e) {
            o0.b("Listener", e.getMessage());
        }
    }

    public void saveHbState(int i) {
        com.mbridge.msdk.foundation.same.report.campaignreport.b bVar = this.mRequestTime;
        if (bVar != null) {
            bVar.c(i);
        }
    }

    public void saveRequestTime(int i) {
        com.mbridge.msdk.foundation.same.report.campaignreport.b bVar = this.mRequestTime;
        if (bVar != null) {
            bVar.a(i);
            this.mRequestTime.a();
        }
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public void setUnitId(String str) {
        this.unitId = str;
    }
}
