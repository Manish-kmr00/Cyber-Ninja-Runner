package com.bytedance.sdk.openadsdk.ZZv;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class BSW {
    private static final int[] Og = {10, 30, 50, 75, 100};
    private long BF;
    private boolean BSW;
    private int Bf;
    private final AtomicBoolean Bzk;
    private final AtomicInteger CIG;
    private com.bytedance.sdk.openadsdk.core.widget.pA.JG DX;
    private final AtomicBoolean FQ;
    private volatile int Gx;
    private volatile long HSv;
    private final AtomicInteger IG;
    private volatile long JBA;
    private final AtomicBoolean JG;
    private int KZx;
    private int ML;
    private final boolean Mc;
    private final AtomicBoolean SD;
    private int SGo;
    private final yFO Sd;
    private final Context Sn;
    private final AtomicInteger SzT;
    private long TV;
    private String TX;
    private volatile long Vgu;
    private long WQf;
    private String WV;
    private String Wx;
    private omh XT;
    private final AtomicBoolean YkC;
    private long ZZv;
    private com.bytedance.sdk.openadsdk.yFO.omh aBv;
    private volatile long agB;
    private String dC;
    private String dmv;
    private long du;
    private long eG;
    private long fJy;
    private final AtomicBoolean fN;
    private SGo gbA;
    private WeakReference<WebView> lT;
    private boolean oX;
    private final AtomicBoolean omh;
    public com.bytedance.sdk.openadsdk.core.widget.pA.JG.pA pA;
    private boolean qmB;
    private boolean rB;
    private boolean roi;
    private int vZF;
    private com.bytedance.sdk.openadsdk.ZZv.ZZv.ML xy;
    private boolean yFO;

    public yFO pA() {
        return this.Sd;
    }

    public BSW(yFO yfo, WebView webView, SGo sGo, int i) {
        this(yfo, webView);
        this.gbA = sGo;
        this.Bf = i;
    }

    public BSW(yFO yfo, WebView webView) {
        this(yfo, webView, false);
    }

    public BSW(yFO yfo, WebView webView, boolean z) {
        this.KZx = 0;
        this.ZZv = -1L;
        this.ML = 1;
        this.JG = new AtomicBoolean(false);
        this.SD = new AtomicBoolean(false);
        this.omh = new AtomicBoolean(false);
        this.Bzk = new AtomicBoolean(false);
        this.SGo = -1;
        this.yFO = false;
        this.TX = "landingpage";
        this.BF = 0L;
        this.WQf = 0L;
        this.TV = 0L;
        this.du = 0L;
        this.eG = 0L;
        this.roi = false;
        this.Mc = false;
        this.IG = new AtomicInteger(0);
        this.rB = false;
        this.qmB = false;
        this.Vgu = 0L;
        this.CIG = new AtomicInteger(0);
        this.SzT = new AtomicInteger(0);
        this.FQ = new AtomicBoolean(false);
        this.Gx = 0;
        this.Bf = -1;
        this.fN = new AtomicBoolean(false);
        this.YkC = new AtomicBoolean(false);
        Context contextPA = com.bytedance.sdk.openadsdk.core.aBv.pA();
        this.Sn = contextPA;
        this.Sd = yfo;
        if (webView == null) {
            return;
        }
        this.yFO = z;
        WeakReference<WebView> weakReference = new WeakReference<>(webView);
        this.lT = weakReference;
        WebView webView2 = weakReference.get();
        if (webView2 == null) {
            return;
        }
        if (yfo != null && yfo.agB()) {
            com.bytedance.sdk.openadsdk.core.widget.pA.JG jg = new com.bytedance.sdk.openadsdk.core.widget.pA.JG(webView2, yfo, contextPA, this.yFO);
            this.DX = jg;
            this.pA = jg.KZx();
        }
        if (yfo != null && yfo.fN() && com.bytedance.sdk.openadsdk.core.settings.oX.vkV().uQ()) {
            this.XT = new omh(yfo, webView, this.yFO);
        }
        if (webView instanceof com.bytedance.sdk.component.Bzk.KZx) {
            this.fJy = ((com.bytedance.sdk.component.Bzk.KZx) webView2).pA;
        } else {
            this.fJy = System.currentTimeMillis();
        }
        try {
            PangleNetworkBridge.onAddedJavascriptInterface(webView2, new pA(), "JS_LANDING_PAGE_LOG_OBJ");
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("LandingPageLog", "addJavascriptInterface exception", e);
        }
        if (yfo != null && yfo.fg() != null) {
            this.ZZv = yfo.fg().optLong("page_id", -1L);
        }
        this.dC = String.valueOf(SystemClock.elapsedRealtime());
    }

    public void pA(long j) {
        this.WQf = j;
    }

    public void pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.pA.JG jg = this.DX;
        if (jg != null) {
            jg.pA(str);
        }
        omh omhVar = this.XT;
        if (omhVar != null) {
            omhVar.KZx(str);
        }
        this.TX = str;
    }

    public void pA(int i) {
        this.Bf = i;
    }

    public com.bytedance.sdk.openadsdk.ZZv.ZZv.ML Og() {
        return this.xy;
    }

    public void pA(com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml) {
        this.xy = ml;
    }

    public BSW pA(boolean z) {
        this.rB = z;
        return this;
    }

    public boolean KZx() {
        return this.qmB;
    }

    public void Og(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.dmv = str;
    }

    public void pA(com.bytedance.sdk.openadsdk.yFO.omh omhVar) {
        this.aBv = omhVar;
    }

    public void Og(boolean z) {
        this.qmB = z;
    }

    public void ZZv() {
        if (Bzk()) {
            this.HSv = SystemClock.elapsedRealtime();
            KZx.pA(this.Sd, this.dmv);
        }
    }

    public void ML() {
        if (Bzk()) {
            this.JBA = SystemClock.elapsedRealtime();
            JG();
        }
    }

    public void JG() {
        if (Bzk() && this.JBA > 0 && this.agB > 0 && !this.fN.getAndSet(true)) {
            KZx.Og(this.agB - this.JBA, this.Sd, this.dmv, (String) null);
        }
    }

    public void pA(WebView webView, int i) {
        if (webView == null) {
            return;
        }
        if (this.Vgu == 0) {
            this.Vgu = SystemClock.elapsedRealtime();
        }
        if (this.TV == 0 && i > 0) {
            this.TV = System.currentTimeMillis();
        } else if (this.du == 0 && i == 100) {
            this.du = System.currentTimeMillis();
        }
        if (this.KZx != Og.length && ("landingpage".equals(this.TX) || "landingpage_endcard".equals(this.TX) || "landingpage_split_screen".equals(this.TX) || "landingpage_direct".equals(this.TX) || "aggregate_page".equals(this.TX))) {
            int i2 = this.KZx;
            while (true) {
                int[] iArr = Og;
                if (i2 >= iArr.length || i < iArr[this.KZx]) {
                    break;
                }
                int i3 = i2 + 1;
                this.KZx = i3;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", webView.getUrl());
                    long j = this.ZZv;
                    if (j != -1) {
                        jSONObject.put("page_id", j);
                    }
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                    jSONObject.put("pct", iArr[i2]);
                } catch (Exception unused) {
                }
                pA("progress_load_finish", jSONObject);
                i2 = i3;
            }
        }
        if (i == 100) {
            pA(webView.getUrl(), "progress", Math.min(this.du - this.TV, 600000L));
        }
    }

    private void pA(String str, String str2, long j) {
        if (this.omh.compareAndSet(false, true)) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (str.length() > 200) {
                    int iIndexOf = str.indexOf(38, 200);
                    int i = 300;
                    if (iIndexOf == -1 || iIndexOf > 300) {
                        iIndexOf = str.indexOf(63);
                    }
                    if (iIndexOf != -1 && iIndexOf <= 300) {
                        i = iIndexOf;
                    }
                    str = str.substring(0, i);
                }
                jSONObject.put("url", str);
                jSONObject.put("type", str2);
            } catch (Throwable unused) {
            }
            pA("load_finish_progress", jSONObject, j);
        }
    }

    public void pA(WebView webView, String str, Bitmap bitmap, boolean z, int i) {
        this.oX = z;
        this.vZF++;
        com.bytedance.sdk.openadsdk.core.widget.pA.JG jg = this.DX;
        if (jg != null && z) {
            jg.Og(str);
            this.DX.Og();
        }
        omh omhVar = this.XT;
        if (omhVar != null && z) {
            omhVar.pA(str, i);
        }
        WeakReference<WebView> weakReference = this.lT;
        WebView webView2 = weakReference != null ? weakReference.get() : null;
        if (webView2 != null) {
            try {
                WebBackForwardList webBackForwardListCopyBackForwardList = webView2.copyBackForwardList();
                if (webBackForwardListCopyBackForwardList != null && webBackForwardListCopyBackForwardList.getCurrentIndex() > this.Gx) {
                    this.CIG.incrementAndGet();
                }
                this.Gx = webBackForwardListCopyBackForwardList.getCurrentIndex();
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.WV.pA("LandingPageLog", "copyBackForwardList exception", e);
            }
        }
        if (this.Vgu == 0) {
            this.Vgu = SystemClock.elapsedRealtime();
        }
        com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml = this.xy;
        if (ml != null) {
            ml.ML();
        }
        if (this.JG.compareAndSet(false, true)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
                int i2 = this.Bf;
                if (i2 >= 0) {
                    jSONObject.putOpt("preload_status", Integer.valueOf(i2));
                }
            } catch (Exception unused) {
            }
            pA("load_start", jSONObject);
        }
    }

    public void pA(WebView webView, String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.widget.pA.JG jg = this.DX;
        if (jg != null && z) {
            jg.pA();
        }
        com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml = this.xy;
        if (ml != null) {
            ml.JG();
        }
        omh omhVar = this.XT;
        if (omhVar != null && z) {
            omhVar.pA(str);
        }
        if (webView != null && !this.roi && this.rB) {
            this.roi = true;
            com.bytedance.sdk.component.utils.BSW.pA(webView, "javascript:\nfunction sendScroll(){\n   var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n   var clientH = window.innerHeight || document.documentElement.clientHeight;\n   var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n   var validH = scrollH + clientH;\n   var result = (validH/totalH*100).toFixed(2);\n   console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n   window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n}\nsendScroll();\nwindow.addEventListener('scroll', function(e){\n    sendScroll();\n});");
        }
        if (this.SD.compareAndSet(false, true)) {
            if (this.ML != 3) {
                this.ML = 2;
            }
            this.BF = System.currentTimeMillis();
            boolean z2 = this.ML == 2;
            int iSGo = SGo();
            if (z2) {
                long j = this.du - this.TV;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("error_code", this.SGo);
                    jSONObject.put("error_msg", this.WV);
                    jSONObject.put("error_url", this.Wx);
                    int i = this.Bf;
                    if (i >= 0) {
                        jSONObject.put("preload_status", i);
                    }
                    jSONObject.put("first_page", iSGo);
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                    jSONObject.put("url", this.Sd.dC());
                    jSONObject.put("preload_h5_type", this.Sd.Bi());
                } catch (Exception unused) {
                }
                pA(z, "0");
                long jMin = Math.min(j, 600000L);
                pA("load_finish", jSONObject, jMin);
                if (Bzk()) {
                    this.agB = SystemClock.elapsedRealtime();
                    JG();
                    KZx.pA(this.Sd, this.dmv, this.agB - this.HSv);
                }
                pA(str, "load_finish", jMin);
                SGo sGo = this.gbA;
                if (sGo != null) {
                    sGo.pA(iSGo);
                    return;
                }
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("error_code", this.SGo);
                jSONObject2.put("error_msg", this.WV);
                jSONObject2.put("error_url", this.Wx);
                jSONObject2.put("first_page", iSGo);
                int i2 = this.Bf;
                if (i2 >= 0) {
                    jSONObject2.put("preload_status", i2);
                }
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                jSONObject2.put("url", this.Sd.dC());
                jSONObject2.put("preload_h5_type", this.Sd.Bi());
            } catch (Exception unused2) {
            }
            pA(z, "2");
            pA(Reporting.EventType.LOAD_FAIL, jSONObject2);
            if (Bzk()) {
                KZx.pA(this.Sd, this.dmv, SystemClock.elapsedRealtime() - this.HSv, this.SGo, this.WV, this.Wx);
            }
            if (this.BSW) {
                jSONObject2.remove("render_type");
                jSONObject2.remove("render_type_2");
                pA("load_fail_main", jSONObject2);
            }
        }
    }

    private boolean Bzk() {
        yFO yfo;
        return this.qmB && (yfo = this.Sd) != null && yfo.eD();
    }

    private String KZx(String str) {
        return "javascript:".concat(String.valueOf(str));
    }

    public void pA(WebView webView, int i, String str, String str2, String str3, boolean z) {
        com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml = this.xy;
        if (ml != null) {
            ml.pA((JSONObject) null);
        }
        if ((str3 == null || !str3.startsWith("image")) && this.ML != 2) {
            this.ML = 3;
        }
        this.SGo = i;
        this.WV = str;
        this.Wx = str2;
        this.BSW = z;
    }

    public void SD() {
        if (this.eG == 0) {
            this.eG = System.currentTimeMillis();
        }
        this.BF = System.currentTimeMillis();
        if ("landingpage".equals(this.TX) || "landingpage_endcard".equals(this.TX) || "landingpage_split_screen".equals(this.TX) || "landingpage_direct".equals(this.TX) || "aggregate_page".equals(this.TX)) {
            if (this.YkC.compareAndSet(false, true)) {
                com.bytedance.sdk.openadsdk.JG.Og.pA().pA("landingStart", this.Sd, this.dC);
            } else {
                com.bytedance.sdk.openadsdk.JG.Og.pA().pA("landingContinue", this.Sd, this.dC);
            }
        }
    }

    public void omh() {
        if (("landingpage".equals(this.TX) || "landingpage_endcard".equals(this.TX) || "landingpage_split_screen".equals(this.TX) || "landingpage_direct".equals(this.TX) || "aggregate_page".equals(this.TX)) && this.ML == 2) {
            if (this.WQf > 0 || !KZx()) {
                long jCurrentTimeMillis = System.currentTimeMillis() - Math.max(this.BF, this.WQf);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("load_status", this.ML);
                    jSONObject.put("max_scroll_percent", this.IG.get());
                    jSONObject.put("jump_times", this.CIG.getAndSet(0));
                    jSONObject.put("click_times", this.SzT.getAndSet(0));
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                } catch (JSONException unused) {
                }
                this.Bzk.set(true);
                pA("stay_page", jSONObject, Math.min(jCurrentTimeMillis, 600000L));
                com.bytedance.sdk.openadsdk.JG.Og.pA().pA("landingPause", this.Sd, this.dC);
            }
        }
    }

    public void pA(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        int iPV;
        Bitmap bitmapPA;
        yFO yfo;
        if ((!"landingpage".equals(this.TX) && !"landingpage_endcard".equals(this.TX) && !"landingpage_split_screen".equals(this.TX) && !"landingpage_direct".equals(this.TX) && !"aggregate_page".equals(this.TX)) || (iPV = com.bytedance.sdk.openadsdk.core.aBv.ZZv().PV()) == 0 || new Random().nextInt(100) + 1 > iPV || zZv == null || zZv.getWebView() == null || zZv.getVisibility() != 0 || (bitmapPA = Vgu.pA(zZv)) == null || (yfo = this.Sd) == null) {
            return;
        }
        Vgu.pA(yfo, this.TX, "landing_page_blank", bitmapPA, zZv.getUrl(), this.ZZv);
    }

    public void KZx(boolean z) {
        WeakReference<WebView> weakReference = this.lT;
        WebView webView = weakReference != null ? weakReference.get() : null;
        if (webView != null) {
            try {
                webView.removeJavascriptInterface("JS_LANDING_PAGE_LOG_OBJ");
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.WV.pA("LandingPageLog", "removeJavascriptInterface exception", e);
            }
        }
        if (this.SD.compareAndSet(false, true)) {
            pA(z, "1");
            if (this.rB) {
                KZx.pA(this.Sd, this.TX, System.currentTimeMillis() - this.eG, this.Bf, SGo());
            }
        } else if (this.ML == 2 && !this.Bzk.get()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("load_status", this.ML);
                jSONObject.put("max_scroll_percent", this.IG.get());
                jSONObject.put("jump_times", this.CIG.getAndSet(0));
                jSONObject.put("click_times", this.SzT.getAndSet(0));
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
            } catch (JSONException unused) {
            }
            pA("stay_page", jSONObject, 0L);
        }
        if ("landingpage".equals(this.TX) || "landingpage_endcard".equals(this.TX) || "landingpage_split_screen".equals(this.TX) || "landingpage_direct".equals(this.TX) || "aggregate_page".equals(this.TX)) {
            com.bytedance.sdk.openadsdk.JG.Og.pA().pA("landingFinish", this.Sd, this.dC);
        }
    }

    public void Og(WebView webView, String str, boolean z) {
        omh omhVar = this.XT;
        if (omhVar == null || !z) {
            return;
        }
        omhVar.pA(webView, str);
    }

    private void pA(String str, JSONObject jSONObject) {
        pA(str, jSONObject, -1L);
    }

    private void pA(final String str, final JSONObject jSONObject, final long j) {
        if (!this.rB || this.Sd == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.yFO.omh omhVar = this.aBv;
        final int iGbA = omhVar != null ? omhVar.gbA() : -1;
        KZx.pA(System.currentTimeMillis(), this.Sd, this.TX, str, new com.bytedance.sdk.openadsdk.Sn.KZx.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.BSW.1
            @Override // com.bytedance.sdk.openadsdk.Sn.KZx.pA
            public JSONObject pA() {
                if (jSONObject == null) {
                    return null;
                }
                try {
                    boolean zOg = WQf.Og(BSW.this.Sd);
                    int i = 0;
                    jSONObject.put("is_playable", zOg ? 1 : 0);
                    jSONObject.put("usecache", com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().pA(BSW.this.Sd) ? 1 : 0);
                    if (zOg && ("load_finish".equals(str) || Reporting.EventType.LOAD_FAIL.equals(str))) {
                        jSONObject.put("playable_has_show", iGbA);
                    }
                    if ("stay_page".equals(str)) {
                        JSONObject jSONObject2 = jSONObject;
                        if (BSW.this.vZF <= 1) {
                            i = 1;
                        }
                        jSONObject2.put("first_page", i);
                    }
                } catch (JSONException unused) {
                }
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("ad_extra_data", jSONObject.toString());
                        long j2 = j;
                        if (j2 > 0) {
                            jSONObject3.put("duration", j2);
                        }
                    } catch (JSONException unused2) {
                    }
                    return jSONObject3;
                } catch (JSONException unused3) {
                    return null;
                }
            }
        });
    }

    private class pA {
        private pA() {
        }

        @JavascriptInterface
        public void readPercent(String str) {
            int i = 0;
            try {
                int iIntValue = Float.valueOf(str).intValue();
                if (iIntValue > 100) {
                    i = 100;
                } else if (iIntValue >= 0) {
                    i = iIntValue;
                }
            } catch (Throwable unused) {
            }
            BSW.this.IG.set(i);
        }

        @JavascriptInterface
        public String getUrl() {
            return "";
        }
    }

    public void pA(MotionEvent motionEvent) {
        com.bytedance.sdk.openadsdk.core.widget.pA.JG jg = this.DX;
        if (jg != null && this.oX) {
            jg.pA(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.Vgu != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                this.SzT.incrementAndGet();
                if (this.FQ.getAndSet(true)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", this.Sd.dC());
                } catch (JSONException unused) {
                }
                pA("click_time", jSONObject, Math.max(SystemClock.elapsedRealtime() - this.Vgu, 0L));
            }
        }
    }

    public void pA(String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.widget.pA.JG jg = this.DX;
        if (jg != null && z) {
            jg.KZx(str);
        }
        omh omhVar = this.XT;
        if (omhVar == null || !z) {
            return;
        }
        omhVar.Og(str);
    }

    public void Og(int i) {
        com.bytedance.sdk.openadsdk.core.widget.pA.JG jg = this.DX;
        if (jg == null || !this.oX) {
            return;
        }
        jg.pA(i);
    }

    private void pA(boolean z, final String str) {
        if (z) {
            final int iSGo = SGo();
            KZx.pA(new com.bytedance.sdk.component.omh.omh("sendPrefLog") { // from class: com.bytedance.sdk.openadsdk.ZZv.BSW.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.bytedance.sdk.openadsdk.core.settings.SD sdTV = com.bytedance.sdk.openadsdk.core.aBv.ZZv().TV();
                        boolean zPA = BSW.this.pA(sdTV, str);
                        if (zPA) {
                            if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.settings.SD.Og)) {
                                BSW.this.pA(iSGo, str);
                                return;
                            }
                            if (TextUtils.isEmpty(sdTV.KZx) || !zPA) {
                                return;
                            }
                            String str2 = sdTV.KZx;
                            com.bytedance.sdk.component.SD.Og.Og ogKZx = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().KZx();
                            ogKZx.Og(str2);
                            HashMap map = new HashMap();
                            map.put("content-type", "application/json; charset=utf-8");
                            ogKZx.ZZv(map);
                            ogKZx.pA(9);
                            ogKZx.pA("sendPrefLog");
                            ogKZx.pA(new com.bytedance.sdk.component.SD.pA.pA() { // from class: com.bytedance.sdk.openadsdk.ZZv.BSW.2.1
                                @Override // com.bytedance.sdk.component.SD.pA.pA
                                public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, IOException iOException) {
                                }

                                @Override // com.bytedance.sdk.component.SD.pA.pA
                                public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, com.bytedance.sdk.component.SD.Og og) {
                                    try {
                                        com.bytedance.sdk.openadsdk.core.settings.SD.Og = og.ZZv();
                                        BSW.this.pA(iSGo, str);
                                    } catch (Exception e) {
                                        com.bytedance.sdk.component.utils.WV.pA("LandingPageLog", "TTWebViewClient : onPageFinished", e);
                                    }
                                }
                            });
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.WV.Og(th.getMessage());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(int i, String str) {
        try {
            if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.settings.SD.Og)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb = new StringBuilder(com.bytedance.sdk.openadsdk.core.settings.SD.Og);
            jSONObject.putOpt("cid", pA().nCO());
            jSONObject.putOpt(CreativeInfo.c, pA().nCO());
            jSONObject.put("log_extra", pA().tM());
            gbA.pA(sb, "\"/** adInfo **/\"", jSONObject.toString());
            gbA.pA(sb, "\"/** first_page **/\"", String.valueOf(i));
            gbA.pA(sb, "\"/** ix_to_externalurl **/\"", this.ZZv != -1 ? "1" : "0");
            gbA.pA(sb, "\"/** preload_status **/\"", this.Bf == 2 ? "2" : "0");
            gbA.pA(sb, "\"/** scene_state **/\"", str);
            gbA.pA(sb, "\"/** web_init_time **/\"", String.valueOf(this.fJy));
            gbA.pA(sb, "\"/** channel_name **/\"", "\"" + pA().Gag() + "\"");
            gbA.pA(sb, "\"/** session_id **/\"", "\"" + UUID.randomUUID().toString() + "\"");
            gbA.pA(sb, "\"/** web_url **/\"", "\"" + pA().dC() + "\"");
            String string = sb.toString();
            if (TextUtils.isEmpty(string)) {
                return;
            }
            final String strKZx = KZx(string);
            WeakReference<WebView> weakReference = this.lT;
            final WebView webView = weakReference != null ? weakReference.get() : null;
            if (TextUtils.isEmpty(strKZx) || webView == null) {
                return;
            }
            xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ZZv.BSW.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.utils.BSW.pA(webView, strKZx);
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.Og(th.getMessage());
        }
    }

    private int SGo() {
        WeakReference<WebView> weakReference = this.lT;
        WebView webView = weakReference != null ? weakReference.get() : null;
        if (webView != null) {
            try {
                WebBackForwardList webBackForwardListCopyBackForwardList = webView.copyBackForwardList();
                if (webBackForwardListCopyBackForwardList != null && webBackForwardListCopyBackForwardList.getCurrentIndex() == 0) {
                    return 1;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pA(com.bytedance.sdk.openadsdk.core.settings.SD sd, String str) {
        str.hashCode();
        switch (str) {
            case "0":
                return sd.ZZv;
            case "1":
                return sd.ML;
            case "2":
                return sd.JG;
            default:
                return false;
        }
    }
}
