package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.component.utils.yFO;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.DX;
import com.bytedance.sdk.openadsdk.ZZv.SD;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.TV;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.vZF;
import com.bytedance.sdk.openadsdk.utils.TX;
import com.bytedance.sdk.openadsdk.utils.Wx;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.concurrent.atomic.AtomicBoolean;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private static String DX;
    private static com.bytedance.sdk.openadsdk.pA.ML.pA Sd;
    private static String Sn;
    private static String XT;
    private static String aBv;
    private static String oX;
    protected int BSW;
    private boolean WQf;
    protected int WV;
    protected com.bytedance.sdk.openadsdk.pA.ML.pA Wx;
    private String vZF;
    private String yFO;
    private final AtomicBoolean TX = new AtomicBoolean(false);
    private int BF = -1;

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean aBv() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.u, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void pA(String str, JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Sd = this.Wx;
        if (this.TX.get() && this.Og != null) {
            this.Og.Og.hP();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (Sn == null) {
                Sn = yFO.pA(this, "tt_reward_msg");
                DX = yFO.pA(this, "tt_msgPlayable");
                oX = yFO.pA(this, "tt_negtiveBtnBtnText");
                aBv = yFO.pA(this, "tt_postiveBtnText");
                XT = yFO.pA(this, "tt_postiveBtnTextPlayable");
            }
        } catch (Throwable th) {
            WV.pA("TTAD.RVA", th.getMessage());
        }
        if (bundle == null || this.Og == null || this.Og.Og == null || !this.Og.Og.DDZ()) {
            return;
        }
        this.TX.set(true);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        com.bytedance.sdk.openadsdk.component.reward.view.Og ogPA;
        super.onResume();
        if (this.Og == null || (ogPA = this.Og.du.pA()) == null) {
            return;
        }
        ogPA.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.JG() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.JG
            public void pA() {
                TTRewardVideoActivity.this.Sd();
            }
        });
    }

    protected void pA(String str) {
        pA(str, false, 0, "", 0, "");
    }

    protected void finalize() throws Throwable {
        super.finalize();
        Sd = null;
    }

    private void pA(final String str, final boolean z, final int i, final String str2, final int i2, final String str3) {
        xy.KZx(new omh("Reward_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTRewardVideoActivity.this.Og(0).executeRewardVideoCallback(TTRewardVideoActivity.this.Og.JBA, str, z, i, str2, i2, str3);
                } catch (Throwable th) {
                    WV.pA("TTAD.RVA", "rewarded_video", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void pA(Bundle bundle) {
        if (!com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            this.Wx = TV.pA().KZx();
        }
        if (this.Wx != null || bundle == null) {
            return;
        }
        this.Wx = Sd;
        Sd = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void pA() {
        this.Og.qmB.pA(null, TTAdDislikeToast.getSkipText());
        this.Og.qmB.ML(true);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void oX() {
        final View viewSGo = this.Og.Vgu.SGo();
        if (viewSGo != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTRewardVideoActivity$3;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_TTRewardVideoActivity$3_onClick_c8280702144fa07a55010ab26ab7cd7e(view);
                }

                /* JADX WARN: Code duplicated, block: B:31:0x00f0  */
                public void safedk_TTRewardVideoActivity$3_onClick_c8280702144fa07a55010ab26ab7cd7e(View p0) {
                    boolean zML;
                    if (TTRewardVideoActivity.this.Og.rB.du() && TTRewardVideoActivity.this.Og.SGo.get()) {
                        boolean zWx = TTRewardVideoActivity.this.Og.xy.Wx();
                        TTRewardVideoActivity.this.Og.rB.ML(zWx);
                        TTRewardVideoActivity.this.Og.Vgu.ML(8);
                        View view = viewSGo;
                        if (view instanceof com.bytedance.sdk.openadsdk.core.ML.ZZv) {
                            ((com.bytedance.sdk.openadsdk.core.ML.ZZv) view).setImageResource(yFO.ZZv(TTRewardVideoActivity.this.Og.Gx, "tt_close_btn"));
                        }
                        TTRewardVideoActivity.this.Og.Bf.sendEmptyMessageDelayed(600, 5000L);
                        if (!com.bytedance.sdk.openadsdk.core.model.yFO.KZx(TTRewardVideoActivity.this.Og.Og)) {
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.core.model.yFO.KZx(TTRewardVideoActivity.this.Og.Og) && zWx) {
                            return;
                        }
                    }
                    if (!TTRewardVideoActivity.this.Og.Og.Fb()) {
                        zML = false;
                    } else if (TTRewardVideoActivity.this.Og.Og.rjD()) {
                        if (TTRewardVideoActivity.this.Og.gbA != null) {
                            TTRewardVideoActivity.this.Og.Og.xy(2);
                            zML = TTRewardVideoActivity.this.Og.gbA.ML();
                        } else {
                            zML = false;
                        }
                    } else if (TTRewardVideoActivity.this.Og.Og.Lf() != 0 || TTRewardVideoActivity.this.Og.rB.aBv()) {
                        zML = false;
                    } else {
                        TTRewardVideoActivity.this.Og.Og.xy(11);
                        if (TTRewardVideoActivity.this.Og.rB.ZZv()) {
                            TTRewardVideoActivity.this.Og.Og.xy(12);
                        }
                        try {
                            TTRewardVideoActivity.this.Og.Vgu.aBv();
                            zML = true;
                        } catch (Exception unused) {
                            zML = false;
                        }
                    }
                    if (zML) {
                        return;
                    }
                    TTRewardVideoActivity.this.Og.rB.eG();
                    TTRewardVideoActivity.this.Og.xy.BSW();
                    TTRewardVideoActivity.this.Og.roi.JG();
                    if (WQf.ZZv(TTRewardVideoActivity.this.Og.Og)) {
                        TTRewardVideoActivity.this.pA(true, true);
                    } else {
                        TTRewardVideoActivity.this.finish();
                    }
                }
            };
            viewSGo.setOnClickListener(onClickListener);
            viewSGo.setTag(viewSGo.getId(), onClickListener);
        }
        this.Og.qmB.pA(new com.bytedance.sdk.openadsdk.component.reward.top.Og() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.Og
            public void pA(View view) {
                if (TTRewardVideoActivity.this.Og.Og.iC()) {
                    if (TTRewardVideoActivity.this.Og.Vgu.BSW() != null) {
                        TTRewardVideoActivity.this.Og.Og.xy(2);
                        TTRewardVideoActivity.this.Og.Vgu.aBv();
                        return;
                    }
                    return;
                }
                if (!TTRewardVideoActivity.this.Og.KZx && TTRewardVideoActivity.this.Og.Og.Fb() && !TTRewardVideoActivity.this.Og.Og.rjD()) {
                    TTRewardVideoActivity.this.Og.Og.xy(13);
                    try {
                        TTRewardVideoActivity.this.Og.Vgu.aBv();
                        return;
                    } catch (Exception unused) {
                    }
                }
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                tTRewardVideoActivity.pA(WQf.KZx(tTRewardVideoActivity.Og.Og), false);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.Og
            public void Og(View view) {
                if (TTRewardVideoActivity.this.KZx != null && TTRewardVideoActivity.this.KZx.ZZv() != null) {
                    TTRewardVideoActivity.this.KZx.ZZv().pA(TTRewardVideoActivity.this.Og.agB);
                }
                TTRewardVideoActivity.this.Og.agB = !TTRewardVideoActivity.this.Og.agB;
                new Object[]{"rewarded_video", "will set is Mute " + TTRewardVideoActivity.this.Og.agB + " mLastVolume=" + TTRewardVideoActivity.this.Og.lT.pA()};
                TTRewardVideoActivity.this.Og.BF.Og(TTRewardVideoActivity.this.Og.agB);
                if (!WQf.yFO(TTRewardVideoActivity.this.Og.Og) || TTRewardVideoActivity.this.Og.SGo.get()) {
                    if (WQf.SD(TTRewardVideoActivity.this.Og.Og)) {
                        TTRewardVideoActivity.this.Og.lT.pA(TTRewardVideoActivity.this.Og.agB, true);
                    }
                    TTRewardVideoActivity.this.Og.rB.ZZv(TTRewardVideoActivity.this.Og.agB);
                    TTRewardVideoActivity.this.Og.TV.JG(TTRewardVideoActivity.this.Og.agB);
                    if (TTRewardVideoActivity.this.Og.Og == null || TTRewardVideoActivity.this.Og.Og.dGZ() == null || TTRewardVideoActivity.this.Og.Og.dGZ().pA() == null || TTRewardVideoActivity.this.Og.BF == null) {
                        return;
                    }
                    if (TTRewardVideoActivity.this.Og.agB) {
                        TTRewardVideoActivity.this.Og.Og.dGZ().pA().omh(TTRewardVideoActivity.this.Og.BF.SD());
                    } else {
                        TTRewardVideoActivity.this.Og.Og.dGZ().pA().Bzk(TTRewardVideoActivity.this.Og.BF.SD());
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.Og
            public void KZx(View view) {
                TTRewardVideoActivity.this.Og.IG.pA(TTRewardVideoActivity.this.KZx);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(final boolean z, boolean z2) {
        if (!z2 && this.WQf && this.Og.SGo.get()) {
            if (WQf.omh(this.Og.Og)) {
                this.Og.rB.omh();
                return;
            } else if (WQf.SGo(this.Og.Og)) {
                this.Og.TV.aBv();
                return;
            }
        }
        if (!aBv.ZZv().omh(String.valueOf(this.Og.JG))) {
            if (!z2 && this.Og.SGo.get()) {
                if (WQf.omh(this.Og.Og)) {
                    this.Og.rB.omh();
                    return;
                } else if (WQf.SGo(this.Og.Og)) {
                    this.Og.TV.aBv();
                    return;
                }
            }
            if (z) {
                finish();
                return;
            } else {
                vZF();
                return;
            }
        }
        if (this.TX.get()) {
            if (this.Og.SGo.get()) {
                if (WQf.omh(this.Og.Og)) {
                    this.Og.rB.omh();
                    return;
                } else if (WQf.SGo(this.Og.Og)) {
                    this.Og.TV.aBv();
                    return;
                }
            }
            if (z) {
                finish();
                return;
            } else {
                vZF();
                return;
            }
        }
        if (WQf.omh(this.Og.Og) && this.Og.rB.BSW().getVisibility() == 0) {
            this.Og.rB.omh();
            return;
        }
        if (WQf.SGo(this.Og.Og) && this.Og.rB.SGo().getVisibility() == 0) {
            this.Og.TV.aBv();
            return;
        }
        this.Og.vZF.set(true);
        this.Og.BF.DX();
        if (z) {
            this.Og.TV.Sn();
        }
        final com.bytedance.sdk.openadsdk.core.widget.Og og = new com.bytedance.sdk.openadsdk.core.widget.Og(this);
        this.KZx.Wx = og;
        if (z) {
            this.KZx.Wx.pA(DX).Og(XT).KZx(oX);
        } else {
            this.KZx.Wx.pA(Sn).Og(aBv).KZx(oX);
        }
        this.KZx.Wx.pA(new com.bytedance.sdk.openadsdk.core.widget.Og.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.Og.pA
            public void pA() {
                TTRewardVideoActivity.this.Og.BF.Sn();
                if (z) {
                    TTRewardVideoActivity.this.Og.TV.ML(1000);
                }
                og.dismiss();
                TTRewardVideoActivity.this.Og.vZF.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.Og.pA
            public void Og() {
                og.dismiss();
                TTRewardVideoActivity.this.WQf = true;
                TTRewardVideoActivity.this.Og.vZF.set(false);
                TTRewardVideoActivity.this.Og.TV.JG(Integer.MAX_VALUE);
                if (z) {
                    if (WQf.XT(TTRewardVideoActivity.this.Og.Og)) {
                        if (WQf.omh(TTRewardVideoActivity.this.Og.Og)) {
                            if (TTRewardVideoActivity.this.Og.TV.pA()) {
                                TTRewardVideoActivity.this.Og.TV.pA(5);
                                return;
                            } else {
                                TTRewardVideoActivity.this.Og.rB.omh();
                                return;
                            }
                        }
                        TTRewardVideoActivity.this.Og.roi.JG();
                        if (TTRewardVideoActivity.this.Og.TV.pA()) {
                            TTRewardVideoActivity.this.Og.TV.pA(4);
                        }
                        TTRewardVideoActivity.this.finish();
                        return;
                    }
                    if (WQf.JG(TTRewardVideoActivity.this.Og.Og)) {
                        if (WQf.SGo(TTRewardVideoActivity.this.Og.Og)) {
                            TTRewardVideoActivity.this.Og.TV.aBv();
                            return;
                        } else {
                            TTRewardVideoActivity.this.Og.roi.JG();
                            TTRewardVideoActivity.this.finish();
                            return;
                        }
                    }
                }
                TTRewardVideoActivity.this.vZF();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0098  */
    public void vZF() {
        com.bytedance.sdk.openadsdk.component.reward.view.Og ogPA;
        DX.pA pAVar = new DX.pA();
        pAVar.pA(this.Og.BF.SD());
        pAVar.KZx(this.Og.BF.yFO());
        pAVar.Og(this.Og.BF.BSW());
        pAVar.KZx(3);
        pAVar.ZZv(this.Og.BF.XT());
        com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.pA(this.Og.BF.KZx(), pAVar, this.Og.BF.pA());
        com.bytedance.sdk.openadsdk.core.WQf.KZx(this.Og.JG);
        this.Og.BF.pA(EventConstants.SKIP, false);
        if (this.Og.KZx) {
            if (com.bytedance.sdk.openadsdk.core.model.aBv.KZx(this.Og.Og) && (ogPA = this.Og.du.pA()) != null && ogPA.ZZv == 0) {
                finish();
            } else {
                pA(true, 4);
            }
            if (com.bytedance.sdk.openadsdk.core.model.aBv.pA(this.Og.Og) && !this.Og.oX.get()) {
                finish();
            }
        } else {
            finish();
        }
        com.bytedance.sdk.openadsdk.core.WV.pA pAVarDGZ = this.Og.Og.dGZ();
        if (pAVarDGZ != null) {
            com.bytedance.sdk.openadsdk.core.WV.ZZv zZvPA = pAVarDGZ.pA();
            long jSD = this.Og.BF.SD();
            zZvPA.JG(jSD);
            zZvPA.ML(jSD);
        }
        com.bytedance.sdk.openadsdk.BF.Og.ML.pA(this.Og.Og, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void pA(Intent intent) {
        super.pA(intent);
        this.yFO = intent.getStringExtra("media_extra");
        this.vZF = intent.getStringExtra("user_id");
    }

    public boolean pA(long j, boolean z) {
        SD sd = new SD();
        sd.pA(System.currentTimeMillis(), 1.0f);
        this.Og.BF.pA(this.Og.Vgu.JG(), sd);
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA pAVar = new com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.6
            boolean pA;

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void pA(long j2, int i) {
                if (this.pA) {
                    return;
                }
                this.pA = true;
                TTRewardVideoActivity.this.ZZv.removeMessages(300);
                TTRewardVideoActivity.this.DX();
                TTRewardVideoActivity.this.yFO();
                TTRewardVideoActivity.this.Og.BF.pA(j2, j2);
                TTRewardVideoActivity.this.Og.yFO.set(true);
                if (TTRewardVideoActivity.this.Og.Og.aBv() == 36 && TTRewardVideoActivity.this.Og.KZx) {
                    TTRewardVideoActivity.this.Og.WQf.KZx().ZZv();
                    Wx.Og();
                }
                if (TTRewardVideoActivity.this.Og.Og.Zc()) {
                    TTRewardVideoActivity.this.Og.Og.xy(1);
                    TTRewardVideoActivity.this.Og.Vgu.aBv();
                }
                if (TTRewardVideoActivity.this.Og.Og.aBv() == 21 && !TTRewardVideoActivity.this.Og.Og.ZZv()) {
                    TTRewardVideoActivity.this.Og.Og.Og(true);
                    TTRewardVideoActivity.this.Og.Vgu.aBv();
                }
                TTRewardVideoActivity.this.WV = (int) (System.currentTimeMillis() / 1000);
                if (com.bytedance.sdk.openadsdk.core.model.aBv.ZZv(TTRewardVideoActivity.this.Og.Og) || com.bytedance.sdk.openadsdk.core.model.aBv.Og(TTRewardVideoActivity.this.Og.Og) || com.bytedance.sdk.openadsdk.core.model.aBv.ML(TTRewardVideoActivity.this.Og.Og)) {
                    TTRewardVideoActivity.this.pA(false, 5);
                    if (!com.bytedance.sdk.openadsdk.core.model.aBv.Og(TTRewardVideoActivity.this.Og.Og) || TTRewardVideoActivity.this.Og.Wo == null) {
                        return;
                    }
                    TTRewardVideoActivity.this.Og.Wo.pA(0L);
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.model.aBv.pA(TTRewardVideoActivity.this.Og.Og) && !TTRewardVideoActivity.this.Og.oX.get()) {
                    TTRewardVideoActivity.this.Og.pA(true);
                    TTRewardVideoActivity.this.Og.qmB.ML(true);
                    return;
                }
                if (TTRewardVideoActivity.this.Og.KZx) {
                    if (TTRewardVideoActivity.this.Og.Og.xkc()) {
                        TTRewardVideoActivity.this.Og.qmB.KZx();
                        return;
                    }
                    TTRewardVideoActivity.this.pA(false, 5);
                    if (com.bytedance.sdk.openadsdk.core.model.yFO.ML(TTRewardVideoActivity.this.Og.Og)) {
                        return;
                    }
                    TTRewardVideoActivity.this.Og.BF.pA(EventConstants.SKIP, true);
                    return;
                }
                if (TTRewardVideoActivity.this.Og.Og.xkc()) {
                    TTRewardVideoActivity.this.Og.qmB.KZx();
                    return;
                }
                if (!com.bytedance.sdk.openadsdk.core.model.yFO.ML(TTRewardVideoActivity.this.Og.Og)) {
                    TTRewardVideoActivity.this.Og.BF.pA(EventConstants.SKIP, true);
                }
                TTRewardVideoActivity.this.finish();
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void Og(long j2, int i) {
                TTRewardVideoActivity.this.ZZv.removeMessages(300);
                if (TTRewardVideoActivity.this.Og.BF.Og()) {
                    TTRewardVideoActivity.this.Wx();
                    return;
                }
                TTRewardVideoActivity.this.Og.BF.Wx();
                TTRewardVideoActivity.this.yFO();
                if (TTRewardVideoActivity.this.Og.KZx) {
                    TTRewardVideoActivity.this.pA(false, true, 3);
                } else {
                    TTRewardVideoActivity.this.finish();
                }
                TTRewardVideoActivity.this.Og.BF.pA(1 ^ (TTRewardVideoActivity.this.Og.BF.eG() ? 1 : 0), 2);
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void pA() {
                TTRewardVideoActivity.this.ZZv.removeMessages(300);
                TTRewardVideoActivity.this.DX();
                TTRewardVideoActivity.this.yFO();
                if (TTRewardVideoActivity.this.Og.KZx) {
                    TTRewardVideoActivity.this.pA(false, true, 6);
                } else {
                    TTRewardVideoActivity.this.finish();
                }
                TTRewardVideoActivity.this.Og.BF.pA(!TTRewardVideoActivity.this.Og.BF.eG() ? 1 : 0, 1 ^ (TTRewardVideoActivity.this.Og.BF.eG() ? 1 : 0));
                TTRewardVideoActivity.this.Og.BF.Wx();
            }

            @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
            public void pA(long j2, long j3) {
                if (!TTRewardVideoActivity.this.Og.fN && TTRewardVideoActivity.this.Og.BF.Og()) {
                    TTRewardVideoActivity.this.Og.BF.DX();
                }
                if (TTRewardVideoActivity.this.Og.SGo.get()) {
                    return;
                }
                TTRewardVideoActivity.this.ZZv.removeMessages(300);
                if (j2 != TTRewardVideoActivity.this.Og.BF.omh()) {
                    TTRewardVideoActivity.this.DX();
                }
                TTRewardVideoActivity.this.Og.BF.pA(j2, j3);
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                long j4 = j2 / 1000;
                double d = j4;
                tTRewardVideoActivity.JG = (int) (tTRewardVideoActivity.Og.BF.roi() - d);
                if (TTRewardVideoActivity.this.JG >= 0) {
                    TTRewardVideoActivity.this.Og.qmB.pA(String.valueOf(TTRewardVideoActivity.this.JG), null);
                }
                TTRewardVideoActivity tTRewardVideoActivity2 = TTRewardVideoActivity.this;
                tTRewardVideoActivity2.JG = (int) (tTRewardVideoActivity2.Og.BF.roi() - d);
                int i = (int) j4;
                int iSGo = aBv.ZZv().SGo(String.valueOf(TTRewardVideoActivity.this.Og.JG));
                boolean z2 = iSGo >= 0;
                if ((TTRewardVideoActivity.this.Og.vZF.get() || TTRewardVideoActivity.this.Og.BSW.get()) && TTRewardVideoActivity.this.Og.BF.Og()) {
                    TTRewardVideoActivity.this.Og.BF.DX();
                }
                TTRewardVideoActivity.this.Og.Vgu.ZZv(i);
                TTRewardVideoActivity.this.pA(j2, j3);
                if (TTRewardVideoActivity.this.JG > 0) {
                    TTRewardVideoActivity.this.Og.qmB.ZZv(true);
                    if (z2 && i >= iSGo) {
                        TTRewardVideoActivity.this.Og.pA(true);
                        TTRewardVideoActivity.this.Og.qmB.pA(String.valueOf(TTRewardVideoActivity.this.JG), TTAdDislikeToast.getSkipText());
                        TTRewardVideoActivity.this.Og.qmB.ML(true);
                        return;
                    }
                    TTRewardVideoActivity.this.Og.qmB.pA(String.valueOf(TTRewardVideoActivity.this.JG), null);
                }
            }
        };
        this.Og.BF.pA(pAVar);
        if (this.Og.Vgu.DX != null) {
            this.Og.Vgu.DX.pA(pAVar);
        }
        boolean zPA = this.Og.BF.pA(j, z, null, this.KZx);
        if (zPA && !z) {
            this.BSW = (int) (System.currentTimeMillis() / 1000);
        }
        return zPA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void c_() {
        Sd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sd() {
        TX.pA("BVA", "invoke callback onAdClicked, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA("onAdVideoBarClick");
            return;
        }
        com.bytedance.sdk.openadsdk.pA.ML.pA pAVar = this.Wx;
        if (pAVar != null) {
            pAVar.onAdClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(final boolean z, final int i, final String str, final int i2, final String str2) {
        TX.pA("BVA", "invoke callback onRewardVerify: " + z + ", " + i + ", " + str + ", " + i2 + ", " + str2 + "; " + this);
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA("onRewardVerify", z, i, str, i2, str2);
        } else {
            this.ZZv.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    if (TTRewardVideoActivity.this.Wx != null) {
                        TTRewardVideoActivity.this.Wx.pA(z, i, str, i2, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void ML() {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA("onAdShow");
        } else {
            com.bytedance.sdk.openadsdk.pA.ML.pA pAVar = this.Wx;
            if (pAVar != null) {
                pAVar.pA();
            }
        }
        if (XT()) {
            this.Og.du.SGo();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void WV() {
        yFO();
    }

    protected void yFO() {
        if (this.TX.get()) {
            return;
        }
        this.TX.set(true);
        if (aBv.ZZv().oX(String.valueOf(this.Og.JG))) {
            pA(true, this.Og.Og.TX(), this.Og.Og.Sd(), 0, "");
        } else {
            aBv.KZx().pA(TX(), new com.bytedance.sdk.openadsdk.core.yFO.Og() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.8
                @Override // com.bytedance.sdk.openadsdk.core.yFO.Og
                public void pA(int i, String str) {
                    TTRewardVideoActivity.this.pA(false, 0, "", i, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.yFO.Og
                public void pA(vZF.Og og) {
                    boolean z = og.Og;
                    TTRewardVideoActivity.this.pA(og.Og, og.KZx.pA(), og.KZx.Og(), 0, "");
                }
            });
        }
    }

    private JSONObject TX() {
        JSONObject jSONObject = new JSONObject();
        int iVZF = (int) this.Og.BF.vZF();
        try {
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put(CampaignEx.JSON_KEY_REWARD_NAME, this.Og.Og.Sd());
            jSONObject.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, this.Og.Og.TX());
            jSONObject.put("network", com.bytedance.sdk.component.utils.DX.KZx(getApplicationContext()));
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            int iVgu = this.Og.Og.Vgu();
            String strKZx = "unKnow";
            if (iVgu == 2) {
                strKZx = gbA.Og();
            } else if (iVgu == 1) {
                strKZx = gbA.KZx();
            }
            jSONObject.put("user_agent", strKZx);
            jSONObject.put("extra", this.Og.Og.fg());
            jSONObject.put("media_extra", this.yFO);
            jSONObject.put("video_duration", this.Og.Og.Bf().JG());
            jSONObject.put("play_start_ts", this.BSW);
            jSONObject.put("play_end_ts", this.WV);
            jSONObject.put("duration", iVZF);
            jSONObject.put("user_id", this.vZF);
            jSONObject.put("trans_id", com.bytedance.sdk.openadsdk.utils.WQf.pA().replace("-", ""));
            return jSONObject;
        } catch (Throwable th) {
            WV.pA("TTAD.RVA", "", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void ZZv() {
        Sd();
        this.Og.Og.Ky();
        this.Og.Og.pA(true);
        if (com.bytedance.sdk.openadsdk.core.model.yFO.ML(this.Og.Og)) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.Og.Og, this.Og.ML, this.Og.Og.Io());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void pA(int i) {
        if (i == 10000) {
            yFO();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BF();
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA("recycleRes");
        }
        this.Wx = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        if (this.Og != null) {
            com.bytedance.sdk.openadsdk.JG.Og.pA().pA("videoForceBreak", this.Og.Og);
        }
        BF();
        super.finish();
    }

    private void BF() {
        if (this.omh) {
            return;
        }
        this.omh = true;
        TX.pA("BVA", "invoke callback onAdClose, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA("onAdClose");
            return;
        }
        com.bytedance.sdk.openadsdk.pA.ML.pA pAVar = this.Wx;
        if (pAVar != null) {
            pAVar.Og();
        }
    }

    public void pA(long j, long j2) {
        long j3 = j + (((long) this.Og.dmv) * 1000);
        if (this.BF == -1) {
            this.BF = aBv.ZZv().eG(String.valueOf(this.Og.JG)).JG;
        }
        if (j2 <= 0) {
            return;
        }
        if (j2 >= 30000 && j3 >= 27000) {
            yFO();
        } else if ((j3 * 100) / j2 >= this.BF) {
            yFO();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0036  */
    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void Sn() {
        int i = aBv.ZZv().eG(String.valueOf(this.Og.JG)).JG;
        boolean z = true;
        boolean z2 = false;
        if (WQf.yFO(this.Og.Og)) {
            if ((1.0d - (((double) this.JG) / this.Og.BF.roi())) * 100.0d < i) {
                z = false;
            }
            z2 = z;
        } else {
            boolean z3 = (1.0f - (this.Og.TV.Og() / ((float) this.Og.Og.mK()))) * 100.0f >= ((float) i);
            int iPA = aBv.ZZv().pA(String.valueOf(this.Og.JG));
            if (iPA == 0) {
                boolean zML = this.Og.rB.WV().ML();
                if (this.Og.TV.KZx()) {
                    zML = true;
                }
                if (!z3 || !zML) {
                    z = false;
                }
                z2 = z;
            } else if (iPA == 1) {
                z2 = z3;
            }
        }
        if (z2) {
            yFO();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void pA(boolean z) {
        if (z) {
            yFO();
            return;
        }
        if ((1.0d - (((double) this.JG) / this.Og.BF.roi())) * 100.0d >= aBv.ZZv().eG(String.valueOf(this.Og.JG)).JG) {
            yFO();
        }
    }
}
