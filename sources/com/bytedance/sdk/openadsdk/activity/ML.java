package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.bytedance.sdk.component.utils.DX;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.ZZv.SD;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.vZF;
import com.bytedance.sdk.openadsdk.utils.Wx;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.HashMap;
import java.util.Iterator;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ML extends pA {
    private static String DX;
    private static String Sn;
    private static String Wx;
    private static String aBv;
    private static String oX;
    protected int JG;
    protected int ML;
    int SD;
    private String XT;
    private int vZF;
    private String yFO;

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    protected boolean a_() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.pA, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void pA(Bundle bundle) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.pA, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void pA(boolean z) {
    }

    public ML(Og og, yFO yfo, int i) {
        super(og, yfo, i);
        this.vZF = -1;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.pA, com.bytedance.sdk.openadsdk.activity.JG
    public void pA(Activity activity, Og.ML ml) {
        super.pA(activity, ml);
        if (activity.isFinishing()) {
            return;
        }
        Intent intent = activity.getIntent();
        this.yFO = intent.getStringExtra("media_extra");
        this.XT = intent.getStringExtra("user_id");
        try {
            if (oX == null) {
                oX = com.bytedance.sdk.component.utils.yFO.pA(this.KZx.Gx, "tt_reward_msg");
                Wx = com.bytedance.sdk.component.utils.yFO.pA(this.KZx.Gx, "tt_msgPlayable");
                DX = com.bytedance.sdk.component.utils.yFO.pA(this.KZx.Gx, "tt_negtiveBtnBtnText");
                aBv = com.bytedance.sdk.component.utils.yFO.pA(this.KZx.Gx, "tt_postiveBtnText");
                Sn = com.bytedance.sdk.component.utils.yFO.pA(this.KZx.Gx, "tt_postiveBtnTextPlayable");
            }
        } catch (Throwable th) {
            WV.pA("TTAD.RewardAdScene", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public String b_() {
        return "rewarded_video";
    }

    @Override // com.bytedance.sdk.openadsdk.activity.pA
    protected void Og() {
        this.KZx.qmB.pA(null, TTAdDislikeToast.getSkipText());
        this.KZx.qmB.ML(true);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.pA
    protected void KZx() {
        final View viewSGo = this.KZx.Vgu.SGo();
        if (viewSGo != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.ML.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/ML$1;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_ML$1_onClick_164a5fab05cb9deb515098f2d8d5d036(view);
                }

                /* JADX WARN: Code duplicated, block: B:28:0x00d9  */
                public void safedk_ML$1_onClick_164a5fab05cb9deb515098f2d8d5d036(View p0) {
                    boolean zML;
                    if (ML.this.KZx.rB.du() && ML.this.KZx.SGo.get()) {
                        boolean zWx = ML.this.KZx.xy.Wx();
                        ML.this.KZx.rB.ML(zWx);
                        ML.this.KZx.Vgu.ML(8);
                        ML.this.KZx.Bf.sendEmptyMessageDelayed(600, 5000L);
                        if (!yFO.KZx(ML.this.KZx.Og)) {
                            return;
                        }
                        if (yFO.KZx(ML.this.KZx.Og) && zWx) {
                            return;
                        }
                    }
                    if (!ML.this.KZx.Og.Fb()) {
                        zML = false;
                    } else if (ML.this.KZx.Og.rjD()) {
                        if (ML.this.KZx.gbA != null) {
                            ML.this.KZx.Og.xy(2);
                            zML = ML.this.KZx.gbA.ML();
                        } else {
                            zML = false;
                        }
                    } else if (ML.this.KZx.Og.Lf() != 0 || ML.this.KZx.rB.aBv()) {
                        zML = false;
                    } else {
                        ML.this.KZx.Og.xy(11);
                        if (ML.this.KZx.rB.ZZv()) {
                            ML.this.KZx.Og.xy(12);
                        }
                        try {
                            ML.this.KZx.Vgu.aBv();
                            zML = true;
                        } catch (Exception unused) {
                            zML = false;
                        }
                    }
                    if (zML) {
                        return;
                    }
                    ML.this.KZx.rB.eG();
                    ML.this.KZx.xy.BSW();
                    ML.this.KZx.roi.JG();
                    if (WQf.ZZv(ML.this.KZx.Og)) {
                        ML.this.pA(true, true, (Runnable) null);
                    } else {
                        ML.this.du();
                    }
                }
            };
            viewSGo.setOnClickListener(onClickListener);
            viewSGo.setTag(viewSGo.getId(), onClickListener);
        }
        this.KZx.qmB.pA(new com.bytedance.sdk.openadsdk.component.reward.top.Og() { // from class: com.bytedance.sdk.openadsdk.activity.ML.2
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.Og
            public void pA(View view) {
                if (ML.this.KZx.Og.iC()) {
                    if (ML.this.KZx.Vgu.BSW() != null) {
                        ML.this.KZx.Og.xy(2);
                        ML.this.KZx.Vgu.aBv();
                        return;
                    }
                    return;
                }
                if (!ML.this.KZx.KZx && ML.this.KZx.Og.Fb() && !ML.this.KZx.Og.rjD()) {
                    ML.this.KZx.Og.xy(13);
                    try {
                        ML.this.KZx.Vgu.aBv();
                        return;
                    } catch (Exception unused) {
                    }
                }
                ML ml = ML.this;
                ml.pA(WQf.KZx(ml.KZx.Og), false, (Runnable) null);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.Og
            public void Og(View view) {
                if (ML.this.Og != null && ML.this.Og.ZZv() != null) {
                    ML.this.Og.ZZv().pA(ML.this.KZx.agB);
                }
                ML.this.KZx.agB = !ML.this.KZx.agB;
                new Object[]{"rewarded_video", "will set is Mute " + ML.this.KZx.agB + " mLastVolume=" + ML.this.KZx.lT.pA()};
                ML.this.KZx.BF.Og(ML.this.KZx.agB);
                if (!WQf.yFO(ML.this.KZx.Og) || ML.this.KZx.SGo.get()) {
                    if (WQf.SD(ML.this.KZx.Og)) {
                        ML.this.KZx.lT.pA(ML.this.KZx.agB, true);
                    }
                    ML.this.KZx.rB.ZZv(ML.this.KZx.agB);
                    if (ML.this.KZx.Og == null || ML.this.KZx.Og.dGZ() == null || ML.this.KZx.Og.dGZ().pA() == null || ML.this.KZx.BF == null) {
                        return;
                    }
                    if (ML.this.KZx.agB) {
                        ML.this.KZx.Og.dGZ().pA().omh(ML.this.KZx.BF.SD());
                    } else {
                        ML.this.KZx.Og.dGZ().pA().Bzk(ML.this.KZx.BF.SD());
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.Og
            public void KZx(View view) {
                ML.this.KZx.IG.pA(ML.this.Og);
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

    @Override // com.bytedance.sdk.openadsdk.activity.pA, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void pA(int i) {
        if (i == 10000) {
            BF();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public boolean pA(long j, boolean z) {
        SD sd;
        if (this.omh.pA()) {
            if (this.KZx.du != null && this.KZx.du.pA() != null) {
                sd = this.KZx.du.pA().getAdShowTime();
            } else {
                sd = new SD();
            }
            this.KZx.BF.pA(this.KZx.du.Og(), sd);
            HashMap map = new HashMap();
            if (this.KZx.du != null) {
                map.put("dynamic_show_type", Integer.valueOf(this.KZx.du.Bzk()));
                JSONObject jSONObjectPA = this.KZx.du.pA((JSONObject) null);
                if (jSONObjectPA != null) {
                    Iterator<String> itKeys = jSONObjectPA.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        try {
                            map.put(next, jSONObjectPA.get(next));
                        } catch (JSONException unused) {
                        }
                    }
                }
            }
            this.KZx.BF.pA(new com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.activity.ML.3
                boolean pA;

                @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
                public void pA(long j2, int i) {
                    if (this.pA) {
                        return;
                    }
                    this.pA = true;
                    ML.this.pA.removeMessages(300);
                    ML.this.Wx();
                    ML.this.KZx.BF.pA(j2, j2);
                    ML.this.KZx.du.Og(true);
                    if (ML.this.KZx.Og.aBv() == 36 && ML.this.KZx.KZx) {
                        ML.this.KZx.WQf.KZx().ZZv();
                        Wx.Og();
                    }
                    if (ML.this.KZx.Og.aBv() == 21 && !ML.this.KZx.Og.ZZv()) {
                        ML.this.KZx.Og.Og(true);
                        ML.this.KZx.Vgu.aBv();
                    }
                    if (ML.this.KZx.Itl) {
                        Og ogWQf = ML.this.WQf();
                        ML ml = ML.this;
                        ogWQf.pA(ml, ml.Og(5));
                    } else if (ML.this.KZx.KZx) {
                        if (ML.this.KZx.Og.xkc()) {
                            if (ML.this.KZx.du.Bzk() == 1) {
                                ML.this.KZx.qmB.KZx();
                            }
                        } else {
                            ML.this.pA(false, 5);
                            if (!yFO.ML(ML.this.KZx.Og)) {
                                ML.this.KZx.BF.pA(EventConstants.SKIP, true);
                            }
                        }
                    } else if (ML.this.KZx.Og.xkc()) {
                        if (ML.this.KZx.du.Bzk() == 1) {
                            ML.this.KZx.qmB.KZx();
                        }
                    } else {
                        if (!yFO.ML(ML.this.KZx.Og)) {
                            ML.this.KZx.BF.pA(EventConstants.SKIP, true);
                        }
                        ML.this.du();
                    }
                    ML.this.ML = (int) (System.currentTimeMillis() / 1000);
                    if (ML.this.KZx.Itl) {
                        return;
                    }
                    ML.this.BF();
                }

                @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
                public void Og(long j2, int i) {
                    ML.this.pA.removeMessages(300);
                    if (ML.this.KZx.BF.Og()) {
                        ML.this.ML();
                        return;
                    }
                    ML.this.BF();
                    ML.this.KZx.BF.Wx();
                    ML.this.KZx.du.pA(true);
                    Og ogWQf = ML.this.WQf();
                    ML ml = ML.this;
                    ogWQf.pA(ml, ml.Og(3));
                }

                @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
                public void pA() {
                    ML.this.pA.removeMessages(300);
                    ML.this.Wx();
                    ML.this.BF();
                    Og ogWQf = ML.this.WQf();
                    ML ml = ML.this;
                    ogWQf.pA(ml, ml.Og(6));
                }

                @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
                public void pA(long j2, long j3) {
                    if (!ML.this.KZx.fN && ML.this.KZx.BF.Og()) {
                        ML.this.KZx.BF.DX();
                    }
                    if (ML.this.KZx.SGo.get()) {
                        return;
                    }
                    ML.this.pA.removeMessages(300);
                    if (j2 != ML.this.KZx.BF.omh()) {
                        ML.this.Wx();
                    }
                    if (ML.this.KZx.BF.Og()) {
                        ML.this.KZx.BF.pA(j2, j3);
                        int iSGo = aBv.ZZv().SGo(String.valueOf(ML.this.KZx.JG));
                        boolean z2 = ML.this.KZx.du.omh() && iSGo != -1 && iSGo >= 0;
                        ML ml = ML.this;
                        long j4 = j2 / 1000;
                        ml.SD = (int) (ml.KZx.BF.roi() - j4);
                        int i = (int) j4;
                        if ((ML.this.KZx.vZF.get() || ML.this.KZx.BSW.get()) && ML.this.KZx.BF.Og()) {
                            ML.this.KZx.BF.DX();
                        }
                        if (ML.this.SD >= 0) {
                            ML.this.KZx.qmB.pA(String.valueOf(ML.this.SD), null);
                        }
                        ML.this.KZx.Vgu.ZZv(i);
                        ML.this.pA(j2, j3);
                        if (ML.this.KZx.du != null && ML.this.KZx.du.pA() != null) {
                            ML.this.KZx.du.pA().setTime(String.valueOf(ML.this.SD), i, 0, false);
                        }
                        ML.this.pA((j2 * 1.0f) / j3);
                        if (ML.this.SD > 0) {
                            if (z2 && i >= iSGo && ML.this.KZx.Og.aBv() != 5) {
                                ML.this.KZx.pA(true);
                                ML.this.KZx.qmB.pA(String.valueOf(ML.this.SD), TTAdDislikeToast.getSkipText());
                                ML.this.KZx.qmB.ML(true);
                                return;
                            }
                            ML.this.KZx.qmB.pA(String.valueOf(ML.this.SD), null);
                        }
                    }
                }
            });
            boolean zPA = this.KZx.BF.pA(j, z, map, this.Og);
            if (zPA && !z) {
                this.JG = (int) (System.currentTimeMillis() / 1000);
            }
            return zPA;
        }
        SD sd2 = new SD();
        sd2.pA(System.currentTimeMillis(), 1.0f);
        this.KZx.BF.pA(this.KZx.Vgu.JG(), sd2);
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA pAVar = new com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.activity.ML.4
            boolean pA;

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void pA(long j2, int i) {
                if (this.pA) {
                    return;
                }
                this.pA = true;
                ML.this.pA.removeMessages(300);
                ML.this.Wx();
                if (!ML.this.KZx.Itl) {
                    ML.this.BF();
                }
                ML.this.KZx.BF.pA(j2, j2);
                ML.this.KZx.yFO.set(true);
                if (ML.this.KZx.Og.Zc()) {
                    ML.this.KZx.Og.xy(1);
                    ML.this.KZx.Vgu.aBv();
                }
                if (ML.this.KZx.Og.aBv() == 21 && !ML.this.KZx.Og.ZZv()) {
                    ML.this.KZx.Og.Og(true);
                    ML.this.KZx.Vgu.aBv();
                }
                ML.this.ML = (int) (System.currentTimeMillis() / 1000);
                if (ML.this.KZx.Itl) {
                    Og.ML mlOg = ML.this.Og(5);
                    mlOg.ML = true;
                    ML.this.WQf().pA(ML.this, mlOg);
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.model.aBv.ZZv(ML.this.KZx.Og) || com.bytedance.sdk.openadsdk.core.model.aBv.Og(ML.this.KZx.Og) || com.bytedance.sdk.openadsdk.core.model.aBv.ML(ML.this.KZx.Og)) {
                    ML.this.pA(false, 5);
                    if (!com.bytedance.sdk.openadsdk.core.model.aBv.Og(ML.this.KZx.Og) || ML.this.KZx.Wo == null) {
                        return;
                    }
                    ML.this.KZx.Wo.pA(0L);
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.model.aBv.pA(ML.this.KZx.Og) && !ML.this.KZx.oX.get()) {
                    ML.this.KZx.pA(true);
                    ML.this.KZx.qmB.ML(true);
                    return;
                }
                if (ML.this.KZx.KZx) {
                    if (ML.this.KZx.Og.xkc()) {
                        ML.this.KZx.qmB.KZx();
                        return;
                    }
                    ML.this.pA(false, 5);
                    if (yFO.ML(ML.this.KZx.Og)) {
                        return;
                    }
                    ML.this.KZx.BF.pA(EventConstants.SKIP, true);
                    return;
                }
                if (ML.this.KZx.Og.xkc()) {
                    ML.this.KZx.qmB.KZx();
                    return;
                }
                if (!yFO.ML(ML.this.KZx.Og)) {
                    ML.this.KZx.BF.pA(EventConstants.SKIP, true);
                }
                ML.this.du();
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void Og(long j2, int i) {
                ML.this.pA.removeMessages(300);
                if (ML.this.KZx.BF.Og()) {
                    ML.this.ML();
                    return;
                }
                ML.this.KZx.BF.Wx();
                ML.this.BF();
                Og ogWQf = ML.this.WQf();
                ML ml = ML.this;
                ogWQf.pA(ml, ml.Og(3));
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void pA() {
                ML.this.pA.removeMessages(300);
                ML.this.Wx();
                ML.this.BF();
                Og ogWQf = ML.this.WQf();
                ML ml = ML.this;
                ogWQf.pA(ml, ml.Og(6));
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void pA(long j2, long j3) {
                if (!ML.this.KZx.fN && ML.this.KZx.BF.Og()) {
                    ML.this.KZx.BF.DX();
                }
                if (ML.this.KZx.SGo.get()) {
                    return;
                }
                ML.this.pA.removeMessages(300);
                if (j2 != ML.this.KZx.BF.omh()) {
                    ML.this.Wx();
                }
                ML.this.KZx.BF.pA(j2, j3);
                ML ml = ML.this;
                long j4 = j2 / 1000;
                double d = j4;
                ml.SD = (int) (ml.KZx.BF.roi() - d);
                if (ML.this.SD >= 0) {
                    ML.this.KZx.qmB.pA(String.valueOf(ML.this.SD), null);
                }
                ML ml2 = ML.this;
                ml2.SD = (int) (ml2.KZx.BF.roi() - d);
                int i = (int) j4;
                int iSGo = aBv.ZZv().SGo(String.valueOf(ML.this.KZx.JG));
                boolean z2 = iSGo >= 0;
                if ((ML.this.KZx.vZF.get() || ML.this.KZx.BSW.get()) && ML.this.KZx.BF.Og()) {
                    ML.this.KZx.BF.DX();
                }
                ML.this.KZx.Vgu.ZZv(i);
                ML.this.pA(j2, j3);
                ML.this.pA((j2 * 1.0f) / j3);
                if (ML.this.SD > 0) {
                    ML.this.KZx.qmB.ZZv(true);
                    if (z2 && i >= iSGo) {
                        ML.this.KZx.pA(true);
                        ML.this.KZx.qmB.pA(String.valueOf(ML.this.SD), TTAdDislikeToast.getSkipText());
                        ML.this.KZx.qmB.ML(true);
                        return;
                    }
                    ML.this.KZx.qmB.pA(String.valueOf(ML.this.SD), null);
                }
            }
        };
        this.KZx.BF.pA(pAVar);
        if (this.KZx.Vgu.DX != null) {
            this.KZx.Vgu.DX.pA(pAVar);
        }
        boolean zPA2 = this.KZx.BF.pA(j, z, null, this.Og);
        if (zPA2 && !z) {
            this.JG = (int) (System.currentTimeMillis() / 1000);
        }
        return zPA2;
    }

    public void pA(long j, long j2) {
        if (this.KZx.Itl) {
            return;
        }
        long j3 = j + (((long) this.KZx.dmv) * 1000);
        if (this.vZF == -1) {
            this.vZF = aBv.ZZv().eG(String.valueOf(this.KZx.JG)).JG;
        }
        if (j2 <= 0) {
            return;
        }
        if (j2 >= 30000 && j3 >= 27000) {
            BF();
        } else if ((j3 * 100) / j2 >= this.vZF) {
            BF();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void c_() {
        Mc();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.pA
    protected void SD() {
        roi();
        if (this.omh.pA()) {
            this.KZx.du.SGo();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.pA, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void WV() {
        BF();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x003e  */
    @Override // com.bytedance.sdk.openadsdk.activity.pA, com.bytedance.sdk.openadsdk.activity.JG, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void Sn() {
        if (this.omh.kK()) {
            int i = aBv.ZZv().eG(String.valueOf(this.KZx.JG)).JG;
            boolean z = false;
            if (WQf.yFO(this.KZx.Og)) {
                if ((1.0d - (((double) this.SD) / this.KZx.BF.roi())) * 100.0d >= i) {
                    z = true;
                }
            } else {
                boolean z2 = (1.0f - (this.KZx.TV.Og() / ((float) this.KZx.Og.mK()))) * 100.0f >= ((float) i);
                int iPA = aBv.ZZv().pA(String.valueOf(this.KZx.JG));
                if (iPA == 0) {
                    boolean zML = this.KZx.rB.WV().ML();
                    if (this.KZx.TV.KZx()) {
                        zML = true;
                    }
                    if (z2 && zML) {
                        z = true;
                    }
                } else if (iPA == 1) {
                    z = z2;
                }
            }
            if (z) {
                BF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pA(final boolean z, boolean z2, final Runnable runnable) {
        if (!z2 && WQf().SGo().getBoolean("user_has_give_up_reward", false) && (WQf.omh(this.KZx.Og) || runnable != null)) {
            if (runnable == null) {
                lT();
            }
            return false;
        }
        if (!aBv.ZZv().omh(String.valueOf(this.KZx.JG))) {
            if (runnable == null) {
                if (z) {
                    du();
                    return false;
                }
                lT();
            }
            return false;
        }
        if (WQf().SGo().getBoolean("reward_verify", false)) {
            if (runnable == null) {
                if (WQf.omh(this.KZx.Og)) {
                    lT();
                    return false;
                }
                if (z) {
                    du();
                    return false;
                }
                lT();
            }
            return false;
        }
        this.KZx.vZF.set(true);
        this.KZx.BF.DX();
        if (z) {
            this.KZx.TV.Sn();
        }
        final com.bytedance.sdk.openadsdk.core.widget.Og og = new com.bytedance.sdk.openadsdk.core.widget.Og(TV());
        this.Og.Wx = og;
        if (z) {
            this.Og.Wx.pA(Wx).Og(Sn).KZx(DX);
        } else {
            this.Og.Wx.pA(oX).Og(aBv).KZx(DX);
        }
        this.Og.Wx.pA(new com.bytedance.sdk.openadsdk.core.widget.Og.pA() { // from class: com.bytedance.sdk.openadsdk.activity.ML.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.Og.pA
            public void pA() {
                ML.this.KZx.BF.Sn();
                if (z) {
                    ML.this.KZx.TV.ML(1000);
                }
                og.dismiss();
                ML.this.KZx.vZF.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.Og.pA
            public void Og() {
                og.dismiss();
                ML.this.WQf().SGo().putBoolean("user_has_give_up_reward", true);
                ML.this.KZx.vZF.set(false);
                ML.this.KZx.TV.JG(Integer.MAX_VALUE);
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                    return;
                }
                if (!z) {
                    ML.this.lT();
                    return;
                }
                if (WQf.omh(ML.this.KZx.Og)) {
                    if (!ML.this.KZx.TV.pA()) {
                        ML.this.lT();
                        return;
                    } else {
                        ML.this.KZx.TV.pA(5);
                        return;
                    }
                }
                ML.this.KZx.roi.JG();
                if (ML.this.KZx.TV.pA()) {
                    ML.this.KZx.TV.pA(4);
                }
                ML.this.du();
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
            jSONObject.put("play_start_ts", this.JG);
            jSONObject.put("play_end_ts", this.ML);
            jSONObject.put("duration", iVZF);
            jSONObject.put("user_id", this.XT);
            jSONObject.put("trans_id", com.bytedance.sdk.openadsdk.utils.WQf.pA().replace("-", ""));
            return jSONObject;
        } catch (Throwable th) {
            WV.pA("TTAD.RewardAdScene", "", th);
            return null;
        }
    }

    public void BF() {
        if (WQf().SGo().getBoolean("reward_verify", false) || WQf().Sn()) {
            return;
        }
        WQf().SGo().putBoolean("reward_verify", true);
        if (aBv.ZZv().oX(String.valueOf(this.KZx.JG))) {
            pA(true, this.KZx.Og.TX(), this.KZx.Og.Sd(), 0, "");
        } else {
            aBv.KZx().pA(IG(), new com.bytedance.sdk.openadsdk.core.yFO.Og() { // from class: com.bytedance.sdk.openadsdk.activity.ML.6
                @Override // com.bytedance.sdk.openadsdk.core.yFO.Og
                public void pA(int i, String str) {
                    ML.this.pA(false, 0, "", i, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.yFO.Og
                public void pA(vZF.Og og) {
                    boolean z = og.Og;
                    ML.this.pA(og.Og, og.KZx.pA(), og.KZx.Og(), 0, "");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0078  */
    public void lT() {
        com.bytedance.sdk.openadsdk.ZZv.ML.Og.DX.pA pAVar = new com.bytedance.sdk.openadsdk.ZZv.ML.Og.DX.pA();
        pAVar.pA(this.KZx.BF.SD());
        pAVar.KZx(this.KZx.BF.yFO());
        pAVar.Og(this.KZx.BF.BSW());
        pAVar.KZx(3);
        pAVar.ZZv(this.KZx.BF.XT());
        com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.pA(this.KZx.BF.KZx(), pAVar, this.KZx.BF.pA());
        com.bytedance.sdk.openadsdk.core.WQf.KZx(this.KZx.JG);
        this.KZx.BF.pA(EventConstants.SKIP, false);
        if (this.KZx.KZx) {
            pA(true, 4);
            if (com.bytedance.sdk.openadsdk.core.model.aBv.pA(this.KZx.Og) && !this.KZx.oX.get()) {
                du();
            }
        } else {
            du();
        }
        com.bytedance.sdk.openadsdk.core.WV.pA pAVarDGZ = this.KZx.Og.dGZ();
        if (pAVarDGZ != null) {
            com.bytedance.sdk.openadsdk.core.WV.ZZv zZvPA = pAVarDGZ.pA();
            long jSD = this.KZx.BF.SD();
            zZvPA.JG(jSD);
            zZvPA.ML(jSD);
        }
        com.bytedance.sdk.openadsdk.BF.Og.ML.pA(this.KZx.Og, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.pA, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void pA(final String str, final JSONObject jSONObject) {
        if ("skipToNextAd".equals(str) && this.KZx.RS != null && WQf().JG() == null && pA(WQf.KZx(this.KZx.Og), false, new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.ML.7
            @Override // java.lang.Runnable
            public void run() {
                ML.super.pA(str, jSONObject);
            }
        })) {
            return;
        }
        super.pA(str, jSONObject);
    }
}
