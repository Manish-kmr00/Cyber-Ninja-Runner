package com.bytedance.sdk.component.pA;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class pA {
    protected omh KZx;
    protected String ML;
    protected Wx Og;
    SD SD;
    protected Context pA;
    protected Handler ZZv = new Handler(Looper.getMainLooper());
    protected volatile boolean JG = false;
    private final Map<String, SD> omh = new HashMap();

    protected abstract void Og(SGo sGo);

    protected abstract Context pA(SGo sGo);

    protected abstract String pA();

    protected abstract void pA(String str);

    protected pA() {
    }

    protected void invokeMethod(final String str) {
        if (this.JG) {
            return;
        }
        this.ZZv.post(new Runnable() { // from class: com.bytedance.sdk.component.pA.pA.1
            @Override // java.lang.Runnable
            public void run() {
                oX oXVarPA;
                if (pA.this.JG) {
                    return;
                }
                try {
                    oXVarPA = pA.this.pA(PangleNetworkBridge.jsonObjectInit(str));
                } catch (Exception unused) {
                    oXVarPA = null;
                }
                if (oX.pA(oXVarPA)) {
                    new StringBuilder("By pass invalid call: ").append(oXVarPA);
                    if (oXVarPA != null) {
                        pA.this.Og(TV.pA(new XT(oXVarPA.pA, "Failed to parse invocation.")), oXVarPA);
                        return;
                    }
                    return;
                }
                pA.this.pA(oXVarPA);
            }
        });
    }

    protected void pA(String str, oX oXVar) {
        pA(str);
    }

    protected void Og() {
        this.SD.pA();
        Iterator<SD> it = this.omh.values().iterator();
        while (it.hasNext()) {
            it.next().pA();
        }
        this.ZZv.removeCallbacksAndMessages(null);
        this.JG = true;
    }

    protected final void pA(oX oXVar) {
        String strPA;
        if (this.JG || (strPA = pA()) == null) {
            return;
        }
        SD sdOg = Og(oXVar.SD);
        if (sdOg == null) {
            new StringBuilder("Received call with unknown namespace, ").append(oXVar);
            if (this.Og != null) {
                pA();
            }
            Og(TV.pA(new XT(-4, "Namespace " + oXVar.SD + " unknown.")), oXVar);
            return;
        }
        JG jg = new JG();
        jg.Og = strPA;
        jg.pA = this.pA;
        jg.KZx = sdOg;
        try {
            SD.pA pAVarPA = sdOg.pA(oXVar, jg);
            if (pAVarPA == null) {
                new StringBuilder("Received call but not registered, ").append(oXVar);
                if (this.Og != null) {
                    pA();
                }
                Og(TV.pA(new XT(-2, "Function " + oXVar.ZZv + " is not registered.")), oXVar);
                return;
            }
            if (pAVarPA.pA) {
                Og(pAVarPA.Og, oXVar);
            }
            if (this.Og != null) {
                pA();
            }
        } catch (Exception e) {
            new StringBuilder("call finished with error, ").append(oXVar);
            Og(TV.pA(e), oXVar);
        }
    }

    final void pA(SGo sGo, TX tx) {
        this.pA = pA(sGo);
        this.KZx = sGo.ZZv;
        this.Og = sGo.Bzk;
        this.SD = new SD(sGo, this, tx);
        this.ML = sGo.BSW;
        Og(sGo);
    }

    final void Og(String str, oX oXVar) {
        JSONObject jSONObject;
        if (this.JG || TextUtils.isEmpty(oXVar.JG)) {
            return;
        }
        if (!str.startsWith("{") || !str.endsWith("}")) {
            Bzk.pA(new IllegalArgumentException("Illegal callback data: ".concat(String.valueOf(str))));
        }
        String str2 = oXVar.JG;
        try {
            jSONObject = PangleNetworkBridge.jsonObjectInit(str);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        pA(DX.pA().pA("__msg_type", "callback").pA("__callback_id", oXVar.JG).pA("__params", jSONObject).Og(), oXVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public oX pA(JSONObject jSONObject) {
        String strOptString;
        if (this.JG) {
            return null;
        }
        String strOptString2 = jSONObject.optString("__callback_id");
        String strOptString3 = jSONObject.optString("func");
        if (pA() == null) {
            return null;
        }
        try {
            String string = jSONObject.getString("__msg_type");
            String strValueOf = "";
            try {
                Object objOpt = jSONObject.opt("params");
                if (objOpt == null) {
                    strOptString = strValueOf;
                } else if (objOpt instanceof JSONObject) {
                    strOptString = String.valueOf((JSONObject) objOpt);
                } else {
                    if (objOpt instanceof String) {
                        strValueOf = (String) objOpt;
                    } else {
                        strValueOf = String.valueOf(objOpt);
                    }
                    strOptString = strValueOf;
                }
            } catch (Throwable unused) {
                strOptString = jSONObject.optString("params");
            }
            String string2 = jSONObject.getString("JSSDK");
            String strOptString4 = jSONObject.optString("namespace");
            return oX.pA().pA(string2).Og(string).KZx(strOptString3).ZZv(strOptString).ML(strOptString2).JG(strOptString4).SD(jSONObject.optString("__iframe_url")).pA();
        } catch (JSONException unused2) {
            return oX.pA(strOptString2, -1);
        }
    }

    private SD Og(String str) {
        if (TextUtils.equals(str, this.ML) || TextUtils.isEmpty(str)) {
            return this.SD;
        }
        return this.omh.get(str);
    }
}
