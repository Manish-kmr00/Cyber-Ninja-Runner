package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.DX;
import com.bytedance.sdk.openadsdk.ZZv.SD;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.reward.Og.Bzk;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Wx;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.HashMap;
import java.util.Iterator;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class ZZv extends pA {
    private boolean JG;
    int ML;

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    protected boolean a_() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.pA, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void pA(Bundle bundle) {
    }

    public ZZv(Og og, yFO yfo, int i) {
        super(og, yfo, i);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.pA
    public void Og() {
        if (!yFO.ML(this.KZx.Og) && !this.KZx.KZx) {
            this.KZx.qmB.pA(null, "X");
        } else {
            this.KZx.qmB.pA(null, TTAdDislikeToast.getSkipText());
        }
        this.KZx.qmB.ML(true);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.pA, com.bytedance.sdk.openadsdk.activity.JG
    public void KZx(Activity activity) {
        super.KZx(activity);
        if (this.KZx == null || !Og(this.KZx.Og) || pA(this.KZx.Og)) {
            return;
        }
        if (this.JG) {
            this.JG = false;
            du();
        } else if (this.KZx.rB.xy()) {
            du();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.JG
    public String b_() {
        return "fullscreen_interstitial_ad";
    }

    private boolean pA(yFO yfo) {
        return yfo == null || yfo.slz() == 100.0f;
    }

    private boolean Og(yFO yfo) {
        if (yfo == null) {
            return false;
        }
        return aBv.ZZv().vZF(String.valueOf(this.KZx.JG));
    }

    @Override // com.bytedance.sdk.openadsdk.activity.pA
    protected void KZx() {
        final View viewSGo = this.KZx.Vgu.SGo();
        if (viewSGo != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.ZZv.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/ZZv$1;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_ZZv$1_onClick_0817da4e44a0ed19f6effa2f1d8530d8(view);
                }

                /* JADX WARN: Code duplicated, block: B:28:0x00d8  */
                public void safedk_ZZv$1_onClick_0817da4e44a0ed19f6effa2f1d8530d8(View p0) {
                    boolean zML;
                    if (ZZv.this.KZx.rB.du() && ZZv.this.KZx.SGo.get()) {
                        boolean zWx = ZZv.this.KZx.xy.Wx();
                        ZZv.this.KZx.rB.ML(zWx);
                        ZZv.this.KZx.Vgu.ML(8);
                        ZZv.this.KZx.Bf.sendEmptyMessageDelayed(600, 5000L);
                        if (!yFO.KZx(ZZv.this.KZx.Og)) {
                            return;
                        }
                        if (yFO.KZx(ZZv.this.KZx.Og) && zWx) {
                            return;
                        }
                    }
                    if (!ZZv.this.KZx.Og.Fb()) {
                        zML = false;
                    } else if (ZZv.this.KZx.Og.rjD()) {
                        if (ZZv.this.KZx.gbA != null) {
                            ZZv.this.KZx.Og.xy(2);
                            zML = ZZv.this.KZx.gbA.ML();
                        } else {
                            zML = false;
                        }
                    } else if (ZZv.this.KZx.Og.Lf() != 0 || ZZv.this.KZx.rB.aBv()) {
                        zML = false;
                    } else {
                        ZZv.this.KZx.Og.xy(11);
                        if (ZZv.this.KZx.rB.ZZv()) {
                            ZZv.this.KZx.Og.xy(12);
                        }
                        try {
                            ZZv.this.KZx.Vgu.aBv();
                            zML = true;
                        } catch (Exception unused) {
                            zML = false;
                        }
                    }
                    if (zML) {
                        return;
                    }
                    ZZv.this.KZx.rB.eG();
                    ZZv.this.KZx.xy.BSW();
                    ZZv.this.KZx.roi.JG();
                    ZZv.this.du();
                }
            };
            viewSGo.setOnClickListener(onClickListener);
            viewSGo.setTag(viewSGo.getId(), onClickListener);
        }
        this.KZx.qmB.pA(new com.bytedance.sdk.openadsdk.component.reward.top.Og() { // from class: com.bytedance.sdk.openadsdk.activity.ZZv.2
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.Og
            public void pA(View view) {
                if (WQf.omh(ZZv.this.KZx.Og) && (WQf.XT(ZZv.this.KZx.Og) || ZZv.this.KZx.SGo.get())) {
                    if (ZZv.this.KZx.TV.pA()) {
                        ZZv.this.KZx.TV.pA(5);
                        return;
                    } else {
                        ZZv.this.KZx.rB.omh();
                        return;
                    }
                }
                if (WQf.XT(ZZv.this.KZx.Og) || (com.bytedance.sdk.openadsdk.core.model.aBv.pA(ZZv.this.KZx.Og) && !ZZv.this.KZx.oX.get())) {
                    if (!WQf.omh(ZZv.this.KZx.Og) && ZZv.this.KZx.TV.pA()) {
                        ZZv.this.KZx.TV.pA(4);
                    }
                    ZZv.this.du();
                    return;
                }
                if (ZZv.this.KZx.Og.iC()) {
                    if (ZZv.this.KZx.Vgu.BSW() != null) {
                        ZZv.this.KZx.Og.xy(2);
                        ZZv.this.KZx.Vgu.aBv();
                        return;
                    }
                    return;
                }
                if (!ZZv.this.KZx.KZx && ZZv.this.KZx.Og.Fb() && !ZZv.this.KZx.Og.rjD()) {
                    ZZv.this.KZx.Og.xy(13);
                    try {
                        ZZv.this.KZx.Vgu.aBv();
                        return;
                    } catch (Exception unused) {
                    }
                }
                DX.pA pAVar = new DX.pA();
                pAVar.pA(ZZv.this.KZx.BF.SD());
                pAVar.KZx(ZZv.this.KZx.BF.yFO());
                pAVar.Og(ZZv.this.KZx.BF.BSW());
                pAVar.KZx(3);
                pAVar.ZZv(ZZv.this.KZx.BF.XT());
                com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.pA(ZZv.this.KZx.BF.KZx(), pAVar, ZZv.this.KZx.BF.pA());
                com.bytedance.sdk.openadsdk.core.WQf.KZx(ZZv.this.KZx.JG);
                ZZv.this.KZx.BF.pA(EventConstants.SKIP, false);
                ZZv.this.KZx.qmB.ZZv(false);
                if (ZZv.this.KZx.KZx) {
                    ZZv.this.pA(true, 4);
                } else {
                    ZZv.this.du();
                }
                if (ZZv.this.KZx.Og != null && ZZv.this.KZx.Og.dGZ() != null && ZZv.this.KZx.BF != null) {
                    ZZv.this.KZx.Og.dGZ().pA().JG(ZZv.this.KZx.BF.SD());
                    ZZv.this.KZx.Og.dGZ().pA().ML(ZZv.this.KZx.BF.SD());
                }
                com.bytedance.sdk.openadsdk.BF.Og.ML.pA(ZZv.this.KZx.Og, 5);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.Og
            public void Og(View view) {
                ZZv.this.KZx.agB = !ZZv.this.KZx.agB;
                if (ZZv.this.Og != null && ZZv.this.Og.ZZv() != null) {
                    ZZv.this.Og.ZZv().pA(ZZv.this.KZx.agB);
                }
                ZZv.this.KZx.BF.Og(ZZv.this.KZx.agB);
                if (!WQf.yFO(ZZv.this.KZx.Og) || ZZv.this.KZx.SGo.get()) {
                    if (WQf.SD(ZZv.this.KZx.Og)) {
                        ZZv.this.KZx.lT.pA(ZZv.this.KZx.agB, true);
                    }
                    ZZv.this.KZx.rB.ZZv(ZZv.this.KZx.agB);
                    if (ZZv.this.KZx.Og == null || ZZv.this.KZx.Og.dGZ() == null || ZZv.this.KZx.Og.dGZ().pA() == null || ZZv.this.KZx.BF == null) {
                        return;
                    }
                    if (ZZv.this.KZx.agB) {
                        ZZv.this.KZx.Og.dGZ().pA().omh(ZZv.this.KZx.BF.SD());
                    } else {
                        ZZv.this.KZx.Og.dGZ().pA().Bzk(ZZv.this.KZx.BF.SD());
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.Og
            public void KZx(View view) {
                ZZv.this.KZx.IG.pA(ZZv.this.Og);
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

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public boolean pA(long j, boolean z) {
        SD sd;
        if (this.omh.pA()) {
            if (this.KZx.du != null && this.KZx.du.pA() != null) {
                sd = this.KZx.du.pA().getAdShowTime();
            } else {
                sd = new SD();
            }
            if (this.Og != null && (this.Og instanceof Bzk) && !this.KZx.fJy) {
                this.KZx.BF.pA(((Bzk) this.Og).Mc(), sd);
            } else {
                this.KZx.BF.pA(this.KZx.du.Og(), sd);
            }
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
            this.KZx.BF.pA(new com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.activity.ZZv.3
                boolean pA;

                @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
                public void pA(long j2, int i) {
                    if (this.pA) {
                        return;
                    }
                    this.pA = true;
                    ZZv.this.pA.removeMessages(300);
                    ZZv.this.Wx();
                    ZZv.this.KZx.BF.pA(j2, j2);
                    ZZv.this.KZx.du.Og(true);
                    if (ZZv.this.KZx.Og.aBv() == 36 && ZZv.this.KZx.KZx) {
                        ZZv.this.KZx.WQf.KZx().ZZv();
                        Wx.Og();
                    }
                    if (ZZv.this.KZx.Og.aBv() == 21 && !ZZv.this.KZx.Og.ZZv()) {
                        ZZv.this.KZx.Og.Og(true);
                        ZZv.this.KZx.Vgu.aBv();
                    }
                    if (ZZv.this.KZx.Itl) {
                        Og.ML mlOg = ZZv.this.Og(5);
                        mlOg.ML = true;
                        ZZv.this.WQf().pA(ZZv.this, mlOg);
                        return;
                    }
                    if (ZZv.this.KZx.KZx) {
                        if (ZZv.this.KZx.Og.xkc()) {
                            if (ZZv.this.KZx.du.Bzk() == 1) {
                                ZZv.this.KZx.qmB.KZx();
                                return;
                            }
                            return;
                        } else {
                            ZZv.this.pA(false, 5);
                            if (yFO.ML(ZZv.this.KZx.Og)) {
                                return;
                            }
                            ZZv.this.KZx.BF.pA(EventConstants.SKIP, true);
                            return;
                        }
                    }
                    if (yFO.ML(ZZv.this.KZx.Og)) {
                        ZZv.this.du();
                        return;
                    }
                    if (ZZv.this.KZx.du == null || ZZv.this.KZx.du.pA() == null) {
                        return;
                    }
                    ZZv.this.KZx.du.pA().setTime("0", 0, 0, false);
                    if (ZZv.this.KZx.du.omh()) {
                        ZZv.this.KZx.qmB.pA("0", "X");
                        ZZv.this.KZx.qmB.ML(true);
                        ZZv.this.KZx.qmB.KZx();
                    }
                }

                @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
                public void Og(long j2, int i) {
                    ZZv.this.pA.removeMessages(300);
                    if (ZZv.this.KZx.BF.Og()) {
                        ZZv.this.ML();
                        return;
                    }
                    ZZv.this.KZx.BF.Wx();
                    WV.pA("TTAD.AdScene", "fullscreen_interstitial_ad", "onError、、、、、、、、");
                    ZZv.this.KZx.du.pA(true);
                    Og ogWQf = ZZv.this.WQf();
                    ZZv zZv = ZZv.this;
                    ogWQf.pA(zZv, zZv.Og(3));
                }

                @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
                public void pA() {
                    ZZv.this.pA.removeMessages(300);
                    ZZv.this.Wx();
                    new Object[]{"fullscreen_interstitial_ad", "onTimeOut、、、、、、、、"};
                    Og ogWQf = ZZv.this.WQf();
                    ZZv zZv = ZZv.this;
                    ogWQf.pA(zZv, zZv.Og(6));
                }

                @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
                public void pA(long j2, long j3) {
                    if (!ZZv.this.KZx.fN && ZZv.this.KZx.BF.Og()) {
                        ZZv.this.KZx.BF.DX();
                    }
                    if (ZZv.this.KZx.SGo.get()) {
                        return;
                    }
                    ZZv.this.pA.removeMessages(300);
                    if (j2 != ZZv.this.KZx.BF.omh()) {
                        ZZv.this.Wx();
                    }
                    if (ZZv.this.KZx.BF.Og()) {
                        ZZv.this.KZx.BF.pA(j2, j3);
                        ZZv zZv = ZZv.this;
                        long j4 = j2 / 1000;
                        zZv.ML = (int) (zZv.KZx.BF.roi() - j4);
                        int i = (int) j4;
                        if ((ZZv.this.KZx.vZF.get() || ZZv.this.KZx.BSW.get()) && ZZv.this.KZx.BF.Og()) {
                            ZZv.this.KZx.BF.DX();
                        }
                        if (ZZv.this.KZx.du != null && ZZv.this.KZx.du.pA() != null) {
                            ZZv.this.KZx.du.pA().setTime(String.valueOf(ZZv.this.ML), i, 0, false);
                        }
                        ZZv.this.pA((j2 * 1.0f) / j3);
                        if (ZZv.this.KZx.du.omh() || ZZv.this.KZx.Og.qH()) {
                            ZZv.this.ZZv(i);
                            if (ZZv.this.ML >= 0) {
                                ZZv.this.KZx.qmB.ZZv(true);
                                ZZv.this.KZx.qmB.pA(String.valueOf(ZZv.this.ML), null);
                            }
                        }
                    }
                }
            });
            return this.KZx.BF.pA(j, z, map, this.Og);
        }
        SD sd2 = new SD();
        sd2.pA(System.currentTimeMillis(), 1.0f);
        if (this.Og != null && (this.Og instanceof Bzk)) {
            this.KZx.BF.pA(((Bzk) this.Og).Mc(), sd2);
        } else {
            this.KZx.BF.pA(this.KZx.Vgu.JG(), sd2);
        }
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA pAVar = new com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.activity.ZZv.4
            boolean pA;

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void pA(long j2, int i) {
                if (this.pA) {
                    return;
                }
                this.pA = true;
                ZZv.this.pA.removeMessages(300);
                ZZv.this.Wx();
                ZZv.this.KZx.BF.pA(j2, j2);
                ZZv.this.KZx.yFO.set(true);
                if (ZZv.this.KZx.Og.Zc()) {
                    ZZv.this.KZx.Og.xy(1);
                    ZZv.this.KZx.Vgu.aBv();
                }
                if (ZZv.this.KZx.Og.aBv() == 21 && !ZZv.this.KZx.Og.ZZv()) {
                    ZZv.this.KZx.Og.Og(true);
                    ZZv.this.KZx.Vgu.aBv();
                }
                if (ZZv.this.KZx.Itl) {
                    Og.ML mlOg = ZZv.this.Og(5);
                    mlOg.ML = true;
                    ZZv.this.WQf().pA(ZZv.this, mlOg);
                    return;
                }
                if (ZZv.this.KZx.KZx) {
                    if (ZZv.this.KZx.Og.xkc()) {
                        ZZv.this.KZx.qmB.KZx();
                        return;
                    }
                    ZZv.this.pA(false, 5);
                    if (com.bytedance.sdk.openadsdk.core.model.aBv.Og(ZZv.this.KZx.Og) && ZZv.this.KZx.Wo != null) {
                        ZZv.this.KZx.Wo.pA(0L);
                    }
                    if (yFO.ML(ZZv.this.KZx.Og)) {
                        return;
                    }
                    ZZv.this.KZx.BF.pA(EventConstants.SKIP, true);
                    return;
                }
                if (ZZv.this.KZx.Og.xkc()) {
                    ZZv.this.KZx.qmB.KZx();
                    return;
                }
                if (!yFO.ML(ZZv.this.KZx.Og)) {
                    ZZv.this.KZx.BF.pA(EventConstants.SKIP, true);
                }
                ZZv.this.du();
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void Og(long j2, int i) {
                ZZv.this.pA.removeMessages(300);
                if (ZZv.this.KZx.BF.Og()) {
                    ZZv.this.ML();
                    return;
                }
                ZZv.this.KZx.BF.Wx();
                Og ogWQf = ZZv.this.WQf();
                ZZv zZv = ZZv.this;
                ogWQf.pA(zZv, zZv.Og(3));
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void pA() {
                ZZv.this.pA.removeMessages(300);
                ZZv.this.Wx();
                new Object[]{"fullscreen_interstitial_ad", "onTimeOut、、、、、、、、"};
                Og ogWQf = ZZv.this.WQf();
                ZZv zZv = ZZv.this;
                ogWQf.pA(zZv, zZv.Og(6));
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void pA(long j2, long j3) {
                if (!ZZv.this.KZx.fN && ZZv.this.KZx.BF.Og()) {
                    ZZv.this.KZx.BF.DX();
                }
                if (ZZv.this.KZx.SGo.get()) {
                    return;
                }
                ZZv.this.pA.removeMessages(300);
                if (j2 != ZZv.this.KZx.BF.omh()) {
                    ZZv.this.Wx();
                }
                ZZv.this.KZx.BF.pA(j2, j3);
                ZZv zZv = ZZv.this;
                long j4 = j2 / 1000;
                zZv.ML = (int) (zZv.KZx.BF.roi() - j4);
                int i = (int) j4;
                if ((ZZv.this.KZx.vZF.get() || ZZv.this.KZx.BSW.get()) && ZZv.this.KZx.BF.Og()) {
                    ZZv.this.KZx.BF.DX();
                }
                ZZv.this.ZZv(i);
                ZZv.this.pA((j2 * 1.0f) / j3);
                if (ZZv.this.ML >= 0) {
                    ZZv.this.KZx.qmB.pA(String.valueOf(ZZv.this.ML), null);
                }
            }
        };
        this.KZx.BF.pA(pAVar);
        if (this.KZx.Vgu.DX != null) {
            this.KZx.Vgu.DX.pA(pAVar);
        }
        return this.KZx.BF.pA(j, z, null, this.Og);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZZv(int i) {
        int iYFO = aBv.ZZv().yFO(String.valueOf(this.KZx.JG));
        if (!aBv.ZZv().JG(String.valueOf(this.KZx.JG)) || (!yFO.ML(this.KZx.Og) && !this.KZx.KZx)) {
            if (i >= iYFO) {
                if (!this.KZx.cFQ) {
                    this.KZx.pA(true);
                }
                Og();
                return;
            }
            return;
        }
        if (!this.KZx.cFQ) {
            this.KZx.pA(true);
        }
        if (i <= iYFO) {
            ML(iYFO - i);
            this.KZx.qmB.ML(false);
        } else {
            Og();
        }
    }

    private void ML(int i) {
        this.KZx.qmB.pA(null, new SpannableStringBuilder(String.format(com.bytedance.sdk.component.utils.yFO.pA(aBv.pA(), "tt_skip_ad_time_text"), Integer.valueOf(i))));
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void c_() {
        if (this.KZx.Og.slz() != 100.0f) {
            this.JG = true;
        }
        Mc();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.pA
    protected void SD() {
        roi();
        if (this.omh.pA()) {
            this.KZx.du.SGo();
        }
    }
}
