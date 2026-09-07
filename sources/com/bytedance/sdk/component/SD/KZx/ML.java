package com.bytedance.sdk.component.SD.KZx;

import android.content.Context;
import android.text.TextUtils;
import com.playon.bridge.Ad;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class ML {
    private static final Object ZZv = new Object();
    private boolean KZx;
    private int ML;
    private ZZv Og = new ZZv();
    private Context pA;

    public ML(Context context, boolean z, int i) {
        this.pA = context;
        this.KZx = z;
        this.ML = i;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:84:0x016e A[EXC_TOP_SPLITTER, FINALLY_INSNS, SYNTHETIC] */
    public void pA(JSONObject jSONObject) {
        Object obj;
        JSONObject jSONObject2;
        if (this.KZx) {
            omh.pA().pA(this.ML).ML();
            try {
                try {
                    boolean z = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
                    if (omh.pA().pA(this.ML).KZx() && z && jSONArrayOptJSONArray != null) {
                        ArrayList<JSONObject> arrayList = new ArrayList();
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            JSONObject jSONObject3 = ((JSONObject) jSONArrayOptJSONArray.get(i)).getJSONObject(Ad.VERIFICATIONPARAM);
                            if (jSONObject3.optString("service_name", "").equals("idc_selection")) {
                                arrayList.add(jSONObject3.getJSONObject("strategy_info"));
                            }
                        }
                        if (arrayList.isEmpty()) {
                            jSONObject2 = null;
                        } else {
                            jSONObject2 = new JSONObject();
                            for (JSONObject jSONObject4 : arrayList) {
                                Iterator<String> itKeys = jSONObject4.keys();
                                while (itKeys.hasNext()) {
                                    String next = itKeys.next();
                                    jSONObject2.put(next, jSONObject4.getString(next));
                                }
                            }
                        }
                    } else {
                        jSONObject2 = null;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("tnc_config");
                    if (jSONObjectOptJSONObject != null || jSONObject2 != null) {
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectOptJSONObject = new JSONObject();
                            jSONObjectOptJSONObject.put("host_replace_map", jSONObject2);
                        } else if (jSONObject2 != null) {
                            jSONObjectOptJSONObject.put("host_replace_map", jSONObject2);
                        }
                    }
                    ZZv zZvOg = Og(jSONObjectOptJSONObject);
                    if (zZvOg != null) {
                        zZvOg.toString();
                    }
                    if (zZvOg == null) {
                        synchronized (ZZv) {
                            this.pA.getSharedPreferences(omh.pA().pA(this.ML).pA(), 0).edit().putString("tnc_config_str", "").apply();
                            com.bytedance.sdk.component.SD.ZZv.ZZv.pA(this.pA, 1, "", this.ML);
                        }
                        return;
                    } else {
                        this.Og = zZvOg;
                        String string = jSONObjectOptJSONObject.toString();
                        synchronized (ZZv) {
                            this.pA.getSharedPreferences(omh.pA().pA(this.ML).pA(), 0).edit().putString("tnc_config_str", string).apply();
                            com.bytedance.sdk.component.SD.ZZv.ZZv.pA(this.pA, 1, string, this.ML);
                        }
                        return;
                    }
                } finally {
                    synchronized (ZZv) {
                        this.pA.getSharedPreferences(omh.pA().pA(this.ML).pA(), 0).edit().putString("tnc_config_str", "").apply();
                        com.bytedance.sdk.component.SD.ZZv.ZZv.pA(this.pA, 1, "", this.ML);
                    }
                }
            } catch (Throwable unused) {
                this.Og = new ZZv();
                synchronized (obj) {
                    return;
                }
            }
            synchronized (ZZv) {
                this.pA.getSharedPreferences(omh.pA().pA(this.ML).pA(), 0).edit().putString("tnc_config_str", "").apply();
                com.bytedance.sdk.component.SD.ZZv.ZZv.pA(this.pA, 1, "", this.ML);
            }
        }
    }

    public void pA() {
        if (this.KZx) {
            String string = this.pA.getSharedPreferences(omh.pA().pA(this.ML).pA(), 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                ZZv zZvOg = Og(PangleNetworkBridge.jsonObjectInit(string));
                if (zZvOg != null) {
                    this.Og = zZvOg;
                }
                if (zZvOg == null) {
                    return;
                }
                zZvOg.toString();
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    public void Og() {
        try {
            String strPA = com.bytedance.sdk.component.SD.ZZv.ZZv.pA(this.pA, 1, this.ML);
            if (TextUtils.isEmpty(strPA)) {
                return;
            }
            ZZv zZvOg = Og(PangleNetworkBridge.jsonObjectInit(strPA));
            if (zZvOg != null) {
                zZvOg.toString();
            }
            if (zZvOg != null) {
                this.Og = zZvOg;
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public ZZv KZx() {
        return this.Og;
    }

    private ZZv Og(JSONObject jSONObject) {
        try {
            ZZv zZv = new ZZv();
            if (jSONObject.has("local_enable")) {
                zZv.pA = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                zZv.Og = jSONObject.getInt("probe_enable") != 0;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap map = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            map.put(string, 0);
                        }
                    }
                }
                zZv.KZx = map;
            } else {
                zZv.KZx = null;
            }
            if (jSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                HashMap map2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                            map2.put(next, string2);
                        }
                    }
                }
                zZv.ZZv = map2;
            } else {
                zZv.ZZv = null;
            }
            zZv.ML = jSONObject.optInt("req_to_cnt", zZv.ML);
            zZv.JG = jSONObject.optInt("req_to_api_cnt", zZv.JG);
            zZv.SD = jSONObject.optInt("req_to_ip_cnt", zZv.SD);
            zZv.omh = jSONObject.optInt("req_err_cnt", zZv.omh);
            zZv.Bzk = jSONObject.optInt("req_err_api_cnt", zZv.Bzk);
            zZv.SGo = jSONObject.optInt("req_err_ip_cnt", zZv.SGo);
            zZv.BSW = jSONObject.optInt("update_interval", zZv.BSW);
            zZv.WV = jSONObject.optInt("update_random_range", zZv.WV);
            zZv.Wx = jSONObject.optString("http_code_black", zZv.Wx);
            return zZv;
        } catch (Throwable unused) {
            return null;
        }
    }
}
