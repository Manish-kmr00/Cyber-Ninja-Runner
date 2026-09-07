package com.bytedance.sdk.openadsdk.core.omh;

import android.R;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.IG;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.rB;
import com.bytedance.sdk.openadsdk.utils.xy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class WQf extends com.bytedance.sdk.component.adexpress.ML.pA {
    private com.bytedance.sdk.openadsdk.ZZv.ZZv.ML BSW;
    private com.bytedance.sdk.openadsdk.core.model.yFO Bzk;
    private IG DX;
    com.bytedance.sdk.openadsdk.utils.pA JG;
    private Context SD;
    private JSONObject SGo;
    private final Runnable Sd;
    private final Map<String, com.bytedance.sdk.openadsdk.XT.pA.pA.JG> Sn;
    private String WV;
    private com.bytedance.sdk.openadsdk.ZZv.BSW Wx;
    private volatile int XT;
    private com.bytedance.sdk.openadsdk.core.model.yFO.pA aBv;
    private com.bytedance.sdk.component.adexpress.Og.SD oX;
    private String omh;
    private final com.bytedance.sdk.component.omh.omh vZF;
    private SGo yFO;

    public WQf(Context context, com.bytedance.sdk.component.adexpress.Og.Wx wx, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml, com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        super(context, wx, themeStatusBroadcastReceiver);
        this.Sn = Collections.synchronizedMap(new HashMap());
        this.XT = 0;
        this.vZF = new com.bytedance.sdk.component.omh.omh("webviewrender_template") { // from class: com.bytedance.sdk.openadsdk.core.omh.WQf.1
            @Override // java.lang.Runnable
            public void run() {
                if (WQf.this.ML.get()) {
                    return;
                }
                if ((WQf.this.Bzk instanceof com.bytedance.sdk.openadsdk.core.model.vZF) && ((com.bytedance.sdk.openadsdk.core.model.vZF) WQf.this.Bzk).PF()) {
                    WQf.this.Og(true);
                }
                WQf wQf = WQf.this;
                wQf.SGo = wQf.BSW().KZx();
                WQf wQf2 = WQf.this;
                wQf2.pA(wQf2.SGo);
                if (WQf.this.XT == 0) {
                    WQf.this.aBv();
                }
                com.bytedance.sdk.openadsdk.core.Sn.KZx().post(WQf.this.Sd);
            }
        };
        this.Sd = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.omh.WQf.2
            @Override // java.lang.Runnable
            public void run() {
                if (WQf.this.ML.get() || WQf.this.oX == null) {
                    return;
                }
                WQf.this.WV();
                WQf wQf = WQf.this;
                WQf.super.pA(wQf.oX);
            }
        };
        if (this.KZx == null) {
            return;
        }
        this.SD = context;
        this.omh = wx.ZZv();
        this.Bzk = yfo;
        this.BSW = ml;
        themeStatusBroadcastReceiver.pA(this);
        aBv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBv() {
        if (this.KZx.getWebView() != null && xy.ML()) {
            XT();
        } else {
            this.XT = 1;
            xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.omh.WQf.3
                @Override // java.lang.Runnable
                public void run() {
                    WQf.this.XT();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XT() {
        if (this.KZx == null || this.KZx.getWebView() == null || this.XT == 2) {
            return;
        }
        this.WV = pA(this.Bzk);
        this.KZx.setDisplayZoomControls(false);
        pA(rB.pA(this.WV));
        Wx();
        IG ig = new IG(this.SD);
        this.DX = ig;
        ig.ZZv(true);
        Sn();
        this.XT = 2;
    }

    public static String pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        return com.bytedance.sdk.component.adexpress.pA.Og.Og.ZZv((yfo == null || !yfo.SzT()) ? null : "v3");
    }

    public void WV() {
        IG ig;
        if (this.KZx == null || this.KZx.getWebView() == null || (ig = this.DX) == null) {
            return;
        }
        ig.Og(this.KZx).pA(this.Bzk).KZx(this.Bzk.nCO()).ZZv(this.Bzk.tM()).Og(gbA.pA(this.omh)).ML(this.Bzk.jK()).pA(this).pA(this.SGo).pA(this.KZx).pA(this.BSW);
    }

    public void Wx() {
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.Bzk;
        if (yfo == null || yfo.CIG() == null) {
            return;
        }
        this.aBv = this.Bzk.CIG();
    }

    public void Sn() {
        if (this.KZx == null || this.KZx.getWebView() == null) {
            return;
        }
        this.KZx.setBackgroundColor(0);
        this.KZx.setBackgroundResource(R.color.transparent);
        pA(this.KZx);
        if (pA() != null) {
            this.Wx = new com.bytedance.sdk.openadsdk.ZZv.BSW(this.Bzk, pA().getWebView()).pA(false);
        }
        this.Wx.pA(this.BSW);
        this.yFO = new SGo(this.SD, this.DX, this.Bzk, this.Wx, BSW());
        this.KZx.setWebViewClient(this.yFO);
        this.KZx.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.pA.ZZv(this.DX, this.Wx));
        com.bytedance.sdk.component.adexpress.ML.ML.pA().pA(this.KZx, this.DX);
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.pA
    protected void Bzk() {
        super.Bzk();
        com.bytedance.sdk.openadsdk.utils.pA pAVarML = com.bytedance.sdk.openadsdk.core.DX.pA().ML();
        this.JG = pAVarML;
        pAVarML.pA(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.pA
    protected void SGo() {
        super.SGo();
        com.bytedance.sdk.openadsdk.utils.pA pAVar = this.JG;
        if (pAVar != null) {
            pAVar.Og(this);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.pA, com.bytedance.sdk.component.adexpress.Og.ZZv
    public void pA(com.bytedance.sdk.component.adexpress.Og.SD sd) {
        this.oX = sd;
        xy.Og(this.vZF);
    }

    private void pA(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        if (zZv == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.pA.KZx.pA(this.SD).pA(false).pA(zZv.getWebView());
            zZv.setVerticalScrollBarEnabled(false);
            zZv.setHorizontalScrollBarEnabled(false);
            com.bytedance.sdk.openadsdk.core.widget.pA.KZx.pA(zZv);
            zZv.SGo();
            zZv.setUserAgentString(com.bytedance.sdk.openadsdk.utils.aBv.pA(zZv.getWebView(), BuildConfig.VERSION_CODE));
            zZv.setMixedContentMode(0);
            zZv.setJavaScriptEnabled(true);
            zZv.setJavaScriptCanOpenWindowsAutomatically(true);
            zZv.setDomStorageEnabled(true);
            zZv.setDatabaseEnabled(true);
            zZv.setAllowFileAccess(false);
            zZv.setSupportZoom(true);
            zZv.setBuiltInZoomControls(true);
            zZv.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            zZv.setUseWideViewPort(true);
            zZv.setCacheMode(-1);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.WebViewRender", e.toString());
        }
    }

    public SGo DX() {
        return this.yFO;
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.pA
    public com.bytedance.sdk.component.Bzk.ZZv pA() {
        return this.KZx;
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.pA
    public void ZZv() {
        if (this.ML.get()) {
            return;
        }
        super.ZZv();
        IG ig = this.DX;
        if (ig != null) {
            ig.Og();
            this.DX.BSW();
            this.DX = null;
        }
        com.bytedance.sdk.openadsdk.ZZv.BSW bsw = this.Wx;
        if (bsw != null) {
            bsw.KZx(false);
        }
        com.bytedance.sdk.openadsdk.core.Sn.KZx().removeCallbacks(this.Sd);
        this.Sn.clear();
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.pA, com.bytedance.sdk.component.adexpress.Og.ZZv
    public int KZx() {
        return this.Bzk.du();
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.pA
    public void JG() {
        if (pA() == null) {
            return;
        }
        try {
            pA().getWebView().resumeTimers();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.pA
    public void omh() {
        super.omh();
        if (this.DX == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.DX.pA("expressShow", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void Og(int i) {
        if (this.DX == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("zoom_type", i);
            this.DX.pA("expressAdViewWillZoom", jSONObject);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.WebViewRender", e.getMessage());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.pA
    public void SD() {
        IG ig = this.DX;
        if (ig == null) {
            return;
        }
        ig.pA("expressWebviewRecycle", (JSONObject) null);
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.pA
    public void pA(int i) {
        if (i == this.ZZv) {
            return;
        }
        this.ZZv = i;
        KZx(i == 0);
    }

    private void KZx(boolean z) {
        if (this.DX == null || this.KZx == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", z);
            this.DX.pA("expressAdShow", jSONObject);
        } catch (Exception unused) {
        }
    }

    public IG oX() {
        return this.DX;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.pA
    public void onThemeChanged(int i) {
        if (this.DX == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
        } catch (JSONException unused) {
        }
        this.DX.pA("themeChange", jSONObject);
    }

    public static boolean Og(String str) {
        return "banner_call".equals(str) || "banner_ad".equals(str) || "slide_banner_ad".equals(str) || "banner_ad_landingpage".equals(str);
    }

    @Override // com.bytedance.sdk.component.adexpress.ML.pA, com.bytedance.sdk.component.adexpress.Og.BSW
    public void pA(com.bytedance.sdk.component.adexpress.Og.Sn sn) {
        super.pA(sn);
        if (this.Og) {
            com.bytedance.sdk.component.utils.SD.Og().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.omh.WQf.4
                @Override // java.lang.Runnable
                public void run() {
                    WebView webView = WQf.this.KZx.getWebView();
                    if (webView != null) {
                        webView.resumeTimers();
                    }
                }
            }, 2000L);
        }
    }
}
