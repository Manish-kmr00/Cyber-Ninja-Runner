package com.bytedance.sdk.openadsdk.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.ZZv.BSW;
import com.bytedance.sdk.openadsdk.core.IG;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.TV;
import com.bytedance.sdk.openadsdk.core.model.oX;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.widget.SD;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes4.dex */
public class TTCeilingLandingPageActivity extends TTBaseActivity {
    private com.bytedance.sdk.component.Bzk.ZZv BSW;
    private BSW Bzk;
    private int JG;
    private IG KZx;
    private String ML;
    private yFO Og;
    private com.bytedance.sdk.openadsdk.common.ZZv SGo;
    private String ZZv;
    private String omh;
    pA pA;

    public interface pA {
        void pA();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.u, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!Sn.ML()) {
            finish();
            return;
        }
        Intent intent = getIntent();
        this.omh = intent.getStringExtra("second_url");
        this.JG = intent.getIntExtra("source", -1);
        this.Og = TV.pA().Og();
        TV.pA().JG();
        yFO yfo = this.Og;
        if (yfo == null) {
            finish();
            return;
        }
        this.ZZv = yfo.nCO();
        this.ML = this.Og.tM();
        this.JG = this.Og.rB().getDurationSlotType() != 7 ? 5 : 7;
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx = new com.bytedance.sdk.openadsdk.core.ML.KZx(this);
        pA(this, kZx);
        setContentView(kZx);
        pA();
    }

    private void pA(Context context, FrameLayout frameLayout) {
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv;
        this.BSW = new com.bytedance.sdk.component.Bzk.ZZv(context);
        frameLayout.addView(this.BSW, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZvOg = SD.Og(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388661;
        layoutParams.topMargin = Vgu.KZx(context, 18.0f);
        layoutParams.rightMargin = Vgu.KZx(context, 18.0f);
        frameLayout.addView(zZvOg, layoutParams);
        final int iZZv = this.Og.SGo().ZZv();
        if (iZZv != 3) {
            zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(Vgu.KZx(context, 28.0f), Vgu.KZx(context, 28.0f));
            layoutParams2.gravity = 8388659;
            layoutParams2.topMargin = Vgu.KZx(context, 18.0f);
            layoutParams2.leftMargin = Vgu.KZx(context, 18.0f);
            int iKZx = Vgu.KZx(context, 5.0f);
            zZv.setPadding(iKZx, iKZx, iKZx, iKZx);
            zZv.setScaleType(ImageView.ScaleType.FIT_XY);
            zZv.setBackground(com.bytedance.sdk.openadsdk.core.widget.ZZv.pA());
            zZv.setImageDrawable(com.bytedance.sdk.component.utils.yFO.KZx(context, "tt_white_lefterbackicon_titlebar"));
            frameLayout.addView(zZv, layoutParams2);
        } else {
            zZv = null;
        }
        com.bytedance.sdk.openadsdk.utils.yFO.pA(this.BSW, this.omh);
        final WebView webView = this.BSW.getWebView();
        zZvOg.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTCeilingLandingPageActivity$1;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_TTCeilingLandingPageActivity$1_onClick_6bdc0644827fbe565c5d910605de88d3(view);
            }

            public void safedk_TTCeilingLandingPageActivity$1_onClick_6bdc0644827fbe565c5d910605de88d3(View p0) {
                TTCeilingLandingPageActivity.this.finish();
            }
        });
        BSW bsw = new BSW(this.Og, webView, true);
        this.Bzk = bsw;
        bsw.pA("landingpage_split_ceiling");
        final com.bytedance.sdk.openadsdk.core.widget.pA.JG.pA pAVar = this.Bzk.pA;
        if (zZv != null) {
            zZv.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTCeilingLandingPageActivity$2;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_TTCeilingLandingPageActivity$2_onClick_1a8fa94fcfa3a4d4a8ddb1293e2ccf48(view);
                }

                public void safedk_TTCeilingLandingPageActivity$2_onClick_1a8fa94fcfa3a4d4a8ddb1293e2ccf48(View p0) {
                    int i = iZZv;
                    if (i == 1) {
                        TTCeilingLandingPageActivity.this.finish();
                    } else if (i != 2) {
                        return;
                    }
                    WebView webView2 = webView;
                    if (webView2 != null && webView2.canGoBack()) {
                        webView.goBack();
                        com.bytedance.sdk.openadsdk.core.widget.pA.JG.pA pAVar2 = pAVar;
                        if (pAVar2 != null) {
                            pAVar2.pA();
                            return;
                        }
                        return;
                    }
                    TTCeilingLandingPageActivity.this.finish();
                }
            });
        }
        com.bytedance.sdk.openadsdk.common.ZZv zZvPA = gbA.pA(this.Og, this.BSW, this, "landingpage_split_ceiling");
        this.SGo = zZvPA;
        if (zZvPA != null) {
            zZvPA.pA("landingpage_split_ceiling");
            this.SGo.pA();
        }
        gbA.pA(this.Og, this.BSW, true);
        this.pA = new pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.3
            @Override // com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.pA
            public void pA() {
                if (TTCeilingLandingPageActivity.this.Og.SGo().ML() == oX.Og) {
                    TTCeilingLandingPageActivity.this.finish();
                }
            }
        };
        com.bytedance.sdk.openadsdk.core.widget.pA.ML ml = new com.bytedance.sdk.openadsdk.core.widget.pA.ML(this, this.KZx, this.ZZv, this.SGo, this.Bzk, true, true, this.pA) { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                CreativeInfoManager.onResourceLoaded(h.u, view, url);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTCeilingLandingPageActivity$4;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
                BrandSafetyUtils.onWebViewPageFinished(h.u, webView2, str);
                safedk_TTCeilingLandingPageActivity$4_onPageFinished_ffa419bda84785b83fafff6cae8a4795(webView2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                BrandSafetyUtils.onWebViewPageStarted(h.u, view, url);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                BrandSafetyUtils.onWebViewReceivedError(h.u, view, errorCode, description, failingUrl);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
                return CreativeInfoManager.onWebViewResponseWithHeaders(h.u, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                boolean zShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(view, url);
                BrandSafetyUtils.onShouldOverrideUrlLoading(h.u, view, url, zShouldOverrideUrlLoading);
                return zShouldOverrideUrlLoading;
            }

            public void safedk_TTCeilingLandingPageActivity$4_onPageFinished_ffa419bda84785b83fafff6cae8a4795(WebView p0, String p1) {
                super.onPageFinished(p0, p1);
            }
        };
        ml.pA(this.Og);
        com.bytedance.sdk.openadsdk.core.widget.pA.ZZv zZv2 = new com.bytedance.sdk.openadsdk.core.widget.pA.ZZv(this.KZx, this.Bzk, this.SGo) { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ZZv, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i) {
                super.onProgressChanged(webView2, i);
            }
        };
        com.bytedance.sdk.component.Bzk.ZZv zZv3 = this.BSW;
        if (zZv3 != null) {
            zZv3.setWebViewClient(ml);
            this.BSW.setWebChromeClient(zZv2);
        }
        if (webView != null) {
            webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTCeilingLandingPageActivity$6;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                    CreativeInfoManager.onViewTouched(h.u, view, motionEvent);
                    return safedk_TTCeilingLandingPageActivity$6_onTouch_cf571c44cfb2e3ba3a2bb1ec5b82702b(view, motionEvent);
                }

                public boolean safedk_TTCeilingLandingPageActivity$6_onTouch_cf571c44cfb2e3ba3a2bb1ec5b82702b(View p0, MotionEvent p1) {
                    if (TTCeilingLandingPageActivity.this.Bzk == null) {
                        return false;
                    }
                    TTCeilingLandingPageActivity.this.Bzk.pA(p1);
                    return false;
                }
            });
            webView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.7
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    if (TTCeilingLandingPageActivity.this.Bzk != null) {
                        TTCeilingLandingPageActivity.this.Bzk.Og(i2);
                    }
                }
            });
        }
    }

    private void pA() {
        IG ig = new IG(this);
        this.KZx = ig;
        ig.Og(this.BSW).KZx(this.ZZv).ZZv(this.ML).pA(this.Og).Og(this.JG).pA(this.Og.Vgu()).ML(this.Og.jK()).pA(this.BSW).Og("landingpage_split_ceiling");
    }
}
