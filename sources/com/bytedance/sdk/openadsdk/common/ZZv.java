package com.bytedance.sdk.openadsdk.common;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.TV;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ZZv implements TV.pA {
    private int Bzk;
    private long DX;
    private WebView KZx;
    private KZx ML;
    private final boolean Og;
    private long SGo;
    private boolean Sn;
    private int Wx;
    private final com.bytedance.sdk.component.Bzk.ZZv ZZv;
    private boolean oX;
    private float omh;
    private final yFO pA;
    private String vZF;
    private int yFO;
    private String JG = "landingpage";
    private final Handler SD = new TV(com.bytedance.sdk.openadsdk.core.Sn.Og().getLooper(), this);
    private final AtomicBoolean BSW = new AtomicBoolean(false);
    private Pattern WV = null;
    private long XT = -1;
    private final List<Integer> aBv = new ArrayList();

    public ZZv(yFO yfo, com.bytedance.sdk.component.Bzk.ZZv zZv, String str, boolean z) {
        this.pA = yfo;
        this.ZZv = zZv;
        this.Og = z;
        Og();
    }

    public void pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.JG = str;
    }

    private void Og() {
        com.bytedance.sdk.component.Bzk.ZZv zZv = this.ZZv;
        if (zZv != null) {
            this.KZx = zZv.getWebView();
            View arbitrageLoadingView = this.ZZv.getArbitrageLoadingView();
            if (arbitrageLoadingView instanceof KZx) {
                this.ML = (KZx) arbitrageLoadingView;
            }
        }
        this.Bzk = com.bytedance.sdk.openadsdk.core.settings.oX.vkV().jO();
        this.omh = com.bytedance.sdk.openadsdk.core.settings.oX.vkV().FGT();
    }

    public void pA(WebView webView, String str, boolean z) {
        if (z && JG()) {
            pA();
        }
    }

    public void pA(WebView webView, String str) {
        yFO yfo = this.pA;
        if (yfo == null || !com.bytedance.sdk.component.Bzk.Og.pA(yfo.BSW().KZx(), str)) {
            return;
        }
        this.Wx++;
        com.bytedance.sdk.component.utils.SD.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.ZZv.1
            @Override // java.lang.Runnable
            public void run() {
                if (ZZv.this.JG()) {
                    ZZv.this.pA();
                }
            }
        });
    }

    public void pA(WebView webView, int i) {
        KZx kZx = this.ML;
        if (kZx != null) {
            kZx.pA(i);
        }
        if (this.oX) {
            if (pA(i, 30)) {
                pA(30, webView);
            }
            if (pA(i, 50)) {
                pA(50, webView);
            }
            if (pA(i, 70)) {
                pA(70, webView);
            }
        }
        if (this.ML == null || i != 100) {
            return;
        }
        pA(1);
    }

    public void Og(WebView webView, String str, boolean z) {
        if (!z || this.ML == null) {
            return;
        }
        pA(1);
    }

    public void KZx(WebView webView, String str, boolean z) {
        this.aBv.clear();
        this.oX = z;
        if (z) {
            this.Sn = true;
        }
        this.yFO = SD();
    }

    private void KZx() {
        Handler handler = this.SD;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(1, this.Bzk);
        }
    }

    private void ZZv() {
        Handler handler = this.SD;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void pA() {
        if (xy.ML()) {
            ML();
        } else {
            com.bytedance.sdk.component.utils.SD.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.ZZv.2
                @Override // java.lang.Runnable
                public void run() {
                    ZZv.this.ML();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ML() {
        this.Sn = false;
        if (this.BSW.getAndSet(true)) {
            return;
        }
        this.SGo = SystemClock.elapsedRealtime();
        this.DX = System.currentTimeMillis();
        omh();
        if (this.ML == null) {
            return;
        }
        WebView webView = this.KZx;
        if (webView != null) {
            String url = webView.getUrl();
            this.vZF = url;
            new Object[]{"showLoadingUrl is:", url};
        }
        this.ML.setVisibility(0);
        this.ML.pA(this.pA);
        this.ML.pA();
        this.ML.setAlpha(this.omh);
        this.ML.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.common.ZZv.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/common/ZZv$3;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                CreativeInfoManager.onViewTouched(h.u, view, motionEvent);
                return safedk_ZZv$3_onTouch_fe6d65056a0fe309f460a75699790b11(view, motionEvent);
            }

            public boolean safedk_ZZv$3_onTouch_fe6d65056a0fe309f460a75699790b11(View p0, MotionEvent p1) {
                return true;
            }
        });
        ZZv();
        KZx();
    }

    private void pA(final int i) {
        WebView webView = this.KZx;
        if (webView != null && i == 1) {
            String url = webView.getUrl();
            new Object[]{"destroyLoadingUrl is:", url};
            if (TextUtils.isEmpty(url) || url.equals(this.vZF)) {
                return;
            }
        }
        com.bytedance.sdk.component.utils.SD.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.ZZv.4
            @Override // java.lang.Runnable
            public void run() {
                if (ZZv.this.ML != null) {
                    ZZv.this.BSW.set(false);
                    ZZv.this.ML.pA(ZZv.this.pA, ZZv.this.JG, i, ZZv.this.vZF, ZZv.this.SGo, ZZv.this.Sn, ZZv.this.Wx, ZZv.this.DX);
                    ZZv.this.Wx = 0;
                }
            }
        });
        ZZv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JG() {
        return SD() > 0 && !this.BSW.get();
    }

    private int SD() {
        try {
            return this.KZx.copyBackForwardList().getCurrentIndex() + 1;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.component.utils.TV.pA
    public void pA(Message message) {
        if (message.what == 1) {
            pA(0);
        }
    }

    public void pA(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.XT = SystemClock.elapsedRealtime();
        }
    }

    private boolean pA(int i, int i2) {
        if (i < i2 || this.aBv.contains(Integer.valueOf(i2)) || this.yFO < 2) {
            return false;
        }
        this.aBv.add(Integer.valueOf(i2));
        return true;
    }

    private void pA(int i, WebView webView) {
        new Object[]{Integer.valueOf(i)};
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_progress", i);
            jSONObject.put("progress_timestamp", System.currentTimeMillis());
            jSONObject.put("arbi_current_url", webView.getUrl());
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(this.pA, this.JG, jSONObject);
    }

    private void omh() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("loading_show_interval", SystemClock.elapsedRealtime() - this.XT);
            jSONObject.put("loading_show_timestamp", this.DX);
            WebView webView = this.KZx;
            jSONObject.put("arbi_current_url", webView != null ? webView.getUrl() : "");
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.pA, this.JG, jSONObject);
    }
}
