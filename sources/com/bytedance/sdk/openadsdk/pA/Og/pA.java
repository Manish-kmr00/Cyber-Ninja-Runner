package com.bytedance.sdk.openadsdk.pA.Og;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGImageItem;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoMediaView;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.DX;
import com.bytedance.sdk.openadsdk.core.omh.Bzk;
import com.bytedance.sdk.openadsdk.core.omh.XT;
import com.bytedance.sdk.openadsdk.core.omh.yFO;
import com.bytedance.sdk.openadsdk.core.settings.oX;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class pA {
    private com.bytedance.sdk.openadsdk.core.Og.pA BSW;
    private yFO Bzk;
    private Og JG;
    private final String KZx;
    private WeakReference<com.bytedance.sdk.openadsdk.core.Wx.Og.JG> ML;
    private final Context Og;
    private com.bytedance.sdk.openadsdk.pA.Og.pA.KZx SD;
    private PAGMediaView SGo;
    private WeakReference<com.bytedance.sdk.openadsdk.core.WV.JG> Sn;
    private com.bytedance.sdk.openadsdk.core.Og.Og WV;
    private boolean Wx = false;
    private boolean ZZv;
    private PAGMediaView omh;
    protected final com.bytedance.sdk.openadsdk.core.model.yFO pA;

    public pA(Context context, com.bytedance.sdk.openadsdk.core.model.yFO yfo, String str) {
        this.Og = context;
        this.pA = yfo;
        this.KZx = str;
    }

    public void pA(Og og) {
        this.JG = og;
    }

    public void pA(com.bytedance.sdk.openadsdk.pA.Og.pA.KZx kZx) {
        this.SD = kZx;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.Wx.Og.JG jg) {
        this.ML = new WeakReference<>(jg);
    }

    public void pA(boolean z) {
        this.ZZv = z;
    }

    public PAGMediaView pA() {
        return this.omh;
    }

    public yFO Og() {
        return this.Bzk;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.Og.pA pAVar) {
        this.BSW = pAVar;
    }

    public PAGImageItem KZx() {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.pA;
        if (yfo == null || yfo.fJy() == null) {
            return null;
        }
        return new PAGImageItem(this.pA.fJy().KZx(), this.pA.fJy().Og(), this.pA.fJy().pA(), (float) this.pA.fJy().ZZv());
    }

    public String ZZv() {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.pA;
        if (yfo != null) {
            return pA(yfo);
        }
        return null;
    }

    private String pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (yfo.Wo() != null && !TextUtils.isEmpty(yfo.Wo().Og())) {
            return yfo.Wo().Og();
        }
        if (!TextUtils.isEmpty(yfo.HSv())) {
            return yfo.HSv();
        }
        if (!TextUtils.isEmpty(yfo.SXO())) {
            return yfo.SXO();
        }
        return "";
    }

    private String Og(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (!TextUtils.isEmpty(yfo.SXO())) {
            return yfo.SXO();
        }
        if (!TextUtils.isEmpty(yfo.fw())) {
            return yfo.fw();
        }
        return "";
    }

    public String ML() {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.pA;
        if (yfo != null) {
            return Og(yfo);
        }
        return null;
    }

    public String JG() {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.pA;
        if (yfo != null) {
            return yfo.gy();
        }
        return null;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.Og.Og og) {
        this.WV = og;
    }

    public PAGMediaView SD() {
        PAGMediaView pAGMediaViewBzk;
        com.bytedance.sdk.openadsdk.utils.Og.pA(this.pA);
        if (this.pA.BF() == 2) {
            pAGMediaViewBzk = Sn();
            pA(pAGMediaViewBzk);
        } else {
            pAGMediaViewBzk = Bzk();
        }
        if (pAGMediaViewBzk != null) {
            pAGMediaViewBzk.setMrcTrackerKey(com.bytedance.sdk.openadsdk.BF.Og.ML.Og(this.pA));
        } else {
            pAGMediaViewBzk = new PAGMediaView(this.Og) { // from class: com.bytedance.sdk.openadsdk.pA.Og.pA.1
                @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView, android.view.ViewGroup, android.view.View
                public boolean dispatchTouchEvent(MotionEvent me) {
                    DetectTouchUtils.viewOnTouch(h.u, this, me);
                    return super.dispatchTouchEvent(me);
                }

                @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView, android.widget.FrameLayout, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    if (1 == 0) {
                        setMeasuredDimension(0, 0);
                    } else {
                        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                        CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
                    }
                }

                @Override // android.view.ViewGroup, android.view.View
                protected void onAttachedToWindow() {
                    super.onAttachedToWindow();
                    com.bytedance.sdk.openadsdk.utils.KZx.pA(this, pA.this.pA);
                }
            };
        }
        if (pAGMediaViewBzk instanceof PAGVideoMediaView) {
            ((PAGVideoMediaView) pAGMediaViewBzk).setMaterialMeta(this.pA);
        }
        this.SGo = pAGMediaViewBzk;
        return pAGMediaViewBzk;
    }

    public PAGMediaView omh() {
        return this.SGo;
    }

    private void pA(PAGMediaView pAGMediaView) {
        if (pAGMediaView == null) {
            return;
        }
        try {
            pAGMediaView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        } catch (Exception unused) {
        }
    }

    private PAGMediaView Sn() {
        if (com.bytedance.sdk.openadsdk.core.model.yFO.ML(this.pA)) {
            com.bytedance.sdk.openadsdk.pA.Og.pA.KZx kZx = this.SD;
            if (kZx == null || !(kZx instanceof com.bytedance.sdk.openadsdk.pA.Og.pA.Og)) {
                return null;
            }
            XT xt = (XT) kZx.ZZv();
            xt.setTag(520093762, Boolean.TRUE);
            if (!this.Wx) {
                this.SD.ML();
            }
            this.Wx = true;
            return pA(xt);
        }
        com.bytedance.sdk.openadsdk.pA.Og.pA.KZx kZx2 = this.SD;
        if (kZx2 == null) {
            return null;
        }
        yFO yfoZZv = kZx2.ZZv();
        yfoZZv.setTag(520093762, Boolean.TRUE);
        if (!this.Wx) {
            this.SD.ML();
        }
        this.Wx = true;
        return pA(yfoZZv);
    }

    public PAGMediaView Bzk() {
        if (com.bytedance.sdk.openadsdk.core.model.yFO.ML(this.pA)) {
            Og og = this.JG;
            if (og != null) {
                View viewML = og.ML();
                if (viewML != null) {
                    if (viewML.getParent() instanceof ViewGroup) {
                        ((ViewGroup) viewML.getParent()).removeView(viewML);
                    }
                    PAGMediaView pAGMediaView = this.omh;
                    if (pAGMediaView != null) {
                        pAGMediaView.setOnClickListener(null);
                        this.omh.setOnTouchListener(null);
                    }
                    PAGVideoMediaView pAGVideoMediaView = new PAGVideoMediaView(this.Og, viewML, this);
                    pAGVideoMediaView.setTag(520093762, Boolean.TRUE);
                    if (this.BSW != null && oX.vkV().ZZv(String.valueOf(this.pA.Wf()))) {
                        pAGVideoMediaView.setOnClickListener(this.BSW);
                        pAGVideoMediaView.setOnTouchListener(this.BSW);
                    } else {
                        com.bytedance.sdk.openadsdk.core.Og.KZx kZx = new com.bytedance.sdk.openadsdk.core.Og.KZx() { // from class: com.bytedance.sdk.openadsdk.pA.Og.pA.2
                            @Override // com.bytedance.sdk.openadsdk.core.Og.KZx
                            protected void pA(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray, boolean z) {
                                try {
                                    ((PAGVideoMediaView) view).handleInterruptVideo();
                                } catch (Exception unused) {
                                }
                            }
                        };
                        pAGVideoMediaView.setOnClickListener(kZx);
                        pAGVideoMediaView.setOnTouchListener(kZx);
                    }
                    this.omh = pAGVideoMediaView;
                    pAGVideoMediaView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    return pAGVideoMediaView;
                }
                ApmHelper.reportCustomError("adVideoView null", "getMediaView return null", new RuntimeException());
                return null;
            }
            ApmHelper.reportCustomError("mPAGFeedVideoAdImpl null", "getMediaView return null", new RuntimeException());
            return null;
        }
        List<DX> listIIF = this.pA.IIF();
        if (listIIF != null && !listIIF.isEmpty()) {
            ImageView imageView = new ImageView(this.Og);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            DX dx = listIIF.get(0);
            if (dx != null) {
                com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(dx).KZx(2).pA(com.bytedance.sdk.openadsdk.Bzk.KZx.pA(this.pA, dx.pA(), imageView));
            }
            PAGMediaView pAGMediaViewPA = pA(imageView);
            if (this.BSW != null && oX.vkV().ZZv(String.valueOf(this.pA.Wf()))) {
                pAGMediaViewPA.setOnClickListener(this.BSW);
                pAGMediaViewPA.setOnTouchListener(this.BSW);
            } else {
                pAGMediaViewPA.setOnClickListener(null);
                pAGMediaViewPA.setOnTouchListener(null);
            }
            pAGMediaViewPA.setTag(520093762, Boolean.TRUE);
            PAGMediaView pAGMediaView2 = this.omh;
            if (pAGMediaView2 != null) {
                pAGMediaView2.setOnClickListener(null);
                this.omh.setOnTouchListener(null);
            }
            this.omh = pAGMediaViewPA;
            return pAGMediaViewPA;
        }
        ApmHelper.reportCustomError("images empty", "getMediaView return null", new RuntimeException());
        return null;
    }

    private PAGMediaView pA(final View view) {
        int i;
        if (view == null) {
            return null;
        }
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        yFO yfo = this.Bzk;
        if (yfo != null) {
            yfo.setClickListener(null);
            this.Bzk.setClickCreativeListener(null);
        }
        com.bytedance.sdk.openadsdk.core.Og.Og og = this.WV;
        if (og != null && (og instanceof Bzk) && (view instanceof yFO)) {
            ((yFO) view).setClickListener((Bzk) og);
        }
        com.bytedance.sdk.openadsdk.core.Og.pA pAVar = this.BSW;
        if (pAVar != null && (pAVar instanceof com.bytedance.sdk.openadsdk.core.omh.omh) && (view instanceof yFO)) {
            ((yFO) view).setClickCreativeListener((com.bytedance.sdk.openadsdk.core.omh.omh) pAVar);
        }
        PAGMediaView pAGMediaView = new PAGMediaView(this.Og) { // from class: com.bytedance.sdk.openadsdk.pA.Og.pA.3
            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView, android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent me) {
                DetectTouchUtils.viewOnTouch(h.u, this, me);
                return super.dispatchTouchEvent(me);
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView, android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                if (1 == 0) {
                    setMeasuredDimension(0, 0);
                } else {
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                    CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
                }
            }

            @Override // android.view.View
            public void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                if (view instanceof yFO) {
                    return;
                }
                pA(z);
            }

            private void pA(boolean z) {
                if (this.pA != null) {
                    com.bytedance.sdk.openadsdk.BF.Og.ML.pA(com.bytedance.sdk.openadsdk.BF.Og.ML.pA(this.pA), z ? 4 : 8);
                }
                if (pA.this.pA != null) {
                    com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(pA.this.pA, z);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView
            public void setVideoAdListener(PAGVideoAdListener pAGVideoAdListener) {
                super.setVideoAdListener(pAGVideoAdListener);
                pA.this.pA(pAGVideoAdListener);
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                com.bytedance.sdk.openadsdk.utils.KZx.pA(this, pA.this.pA);
            }
        };
        int i2 = -1;
        pAGMediaView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            i2 = layoutParams.width;
            i = layoutParams.height;
        } else {
            i = -1;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i);
        layoutParams2.gravity = 17;
        pAGMediaView.addView(view, layoutParams2);
        if (view instanceof yFO) {
            this.Bzk = (yFO) view;
        }
        return pAGMediaView;
    }

    public View SGo() {
        if (aBv.pA() == null) {
            WV.pA("TTNativeAdImpl", "getAdLogoView mContext == null");
            return null;
        }
        ImageView imageView = new ImageView(aBv.pA());
        imageView.setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(aBv.pA(), "tt_ad_logo_new"));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.pA.Og.pA.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/pA/Og/pA$4;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_pA$4_onClick_f9cbf11abfb9b8472a195ad789b5096b(view);
            }

            public void safedk_pA$4_onClick_f9cbf11abfb9b8472a195ad789b5096b(View p0) {
                pA.this.WV();
            }
        });
        return imageView;
    }

    public View BSW() {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo;
        if (aBv.pA() == null || (yfo = this.pA) == null) {
            WV.pA("TTNativeAdImpl", "getAdChoicesView mContext == null");
            return null;
        }
        if (!yfo.rjD() || !this.pA.omh()) {
            return null;
        }
        ImageView imageView = new ImageView(aBv.pA());
        com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA((int) Vgu.pA(aBv.pA(), 14.0f, true), imageView, this.pA);
        return imageView;
    }

    public void WV() {
        Context context = this.Og;
        if (context != null) {
            TTWebsiteActivity.pA(context, this.pA, this.KZx);
        }
    }

    public void pA(PAGVideoAdListener pAGVideoAdListener) {
        com.bytedance.sdk.openadsdk.pA.Og.pA.KZx kZx;
        if (this.pA.BF() == 2 && com.bytedance.sdk.openadsdk.core.model.yFO.ML(this.pA) && (kZx = this.SD) != null && (kZx instanceof com.bytedance.sdk.openadsdk.pA.Og.pA.Og)) {
            XT xt = (XT) kZx.ZZv();
            if (xt != null) {
                xt.setVideoAdListener(Og(pAGVideoAdListener));
                return;
            }
            return;
        }
        Og og = this.JG;
        if (og != null) {
            og.pA(Og(pAGVideoAdListener));
        }
    }

    private KZx Og(final PAGVideoAdListener pAGVideoAdListener) {
        return new KZx() { // from class: com.bytedance.sdk.openadsdk.pA.Og.pA.5
            @Override // com.bytedance.sdk.openadsdk.pA.Og.KZx
            public void pA(int i, int i2) {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoError();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.pA.Og.KZx
            public void pA(PAGNativeAd pAGNativeAd) {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdPlay();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.pA.Og.KZx
            public void Og(PAGNativeAd pAGNativeAd) {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdPaused();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.pA.Og.KZx
            public void KZx(PAGNativeAd pAGNativeAd) {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdComplete();
                }
            }
        };
    }

    public void Wx() {
        com.bytedance.sdk.openadsdk.core.WV.JG jg;
        WeakReference<com.bytedance.sdk.openadsdk.core.WV.JG> weakReference = this.Sn;
        if (weakReference == null || (jg = weakReference.get()) == null) {
            return;
        }
        jg.pA(13);
    }

    public void pA(com.bytedance.sdk.openadsdk.core.WV.JG jg) {
        this.Sn = new WeakReference<>(jg);
    }
}
