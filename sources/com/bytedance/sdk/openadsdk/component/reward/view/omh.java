package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.model.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.omh.Sn;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class omh {
    private boolean BSW;
    private Og Bzk;
    private final Activity JG;
    Handler Og;
    private final yFO SD;
    private final com.bytedance.sdk.openadsdk.component.reward.pA.pA SGo;
    private final String omh;
    com.bytedance.sdk.openadsdk.XT.pA.pA.JG pA;
    boolean KZx = false;
    boolean ZZv = false;
    boolean ML = false;

    public omh(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        this.SGo = pAVar;
        this.JG = pAVar.SzT;
        this.SD = pAVar.Og;
        this.omh = pAVar.ML;
    }

    public void pA(AdSlot adSlot, aBv abv) {
        if (this.ML) {
            return;
        }
        this.ML = true;
        Og og = new Og(this.SGo, adSlot, this.omh);
        this.Bzk = og;
        abv.pA(og, og.getVideoFrameLayout());
    }

    public Og pA() {
        return this.Bzk;
    }

    public FrameLayout Og() {
        Og og = this.Bzk;
        if (og == null) {
            return null;
        }
        FrameLayout videoFrameLayout = og.getVideoFrameLayout();
        if (this.Bzk.Wx()) {
            WV();
        }
        return videoFrameLayout;
    }

    public boolean KZx() {
        return this.KZx;
    }

    public void pA(boolean z) {
        this.KZx = z;
    }

    public boolean ZZv() {
        return this.ZZv;
    }

    public void Og(boolean z) {
        this.ZZv = z;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.omh.Bzk bzk, com.bytedance.sdk.openadsdk.core.omh.omh omhVar) {
        yFO yfo;
        if (this.Bzk == null || (yfo = this.SD) == null) {
            return;
        }
        this.pA = pA(yfo);
        bzk.pA(this.Bzk);
        bzk.pA(this.pA);
        this.Bzk.setClickListener(bzk);
        omhVar.pA((View) this.Bzk);
        omhVar.pA(this.pA);
        this.Bzk.setClickCreativeListener(omhVar);
    }

    private com.bytedance.sdk.openadsdk.XT.pA.pA.JG pA(yFO yfo) {
        if (yfo.JBA() == 4) {
            return com.bytedance.sdk.openadsdk.XT.pA.pA.SD.pA(this.JG, yfo, this.omh);
        }
        return null;
    }

    public void pA(Sn sn) {
        Og og = this.Bzk;
        if (og == null) {
            return;
        }
        og.setExpressVideoListenerProxy(sn);
    }

    public void pA(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
        Og og = this.Bzk;
        if (og == null) {
            return;
        }
        og.setExpressInteractionListener(pAGExpressAdWrapperListener);
    }

    public Handler ML() {
        if (this.Og == null) {
            this.Og = new Handler(Looper.getMainLooper());
        }
        return this.Og;
    }

    public void JG() {
        if (this.BSW) {
            return;
        }
        this.BSW = true;
        Og og = this.Bzk;
        if (og != null) {
            og.BSW();
        }
        Handler handler = this.Og;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void SD() {
        Og og = this.Bzk;
        if (og != null) {
            og.SGo();
        }
    }

    public boolean omh() {
        Og og = this.Bzk;
        if (og == null) {
            return false;
        }
        return og.Wx();
    }

    public int Bzk() {
        Og og = this.Bzk;
        if (og != null) {
            return og.getDynamicShowType();
        }
        return 0;
    }

    public JSONObject pA(JSONObject jSONObject) {
        Og og = this.Bzk;
        if (og != null) {
            return og.pA(jSONObject, this.SGo.Og);
        }
        return null;
    }

    public void SGo() {
        Og og = this.Bzk;
        if (og == null) {
            return;
        }
        og.omh();
    }

    public void BSW() {
        Og og = this.Bzk;
        if (og == null) {
            return;
        }
        og.Bzk();
        this.Bzk.SGo();
    }

    public void WV() {
        if (yFO.ML(this.SD) && this.SD.Mc() == 3 && this.SD.IG() == 0) {
            try {
                if (this.SD.rtW() == 1) {
                    int iKZx = Vgu.KZx(com.bytedance.sdk.openadsdk.core.aBv.pA(), 90.0f);
                    FrameLayout frameLayout = (FrameLayout) this.Bzk.getBackupContainerBackgroundView();
                    if (frameLayout != null) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                        layoutParams.bottomMargin = iKZx;
                        frameLayout.setLayoutParams(layoutParams);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void pA(int i, boolean z) {
        Og og = this.Bzk;
        if (og != null) {
            og.pA(i, z, false);
        }
    }

    public void pA(int i, String str) {
        Og og = this.Bzk;
        if (og != null) {
            og.Og(i, str);
        }
    }
}
