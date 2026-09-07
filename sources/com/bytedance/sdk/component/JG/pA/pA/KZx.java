package com.bytedance.sdk.component.JG.pA.pA;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.JG.pA.omh;
import com.bytedance.sdk.component.JG.pA.pA.pA.pA.SD;
import java.util.Iterator;
import java.util.List;
import net.pubnative.lite.sdk.db.DatabaseHelper;

/* JADX INFO: loaded from: classes12.dex */
public class KZx implements ZZv {
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA BSW;
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA Bzk;
    private com.bytedance.sdk.component.JG.pA.pA.pA.pA.ML JG;
    private com.bytedance.sdk.component.JG.pA.pA.pA.pA.Og KZx;
    private com.bytedance.sdk.component.JG.pA.pA.pA.pA.JG ML;
    private com.bytedance.sdk.component.JG.pA.pA.pA.pA.pA Og;
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA SD;
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA SGo;
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA WV;
    private SD ZZv;
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA omh;
    private com.bytedance.sdk.component.JG.pA.pA.pA.pA.ZZv pA;

    public KZx() {
        Context contextJG = omh.SD().JG();
        if (com.bytedance.sdk.component.JG.pA.Og.pA.pA()) {
            this.SD = omh.SD().WV();
            this.pA = new com.bytedance.sdk.component.JG.pA.pA.pA.pA.ZZv(contextJG, this.SD);
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.ML()) {
            if (omh.SD().SGo() != null) {
                this.Bzk = omh.SD().SGo();
            } else {
                this.Bzk = omh.SD().Wx();
            }
            this.KZx = new com.bytedance.sdk.component.JG.pA.pA.pA.pA.Og(contextJG, this.Bzk);
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.Og()) {
            this.omh = omh.SD().Wx();
            this.Og = new com.bytedance.sdk.component.JG.pA.pA.pA.pA.pA(contextJG, this.omh);
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.KZx()) {
            this.SGo = omh.SD().Wx();
            this.ZZv = new SD(contextJG, this.SGo);
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.ZZv()) {
            this.BSW = omh.SD().Sn();
            this.ML = new com.bytedance.sdk.component.JG.pA.pA.pA.pA.JG(contextJG, this.BSW);
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.JG()) {
            this.WV = omh.SD().DX();
            this.JG = new com.bytedance.sdk.component.JG.pA.pA.pA.pA.ML(contextJG, this.WV);
        }
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ZZv
    public void pA(com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar, int i) {
        if (pAVar == null) {
            return;
        }
        try {
            pAVar.Og(System.currentTimeMillis());
            if (pAVar.ZZv() == 0 && pAVar.ML() == 1) {
                if (com.bytedance.sdk.component.JG.pA.Og.pA.pA()) {
                    this.pA.pA(pAVar);
                    return;
                }
                return;
            }
            if (pAVar.ZZv() == 3 && pAVar.ML() == 2) {
                if (com.bytedance.sdk.component.JG.pA.Og.pA.ML()) {
                    this.KZx.pA(pAVar);
                    return;
                }
                return;
            }
            if (pAVar.ZZv() == 0 && pAVar.ML() == 2) {
                if (com.bytedance.sdk.component.JG.pA.Og.pA.Og()) {
                    this.Og.pA(pAVar);
                    return;
                }
                return;
            }
            if (pAVar.ZZv() == 1 && pAVar.ML() == 2) {
                if (com.bytedance.sdk.component.JG.pA.Og.pA.KZx()) {
                    this.ZZv.pA(pAVar);
                }
            } else if (pAVar.ZZv() == 1 && pAVar.ML() == 3) {
                if (com.bytedance.sdk.component.JG.pA.Og.pA.ZZv()) {
                    this.ML.pA(pAVar);
                }
            } else if (pAVar.ZZv() == 2 && pAVar.ML() == 3 && com.bytedance.sdk.component.JG.pA.Og.pA.JG()) {
                this.JG.pA(pAVar);
            }
        } catch (Throwable unused) {
            com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.xy(), 1);
        }
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ZZv
    public void pA(int i, List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list) {
        if (list == null || list.size() == 0 || list.get(0) == null) {
            return;
        }
        com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar = list.get(0);
        if (i == 200 || i == -1) {
            com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.IIF(), list.size());
            if (i != 200) {
                com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.PV(), list.size());
            }
            if (pAVar.ZZv() == 0 && pAVar.ML() == 1) {
                if (com.bytedance.sdk.component.JG.pA.Og.pA.pA()) {
                    this.pA.Og(list);
                    return;
                }
                return;
            }
            if (pAVar.ZZv() == 3 && pAVar.ML() == 2) {
                if (com.bytedance.sdk.component.JG.pA.Og.pA.ML()) {
                    this.KZx.Og(list);
                    return;
                }
                return;
            }
            if (pAVar.ZZv() == 0 && pAVar.ML() == 2) {
                if (com.bytedance.sdk.component.JG.pA.Og.pA.Og()) {
                    this.Og.Og(list);
                    return;
                }
                return;
            }
            if (pAVar.ZZv() == 1 && pAVar.ML() == 2) {
                if (com.bytedance.sdk.component.JG.pA.Og.pA.KZx()) {
                    this.ZZv.Og(list);
                }
            } else if (pAVar.ZZv() == 1 && pAVar.ML() == 3) {
                if (com.bytedance.sdk.component.JG.pA.Og.pA.ZZv()) {
                    this.ML.Og(list);
                }
            } else if (pAVar.ZZv() == 2 && pAVar.ML() == 3 && com.bytedance.sdk.component.JG.pA.Og.pA.JG()) {
                this.JG.Og(list);
            }
        }
    }

    public List<com.bytedance.sdk.component.JG.pA.ZZv.pA> Og(com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar, int i) {
        if (pAVar.ZZv() == 0 && pAVar.ML() == 1 && com.bytedance.sdk.component.JG.pA.Og.pA.pA()) {
            if (this.SD.Og() <= i) {
                return null;
            }
            List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listPA = this.pA.pA(this.SD.Og() - i, DatabaseHelper._ID);
            if (listPA != null && listPA.size() != 0) {
                com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.eG(), 1);
            }
            return listPA;
        }
        if (pAVar.ZZv() == 3 && pAVar.ML() == 2 && com.bytedance.sdk.component.JG.pA.Og.pA.ML()) {
            if (this.Bzk.Og() > i) {
                return this.KZx.pA(this.Bzk.Og() - i, DatabaseHelper._ID);
            }
        } else if (pAVar.ZZv() == 0 && pAVar.ML() == 2 && com.bytedance.sdk.component.JG.pA.Og.pA.Og()) {
            if (this.omh.Og() > i) {
                List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listPA2 = this.Og.pA(this.omh.Og() - i, DatabaseHelper._ID);
                if (listPA2 != null && listPA2.size() != 0) {
                    com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.roi(), 1);
                }
                return listPA2;
            }
        } else if (pAVar.ZZv() == 1 && pAVar.ML() == 2 && com.bytedance.sdk.component.JG.pA.Og.pA.KZx()) {
            if (this.SGo.Og() > i) {
                List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listPA3 = this.ZZv.pA(this.SGo.Og() - i, DatabaseHelper._ID);
                if (listPA3 != null && listPA3.size() != 0) {
                    com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.Mc(), 1);
                }
                return listPA3;
            }
        } else if (pAVar.ZZv() == 1 && pAVar.ML() == 3 && com.bytedance.sdk.component.JG.pA.Og.pA.ZZv()) {
            if (this.BSW.Og() > i) {
                List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listPA4 = this.ML.pA(this.BSW.Og() - i, DatabaseHelper._ID);
                if (listPA4 != null && listPA4.size() != 0) {
                    com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.IG(), 1);
                }
                return listPA4;
            }
        } else if (pAVar.ZZv() == 2 && pAVar.ML() == 3 && com.bytedance.sdk.component.JG.pA.Og.pA.JG() && this.WV.Og() > i) {
            return this.JG.pA(this.WV.Og() - i, DatabaseHelper._ID);
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ZZv
    public List<com.bytedance.sdk.component.JG.pA.ZZv.pA> pA(int i, int i2, List<String> list) {
        if (com.bytedance.sdk.component.JG.pA.Og.pA.pA()) {
            List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listPA = this.pA.pA(DatabaseHelper._ID);
            if (pA(listPA, list)) {
                listPA.size();
                com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.BF(), 1);
                return listPA;
            }
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.ML()) {
            List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listPA2 = this.KZx.pA(DatabaseHelper._ID);
            if (pA(listPA2, list)) {
                listPA2.size();
                return listPA2;
            }
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.Og()) {
            List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listPA3 = this.Og.pA(DatabaseHelper._ID);
            if (pA(listPA3, list)) {
                listPA3.size();
                com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.WQf(), 1);
                return listPA3;
            }
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.KZx()) {
            List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listOg = this.ZZv.Og(DatabaseHelper._ID);
            if (pA(listOg, list)) {
                listOg.size();
                com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.TV(), 1);
                return listOg;
            }
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.ZZv()) {
            List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listOg2 = this.ML.Og(DatabaseHelper._ID);
            if (pA(listOg2, list)) {
                listOg2.size();
                com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.du(), 1);
                return listOg2;
            }
        }
        if (!com.bytedance.sdk.component.JG.pA.Og.pA.JG()) {
            return null;
        }
        List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listOg3 = this.JG.Og(DatabaseHelper._ID);
        if (!pA(listOg3, list)) {
            return null;
        }
        listOg3.size();
        return listOg3;
    }

    private boolean pA(List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list, List<String> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            try {
                Iterator<com.bytedance.sdk.component.JG.pA.ZZv.pA> it = list.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.JG.pA.ZZv.pA next = it.next();
                    if (next != null) {
                        String strKZx = next.KZx();
                        if (!TextUtils.isEmpty(strKZx) && list2.contains(strKZx)) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return (list == null || list.isEmpty()) ? false : true;
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ZZv
    public boolean pA(int i, boolean z) {
        com.bytedance.sdk.component.JG.pA.pA.pA.pA.ML ml;
        com.bytedance.sdk.component.JG.pA.pA.pA.pA.JG jg;
        SD sd;
        com.bytedance.sdk.component.JG.pA.pA.pA.pA.pA pAVar;
        com.bytedance.sdk.component.JG.pA.pA.pA.pA.Og og;
        com.bytedance.sdk.component.JG.pA.pA.pA.pA.ZZv zZv;
        if (com.bytedance.sdk.component.JG.pA.Og.pA.pA() && (zZv = this.pA) != null && zZv.pA(i)) {
            com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.Sn(), 1);
            return true;
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.ML() && (og = this.KZx) != null && og.pA(i)) {
            return true;
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.Og() && (pAVar = this.Og) != null && pAVar.pA(i)) {
            com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.DX(), 1);
            return true;
        }
        if (com.bytedance.sdk.component.JG.pA.Og.pA.KZx() && (sd = this.ZZv) != null && sd.pA(i)) {
            com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.oX(), 1);
            return true;
        }
        if (!com.bytedance.sdk.component.JG.pA.Og.pA.ZZv() || (jg = this.ML) == null || !jg.pA(i)) {
            return com.bytedance.sdk.component.JG.pA.Og.pA.JG() && (ml = this.JG) != null && ml.pA(i);
        }
        com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.aBv(), 1);
        return true;
    }

    @Override // com.bytedance.sdk.component.JG.pA.pA.ZZv
    public void pA(int i, long j) {
        com.bytedance.sdk.component.JG.pA.pA.pA.pA.ZZv zZv = this.pA;
        if (zZv != null) {
            zZv.pA(i, j);
        }
        com.bytedance.sdk.component.JG.pA.pA.pA.pA.Og og = this.KZx;
        if (og != null) {
            og.pA(i, j);
        }
        com.bytedance.sdk.component.JG.pA.pA.pA.pA.pA pAVar = this.Og;
        if (pAVar != null) {
            pAVar.pA(i, j);
        }
        SD sd = this.ZZv;
        if (sd != null) {
            sd.pA(i, j);
        }
        com.bytedance.sdk.component.JG.pA.pA.pA.pA.JG jg = this.ML;
        if (jg != null) {
            jg.pA(i, j);
        }
        com.bytedance.sdk.component.JG.pA.pA.pA.pA.ML ml = this.JG;
        if (ml != null) {
            ml.pA(i, j);
        }
    }
}
