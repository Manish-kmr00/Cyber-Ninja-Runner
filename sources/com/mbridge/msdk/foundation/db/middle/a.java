package com.mbridge.msdk.foundation.db.middle;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.g;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.w0;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: FrequencyDaoMiddle.java */
/* JADX INFO: loaded from: classes13.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f4923a = "FrequencyDaoMiddle";
    private static a b = null;
    private static String c = "FrequencyDaoMiddle";
    private static JSONArray d = new JSONArray();

    private a() {
        c();
    }

    public static a b() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    private void c() {
        try {
            String str = (String) w0.a(c.m().d(), c, d.toString());
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d = new JSONArray(str);
        } catch (Exception e) {
            o0.b(f4923a, e.getMessage());
        }
    }

    private void d() {
        try {
            if (d != null) {
                w0.b(c.m().d(), c, d.toString());
            }
        } catch (Exception e) {
            o0.b(f4923a, e.getMessage());
        }
    }

    public void a(g gVar) {
        JSONObject jSONObjectA;
        if (gVar == null || (jSONObjectA = a(gVar.a(), gVar.c(), gVar.d(), gVar.f(), gVar.e(), gVar.b())) == null) {
            return;
        }
        if (d == null) {
            d = new JSONArray();
        }
        d.put(jSONObjectA);
        d();
    }

    public void a(String str) {
        if (d != null) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < d.length(); i++) {
                try {
                    JSONObject jSONObject = d.getJSONObject(i);
                    if (jSONObject != null) {
                        if (jSONObject.optString("id", "").equals(str)) {
                            jSONObject.put("impression_count", jSONObject.optInt("impression_count", 0) + 1);
                            jSONArray.put(jSONObject);
                        } else {
                            jSONArray.put(jSONObject);
                        }
                    }
                } catch (JSONException e) {
                    o0.b(f4923a, e.getMessage());
                }
            }
            if (jSONArray.length() > 0) {
                d = jSONArray;
            }
            d();
        }
    }

    public String[] a() {
        ArrayList arrayList = new ArrayList();
        if (d != null) {
            for (int i = 0; i < d.length(); i++) {
                try {
                    JSONObject jSONObject = d.getJSONObject(i);
                    if (jSONObject != null && jSONObject.optInt("fc_a") < jSONObject.optInt("impression_count")) {
                        arrayList.add(jSONObject.optString("id"));
                    }
                } catch (JSONException e) {
                    o0.b(f4923a, e.getMessage());
                }
            }
        }
        String[] strArr = new String[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            strArr[i2] = (String) arrayList.get(i2);
        }
        return strArr;
    }

    public void a(long j) {
        if (d != null) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < d.length(); i++) {
                try {
                    JSONObject jSONObject = d.getJSONObject(i);
                    if (jSONObject != null && jSONObject.optInt("ts") >= j) {
                        jSONArray.put(jSONObject);
                    }
                } catch (JSONException e) {
                    o0.b(f4923a, e.getMessage());
                }
            }
            if (jSONArray.length() > 0) {
                d = jSONArray;
            }
        }
        d();
    }

    private JSONObject a(String str, int i, int i2, long j, int i3, int i4) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("id", str);
                jSONObject.put("fc_a", i);
                jSONObject.put("fc_b", i2);
                jSONObject.put("ts", j);
                jSONObject.put("impression_count", i3);
                jSONObject.put("click_count", i4);
            } catch (Exception e) {
                e = e;
                o0.b(f4923a, e.getMessage());
            }
        } catch (Exception e2) {
            e = e2;
            jSONObject = null;
        }
        return jSONObject;
    }
}
