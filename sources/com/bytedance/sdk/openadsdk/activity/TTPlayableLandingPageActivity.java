package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.utils.TV;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.WV.SD;
import com.bytedance.sdk.openadsdk.ZZv.BSW;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.IG;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.du;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.widget.DX;
import com.bytedance.sdk.openadsdk.core.widget.SGo;
import com.bytedance.sdk.openadsdk.core.widget.Sn;
import com.bytedance.sdk.openadsdk.core.xy;
import com.bytedance.sdk.openadsdk.utils.Bzk;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.yFO.omh;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class TTPlayableLandingPageActivity extends TTBaseActivity implements TV.pA, SD, com.bytedance.sdk.openadsdk.core.Og.ZZv {
    private static final com.bytedance.sdk.openadsdk.yFO.SD.pA JBA = new com.bytedance.sdk.openadsdk.yFO.SD.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.1
        @Override // com.bytedance.sdk.openadsdk.yFO.SD.pA
        public void pA(String str, String str2, Throwable th) {
            WV.pA(str, str2, th);
        }
    };
    private String BF;
    private DX BSW;
    private com.bytedance.sdk.openadsdk.ZZv.ZZv.ML Bf;
    private int CIG;
    private com.bytedance.sdk.openadsdk.core.ML.JG DX;
    private ILoader FQ;
    private BSW HSv;
    private com.bytedance.sdk.openadsdk.XT.pA.pA.JG IG;
    private com.bytedance.sdk.component.Bzk.ZZv ML;
    private boolean Mc;
    TTAdDislikeToast Og;
    private RelativeLayout SGo;
    private IG Sd;
    private int Sn;
    private omh SzT;
    private int TX;
    private int Vgu;
    private String WQf;
    private Sn WV;
    private Context Wx;
    private String XT;
    private SGo aBv;
    private com.bytedance.sdk.openadsdk.yFO.pA.pA dmv;
    private yFO du;
    private boolean fN;
    private com.bytedance.sdk.openadsdk.core.widget.BSW oX;
    du pA;
    private String rB;
    private boolean roi;
    private IG vZF;
    private String yFO;
    private boolean JG = true;
    private boolean omh = false;
    private boolean Bzk = true;
    final AtomicBoolean KZx = new AtomicBoolean(false);
    private final String TV = "embeded_ad";
    private final TV eG = new TV(Looper.getMainLooper(), this);
    private final AtomicBoolean lT = new AtomicBoolean(false);
    private final AtomicInteger xy = new AtomicInteger(0);
    private final AtomicInteger qmB = new AtomicInteger(0);
    private final AtomicInteger gbA = new AtomicInteger(0);
    private boolean Gx = false;
    protected com.bytedance.sdk.openadsdk.WV.ZZv ZZv = new com.bytedance.sdk.openadsdk.WV.ZZv() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.8
        @Override // com.bytedance.sdk.openadsdk.WV.ZZv
        public void pA() {
            if (!TTPlayableLandingPageActivity.this.isFinishing() && WQf.Sn(TTPlayableLandingPageActivity.this.du) && WQf.oX(TTPlayableLandingPageActivity.this.du)) {
                TTPlayableLandingPageActivity.this.eG.removeMessages(2);
                TTPlayableLandingPageActivity.this.eG.sendMessage(TTPlayableLandingPageActivity.this.pA(1, 0));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.WV.ZZv
        public void Og() {
            if (WQf.Sn(TTPlayableLandingPageActivity.this.du) && WQf.DX(TTPlayableLandingPageActivity.this.du)) {
                TTPlayableLandingPageActivity.this.eG.sendMessageDelayed(TTPlayableLandingPageActivity.this.pA(0, 0), 1000L);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.WV.ZZv
        public void pA(int i) {
            if (!WQf.Sn(TTPlayableLandingPageActivity.this.du) || TTPlayableLandingPageActivity.this.oX == null) {
                return;
            }
            TTPlayableLandingPageActivity.this.oX.setProgress(i);
        }
    };
    private int agB = 1;

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.u, me);
        return super.dispatchTouchEvent(me);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message pA(int i, int i2) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 2;
        messageObtain.arg1 = i;
        if (i == 3) {
            messageObtain.arg2 = i2;
        }
        return messageObtain;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        com.bytedance.sdk.openadsdk.yFO.pA.pA pAVar;
        super.onCreate(bundle);
        if (!com.bytedance.sdk.openadsdk.core.Sn.ML()) {
            finish();
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
            aBv.Og(this);
        } catch (Throwable unused) {
        }
        pA(bundle);
        yFO yfo = this.du;
        if (yfo == null) {
            return;
        }
        this.fN = yfo.SRe();
        int iABv = WQf.aBv(this.du);
        if (iABv == 0) {
            setRequestedOrientation(14);
        } else if (iABv == 1) {
            setRequestedOrientation(1);
        } else if (iABv == 2) {
            setRequestedOrientation(0);
            this.agB = 2;
        }
        this.Wx = this;
        try {
            setContentView(ZZv());
            Bzk();
            JG();
            if (this.fN) {
                Sn();
                this.dmv.pA(false, (com.bytedance.sdk.openadsdk.WV.ML) null);
            } else {
                pA();
                BSW();
                if (!TextUtils.isEmpty(this.rB)) {
                    this.FQ = com.bytedance.sdk.openadsdk.SD.Og.pA().Og();
                    int iPA = com.bytedance.sdk.openadsdk.SD.Og.pA().pA(this.FQ, this.rB);
                    this.Vgu = iPA;
                    this.CIG = iPA > 0 ? 2 : 0;
                }
                omh();
                com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml = this.Bf;
                if (ml != null) {
                    ml.SD();
                }
            }
            SD();
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA.pA(SystemClock.elapsedRealtime() - jElapsedRealtime, this.du, "embeded_ad", this.FQ, this.rB);
            if (!this.fN || (pAVar = this.dmv) == null) {
                return;
            }
            pAVar.pA();
        } catch (Throwable unused2) {
            finish();
        }
    }

    private View ZZv() {
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx = new com.bytedance.sdk.openadsdk.core.ML.KZx(this);
        kZx.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.fN) {
            this.dmv = new com.bytedance.sdk.openadsdk.yFO.pA.pA(this.Wx, this.du, this.agB, this.Gx, kZx, true);
        } else {
            this.ML = new com.bytedance.sdk.component.Bzk.ZZv(this);
            this.ML.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.ML.setVisibility(4);
            this.DX = new com.bytedance.sdk.openadsdk.core.ML.JG(this, null, R.style.Widget.ProgressBar.Horizontal);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, Vgu.KZx(this, 3.0f));
            layoutParams.gravity = 49;
            this.DX.setLayoutParams(layoutParams);
            this.DX.setProgress(1);
            this.DX.setProgressDrawable(Bzk.pA(this, "tt_browser_progress_style"));
            this.oX = new com.bytedance.sdk.openadsdk.core.widget.BSW(this);
            this.oX.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.oX.setClickable(true);
            this.oX.setFocusable(true);
            this.aBv = new SGo(this);
            this.aBv.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        this.WV = new Sn(this);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(Vgu.KZx(this, 28.0f), Vgu.KZx(this, 28.0f));
        layoutParams2.leftMargin = Vgu.KZx(this, 12.0f);
        layoutParams2.topMargin = Vgu.KZx(this, 20.0f);
        this.WV.setLayoutParams(layoutParams2);
        this.WV.setScaleType(ImageView.ScaleType.CENTER);
        this.WV.setImageDrawable(Bzk.pA(this, "tt_unmute_wrapper"));
        this.BSW = new DX(this);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, Vgu.KZx(this, 28.0f));
        layoutParams3.gravity = 8388661;
        layoutParams3.leftMargin = Vgu.KZx(this, 16.0f);
        layoutParams3.rightMargin = Vgu.KZx(this, 80.0f);
        layoutParams3.topMargin = Vgu.KZx(this, 20.0f);
        this.BSW.setLayoutParams(layoutParams3);
        this.BSW.setGravity(17);
        this.BSW.setText(com.bytedance.sdk.component.utils.yFO.pA(this, "tt_reward_feedback"));
        this.BSW.setTextColor(-1);
        this.BSW.setTextSize(14.0f);
        this.SGo = new com.bytedance.sdk.openadsdk.core.ML.SD(this);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(Vgu.KZx(this, 28.0f), Vgu.KZx(this, 28.0f));
        layoutParams4.gravity = 8388661;
        layoutParams4.topMargin = Vgu.KZx(this, 20.0f);
        layoutParams4.rightMargin = Vgu.KZx(this, 24.0f);
        this.SGo.setLayoutParams(layoutParams4);
        this.SGo.setBackground(Bzk.pA(this, "tt_mute_btn_bg"));
        this.SGo.setGravity(17);
        this.SGo.setVisibility(8);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(this);
        zZv.setLayoutParams(new RelativeLayout.LayoutParams(Vgu.KZx(this, 12.0f), Vgu.KZx(this, 12.0f)));
        zZv.setImageDrawable(com.bytedance.sdk.component.utils.yFO.KZx(this, "tt_video_close_drawable"));
        zZv.setVisibility(0);
        this.SGo.addView(zZv);
        if (!this.fN) {
            kZx.addView(this.ML);
            kZx.addView(this.DX);
            kZx.addView(this.aBv);
            kZx.addView(this.oX);
        }
        kZx.addView(this.WV);
        kZx.addView(this.BSW);
        kZx.addView(this.SGo);
        return kZx;
    }

    private void ML() {
        if (this.SzT != null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.Bzk.Og().aBv()) {
            com.bytedance.sdk.openadsdk.yFO.SD.pA(JBA);
        }
        com.bytedance.sdk.openadsdk.yFO.pA pAVar = new com.bytedance.sdk.openadsdk.yFO.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.9
            @Override // com.bytedance.sdk.openadsdk.yFO.pA
            public void pA(int i, String str) {
                super.pA(i, str);
                if (WQf.BF(TTPlayableLandingPageActivity.this.du)) {
                    TTPlayableLandingPageActivity.this.eG.sendMessage(TTPlayableLandingPageActivity.this.pA(3, WQf.pA(i)));
                    TTPlayableLandingPageActivity.this.SGo();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.yFO.pA
            public com.bytedance.sdk.openadsdk.yFO.ZZv pA() {
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

            @Override // com.bytedance.sdk.openadsdk.yFO.pA
            public void pA(JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.Og(TTPlayableLandingPageActivity.this.du, "embeded_ad", "playable_track", jSONObject);
            }
        };
        com.bytedance.sdk.openadsdk.yFO.KZx kZx = new com.bytedance.sdk.openadsdk.yFO.KZx() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.10
            @Override // com.bytedance.sdk.openadsdk.yFO.KZx
            public void pA(String str, JSONObject jSONObject) {
                TTPlayableLandingPageActivity.this.vZF.pA(str, jSONObject);
            }
        };
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.XT);
            jSONObject.put("log_extra", this.yFO);
            this.SzT = omh.pA(getApplicationContext(), this.ML.getWebView(), kZx, pAVar).SD(this.BF).ML(com.bytedance.sdk.openadsdk.common.Og.pA(aBv.pA())).pA(com.bytedance.sdk.openadsdk.common.Og.pA()).KZx(jSONObject).Og(com.bytedance.sdk.openadsdk.common.Og.ML()).pA("sdkEdition", com.bytedance.sdk.openadsdk.common.Og.KZx()).ZZv(com.bytedance.sdk.openadsdk.common.Og.ZZv()).ZZv(false).pA(this.Gx).pA(WQf.vZF(this.du)).Og(WQf.vZF(this.du)).ML(true);
        } catch (Throwable unused) {
        }
        if (this.SzT == null) {
            WV.pA("Pangle", "new PlayablePlugin Object failed, mPlayablePlugin is null");
            return;
        }
        if (!TextUtils.isEmpty(WQf.BSW(this.du))) {
            this.SzT.KZx(WQf.BSW(this.du));
        }
        Set<String> setBSW = this.SzT.BSW();
        final WeakReference weakReference = new WeakReference(this.SzT);
        for (String str : setBSW) {
            if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str)) {
                this.vZF.pA().pA(str, new com.bytedance.sdk.component.pA.ML<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.11
                    @Override // com.bytedance.sdk.component.pA.ML
                    public JSONObject pA(JSONObject jSONObject2, com.bytedance.sdk.component.pA.JG jg) {
                        try {
                            omh omhVar = (omh) weakReference.get();
                            if (omhVar == null) {
                                return null;
                            }
                            return omhVar.ZZv(pA(), jSONObject2);
                        } catch (Throwable unused2) {
                            return null;
                        }
                    }
                });
            }
        }
    }

    private void JG() {
        if (this.du.JBA() == 4) {
            this.IG = com.bytedance.sdk.openadsdk.XT.pA.pA.SD.pA(this.Wx, this.du, "interaction");
        }
    }

    private void SD() {
        int i = aBv.ZZv().eG(String.valueOf(this.du.Wf())).aBv;
        if (i >= 0) {
            this.eG.sendEmptyMessageDelayed(1, ((long) i) * 1000);
        } else {
            Vgu.pA((View) this.SGo, 0);
        }
    }

    private void pA(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.Sn = intent.getIntExtra("sdk_version", 1);
            this.XT = intent.getStringExtra("adid");
            this.yFO = intent.getStringExtra("log_extra");
            this.TX = intent.getIntExtra("source", -1);
            this.roi = intent.getBooleanExtra("ad_pending_download", false);
            this.BF = intent.getStringExtra("url");
            this.rB = intent.getStringExtra("gecko_id");
            this.WQf = intent.getStringExtra("web_title");
            if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra != null) {
                    try {
                        this.du = com.bytedance.sdk.openadsdk.core.Og.pA(PangleNetworkBridge.jsonObjectInit(stringExtra));
                    } catch (Exception e) {
                        WV.pA("TTPWPActivity", "TTPlayableLandingPageActivity - onCreate MultiGlobalInfo : ", e);
                    }
                }
            } else {
                this.du = com.bytedance.sdk.openadsdk.core.TV.pA().Og();
                com.bytedance.sdk.openadsdk.core.TV.pA().JG();
            }
        }
        if (bundle != null) {
            try {
                this.Sn = bundle.getInt("sdk_version", 1);
                this.XT = bundle.getString("adid");
                this.yFO = bundle.getString("log_extra");
                this.TX = bundle.getInt("source", -1);
                this.roi = bundle.getBoolean("ad_pending_download", false);
                this.BF = bundle.getString("url");
                this.WQf = bundle.getString("web_title");
                String string = bundle.getString("material_meta", null);
                if (!TextUtils.isEmpty(string)) {
                    this.du = com.bytedance.sdk.openadsdk.core.Og.pA(PangleNetworkBridge.jsonObjectInit(string));
                }
            } catch (Throwable unused) {
            }
        }
        if (this.du == null) {
            WV.pA("TTPWPActivity", "material is null, no data to display");
            finish();
        } else {
            try {
                this.Gx = aBv.ZZv().aBv(this.du.rB().getCodeId());
            } catch (Throwable th) {
                WV.pA("TTPWPActivity", th.getMessage());
            }
        }
    }

    private void omh() {
        com.bytedance.sdk.component.Bzk.ZZv zZv = this.ML;
        if (zZv == null) {
            return;
        }
        zZv.setLandingPage(true);
        this.ML.setTag("landingpage");
        this.ML.setMaterialMeta(this.du.BDQ());
        BSW bswPA = new BSW(this.du, this.ML.getWebView(), new com.bytedance.sdk.openadsdk.ZZv.SGo() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.12
            @Override // com.bytedance.sdk.openadsdk.ZZv.SGo
            public void pA(int i) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA.pA(TTPlayableLandingPageActivity.this.Vgu, TTPlayableLandingPageActivity.this.gbA.get(), TTPlayableLandingPageActivity.this.qmB.get(), TTPlayableLandingPageActivity.this.xy.get() - TTPlayableLandingPageActivity.this.qmB.get(), TTPlayableLandingPageActivity.this.du, "embeded_ad", i);
            }
        }, this.CIG).pA(true);
        this.HSv = bswPA;
        bswPA.pA("embeded_ad");
        this.HSv.pA(this.Bf);
        this.HSv.pA(this.SzT);
        this.ML.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.pA.ML(this.Wx, this.vZF, this.XT, this.HSv, true) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.13
            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                CreativeInfoManager.onResourceLoaded(h.u, view, url);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity$13;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
                BrandSafetyUtils.onWebViewPageFinished(h.u, webView, str);
                safedk_TTPlayableLandingPageActivity$13_onPageFinished_c9ab2344cb52957c4d4365c705498690(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity$13;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
                BrandSafetyUtils.onWebViewPageStarted(h.u, webView, str);
                safedk_TTPlayableLandingPageActivity$13_onPageStarted_f70d8ca07d41c0776b82f93108cfd8d9(webView, str, bitmap);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity$13;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
                BrandSafetyUtils.onWebViewReceivedError(h.u, webView, i, str, str2);
                safedk_TTPlayableLandingPageActivity$13_onReceivedError_9bfa27135f5f9d735bdbeb5a42e36f2c(webView, i, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity$13;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
                BrandSafetyUtils.onWebViewReceivedError(h.u, webView, webResourceRequest, webResourceError);
                safedk_TTPlayableLandingPageActivity$13_onReceivedError_c1cbbb6cd137e888d0ff5013be67ae56(webView, webResourceRequest, webResourceError);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity$13;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;");
                return CreativeInfoManager.onWebViewResponse(h.u, webView, str, safedk_TTPlayableLandingPageActivity$13_shouldInterceptRequest_76f9bf03be3039af52a7a5b3cfdb8fa3(webView, str));
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, com.bytedance.sdk.component.Bzk.ZZv.pA, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                boolean zShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(view, url);
                BrandSafetyUtils.onShouldOverrideUrlLoading(h.u, view, url, zShouldOverrideUrlLoading);
                return zShouldOverrideUrlLoading;
            }

            public void safedk_TTPlayableLandingPageActivity$13_onPageStarted_f70d8ca07d41c0776b82f93108cfd8d9(WebView p0, String p1, Bitmap p2) {
                super.onPageStarted(p0, p1, p2);
            }

            public void safedk_TTPlayableLandingPageActivity$13_onPageFinished_c9ab2344cb52957c4d4365c705498690(WebView p0, String p1) {
                super.onPageFinished(p0, p1);
                TTPlayableLandingPageActivity.this.omh = true;
                if (TTPlayableLandingPageActivity.this.isFinishing()) {
                    return;
                }
                if (TTPlayableLandingPageActivity.this.SzT != null) {
                    TTPlayableLandingPageActivity.this.SzT.Bzk(p1);
                }
                try {
                    TTPlayableLandingPageActivity.this.ZZv.Og();
                } catch (Throwable unused) {
                }
                try {
                    if (TTPlayableLandingPageActivity.this.DX != null) {
                        TTPlayableLandingPageActivity.this.DX.setVisibility(8);
                    }
                    if (TTPlayableLandingPageActivity.this.JG) {
                        TTPlayableLandingPageActivity.this.SGo();
                        TTPlayableLandingPageActivity.this.pA("py_loading_success");
                        if (this.KZx != null) {
                            this.KZx.Og(true);
                        }
                    }
                } catch (Throwable unused2) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ML, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (TTPlayableLandingPageActivity.this.BF != null && webResourceRequest != null && webResourceRequest.getUrl() != null && TTPlayableLandingPageActivity.this.BF.equals(webResourceRequest.getUrl().toString())) {
                    TTPlayableLandingPageActivity.this.JG = false;
                }
                if (TTPlayableLandingPageActivity.this.SzT != null && webResourceRequest != null) {
                    try {
                        TTPlayableLandingPageActivity.this.SzT.pA(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                    } catch (Throwable unused) {
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            public void safedk_TTPlayableLandingPageActivity$13_onReceivedError_c1cbbb6cd137e888d0ff5013be67ae56(WebView p0, WebResourceRequest p1, WebResourceError p2) {
                super.onReceivedError(p0, p1, p2);
                TTPlayableLandingPageActivity.this.JG = false;
                if (TTPlayableLandingPageActivity.this.SzT == null || p2 == null || p1 == null) {
                    return;
                }
                TTPlayableLandingPageActivity.this.SzT.pA(p2.getErrorCode(), String.valueOf(p2.getDescription()), String.valueOf(p1.getUrl()));
            }

            public void safedk_TTPlayableLandingPageActivity$13_onReceivedError_9bfa27135f5f9d735bdbeb5a42e36f2c(WebView p0, int p1, String p2, String p3) {
                super.onReceivedError(p0, p1, p2, p3);
            }

            public WebResourceResponse safedk_TTPlayableLandingPageActivity$13_shouldInterceptRequest_76f9bf03be3039af52a7a5b3cfdb8fa3(WebView p0, String p1) {
                try {
                    if (TTPlayableLandingPageActivity.this.SzT != null) {
                        TTPlayableLandingPageActivity.this.SzT.SGo(p1);
                    }
                    if (!TextUtils.isEmpty(TTPlayableLandingPageActivity.this.rB)) {
                        TTPlayableLandingPageActivity.this.xy.incrementAndGet();
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    WebResourceResponseModel webResourceResponseModelPA = com.bytedance.sdk.openadsdk.SD.Og.pA().pA(TTPlayableLandingPageActivity.this.FQ, TTPlayableLandingPageActivity.this.rB, p1);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (TTPlayableLandingPageActivity.this.Bf != null) {
                        com.bytedance.sdk.component.adexpress.ZZv.SGo.pA pAVarPA = com.bytedance.sdk.component.adexpress.ZZv.SGo.pA(p1);
                        int i = (webResourceResponseModelPA == null || webResourceResponseModelPA.getWebResourceResponse() == null) ? 2 : 1;
                        if (pAVarPA == com.bytedance.sdk.component.adexpress.ZZv.SGo.pA.HTML) {
                            TTPlayableLandingPageActivity.this.Bf.pA(p1, jCurrentTimeMillis, jCurrentTimeMillis2, i);
                        } else if (pAVarPA == com.bytedance.sdk.component.adexpress.ZZv.SGo.pA.JS) {
                            TTPlayableLandingPageActivity.this.Bf.Og(p1, jCurrentTimeMillis, jCurrentTimeMillis2, i);
                        }
                    }
                    if (webResourceResponseModelPA != null && webResourceResponseModelPA.getWebResourceResponse() != null) {
                        TTPlayableLandingPageActivity.this.qmB.incrementAndGet();
                        if (TTPlayableLandingPageActivity.this.SzT != null) {
                            TTPlayableLandingPageActivity.this.SzT.BSW(p1);
                        }
                        return webResourceResponseModelPA.getWebResourceResponse();
                    }
                    if (webResourceResponseModelPA != null && webResourceResponseModelPA.getMsg() == 2) {
                        TTPlayableLandingPageActivity.this.gbA.incrementAndGet();
                    }
                    return super.shouldInterceptRequest(p0, p1);
                } catch (Exception unused) {
                    return super.shouldInterceptRequest(p0, p1);
                }
            }
        });
        pA(this.ML);
        com.bytedance.sdk.openadsdk.utils.yFO.pA(this.ML, this.BF);
        omh omhVar = this.SzT;
        if (omhVar != null) {
            omhVar.omh(this.BF);
        }
        this.ML.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.pA.ZZv(this.vZF, this.HSv) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.14
            @Override // com.bytedance.sdk.openadsdk.core.widget.pA.ZZv, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTPlayableLandingPageActivity.this.isFinishing()) {
                    return;
                }
                try {
                    TTPlayableLandingPageActivity.this.ZZv.pA(i);
                } catch (Throwable unused) {
                }
                if (TTPlayableLandingPageActivity.this.DX != null) {
                    if (i == 100) {
                        TTPlayableLandingPageActivity.this.omh = true;
                        TTPlayableLandingPageActivity.this.DX.setVisibility(8);
                        TTPlayableLandingPageActivity.this.SGo();
                        return;
                    }
                    TTPlayableLandingPageActivity.this.DX.setProgress(i);
                }
            }
        });
        this.ML.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.15
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity$15;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                CreativeInfoManager.onViewTouched(h.u, view, motionEvent);
                return safedk_TTPlayableLandingPageActivity$15_onTouch_3a69aa6da5d92e5e30cb910cf00f4f72(view, motionEvent);
            }

            public boolean safedk_TTPlayableLandingPageActivity$15_onTouch_3a69aa6da5d92e5e30cb910cf00f4f72(View p0, MotionEvent p1) {
                if (TTPlayableLandingPageActivity.this.HSv == null) {
                    return false;
                }
                TTPlayableLandingPageActivity.this.HSv.pA(p1);
                return false;
            }
        });
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            yFO yfo = this.du;
            bundle.putString("material_meta", yfo != null ? yfo.jO().toString() : null);
            bundle.putInt("sdk_version", this.Sn);
            bundle.putString("adid", this.XT);
            bundle.putString("log_extra", this.yFO);
            bundle.putInt("source", this.TX);
            bundle.putBoolean("ad_pending_download", this.roi);
            bundle.putString("url", this.BF);
            bundle.putString("web_title", this.WQf);
            bundle.putString("event_tag", "embeded_ad");
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private void Bzk() {
        RelativeLayout relativeLayout = this.SGo;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity$2;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_TTPlayableLandingPageActivity$2_onClick_e9e7a863d3f9c18cd26e77a33b62c341(view);
                }

                public void safedk_TTPlayableLandingPageActivity$2_onClick_e9e7a863d3f9c18cd26e77a33b62c341(View p0) {
                    if (TTPlayableLandingPageActivity.this.Bf != null) {
                        TTPlayableLandingPageActivity.this.Bf.omh();
                    }
                    TTPlayableLandingPageActivity.this.eG.sendMessage(TTPlayableLandingPageActivity.this.pA(4, 0));
                    TTPlayableLandingPageActivity.this.pA("playable_close");
                    TTPlayableLandingPageActivity.this.finish();
                }
            });
        }
        DX dx = this.BSW;
        if (dx != null) {
            dx.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity$3;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_TTPlayableLandingPageActivity$3_onClick_3ea26895309c16e9185af3fa35f2af8a(view);
                }

                public void safedk_TTPlayableLandingPageActivity$3_onClick_3ea26895309c16e9185af3fa35f2af8a(View p0) {
                    TTPlayableLandingPageActivity.this.Og();
                }
            });
        }
        Sn sn = this.WV;
        if (sn != null) {
            sn.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/activity/TTPlayableLandingPageActivity$4;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_TTPlayableLandingPageActivity$4_onClick_d18901dd313cf4399b61c94a6754d559(view);
                }

                public void safedk_TTPlayableLandingPageActivity$4_onClick_d18901dd313cf4399b61c94a6754d559(View p0) {
                    TTPlayableLandingPageActivity tTPlayableLandingPageActivity = TTPlayableLandingPageActivity.this;
                    tTPlayableLandingPageActivity.Gx = !tTPlayableLandingPageActivity.Gx;
                    TTPlayableLandingPageActivity tTPlayableLandingPageActivity2 = TTPlayableLandingPageActivity.this;
                    tTPlayableLandingPageActivity2.KZx(tTPlayableLandingPageActivity2.Gx);
                    if (TTPlayableLandingPageActivity.this.SzT != null) {
                        TTPlayableLandingPageActivity.this.SzT.pA(TTPlayableLandingPageActivity.this.Gx);
                    }
                }
            });
        }
        if (this.fN) {
            return;
        }
        this.ML.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        Vgu.pA((View) this.ML, 4);
        this.oX.Og(this.du, this.agB);
    }

    protected void pA() {
        if (this.oX == null) {
            return;
        }
        yFO yfo = this.du;
        if (yfo != null && !WQf.Sn(yfo)) {
            this.oX.KZx();
            return;
        }
        this.oX.Og(this.du, this.agB);
        if (this.oX.getDownloadButton() != null) {
            com.bytedance.sdk.openadsdk.core.Og.pA pAVar = new com.bytedance.sdk.openadsdk.core.Og.pA(this, this.du, "embeded_ad", this.TX) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.5
                @Override // com.bytedance.sdk.openadsdk.core.Og.pA, com.bytedance.sdk.openadsdk.core.Og.Og, com.bytedance.sdk.openadsdk.core.Og.KZx
                public void pA(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray, boolean z) {
                    if (this.JG == null || this.JG.vZF() != 1 || z) {
                        super.pA(view, f, f2, f3, f4, sparseArray, z);
                        TTPlayableLandingPageActivity.this.roi = true;
                        TTPlayableLandingPageActivity.this.Mc = true;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("playable_url", TTPlayableLandingPageActivity.this.BF);
                        } catch (JSONException e) {
                            WV.pA("TTPWPActivity", "onClick JSON ERROR", e);
                        }
                        com.bytedance.sdk.openadsdk.ZZv.KZx.Og(TTPlayableLandingPageActivity.this.du, this.SD, "click_playable_download_button_loading", jSONObject);
                    }
                }
            };
            pAVar.pA(this.IG);
            this.oX.getDownloadButton().setOnClickListener(pAVar);
        }
        if (WQf.oX(this.du)) {
            this.eG.sendMessageDelayed(pA(2, WQf.pA(2)), WQf.Sd(this.du));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SGo() {
        if (this.lT.getAndSet(true)) {
            return;
        }
        if (WQf.BF(this.du) && (!this.omh || !this.JG)) {
            if (this.aBv == null || this.oX == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.Og.pA pAVar = new com.bytedance.sdk.openadsdk.core.Og.pA(this, this.du, "embeded_ad", this.TX);
            pAVar.pA(this.IG);
            this.aBv.pA(this.du, "embeded_ad", pAVar);
            Vgu.pA((View) this.aBv, 0);
            Vgu.pA((View) this.oX, 8);
            Vgu.pA((View) this.WV, 8);
            return;
        }
        com.bytedance.sdk.component.Bzk.ZZv zZv = this.ML;
        if (zZv == null || this.oX == null) {
            return;
        }
        Vgu.pA((View) zZv, 0);
        Vgu.pA((View) this.oX, 8);
    }

    private void pA(com.bytedance.sdk.component.Bzk.ZZv zZv) {
        if (zZv == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.pA.KZx.pA(this.Wx).pA(false).Og(false).pA(zZv.getWebView());
        zZv.setUserAgentString(com.bytedance.sdk.openadsdk.utils.aBv.pA(zZv.getWebView(), this.Sn));
        zZv.setMixedContentMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(String str) {
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(System.currentTimeMillis(), this.du, "embeded_ad", str);
    }

    private void BSW() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.du);
        this.Bf = new com.bytedance.sdk.openadsdk.ZZv.aBv(3, "embeded_ad", this.du);
        this.vZF = new IG(this);
        this.vZF.Og(this.ML).pA(this.du).pA(arrayList).KZx(this.XT).ZZv(this.yFO).Og("embeded_ad").Og(this.TX).pA(this).pA(this.Bf).pA(this.ZZv).pA(this.ML).ML(this.du.jK());
        ML();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml = this.Bf;
        if (ml != null) {
            ml.SGo();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        IG ig = this.vZF;
        if (ig != null) {
            ig.SGo();
            com.bytedance.sdk.component.Bzk.ZZv zZv = this.ML;
            if (zZv != null) {
                this.vZF.Og(zZv.getVisibility() == 0);
            }
        }
        IG ig2 = this.Sd;
        if (ig2 != null) {
            ig2.SGo();
        }
        omh omhVar = this.SzT;
        if (omhVar != null) {
            omhVar.KZx(true);
        }
        BSW bsw = this.HSv;
        if (bsw != null) {
            bsw.SD();
        }
        DeviceUtils.AudioInfoReceiver.pA((SD) this);
        if (DeviceUtils.SD() == 0) {
            this.Gx = true;
        }
        KZx(this.Gx);
        com.bytedance.sdk.openadsdk.yFO.pA.pA pAVar = this.dmv;
        if (pAVar != null) {
            pAVar.Og();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        IG ig = this.vZF;
        if (ig != null) {
            ig.Og(false);
        }
        omh omhVar = this.SzT;
        if (omhVar != null) {
            omhVar.pA(true);
            this.SzT.KZx(false);
        }
        DeviceUtils.AudioInfoReceiver.Og((SD) this);
        com.bytedance.sdk.openadsdk.yFO.pA.pA pAVar = this.dmv;
        if (pAVar != null) {
            pAVar.KZx();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml = this.Bf;
        if (ml != null) {
            ml.Bzk();
        }
        BSW bsw = this.HSv;
        if (bsw != null) {
            bsw.omh();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml = this.Bf;
        if (ml != null) {
            ml.omh();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.bytedance.sdk.openadsdk.yFO.pA.pA pAVar = this.dmv;
        if (pAVar != null) {
            pAVar.ZZv();
        }
        com.bytedance.sdk.openadsdk.ZZv.ZZv.ML ml = this.Bf;
        if (ml != null) {
            ml.pA(true);
            this.Bf.WV();
        }
        this.eG.removeCallbacksAndMessages(null);
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(this.rB)) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA.pA(this.qmB.get(), this.xy.get(), this.du);
        }
        com.bytedance.sdk.openadsdk.SD.Og.pA().pA(this.FQ);
        com.bytedance.sdk.component.Bzk.ZZv zZv = this.ML;
        if (zZv != null) {
            xy.pA(zZv.getWebView());
            this.ML.WV();
        }
        this.ML = null;
        IG ig = this.vZF;
        if (ig != null) {
            ig.BSW();
        }
        IG ig2 = this.Sd;
        if (ig2 != null) {
            ig2.BSW();
        }
        omh omhVar = this.SzT;
        if (omhVar != null) {
            omhVar.qmB();
        }
        BSW bsw = this.HSv;
        if (bsw != null) {
            bsw.KZx(true);
        }
        du duVar = this.pA;
        if (duVar != null) {
            duVar.Og();
        }
    }

    @Override // com.bytedance.sdk.component.utils.TV.pA
    public void pA(Message message) {
        int i = message.what;
        if (i == 1) {
            Vgu.pA((View) this.SGo, 0);
            return;
        }
        if (i != 2) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.BSW bsw = this.oX;
        if (bsw == null || !bsw.ZZv()) {
            int i2 = message.arg1;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("remove_loading_page_type", message.arg1);
                if (message.arg2 != 0) {
                    jSONObject.put("remove_loading_page_reason", message.arg2);
                }
                jSONObject.put("playable_url", this.BF);
                com.bytedance.sdk.openadsdk.core.widget.BSW bsw2 = this.oX;
                jSONObject.put("duration", bsw2 != null ? bsw2.getDisplayDuration() : 0L);
            } catch (JSONException e) {
                WV.pA("TTPWPActivity", "handleMsg json error", e);
            }
            com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.du, "embeded_ad", "remove_loading_page", jSONObject);
            this.eG.removeMessages(2);
            com.bytedance.sdk.openadsdk.core.widget.BSW bsw3 = this.oX;
            if (bsw3 != null) {
                bsw3.KZx();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Og.ZZv
    public void pA(boolean z) {
        com.bytedance.sdk.openadsdk.XT.pA.pA.JG jg;
        this.roi = true;
        this.Mc = z;
        if (!z) {
            try {
                Toast.makeText(this.Wx, "Download later", 0).show();
            } catch (Throwable unused) {
            }
        }
        if (!this.Mc || (jg = this.IG) == null) {
            return;
        }
        jg.ZZv();
    }

    protected void Og() {
        if (this.du == null || isFinishing()) {
            return;
        }
        if (this.KZx.get()) {
            WV();
            return;
        }
        if (this.pA == null) {
            KZx();
        }
        this.pA.pA(new du.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.6
            @Override // com.bytedance.sdk.openadsdk.core.du.pA
            public void pA() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.du.pA
            public void pA(int i, String str) {
                if (TTPlayableLandingPageActivity.this.KZx.get() || TextUtils.isEmpty(str)) {
                    return;
                }
                TTPlayableLandingPageActivity.this.KZx.set(true);
                TTPlayableLandingPageActivity.this.Wx();
            }
        });
        du duVar = this.pA;
        if (duVar != null) {
            duVar.pA();
        }
    }

    void KZx() {
        if (this.du != null) {
            this.pA = new com.bytedance.sdk.openadsdk.KZx.KZx(this, this.du.tM(), this.du.QI(), this.du.jO().toString(), "playable");
        }
        if (this.Og == null) {
            this.Og = new TTAdDislikeToast(this);
            ((FrameLayout) findViewById(R.id.content)).addView(this.Og);
        }
    }

    private void WV() {
        TTAdDislikeToast tTAdDislikeToast = this.Og;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.show(TTAdDislikeToast.getDislikeTip());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wx() {
        TTAdDislikeToast tTAdDislikeToast = this.Og;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.show(TTAdDislikeToast.getDislikeSendTip());
        }
    }

    protected void KZx(boolean z) {
        Drawable drawablePA;
        try {
            this.Gx = z;
            if (z) {
                drawablePA = Bzk.pA(this.Wx, "tt_mute_wrapper");
            } else {
                drawablePA = Bzk.pA(this.Wx, "tt_unmute_wrapper");
            }
            this.WV.setImageDrawable(drawablePA);
            omh omhVar = this.SzT;
            if (omhVar != null) {
                omhVar.pA(z);
            }
            com.bytedance.sdk.openadsdk.yFO.pA.pA pAVar = this.dmv;
            if (pAVar != null) {
                pAVar.pA(z);
            }
        } catch (Exception e) {
            WV.pA("TTPWPActivity", e.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.WV.SD
    public void pA(int i) {
        KZx(i <= 0);
    }

    private void Sn() {
        com.bytedance.sdk.openadsdk.core.Og.pA pAVar = new com.bytedance.sdk.openadsdk.core.Og.pA(this, this.du, "embeded_ad", this.TX) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.Og.pA, com.bytedance.sdk.openadsdk.core.Og.Og, com.bytedance.sdk.openadsdk.core.Og.KZx
            public void pA(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray, boolean z) {
                if (this.JG == null || this.JG.vZF() != 1 || z) {
                    super.pA(view, f, f2, f3, f4, sparseArray, z);
                    TTPlayableLandingPageActivity.this.roi = true;
                    TTPlayableLandingPageActivity.this.Mc = true;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("playable_url", TTPlayableLandingPageActivity.this.BF);
                    } catch (JSONException e) {
                        WV.pA("TTPWPActivity", "onClick JSON ERROR", e);
                    }
                    com.bytedance.sdk.openadsdk.ZZv.KZx.Og(TTPlayableLandingPageActivity.this.du, this.SD, "click_playable_download_button_loading", jSONObject);
                }
            }
        };
        pAVar.pA(this.IG);
        com.bytedance.sdk.openadsdk.yFO.pA.pA pAVar2 = this.dmv;
        if (pAVar2 != null) {
            pAVar2.pA(pAVar);
        }
    }
}
