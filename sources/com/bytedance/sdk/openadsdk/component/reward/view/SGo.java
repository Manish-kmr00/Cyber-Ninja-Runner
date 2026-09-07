package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.component.reward.pA.oX;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.Wx;
import com.bytedance.sdk.openadsdk.core.model.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.Sn;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class SGo {
    RelativeLayout BSW;
    PAGLogoView Bzk;
    public aBv DX;
    FrameLayout JG;
    protected final com.bytedance.sdk.openadsdk.component.reward.pA.pA KZx;
    ImageView ML;
    final Activity Og;
    View SD;
    ImageView SGo;
    private boolean Sd;
    private KZx TX;
    oX WV;
    private final boolean XT;
    final yFO ZZv;
    com.bytedance.sdk.openadsdk.core.ML.JG oX;
    View omh;
    private int vZF;
    private final String yFO;
    int pA = 3;
    protected int Wx = 0;
    protected final AtomicBoolean Sn = new AtomicBoolean(false);
    Runnable aBv = new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.SGo.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                if ((SGo.this.ZZv == null || !SGo.this.ZZv.qH()) && SGo.this.ML != null) {
                    int[] iArr = new int[2];
                    SGo.this.ML.getLocationOnScreen(iArr);
                    SGo.this.KZx.qmB.pA(iArr[0]);
                }
            } catch (Exception unused) {
            }
        }
    };

    protected boolean pA() {
        return true;
    }

    public SGo(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        this.KZx = pAVar;
        this.Og = pAVar.SzT;
        this.ZZv = pAVar.Og;
        this.yFO = pAVar.ML;
        this.XT = pAVar.ZZv;
    }

    public void Og() {
        if (this.Sd) {
            return;
        }
        this.Sd = true;
        this.vZF = this.KZx.YkC;
        if (pA()) {
            oX oXVar = new oX(this.KZx);
            this.WV = oXVar;
            oXVar.pA();
        }
        XT();
        aBv abv = new aBv(this.Og, this.ZZv, this.yFO, this.JG, this.KZx.FQ, this.KZx.CIG);
        this.DX = abv;
        abv.pA();
    }

    private void XT() {
        RelativeLayout relativeLayout;
        KZx kZx = (KZx) this.KZx.CIG.findViewById(Sn.WV);
        this.TX = kZx;
        kZx.pA(this.KZx);
        this.Bzk = (PAGLogoView) this.KZx.CIG.findViewById(520093757);
        this.SGo = (ImageView) this.KZx.CIG.findViewById(Sn.Ij);
        this.ML = (ImageView) this.KZx.CIG.findViewById(520093708);
        this.JG = (FrameLayout) this.KZx.CIG.findViewById(Sn.BSW);
        this.SD = this.KZx.CIG.findViewById(Sn.aBv);
        this.omh = this.KZx.CIG.findViewById(Sn.slz);
        this.BSW = (RelativeLayout) this.KZx.CIG.findViewById(Sn.jK);
        oX oXVar = this.WV;
        if (oXVar == null || oXVar.ZZv() == null || (relativeLayout = this.BSW) == null) {
            return;
        }
        relativeLayout.addView(this.WV.ZZv(), new LinearLayout.LayoutParams(-1, -1));
        this.WV.Og();
    }

    public void KZx() {
        this.JG.removeAllViews();
    }

    public void pA(boolean z) {
        int i = 8;
        Vgu.pA((View) this.Bzk, WQf.KZx(this.ZZv) ? 8 : 0);
        ImageView imageView = this.SGo;
        if (this.ZZv.rjD() && this.ZZv.omh()) {
            i = 0;
        }
        Vgu.pA((View) imageView, i);
        Og(z);
        if (this.XT) {
            ML();
        }
    }

    public void pA(int i) {
        if (this.oX == null) {
            this.oX = new com.bytedance.sdk.openadsdk.core.ML.JG(this.KZx.SzT);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
            layoutParams.gravity = 17;
            this.oX.setLayoutParams(layoutParams);
            this.oX.setIndeterminateDrawable(com.bytedance.sdk.openadsdk.utils.Bzk.pA(this.KZx.SzT, "tt_video_loading_progress_bar"));
            this.KZx.Vgu.JG().addView(this.oX);
        }
        this.oX.setVisibility(i);
    }

    public void pA(int i, int i2) {
        FrameLayout frameLayout;
        if (this.ZZv.IG() == 1 && (frameLayout = this.JG) != null && (frameLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            int iKZx = Vgu.KZx((Context) this.Og);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.JG.getLayoutParams();
            layoutParams.width = iKZx;
            int i3 = (iKZx * 9) / 16;
            layoutParams.height = i3;
            this.JG.setLayoutParams(layoutParams);
            this.Wx = (Vgu.ZZv((Context) this.Og) - i3) / 2;
            WV.pA("TTAD.RFullVideoLayout", "NonContentAreaHeight:" + this.Wx);
        }
    }

    public void pA(com.bytedance.sdk.openadsdk.core.Og.KZx kZx, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        View view;
        View view2;
        yFO yfo;
        if (this.JG != null && (yfo = this.ZZv) != null && yfo.lT() != null) {
            if (this.ZZv.lT().JG && !aBv.Og(this.ZZv)) {
                pA((View.OnClickListener) kZx);
                pA(kZx);
            } else {
                pA(onClickListener);
            }
        }
        yFO yfo2 = this.ZZv;
        if (yfo2 != null && yfo2.IG() == 1) {
            if (this.ZZv.lT() != null && (view2 = this.SD) != null) {
                Vgu.pA(view2, 0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.SD.getLayoutParams();
                layoutParams.height = this.Wx;
                this.SD.setLayoutParams(layoutParams);
                if (this.ZZv.lT().Og) {
                    this.SD.setOnClickListener(kZx);
                    this.SD.setOnTouchListener(onTouchListener);
                } else {
                    this.SD.setOnClickListener(onClickListener);
                }
            }
            if (this.ZZv.lT() != null && (view = this.omh) != null) {
                Vgu.pA(view, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.omh.getLayoutParams();
                layoutParams2.height = this.Wx;
                this.omh.setLayoutParams(layoutParams2);
                if (this.ZZv.lT().ZZv) {
                    this.omh.setOnClickListener(kZx);
                    this.omh.setOnTouchListener(onTouchListener);
                } else {
                    this.omh.setOnClickListener(onClickListener);
                }
            }
        }
        PAGLogoView pAGLogoView = this.Bzk;
        if (pAGLogoView != null) {
            pAGLogoView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.SGo.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/view/SGo$1;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view3);
                    safedk_SGo$1_onClick_c412f9bff65733d3a27381b1cf7f2704(view3);
                }

                public void safedk_SGo$1_onClick_c412f9bff65733d3a27381b1cf7f2704(View p0) {
                    try {
                        TTWebsiteActivity.pA(SGo.this.Og, SGo.this.ZZv, SGo.this.yFO);
                    } catch (Throwable th) {
                        WV.pA("TTAD.RFullVideoLayout", th.getMessage());
                    }
                }
            });
        }
        ImageView imageView = this.SGo;
        if (imageView != null) {
            imageView.setClickable(true);
            com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA((int) Vgu.pA(com.bytedance.sdk.openadsdk.core.aBv.pA(), 14.0f, true), this.SGo, this.KZx.Og);
        }
    }

    public void ZZv() {
        Vgu.pA((View) this.JG, 8);
        Vgu.pA(this.SD, 8);
        Vgu.pA(this.omh, 8);
        Og(8);
        Vgu.pA((View) this.ML, 8);
        Vgu.pA((View) this.Bzk, 8);
        Vgu.pA((View) this.BSW, 8);
        Vgu.pA((View) this.SGo, 8);
    }

    void ML() {
        int iXy = this.ZZv.xy();
        this.pA = iXy;
        if (iXy == -200) {
            this.pA = com.bytedance.sdk.openadsdk.core.aBv.ZZv().DX(String.valueOf(this.ZZv.Wf()));
        }
        if (this.pA != -1 || pA() || (this.KZx.nCO instanceof com.bytedance.sdk.openadsdk.component.reward.Og.ZZv) || (this.KZx.nCO instanceof com.bytedance.sdk.openadsdk.component.reward.Og.KZx)) {
            return;
        }
        Og(0);
    }

    void Og(boolean z) {
        ImageView imageView;
        int iPA;
        if (this.vZF != 1 && (imageView = this.ML) != null && z) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && (iPA = pA("navigation_bar_height")) > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (iPA > marginLayoutParams.rightMargin) {
                    marginLayoutParams.rightMargin = iPA;
                }
            }
        }
        if ((this.KZx.nCO instanceof com.bytedance.sdk.openadsdk.component.reward.Og.ZZv) || (this.KZx.nCO instanceof com.bytedance.sdk.openadsdk.component.reward.Og.KZx)) {
            return;
        }
        Og(0);
    }

    private int pA(String str) {
        Resources resources = this.Og.getResources();
        if (resources != null) {
            return resources.getDimensionPixelSize(resources.getIdentifier(str, "dimen", "android"));
        }
        return 0;
    }

    public void Og(int i) {
        yFO yfo = this.ZZv;
        if (yfo != null && yfo.rjD() && Wx.pA(this.ZZv)) {
            Vgu.pA((View) this.TX, 8);
        } else {
            Vgu.pA((View) this.TX, i);
        }
    }

    public FrameLayout JG() {
        return this.JG;
    }

    public void KZx(int i) {
        Vgu.pA((View) this.Bzk, i);
    }

    public void SD() {
        if (this.SGo.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.SGo.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 11, 16);
            marginLayoutParams.setMarginStart(0);
            marginLayoutParams.setMarginEnd(11);
            this.SGo.setLayoutParams(marginLayoutParams);
        }
    }

    public void ZZv(int i) {
        int i2 = this.pA;
        if (i2 == -1 || i != i2 || this.Sn.get()) {
            return;
        }
        Og(0);
        this.Sn.set(true);
        omh();
    }

    protected void omh() {
        KZx kZx = this.TX;
        if (kZx == null) {
            return;
        }
        kZx.pA();
    }

    public void ML(int i) {
        Vgu.pA((View) this.ML, i);
        if (i == 0 && !this.KZx.SGo.get() && WQf.SD(this.KZx.Og)) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.KZx.Og, this.KZx.ML, "show_close_button", (JSONObject) null, System.currentTimeMillis() - this.KZx.SXO);
        }
    }

    public boolean Bzk() {
        ImageView imageView = this.ML;
        return imageView != null && imageView.getVisibility() == 0;
    }

    public void pA(View.OnClickListener onClickListener) {
        Vgu.pA(this.JG, onClickListener, "TTBaseVideoActivity#mVideoNativeFrame");
    }

    private void pA(com.bytedance.sdk.openadsdk.core.Og.KZx kZx) {
        Vgu.pA((View) this.JG, (View.OnTouchListener) kZx, "TTBaseVideoActivity#mVideoNativeFrame");
    }

    public View SGo() {
        return this.ML;
    }

    public View BSW() {
        return this.TX;
    }

    public void pA(float f) {
        Vgu.pA(this.ML, f);
    }

    public void pA(Animation animation) {
        RelativeLayout relativeLayout = this.BSW;
        if (relativeLayout != null) {
            relativeLayout.startAnimation(animation);
        }
    }

    public void WV() {
        try {
            oX oXVar = this.WV;
            if (oXVar != null) {
                oXVar.KZx();
            }
            RelativeLayout relativeLayout = this.BSW;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
        } catch (Throwable unused) {
            RelativeLayout relativeLayout2 = this.BSW;
            if (relativeLayout2 != null) {
                relativeLayout2.setAlpha(0.0f);
            }
        }
    }

    public void Wx() {
        try {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.KZx.SzT, com.bytedance.sdk.component.utils.yFO.Bzk(this.KZx.SzT, "tt_fade_out"));
            if (animationLoadAnimation != null) {
                animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.SGo.3
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        SGo.this.KZx.Vgu.WV();
                    }
                });
                this.KZx.Vgu.pA(animationLoadAnimation);
            } else {
                this.KZx.Vgu.WV();
            }
        } catch (Throwable unused) {
            this.KZx.Vgu.WV();
        }
    }

    public void Sn() {
        aBv abv = this.DX;
        if (abv != null) {
            abv.JG();
        }
        ImageView imageView = this.ML;
        if (imageView != null) {
            imageView.removeCallbacks(this.aBv);
        }
    }

    public void DX() {
        aBv abv = this.DX;
        if (abv != null) {
            abv.SD();
        }
    }

    public void oX() {
        aBv abv = this.DX;
        if (abv != null) {
            abv.omh();
        }
    }

    public void pA(int i, com.bytedance.sdk.component.adexpress.Og.Sn sn) {
        aBv abv = this.DX;
        if (abv != null) {
            abv.pA(i, sn);
        }
    }

    public void aBv() {
        com.bytedance.sdk.openadsdk.core.Og.ML ML = this.KZx.roi.ML();
        View view = this.TX;
        if (view == null) {
            view = this.KZx.CIG;
        }
        ML.onClick(view);
    }
}
