package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.DX;
import com.bytedance.sdk.openadsdk.ZZv.SD;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.reward.Og.Bzk;
import com.bytedance.sdk.openadsdk.core.TV;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.TX;
import com.bytedance.sdk.openadsdk.utils.Wx;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    private static com.bytedance.sdk.openadsdk.pA.KZx.Og WV;
    private com.bytedance.sdk.openadsdk.pA.KZx.Og BSW;
    private boolean Wx;

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void Sn() {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean aBv() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.u, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void pA(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void pA(String str, JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void pA(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        WV = this.BSW;
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        com.bytedance.sdk.openadsdk.component.reward.view.Og ogPA;
        super.onResume();
        if (this.Og == null || (ogPA = this.Og.du.pA()) == null) {
            return;
        }
        ogPA.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.JG() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.JG
            public void pA() {
                TTFullScreenVideoActivity.this.yFO();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.Og == null || yFO.ML(this.Og.Og)) {
            return;
        }
        com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogBf = this.Og.Og.Bf();
        if (ogBf == null) {
            com.bykv.vk.openvk.pA.pA.pA.KZx.Og og = new com.bykv.vk.openvk.pA.pA.pA.KZx.Og();
            og.pA(10.0d);
            this.Og.Og.pA(og);
        } else if (ogBf.JG() <= 0.0d) {
            ogBf.pA(10.0d);
        }
    }

    private void pA(final String str) {
        xy.KZx(new omh("FullScreen_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTFullScreenVideoActivity.this.Og(1).executeFullVideoCallback(TTFullScreenVideoActivity.this.Og.JBA, str);
                } catch (Throwable th) {
                    WV.pA("TTAD.FSVA", "fullscreen_interstitial_ad", "executeFullVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void pA(Intent intent) {
        super.pA(intent);
        this.Og.lx = intent.getBooleanExtra("is_verity_playable", false);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void pA(Bundle bundle) {
        if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            this.BSW = TV.pA().ZZv();
        }
        if (this.BSW != null || bundle == null) {
            return;
        }
        this.BSW = WV;
        WV = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void oX() {
        final View viewSGo = this.Og.Vgu.SGo();
        if (viewSGo != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTFullScreenVideoActivity$3;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_TTFullScreenVideoActivity$3_onClick_2f865e131fb3fb8612e640b50ce81baa(view);
                }

                /* JADX WARN: Code duplicated, block: B:31:0x00f0  */
                public void safedk_TTFullScreenVideoActivity$3_onClick_2f865e131fb3fb8612e640b50ce81baa(View p0) {
                    boolean zML;
                    if (TTFullScreenVideoActivity.this.Og.rB.du() && TTFullScreenVideoActivity.this.Og.SGo.get()) {
                        boolean zWx = TTFullScreenVideoActivity.this.Og.xy.Wx();
                        TTFullScreenVideoActivity.this.Og.rB.ML(zWx);
                        TTFullScreenVideoActivity.this.Og.Vgu.ML(8);
                        View view = viewSGo;
                        if (view instanceof com.bytedance.sdk.openadsdk.core.ML.ZZv) {
                            ((com.bytedance.sdk.openadsdk.core.ML.ZZv) view).setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(TTFullScreenVideoActivity.this.Og.Gx, "tt_close_btn"));
                        }
                        TTFullScreenVideoActivity.this.Og.Bf.sendEmptyMessageDelayed(600, 5000L);
                        if (!yFO.KZx(TTFullScreenVideoActivity.this.Og.Og)) {
                            return;
                        }
                        if (yFO.KZx(TTFullScreenVideoActivity.this.Og.Og) && zWx) {
                            return;
                        }
                    }
                    if (!TTFullScreenVideoActivity.this.Og.Og.Fb()) {
                        zML = false;
                    } else if (TTFullScreenVideoActivity.this.Og.Og.rjD()) {
                        if (TTFullScreenVideoActivity.this.Og.gbA != null) {
                            TTFullScreenVideoActivity.this.Og.Og.xy(2);
                            zML = TTFullScreenVideoActivity.this.Og.gbA.ML();
                        } else {
                            zML = false;
                        }
                    } else if (TTFullScreenVideoActivity.this.Og.Og.Lf() != 0 || TTFullScreenVideoActivity.this.Og.rB.aBv()) {
                        zML = false;
                    } else {
                        TTFullScreenVideoActivity.this.Og.Og.xy(11);
                        if (TTFullScreenVideoActivity.this.Og.rB.ZZv()) {
                            TTFullScreenVideoActivity.this.Og.Og.xy(12);
                        }
                        try {
                            TTFullScreenVideoActivity.this.Og.Vgu.aBv();
                            zML = true;
                        } catch (Exception unused) {
                            zML = false;
                        }
                    }
                    if (zML) {
                        return;
                    }
                    TTFullScreenVideoActivity.this.Og.rB.eG();
                    TTFullScreenVideoActivity.this.Og.xy.BSW();
                    TTFullScreenVideoActivity.this.Og.roi.JG();
                    TTFullScreenVideoActivity.this.finish();
                }
            };
            viewSGo.setOnClickListener(onClickListener);
            viewSGo.setTag(viewSGo.getId(), onClickListener);
        }
        this.Og.qmB.pA(new com.bytedance.sdk.openadsdk.component.reward.top.Og() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.Og
            public void pA(View view) {
                com.bytedance.sdk.openadsdk.component.reward.view.Og ogPA;
                if (WQf.JG(TTFullScreenVideoActivity.this.Og.Og) || (WQf.ML(TTFullScreenVideoActivity.this.Og.Og) && TTFullScreenVideoActivity.this.Og.TV.omh(com.bytedance.sdk.openadsdk.component.reward.pA.omh.Og))) {
                    if (WQf.SGo(TTFullScreenVideoActivity.this.Og.Og)) {
                        TTFullScreenVideoActivity.this.Og.TV.aBv();
                        return;
                    }
                    View view2 = viewSGo;
                    if (view2 != null) {
                        view2.performClick();
                        return;
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                        return;
                    }
                }
                if (WQf.omh(TTFullScreenVideoActivity.this.Og.Og) && (WQf.XT(TTFullScreenVideoActivity.this.Og.Og) || TTFullScreenVideoActivity.this.Og.SGo.get())) {
                    if (TTFullScreenVideoActivity.this.Og.TV.pA()) {
                        TTFullScreenVideoActivity.this.Og.TV.pA(5);
                        return;
                    } else {
                        TTFullScreenVideoActivity.this.Og.rB.omh();
                        return;
                    }
                }
                if (WQf.XT(TTFullScreenVideoActivity.this.Og.Og) || (aBv.pA(TTFullScreenVideoActivity.this.Og.Og) && !TTFullScreenVideoActivity.this.Og.oX.get())) {
                    if (!WQf.omh(TTFullScreenVideoActivity.this.Og.Og) && TTFullScreenVideoActivity.this.Og.TV.pA()) {
                        TTFullScreenVideoActivity.this.Og.TV.pA(4);
                    }
                    TTFullScreenVideoActivity.this.finish();
                    return;
                }
                if (TTFullScreenVideoActivity.this.Og.Og.iC()) {
                    if (TTFullScreenVideoActivity.this.Og.Vgu.BSW() != null) {
                        TTFullScreenVideoActivity.this.Og.Og.xy(2);
                        TTFullScreenVideoActivity.this.Og.Vgu.aBv();
                        return;
                    }
                    return;
                }
                if (!TTFullScreenVideoActivity.this.Og.KZx && TTFullScreenVideoActivity.this.Og.Og.Fb() && !TTFullScreenVideoActivity.this.Og.Og.rjD()) {
                    TTFullScreenVideoActivity.this.Og.Og.xy(13);
                    try {
                        TTFullScreenVideoActivity.this.Og.Vgu.aBv();
                        return;
                    } catch (Exception unused) {
                    }
                }
                DX.pA pAVar = new DX.pA();
                pAVar.pA(TTFullScreenVideoActivity.this.Og.BF.SD());
                pAVar.KZx(TTFullScreenVideoActivity.this.Og.BF.yFO());
                pAVar.Og(TTFullScreenVideoActivity.this.Og.BF.BSW());
                pAVar.KZx(3);
                pAVar.ZZv(TTFullScreenVideoActivity.this.Og.BF.XT());
                com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.pA(TTFullScreenVideoActivity.this.Og.BF.KZx(), pAVar, TTFullScreenVideoActivity.this.Og.BF.pA());
                com.bytedance.sdk.openadsdk.core.WQf.KZx(TTFullScreenVideoActivity.this.Og.JG);
                TTFullScreenVideoActivity.this.Og.BF.pA(EventConstants.SKIP, false);
                TTFullScreenVideoActivity.this.Og.qmB.ZZv(false);
                if (TTFullScreenVideoActivity.this.Og.KZx && (!aBv.KZx(TTFullScreenVideoActivity.this.Og.Og) || (ogPA = TTFullScreenVideoActivity.this.Og.du.pA()) == null || ogPA.ZZv != 0)) {
                    TTFullScreenVideoActivity.this.pA(true, 4);
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
                if (TTFullScreenVideoActivity.this.Og.Og != null && TTFullScreenVideoActivity.this.Og.Og.dGZ() != null && TTFullScreenVideoActivity.this.Og.BF != null) {
                    TTFullScreenVideoActivity.this.Og.Og.dGZ().pA().JG(TTFullScreenVideoActivity.this.Og.BF.SD());
                    TTFullScreenVideoActivity.this.Og.Og.dGZ().pA().ML(TTFullScreenVideoActivity.this.Og.BF.SD());
                }
                com.bytedance.sdk.openadsdk.BF.Og.ML.pA(TTFullScreenVideoActivity.this.Og.Og, 5);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.Og
            public void Og(View view) {
                TTFullScreenVideoActivity.this.Og.agB = !TTFullScreenVideoActivity.this.Og.agB;
                if (TTFullScreenVideoActivity.this.KZx != null && TTFullScreenVideoActivity.this.KZx.ZZv() != null) {
                    TTFullScreenVideoActivity.this.KZx.ZZv().pA(TTFullScreenVideoActivity.this.Og.agB);
                }
                TTFullScreenVideoActivity.this.Og.BF.Og(TTFullScreenVideoActivity.this.Og.agB);
                if (!WQf.yFO(TTFullScreenVideoActivity.this.Og.Og) || TTFullScreenVideoActivity.this.Og.SGo.get()) {
                    if (WQf.SD(TTFullScreenVideoActivity.this.Og.Og)) {
                        TTFullScreenVideoActivity.this.Og.lT.pA(TTFullScreenVideoActivity.this.Og.agB, true);
                    }
                    TTFullScreenVideoActivity.this.Og.rB.ZZv(TTFullScreenVideoActivity.this.Og.agB);
                    TTFullScreenVideoActivity.this.Og.TV.JG(TTFullScreenVideoActivity.this.Og.agB);
                    if (TTFullScreenVideoActivity.this.Og.Og == null || TTFullScreenVideoActivity.this.Og.Og.dGZ() == null || TTFullScreenVideoActivity.this.Og.Og.dGZ().pA() == null || TTFullScreenVideoActivity.this.Og.BF == null) {
                        return;
                    }
                    if (TTFullScreenVideoActivity.this.Og.agB) {
                        TTFullScreenVideoActivity.this.Og.Og.dGZ().pA().omh(TTFullScreenVideoActivity.this.Og.BF.SD());
                    } else {
                        TTFullScreenVideoActivity.this.Og.Og.dGZ().pA().Bzk(TTFullScreenVideoActivity.this.Og.BF.SD());
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.Og
            public void KZx(View view) {
                TTFullScreenVideoActivity.this.Og.IG.pA(TTFullScreenVideoActivity.this.KZx);
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

    public boolean pA(long j, boolean z) {
        SD sd = new SD();
        sd.pA(System.currentTimeMillis(), 1.0f);
        if (this.KZx != null && (this.KZx instanceof Bzk)) {
            this.Og.BF.pA(((Bzk) this.KZx).Mc(), sd);
        } else {
            this.Og.BF.pA(this.Og.Vgu.JG(), sd);
        }
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA pAVar = new com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.5
            boolean pA;

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void pA(long j2, int i) {
                if (this.pA) {
                    return;
                }
                this.pA = true;
                TTFullScreenVideoActivity.this.ZZv.removeMessages(300);
                TTFullScreenVideoActivity.this.DX();
                TTFullScreenVideoActivity.this.Og.BF.pA(j2, j2);
                TTFullScreenVideoActivity.this.Og.yFO.set(true);
                if (TTFullScreenVideoActivity.this.Og.Og.aBv() == 36 && TTFullScreenVideoActivity.this.Og.KZx) {
                    TTFullScreenVideoActivity.this.Og.WQf.KZx().ZZv();
                    Wx.Og();
                }
                if (TTFullScreenVideoActivity.this.Og.Og.Zc()) {
                    TTFullScreenVideoActivity.this.Og.Og.xy(1);
                    TTFullScreenVideoActivity.this.Og.Vgu.aBv();
                }
                if (TTFullScreenVideoActivity.this.Og.Og.aBv() == 21 && !TTFullScreenVideoActivity.this.Og.Og.ZZv()) {
                    TTFullScreenVideoActivity.this.Og.Og.Og(true);
                    TTFullScreenVideoActivity.this.Og.Vgu.aBv();
                }
                if (TTFullScreenVideoActivity.this.Og.KZx) {
                    if (TTFullScreenVideoActivity.this.Og.Og.xkc()) {
                        TTFullScreenVideoActivity.this.Og.qmB.KZx();
                        return;
                    }
                    TTFullScreenVideoActivity.this.pA(false, 5);
                    if (aBv.Og(TTFullScreenVideoActivity.this.Og.Og) && TTFullScreenVideoActivity.this.Og.Wo != null) {
                        TTFullScreenVideoActivity.this.Og.Wo.pA(0L);
                    }
                    if (yFO.ML(TTFullScreenVideoActivity.this.Og.Og)) {
                        return;
                    }
                    TTFullScreenVideoActivity.this.Og.BF.pA(EventConstants.SKIP, true);
                    return;
                }
                if (TTFullScreenVideoActivity.this.Og.Og.xkc()) {
                    TTFullScreenVideoActivity.this.Og.qmB.KZx();
                    return;
                }
                if (!yFO.ML(TTFullScreenVideoActivity.this.Og.Og)) {
                    TTFullScreenVideoActivity.this.Og.BF.pA(EventConstants.SKIP, true);
                }
                TTFullScreenVideoActivity.this.finish();
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void Og(long j2, int i) {
                TTFullScreenVideoActivity.this.ZZv.removeMessages(300);
                if (TTFullScreenVideoActivity.this.Og.BF.Og()) {
                    TTFullScreenVideoActivity.this.Wx();
                    return;
                }
                TTFullScreenVideoActivity.this.Og.BF.Wx();
                WV.pA("TTAD.FSVA", "fullscreen_interstitial_ad", "onError、、、、、、、、");
                if (TTFullScreenVideoActivity.this.Og.KZx) {
                    TTFullScreenVideoActivity.this.pA(false, true, 3);
                    TTFullScreenVideoActivity.this.Og.BF.pA(!TTFullScreenVideoActivity.this.Og.BF.eG() ? 1 : 0, 2);
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void pA() {
                TTFullScreenVideoActivity.this.ZZv.removeMessages(300);
                TTFullScreenVideoActivity.this.DX();
                new Object[]{"fullscreen_interstitial_ad", "onTimeOut、、、、、、、、"};
                if (TTFullScreenVideoActivity.this.Og.KZx) {
                    TTFullScreenVideoActivity.this.pA(false, true, 6);
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
                TTFullScreenVideoActivity.this.Og.BF.pA(!TTFullScreenVideoActivity.this.Og.BF.eG() ? 1 : 0, 1 ^ (TTFullScreenVideoActivity.this.Og.BF.eG() ? 1 : 0));
                TTFullScreenVideoActivity.this.Og.BF.Wx();
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void pA(long j2, long j3) {
                if (!TTFullScreenVideoActivity.this.Og.fN && TTFullScreenVideoActivity.this.Og.BF.Og()) {
                    TTFullScreenVideoActivity.this.Og.BF.DX();
                }
                if (TTFullScreenVideoActivity.this.Og.SGo.get()) {
                    return;
                }
                TTFullScreenVideoActivity.this.ZZv.removeMessages(300);
                if (j2 != TTFullScreenVideoActivity.this.Og.BF.omh()) {
                    TTFullScreenVideoActivity.this.DX();
                }
                TTFullScreenVideoActivity.this.Og.BF.pA(j2, j3);
                TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                long j4 = j2 / 1000;
                tTFullScreenVideoActivity.JG = (int) (tTFullScreenVideoActivity.Og.BF.roi() - j4);
                int i = (int) j4;
                if ((TTFullScreenVideoActivity.this.Og.vZF.get() || TTFullScreenVideoActivity.this.Og.BSW.get()) && TTFullScreenVideoActivity.this.Og.BF.Og()) {
                    TTFullScreenVideoActivity.this.Og.BF.DX();
                }
                TTFullScreenVideoActivity.this.KZx(i);
                if (TTFullScreenVideoActivity.this.JG >= 0) {
                    TTFullScreenVideoActivity.this.Og.qmB.pA(String.valueOf(TTFullScreenVideoActivity.this.JG), null);
                }
            }
        };
        this.Og.BF.pA(pAVar);
        if (this.Og.Vgu.DX != null) {
            this.Og.Vgu.DX.pA(pAVar);
        }
        return this.Og.BF.pA(j, z, null, this.KZx);
    }

    protected void KZx(int i) {
        int iYFO = com.bytedance.sdk.openadsdk.core.aBv.ZZv().yFO(String.valueOf(this.Og.JG));
        if (!com.bytedance.sdk.openadsdk.core.aBv.ZZv().JG(String.valueOf(this.Og.JG)) || (!yFO.ML(this.Og.Og) && !this.Og.KZx)) {
            if (i >= iYFO) {
                if (!this.Og.cFQ) {
                    this.Og.pA(true);
                }
                pA();
                return;
            }
            return;
        }
        if (!this.Og.cFQ) {
            this.Og.pA(true);
        }
        if (i <= iYFO) {
            ZZv(iYFO - i);
            this.Og.qmB.ML(false);
        } else {
            pA();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void pA() {
        if (!yFO.ML(this.Og.Og) && !this.Og.KZx) {
            this.Og.qmB.pA(null, "X");
        } else {
            this.Og.qmB.pA(null, TTAdDislikeToast.getSkipText());
        }
        this.Og.qmB.ML(true);
    }

    private void ZZv(int i) {
        this.Og.qmB.pA(null, String.format(com.bytedance.sdk.component.utils.yFO.pA(com.bytedance.sdk.openadsdk.core.aBv.pA(), "tt_skip_ad_time_text"), Integer.valueOf(i)));
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void c_() {
        if (this.Og.Og.slz() != 100.0f) {
            this.Wx = true;
        }
        yFO();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void ML() {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA("onAdShow");
        } else {
            com.bytedance.sdk.openadsdk.pA.KZx.Og og = this.BSW;
            if (og != null) {
                og.pA();
            }
        }
        if (XT()) {
            this.Og.du.SGo();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void ZZv() {
        yFO();
        this.Og.Og.Ky();
        this.Og.Og.pA(true);
        if (yFO.ML(this.Og.Og)) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.Og.Og, this.Og.ML, this.Og.Og.Io());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yFO() {
        TX.pA("BVA", "invoke callback onAdClicked, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA("onAdVideoBarClick");
            return;
        }
        com.bytedance.sdk.openadsdk.pA.KZx.Og og = this.BSW;
        if (og != null) {
            og.onAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        if (this.Og != null) {
            com.bytedance.sdk.openadsdk.JG.Og.pA().pA("videoForceBreak", this.Og.Og);
            this.Og.TV.pA(this.Og.lx);
        }
        try {
            vZF();
        } catch (Exception unused) {
        }
        super.finish();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        vZF();
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA("recycleRes");
        }
        this.BSW = null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        WV = null;
    }

    private void vZF() {
        if (this.omh) {
            return;
        }
        this.omh = true;
        TX.pA("BVA", "invoke callback onAdClose, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA("onAdClose");
            return;
        }
        com.bytedance.sdk.openadsdk.pA.KZx.Og og = this.BSW;
        if (og != null) {
            og.Og();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.Og == null || !Og(this.Og.Og) || pA(this.Og.Og)) {
            return;
        }
        if (this.Wx) {
            this.Wx = false;
            finish();
        } else if (this.Og.rB.xy()) {
            finish();
        }
    }

    private boolean pA(yFO yfo) {
        return yfo == null || yfo.slz() == 100.0f;
    }

    private boolean Og(yFO yfo) {
        if (yfo == null) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.core.aBv.ZZv().vZF(String.valueOf(this.Og.JG));
    }
}
