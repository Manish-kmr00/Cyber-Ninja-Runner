package com.bytedance.sdk.openadsdk.component.reward.Og;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.TV;
import com.bytedance.sdk.component.utils.yFO;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.common.Wx;
import com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout;
import com.bytedance.sdk.openadsdk.core.model.DX;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.aBv;
import com.bytedance.sdk.openadsdk.core.widget.BSW;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.Sn;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public abstract class Og extends com.bytedance.sdk.openadsdk.component.reward.Og.pA {
    protected String BSW;
    private com.bytedance.sdk.openadsdk.WV.ML DX;
    public LinearLayout Sn;
    protected com.bytedance.sdk.openadsdk.core.Og.ML WV;
    public com.bytedance.sdk.openadsdk.core.widget.Og Wx;

    public interface pA {
        void pA(boolean z);
    }

    public abstract boolean JG();

    public abstract boolean ML();

    public abstract void SD();

    public void Wx() {
    }

    public pA ZZv() {
        return null;
    }

    public abstract void pA(FrameLayout frameLayout);

    protected boolean roi() {
        return true;
    }

    public void yFO() {
    }

    public Og(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        super(pAVar);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.pA
    public void pA(com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og og, TV tv) {
        super.pA(og, tv);
        if (this.pA.Og.pA() && this.pA.bU) {
            this.pA.rB.pA(false);
        }
        if (WQf.XT(this.pA.Og)) {
            this.pA.TV.WV();
        }
    }

    public void pA(com.bytedance.sdk.openadsdk.component.reward.view.SD sd) {
        pA(sd, this.pA);
    }

    public RFEndCardBackUpLayout omh() {
        return new RFEndCardBackUpLayout(this.pA.Gx);
    }

    public View Bzk() {
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx = new com.bytedance.sdk.openadsdk.core.ML.KZx(this.pA.SzT);
        kZx.setId(Sn.Mx);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZvOg = com.bytedance.sdk.openadsdk.core.widget.SD.Og(this.pA.SzT);
        zZvOg.setId(520093708);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388661;
        layoutParams.topMargin = Vgu.KZx(this.pA.SzT, 20.0f);
        layoutParams.rightMargin = Vgu.KZx(this.pA.SzT, 16.0f);
        zZvOg.setLayoutParams(layoutParams);
        zZvOg.setContentDescription(yFO.pA(this.pA.SzT, "tt_ad_close_text"));
        zZvOg.setVisibility(8);
        PAGLogoView pAGLogoView = new PAGLogoView(this.pA.SzT);
        pAGLogoView.setId(520093757);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, Vgu.KZx(this.pA.SzT, 14.0f));
        layoutParams2.gravity = 8388691;
        pAGLogoView.setLayoutParams(layoutParams2);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(this.pA.SzT);
        zZv.setId(Sn.Ij);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(Vgu.KZx(this.pA.SzT, 32.0f), Vgu.KZx(this.pA.SzT, 14.0f));
        layoutParams3.gravity = 8388693;
        zZv.setLayoutParams(layoutParams3);
        zZv.setPadding(Vgu.KZx(this.pA.SzT, 9.0f), 0, Vgu.KZx(this.pA.SzT, 9.0f), 0);
        zZv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        BSW bsw = new BSW(this.pA.SzT);
        bsw.setId(Sn.qH);
        bsw.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        bsw.setClickable(true);
        bsw.setFocusable(true);
        kZx.addView(pAGLogoView);
        kZx.addView(zZv);
        kZx.addView(bsw);
        if (!this.pA.Og.fS() || !this.pA.Itl || this.pA.pA != 1) {
            com.bytedance.sdk.openadsdk.component.reward.top.KZx kZx2 = new com.bytedance.sdk.openadsdk.component.reward.top.KZx(this.pA.SzT);
            kZx2.setId(Sn.Lf);
            kZx2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            kZx.addView(kZx2);
        }
        kZx.addView(zZvOg);
        return kZx;
    }

    public View SGo() {
        com.bytedance.sdk.openadsdk.core.ML.SD sd;
        if (this.Og.IG() != 5) {
            sd = new com.bytedance.sdk.openadsdk.core.ML.SD(this.pA.SzT);
            sd.setId(Sn.jK);
        } else {
            sd = null;
        }
        new StringBuilder("getLoadingFrameView").append(sd);
        return sd;
    }

    public void BSW() {
        this.pA.eG.pA(this.pA.ZZv);
        this.pA.Vgu.Og();
        this.pA.gbA.pA();
        if (!this.pA.Og.rjD()) {
            if (this.pA.SD && TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.model.yFO.pA(this.pA.Gx, this.Og))) {
                WV();
            }
            this.pA.rB.pA();
            this.pA.xy.pA();
        }
        this.pA.TV.DX();
        this.pA.qmB.pA();
        if (WQf.SD(this.pA.Og)) {
            com.bytedance.sdk.component.Bzk.ZZv zZvSGo = this.pA.rB.SGo();
            if (zZvSGo != null) {
                zZvSGo.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.pA.rB.BSW().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            this.pA.qmB.KZx(true);
            if (WQf.XT(this.pA.Og)) {
                this.pA.Vgu.ZZv();
                Vgu.pA((View) zZvSGo, 4);
                Vgu.pA((View) this.pA.rB.BSW(), 0);
            }
        }
        if (WQf.JG(this.pA.Og)) {
            this.pA.Vgu.ZZv();
            Vgu.pA((View) this.pA.rB.SGo(), 4);
        }
        if (aBv.ZZv(this.pA.Og) || aBv.Og(this.pA.Og) || aBv.ML(this.pA.Og)) {
            return;
        }
        this.pA.Vgu.pA(Vgu.KZx(this.pA.Gx, this.pA.IIF), Vgu.KZx(this.pA.Gx, this.pA.vA));
        this.pA.WQf.pA();
        if (WQf.XT(this.pA.Og)) {
            this.pA.rB.pA(true);
            this.pA.rB.ML();
            pA(false, false, false, com.bytedance.sdk.openadsdk.ZZv.Og.C0216Og.KZx);
        } else if (this.pA.gy) {
            this.pA.Vgu.pA(0);
        }
    }

    public void WV() {
        LinearLayout linearLayout = (LinearLayout) this.pA.CIG.findViewById(Sn.Wx);
        this.Sn = linearLayout;
        Vgu.pA((View) linearLayout, 8);
        this.pA.fw = new Wx(this.pA.SzT, this.pA.Og, "landingpage_endcard");
        this.pA.fw.KZx().setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.Og.Og.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/Og/Og$1;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_Og$1_onClick_e461abafb4c8027afac51f5817bd5257(view);
            }

            public void safedk_Og$1_onClick_e461abafb4c8027afac51f5817bd5257(View p0) {
                View p1 = Og.this.pA.Vgu.SGo();
                p1.performClick();
            }
        });
        this.Sn.addView(this.pA.fw.ML(), new LinearLayout.LayoutParams(-1, -1));
        this.pA.rB.pA(this.pA.fw);
    }

    public void pA(boolean z, boolean z2, boolean z3, int i) {
        this.pA.gbA.pA(z, z2, z3, this, i);
    }

    public void Sn() {
        com.bytedance.sdk.openadsdk.core.widget.Og og = this.Wx;
        if (og == null || !og.isShowing()) {
            return;
        }
        this.Wx.dismiss();
    }

    public void DX() {
        if (this.pA.SD) {
            return;
        }
        this.pA.qmB.JG();
        if (this.pA.Itl && (this.pA.RS instanceof com.bytedance.sdk.openadsdk.activity.pA)) {
            return;
        }
        this.pA.Vgu.ML(0);
    }

    public void oX() {
        this.SGo.removeMessages(300);
    }

    public void aBv() {
        if (!WQf.SGo(this.Og) || this.pA.rB.CIG()) {
            XT();
        }
        if (this.pA == null) {
            return;
        }
        if (this.pA.Wo != null) {
            this.pA.Wo.pA();
        }
        this.pA.pA();
    }

    protected void XT() {
        if (this.pA.SGo.get() && !this.pA.SD && this.pA.Sd.getAndSet(false) && (this.pA.omh >= 0 || this.pA.omh == -1)) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 700;
            messageObtain.arg1 = this.pA.omh;
            this.pA.Bf.sendMessage(messageObtain);
        }
        if (this.pA.Bzk <= 0 || !this.pA.TX.getAndSet(false)) {
            return;
        }
        Message messageObtain2 = Message.obtain();
        messageObtain2.what = 900;
        messageObtain2.arg1 = this.pA.Bzk;
        this.pA.Bf.sendMessage(messageObtain2);
    }

    public void vZF() {
        if (this.pA == null) {
            return;
        }
        this.pA.fN = false;
        boolean z = this.pA.fN;
        boolean z2 = this.pA.agB;
        if (!this.pA.BSW.get()) {
            this.pA.BF.SGo();
        }
        oX();
        this.pA.rB.Sd();
        this.pA.TV.oX();
        this.pA.TX.set(true);
        if (this.pA.SGo.get()) {
            this.pA.Sd.set(true);
        }
        if (this.pA.Wo != null) {
            this.pA.Wo.Og();
        }
        this.pA.Og();
    }

    public void Sd() {
        if (this.pA == null) {
            return;
        }
        if (this.pA.Vgu != null) {
            this.pA.Vgu.oX();
        }
        boolean z = this.pA.agB;
        this.pA.lT.pA();
        DeviceUtils.SD();
        this.pA.rB.vZF();
        if (this.pA.agB) {
            this.pA.SzT.runOnUiThread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.Og.Og.2
                @Override // java.lang.Runnable
                public void run() {
                    if (Og.this.pA.lT.pA() > 0) {
                        Og.this.pA.lT.pA(false);
                    }
                }
            });
        }
    }

    public void TX() {
        if (this.pA.du != null) {
            this.pA.du.JG();
        }
        if (this.pA.Vgu != null) {
            this.pA.Vgu.Sn();
        }
        this.pA.BF.TV();
        if (!ML()) {
            this.pA.SGo.get();
        }
        this.pA.rB.oX();
        this.pA.TV.SD(com.bytedance.sdk.openadsdk.component.reward.pA.omh.pA);
        this.pA.Vgu.WV();
        this.pA.gbA.KZx();
        this.pA.eG.Og();
        if (this.pA.Wo != null) {
            this.pA.Wo.KZx();
        }
    }

    public void BF() {
        int iYFO;
        if (com.bytedance.sdk.openadsdk.core.aBv.ZZv().Sd(String.valueOf(this.pA.JG)) == 1) {
            if (this.pA.ZZv) {
                if (WQf.KZx(this.pA.Og)) {
                    iYFO = com.bytedance.sdk.openadsdk.core.aBv.ZZv().pA(String.valueOf(this.pA.JG), true);
                } else {
                    iYFO = com.bytedance.sdk.openadsdk.core.aBv.ZZv().SGo(String.valueOf(this.pA.JG));
                }
            } else if (WQf.KZx(this.pA.Og)) {
                iYFO = com.bytedance.sdk.openadsdk.core.aBv.ZZv().pA(String.valueOf(this.pA.JG), false);
            } else {
                iYFO = com.bytedance.sdk.openadsdk.core.aBv.ZZv().yFO(String.valueOf(this.pA.JG));
            }
            if (this.pA.Vgu != null && this.pA.Vgu.Bzk()) {
                if (this.pA.Vgu != null) {
                    this.pA.Vgu.SGo().performClick();
                }
            } else if ((!this.pA.SGo.get() || WQf.KZx(this.pA.Og)) && iYFO != -1) {
                if (((this.pA.BF == null || this.pA.BF.omh() < ((long) iYFO) * 1000) && (this.pA.TV == null || !this.pA.TV.ZZv(iYFO))) || this.pA.qmB == null) {
                    return;
                }
                this.pA.qmB.ZZv();
            }
        }
    }

    public void WQf() {
        this.pA.qmB.KZx();
        this.pA.qmB.ML(true);
    }

    public void TV() {
        this.WV = this.pA.roi.KZx();
    }

    public void du() {
        if (!JG() && ((this instanceof omh) || (this instanceof Bzk))) {
            this.pA.roi.Og();
            return;
        }
        if (!this.Bzk.pA(this.ML.Bzk(), false)) {
            this.SGo.removeMessages(300);
            if (this.pA.Itl && (this.pA.RS instanceof com.bytedance.sdk.openadsdk.activity.pA)) {
                ((com.bytedance.sdk.openadsdk.activity.pA) this.pA.RS).Sd();
            } else {
                pA(com.bytedance.sdk.openadsdk.ZZv.Og.C0216Og.pA);
                this.ML.pA(!this.ML.eG() ? 1 : 0, 4);
            }
        }
        if (this.pA == null || this.pA.Og == null || this.pA.Wo == null || !this.pA.Og.qH()) {
            return;
        }
        this.pA.Wo.pA(this.pA.BF.vZF());
    }

    public void pA(int i) {
        this.ML.Wx();
        pA(false, true, false, i);
        if (this.pA.ZZv) {
            this.Bzk.pA(10000);
        }
    }

    public void pA(com.bytedance.sdk.openadsdk.WV.ML ml) {
        this.DX = ml;
        KZx();
        if (!this.pA.Og.rjD() && roi()) {
            eG();
        }
        if (roi()) {
            this.pA.gbA.Og();
        }
        if (aBv.ZZv(this.pA.Og) || aBv.ML(this.pA.Og)) {
            this.SGo.sendEmptyMessageDelayed(500, 100L);
        }
        this.pA.Vgu.pA(this.pA.dC == 100.0f);
        TV();
        SD();
    }

    public final void eG() {
        if (this.pA.SzT.isFinishing()) {
            return;
        }
        this.pA.rB.DX();
        String str = this.pA.ZZv ? "reward_endcard" : "fullscreen_endcard";
        this.pA.rB.pA(this.DX, str, this.pA.FQ);
        this.pA.TV.pA(this.DX, this.pA.agB);
        this.pA.rB.pA(str, this.pA.FQ);
        this.pA.rB.ML();
    }

    public void pA(Message message) {
        int i = message.what;
        int i2 = message.what;
        if (i2 == 1) {
            WQf();
            return;
        }
        if (i2 == 300) {
            if (this.pA.Itl && (this.pA.RS instanceof com.bytedance.sdk.openadsdk.activity.pA)) {
                ((com.bytedance.sdk.openadsdk.activity.pA) this.pA.RS).Sd();
            } else {
                pA(com.bytedance.sdk.openadsdk.ZZv.Og.C0216Og.Og);
                this.pA.BF.pA(!this.pA.BF.eG() ? 1 : 0, 1 ^ (this.pA.BF.eG() ? 1 : 0));
            }
            if (this.pA.Og.dGZ() == null || this.pA.Og.dGZ().pA() == null) {
                return;
            }
            this.pA.Og.dGZ().pA().pA(com.bytedance.sdk.openadsdk.core.WV.pA.pA.GENERAL_LINEAR_AD_ERROR);
            return;
        }
        if (i2 == 400) {
            this.pA.BF.Wx();
            pA(false, true, false, 3);
            return;
        }
        if (i2 == 500) {
            if (!WQf.SD(this.pA.Og)) {
                this.pA.qmB.KZx(false);
            }
            com.bytedance.sdk.component.Bzk.ZZv zZvSGo = this.pA.rB.SGo();
            if (zZvSGo != null && zZvSGo.getWebView() != null) {
                zZvSGo.Bzk();
                zZvSGo.getWebView().resumeTimers();
            }
            if (this.pA.rB.SGo() != null) {
                this.pA.rB.pA(1.0f);
                this.pA.Vgu.pA(1.0f);
            }
            if (!this.pA.Og.kK() && this.pA.BF.Og() && this.pA.XT.get()) {
                this.pA.BF.Wx();
                return;
            }
            return;
        }
        if (i2 == 600) {
            DX();
            return;
        }
        if (i2 == 700) {
            int i3 = message.arg1;
            if (this.pA.Sd.get()) {
                return;
            }
            if (i3 > 0) {
                this.pA.qmB.Og();
                this.pA.qmB.pA((i3 / 1000) + "s");
                this.pA.qmB.ML(false);
                Message messageObtain = Message.obtain();
                messageObtain.what = 700;
                messageObtain.arg1 = i3 - 1000;
                this.pA.omh -= 1000;
                this.SGo.sendMessageDelayed(messageObtain, 1000L);
                return;
            }
            this.SGo.removeMessages(700);
            if (WQf.Bzk(this.Og)) {
                if (this.pA.TV.SD() || !this.pA.rB.XT()) {
                    DX();
                    return;
                } else {
                    WQf();
                    return;
                }
            }
            DX();
            return;
        }
        if (i2 == 800) {
            if (!WQf.SD(this.pA.Og)) {
                this.pA.qmB.KZx(false);
            }
            this.pA.Vgu.pA(1.0f);
            if (!this.pA.Og.kK() && this.pA.BF.Og() && this.pA.XT.get()) {
                this.pA.BF.Wx();
                return;
            }
            return;
        }
        if (i2 == 900 && !this.pA.TX.get()) {
            int i4 = message.arg1;
            double dRoi = this.pA.BF.roi();
            pA(i4, (long) (1000.0d * dRoi));
            if (i4 > 0) {
                this.pA.qmB.Og();
                this.pA.qmB.pA((i4 / 1000) + "s");
                this.pA.qmB.ML(false);
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 900;
                messageObtain2.arg1 = i4 - 1000;
                this.pA.Bzk = messageObtain2.arg1;
                this.SGo.sendMessageDelayed(messageObtain2, 1000L);
                if (this.pA.Itl && (this.pA.RS instanceof com.bytedance.sdk.openadsdk.activity.pA) && dRoi > 0.0d) {
                    ((com.bytedance.sdk.openadsdk.activity.pA) this.pA.RS).pA((float) (1.0d - (((double) (i4 / 1000.0f)) / dRoi)));
                    return;
                }
                return;
            }
            this.SGo.removeMessages(900);
            DX();
            com.bytedance.sdk.openadsdk.activity.JG jg = this.pA.RS;
            if (this.pA.Itl && (jg instanceof com.bytedance.sdk.openadsdk.activity.pA)) {
                jg.WQf().pA(jg, new com.bytedance.sdk.openadsdk.activity.Og.ML(5, this.pA));
            }
        }
    }

    private void pA(long j, long j2) {
        long j3 = j2 - j;
        if (this.pA.SzT instanceof TTRewardVideoActivity) {
            ((TTRewardVideoActivity) this.pA.SzT).pA(j3, j2);
        } else if (this.pA.FQ instanceof com.bytedance.sdk.openadsdk.activity.ML) {
            ((com.bytedance.sdk.openadsdk.activity.ML) this.pA.FQ).pA(j3, j2);
        }
    }

    static void pA(FrameLayout frameLayout, final com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        final com.bytedance.sdk.openadsdk.core.ML.ZZv zZv;
        Context context = frameLayout.getContext();
        if (pAVar.bU) {
            com.bytedance.sdk.openadsdk.core.ML.KZx kZx = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
            kZx.setId(Sn.SGo);
            frameLayout.addView(kZx, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayoutPA = pA(context);
            String strPA = "";
            if (com.bytedance.sdk.openadsdk.core.model.yFO.ML(pAVar.Og)) {
                com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogBf = pAVar.Og.Bf();
                if (ogBf != null) {
                    strPA = ogBf.SGo();
                }
            } else {
                List<DX> listIIF = pAVar.Og.IIF();
                if (listIIF != null && !listIIF.isEmpty()) {
                    strPA = listIIF.get(0).pA();
                }
            }
            if (TextUtils.isEmpty(strPA)) {
                zZv = null;
            } else {
                zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
                zZv.setId(Sn.ZDE);
                zZv.setTag(Sn.ZDE, strPA);
                zZv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                frameLayoutPA.addView(zZv);
            }
            kZx.addView(frameLayoutPA);
            com.bytedance.sdk.openadsdk.component.reward.view.KZx kZx2 = new com.bytedance.sdk.openadsdk.component.reward.view.KZx(context);
            kZx2.setId(Sn.WV);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            frameLayout.addView(kZx2, layoutParams);
            kZx2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.Og.Og.3
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    int height = view.getHeight();
                    if (height <= 0) {
                        return;
                    }
                    View viewFindViewById = pAVar.CIG.findViewById(520093757);
                    if (viewFindViewById != null) {
                        ViewGroup.LayoutParams layoutParams2 = viewFindViewById.getLayoutParams();
                        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams2).bottomMargin = height;
                        }
                    }
                    View viewFindViewById2 = pAVar.CIG.findViewById(Sn.Ij);
                    if (viewFindViewById2 != null) {
                        ViewGroup.LayoutParams layoutParams3 = viewFindViewById2.getLayoutParams();
                        if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams3).bottomMargin = height;
                        }
                    }
                    View viewFindViewById3 = pAVar.CIG.findViewById(Sn.eD);
                    if (viewFindViewById3 != null) {
                        ViewGroup.LayoutParams layoutParams4 = viewFindViewById3.getLayoutParams();
                        if (layoutParams4 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams4).bottomMargin = height;
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.ML.ZZv zZv2 = zZv;
                    if (zZv2 != null) {
                        ViewGroup.LayoutParams layoutParams5 = zZv2.getLayoutParams();
                        if (layoutParams5 instanceof ViewGroup.MarginLayoutParams) {
                            ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = height;
                            zZv.setLayoutParams(layoutParams5);
                        }
                    }
                }
            });
            com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
            ml.setId(Sn.Wx);
            ml.setOrientation(1);
            ml.setVisibility(8);
            frameLayout.addView(ml, new FrameLayout.LayoutParams(-1, -1));
        }
        if (pAVar.HSv) {
            com.bytedance.sdk.component.Bzk.ZZv zZv2 = new com.bytedance.sdk.component.Bzk.ZZv(context, true);
            zZv2.setId(Sn.Sn);
            zZv2.setLayerType(2, null);
            zZv2.setVisibility(4);
            frameLayout.addView(zZv2, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayout2 = new FrameLayout(context);
            frameLayout2.setId(Sn.DX);
            frameLayout2.setVisibility(4);
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            if (WQf.Og(pAVar.Og)) {
                com.bytedance.sdk.openadsdk.core.ML.KZx kZx3 = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
                kZx3.setId(Sn.Bi);
                kZx3.setVisibility(4);
                frameLayout.addView(kZx3, new FrameLayout.LayoutParams(-1, -1));
            }
        }
        com.bytedance.sdk.component.Bzk.ZZv zZv3 = new com.bytedance.sdk.component.Bzk.ZZv(context, true);
        zZv3.setId(Sn.oX);
        zZv3.setVisibility(8);
        frameLayout.addView(zZv3, new FrameLayout.LayoutParams(-1, -1));
    }

    protected static FrameLayout pA(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
        kZx.setId(Sn.BSW);
        kZx.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        kZx.setLayoutParams(layoutParams);
        return kZx;
    }
}
