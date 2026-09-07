package com.bytedance.sdk.openadsdk.core.model;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity;
import com.bytedance.sdk.openadsdk.core.IG;
import com.bytedance.sdk.openadsdk.core.xy;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import com.safedk.android.utils.n;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class aBv implements Handler.Callback {
    private com.bytedance.sdk.component.Bzk.ZZv BF;
    ObjectAnimator BSW;
    private com.bytedance.sdk.openadsdk.core.widget.pA.ML Bf;
    ObjectAnimator Bzk;
    private com.bytedance.sdk.openadsdk.ZZv.BSW CIG;
    private Handler DX;
    private boolean Gx;
    private String HSv;
    private com.bytedance.sdk.openadsdk.core.ML.ZZv IIF;
    private ILoader JBA;
    RelativeLayout JG;
    TextView KZx;
    View ML;
    private long Mc;
    FrameLayout Og;
    private FrameLayout PV;
    final yFO SD;
    ValueAnimator SGo;
    private com.bytedance.sdk.openadsdk.core.widget.aBv SXO;
    private TextView Sd;
    com.bytedance.sdk.openadsdk.core.Og.Og Sn;
    private boolean SzT;
    private com.bytedance.sdk.openadsdk.common.WV TV;
    private IG TX;
    private com.bytedance.sdk.openadsdk.XT.pA.pA.JG Vgu;
    private FrameLayout WQf;
    com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA WV;
    com.bytedance.sdk.openadsdk.core.Og.pA Wx;
    private TextView XT;
    private int YkC;
    FrameLayout ZZv;
    private View aBv;
    private com.bytedance.sdk.openadsdk.common.ZZv dC;
    private View du;
    private ImageView eG;
    private int fJy;
    private com.bytedance.sdk.openadsdk.core.ML.omh fw;
    private int gbA;
    private LinearLayout.LayoutParams gy;
    private final Activity lT;
    private AtomicBoolean lx;
    private View oX;
    FrameLayout omh;
    ImageView pA;
    private final View qmB;
    private String rB;
    private View roi;
    private com.bytedance.sdk.openadsdk.core.omh.yFO vA;
    private com.bytedance.sdk.openadsdk.core.widget.aBv vZF;
    private final com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og xy;
    private TextView yFO;
    private final AtomicBoolean IG = new AtomicBoolean(false);
    private final AtomicBoolean FQ = new AtomicBoolean(false);
    private volatile int agB = 0;
    private volatile int fN = 0;
    private volatile int dmv = 0;
    private float cFQ = -1.0f;
    private final AtomicBoolean nCO = new AtomicBoolean(false);
    private long bU = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Og(int i) {
        return i == 1 || i == 2 || i == 4 || i == 5;
    }

    static /* synthetic */ int BSW(aBv abv) {
        int i = abv.agB;
        abv.agB = i + 1;
        return i;
    }

    static /* synthetic */ int Sn(aBv abv) {
        int i = abv.dmv;
        abv.dmv = i + 1;
        return i;
    }

    static /* synthetic */ int Wx(aBv abv) {
        int i = abv.fN;
        abv.fN = i + 1;
        return i;
    }

    public aBv(Activity activity, final yFO yfo, String str, FrameLayout frameLayout, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og og, View view) {
        this.lT = activity;
        this.SD = yfo;
        this.rB = str;
        this.xy = og;
        this.qmB = view;
        this.gbA = gbA.pA(str);
        if (yfo != null) {
            this.HSv = yfo.Gag();
        }
        if (!TextUtils.isEmpty(this.HSv)) {
            this.JBA = com.bytedance.sdk.openadsdk.SD.Og.pA().Og();
            int iPA = com.bytedance.sdk.openadsdk.SD.Og.pA().pA(this.JBA, this.HSv);
            this.fJy = iPA;
            this.YkC = iPA > 0 ? 2 : 0;
        }
        boolean zZZv = ZZv(yfo);
        boolean zML = ML(yfo);
        if (Og(yfo)) {
            this.rB = "landingpage_split_screen";
        } else if (zZZv) {
            this.rB = "landingpage_direct";
        } else if (zML) {
            this.rB = "aggregate_page";
        } else if (KZx(yfo)) {
            this.rB = "landingpage_split_ceiling";
        }
        this.Wx = new com.bytedance.sdk.openadsdk.core.Og.pA(com.bytedance.sdk.openadsdk.core.aBv.pA(), yfo, this.rB, gbA.pA(str));
        HashMap map = new HashMap();
        map.put("click_scence", 1);
        this.Wx.pA(map);
        View viewFindViewById = activity.findViewById(R.id.content);
        this.Wx.pA(viewFindViewById);
        com.bytedance.sdk.openadsdk.core.Og.Og og2 = new com.bytedance.sdk.openadsdk.core.Og.Og(activity, yfo, this.rB, gbA.pA(str), true) { // from class: com.bytedance.sdk.openadsdk.core.model.aBv.1
            @Override // com.bytedance.sdk.openadsdk.core.Og.Og
            public boolean pA(SGo sGo, Map<String, Object> map2) {
                if (aBv.omh(yfo) && aBv.this.Bf != null) {
                    aBv.this.Bf.pA(sGo);
                    aBv.this.Bf.pA(map2);
                    if (aBv.SD(aBv.this.SD) || aBv.this.Gx) {
                        return true;
                    }
                }
                return super.pA(sGo, map2);
            }
        };
        this.Sn = og2;
        og2.pA(map);
        this.Sn.pA(viewFindViewById);
        this.omh = frameLayout;
        if (zZZv || zML) {
            try {
                Handler handler = new Handler(Looper.getMainLooper(), this);
                this.DX = handler;
                handler.sendMessage(handler.obtainMessage(100, 0, 0));
            } catch (Exception e) {
                Log.e("LandingPageModel", "LandingPageModel: ", e);
            }
        }
    }

    public void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA pAVar) {
        this.WV = pAVar;
    }

    public void pA() {
        long jPA;
        View view;
        Long lValueOf = Long.valueOf(SystemClock.elapsedRealtime());
        com.bytedance.sdk.component.Bzk.ZZv zZv = (com.bytedance.sdk.component.Bzk.ZZv) this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.Sd);
        this.BF = zZv;
        if (zZv != null && !yFO.pA(this.SD)) {
            this.BF.f_();
        } else {
            Vgu.pA((View) this.BF, 8);
        }
        this.WQf = (FrameLayout) this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.vZF);
        this.TV = (com.bytedance.sdk.openadsdk.common.WV) this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.TV);
        this.du = this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.TX);
        this.eG = (ImageView) this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.BF);
        this.roi = this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.xy);
        this.Og = (FrameLayout) this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.XT);
        this.pA = (ImageView) this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.yFO);
        this.JG = (RelativeLayout) this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.WQf);
        this.KZx = (TextView) this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.eUc);
        this.ZZv = (FrameLayout) this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.SGo);
        View viewFindViewById = this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.du);
        this.oX = viewFindViewById;
        if (viewFindViewById == null) {
            this.oX = this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.gbA);
        }
        this.aBv = this.lT.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.eG);
        this.XT = (TextView) this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.Mc);
        this.yFO = (TextView) this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.IG);
        this.vZF = (com.bytedance.sdk.openadsdk.core.widget.aBv) this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.roi);
        this.Sd = (TextView) this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.lT);
        if (this.KZx != null && this.SD.Bzk() != null) {
            this.KZx.setText(this.SD.Bzk().ML());
        }
        this.ML = this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.rB);
        this.IIF = (com.bytedance.sdk.openadsdk.core.ML.ZZv) this.qmB.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.LAE);
        if ((ZZv(this.SD) || Og(this.SD) || ML(this.SD) || KZx(this.SD)) && this.SD.Bzk() != null) {
            View view2 = this.ML;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (ML(this.SD)) {
                jPA = this.SD.Bzk().KZx();
            } else {
                jPA = this.SD.Bzk().pA();
            }
            com.bytedance.sdk.openadsdk.core.Sn.KZx().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.model.aBv.9
                @Override // java.lang.Runnable
                public void run() {
                    if (aBv.this.IG.get()) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA(aBv.this.SD, aBv.this.rB, System.currentTimeMillis() - aBv.this.Mc, false);
                    aBv.this.Sn();
                }
            }, jPA * 1000);
        }
        SGo();
        if (Og(this.SD)) {
            aBv();
            if (!ZZv()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.WQf.getLayoutParams();
                layoutParams.weight = 2.33f;
                this.WQf.setLayoutParams(layoutParams);
            }
        }
        if ((ZZv(this.SD) || ML(this.SD)) && (view = this.roi) != null) {
            view.setVisibility(8);
        }
        com.bytedance.sdk.openadsdk.common.WV wv = this.TV;
        if (wv != null) {
            wv.pA(this.SD);
        }
        if (KZx(this.SD)) {
            oX();
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA.pA(SystemClock.elapsedRealtime() - lValueOf.longValue(), this.SD, this.rB, this.JBA, this.HSv);
    }

    private void SGo() {
        com.bytedance.sdk.openadsdk.common.WV wv;
        com.bytedance.sdk.component.Bzk.ZZv zZv = this.BF;
        if (zZv != null && zZv.getWebView() != null) {
            com.bytedance.sdk.openadsdk.core.widget.pA.KZx.pA(com.bytedance.sdk.openadsdk.core.aBv.pA()).pA(false).Og(false).pA(this.BF.getWebView());
            com.bytedance.sdk.component.Bzk.ZZv zZv2 = this.BF;
            if (zZv2 != null && zZv2.getWebView() != null) {
                com.bytedance.sdk.openadsdk.ZZv.BSW bswPA = new com.bytedance.sdk.openadsdk.ZZv.BSW(this.SD, this.BF.getWebView(), new Og(this.fJy, this.SD, this.rB, this), this.YkC).pA(true);
                this.CIG = bswPA;
                bswPA.pA(this.rB);
                com.bytedance.sdk.openadsdk.common.ZZv zZvPA = gbA.pA(this.SD, this.BF, this.lT, this.rB);
                this.dC = zZvPA;
                if (zZvPA != null) {
                    zZvPA.pA(this.rB);
                }
                gbA.pA(this.SD, this.BF);
            }
            BSW();
            this.BF.setLandingPage(true);
            this.BF.setTag(this.rB);
            this.BF.setMaterialMeta(this.SD.BDQ());
            com.bytedance.sdk.openadsdk.core.widget.pA.ML ml = new com.bytedance.sdk.openadsdk.core.widget.pA.ML(com.bytedance.sdk.openadsdk.core.aBv.pA(), this.TX, this.SD.nCO(), this.dC, this.CIG, true) { // from class: com.bytedance.sdk.openadsdk.core.model.aBv.10
                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                public void onLoadResource(WebView view, String url) {
                    super.onLoadResource(view, url);
                    CreativeInfoManager.onResourceLoaded(h.u, view, url);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/model/aBv$10;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
                    BrandSafetyUtils.onWebViewPageFinished(h.u, webView, str);
                    safedk_aBv$10_onPageFinished_4ac7b3660e33b65d7110904b900ec8bc(webView, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/model/aBv$10;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
                    BrandSafetyUtils.onWebViewPageStarted(h.u, webView, str);
                    safedk_aBv$10_onPageStarted_df5c38f58360791b09912fa0baffc4c4(webView, str, bitmap);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/model/aBv$10;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
                    BrandSafetyUtils.onWebViewReceivedError(h.u, webView, i, str, str2);
                    safedk_aBv$10_onReceivedError_3c99e91753b8e8fc738d2d33ccd5106d(webView, i, str, str2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/model/aBv$10;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;");
                    return CreativeInfoManager.onWebViewResponse(h.u, webView, str, safedk_aBv$10_shouldInterceptRequest_6b068fdb7ff65bc069a187fdc76fd0d6(webView, str));
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/model/aBv$10;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
                    boolean zSafedk_aBv$10_shouldOverrideUrlLoading_814fe54ed88a041bf4815898d8d580b9 = safedk_aBv$10_shouldOverrideUrlLoading_814fe54ed88a041bf4815898d8d580b9(webView, str);
                    BrandSafetyUtils.onShouldOverrideUrlLoading(h.u, webView, str, zSafedk_aBv$10_shouldOverrideUrlLoading_814fe54ed88a041bf4815898d8d580b9);
                    return zSafedk_aBv$10_shouldOverrideUrlLoading_814fe54ed88a041bf4815898d8d580b9;
                }

                public boolean safedk_aBv$10_shouldOverrideUrlLoading_814fe54ed88a041bf4815898d8d580b9(WebView p0, String p1) {
                    if (aBv.KZx(aBv.this.SD) && gbA.pA(p0) == 1) {
                        Intent intent = new Intent(aBv.this.lT, (Class<?>) TTCeilingLandingPageActivity.class);
                        intent.putExtra("second_url", p1);
                        com.bytedance.sdk.openadsdk.core.TV.pA().JG();
                        com.bytedance.sdk.openadsdk.core.TV.pA().pA(aBv.this.SD);
                        com.bytedance.sdk.component.utils.Og.pA(this.ZZv, intent, null);
                        return true;
                    }
                    return super.shouldOverrideUrlLoading(p0, p1);
                }

                public void safedk_aBv$10_onPageFinished_4ac7b3660e33b65d7110904b900ec8bc(WebView p0, String p1) {
                    super.onPageFinished(p0, p1);
                    aBv.this.WV();
                }

                public void safedk_aBv$10_onPageStarted_df5c38f58360791b09912fa0baffc4c4(WebView p0, String p1, Bitmap p2) {
                    super.onPageStarted(p0, p1, p2);
                    aBv.this.xy.BSW();
                    aBv.this.Mc = System.currentTimeMillis();
                }

                public void safedk_aBv$10_onReceivedError_3c99e91753b8e8fc738d2d33ccd5106d(WebView p0, int p1, String p2, String p3) {
                    super.onReceivedError(p0, p1, p2, p3);
                    String strZZv = ZZv(p3);
                    if (this.JG != null) {
                        this.JG.pA(p0, p1, p2, p3, ZZv(p3), (p0 == null || p3 == null || !p3.equals(p0.getUrl())) ? false : true);
                    }
                    boolean z = strZZv != null && strZZv.startsWith("image");
                    boolean z2 = strZZv != null && strZZv.startsWith(n.d);
                    if (z || z2 || aBv.this.IG.get()) {
                        return;
                    }
                    aBv.this.Sn();
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, android.webkit.WebViewClient
                public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    if (sslErrorHandler != null) {
                        aBv.this.Sn();
                    }
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                }

                public WebResourceResponse safedk_aBv$10_shouldInterceptRequest_6b068fdb7ff65bc069a187fdc76fd0d6(WebView p0, String p1) {
                    try {
                        if (TextUtils.isEmpty(aBv.this.HSv)) {
                            return super.shouldInterceptRequest(p0, p1);
                        }
                        aBv.BSW(aBv.this);
                        WebResourceResponseModel webResourceResponseModelPA = com.bytedance.sdk.openadsdk.SD.Og.pA().pA(aBv.this.JBA, aBv.this.HSv, p1);
                        if (webResourceResponseModelPA != null && webResourceResponseModelPA.getWebResourceResponse() != null) {
                            aBv.Wx(aBv.this);
                            return webResourceResponseModelPA.getWebResourceResponse();
                        }
                        if (webResourceResponseModelPA != null && webResourceResponseModelPA.getMsg() == 2) {
                            aBv.Sn(aBv.this);
                        }
                        return super.shouldInterceptRequest(p0, p1);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.WV.pA("LandingPageModel", "shouldInterceptRequest url error", th);
                        return super.shouldInterceptRequest(p0, p1);
                    }
                }
            };
            this.Bf = ml;
            this.BF.setWebViewClient(ml);
            this.Bf.pA(this.SD);
            this.Bf.pA(this.rB);
            this.BF.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.pA.ZZv(this.TX, this.CIG, this.dC) { // from class: com.bytedance.sdk.openadsdk.core.model.aBv.11
                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ZZv, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    if (aBv.this.lT != null && !aBv.this.lT.isFinishing() && i == 100) {
                        aBv.this.WV();
                    }
                    if (aBv.this.TV != null) {
                        aBv.this.TV.pA(i);
                    }
                }
            });
            if (this.Vgu == null) {
                this.Vgu = com.bytedance.sdk.openadsdk.XT.pA.pA.SD.pA(com.bytedance.sdk.openadsdk.core.aBv.pA(), this.SD, this.rB);
            }
            this.BF.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.model.aBv.12
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (aBv.this.Vgu != null) {
                        aBv.this.Vgu.ZZv();
                    }
                }
            });
            com.bytedance.sdk.component.Bzk.ZZv zZv3 = this.BF;
            zZv3.setUserAgentString(com.bytedance.sdk.openadsdk.utils.aBv.pA(zZv3.getWebView(), BuildConfig.VERSION_CODE));
            this.BF.setMixedContentMode(0);
            this.BF.getWebView().setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.model.aBv.13
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    if (aBv.this.CIG != null) {
                        aBv.this.CIG.Og(i2);
                    }
                }
            });
            this.BF.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.model.aBv.14
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/model/aBv$14;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                    CreativeInfoManager.onViewTouched(h.u, view, motionEvent);
                    return safedk_aBv$14_onTouch_28d35abb90bb0b75fbafe57abb8b2b52(view, motionEvent);
                }

                public boolean safedk_aBv$14_onTouch_28d35abb90bb0b75fbafe57abb8b2b52(View p0, MotionEvent p1) {
                    if (aBv.this.Bzk()) {
                        int action = p1.getAction();
                        if (action == 0) {
                            aBv.this.cFQ = p1.getY();
                        } else if (action == 1) {
                            if (Vgu.pA(aBv.this.cFQ, p1.getY(), aBv.this.lT)) {
                                aBv.this.pA(5);
                            }
                        } else if (action == 2) {
                            p1.setAction(3);
                        }
                    }
                    if ((!aBv.this.Gx || aBv.omh(aBv.this.SD)) && !aBv.ML(aBv.this.SD)) {
                        aBv.this.Sn.onTouch(p0, p1);
                    }
                    if ((!aBv.this.Gx || aBv.omh(aBv.this.SD)) && !aBv.ML(aBv.this.SD) && p1.getAction() == 1 && aBv.this.Sn.SD()) {
                        aBv.this.BF.getWebView().performClick();
                        aBv.this.Gx = true;
                    }
                    if (aBv.this.CIG != null) {
                        aBv.this.CIG.pA(p1);
                    }
                    if (aBv.this.dC == null) {
                        return false;
                    }
                    aBv.this.dC.pA(p1);
                    return false;
                }
            });
            this.BF.getWebView().setOnClickListener(this.Sn);
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.SD, this.rB, this.YkC);
            com.bytedance.sdk.openadsdk.utils.yFO.pA(this.BF, this.SD.dC());
            this.SzT = true;
        }
        if (this.BF == null || (wv = this.TV) == null) {
            return;
        }
        wv.pA();
    }

    public static class Og implements com.bytedance.sdk.openadsdk.ZZv.SGo {
        private final String KZx;
        private final yFO Og;
        private final WeakReference<aBv> ZZv;
        private final int pA;

        public Og(int i, yFO yfo, String str, aBv abv) {
            this.pA = i;
            this.Og = yfo;
            this.KZx = str;
            this.ZZv = new WeakReference<>(abv);
        }

        @Override // com.bytedance.sdk.openadsdk.ZZv.SGo
        public void pA(int i) {
            aBv abv = this.ZZv.get();
            if (abv != null) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA.pA(this.pA, abv.dmv, abv.fN, abv.agB - abv.fN, this.Og, this.KZx, i);
            }
        }
    }

    private void BSW() {
        IG ig = new IG(this.lT);
        this.TX = ig;
        ig.Og(this.BF).KZx(this.SD.nCO()).ZZv(this.SD.tM()).pA(this.SD).Og(ML(this.SD) ? this.gbA : -1).pA(this.SD.Vgu()).Og(this.rB).ML(this.SD.jK()).pA(this.BF).pA(new com.bytedance.sdk.openadsdk.core.widget.JG() { // from class: com.bytedance.sdk.openadsdk.core.model.aBv.15
            @Override // com.bytedance.sdk.openadsdk.core.widget.JG
            public void pA() {
                if (!aBv.ML(aBv.this.SD) || !(aBv.this.lT instanceof com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og)) {
                    if (aBv.this.Bf != null) {
                        aBv.this.Bf.Og();
                        return;
                    }
                    return;
                }
                ((com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og) aBv.this.lT).c_();
            }
        });
    }

    public static boolean pA(yFO yfo) {
        if (yfo == null || Bzk(yfo)) {
            return false;
        }
        return ZZv(yfo) || Og(yfo) || ML(yfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WV() {
        if (this.IG.get() || this.FQ.get()) {
            return;
        }
        this.IG.set(true);
        long jElapsedRealtime = this.bU == -1 ? 0L : SystemClock.elapsedRealtime() - this.bU;
        if (KZx(this.SD)) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(this.SD, this.rB, jElapsedRealtime);
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.SD, this.rB, System.currentTimeMillis() - this.Mc, true);
        Wx();
    }

    private void Wx() {
        this.JG.setVisibility(8);
        if (ZZv(this.SD) || ML(this.SD) || !ZZv() || KZx(this.SD)) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "timeVisible", 0.0f, 1.0f);
        this.BSW = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(100L);
        this.BSW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.model.aBv.16
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aBv.this.WQf.getLayoutParams();
                layoutParams.weight = (float) (((double) ((Float) valueAnimator.getAnimatedValue()).floatValue()) * 0.25d);
                aBv.this.pA((float) (1.0d - (((double) ((Float) valueAnimator.getAnimatedValue()).floatValue()) * 0.2d)));
                aBv.this.WQf.setLayoutParams(layoutParams);
            }
        });
        this.BSW.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sn() {
        LinearLayout.LayoutParams layoutParams;
        if (this.IG.get()) {
            return;
        }
        DX();
        this.FQ.set(true);
        this.xy.omh();
        com.bytedance.sdk.openadsdk.common.WV wv = this.TV;
        if (wv != null) {
            wv.Og();
        }
        if (ML(this.SD)) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(System.currentTimeMillis(), this.SD, this.rB, "show_agg_backup");
            View view = this.aBv;
            if (view != null) {
                view.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aBv.getLayoutParams();
                layoutParams2.addRule(13);
                layoutParams2.addRule(10, 0);
                this.aBv.setLayoutParams(layoutParams2);
                RelativeLayout relativeLayout = this.JG;
                if (relativeLayout != null) {
                    relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.model.aBv.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/model/aBv$2;->onClick(Landroid/view/View;)V");
                            CreativeInfoManager.onViewClicked(h.u, view2);
                            safedk_aBv$2_onClick_035ed76de3aea6b7543959b930dc9d46(view2);
                        }

                        public void safedk_aBv$2_onClick_035ed76de3aea6b7543959b930dc9d46(View p0) {
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        this.oX.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.oX.getLayoutParams();
        layoutParams3.addRule(13);
        layoutParams3.addRule(10, 0);
        this.oX.setLayoutParams(layoutParams3);
        if (this.SD.fJy() != null && !TextUtils.isEmpty(this.SD.fJy().pA())) {
            com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.SD.fJy().pA(), this.SD.fJy().Og(), this.SD.fJy().KZx(), this.vZF, this.SD);
        }
        this.XT.setText(this.SD.HSv());
        this.yFO.setText(this.SD.fw());
        if (this.Sd != null) {
            Og();
            this.Sd.setClickable(true);
            this.Sd.setOnClickListener(this.Wx);
            this.Sd.setOnTouchListener(this.Wx);
        }
        if (!KZx(this.SD) || (layoutParams = this.gy) == null) {
            return;
        }
        if (layoutParams.weight < 30.0f) {
            KZx(8);
        } else {
            KZx(0);
        }
    }

    private void DX() {
        if ((ZZv(this.SD) || ML(this.SD)) && (this.lT instanceof com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og)) {
            this.xy.BSW();
            this.xy.WV();
        }
    }

    protected void Og() {
        yFO yfo = this.SD;
        if (yfo == null || TextUtils.isEmpty(yfo.gy())) {
            return;
        }
        this.Sd.setText(this.SD.gy());
    }

    private void oX() {
        com.bytedance.sdk.openadsdk.common.BSW loadingStyle;
        com.bytedance.sdk.openadsdk.common.WV wv = this.TV;
        if (wv != null && (loadingStyle = wv.getLoadingStyle()) != null) {
            this.SXO = loadingStyle.Og();
            this.fw = loadingStyle.KZx();
        }
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = this.IIF;
        if (zZv != null) {
            zZv.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.model.aBv.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/model/aBv$3;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_aBv$3_onClick_cac17d18c31c3ac65d9add219ccf8e92(view);
                }

                public void safedk_aBv$3_onClick_cac17d18c31c3ac65d9add219ccf8e92(View p0) {
                    if (aBv.this.IIF.getTag() != null) {
                        if (!aBv.this.IIF.getTag().equals(1)) {
                            if (aBv.this.IIF.getTag().equals(2)) {
                                aBv.this.pA(4);
                                return;
                            }
                            return;
                        }
                        aBv.this.pA(3);
                    }
                }
            });
        }
    }

    public void KZx() {
        if (XT()) {
            try {
                String strSGo = this.SD.Bf().SGo();
                com.bytedance.sdk.openadsdk.Bzk.ZZv.pA().pA(strSGo).pA(this.SD.Bf().KZx()).Og(this.SD.Bf().Og()).ML(Vgu.ZZv(com.bytedance.sdk.openadsdk.core.aBv.pA())).ZZv(Vgu.KZx(com.bytedance.sdk.openadsdk.core.aBv.pA())).KZx(2).pA(new pA()).pA(new com.bytedance.sdk.openadsdk.Bzk.Og(this.SD, strSGo, new com.bytedance.sdk.component.ML.oX<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.model.aBv.4
                    @Override // com.bytedance.sdk.component.ML.oX
                    public void pA(int i, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.ML.oX
                    public void pA(com.bytedance.sdk.component.ML.BSW<Bitmap> bsw) {
                        try {
                            Bitmap bitmapOg = bsw.Og();
                            if (bitmapOg != null && bsw.KZx() != null) {
                                BitmapDrawable bitmapDrawable = new BitmapDrawable(com.bytedance.sdk.openadsdk.core.aBv.pA().getResources(), bitmapOg);
                                View viewSGo = aBv.this.xy.SGo();
                                if (viewSGo == null || !(viewSGo.getParent() instanceof View)) {
                                    return;
                                }
                                View view = (View) viewSGo.getParent();
                                view.setBackground(bitmapDrawable);
                            }
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.WV.pA("LandingPageModel", th.getMessage());
                        }
                    }
                }));
            } catch (Exception unused) {
            }
        }
    }

    private void aBv() {
        if (ZZv()) {
            this.du.setVisibility(0);
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.eG, "translationY", 16.0f, 0.0f).setDuration(500L);
            this.Bzk = duration;
            duration.setRepeatMode(2);
            this.Bzk.setRepeatCount(-1);
            this.Bzk.start();
            this.du.setClickable(true);
            this.du.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.model.aBv.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/model/aBv$5;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                    CreativeInfoManager.onViewTouched(h.u, view, motionEvent);
                    return safedk_aBv$5_onTouch_aeb8e39834f52a281d00be11abc2aed3(view, motionEvent);
                }

                public boolean safedk_aBv$5_onTouch_aeb8e39834f52a281d00be11abc2aed3(View p0, MotionEvent p1) {
                    if (!aBv.this.Gx) {
                        aBv.this.Sn.onTouch(p0, p1);
                    }
                    if (p1.getAction() != 3 && p1.getAction() != 1) {
                        return false;
                    }
                    aBv.this.SGo = ObjectAnimator.ofFloat(this, "timeSlide", 0.0f, 1.0f);
                    aBv.this.SGo.setDuration(200L);
                    aBv.this.SGo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.model.aBv.5.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aBv.this.WQf.getLayoutParams();
                            layoutParams.weight = (float) (((double) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 2.07f)) + 0.25d);
                            aBv.this.pA((float) (0.800000011920929d - (((double) ((Float) valueAnimator.getAnimatedValue()).floatValue()) * 0.5d)));
                            aBv.this.WQf.setLayoutParams(layoutParams);
                        }
                    });
                    if (aBv.this.Sn.SD()) {
                        View p2 = aBv.this.du;
                        p2.performClick();
                        aBv.this.Gx = true;
                    }
                    aBv.this.SGo.start();
                    View p3 = aBv.this.du;
                    p3.setVisibility(8);
                    return true;
                }
            });
            this.du.setOnClickListener(this.Sn);
        }
        if (!XT()) {
            this.omh.setVisibility(8);
            this.Og.setVisibility(0);
            this.pA.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.pA.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.model.aBv.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/model/aBv$6;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_aBv$6_onClick_b116794eec10530e85ac99259b5007a4(view);
                }

                public void safedk_aBv$6_onClick_b116794eec10530e85ac99259b5007a4(View p0) {
                    com.bytedance.sdk.openadsdk.ZZv.KZx.Og(aBv.this.SD, aBv.this.rB);
                }
            });
            yFO yfo = this.SD;
            if (yfo != null && yfo.IIF() != null && this.SD.IIF().size() > 0 && this.SD.IIF().get(0) != null && !TextUtils.isEmpty(this.SD.IIF().get(0).pA())) {
                com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.SD.IIF().get(0), this.pA, this.SD);
            }
        }
        try {
            String strPA = this.SD.IIF().get(0).pA();
            com.bytedance.sdk.openadsdk.Bzk.ZZv.pA().pA(strPA).pA(this.SD.IIF().get(0).Og()).Og(this.SD.IIF().get(0).KZx()).ML(Vgu.ZZv(com.bytedance.sdk.openadsdk.core.aBv.pA())).ZZv(Vgu.KZx(com.bytedance.sdk.openadsdk.core.aBv.pA())).KZx(2).pA(new pA()).pA(new com.bytedance.sdk.openadsdk.Bzk.Og(this.SD, strPA, new com.bytedance.sdk.component.ML.oX<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.model.aBv.7
                @Override // com.bytedance.sdk.component.ML.oX
                public void pA(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.ML.oX
                public void pA(com.bytedance.sdk.component.ML.BSW<Bitmap> bsw) {
                    try {
                        Bitmap bitmapOg = bsw.Og();
                        if (bitmapOg != null && bsw.KZx() != null) {
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.bytedance.sdk.openadsdk.core.aBv.pA().getResources(), bitmapOg);
                            if (!aBv.this.XT()) {
                                aBv.this.Og.setBackground(bitmapDrawable);
                                return;
                            }
                            aBv.this.ZZv.setBackground(bitmapDrawable);
                            View viewSGo = aBv.this.xy.SGo();
                            if (viewSGo == null || !(viewSGo.getParent() instanceof View)) {
                                return;
                            }
                            View view = (View) viewSGo.getParent();
                            view.setBackground(bitmapDrawable);
                        }
                    } catch (Exception unused) {
                    }
                }
            }));
        } catch (Exception unused) {
        }
    }

    private static class pA implements com.bytedance.sdk.component.ML.omh {
        @Override // com.bytedance.sdk.component.ML.omh
        public Bitmap pA(Bitmap bitmap) {
            return com.bytedance.sdk.component.adexpress.ZZv.pA.pA(com.bytedance.sdk.openadsdk.core.aBv.pA(), bitmap, 25);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean XT() {
        return yFO.ML(this.SD);
    }

    public boolean ZZv() {
        return this.SD.RS() == 15 || this.SD.RS() == 16;
    }

    public void pA(float f) {
        try {
            this.xy.Bzk();
        } catch (Throwable unused) {
        }
    }

    public static boolean Og(yFO yfo) {
        return yfo != null && yfo.JBA() == 3 && yfo.aBv() == 6 && !WQf.Og(yfo) && yfo.rtW() == 1 && (yfo.slz() == 0.0f || yfo.slz() == 100.0f);
    }

    public static boolean KZx(yFO yfo) {
        return yfo != null && yfo.JBA() == 3 && yfo.XT() == 38 && yfo.rtW() == 1;
    }

    public static boolean ZZv(yFO yfo) {
        if (yfo == null) {
            return false;
        }
        if (Bzk(yfo)) {
            return true;
        }
        return yfo.JBA() == 3 && yfo.aBv() == 5 && !WQf.Og(yfo) && (yfo.slz() == 0.0f || yfo.slz() == 100.0f);
    }

    public static boolean ML(yFO yfo) {
        return yfo != null && yfo.aBv() == 33;
    }

    public static boolean JG(yFO yfo) {
        return ZZv(yfo) && !Bzk(yfo);
    }

    public static boolean SD(yFO yfo) {
        return (yfo == null || yfo.HMH() == 1 || !omh(yfo)) ? false : true;
    }

    public static boolean omh(yFO yfo) {
        if (yfo != null) {
            return yfo.aBv() == 19 || yfo.aBv() == 20;
        }
        return false;
    }

    public static boolean Bzk(yFO yfo) {
        return yfo != null && yfo.aBv() == 19;
    }

    public static boolean SGo(yFO yfo) {
        return (yfo == null || !com.bytedance.sdk.openadsdk.core.aBv.ZZv().TX() || !yfo.gbA() || Og(yfo) || ZZv(yfo) || ML(yfo)) ? false : true;
    }

    public void ML() {
        FrameLayout frameLayout = this.WQf;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            View view = this.roi;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public void JG() {
        com.bytedance.sdk.component.Bzk.ZZv zZv;
        com.bytedance.sdk.openadsdk.ZZv.BSW bsw = this.CIG;
        if (bsw != null && (zZv = this.BF) != null) {
            bsw.pA(zZv);
        }
        Handler handler = this.DX;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ValueAnimator valueAnimator = this.SGo;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.SGo.cancel();
        }
        ObjectAnimator objectAnimator = this.BSW;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.BSW.cancel();
        }
        com.bytedance.sdk.openadsdk.common.WV wv = this.TV;
        if (wv != null) {
            wv.Og();
        }
        ObjectAnimator objectAnimator2 = this.Bzk;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        com.bytedance.sdk.component.Bzk.ZZv zZv2 = this.BF;
        if (zZv2 != null) {
            xy.pA(zZv2.getWebView());
        }
        this.BF = null;
        IG ig = this.TX;
        if (ig != null) {
            ig.BSW();
        }
        com.bytedance.sdk.openadsdk.ZZv.BSW bsw2 = this.CIG;
        if (bsw2 != null) {
            bsw2.KZx(true);
        }
        if (!TextUtils.isEmpty(this.HSv) && this.SzT) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA.pA(this.fN, this.agB, this.SD);
        }
        com.bytedance.sdk.openadsdk.SD.Og.pA().pA(this.JBA);
    }

    public void SD() {
        IG ig = this.TX;
        if (ig != null) {
            ig.SGo();
        }
        com.bytedance.sdk.openadsdk.ZZv.BSW bsw = this.CIG;
        if (bsw != null) {
            bsw.SD();
        }
    }

    public void omh() {
        com.bytedance.sdk.openadsdk.ZZv.BSW bsw = this.CIG;
        if (bsw != null) {
            bsw.omh();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        long jZZv;
        yFO yfo;
        yFO yfo2;
        if (message.what == 100) {
            int i = message.arg1;
            if (ZZv(this.SD) && (yfo2 = this.SD) != null && yfo2.Bzk() != null) {
                jZZv = this.SD.Bzk().Og();
            } else {
                jZZv = (!ML(this.SD) || (yfo = this.SD) == null || yfo.Bzk() == null) ? 20L : this.SD.Bzk().ZZv();
            }
            com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA pAVar = this.WV;
            if (pAVar != null) {
                pAVar.pA(((long) i) * 1000, jZZv * 1000);
            }
            long j = i;
            if (j >= jZZv) {
                com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA pAVar2 = this.WV;
                if (pAVar2 != null) {
                    pAVar2.pA(jZZv * 1000, 100);
                }
            } else if (j < jZZv && this.DX != null) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 100;
                messageObtain.arg1 = i + 1;
                this.DX.sendMessageDelayed(messageObtain, 1000L);
            }
        }
        return true;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.omh.yFO yfo, FrameLayout frameLayout) {
        this.vA = yfo;
        this.PV = frameLayout;
    }

    public boolean Bzk() {
        AtomicBoolean atomicBoolean;
        return (!KZx(this.SD) || (atomicBoolean = this.lx) == null || atomicBoolean.get()) ? false : true;
    }

    public void pA(int i) {
        com.bytedance.sdk.openadsdk.core.omh.yFO yfo = this.vA;
        if (yfo != null) {
            yfo.ML(i);
        }
    }

    public void pA(final int i, com.bytedance.sdk.component.adexpress.Og.Sn sn) {
        float f;
        int iKZx;
        if (i == 3 || Og(i)) {
            if (this.PV == null || sn == null) {
                return;
            }
            AtomicBoolean atomicBoolean = this.lx;
            if (atomicBoolean != null) {
                if (i == 1) {
                    return;
                }
                if (i == 5 && atomicBoolean.get()) {
                    return;
                }
            }
            final LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.roi.getLayoutParams();
            this.gy = (LinearLayout.LayoutParams) this.WQf.getLayoutParams();
            final float f2 = layoutParams.weight;
            oX oXVarSGo = this.SD.SGo();
            if (Og(i)) {
                if (oXVarSGo != null) {
                    iKZx = oXVarSGo.Og();
                    f = iKZx;
                } else {
                    f = 30.0f;
                }
            } else if (oXVarSGo != null) {
                iKZx = oXVarSGo.KZx();
                f = iKZx;
            } else {
                f = 70.0f;
            }
            final float f3 = f;
            new Object[]{"expressStartWeight is :", Float.valueOf(f2), "expressEndWeight is:", Float.valueOf(f3)};
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.PV.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            final FrameLayout.LayoutParams layoutParams3 = layoutParams2;
            final int i2 = layoutParams3.height;
            final int i3 = layoutParams3.width;
            final int i4 = layoutParams3.leftMargin;
            final int i5 = layoutParams3.topMargin;
            final int iKZx2 = Vgu.KZx(this.lT, (float) sn.omh());
            final int iKZx3 = Vgu.KZx(this.lT, (float) sn.Bzk());
            final int iKZx4 = Vgu.KZx(this.lT, (float) sn.JG());
            final int iKZx5 = Vgu.KZx(this.lT, (float) sn.SD());
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.SGo = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(500L);
            this.SGo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.model.aBv.8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LinearLayout.LayoutParams layoutParams4 = layoutParams;
                    float f4 = f2;
                    layoutParams4.weight = f4 + ((f3 - f4) * fFloatValue);
                    aBv.this.gy.weight = 100.0f - layoutParams.weight;
                    if (aBv.this.roi != null) {
                        aBv.this.roi.setLayoutParams(layoutParams);
                    }
                    if (aBv.this.WQf != null) {
                        aBv.this.WQf.setLayoutParams(aBv.this.gy);
                    }
                    if (aBv.this.gy.weight < 30.0f) {
                        aBv.this.KZx(8);
                    } else {
                        aBv.this.KZx(0);
                    }
                    FrameLayout.LayoutParams layoutParams5 = layoutParams3;
                    int i6 = i3;
                    layoutParams5.width = i6 + ((int) ((iKZx2 - i6) * fFloatValue));
                    FrameLayout.LayoutParams layoutParams6 = layoutParams3;
                    int i7 = i2;
                    layoutParams6.height = i7 + ((int) ((iKZx3 - i7) * fFloatValue));
                    FrameLayout.LayoutParams layoutParams7 = layoutParams3;
                    int i8 = i4;
                    layoutParams7.leftMargin = i8 + ((int) ((iKZx4 - i8) * fFloatValue));
                    FrameLayout.LayoutParams layoutParams8 = layoutParams3;
                    int i9 = i5;
                    layoutParams8.topMargin = i9 + ((int) ((iKZx5 - i9) * fFloatValue));
                    if (aBv.this.PV != null) {
                        aBv.this.PV.setLayoutParams(layoutParams3);
                    }
                    aBv.this.pA(0.0f);
                    if (fFloatValue == 1.0f) {
                        if (aBv.this.IIF != null) {
                            Vgu.pA((View) aBv.this.IIF, 0);
                            if (aBv.this.Og(i)) {
                                aBv.this.IIF.setImageDrawable(com.bytedance.sdk.component.utils.yFO.KZx(aBv.this.lT, "tt_ad_zoom_down"));
                                aBv.this.IIF.setTag(1);
                            } else {
                                aBv.this.IIF.setImageDrawable(com.bytedance.sdk.component.utils.yFO.KZx(aBv.this.lT, "tt_ad_zoom_up"));
                                aBv.this.IIF.setTag(2);
                            }
                        }
                        if (aBv.this.lx == null) {
                            aBv.this.lx = new AtomicBoolean();
                        }
                        aBv.this.lx.set(aBv.this.Og(i));
                    }
                }
            });
            com.bytedance.sdk.openadsdk.ZZv.KZx.ZZv(this.SD, this.rB, i);
            this.SGo.start();
            if (this.nCO.compareAndSet(false, true)) {
                this.bU = SystemClock.elapsedRealtime();
            }
            Vgu.pA((View) this.IIF, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZx(int i) {
        Vgu.pA((View) this.SXO, i);
        Vgu.pA((View) this.fw, i);
        if (this.FQ.get()) {
            Vgu.pA((View) this.XT, i);
            Vgu.pA((View) this.yFO, i);
            Vgu.pA((View) this.vZF, i);
            Vgu.pA((View) this.Sd, 0);
        }
    }
}
