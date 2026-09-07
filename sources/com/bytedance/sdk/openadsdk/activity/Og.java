package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.WV.omh;
import com.bytedance.sdk.openadsdk.Wx.BSW;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.vZF;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.settings.oX;
import com.bytedance.sdk.openadsdk.utils.SD;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.WV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class Og {
    private static com.bytedance.sdk.openadsdk.pA.KZx.Og KZx;
    private static com.bytedance.sdk.openadsdk.pA.ML.pA Og;
    private boolean BF;
    private Activity BSW;
    private com.bytedance.sdk.openadsdk.pA.KZx.Og Bzk;
    private com.bytedance.sdk.openadsdk.activity.KZx DX;
    private final yFO ML;
    private final omh SD;
    private boolean SGo;
    private com.bytedance.sdk.openadsdk.component.reward.top.KZx Sd;
    private com.bytedance.sdk.openadsdk.core.ML.KZx Sn;
    private int TV;
    private AbstractC0221Og TX;
    private boolean WQf;
    private JG WV;
    private int Wx;
    private int XT;
    private com.bytedance.sdk.openadsdk.core.ML.omh aBv;
    private Runnable du;
    private com.bytedance.sdk.openadsdk.core.ML.KZx oX;
    private com.bytedance.sdk.openadsdk.pA.ML.pA omh;
    public WV pA;
    private BSW vZF;
    private Bundle yFO;
    private final List<JG> ZZv = new ArrayList();
    private final Bundle JG = new Bundle();

    public Og(Activity activity, yFO yfo) {
        com.bytedance.sdk.openadsdk.core.model.pA pAVarXoO;
        List<yFO> listZZv;
        this.ML = yfo;
        this.BSW = activity;
        this.SD = new omh(activity.getApplicationContext());
        int i = 0;
        if ((yfo instanceof vZF) && (pAVarXoO = ((vZF) yfo).xoO()) != null) {
            boolean zWV = pAVarXoO.WV();
            this.SGo = zWV;
            if (zWV) {
                if (!oX.vkV().Lm()) {
                    this.SGo = false;
                }
                if (this.SGo && (listZZv = pAVarXoO.ZZv()) != null) {
                    Iterator<yFO> it = listZZv.iterator();
                    while (it.hasNext()) {
                        this.ZZv.add(pA(this, it.next(), i));
                        this.TV++;
                        i++;
                    }
                }
            }
        }
        if (this.ZZv.isEmpty() && !WQf.KZx(yfo)) {
            this.ZZv.add(pA(this, yfo, i));
            i++;
        }
        if (oX.vkV().Sn(String.valueOf(yfo.Wf())) || WQf.KZx(yfo)) {
            this.ZZv.add(new com.bytedance.sdk.openadsdk.activity.KZx(this, yfo, i));
        } else if (pA()) {
            this.pA = SD.pA(activity, new SD.pA() { // from class: com.bytedance.sdk.openadsdk.activity.Og.1
                @Override // com.bytedance.sdk.openadsdk.utils.SD.pA
                public View pA() {
                    if (Og.this.Sd != null) {
                        return Og.this.Sd.getCloseButton();
                    }
                    return null;
                }

                @Override // com.bytedance.sdk.openadsdk.utils.SD.pA
                public void Og() {
                    if (Og.this.Sd != null) {
                        Og.this.Sd.setSkipInvisiable();
                    }
                }
            });
        }
    }

    private static JG pA(Og og, yFO yfo, int i) {
        boolean zKK = yfo.kK();
        AdSlot adSlotRB = yfo.rB();
        if (adSlotRB != null) {
            zKK = adSlotRB.getDurationSlotType() == 7;
        }
        if (zKK) {
            return new com.bytedance.sdk.openadsdk.activity.ML(og, yfo, i);
        }
        return new com.bytedance.sdk.openadsdk.activity.ZZv(og, yfo, i);
    }

    public boolean pA() {
        return this.SGo;
    }

    public void pA(TTAdActivity tTAdActivity, Bundle bundle, com.bytedance.sdk.openadsdk.pA.ML.pA pAVar, com.bytedance.sdk.openadsdk.pA.KZx.Og og) {
        this.yFO = bundle;
        this.XT = 1;
        this.Sn = new com.bytedance.sdk.openadsdk.core.ML.KZx(tTAdActivity);
        if (Build.VERSION.SDK_INT >= 35) {
            this.Sn.setFitsSystemWindows(true);
        }
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx = new com.bytedance.sdk.openadsdk.core.ML.KZx(tTAdActivity);
        this.oX = kZx;
        this.Sn.addView(kZx, new FrameLayout.LayoutParams(-1, -1));
        if (this.SGo) {
            this.vZF = new BSW(tTAdActivity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, Vgu.KZx(tTAdActivity, 2.0f));
            layoutParams.gravity = 80;
            this.Sn.addView(this.vZF, layoutParams);
            com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(tTAdActivity);
            this.aBv = omhVar;
            omhVar.setTextColor(-1);
            this.aBv.setTextSize(15.0f);
            this.aBv.setShadowLayer(1.0f, 0.0f, 1.0f, ViewCompat.MEASURED_STATE_MASK);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = Vgu.KZx(tTAdActivity, 60.0f);
            layoutParams2.rightMargin = Vgu.KZx(tTAdActivity, 16.0f);
            layoutParams2.gravity = 8388661;
            this.Sn.addView(this.aBv, layoutParams2);
            com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx2 = new com.bytedance.sdk.openadsdk.component.reward.top.KZx(tTAdActivity);
            this.Sd = kZx2;
            this.Sn.addView(kZx2, new FrameLayout.LayoutParams(-1, -2));
            this.Sd.pA(this.ML);
            this.Sd.setShowDislike(true);
        }
        this.omh = pAVar;
        this.Bzk = og;
        if (pAVar == null && bundle != null) {
            this.omh = Og;
            Og = null;
        }
        if (og == null && bundle != null) {
            this.Bzk = KZx;
            KZx = null;
        }
        KZx(null, new ML(1, null));
    }

    private void KZx(JG jg, ML ml) {
        if (this.BSW == null) {
            return;
        }
        Og();
        if (jg == null) {
            JG jg2 = this.WV;
            int i = jg2 != null ? jg2.Bzk + 1 : 0;
            if (i < this.ZZv.size()) {
                jg = this.ZZv.get(i);
            }
            if (jg == null) {
                pA(this.WV);
                return;
            }
        }
        JG jg3 = this.WV;
        if (jg3 != null) {
            if (jg3 == jg) {
                return;
            }
            jg3.ML(this.BSW);
            this.WV.KZx(this.BSW);
            View viewPA = this.WV.pA();
            if (viewPA != null) {
                this.oX.removeView(viewPA);
            }
            this.WV.DX();
            this.WV.SGo = false;
        }
        jg.SGo = true;
        jg.pA(this.BSW, ml);
        View viewPA2 = jg.pA();
        if (viewPA2 != null) {
            ViewParent parent = viewPA2.getParent();
            if (parent != null) {
                if (parent == this.oX) {
                    viewPA2.setVisibility(0);
                } else if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(viewPA2);
                }
            }
            if (viewPA2.getParent() == null) {
                this.oX.addView(viewPA2, new ViewGroup.LayoutParams(-1, -1));
            }
            if (this.BSW.getWindow().getContainer() == null) {
                this.BSW.setContentView(this.Sn);
            }
        }
        JG jg4 = this.WV;
        this.WV = jg;
        pA(jg4, jg, ml);
    }

    private void pA(JG jg, JG jg2, ML ml) {
        if (this.SGo) {
            boolean z = jg2 instanceof com.bytedance.sdk.openadsdk.activity.pA;
            if (z) {
                this.Wx++;
                pA(0.0f);
                if (this.TX == null) {
                    if (jg2 instanceof com.bytedance.sdk.openadsdk.activity.ZZv) {
                        this.TX = new pA(this, this.ML, this.Sd);
                    } else {
                        this.TX = new ZZv(this, this.ML, this.Sd);
                    }
                }
                int iJG = 0;
                for (int i = jg2.Bzk; i < this.ZZv.size(); i++) {
                    JG jg3 = this.ZZv.get(i);
                    if (jg3 instanceof com.bytedance.sdk.openadsdk.activity.KZx) {
                        break;
                    }
                    com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogBf = jg3.omh.Bf();
                    iJG = ogBf != null ? (int) (((double) iJG) + ogBf.JG()) : (int) (((long) iJG) + 10);
                }
                this.TX.pA(iJG);
                WV wv = this.pA;
                if (wv != null && jg == null) {
                    wv.pA(iJG * 1000);
                }
            } else if (jg2 instanceof com.bytedance.sdk.openadsdk.activity.KZx) {
                BSW bsw = this.vZF;
                if (bsw != null) {
                    Vgu.SD(bsw);
                    this.vZF = null;
                }
                com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx = this.Sd;
                if (kZx != null) {
                    Vgu.SD(kZx);
                    Vgu.SD(this.Sd.getITopLayout());
                    this.Sd = null;
                }
                AbstractC0221Og abstractC0221Og = this.TX;
                if (abstractC0221Og != null) {
                    abstractC0221Og.KZx();
                }
                if (jg instanceof com.bytedance.sdk.openadsdk.activity.ML) {
                    ((com.bytedance.sdk.openadsdk.activity.ML) jg).BF();
                }
                WV wv2 = this.pA;
                if (wv2 != null) {
                    wv2.KZx();
                }
            }
            if (z) {
                this.aBv.setText(this.BSW.getString(com.bytedance.sdk.component.utils.yFO.Og(aBv.pA(), "tt_multiple_ad_indicator"), new Object[]{Integer.valueOf(jg2.Bzk + 1), Integer.valueOf(this.TV)}));
            } else {
                this.aBv.setVisibility(8);
            }
        }
        for (int i2 = jg != null ? jg.Bzk : 0; i2 < this.ZZv.size(); i2++) {
            this.ZZv.get(i2).pA(jg, jg2, ml);
        }
        jg2.pA(this.BSW, this.yFO);
        int i3 = this.XT;
        if (i3 == 2) {
            jg2.ZZv(this.BSW);
            return;
        }
        if (i3 == 3) {
            jg2.ZZv(this.BSW);
            jg2.Og(this.BSW);
            jg2.Og(true);
        } else if (i3 == 4) {
            jg2.Og(false);
            jg2.ML(this.BSW);
        } else {
            if (i3 != 5) {
                return;
            }
            jg2.KZx(this.BSW);
        }
    }

    public void pA(TTAdActivity tTAdActivity) {
        this.XT = 2;
        JG jg = this.WV;
        if (jg != null) {
            jg.ZZv(tTAdActivity);
        }
    }

    public void Og(TTAdActivity tTAdActivity) {
        this.XT = 3;
        JG jg = this.WV;
        if (jg != null) {
            jg.Og(tTAdActivity);
        }
        AbstractC0221Og abstractC0221Og = this.TX;
        if (abstractC0221Og != null) {
            abstractC0221Og.Og();
        }
        WV wv = this.pA;
        if (wv != null) {
            wv.pA();
        }
    }

    public void pA(boolean z) {
        JG jg = this.WV;
        if (jg != null) {
            jg.Og(z);
        }
    }

    public void KZx(TTAdActivity tTAdActivity) {
        this.XT = 4;
        JG jg = this.WV;
        if (jg != null) {
            jg.ML(tTAdActivity);
        }
        AbstractC0221Og abstractC0221Og = this.TX;
        if (abstractC0221Og != null) {
            abstractC0221Og.pA();
        }
        WV wv = this.pA;
        if (wv != null) {
            wv.Og();
        }
    }

    public void ZZv(TTAdActivity tTAdActivity) {
        this.XT = 5;
        JG jg = this.WV;
        if (jg != null) {
            jg.KZx(tTAdActivity);
        }
    }

    public void pA(TTAdActivity tTAdActivity, Bundle bundle) {
        com.bytedance.sdk.openadsdk.pA.ML.pA pAVar = this.omh;
        if (pAVar != null) {
            Og = pAVar;
            return;
        }
        com.bytedance.sdk.openadsdk.pA.KZx.Og og = this.Bzk;
        if (og != null) {
            KZx = og;
        }
    }

    public void ML(TTAdActivity tTAdActivity) {
        this.XT = 6;
        int iOg = Og();
        for (JG jg : this.ZZv) {
            if (jg.Bzk >= iOg) {
                jg.DX();
            }
        }
        JG jg2 = this.WV;
        if (jg2 != null) {
            jg2.eG();
        }
        JG jg3 = this.WV;
        if (jg3 != null && !jg3.yFO()) {
            Sn.Og().post(new KZx(this.ML));
        }
        AbstractC0221Og abstractC0221Og = this.TX;
        if (abstractC0221Og != null) {
            abstractC0221Og.KZx();
        }
        WV wv = this.pA;
        if (wv != null) {
            wv.KZx();
        }
        this.WV = null;
        this.BSW = null;
    }

    public int Og() {
        JG jg = this.WV;
        if (jg != null) {
            return jg.Bzk;
        }
        return -1;
    }

    public void pA(JG jg, ML ml) {
        JG jg2 = this.WV;
        if (jg2 == null || jg2 == jg) {
            KZx(null, ml);
        }
    }

    public void Og(JG jg, ML ml) {
        JG jg2 = this.WV;
        if (jg2 == null || jg2 == jg) {
            if (jg2 != null && (jg2 instanceof com.bytedance.sdk.openadsdk.activity.pA)) {
                final long jOmh = (jg2.TX() == null || this.WV.TX().BF == null) ? 0L : this.WV.TX().BF.omh();
                final int i = this.WV.Bzk + 1;
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(System.currentTimeMillis(), this.WV.omh, this.WV.b_(), "dislike_skip", new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.activity.Og.2
                    @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
                    public JSONObject pA() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("ad_show_order", i);
                            jSONObject2.put("pag_json_data", jSONObject3.toString());
                            jSONObject.put("duration", jOmh);
                            jSONObject.put("ad_extra_data", jSONObject2);
                        } catch (Throwable unused) {
                        }
                        return jSONObject;
                    }
                });
            }
            KZx(JG(), ml);
        }
    }

    public void pA(JG jg) {
        Activity activity = this.BSW;
        if (activity != null) {
            activity.finish();
        }
    }

    public Activity KZx() {
        return this.BSW;
    }

    public void pA(JG jg, boolean z, boolean z2, boolean z3, int i) {
        com.bytedance.sdk.openadsdk.activity.KZx kZxML;
        JG jg2 = this.WV;
        if ((jg2 == null || jg2 == jg) && (kZxML = ML()) != null) {
            ML ml = new ML(i, jg != null ? jg.TX() : null);
            ml.pA.putBoolean("isSkip", z);
            ml.pA.putBoolean("force", z2);
            ml.pA.putBoolean("isFromLandingPage", z3);
            KZx(kZxML, ml);
        }
    }

    public void pA(Activity activity) {
        JG jg = this.WV;
        if (jg != null) {
            jg.pA(activity);
        }
    }

    public void ZZv() {
        JG jg = this.WV;
        if (jg != null) {
            jg.aBv();
        }
    }

    public com.bytedance.sdk.openadsdk.activity.KZx ML() {
        com.bytedance.sdk.openadsdk.activity.KZx kZx = this.DX;
        if (kZx != null) {
            return kZx;
        }
        JG jg = this.WV;
        int i = jg != null ? jg.Bzk : -1;
        for (int size = this.ZZv.size() - 1; size > i; size--) {
            JG jg2 = this.ZZv.get(size);
            if (jg2 instanceof com.bytedance.sdk.openadsdk.activity.KZx) {
                this.DX = (com.bytedance.sdk.openadsdk.activity.KZx) jg2;
                break;
            }
        }
        return this.DX;
    }

    public com.bytedance.sdk.openadsdk.activity.pA JG() {
        JG jg;
        JG jg2 = this.WV;
        if (jg2 == null) {
            return null;
        }
        int i = jg2.Bzk;
        do {
            i++;
            if (i >= this.ZZv.size()) {
                return null;
            }
            jg = this.ZZv.get(i);
        } while (!(jg instanceof com.bytedance.sdk.openadsdk.activity.pA));
        return (com.bytedance.sdk.openadsdk.activity.pA) jg;
    }

    public void pA(float f) {
        BSW bsw = this.vZF;
        if (bsw == null) {
            return;
        }
        bsw.setProgress(f);
        if (f == 0.0f && this.vZF.getVisibility() == 0) {
            this.vZF.setVisibility(4);
        } else {
            if (f <= 0.0f || this.vZF.getVisibility() == 0) {
                return;
            }
            this.vZF.setVisibility(0);
        }
    }

    public int SD() {
        return this.Wx;
    }

    public com.bytedance.sdk.openadsdk.component.reward.top.KZx omh() {
        return this.Sd;
    }

    public void pA(int i) {
        AbstractC0221Og abstractC0221Og = this.TX;
        if (abstractC0221Og == null) {
            return;
        }
        if (i == 2) {
            abstractC0221Og.pA();
            WV wv = this.pA;
            if (wv != null) {
                wv.Og();
                return;
            }
            return;
        }
        if (i == 1) {
            abstractC0221Og.Og();
            WV wv2 = this.pA;
            if (wv2 != null) {
                wv2.pA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JG yFO() {
        return this.WV;
    }

    public JG Bzk() {
        int i;
        JG jg = this.WV;
        if (jg != null && (i = jg.Bzk + 1) >= 0 && i < this.ZZv.size()) {
            return this.ZZv.get(i);
        }
        return null;
    }

    public Bundle SGo() {
        return this.JG;
    }

    public void BSW() {
        com.bytedance.sdk.openadsdk.pA.ML.pA pAVar = this.omh;
        if (pAVar != null) {
            pAVar.onAdClicked();
            return;
        }
        com.bytedance.sdk.openadsdk.pA.KZx.Og og = this.Bzk;
        if (og != null) {
            og.onAdClicked();
        }
    }

    public void WV() {
        com.bytedance.sdk.openadsdk.pA.ML.pA pAVar = this.omh;
        if (pAVar != null) {
            pAVar.Og();
            return;
        }
        com.bytedance.sdk.openadsdk.pA.KZx.Og og = this.Bzk;
        if (og != null) {
            og.Og();
        }
    }

    public void Wx() {
        if (oX()) {
            return;
        }
        aBv();
        com.bytedance.sdk.openadsdk.pA.ML.pA pAVar = this.omh;
        if (pAVar != null) {
            pAVar.pA();
        } else {
            com.bytedance.sdk.openadsdk.pA.KZx.Og og = this.Bzk;
            if (og != null) {
                og.pA();
            }
        }
        Runnable runnable = this.du;
        if (runnable != null) {
            runnable.run();
            this.du = null;
        }
    }

    public boolean Sn() {
        return this.WQf;
    }

    public void DX() {
        this.WQf = true;
    }

    public void pA(final JG jg, final boolean z, final int i, final String str, final int i2, final String str2) {
        Activity activity;
        if (!this.BF) {
            this.du = new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.Og.3
                @Override // java.lang.Runnable
                public void run() {
                    Og.this.pA(jg, z, i, str, i2, str2);
                }
            };
            return;
        }
        if (Sn()) {
            return;
        }
        DX();
        if (this.omh == null || (activity = this.BSW) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.Og.4
            @Override // java.lang.Runnable
            public void run() {
                Og.this.omh.pA(z, i, str, i2, str2);
            }
        });
        if (pA()) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(System.currentTimeMillis(), jg.omh, jg.b_(), z ? "reward_success" : "reward_fail");
        }
    }

    public boolean oX() {
        return this.BF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vZF() {
        if (this.ZZv.isEmpty()) {
            return false;
        }
        List<JG> list = this.ZZv;
        return list.get(list.size() - 1) instanceof com.bytedance.sdk.openadsdk.activity.KZx;
    }

    public void aBv() {
        this.BF = true;
    }

    public omh XT() {
        return this.SD;
    }

    public void pA(View view) {
        if (view.getParent() != null) {
            return;
        }
        view.setVisibility(4);
        this.oX.addView(view, 0);
    }

    public static class ML {
        public final com.bytedance.sdk.openadsdk.component.reward.pA.pA KZx;
        public boolean ML;
        public final int Og;
        public boolean ZZv;
        public final Bundle pA = new Bundle();

        public ML(int i, com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
            this.Og = i;
            this.KZx = pAVar;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.activity.Og$Og, reason: collision with other inner class name */
    static abstract class AbstractC0221Og implements Handler.Callback {
        private boolean Bzk;
        private final Handler JG = new Handler(Looper.getMainLooper(), this);
        protected float KZx;
        protected int ML;
        protected final yFO Og;
        private final com.bytedance.sdk.openadsdk.component.reward.top.KZx SD;
        private boolean SGo;
        protected int ZZv;
        private final Context omh;
        protected final Og pA;

        protected abstract int pA(yFO yfo);

        public AbstractC0221Og(Og og, yFO yfo, com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx) {
            this.pA = og;
            this.Og = yfo;
            this.SD = kZx;
            this.omh = kZx.getContext();
            this.ZZv = pA(yfo);
        }

        public void pA() {
            this.JG.removeMessages(this.ML);
        }

        public void Og() {
            if (this.ZZv < 0 || this.Bzk || this.SGo) {
                return;
            }
            this.JG.removeMessages(this.ML);
            this.JG.sendEmptyMessage(this.ML);
        }

        public void KZx() {
            this.JG.removeMessages(this.ML);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (this.ZZv > 0) {
                    this.SD.setSkipText(this.ZZv + "s");
                    int i = this.ZZv - 1;
                    this.ZZv = i;
                    if (i >= 0) {
                        this.JG.removeMessages(message.what);
                        this.JG.sendEmptyMessageDelayed(message.what, 1000L);
                    }
                } else {
                    ZZv();
                }
            } else if (message.what == 2) {
                if (this.ZZv > 0) {
                    this.SD.setSkipText(this.ZZv + "s");
                    int i2 = this.ZZv - 1;
                    this.ZZv = i2;
                    if (i2 >= 0) {
                        this.JG.removeMessages(message.what);
                        this.JG.sendEmptyMessageDelayed(message.what, 1000L);
                    }
                } else {
                    ZZv();
                }
            }
            return true;
        }

        private void ZZv() {
            if (this.pA.vZF()) {
                this.SD.showSkipButton();
                this.Bzk = true;
            } else {
                this.SGo = true;
                this.SD.showCloseButton();
            }
        }

        public void pA(int i) {
            if (this.Bzk || this.SGo) {
                return;
            }
            float f = i;
            this.KZx = f;
            if (f > this.ZZv) {
                if (this.ML == 0) {
                    this.ML = 1;
                }
            } else {
                this.ML = 2;
                this.ZZv = (int) f;
            }
            this.JG.removeCallbacksAndMessages(null);
            this.JG.sendEmptyMessage(this.ML);
        }
    }

    static class ZZv extends AbstractC0221Og {
        private final int JG;
        private int SD;
        private boolean omh;

        public ZZv(Og og, yFO yfo, com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx) {
            super(og, yfo, kZx);
            this.JG = aBv.ZZv().eG(String.valueOf(yfo.Wf())).JG;
        }

        @Override // com.bytedance.sdk.openadsdk.activity.Og.AbstractC0221Og
        protected int pA(yFO yfo) {
            return aBv.ZZv().BSW(String.valueOf(yfo.Wf()));
        }

        @Override // com.bytedance.sdk.openadsdk.activity.Og.AbstractC0221Og
        public void pA(int i) {
            boolean z = this.ML == 0;
            int i2 = this.ZZv;
            super.pA(i);
            if (!z) {
                if (this.KZx < i2) {
                    this.SD = (int) ((1.0f - (this.JG / 100.0f)) * this.ZZv);
                }
            } else if (this.ML == 1) {
                this.SD = 3;
            } else {
                this.SD = (int) ((1.0f - (this.JG / 100.0f)) * this.KZx);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.activity.Og.AbstractC0221Og, android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (!this.omh && this.ZZv <= this.SD) {
                this.omh = true;
                JG jgYFO = this.pA.yFO();
                if (jgYFO instanceof com.bytedance.sdk.openadsdk.activity.ML) {
                    ((com.bytedance.sdk.openadsdk.activity.ML) jgYFO).BF();
                }
            }
            super.handleMessage(message);
            return true;
        }
    }

    static class pA extends AbstractC0221Og {
        public pA(Og og, yFO yfo, com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx) {
            super(og, yfo, kZx);
        }

        @Override // com.bytedance.sdk.openadsdk.activity.Og.AbstractC0221Og
        protected int pA(yFO yfo) {
            return aBv.ZZv().yFO(String.valueOf(yfo.Wf()));
        }
    }

    private static class KZx implements Runnable {
        private final yFO pA;

        public KZx(yFO yfo) {
            this.pA = yfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pA.kK()) {
                com.bytedance.sdk.openadsdk.component.reward.WV.pA(aBv.pA()).pA(this.pA.rB());
            } else {
                com.bytedance.sdk.openadsdk.component.reward.ML.pA(aBv.pA()).pA(this.pA.rB());
            }
        }
    }
}
