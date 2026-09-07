package com.bytedance.sdk.openadsdk.ZZv;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.WQf;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class pA implements com.bytedance.sdk.component.JG.pA.ZZv.pA.Og {
    private int BF;
    private int Bzk;
    private String DX;
    private final String JG;
    private boolean KZx;
    private long ML;
    protected final JSONObject Og;
    private int SD;
    private String Sd;
    private String Sn;
    private String TX;
    private String WQf;
    private final AtomicBoolean WV;
    private JSONObject Wx;
    private String XT;
    private long ZZv;
    private String aBv;
    private String oX;
    private int omh;
    public final String pA;
    private com.bytedance.sdk.openadsdk.ZZv.Og.pA vZF;
    private String yFO;
    private static final Set<String> SGo = new HashSet(Arrays.asList("insight_log"));
    private static final Map<String, String> BSW = new HashMap<String, String>() { // from class: com.bytedance.sdk.openadsdk.ZZv.pA.1
        {
            put("id", "extra_id");
            put("source", "extra_source");
            put("url", "extra_url");
            put("toolType", "extra_tool_type");
            put("storeOpenType", "store_open_type");
            put("errorCode", "error_code");
            put("md5", "extra_md5");
            put("areaType", "area_type");
            put("rectInfo", "rect_info");
        }
    };

    public pA(String str, JSONObject jSONObject) {
        this.JG = "adiff";
        this.WV = new AtomicBoolean(false);
        this.Wx = new JSONObject();
        this.pA = str;
        this.Og = jSONObject;
    }

    private void JG() {
        JSONObject jSONObject = this.Wx;
        if (jSONObject == null) {
            if (!pA(this.aBv, this.oX, this.TX)) {
                return;
            }
        } else {
            String strOptString = jSONObject.optString("value");
            String strOptString2 = this.Wx.optString("category");
            String strOptString3 = this.Wx.optString("log_extra");
            if (pA(this.aBv, this.oX, this.TX)) {
                if (!TextUtils.isEmpty(strOptString) && TextUtils.equals(strOptString, "0")) {
                    return;
                }
                if (!TextUtils.isEmpty(strOptString2) && !Og(strOptString2)) {
                    return;
                }
            } else {
                if ((TextUtils.isEmpty(strOptString) || TextUtils.equals(strOptString, "0")) && (TextUtils.isEmpty(this.aBv) || TextUtils.equals(this.aBv, "0"))) {
                    return;
                }
                if ((TextUtils.isEmpty(this.oX) || !Og(this.oX)) && (TextUtils.isEmpty(strOptString2) || !Og(strOptString2))) {
                    return;
                }
                if (TextUtils.isEmpty(this.TX) && TextUtils.isEmpty(strOptString3)) {
                    return;
                }
            }
        }
        this.ZZv = com.bytedance.sdk.openadsdk.ZZv.pA.ZZv.pA.incrementAndGet();
    }

    private boolean Og(String str) {
        str.hashCode();
        switch (str) {
            case "umeng":
            case "event_v1":
            case "event_v3":
            case "app_union":
                return true;
            default:
                return false;
        }
    }

    private boolean pA(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "0") || TextUtils.isEmpty(str3)) {
            return false;
        }
        str2.hashCode();
        switch (str2) {
            case "umeng":
            case "event_v1":
            case "event_v3":
            case "app_union":
                return true;
            default:
                return false;
        }
    }

    private JSONObject pA(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("adiff")) {
                jSONObject.put("adiff", this.pA);
            }
            if (this.KZx) {
                if (!jSONObject.has("interaction_method")) {
                    jSONObject.put("interaction_method", this.SD);
                }
                if (!jSONObject.has("real_interaction_method")) {
                    jSONObject.put("real_interaction_method", this.omh);
                }
                if (!jSONObject.has("image_mode")) {
                    jSONObject.put("image_mode", this.Bzk);
                }
            }
            if (com.bytedance.sdk.openadsdk.vZF.pA.pA("replace_log_extra_key", false)) {
                Og(jSONObject);
            }
            jSONObject.put("pangle_client_unique_id", "pangle-" + this.pA + "-" + System.currentTimeMillis());
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("AdEvent", th.getMessage() == null ? "error " : th.getMessage());
            return jSONObject;
        }
    }

    private void Og(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : BSW.keySet()) {
            try {
                if (jSONObject.has(str)) {
                    Object objOpt = jSONObject.opt(str);
                    jSONObject.remove(str);
                    jSONObject.put(BSW.get(str), objOpt);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public JSONObject KZx() {
        if (this.WV.get()) {
            return this.Og;
        }
        try {
            SD();
            if (this.Og.has("ad_extra_data")) {
                Object objOpt = this.Og.opt("ad_extra_data");
                if (objOpt != null) {
                    try {
                        if (objOpt instanceof JSONObject) {
                            com.bytedance.sdk.component.utils.WV.pA("AdEvent", "ad_extra_data is JSONObject");
                            this.Og.put("ad_extra_data", pA((JSONObject) objOpt).toString());
                        } else if (objOpt instanceof String) {
                            this.Og.put("ad_extra_data", pA(PangleNetworkBridge.jsonObjectInit((String) objOpt)).toString());
                        }
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.WV.pA("AdEvent", "json error", e.getMessage());
                    }
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("adiff", this.pA);
                    if (this.KZx) {
                        jSONObject.put("interaction_method", this.SD);
                        jSONObject.put("real_interaction_method", this.omh);
                        jSONObject.put("image_mode", this.Bzk);
                    }
                    this.Og.put("ad_extra_data", jSONObject.toString());
                } catch (JSONException e2) {
                    com.bytedance.sdk.component.utils.WV.pA("AdEvent", "json error", e2.getMessage());
                }
            }
            this.WV.set(true);
        } catch (Throwable th) {
            new Object[]{th};
        }
        return this.Og;
    }

    public JSONObject pA(boolean z) {
        JSONObject jSONObjectKZx = KZx();
        try {
            if (z) {
                JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(jSONObjectKZx.toString());
                JSONObject jSONObjectOptJSONObject = jSONObjectJsonObjectInit.optJSONObject("params");
                if (jSONObjectOptJSONObject != null) {
                    jSONObjectOptJSONObject.remove("app_log_url");
                }
                return jSONObjectJsonObjectInit;
            }
            JSONObject jSONObjectJsonObjectInit2 = PangleNetworkBridge.jsonObjectInit(jSONObjectKZx.toString());
            jSONObjectJsonObjectInit2.remove("app_log_url");
            return jSONObjectJsonObjectInit2;
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.WV.pA("AdEvent", e.getMessage());
            return jSONObjectKZx;
        }
    }

    private void SD() throws JSONException {
        this.Og.putOpt("app_log_url", this.WQf);
        this.Og.putOpt("tag", this.Sn);
        this.Og.putOpt("label", this.DX);
        this.Og.putOpt("category", this.oX);
        if (!TextUtils.isEmpty(this.aBv)) {
            try {
                this.Og.putOpt("value", Long.valueOf(Long.parseLong(this.aBv)));
            } catch (NumberFormatException unused) {
                this.Og.putOpt("value", 0L);
            }
        }
        if (!TextUtils.isEmpty(this.yFO)) {
            try {
                this.Og.putOpt("ext_value", Long.valueOf(Long.parseLong(this.yFO)));
            } catch (Exception unused2) {
            }
        }
        if (!TextUtils.isEmpty(this.TX)) {
            this.Og.putOpt("log_extra", this.TX);
        }
        if (!TextUtils.isEmpty(this.Sd)) {
            try {
                this.Og.putOpt("ua_policy", Integer.valueOf(Integer.parseInt(this.Sd)));
            } catch (NumberFormatException unused3) {
            }
        }
        pA(this.Og, this.DX);
        try {
            this.Og.putOpt("nt", Integer.valueOf(this.BF));
        } catch (Exception unused4) {
        }
        Iterator<String> itKeys = this.Wx.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.Og.putOpt(next, this.Wx.opt(next));
        }
    }

    public String ZZv() {
        return this.pA;
    }

    pA(C0217pA c0217pA) {
        this.JG = "adiff";
        this.WV = new AtomicBoolean(false);
        this.Wx = new JSONObject();
        if (TextUtils.isEmpty(c0217pA.Og)) {
            this.pA = WQf.pA();
        } else {
            this.pA = c0217pA.Og;
        }
        this.vZF = c0217pA.DX;
        this.TX = c0217pA.JG;
        this.Sn = c0217pA.KZx;
        this.DX = c0217pA.ZZv;
        if (TextUtils.isEmpty(c0217pA.ML)) {
            this.oX = "app_union";
        } else {
            this.oX = c0217pA.ML;
        }
        this.Sd = c0217pA.BSW;
        this.aBv = c0217pA.omh;
        this.yFO = c0217pA.Bzk;
        this.XT = c0217pA.SD;
        this.BF = c0217pA.WV;
        this.WQf = c0217pA.Wx;
        this.Wx = c0217pA.SGo = c0217pA.SGo != null ? c0217pA.SGo : new JSONObject();
        JSONObject jSONObject = new JSONObject();
        this.Og = jSONObject;
        if (!TextUtils.isEmpty(c0217pA.Wx)) {
            try {
                jSONObject.put("app_log_url", c0217pA.Wx);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.WV.pA("AdEvent", e.getMessage());
            }
        }
        this.SD = c0217pA.aBv;
        this.omh = c0217pA.XT;
        this.Bzk = c0217pA.pA;
        this.KZx = c0217pA.yFO;
        this.ML = System.currentTimeMillis();
        JG();
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA.Og
    public JSONObject pA(String str) {
        return KZx();
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA.Og
    public long pA() {
        return this.ML;
    }

    @Override // com.bytedance.sdk.component.JG.pA.ZZv.pA.Og
    public long Og() {
        return this.ZZv;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.ZZv.pA$pA, reason: collision with other inner class name */
    public static final class C0217pA {
        private String BSW;
        private String Bzk;
        private com.bytedance.sdk.openadsdk.ZZv.Og.pA DX;
        private String JG;
        private String KZx;
        private String ML;
        private String Og;
        private String SD;
        private JSONObject SGo;
        private com.bytedance.sdk.openadsdk.ZZv.Og.Og Sn;
        private final int WV;
        private String Wx;
        private int XT;
        private String ZZv;
        private int aBv;
        private final long oX;
        private String omh;
        public int pA;
        private String vZF;
        private boolean yFO;

        public C0217pA(long j, yFO yfo) {
            this.aBv = -1;
            this.XT = -1;
            this.pA = -1;
            if (yfo != null) {
                this.yFO = com.bytedance.sdk.openadsdk.core.model.WQf.Og(yfo);
                this.aBv = yfo.XT();
                this.XT = yfo.aBv();
                this.pA = yfo.RS();
            }
            this.oX = j;
            this.WV = com.bytedance.sdk.component.utils.DX.KZx(com.bytedance.sdk.openadsdk.core.aBv.pA());
        }

        public C0217pA pA(String str) {
            this.Wx = str;
            return this;
        }

        public C0217pA Og(String str) {
            this.KZx = str;
            return this;
        }

        public C0217pA KZx(String str) {
            this.ZZv = str;
            return this;
        }

        public C0217pA ZZv(String str) {
            this.ML = str;
            return this;
        }

        public C0217pA ML(String str) {
            this.omh = str;
            return this;
        }

        public C0217pA JG(String str) {
            this.Bzk = str;
            return this;
        }

        public C0217pA pA(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            this.SGo = jSONObject;
            return this;
        }

        public C0217pA SD(String str) {
            this.SD = str;
            return this;
        }

        public void pA(com.bytedance.sdk.openadsdk.ZZv.Og.pA pAVar) {
            com.bytedance.sdk.openadsdk.JG.Og.pA().pA(this.ZZv, this.vZF, this.SD, this.KZx);
            this.DX = pAVar;
            final pA pAVar2 = new pA(this);
            try {
                com.bytedance.sdk.openadsdk.ZZv.Og.Og og = this.Sn;
                if (og != null) {
                    og.pA(pAVar2.Og, this.oX);
                } else {
                    new com.bytedance.sdk.openadsdk.ZZv.Og.KZx().pA(pAVar2.Og, this.oX);
                }
            } catch (Throwable th) {
                new Object[]{th};
            }
            if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                xy.KZx(new com.bytedance.sdk.component.omh.omh("dispatchEvent") { // from class: com.bytedance.sdk.openadsdk.ZZv.pA.pA.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.openadsdk.ZZv.pA.ZZv.pA(pAVar2);
                    }
                });
            } else {
                com.bytedance.sdk.openadsdk.ZZv.pA.ZZv.pA(pAVar2);
            }
        }

        public C0217pA omh(String str) {
            this.vZF = str;
            return this;
        }
    }

    public boolean ML() {
        Set<String> setWx;
        if (this.Og == null || (setWx = com.bytedance.sdk.openadsdk.core.aBv.ZZv().Wx()) == null) {
            return false;
        }
        String strOptString = this.Og.optString("label");
        if (TextUtils.isEmpty(strOptString)) {
            if (TextUtils.isEmpty(this.DX)) {
                return false;
            }
            return setWx.contains(this.DX);
        }
        return setWx.contains(strOptString);
    }

    private static void pA(JSONObject jSONObject, String str) {
        try {
            Set<String> set = SGo;
            if (!set.contains(str) && !set.contains(jSONObject.get("label"))) {
                jSONObject.putOpt("is_ad_event", "1");
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("AdEvent", th);
        }
    }
}
