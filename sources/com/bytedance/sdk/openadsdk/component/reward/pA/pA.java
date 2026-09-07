package com.bytedance.sdk.openadsdk.component.reward.pA;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import com.bytedance.sdk.component.utils.TV;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class pA {
    public final aBv BF;
    public final TV Bf;
    public final com.bytedance.sdk.openadsdk.component.reward.view.SD CIG;
    public final com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og FQ;
    private long Gag;
    public final Context Gx;
    public final boolean HSv;
    public final KZx IG;
    public int IIF;
    public boolean Itl;
    public String JBA;
    public final int JG;
    public final boolean KZx;
    public final String ML;
    public final JG Mc;
    public final com.bytedance.sdk.openadsdk.core.model.yFO Og;
    public boolean PV;
    private long QI;
    public com.bytedance.sdk.openadsdk.activity.JG RS;
    public final boolean SD;
    public final Activity SzT;
    public final omh TV;
    public final com.bytedance.sdk.openadsdk.component.reward.view.SGo Vgu;
    public final ZZv WQf;
    public com.bytedance.sdk.openadsdk.utils.WV Wo;
    public final boolean ZZv;
    public boolean agB;
    public boolean bU;
    public boolean cFQ;
    public float dC;
    public int dmv;
    public final com.bytedance.sdk.openadsdk.component.reward.view.omh du;
    public final WV eG;
    public boolean fJy;
    public com.bytedance.sdk.openadsdk.common.Wx fw;
    public final ML gbA;
    public boolean gy;
    public com.bytedance.sdk.openadsdk.WV.omh lT;
    public boolean lx;
    public com.bytedance.sdk.openadsdk.component.reward.Og.Og nCO;
    public final int pA;
    public final Sn qmB;
    public final XT rB;
    public final BSW roi;
    public com.bytedance.sdk.openadsdk.component.reward.top.KZx tM;
    public int vA;
    public final DX xy;
    public int omh = 0;
    public int Bzk = 0;
    public final AtomicBoolean SGo = new AtomicBoolean(false);
    public final AtomicBoolean BSW = new AtomicBoolean(false);
    public final AtomicBoolean WV = new AtomicBoolean(false);
    public final AtomicBoolean Wx = new AtomicBoolean(false);
    public final AtomicBoolean Sn = new AtomicBoolean(false);
    public final AtomicBoolean DX = new AtomicBoolean(false);
    public final AtomicBoolean oX = new AtomicBoolean(false);
    public final AtomicBoolean aBv = new AtomicBoolean(false);
    public final AtomicBoolean XT = new AtomicBoolean(false);
    public final AtomicBoolean yFO = new AtomicBoolean(false);
    public final AtomicBoolean vZF = new AtomicBoolean(false);
    public final AtomicBoolean Sd = new AtomicBoolean(false);
    public final AtomicBoolean TX = new AtomicBoolean(false);
    public boolean fN = false;
    public int YkC = 1;
    public long SXO = 0;

    public pA(Activity activity, TV tv, com.bytedance.sdk.openadsdk.core.model.yFO yfo, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og og, int i) {
        com.bytedance.sdk.openadsdk.component.reward.view.SGo sGo;
        this.SzT = activity;
        this.FQ = og;
        Context contextPA = com.bytedance.sdk.openadsdk.core.aBv.pA();
        this.Gx = contextPA;
        this.Og = yfo;
        this.pA = i;
        this.HSv = i == 0 || i == 2;
        this.bU = i == 0 || i == 1;
        this.Bf = tv;
        boolean z = yfo.rB().getDurationSlotType() == 7;
        this.ZZv = z;
        this.ML = z ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.gy = yfo.pA();
        this.SD = com.bytedance.sdk.openadsdk.core.model.aBv.SGo(yfo);
        int iWf = yfo.Wf();
        this.JG = iWf;
        this.agB = com.bytedance.sdk.openadsdk.core.aBv.ZZv().aBv(String.valueOf(iWf));
        this.KZx = com.bytedance.sdk.openadsdk.core.settings.oX.vkV().Sn(String.valueOf(iWf));
        this.eG = i == 2 ? new Wx(this) : new WV(this);
        if (i == 2) {
            sGo = new com.bytedance.sdk.openadsdk.component.reward.view.BSW(this);
        } else {
            sGo = yfo.pA() ? new com.bytedance.sdk.openadsdk.component.reward.view.SGo(this) : new com.bytedance.sdk.openadsdk.component.reward.view.Bzk(this);
        }
        this.Vgu = sGo;
        this.CIG = new com.bytedance.sdk.openadsdk.component.reward.view.SD(this);
        this.BF = new aBv(this);
        this.WQf = new ZZv(this);
        this.TV = new omh(this, yfo);
        this.du = new com.bytedance.sdk.openadsdk.component.reward.view.omh(this);
        this.rB = new XT(this);
        this.xy = new DX(this);
        this.qmB = new Sn(this);
        this.gbA = new ML(this);
        this.roi = new BSW(this);
        this.Mc = new JG(this);
        this.IG = new KZx(this);
        this.lT = new com.bytedance.sdk.openadsdk.WV.omh(contextPA);
        this.Wo = com.bytedance.sdk.openadsdk.utils.SD.pA(activity, new com.bytedance.sdk.openadsdk.utils.SD.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.pA.1
            @Override // com.bytedance.sdk.openadsdk.utils.SD.pA
            public View pA() {
                if (pA.this.Vgu != null) {
                    return pA.this.Vgu.SGo();
                }
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.utils.SD.pA
            public void Og() {
                if (pA.this.qmB != null) {
                    pA.this.qmB.JG();
                }
            }
        });
    }

    public void pA(boolean z) {
        this.cFQ = z;
        this.qmB.ZZv(z);
    }

    public void pA() {
        this.QI = SystemClock.elapsedRealtime();
    }

    public void Og() {
        if (this.QI <= 0) {
            this.QI = SystemClock.elapsedRealtime();
        }
        this.Gag += SystemClock.elapsedRealtime() - this.QI;
    }

    public long KZx() {
        return this.Gag + (SystemClock.elapsedRealtime() - this.QI);
    }
}
