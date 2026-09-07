package com.bytedance.sdk.component.adexpress.pA.Og;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.WV;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class SD {
    private static volatile SD pA;
    private AtomicBoolean Og = new AtomicBoolean(false);

    public static SD pA() {
        if (pA == null) {
            synchronized (SD.class) {
                if (pA == null) {
                    pA = new SD();
                }
            }
        }
        return pA;
    }

    private SD() {
    }

    public com.bytedance.sdk.component.adexpress.pA.KZx.Og pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return JG.pA().pA(str);
    }

    public Set<String> Og(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return JG.pA().Og(str);
    }

    private void Og() {
        if (com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx() == null) {
            return;
        }
        int iPA = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx().pA();
        if (iPA <= 0) {
            iPA = 100;
        }
        List<com.bytedance.sdk.component.adexpress.pA.KZx.Og> listOg = JG.pA().Og();
        if (listOg == null || listOg.isEmpty() || iPA >= listOg.size()) {
            if (listOg == null) {
                return;
            }
            listOg.size();
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.component.adexpress.pA.KZx.Og og : listOg) {
            treeMap.put(og.SD(), og);
        }
        HashSet hashSet = new HashSet();
        int size = (int) (listOg.size() - (iPA * 0.75f));
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                ((Long) entry.getKey()).longValue();
                com.bytedance.sdk.component.adexpress.pA.KZx.Og og2 = (com.bytedance.sdk.component.adexpress.pA.KZx.Og) entry.getValue();
                if (og2 != null) {
                    hashSet.add(og2.Og());
                }
            }
        }
        pA(hashSet);
        this.Og.set(false);
    }

    private JSONObject KZx(String str) {
        com.bytedance.sdk.component.adexpress.pA.pA.KZx KZx = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx();
        if (KZx == null) {
            return null;
        }
        com.bytedance.sdk.component.SD.Og.Og ogSD = KZx.SD();
        ogSD.Og(str);
        com.bytedance.sdk.component.SD.Og ogPA = ogSD.pA();
        if (ogPA != null) {
            try {
                if (ogPA.JG() && ogPA.ZZv() != null) {
                    return PangleNetworkBridge.jsonObjectInit(ogPA.ZZv());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public void pA(com.bytedance.sdk.component.adexpress.pA.KZx.ZZv zZv, String str) {
        String strOmh;
        if (zZv == null) {
            WV.pA("TmplDiffManager", "saveTemplate error: tplInfo == null");
            return;
        }
        final String str2 = zZv.pA;
        final String str3 = zZv.KZx;
        final String str4 = zZv.Og;
        final String str5 = zZv.ZZv;
        final String str6 = zZv.ML;
        if (com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx() == null) {
            strOmh = "";
        } else {
            strOmh = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx().omh();
        }
        final String str7 = TextUtils.isEmpty(str) ? strOmh : str;
        if (TextUtils.isEmpty(str2)) {
            WV.pA("TmplDiffManager", "saveTemplate error:tmpId is empty");
        } else {
            com.bytedance.sdk.component.adexpress.ZZv.ZZv.pA(new com.bytedance.sdk.component.omh.omh("saveTemplate") { // from class: com.bytedance.sdk.component.adexpress.pA.Og.SD.1
                @Override // java.lang.Runnable
                public void run() {
                    SD.this.pA(str2, str3, str4, str5, str6, str7);
                }
            }, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void pA(String str, String str2, String str3, String str4, String str5, String str6) {
        if (pA(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                Og(str6, str, str3, str2, str4, str5);
            }
            return;
        } else if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            pA(str2, str6, str);
        } else {
            Og(str6, str, str3, str2, str4, str5);
        }
        boolean zPA = omh.pA(str5);
        if (!Og.ML() || zPA) {
            ML.Og().pA(true);
        }
    }

    private void pA(String str, String str2, String str3) {
        JSONObject jSONObjectKZx;
        if (TextUtils.isEmpty(str) || (jSONObjectKZx = KZx(str)) == null) {
            return;
        }
        String strOptString = jSONObjectKZx.optString("md5");
        String strOptString2 = jSONObjectKZx.optString("version");
        String strOptString3 = jSONObjectKZx.optString("data");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3)) {
            return;
        }
        com.bytedance.sdk.component.adexpress.pA.KZx.Og ogPA = new com.bytedance.sdk.component.adexpress.pA.KZx.Og().pA(str2).Og(str3).KZx(strOptString).ZZv(str).ML(strOptString3).JG(strOptString2).pA(Long.valueOf(System.currentTimeMillis()));
        JG.pA().pA(ogPA, false);
        Og();
        if (omh.pA(strOptString2)) {
            ogPA.JG(strOptString2);
            ML.Og().pA(true);
        }
    }

    private void Og(String str, String str2, String str3, String str4, String str5, String str6) {
        JG.pA().pA(new com.bytedance.sdk.component.adexpress.pA.KZx.Og().pA(str).Og(str2).KZx(str3).ZZv(str4).ML(str5).JG(str6).pA(Long.valueOf(System.currentTimeMillis())), false);
        Og();
    }

    public void pA(Set<String> set) {
        try {
            JG.pA().pA(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
