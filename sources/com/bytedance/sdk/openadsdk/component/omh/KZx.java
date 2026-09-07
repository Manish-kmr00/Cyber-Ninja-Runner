package com.bytedance.sdk.openadsdk.component.omh;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.DX;
import com.bytedance.sdk.openadsdk.core.model.yFO;

/* JADX INFO: loaded from: classes4.dex */
public class KZx implements com.bytedance.sdk.openadsdk.core.Og.pA.InterfaceC0231pA {
    private yFO KZx;
    private boolean ML = false;
    private FrameLayout Og;
    private Og ZZv;
    private Context pA;

    public KZx(Context context) {
        this.pA = context.getApplicationContext();
    }

    public void pA(FrameLayout frameLayout, yFO yfo) {
        this.Og = frameLayout;
        this.KZx = yfo;
        this.ZZv = new Og(this.pA, this.Og, this.KZx);
    }

    public boolean pA() {
        com.bytedance.sdk.openadsdk.core.Wx.pA.Og ogPA = yFO.pA(CacheDirFactory.getICacheDir(0).Og(), this.KZx);
        ogPA.Og(this.KZx.nCO());
        ogPA.pA(this.Og.getWidth());
        ogPA.Og(this.Og.getHeight());
        ogPA.KZx(this.KZx.tM());
        ogPA.pA(0L);
        ogPA.pA(true);
        return this.ZZv.pA(ogPA);
    }

    public void pA(boolean z) {
        this.ML = z;
    }

    public boolean Og() {
        return this.ML;
    }

    public boolean KZx() {
        Og og = this.ZZv;
        return (og == null || og.WV() == null || !this.ZZv.WV().Og()) ? false : true;
    }

    public boolean ZZv() {
        Og og = this.ZZv;
        return (og == null || og.WV() == null || !this.ZZv.WV().JG()) ? false : true;
    }

    public boolean ML() {
        Og og = this.ZZv;
        return (og == null || og.WV() == null || !this.ZZv.WV().SD()) ? false : true;
    }

    public boolean JG() {
        Og og = this.ZZv;
        return og != null && og.oX();
    }

    public void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA pAVar) {
        Og og = this.ZZv;
        if (og != null) {
            og.pA(pAVar);
        }
    }

    public boolean pA(FrameLayout frameLayout, com.bytedance.sdk.openadsdk.component.pA pAVar, yFO yfo) {
        pA(frameLayout, yfo);
        pA(pAVar);
        try {
            return pA();
        } catch (Throwable th) {
            WV.pA("TTAppOpenVideoManager", "open_ad", "ttAppOpenAd playVideo error: " + th.getMessage());
            return false;
        }
    }

    public void SD() {
        try {
            if (ZZv()) {
                this.ZZv.pA();
            }
        } catch (Throwable th) {
            WV.pA("TTAppOpenVideoManager", "open_ad", "AppOpenVideoManager onPause throw Exception :" + th.getMessage());
        }
    }

    public void omh() {
        try {
            if (ML()) {
                SGo();
            }
        } catch (Throwable th) {
            WV.pA("TTAppOpenVideoManager", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public void Bzk() {
        Og og = this.ZZv;
        if (og == null) {
            return;
        }
        og.KZx();
        this.ZZv = null;
    }

    public void SGo() {
        Og og = this.ZZv;
        if (og != null) {
            og.Og();
        }
    }

    public void BSW() {
        Og og = this.ZZv;
        if (og == null) {
            return;
        }
        this.pA = null;
        og.KZx();
        this.ZZv = null;
    }

    public long WV() {
        Og og = this.ZZv;
        if (og != null) {
            return og.ML();
        }
        return 0L;
    }

    public long Wx() {
        Og og = this.ZZv;
        if (og != null) {
            return og.JG();
        }
        return 0L;
    }

    public long Sn() {
        Og og = this.ZZv;
        if (og != null) {
            return og.omh() + this.ZZv.JG();
        }
        return 0L;
    }

    public void pA(int i) {
        if (this.ZZv != null) {
            DX.pA pAVar = new DX.pA();
            pAVar.pA(WV());
            pAVar.KZx(Sn());
            pAVar.Og(Wx());
            pAVar.KZx(i);
            pAVar.ZZv(this.ZZv.SD());
            this.ZZv.pA(pAVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Og.pA.InterfaceC0231pA
    public long getVideoProgress() {
        return WV();
    }
}
