package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.eG;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes2.dex */
public class WV extends com.bytedance.sdk.openadsdk.core.ML.KZx {
    private Runnable JG;
    private int KZx;
    private Runnable ML;
    protected boolean Og;
    private com.bytedance.sdk.openadsdk.core.ML.ZZv SD;
    private long ZZv;
    private int omh;
    protected BSW pA;

    @Override // com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.KZx, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public WV(Context context) {
        super(context);
        this.ZZv = 10L;
        this.Og = true;
        this.omh = 1;
        KZx();
    }

    private void KZx() {
        setBackgroundColor(Color.parseColor("#2E2E2E"));
        setVisibility(8);
    }

    public void pA(final yFO yfo) {
        com.bytedance.sdk.openadsdk.core.model.XT xtBzk;
        if (yfo != null && (xtBzk = yfo.Bzk()) != null) {
            this.ZZv = xtBzk.pA();
        }
        BSW bsw = new BSW(getContext());
        this.pA = bsw;
        View viewPA = bsw.pA();
        if (viewPA.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewPA.getParent()).removeView(viewPA);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        viewPA.setLayoutParams(layoutParams);
        if (yfo != null) {
            boolean zFN = yfo.fN();
            com.bytedance.sdk.openadsdk.core.widget.aBv abvOg = this.pA.Og();
            if (abvOg != null) {
                if (zFN) {
                    abvOg.setVisibility(8);
                } else {
                    com.bytedance.sdk.openadsdk.core.model.DX dxFJy = (yfo.fJy() == null || TextUtils.isEmpty(yfo.fJy().pA())) ? null : yfo.fJy();
                    if (dxFJy != null && !TextUtils.isEmpty(dxFJy.pA())) {
                        try {
                            com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(dxFJy).pA(new com.bytedance.sdk.openadsdk.Bzk.Og(yfo, dxFJy.pA(), new eG(abvOg)));
                        } catch (Throwable unused) {
                            abvOg.setVisibility(8);
                        }
                    } else {
                        abvOg.setVisibility(8);
                    }
                }
            }
            com.bytedance.sdk.openadsdk.core.ML.omh omhVarKZx = this.pA.KZx();
            if (omhVarKZx != null) {
                if (zFN) {
                    omhVarKZx.setText("Loading");
                } else if (!TextUtils.isEmpty(yfo.SXO())) {
                    omhVarKZx.setText(yfo.SXO());
                } else {
                    omhVarKZx.setVisibility(8);
                }
            }
        }
        addView(viewPA);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(getContext());
        this.SD = zZv;
        zZv.setImageDrawable(com.bytedance.sdk.component.utils.yFO.KZx(getContext(), "tt_ad_logo_big"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(Vgu.KZx(getContext(), 64.0f), Vgu.KZx(getContext(), 24.0f));
        layoutParams2.bottomMargin = Vgu.KZx(getContext(), 60.0f);
        layoutParams2.gravity = 81;
        this.SD.setLayoutParams(layoutParams2);
        addView(this.SD);
        this.SD.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.WV.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/common/WV$1;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_WV$1_onClick_f26d4615415a88e3846edc116b24ac29(view);
            }

            public void safedk_WV$1_onClick_f26d4615415a88e3846edc116b24ac29(View p0) {
                Context context = WV.this.getContext();
                yFO yfo2 = yfo;
                TTWebsiteActivity.pA(context, yfo2, gbA.pA(yfo2));
            }
        });
        KZx(getResources().getConfiguration().orientation);
    }

    public BSW getLoadingStyle() {
        return this.pA;
    }

    public void pA() {
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.WV.2
            @Override // java.lang.Runnable
            public void run() {
                if (WV.this.pA != null) {
                    WV.this.setVisibility(0);
                }
            }
        });
        if (this.ML == null) {
            this.ML = new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.WV.3
                @Override // java.lang.Runnable
                public void run() {
                    WV.this.Og();
                }
            };
        }
        postDelayed(this.ML, this.ZZv * 1000);
    }

    public void pA(int i) {
        if (i == 100 || Math.abs(i - this.KZx) >= 7) {
            this.KZx = i;
            if (com.bykv.vk.openvk.pA.pA.Og.KZx.pA.Og()) {
                Og(this.KZx);
                return;
            }
            if (this.JG == null) {
                this.JG = new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.WV.4
                    @Override // java.lang.Runnable
                    public void run() {
                        WV wv = WV.this;
                        wv.Og(wv.KZx);
                    }
                };
            }
            post(this.JG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(int i) {
        BSW bsw = this.pA;
        if (bsw != null) {
            bsw.pA(i);
        }
        if (i == 100 && this.Og) {
            Og();
        }
    }

    public void Og() {
        this.KZx = 0;
        BSW bsw = this.pA;
        if (bsw != null) {
            removeView(bsw.pA);
            this.pA.ZZv();
        }
        setVisibility(8);
        this.pA = null;
        Runnable runnable = this.ML;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = this.JG;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
        }
        this.JG = null;
        this.ML = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.ML;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.ML = null;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        KZx(configuration.orientation);
    }

    private void KZx(int i) {
        if (this.omh != i) {
            this.omh = i;
            com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = this.SD;
            if (zZv != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) zZv.getLayoutParams();
                if (this.omh == 1) {
                    marginLayoutParams.width = Vgu.KZx(getContext(), 64.0f);
                    marginLayoutParams.height = Vgu.KZx(getContext(), 24.0f);
                    marginLayoutParams.bottomMargin = Vgu.KZx(getContext(), 60.0f);
                } else {
                    marginLayoutParams.width = Vgu.KZx(getContext(), 41.0f);
                    marginLayoutParams.height = Vgu.KZx(getContext(), 15.0f);
                    marginLayoutParams.bottomMargin = Vgu.KZx(getContext(), 24.0f);
                }
                this.SD.setLayoutParams(marginLayoutParams);
            }
        }
    }
}
