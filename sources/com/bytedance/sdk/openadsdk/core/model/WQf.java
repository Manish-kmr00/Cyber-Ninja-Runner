package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class WQf {
    private int Bzk;
    private String JG;
    private boolean KZx;
    private String ML;
    private int Og;
    private int SD;
    private boolean SGo;
    private int ZZv;
    private int omh;
    private int pA;

    private static int Og(int i) {
        return i == 1 ? 10 : 5;
    }

    public static boolean Sn(yFO yfo) {
        return true;
    }

    public static int pA(int i) {
        return i + 10;
    }

    public WQf(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.KZx = jSONObject.optBoolean("is_playable");
        this.ZZv = jSONObject.optInt("playable_type", 0);
        this.ML = jSONObject.optString("playable_style");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("playable");
        if (jSONObjectOptJSONObject != null) {
            this.JG = jSONObjectOptJSONObject.optString("playable_url", "");
            this.SD = jSONObjectOptJSONObject.optInt("playable_orientation", 0);
            this.Og = jSONObjectOptJSONObject.optInt("new_style", 0);
            this.pA = jSONObjectOptJSONObject.optInt("close_2_app", 0);
            int iOg = Og(this.ZZv);
            this.omh = jSONObjectOptJSONObject.optInt("playable_webview_timeout", iOg);
            this.Bzk = jSONObjectOptJSONObject.optInt("playable_js_timeout", iOg);
            this.SGo = jSONObjectOptJSONObject.optInt("playable_backup_enable", 0) == 1;
        }
    }

    public static int pA(yFO yfo) {
        int i;
        WQf wQfOX = yfo.oX();
        if (wQfOX != null && (i = wQfOX.pA) >= 0 && i <= 100) {
            return i;
        }
        return 0;
    }

    public void pA(JSONObject jSONObject) {
        try {
            jSONObject.put("is_playable", this.KZx);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.WV.pA("PlayableModel", e.getMessage());
        }
        if (!TextUtils.isEmpty(this.JG)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("playable_url", this.JG);
                jSONObject2.put("playable_orientation", this.SD);
                jSONObject2.put("new_style", this.Og);
                jSONObject2.put("close_2_app", this.pA);
                jSONObject2.put("playable_webview_timeout", this.omh);
                jSONObject2.put("playable_js_timeout", this.Bzk);
                jSONObject2.put("playable_backup_enable", this.SGo ? 1 : 0);
                jSONObject.put("playable", jSONObject2);
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.WV.pA("PlayableModel", e2.getMessage());
            }
        }
        try {
            jSONObject.put("playable_type", this.ZZv);
        } catch (JSONException e3) {
            com.bytedance.sdk.component.utils.WV.pA("PlayableModel", e3.getMessage());
        }
        try {
            jSONObject.put("playable_style", this.ML);
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.WV.pA("PlayableModel", e4.getMessage());
        }
    }

    private static WQf WQf(yFO yfo) {
        if (yfo == null) {
            return null;
        }
        return yfo.oX();
    }

    public static boolean Og(yFO yfo) {
        WQf WQf = WQf(yfo);
        return (WQf == null || !WQf.KZx || TextUtils.isEmpty(Wx(yfo))) ? false : true;
    }

    public static boolean KZx(yFO yfo) {
        return Og(yfo) && TV(yfo) == 1;
    }

    public static boolean ZZv(yFO yfo) {
        return KZx(yfo) && !Bzk(yfo);
    }

    public static boolean ML(yFO yfo) {
        WQf WQf = WQf(yfo);
        return WQf != null && yfo.SRe() && WQf.KZx && !TextUtils.isEmpty(Wx(yfo));
    }

    public static boolean JG(yFO yfo) {
        return ML(yfo) && TV(yfo) == 1;
    }

    public static boolean SD(yFO yfo) {
        WQf WQf = WQf(yfo);
        return (WQf == null || yfo.SRe() || !WQf.KZx || TextUtils.isEmpty(Wx(yfo))) ? false : true;
    }

    public static boolean omh(yFO yfo) {
        WQf wQfOX = yfo.oX();
        return wQfOX != null && !yfo.SRe() && wQfOX.KZx && wQfOX.Og == 1;
    }

    public static boolean Bzk(yFO yfo) {
        WQf wQfOX = yfo.oX();
        return wQfOX != null && wQfOX.KZx && wQfOX.Og == 1;
    }

    public static boolean SGo(yFO yfo) {
        WQf wQfOX = yfo.oX();
        return wQfOX != null && yfo.SRe() && wQfOX.KZx && wQfOX.Og == 1;
    }

    private static int TV(yFO yfo) {
        WQf WQf = WQf(yfo);
        if (WQf == null) {
            return 0;
        }
        return WQf.ZZv;
    }

    public static String BSW(yFO yfo) {
        WQf WQf = WQf(yfo);
        if (WQf == null) {
            return null;
        }
        return WQf.ML;
    }

    public static String WV(yFO yfo) {
        WQf WQf = WQf(yfo);
        if (WQf == null) {
            return null;
        }
        return WQf.JG;
    }

    public static String Wx(yFO yfo) {
        if (yfo == null) {
            return null;
        }
        WQf wQfOX = yfo.oX();
        if (wQfOX != null && wQfOX.KZx) {
            String str = wQfOX.JG;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        if (yfo.aBv() == 20) {
            return yfo.dC();
        }
        if (yfo.Bf() != null) {
            return yfo.Bf().WV();
        }
        return null;
    }

    public static boolean DX(yFO yfo) {
        return ((yfo == null || yfo.Bf() == null) ? 0 : yfo.Bf().vZF()) != 1;
    }

    public static boolean oX(yFO yfo) {
        com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogBf = yfo.Bf();
        return ogBf != null && ogBf.vZF() == 1;
    }

    public static int aBv(yFO yfo) {
        WQf WQf = WQf(yfo);
        if (WQf == null) {
            return 0;
        }
        return WQf.SD;
    }

    public static boolean XT(yFO yfo) {
        return SD(yfo) && TV(yfo) == 1;
    }

    public static boolean yFO(yFO yfo) {
        return SD(yfo) && TV(yfo) == 0;
    }

    public int pA() {
        return this.omh;
    }

    public int Og() {
        return this.Bzk;
    }

    public boolean KZx() {
        return this.SGo;
    }

    public static long vZF(yFO yfo) {
        return Math.max(Sd(yfo), TX(yfo));
    }

    public static long Sd(yFO yfo) {
        WQf WQf = WQf(yfo);
        if (WQf == null) {
            return 5L;
        }
        return WQf.pA();
    }

    public static long TX(yFO yfo) {
        WQf WQf = WQf(yfo);
        if (WQf == null) {
            return 5L;
        }
        return WQf.Og();
    }

    public static boolean BF(yFO yfo) {
        WQf WQf = WQf(yfo);
        return WQf != null && WQf.KZx();
    }
}
