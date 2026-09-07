package com.bytedance.sdk.openadsdk.core.BSW.pA;

import android.text.TextUtils;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class Og {
    private static volatile Og pA;

    public interface pA {
        void pA(int i, String str, String str2);

        void pA(JSONObject jSONObject, String str);
    }

    public static Og pA() {
        if (pA == null) {
            synchronized (Og.class) {
                if (pA == null) {
                    pA = new Og();
                }
            }
        }
        return pA;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.BSW.JG.pA pAVar, String str) {
        if (pAVar == null) {
            return;
        }
        if (TextUtils.isEmpty(pAVar.pA())) {
            WV.pA("UGTemplateManager", "save ugen template error : tmpId is empty");
            return;
        }
        final String str2 = str + "_" + pAVar.pA();
        final String strKZx = pAVar.KZx();
        final String strOg = pAVar.Og();
        final String strZZv = pAVar.ZZv();
        String strML = pAVar.ML();
        if (TextUtils.isEmpty(strML)) {
            if (str.equals(Reporting.Key.CLICK_SOURCE_TYPE_AD)) {
                strML = Bzk.Og().ZZv();
            } else if (str.equals("adv3")) {
                strML = Bzk.Og().ZZv() + "_v3";
            }
        }
        final String str3 = strML;
        xy.pA(new omh("saveUGenTemplate") { // from class: com.bytedance.sdk.openadsdk.core.BSW.pA.Og.1
            @Override // java.lang.Runnable
            public void run() {
                Og.this.pA(str2, strKZx, strOg, strZZv, str3);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(String str, String str2, String str3, String str4, String str5) {
        if (pA(str, str3) != null) {
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                return;
            }
            Og(str2, str3, str5, str4, str);
            return;
        }
        if (TextUtils.isEmpty(str4)) {
            pA(str2, str, str3, str5, (pA) null);
        } else {
            Og(str2, str3, str5, str4, str);
        }
    }

    public void pA(String str, String str2, String str3, String str4, String str5, final pA pAVar) {
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            if (pAVar != null) {
                pAVar.pA(1, "id  or md5 is empty", "net");
                return;
            }
            return;
        }
        String str6 = str + "_" + str3;
        com.bytedance.sdk.openadsdk.core.BSW.pA.pA pAVarPA = pA(str6, str4);
        if (pAVarPA == null || TextUtils.isEmpty(pAVarPA.ML())) {
            pA(str2, str6, str4, str5, new pA() { // from class: com.bytedance.sdk.openadsdk.core.BSW.pA.Og.2
                @Override // com.bytedance.sdk.openadsdk.core.BSW.pA.Og.pA
                public void pA(JSONObject jSONObject, String str7) {
                    pA pAVar2 = pAVar;
                    if (pAVar2 != null) {
                        pAVar2.pA(jSONObject, str7);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.BSW.pA.Og.pA
                public void pA(int i, String str7, String str8) {
                    pA pAVar2 = pAVar;
                    if (pAVar2 != null) {
                        pAVar2.pA(i, str7, str8);
                    }
                }
            });
            return;
        }
        pA(pAVarPA);
        if (pAVar != null) {
            try {
                pAVar.pA(PangleNetworkBridge.jsonObjectInit(pAVarPA.ML()), "local");
            } catch (JSONException unused) {
                pAVar.pA(2, "parse json exception data is " + pAVarPA.ML(), "local");
            }
        }
    }

    private void pA(final String str, final String str2, final String str3, final String str4, final pA pAVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            if (pAVar != null) {
                pAVar.pA(1, "template url or id  or md5 is empty", "net");
            }
        } else {
            com.bytedance.sdk.component.SD.Og.Og ogKZx = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().KZx();
            ogKZx.Og(str);
            ogKZx.pA(7);
            ogKZx.pA("load_ug_t");
            ogKZx.pA(new com.bytedance.sdk.component.SD.pA.pA() { // from class: com.bytedance.sdk.openadsdk.core.BSW.pA.Og.3
                @Override // com.bytedance.sdk.component.SD.pA.pA
                public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, com.bytedance.sdk.component.SD.Og og) {
                    if (og == null) {
                        return;
                    }
                    if (og.JG()) {
                        String strZZv = og.ZZv();
                        if (TextUtils.isEmpty(strZZv)) {
                            pA pAVar2 = pAVar;
                            if (pAVar2 != null) {
                                pAVar2.pA(3, "net data is null", "net");
                                return;
                            }
                            return;
                        }
                        KZx.pA().pA(new com.bytedance.sdk.openadsdk.core.BSW.pA.pA().pA(str2).Og(str3).KZx(str).ML(str4).ZZv(strZZv).pA(Long.valueOf(System.currentTimeMillis())));
                        Og.this.Og();
                        if (pAVar != null) {
                            try {
                                pAVar.pA(PangleNetworkBridge.jsonObjectInit(strZZv), "net");
                                return;
                            } catch (JSONException unused) {
                                pAVar.pA(2, "parse json exception data is".concat(String.valueOf(strZZv)), "net");
                                return;
                            }
                        }
                        return;
                    }
                    pA pAVar3 = pAVar;
                    if (pAVar3 != null) {
                        pAVar3.pA(3, "net code error code is " + og.pA() + " message is " + og.Og(), "net");
                    }
                }

                @Override // com.bytedance.sdk.component.SD.pA.pA
                public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, IOException iOException) {
                    pA pAVar2 = pAVar;
                    if (pAVar2 != null) {
                        pAVar2.pA(3, "net error " + iOException.getMessage(), "net");
                    }
                }
            });
        }
    }

    public Set<com.bytedance.sdk.openadsdk.core.BSW.pA.pA> pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return KZx.pA().pA(str);
    }

    public String pA(String str, String str2, String str3) {
        com.bytedance.sdk.openadsdk.core.BSW.pA.pA pAVarPA = pA(str + "_" + str2, str3);
        if (pAVarPA == null) {
            return null;
        }
        pA(pAVarPA);
        return pAVarPA.ML();
    }

    private com.bytedance.sdk.openadsdk.core.BSW.pA.pA pA(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return KZx.pA().pA(str, str2);
    }

    private void Og(String str, String str2, String str3, String str4, String str5) {
        com.bytedance.sdk.openadsdk.core.BSW.pA.pA pAVar = new com.bytedance.sdk.openadsdk.core.BSW.pA.pA();
        pAVar.KZx(str).ML(str3).ZZv(str4).Og(str2).pA(str5).pA(Long.valueOf(System.currentTimeMillis()));
        KZx.pA().pA(pAVar);
        Og();
    }

    private void pA(final com.bytedance.sdk.openadsdk.core.BSW.pA.pA pAVar) {
        pAVar.pA(Long.valueOf(System.currentTimeMillis()));
        xy.pA(new omh("updateTmplTime") { // from class: com.bytedance.sdk.openadsdk.core.BSW.pA.Og.4
            @Override // java.lang.Runnable
            public void run() {
                KZx.pA().pA(pAVar);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og() {
        int iZZv = aBv.ZZv().ZZv();
        if (iZZv <= 0) {
            iZZv = 100;
        }
        List<com.bytedance.sdk.openadsdk.core.BSW.pA.pA> listOg = KZx.pA().Og();
        if (listOg == null || listOg.isEmpty() || iZZv >= listOg.size()) {
            if (listOg == null) {
                return;
            }
            listOg.size();
            return;
        }
        int size = (int) (listOg.size() - (iZZv * 0.75f));
        if (size <= 0) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.openadsdk.core.BSW.pA.pA pAVar : listOg) {
            treeMap.put(pAVar.ZZv(), pAVar);
        }
        HashSet hashSet = new HashSet();
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                com.bytedance.sdk.openadsdk.core.BSW.pA.pA pAVar2 = (com.bytedance.sdk.openadsdk.core.BSW.pA.pA) entry.getValue();
                if (pAVar2 != null) {
                    hashSet.add(pAVar2.pA());
                }
            }
        }
        pA(hashSet);
    }

    public void pA(Set<String> set) {
        try {
            KZx.pA().pA(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
