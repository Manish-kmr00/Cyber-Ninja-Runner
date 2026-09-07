package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.model.DX;
import com.bytedance.sdk.openadsdk.core.model.Sn;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.widget.aBv;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class pA extends com.bytedance.sdk.openadsdk.core.omh.pA {
    private int DX;
    private int Sn;
    private boolean Wx;
    private View XT;
    private View aBv;
    private int oX;
    private float pA;
    private com.bytedance.sdk.openadsdk.core.Og.ML vZF;
    private FrameLayout yFO;

    @Override // com.bytedance.sdk.openadsdk.core.omh.pA, com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public View getInteractionStyleRootView() {
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.pA, com.bytedance.sdk.openadsdk.core.ML.KZx, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.pA
    protected void pA(View view, int i, Sn sn) {
    }

    public pA(Context context, String str) {
        super(context, str);
        this.oX = 1;
        this.Og = context;
    }

    public void pA(yFO yfo, float f, int i, int i2, int i3) {
        this.pA = f;
        this.oX = i;
        this.KZx = yfo;
        this.JG = "fullscreen_interstitial_ad";
        this.Sn = i2;
        this.DX = i3;
        pA(this.Bzk);
        Og();
    }

    private void Og() {
        this.SD = Vgu.KZx(this.Og, this.Sn);
        this.omh = Vgu.KZx(this.Og, this.DX);
        int i = (int) (this.pA * 1000.0f);
        if (this.oX == 1) {
            if (i == 666) {
                ML();
                return;
            }
            if (i == 1000) {
                KZx();
                return;
            }
            if (i == 1500) {
                BSW();
                return;
            } else if (i == 1777) {
                Wx();
                return;
            } else {
                pA(0.562f);
                WV();
                return;
            }
        }
        if (i == 562) {
            Bzk();
            return;
        }
        if (i == 666) {
            SD();
            return;
        }
        if (i == 1000) {
            KZx();
        } else if (i == 1500) {
            omh();
        } else {
            pA(1.777f);
            SGo();
        }
    }

    private void KZx() {
        com.bytedance.sdk.openadsdk.Wx.pA pAVar = new com.bytedance.sdk.openadsdk.Wx.pA(this.Og);
        this.aBv = pAVar;
        Og(pAVar);
        ZZv();
        JG();
    }

    private void Og(View view) {
        if (view.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            view.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            addView(view);
        }
    }

    private void ZZv() {
        this.yFO = (FrameLayout) this.aBv.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.rjD);
        ImageView imageView = (ImageView) this.aBv.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.npn);
        aBv abv = (aBv) this.aBv.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.uQ);
        TextView textView = (TextView) this.aBv.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.mK);
        TextView textView2 = (TextView) this.aBv.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.jO);
        View viewFindViewById = this.aBv.findViewById(520093739);
        if (!TextUtils.isEmpty(this.KZx.gy())) {
            textView2.setText(this.KZx.gy());
        }
        pA(this.yFO, imageView);
        if (this.KZx.fJy() != null && !TextUtils.isEmpty(this.KZx.fJy().pA())) {
            com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.KZx.fJy().pA(), this.KZx.fJy().Og(), this.KZx.fJy().KZx(), abv, this.KZx);
        }
        textView.setText(getTitle());
        KZx(this.yFO);
        KZx(imageView);
        KZx(abv);
        KZx(textView);
        KZx(textView2);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.pA.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/view/pA$1;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_pA$1_onClick_837e1aa7145abfdfa9f7847d4b73fead(view);
            }

            public void safedk_pA$1_onClick_837e1aa7145abfdfa9f7847d4b73fead(View p0) {
                try {
                    TTWebsiteActivity.pA(pA.this.Og, pA.this.KZx, pA.this.JG);
                } catch (Throwable th) {
                    WV.pA("FullInteractionStyleView", th.getMessage());
                }
            }
        });
    }

    private void ML() {
        com.bytedance.sdk.openadsdk.Wx.KZx kZx = new com.bytedance.sdk.openadsdk.Wx.KZx(this.Og);
        this.aBv = kZx;
        Og(kZx);
        ZZv();
        JG();
    }

    private void JG() {
        TextView textView = (TextView) this.aBv.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.guZ);
        if (textView != null) {
            textView.setText(getDescription());
            KZx(textView);
        }
    }

    private void SD() {
        com.bytedance.sdk.openadsdk.Wx.Og og = new com.bytedance.sdk.openadsdk.Wx.Og(this.Og);
        this.aBv = og;
        Og(og);
        ZZv();
        JG();
    }

    private void omh() {
        com.bytedance.sdk.openadsdk.Wx.ZZv zZv = new com.bytedance.sdk.openadsdk.Wx.ZZv(this.Og);
        this.aBv = zZv;
        Og(zZv);
        ZZv();
    }

    private void Bzk() {
        com.bytedance.sdk.openadsdk.Wx.JG jg = new com.bytedance.sdk.openadsdk.Wx.JG(this.Og);
        this.aBv = jg;
        Og(jg);
        ZZv();
        JG();
    }

    private void SGo() {
        com.bytedance.sdk.openadsdk.Wx.omh omhVar = new com.bytedance.sdk.openadsdk.Wx.omh(this.Og);
        this.aBv = omhVar;
        Og(omhVar);
        ZZv();
    }

    private void BSW() {
        View ml = new com.bytedance.sdk.openadsdk.Wx.ML(this.Og);
        this.aBv = ml;
        Og(ml);
        this.yFO = (FrameLayout) this.aBv.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.rjD);
        ImageView imageView = (ImageView) this.aBv.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.dGZ);
        TextView textView = (TextView) this.aBv.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.qQU);
        View viewFindViewById = this.aBv.findViewById(520093739);
        pA(this.yFO, imageView);
        textView.setText(getDescription());
        KZx(this.yFO);
        KZx(imageView);
        KZx(textView);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.pA.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/view/pA$2;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_pA$2_onClick_08de7ea0a6fe8cd7d26404adf84dc404(view);
            }

            public void safedk_pA$2_onClick_08de7ea0a6fe8cd7d26404adf84dc404(View p0) {
                try {
                    TTWebsiteActivity.pA(pA.this.Og, pA.this.KZx, pA.this.JG);
                } catch (Throwable th) {
                    WV.pA("FullInteractionStyleView", th.getMessage());
                }
            }
        });
    }

    private void pA(FrameLayout frameLayout, ImageView imageView) {
        if (this.KZx == null) {
            return;
        }
        boolean zML = yFO.ML(this.KZx);
        if (this.KZx.Bf() != null && zML) {
            Vgu.pA((View) imageView, 8);
            Vgu.pA((View) frameLayout, 0);
        } else {
            pA(imageView);
            Vgu.pA((View) imageView, 0);
            Vgu.pA((View) frameLayout, 8);
        }
    }

    private void pA(ImageView imageView) {
        List<DX> listIIF;
        DX dx;
        if (this.KZx == null || (listIIF = this.KZx.IIF()) == null || listIIF.size() <= 0 || (dx = listIIF.get(0)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(dx).KZx(2).pA(com.bytedance.sdk.openadsdk.Bzk.KZx.pA(this.KZx, dx.pA(), imageView));
    }

    private void WV() {
        com.bytedance.sdk.openadsdk.Wx.SD sd = new com.bytedance.sdk.openadsdk.Wx.SD(this.Og);
        this.aBv = sd;
        Og(sd);
        ZZv();
    }

    private void Wx() {
        com.bytedance.sdk.openadsdk.Wx.Bzk bzk = new com.bytedance.sdk.openadsdk.Wx.Bzk(this.Og);
        this.aBv = bzk;
        Og(bzk);
        ZZv();
        JG();
    }

    private void KZx(View view) {
        if (view == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.Og.Og pAVar = this.vZF;
        if (pAVar == null) {
            pAVar = new com.bytedance.sdk.openadsdk.core.Og.pA(this.Og, this.KZx, this.JG, gbA.pA(this.JG));
            pAVar.pA(pA(this.KZx, this.Og));
        }
        view.setOnTouchListener(pAVar);
        view.setOnClickListener(pAVar);
    }

    private com.bytedance.sdk.openadsdk.XT.pA.pA.JG pA(yFO yfo, Context context) {
        if (yfo != null && yfo.JBA() == 4) {
            return new com.bytedance.sdk.openadsdk.XT.pA.pA.ZZv(context, yfo, this.JG);
        }
        return null;
    }

    public void setIsMute(boolean z) {
        this.Wx = z;
        View view = this.XT;
        if (view != null && (view instanceof com.bytedance.sdk.openadsdk.core.Wx.Og.JG)) {
            ((com.bytedance.sdk.openadsdk.core.Wx.Og.JG) view).setIsQuiet(z);
        }
    }

    public FrameLayout getVideoContainer() {
        return this.yFO;
    }

    public void setDownloadListener(com.bytedance.sdk.openadsdk.core.Og.ML ml) {
        this.vZF = ml;
    }

    private float getHeightDp() {
        return Vgu.ZZv(this.Og, Vgu.Bzk(this.Og));
    }

    private float getWidthDp() {
        return Vgu.ZZv(this.Og, Vgu.SGo(this.Og));
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0071  */
    private void pA(float f) {
        float fMin;
        float fMax;
        int iMax;
        int i;
        int iMax2;
        float heightDp = getHeightDp();
        float widthDp = getWidthDp();
        if (this.oX == 2) {
            fMin = Math.max(heightDp, widthDp);
            fMax = Math.min(heightDp, widthDp);
        } else {
            fMin = Math.min(heightDp, widthDp);
            fMax = Math.max(heightDp, widthDp);
        }
        if (this.oX != 2 && Vgu.KZx((Activity) this.Og)) {
            fMax -= Vgu.ZZv(this.Og, Vgu.pA());
        }
        int i2 = 20;
        if (this.oX != 2) {
            if (f == 0.0f || f == 100.0f) {
                i2 = 0;
                iMax2 = 0;
                iMax = 0;
                i = 0;
            } else {
                iMax2 = (int) Math.max((fMax - (((fMin - 20.0f) - 20.0f) / f)) / 2.0f, 0.0f);
                iMax = 20;
                i = 20;
                i2 = iMax2;
            }
        } else if (f == 0.0f || f == 100.0f) {
            i2 = 0;
            iMax2 = 0;
            iMax = 0;
            i = 0;
        } else {
            iMax = (int) Math.max((fMin - (((fMax - 20.0f) - 20.0f) * f)) / 2.0f, 0.0f);
            i = iMax;
            iMax2 = 20;
        }
        ((Activity) this.Og).getWindow().getDecorView().setPadding(Vgu.KZx(this.Og, iMax), Vgu.KZx(this.Og, i2), Vgu.KZx(this.Og, i), Vgu.KZx(this.Og, iMax2));
    }
}
