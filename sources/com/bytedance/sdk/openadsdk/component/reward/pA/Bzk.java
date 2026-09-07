package com.bytedance.sdk.openadsdk.component.reward.pA;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.HomeWatcherReceiver;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class Bzk implements Handler.Callback, com.bytedance.sdk.openadsdk.WV.SD {
    private static final com.bytedance.sdk.openadsdk.yFO.SD.pA SGo = new com.bytedance.sdk.openadsdk.yFO.SD.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.Bzk.1
        @Override // com.bytedance.sdk.openadsdk.yFO.SD.pA
        public void pA(String str, String str2, Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA(str, str2, th);
        }
    };
    private boolean BF;
    private volatile boolean BSW;
    private boolean Bzk;
    private final pA DX;
    private HomeWatcherReceiver Sd;
    private final String Sn;
    private boolean TV;
    private com.bytedance.sdk.openadsdk.yFO.omh TX;
    private volatile boolean WQf;
    private final Activity WV;
    private final com.bytedance.sdk.openadsdk.core.model.yFO Wx;
    private XT aBv;
    private boolean du;
    private boolean omh;
    private com.bytedance.sdk.openadsdk.core.widget.BSW yFO;
    protected final AtomicBoolean pA = new AtomicBoolean(false);
    private final Handler oX = new Handler(this);
    boolean Og = false;
    boolean KZx = false;
    long ZZv = 0;
    int ML = 0;
    int JG = 0;
    int SD = 0;
    private int XT = 1;
    private boolean vZF = true;
    private final com.bytedance.sdk.openadsdk.WV.ZZv eG = new com.bytedance.sdk.openadsdk.WV.ZZv() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.Bzk.8
        @Override // com.bytedance.sdk.openadsdk.WV.ZZv
        public void Og() {
        }

        @Override // com.bytedance.sdk.openadsdk.WV.ZZv
        public void pA(int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.WV.ZZv
        public void pA() {
            if (!Bzk.this.DX.SzT.isFinishing() && Bzk.this.DX.Og.Bpk() && WQf.oX(Bzk.this.DX.Og)) {
                Bzk.this.oX.removeMessages(800);
                Bzk.this.oX.sendMessage(Bzk.pA(1, 0));
            }
        }
    };

    public Bzk(pA pAVar) {
        this.omh = true;
        this.DX = pAVar;
        this.WV = pAVar.SzT;
        this.Sn = pAVar.ML;
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = pAVar.Og;
        this.Wx = yfo;
        this.omh = WQf.SD(yfo);
    }

    public static Message pA(int i, int i2) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 800;
        messageObtain.arg1 = i;
        if (i == 3) {
            messageObtain.arg2 = i2;
        }
        return messageObtain;
    }

    public void Og(int i) {
        if (this.omh) {
            if (i == 5) {
                this.Bzk = true;
                if (WQf.BF(this.Wx)) {
                    this.oX.removeMessages(900);
                    this.DX.Bf.sendEmptyMessage(600);
                }
            }
            this.oX.sendMessage(pA(i, 0));
        }
    }

    public void pA() {
        if (this.omh && !this.BF) {
            this.BF = true;
            this.aBv = this.DX.rB;
            this.XT = this.DX.YkC;
            Sd();
            if (WQf.SD(this.Wx)) {
                DeviceUtils.AudioInfoReceiver.pA(this);
            }
            if (TX() && WQf.XT(this.Wx) && WQf.oX(this.Wx)) {
                Handler handler = this.oX;
                handler.sendMessageDelayed(handler.obtainMessage(800, 2, WQf.pA(2)), WQf.vZF(this.Wx) * 1000);
            }
        }
    }

    public void pA(final com.bytedance.sdk.openadsdk.WV.ML ml, boolean z) {
        com.bytedance.sdk.openadsdk.Sn.Og og;
        com.bytedance.sdk.component.pA.aBv abvPA;
        if (this.omh && WQf.SD(this.Wx) && this.DX.HSv) {
            if (com.bytedance.sdk.openadsdk.core.Bzk.Og().aBv()) {
                com.bytedance.sdk.openadsdk.yFO.SD.pA(SGo);
            }
            com.bytedance.sdk.openadsdk.yFO.pA pAVar = new com.bytedance.sdk.openadsdk.yFO.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.Bzk.2
                @Override // com.bytedance.sdk.openadsdk.yFO.pA
                public void pA(int i, String str) {
                    super.pA(i, str);
                    if (Bzk.this.yFO == null || !Bzk.this.yFO.isShown()) {
                        return;
                    }
                    Bzk.this.oX.sendMessage(Bzk.pA(3, WQf.pA(i)));
                }

                @Override // com.bytedance.sdk.openadsdk.yFO.pA
                public com.bytedance.sdk.openadsdk.yFO.ZZv pA() {
                    return Bzk.vZF();
                }

                @Override // com.bytedance.sdk.openadsdk.yFO.pA
                public void Og() {
                    Bzk.this.DX.rB.WV().KZx(true);
                    com.bytedance.sdk.openadsdk.WV.ML ml2 = ml;
                    if (ml2 != null) {
                        ml2.pA();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.yFO.pA
                public void pA(JSONObject jSONObject) {
                    com.bytedance.sdk.openadsdk.ZZv.KZx.Og(Bzk.this.Wx, Bzk.this.Sn, "playable_track", jSONObject);
                }
            };
            com.bytedance.sdk.openadsdk.yFO.KZx kZx = new com.bytedance.sdk.openadsdk.yFO.KZx() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.Bzk.3
                @Override // com.bytedance.sdk.openadsdk.yFO.KZx
                public void pA(String str, JSONObject jSONObject) {
                    Bzk.this.DX.rB.WV().pA(str, jSONObject);
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cid", this.Wx.nCO());
                jSONObject.put("log_extra", this.Wx.tM());
                com.bytedance.sdk.openadsdk.yFO.omh omhVarML = com.bytedance.sdk.openadsdk.yFO.omh.pA(com.bytedance.sdk.openadsdk.core.aBv.pA(), this.DX.rB.SGo().getWebView(), kZx, pAVar).SD(this.DX.rB.TV()).ML(com.bytedance.sdk.openadsdk.common.Og.pA(com.bytedance.sdk.openadsdk.core.aBv.pA())).pA(com.bytedance.sdk.openadsdk.common.Og.pA()).KZx(jSONObject).pA("sdkEdition", com.bytedance.sdk.openadsdk.common.Og.KZx()).Og(com.bytedance.sdk.openadsdk.common.Og.ML()).ZZv(com.bytedance.sdk.openadsdk.common.Og.ZZv()).ZZv(false).pA(z).pA(WQf.vZF(this.Wx)).Og(WQf.vZF(this.Wx)).ML(WQf.XT(this.Wx));
                this.TX = omhVarML;
                if (omhVarML == null) {
                    og = new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.Bzk.4
                        @Override // com.bytedance.sdk.openadsdk.Sn.Og
                        public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("PlayablePlugin_is_null", true);
                            return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("PlayablePlugin_init").Og(jSONObject2.toString());
                        }
                    };
                    com.bytedance.sdk.openadsdk.Sn.KZx.pA("PlayablePlugin_init", false, og);
                }
            } catch (Exception unused) {
                if (this.TX == null) {
                    og = new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.Bzk.4
                        @Override // com.bytedance.sdk.openadsdk.Sn.Og
                        public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("PlayablePlugin_is_null", true);
                            return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("PlayablePlugin_init").Og(jSONObject2.toString());
                        }
                    };
                }
            } catch (Throwable th) {
                if (this.TX == null) {
                    com.bytedance.sdk.openadsdk.Sn.KZx.pA("PlayablePlugin_init", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.Bzk.4
                        @Override // com.bytedance.sdk.openadsdk.Sn.Og
                        public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("PlayablePlugin_is_null", true);
                            return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("PlayablePlugin_init").Og(jSONObject2.toString());
                        }
                    });
                }
                throw th;
            }
            if (this.TX != null && !TextUtils.isEmpty(WQf.BSW(this.Wx))) {
                this.TX.KZx(WQf.BSW(this.Wx));
            }
            com.bytedance.sdk.openadsdk.yFO.omh omhVar = this.TX;
            if (omhVar != null) {
                Set<String> setBSW = omhVar.BSW();
                final WeakReference weakReference = new WeakReference(this.TX);
                for (String str : setBSW) {
                    if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str) && (abvPA = this.DX.rB.WV().pA()) != null) {
                        abvPA.pA(str, new com.bytedance.sdk.component.pA.ML<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.Bzk.5
                            @Override // com.bytedance.sdk.component.pA.ML
                            public JSONObject pA(JSONObject jSONObject2, com.bytedance.sdk.component.pA.JG jg) {
                                try {
                                    com.bytedance.sdk.openadsdk.yFO.omh omhVar2 = (com.bytedance.sdk.openadsdk.yFO.omh) weakReference.get();
                                    if (omhVar2 == null) {
                                        return null;
                                    }
                                    return omhVar2.ZZv(pA(), jSONObject2);
                                } catch (Throwable unused2) {
                                    return null;
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.yFO.ZZv vZF() {
        String strJG = com.bytedance.sdk.openadsdk.common.Og.JG();
        strJG.hashCode();
        switch (strJG) {
            case "2g":
                return com.bytedance.sdk.openadsdk.yFO.ZZv.TYPE_2G;
            case "3g":
                return com.bytedance.sdk.openadsdk.yFO.ZZv.TYPE_3G;
            case "4g":
                return com.bytedance.sdk.openadsdk.yFO.ZZv.TYPE_4G;
            case "5g":
                return com.bytedance.sdk.openadsdk.yFO.ZZv.TYPE_5G;
            case "wifi":
                return com.bytedance.sdk.openadsdk.yFO.ZZv.TYPE_WIFI;
            default:
                return com.bytedance.sdk.openadsdk.yFO.ZZv.TYPE_UNKNOWN;
        }
    }

    private void Sd() {
        if (this.omh) {
            this.yFO = (com.bytedance.sdk.openadsdk.core.widget.BSW) this.DX.CIG.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.qH);
        }
    }

    private boolean TX() {
        if (this.yFO == null) {
            return false;
        }
        if (this.Wx.Bpk() && WQf.XT(this.Wx)) {
            this.yFO.Og(this.Wx, this.XT);
            return true;
        }
        this.yFO.KZx();
        return false;
    }

    public void Og() {
        if (this.omh && !this.pA.getAndSet(true)) {
            this.aBv.qmB();
            if (WQf.omh(this.Wx)) {
                this.aBv.SD();
            }
        }
    }

    public void pA(DownloadListener downloadListener) {
        com.bytedance.sdk.component.Bzk.ZZv zZvBSW;
        if (this.omh && (zZvBSW = this.aBv.BSW()) != null) {
            String strBF = BF();
            if (TextUtils.isEmpty(strBF)) {
                return;
            }
            zZvBSW.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.pA.ML(this.WV, this.aBv.Wx(), this.Wx.nCO(), null, false) { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.Bzk.6
                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                public void onLoadResource(WebView view, String url) {
                    super.onLoadResource(view, url);
                    CreativeInfoManager.onResourceLoaded(h.u, view, url);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/pA/Bzk$6;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
                    BrandSafetyUtils.onWebViewPageFinished(h.u, webView, str);
                    safedk_Bzk$6_onPageFinished_7dffd9b459fa1575dc79ea4de84f7811(webView, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    BrandSafetyUtils.onWebViewPageStarted(h.u, view, url);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/pA/Bzk$6;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
                    BrandSafetyUtils.onWebViewReceivedError(h.u, webView, i, str, str2);
                    safedk_Bzk$6_onReceivedError_18dbdf4204f0b37fef7fe112bf43b8b1(webView, i, str, str2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/pA/Bzk$6;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
                    BrandSafetyUtils.onWebViewReceivedError(h.u, webView, webResourceRequest, webResourceError);
                    safedk_Bzk$6_onReceivedError_eb79cd17516b0ad8f81a774a74145592(webView, webResourceRequest, webResourceError);
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

                public void safedk_Bzk$6_onPageFinished_7dffd9b459fa1575dc79ea4de84f7811(WebView p0, String p1) {
                    if (Bzk.this.vZF) {
                        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(System.currentTimeMillis(), Bzk.this.Wx, Bzk.this.Sn, "loading_h5_success");
                    }
                    super.onPageFinished(p0, p1);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, android.webkit.WebViewClient
                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                    Bzk.this.vZF = false;
                }

                public void safedk_Bzk$6_onReceivedError_eb79cd17516b0ad8f81a774a74145592(WebView p0, WebResourceRequest p1, WebResourceError p2) {
                    super.onReceivedError(p0, p1, p2);
                    Bzk.this.vZF = false;
                }

                public void safedk_Bzk$6_onReceivedError_18dbdf4204f0b37fef7fe112bf43b8b1(WebView p0, int p1, String p2, String p3) {
                    super.onReceivedError(p0, p1, p2, p3);
                    Bzk.this.vZF = false;
                }
            });
            zZvBSW.a_(strBF);
            zZvBSW.setDisplayZoomControls(false);
            zZvBSW.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.pA.ZZv(this.aBv.Wx(), this.aBv.Sn()));
            zZvBSW.setDownloadListener(downloadListener);
        }
    }

    private String BF() {
        String strPA;
        String strDu = com.bytedance.sdk.openadsdk.core.aBv.ZZv().du();
        if (TextUtils.isEmpty(strDu) || this.Wx.Wo() == null) {
            return strDu;
        }
        String strOg = this.Wx.Wo().Og();
        double dZZv = this.Wx.Wo().ZZv();
        int iML = this.Wx.Wo().ML();
        if (this.Wx.fJy() != null && !TextUtils.isEmpty(this.Wx.fJy().pA())) {
            strPA = this.Wx.fJy().pA();
        } else {
            strPA = "";
        }
        String strNCO = this.Wx.nCO();
        String strKZx = this.Wx.Wo().KZx();
        String strPA2 = this.Wx.Wo().pA();
        String strOg2 = this.Wx.Wo().Og();
        String strSXO = this.Wx.SXO();
        StringBuilder sb = new StringBuilder("appname=");
        sb.append(URLEncoder.encode(strOg)).append("&stars=").append(dZZv).append("&comments=").append(iML).append("&icon=").append(URLEncoder.encode(strPA)).append("&downloading=true&id=").append(URLEncoder.encode(strNCO)).append("&packageName=").append(URLEncoder.encode(strKZx)).append("&downloadUrl=").append(URLEncoder.encode(strPA2)).append("&name=").append(URLEncoder.encode(strOg2)).append("&orientation=").append(this.XT == 1 ? "portrait" : "landscape").append("&apptitle=").append(URLEncoder.encode(strSXO));
        return strDu + "?" + ((Object) sb);
    }

    public void KZx() {
        if (this.omh && !this.du) {
            this.du = true;
            KZx(false);
            pA(this.WV.getApplicationContext());
            com.bytedance.sdk.openadsdk.yFO.omh omhVar = this.TX;
            if (omhVar != null) {
                omhVar.qmB();
            }
            this.oX.removeCallbacksAndMessages(null);
            DeviceUtils.AudioInfoReceiver.Og(this);
        }
    }

    public void pA(boolean z) {
        if (this.omh && z) {
            this.aBv.SGo().setDomStorageEnabled(true);
        }
    }

    public void Og(boolean z) {
        if (this.omh) {
            if (z) {
                try {
                    if (!TextUtils.isEmpty(this.aBv.TV()) && this.aBv.BF() != 0) {
                        com.bytedance.sdk.openadsdk.Sn.KZx.pA().pA(this.aBv.TV(), this.aBv.BF(), this.aBv.WQf());
                    }
                } catch (Throwable unused) {
                }
            }
            if (z) {
                try {
                    if (TextUtils.isEmpty(this.aBv.TV())) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.Sn.KZx.pA().Og(this.aBv.TV());
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public void ZZv() {
        if (this.omh) {
            try {
                HomeWatcherReceiver homeWatcherReceiver = new HomeWatcherReceiver();
                this.Sd = homeWatcherReceiver;
                homeWatcherReceiver.pA(new HomeWatcherReceiver.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.Bzk.7
                    @Override // com.bytedance.sdk.component.utils.HomeWatcherReceiver.pA
                    public void pA() {
                        Bzk.this.KZx = true;
                    }

                    @Override // com.bytedance.sdk.component.utils.HomeWatcherReceiver.pA
                    public void Og() {
                        Bzk.this.KZx = true;
                    }
                });
                this.WV.getApplicationContext().registerReceiver(this.Sd, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            } catch (Throwable unused) {
            }
        }
    }

    private void pA(Context context) {
        if (this.omh) {
            try {
                this.Sd.pA(null);
                context.getApplicationContext().unregisterReceiver(this.Sd);
            } catch (Throwable unused) {
            }
        }
    }

    public void pA(String str) {
        if (this.omh && this.KZx) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", System.currentTimeMillis() - this.ZZv);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.RFPM", "sendPlayableEvent error", e);
            }
            com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.Wx, this.Sn, str, jSONObject);
            if ("return_foreground".equals(str)) {
                this.KZx = false;
            }
        }
    }

    public void ML() {
        if (this.omh && this.ZZv <= 0) {
            this.ZZv = System.currentTimeMillis();
            Handler handler = this.oX;
            handler.sendMessage(handler.obtainMessage(900, Bzk(), 0));
            KZx(true);
        }
    }

    public void pA(JSONObject jSONObject) {
        if (this.omh && jSONObject != null) {
            try {
                jSONObject.put("duration", System.currentTimeMillis() - this.ZZv);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.RFPM", "endShow json error", e);
            }
        }
    }

    public void KZx(int i) {
        com.bytedance.sdk.openadsdk.core.widget.BSW bsw;
        if (this.omh && (bsw = this.yFO) != null) {
            bsw.setProgress(i);
        }
    }

    public void pA(com.bytedance.sdk.openadsdk.core.Og.ML ml) {
        com.bytedance.sdk.openadsdk.core.widget.BSW bsw;
        if (!this.omh || (bsw = this.yFO) == null || bsw.getDownloadButton() == null) {
            return;
        }
        if (WQf.XT(this.Wx) || WQf.BF(this.Wx)) {
            this.yFO.getDownloadButton().setOnClickListener(ml);
            this.yFO.getDownloadButton().setOnTouchListener(ml);
        }
    }

    public void JG() {
        com.bytedance.sdk.openadsdk.yFO.omh omhVar;
        if (this.omh) {
            if (!WQf.omh(this.Wx) && this.yFO.isShown() && this.DX.Wo != null) {
                this.DX.Wo.pA(Bzk() * 1000);
            }
            if (WQf.yFO(this.Wx) && this.yFO.isShown()) {
                this.DX.gbA.Og(this.DX.nCO);
            }
            com.bytedance.sdk.openadsdk.core.widget.BSW bsw = this.yFO;
            if (bsw != null) {
                bsw.KZx();
            }
            if (this.pA.getAndSet(true)) {
                return;
            }
            if (this.DX.rB.Vgu() && (omhVar = this.TX) != null) {
                omhVar.pA(1);
            }
            if (WQf.SD(this.Wx) && WQf.BF(this.Wx)) {
                if (this.DX.rB != null && !this.DX.rB.Vgu()) {
                    int i = !this.DX.rB.XT() ? 2 : 3;
                    com.bytedance.sdk.openadsdk.yFO.omh omhVar2 = this.TX;
                    if (omhVar2 != null) {
                        omhVar2.pA(i);
                    }
                    if (WQf.XT(this.DX.Og)) {
                        pA(this.DX.JG, this.DX.Og, this.DX.Og.kK());
                        ML();
                        this.DX.FQ.BSW();
                    }
                    this.DX.gbA.pA(false);
                    this.DX.rB.gbA();
                    this.WQf = true;
                    this.DX.qmB.KZx(false);
                    this.DX.lT.pA(true);
                    this.DX.agB = true;
                    if (WQf.yFO(this.Wx)) {
                        this.oX.removeMessages(900);
                        this.DX.qmB.ZZv(false);
                        if (this.DX.Bf != null) {
                            this.DX.Bf.removeMessages(1);
                            this.DX.Bf.sendEmptyMessageDelayed(600, 1000L);
                        }
                    }
                    com.bytedance.sdk.openadsdk.yFO.omh omhVar3 = this.TX;
                    if (omhVar3 != null) {
                        omhVar3.KZx(true);
                        return;
                    }
                    return;
                }
                this.DX.gbA.pA(this.DX.nCO);
            }
        }
    }

    public void SD() {
        if (this.omh && !this.yFO.isShown()) {
            com.bytedance.sdk.openadsdk.core.widget.BSW bsw = this.yFO;
            if (bsw != null) {
                bsw.Og(this.Wx, this.XT);
                this.yFO.setProgress(this.DX.rB.SGo() != null ? this.DX.rB.SGo().getProgress() : 0);
            }
            com.bytedance.sdk.openadsdk.yFO.omh omhVar = this.TX;
            if (omhVar != null) {
                omhVar.Mc();
            }
        }
    }

    public boolean omh() {
        return this.BSW;
    }

    public void KZx(boolean z) {
        if (this.omh) {
            this.BSW = z;
            if (z) {
                return;
            }
            this.oX.removeMessages(900);
        }
    }

    public int ZZv(int i) {
        return this.SD - (this.JG - i);
    }

    public int Bzk() {
        return this.JG;
    }

    public int SGo() {
        return this.ML;
    }

    public void pA(int i, com.bytedance.sdk.openadsdk.core.model.yFO yfo, boolean z) {
        if (this.omh && yfo != null) {
            this.JG = yfo.mK();
            this.SD = com.bytedance.sdk.openadsdk.core.aBv.ZZv().pA(String.valueOf(i), z);
        }
    }

    public void ML(int i) {
        this.ML = i - 1;
    }

    public void JG(int i) {
        this.ML = i;
    }

    @Override // com.bytedance.sdk.openadsdk.WV.SD
    public void pA(int i) {
        if (this.omh) {
            if (!WQf.yFO(this.DX.Og) || this.DX.SGo.get()) {
                if (WQf.XT(this.DX.Og) || WQf.yFO(this.DX.Og)) {
                    if (this.DX.lT.Og()) {
                        boolean z = this.DX.agB;
                        this.DX.lT.pA();
                        if (i == 0) {
                            this.DX.qmB.Og(true);
                            this.DX.BF.Og(true);
                            return;
                        } else {
                            this.DX.qmB.Og(false);
                            this.DX.BF.Og(false);
                            return;
                        }
                    }
                    this.DX.lT.pA(-1);
                    boolean z2 = this.DX.agB;
                    this.DX.lT.pA();
                    if (this.DX.fN) {
                        if (i == 0) {
                            this.DX.agB = true;
                            this.DX.qmB.Og(true);
                            this.DX.BF.Og(true);
                        } else {
                            this.DX.agB = false;
                            this.DX.qmB.Og(false);
                            this.DX.BF.Og(false);
                        }
                    }
                }
            }
        }
    }

    public void BSW() {
        if (this.omh && this.TX != null && Vgu.ZZv(this.DX.rB.SGo())) {
            this.TX.KZx(true);
        }
    }

    public void WV() {
        if (this.omh) {
            com.bytedance.sdk.openadsdk.yFO.omh omhVar = this.TX;
            if (omhVar != null) {
                omhVar.KZx(false);
            }
            this.oX.removeMessages(900);
        }
    }

    public void ZZv(boolean z) {
        com.bytedance.sdk.openadsdk.yFO.omh omhVar;
        if (this.omh && (omhVar = this.TX) != null) {
            omhVar.KZx(z);
        }
    }

    public void ML(boolean z) {
        com.bytedance.sdk.openadsdk.yFO.omh omhVar;
        if (this.omh && (omhVar = this.TX) != null) {
            omhVar.pA(z);
        }
    }

    public void pA(int i, String str, String str2) {
        if (this.omh) {
            try {
                com.bytedance.sdk.openadsdk.yFO.omh omhVar = this.TX;
                if (omhVar != null) {
                    omhVar.JG(com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().pA(this.Wx));
                    this.TX.pA(i, str, str2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void pA(boolean z, String str, int i) {
        if (this.omh) {
            try {
                com.bytedance.sdk.openadsdk.yFO.omh omhVar = this.TX;
                if (omhVar != null) {
                    omhVar.JG(com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().pA(this.Wx));
                    this.TX.pA(z, str, i);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void Og(String str) {
        com.bytedance.sdk.openadsdk.yFO.omh omhVar = this.TX;
        if (omhVar != null) {
            if (!this.omh) {
                return;
            }
            omhVar.JG(com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().pA(this.Wx));
            this.TX.Bzk(str);
        }
        if (DX()) {
            this.DX.rB.ZZv(true);
            this.DX.lT.pA(true);
            this.DX.agB = true;
        }
    }

    public void KZx(String str) {
        com.bytedance.sdk.openadsdk.yFO.omh omhVar = this.TX;
        if (omhVar == null || !this.omh) {
            return;
        }
        omhVar.JG(com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().pA(this.Wx));
        this.TX.omh(str);
    }

    public void Wx() {
        if (this.omh) {
            this.oX.removeMessages(900);
            this.oX.removeMessages(600);
        }
    }

    public void pA(long j) {
        if (this.omh) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 900;
            messageObtain.arg1 = SGo();
            this.oX.sendMessageDelayed(messageObtain, j);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.bytedance.sdk.openadsdk.core.widget.BSW bsw;
        if (message.what == 900) {
            if (!this.BSW || !WQf.XT(this.DX.Og)) {
                return true;
            }
            int i = message.arg1;
            if (i > 0) {
                this.DX.qmB.ZZv(true);
                int iOg = this.DX.TV.Og(i);
                if (iOg == i) {
                    this.DX.qmB.pA(String.valueOf(i), null);
                } else if (iOg > 0) {
                    this.DX.qmB.pA(String.valueOf(i), String.format(com.bytedance.sdk.component.utils.yFO.pA(this.DX.SzT.getApplicationContext(), "tt_skip_ad_time_text"), Integer.valueOf(iOg)));
                } else if (WQf.omh(this.Wx) && !DX()) {
                    this.DX.qmB.pA(String.valueOf(i), com.bytedance.sdk.component.utils.yFO.pA(this.DX.SzT.getApplicationContext(), "tt_reward_screen_skip_tx"));
                    this.DX.qmB.ML(true);
                } else {
                    this.DX.yFO.set(true);
                    this.DX.nCO.DX();
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 900;
                messageObtain.arg1 = i - 1;
                this.oX.sendMessageDelayed(messageObtain, 1000L);
                ML(i);
            } else {
                if (WQf.omh(this.Wx) && (!WQf.BF(this.Wx) || !this.DX.TV.SD())) {
                    this.DX.qmB.KZx();
                    this.DX.qmB.ML(true);
                } else {
                    this.DX.qmB.ZZv(false);
                    this.DX.yFO.set(true);
                    this.DX.nCO.DX();
                }
                if (!this.Bzk) {
                    this.TV = true;
                }
            }
            this.DX.FQ.Sn();
        } else {
            if (message.what != 800 || ((bsw = this.yFO) != null && (!bsw.isShown() || this.yFO.ZZv()))) {
                return true;
            }
            JSONObject jSONObject = new JSONObject();
            long displayDuration = 0;
            try {
                jSONObject.put("remove_loading_page_type", message.arg1);
                if (message.arg2 != 0) {
                    jSONObject.put("remove_loading_page_reason", message.arg2);
                }
                String strWV = WQf.WV(this.Wx);
                pA pAVar = this.DX;
                if (pAVar != null && pAVar.rB != null) {
                    String strTV = this.DX.rB.TV();
                    if (!TextUtils.isEmpty(strTV)) {
                        strWV = strTV;
                    }
                }
                jSONObject.put("playable_url", strWV);
                com.bytedance.sdk.openadsdk.core.widget.BSW bsw2 = this.yFO;
                displayDuration = bsw2 != null ? bsw2.getDisplayDuration() : 0L;
                jSONObject.put("duration", displayDuration);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.RFPM", "handleMessage json error", e);
            }
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.DX.Og, this.DX.ML, "remove_loading_page", jSONObject, displayDuration);
            this.oX.removeMessages(800);
            if (!this.WV.isFinishing()) {
                this.DX.TV.ML();
            }
        }
        return true;
    }

    public com.bytedance.sdk.openadsdk.WV.ZZv Sn() {
        return this.eG;
    }

    public void JG(boolean z) {
        if (this.omh && z && !this.DX.TV.SD()) {
            com.bytedance.sdk.openadsdk.yFO.omh omhVar = this.TX;
            if (omhVar != null) {
                omhVar.pA(1);
            }
            boolean zXT = WQf.XT(this.Wx);
            if ((zXT || WQf.BF(this.Wx)) && this.Wx.Bpk() && !WQf.oX(this.Wx)) {
                Handler handler = this.oX;
                handler.sendMessageDelayed(handler.obtainMessage(800, 0, 0), 1000L);
            }
            if (zXT) {
                this.DX.TV.omh();
                this.DX.rB.Og(true);
                this.DX.rB.KZx(true);
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(System.currentTimeMillis(), this.DX.Og, this.Sn, "py_loading_success");
            }
        }
    }

    public boolean DX() {
        return this.WQf;
    }

    public boolean oX() {
        return this.TV;
    }

    public boolean aBv() {
        com.bytedance.sdk.openadsdk.core.widget.BSW bsw = this.yFO;
        return bsw != null && bsw.isShown();
    }

    public com.bytedance.sdk.openadsdk.yFO.omh XT() {
        return this.TX;
    }
}
