package com.mbridge.msdk.foundation.cache;

import android.text.TextUtils;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.facebook.appevents.UserDataStore;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.j;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.i0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.z0;
import com.safedk.android.analytics.brandsafety.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseCandidateCache.java */
/* JADX INFO: loaded from: classes11.dex */
public class a {
    private static String e = "BaseCandidateCache";
    public static int f = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.mbridge.msdk.foundation.db.c f4887a;
    private JSONArray b;
    private JSONObject c;
    private String d;

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.cache.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseCandidateCache.java */
    class C0428a implements Comparator<b> {
        C0428a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return Double.compare(bVar.b, bVar2.b);
        }
    }

    /* JADX INFO: compiled from: BaseCandidateCache.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.foundation.cache.b f4889a;
        private double b;

        public b(double d, com.mbridge.msdk.foundation.cache.b bVar) {
            this.b = d;
            this.f4889a = bVar;
        }

        public com.mbridge.msdk.foundation.cache.b a() {
            return this.f4889a;
        }
    }

    public void a(int i) {
        com.mbridge.msdk.foundation.db.c cVar = this.f4887a;
        if (cVar != null) {
            cVar.a(this.d, i);
            a(f, 1, null, true, "", "", i, this.d);
        }
    }

    public double b(String str) {
        c cVarA = a(str);
        if (cVarA != null && cVarA.g() != c.k && cVarA.g() != c.i) {
            try {
                String[] strArrSplit = i0.a(str.split("_")[3]).split("\\|");
                if (strArrSplit.length > 0) {
                    return Double.parseDouble(strArrSplit[0]);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return -1.0d;
    }

    public JSONObject c(String str) {
        JSONArray jSONArray = this.b;
        if (jSONArray == null) {
            return null;
        }
        if (jSONArray.length() <= 1) {
            return this.b.optJSONObject(0);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < this.b.length(); i++) {
            try {
                JSONObject jSONObjectOptJSONObject = this.b.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && str.equals(jSONObjectOptJSONObject.getString("g"))) {
                    this.c = jSONObjectOptJSONObject;
                    return jSONObjectOptJSONObject;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public String d(String str) {
        c cVarA = a(str);
        if (cVarA != null && cVarA.g() != c.k && cVarA.g() != c.i) {
            String[] strArrSplit = i0.a(str.split("_")[3]).split("\\|");
            if (strArrSplit.length > 1) {
                return strArrSplit[1];
            }
        }
        return "";
    }

    public void e(String str) {
        this.d = str;
    }

    public c a(String str) {
        c cVar = new c();
        if (!TextUtils.isEmpty(str) && str.split("_").length > 3 && !TextUtils.isEmpty(str.split("_")[3])) {
            JSONArray jSONArray = this.b;
            if (jSONArray != null && jSONArray.length() != 0) {
                String strA = i0.a(str.split("_")[3]);
                if (TextUtils.isEmpty(strA)) {
                    cVar.d("bid token exception:decode error");
                    cVar.a(c.i);
                    return cVar;
                }
                String[] strArrSplit = strA.split("\\|");
                if (strArrSplit.length == 0) {
                    cVar.d("bid token can not get bid price");
                    cVar.a(c.i);
                    return cVar;
                }
                if (strArrSplit.length > 0) {
                    try {
                        Double.parseDouble(strArrSplit[0]);
                    } catch (Exception unused) {
                        cVar.d("bid token can not cast bid price");
                        cVar.a(c.i);
                        return cVar;
                    }
                }
                if (TextUtils.isEmpty(this.d)) {
                    cVar.d("unitId is empty");
                    cVar.a(c.k);
                }
                return cVar;
            }
            cVar.d("config is empty");
            cVar.a(c.i);
            return cVar;
        }
        cVar.d("bid token exception");
        cVar.a(c.i);
        return cVar;
    }

    private List<Map<Integer, String>> b(List<Map<Integer, String>> list, int i, String str, String str2) {
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Map<Integer, String> map = list.get(i2);
            if (map != null && map.size() > 0) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    map.put(entry.getKey(), a(entry.getValue(), i, str, str2));
                }
                arrayList.add(map);
            }
        }
        return arrayList;
    }

    public void a(JSONArray jSONArray) {
        this.b = jSONArray;
    }

    public void a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str, int i, String str2, int i2, double d) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        CampaignEx campaignEx = list.get(i3);
                        campaignEx.setReadyState(0);
                        if (cVar != null) {
                            campaignEx.setNLRid(cVar.o());
                        }
                        campaignEx.setNRid(str);
                        campaignEx.setReasond(str2);
                        campaignEx.setTyped(i);
                        String strB = i0.b(d + "");
                        campaignEx.setNoticeUrl(a(campaignEx.getNoticeUrl(), i2, str, strB));
                        campaignEx.setClickURL(a(campaignEx.getClickURL(), i2, str, strB));
                        campaignEx.setImpressionURL(a(campaignEx.getImpressionURL(), i2, str, strB));
                        campaignEx.setOnlyImpressionURL(a(campaignEx.getOnlyImpressionURL(), i2, str, strB));
                        campaignEx.setAdvImp(a(campaignEx.getAdvImpList(), i2, str, strB));
                        j nativeVideoTracking = campaignEx.getNativeVideoTracking();
                        if (nativeVideoTracking != null) {
                            nativeVideoTracking.d(a(nativeVideoTracking.d(), i2, str, strB));
                            nativeVideoTracking.c(a(nativeVideoTracking.c(), i2, str, strB));
                            nativeVideoTracking.k(a(nativeVideoTracking.k(), i2, str, strB));
                            nativeVideoTracking.s(a(nativeVideoTracking.t(), i2, str, strB));
                            nativeVideoTracking.a(a(nativeVideoTracking.a(), i2, str, strB));
                            nativeVideoTracking.b(a(nativeVideoTracking.b(), i2, str, strB));
                            nativeVideoTracking.e(a(nativeVideoTracking.e(), i2, str, strB));
                            nativeVideoTracking.t(a(nativeVideoTracking.u(), i2, str, strB));
                            nativeVideoTracking.u(a(nativeVideoTracking.u(), i2, str, strB));
                            nativeVideoTracking.v(a(nativeVideoTracking.w(), i2, str, strB));
                            nativeVideoTracking.f(a(nativeVideoTracking.f(), i2, str, strB));
                            nativeVideoTracking.g(a(nativeVideoTracking.g(), i2, str, strB));
                            nativeVideoTracking.h(a(nativeVideoTracking.h(), i2, str, strB));
                            nativeVideoTracking.i(a(nativeVideoTracking.i(), i2, str, strB));
                            nativeVideoTracking.j(a(nativeVideoTracking.j(), i2, str, strB));
                            nativeVideoTracking.l(a(nativeVideoTracking.l(), i2, str, strB));
                            nativeVideoTracking.q(a(nativeVideoTracking.r(), i2, str, strB));
                            nativeVideoTracking.m(a(nativeVideoTracking.m(), i2, str, strB));
                            nativeVideoTracking.r(a(nativeVideoTracking.s(), i2, str, strB));
                            nativeVideoTracking.n(a(nativeVideoTracking.n(), i2, str, strB));
                            nativeVideoTracking.a(b(nativeVideoTracking.o(), i2, str, strB));
                            nativeVideoTracking.p(a(nativeVideoTracking.q(), i2, str, strB));
                            nativeVideoTracking.o(a(nativeVideoTracking.p(), i2, str, strB));
                            campaignEx.setNativeVideoTracking(nativeVideoTracking);
                            campaignEx.setNativeVideoTrackingString(CampaignEx.object2TrackingStr(nativeVideoTracking));
                        }
                        campaignEx.setPv_urls(a(campaignEx.getPv_urls(), i2, str, strB));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public c a() {
        c cVar = new c();
        try {
            JSONArray jSONArray = this.b;
            if (jSONArray != null && jSONArray.length() != 0) {
                if (this.f4887a == null) {
                    cVar.d("db error");
                    cVar.a(c.k);
                    return cVar;
                }
                return cVar;
            }
            cVar.d("setting config is null");
            cVar.a(c.i);
            return cVar;
        } catch (Exception unused) {
            cVar.d("checkConfigAndDB exception");
            cVar.a(c.k);
        }
    }

    public List<com.mbridge.msdk.foundation.cache.b> a(int i, long j) {
        if (i >= 0) {
            a(i);
        }
        com.mbridge.msdk.foundation.db.c cVar = this.f4887a;
        if (cVar != null) {
            return cVar.a(this.d, j);
        }
        return null;
    }

    public void a(List<b> list, int i) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Collections.sort(list, new C0428a());
                    int size = list.size() - i;
                    if (size > 0) {
                        List<b> listSubList = list.subList(0, size);
                        if (this.f4887a == null || listSubList.size() <= 0) {
                            return;
                        }
                        for (int i2 = 0; i2 < listSubList.size(); i2++) {
                            com.mbridge.msdk.foundation.cache.b bVar = listSubList.get(i2).f4889a;
                            this.f4887a.a(this.d, bVar.e(), bVar.d());
                            a(f, 1, null, true, bVar.e(), bVar.d(), -1, this.d);
                        }
                    }
                }
            } catch (Exception e2) {
                o0.a(e, e2);
            }
        }
    }

    private String a(String str, int i, String str2, String str3) {
        if (TextUtils.isEmpty(str) || str.contains("ca_sce") || str.contains("real_rid") || str.contains("real_bp")) {
            return str;
        }
        if (z0.c(str) > 0) {
            return str + "&ca_sce=" + i + "&real_rid=" + str2 + "&real_bp=" + str3;
        }
        return str + "?ca_sce=" + i + "&real_rid=" + str2 + "&real_bp=" + str3;
    }

    private String a(Map<Integer, String> map, int i, String str, String str2) {
        if (map == null || map.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                String value = entry.getValue();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_AD_IMP_KEY, entry.getKey());
                jSONObject.put("url", a(value, i, str, str2));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray.toString();
    }

    private String[] a(String[] strArr, int i, String str, String str2) {
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr2[i2] = a(strArr[i2], i, str, str2);
        }
        return strArr2;
    }

    private List<String> a(List<String> list, int i, String str, String str2) {
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(a(list.get(i2), i, str, str2));
        }
        return arrayList;
    }

    public long a(List<CampaignEx> list, String str) {
        if (list == null || list.size() == 0) {
            return 0L;
        }
        String ecppv = list.get(0).getEcppv();
        if (TextUtils.isEmpty(ecppv)) {
            return 0L;
        }
        String strA = i0.a(ecppv);
        if (TextUtils.isEmpty(strA)) {
            return 0L;
        }
        try {
            if (Double.parseDouble(strA) <= 0.0d) {
                return 0L;
            }
            JSONObject jSONObjectC = c(d(str));
            int iOptInt = jSONObjectC != null ? jSONObjectC.optInt("max_cache_num", 20) : 20;
            com.mbridge.msdk.foundation.db.c cVar = this.f4887a;
            if (cVar == null || iOptInt <= 0) {
                return -1L;
            }
            return cVar.a(list, this.d);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    public void a(String str, String str2, int i, String str3) {
        try {
            if (this.f4887a == null || TextUtils.isEmpty(str3)) {
                return;
            }
            if (i == 1) {
                this.f4887a.a(str2, str, this.d, i);
                a(f, 3, null, true, str2, str, -1, this.d);
            } else if (i == 2) {
                this.f4887a.a(this.d, str2, str);
                a(f, 1, null, true, str2, str, -1, this.d);
            } else if (i == 3) {
                this.f4887a.b(str2, str, this.d);
                a(f, 4, null, true, str2, str, -1, this.d);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:67:0x0195  */
    /* JADX WARN: Code duplicated, block: B:70:0x01a3 A[Catch: Exception -> 0x01b6, TryCatch #5 {Exception -> 0x01b6, blocks: (B:3:0x0011, B:7:0x0030, B:9:0x006c, B:12:0x007c, B:14:0x0082, B:17:0x0089, B:19:0x0094, B:22:0x009b, B:24:0x00a1, B:26:0x00a9, B:28:0x00b9, B:30:0x0106, B:37:0x011c, B:41:0x0125, B:43:0x012b, B:45:0x0139, B:46:0x013d, B:48:0x0148, B:50:0x014e, B:52:0x0156, B:54:0x0161, B:56:0x0173, B:65:0x018f, B:68:0x019b, B:70:0x01a3, B:71:0x01a8, B:57:0x0178, B:31:0x010b), top: B:86:0x0011 }] */
    public void a(int i, int i2, List<CampaignEx> list, boolean z, String str, String str2, int i3, String str3) {
        String str4;
        com.mbridge.msdk.foundation.same.report.metrics.c cVar;
        String str5;
        String currentLocalRid;
        com.mbridge.msdk.foundation.db.c cVar2;
        e eVar = new e();
        try {
            eVar.a("type", i2 + "");
            eVar.a("result", z ? "1" : "2");
            eVar.a("max_usage_limit", i3 + "");
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str3 + "");
            eVar.a("scene", UserDataStore.DATE_OF_BIRTH);
            JSONObject jSONObject = this.c;
            if (jSONObject != null) {
                eVar.a(DTBMetricsConfiguration.CONFIG_DIR, jSONObject.toString());
            }
            String str6 = l.x;
            if (i2 == 1 && TextUtils.isEmpty(str2) && (cVar2 = this.f4887a) != null) {
                try {
                    List<com.mbridge.msdk.foundation.cache.b> listA = cVar2.a(str3, -1, -1L);
                    JSONArray jSONArray = new JSONArray();
                    if (listA != null && listA.size() > 0) {
                        int i4 = 0;
                        while (i4 < listA.size()) {
                            com.mbridge.msdk.foundation.cache.b bVar = listA.get(i4);
                            if (bVar != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(str6, bVar.e());
                                str4 = str6;
                                try {
                                    jSONObject2.put("ts", bVar.h());
                                    jSONObject2.put("lrid", bVar.d());
                                    jSONObject2.put("ecppv", i0.b(bVar.b() + ""));
                                    jSONObject2.put("state", bVar.g());
                                    jSONObject2.put("showCount", bVar.f());
                                    jSONObject2.put("interval_ts", bVar.c());
                                    jSONArray.put(jSONObject2);
                                } catch (JSONException e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    cVar = null;
                                    if (list != null) {
                                        str5 = str4;
                                        currentLocalRid = str2;
                                    } else {
                                        str5 = str4;
                                        currentLocalRid = str2;
                                    }
                                    eVar.a(str5, str);
                                    eVar.a("lrid", currentLocalRid);
                                    if (cVar == null) {
                                        cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                                    }
                                    cVar.m(str3);
                                    cVar.a("m_candidate_db", eVar);
                                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_candidate_db", cVar);
                                }
                            } else {
                                str4 = str6;
                            }
                            i4++;
                            str6 = str4;
                        }
                    }
                    str4 = str6;
                    eVar.a(Reporting.EventType.CACHE, jSONArray.toString());
                } catch (JSONException e3) {
                    e = e3;
                    str4 = str6;
                }
            } else {
                str4 = l.x;
            }
            cVar = null;
            if (list != null || list.size() <= 0) {
                str5 = str4;
                currentLocalRid = str2;
            } else {
                try {
                    JSONArray jSONArray2 = new JSONArray();
                    int i5 = 0;
                    CampaignEx campaignEx = list.get(0);
                    if (campaignEx != null) {
                        currentLocalRid = campaignEx.getCurrentLocalRid();
                        try {
                            cVar = com.mbridge.msdk.foundation.same.report.metrics.d.b().a(currentLocalRid);
                        } catch (JSONException e4) {
                            e = e4;
                            str5 = str4;
                            e.printStackTrace();
                            eVar.a(str5, str);
                            eVar.a("lrid", currentLocalRid);
                            if (cVar == null) {
                                cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                            }
                            cVar.m(str3);
                            cVar.a("m_candidate_db", eVar);
                            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_candidate_db", cVar);
                        }
                    } else {
                        currentLocalRid = str2;
                    }
                    while (i5 < list.size()) {
                        CampaignEx campaignEx2 = list.get(i5);
                        if (campaignEx2 != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            str5 = str4;
                            try {
                                jSONObject3.put(str5, campaignEx2.getRequestId());
                                jSONObject3.put("rid_n", campaignEx2.getRequestIdNotice());
                                jSONArray2.put(jSONObject3);
                            } catch (JSONException e5) {
                                e = e5;
                                e.printStackTrace();
                                eVar.a(str5, str);
                                eVar.a("lrid", currentLocalRid);
                                if (cVar == null) {
                                    cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                                }
                                cVar.m(str3);
                                cVar.a("m_candidate_db", eVar);
                                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_candidate_db", cVar);
                            }
                        } else {
                            str5 = str4;
                        }
                        i5++;
                        str4 = str5;
                    }
                    str5 = str4;
                    eVar.a("c_info", jSONArray2.toString());
                } catch (JSONException e6) {
                    e = e6;
                    str5 = str4;
                    currentLocalRid = str2;
                }
            }
            eVar.a(str5, str);
            eVar.a("lrid", currentLocalRid);
            if (cVar == null) {
                cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
            }
            cVar.m(str3);
            cVar.a("m_candidate_db", eVar);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_candidate_db", cVar);
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }
}
