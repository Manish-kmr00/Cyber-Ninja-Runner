package com.mbridge.msdk.videocommon.setting;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.safedk.android.analytics.brandsafety.l;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardSetting.java */
/* JADX INFO: loaded from: classes13.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Integer> f5980a;
    private Map<String, com.mbridge.msdk.videocommon.entity.c> b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private String j;
    private int i = 0;
    private String k = "";
    private String l = "";

    public String a() {
        return this.j;
    }

    public void b(String str) {
        this.j = str;
    }

    public void c(String str) {
        this.l = str;
    }

    public void d(String str) {
        this.k = str;
    }

    public void e(long j) {
        this.d = j;
    }

    public String f() {
        return this.l;
    }

    public Map<String, com.mbridge.msdk.videocommon.entity.c> g() {
        return this.b;
    }

    public long h() {
        return this.d * 1000;
    }

    public long i() {
        return this.g;
    }

    public String j() {
        return this.k;
    }

    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            Map<String, Integer> map = this.f5980a;
            if (map != null && map.size() > 0) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, Integer> entry : this.f5980a.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue().intValue());
                    }
                    jSONObject.put("caplist", jSONObject2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Map<String, com.mbridge.msdk.videocommon.entity.c> map2 = this.b;
            if (map2 != null && map2.size() > 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, com.mbridge.msdk.videocommon.entity.c> entry2 : this.b.entrySet()) {
                        JSONObject jSONObject3 = new JSONObject();
                        String key = entry2.getKey();
                        com.mbridge.msdk.videocommon.entity.c value = entry2.getValue();
                        if (value != null) {
                            jSONObject3.put("name", value.c());
                            jSONObject3.put("amount", value.a());
                            jSONObject3.put("id", key);
                        }
                        jSONArray.put(jSONObject3);
                    }
                    jSONObject.put("reward", jSONArray);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            jSONObject.put("getpf", this.c);
            jSONObject.put("ruct", this.d);
            jSONObject.put(CampaignEx.JSON_KEY_PLCT, this.e);
            jSONObject.put("dlct", this.f);
            jSONObject.put("vcct", this.g);
            jSONObject.put("current_time", this.h);
            jSONObject.put("vtag", this.k);
            jSONObject.put("isDefault", this.i);
            return jSONObject;
        } catch (Exception e3) {
            e3.printStackTrace();
            return jSONObject;
        }
    }

    public void a(long j) {
        this.h = j;
    }

    public void b(long j) {
        this.f = j;
    }

    public void c(long j) {
        this.c = j;
    }

    public long d() {
        return this.c * 1000;
    }

    public long e() {
        return this.e * 1000;
    }

    public void f(long j) {
        this.g = j;
    }

    public void a(Map<String, Integer> map) {
        this.f5980a = map;
    }

    public long b() {
        return this.h;
    }

    public long c() {
        return this.f;
    }

    public void d(long j) {
        this.e = j;
    }

    public void a(int i) {
        this.i = i;
    }

    public void b(Map<String, com.mbridge.msdk.videocommon.entity.c> map) {
        this.b = map;
    }

    public static a a(String str) {
        a aVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                a aVar2 = new a();
                try {
                    JSONObject jSONObjectJsonObjectInit = MintegralNetworkBridge.jsonObjectInit(str);
                    JSONObject jSONObjectOptJSONObject = jSONObjectJsonObjectInit.optJSONObject("caplist");
                    aVar2.b(jSONObjectJsonObjectInit.optString("ab_id", ""));
                    aVar2.c(jSONObjectJsonObjectInit.optString(l.x, ""));
                    if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                        HashMap map = new HashMap();
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys != null && itKeys.hasNext()) {
                            String next = itKeys.next();
                            int iIntValue = Integer.valueOf(jSONObjectOptJSONObject.optInt(next, 1000)).intValue();
                            if (!TextUtils.isEmpty(next)) {
                                if (!TextUtils.isEmpty(next) && iIntValue == 0) {
                                    map.put(next, 1000);
                                } else {
                                    map.put(next, Integer.valueOf(iIntValue));
                                }
                            }
                        }
                        aVar2.a(map);
                    }
                    aVar2.b(com.mbridge.msdk.videocommon.entity.c.a(jSONObjectJsonObjectInit.optJSONArray("reward")));
                    aVar2.c(jSONObjectJsonObjectInit.optLong("getpf", 43200L));
                    aVar2.e(jSONObjectJsonObjectInit.optLong("ruct", 5400L));
                    aVar2.d(jSONObjectJsonObjectInit.optLong(CampaignEx.JSON_KEY_PLCT, 3600L));
                    aVar2.b(jSONObjectJsonObjectInit.optLong("dlct", 3600L));
                    aVar2.f(jSONObjectJsonObjectInit.optLong("vcct", 5L));
                    aVar2.a(jSONObjectJsonObjectInit.optLong("current_time"));
                    aVar2.d(jSONObjectJsonObjectInit.optString("vtag", ""));
                    return aVar2;
                } catch (Exception e) {
                    e = e;
                    aVar = aVar2;
                    e.printStackTrace();
                    return aVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return aVar;
    }
}
