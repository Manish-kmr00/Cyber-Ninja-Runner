package com.bytedance.sdk.openadsdk.component.reward.pA;

import android.R;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.IG;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.xy;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.json.b9;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class XT implements com.bytedance.sdk.openadsdk.WV.SD {
    private boolean BF;
    private final com.bytedance.sdk.openadsdk.core.model.yFO BSW;
    private boolean Bf;
    private com.bytedance.sdk.openadsdk.core.widget.pA.ML CIG;
    private int DX;
    private boolean FQ;
    private boolean Gx;
    private long JBA;
    com.bytedance.sdk.openadsdk.ZZv.BSW ML;
    IG Og;
    private boolean PV;
    private boolean SXO;
    private boolean Sd;
    private final boolean Sn;
    private boolean SzT;
    private View TV;
    private boolean TX;
    private View WQf;
    private final String WV;
    private int Wx;
    private com.bytedance.sdk.component.Bzk.ZZv XT;
    private ILoader YkC;
    protected String ZZv;
    private com.bytedance.sdk.component.Bzk.ZZv aBv;
    private com.bytedance.sdk.openadsdk.core.widget.pA.JG.pA cFQ;
    private float du;
    private float eG;
    private String fJy;
    private int fN;
    private String fw;
    private final com.bytedance.sdk.openadsdk.component.reward.pA.pA gbA;
    private boolean gy;
    private com.bytedance.sdk.openadsdk.common.ZZv lx;
    private int oX;
    protected com.bytedance.sdk.openadsdk.ZZv.ZZv.ML omh;
    IG pA;
    private boolean qmB;
    private long roi;
    private com.bytedance.sdk.openadsdk.common.Wx xy;
    protected boolean KZx = true;
    private boolean yFO = false;
    private final AtomicBoolean vZF = new AtomicBoolean(true);
    int JG = 0;
    String SD = "";
    boolean Bzk = false;
    private SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> Mc = new SparseArray<>();
    private boolean IG = true;
    private float lT = -1.0f;
    private float rB = -1.0f;
    private boolean Vgu = false;
    private long HSv = -1;
    private volatile int agB = 0;
    private int dmv = -1;
    private volatile int dC = 0;
    private volatile int IIF = 0;
    private long vA = 0;
    public boolean SGo = false;
    private int nCO = -1;

    public interface ZZv {
        void pA(WebView webView, int i);

        void pA(WebView webView, String str);

        void pA(WebView webView, String str, Bitmap bitmap);
    }

    static /* synthetic */ int Sn(XT xt) {
        int i = xt.dC;
        xt.dC = i + 1;
        return i;
    }

    static /* synthetic */ int aBv(XT xt) {
        int i = xt.agB;
        xt.agB = i + 1;
        return i;
    }

    static /* synthetic */ int oX(XT xt) {
        int i = xt.IIF;
        xt.IIF = i + 1;
        return i;
    }

    public XT(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        this.gbA = pAVar;
        this.BSW = pAVar.Og;
        this.WV = pAVar.ML;
        this.Sn = pAVar.ZZv;
    }

    public void pA() {
        if (this.BF) {
            return;
        }
        this.BF = true;
        this.Wx = this.gbA.YkC;
        this.DX = this.gbA.IIF;
        this.oX = this.gbA.vA;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Og();
        this.vA = SystemClock.elapsedRealtime() - jElapsedRealtime;
    }

    void Og() {
        com.bytedance.sdk.openadsdk.common.Wx wx;
        this.WQf = this.gbA.SzT.findViewById(R.id.content);
        boolean z = this.gbA.SD;
        this.qmB = z;
        if (z && (wx = this.xy) != null) {
            this.aBv = wx.ZZv();
        } else {
            com.bytedance.sdk.component.Bzk.ZZv zZv = (com.bytedance.sdk.component.Bzk.ZZv) this.gbA.CIG.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.Sn);
            this.aBv = zZv;
            if (zZv != null && com.bytedance.sdk.openadsdk.core.model.yFO.Og(this.BSW)) {
                this.aBv.f_();
            } else {
                Vgu.pA((View) this.aBv, 8);
            }
        }
        com.bytedance.sdk.component.Bzk.ZZv zZv2 = (com.bytedance.sdk.component.Bzk.ZZv) this.gbA.CIG.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.oX);
        this.XT = zZv2;
        if (zZv2 != null && WQf.SD(this.BSW) && WQf.omh(this.BSW)) {
            this.XT.f_();
            this.XT.setDisplayZoomControls(false);
        } else {
            Vgu.pA((View) this.XT, 8);
        }
        com.bytedance.sdk.component.Bzk.ZZv zZv3 = this.aBv;
        if (zZv3 != null) {
            zZv3.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (XT.this.aBv == null || XT.this.aBv.getViewTreeObserver() == null) {
                        return;
                    }
                    XT.this.aBv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredWidth = XT.this.aBv.getMeasuredWidth();
                    int measuredHeight = XT.this.aBv.getMeasuredHeight();
                    if (XT.this.aBv.getVisibility() == 0) {
                        XT.this.pA(measuredWidth, measuredHeight);
                    }
                }
            });
        }
        com.bytedance.sdk.component.Bzk.ZZv zZv4 = this.XT;
        if (zZv4 != null) {
            zZv4.setLandingPage(true);
            this.XT.setTag(WQf.SD(this.BSW) ? this.WV : "landingpage_endcard");
            this.XT.setWebViewClient(new com.bytedance.sdk.component.Bzk.ZZv.pA());
            this.XT.setMaterialMeta(this.BSW.BDQ());
        }
    }

    public void pA(String str, final com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og og) {
        pA(str, new ZZv() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.12
            @Override // com.bytedance.sdk.openadsdk.component.reward.pA.XT.ZZv
            public void pA(WebView webView, String str2) {
                if (XT.this.gbA.SzT.isFinishing()) {
                    return;
                }
                XT.this.gbA.TV.Og(XT.this.XT());
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.pA.XT.ZZv
            public void pA(WebView webView, String str2, Bitmap bitmap) {
                if (XT.this.Vgu || !WQf.XT(XT.this.gbA.Og)) {
                    return;
                }
                XT.this.Vgu = true;
                XT.this.gbA.TV.pA(XT.this.gbA.JG, XT.this.gbA.Og, XT.this.gbA.Og.kK());
                if (!WQf.omh(XT.this.BSW)) {
                    XT.this.gbA.Bf.sendEmptyMessageDelayed(600, XT.this.gbA.TV.Bzk() * 1000);
                }
                XT.this.gbA.TV.SGo();
                XT.this.gbA.FQ.BSW();
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.pA.XT.ZZv
            public void pA(WebView webView, int i) {
                try {
                    if (!WQf.XT(XT.this.gbA.Og) || !XT.this.gbA.Og.Bpk() || XT.this.gbA.SzT.isFinishing()) {
                        if (!XT.this.gbA.SD || XT.this.gbA.fw == null) {
                            return;
                        }
                        XT.this.gbA.fw.pA(webView, i, XT.this.cFQ);
                        return;
                    }
                    XT.this.gbA.TV.KZx(i);
                } catch (Exception unused) {
                }
            }
        });
        if (WQf.XT(this.gbA.Og)) {
            pA(this.XT);
            this.gbA.TV.pA(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.13
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str2, String str3, String str4, String str5, long j) {
                    XT.this.gbA.WQf.Og();
                    com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og og2 = og;
                    if (og2 != null) {
                        og2.ZZv();
                    }
                }
            });
        }
        this.gbA.TV.KZx(this.gbA.lx);
        pA(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.14
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str2, String str3, String str4, String str5, long j) {
                XT.this.gbA.WQf.Og();
                com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og og2 = og;
                if (og2 != null) {
                    og2.ZZv();
                }
            }
        });
    }

    public void pA(com.bytedance.sdk.openadsdk.WV.ML ml, String str, final com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og og) {
        if (this.aBv == null) {
            return;
        }
        HashMap map = new HashMap();
        if (WQf.SD(this.BSW)) {
            map.put("click_scence", 3);
        } else {
            map.put("click_scence", 2);
        }
        this.omh = agB();
        IG ig = new IG(this.gbA.SzT);
        this.pA = ig;
        ig.pA(this.gbA.FQ);
        String strJK = this.BSW.jK();
        this.pA.Og(this.aBv).pA(this.BSW).KZx(this.BSW.nCO()).ZZv(this.BSW.tM()).Og(this.BSW.kK() ? 7 : 5).pA(new Og(this.aBv)).ML(strJK).pA(this.aBv).Og(aBv() ? "landingpage_endcard" : str).pA(map).pA(this.omh).pA(new com.bytedance.sdk.openadsdk.core.widget.JG() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.16
            @Override // com.bytedance.sdk.openadsdk.core.widget.JG
            public void pA() {
                if (XT.this.CIG != null) {
                    XT.this.CIG.Og();
                }
                com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og og2 = og;
                if (og2 != null) {
                    og2.ZZv();
                }
            }
        }).pA(new IG.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.15
            @Override // com.bytedance.sdk.openadsdk.core.IG.pA
            public void pA() {
                XT.this.HSv();
            }
        });
        HashMap map2 = new HashMap();
        if (WQf.omh(this.BSW)) {
            map2.put("click_scence", 2);
        }
        IG ig2 = new IG(this.gbA.SzT);
        this.Og = ig2;
        ig2.pA(this.gbA.FQ);
        IG igML = this.Og.Og(this.XT).pA(this.BSW).KZx(this.BSW.nCO()).ZZv(this.BSW.tM()).Og(this.BSW.kK() ? 7 : 5).pA(new Og(this.XT)).pA(this.XT).ML(strJK);
        if (aBv()) {
            str = "landingpage_endcard";
        }
        igML.Og(str).pA(map2).pA(this.omh).pA(new com.bytedance.sdk.openadsdk.core.widget.JG() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.18
            @Override // com.bytedance.sdk.openadsdk.core.widget.JG
            public void pA() {
                if (XT.this.CIG != null) {
                    XT.this.CIG.Og();
                }
            }
        }).pA(new IG.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.17
            @Override // com.bytedance.sdk.openadsdk.core.IG.pA
            public void pA() {
                XT.this.HSv();
            }
        });
        this.pA.pA(new KZx(this.aBv));
        this.Og.pA(new KZx(this.XT));
        this.pA.pA(this.gbA.Vgu.SGo()).pA(this.gbA.lx).pA(ml).pA(this.gbA.TV.BSW()).pA(new com.bytedance.sdk.openadsdk.WV.Og() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.19
            @Override // com.bytedance.sdk.openadsdk.WV.Og
            public void pA(boolean z, int i, String str2) {
                if (z) {
                    XT.this.SGo = true;
                    if (XT.this.PV) {
                        XT.this.PV = false;
                        XT xt = XT.this;
                        xt.pA(xt.gbA.agB, true);
                    }
                }
                if (!com.bytedance.sdk.openadsdk.core.model.yFO.ZZv(XT.this.gbA.Og) || WQf.SD(XT.this.gbA.Og)) {
                    return;
                }
                XT.this.pA(z, i, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.WV.Og
            public void pA() {
                XT.this.Bf = true;
                XT.this.gbA.Vgu.SGo().performClick();
            }
        });
        this.pA.ML(this.FQ);
        this.Og.pA(this.gbA.Vgu.SGo()).pA(new com.bytedance.sdk.openadsdk.WV.Og() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.2
            @Override // com.bytedance.sdk.openadsdk.WV.Og
            public void pA(boolean z, int i, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.WV.Og
            public void pA() {
                XT.this.Bf = true;
                XT.this.gbA.Vgu.SGo().performClick();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HSv() {
        this.SzT = true;
        this.gy = false;
        this.gbA.Bf.removeMessages(600);
        this.gbA.Bf.removeMessages(700);
        this.gbA.Bf.removeMessages(900);
        this.gbA.qmB.ZZv(false);
        this.gbA.yFO.set(true);
        this.gbA.nCO.DX();
        this.BSW.Dc();
        if (this.BSW.Dc() || !gbA.omh(WQf.pA(this.BSW))) {
            return;
        }
        View viewSGo = this.gbA.Vgu.SGo();
        View.OnClickListener onClickListener = (View.OnClickListener) viewSGo.getTag(viewSGo.getId());
        if (onClickListener != null) {
            pA pAVar = new pA(this.gbA, viewSGo, onClickListener);
            viewSGo.setOnClickListener(pAVar);
            viewSGo.setOnTouchListener(pAVar);
        }
    }

    public boolean KZx() {
        return this.Bf;
    }

    public boolean ZZv() {
        return this.Gx;
    }

    public void pA(int i, int i2) {
        if (this.pA == null || this.gbA.SzT.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
            this.pA.pA("resize", jSONObject);
        } catch (Exception e) {
            Log.e("TTAD.RFWVM", "", e);
        }
    }

    public void pA(boolean z) {
        this.KZx = z;
    }

    public void ML() {
        if (WQf.ML(this.BSW)) {
            return;
        }
        JG();
    }

    public void JG() {
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.model.yFO.pA(this.gbA.Gx, this.BSW))) {
            com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.BSW;
            if (yfo != null && !yfo.eD() && this.YkC == null && aBv()) {
                this.fJy = this.BSW.Gag();
                this.YkC = com.bytedance.sdk.openadsdk.SD.Og.pA().Og();
                int iPA = com.bytedance.sdk.openadsdk.SD.Og.pA().pA(this.YkC, this.fJy);
                this.fN = iPA;
                this.dmv = iPA > 0 ? 2 : 0;
                if (!TextUtils.isEmpty(this.fJy)) {
                    com.bytedance.sdk.openadsdk.ZZv.BSW bsw = this.ML;
                    if (bsw != null) {
                        bsw.pA(this.dmv);
                    }
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA.pA(this.vA, this.BSW, "landingpage_endcard", this.YkC, this.fJy);
                }
            }
            if ((!TextUtils.isEmpty(this.ZZv) && this.ZZv.contains("play.google.com/store")) || com.bytedance.sdk.openadsdk.core.model.aBv.JG(this.BSW) || com.bytedance.sdk.openadsdk.core.model.aBv.ML(this.BSW)) {
                this.Bzk = true;
                return;
            }
            if (this.KZx) {
                if (this.aBv != null && !TextUtils.isEmpty(this.ZZv) && com.bytedance.sdk.openadsdk.core.model.yFO.Og(this.BSW)) {
                    if (this.SXO) {
                        return;
                    }
                    String str = this.ZZv + "&is_pre_render=1";
                    com.bytedance.sdk.openadsdk.ZZv.BSW bsw2 = this.ML;
                    if (bsw2 != null) {
                        bsw2.ZZv();
                    }
                    if (WQf.SD(this.BSW)) {
                        com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().Og(this.BSW);
                    }
                    com.bytedance.sdk.openadsdk.utils.yFO.pA(this.aBv, str);
                    this.gbA.TV.pA(str);
                    this.SXO = true;
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.model.yFO.KZx(this.BSW)) {
                    this.gbA.xy.KZx();
                }
            }
        }
    }

    public void SD() {
        com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogBf = this.BSW.Bf();
        if (ogBf == null) {
            return;
        }
        String strWV = ogBf.WV();
        this.fw = strWV;
        if (TextUtils.isEmpty(strWV)) {
            return;
        }
        this.fw = pA(this.fw, this.BSW, this.Wx, this.oX, this.DX);
        this.XT.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.pA.ML(com.bytedance.sdk.openadsdk.core.aBv.pA(), this.Og, this.BSW.nCO(), this.ML, this.BSW.gbA() || WQf.SD(this.BSW)) { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.3
            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                CreativeInfoManager.onResourceLoaded(h.u, view, url);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/pA/XT$3;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
                BrandSafetyUtils.onWebViewPageFinished(h.u, webView, str);
                safedk_XT$3_onPageFinished_e673fdc753981aa23d0b94d0d6ae0942(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/pA/XT$3;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
                BrandSafetyUtils.onWebViewPageStarted(h.u, webView, str);
                safedk_XT$3_onPageStarted_2d744d884d39705a30ecae8f9516fcde(webView, str, bitmap);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/pA/XT$3;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
                BrandSafetyUtils.onWebViewReceivedError(h.u, webView, i, str, str2);
                safedk_XT$3_onReceivedError_7eea824c408a6cf681d2a549ba8af36a(webView, i, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/pA/XT$3;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
                BrandSafetyUtils.onWebViewReceivedError(h.u, webView, webResourceRequest, webResourceError);
                safedk_XT$3_onReceivedError_00ebd52e4cbbf70090a3b00f52932526(webView, webResourceRequest, webResourceError);
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

            public void safedk_XT$3_onReceivedError_7eea824c408a6cf681d2a549ba8af36a(WebView p0, int p1, String p2, String p3) {
                if (XT.this.pA(p3)) {
                    return;
                }
                XT.this.TX = false;
                XT.this.JG = p1;
                XT.this.SD = p2;
                if (XT.this.omh != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", p1);
                        jSONObject.put("msg", p2);
                        XT.this.omh.pA(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(p0, p1, p2, p3);
            }

            public void safedk_XT$3_onReceivedError_00ebd52e4cbbf70090a3b00f52932526(WebView p0, WebResourceRequest p1, WebResourceError p2) {
                if (p1 == null || p1.getUrl() == null || !XT.this.pA(p1.getUrl().toString())) {
                    XT.this.TX = false;
                    if (XT.this.omh != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (p2 != null) {
                                jSONObject.put("code", p2.getErrorCode());
                                jSONObject.put("msg", p2.getDescription());
                            }
                            XT.this.omh.pA(jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                    if (p2 != null) {
                        XT.this.JG = p2.getErrorCode();
                        XT.this.SD = String.valueOf(p2.getDescription());
                    }
                    if (p1 == null) {
                        return;
                    }
                    super.onReceivedError(p0, p1, p2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (webResourceRequest != null && webResourceRequest.isForMainFrame()) {
                    XT.this.TX = false;
                    if (webResourceResponse != null) {
                        XT.this.JG = webResourceResponse.getStatusCode();
                        XT.this.SD = "onReceivedHttpError";
                    }
                }
                if (XT.this.omh != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (webResourceResponse != null) {
                            jSONObject.put("code", webResourceResponse.getStatusCode());
                            jSONObject.put("msg", webResourceResponse.getReasonPhrase());
                        }
                        XT.this.omh.pA(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (webResourceRequest != null) {
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                }
            }

            public void safedk_XT$3_onPageFinished_e673fdc753981aa23d0b94d0d6ae0942(WebView p0, String p1) {
                super.onPageFinished(p0, p1);
                if (XT.this.omh != null) {
                    XT.this.omh.JG();
                }
            }

            public void safedk_XT$3_onPageStarted_2d744d884d39705a30ecae8f9516fcde(WebView p0, String p1, Bitmap p2) {
                super.onPageStarted(p0, p1, p2);
                if (XT.this.omh != null) {
                    XT.this.omh.ML();
                }
            }
        });
        this.XT.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.pA.ZZv(this.Og, this.ML) { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ZZv, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (!XT.this.gbA.SD || XT.this.gbA.fw == null) {
                    return;
                }
                XT.this.gbA.fw.pA(webView, i, XT.this.cFQ);
            }
        });
        com.bytedance.sdk.openadsdk.utils.yFO.pA(this.XT, this.fw);
        this.TX = true;
    }

    public void omh() {
        if (this.aBv == null) {
            return;
        }
        this.vZF.set(this.TX);
        if (this.XT.getVisibility() == 0 && this.TX) {
            JBA();
            return;
        }
        this.gbA.qmB.KZx(false);
        this.gbA.TV.SD(omh.KZx);
        pA(this.pA, true, false);
        Og(this.pA, false);
        pA(this.pA, false);
        this.aBv.WV();
        if (this.TX) {
            this.XT.setVisibility(0);
            pA(this.Og, this.gbA.agB, true);
            Og(this.Og, true);
            pA(this.Og, true);
            this.gbA.Bf.removeMessages(600);
            if (!this.gbA.gbA.KZx(this.gbA.nCO)) {
                this.gbA.nCO.WQf();
            }
        } else {
            if (this.gbA.TV.pA()) {
                this.gbA.TV.pA(5);
            }
            this.gbA.gbA.ZZv();
            this.gbA.Wo.pA(this.gbA.omh);
        }
        this.gy = true;
    }

    private void JBA() {
        this.Og.pA("showPlayableEndCardOverlay", (JSONObject) null);
        this.gbA.Bf.sendEmptyMessageDelayed(600, 1000L);
        this.gbA.Bf.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.5
            @Override // java.lang.Runnable
            public void run() {
                XT.this.HSv();
            }
        }, 1000L);
        if (this.gbA.Wo != null) {
            this.gbA.Wo.pA(0L);
        }
    }

    public void Bzk() {
        this.pA.pA("showPlayableEndCardOverlay", (JSONObject) null);
        this.gbA.Bf.sendEmptyMessageDelayed(600, 1000L);
        this.gbA.Bf.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.6
            @Override // java.lang.Runnable
            public void run() {
                XT.this.HSv();
            }
        }, 1000L);
        if (this.gbA.Wo != null) {
            this.gbA.Wo.pA(0L);
        }
    }

    public com.bytedance.sdk.component.Bzk.ZZv SGo() {
        return this.aBv;
    }

    public com.bytedance.sdk.component.Bzk.ZZv BSW() {
        return this.XT;
    }

    public IG WV() {
        return this.pA;
    }

    public IG Wx() {
        return this.Og;
    }

    public com.bytedance.sdk.openadsdk.ZZv.BSW Sn() {
        return this.ML;
    }

    public void DX() {
        com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogBf;
        if (WQf.ML(this.BSW)) {
            com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.BSW;
            if (yfo != null && (ogBf = yfo.Bf()) != null) {
                this.ZZv = ogBf.WV();
            }
        } else {
            this.ZZv = WQf.Wx(this.BSW);
        }
        String strPA = pA(this.ZZv, this.BSW, this.Wx, this.oX, this.DX);
        this.ZZv = strPA;
        if (TextUtils.isEmpty(strPA)) {
            return;
        }
        this.FQ = this.ZZv.contains("use_second_endcard=1");
    }

    private static String pA(String str, com.bytedance.sdk.openadsdk.core.model.yFO yfo, int i, int i2, int i3) {
        String str2;
        String str3;
        float fSlz = yfo.slz();
        if (!TextUtils.isEmpty(str)) {
            if (i == 1) {
                if (str.contains("?")) {
                    str3 = str + b9.i.c;
                } else {
                    str3 = str + "?";
                }
                str = str3 + "orientation=portrait";
            }
            if (str.contains("?")) {
                str2 = str + b9.i.c;
            } else {
                str2 = str + "?";
            }
            str = str2 + "height=" + i2 + "&width=" + i3 + "&aspect_ratio=" + fSlz;
        }
        return !WQf.SD(yfo) ? com.bytedance.sdk.openadsdk.utils.ZZv.pA(str) : str;
    }

    public void oX() {
        com.bytedance.sdk.component.Bzk.ZZv zZv = this.aBv;
        if (zZv != null) {
            xy.pA(zZv.getWebView());
        }
        com.bytedance.sdk.component.Bzk.ZZv zZv2 = this.XT;
        if (zZv2 != null) {
            xy.pA(zZv2.getWebView());
        }
        long j = this.JBA;
        if (j > 0) {
            if (this.HSv > 0) {
                this.JBA = j + (SystemClock.elapsedRealtime() - this.HSv);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("endcard_overlay_render_type", com.bytedance.sdk.openadsdk.core.model.yFO.KZx(this.BSW) ? 7 : 0);
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.gbA.Og, this.WV, "second_endcard_duration", jSONObject, this.JBA);
        }
        this.aBv = null;
        if (this.omh != null && !com.bytedance.sdk.openadsdk.core.model.aBv.ZZv(this.BSW) && !com.bytedance.sdk.openadsdk.core.model.aBv.ML(this.BSW) && !com.bytedance.sdk.openadsdk.core.model.yFO.KZx(this.BSW)) {
            this.omh.pA(true);
            this.omh.WV();
        }
        IG ig = this.pA;
        if (ig != null) {
            ig.BSW();
        }
        IG ig2 = this.Og;
        if (ig2 != null) {
            ig2.BSW();
        }
        com.bytedance.sdk.openadsdk.ZZv.BSW bsw = this.ML;
        if (bsw != null) {
            bsw.KZx(this.BSW.gbA() || WQf.SD(this.BSW));
        }
        DeviceUtils.AudioInfoReceiver.Og(this);
    }

    public void Og(int i) {
        Vgu.pA((View) this.aBv, i);
        com.bytedance.sdk.component.Bzk.ZZv zZv = this.aBv;
        if (zZv != null) {
            Vgu.pA((View) zZv.getWebView(), i);
        }
        if (this.aBv != null && (this.BSW.gbA() || WQf.SD(this.BSW))) {
            this.aBv.setLandingPage(true);
            this.aBv.setTag(WQf.SD(this.BSW) ? this.WV : "landingpage_endcard");
            this.aBv.setMaterialMeta(this.BSW.BDQ());
        }
        if (i == 0 && WQf.omh(this.BSW)) {
            SD();
        }
    }

    public void pA(com.bytedance.sdk.openadsdk.common.Wx wx) {
        this.xy = wx;
    }

    public void pA(float f) {
        Vgu.pA(this.aBv, f);
    }

    public void Og(boolean z) {
        pA(this.pA, z);
    }

    public void pA(IG ig, boolean z) {
        if (this.pA == null || this.gbA.SzT.isFinishing()) {
            return;
        }
        ig.Og(z);
    }

    private void pA(String str, final ZZv zZv) {
        com.bytedance.sdk.component.Bzk.ZZv zZv2;
        com.bytedance.sdk.component.Bzk.ZZv zZv3 = this.aBv;
        if (zZv3 != null && zZv3.getWebView() != null) {
            com.bytedance.sdk.openadsdk.ZZv.BSW bswPA = new com.bytedance.sdk.openadsdk.ZZv.BSW(this.BSW, this.aBv.getWebView(), new com.bytedance.sdk.openadsdk.ZZv.SGo() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.7
                @Override // com.bytedance.sdk.openadsdk.ZZv.SGo
                public void pA(int i) {
                    if (TextUtils.isEmpty(XT.this.fJy)) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA.pA(XT.this.fN, XT.this.agB, XT.this.IIF, XT.this.dC - XT.this.IIF, XT.this.BSW, "landingpage_endcard", i);
                }
            }, this.dmv).pA(true);
            this.ML = bswPA;
            this.cFQ = bswPA.pA;
            this.ML.pA(aBv() ? "landingpage_endcard" : str);
            this.ML.Og(this.WV);
            this.ML.Og(true);
            this.aBv.getWebView().setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.8
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    if (XT.this.ML != null) {
                        XT.this.ML.Og(i2);
                    }
                }
            });
            if (this.gbA.TV != null) {
                this.ML.pA(this.gbA.TV.ZZv());
            }
            com.bytedance.sdk.openadsdk.common.ZZv zZvPA = gbA.pA(this.BSW, this.aBv, this.gbA.SzT, this.WV);
            this.lx = zZvPA;
            if (zZvPA != null) {
                if (aBv()) {
                    str = "landingpage_endcard";
                }
                zZvPA.pA(str);
            }
            if (aBv()) {
                gbA.pA(this.BSW, this.aBv);
            }
            com.bytedance.sdk.openadsdk.core.widget.pA.ML ml = new com.bytedance.sdk.openadsdk.core.widget.pA.ML(com.bytedance.sdk.openadsdk.core.aBv.pA(), this.pA, this.BSW.nCO(), this.lx, this.ML, this.BSW.gbA() || WQf.SD(this.BSW)) { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.9
                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                public void onLoadResource(WebView view, String url) {
                    super.onLoadResource(view, url);
                    CreativeInfoManager.onResourceLoaded(h.u, view, url);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str2) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/pA/XT$9;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
                    BrandSafetyUtils.onWebViewPageFinished(h.u, webView, str2);
                    safedk_XT$9_onPageFinished_054bdc187e176423f50d721f29e203f2(webView, str2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/pA/XT$9;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
                    BrandSafetyUtils.onWebViewPageStarted(h.u, webView, str2);
                    safedk_XT$9_onPageStarted_d45fbc2ffee7d47589a434e9118a333b(webView, str2, bitmap);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i, String str2, String str3) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/pA/XT$9;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
                    BrandSafetyUtils.onWebViewReceivedError(h.u, webView, i, str2, str3);
                    safedk_XT$9_onReceivedError_cf3df0816750c7f9572023ffaa55f009(webView, i, str2, str3);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/pA/XT$9;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
                    BrandSafetyUtils.onWebViewReceivedError(h.u, webView, webResourceRequest, webResourceError);
                    safedk_XT$9_onReceivedError_1a3559a1f63e58feb4849f83ada4e2ba(webView, webResourceRequest, webResourceError);
                }

                /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/pA/XT$9;->shouldInterceptRequest(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;");
                    return CreativeInfoManager.onWebViewResponseWithHeaders(h.u, webView, webResourceRequest, safedk_XT$9_shouldInterceptRequest_02a7110c3bdd784ee99544f5038e0e66(webView, webResourceRequest));
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str2) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/pA/XT$9;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;");
                    return CreativeInfoManager.onWebViewResponse(h.u, webView, str2, safedk_XT$9_shouldInterceptRequest_5370e417aba0f0edc80050c18084811b(webView, str2));
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    boolean zShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(view, url);
                    BrandSafetyUtils.onShouldOverrideUrlLoading(h.u, view, url, zShouldOverrideUrlLoading);
                    return zShouldOverrideUrlLoading;
                }

                public WebResourceResponse safedk_XT$9_shouldInterceptRequest_5370e417aba0f0edc80050c18084811b(WebView p0, String p1) {
                    if (!WQf.SD(XT.this.BSW)) {
                        try {
                            if (TextUtils.isEmpty(XT.this.fJy)) {
                                return super.shouldInterceptRequest(p0, p1);
                            }
                            XT.Sn(XT.this);
                            WebResourceResponseModel webResourceResponseModelPA = com.bytedance.sdk.openadsdk.SD.Og.pA().pA(XT.this.YkC, XT.this.fJy, p1);
                            if (webResourceResponseModelPA != null && webResourceResponseModelPA.getWebResourceResponse() != null) {
                                XT.oX(XT.this);
                                return webResourceResponseModelPA.getWebResourceResponse();
                            }
                            if (webResourceResponseModelPA != null && webResourceResponseModelPA.getMsg() == 2) {
                                XT.aBv(XT.this);
                            }
                            return super.shouldInterceptRequest(p0, p1);
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.WV.pA("TTAD.RFWVM", "shouldInterceptRequest url error", th);
                            return super.shouldInterceptRequest(p0, p1);
                        }
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    WebResourceResponse webResourceResponsePA = com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().pA(XT.this.BSW.Bf().Wx(), WQf.Wx(XT.this.BSW), p1);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (XT.this.omh != null) {
                        com.bytedance.sdk.component.adexpress.ZZv.SGo.pA pAVarPA = com.bytedance.sdk.component.adexpress.ZZv.SGo.pA(p1);
                        int i = webResourceResponsePA != null ? 1 : 2;
                        if (pAVarPA == com.bytedance.sdk.component.adexpress.ZZv.SGo.pA.HTML) {
                            XT.this.omh.pA(p1, jCurrentTimeMillis, jCurrentTimeMillis2, i);
                        } else if (pAVarPA == com.bytedance.sdk.component.adexpress.ZZv.SGo.pA.JS) {
                            XT.this.omh.Og(p1, jCurrentTimeMillis, jCurrentTimeMillis2, i);
                        }
                    }
                    if (webResourceResponsePA != null) {
                        new Object[]{"Plb res: hit++ ", p1};
                        return webResourceResponsePA;
                    }
                    new Object[]{"Plb res: hit no ", p1};
                    return super.shouldInterceptRequest(p0, p1);
                }

                public WebResourceResponse safedk_XT$9_shouldInterceptRequest_02a7110c3bdd784ee99544f5038e0e66(WebView p0, WebResourceRequest p1) {
                    try {
                        return shouldInterceptRequest(p0, p1.getUrl().toString());
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.WV.pA("TTAD.RFWVM", "shouldInterceptRequest error1", th);
                        return super.shouldInterceptRequest(p0, p1);
                    }
                }

                public void safedk_XT$9_onReceivedError_cf3df0816750c7f9572023ffaa55f009(WebView p0, int p1, String p2, String p3) {
                    super.onReceivedError(p0, p1, p2, p3);
                }

                public void safedk_XT$9_onReceivedError_1a3559a1f63e58feb4849f83ada4e2ba(WebView p0, WebResourceRequest p1, WebResourceError p2) {
                    super.onReceivedError(p0, p1, p2);
                    if (p2 != null && p1 != null && p1.getUrl() != null) {
                        Log.i("TTAD.RFWVM", "onReceivedError WebResourceError : description=" + ((Object) p2.getDescription()) + "  url =" + p1.getUrl().toString());
                    }
                    if (p1 == null || p1.getUrl() == null || !XT.this.pA(p1.getUrl().toString())) {
                        if (p2 != null && p1 != null && p1.isForMainFrame()) {
                            XT.this.gbA.TV.pA(p2.getErrorCode(), String.valueOf(p2.getDescription()), String.valueOf(p1.getUrl()));
                        }
                        if (p1 == null || p1.isForMainFrame()) {
                            XT.this.vZF.set(false);
                            XT.this.SXO = false;
                        }
                        if (XT.this.omh != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                if (p2 != null) {
                                    jSONObject.put("code", p2.getErrorCode());
                                    jSONObject.put("msg", p2.getDescription());
                                }
                                XT.this.omh.pA(jSONObject);
                            } catch (JSONException unused) {
                            }
                        }
                        if (p2 != null) {
                            XT.this.JG = p2.getErrorCode();
                            XT.this.SD = String.valueOf(p2.getDescription());
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, android.webkit.WebViewClient
                public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, android.webkit.WebViewClient
                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    XT.this.gbA.TV.pA(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                    if (webResourceRequest != null && webResourceRequest.getUrl() != null) {
                        Log.i("TTAD.RFWVM", "onReceivedHttpError:url =" + webResourceRequest.getUrl().toString());
                    }
                    if (webResourceRequest != null && webResourceRequest.isForMainFrame()) {
                        XT.this.vZF.set(false);
                        XT.this.SXO = false;
                        if (webResourceResponse != null) {
                            XT.this.JG = webResourceResponse.getStatusCode();
                            XT.this.SD = "onReceivedHttpError";
                        }
                    }
                    if (XT.this.omh != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (webResourceResponse != null) {
                                jSONObject.put("code", webResourceResponse.getStatusCode());
                                jSONObject.put("msg", webResourceResponse.getReasonPhrase());
                            }
                            XT.this.omh.pA(jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                    if (webResourceRequest != null) {
                        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                    }
                }

                public void safedk_XT$9_onPageFinished_054bdc187e176423f50d721f29e203f2(WebView p0, String p1) {
                    super.onPageFinished(p0, p1);
                    XT.this.SXO = false;
                    XT.this.Sd = true;
                    if (XT.this.gbA.rB.du()) {
                        View viewSGo = XT.this.gbA.Vgu.SGo();
                        if (viewSGo instanceof com.bytedance.sdk.openadsdk.core.ML.ZZv) {
                            ((com.bytedance.sdk.openadsdk.core.ML.ZZv) viewSGo).setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(XT.this.gbA.Gx, "tt_skip_btn"));
                        }
                    }
                    DeviceUtils.AudioInfoReceiver.pA(XT.this);
                    XT.this.nCO = DeviceUtils.SD();
                    if (XT.this.omh != null) {
                        XT.this.omh.JG();
                    }
                    XT.this.gbA.TV.Og(p1);
                    ZZv zZv4 = zZv;
                    if (zZv4 != null) {
                        zZv4.pA(p0, p1);
                    }
                }

                public void safedk_XT$9_onPageStarted_d45fbc2ffee7d47589a434e9118a333b(WebView p0, String p1, Bitmap p2) {
                    super.onPageStarted(p0, p1, p2);
                    if (XT.this.omh != null) {
                        XT.this.omh.ML();
                    }
                    ZZv zZv4 = zZv;
                    if (zZv4 != null) {
                        zZv4.pA(p0, p1, p2);
                    }
                }
            };
            this.CIG = ml;
            this.aBv.setWebViewClient(ml);
            this.CIG.pA(this.BSW);
            this.CIG.pA(this.Sn ? "rewarded_video" : "fullscreen_interstitial_ad");
            if (this.BSW.gbA() && (zZv2 = this.aBv) != null && zZv2.getWebView() != null) {
                this.aBv.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.10
                    private final int Og = com.bytedance.sdk.openadsdk.core.aBv.Og();

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/pA/XT$10;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                        CreativeInfoManager.onViewTouched(h.u, view, motionEvent);
                        return safedk_XT$10_onTouch_5285b8cad45ad02754865214b68dabe0(view, motionEvent);
                    }

                    public boolean safedk_XT$10_onTouch_5285b8cad45ad02754865214b68dabe0(View p0, MotionEvent p1) {
                        int i;
                        if (XT.this.ML != null) {
                            XT.this.ML.pA(p1);
                        }
                        if (XT.this.lx != null) {
                            XT.this.lx.pA(p1);
                        }
                        try {
                            int actionMasked = p1.getActionMasked();
                            if (actionMasked != 0) {
                                int i2 = 3;
                                if (actionMasked == 1) {
                                    i = i2;
                                } else if (actionMasked != 2) {
                                    i2 = actionMasked != 3 ? -1 : 4;
                                    i = i2;
                                } else {
                                    float rawX = p1.getRawX();
                                    float rawY = p1.getRawY();
                                    if (Math.abs(rawX - XT.this.du) >= this.Og || Math.abs(rawY - XT.this.eG) >= this.Og) {
                                        XT.this.IG = false;
                                    }
                                    XT.this.lT += Math.abs(p1.getX() - XT.this.du);
                                    XT.this.rB += Math.abs(p1.getY() - XT.this.eG);
                                    int i3 = (System.currentTimeMillis() - XT.this.roi <= 200 || (XT.this.lT <= 8.0f && XT.this.rB <= 8.0f)) ? 2 : 1;
                                    if (XT.this.qmB) {
                                        if (rawY - XT.this.eG > 8.0f) {
                                            XT.this.xy.pA();
                                        }
                                        if (rawY - XT.this.eG < -8.0f) {
                                            XT.this.xy.Og();
                                        }
                                    }
                                    i = i3;
                                }
                            } else {
                                XT.this.IG = true;
                                XT.this.Mc = new SparseArray();
                                XT.this.du = p1.getRawX();
                                XT.this.eG = p1.getRawY();
                                XT.this.roi = System.currentTimeMillis();
                                try {
                                    long landingPageClickBegin = XT.this.aBv.getLandingPageClickBegin();
                                    if (landingPageClickBegin > 0 && landingPageClickBegin < XT.this.roi) {
                                        XT.this.roi = landingPageClickBegin;
                                        XT.this.aBv.setLandingPageClickBegin(-1L);
                                    }
                                } catch (Exception unused) {
                                }
                                XT.this.lT = -1.0f;
                                XT.this.rB = -1.0f;
                                i = 0;
                            }
                            XT.this.Mc.put(p1.getActionMasked(), new com.bytedance.sdk.openadsdk.core.Og.KZx.pA(i, p1.getSize(), p1.getPressure(), System.currentTimeMillis()));
                            if (p1.getAction() != 1 || p0.getVisibility() != 0 || Float.valueOf(p0.getAlpha()).intValue() != 1) {
                                return false;
                            }
                            if ((XT.this.yFO && !com.bytedance.sdk.openadsdk.core.model.aBv.omh(XT.this.BSW)) || !XT.this.IG) {
                                return false;
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("down_x", XT.this.du);
                            jSONObject.put("down_y", XT.this.eG);
                            jSONObject.put("down_time", XT.this.roi);
                            jSONObject.put("up_x", p1.getRawX());
                            jSONObject.put("up_y", p1.getRawY());
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            try {
                                long landingPageClickEnd = XT.this.aBv.getLandingPageClickEnd();
                                if (landingPageClickEnd > 0 && landingPageClickEnd < jCurrentTimeMillis) {
                                    try {
                                        XT.this.aBv.setLandingPageClickEnd(-1L);
                                    } catch (Exception unused2) {
                                    }
                                    jCurrentTimeMillis = landingPageClickEnd;
                                }
                            } catch (Exception unused3) {
                            }
                            jSONObject.put("up_time", jCurrentTimeMillis);
                            int[] iArr = new int[2];
                            if (XT.this.qmB) {
                                XT xt = XT.this;
                                xt.TV = xt.gbA.CIG.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.Wo);
                            } else {
                                XT xt2 = XT.this;
                                xt2.TV = xt2.gbA.CIG.findViewById(520093713);
                            }
                            if (XT.this.TV != null) {
                                XT.this.TV.getLocationOnScreen(iArr);
                                jSONObject.put("button_x", iArr[0]);
                                jSONObject.put("button_y", iArr[1]);
                                jSONObject.put("button_width", XT.this.TV.getWidth());
                                jSONObject.put("button_height", XT.this.TV.getHeight());
                            }
                            if (XT.this.WQf != null) {
                                int[] iArr2 = new int[2];
                                XT.this.WQf.getLocationOnScreen(iArr2);
                                jSONObject.put("ad_x", iArr2[0]);
                                jSONObject.put("ad_y", iArr2[1]);
                                jSONObject.put("width", XT.this.WQf.getWidth());
                                jSONObject.put("height", XT.this.WQf.getHeight());
                            }
                            jSONObject.put("toolType", p1.getToolType(0));
                            jSONObject.put("deviceId", p1.getDeviceId());
                            jSONObject.put("source", p1.getSource());
                            jSONObject.put("ft", com.bytedance.sdk.openadsdk.core.model.SGo.pA(XT.this.Mc, com.bytedance.sdk.openadsdk.core.Bzk.Og().pA() ? 1 : 2));
                            jSONObject.put("user_behavior_type", XT.this.IG ? 1 : 2);
                            jSONObject.put("click_scence", 2);
                            if (XT.this.CIG != null) {
                                XT.this.CIG.pA(jSONObject);
                            }
                            if (!XT.this.yFO && !com.bytedance.sdk.openadsdk.core.model.aBv.SD(XT.this.BSW)) {
                                if (XT.this.Sn) {
                                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA(XT.this.BSW, "rewarded_video", "click", jSONObject);
                                } else {
                                    com.bytedance.sdk.openadsdk.ZZv.KZx.pA(XT.this.BSW, "fullscreen_interstitial_ad", "click", jSONObject);
                                }
                                XT.this.yFO = true;
                                return false;
                            }
                            return false;
                        } catch (Throwable th) {
                            Log.e("TTAD.RFWVM", "TouchRecordTool onTouch error", th);
                            return false;
                        }
                    }
                });
            }
            com.bytedance.sdk.component.Bzk.ZZv zZv4 = this.aBv;
            if (zZv4 != null) {
                zZv4.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.pA.ZZv(this.pA, this.ML, this.lx) { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.XT.11
                    @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ZZv, android.webkit.WebChromeClient
                    public void onProgressChanged(WebView webView, int i) {
                        super.onProgressChanged(webView, i);
                        ZZv zZv5 = zZv;
                        if (zZv5 != null) {
                            zZv5.pA(webView, i);
                        }
                    }
                });
            }
            pA(this.aBv);
            this.aBv.setLayerType(1, null);
            this.aBv.setBackgroundColor(-1);
            this.aBv.setDisplayZoomControls(false);
        }
        ML();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return this.BSW.gbA() && str.endsWith(".mp4");
    }

    public boolean aBv() {
        String str = this.ZZv;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void pA(DownloadListener downloadListener) {
        com.bytedance.sdk.component.Bzk.ZZv zZv = this.aBv;
        if (zZv == null || downloadListener == null) {
            return;
        }
        zZv.setDownloadListener(downloadListener);
    }

    public boolean XT() {
        return this.vZF.get();
    }

    public boolean yFO() {
        return this.Sd;
    }

    public void pA(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        if (zZv == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.pA.KZx.pA(this.gbA.SzT).pA(false).Og(false).pA(zZv.getWebView());
        zZv.setUserAgentString(com.bytedance.sdk.openadsdk.utils.aBv.pA(zZv.getWebView(), BuildConfig.VERSION_CODE));
        zZv.setMixedContentMode(0);
    }

    public void vZF() {
        com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml = this.omh;
        if (ml != null) {
            ml.Bzk();
        }
        com.bytedance.sdk.openadsdk.ZZv.BSW bsw = this.ML;
        if (bsw != null) {
            bsw.omh();
        }
    }

    public void Sd() {
        com.bytedance.sdk.component.Bzk.ZZv zZv = this.aBv;
        if (zZv != null) {
            zZv.BSW();
        }
        com.bytedance.sdk.component.Bzk.ZZv zZv2 = this.XT;
        if (zZv2 != null) {
            zZv2.BSW();
        }
        if (this.HSv > 0) {
            this.JBA += SystemClock.elapsedRealtime() - this.HSv;
            this.HSv = 0L;
        }
        IG ig = this.pA;
        if (ig != null) {
            ig.Og(false);
            Og(this.pA, false);
            pA(this.pA, true, false);
        }
        if (this.Og == null || !WQf.omh(this.BSW)) {
            return;
        }
        this.Og.Og(false);
        Og(this.Og, false);
        pA(this.Og, true, false);
    }

    public void KZx(boolean z) {
        Og(this.pA, z);
    }

    public void Og(IG ig, boolean z) {
        try {
            this.gbA.TV.ZZv(z);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            ig.pA(b9.g.V, jSONObject);
        } catch (Exception unused) {
        }
    }

    public void pA(boolean z, boolean z2) {
        pA(this.pA, z, z2);
    }

    public void pA(IG ig, boolean z, boolean z2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD_SHOW, z2);
            com.bytedance.sdk.openadsdk.activity.JG jg = this.gbA.RS;
            if (jg != null) {
                jSONObject.put("multi_ads_show", jg.WQf().SD());
            }
            ig.pA("endcard_control_event", jSONObject);
            if (z2) {
                if (this.Sd) {
                    return;
                }
                this.PV = true;
                return;
            }
            this.PV = false;
        } catch (Exception unused) {
        }
    }

    public void ZZv(boolean z) {
        if (this.pA == null || this.gbA.SzT.isFinishing()) {
            return;
        }
        this.gbA.TV.ML(z);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            this.pA.pA("volumeChange", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void TX() {
        com.bytedance.sdk.component.Bzk.ZZv zZv = this.aBv;
        if (zZv != null) {
            zZv.Bzk();
        }
        com.bytedance.sdk.component.Bzk.ZZv zZv2 = this.XT;
        if (zZv2 != null) {
            zZv2.Bzk();
        }
        if (this.HSv == 0) {
            this.HSv = SystemClock.elapsedRealtime();
        }
        IG ig = this.pA;
        if (ig != null) {
            ig.SGo();
            com.bytedance.sdk.component.Bzk.ZZv zZv3 = this.aBv;
            if (zZv3 != null) {
                if (zZv3.getVisibility() == 0) {
                    this.pA.Og(true);
                    Og(this.pA, true);
                    pA(this.pA, false, true);
                    if (WQf.SGo(this.BSW) && !this.SzT && this.gbA.Og.Dc()) {
                        Bzk();
                    }
                } else {
                    this.pA.Og(false);
                    Og(this.pA, false);
                    pA(this.pA, true, false);
                }
            }
        }
        if (this.Og != null && WQf.omh(this.BSW)) {
            this.Og.SGo();
            com.bytedance.sdk.component.Bzk.ZZv zZv4 = this.XT;
            if (zZv4 != null) {
                if (zZv4.getVisibility() == 0) {
                    this.Og.Og(true);
                    Og(this.Og, true);
                    pA(this.Og, false, true);
                    if (!this.SzT && this.gbA.Og.Dc()) {
                        JBA();
                    }
                } else {
                    this.Og.Og(false);
                    Og(this.Og, false);
                    pA(this.Og, true, false);
                }
            }
        }
        com.bytedance.sdk.openadsdk.ZZv.BSW bsw = this.ML;
        if (bsw != null) {
            bsw.SD();
        }
    }

    public int BF() {
        return this.JG;
    }

    public String WQf() {
        return this.SD;
    }

    public String TV() {
        return this.ZZv;
    }

    public boolean du() {
        if (com.bytedance.sdk.openadsdk.core.model.yFO.KZx(this.BSW)) {
            return this.FQ && !this.Gx && this.gbA.xy.WV();
        }
        return this.FQ && !this.Gx && this.vZF.get() && this.Sd;
    }

    public void eG() {
        com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml = this.omh;
        if (ml != null) {
            ml.omh();
        }
    }

    public void pA(boolean z, int i, String str) {
        com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml = this.omh;
        if (ml == null) {
            return;
        }
        if (z) {
            ml.Og();
        } else {
            ml.pA(i, str);
        }
    }

    public void roi() {
        com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml = this.omh;
        if (ml != null) {
            ml.SD();
        }
    }

    public void Mc() {
        com.bytedance.sdk.openadsdk.ZZv.BSW bsw = this.ML;
        if (bsw != null) {
            bsw.pA(System.currentTimeMillis());
        }
    }

    public boolean IG() {
        return this.Bzk;
    }

    public void lT() {
        com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml = this.omh;
        if (ml != null) {
            ml.KZx();
            this.omh.ZZv();
        }
    }

    public void rB() {
        com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml = this.omh;
        if (ml != null) {
            ml.SGo();
        }
    }

    private com.bytedance.sdk.openadsdk.ZZv.ZZv.ML agB() {
        return new com.bytedance.sdk.openadsdk.ZZv.aBv(WQf.SD(this.BSW) ? 3 : 2, this.Sn ? "rewarded_video" : "fullscreen_interstitial_ad", this.BSW);
    }

    public boolean xy() {
        IG ig = this.pA;
        if (ig == null) {
            return false;
        }
        return ig.omh();
    }

    @Override // com.bytedance.sdk.openadsdk.WV.SD
    public void pA(int i) {
        int i2 = this.nCO;
        if (i2 <= 0 && i > 0) {
            ZZv(false);
        } else if (i2 > 0 && i == 0) {
            ZZv(true);
        }
        this.nCO = i;
    }

    public void qmB() {
        Vgu.pA((View) this.aBv, 0);
        Vgu.pA((View) this.XT, 8);
    }

    public void gbA() {
        Vgu.pA((View) this.XT, 8);
    }

    public void ML(boolean z) {
        this.Gx = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("endcard_overlay_render_type", com.bytedance.sdk.openadsdk.core.model.yFO.KZx(this.BSW) ? 7 : 0);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.BSW, this.WV, "use_second_endcard", jSONObject);
        this.HSv = SystemClock.elapsedRealtime();
        try {
            if (!com.bytedance.sdk.openadsdk.core.model.yFO.KZx(this.BSW)) {
                this.pA.pA("click_endcard_close", (JSONObject) null);
            } else if (z) {
                this.gbA.xy.omh();
                com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.BSW, this.WV, "endcard_close_skip", jSONObject);
            }
        } catch (Exception unused2) {
        }
        this.gbA.Wo.pA(this.gbA.omh);
    }

    public boolean Vgu() {
        return this.Sd && this.vZF.get();
    }

    public boolean CIG() {
        return this.gy;
    }

    public boolean SzT() {
        com.bytedance.sdk.component.Bzk.ZZv zZv = this.aBv;
        return zZv == null || zZv.getWebView() == null;
    }

    private static class Og implements com.bytedance.sdk.openadsdk.WV.pA {
        private final View pA;

        public Og(View view) {
            this.pA = view;
        }

        @Override // com.bytedance.sdk.openadsdk.WV.pA
        public int pA() {
            View view = this.pA;
            int measuredHeight = view != null ? view.getMeasuredHeight() : -1;
            return measuredHeight <= 0 ? Vgu.ZZv(com.bytedance.sdk.openadsdk.core.aBv.pA()) : measuredHeight;
        }

        @Override // com.bytedance.sdk.openadsdk.WV.pA
        public int Og() {
            View view = this.pA;
            int measuredWidth = view != null ? view.getMeasuredWidth() : -1;
            return measuredWidth <= 0 ? Vgu.KZx(com.bytedance.sdk.openadsdk.core.aBv.pA()) : measuredWidth;
        }
    }

    private static class KZx implements com.bytedance.sdk.openadsdk.WV.Bzk {
        private final com.bytedance.sdk.component.Bzk.ZZv pA;

        private KZx(com.bytedance.sdk.component.Bzk.ZZv zZv) {
            this.pA = zZv;
        }

        @Override // com.bytedance.sdk.openadsdk.WV.Bzk
        public void pA() {
            com.bytedance.sdk.component.Bzk.ZZv zZv = this.pA;
            if (zZv == null) {
                return;
            }
            zZv.BSW();
        }

        @Override // com.bytedance.sdk.openadsdk.WV.Bzk
        public void Og() {
            com.bytedance.sdk.component.Bzk.ZZv zZv = this.pA;
            if (zZv == null) {
                return;
            }
            zZv.Sn();
        }
    }

    public void FQ() {
        com.bytedance.sdk.openadsdk.ZZv.BSW bsw = this.ML;
        if (bsw != null) {
            bsw.ML();
        }
    }

    private static class pA extends com.bytedance.sdk.openadsdk.core.Og.pA implements com.bytedance.sdk.openadsdk.core.Og.Og.pA {
        private final View.OnClickListener KZx;
        private final View Og;
        private final com.bytedance.sdk.openadsdk.component.reward.pA.pA pA;

        public pA(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar, View view, View.OnClickListener onClickListener) {
            super(pAVar.SzT, pAVar.Og, pAVar.ML, pAVar.ZZv ? 7 : 5);
            this.pA = pAVar;
            this.Og = view;
            this.KZx = onClickListener;
            HashMap map = new HashMap();
            map.put("close_auto_click", Boolean.TRUE);
            map.put("click_scence", 2);
            pA(map);
            pA(pAVar.WQf.KZx());
            pA(this);
        }

        @Override // com.bytedance.sdk.openadsdk.core.Og.pA, com.bytedance.sdk.openadsdk.core.Og.Og, com.bytedance.sdk.openadsdk.core.Og.KZx
        public void pA(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray, boolean z) {
            if (this.JG.Dc()) {
                this.KZx.onClick(view);
                this.Og.setOnTouchListener(null);
                this.Og.setOnClickListener(this.KZx);
            } else {
                super.pA(view, f, f2, f3, f4, sparseArray, z);
                this.pA.FQ.c_();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.Og.Og.pA
        public void pA(View view, int i) {
            this.Og.setOnTouchListener(null);
            this.Og.setOnClickListener(this.KZx);
        }
    }

    public boolean Gx() {
        return this.SzT;
    }

    public void JG(boolean z) {
        this.gy = z;
    }

    public boolean Bf() {
        return this.SGo;
    }
}
