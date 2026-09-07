package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.bytedance.sdk.component.utils.DX;
import com.bytedance.sdk.component.utils.TV;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.component.reward.Og.SD;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.vZF;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class KZx extends JG implements TV.pA, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og {
    private static String JG;
    private static String ML;
    private static String SD;
    private static String Wx;
    private static String ZZv;
    private int DX;
    protected com.bytedance.sdk.openadsdk.component.reward.pA.pA KZx;
    protected com.bytedance.sdk.openadsdk.component.reward.Og.Og Og;
    private Bundle Sn;
    private String XT;
    private boolean aBv;
    private Og.ML oX;
    protected final TV pA;
    private boolean vZF;
    private String yFO;

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public final void Bzk() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public final View SGo() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void pA(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void pA(Bundle bundle) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void pA(String str, JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public boolean pA(long j, boolean z) {
        return false;
    }

    public KZx(Og og, yFO yfo, int i) {
        super(og, yfo, i);
        this.pA = new TV(Looper.getMainLooper(), this);
        this.DX = 0;
        this.vZF = true;
        pA(yfo, this.Sn);
        try {
            oX();
        } catch (Throwable th) {
            WV.pA("TTAD.EndCardScene", "onCreate: ", th);
            du();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public final void pA(Activity activity, Bundle bundle) {
        this.Sn = bundle;
        super.pA(activity, bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public final View pA() {
        return this.KZx.CIG;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public void pA(Activity activity, Og.ML ml) {
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar;
        super.pA(activity, ml);
        this.oX = ml;
        Intent intent = activity.getIntent();
        this.yFO = intent.getStringExtra("media_extra");
        this.XT = intent.getStringExtra("user_id");
        try {
            if (SD == null) {
                SD = com.bytedance.sdk.component.utils.yFO.pA(this.KZx.Gx, "tt_reward_msg");
                ZZv = com.bytedance.sdk.component.utils.yFO.pA(this.KZx.Gx, "tt_msgPlayable");
                JG = com.bytedance.sdk.component.utils.yFO.pA(this.KZx.Gx, "tt_negtiveBtnBtnText");
                Wx = com.bytedance.sdk.component.utils.yFO.pA(this.KZx.Gx, "tt_postiveBtnText");
                ML = com.bytedance.sdk.component.utils.yFO.pA(this.KZx.Gx, "tt_postiveBtnTextPlayable");
            }
        } catch (Throwable th) {
            WV.pA("TTAD.EndCardScene", th.getMessage());
        }
        if (ml != null && (pAVar = ml.KZx) != null) {
            this.KZx.Wx.set(pAVar.Wx.get());
            this.KZx.SXO = pAVar.SXO;
            this.KZx.Sn.set(pAVar.Sn.get());
            this.KZx.BF.pA(pAVar.BF.pA());
        }
        XT();
        omh();
    }

    private void pA(yFO yfo, Bundle bundle) {
        Activity activityTV = TV();
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = new com.bytedance.sdk.openadsdk.component.reward.pA.pA(activityTV, this.pA, yfo, this, 2);
        this.KZx = pAVar;
        pAVar.Itl = WQf().pA();
        this.KZx.RS = this;
        this.KZx.lT = WQf().XT();
        com.bytedance.sdk.openadsdk.component.reward.pA.Og.pA(this.KZx, activityTV.getIntent(), bundle);
        com.bytedance.sdk.openadsdk.component.reward.Og.Og ogPA = SD.pA(this.KZx);
        this.Og = ogPA;
        this.KZx.nCO = ogPA;
        new StringBuilder("init: mAdType = ").append(this.Og);
    }

    private void oX() {
        this.KZx.CIG.pA(this.Og);
        this.Og.pA(this, this.pA);
        this.Og.BSW();
    }

    private void XT() {
        if (this.aBv) {
            return;
        }
        this.aBv = true;
        this.Og.pA(this.WV);
        Sd();
    }

    private void Sd() {
        final View viewSGo = this.KZx.Vgu.SGo();
        if (viewSGo != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.KZx.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/KZx$1;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_KZx$1_onClick_4d1d269923ba2fb06a3f0c5a38cf85ef(view);
                }

                /* JADX WARN: Code duplicated, block: B:29:0x00e4  */
                public void safedk_KZx$1_onClick_4d1d269923ba2fb06a3f0c5a38cf85ef(View p0) {
                    boolean zML;
                    if (KZx.this.KZx.rB.du()) {
                        boolean zWx = KZx.this.KZx.xy.Wx();
                        KZx.this.KZx.rB.ML(zWx);
                        KZx.this.KZx.Vgu.ML(8);
                        View view = viewSGo;
                        if (view instanceof com.bytedance.sdk.openadsdk.core.ML.ZZv) {
                            ((com.bytedance.sdk.openadsdk.core.ML.ZZv) view).setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(KZx.this.KZx.Gx, "tt_close_btn"));
                        }
                        KZx.this.KZx.Bf.sendEmptyMessageDelayed(600, 5000L);
                        if (!yFO.KZx(KZx.this.KZx.Og)) {
                            return;
                        }
                        if (yFO.KZx(KZx.this.KZx.Og) && zWx) {
                            return;
                        }
                    }
                    if (!KZx.this.KZx.Og.Fb()) {
                        zML = false;
                    } else if (KZx.this.KZx.Og.rjD()) {
                        if (KZx.this.KZx.gbA != null) {
                            KZx.this.KZx.Og.xy(2);
                            zML = KZx.this.KZx.gbA.ML();
                        } else {
                            zML = false;
                        }
                    } else if (KZx.this.KZx.Og.Lf() != 0 || KZx.this.KZx.rB.aBv()) {
                        zML = false;
                    } else {
                        KZx.this.KZx.Og.xy(11);
                        if (KZx.this.KZx.rB.ZZv()) {
                            KZx.this.KZx.Og.xy(12);
                        }
                        try {
                            KZx.this.KZx.Vgu.aBv();
                            zML = true;
                        } catch (Exception unused) {
                            zML = false;
                        }
                    }
                    if (zML) {
                        return;
                    }
                    KZx.this.KZx.rB.eG();
                    KZx.this.KZx.xy.BSW();
                    KZx.this.KZx.roi.JG();
                    if (WQf.ZZv(KZx.this.KZx.Og) && KZx.this.pA(true, true)) {
                        return;
                    }
                    KZx.this.du();
                }
            };
            viewSGo.setOnClickListener(onClickListener);
            viewSGo.setTag(viewSGo.getId(), onClickListener);
        }
        this.KZx.qmB.pA(new com.bytedance.sdk.openadsdk.component.reward.top.Og() { // from class: com.bytedance.sdk.openadsdk.activity.KZx.2
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.Og
            public void pA(View view) {
                KZx kZx = KZx.this;
                if (kZx.pA(WQf.KZx(kZx.KZx.Og), false)) {
                    return;
                }
                if (WQf.ML(KZx.this.KZx.Og)) {
                    if (WQf.SGo(KZx.this.KZx.Og)) {
                        KZx.this.KZx.TV.aBv();
                        return;
                    }
                    View view2 = viewSGo;
                    if (view2 != null) {
                        view2.performClick();
                        return;
                    } else {
                        KZx.this.du();
                        return;
                    }
                }
                if (WQf.omh(KZx.this.KZx.Og)) {
                    if (KZx.this.KZx.TV.pA()) {
                        KZx.this.KZx.TV.pA(5);
                        return;
                    } else {
                        KZx.this.KZx.rB.omh();
                        return;
                    }
                }
                if (WQf.XT(KZx.this.KZx.Og) || (aBv.pA(KZx.this.KZx.Og) && !KZx.this.KZx.oX.get())) {
                    if (!WQf.omh(KZx.this.KZx.Og) && KZx.this.KZx.TV.pA()) {
                        KZx.this.KZx.TV.pA(4);
                    }
                    KZx.this.du();
                    return;
                }
                KZx.this.du();
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.Og
            public void Og(View view) {
                if (KZx.this.Og != null && KZx.this.Og.ZZv() != null) {
                    KZx.this.Og.ZZv().pA(KZx.this.KZx.agB);
                }
                KZx.this.KZx.agB = !KZx.this.KZx.agB;
                new Object[]{"rewarded_video", "will set is Mute " + KZx.this.KZx.agB + " mLastVolume=" + KZx.this.KZx.lT.pA()};
                KZx.this.KZx.BF.Og(KZx.this.KZx.agB);
                if (!WQf.yFO(KZx.this.KZx.Og) || KZx.this.KZx.SGo.get()) {
                    if (WQf.SD(KZx.this.KZx.Og)) {
                        KZx.this.KZx.lT.pA(KZx.this.KZx.agB, true);
                    }
                    KZx.this.KZx.rB.ZZv(KZx.this.KZx.agB);
                    if (KZx.this.KZx.Og != null && KZx.this.KZx.Og.dGZ() != null && KZx.this.KZx.Og.dGZ().pA() != null && KZx.this.KZx.BF != null) {
                        if (KZx.this.KZx.agB) {
                            KZx.this.KZx.Og.dGZ().pA().omh(KZx.this.KZx.BF.SD());
                        } else {
                            KZx.this.KZx.Og.dGZ().pA().Bzk(KZx.this.KZx.BF.SD());
                        }
                    }
                    KZx.this.KZx.TV.JG(KZx.this.KZx.agB);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.Og
            public void KZx(View view) {
                KZx.this.KZx.IG.pA(KZx.this.Og);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.Og
            public void ZZv(View view) {
                View view2 = viewSGo;
                if (view2 != null) {
                    view2.performClick();
                }
            }
        });
    }

    private boolean BF() {
        if (this.KZx.SGo.get() && this.KZx.SD) {
            return false;
        }
        if (this.omh.pA()) {
            return this.KZx.SGo.get();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public final void Og(Activity activity) {
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og;
        super.Og(activity);
        if (this.KZx == null || (og = this.Og) == null) {
            return;
        }
        og.aBv();
        this.KZx.fN = true;
        this.KZx.eG.Og(this.pA);
        if (BF()) {
            this.KZx.qmB.pA(this.KZx.Og.uQ());
        }
        this.KZx.Vgu.DX();
        this.KZx.rB.TX();
        this.KZx.TV.Wx();
        if (this.Og.Og()) {
            this.KZx.BF.pA(this.Og);
            this.KZx.BF.pA(false, this, this.DX != 0);
        }
        this.DX++;
        if (this.KZx.du != null) {
            this.KZx.du.SD();
        }
        this.KZx.eG.pA(this.pA);
        this.Og.yFO();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public void KZx(Activity activity) {
        super.KZx(activity);
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.Og;
        if (og == null) {
            return;
        }
        og.Sd();
    }

    @Override // com.bytedance.sdk.component.utils.TV.pA
    public final void pA(Message message) {
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.Og;
        if (og == null) {
            return;
        }
        og.pA(message);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public final void ZZv() {
        Mc();
        this.KZx.Og.Ky();
        this.KZx.Og.pA(true);
        if (yFO.ML(this.KZx.Og)) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.KZx.Og, this.KZx.ML, this.KZx.Og.Io());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void c_() {
        Mc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public final void JG() {
        roi();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public final void omh() {
        if (WQf() == null) {
            return;
        }
        this.KZx.gbA.pA(this.oX.pA.getBoolean("isSkip", false), this.oX.pA.getBoolean("force", false), this.oX.pA.getBoolean("isFromLandingPage", false), this.Og, this.oX.Og);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public final void ZZv(Activity activity) {
        super.ZZv(activity);
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = this.KZx;
        if (pAVar == null) {
            return;
        }
        pAVar.rB.rB();
        com.bytedance.sdk.openadsdk.utils.KZx.pA(activity, this.KZx.Og);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public final void ML(Activity activity) {
        super.ML(activity);
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.Og;
        if (og == null) {
            return;
        }
        og.vZF();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public final void BSW() {
        if (!this.KZx.Sn.getAndSet(true) || WQf.XT(this.KZx.Og)) {
            this.KZx.roi.pA();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void WV() {
        KZx();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void Sn() {
        boolean z = false;
        boolean z2 = (1.0f - (this.KZx.TV.Og() / ((float) this.KZx.Og.mK()))) * 100.0f >= ((float) com.bytedance.sdk.openadsdk.core.aBv.ZZv().eG(String.valueOf(this.KZx.JG)).JG);
        int iPA = com.bytedance.sdk.openadsdk.core.aBv.ZZv().pA(String.valueOf(this.KZx.JG));
        if (iPA == 0) {
            boolean zML = this.KZx.rB.WV().ML();
            if (this.KZx.TV.KZx()) {
                zML = true;
            }
            z = z2 && zML;
        } else if (iPA == 1) {
            z = z2;
        }
        if (z) {
            KZx();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void pA(boolean z) {
        if (z) {
            KZx();
        }
    }

    public void KZx() {
        if (WQf().SGo().getBoolean("reward_verify", false) || WQf().Sn()) {
            return;
        }
        WQf().SGo().putBoolean("reward_verify", true);
        if (com.bytedance.sdk.openadsdk.core.aBv.ZZv().oX(String.valueOf(this.KZx.JG))) {
            pA(true, this.KZx.Og.TX(), this.KZx.Og.Sd(), 0, "");
        } else {
            com.bytedance.sdk.openadsdk.core.aBv.KZx().pA(IG(), new com.bytedance.sdk.openadsdk.core.yFO.Og() { // from class: com.bytedance.sdk.openadsdk.activity.KZx.3
                @Override // com.bytedance.sdk.openadsdk.core.yFO.Og
                public void pA(int i, String str) {
                    KZx.this.pA(false, 0, "", i, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.yFO.Og
                public void pA(vZF.Og og) {
                    KZx.this.pA(og.Og, og.KZx.pA(), og.KZx.Og(), 0, "");
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public void aBv() {
        super.aBv();
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.Og;
        if (og != null) {
            og.BF();
        }
    }

    public void ML() {
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.Og;
        if (og == null) {
            return;
        }
        og.eG();
        this.KZx.gbA.Og();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public boolean yFO() {
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = this.KZx;
        return pAVar != null && pAVar.BF.WQf();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    protected boolean a_() {
        return this.KZx.ZZv;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    protected String vZF() {
        return this.KZx.JBA;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public String b_() {
        return this.KZx.ML;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public void pA(JG jg, JG jg2, Og.ML ml) {
        super.pA(jg, jg2, ml);
        if (jg != null || jg2 == this) {
            return;
        }
        if (WQf.SD(this.KZx.Og) || com.bytedance.sdk.openadsdk.vZF.pA.pA("ivrv_new_arch_endcard_view_add_at_first", 0) == 1) {
            WQf().pA(pA());
        }
        XT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pA(final boolean z, boolean z2) {
        if (!this.KZx.ZZv || WQf().SGo().getBoolean("reward_verify", false) || WQf().Sn()) {
            return false;
        }
        if (!z2 && WQf().SGo().getBoolean("user_has_give_up_reward", false)) {
            return false;
        }
        if (!com.bytedance.sdk.openadsdk.core.aBv.ZZv().omh(String.valueOf(this.KZx.JG))) {
            if (!z2) {
                return false;
            }
            if (z) {
                du();
                return true;
            }
        }
        this.KZx.vZF.set(true);
        if (z) {
            this.KZx.TV.Sn();
        }
        final com.bytedance.sdk.openadsdk.core.widget.Og og = new com.bytedance.sdk.openadsdk.core.widget.Og(this.KZx.SzT);
        this.Og.Wx = og;
        if (z) {
            this.Og.Wx.pA(ZZv).Og(ML).KZx(JG);
        } else {
            this.Og.Wx.pA(SD).Og(Wx).KZx(JG);
        }
        this.Og.Wx.pA(new com.bytedance.sdk.openadsdk.core.widget.Og.pA() { // from class: com.bytedance.sdk.openadsdk.activity.KZx.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.Og.pA
            public void pA() {
                if (z) {
                    KZx.this.KZx.TV.ML(1000);
                }
                og.dismiss();
                KZx.this.KZx.vZF.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.Og.pA
            public void Og() {
                og.dismiss();
                KZx.this.WQf().SGo().putBoolean("user_has_give_up_reward", true);
                KZx.this.KZx.vZF.set(false);
                KZx.this.KZx.TV.JG(Integer.MAX_VALUE);
                if (z) {
                    if (WQf.omh(KZx.this.KZx.Og)) {
                        if (KZx.this.KZx.TV.pA()) {
                            KZx.this.KZx.TV.pA(5);
                            return;
                        } else {
                            KZx.this.KZx.rB.omh();
                            return;
                        }
                    }
                    KZx.this.KZx.roi.JG();
                    if (KZx.this.KZx.TV.pA()) {
                        KZx.this.KZx.TV.pA(4);
                    }
                    KZx.this.du();
                }
            }
        }).show();
        return true;
    }

    private JSONObject IG() {
        JSONObject jSONObject = new JSONObject();
        int iVZF = (int) this.KZx.BF.vZF();
        try {
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put(CampaignEx.JSON_KEY_REWARD_NAME, this.KZx.Og.Sd());
            jSONObject.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, this.KZx.Og.TX());
            jSONObject.put("network", DX.KZx(this.KZx.Gx));
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            int iVgu = this.KZx.Og.Vgu();
            String strKZx = "unKnow";
            if (iVgu == 2) {
                strKZx = gbA.Og();
            } else if (iVgu == 1) {
                strKZx = gbA.KZx();
            }
            jSONObject.put("user_agent", strKZx);
            jSONObject.put("extra", this.KZx.Og.fg());
            jSONObject.put("media_extra", this.yFO);
            jSONObject.put("video_duration", this.KZx.Og.Bf().JG());
            jSONObject.put("play_start_ts", 0);
            jSONObject.put("play_end_ts", 0);
            jSONObject.put("duration", iVZF);
            jSONObject.put("user_id", this.XT);
            jSONObject.put("trans_id", com.bytedance.sdk.openadsdk.utils.WQf.pA().replace("-", ""));
            return jSONObject;
        } catch (Throwable th) {
            WV.pA("TTAD.EndCardScene", "", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public void DX() {
        super.DX();
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.Og;
        if (og == null) {
            return;
        }
        og.TX();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public void Og(boolean z) {
        long j = this.vZF ? this.KZx.SXO : 0L;
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = this.KZx;
        if (pAVar != null && pAVar.roi != null) {
            this.KZx.roi.Og(z);
            this.KZx.roi.KZx(z);
            if (z && j > 0) {
                this.KZx.SXO = j;
            }
        }
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar2 = this.KZx;
        if (pAVar2 != null && (pAVar2.nCO instanceof com.bytedance.sdk.openadsdk.component.reward.Og.JG)) {
            ((com.bytedance.sdk.openadsdk.component.reward.Og.JG) this.KZx.nCO).Og(z);
        }
        if (z) {
            this.vZF = false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public com.bytedance.sdk.openadsdk.component.reward.pA.pA TX() {
        return this.KZx;
    }
}
