package com.bytedance.sdk.openadsdk.ZZv.pA;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.settings.oX;
import com.bytedance.sdk.openadsdk.core.yFO;
import com.bytedance.sdk.openadsdk.utils.WQf;
import com.bytedance.sdk.openadsdk.utils.xy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class SGo implements com.bytedance.sdk.component.JG.pA.Og.KZx {
    private final KZx Og = KZx.pA();
    public yFO<com.bytedance.sdk.openadsdk.ZZv.pA> pA;

    @Override // com.bytedance.sdk.component.JG.pA.Og.KZx
    public void pA(final List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list, final com.bytedance.sdk.component.JG.pA.Og.Og og) {
        com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar;
        if (list == null || list.isEmpty() || !aBv.ZZv().qQU() || (pAVar = list.get(0)) == null) {
            return;
        }
        byte bZZv = pAVar.ZZv();
        final ArrayList arrayList = new ArrayList();
        if (bZZv == 0) {
            com.bytedance.sdk.openadsdk.oX.KZx.pA(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.ZZv.pA.SGo.1
                @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                    com.bytedance.sdk.openadsdk.oX.Og.pA pAVar2 = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                    pAVar2.Og("applog");
                    return pAVar2;
                }
            });
            xy.pA(new com.bytedance.sdk.component.omh.KZx.Og(7, "upload_ad_event") { // from class: com.bytedance.sdk.openadsdk.ZZv.pA.SGo.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it;
                    try {
                        it = SGo.this.ZZv(list).entrySet().iterator();
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.WV.pA("OverSeaEventUploadImp", th.getMessage());
                        it = null;
                    }
                    if (it == null) {
                        com.bytedance.sdk.component.JG.pA.Og.Og og2 = og;
                        if (og2 != null) {
                            og2.pA(arrayList);
                            return;
                        }
                        return;
                    }
                    while (it.hasNext()) {
                        try {
                            pA.pA(pA.ZZv);
                            List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list2 = (List) ((Map.Entry) it.next()).getValue();
                            ArrayList arrayList2 = new ArrayList();
                            for (com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar2 : list2) {
                                arrayList2.add(new com.bytedance.sdk.openadsdk.ZZv.pA(pAVar2.KZx(), pAVar2.SD()));
                            }
                            com.bytedance.sdk.openadsdk.ZZv.ML mlPA = SGo.this.pA(arrayList2);
                            if (og != null && mlPA != null) {
                                boolean z = mlPA.ZZv;
                                if (SGo.this.pA(arrayList2, mlPA)) {
                                    z = true;
                                }
                                arrayList.add(new com.bytedance.sdk.component.JG.pA.Og.KZx.pA(new com.bytedance.sdk.component.JG.pA.Og.KZx.Og(mlPA.pA, mlPA.Og, mlPA.KZx, z, ""), list2));
                                if (mlPA.Og == 200) {
                                    pA.pA(pA.ZZv, true);
                                    com.bytedance.sdk.openadsdk.oX.KZx.Og(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.ZZv.pA.SGo.2.1
                                        @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                                        public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                                            com.bytedance.sdk.openadsdk.oX.Og.pA pAVar3 = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                                            pAVar3.Og("applog");
                                            return pAVar3;
                                        }
                                    });
                                } else if (z) {
                                    pA.pA(pA.ZZv, false);
                                    com.bytedance.sdk.openadsdk.oX.KZx.KZx(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.ZZv.pA.SGo.2.2
                                        @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                                        public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                                            com.bytedance.sdk.openadsdk.oX.Og.pA pAVar3 = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                                            pAVar3.Og("applog");
                                            return pAVar3;
                                        }
                                    });
                                } else {
                                    com.bytedance.sdk.openadsdk.oX.KZx.KZx(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.ZZv.pA.SGo.2.3
                                        @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                                        public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                                            com.bytedance.sdk.openadsdk.oX.Og.pA pAVar3 = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                                            pAVar3.Og("applog");
                                            return pAVar3;
                                        }
                                    });
                                }
                            }
                            if (og != null && mlPA == null) {
                                com.bytedance.sdk.openadsdk.oX.KZx.KZx(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.ZZv.pA.SGo.2.4
                                    @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                                    public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                                        com.bytedance.sdk.openadsdk.oX.Og.pA pAVar3 = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                                        pAVar3.Og("applog");
                                        return pAVar3;
                                    }
                                });
                            }
                        } catch (Throwable th2) {
                            com.bytedance.sdk.component.utils.WV.pA("OverSeaEventUploadImp", th2.getMessage());
                        }
                    }
                    com.bytedance.sdk.component.JG.pA.Og.Og og3 = og;
                    if (og3 != null) {
                        og3.pA(arrayList);
                    }
                }
            });
            return;
        }
        if (bZZv == 1) {
            final ArrayList arrayList2 = new ArrayList();
            for (com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar2 : list) {
                arrayList2.add(new com.bytedance.sdk.openadsdk.Sn.KZx.KZx.pA(pAVar2.KZx(), pAVar2.SD()));
            }
            pA.pA(pA.ML);
            if (arrayList2.size() > 0) {
                com.bytedance.sdk.openadsdk.oX.KZx.pA(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.ZZv.pA.SGo.3
                    @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                    public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                        com.bytedance.sdk.openadsdk.oX.Og.pA pAVar3 = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                        pAVar3.Og("stats");
                        return pAVar3;
                    }
                });
                xy.pA(new com.bytedance.sdk.component.omh.KZx.Og(6, "upload_stats_event") { // from class: com.bytedance.sdk.openadsdk.ZZv.pA.SGo.4
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.openadsdk.ZZv.ML mlOg = SGo.this.Og(arrayList2);
                        if (og != null && mlOg != null) {
                            arrayList.add(new com.bytedance.sdk.component.JG.pA.Og.KZx.pA(new com.bytedance.sdk.component.JG.pA.Og.KZx.Og(mlOg.pA, mlOg.Og, mlOg.KZx, mlOg.ZZv, ""), list));
                            og.pA(arrayList);
                            if (mlOg.Og == 200) {
                                pA.pA(pA.ML, true);
                                com.bytedance.sdk.openadsdk.oX.KZx.Og(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.ZZv.pA.SGo.4.1
                                    @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                                    public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                                        com.bytedance.sdk.openadsdk.oX.Og.pA pAVar3 = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                                        pAVar3.Og("stats");
                                        return pAVar3;
                                    }
                                });
                            } else if (mlOg.ZZv) {
                                pA.pA(pA.ML, false);
                                com.bytedance.sdk.openadsdk.oX.KZx.KZx(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.ZZv.pA.SGo.4.2
                                    @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                                    public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                                        com.bytedance.sdk.openadsdk.oX.Og.pA pAVar3 = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                                        pAVar3.Og("stats");
                                        return pAVar3;
                                    }
                                });
                            } else {
                                com.bytedance.sdk.openadsdk.oX.KZx.KZx(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.ZZv.pA.SGo.4.3
                                    @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                                    public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                                        com.bytedance.sdk.openadsdk.oX.Og.pA pAVar3 = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                                        pAVar3.Og("stats");
                                        return pAVar3;
                                    }
                                });
                            }
                        }
                        if (og == null || mlOg != null) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.oX.KZx.KZx(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.ZZv.pA.SGo.4.4
                            @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                            public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                                com.bytedance.sdk.openadsdk.oX.Og.pA pAVar3 = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                                pAVar3.Og("stats");
                                return pAVar3;
                            }
                        });
                    }
                });
            }
        }
    }

    private boolean KZx(List<com.bytedance.sdk.openadsdk.ZZv.pA> list) {
        JSONObject jSONObjectKZx;
        if (list == null || list.size() == 0 || (jSONObjectKZx = list.get(0).KZx()) == null) {
            return true;
        }
        return TextUtils.isEmpty(jSONObjectKZx.optString("app_log_url"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pA(List<com.bytedance.sdk.openadsdk.ZZv.pA> list, com.bytedance.sdk.openadsdk.ZZv.ML ml) {
        return !KZx(list) && ml.Og >= 400 && ml.Og < 500;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, List<com.bytedance.sdk.component.JG.pA.ZZv.pA>> ZZv(List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list) {
        HashMap<String, List<com.bytedance.sdk.component.JG.pA.ZZv.pA>> map = new HashMap<>();
        new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar = list.get(i);
            JSONObject jSONObjectSD = pAVar.SD();
            if (jSONObjectSD != null) {
                String strOptString = jSONObjectSD.optString("app_log_url");
                List<com.bytedance.sdk.component.JG.pA.ZZv.pA> arrayList = map.get(strOptString);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    map.put(strOptString, arrayList);
                }
                arrayList.add(pAVar);
            }
        }
        return map;
    }

    public com.bytedance.sdk.openadsdk.ZZv.ML pA(List<com.bytedance.sdk.openadsdk.ZZv.pA> list) {
        if (this.pA == null) {
            this.pA = aBv.KZx();
        }
        if (this.pA == null) {
            return null;
        }
        int iFw = oX.vkV().fw();
        if (3 == iFw) {
            return this.pA.pA(this.Og.pA(this.Og.pA(list, false), System.currentTimeMillis(), this.Og.Og(), true), this.Og.pA(list), true);
        }
        if (2 == iFw) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObjectOg = this.Og.Og();
            this.pA.pA(this.Og.pA(this.Og.pA(list, true), jCurrentTimeMillis, jSONObjectOg, true), this.Og.pA(list), true);
            return this.pA.pA(this.Og.pA(this.Og.Og(list), jCurrentTimeMillis, jSONObjectOg, false), this.Og.pA(list), false);
        }
        return this.pA.pA(this.Og.pA(list, System.currentTimeMillis(), this.Og.Og(), false), this.Og.pA(list), false);
    }

    public com.bytedance.sdk.openadsdk.ZZv.ML Og(List<com.bytedance.sdk.openadsdk.Sn.KZx.KZx.pA> list) {
        if (this.pA == null) {
            this.pA = aBv.KZx();
        }
        if (list != null && list.size() != 0 && com.bytedance.sdk.openadsdk.core.settings.WV.pA()) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<com.bytedance.sdk.openadsdk.Sn.KZx.KZx.pA> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().Og);
                }
                jSONObject.put("stats_list", jSONArray);
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = jCurrentTimeMillis / 1000;
                jSONObject.put("ts", j);
                jSONObject.put("ts_ms", jCurrentTimeMillis);
                String strZZv = com.bytedance.sdk.openadsdk.core.Bzk.Og().ZZv();
                if (strZZv == null) {
                    strZZv = "";
                }
                String strPA = WQf.pA();
                StringBuilder sbAppend = new StringBuilder(strZZv).append(j).append(BuildConfig.VERSION_NAME);
                StringBuilder sbAppend2 = new StringBuilder(strPA).append("-").append(jCurrentTimeMillis);
                jSONObject.put("req_sign", com.bytedance.sdk.component.utils.ML.pA(sbAppend.toString()));
                jSONObject.put("req_uniq", com.bytedance.sdk.component.utils.ML.pA(sbAppend2.toString()));
                return this.pA.Og(jSONObject);
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
