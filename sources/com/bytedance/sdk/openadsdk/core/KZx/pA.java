package com.bytedance.sdk.openadsdk.core.KZx;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.model.DX;
import com.bytedance.sdk.openadsdk.core.model.Sn;
import com.bytedance.sdk.openadsdk.core.omh.XT;
import com.bytedance.sdk.openadsdk.core.omh.aBv;
import com.bytedance.sdk.openadsdk.core.omh.omh;
import com.bytedance.sdk.openadsdk.core.omh.yFO;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.WV;
import com.bytedance.sdk.openadsdk.core.widget.Wx;
import com.bytedance.sdk.openadsdk.core.widget.oX;
import com.bytedance.sdk.openadsdk.utils.Bzk;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class pA extends com.bytedance.sdk.openadsdk.core.omh.pA {
    public static aBv[] pA = {new aBv(1, 6.4f, 320, 50), new aBv(4, 1.2f, 300, 250)};
    private String DX;
    private yFO Sn;
    private C0230pA Wx;
    private PAGBannerAdWrapperListener oX;

    @Override // com.bytedance.sdk.openadsdk.core.omh.pA, com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
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

    public void setClosedListenerKey(String str) {
        this.DX = str;
    }

    public pA(Context context) {
        super(context);
        this.Og = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.pA
    protected void pA(View view, int i, Sn sn) {
        yFO yfo = this.Sn;
        if (yfo != null) {
            yfo.pA(view, i, sn);
        }
    }

    void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, yFO yfo2, com.bytedance.sdk.openadsdk.XT.pA.pA.JG jg) {
        setBackgroundColor(-1);
        this.KZx = yfo;
        this.Sn = yfo2;
        this.JG = "banner_ad";
        this.Sn.addView(this, new ViewGroup.LayoutParams(-2, -2));
        Og();
    }

    private void Og() {
        aBv abvPA = pA(this.Sn.getExpectExpressWidth(), this.Sn.getExpectExpressHeight());
        if (this.Sn.getExpectExpressWidth() > 0 && this.Sn.getExpectExpressHeight() > 0) {
            this.SD = Vgu.KZx(this.Og, this.Sn.getExpectExpressWidth());
            this.omh = Vgu.KZx(this.Og, this.Sn.getExpectExpressHeight());
        } else {
            this.SD = Vgu.KZx(this.Og);
            this.omh = Float.valueOf(this.SD / abvPA.Og).intValue();
        }
        if (this.SD > 0 && this.SD > Vgu.KZx(this.Og)) {
            float fKZx = Vgu.KZx(this.Og) / this.SD;
            this.SD = Vgu.KZx(this.Og);
            this.omh = Float.valueOf(this.omh * fKZx).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.SD, this.omh);
        }
        layoutParams.width = this.SD;
        layoutParams.height = this.omh;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        if (this.KZx != null) {
            int iRS = this.KZx.RS();
            if (iRS == 1010 || iRS == 1011 || iRS == 1012) {
                ZZv();
            } else {
                pA(abvPA);
            }
        }
    }

    private void pA(aBv abv) {
        if (abv.pA == 1) {
            KZx();
        } else {
            ML();
        }
    }

    private void KZx() {
        float fKZx = (this.omh * 1.0f) / Vgu.KZx(this.Og, 50.0f);
        if ((this.omh * 1.0f) / this.SD > 0.21875f) {
            fKZx = (this.SD * 1.0f) / Vgu.KZx(this.Og, 320.0f);
        }
        C0230pA c0230pASD = SD();
        this.Wx = c0230pASD;
        ImageView imageView = c0230pASD.KZx;
        TextView textView = this.Wx.Og;
        oX oXVar = this.Wx.ZZv;
        TextView textView2 = this.Wx.SD;
        textView.setTextSize(2, Vgu.Og(this.Og, textView.getTextSize()) * fKZx);
        textView2.setTextSize(2, Vgu.Og(this.Og, textView2.getTextSize()) * fKZx);
        View view = this.Wx.JG;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.KZx.pA.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/KZx/pA$1;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view2);
                    safedk_pA$1_onClick_05cd441d9052670dae1e027b70b893c6(view2);
                }

                public void safedk_pA$1_onClick_05cd441d9052670dae1e027b70b893c6(View p0) {
                    TTWebsiteActivity.pA(pA.this.Og, pA.this.KZx, pA.this.JG);
                }
            });
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (Vgu.KZx(this.Og, 38.0f) * fKZx);
            layoutParams.height = (int) (Vgu.KZx(this.Og, 38.0f) * fKZx);
        }
        if (this.KZx.fJy() != null && !TextUtils.isEmpty(this.KZx.fJy().pA())) {
            com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.KZx.fJy().pA(), this.KZx.fJy().Og(), this.KZx.fJy().KZx(), imageView, this.KZx);
        }
        textView.setText(this.KZx.SXO());
        if (!TextUtils.isEmpty(this.KZx.gy())) {
            textView2.setText(this.KZx.gy());
        } else {
            textView2.setVisibility(8);
        }
        Vgu.pA((TextView) null, oXVar, this.KZx);
        pA((View) imageView, true);
        imageView.setTag(520093762, Boolean.TRUE);
        pA((View) this, true);
        pA((View) textView2, true);
    }

    private void ZZv() {
        C0230pA c0230pAJG = JG();
        this.Wx = c0230pAJG;
        View view = c0230pAJG.JG;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.KZx.pA.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/KZx/pA$2;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view2);
                    safedk_pA$2_onClick_584f2b33356e29eb44a5ff8a035d78f1(view2);
                }

                public void safedk_pA$2_onClick_584f2b33356e29eb44a5ff8a035d78f1(View p0) {
                    TTWebsiteActivity.pA(pA.this.Og, pA.this.KZx, pA.this.JG);
                }
            });
        }
        Wx wx = this.Wx.pA;
        if (wx != null) {
            List<DX> listIIF = this.KZx.IIF();
            if (listIIF != null && !listIIF.isEmpty()) {
                com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(listIIF.get(0), wx, this.KZx);
            }
            pA((View) wx, true);
            wx.setTag(520093762, Boolean.TRUE);
        }
    }

    private void ML() {
        if (this.KZx != null) {
            int iRS = this.KZx.RS();
            float fKZx = (this.omh * 1.0f) / Vgu.KZx(this.Og, 250.0f);
            if (this.KZx.Bf() == null) {
                C0230pA c0230pAOmh = omh();
                this.Wx = c0230pAOmh;
                Wx wx = c0230pAOmh.pA;
                ImageView imageView = this.Wx.KZx;
                TextView textView = this.Wx.Og;
                TextView textView2 = this.Wx.SD;
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = (int) (Vgu.KZx(this.Og, 45.0f) * fKZx);
                    layoutParams.height = (int) (Vgu.KZx(this.Og, 45.0f) * fKZx);
                }
                textView.setTextSize(2, Vgu.Og(this.Og, textView.getTextSize()) * fKZx);
                textView2.setTextSize(2, Vgu.Og(this.Og, textView2.getTextSize()) * fKZx);
                View view = this.Wx.JG;
                if (view != null) {
                    view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.KZx.pA.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/KZx/pA$3;->onClick(Landroid/view/View;)V");
                            CreativeInfoManager.onViewClicked(h.u, view2);
                            safedk_pA$3_onClick_3aa811d5597aa24fb3f52bcf692c5be0(view2);
                        }

                        public void safedk_pA$3_onClick_3aa811d5597aa24fb3f52bcf692c5be0(View p0) {
                            TTWebsiteActivity.pA(pA.this.Og, pA.this.KZx, pA.this.JG);
                        }
                    });
                }
                if (iRS == 33) {
                    wx.setRatio(1.0f);
                } else {
                    wx.setRatio(1.91f);
                }
                List<DX> listIIF = this.KZx.IIF();
                if (listIIF != null && !listIIF.isEmpty()) {
                    com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(listIIF.get(0), wx, this.KZx);
                    com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(listIIF.get(0).pA(), this.Wx.ML);
                }
                if (this.KZx.fJy() != null && !TextUtils.isEmpty(this.KZx.fJy().pA())) {
                    com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.KZx.fJy().pA(), this.KZx.fJy().Og(), this.KZx.fJy().KZx(), imageView, this.KZx);
                }
                textView.setText(this.KZx.SXO());
                if (!TextUtils.isEmpty(this.KZx.gy())) {
                    textView2.setText(this.KZx.gy());
                } else {
                    textView2.setVisibility(8);
                }
                Vgu.pA((TextView) null, this.Wx.ZZv, this.KZx);
                pA((View) wx, true);
                wx.setTag(520093762, Boolean.TRUE);
                pA((View) this, true);
                pA((View) textView2, true);
                return;
            }
            C0230pA c0230pABzk = Bzk();
            this.Wx = c0230pABzk;
            TextView textView3 = c0230pABzk.Og;
            TextView textView4 = this.Wx.SD;
            WV wv = this.Wx.omh;
            textView3.setTextSize(2, Vgu.Og(this.Og, textView3.getTextSize()) * fKZx);
            textView4.setTextSize(2, Vgu.Og(this.Og, textView4.getTextSize()) * fKZx);
            com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.KZx.Bf().SGo(), this.Wx.ML);
            View view2 = this.Wx.JG;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.KZx.pA.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/KZx/pA$4;->onClick(Landroid/view/View;)V");
                        CreativeInfoManager.onViewClicked(h.u, view3);
                        safedk_pA$4_onClick_8b6ad3efd17665ae526c458f06213df9(view3);
                    }

                    public void safedk_pA$4_onClick_8b6ad3efd17665ae526c458f06213df9(View p0) {
                        TTWebsiteActivity.pA(pA.this.Og, pA.this.KZx, pA.this.JG);
                    }
                });
            }
            if (iRS == 15) {
                wv.setRatio(0.5625f);
            } else if (iRS == 5) {
                wv.setRatio(1.7777778f);
            } else {
                wv.setRatio(1.0f);
            }
            wv.removeAllViews();
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            com.bytedance.sdk.openadsdk.core.Wx.Og.JG videoView = getVideoView();
            if (videoView != null) {
                yFO yfo = this.Sn;
                if (yfo instanceof XT) {
                    videoView.setVideoAdInteractionListener((XT) yfo);
                }
                wv.addView(videoView, layoutParams2);
                videoView.setAdCreativeClickListener(new com.bytedance.sdk.openadsdk.core.Wx.Og.JG.pA() { // from class: com.bytedance.sdk.openadsdk.core.KZx.pA.5
                    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.JG.pA
                    public void pA(View view3, int i) {
                        if (pA.this.oX != null) {
                            pA.this.oX.onAdClicked();
                        }
                    }
                });
                omh clickCreativeListener = this.Sn.getClickCreativeListener();
                if (clickCreativeListener != null) {
                    clickCreativeListener.pA(videoView.getNativeVideoController());
                }
            }
            if (this.KZx.fJy() != null && !TextUtils.isEmpty(this.KZx.fJy().pA())) {
                com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.KZx.fJy().pA(), this.KZx.fJy().Og(), this.KZx.fJy().KZx(), this.Wx.KZx, this.KZx);
            }
            textView3.setText(this.KZx.SXO());
            Vgu.pA((TextView) null, this.Wx.ZZv, this.KZx);
            if (!TextUtils.isEmpty(this.KZx.gy())) {
                textView4.setText(this.KZx.gy());
            } else {
                textView4.setVisibility(8);
            }
            pA((View) videoView, true);
            if (videoView != null) {
                videoView.setTag(520093762, Boolean.TRUE);
            }
            pA((View) this, true);
            pA((View) textView4, true);
            pA(wv);
        }
    }

    public static aBv pA(int i, int i2) {
        try {
            return ((double) i2) >= Math.floor((((double) i) * 450.0d) / 600.0d) ? pA[1] : pA[0];
        } catch (Throwable unused) {
            return pA[0];
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.pA
    public void pA() {
        if (this.ML != null) {
            this.ML.show();
        } else if (this.ZZv != null) {
            this.ZZv.pA();
        } else {
            TTDelegateActivity.pA(this.KZx, this.DX);
        }
    }

    private C0230pA JG() {
        int iKZx = Vgu.KZx(this.Og, 8.0f);
        Wx wx = new Wx(this.Og);
        wx.setId(520093736);
        wx.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(wx, layoutParams);
        View pAGLogoView = new PAGLogoView(this.Og);
        pAGLogoView.setId(520093739);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(iKZx, iKZx, 0, 0);
        layoutParams2.gravity = 8388659;
        pAGLogoView.setLayoutParams(layoutParams2);
        addView(pAGLogoView);
        return new C0230pA(pAGLogoView, wx);
    }

    private C0230pA SD() {
        int iKZx = Vgu.KZx(this.Og, 38.0f);
        int iKZx2 = (int) (((double) Vgu.KZx(this.Og, 25.0f)) / 5.0d);
        int iKZx3 = Vgu.KZx(this.Og, 10.0f);
        int iKZx4 = Vgu.KZx(this.Og, 2.0f);
        int iKZx5 = Vgu.KZx(this.Og, 6.0f);
        int iKZx6 = Vgu.KZx(this.Og, 8.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.Og);
        addView(relativeLayout, -1, -1);
        com.bytedance.sdk.openadsdk.core.widget.aBv abv = new com.bytedance.sdk.openadsdk.core.widget.aBv(this.Og);
        abv.setId(520093738);
        TextView textView = new TextView(this.Og);
        textView.setId(520093730);
        oX oXVar = new oX(this.Og);
        oXVar.setId(520093735);
        View pAGLogoView = new PAGLogoView(this.Og);
        pAGLogoView.setId(520093739);
        TextView textView2 = new TextView(this.Og);
        textView2.setId(520093703);
        C0230pA c0230pA = new C0230pA(abv, textView, oXVar, pAGLogoView, textView2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iKZx, iKZx);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        layoutParams.addRule(20);
        layoutParams.setMarginStart(iKZx5);
        layoutParams.setMargins(iKZx5, 0, 0, 0);
        abv.setLayoutParams(layoutParams);
        abv.setBackgroundColor(-1);
        abv.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(abv);
        LinearLayout linearLayout = new LinearLayout(this.Og);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(16, textView2.getId());
        layoutParams2.addRule(17, abv.getId());
        layoutParams2.setMarginStart(iKZx6);
        layoutParams2.setMarginEnd(iKZx6);
        layoutParams2.addRule(0, textView2.getId());
        layoutParams2.addRule(1, abv.getId());
        layoutParams2.setMargins(iKZx6, 0, iKZx6, 0);
        relativeLayout.addView(linearLayout, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        textView.setTextDirection(5);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(80);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#FF333333"));
        textView.setTextSize(12.0f);
        textView.setLayoutParams(layoutParams3);
        linearLayout.addView(textView);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = iKZx4;
        oXVar.setLayoutParams(layoutParams4);
        linearLayout.addView(oXVar);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(20);
        layoutParams5.addRule(9);
        layoutParams5.addRule(12);
        pAGLogoView.setLayoutParams(layoutParams5);
        relativeLayout.addView(pAGLogoView);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(11);
        layoutParams6.addRule(15);
        layoutParams6.setMarginEnd(iKZx5);
        layoutParams6.addRule(21);
        layoutParams6.rightMargin = iKZx5;
        textView2.setBackground(Bzk.pA(this.Og, 12));
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setGravity(17);
        textView2.setMaxLines(1);
        textView2.setPadding(iKZx3, iKZx2, iKZx3, iKZx2);
        textView2.setText(com.bytedance.sdk.component.utils.yFO.pA(this.Og, "tt_video_download_apk"));
        textView2.setTextColor(Color.parseColor("#f0f0f0"));
        textView2.setTextSize(10.0f);
        textView2.setLayoutParams(layoutParams6);
        relativeLayout.addView(textView2);
        return c0230pA;
    }

    private C0230pA omh() {
        int iKZx = Vgu.KZx(this.Og, 8.0f);
        int iKZx2 = Vgu.KZx(this.Og, 21.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.Og);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        relativeLayout.setPadding(iKZx, iKZx, iKZx, iKZx2);
        relativeLayout.setLayoutParams(layoutParams);
        addView(relativeLayout);
        LinearLayout linearLayout = new LinearLayout(this.Og);
        linearLayout.setId(520093737);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams2);
        relativeLayout.addView(linearLayout);
        com.bytedance.sdk.openadsdk.core.widget.aBv abv = new com.bytedance.sdk.openadsdk.core.widget.aBv(this.Og);
        abv.setId(520093738);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(Vgu.KZx(this.Og, 52.0f), Vgu.KZx(this.Og, 52.0f));
        abv.setScaleType(ImageView.ScaleType.FIT_XY);
        abv.setLayoutParams(layoutParams3);
        linearLayout.addView(abv);
        LinearLayout linearLayout2 = new LinearLayout(this.Og);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        layoutParams4.leftMargin = iKZx;
        layoutParams4.rightMargin = iKZx;
        layoutParams4.setMarginStart(iKZx);
        layoutParams4.setMarginEnd(iKZx);
        linearLayout.addView(linearLayout2, layoutParams4);
        TextView textView = new TextView(this.Og);
        textView.setId(520093730);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#FF3E3E3E"));
        textView.setTextSize(12.0f);
        textView.setLayoutParams(layoutParams5);
        linearLayout2.addView(textView);
        oX oXVar = new oX(this.Og);
        oXVar.setId(520093735);
        linearLayout2.addView(oXVar, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(this.Og);
        textView2.setId(520093703);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(Vgu.KZx(this.Og, 76.0f), Vgu.KZx(this.Og, 36.0f));
        textView2.setBackground(Bzk.pA(this.Og, 18));
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setGravity(17);
        textView2.setText(com.bytedance.sdk.component.utils.yFO.pA(this.Og, "tt_video_download_apk"));
        textView2.setTextColor(-1);
        textView2.setTextSize(14.0f);
        textView2.setLayoutParams(layoutParams6);
        linearLayout.addView(textView2);
        FrameLayout frameLayout = new FrameLayout(this.Og);
        frameLayout.setLayoutDirection(3);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams7.addRule(2, linearLayout.getId());
        layoutParams7.bottomMargin = iKZx2;
        frameLayout.setLayoutParams(layoutParams7);
        relativeLayout.addView(frameLayout);
        Wx wx = new Wx(this.Og);
        wx.setId(520093736);
        wx.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams8.gravity = 17;
        frameLayout.addView(wx, layoutParams8);
        View pAGLogoView = new PAGLogoView(this.Og);
        pAGLogoView.setId(520093739);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams9.addRule(10);
        layoutParams9.addRule(9);
        layoutParams9.setMargins(iKZx, iKZx, 0, 0);
        pAGLogoView.setLayoutParams(layoutParams9);
        relativeLayout.addView(pAGLogoView);
        return new C0230pA(abv, pAGLogoView, textView2, textView, wx, oXVar, frameLayout);
    }

    private C0230pA Bzk() {
        int iKZx = Vgu.KZx(this.Og, 8.0f);
        int iKZx2 = Vgu.KZx(this.Og, 21.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.Og);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        relativeLayout.setPadding(iKZx, iKZx, iKZx, iKZx2);
        relativeLayout.setLayoutParams(layoutParams);
        addView(relativeLayout);
        LinearLayout linearLayout = new LinearLayout(this.Og);
        linearLayout.setId(520093737);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams2);
        relativeLayout.addView(linearLayout);
        com.bytedance.sdk.openadsdk.core.widget.aBv abv = new com.bytedance.sdk.openadsdk.core.widget.aBv(this.Og);
        abv.setId(520093738);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(Vgu.KZx(this.Og, 52.0f), Vgu.KZx(this.Og, 52.0f));
        abv.setScaleType(ImageView.ScaleType.FIT_XY);
        abv.setLayoutParams(layoutParams3);
        linearLayout.addView(abv);
        LinearLayout linearLayout2 = new LinearLayout(this.Og);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        layoutParams4.leftMargin = iKZx;
        layoutParams4.rightMargin = iKZx;
        layoutParams4.setMarginStart(iKZx);
        layoutParams4.setMarginEnd(iKZx);
        linearLayout.addView(linearLayout2, layoutParams4);
        TextView textView = new TextView(this.Og);
        textView.setId(520093730);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#FF3E3E3E"));
        textView.setTextSize(12.0f);
        textView.setLayoutParams(layoutParams5);
        linearLayout2.addView(textView);
        oX oXVar = new oX(this.Og);
        oXVar.setId(520093735);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = Vgu.KZx(this.Og, 4.0f);
        linearLayout2.addView(oXVar, layoutParams6);
        TextView textView2 = new TextView(this.Og);
        textView2.setId(520093703);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(Vgu.KZx(this.Og, 76.0f), Vgu.KZx(this.Og, 36.0f));
        textView2.setBackground(Bzk.pA(this.Og, 18));
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setGravity(17);
        textView2.setText(com.bytedance.sdk.component.utils.yFO.pA(this.Og, "tt_video_download_apk"));
        textView2.setTextColor(-1);
        textView2.setTextSize(14.0f);
        textView2.setLayoutParams(layoutParams7);
        linearLayout.addView(textView2);
        FrameLayout frameLayout = new FrameLayout(this.Og);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams8.addRule(2, linearLayout.getId());
        layoutParams8.bottomMargin = iKZx2;
        frameLayout.setLayoutParams(layoutParams8);
        relativeLayout.addView(frameLayout);
        WV wv = new WV(this.Og);
        wv.setId(520093736);
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams9.gravity = 17;
        wv.setLayoutParams(layoutParams9);
        frameLayout.addView(wv);
        View pAGLogoView = new PAGLogoView(this.Og);
        pAGLogoView.setId(520093739);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(10);
        layoutParams10.addRule(9);
        layoutParams10.setMargins(iKZx, iKZx, 0, 0);
        pAGLogoView.setLayoutParams(layoutParams10);
        relativeLayout.addView(pAGLogoView);
        return new C0230pA(abv, pAGLogoView, textView2, textView, wv, oXVar, frameLayout);
    }

    public void setAdInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.oX = pAGBannerAdWrapperListener;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.KZx.pA$pA, reason: collision with other inner class name */
    private static class C0230pA {
        View JG;
        ImageView KZx;
        FrameLayout ML;
        public TextView Og;
        TextView SD;
        oX ZZv;
        private WV omh;
        public Wx pA;

        C0230pA(ImageView imageView, TextView textView, oX oXVar, View view, TextView textView2) {
            this.KZx = imageView;
            this.Og = textView;
            this.ZZv = oXVar;
            this.JG = view;
            this.SD = textView2;
        }

        public C0230pA(ImageView imageView, View view, TextView textView, TextView textView2, Wx wx, oX oXVar, FrameLayout frameLayout) {
            this.KZx = imageView;
            this.JG = view;
            this.SD = textView;
            this.Og = textView2;
            this.pA = wx;
            this.ZZv = oXVar;
            this.ML = frameLayout;
        }

        public C0230pA(ImageView imageView, View view, TextView textView, TextView textView2, WV wv, oX oXVar, FrameLayout frameLayout) {
            this.KZx = imageView;
            this.JG = view;
            this.SD = textView;
            this.Og = textView2;
            this.omh = wv;
            this.ZZv = oXVar;
            this.ML = frameLayout;
        }

        public C0230pA(View view, Wx wx) {
            this.JG = view;
            this.pA = wx;
        }
    }
}
