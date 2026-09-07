package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.yFO;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.common.DX;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.common.WV;
import com.bytedance.sdk.openadsdk.common.oX;
import com.bytedance.sdk.openadsdk.core.ML.SD;
import com.bytedance.sdk.openadsdk.core.ML.omh;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.Bzk;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTVideoLandingPageLink2Activity extends TTVideoLandingPageActivity implements com.bytedance.sdk.openadsdk.SGo.ZZv {
    private View IIF;
    private com.bytedance.sdk.openadsdk.core.widget.pA.ML Itl;
    private TextView PV;
    private PAGLogoView Wo;
    private WV YkC;
    DX agB;
    private com.bytedance.sdk.openadsdk.common.ZZv bU;
    private TextView cFQ;
    private View dC;
    TTAdDislikeToast fN;
    private boolean fw;
    private oX gy;
    private long lx;
    private LinearLayout nCO;
    private boolean vA;
    private boolean SXO = false;
    final AtomicBoolean dmv = new AtomicBoolean(false);
    final AtomicBoolean fJy = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.u, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!Sn.ML() || this.oX == null || this.pA == null) {
            finish();
            return;
        }
        com.bytedance.sdk.openadsdk.common.ZZv zZvPA = gbA.pA(this.oX, this.pA, this.ML, this.lT);
        this.bU = zZvPA;
        if (zZvPA != null) {
            zZvPA.pA("landingpage_split_screen");
        }
        this.fw = aBv.ZZv().TX();
        if (this.pA.getWebView() != null) {
            this.pA.getWebView().setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.1
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    if (TTVideoLandingPageLink2Activity.this.SzT != null) {
                        TTVideoLandingPageLink2Activity.this.SzT.Og(i2);
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.widget.pA.ML ml = new com.bytedance.sdk.openadsdk.core.widget.pA.ML(this.ML, this.SGo, this.omh, this.bU, this.SzT, true) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.7
            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                CreativeInfoManager.onResourceLoaded(h.u, view, url);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTVideoLandingPageLink2Activity$7;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
                BrandSafetyUtils.onWebViewPageFinished(h.u, webView, str);
                safedk_TTVideoLandingPageLink2Activity$7_onPageFinished_29d2550c931810cdffd6cc4615910995(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTVideoLandingPageLink2Activity$7;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
                BrandSafetyUtils.onWebViewPageStarted(h.u, webView, str);
                safedk_TTVideoLandingPageLink2Activity$7_onPageStarted_140514f9f2d1e7ada0c927690edcd0ba(webView, str, bitmap);
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

            public void safedk_TTVideoLandingPageLink2Activity$7_onPageFinished_29d2550c931810cdffd6cc4615910995(WebView p0, String p1) {
                super.onPageFinished(p0, p1);
                try {
                    if (TTVideoLandingPageLink2Activity.this.dC != null && !TTVideoLandingPageLink2Activity.this.vA) {
                        TTVideoLandingPageLink2Activity.this.dC.setVisibility(8);
                    }
                    if (TTVideoLandingPageLink2Activity.this.nCO != null) {
                        TTVideoLandingPageLink2Activity.this.nCO.setVisibility(0);
                    }
                    TTVideoLandingPageLink2Activity.this.SXO = true;
                    TTVideoLandingPageLink2Activity.this.Sn();
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA(TTVideoLandingPageLink2Activity.this.oX, TTVideoLandingPageLink2Activity.this.lT, System.currentTimeMillis() - TTVideoLandingPageLink2Activity.this.lx, true);
                } catch (Throwable unused) {
                }
            }

            public void safedk_TTVideoLandingPageLink2Activity$7_onPageStarted_140514f9f2d1e7ada0c927690edcd0ba(WebView p0, String p1, Bitmap p2) {
                super.onPageStarted(p0, p1, p2);
                TTVideoLandingPageLink2Activity.this.lx = System.currentTimeMillis();
            }
        };
        this.Itl = ml;
        ml.pA(this.oX);
        this.pA.setWebViewClient(this.Itl);
        this.pA.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.pA.ZZv(this.SGo, this.SzT, this.bU) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.8
            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ZZv, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTVideoLandingPageLink2Activity.this.fw && TTVideoLandingPageLink2Activity.this.gy != null && i == 100) {
                    TTVideoLandingPageLink2Activity.this.gy.pA(webView, TTVideoLandingPageLink2Activity.this.HSv);
                }
                if (TTVideoLandingPageLink2Activity.this.YkC != null) {
                    TTVideoLandingPageLink2Activity.this.YkC.pA(i);
                }
            }
        });
        TextView textView = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.eUc);
        if (textView != null && this.oX.Bzk() != null) {
            textView.setText(this.oX.Bzk().ML());
        }
        Sn.KZx().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTVideoLandingPageLink2Activity.this.vA = true;
                    if (TTVideoLandingPageLink2Activity.this.YkC != null) {
                        TTVideoLandingPageLink2Activity.this.YkC.Og();
                    }
                    TTVideoLandingPageLink2Activity.this.IIF.setVisibility(0);
                    if (TTVideoLandingPageLink2Activity.this.Wo != null) {
                        TTVideoLandingPageLink2Activity.this.Wo.setVisibility(0);
                    }
                    if (TTVideoLandingPageLink2Activity.this.SXO) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA(TTVideoLandingPageLink2Activity.this.oX, TTVideoLandingPageLink2Activity.this.lT, System.currentTimeMillis() - TTVideoLandingPageLink2Activity.this.lx, false);
                } catch (Exception unused) {
                }
            }
        }, (this.oX == null || this.oX.Bzk() == null) ? 10000L : this.oX.Bzk().pA() * 1000);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    protected View pA() {
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(this);
        if (Build.VERSION.SDK_INT >= 35) {
            ml.setFitsSystemWindows(true);
        }
        ml.setOrientation(1);
        ml.setBackgroundColor(-1);
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx = new com.bytedance.sdk.openadsdk.core.ML.KZx(this);
        ml.addView(kZx, new LinearLayout.LayoutParams(-1, Vgu.KZx(this, 220.0f)));
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx2 = new com.bytedance.sdk.openadsdk.core.ML.KZx(this);
        kZx2.setId(com.bytedance.sdk.openadsdk.utils.Sn.Vgu);
        kZx.addView(kZx2, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ML.ML ml2 = new com.bytedance.sdk.openadsdk.core.ML.ML(this);
        ml2.setOrientation(0);
        ml2.setPadding(0, Vgu.KZx(this, 20.0f), 0, 0);
        kZx.addView(ml2, new FrameLayout.LayoutParams(-1, -2));
        View view = new View(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1.0f;
        ml2.addView(view, layoutParams);
        com.bytedance.sdk.openadsdk.core.widget.DX dx = new com.bytedance.sdk.openadsdk.core.widget.DX(this);
        dx.setId(520093713);
        dx.setGravity(17);
        dx.setText(yFO.pA(this, "tt_reward_feedback"));
        dx.setTextColor(-1);
        dx.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, Vgu.KZx(this, 28.0f));
        int iKZx = Vgu.KZx(this, 16.0f);
        layoutParams2.rightMargin = iKZx;
        layoutParams2.leftMargin = iKZx;
        ml2.addView(dx, layoutParams2);
        com.bytedance.sdk.openadsdk.core.widget.Sn sn = new com.bytedance.sdk.openadsdk.core.widget.Sn(this);
        sn.setId(com.bytedance.sdk.openadsdk.utils.Sn.CIG);
        sn.setPadding(Vgu.KZx(this, 7.0f), Vgu.KZx(this, 7.0f), Vgu.KZx(this, 7.0f), Vgu.KZx(this, 7.0f));
        sn.setImageResource(yFO.ZZv(this, "tt_video_close_drawable"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(Vgu.KZx(this, 28.0f), Vgu.KZx(this, 28.0f));
        layoutParams3.rightMargin = Vgu.KZx(this, 12.0f);
        ml2.addView(sn, layoutParams3);
        SD sd = new SD(this);
        sd.setVisibility(8);
        sd.setId(com.bytedance.sdk.openadsdk.utils.Sn.SzT);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = Vgu.KZx(this, 10.0f);
        ml.addView(sd, layoutParams4);
        com.bytedance.sdk.openadsdk.core.widget.pA pAVar = new com.bytedance.sdk.openadsdk.core.widget.pA(this);
        pAVar.setId(com.bytedance.sdk.openadsdk.utils.Sn.FQ);
        pAVar.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        pAVar.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(Vgu.KZx(this, 44.0f), Vgu.KZx(this, 44.0f));
        layoutParams5.addRule(9);
        layoutParams5.leftMargin = Vgu.KZx(this, 5.0f);
        sd.addView(pAVar, layoutParams5);
        omh omhVar = new omh(this);
        omhVar.setId(com.bytedance.sdk.openadsdk.utils.Sn.Gx);
        omhVar.setBackground(Bzk.pA(this, "tt_circle_solid_mian"));
        omhVar.setGravity(17);
        omhVar.setTextColor(-1);
        omhVar.setTextSize(2, 19.0f);
        omhVar.setTypeface(Typeface.DEFAULT_BOLD);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(Vgu.KZx(this, 44.0f), Vgu.KZx(this, 44.0f));
        layoutParams6.addRule(9);
        layoutParams6.leftMargin = Vgu.KZx(this, 5.0f);
        sd.addView(omhVar, layoutParams6);
        omh omhVar2 = new omh(this);
        omhVar2.setId(com.bytedance.sdk.openadsdk.utils.Sn.Bf);
        omhVar2.setMaxLines(1);
        omhVar2.setEllipsize(TextUtils.TruncateAt.END);
        omhVar2.setTextColor(Color.parseColor("#e5000000"));
        omhVar2.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(15);
        layoutParams7.leftMargin = Vgu.KZx(this, 5.0f);
        layoutParams7.rightMargin = Vgu.KZx(this, 80.0f);
        layoutParams7.addRule(1, com.bytedance.sdk.openadsdk.utils.Sn.Gx);
        sd.addView(omhVar2, layoutParams7);
        omh omhVar3 = new omh(this);
        omhVar3.setId(com.bytedance.sdk.openadsdk.utils.Sn.HSv);
        omhVar3.setClickable(true);
        omhVar3.setMaxLines(1);
        omhVar3.setEllipsize(TextUtils.TruncateAt.END);
        omhVar3.setFocusable(true);
        omhVar3.setGravity(17);
        omhVar3.setText(yFO.pA(this, "tt_video_mobile_go_detail"));
        omhVar3.setTextColor(-1);
        omhVar3.setTextSize(2, 14.0f);
        omhVar3.setPadding(Vgu.KZx(this, 2.0f), Vgu.KZx(this, 2.0f), Vgu.KZx(this, 2.0f), Vgu.KZx(this, 2.0f));
        omhVar3.setBackground(Bzk.pA(this, "tt_ad_cover_btn_begin_bg"));
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(Vgu.KZx(this, 90.0f), Vgu.KZx(this, 36.0f));
        layoutParams8.addRule(11);
        layoutParams8.addRule(15);
        layoutParams8.rightMargin = Vgu.KZx(this, 5.0f);
        sd.addView(omhVar3, layoutParams8);
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx3 = new com.bytedance.sdk.openadsdk.core.ML.KZx(this);
        ml.addView(kZx3, new LinearLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.component.Bzk.ZZv zZv = new com.bytedance.sdk.component.Bzk.ZZv(this);
        zZv.setId(com.bytedance.sdk.openadsdk.utils.Sn.JBA);
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams9.topMargin = Vgu.KZx(this, 2.0f);
        kZx3.addView(zZv, layoutParams9);
        SD sd2 = new SD(this);
        sd2.setId(com.bytedance.sdk.openadsdk.utils.Sn.agB);
        sd2.setBackgroundColor(Color.parseColor("#F8F8F8"));
        kZx3.addView(sd2, new FrameLayout.LayoutParams(-1, -1));
        WV wv = new WV(this);
        wv.setId(com.bytedance.sdk.openadsdk.utils.Sn.fN);
        sd2.addView(wv, new RelativeLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ML.ML ml3 = new com.bytedance.sdk.openadsdk.core.ML.ML(this);
        ml3.setId(com.bytedance.sdk.openadsdk.utils.Sn.gbA);
        ml3.setOrientation(1);
        ml3.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams10.addRule(13);
        sd2.addView(ml3, layoutParams10);
        com.bytedance.sdk.openadsdk.core.widget.aBv abv = new com.bytedance.sdk.openadsdk.core.widget.aBv(this);
        abv.setId(com.bytedance.sdk.openadsdk.utils.Sn.dmv);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(Vgu.KZx(this, 80.0f), Vgu.KZx(this, 80.0f));
        layoutParams11.gravity = 17;
        ml3.addView(abv, layoutParams11);
        omh omhVar4 = new omh(this);
        omhVar4.setId(com.bytedance.sdk.openadsdk.utils.Sn.fJy);
        omhVar4.setTextColor(Color.parseColor("#161823"));
        omhVar4.setTextSize(0, Vgu.KZx(this, 24.0f));
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.gravity = 17;
        layoutParams12.topMargin = Vgu.KZx(this, 12.0f);
        ml3.addView(omhVar4, layoutParams12);
        omh omhVar5 = new omh(this);
        omhVar5.setId(com.bytedance.sdk.openadsdk.utils.Sn.YkC);
        omhVar5.setTextColor(Color.parseColor("#80161823"));
        omhVar5.setTextSize(0, Vgu.KZx(this, 16.0f));
        omhVar5.setTextAlignment(4);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams13.gravity = 17;
        int iKZx2 = Vgu.KZx(this, 60.0f);
        layoutParams13.rightMargin = iKZx2;
        layoutParams13.leftMargin = iKZx2;
        layoutParams13.topMargin = Vgu.KZx(this, 8.0f);
        ml3.addView(omhVar5, layoutParams13);
        omh omhVar6 = new omh(this);
        omhVar6.setId(com.bytedance.sdk.openadsdk.utils.Sn.dC);
        omhVar6.setGravity(17);
        omhVar6.setTextColor(-1);
        omhVar6.setText(yFO.pA(this, "tt_video_mobile_go_detail"));
        omhVar6.setBackground(Bzk.pA(this, "tt_reward_video_download_btn_bg"));
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(Vgu.KZx(this, 255.0f), Vgu.KZx(this, 44.0f));
        layoutParams14.gravity = 17;
        layoutParams14.topMargin = Vgu.KZx(this, 32.0f);
        ml3.addView(omhVar6, layoutParams14);
        PAGLogoView pAGLogoView = new PAGLogoView(this);
        this.Wo = pAGLogoView;
        pAGLogoView.setId(com.bytedance.sdk.openadsdk.utils.Sn.IIF);
        this.Wo.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, Vgu.KZx(this, 14.0f));
        layoutParams15.addRule(12);
        layoutParams15.leftMargin = Vgu.KZx(this, 18.0f);
        layoutParams15.bottomMargin = Vgu.KZx(this, 61.0f);
        sd2.addView(this.Wo, layoutParams15);
        com.bytedance.sdk.openadsdk.common.Sn sn2 = new com.bytedance.sdk.openadsdk.common.Sn(this, new com.bytedance.sdk.openadsdk.common.Sn.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.10
            @Override // com.bytedance.sdk.openadsdk.common.Sn.pA
            public View pA(Context context) {
                return new com.bytedance.sdk.openadsdk.common.SD(context);
            }
        });
        sn2.setId(com.bytedance.sdk.openadsdk.utils.Sn.vA);
        FrameLayout.LayoutParams layoutParams16 = new FrameLayout.LayoutParams(-1, Vgu.KZx(this, 48.0f));
        layoutParams16.gravity = 81;
        kZx3.addView(sn2, layoutParams16);
        com.bytedance.sdk.openadsdk.common.Sn sn3 = new com.bytedance.sdk.openadsdk.common.Sn(this, new com.bytedance.sdk.openadsdk.common.Sn.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.11
            @Override // com.bytedance.sdk.openadsdk.common.Sn.pA
            public View pA(Context context) {
                return new com.bytedance.sdk.openadsdk.common.omh(context);
            }
        });
        sn3.setId(com.bytedance.sdk.openadsdk.utils.Sn.PV);
        FrameLayout.LayoutParams layoutParams17 = new FrameLayout.LayoutParams(-1, Vgu.KZx(this, 44.0f));
        layoutParams17.gravity = 80;
        kZx3.addView(sn3, layoutParams17);
        return ml;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    protected void KZx() {
        super.KZx();
        TextView textView = (TextView) findViewById(520093713);
        if (textView != null) {
            textView.setText(yFO.pA(aBv.pA(), "tt_reward_feedback"));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTVideoLandingPageLink2Activity$12;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_TTVideoLandingPageLink2Activity$12_onClick_894a37655b01d0c1a7c730b2114f467f(view);
                }

                public void safedk_TTVideoLandingPageLink2Activity$12_onClick_894a37655b01d0c1a7c730b2114f467f(View p0) {
                    TTVideoLandingPageLink2Activity.this.WV();
                }
            });
        }
        this.PV = (TextView) findViewById(520093714);
        this.YkC = (WV) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.fN);
        this.dC = findViewById(com.bytedance.sdk.openadsdk.utils.Sn.agB);
        this.IIF = findViewById(com.bytedance.sdk.openadsdk.utils.Sn.gbA);
        TextView textView2 = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.fJy);
        TextView textView3 = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.YkC);
        com.bytedance.sdk.openadsdk.core.widget.aBv abv = (com.bytedance.sdk.openadsdk.core.widget.aBv) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.dmv);
        this.cFQ = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.dC);
        if (this.oX.fJy() != null && !TextUtils.isEmpty(this.oX.fJy().pA())) {
            com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.oX.fJy(), abv, this.oX);
        }
        textView2.setText(this.oX.HSv());
        textView3.setText(this.oX.fw());
        findViewById(com.bytedance.sdk.openadsdk.utils.Sn.IIF).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTVideoLandingPageLink2Activity$13;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_TTVideoLandingPageLink2Activity$13_onClick_c48c78cdf038801b4a80a07480afd49e(view);
            }

            public void safedk_TTVideoLandingPageLink2Activity$13_onClick_c48c78cdf038801b4a80a07480afd49e(View p0) {
                TTWebsiteActivity.pA(TTVideoLandingPageLink2Activity.this.ML, TTVideoLandingPageLink2Activity.this.oX, TTVideoLandingPageLink2Activity.this.lT);
            }
        });
        if (this.pA != null && this.pA.getWebView() != null) {
            gbA.pA(this.oX, this.pA);
        }
        boolean zTX = aBv.ZZv().TX();
        this.fw = zTX;
        if (zTX) {
            ((com.bytedance.sdk.openadsdk.common.Sn) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.PV)).setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.tM);
            this.nCO = linearLayout;
            linearLayout.setVisibility(8);
            this.gy = new oX(this, this.nCO, this.pA, this.oX, "landingpage_split_screen");
            if (this.pA.getWebView() != null) {
                this.pA.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.14
                    float pA = 0.0f;

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTVideoLandingPageLink2Activity$14;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                        CreativeInfoManager.onViewTouched(h.u, view, motionEvent);
                        return safedk_TTVideoLandingPageLink2Activity$14_onTouch_a34d5a4f92d5a6c1e5ed04d7ec9967ed(view, motionEvent);
                    }

                    public boolean safedk_TTVideoLandingPageLink2Activity$14_onTouch_a34d5a4f92d5a6c1e5ed04d7ec9967ed(View p0, MotionEvent p1) {
                        if (p1.getAction() == 0) {
                            this.pA = p1.getY();
                        }
                        if (TTVideoLandingPageLink2Activity.this.SzT != null) {
                            TTVideoLandingPageLink2Activity.this.SzT.pA(p1);
                        }
                        if (TTVideoLandingPageLink2Activity.this.bU != null) {
                            TTVideoLandingPageLink2Activity.this.bU.pA(p1);
                        }
                        if (p1.getAction() == 2) {
                            float y = p1.getY();
                            float f = this.pA;
                            if (y - f > 8.0f) {
                                if (TTVideoLandingPageLink2Activity.this.gy != null) {
                                    TTVideoLandingPageLink2Activity.this.gy.pA();
                                }
                                return false;
                            }
                            if (y - f < -8.0f && TTVideoLandingPageLink2Activity.this.gy != null) {
                                TTVideoLandingPageLink2Activity.this.gy.Og();
                            }
                        }
                        return false;
                    }
                });
            }
        } else if (this.pA.getWebView() != null) {
            this.pA.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTVideoLandingPageLink2Activity$2;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                    CreativeInfoManager.onViewTouched(h.u, view, motionEvent);
                    return safedk_TTVideoLandingPageLink2Activity$2_onTouch_e07c7ecb533d7d8a1fd10db6e64ff98c(view, motionEvent);
                }

                public boolean safedk_TTVideoLandingPageLink2Activity$2_onTouch_e07c7ecb533d7d8a1fd10db6e64ff98c(View p0, MotionEvent p1) {
                    if (TTVideoLandingPageLink2Activity.this.SzT != null) {
                        TTVideoLandingPageLink2Activity.this.SzT.pA(p1);
                    }
                    if (TTVideoLandingPageLink2Activity.this.bU == null) {
                        return false;
                    }
                    TTVideoLandingPageLink2Activity.this.bU.pA(p1);
                    return false;
                }
            });
        }
        WV wv = this.YkC;
        if (wv != null) {
            wv.pA(this.oX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wx() {
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.oX, "landingpage_split_screen", "click_video", (JSONObject) null);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        WV wv = this.YkC;
        if (wv != null) {
            wv.pA();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    protected void ZZv() {
        if (ML()) {
            super.ZZv();
            if (this.Sn != null) {
                if (this.Sn.getNativeVideoController() != null) {
                    this.Sn.getNativeVideoController().pA(false);
                    ((com.bytedance.sdk.openadsdk.core.Wx.Og.KZx) this.Sn.getNativeVideoController()).SD(false);
                    this.WV.setClickable(true);
                    this.WV.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.3
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTVideoLandingPageLink2Activity$3;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                            CreativeInfoManager.onViewTouched(h.u, view, motionEvent);
                            return safedk_TTVideoLandingPageLink2Activity$3_onTouch_fbfa42fcd09872eeca58acfca8fa69ec(view, motionEvent);
                        }

                        public boolean safedk_TTVideoLandingPageLink2Activity$3_onTouch_fbfa42fcd09872eeca58acfca8fa69ec(View p0, MotionEvent p1) {
                            if (p1.getAction() != 0) {
                                return false;
                            }
                            TTVideoLandingPageLink2Activity.this.Wx();
                            return false;
                        }
                    });
                }
                this.Sn.getNativeVideoController().pA(new com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.4
                    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
                    public void Og(long j, int i) {
                    }

                    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
                    public void pA() {
                    }

                    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
                    public void pA(long j, int i) {
                    }

                    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
                    public void pA(long j, long j2) {
                        if (TTVideoLandingPageLink2Activity.this.PV != null) {
                            int iMax = (int) Math.max(0L, (j2 - j) / 1000);
                            TTVideoLandingPageLink2Activity.this.PV.setText(String.valueOf(iMax));
                            if (iMax <= 0) {
                                TTVideoLandingPageLink2Activity.this.PV.setVisibility(8);
                            }
                        }
                    }
                });
                return;
            }
            return;
        }
        try {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.oX.IIF().get(0), imageView, this.oX);
            this.WV.setVisibility(0);
            this.WV.removeAllViews();
            this.WV.addView(imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTVideoLandingPageLink2Activity$5;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_TTVideoLandingPageLink2Activity$5_onClick_9fee6148bff7bd1fe5405435fc5d12f6(view);
                }

                public void safedk_TTVideoLandingPageLink2Activity$5_onClick_9fee6148bff7bd1fe5405435fc5d12f6(View p0) {
                    com.bytedance.sdk.openadsdk.ZZv.KZx.Og(TTVideoLandingPageLink2Activity.this.oX, "landingpage_split_screen");
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    protected boolean ML() {
        return this.Wx == 5 || this.Wx == 15 || this.Wx == 50;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    public void Bzk() {
        super.Bzk();
        if (this.oX != null) {
            this.oX.JG(true);
        }
        TextView textView = this.cFQ;
        if (textView != null) {
            textView.setText(Og());
            this.cFQ.setClickable(true);
            this.cFQ.setOnClickListener(this.JBA);
            this.cFQ.setOnTouchListener(this.JBA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sn() {
        WV wv = this.YkC;
        if (wv != null) {
            wv.Og();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity, android.app.Activity
    protected void onDestroy() {
        Sn();
        if (!this.vA && this.SzT != null && this.pA != null && this.YkC.getVisibility() == 8) {
            this.SzT.pA(this.pA);
        }
        super.onDestroy();
    }

    private void DX() {
        TTAdDislikeToast tTAdDislikeToast = this.fN;
        if (tTAdDislikeToast == null) {
            return;
        }
        tTAdDislikeToast.show(TTAdDislikeToast.getDislikeTip());
    }

    protected void WV() {
        if (isFinishing()) {
            return;
        }
        if (this.fJy.get()) {
            DX();
            return;
        }
        if (this.agB == null) {
            oX();
        }
        DX dx = this.agB;
        if (dx != null) {
            dx.pA();
        }
    }

    private void oX() {
        try {
            if (this.agB == null) {
                DX dx = new DX(this.ML, this.oX);
                this.agB = dx;
                dx.setDislikeSource("landing_page");
                this.agB.setCallback(new DX.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.6
                    @Override // com.bytedance.sdk.openadsdk.common.DX.pA
                    public void pA(View view) {
                        TTVideoLandingPageLink2Activity.this.dmv.set(true);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.DX.pA
                    public void Og(View view) {
                        TTVideoLandingPageLink2Activity.this.dmv.set(false);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.DX.pA
                    public void pA(FilterWord filterWord) {
                        if (TTVideoLandingPageLink2Activity.this.fJy.get() || filterWord == null || filterWord.hasSecondOptions()) {
                            return;
                        }
                        TTVideoLandingPageLink2Activity.this.fJy.set(true);
                        TTVideoLandingPageLink2Activity.this.aBv();
                    }
                });
            }
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
            frameLayout.addView(this.agB);
            if (this.fN == null) {
                TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this.ML);
                this.fN = tTAdDislikeToast;
                frameLayout.addView(tTAdDislikeToast);
            }
        } catch (Throwable th) {
            ApmHelper.reportCustomError("initDislike error", "TTVideoLandingPageLink2Activity", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBv() {
        TTAdDislikeToast tTAdDislikeToast;
        if (isFinishing() || (tTAdDislikeToast = this.fN) == null) {
            return;
        }
        tTAdDislikeToast.show(TTAdDislikeToast.getDislikeSendTip());
    }
}
