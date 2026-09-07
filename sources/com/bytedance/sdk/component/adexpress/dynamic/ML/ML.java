package com.bytedance.sdk.component.adexpress.dynamic.ML;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.Og.Wx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ML {
    private com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh KZx;
    protected Og Og;
    private pA ZZv;
    public com.bytedance.sdk.component.adexpress.dynamic.ZZv.Og pA;

    static class pA {
        float KZx;
        float Og;
        float pA;

        pA() {
        }
    }

    public ML(double d, int i, double d2, String str, Wx wx) {
        this.Og = new Og(d, i, d2, str, wx);
    }

    public void pA(pA pAVar) {
        this.ZZv = pAVar;
    }

    public void pA() {
        this.Og.pA();
    }

    public void pA(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar, float f, float f2) {
        if (omhVar != null) {
            this.KZx = omhVar;
        }
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar2 = this.KZx;
        float fOmh = omhVar2.omh();
        float fBzk = omhVar2.Bzk();
        float f3 = TextUtils.equals(omhVar2.SGo().ML().eG(), "fixed") ? fBzk : 65536.0f;
        this.Og.pA();
        this.Og.KZx(omhVar2, fOmh, f3);
        Og.KZx kZxPA = this.Og.pA(omhVar2);
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.Og og = new com.bytedance.sdk.component.adexpress.dynamic.ZZv.Og();
        og.pA = f;
        og.Og = f2;
        if (kZxPA != null) {
            fOmh = kZxPA.pA;
        }
        og.KZx = fOmh;
        if (kZxPA != null) {
            fBzk = kZxPA.Og;
        }
        og.ZZv = fBzk;
        og.ML = "root";
        og.Bzk = 1280.0f;
        og.JG = omhVar2;
        og.JG.KZx(og.pA);
        og.JG.ZZv(og.Og);
        og.JG.ML(og.KZx);
        og.JG.JG(og.ZZv);
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.Og ogPA = pA(og, 0.0f);
        this.pA = ogPA;
        pA(ogPA);
    }

    public void pA(com.bytedance.sdk.component.adexpress.dynamic.ZZv.Og og) {
        if (og == null) {
            return;
        }
        og.JG.SGo().Og();
        float f = og.KZx;
        float f2 = og.ZZv;
        float f3 = og.pA;
        float f4 = og.Og;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.Og>> list = og.SD;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.Og> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.ZZv.Og> it = list2.iterator();
                while (it.hasNext()) {
                    pA(it.next());
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x031e  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:87:0x01ef  */
    public com.bytedance.sdk.component.adexpress.dynamic.ZZv.Og pA(com.bytedance.sdk.component.adexpress.dynamic.ZZv.Og og, float f) {
        float fPA;
        float fPA2;
        float f2;
        float fPA3;
        float fPA4;
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.Og og2;
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.Bzk bzkPA;
        float f3;
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.Bzk bzk;
        Og.KZx kZxPA;
        Og.KZx kZxPA2;
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.Og og3 = og;
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar = og3.JG;
        if (omhVar == null) {
            return og3;
        }
        omhVar.Sd();
        List<List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh>> listABv = omhVar.aBv();
        if (listABv == null || listABv.size() <= 0) {
            return og3;
        }
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jgML = omhVar.SGo().ML();
        float fABv = jgML.aBv();
        float fOX = jgML.oX();
        float fSn = jgML.Sn();
        float fDX = jgML.DX();
        float fWV = jgML.WV();
        String strFQ = jgML.FQ();
        String strGx = jgML.Gx();
        float f4 = og3.pA + fDX;
        float f5 = og3.Og + fABv;
        float f6 = fWV * 2.0f;
        float f7 = ((og3.KZx - fDX) - fOX) - f6;
        float f8 = ((og3.ZZv - fABv) - fSn) - f6;
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.Bzk bzk2 = new com.bytedance.sdk.component.adexpress.dynamic.ZZv.Bzk(f4, f5);
        if (og3.SD == null) {
            og3.SD = new ArrayList();
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh>> it = listABv.iterator();
        float f9 = 0.0f;
        while (it.hasNext()) {
            Og.KZx kZxPA3 = this.Og.pA(it.next());
            if (kZxPA3 != null) {
                f9 += kZxPA3.Og;
            }
        }
        String str = "space-between";
        String str2 = "space-around";
        if (f9 >= f8) {
            fPA = 0.0f;
            fPA2 = 0.0f;
        } else {
            if (TextUtils.equals(strGx, "center")) {
                fPA2 = (f8 - f9) / 2.0f;
            } else if (TextUtils.equals(strGx, "flex-end")) {
                fPA2 = f8 - f9;
            } else if (TextUtils.equals(strGx, "space-around")) {
                fPA2 = SGo.pA((f8 - f9) / (listABv.size() + 1));
                fPA = fPA2;
            } else {
                if (!TextUtils.equals(strGx, "space-between") || listABv.size() <= 1) {
                    fPA = 0.0f;
                } else {
                    fPA = SGo.pA((f8 - f9) / (listABv.size() - 1));
                }
                fPA2 = 0.0f;
            }
            fPA = 0.0f;
        }
        bzk2.Og += fPA2;
        float f10 = f;
        int i = 0;
        while (i < listABv.size()) {
            List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> list = listABv.get(i);
            i++;
            if (i >= og3.SD.size()) {
                int size = (i - og3.SD.size()) + 1;
                int i2 = 0;
                while (i2 < size) {
                    og3.SD.add(new ArrayList());
                    i2++;
                    size = size;
                    f10 = f10;
                }
            }
            float f11 = f10;
            Iterator<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> it2 = list.iterator();
            float f12 = 0.0f;
            while (true) {
                f2 = fPA;
                if (!it2.hasNext()) {
                    break;
                }
                com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh next = it2.next();
                com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jgML2 = next.SGo().ML();
                String strRoi = jgML2.roi();
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> it3 = it2;
                int iPV = jgML2.PV();
                if (!TextUtils.equals(strRoi, "flex") && iPV != 1 && iPV != 2 && (kZxPA2 = this.Og.pA(next)) != null) {
                    f12 += kZxPA2.pA;
                }
                fPA = f2;
                it2 = it3;
            }
            float fMax = Math.max(f7 - f12, 0.0f);
            Iterator<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> it4 = list.iterator();
            float f13 = 0.0f;
            while (it4.hasNext()) {
                com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh next2 = it4.next();
                com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jgML3 = next2.SGo().ML();
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> it5 = it4;
                if (jgML3.PV() != 1 && jgML3.PV() != 2 && (kZxPA = this.Og.pA(next2)) != null) {
                    f13 += kZxPA.pA;
                }
                it4 = it5;
            }
            if (f13 >= f7) {
                fPA3 = 0.0f;
                fPA4 = 0.0f;
            } else {
                if (TextUtils.equals(strFQ, "center")) {
                    fPA3 = (f7 - f13) / 2.0f;
                } else if (TextUtils.equals(strFQ, "flex-end")) {
                    fPA3 = f7 - f13;
                } else if (TextUtils.equals(strFQ, str2)) {
                    fPA3 = SGo.pA((f7 - f13) / (list.size() + 1));
                    fPA4 = fPA3;
                } else if (!TextUtils.equals(strFQ, str) || list.size() <= 1) {
                    fPA3 = 0.0f;
                } else {
                    fPA4 = SGo.pA((f7 - f13) / (list.size() - 1.0f));
                    fPA3 = 0.0f;
                }
                fPA4 = 0.0f;
            }
            bzk2.pA += fPA3;
            Iterator<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> it6 = list.iterator();
            float fMax2 = 0.0f;
            while (it6.hasNext()) {
                com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh next3 = it6.next();
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> it7 = it6;
                float f14 = this.Og.pA(next3) != null ? this.Og.pA(next3).Og : 0.0f;
                com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jgML4 = next3.SGo().ML();
                String str3 = str;
                fMax2 = Math.max(fMax2, (jgML4.PV() == 1 || jgML4.PV() == 2) ? 0.0f : f14);
                it6 = it7;
                str = str3;
            }
            String str4 = str;
            Iterator<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> it8 = list.iterator();
            f10 = f11;
            while (it8.hasNext()) {
                com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh next4 = it8.next();
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> it9 = it8;
                Og.KZx kZxPA4 = this.Og.pA(next4);
                String str5 = strFQ;
                com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jgML5 = next4.SGo().ML();
                float f15 = f10;
                float fJBA = jgML5.JBA();
                float f16 = f7;
                float fDmv = jgML5.dmv();
                String str6 = str2;
                float fAgB = jgML5.agB();
                float f17 = fPA4;
                float fFN = jgML5.fN();
                com.bytedance.sdk.component.adexpress.dynamic.ZZv.Bzk bzk3 = bzk2;
                float f18 = kZxPA4 == null ? 0.0f : kZxPA4.pA;
                float f19 = kZxPA4 == null ? 0.0f : kZxPA4.Og;
                com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar2 = omhVar;
                float f20 = TextUtils.equals(omhVar.KZx(), "root") ? i : f15;
                int i3 = i;
                if (jgML5.PV() == 1) {
                    og2 = og;
                    bzkPA = pA(og2, jgML5, (f18 - fDmv) - fFN, (f19 - fJBA) - fAgB);
                } else {
                    og2 = og;
                    bzkPA = bzk3;
                }
                com.bytedance.sdk.component.adexpress.dynamic.ZZv.Bzk bzkPA2 = jgML5.PV() == 2 ? pA(jgML5, this.Og.pA(this.KZx), new Og.KZx((f18 - fDmv) - fFN, (f19 - fJBA) - fAgB)) : bzkPA;
                String strTZW = jgML.tZW();
                if (fMax2 <= f19 || TextUtils.equals(strTZW, "flex-start")) {
                    f3 = 0.0f;
                } else {
                    strTZW.hashCode();
                    if (strTZW.equals("center")) {
                        f3 = (fMax2 - f19) / 2.0f;
                    } else if (strTZW.equals("flex-end")) {
                        f3 = fMax2 - f19;
                    } else {
                        f3 = 0.0f;
                    }
                }
                com.bytedance.sdk.component.adexpress.dynamic.ZZv.Og og4 = new com.bytedance.sdk.component.adexpress.dynamic.ZZv.Og();
                og4.pA = bzkPA2.pA + fFN;
                og4.Og = bzkPA2.Og + fJBA + f3;
                og4.KZx = (f18 - fDmv) - fFN;
                og4.ZZv = (f19 - fJBA) - fAgB;
                og4.ML = og2.ML + "." + next4.KZx();
                og4.omh = og2;
                og4.JG = next4;
                fMax = fMax;
                og4.Bzk = fMax;
                list = list;
                og4.SGo = list;
                og4.JG.KZx(og4.pA);
                og4.JG.ZZv(og4.Og);
                og4.JG.ML(og4.KZx);
                og4.JG.JG(og4.ZZv);
                float f21 = f20;
                com.bytedance.sdk.component.adexpress.dynamic.ZZv.Og ogPA = pA(og4, f21);
                i = i3;
                og2.SD.get(i).add(ogPA);
                if (jgML5.PV() == 1) {
                    bzk = bzk3;
                } else if (jgML5.PV() != 2) {
                    bzk = bzk3;
                    bzk.pA += f18 + f17;
                } else {
                    bzk = bzk3;
                }
                f10 = f21;
                bzk2 = bzk;
                it8 = it9;
                strFQ = str5;
                f7 = f16;
                str2 = str6;
                fPA4 = f17;
                omhVar = omhVar2;
            }
            com.bytedance.sdk.component.adexpress.dynamic.ZZv.Bzk bzk4 = bzk2;
            bzk4.pA = f4;
            bzk4.Og += fMax2 + f2;
            og3 = og;
            listABv = listABv;
            fPA = f2;
            str = str4;
            omhVar = omhVar;
        }
        return og3;
    }

    private com.bytedance.sdk.component.adexpress.dynamic.ZZv.Bzk pA(com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jg, Og.KZx kZx, Og.KZx kZx2) {
        float fQI = jg.QI();
        float fQj = jg.Qj();
        float fGag = jg.Gag();
        float fSk = jg.sk();
        boolean zLx = jg.lx();
        boolean zSXO = jg.SXO();
        boolean zFw = jg.fw();
        boolean zGy = jg.gy();
        if (!zLx) {
            if (zSXO) {
                fQI = ((this.ZZv.pA != 0.0f ? Math.min(this.ZZv.pA, kZx.pA) : kZx.pA) - fGag) - kZx2.pA;
            } else {
                fQI = 0.0f;
            }
        }
        if (!zFw) {
            if (zGy) {
                fQj = ((this.ZZv.Og != 0.0f ? this.ZZv.Og : kZx.Og) - fSk) - kZx2.Og;
            } else {
                fQj = 0.0f;
            }
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.ZZv.Bzk(fQI, fQj);
    }

    private com.bytedance.sdk.component.adexpress.dynamic.ZZv.Bzk pA(com.bytedance.sdk.component.adexpress.dynamic.ZZv.Og og, com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jg, float f, float f2) {
        float f3;
        float f4;
        float f5 = og.pA;
        float f6 = og.Og;
        float fQI = jg.QI();
        float fQj = jg.Qj();
        float fGag = jg.Gag();
        float fSk = jg.sk();
        boolean zLx = jg.lx();
        boolean zSXO = jg.SXO();
        boolean zFw = jg.fw();
        boolean zGy = jg.gy();
        String strCFQ = jg.cFQ();
        float f7 = og.KZx;
        float f8 = og.ZZv;
        if (TextUtils.equals(strCFQ, "0")) {
            if (zLx) {
                f5 = og.pA + fQI;
            } else if (zSXO) {
                f5 = ((og.pA + f7) - fGag) - f;
            }
            if (zFw) {
                f4 = og.Og;
                f6 = f4 + fQj;
            } else if (zGy) {
                f3 = og.Og;
                f6 = ((f3 + f8) - fSk) - f2;
            }
        } else if (TextUtils.equals(strCFQ, "1")) {
            f5 = og.pA + ((f7 - f) / 2.0f);
            if (zFw) {
                f4 = og.Og;
                f6 = f4 + fQj;
            } else if (zGy) {
                f3 = og.Og;
                f6 = ((f3 + f8) - fSk) - f2;
            }
        } else if (TextUtils.equals(strCFQ, "2")) {
            f6 = og.Og + ((f8 - f2) / 2.0f);
            if (zLx) {
                f5 = og.pA + fQI;
            } else if (zSXO) {
                f5 = ((og.pA + f7) - fGag) - f;
            }
        } else if (TextUtils.equals(strCFQ, "3")) {
            f5 = og.pA + ((f7 - f) / 2.0f);
            f6 = og.Og + ((f8 - f2) / 2.0f);
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.ZZv.Bzk(f5, f6);
    }
}
