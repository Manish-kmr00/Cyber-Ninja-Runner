package com.bytedance.sdk.component.adexpress.dynamic.ML;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.Og.Wx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class Og {
    private Wx Bzk;
    private int JG;
    private double ML;
    private double SD;
    private String omh;
    public Map<String, KZx> pA = new HashMap();
    public Map<String, KZx> Og = new HashMap();
    public Map<String, KZx> KZx = new HashMap();
    private double ZZv = Math.random();

    public Og(double d, int i, double d2, String str, Wx wx) {
        this.ML = d;
        this.JG = i;
        this.SD = d2;
        this.omh = str;
        this.Bzk = wx;
    }

    public KZx pA(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar, float f, float f2) {
        float f3;
        if (TextUtils.isEmpty(omhVar.SGo().KZx()) && omhVar.SGo().ML().nCO() == null) {
            return new KZx(0.0f, 0.0f);
        }
        if (TextUtils.equals(omhVar.SGo().Og(), "creative-playable-bait")) {
            return new KZx(0.0f, 0.0f);
        }
        float fOmh = omhVar.omh();
        float fBzk = omhVar.Bzk();
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jgML = omhVar.SGo().ML();
        String strRoi = jgML.roi();
        String strEG = jgML.eG();
        float fWx = omhVar.Wx();
        float fSn = omhVar.Sn();
        float fDX = omhVar.DX();
        float fOX = omhVar.oX();
        if (TextUtils.equals(strRoi, "fixed")) {
            f = Math.min(fOmh, f);
            if (TextUtils.equals(strEG, "auto")) {
                f3 = Og(omhVar, f - fDX, f2 - fOX).Og;
                fBzk = f3 + fOX;
            }
        } else if (TextUtils.equals(strRoi, "auto")) {
            KZx kZxOg = Og(omhVar, f - fDX, f2 - fOX);
            f = kZxOg.pA + fDX;
            if (TextUtils.equals(strEG, "auto")) {
                f3 = kZxOg.Og;
                fBzk = f3 + fOX;
            }
        } else if (!TextUtils.equals(strRoi, "flex")) {
            f = fOmh;
        } else if (TextUtils.equals(strEG, "auto")) {
            f3 = Og(omhVar, f - fDX, f2 - fOX).Og;
            fBzk = f3 + fOX;
        }
        if (TextUtils.equals(strEG, "scale")) {
            float fRound = Math.round((f - fWx) / fBzk) + fSn;
            if (fRound > f2) {
                f = Math.round((f2 - fSn) * fBzk) + fWx;
            } else {
                f2 = fRound;
            }
        } else if (TextUtils.equals(strEG, "fixed")) {
            f2 = Math.min(fBzk + fSn, f2);
        } else if (!TextUtils.equals(strEG, "flex")) {
            f2 = fBzk;
        }
        KZx kZx = new KZx();
        kZx.pA = f;
        kZx.Og = f2;
        return kZx;
    }

    public KZx Og(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar, float f, float f2) {
        KZx kZx = new KZx();
        if (omhVar.SGo().ML() == null) {
            return kZx;
        }
        KZx kZxML = ML(omhVar, f, f2);
        float f3 = kZxML.pA;
        float f4 = kZxML.Og;
        kZx.pA = Math.min(f3, f);
        kZx.Og = Math.min(f4, f2);
        return kZx;
    }

    private KZx ML(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar, float f, float f2) {
        String str = omhVar.KZx() + "_" + f + "_" + f2;
        if (this.KZx.containsKey(str)) {
            return this.KZx.get(str);
        }
        KZx kZxJG = JG(omhVar, f, f2);
        this.KZx.put(str, kZxJG);
        return kZxJG;
    }

    private KZx JG(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar, float f, float f2) {
        new KZx();
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jgML = omhVar.SGo().ML();
        omhVar.SGo().KZx();
        jgML.dC();
        float fXT = jgML.XT();
        int iYkC = jgML.YkC();
        double dFJy = jgML.fJy();
        int iIIF = jgML.IIF();
        boolean zBf = jgML.Bf();
        boolean zVA = jgML.vA();
        int iHSv = jgML.HSv();
        C0202Og c0202Og = new C0202Og();
        c0202Og.pA = fXT;
        c0202Og.Og = iYkC;
        c0202Og.KZx = iIIF;
        c0202Og.ZZv = dFJy;
        c0202Og.ML = f;
        return pA(omhVar.SGo().KZx(), c0202Og, zBf, zVA, iHSv, omhVar);
    }

    private KZx pA(String str, C0202Og c0202Og, boolean z, boolean z2, int i, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        return BSW.pA(str, omhVar.SGo().Og(), C0202Og.pA(c0202Og).toString(), z, z2, i, omhVar, this.ML, this.JG, this.SD, this.omh, this.Bzk);
    }

    public KZx KZx(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar, float f, float f2) {
        if (omhVar == null) {
            return null;
        }
        KZx kZxPA = pA(omhVar);
        if (kZxPA != null && (kZxPA.pA != 0.0f || kZxPA.Og != 0.0f)) {
            return kZxPA;
        }
        KZx kZxZZv = ZZv(omhVar, f, f2);
        pA(omhVar, kZxZZv);
        return kZxZZv;
    }

    public KZx ZZv(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar, float f, float f2) {
        float fMin;
        KZx kZx = new KZx();
        float f3 = 0.0f;
        if (f2 <= 0.0f || f <= 0.0f) {
            kZx.pA = 0.0f;
            kZx.Og = 0.0f;
            return kZx;
        }
        if (omhVar.XT()) {
            return pA(omhVar, f, f2);
        }
        float fOmh = omhVar.omh();
        float fBzk = omhVar.Bzk();
        float fDX = omhVar.DX();
        float fOX = omhVar.oX();
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jgML = omhVar.SGo().ML();
        String strRoi = jgML.roi();
        String strEG = jgML.eG();
        float fMin2 = ((TextUtils.equals(strRoi, "flex") || TextUtils.equals(strRoi, "auto")) ? f : Math.min(fOmh, f)) - fDX;
        if (TextUtils.equals(strEG, "scale")) {
            fMin = Math.round(fMin2 / fBzk) + fOX;
            if (fMin > f2) {
                fMin2 = Math.round((f2 - fOX) * fBzk);
            }
        } else {
            fMin = (TextUtils.equals(strEG, "auto") || TextUtils.equals(strEG, "flex")) ? f2 : Math.min(fBzk, f2);
        }
        float f4 = fMin - fOX;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh>> listABv = omhVar.aBv();
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh>> it = listABv.iterator();
        float fMax = 0.0f;
        float fMax2 = 0.0f;
        while (it.hasNext()) {
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh>> it2 = it;
            List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> next = it.next();
            KZx kZx2 = kZx;
            KZx kZxOg = Og(next, fMin2, f4);
            if (Og(next)) {
                f3 += 1.0f;
            } else {
                fMax = Math.max(fMax, kZxOg.pA);
            }
            float f5 = f3;
            if (omhVar.SGo().Og().equals("carousel")) {
                fMax2 = Math.max(omhVar.Bzk(), kZxOg.Og);
            } else {
                fMax2 += kZxOg.Og;
            }
            kZx = kZx2;
            it = it2;
            f3 = f5;
        }
        KZx kZx3 = kZx;
        if (TextUtils.equals(strRoi, "auto")) {
            if (f3 == listABv.size()) {
                fMin2 = f;
            } else {
                for (List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> list : listABv) {
                    KZx(list);
                    Og(list, fMax, f4);
                }
                fMin2 = fMax;
            }
        }
        if (TextUtils.equals(strEG, "auto")) {
            if (fMax2 <= f2) {
                f4 = fMax2;
            } else {
                pA(listABv, fMin2, f4);
            }
        } else if ((TextUtils.equals(strEG, "fixed") || TextUtils.equals(strEG, "flex")) && f4 < fMax2) {
            pA(listABv, fMin2, f4);
        }
        kZx3.pA = Math.min(fMin2 + fDX, f);
        kZx3.Og = Math.min(f4 + fOX, f2);
        return kZx3;
    }

    private void pA(List<List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh>> list, float f, float f2) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh>> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (pA(it.next(), false)) {
                z = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> list2 : list) {
            pA pAVar = new pA();
            boolean zPA = pA(list2, !z);
            pAVar.pA = zPA ? 1.0f : Og(list2, f, f2).Og;
            pAVar.Og = !zPA;
            arrayList.add(pAVar);
        }
        List<pA> listPA = SGo.pA(f2, arrayList);
        for (int i = 0; i < list.size(); i++) {
            if (((pA) arrayList.get(i)).pA != listPA.get(i).pA) {
                List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> list3 = list.get(i);
                KZx(list3);
                Og(list3, f, listPA.get(i).pA);
            }
        }
    }

    private boolean Og(List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> list) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh>> listABv;
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().SGo().ML().roi(), "flex")) {
                return true;
            }
        }
        while (true) {
            boolean z = false;
            for (com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar : list) {
                if (TextUtils.equals(omhVar.SGo().ML().roi(), "auto") && (listABv = omhVar.aBv()) != null) {
                    Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh>> it2 = listABv.iterator();
                    int i = 0;
                    while (true) {
                        if (it2.hasNext()) {
                            List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> next = it2.next();
                            i++;
                            if (Og(next)) {
                                if (i == next.size()) {
                                    z = true;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return z;
        }
    }

    private KZx Og(List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> list, float f, float f2) {
        KZx kZxPA = pA(list);
        if (kZxPA != null && (kZxPA.pA != 0.0f || kZxPA.Og != 0.0f)) {
            return kZxPA;
        }
        KZx KZx2 = KZx(list, f, f2);
        pA(list, KZx2);
        return KZx2;
    }

    private KZx KZx(List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> list, float f, float f2) {
        float fMax;
        ZZv(list);
        KZx kZx = new KZx();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jgML = omhVar.SGo().ML();
            if (jgML.PV() == 1 || jgML.PV() == 2) {
                arrayList.add(omhVar);
            }
            if (jgML.PV() != 1 && jgML.PV() != 2) {
                arrayList2.add(omhVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            KZx((com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh) it.next(), f, f2);
        }
        if (arrayList2.size() <= 0) {
            return kZx;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Float.valueOf(KZx(it2.next(), f, f2).pA));
        }
        ArrayList arrayList4 = new ArrayList();
        int i = 0;
        while (true) {
            fMax = 0.0f;
            if (i >= arrayList2.size()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar2 = arrayList2.get(i);
            String strRoi = omhVar2.SGo().ML().roi();
            float fOmh = omhVar2.omh();
            boolean zEquals = TextUtils.equals(strRoi, "flex");
            if (TextUtils.equals(strRoi, "auto")) {
                List<List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh>> listABv = omhVar2.aBv();
                if (listABv == null || listABv.size() <= 0) {
                    zEquals = false;
                    break;
                }
                Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh>> it3 = listABv.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        zEquals = false;
                        break;
                    }
                    if (Og(it3.next())) {
                        zEquals = true;
                        break;
                    }
                }
            }
            pA pAVar = new pA();
            if (!zEquals) {
                fOmh = ((Float) arrayList3.get(i)).floatValue();
            }
            pAVar.pA = fOmh;
            pAVar.Og = !zEquals;
            if (zEquals) {
                fMax = ((Float) arrayList3.get(i)).floatValue();
            }
            pAVar.KZx = fMax;
            arrayList4.add(pAVar);
            i++;
        }
        pA(arrayList4, f, arrayList2);
        List<pA> listPA = SGo.pA(f, arrayList4);
        float f3 = 0.0f;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            f3 += listPA.get(i2).pA;
            if (((Float) arrayList3.get(i2)).floatValue() != listPA.get(i2).pA) {
                ZZv(arrayList2.get(i2));
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> it4 = arrayList2.iterator();
        int i3 = 0;
        boolean z = false;
        while (it4.hasNext()) {
            i3++;
            if (!Og(it4.next())) {
                z = false;
                break;
            }
            if (i3 == arrayList2.size()) {
                z = true;
            }
        }
        fMax = z ? f2 : 0.0f;
        ArrayList arrayList5 = new ArrayList();
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar3 = arrayList2.get(i4);
            KZx KZx2 = KZx(omhVar3, listPA.get(i4).pA, f2);
            if (!Og(omhVar3)) {
                fMax = Math.max(fMax, KZx2.Og);
            }
            arrayList5.add(KZx2);
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(Float.valueOf(((KZx) it5.next()).Og));
        }
        if (!z) {
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar4 = arrayList2.get(i5);
                if (Og(omhVar4) && ((Float) arrayList6.get(i5)).floatValue() != fMax) {
                    ZZv(omhVar4);
                    KZx(omhVar4, listPA.get(i5).pA, fMax);
                }
            }
        }
        kZx.pA = f3;
        kZx.Og = fMax;
        return kZx;
    }

    private boolean Og(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        if (omhVar == null) {
            return false;
        }
        if (TextUtils.equals(omhVar.SGo().ML().eG(), "flex")) {
            return true;
        }
        return KZx(omhVar);
    }

    private boolean KZx(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh>> listABv;
        if (!omhVar.XT() && TextUtils.equals(omhVar.SGo().ML().eG(), "auto") && (listABv = omhVar.aBv()) != null && listABv.size() > 0) {
            if (listABv.size() == 1) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> it = listABv.get(0).iterator();
                while (it.hasNext()) {
                    if (!Og(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh>> it2 = listABv.iterator();
            while (it2.hasNext()) {
                if (pA(it2.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean pA(List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> list, boolean z) {
        for (com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jgML = omhVar.SGo().ML();
            String strEG = jgML.eG();
            if (TextUtils.equals(strEG, "flex") || (z && ((TextUtils.equals(jgML.roi(), "flex") && TextUtils.equals(jgML.eG(), "scale") && com.bytedance.sdk.component.adexpress.dynamic.ZZv.ML.pA.get(omhVar.SGo().Og()).intValue() == 7) || TextUtils.equals(strEG, "flex")))) {
                return true;
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> it = list.iterator();
        while (it.hasNext()) {
            if (KZx(it.next())) {
                return true;
            }
        }
        return false;
    }

    private void pA(List<pA> list, float f, List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> list2) {
        float f2 = 0.0f;
        for (pA pAVar : list) {
            if (pAVar.Og) {
                f2 += pAVar.pA;
            }
        }
        if (f2 > f) {
            int i = 0;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (list.get(i2).Og && list2.get(i2).TX()) {
                    i++;
                }
            }
            if (i > 0) {
                float fCeil = (float) (Math.ceil(((f2 - f) / i) * 1000.0f) / 1000.0d);
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    pA pAVar2 = list.get(i3);
                    if (pAVar2.Og && list2.get(i3).TX()) {
                        pAVar2.pA -= fCeil;
                    }
                }
            }
        }
    }

    public void pA() {
        this.KZx.clear();
        this.pA.clear();
        this.Og.clear();
    }

    public KZx pA(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        return this.pA.get(ML(omhVar));
    }

    public KZx pA(List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> list) {
        return this.Og.get(ZZv(list));
    }

    private void ZZv(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        this.pA.remove(ML(omhVar));
        List<List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh>> listABv = omhVar.aBv();
        if (listABv == null || listABv.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh>> it = listABv.iterator();
        while (it.hasNext()) {
            KZx(it.next());
        }
    }

    private void KZx(List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.Og.remove(ZZv(list));
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> it = list.iterator();
        while (it.hasNext()) {
            ZZv(it.next());
        }
    }

    private String ML(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        return omhVar.KZx();
    }

    private String ZZv(List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String strKZx = list.get(i).KZx();
            if (i < list.size() - 1) {
                sb.append(strKZx).append("-");
            } else {
                sb.append(strKZx);
            }
        }
        return sb.toString();
    }

    private void pA(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar, KZx kZx) {
        this.pA.put(ML(omhVar), kZx);
    }

    private void pA(List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> list, KZx kZx) {
        this.Og.put(ZZv(list), kZx);
    }

    static class KZx {
        float Og;
        float pA;

        public KZx() {
        }

        public KZx(float f, float f2) {
            this.pA = f;
            this.Og = f2;
        }

        public String toString() {
            return "UnitSize{width=" + this.pA + ", height=" + this.Og + AbstractJsonLexerKt.END_OBJ;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.dynamic.ML.Og$Og, reason: collision with other inner class name */
    static class C0202Og {
        int KZx;
        float ML;
        int Og;
        double ZZv;
        float pA;

        C0202Og() {
        }

        static JSONObject pA(C0202Og c0202Og) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fontSize", c0202Og.pA);
                jSONObject.put("letterSpacing", c0202Og.Og);
                jSONObject.put("lineHeight", c0202Og.ZZv);
                jSONObject.put("maxWidth", c0202Og.ML);
                jSONObject.put("fontWeight", c0202Og.KZx);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    static class pA implements Cloneable {
        float KZx;
        boolean Og;
        float pA;

        pA() {
        }

        public Object clone() {
            try {
                return (pA) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
    }
}
