package com.mbridge.msdk.reward.candidate;

import android.text.TextUtils;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.foundation.cache.d;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.i0;
import com.mbridge.msdk.foundation.tools.t0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardCandidateController.java */
/* JADX INFO: loaded from: classes12.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f5358a;

    public a(String str, boolean z) {
        try {
            this.f5358a = b.a().b(str, com.mbridge.msdk.videocommon.setting.b.b().a(c.m().b(), str, z).B());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(List<CampaignEx> list, String str, com.mbridge.msdk.reward.adapter.c cVar, String str2) {
        try {
            if (this.f5358a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f5358a.a(com.mbridge.msdk.foundation.cache.a.f, 2, list, this.f5358a.a(list, str) > 0, "", "", -1, str2);
            d dVar = this.f5358a;
            JSONObject jSONObjectC = dVar.c(dVar.d(str));
            if (jSONObjectC == null || this.f5358a.b(str) <= 0.0d) {
                return;
            }
            a(this.f5358a.a(jSONObjectC.optInt("max_usage_limit", 10), 0L), jSONObjectC, jSONObjectC.optInt("max_cache_num", 20), -1.0d, cVar, new com.mbridge.msdk.foundation.same.report.metrics.c(), str, false, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public com.mbridge.msdk.foundation.cache.c a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar, CampaignEx campaignEx, com.mbridge.msdk.foundation.error.b bVar, int i, com.mbridge.msdk.reward.adapter.c cVar2) {
        String requestId;
        com.mbridge.msdk.foundation.cache.c cVar3 = new com.mbridge.msdk.foundation.cache.c();
        if (campaignEx == null) {
            requestId = "";
        } else {
            try {
                try {
                    requestId = campaignEx.getRequestId();
                } catch (Exception unused) {
                    cVar3.d("getCandidateCampaignList result exception");
                    cVar3.a(com.mbridge.msdk.foundation.cache.c.k);
                    return cVar3;
                }
            } catch (Exception unused2) {
                cVar3.d("getRewardCandidateCampaignList result exception");
                cVar3.a(com.mbridge.msdk.foundation.cache.c.k);
                return cVar3;
            }
        }
        return a(str, cVar, requestId, bVar, i, cVar2);
    }

    private com.mbridge.msdk.foundation.cache.c a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str2, com.mbridge.msdk.foundation.error.b bVar, int i, com.mbridge.msdk.reward.adapter.c cVar2) {
        String strG;
        int i2;
        String str3;
        if (bVar != null) {
            int iC = bVar.c();
            strG = bVar.g();
            i2 = iC;
        } else {
            strG = null;
            i2 = 0;
        }
        String str4 = strG;
        d dVar = this.f5358a;
        if (dVar == null) {
            com.mbridge.msdk.foundation.cache.c cVar3 = new com.mbridge.msdk.foundation.cache.c();
            cVar3.d("can not get manager");
            cVar3.a(com.mbridge.msdk.foundation.cache.c.k);
            return cVar3;
        }
        com.mbridge.msdk.foundation.cache.c cVarA = dVar.a(str);
        if (cVarA.g() > com.mbridge.msdk.foundation.cache.c.j) {
            return cVarA;
        }
        String[] strArrSplit = i0.a(str.split("_")[3]).split("\\|");
        double d = Double.parseDouble(strArrSplit[0]);
        if (strArrSplit.length <= 1) {
            str3 = "";
        } else {
            str3 = strArrSplit[1];
        }
        com.mbridge.msdk.foundation.cache.c cVarA2 = a(d, str3, cVar2, cVar, str, i);
        this.f5358a.a(cVarA2.c(), cVar, str2, i2, str4, i, d);
        return cVarA2;
    }

    private com.mbridge.msdk.foundation.cache.c a(double d, String str, com.mbridge.msdk.reward.adapter.c cVar, com.mbridge.msdk.foundation.same.report.metrics.c cVar2, String str2, int i) {
        com.mbridge.msdk.foundation.cache.c cVarA = this.f5358a.a();
        try {
            if (cVarA.g() > 0) {
                return cVarA;
            }
            JSONObject jSONObjectC = this.f5358a.c(str);
            if (jSONObjectC != null) {
                int iOptInt = jSONObjectC.optInt("max_usage_limit", 10);
                int iOptInt2 = jSONObjectC.optInt("max_cache_num", 20);
                if (iOptInt2 > 0) {
                    long j = 8640000;
                    long jOptLong = jSONObjectC.optLong("show_interval_time", 8640000L);
                    if (jOptLong != 0) {
                        j = jOptLong;
                    }
                    List<com.mbridge.msdk.foundation.cache.b> listA = this.f5358a.a(iOptInt, System.currentTimeMillis() - (j * 1000));
                    if (listA != null && listA.size() > 0) {
                        return a(listA, jSONObjectC, iOptInt2, d, cVar, cVar2, str2, true, i);
                    }
                    cVarA.d("no cache");
                    cVarA.a(com.mbridge.msdk.foundation.cache.c.k);
                    a(cVar2, str2, cVarA, (List<com.mbridge.msdk.foundation.cache.a.b>) null, jSONObjectC, 2);
                } else {
                    cVarA.d("max cache num error");
                    cVarA.a(com.mbridge.msdk.foundation.cache.c.k);
                }
            } else {
                cVarA.d("setting config not mapping");
                cVarA.a(com.mbridge.msdk.foundation.cache.c.k);
            }
            return cVarA;
        } catch (Exception unused) {
            cVarA.d("getHighestCampaigns exception");
            cVarA.a(com.mbridge.msdk.foundation.cache.c.k);
        }
    }

    private com.mbridge.msdk.foundation.cache.c a(List<com.mbridge.msdk.foundation.cache.b> list, JSONObject jSONObject, int i, double d, com.mbridge.msdk.reward.adapter.c cVar, com.mbridge.msdk.foundation.same.report.metrics.c cVar2, String str, boolean z, int i2) {
        ArrayList arrayList;
        int i3;
        com.mbridge.msdk.foundation.cache.c cVar3;
        a aVar = this;
        List<com.mbridge.msdk.foundation.cache.b> listA = list;
        com.mbridge.msdk.foundation.cache.c cVar4 = new com.mbridge.msdk.foundation.cache.c();
        if (jSONObject == null) {
            cVar4.d("config is null");
            cVar4.a(com.mbridge.msdk.foundation.cache.c.k);
            return cVar4;
        }
        if (listA != null && list.size() != 0) {
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                com.mbridge.msdk.foundation.cache.b bVar = listA.get(i5);
                if (bVar != null) {
                    cVar4.a(bVar.e());
                }
            }
            if (list.size() > 0 && ((listA = aVar.a(listA, cVar4)) == null || listA.size() == 0)) {
                cVar4.d("existed");
                cVar4.a(com.mbridge.msdk.foundation.cache.c.k);
            }
            if (listA.size() > 0 && ((listA = aVar.a(listA, cVar, cVar4)) == null || listA.size() == 0)) {
                cVar4.d("not ready");
                cVar4.a(com.mbridge.msdk.foundation.cache.c.k);
            }
            com.mbridge.msdk.foundation.cache.b bVar2 = null;
            if (listA == null || listA.size() <= 0) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                double dOptDouble = jSONObject.optDouble("t_disc", 0.8d);
                double dOptDouble2 = jSONObject.optDouble("u_disc", 0.95d);
                double d2 = 0.0d;
                double dOptDouble3 = jSONObject.optDouble("max_ecppv_diff", 0.0d);
                int iOptInt = jSONObject.optInt(SDKConstants.PARAM_A2U_TIME_INTERVAL, 1800);
                int size = listA.size();
                while (i4 < size) {
                    List<com.mbridge.msdk.foundation.cache.b> list2 = listA;
                    com.mbridge.msdk.foundation.cache.b bVar3 = listA.get(i4);
                    if (bVar3 != null) {
                        i3 = size;
                        cVar3 = cVar4;
                        double dPow = Math.pow(dOptDouble2, bVar3.f()) * bVar3.b() * Math.pow(dOptDouble, (System.currentTimeMillis() - bVar3.h()) / (((double) iOptInt) * 1000.0d));
                        arrayList2.add(new com.mbridge.msdk.foundation.cache.a.b(dPow, bVar3));
                        if (dPow >= d - dOptDouble3 && dPow > d2) {
                            bVar2 = bVar3;
                            d2 = dPow;
                        }
                    } else {
                        i3 = size;
                        cVar3 = cVar4;
                    }
                    i4++;
                    aVar = this;
                    listA = list2;
                    size = i3;
                    cVar4 = cVar3;
                }
                com.mbridge.msdk.foundation.cache.c cVar5 = cVar4;
                d dVar = aVar.f5358a;
                if (dVar != null) {
                    dVar.a(arrayList2, i);
                }
                if (bVar2 != null) {
                    cVar4 = cVar5;
                    cVar4.a(bVar2.a());
                    cVar4.a(com.mbridge.msdk.foundation.cache.c.l);
                } else {
                    cVar4 = cVar5;
                    cVar4.d("no match campaign");
                    cVar4.a(com.mbridge.msdk.foundation.cache.c.k);
                }
                arrayList = arrayList2;
            }
            if (z) {
                a(cVar2, str, cVar4, arrayList, jSONObject, 2);
            }
            return cVar4;
        }
        cVar4.d("candidate is null");
        cVar4.a(com.mbridge.msdk.foundation.cache.c.k);
        return cVar4;
    }

    private List<com.mbridge.msdk.foundation.cache.b> a(List<com.mbridge.msdk.foundation.cache.b> list, com.mbridge.msdk.foundation.cache.c cVar) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA;
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            com.mbridge.msdk.foundation.cache.b bVar = list.get(i);
            if (bVar != null && (copyOnWriteArrayListA = bVar.a()) != null && copyOnWriteArrayListA.size() != 0) {
                int i2 = 0;
                boolean z = false;
                while (i2 < copyOnWriteArrayListA.size()) {
                    CampaignEx campaignEx = copyOnWriteArrayListA.get(i2);
                    boolean zC = t0.c(c.m().d(), campaignEx.getPackageName());
                    if (zC) {
                        cVar.b(bVar.e());
                        d dVar = this.f5358a;
                        if (dVar != null) {
                            dVar.a(bVar.d(), bVar.e(), 2, campaignEx.getEcppv());
                        }
                        z = zC;
                        break;
                    }
                    i2++;
                    z = zC;
                }
                if (!z) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    private List<com.mbridge.msdk.foundation.cache.b> a(List<com.mbridge.msdk.foundation.cache.b> list, com.mbridge.msdk.reward.adapter.c cVar, com.mbridge.msdk.foundation.cache.c cVar2) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA;
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            com.mbridge.msdk.foundation.cache.b bVar = list.get(i);
            if (bVar != null && (copyOnWriteArrayListA = bVar.a()) != null && copyOnWriteArrayListA.size() != 0) {
                boolean zA = false;
                for (int i2 = 0; i2 < copyOnWriteArrayListA.size(); i2++) {
                    CampaignEx campaignEx = copyOnWriteArrayListA.get(i2);
                    if (cVar != null && !(zA = cVar.a(copyOnWriteArrayListA, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())))) {
                        cVar2.c(bVar.e());
                        d dVar = this.f5358a;
                        if (dVar == null) {
                            break;
                        }
                        dVar.a(bVar.d(), bVar.e(), 2, campaignEx.getEcppv());
                        break;
                    }
                }
                if (zA) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    public boolean a(String str) {
        JSONObject jSONObjectC;
        try {
            d dVar = this.f5358a;
            return (dVar == null || (jSONObjectC = dVar.c(dVar.d(str))) == null || jSONObjectC.optInt("c_cb", 0) != 1) ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void a(String str, String str2, int i, String str3) {
        d dVar = this.f5358a;
        if (dVar != null) {
            dVar.a(str, str2, i, str3);
        }
    }

    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str, com.mbridge.msdk.foundation.cache.c cVar2, List<com.mbridge.msdk.foundation.cache.a.b> list, JSONObject jSONObject, int i) {
        String str2;
        try {
            e eVar = new e();
            if (i == 1) {
                str2 = "cb";
            } else if (i == 2) {
                str2 = "candidate";
            } else if (i != 3) {
                str2 = "unknown";
            } else {
                str2 = "track";
            }
            eVar.a("scene", str2);
            d dVar = this.f5358a;
            if (dVar != null) {
                double dB = dVar.b(str);
                if (dB >= 0.0d) {
                    eVar.a("bp", i0.b(dB + ""));
                }
                eVar.a("cb_state", a(str) ? "open" : "close");
                try {
                    d dVar2 = this.f5358a;
                    JSONObject jSONObjectC = dVar2.c(dVar2.d(str));
                    if (jSONObjectC != null) {
                        eVar.a(DTBMetricsConfiguration.CONFIG_DIR, jSONObjectC.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (cVar2 != null) {
                if (cVar2.g() == com.mbridge.msdk.foundation.cache.c.l) {
                    eVar.a("result", 1);
                } else {
                    eVar.a("result", 2);
                    eVar.a("reason", cVar2.e());
                }
                eVar.a("acr", cVar2.a());
                eVar.a("her", cVar2.d());
                eVar.a("nrr", cVar2.f());
                eVar.a("cer", cVar2.b());
            } else {
                eVar.a("result", 2);
                eVar.a("reason", "candidate result is null");
            }
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    com.mbridge.msdk.foundation.cache.b bVarA = list.get(i2).a();
                    if (bVarA != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("ecppv", i0.b(bVarA.b() + ""));
                        jSONObject2.put("showCount", bVarA.f());
                        jSONObject2.put("intervalTime", System.currentTimeMillis() - bVarA.h());
                        jSONArray.put(jSONObject2);
                    }
                }
                eVar.a("data", jSONArray.toString());
            }
            if (cVar != null) {
                cVar.i("m_candidate_data");
                cVar.d("m_candidate_data");
                cVar.a("m_candidate_data", eVar);
                if (cVar2 != null && cVar2.c() != null) {
                    cVar.b(cVar2.c());
                }
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().b("m_candidate_data", cVar, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
