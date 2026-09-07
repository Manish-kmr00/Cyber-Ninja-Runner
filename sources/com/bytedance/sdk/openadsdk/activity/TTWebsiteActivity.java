package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.common.aBv;
import com.bytedance.sdk.openadsdk.core.ML.SD;
import com.bytedance.sdk.openadsdk.core.ML.omh;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.xy;
import com.bytedance.sdk.openadsdk.utils.Bzk;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.google.common.net.HttpHeaders;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.net.URLEncoder;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class TTWebsiteActivity extends TTBaseActivity {
    private WebView KZx;
    private aBv Og;
    private String pA = null;

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.u, me);
        return super.dispatchTouchEvent(me);
    }

    public static void pA(Context context, yFO yfo, String str) {
        if (context == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(System.currentTimeMillis(), yfo, str, "open_policy");
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.aBv.ZZv().qmB())) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) TTWebsiteActivity.class);
        if (yfo != null) {
            intent.putExtra("_extra_meta", yfo.FGT().toString());
            intent.putExtra("_extra_glo_d", yfo.ged());
        }
        com.bytedance.sdk.component.utils.Og.pA(context, intent, null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.bytedance.sdk.openadsdk.core.aBv.Og(getApplicationContext());
        if (!Sn.ML()) {
            finish();
            return;
        }
        final String stringExtra = getIntent().getStringExtra("_extra_meta");
        String stringExtra2 = getIntent().getStringExtra("_extra_glo_d");
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(this);
        if (Build.VERSION.SDK_INT >= 35) {
            ml.setFitsSystemWindows(true);
        }
        ml.setBackgroundColor(-1);
        ml.setId(520093726);
        ml.setOrientation(1);
        ml.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        try {
            setContentView(ml);
            int iKZx = Vgu.KZx(this, 5.0f);
            int iKZx2 = Vgu.KZx(this, 8.0f);
            int iKZx3 = Vgu.KZx(this, 10.0f);
            int iKZx4 = Vgu.KZx(this, 12.0f);
            int iKZx5 = Vgu.KZx(this, 14.0f);
            int iKZx6 = Vgu.KZx(this, 20.0f);
            int iKZx7 = Vgu.KZx(this, 24.0f);
            int iKZx8 = Vgu.KZx(this, 40.0f);
            int iKZx9 = Vgu.KZx(this, 44.0f);
            int iKZx10 = Vgu.KZx(this, 191.0f);
            SD sd = new SD(this);
            sd.setGravity(15);
            sd.setLayoutParams(new LinearLayout.LayoutParams(-1, iKZx9));
            com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(this);
            zZv.setId(520093720);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iKZx8, iKZx9);
            layoutParams.setMarginStart(iKZx2);
            zZv.setLayoutParams(layoutParams);
            zZv.setClickable(true);
            zZv.setFocusable(true);
            zZv.setPadding(iKZx5, iKZx4, iKZx5, iKZx4);
            zZv.setImageDrawable(com.bytedance.sdk.component.utils.yFO.KZx(this, "tt_ad_arrow_backward"));
            final com.bytedance.sdk.openadsdk.core.ML.ZZv zZv2 = new com.bytedance.sdk.openadsdk.core.ML.ZZv(this);
            zZv2.setId(520093716);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iKZx8, iKZx9);
            layoutParams2.addRule(17, 520093720);
            zZv2.setLayoutParams(layoutParams2);
            zZv2.setClickable(true);
            zZv2.setFocusable(true);
            zZv2.setPadding(iKZx4, iKZx5, iKZx4, iKZx5);
            zZv2.setImageDrawable(com.bytedance.sdk.component.utils.yFO.KZx(this, "tt_ad_xmark"));
            omh omhVar = new omh(this);
            omhVar.setId(com.bytedance.sdk.openadsdk.utils.Sn.Ld);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iKZx10, iKZx7);
            layoutParams3.setMarginStart(iKZx);
            layoutParams3.addRule(15);
            layoutParams3.addRule(16, 520093741);
            layoutParams3.addRule(17, 520093716);
            omhVar.setLayoutParams(layoutParams3);
            omhVar.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            omhVar.setGravity(17);
            omhVar.setSingleLine(true);
            omhVar.setTextColor(Color.parseColor("#222222"));
            omhVar.setTextSize(17.0f);
            com.bytedance.sdk.openadsdk.core.ML.ZZv zZv3 = new com.bytedance.sdk.openadsdk.core.ML.ZZv(this);
            zZv3.setId(520093741);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iKZx8, iKZx9);
            layoutParams4.addRule(16, 520093742);
            zZv3.setLayoutParams(layoutParams4);
            zZv3.setPadding(iKZx3, iKZx4, iKZx3, iKZx4);
            zZv3.setImageDrawable(com.bytedance.sdk.component.utils.yFO.KZx(this, "tt_ad_link"));
            com.bytedance.sdk.openadsdk.core.ML.ZZv zZv4 = new com.bytedance.sdk.openadsdk.core.ML.ZZv(this);
            zZv4.setId(520093742);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(iKZx8, iKZx9);
            layoutParams5.addRule(21);
            layoutParams5.setMarginEnd(iKZx2);
            zZv4.setLayoutParams(layoutParams5);
            zZv4.setPadding(iKZx4, iKZx6, iKZx4, iKZx6);
            zZv4.setImageDrawable(com.bytedance.sdk.component.utils.yFO.KZx(this, "tt_ad_threedots"));
            final com.bytedance.sdk.openadsdk.core.ML.JG jg = new com.bytedance.sdk.openadsdk.core.ML.JG(this, null, R.style.Widget.ProgressBar.Horizontal);
            jg.setId(520093743);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, Vgu.KZx(this, 2.0f));
            layoutParams6.addRule(12);
            jg.setLayoutParams(layoutParams6);
            jg.setProgress(1);
            jg.setProgressDrawable(Bzk.pA(this, "tt_privacy_progress_style"));
            View view = new View(this);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, Vgu.KZx(this, 1.0f));
            layoutParams7.addRule(12);
            view.setLayoutParams(layoutParams7);
            sd.addView(zZv);
            sd.addView(zZv2);
            sd.addView(omhVar);
            sd.addView(zZv3);
            sd.addView(zZv4);
            sd.addView(jg);
            sd.addView(view);
            ml.addView(sd);
            try {
                WebView webView = new WebView(getApplicationContext());
                this.KZx = webView;
                webView.setBackgroundColor(-1);
                ml.addView(this.KZx, new ViewGroup.LayoutParams(-1, -1));
                zZv.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTWebsiteActivity$1;->onClick(Landroid/view/View;)V");
                        CreativeInfoManager.onViewClicked(h.u, view2);
                        safedk_TTWebsiteActivity$1_onClick_d8cd77bea57b26aad36834f5e0ba44d8(view2);
                    }

                    public void safedk_TTWebsiteActivity$1_onClick_d8cd77bea57b26aad36834f5e0ba44d8(View p0) {
                        if (TTWebsiteActivity.this.KZx.canGoBack()) {
                            TTWebsiteActivity.this.KZx.goBack();
                        } else {
                            TTWebsiteActivity.this.finish();
                        }
                    }
                });
                zZv2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTWebsiteActivity$2;->onClick(Landroid/view/View;)V");
                        CreativeInfoManager.onViewClicked(h.u, view2);
                        safedk_TTWebsiteActivity$2_onClick_f5f79c59603abad0c3d6c7c1a7e7d495(view2);
                    }

                    public void safedk_TTWebsiteActivity$2_onClick_f5f79c59603abad0c3d6c7c1a7e7d495(View p0) {
                        TTWebsiteActivity.this.finish();
                    }
                });
                zZv2.setVisibility(4);
                zZv2.setClickable(false);
                omhVar.setText(com.bytedance.sdk.component.utils.yFO.pA(this, "tt_privacy_title"));
                zZv3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTWebsiteActivity$3;->onClick(Landroid/view/View;)V");
                        CreativeInfoManager.onViewClicked(h.u, view2);
                        safedk_TTWebsiteActivity$3_onClick_3f967ff73fae907dadffa55f4069e51e(view2);
                    }

                    public void safedk_TTWebsiteActivity$3_onClick_3f967ff73fae907dadffa55f4069e51e(View p0) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        String url = TTWebsiteActivity.this.KZx.getUrl();
                        if (TextUtils.isEmpty(url)) {
                            return;
                        }
                        intent.setData(Uri.parse(url));
                        com.bytedance.sdk.component.utils.Og.pA(TTWebsiteActivity.this, intent, null);
                    }
                });
                zZv4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTWebsiteActivity$4;->onClick(Landroid/view/View;)V");
                        CreativeInfoManager.onViewClicked(h.u, view2);
                        safedk_TTWebsiteActivity$4_onClick_d1bd09a9df9df7b640401a2216204c5c(view2);
                    }

                    public void safedk_TTWebsiteActivity$4_onClick_d1bd09a9df9df7b640401a2216204c5c(View p0) {
                        if (TTWebsiteActivity.this.Og == null) {
                            TTWebsiteActivity.this.Og = new aBv(TTWebsiteActivity.this);
                            TTWebsiteActivity.this.Og.pA(stringExtra);
                            TTWebsiteActivity.this.Og.setCanceledOnTouchOutside(false);
                        }
                        TTWebsiteActivity.this.Og.show();
                    }
                });
                if (com.bytedance.sdk.openadsdk.core.aBv.ZZv() != null) {
                    this.pA = com.bytedance.sdk.openadsdk.core.aBv.ZZv().qmB();
                    if (!TextUtils.isEmpty(stringExtra2)) {
                        String strEncode = URLEncoder.encode(stringExtra2);
                        if (this.pA.contains("?")) {
                            this.pA += "&gdid_encrypted=" + strEncode;
                        } else {
                            this.pA += "?gdid_encrypted=" + strEncode;
                        }
                    }
                }
                if (this.pA != null) {
                    WebSettings settings = this.KZx.getSettings();
                    settings.setMixedContentMode(0);
                    try {
                        settings.setJavaScriptEnabled(true);
                        settings.setDomStorageEnabled(true);
                        settings.setSavePassword(false);
                        settings.setAllowFileAccess(false);
                    } catch (Throwable unused) {
                    }
                    HashMap map = new HashMap();
                    map.put(HttpHeaders.REFERER, TTAdConstant.REQUEST_HEAD_REFERER);
                    try {
                        this.KZx.loadUrl(this.pA, map);
                    } catch (Throwable unused2) {
                        this.KZx.loadUrl(this.pA);
                    }
                    this.KZx.setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.5
                        @Override // android.webkit.WebChromeClient
                        public void onProgressChanged(WebView webView2, int i) {
                            super.onProgressChanged(webView2, i);
                            if (jg == null || TTWebsiteActivity.this.isFinishing()) {
                                return;
                            }
                            if (i == 100) {
                                jg.setVisibility(8);
                                if (webView2.canGoBack()) {
                                    zZv2.setVisibility(0);
                                    zZv2.setClickable(true);
                                    return;
                                } else {
                                    zZv2.setVisibility(4);
                                    zZv2.setClickable(false);
                                    return;
                                }
                            }
                            jg.setVisibility(0);
                            jg.setProgress(i);
                        }
                    });
                    this.KZx.setWebViewClient(new com.bytedance.sdk.component.Bzk.ZZv.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.6
                        @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                        public void onLoadResource(WebView view2, String url) {
                            super.onLoadResource(view2, url);
                            CreativeInfoManager.onResourceLoaded(h.u, view2, url);
                        }

                        @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                        public void onPageFinished(WebView webView2, String str) {
                            Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTWebsiteActivity$6;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
                            BrandSafetyUtils.onWebViewPageFinished(h.u, webView2, str);
                            safedk_TTWebsiteActivity$6_onPageFinished_1bf132ccf02adb00b374ab5fb4ce6ab3(webView2, str);
                        }

                        @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                        public void onPageStarted(WebView view2, String url, Bitmap favicon) {
                            super.onPageStarted(view2, url, favicon);
                            BrandSafetyUtils.onWebViewPageStarted(h.u, view2, url);
                        }

                        @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                        public void onReceivedError(WebView webView2, int i, String str, String str2) {
                            Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTWebsiteActivity$6;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
                            BrandSafetyUtils.onWebViewReceivedError(h.u, webView2, i, str, str2);
                            safedk_TTWebsiteActivity$6_onReceivedError_be7cef542c428a3115a14acbd2276592(webView2, i, str, str2);
                        }

                        @Override // android.webkit.WebViewClient
                        public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                            Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTWebsiteActivity$6;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
                            BrandSafetyUtils.onWebViewReceivedError(h.u, webView2, webResourceRequest, webResourceError);
                            safedk_TTWebsiteActivity$6_onReceivedError_ff42c1e7d1ef8c5a9394fa663a0c2f85(webView2, webResourceRequest, webResourceError);
                        }

                        @Override // com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                        public WebResourceResponse shouldInterceptRequest(WebView view2, WebResourceRequest webResourceRequest) {
                            return CreativeInfoManager.onWebViewResponseWithHeaders(h.u, view2, webResourceRequest, super.shouldInterceptRequest(view2, webResourceRequest));
                        }

                        @Override // android.webkit.WebViewClient
                        public boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                            Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTWebsiteActivity$6;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z");
                            boolean zSafedk_TTWebsiteActivity$6_shouldOverrideUrlLoading_f17b7541cb11120167322acf0f063b25 = safedk_TTWebsiteActivity$6_shouldOverrideUrlLoading_f17b7541cb11120167322acf0f063b25(webView2, webResourceRequest);
                            BrandSafetyUtils.onShouldOverrideUrlLoading(h.u, webView2, webResourceRequest, zSafedk_TTWebsiteActivity$6_shouldOverrideUrlLoading_f17b7541cb11120167322acf0f063b25);
                            return zSafedk_TTWebsiteActivity$6_shouldOverrideUrlLoading_f17b7541cb11120167322acf0f063b25;
                        }

                        public boolean safedk_TTWebsiteActivity$6_shouldOverrideUrlLoading_f17b7541cb11120167322acf0f063b25(WebView p0, WebResourceRequest p1) {
                            if (p0 == null || p1 == null) {
                                return false;
                            }
                            PangleNetworkBridge.webviewLoadUrl(p0, p1.getUrl().toString());
                            return true;
                        }

                        public void safedk_TTWebsiteActivity$6_onPageFinished_1bf132ccf02adb00b374ab5fb4ce6ab3(WebView p0, String p1) {
                            super.onPageFinished(p0, p1);
                        }

                        @Override // android.webkit.WebViewClient
                        public void onReceivedHttpError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                            super.onReceivedHttpError(webView2, webResourceRequest, webResourceResponse);
                            WV.pA("TTAD.TTWebsiteActivity", "onReceivedHttpError invoke....errorResponse=".concat(String.valueOf(webResourceResponse)));
                        }

                        public void safedk_TTWebsiteActivity$6_onReceivedError_ff42c1e7d1ef8c5a9394fa663a0c2f85(WebView p0, WebResourceRequest p1, WebResourceError p2) {
                            super.onReceivedError(p0, p1, p2);
                            WV.pA("TTAD.TTWebsiteActivity", "onReceivedError invoke....onReceivedError=" + p2.getErrorCode());
                        }

                        public void safedk_TTWebsiteActivity$6_onReceivedError_be7cef542c428a3115a14acbd2276592(WebView p0, int p1, String p2, String p3) {
                            super.onReceivedError(p0, p1, p2, p3);
                        }
                    });
                    com.bytedance.sdk.openadsdk.core.widget.pA.KZx.Og(this.KZx);
                    return;
                }
                finish();
            } catch (Exception e) {
                WV.pA("TTAD.TTWebsiteActivity", "onCreate: ", e);
                finish();
            }
        } catch (Throwable unused3) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        xy.pA(this.KZx);
        super.onDestroy();
    }
}
