package com.bytedance.sdk.component.JG.pA.pA;

import com.bytedance.sdk.component.JG.pA.omh;
import com.bytedance.sdk.component.JG.pA.pA.Og.SD;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes4.dex */
public class JG implements ZZv {
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA BSW;
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA Bzk;
    private com.bytedance.sdk.component.JG.pA.pA.Og.KZx JG;
    private com.bytedance.sdk.component.JG.pA.pA.Og.pA KZx;
    private SD ML;
    private com.bytedance.sdk.component.JG.pA.pA.Og.ML Og;
    private com.bytedance.sdk.component.JG.pA.pA.Og.JG SD;
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA SGo;
    private Queue<String> Sn;
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA WV;
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA Wx;
    private com.bytedance.sdk.component.JG.pA.pA.Og.Og ZZv;
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA omh;
    ML pA = omh.SD().ZZv();

    @Override // com.bytedance.sdk.component.JG.pA.pA.ZZv
    public void pA(int i, long j) {
    }

    public JG(Queue<String> queue) {
        this.Sn = queue;
        if (com.bytedance.sdk.component.JG.pA.Og.pA.pA()) {
            this.omh = omh.SD().WV();
            this.Og = new com.bytedance.sdk.component.JG.pA.pA.Og.ML(this.omh, queue);
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.ML()) {
            if (omh.SD().SGo() != null) {
                this.SGo = omh.SD().SGo();
            } else {
                this.SGo = omh.SD().Wx();
            }
            this.ZZv = new com.bytedance.sdk.component.JG.pA.pA.Og.Og(this.SGo, queue);
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.Og()) {
            this.Bzk = omh.SD().Wx();
            this.KZx = new com.bytedance.sdk.component.JG.pA.pA.Og.pA(this.Bzk, queue);
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.KZx()) {
            this.BSW = omh.SD().Wx();
            this.ML = new SD(this.BSW, queue);
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.ZZv()) {
            this.WV = omh.SD().Sn();
            this.JG = new com.bytedance.sdk.component.JG.pA.pA.Og.KZx(this.WV, queue);
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.JG()) {
            this.Wx = omh.SD().DX();
            this.SD = new com.bytedance.sdk.component.JG.pA.pA.Og.JG(this.Wx, queue);
        }
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ZZv
    public void pA(com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar, int i) {
        try {
            byte bZZv = pAVar.ZZv();
            byte bML = pAVar.ML();
            if (bZZv == 0 && bML == 1 && com.bytedance.sdk.component.JG.pA.Og.pA.pA()) {
                this.Og.pA(pAVar);
                return;
            }
            if (bZZv == 3 && bML == 2 && com.bytedance.sdk.component.JG.pA.Og.pA.ML()) {
                this.ZZv.pA(pAVar);
                return;
            }
            if (bZZv == 0 && bML == 2 && com.bytedance.sdk.component.JG.pA.Og.pA.Og()) {
                this.KZx.pA(pAVar);
                return;
            }
            if (bZZv == 1 && bML == 2 && com.bytedance.sdk.component.JG.pA.Og.pA.KZx()) {
                this.ML.pA(pAVar);
                return;
            }
            if (bZZv == 1 && bML == 3 && com.bytedance.sdk.component.JG.pA.Og.pA.ZZv()) {
                this.JG.pA(pAVar);
            } else if (bZZv == 2 && bML == 3 && com.bytedance.sdk.component.JG.pA.Og.pA.JG()) {
                this.SD.pA(pAVar);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ZZv
    public void pA(int i, List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list) {
        if (list == null || list.size() == 0 || list.get(0) == null) {
            return;
        }
        com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar = list.get(0);
        byte bML = pAVar.ML();
        byte bZZv = pAVar.ZZv();
        if (bZZv == 0 && bML == 1 && com.bytedance.sdk.component.JG.pA.Og.pA.pA()) {
            this.Og.pA(i, list);
            return;
        }
        if (bZZv == 3 && bML == 2 && com.bytedance.sdk.component.JG.pA.Og.pA.ML()) {
            this.ZZv.pA(i, list);
            return;
        }
        if (bZZv == 0 && bML == 2 && com.bytedance.sdk.component.JG.pA.Og.pA.Og()) {
            this.KZx.pA(i, list);
            return;
        }
        if (bZZv == 1 && bML == 2 && com.bytedance.sdk.component.JG.pA.Og.pA.KZx()) {
            this.ML.pA(i, list);
            return;
        }
        if (bZZv == 1 && bML == 3 && com.bytedance.sdk.component.JG.pA.Og.pA.ZZv()) {
            this.JG.pA(i, list);
        } else if (bZZv == 2 && bML == 3 && com.bytedance.sdk.component.JG.pA.Og.pA.JG()) {
            this.SD.pA(i, list);
        }
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ZZv
    public List<com.bytedance.sdk.component.JG.pA.ZZv.pA> pA(int i, int i2, List<String> list) {
        List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listPA;
        List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listPA2;
        List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listPA3;
        List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listPA4;
        List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listPA5;
        List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listPA6;
        if (com.bytedance.sdk.component.JG.pA.Og.pA.pA() && this.Og.Og(i, i2) && (listPA6 = this.Og.pA(i, i2)) != null && listPA6.size() != 0) {
            com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.XT(), 1);
            return listPA6;
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.ML() && this.ZZv.Og(i, i2) && (listPA5 = this.ZZv.pA(i, i2)) != null && listPA5.size() != 0) {
            return listPA5;
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.Og() && this.KZx.Og(i, i2) && (listPA4 = this.KZx.pA(i, i2)) != null && listPA4.size() != 0) {
            com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.yFO(), 1);
            return listPA4;
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.KZx() && this.ML.Og(i, i2) && (listPA3 = this.ML.pA(i, i2)) != null && listPA3.size() != 0) {
            com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.vZF(), 1);
            return listPA3;
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.ZZv() && this.JG.Og(i, i2) && (listPA2 = this.JG.pA(i, i2)) != null && listPA2.size() != 0) {
            com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.Sd(), 1);
            return listPA2;
        }
        if (!com.bytedance.sdk.component.JG.pA.Og.pA.JG() || !this.SD.Og(i, i2) || (listPA = this.SD.pA(i, i2)) == null || listPA.size() == 0) {
            return null;
        }
        return listPA;
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ZZv
    public boolean pA(int i, boolean z) {
        com.bytedance.sdk.component.JG.pA.pA.Og.JG jg;
        com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar;
        com.bytedance.sdk.component.JG.pA.pA.Og.KZx kZx;
        com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar2;
        SD sd;
        com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar3;
        com.bytedance.sdk.component.JG.pA.pA.Og.pA pAVar4;
        com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar5;
        com.bytedance.sdk.component.JG.pA.pA.Og.Og og;
        com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar6;
        com.bytedance.sdk.component.JG.pA.pA.Og.ML ml;
        com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar7;
        if (com.bytedance.sdk.component.JG.pA.Og.pA.pA() && (ml = this.Og) != null && (pAVar7 = this.omh) != null && ml.Og(i, pAVar7.pA())) {
            return true;
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.ML() && (og = this.ZZv) != null && (pAVar6 = this.SGo) != null && og.Og(i, pAVar6.pA())) {
            return true;
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.Og() && (pAVar4 = this.KZx) != null && (pAVar5 = this.Bzk) != null && pAVar4.Og(i, pAVar5.pA())) {
            return true;
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.KZx() && (sd = this.ML) != null && (pAVar3 = this.BSW) != null && sd.Og(i, pAVar3.pA())) {
            return true;
        }
        if (!com.bytedance.sdk.component.JG.pA.Og.pA.ZZv() || (kZx = this.JG) == null || (pAVar2 = this.WV) == null || !kZx.Og(i, pAVar2.pA())) {
            return com.bytedance.sdk.component.JG.pA.Og.pA.JG() && (jg = this.SD) != null && (pAVar = this.Wx) != null && jg.Og(i, pAVar.pA());
        }
        return true;
    }
}
