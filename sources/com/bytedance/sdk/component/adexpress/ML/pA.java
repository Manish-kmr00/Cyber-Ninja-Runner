package com.bytedance.sdk.component.adexpress.ML;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.Og.BSW;
import com.bytedance.sdk.component.adexpress.Og.SD;
import com.bytedance.sdk.component.adexpress.Og.Sn;
import com.bytedance.sdk.component.adexpress.Og.Wx;
import com.bytedance.sdk.component.adexpress.Og.omh;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public abstract class pA implements BSW, com.bytedance.sdk.component.adexpress.Og.ZZv<com.bytedance.sdk.component.Bzk.ZZv>, com.bytedance.sdk.component.adexpress.pA, com.bytedance.sdk.component.adexpress.theme.pA {
    private omh BSW;
    private volatile SD Bzk;
    private Context JG;
    protected com.bytedance.sdk.component.Bzk.ZZv KZx;
    protected boolean Og;
    private String SD;
    private boolean SGo;
    private int Sn;
    private Wx WV;
    private boolean Wx;
    private String omh;
    protected JSONObject pA;
    protected int ZZv = 8;
    protected AtomicBoolean ML = new AtomicBoolean(false);
    private boolean DX = false;

    protected void Bzk() {
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.ZZv
    public int KZx() {
        return 0;
    }

    public abstract void SD();

    protected void SGo() {
    }

    public abstract void pA(int i);

    public pA(Context context, Wx wx, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        this.SGo = false;
        this.JG = context;
        this.WV = wx;
        this.SD = wx.ZZv();
        themeStatusBroadcastReceiver.pA(this);
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            WV();
            return;
        }
        com.bytedance.sdk.component.Bzk.ZZv zZvWx = Wx();
        this.KZx = zZvWx;
        if (zZvWx == null) {
            Log.d("WebViewRender", "initWebView: create WebView");
            if (com.bytedance.sdk.component.adexpress.ZZv.pA() != null) {
                this.KZx = new com.bytedance.sdk.component.Bzk.ZZv(com.bytedance.sdk.component.adexpress.ZZv.pA());
                return;
            }
            return;
        }
        this.SGo = true;
        Log.d("WebViewRender", "initWebView: reuse WebView");
    }

    private void WV() {
        if (this.JG == null && com.bytedance.sdk.component.adexpress.ZZv.pA() != null) {
            this.JG = com.bytedance.sdk.component.adexpress.ZZv.pA();
        }
        if (this.JG != null) {
            com.bytedance.sdk.component.Bzk.ZZv zZvWx = Wx();
            this.KZx = zZvWx;
            if (zZvWx == null) {
                Log.d("WebViewRender", "initWebView: create WebView by act");
                this.KZx = new com.bytedance.sdk.component.Bzk.ZZv(new MutableContextWrapper(this.JG.getApplicationContext()));
            } else {
                this.SGo = true;
                Log.d("WebViewRender", "initWebView: reuse WebView");
            }
        }
    }

    private com.bytedance.sdk.component.Bzk.ZZv Wx() {
        if (this.WV.BF()) {
            return ML.pA().pA(this.JG, this.SD);
        }
        return ML.pA().Og(this.JG, this.SD);
    }

    private void Sn() {
        if (this.WV.BF()) {
            ML.pA().Og(this.KZx);
        } else {
            ML.pA().KZx(this.KZx);
        }
    }

    public void pA(String str) {
        this.omh = str;
    }

    public com.bytedance.sdk.component.Bzk.ZZv pA() {
        return this.KZx;
    }

    public void pA(omh omhVar) {
        this.BSW = omhVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.ZZv
    public void pA(SD sd) {
        this.Bzk = sd;
        if (pA() == null || pA().getWebView() == null) {
            this.Bzk.pA(102, "SSWebview null is " + (pA() == null) + " or Webview is null");
            return;
        }
        if (TextUtils.isEmpty(this.omh)) {
            this.Bzk.pA(102, "url is empty");
            return;
        }
        if (!this.WV.BF()) {
            if (!this.DX && !com.bytedance.sdk.component.adexpress.pA.Og.Og.pA(this.pA)) {
                this.Bzk.pA(103, "data null is " + (this.pA == null));
                return;
            } else if (this.DX && !com.bytedance.sdk.component.adexpress.pA.Og.Og.KZx(this.pA)) {
                this.Bzk.pA(103, "choice ad data null is " + (this.pA == null));
                return;
            }
        } else if (KZx() == 9 && !com.bytedance.sdk.component.adexpress.pA.Og.Og.Og(this.pA)) {
            this.Bzk.pA(103, "data null is " + (this.pA == null));
            return;
        }
        this.WV.ML().pA(this.SGo);
        if (this.SGo) {
            try {
                this.KZx.Wx();
                this.WV.ML();
                com.bytedance.sdk.component.utils.BSW.pA(this.KZx.getWebView(), "javascript:window.SDK_RESET_RENDER();window.SDK_TRIGGER_RENDER();");
                return;
            } catch (Exception e) {
                ML.pA().ML(this.KZx);
                this.Bzk.pA(102, "load exception is " + e.getMessage());
                return;
            }
        }
        com.bytedance.sdk.component.Bzk.ZZv zZvPA = pA();
        zZvPA.Wx();
        this.WV.ML();
        zZvPA.a_(this.omh);
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.ZZv
    /* JADX INFO: renamed from: Og, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.Bzk.ZZv ML() {
        return pA();
    }

    public void ZZv() {
        if (this.ML.get()) {
            return;
        }
        this.ML.set(true);
        SD();
        if (this.KZx.getParent() != null) {
            ((ViewGroup) this.KZx.getParent()).removeView(this.KZx);
        }
        if (this.Og) {
            Sn();
        } else {
            ML.pA().ML(this.KZx);
        }
    }

    public void JG() {
        if (pA() == null) {
            return;
        }
        try {
            pA().getWebView().resumeTimers();
        } catch (Exception unused) {
        }
    }

    public void pA(boolean z) {
        this.Wx = z;
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.BSW
    public void pA(final Sn sn) {
        if (sn == null) {
            if (this.Bzk != null) {
                this.Bzk.pA(105, "renderResult is null");
                return;
            }
            return;
        }
        boolean zKZx = sn.KZx();
        final float fZZv = (float) sn.ZZv();
        final float fML = (float) sn.ML();
        if (KZx() == 0 && (fZZv <= 0.0f || fML <= 0.0f)) {
            if (this.Bzk != null) {
                this.Bzk.pA(105, "width is " + fZZv + "height is " + fML);
            }
        } else {
            this.Og = zKZx;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                pA(sn, fZZv, fML);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.ML.pA.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pA.this.pA(sn, fZZv, fML);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(Sn sn, float f, float f2) {
        sn.BSW();
        boolean z = this.Og;
        if (z && !this.Wx) {
            pA(f, f2);
            pA(this.ZZv);
            if (this.Bzk != null) {
                this.Bzk.pA(pA(), sn);
                return;
            }
            return;
        }
        if (!z) {
            ML.pA().ML(this.KZx);
        }
        pA(sn.BSW(), sn.SGo());
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.BSW
    public void pA(View view, int i, com.bytedance.sdk.component.adexpress.KZx kZx) {
        omh omhVar = this.BSW;
        if (omhVar != null) {
            omhVar.pA(view, i, kZx);
        }
    }

    private void pA(float f, float f2) {
        this.WV.ML().ML();
        if (KZx() == 9) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) pA().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
            pA().setLayoutParams(layoutParams);
            return;
        }
        int iPA = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.JG, f);
        int iPA2 = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.JG, f2);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) pA().getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(iPA, iPA2);
        }
        layoutParams2.width = iPA;
        layoutParams2.height = iPA2;
        pA().setLayoutParams(layoutParams2);
    }

    private void pA(int i, String str) {
        if (this.Bzk != null) {
            this.Bzk.pA(i, str);
        }
    }

    private int Og(Activity activity) {
        return activity.hashCode();
    }

    public void omh() {
        Bzk();
        Activity activityPA = com.bytedance.sdk.component.utils.Og.pA(this.KZx);
        if (activityPA != null) {
            this.Sn = Og(activityPA);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.pA
    public void pA(Activity activity) {
        if (this.Sn == 0 || activity == null || activity.hashCode() != this.Sn) {
            return;
        }
        ZZv();
        SGo();
    }

    public void pA(JSONObject jSONObject) {
        this.pA = jSONObject;
    }

    public Wx BSW() {
        return this.WV;
    }

    public void Og(boolean z) {
        this.DX = z;
    }
}
