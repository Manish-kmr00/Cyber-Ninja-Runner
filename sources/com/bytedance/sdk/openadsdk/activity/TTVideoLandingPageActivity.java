package com.bytedance.sdk.openadsdk.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.ML.oX;
import com.bytedance.sdk.component.utils.BF;
import com.bytedance.sdk.component.utils.DX;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.ZZv.BSW;
import com.bytedance.sdk.openadsdk.ZZv.SD;
import com.bytedance.sdk.openadsdk.ZZv.SGo;
import com.bytedance.sdk.openadsdk.common.Sn;
import com.bytedance.sdk.openadsdk.core.IG;
import com.bytedance.sdk.openadsdk.core.TV;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TTVideoLandingPageActivity extends TTBaseActivity implements com.bytedance.sdk.openadsdk.SGo.ZZv {
    protected TextView BF;
    protected int BSW;
    protected String Bf;
    protected String Bzk;
    protected com.bytedance.sdk.openadsdk.multipro.Og.pA CIG;
    protected long DX;
    protected com.bytedance.sdk.openadsdk.core.widget.pA.JG.pA HSv;
    protected int JG;
    protected ImageView KZx;
    protected Context ML;
    protected com.bytedance.sdk.openadsdk.XT.pA.pA.JG Mc;
    protected ImageView Og;
    protected IG SGo;
    protected com.bytedance.sdk.openadsdk.core.Wx.Og.JG Sn;
    protected BSW SzT;
    protected TextView TV;
    protected RelativeLayout TX;
    protected int Vgu;
    protected com.bytedance.sdk.openadsdk.core.widget.pA WQf;
    protected FrameLayout WV;
    private int YkC;
    protected TextView ZZv;
    private ILoader agB;
    private int dC;
    protected TextView du;
    protected Sn eG;
    protected String lT;
    protected yFO oX;
    protected String omh;
    protected com.bytedance.sdk.component.Bzk.ZZv pA;
    protected Button roi;
    protected int Wx = -1;
    protected int aBv = 0;
    protected int XT = 0;
    protected int yFO = 0;
    protected int vZF = 0;
    protected String Sd = "ダウンロード";
    protected boolean IG = false;
    protected boolean rB = false;
    protected boolean xy = true;
    protected boolean qmB = false;
    protected String gbA = null;
    protected AtomicBoolean FQ = new AtomicBoolean(true);
    protected JSONArray Gx = null;
    private final AtomicInteger fN = new AtomicInteger(0);
    private final AtomicInteger dmv = new AtomicInteger(0);
    private final AtomicInteger fJy = new AtomicInteger(0);
    protected com.bytedance.sdk.openadsdk.core.Og.pA JBA = null;
    private final com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.Og IIF = new com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.Og() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.11
        @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.Og
        public void pA(boolean z) {
            TTVideoLandingPageActivity.this.IG = z;
            if (TTVideoLandingPageActivity.this.isFinishing()) {
                return;
            }
            if (z) {
                Vgu.pA((View) TTVideoLandingPageActivity.this.pA, 8);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.WV.getLayoutParams();
                TTVideoLandingPageActivity.this.XT = marginLayoutParams.leftMargin;
                TTVideoLandingPageActivity.this.aBv = marginLayoutParams.topMargin;
                TTVideoLandingPageActivity.this.yFO = marginLayoutParams.width;
                TTVideoLandingPageActivity.this.vZF = marginLayoutParams.height;
                marginLayoutParams.width = -1;
                marginLayoutParams.height = -1;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                TTVideoLandingPageActivity.this.WV.setLayoutParams(marginLayoutParams);
                return;
            }
            Vgu.pA((View) TTVideoLandingPageActivity.this.pA, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.WV.getLayoutParams();
            marginLayoutParams2.width = TTVideoLandingPageActivity.this.yFO;
            marginLayoutParams2.height = TTVideoLandingPageActivity.this.vZF;
            marginLayoutParams2.leftMargin = TTVideoLandingPageActivity.this.XT;
            marginLayoutParams2.topMargin = TTVideoLandingPageActivity.this.aBv;
            TTVideoLandingPageActivity.this.WV.setLayoutParams(marginLayoutParams2);
        }
    };
    private final BF.pA vA = new BF.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.2
        @Override // com.bytedance.sdk.component.utils.BF.pA
        public void pA(Context context, Intent intent, boolean z, final int i) {
            xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    pA(i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pA(int i) {
            if (TTVideoLandingPageActivity.this.Vgu == 0 && i != 0 && TTVideoLandingPageActivity.this.pA != null && TTVideoLandingPageActivity.this.gbA != null) {
                TTVideoLandingPageActivity.this.pA.a_(TTVideoLandingPageActivity.this.gbA);
            }
            if (TTVideoLandingPageActivity.this.Sn != null && TTVideoLandingPageActivity.this.Sn.getNativeVideoController() != null && !TTVideoLandingPageActivity.this.rB && TTVideoLandingPageActivity.this.Vgu != i) {
                ((com.bytedance.sdk.openadsdk.core.Wx.Og.KZx) TTVideoLandingPageActivity.this.Sn.getNativeVideoController()).KZx(i);
            }
            TTVideoLandingPageActivity.this.Vgu = i;
        }
    };

    protected abstract boolean ML();

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.u, me);
        return super.dispatchTouchEvent(me);
    }

    protected abstract View pA();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.bytedance.sdk.openadsdk.core.Sn.ML()) {
            finish();
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
        try {
            aBv.Og(this);
        } catch (Throwable unused2) {
        }
        this.Vgu = DX.KZx(getApplicationContext());
        try {
            setContentView(pA());
            this.ML = this;
            Intent intent = getIntent();
            this.JG = intent.getIntExtra("sdk_version", 1);
            this.omh = intent.getStringExtra("adid");
            this.Bzk = intent.getStringExtra("log_extra");
            this.BSW = intent.getIntExtra("source", -1);
            this.gbA = intent.getStringExtra("url");
            String stringExtra = intent.getStringExtra("web_title");
            this.lT = intent.getStringExtra("event_tag");
            this.Bf = intent.getStringExtra("gecko_id");
            this.qmB = intent.getBooleanExtra("video_is_auto_play", true);
            if (bundle != null && bundle.getLong("video_play_position") > 0) {
                this.DX = bundle.getLong("video_play_position", 0L);
            }
            String stringExtra2 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_DATA);
            if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra3 != null) {
                    try {
                        this.oX = com.bytedance.sdk.openadsdk.core.Og.pA(new JSONObject(stringExtra3));
                    } catch (Exception unused3) {
                    }
                }
                yFO yfo = this.oX;
                if (yfo != null) {
                    this.Wx = yfo.RS();
                }
            } else {
                yFO yfoOg = TV.pA().Og();
                this.oX = yfoOg;
                if (yfoOg != null) {
                    this.Wx = yfoOg.RS();
                }
                TV.pA().JG();
            }
            if (this.oX == null) {
                finish();
                return;
            }
            if (!TextUtils.isEmpty(this.Bf)) {
                this.agB = com.bytedance.sdk.openadsdk.SD.Og.pA().Og();
                int iPA = com.bytedance.sdk.openadsdk.SD.Og.pA().pA(this.agB, this.Bf);
                this.YkC = iPA;
                this.dC = iPA > 0 ? 2 : 0;
            }
            if (stringExtra2 != null) {
                try {
                    this.CIG = com.bytedance.sdk.openadsdk.multipro.Og.pA.pA(new JSONObject(stringExtra2));
                } catch (Exception unused4) {
                }
                com.bytedance.sdk.openadsdk.multipro.Og.pA pAVar = this.CIG;
                if (pAVar != null) {
                    this.DX = pAVar.SD;
                }
            }
            if (bundle != null) {
                String string = bundle.getString("material_meta");
                if (this.oX == null) {
                    try {
                        this.oX = com.bytedance.sdk.openadsdk.core.Og.pA(new JSONObject(string));
                    } catch (Throwable unused5) {
                    }
                }
                long j = bundle.getLong("video_play_position");
                if (j > 0) {
                    this.DX = j;
                }
            }
            KZx();
            Bzk();
            Wx();
            pA(4);
            if (this.pA != null) {
                com.bytedance.sdk.openadsdk.core.widget.pA.KZx.pA(this.ML).pA(true).Og(false).pA(this.pA.getWebView());
                BSW bswPA = new BSW(this.oX, this.pA.getWebView(), new SGo() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.1
                    @Override // com.bytedance.sdk.openadsdk.ZZv.SGo
                    public void pA(int i) {
                        com.bytedance.sdk.openadsdk.ZZv.KZx.pA.pA(TTVideoLandingPageActivity.this.YkC, TTVideoLandingPageActivity.this.fJy.get(), TTVideoLandingPageActivity.this.dmv.get(), TTVideoLandingPageActivity.this.fN.get() - TTVideoLandingPageActivity.this.dmv.get(), TTVideoLandingPageActivity.this.oX, "landingpage_split_screen", i);
                    }
                }, this.dC).pA(true);
                this.SzT = bswPA;
                this.HSv = bswPA.pA;
                this.SzT.pA("landingpage_split_screen");
            }
            com.bytedance.sdk.component.Bzk.ZZv zZv = this.pA;
            if (zZv != null) {
                zZv.setLandingPage(true);
                this.pA.setTag("landingpage_split_screen");
                this.pA.setMaterialMeta(this.oX.BDQ());
                this.pA.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.pA.ML(this.ML, this.SGo, this.omh, this.SzT, true) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.4
                    @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                    public void onLoadResource(WebView view, String url) {
                        super.onLoadResource(view, url);
                        CreativeInfoManager.onResourceLoaded(h.u, view, url);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                    public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);
                        BrandSafetyUtils.onWebViewPageFinished(h.u, view, url);
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
                        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTVideoLandingPageActivity$4;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;");
                        return CreativeInfoManager.onWebViewResponse(h.u, webView, str, safedk_TTVideoLandingPageActivity$4_shouldInterceptRequest_70bacd8d18e5c7fb197b2b534026d60a(webView, str));
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        boolean zShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(view, url);
                        BrandSafetyUtils.onShouldOverrideUrlLoading(h.u, view, url, zShouldOverrideUrlLoading);
                        return zShouldOverrideUrlLoading;
                    }

                    public WebResourceResponse safedk_TTVideoLandingPageActivity$4_shouldInterceptRequest_70bacd8d18e5c7fb197b2b534026d60a(WebView p0, String p1) {
                        try {
                            if (!TextUtils.isEmpty(TTVideoLandingPageActivity.this.Bf)) {
                                TTVideoLandingPageActivity.this.fN.incrementAndGet();
                                WebResourceResponseModel webResourceResponseModelPA = com.bytedance.sdk.openadsdk.SD.Og.pA().pA(TTVideoLandingPageActivity.this.agB, TTVideoLandingPageActivity.this.Bf, p1);
                                if (webResourceResponseModelPA != null && webResourceResponseModelPA.getWebResourceResponse() != null) {
                                    TTVideoLandingPageActivity.this.dmv.incrementAndGet();
                                    return webResourceResponseModelPA.getWebResourceResponse();
                                }
                                if (webResourceResponseModelPA != null && webResourceResponseModelPA.getMsg() == 2) {
                                    TTVideoLandingPageActivity.this.fJy.incrementAndGet();
                                }
                                return super.shouldInterceptRequest(p0, p1);
                            }
                            return super.shouldInterceptRequest(p0, p1);
                        } catch (Throwable th) {
                            WV.pA("TTVideoLandingPage", "shouldInterceptRequest url error", th);
                            return super.shouldInterceptRequest(p0, p1);
                        }
                    }
                });
                com.bytedance.sdk.component.Bzk.ZZv zZv2 = this.pA;
                zZv2.setUserAgentString(com.bytedance.sdk.openadsdk.utils.aBv.pA(zZv2.getWebView(), this.JG));
            }
            com.bytedance.sdk.component.Bzk.ZZv zZv3 = this.pA;
            if (zZv3 != null) {
                zZv3.setMixedContentMode(0);
            }
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.oX, "landingpage_split_screen", this.dC);
            com.bytedance.sdk.openadsdk.utils.yFO.pA(this.pA, this.gbA);
            this.pA.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.pA.ZZv(this.SGo, this.SzT) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.5
                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ZZv, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                }
            });
            this.pA.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.6
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                    if (TTVideoLandingPageActivity.this.Mc != null) {
                        TTVideoLandingPageActivity.this.Mc.ZZv();
                    }
                }
            });
            TextView textView = this.ZZv;
            if (textView != null) {
                if (TextUtils.isEmpty(stringExtra)) {
                    stringExtra = com.bytedance.sdk.component.utils.yFO.pA(this, "tt_web_title_default");
                }
                textView.setText(stringExtra);
            }
            SGo();
            ZZv();
            WV();
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA.pA(SystemClock.elapsedRealtime() - jElapsedRealtime, this.oX, "landingpage_split_screen", this.agB, this.Bf);
        } catch (Throwable unused6) {
            finish();
        }
    }

    private void WV() {
        yFO yfo = this.oX;
        if (yfo == null || yfo.JBA() != 4) {
            return;
        }
        this.eG.setVisibility(0);
        Button button = (Button) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.sk);
        this.roi = button;
        if (button != null) {
            pA(Og());
            this.roi.setOnClickListener(this.JBA);
            this.roi.setOnTouchListener(this.JBA);
        }
    }

    protected String Og() {
        yFO yfo = this.oX;
        if (yfo != null && !TextUtils.isEmpty(yfo.gy())) {
            this.Sd = this.oX.gy();
        }
        return this.Sd;
    }

    private void pA(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.roi) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.7
            @Override // java.lang.Runnable
            public void run() {
                if (TTVideoLandingPageActivity.this.roi == null || TTVideoLandingPageActivity.this.isFinishing()) {
                    return;
                }
                TTVideoLandingPageActivity.this.roi.setText(str);
            }
        });
    }

    protected void KZx() {
        this.eG = (Sn) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.vA);
        this.pA = (com.bytedance.sdk.component.Bzk.ZZv) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.JBA);
        ImageView imageView = (ImageView) findViewById(520093720);
        this.Og = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTVideoLandingPageActivity$8;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_TTVideoLandingPageActivity$8_onClick_8becff8855aaffa33f686ea19bcfc1c9(view);
                }

                public void safedk_TTVideoLandingPageActivity$8_onClick_8becff8855aaffa33f686ea19bcfc1c9(View p0) {
                    View p1 = TTVideoLandingPageActivity.this.pA;
                    if (p1 != null) {
                        if (TTVideoLandingPageActivity.this.HSv != null) {
                            TTVideoLandingPageActivity.this.HSv.pA();
                        }
                        if (!TTVideoLandingPageActivity.this.pA.ML()) {
                            if (TTVideoLandingPageActivity.this.aBv()) {
                                TTVideoLandingPageActivity.this.onBackPressed();
                                return;
                            }
                            View p2 = TTVideoLandingPageActivity.this.Sn;
                            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(TTVideoLandingPageActivity.this.oX, "embeded_ad", "detail_back", TTVideoLandingPageActivity.this.JG(), TTVideoLandingPageActivity.this.SD(), (p2 == null || TTVideoLandingPageActivity.this.Sn.getNativeVideoController() == null) ? null : gbA.pA(TTVideoLandingPageActivity.this.oX, TTVideoLandingPageActivity.this.Sn.getNativeVideoController().JG(), TTVideoLandingPageActivity.this.Sn.getNativeVideoController().WV()), (SD) null);
                            TTVideoLandingPageActivity.this.finish();
                            return;
                        }
                        TTVideoLandingPageActivity.this.pA.JG();
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.Wx.Og.JG jg = this.Sn;
        if (jg != null) {
            jg.setIsAutoPlay(this.qmB);
        }
        ImageView imageView2 = (ImageView) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.CIG);
        this.KZx = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTVideoLandingPageActivity$9;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_TTVideoLandingPageActivity$9_onClick_df389c5d78bce6f751d1ca8c5d18117f(view);
                }

                public void safedk_TTVideoLandingPageActivity$9_onClick_df389c5d78bce6f751d1ca8c5d18117f(View p0) {
                    View p1 = TTVideoLandingPageActivity.this.Sn;
                    if (p1 != null) {
                        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(TTVideoLandingPageActivity.this.oX, "embeded_ad", "detail_skip", TTVideoLandingPageActivity.this.JG(), TTVideoLandingPageActivity.this.SD(), TTVideoLandingPageActivity.this.Sn.getNativeVideoController() != null ? gbA.pA(TTVideoLandingPageActivity.this.oX, TTVideoLandingPageActivity.this.Sn.getNativeVideoController().JG(), TTVideoLandingPageActivity.this.Sn.getNativeVideoController().WV()) : null, (SD) null);
                    }
                    TTVideoLandingPageActivity.this.finish();
                }
            });
        }
        this.ZZv = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.Ld);
        this.WV = (FrameLayout) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.Vgu);
        this.TX = (RelativeLayout) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.SzT);
        this.BF = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.Gx);
        this.TV = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.Bf);
        this.du = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.HSv);
        this.WQf = (com.bytedance.sdk.openadsdk.core.widget.pA) findViewById(com.bytedance.sdk.openadsdk.utils.Sn.FQ);
        omh();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        WV();
    }

    protected void ZZv() {
        if (ML()) {
            try {
                com.bytedance.sdk.openadsdk.core.Wx.Og.JG jg = new com.bytedance.sdk.openadsdk.core.Wx.Og.JG(this.ML, this.oX, true, null);
                this.Sn = jg;
                if (jg.getNativeVideoController() != null) {
                    this.Sn.getNativeVideoController().pA(false);
                }
                if (this.rB) {
                    this.WV.setVisibility(0);
                    this.WV.removeAllViews();
                    this.WV.addView(this.Sn);
                    this.Sn.Og(true);
                } else {
                    if (!this.qmB) {
                        this.DX = 0L;
                    }
                    if (this.CIG != null && this.Sn.getNativeVideoController() != null) {
                        this.Sn.getNativeVideoController().Og(this.CIG.SD);
                        this.Sn.getNativeVideoController().KZx(this.CIG.ML);
                        this.Sn.setIsQuiet(aBv.ZZv().KZx(String.valueOf(this.oX.Wf())));
                    }
                    if (this.Sn.pA(this.DX, this.xy, this.rB)) {
                        this.WV.setVisibility(0);
                        this.WV.removeAllViews();
                        this.WV.addView(this.Sn);
                    }
                    if (this.Sn.getNativeVideoController() != null) {
                        this.Sn.getNativeVideoController().pA(false);
                        this.Sn.getNativeVideoController().pA(this.IIF);
                    }
                }
                String strPA = this.oX.IIF().get(0).pA();
                com.bytedance.sdk.openadsdk.Bzk.ZZv.pA().pA(strPA).pA(this.oX.IIF().get(0).Og()).Og(this.oX.IIF().get(0).KZx()).ML(Vgu.ZZv(aBv.pA())).ZZv(Vgu.KZx(aBv.pA())).KZx(2).pA(new com.bytedance.sdk.openadsdk.Bzk.Og(this.oX, strPA, new oX<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.10
                    @Override // com.bytedance.sdk.component.ML.oX
                    public void pA(int i, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.ML.oX
                    public void pA(com.bytedance.sdk.component.ML.BSW<Bitmap> bsw) {
                        try {
                            new pA(bsw.Og(), TTVideoLandingPageActivity.this.Sn.getNativeVideoController().Wx()).execute(new Void[0]);
                        } catch (Exception unused) {
                        }
                    }
                }), 4);
                this.Sn.findViewById(520093726).setOnTouchListener(null);
                this.Sn.findViewById(520093726).setOnClickListener(null);
            } catch (Exception e) {
                WV.pA("TTVideoLandingPage", e.getMessage());
                if (this.Sn == null) {
                    ApmHelper.reportCustomError("mNativeVideoTsView is null", "FUNCTION EXCEPTION", e);
                }
            }
            if (this.Vgu == 0) {
                try {
                    Toast.makeText(this, com.bytedance.sdk.component.utils.yFO.pA(this, "tt_no_network"), 0).show();
                } catch (Throwable unused) {
                }
            }
        }
    }

    protected long JG() {
        com.bytedance.sdk.openadsdk.core.Wx.Og.JG jg = this.Sn;
        if (jg == null || jg.getNativeVideoController() == null) {
            return 0L;
        }
        return this.Sn.getNativeVideoController().omh();
    }

    protected int SD() {
        com.bytedance.sdk.openadsdk.core.Wx.Og.JG jg = this.Sn;
        if (jg == null || jg.getNativeVideoController() == null) {
            return 0;
        }
        return this.Sn.getNativeVideoController().SGo();
    }

    protected void omh() {
        String strHSv;
        yFO yfo = this.oX;
        if (yfo == null || yfo.JBA() != 4) {
            return;
        }
        Vgu.pA((View) this.TX, 0);
        if (!TextUtils.isEmpty(this.oX.SXO())) {
            strHSv = this.oX.SXO();
        } else if (!TextUtils.isEmpty(this.oX.fw())) {
            strHSv = this.oX.fw();
        } else if (TextUtils.isEmpty(this.oX.HSv())) {
            strHSv = "";
        } else {
            strHSv = this.oX.HSv();
        }
        if (this.oX.fJy() != null && this.oX.fJy().pA() != null) {
            Vgu.pA((View) this.WQf, 0);
            Vgu.pA((View) this.BF, 4);
            com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.oX.fJy(), this.WQf, this.oX);
        } else if (!TextUtils.isEmpty(strHSv)) {
            Vgu.pA((View) this.WQf, 4);
            Vgu.pA((View) this.BF, 0);
            this.BF.setText(strHSv.substring(0, 1));
        }
        if (!TextUtils.isEmpty(this.oX.gy())) {
            this.du.setText(this.oX.gy());
        }
        if (!TextUtils.isEmpty(strHSv)) {
            this.TV.setText(strHSv);
        }
        Vgu.pA((View) this.TV, 0);
        Vgu.pA((View) this.du, 0);
    }

    public void Bzk() {
        yFO yfo = this.oX;
        if (yfo == null) {
            return;
        }
        this.Mc = com.bytedance.sdk.openadsdk.XT.pA.pA.SD.pA(this, yfo, this.lT);
        com.bytedance.sdk.openadsdk.core.Og.pA pAVar = new com.bytedance.sdk.openadsdk.core.Og.pA(this, this.oX, this.lT, this.BSW);
        this.JBA = pAVar;
        pAVar.pA(false);
        this.JBA.KZx(true);
        this.du.setOnClickListener(this.JBA);
        this.du.setOnTouchListener(this.JBA);
        this.JBA.pA(this.Mc);
    }

    private void Wx() {
        IG ig = new IG(this);
        this.SGo = ig;
        ig.Og(this.pA).KZx(this.omh).ZZv(this.Bzk).Og(this.BSW).pA(this.oX).pA(this.oX.Vgu()).pA(this.pA).Og("landingpage_split_screen").ML(this.oX.jK());
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.bytedance.sdk.openadsdk.core.Wx.Og.JG jg;
        if (this.IG && (jg = this.Sn) != null && jg.getNativeVideoController() != null) {
            ((com.bykv.vk.openvk.pA.pA.pA.ZZv.pA) this.Sn.getNativeVideoController()).ML(null, null);
            this.IG = false;
        } else if (aBv() && !this.FQ.getAndSet(true)) {
            XT();
            pA(0);
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        yFO yfo = this.oX;
        bundle.putString("material_meta", yfo != null ? yfo.jO().toString() : null);
        bundle.putLong("video_play_position", this.DX);
        bundle.putBoolean("is_complete", this.rB);
        long jML = this.DX;
        com.bytedance.sdk.openadsdk.core.Wx.Og.JG jg = this.Sn;
        if (jg != null && jg.getNativeVideoController() != null) {
            jML = this.Sn.getNativeVideoController().ML();
        }
        bundle.putLong("video_play_position", jML);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!this.xy) {
            Sn();
        }
        this.xy = false;
        IG ig = this.SGo;
        if (ig != null) {
            ig.SGo();
        }
        BSW bsw = this.SzT;
        if (bsw != null) {
            bsw.SD();
        }
    }

    private void Sn() {
        com.bytedance.sdk.openadsdk.core.Wx.Og.JG jg = this.Sn;
        if (jg == null || jg.getNativeVideoController() == null || oX()) {
            return;
        }
        this.Sn.Wx();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        DX();
        com.bytedance.sdk.openadsdk.core.Wx.Og.JG jg = this.Sn;
        if (jg == null || jg.getNativeVideoController() == null) {
            return;
        }
        pA(this.Sn.getNativeVideoController());
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        BSW bsw = this.SzT;
        if (bsw != null) {
            bsw.omh();
        }
    }

    private void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx) {
        this.rB = this.rB || kZx.DX();
        com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.TRUE);
        com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_native_video_data", "key_video_isfromvideodetailpage", Boolean.TRUE);
        com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_native_video_data", "key_native_video_complete", Boolean.valueOf(this.rB));
        com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_native_video_data", "key_video_current_play_position", Long.valueOf(kZx.ML()));
        com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_native_video_data", "key_video_total_play_duration", Long.valueOf(kZx.omh() + kZx.JG()));
        com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_native_video_data", "key_video_duration", Long.valueOf(kZx.omh()));
    }

    private void DX() {
        if (this.Sn == null || oX()) {
            return;
        }
        this.Sn.Wx();
    }

    private boolean oX() {
        com.bytedance.sdk.openadsdk.core.Wx.Og.JG jg = this.Sn;
        if (jg == null || jg.getNativeVideoController() == null) {
            return true;
        }
        return this.Sn.getNativeVideoController().DX();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BSW();
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
            this.oX.JG(false);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.component.Bzk.ZZv zZv = this.pA;
        if (zZv != null) {
            com.bytedance.sdk.openadsdk.core.xy.pA(zZv.getWebView());
        }
        this.pA = null;
        IG ig = this.SGo;
        if (ig != null) {
            ig.BSW();
        }
        com.bytedance.sdk.openadsdk.core.Wx.Og.JG jg = this.Sn;
        if (jg != null && jg.getNativeVideoController() != null) {
            this.Sn.getNativeVideoController().ZZv();
        }
        this.Sn = null;
        this.oX = null;
        BSW bsw = this.SzT;
        if (bsw != null) {
            bsw.KZx(true);
        }
        if (!TextUtils.isEmpty(this.Bf)) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA.pA(this.dmv.get(), this.fN.get(), this.oX);
        }
        com.bytedance.sdk.openadsdk.SD.Og.pA().pA(this.agB);
    }

    protected void SGo() {
        BF.pA(this.vA, this.ML);
    }

    protected void BSW() {
        try {
            BF.pA(this.vA);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBv() {
        return !TextUtils.isEmpty(this.gbA) && this.gbA.contains("__luban_sdk");
    }

    private void pA(final int i) {
        if (this.KZx == null || !aBv()) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.3
            @Override // java.lang.Runnable
            public void run() {
                Vgu.pA((View) TTVideoLandingPageActivity.this.KZx, i);
            }
        });
    }

    private void XT() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", true);
            this.SGo.pA("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.SGo.ZZv
    public void pA(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.Gx = jSONArray;
    }

    private static class pA extends AsyncTask<Void, Void, Drawable> {
        private final WeakReference<com.bykv.vk.openvk.pA.pA.pA.ZZv.Og> Og;
        private final Bitmap pA;

        private pA(Bitmap bitmap, com.bykv.vk.openvk.pA.pA.pA.ZZv.Og og) {
            this.pA = bitmap;
            this.Og = new WeakReference<>(og);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public Drawable doInBackground(Void... voidArr) {
            try {
                Bitmap bitmapPA = com.bytedance.sdk.component.adexpress.ZZv.pA.pA(aBv.pA(), this.pA, 25);
                if (bitmapPA == null) {
                    return null;
                }
                return new BitmapDrawable(aBv.pA().getResources(), bitmapPA);
            } catch (Throwable th) {
                WV.pA("TTVideoLandingPage", th.getMessage());
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Drawable drawable) {
            WeakReference<com.bykv.vk.openvk.pA.pA.pA.ZZv.Og> weakReference;
            if (drawable == null || (weakReference = this.Og) == null || weakReference.get() == null) {
                return;
            }
            this.Og.get().pA(drawable);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        com.bytedance.sdk.openadsdk.utils.KZx.pA(this, this.oX);
    }
}
