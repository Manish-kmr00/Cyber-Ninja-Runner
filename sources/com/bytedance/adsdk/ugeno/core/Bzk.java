package com.bytedance.adsdk.ugeno.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class Bzk {
    private JSONObject BSW;
    private String Bzk;
    private boolean DX;
    private DX JG;
    private com.bytedance.adsdk.ugeno.Og.KZx<View> KZx;
    private WV ML;
    private JSONObject Og;
    private Wx SD;
    private omh SGo;
    private com.bytedance.adsdk.ugeno.ZZv.pA.pA Sn;
    private boolean WV = true;
    private boolean Wx = false;
    private JG ZZv;
    private List<String> oX;
    private ML omh;
    private Context pA;

    public Bzk(Context context) {
        this.pA = context;
    }

    public void pA(String str, omh omhVar) {
        this.SGo = omhVar;
        this.Bzk = str;
        if (omhVar != null) {
            this.Og = omhVar.pA();
        }
    }

    public com.bytedance.adsdk.ugeno.Og.KZx<View> pA(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.Og = jSONObject2;
        DX dx = this.JG;
        if (dx != null) {
            dx.pA();
        }
        this.omh = new ML(jSONObject, jSONObject2, jSONObject3);
        this.Sn = new com.bytedance.adsdk.ugeno.ZZv.pA.pA();
        WV wv = this.ML;
        if (wv instanceof com.bytedance.adsdk.ugeno.core.pA.pA) {
            ((com.bytedance.adsdk.ugeno.core.pA.pA) wv).pA(this.omh.Og());
        }
        this.KZx = pA(this.omh.pA(), (com.bytedance.adsdk.ugeno.Og.KZx<View>) null);
        DX dx2 = this.JG;
        if (dx2 != null) {
            dx2.Og();
            this.KZx.pA(this.JG);
        }
        pA(this.KZx);
        return this.KZx;
    }

    public com.bytedance.adsdk.ugeno.Og.KZx<View> pA(ML.pA pAVar, com.bytedance.adsdk.ugeno.Og.KZx<View> kZx) {
        Og og;
        List<ML.pA> listKZx;
        com.bytedance.adsdk.ugeno.Og.pA.C0174pA c0174pAKZx = null;
        if (!ML.pA(pAVar)) {
            return null;
        }
        String strKZx = pAVar.KZx();
        Og ogPA = ZZv.pA(strKZx);
        if (ogPA == null) {
            this.DX = true;
            if (this.oX == null) {
                og = ogPA;
                this.oX = new ArrayList();
            }
            og = ogPA;
            this.oX.add(strKZx);
            strKZx = "View";
            pAVar.pA("View");
            Og ogPA2 = ZZv.pA("View");
            Log.d("UGTemplateEngine", "unknown component; use view widget");
            og = ogPA2;
            if (ogPA2 == null) {
                Log.d("UGTemplateEngine", "not found component ".concat(String.valueOf("View")));
                return null;
            }
        }
        og = ogPA;
        com.bytedance.adsdk.ugeno.Og.KZx kZxPA = og.pA(this.pA);
        if (kZxPA == null) {
            return null;
        }
        JSONObject jSONObjectZZv = pAVar.ZZv();
        kZxPA.ML(com.bytedance.adsdk.ugeno.KZx.Og.pA(pAVar.pA(), this.Og));
        kZxPA.JG(strKZx);
        kZxPA.Og(jSONObjectZZv);
        kZxPA.pA(pAVar);
        kZxPA.pA(this.omh.ZZv());
        kZxPA.pA(this.SGo);
        kZxPA.pA(this.Sn);
        Iterator<String> itKeys = jSONObjectZZv.keys();
        if (kZx instanceof com.bytedance.adsdk.ugeno.Og.pA) {
            com.bytedance.adsdk.ugeno.Og.pA pAVar2 = (com.bytedance.adsdk.ugeno.Og.pA) kZx;
            c0174pAKZx = pAVar2.KZx();
            kZxPA.pA(pAVar2);
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strPA = com.bytedance.adsdk.ugeno.KZx.Og.pA(jSONObjectZZv.optString(next), this.Og);
            kZxPA.pA(next, strPA);
            if (c0174pAKZx != null) {
                c0174pAKZx.pA(this.pA, next, strPA);
            }
        }
        if (c0174pAKZx != null) {
            kZxPA.pA(c0174pAKZx.pA());
        }
        if (kZxPA instanceof com.bytedance.adsdk.ugeno.Og.pA) {
            List<ML.pA> listML = pAVar.ML();
            if (listML == null || listML.size() <= 0) {
                if (TextUtils.equals(kZxPA.lT(), "RecyclerLayout") && (listKZx = this.omh.KZx()) != null && listKZx.size() > 0) {
                    Iterator<ML.pA> it = listKZx.iterator();
                    while (it.hasNext()) {
                        com.bytedance.adsdk.ugeno.Og.KZx<View> kZxPA2 = pA(it.next(), (com.bytedance.adsdk.ugeno.Og.KZx<View>) kZxPA);
                        if (kZxPA2 != null && kZxPA2.qmB()) {
                            ((com.bytedance.adsdk.ugeno.Og.pA) kZxPA).pA(kZxPA2);
                        }
                    }
                }
                return kZxPA;
            }
            if (TextUtils.equals(kZxPA.lT(), "Swiper") && listML.size() != 1) {
                Log.e("UGTemplateEngine", "Swiper must be only one widget");
            }
            Iterator<ML.pA> it2 = listML.iterator();
            while (it2.hasNext()) {
                com.bytedance.adsdk.ugeno.Og.KZx<View> kZxPA3 = pA(it2.next(), (com.bytedance.adsdk.ugeno.Og.KZx<View>) kZxPA);
                if (kZxPA3 != null && !kZxPA3.agB()) {
                    ((com.bytedance.adsdk.ugeno.Og.pA) kZxPA).pA(kZxPA3, kZxPA3.TV());
                }
            }
        }
        this.KZx = kZxPA;
        return kZxPA;
    }

    public com.bytedance.adsdk.ugeno.Og.KZx<View> pA(JSONObject jSONObject) {
        DX dx = this.JG;
        if (dx != null) {
            dx.pA();
        }
        ML ml = new ML(jSONObject, this.Og);
        this.omh = ml;
        WV wv = this.ML;
        if (wv instanceof com.bytedance.adsdk.ugeno.core.pA.pA) {
            ((com.bytedance.adsdk.ugeno.core.pA.pA) wv).pA(ml.Og());
        }
        this.KZx = Og(this.omh.pA(), null);
        DX dx2 = this.JG;
        if (dx2 != null) {
            dx2.Og();
            this.KZx.pA(this.JG);
        }
        return this.KZx;
    }

    public com.bytedance.adsdk.ugeno.Og.KZx<View> Og(ML.pA pAVar, com.bytedance.adsdk.ugeno.Og.KZx<View> kZx) {
        List<ML.pA> listKZx;
        com.bytedance.adsdk.ugeno.Og.pA.C0174pA c0174pAKZx = null;
        if (!ML.pA(pAVar)) {
            return null;
        }
        String strKZx = pAVar.KZx();
        Og ogPA = ZZv.pA(strKZx);
        if (ogPA == null) {
            Log.d("UGTemplateEngine", "not found component ".concat(String.valueOf(strKZx)));
            this.DX = true;
            if (this.oX == null) {
                this.oX = new ArrayList();
            }
            this.oX.add(strKZx);
            return null;
        }
        com.bytedance.adsdk.ugeno.Og.KZx kZxPA = ogPA.pA(this.pA);
        if (kZxPA == null) {
            return null;
        }
        kZxPA.ML(com.bytedance.adsdk.ugeno.KZx.Og.pA(pAVar.pA(), this.Og));
        kZxPA.JG(strKZx);
        kZxPA.Og(pAVar.ZZv());
        kZxPA.pA(pAVar);
        kZxPA.pA(this.SGo);
        if (kZx instanceof com.bytedance.adsdk.ugeno.Og.pA) {
            com.bytedance.adsdk.ugeno.Og.pA pAVar2 = (com.bytedance.adsdk.ugeno.Og.pA) kZx;
            kZxPA.pA(pAVar2);
            c0174pAKZx = pAVar2.KZx();
        }
        Iterator<String> itKeys = pAVar.ZZv().keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strPA = com.bytedance.adsdk.ugeno.KZx.Og.pA(pAVar.ZZv().optString(next), this.Og);
            kZxPA.pA(next, strPA);
            if (c0174pAKZx != null) {
                c0174pAKZx.pA(this.pA, next, strPA);
            }
        }
        if (kZxPA instanceof com.bytedance.adsdk.ugeno.Og.pA) {
            List<ML.pA> listML = pAVar.ML();
            if (listML == null || listML.size() <= 0) {
                if (TextUtils.equals(kZxPA.lT(), "RecyclerLayout") && (listKZx = this.omh.KZx()) != null && listKZx.size() > 0) {
                    Iterator<ML.pA> it = listKZx.iterator();
                    while (it.hasNext()) {
                        com.bytedance.adsdk.ugeno.Og.KZx<View> kZxOg = Og(it.next(), kZxPA);
                        if (kZxOg != null && kZxOg.qmB()) {
                            ((com.bytedance.adsdk.ugeno.Og.pA) kZxPA).pA(kZxOg);
                        }
                    }
                }
                return kZxPA;
            }
            if (TextUtils.equals(kZxPA.lT(), "Swiper") && listML.size() != 1) {
                Log.e("UGTemplateEngine", "Swiper must be only one widget");
            }
            Iterator<ML.pA> it2 = listML.iterator();
            while (it2.hasNext()) {
                com.bytedance.adsdk.ugeno.Og.KZx<View> kZxOg2 = Og(it2.next(), kZxPA);
                if (kZxOg2 != null && kZxOg2.qmB()) {
                    ((com.bytedance.adsdk.ugeno.Og.pA) kZxPA).pA(kZxOg2);
                }
            }
        }
        if (c0174pAKZx != null) {
            kZxPA.pA(c0174pAKZx.pA());
        }
        this.KZx = kZxPA;
        return kZxPA;
    }

    public void Og(JSONObject jSONObject) {
        DX dx = this.JG;
        if (dx != null) {
            dx.KZx();
        }
        this.Og = jSONObject;
        pA(this.KZx, jSONObject);
        pA(this.KZx);
        if (this.JG != null) {
            Sn sn = new Sn();
            sn.pA(0);
            sn.pA(this.KZx);
            this.JG.pA(sn);
        }
    }

    public void pA(com.bytedance.adsdk.ugeno.Og.KZx kZx, JSONObject jSONObject) {
        if (kZx == null) {
            return;
        }
        if (kZx instanceof com.bytedance.adsdk.ugeno.Og.pA) {
            kZx.pA(jSONObject);
            List<com.bytedance.adsdk.ugeno.Og.KZx<View>> listPA = ((com.bytedance.adsdk.ugeno.Og.pA) kZx).pA();
            if (listPA == null || listPA.size() <= 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.Og.KZx<View>> it = listPA.iterator();
            while (it.hasNext()) {
                pA(it.next(), jSONObject);
            }
            return;
        }
        kZx.pA(jSONObject);
    }

    private void pA(com.bytedance.adsdk.ugeno.Og.KZx<View> kZx) {
        List<com.bytedance.adsdk.ugeno.Og.KZx<View>> listPA;
        if (kZx == null) {
            return;
        }
        JSONObject jSONObjectTX = kZx.TX();
        Iterator<String> itKeys = jSONObjectTX.keys();
        com.bytedance.adsdk.ugeno.Og.pA pAVarMc = kZx.Mc();
        com.bytedance.adsdk.ugeno.Og.pA.C0174pA c0174pAKZx = pAVarMc != null ? pAVarMc.KZx() : null;
        Og(kZx);
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strPA = com.bytedance.adsdk.ugeno.KZx.Og.pA(jSONObjectTX.optString(next), this.Og);
            kZx.pA(next, strPA);
            if (c0174pAKZx != null) {
                c0174pAKZx.pA(this.pA, next, strPA);
            }
        }
        kZx.pA(this.ZZv);
        kZx.pA(this.ML);
        kZx.pA(this.SD);
        if ((kZx instanceof com.bytedance.adsdk.ugeno.Og.pA) && (listPA = ((com.bytedance.adsdk.ugeno.Og.pA) kZx).pA()) != null && listPA.size() > 0) {
            Iterator<com.bytedance.adsdk.ugeno.Og.KZx<View>> it = listPA.iterator();
            while (it.hasNext()) {
                pA(it.next());
            }
        }
        if (c0174pAKZx != null) {
            kZx.pA(c0174pAKZx.pA());
        }
        kZx.Og();
    }

    private void Og(com.bytedance.adsdk.ugeno.Og.KZx kZx) {
        try {
            if (!kZx.roi() || kZx.eG() == null || kZx.eG().JG() == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("i18n", kZx.eG().JG());
            this.Og.put("xNode", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void pA(WV wv) {
        com.bytedance.adsdk.ugeno.core.pA.pA pAVar = new com.bytedance.adsdk.ugeno.core.pA.pA(wv);
        pAVar.pA(this.BSW);
        pAVar.pA(this.WV);
        pAVar.Og(this.Wx);
        ML ml = this.omh;
        if (ml != null) {
            pAVar.pA(ml.Og());
        }
        this.ML = pAVar;
    }

    public void pA(Wx wx) {
        this.SD = wx;
    }

    public boolean pA() {
        return this.DX;
    }

    public List<String> Og() {
        return this.oX;
    }
}
