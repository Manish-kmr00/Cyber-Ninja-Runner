package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.ZZv.BSW;
import com.bytedance.sdk.openadsdk.ZZv.SGo;
import com.bytedance.sdk.openadsdk.common.DX;
import com.bytedance.sdk.openadsdk.common.Sn;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.common.WV;
import com.bytedance.sdk.openadsdk.core.IG;
import com.bytedance.sdk.openadsdk.core.TV;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Bzk;
import com.bytedance.sdk.openadsdk.utils.SD;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class TTLandingPageActivity extends TTBaseActivity {
    private String BF;
    private Sn BSW;
    private TextView Bzk;
    private String DX;
    private WV IG;
    private com.bytedance.sdk.component.Bzk.ZZv JG;
    TTAdDislikeToast KZx;
    DX Og;
    private Context SGo;
    private String Sd;
    private String Sn;
    private ILoader WQf;
    private Button WV;
    private com.bytedance.sdk.openadsdk.core.ML.JG Wx;
    private String XT;
    private int aBv;
    private int eG;
    private com.bytedance.sdk.openadsdk.core.widget.pA.ML gbA;
    private boolean lT;
    private IG oX;
    private ImageView omh;
    BSW pA;
    private com.bytedance.sdk.openadsdk.common.ZZv qmB;
    private com.bytedance.sdk.openadsdk.utils.WV rB;
    private int roi;
    private com.bytedance.sdk.openadsdk.XT.pA.pA.JG vZF;
    private com.bytedance.sdk.openadsdk.core.widget.pA.JG.pA xy;
    private yFO yFO;
    private final AtomicBoolean TX = new AtomicBoolean(true);
    private final AtomicInteger TV = new AtomicInteger(0);
    private final AtomicInteger du = new AtomicInteger(0);
    private final AtomicInteger Mc = new AtomicInteger(0);
    final AtomicBoolean ZZv = new AtomicBoolean(false);
    final AtomicBoolean ML = new AtomicBoolean(false);
    private String Vgu = "ダウンロード";

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.u, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        pA(3);
        super.onCreate(bundle);
        if (!com.bytedance.sdk.openadsdk.core.Sn.ML()) {
            finish();
            return;
        }
        try {
            aBv.Og(this);
        } catch (Throwable unused) {
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            setContentView(Og());
            Intent intent = getIntent();
            int intExtra = intent.getIntExtra("sdk_version", 1);
            this.Sn = intent.getStringExtra("adid");
            this.DX = intent.getStringExtra("log_extra");
            this.aBv = intent.getIntExtra("source", -1);
            String stringExtra = intent.getStringExtra("url");
            this.Sd = stringExtra;
            Og(4);
            String stringExtra2 = intent.getStringExtra("web_title");
            this.XT = intent.getStringExtra("event_tag");
            this.BF = intent.getStringExtra("gecko_id");
            if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra3 != null) {
                    try {
                        this.yFO = com.bytedance.sdk.openadsdk.core.Og.pA(new JSONObject(stringExtra3));
                    } catch (Exception e) {
                        com.bytedance.sdk.component.utils.WV.pA("TTAD.LandingPageAct", "TTLandingPageActivity - onCreate MultiGlobalInfo : ", e);
                    }
                }
            } else {
                this.yFO = TV.pA().Og();
                TV.pA().JG();
            }
            if (this.yFO == null) {
                finish();
                return;
            }
            ML();
            if (!TextUtils.isEmpty(this.BF)) {
                this.WQf = com.bytedance.sdk.openadsdk.SD.Og.pA().Og();
                int iPA = com.bytedance.sdk.openadsdk.SD.Og.pA().pA(this.WQf, this.BF);
                this.eG = iPA;
                this.roi = iPA > 0 ? 2 : 0;
            }
            this.SGo = this;
            if (this.JG != null) {
                com.bytedance.sdk.openadsdk.core.widget.pA.KZx.pA(this).pA(false).Og(false).pA(this.JG.getWebView());
            }
            com.bytedance.sdk.component.Bzk.ZZv zZv = this.JG;
            if (zZv != null && zZv.getWebView() != null) {
                BSW bswPA = new BSW(this.yFO, this.JG.getWebView(), new pA(this.eG, this.yFO, "landingpage", this), this.roi).pA(true);
                this.pA = bswPA;
                this.xy = bswPA.pA;
                this.qmB = gbA.pA(this.yFO, this.JG, this.SGo, this.XT);
            }
            JG();
            this.JG.setLandingPage(true);
            this.JG.setTag("landingpage");
            this.JG.setMaterialMeta(this.yFO.BDQ());
            com.bytedance.sdk.openadsdk.core.widget.pA.ML ml = new com.bytedance.sdk.openadsdk.core.widget.pA.ML(this.SGo, this.oX, this.Sn, this.qmB, this.pA, true) { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.1
                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                public void onLoadResource(WebView view, String url) {
                    super.onLoadResource(view, url);
                    CreativeInfoManager.onResourceLoaded(h.u, view, url);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTLandingPageActivity$1;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
                    BrandSafetyUtils.onWebViewPageFinished(h.u, webView, str);
                    safedk_TTLandingPageActivity$1_onPageFinished_967ad1ca533d90a13ac51682f67de6fb(webView, str);
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

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTLandingPageActivity$1;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;");
                    return CreativeInfoManager.onWebViewResponse(h.u, webView, str, safedk_TTLandingPageActivity$1_shouldInterceptRequest_a23ee0e4f1758c9414b15086c3f5754f(webView, str));
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    boolean zShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(view, url);
                    BrandSafetyUtils.onShouldOverrideUrlLoading(h.u, view, url, zShouldOverrideUrlLoading);
                    return zShouldOverrideUrlLoading;
                }

                public void safedk_TTLandingPageActivity$1_onPageFinished_967ad1ca533d90a13ac51682f67de6fb(WebView p0, String p1) {
                    super.onPageFinished(p0, p1);
                    try {
                        if (TTLandingPageActivity.this.Wx != null && !TTLandingPageActivity.this.isFinishing()) {
                            TTLandingPageActivity.this.Wx.setVisibility(8);
                        }
                    } catch (Throwable unused2) {
                    }
                    if (TTLandingPageActivity.this.IG != null) {
                        TTLandingPageActivity.this.IG.Og();
                    }
                }

                public WebResourceResponse safedk_TTLandingPageActivity$1_shouldInterceptRequest_a23ee0e4f1758c9414b15086c3f5754f(WebView p0, String p1) {
                    try {
                        if (!TextUtils.isEmpty(TTLandingPageActivity.this.BF)) {
                            TTLandingPageActivity.this.TV.incrementAndGet();
                            WebResourceResponseModel webResourceResponseModelPA = com.bytedance.sdk.openadsdk.SD.Og.pA().pA(TTLandingPageActivity.this.WQf, TTLandingPageActivity.this.BF, p1);
                            if (webResourceResponseModelPA != null && webResourceResponseModelPA.getWebResourceResponse() != null) {
                                TTLandingPageActivity.this.Mc.incrementAndGet();
                                return webResourceResponseModelPA.getWebResourceResponse();
                            }
                            if (webResourceResponseModelPA != null && webResourceResponseModelPA.getMsg() == 2) {
                                TTLandingPageActivity.this.du.incrementAndGet();
                            }
                            return super.shouldInterceptRequest(p0, p1);
                        }
                        return super.shouldInterceptRequest(p0, p1);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.WV.pA("TTAD.LandingPageAct", "shouldInterceptRequest url error", th);
                        return super.shouldInterceptRequest(p0, p1);
                    }
                }
            };
            this.gbA = ml;
            ml.pA(this.yFO);
            this.JG.setWebViewClient(this.gbA);
            com.bytedance.sdk.component.Bzk.ZZv zZv2 = this.JG;
            if (zZv2 != null) {
                zZv2.setUserAgentString(com.bytedance.sdk.openadsdk.utils.aBv.pA(zZv2.getWebView(), intExtra));
            }
            com.bytedance.sdk.component.Bzk.ZZv zZv3 = this.JG;
            if (zZv3 != null) {
                zZv3.setMixedContentMode(0);
            }
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.yFO, "landingpage", this.roi);
            com.bytedance.sdk.openadsdk.utils.yFO.pA(this.JG, stringExtra);
            this.JG.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.pA.ZZv(this.oX, this.pA, this.qmB) { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.5
                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ZZv, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    if (TTLandingPageActivity.this.IG != null) {
                        TTLandingPageActivity.this.IG.pA(i);
                    }
                    if (TTLandingPageActivity.this.Wx == null || TTLandingPageActivity.this.isFinishing()) {
                        return;
                    }
                    if (i != 100 || !TTLandingPageActivity.this.Wx.isShown()) {
                        TTLandingPageActivity.this.Wx.setProgress(i);
                    } else {
                        TTLandingPageActivity.this.Wx.setVisibility(8);
                    }
                }
            });
            if (this.JG.getWebView() != null) {
                this.JG.getWebView().setOnScrollChangeListener(new Og(this.pA));
                this.JG.getWebView().setOnTouchListener(new KZx(this.pA, this.qmB));
            }
            this.JG.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.6
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (TTLandingPageActivity.this.vZF != null) {
                        TTLandingPageActivity.this.vZF.ZZv();
                    }
                }
            });
            TextView textView = this.Bzk;
            if (textView != null) {
                if (TextUtils.isEmpty(stringExtra2)) {
                    stringExtra2 = com.bytedance.sdk.component.utils.yFO.pA(this, "tt_web_title_default");
                }
                textView.setText(stringExtra2);
            }
            KZx();
            com.bytedance.sdk.openadsdk.utils.WV wvPA = SD.pA(this, new SD.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.7
                @Override // com.bytedance.sdk.openadsdk.utils.SD.pA
                public void Og() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.SD.pA
                public View pA() {
                    return TTLandingPageActivity.this.omh;
                }
            });
            this.rB = wvPA;
            wvPA.pA(0L);
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA.pA(SystemClock.elapsedRealtime() - jElapsedRealtime, this.yFO, "landingpage", this.WQf, this.BF);
        } catch (Throwable unused2) {
            finish();
        }
    }

    public static class pA implements SGo {
        private final String KZx;
        private final yFO Og;
        private final WeakReference<TTLandingPageActivity> ZZv;
        private final int pA;

        public pA(int i, yFO yfo, String str, TTLandingPageActivity tTLandingPageActivity) {
            this.pA = i;
            this.Og = yfo;
            this.KZx = str;
            this.ZZv = new WeakReference<>(tTLandingPageActivity);
        }

        @Override // com.bytedance.sdk.openadsdk.ZZv.SGo
        public void pA(int i) {
            TTLandingPageActivity tTLandingPageActivity = this.ZZv.get();
            if (tTLandingPageActivity != null) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA.pA(this.pA, tTLandingPageActivity.du.get(), tTLandingPageActivity.Mc.get(), tTLandingPageActivity.TV.get() - tTLandingPageActivity.Mc.get(), this.Og, this.KZx, i);
            }
        }
    }

    private static class Og implements View.OnScrollChangeListener {
        private final WeakReference<BSW> pA;

        public Og(BSW bsw) {
            this.pA = new WeakReference<>(bsw);
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i, int i2, int i3, int i4) {
            BSW bsw = this.pA.get();
            if (bsw != null) {
                bsw.Og(i2);
            }
        }
    }

    private static class KZx implements View.OnTouchListener {
        private final WeakReference<com.bytedance.sdk.openadsdk.common.ZZv> Og;
        private final WeakReference<BSW> pA;

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTLandingPageActivity$KZx;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            CreativeInfoManager.onViewTouched(h.u, view, motionEvent);
            return safedk_TTLandingPageActivity$KZx_onTouch_f54f1fd3b8c1b4673707e2a7005229c7(view, motionEvent);
        }

        public KZx(BSW bsw, com.bytedance.sdk.openadsdk.common.ZZv zZv) {
            this.pA = new WeakReference<>(bsw);
            this.Og = new WeakReference<>(zZv);
        }

        public boolean safedk_TTLandingPageActivity$KZx_onTouch_f54f1fd3b8c1b4673707e2a7005229c7(View p0, MotionEvent p1) {
            BSW bsw = this.pA.get();
            if (bsw != null) {
                bsw.pA(p1);
            }
            com.bytedance.sdk.openadsdk.common.ZZv zZv = this.Og.get();
            if (zZv == null) {
                return false;
            }
            zZv.pA(p1);
            return false;
        }
    }

    private View Og() {
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx = new com.bytedance.sdk.openadsdk.core.ML.KZx(this);
        if (Build.VERSION.SDK_INT >= 35) {
            kZx.setFitsSystemWindows(true);
        }
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(this);
        ml.setOrientation(1);
        kZx.addView(ml, new FrameLayout.LayoutParams(-1, -1));
        Sn sn = new Sn(this, new Sn.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.8
            @Override // com.bytedance.sdk.openadsdk.common.Sn.pA
            public View pA(Context context) {
                return new com.bytedance.sdk.openadsdk.common.SGo(context);
            }
        });
        sn.setId(com.bytedance.sdk.openadsdk.utils.Sn.cFQ);
        ml.addView(sn, new LinearLayout.LayoutParams(-1, Vgu.KZx(this, 44.0f)));
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx2 = new com.bytedance.sdk.openadsdk.core.ML.KZx(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        ml.addView(kZx2, layoutParams);
        com.bytedance.sdk.component.Bzk.ZZv zZv = new com.bytedance.sdk.component.Bzk.ZZv(this);
        zZv.setId(com.bytedance.sdk.openadsdk.utils.Sn.JBA);
        kZx2.addView(zZv, new FrameLayout.LayoutParams(-1, -1));
        Sn sn2 = new Sn(this, new Sn.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.9
            @Override // com.bytedance.sdk.openadsdk.common.Sn.pA
            public View pA(Context context) {
                return new com.bytedance.sdk.openadsdk.common.SD(context);
            }
        });
        sn2.setId(com.bytedance.sdk.openadsdk.utils.Sn.vA);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 81;
        kZx2.addView(sn2, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ML.JG jg = new com.bytedance.sdk.openadsdk.core.ML.JG(this, null, R.style.Widget.ProgressBar.Horizontal);
        jg.setId(com.bytedance.sdk.openadsdk.utils.Sn.fw);
        jg.setProgress(1);
        jg.setVisibility(8);
        jg.setProgressDrawable(Bzk.pA(this, "tt_browser_progress_style"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, Vgu.KZx(this, 3.0f));
        layoutParams3.gravity = 49;
        kZx2.addView(jg, layoutParams3);
        WV wv = new WV(this);
        wv.setId(520093721);
        kZx.addView(wv, new FrameLayout.LayoutParams(-1, -1));
        return kZx;
    }

    private void pA(int i) {
        if (i == 1 || Build.VERSION.SDK_INT == 26) {
            return;
        }
        if (Build.VERSION.SDK_INT == 27) {
            try {
                setRequestedOrientation(i);
            } catch (Throwable unused) {
            }
        } else {
            setRequestedOrientation(i);
        }
    }

    private void KZx() {
        yFO yfo = this.yFO;
        if (yfo == null || yfo.JBA() != 4) {
            return;
        }
        Sn sn = this.BSW;
        if (sn != null) {
            sn.setVisibility(0);
        }
        Button button = (Button) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.sk);
        this.WV = button;
        if (button != null) {
            pA(ZZv());
            if (this.vZF == null) {
                this.vZF = com.bytedance.sdk.openadsdk.XT.pA.pA.SD.pA(this, this.yFO, TextUtils.isEmpty(this.XT) ? gbA.Og(this.aBv) : this.XT);
            }
            com.bytedance.sdk.openadsdk.core.Og.pA pAVar = new com.bytedance.sdk.openadsdk.core.Og.pA(this, this.yFO, this.XT, this.aBv);
            pAVar.pA(false);
            this.WV.setOnClickListener(pAVar);
            this.WV.setOnTouchListener(pAVar);
            pAVar.KZx(true);
            pAVar.pA(this.vZF);
        }
    }

    private String ZZv() {
        yFO yfo = this.yFO;
        if (yfo != null && !TextUtils.isEmpty(yfo.gy())) {
            this.Vgu = this.yFO.gy();
        }
        return this.Vgu;
    }

    private void pA(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.WV) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.10
            @Override // java.lang.Runnable
            public void run() {
                if (TTLandingPageActivity.this.WV == null || TTLandingPageActivity.this.isFinishing()) {
                    return;
                }
                TTLandingPageActivity.this.WV.setText(str);
            }
        });
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (Throwable unused) {
        }
        KZx();
    }

    private void ML() {
        com.bytedance.sdk.component.Bzk.ZZv zZv = (com.bytedance.sdk.component.Bzk.ZZv) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.JBA);
        this.JG = zZv;
        gbA.pA(this.yFO, zZv);
        this.BSW = (Sn) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.vA);
        Sn sn = (Sn) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.cFQ);
        WV wv = (WV) findViewById(520093721);
        this.IG = wv;
        if (wv != null) {
            wv.pA(this.yFO);
            this.IG.pA();
        }
        if (sn != null) {
            sn.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(520093720);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTLandingPageActivity$11;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_TTLandingPageActivity$11_onClick_ed27a989812dc5c9b827a0289fa9275b(view);
                }

                public void safedk_TTLandingPageActivity$11_onClick_ed27a989812dc5c9b827a0289fa9275b(View p0) {
                    View p1 = TTLandingPageActivity.this.JG;
                    if (p1 != null) {
                        if (TTLandingPageActivity.this.xy != null) {
                            TTLandingPageActivity.this.xy.pA();
                        }
                        if (TTLandingPageActivity.this.JG.ML()) {
                            TTLandingPageActivity.this.JG.JG();
                        } else if (TTLandingPageActivity.this.SD()) {
                            TTLandingPageActivity.this.onBackPressed();
                        } else {
                            TTLandingPageActivity.this.finish();
                        }
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(520093716);
        this.omh = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTLandingPageActivity$12;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_TTLandingPageActivity$12_onClick_2130f5422e151e3d56ee44a8d5cb2e8f(view);
                }

                public void safedk_TTLandingPageActivity$12_onClick_2130f5422e151e3d56ee44a8d5cb2e8f(View p0) {
                    TTLandingPageActivity.this.finish();
                }
            });
        }
        this.Bzk = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.Ld);
        com.bytedance.sdk.openadsdk.core.ML.JG jg = (com.bytedance.sdk.openadsdk.core.ML.JG) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.fw);
        this.Wx = jg;
        if (jg != null) {
            jg.setVisibility(0);
        }
        View viewFindViewById = findViewById(com.bytedance.sdk.openadsdk.utils.Sn.tZW);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTLandingPageActivity$2;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_TTLandingPageActivity$2_onClick_fc6749bd0e69043089d54377338bbf83(view);
                }

                public void safedk_TTLandingPageActivity$2_onClick_fc6749bd0e69043089d54377338bbf83(View p0) {
                    TTLandingPageActivity.this.pA();
                }
            });
        }
    }

    private void JG() {
        IG ig = new IG(this);
        this.oX = ig;
        ig.Og(this.JG).KZx(this.Sn).ZZv(this.DX).pA(this.yFO).Og(this.aBv).pA(this.yFO.Vgu()).ML(this.yFO.jK()).pA(this.JG).Og("landingpage");
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        IG ig = this.oX;
        if (ig != null) {
            ig.SGo();
        }
        BSW bsw = this.pA;
        if (bsw != null) {
            bsw.SD();
        }
        if (!this.lT) {
            this.lT = true;
            pA(4);
        }
        com.bytedance.sdk.openadsdk.utils.WV wv = this.rB;
        if (wv != null) {
            wv.pA();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        BSW bsw = this.pA;
        if (bsw != null) {
            bsw.omh();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        com.bytedance.sdk.openadsdk.utils.WV wv = this.rB;
        if (wv != null) {
            wv.Og();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (SD() && !this.TX.getAndSet(true)) {
            omh();
            Og(0);
        } else {
            try {
                super.onBackPressed();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.LandingPageAct", "onBackPressed: ", th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SD() {
        return !TextUtils.isEmpty(this.Sd) && this.Sd.contains("__luban_sdk");
    }

    private void Og(final int i) {
        if (this.omh == null || !SD()) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.3
            @Override // java.lang.Runnable
            public void run() {
                Vgu.pA((View) TTLandingPageActivity.this.omh, i);
            }
        });
    }

    private void omh() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", true);
            this.oX.pA("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.bytedance.sdk.component.Bzk.ZZv zZv;
        super.onDestroy();
        BSW bsw = this.pA;
        if (bsw != null && (zZv = this.JG) != null) {
            bsw.pA(zZv);
        }
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.component.Bzk.ZZv zZv2 = this.JG;
        if (zZv2 != null) {
            com.bytedance.sdk.openadsdk.core.xy.pA(zZv2.getWebView());
        }
        this.JG = null;
        IG ig = this.oX;
        if (ig != null) {
            ig.BSW();
        }
        BSW bsw2 = this.pA;
        if (bsw2 != null) {
            bsw2.KZx(true);
        }
        if (!TextUtils.isEmpty(this.BF)) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA.pA(this.Mc.get(), this.TV.get(), this.yFO);
        }
        com.bytedance.sdk.openadsdk.SD.Og.pA().pA(this.WQf);
        com.bytedance.sdk.openadsdk.utils.WV wv = this.rB;
        if (wv != null) {
            wv.KZx();
        }
    }

    protected void pA() {
        if (isFinishing()) {
            return;
        }
        if (this.ML.get()) {
            SGo();
            return;
        }
        if (this.Og == null) {
            Bzk();
        }
        DX dx = this.Og;
        if (dx != null) {
            dx.pA();
        }
    }

    private void Bzk() {
        try {
            if (this.Og == null) {
                DX dx = new DX(this.SGo, this.yFO);
                this.Og = dx;
                dx.setDislikeSource("landing_page");
                this.Og.setCallback(new DX.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.4
                    @Override // com.bytedance.sdk.openadsdk.common.DX.pA
                    public void pA(View view) {
                        TTLandingPageActivity.this.ZZv.set(true);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.DX.pA
                    public void Og(View view) {
                        TTLandingPageActivity.this.ZZv.set(false);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.DX.pA
                    public void pA(FilterWord filterWord) {
                        if (TTLandingPageActivity.this.ML.get() || filterWord == null || filterWord.hasSecondOptions()) {
                            return;
                        }
                        TTLandingPageActivity.this.ML.set(true);
                        TTLandingPageActivity.this.BSW();
                    }
                });
            }
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
            frameLayout.addView(this.Og);
            if (this.KZx == null) {
                TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this.SGo);
                this.KZx = tTAdDislikeToast;
                frameLayout.addView(tTAdDislikeToast);
            }
        } catch (Throwable th) {
            ApmHelper.reportCustomError("initDislike error", "LandingPageActivity", th);
        }
    }

    private void SGo() {
        TTAdDislikeToast tTAdDislikeToast = this.KZx;
        if (tTAdDislikeToast == null) {
            return;
        }
        tTAdDislikeToast.show(TTAdDislikeToast.getDislikeTip());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BSW() {
        TTAdDislikeToast tTAdDislikeToast;
        if (isFinishing() || (tTAdDislikeToast = this.KZx) == null) {
            return;
        }
        tTAdDislikeToast.show(TTAdDislikeToast.getDislikeSendTip());
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        com.bytedance.sdk.openadsdk.utils.KZx.pA(this, this.yFO);
    }
}
