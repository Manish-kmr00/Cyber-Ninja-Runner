package com.bytedance.sdk.openadsdk.component.reward.pA;

import android.webkit.DownloadListener;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class omh {
    public static int KZx = 2;
    public static int Og = 1;
    public static int pA;
    private Bzk JG;
    private SGo ML;
    private final boolean ZZv;

    public omh(pA pAVar, com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        boolean zSRe = yfo.SRe();
        this.ZZv = zSRe;
        if (zSRe) {
            this.ML = WQf.JG(yfo) ? new SD(pAVar) : new SGo(pAVar);
        } else {
            this.JG = new Bzk(pAVar);
        }
    }

    public boolean pA() {
        Bzk bzk = this.JG;
        return bzk != null && bzk.aBv();
    }

    public void pA(int i) {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.Og(i);
        }
    }

    public float Og() {
        Bzk bzk = this.JG;
        if (bzk != null) {
            return bzk.SGo();
        }
        return 0.0f;
    }

    public boolean KZx() {
        Bzk bzk = this.JG;
        if (bzk != null) {
            return bzk.oX();
        }
        return true;
    }

    public void pA(boolean z) {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.Og(z);
        }
    }

    public com.bytedance.sdk.openadsdk.yFO.omh ZZv() {
        Bzk bzk = this.JG;
        if (bzk != null) {
            return bzk.XT();
        }
        return null;
    }

    public void ML() {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.JG();
        }
    }

    public void JG() {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.SD();
        }
    }

    public boolean SD() {
        Bzk bzk = this.JG;
        if (bzk != null) {
            return bzk.DX();
        }
        return false;
    }

    public int Og(int i) {
        Bzk bzk = this.JG;
        if (bzk != null) {
            return bzk.ZZv(i);
        }
        return 0;
    }

    public void omh() {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.Og();
        }
    }

    public void pA(JSONObject jSONObject) {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.pA(jSONObject);
        }
    }

    public void Og(boolean z) {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.JG(z);
        }
    }

    public void pA(int i, com.bytedance.sdk.openadsdk.core.model.yFO yfo, boolean z) {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.pA(i, yfo, z);
        }
    }

    public long Bzk() {
        Bzk bzk = this.JG;
        if (bzk != null) {
            return bzk.Bzk();
        }
        return 0L;
    }

    public void SGo() {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.ML();
        }
    }

    public void KZx(int i) {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.KZx(i);
        }
    }

    public void pA(DownloadListener downloadListener) {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.pA(downloadListener);
        }
    }

    public void KZx(boolean z) {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.pA(z);
        }
    }

    public com.bytedance.sdk.openadsdk.WV.ZZv BSW() {
        Bzk bzk = this.JG;
        if (bzk != null) {
            return bzk.Sn();
        }
        return null;
    }

    public void pA(String str) {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.KZx(str);
        }
    }

    public void pA(int i, String str, String str2) {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.pA(i, str, str2);
        }
    }

    public void pA(boolean z, String str, int i) {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.pA(z, str, i);
        }
    }

    public void ZZv(boolean z) {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.ZZv(z);
        }
    }

    public void ML(boolean z) {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.ML(z);
        }
    }

    public void Og(String str) {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.Og(str);
        }
    }

    public void WV() {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.ZZv();
        }
    }

    public void KZx(String str) {
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.pA(str);
        }
    }

    public boolean ZZv(int i) {
        if (this.ZZv) {
            SGo sGo = this.ML;
            if (sGo != null) {
                return sGo.Bzk();
            }
        } else {
            Bzk bzk = this.JG;
            if (bzk != null && bzk.Bzk() - this.JG.SGo() >= i) {
                return true;
            }
        }
        return false;
    }

    public void Wx() {
        if (this.ZZv) {
            SGo sGo = this.ML;
            if (sGo != null) {
                sGo.ZZv();
                return;
            }
            return;
        }
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.BSW();
        }
    }

    public void Sn() {
        if (this.ZZv) {
            SGo sGo = this.ML;
            if (sGo != null) {
                sGo.omh();
                return;
            }
            return;
        }
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.Wx();
        }
    }

    public void ML(int i) {
        if (this.ZZv) {
            SGo sGo = this.ML;
            if (sGo != null) {
                sGo.pA(i);
                return;
            }
            return;
        }
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.pA(i);
        }
    }

    public void JG(int i) {
        if (this.ZZv) {
            SGo sGo = this.ML;
            if (sGo != null) {
                sGo.Og(i);
                return;
            }
            return;
        }
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.JG(i);
        }
    }

    public void pA(com.bytedance.sdk.openadsdk.core.Og.ML ml) {
        if (this.ZZv) {
            SGo sGo = this.ML;
            if (sGo != null) {
                sGo.pA(ml);
                return;
            }
            return;
        }
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.pA(ml);
        }
    }

    public void DX() {
        if (this.ZZv) {
            SGo sGo = this.ML;
            if (sGo != null) {
                sGo.pA();
                return;
            }
            return;
        }
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.pA();
        }
    }

    public void oX() {
        if (this.ZZv) {
            SGo sGo = this.ML;
            if (sGo != null) {
                sGo.ML();
                return;
            }
            return;
        }
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.WV();
        }
    }

    public void SD(int i) {
        SGo sGo;
        if (this.ZZv && i != KZx && (sGo = this.ML) != null) {
            sGo.JG();
            return;
        }
        Bzk bzk = this.JG;
        if (bzk == null || i == Og) {
            return;
        }
        bzk.KZx();
    }

    public void pA(com.bytedance.sdk.openadsdk.WV.ML ml, boolean z) {
        if (this.ZZv) {
            SGo sGo = this.ML;
            if (sGo != null) {
                sGo.Og(z);
                return;
            }
            return;
        }
        Bzk bzk = this.JG;
        if (bzk != null) {
            bzk.pA(ml, z);
        }
    }

    public boolean omh(int i) {
        if (this.ZZv && i == Og) {
            SGo sGo = this.ML;
            if (sGo != null) {
                return sGo.SGo();
            }
            return false;
        }
        Bzk bzk = this.JG;
        if (bzk != null) {
            return bzk.omh();
        }
        return false;
    }

    public void aBv() {
        SGo sGo = this.ML;
        if (sGo != null) {
            sGo.BSW();
        }
    }

    public void JG(boolean z) {
        SGo sGo = this.ML;
        if (sGo != null) {
            sGo.KZx(z);
        }
    }

    public void XT() {
        SGo sGo = this.ML;
        if (sGo != null) {
            sGo.KZx();
        }
    }
}
