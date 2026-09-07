package com.bytedance.sdk.openadsdk.core.KZx;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.model.Sn;
import com.bytedance.sdk.openadsdk.core.omh.aBv;
import com.bytedance.sdk.openadsdk.core.omh.yFO;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.WV;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class SD extends com.bytedance.sdk.openadsdk.core.omh.pA implements com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx, com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.ZZv {
    private com.bytedance.sdk.openadsdk.core.Wx.Og.JG DX;
    private com.bytedance.sdk.openadsdk.XT.pA.pA.JG Sn;
    private yFO Wx;
    private long XT;
    private String aBv;
    private ImageView oX;
    public boolean pA;
    private PAGBannerAdWrapperListener yFO;

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx
    public void d_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.pA, com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx
    public void g_() {
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx
    public void h_() {
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

    public SD(Context context) {
        super(context);
        this.pA = true;
        this.Og = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.pA
    protected void pA(View view, int i, Sn sn) {
        yFO yfo = this.Wx;
        if (yfo != null) {
            yfo.pA(view, i, sn);
            com.bytedance.sdk.openadsdk.core.Wx.Og.JG jg = this.DX;
            if (jg == null || !(jg.getNativeVideoController() instanceof com.bytedance.sdk.openadsdk.core.Wx.Og.KZx)) {
                return;
            }
            ((com.bytedance.sdk.openadsdk.core.Wx.Og.KZx) this.DX.getNativeVideoController()).xy();
        }
    }

    public void setClosedListenerKey(String str) {
        this.aBv = str;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, yFO yfo2, com.bytedance.sdk.openadsdk.XT.pA.pA.JG jg) {
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.KZx = yfo;
        this.Wx = yfo2;
        this.Sn = jg;
        this.JG = "banner_ad";
        this.Wx.addView(this, new ViewGroup.LayoutParams(-2, -2));
        ML();
    }

    private void ML() {
        aBv abvPA = com.bytedance.sdk.openadsdk.core.KZx.pA.pA(this.Wx.getExpectExpressWidth(), this.Wx.getExpectExpressHeight());
        if (this.Wx.getExpectExpressWidth() > 0 && this.Wx.getExpectExpressHeight() > 0) {
            this.SD = Vgu.KZx(this.Og, this.Wx.getExpectExpressWidth());
            this.omh = Vgu.KZx(this.Og, this.Wx.getExpectExpressHeight());
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
        pA(abvPA);
    }

    private void pA(aBv abv) {
        if (this.KZx != null) {
            int iRS = this.KZx.RS();
            pA pAVarOg = Og(abv);
            if (pAVarOg == null || pAVarOg.pA == null) {
                return;
            }
            addView(pAVarOg.pA);
            com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = pAVarOg.ZZv;
            PAGLogoView pAGLogoView = pAVarOg.ML;
            com.bytedance.sdk.openadsdk.core.ML.ZZv zZv2 = pAVarOg.JG;
            if (zZv2 != null && this.KZx.omh()) {
                Vgu.pA((View) zZv2, 0);
                com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA((int) Vgu.pA(com.bytedance.sdk.openadsdk.core.aBv.pA(), 11.0f, true), zZv2, this.KZx);
            }
            this.oX = pAVarOg.KZx;
            com.bytedance.sdk.openadsdk.core.Wx.Og.JG videoView = getVideoView();
            if (videoView instanceof com.bytedance.sdk.openadsdk.core.Wx.Og.JG) {
                this.DX = videoView;
                videoView.setVideoAdLoadListener(this);
                this.DX.setVideoAdInteractionListener(this);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair(zZv, FriendlyObstructionPurpose.CLOSE_AD));
                arrayList.add(new Pair(pAGLogoView, FriendlyObstructionPurpose.OTHER));
                arrayList.add(new Pair(zZv2, FriendlyObstructionPurpose.OTHER));
                arrayList.add(new Pair(this.oX, FriendlyObstructionPurpose.VIDEO_CONTROLS));
                this.DX.pA(arrayList);
                this.DX.setAdCreativeClickListener(new com.bytedance.sdk.openadsdk.core.Wx.Og.JG.pA() { // from class: com.bytedance.sdk.openadsdk.core.KZx.SD.1
                    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.JG.pA
                    public void pA(View view, int i) {
                        if (SD.this.yFO != null) {
                            SD.this.yFO.onAdClicked();
                        }
                    }
                });
            }
            if (pAGLogoView != null) {
                pAGLogoView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.KZx.SD.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/KZx/SD$2;->onClick(Landroid/view/View;)V");
                        CreativeInfoManager.onViewClicked(h.u, view);
                        safedk_SD$2_onClick_6eaf6a970e24d3574462f88866505592(view);
                    }

                    public void safedk_SD$2_onClick_6eaf6a970e24d3574462f88866505592(View p0) {
                        TTWebsiteActivity.pA(SD.this.Og, SD.this.KZx, SD.this.JG);
                    }
                });
            }
            if (zZv != null) {
                zZv.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.KZx.SD.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/KZx/SD$3;->onClick(Landroid/view/View;)V");
                        CreativeInfoManager.onViewClicked(h.u, view);
                        safedk_SD$3_onClick_ece8daa17c81598d71e94c297b675d16(view);
                    }

                    public void safedk_SD$3_onClick_ece8daa17c81598d71e94c297b675d16(View p0) {
                        SD.this.pA();
                    }
                });
                yFO yfo = this.Wx;
                if (yfo != null) {
                    if (yfo.getClickListener() != null) {
                        this.Wx.getClickListener().Og(zZv);
                    }
                    if (this.Wx.getClickCreativeListener() != null) {
                        this.Wx.getClickCreativeListener().Og(zZv);
                    }
                }
            }
            ImageView imageView = this.oX;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.KZx.SD.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/KZx/SD$4;->onClick(Landroid/view/View;)V");
                        CreativeInfoManager.onViewClicked(h.u, view);
                        safedk_SD$4_onClick_a37f71e545776391895c10feceb0f664(view);
                    }

                    public void safedk_SD$4_onClick_a37f71e545776391895c10feceb0f664(View p0) {
                        View p1 = SD.this.DX;
                        if (p1 != null) {
                            boolean zBzk = SD.this.DX.Bzk();
                            boolean z = !zBzk;
                            SD sd = SD.this;
                            Drawable drawableKZx = !zBzk ? com.bytedance.sdk.component.utils.yFO.KZx(sd.getContext(), "tt_reward_full_mute") : com.bytedance.sdk.component.utils.yFO.KZx(sd.getContext(), "tt_reward_full_unmute");
                            SD.this.DX.setIsQuiet(z);
                            SD.this.oX.setImageDrawable(drawableKZx);
                            if (SD.this.KZx == null || SD.this.KZx.dGZ() == null || SD.this.KZx.dGZ().pA() == null) {
                                return;
                            }
                            if (!zBzk) {
                                SD.this.KZx.dGZ().pA().omh(SD.this.XT);
                            } else {
                                SD.this.KZx.dGZ().pA().Bzk(SD.this.XT);
                            }
                        }
                    }
                });
            }
            WV wv = pAVarOg.Og;
            if (this.KZx != null && this.KZx.dGZ() != null && wv != null) {
                int iWV = this.KZx.dGZ().WV();
                float fWx = this.KZx.dGZ().Wx();
                if (iWV > 0 && fWx > 0.0f) {
                    wv.setRatio(iWV / fWx);
                } else if (iRS == 15) {
                    wv.setRatio(0.5625f);
                } else if (iRS == 5) {
                    wv.setRatio(1.7777778f);
                } else {
                    wv.setRatio(1.0f);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (videoView != null && wv != null) {
                wv.addView(videoView, layoutParams);
                videoView.setTag(520093762, Boolean.TRUE);
            }
            pA((View) videoView, true);
            pA((View) this, true);
            pA(wv);
        }
    }

    private pA Og(aBv abv) {
        pA pAVar = new pA();
        pAVar.pA = new FrameLayout(this.Og);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = -1;
        pAVar.pA.setLayoutParams(layoutParams);
        pAVar.Og = new WV(this.Og);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 17;
        pAVar.Og.setLayoutParams(layoutParams2);
        pAVar.pA.addView(pAVar.Og);
        int iKZx = Vgu.KZx(this.Og, 28.0f);
        int iKZx2 = Vgu.KZx(this.Og, 12.0f);
        int iKZx3 = Vgu.KZx(this.Og, 2.25f);
        int iKZx4 = Vgu.KZx(this.Og, 5.0f);
        if (abv != null && abv.pA == 1) {
            iKZx = iKZx2;
        }
        if (abv == null || abv.pA != 1) {
            iKZx3 = iKZx4;
        }
        pAVar.KZx = new com.bytedance.sdk.openadsdk.core.ML.ZZv(getContext());
        pAVar.KZx.setPadding(iKZx3, iKZx3, iKZx3, iKZx3);
        pAVar.KZx.setBackground(com.bytedance.sdk.openadsdk.core.widget.ZZv.pA());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iKZx, iKZx);
        layoutParams3.setMargins(iKZx4, iKZx4, iKZx4, iKZx4);
        pAVar.KZx.setScaleType(ImageView.ScaleType.FIT_CENTER);
        pAVar.KZx.setImageDrawable(com.bytedance.sdk.component.utils.yFO.KZx(getContext(), "tt_reward_full_mute"));
        pAVar.KZx.setLayoutParams(layoutParams3);
        pAVar.pA.addView(pAVar.KZx);
        if (abv != null && abv.pA == 1) {
            pAVar.ZZv = com.bytedance.sdk.openadsdk.core.widget.SD.pA(getContext());
        } else {
            pAVar.ZZv = com.bytedance.sdk.openadsdk.core.widget.SD.Og(getContext());
        }
        pAVar.ZZv.setId(520093697);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = GravityCompat.END;
        layoutParams4.setMargins(iKZx4, iKZx4, iKZx4, iKZx4);
        pAVar.ZZv.setLayoutParams(layoutParams4);
        pAVar.pA.addView(pAVar.ZZv);
        pAVar.ML = new PAGLogoView(this.Og);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 8388691;
        layoutParams5.setMargins(iKZx4, iKZx4, iKZx4, iKZx4);
        pAVar.ML.setLayoutParams(layoutParams5);
        pAVar.pA.addView(pAVar.ML);
        pAVar.JG = new com.bytedance.sdk.openadsdk.core.ML.ZZv(this.Og);
        int iKZx5 = Vgu.KZx(this.Og, 11.0f);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(iKZx5, iKZx5);
        layoutParams6.gravity = 8388693;
        layoutParams6.rightMargin = iKZx4;
        layoutParams6.bottomMargin = iKZx4;
        pAVar.JG.setVisibility(8);
        pAVar.JG.setScaleType(ImageView.ScaleType.FIT_CENTER);
        pAVar.JG.setLayoutParams(layoutParams6);
        pAVar.pA.addView(pAVar.JG);
        return pAVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.pA
    public void pA() {
        if (this.ML != null) {
            this.ML.show();
        } else if (this.ZZv != null) {
            this.ZZv.pA();
        } else {
            TTDelegateActivity.pA(this.KZx, this.aBv);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.ZZv
    public void pA(int i, int i2) {
        ImageView imageView = this.oX;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx
    public void pA(long j, long j2) {
        this.XT = j;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx
    public void i_() {
        ImageView imageView = this.oX;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public long getVideoProgress() {
        return this.XT;
    }

    public void setAdInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.yFO = pAGBannerAdWrapperListener;
    }

    private static class pA {
        public com.bytedance.sdk.openadsdk.core.ML.ZZv JG;
        public com.bytedance.sdk.openadsdk.core.ML.ZZv KZx;
        public PAGLogoView ML;
        public WV Og;
        public com.bytedance.sdk.openadsdk.core.ML.ZZv ZZv;
        public FrameLayout pA;

        private pA() {
        }
    }
}
