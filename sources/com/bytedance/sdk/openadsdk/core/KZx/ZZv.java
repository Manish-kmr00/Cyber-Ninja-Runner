package com.bytedance.sdk.openadsdk.core.KZx;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.omh.Bzk;
import com.bytedance.sdk.openadsdk.core.omh.XT;
import com.bytedance.sdk.openadsdk.core.omh.omh;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.CIG;
import com.bytedance.sdk.openadsdk.utils.Mc;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.WQf;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class ZZv extends PAGBannerAd {
    private boolean BSW;
    private com.bytedance.sdk.openadsdk.XT.pA.pA.JG Bzk;
    protected yFO KZx;
    TTDislikeDialogAbstract ML;
    protected final Context Og;
    private final boolean SD;
    private com.bytedance.sdk.openadsdk.core.omh.yFO Sn;
    private boolean WV;
    protected AdSlot ZZv;
    private boolean oX;
    private PAGBannerAdWrapperListener omh;
    protected KZx pA;
    private final Queue<Long> SGo = new LinkedList();
    private String Wx = "banner_ad";
    private final AtomicBoolean DX = new AtomicBoolean(false);
    protected final View.OnAttachStateChangeListener JG = new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.KZx.ZZv.1
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (ZZv.this.oX) {
                return;
            }
            ZZv zZv = ZZv.this;
            zZv.pA(zZv.pA.getCurView(), ZZv.this.KZx);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ZZv.this.pA.KZx();
        }
    };

    public interface pA {
        void pA();
    }

    public ZZv(Context context, yFO yfo, AdSlot adSlot) {
        this.Og = context;
        this.KZx = yfo;
        this.ZZv = adSlot;
        pA(context, yfo, adSlot);
        this.SD = false;
        this.oX = false;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d) {
        if (this.BSW) {
            return;
        }
        Mc.pA(this.KZx, d);
        this.BSW = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d, String str, String str2) {
        if (this.WV) {
            return;
        }
        Mc.pA(this.KZx, d, str, str2);
        this.WV = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        yFO yfo = this.KZx;
        if (yfo != null) {
            return yfo.tZW();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Object getExtraInfo(String str) {
        yFO yfo = this.KZx;
        if (yfo == null || yfo.tZW() == null) {
            return null;
        }
        try {
            return this.KZx.tZW().get(str);
        } catch (Throwable th) {
            WV.pA("PAGBannerAdImpl", th.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public void setAdInteractionCallback(PAGBannerAdInteractionCallback pAGBannerAdInteractionCallback) {
        ML ml = new ML(pAGBannerAdInteractionCallback);
        this.omh = ml;
        this.pA.setExpressInteractionListener(ml);
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public void setAdInteractionListener(PAGBannerAdInteractionListener pAGBannerAdInteractionListener) {
        ML ml = new ML(pAGBannerAdInteractionListener);
        this.omh = ml;
        this.pA.setExpressInteractionListener(ml);
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public View getBannerView() {
        com.bytedance.sdk.openadsdk.utils.Og.pA(this.KZx);
        IPMiBroadcastReceiver.pA(this.Og, this.KZx);
        return this.pA;
    }

    @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd
    public void destroy() {
        KZx kZx = this.pA;
        if (kZx != null) {
            try {
                kZx.KZx();
                this.pA.removeOnAttachStateChangeListener(this.JG);
            } catch (Throwable unused) {
            }
        }
    }

    public void pA(Context context, yFO yfo, AdSlot adSlot) {
        KZx kZx = new KZx(context, yfo, adSlot);
        this.pA = kZx;
        kZx.addOnAttachStateChangeListener(this.JG);
    }

    protected void pA(final com.bytedance.sdk.openadsdk.core.omh.yFO yfo, final yFO yfo2) {
        final com.bytedance.sdk.openadsdk.core.SD sd;
        if (yfo == null || yfo2 == null) {
            return;
        }
        this.KZx = yfo2;
        this.Bzk = pA(yfo2);
        this.Sn = yfo;
        final String strPA = WQf.pA();
        final pA pAVarPA = pA();
        yfo.setClosedListenerKey(strPA);
        yfo.setBannerClickClosedListener(pAVarPA);
        yfo.setBackupListener(new com.bytedance.sdk.component.adexpress.Og.KZx() { // from class: com.bytedance.sdk.openadsdk.core.KZx.ZZv.2
            @Override // com.bytedance.sdk.component.adexpress.Og.KZx
            public boolean pA(ViewGroup viewGroup, int i) {
                try {
                    yfo.WV();
                    if (ZZv.this.KZx.rjD()) {
                        SD sd2 = new SD(yfo.getContext());
                        sd2.setClosedListenerKey(strPA);
                        sd2.pA(ZZv.this.KZx, yfo, ZZv.this.Bzk);
                        sd2.setDislikeOuter(ZZv.this.ML);
                        sd2.setAdInteractionListener(ZZv.this.omh);
                        yfo.setVastVideoHelper(sd2);
                        return true;
                    }
                    com.bytedance.sdk.openadsdk.core.KZx.pA pAVar = new com.bytedance.sdk.openadsdk.core.KZx.pA(yfo.getContext());
                    pAVar.setClosedListenerKey(strPA);
                    pAVar.pA(ZZv.this.KZx, yfo, ZZv.this.Bzk);
                    pAVar.setDislikeOuter(ZZv.this.ML);
                    pAVar.setAdInteractionListener(ZZv.this.omh);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        if (!this.SD) {
            com.bytedance.sdk.openadsdk.core.SD sdPA = pA(yfo);
            if (sdPA == null) {
                sdPA = new com.bytedance.sdk.openadsdk.core.SD(this.Og, yfo);
                yfo.addView(sdPA);
            }
            sd = sdPA;
            sd.setCallback(new com.bytedance.sdk.openadsdk.core.SD.pA() { // from class: com.bytedance.sdk.openadsdk.core.KZx.ZZv.3
                @Override // com.bytedance.sdk.openadsdk.core.SD.pA
                public void pA(boolean z) {
                    ZZv.this.pA(z, yfo2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.SD.pA
                public void pA() {
                    ZZv.this.KZx();
                }

                @Override // com.bytedance.sdk.openadsdk.core.SD.pA
                public void Og() {
                    ZZv.this.pA(sd, false, yfo2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.SD.pA
                public void pA(View view) {
                    if (ZZv.this.DX.compareAndSet(false, true)) {
                        ZZv.this.pA(view, yfo, yfo2, strPA, pAVarPA);
                    }
                }
            });
        } else {
            CIG.pA(yfo, true, 1, new CIG.Og() { // from class: com.bytedance.sdk.openadsdk.core.KZx.ZZv.4
                @Override // com.bytedance.sdk.openadsdk.utils.CIG.Og
                public void pA(boolean z) {
                    ZZv.this.pA(z, yfo2);
                }

                @Override // com.bytedance.sdk.openadsdk.utils.CIG.Og
                public void pA() {
                    ZZv.this.KZx();
                }

                @Override // com.bytedance.sdk.openadsdk.utils.CIG.Og
                public void Og() {
                    ZZv.this.pA((com.bytedance.sdk.openadsdk.core.SD) null, true, yfo2);
                }

                @Override // com.bytedance.sdk.openadsdk.utils.CIG.Og
                public void pA(View view, boolean z) {
                    if (!z) {
                        com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(ZZv.this.KZx, 8);
                        return;
                    }
                    com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(ZZv.this.KZx, 4);
                    if (ZZv.this.DX.compareAndSet(false, true)) {
                        ZZv.this.pA(view, yfo, yfo2, strPA, pAVarPA);
                    }
                }
            }, null);
            sd = null;
        }
        Context contextPA = yfo != null ? com.bytedance.sdk.component.utils.Og.pA(yfo) : null;
        if (contextPA == null) {
            contextPA = this.Og;
        }
        Bzk bzk = new Bzk(contextPA, yfo2, this.Wx, 2);
        bzk.pA(yfo);
        bzk.pA(this);
        bzk.pA(this.Bzk);
        bzk.pA(new com.bytedance.sdk.openadsdk.core.Og.Og.pA() { // from class: com.bytedance.sdk.openadsdk.core.KZx.ZZv.5
            @Override // com.bytedance.sdk.openadsdk.core.Og.Og.pA
            public void pA(View view, int i) {
                if (ZZv.this.omh != null) {
                    ZZv.this.omh.onAdClicked();
                }
            }
        });
        yfo.setClickListener(bzk);
        omh omhVar = new omh(this.Og, yfo2, this.Wx, 2);
        omhVar.pA((View) yfo);
        omhVar.pA(this);
        omhVar.pA(new com.bytedance.sdk.openadsdk.core.Og.Og.pA() { // from class: com.bytedance.sdk.openadsdk.core.KZx.ZZv.6
            @Override // com.bytedance.sdk.openadsdk.core.Og.Og.pA
            public void pA(View view, int i) {
                if (ZZv.this.omh != null) {
                    ZZv.this.omh.onAdClicked();
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.omh.yFO yfo3 = this.Sn;
        if (yfo3 instanceof XT) {
            omhVar.pA(((XT) yfo3).getVideoController());
        }
        omhVar.pA(this.Bzk);
        yfo.setClickCreativeListener(omhVar);
        if (this.SD) {
            return;
        }
        sd.setNeedCheckingShow(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(boolean z, yFO yfo) {
        if (!z) {
            new Object[]{"banner_ad", "Lose focus, stop timing"};
        } else {
            if (this.KZx.Dc() && !this.KZx.eUc()) {
                this.KZx.SD(true);
                yFO yfo2 = this.KZx;
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo2, this.Wx, yfo2.ZF());
            }
            new Object[]{"banner_ad", "Get focus, start timing"};
        }
        xy.Og(new Og(z, yfo, this), 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZx() {
        Og();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(com.bytedance.sdk.openadsdk.core.SD sd, boolean z, yFO yfo) {
        Og(yfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(View view, com.bytedance.sdk.openadsdk.core.omh.yFO yfo, yFO yfo2, String str, pA pAVar) {
        com.bytedance.sdk.openadsdk.core.Bzk.Og().pA(str, pAVar);
        new Object[]{"banner_ad", "ExpressView SHOW"};
        Queue<Long> queue = this.SGo;
        if (queue != null) {
            queue.offer(Long.valueOf(System.currentTimeMillis()));
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (yfo != null) {
                jSONObject.put("dynamic_show_type", yfo.getDynamicShowType());
                yfo.pA(jSONObject, yfo2);
            }
            if (view != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("width", view.getWidth());
                    jSONObject2.put("height", view.getHeight());
                    jSONObject2.put("alpha", view.getAlpha());
                } catch (Throwable unused) {
                }
                jSONObject.put("root_view", jSONObject2.toString());
            }
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo2, this.Wx, jSONObject);
            com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(yfo2);
        } catch (JSONException unused2) {
            WV.pA("PAGBannerAdImpl", "onShowFun json error");
        }
        PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.omh;
        if (pAGBannerAdWrapperListener != null) {
            pAGBannerAdWrapperListener.onAdShow(view, yfo2.JBA());
        }
        if (yfo2.sk()) {
            gbA.pA(yfo2, view);
        }
        KZx kZx = this.pA;
        if (kZx == null || kZx.getCurView() == null) {
            return;
        }
        this.pA.getCurView().SGo();
        this.pA.getCurView().omh();
    }

    private com.bytedance.sdk.openadsdk.XT.pA.pA.JG pA(yFO yfo) {
        if (yfo.JBA() == 4) {
            return com.bytedance.sdk.openadsdk.XT.pA.pA.SD.pA(this.Og, yfo, this.Wx);
        }
        return null;
    }

    private static class Og extends com.bytedance.sdk.component.omh.omh {
        WeakReference<ZZv> KZx;
        yFO Og;
        boolean pA;

        Og(boolean z, yFO yfo, ZZv zZv) {
            super("ReportWindowFocusChangedAdShow");
            this.pA = z;
            this.Og = yfo;
            this.KZx = new WeakReference<>(zZv);
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<ZZv> weakReference = this.KZx;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.KZx.get().Og(this.pA, this.Og);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(boolean z, yFO yfo) {
        Long lPoll;
        try {
            if (z) {
                this.SGo.offer(Long.valueOf(System.currentTimeMillis()));
            } else {
                if (this.SGo.size() <= 0 || this.Sn == null || (lPoll = this.SGo.poll()) == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(String.valueOf(System.currentTimeMillis() - lPoll.longValue()), yfo, this.Wx, this.Sn.getAdShowTime());
            }
        } catch (Exception e) {
            WV.pA("PAGBannerAdImpl", e.getMessage());
        }
    }

    private com.bytedance.sdk.openadsdk.core.SD pA(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            try {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof com.bytedance.sdk.openadsdk.core.SD) {
                    return (com.bytedance.sdk.openadsdk.core.SD) childAt;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private void Og(yFO yfo) {
        Queue<Long> queue = this.SGo;
        if (queue == null || queue.size() <= 0 || yfo == null) {
            return;
        }
        try {
            long jLongValue = this.SGo.poll().longValue();
            if (jLongValue <= 0 || this.Sn == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(String.valueOf(System.currentTimeMillis() - jLongValue), yfo, this.Wx, this.Sn.getAdShowTime());
        } catch (Exception e) {
            WV.pA("PAGBannerAdImpl", e.getMessage());
        }
    }

    public pA pA() {
        return new pA() { // from class: com.bytedance.sdk.openadsdk.core.KZx.ZZv.7
            @Override // com.bytedance.sdk.openadsdk.core.KZx.ZZv.pA
            public void pA() {
                int width = ZZv.this.Sn.getWidth();
                int height = ZZv.this.Sn.getHeight();
                View viewPA = pA(((double) height) >= Math.floor((((double) width) * 450.0d) / 600.0d));
                ZZv.this.Sn.Sn();
                ZZv.this.Sn.removeAllViews();
                ZZv.this.Sn.addView(viewPA, new ViewGroup.LayoutParams(width, height));
                ZZv.this.Sn.setClickCreativeListener(null);
                ZZv.this.Sn.setClickListener(null);
                if (ZZv.this.omh != null) {
                    ZZv.this.omh.onAdDismissed();
                }
                ZZv.this.oX = true;
            }

            private View pA(boolean z) {
                com.bytedance.sdk.openadsdk.core.ML.KZx kZx = new com.bytedance.sdk.openadsdk.core.ML.KZx(ZZv.this.Og);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                kZx.setBackgroundColor(-1);
                kZx.setLayoutParams(layoutParams);
                View view = new View(ZZv.this.Og);
                ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                view.setAlpha(0.3f);
                view.setBackgroundColor(Color.parseColor("#F3F7F8"));
                kZx.addView(view, layoutParams2);
                com.bytedance.sdk.openadsdk.core.ML.KZx kZx2 = new com.bytedance.sdk.openadsdk.core.ML.KZx(ZZv.this.Og);
                ViewGroup.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
                if (z) {
                    kZx2.setBackground(com.bytedance.sdk.component.utils.yFO.KZx(ZZv.this.Og, "tt_ad_closed_background_300_250"));
                } else {
                    kZx2.setBackground(com.bytedance.sdk.component.utils.yFO.KZx(ZZv.this.Og, "tt_ad_closed_background_320_50"));
                }
                kZx.addView(kZx2, layoutParams3);
                com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(ZZv.this.Og);
                zZv.setId(520093739);
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
                if (z) {
                    int iKZx = Vgu.KZx(ZZv.this.Og, 16.0f);
                    layoutParams4.width = Vgu.KZx(ZZv.this.Og, 77.0f);
                    layoutParams4.height = Vgu.KZx(ZZv.this.Og, 14.0f);
                    layoutParams4.leftMargin = iKZx;
                    layoutParams4.topMargin = iKZx;
                } else {
                    int iKZx2 = Vgu.KZx(ZZv.this.Og, 8.0f);
                    layoutParams4.width = Vgu.KZx(ZZv.this.Og, 45.0f);
                    layoutParams4.height = Vgu.KZx(ZZv.this.Og, 8.18f);
                    layoutParams4.leftMargin = iKZx2;
                    layoutParams4.topMargin = iKZx2;
                }
                zZv.setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(ZZv.this.Og, "tt_ad_closed_logo_red"));
                kZx2.addView(zZv, layoutParams4);
                com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(ZZv.this.Og);
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams5.gravity = 17;
                omhVar.setAlpha(0.5f);
                omhVar.setLines(1);
                omhVar.setText(com.bytedance.sdk.component.utils.yFO.pA(ZZv.this.Og, "tt_ad_is_closed"));
                if (z) {
                    omhVar.setTextSize(18.0f);
                } else {
                    omhVar.setTextSize(12.0f);
                }
                kZx2.addView(omhVar, layoutParams5);
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.KZx.ZZv.7.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/KZx/ZZv$7$1;->onClick(Landroid/view/View;)V");
                        CreativeInfoManager.onViewClicked(h.u, view2);
                        safedk_ZZv$7$1_onClick_5f865b50728c4a887091e0f47acbc8f2(view2);
                    }

                    public void safedk_ZZv$7$1_onClick_5f865b50728c4a887091e0f47acbc8f2(View p0) {
                        TTWebsiteActivity.pA(ZZv.this.Og, ZZv.this.KZx, ZZv.this.Wx);
                    }
                };
                zZv.setOnClickListener(onClickListener);
                omhVar.setOnClickListener(onClickListener);
                return kZx;
            }
        };
    }

    public void Og() {
        this.KZx.pA(SystemClock.elapsedRealtime());
        this.pA.Og();
    }
}
