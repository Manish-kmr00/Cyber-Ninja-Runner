package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import android.view.DisplayCutout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.TV;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.ZZv.SD;
import com.bytedance.sdk.openadsdk.common.DX;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.Bzk.omh;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.WQf;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.settings.oX;
import com.bytedance.sdk.openadsdk.utils.TX;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.qmB;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.json.b9;
import com.json.nu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import com.safedk.android.utils.h;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTAppOpenAdActivity extends TTBaseActivity implements TV.pA {
    private static com.bytedance.sdk.openadsdk.pA.ZZv.Og omh;
    private com.bytedance.sdk.openadsdk.pA.ZZv.Og BF;
    private DX BSW;
    private SD DX;
    private AdSlot IG;
    private com.bytedance.sdk.openadsdk.component.KZx Mc;
    private com.bytedance.sdk.openadsdk.component.JG.Og SGo;
    private yFO Sd;
    private int TV;
    private IListenerManager TX;
    private TTAdDislikeToast WV;
    private boolean XT;
    private float aBv;
    private int du;
    private FrameLayout eG;
    private float oX;
    private boolean roi;
    private String vZF;
    private int yFO;
    protected final AtomicBoolean pA = new AtomicBoolean(false);
    protected final TV Og = new TV(Looper.getMainLooper(), this);
    final AtomicBoolean KZx = new AtomicBoolean(false);
    final AtomicBoolean ZZv = new AtomicBoolean(false);
    private final com.bytedance.sdk.openadsdk.component.omh.pA Bzk = new com.bytedance.sdk.openadsdk.component.omh.pA();
    protected boolean ML = false;
    private final AtomicBoolean Wx = new AtomicBoolean(false);
    private qmB Sn = qmB.KZx();
    private final AtomicBoolean WQf = new AtomicBoolean(false);
    long JG = 0;
    private volatile boolean lT = false;
    private final com.bytedance.sdk.openadsdk.component.pA rB = new com.bytedance.sdk.openadsdk.component.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.1
        @Override // com.bytedance.sdk.openadsdk.component.pA, com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
        public void Og(long j, int i) {
            com.bytedance.sdk.openadsdk.component.omh.KZx kZxSD;
            new Object[]{"open_ad", "onError() called with: totalPlayTime = [" + j + "], percent = [" + i + b9.i.e};
            if (TTAppOpenAdActivity.this.Mc != null && (kZxSD = TTAppOpenAdActivity.this.Mc.SD()) != null) {
                kZxSD.pA(true);
            }
            TTAppOpenAdActivity.this.vZF();
            TTAppOpenAdActivity.this.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.component.pA, com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
        public void pA() {
            new Object[]{"open_ad", "onTimeOut"};
            TTAppOpenAdActivity.this.vZF();
            TTAppOpenAdActivity.this.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.component.pA, com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
        public void pA(long j, long j2) {
            TTAppOpenAdActivity.this.Bzk.pA(j);
            if (!TTAppOpenAdActivity.this.ML && TTAppOpenAdActivity.this.Mc != null && TTAppOpenAdActivity.this.Mc.SD() != null && TTAppOpenAdActivity.this.Mc.SD().ZZv()) {
                TTAppOpenAdActivity.this.Mc.SD().SD();
            }
            TTAppOpenAdActivity.this.Wx();
        }

        @Override // com.bytedance.sdk.openadsdk.component.pA, com.bytedance.sdk.openadsdk.component.JG.pA
        public void pA(View view) {
            TTAppOpenAdActivity.this.Sd();
        }

        @Override // com.bytedance.sdk.openadsdk.component.pA, com.bytedance.sdk.openadsdk.component.JG.pA
        public void Og(View view) {
            TTAppOpenAdActivity.this.pA();
        }

        @Override // com.bytedance.sdk.openadsdk.component.pA, com.bytedance.sdk.openadsdk.component.JG.pA
        public void Og() {
            TTAppOpenAdActivity.this.lT = true;
            new Object[]{"open_ad", "onCountDownFinish() called"};
            if (com.bytedance.sdk.openadsdk.vZF.pA.pA("splash_auto_close_switch", 0) == 0) {
                TTAppOpenAdActivity.this.SD();
                TTAppOpenAdActivity.this.finish();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.component.pA, com.bytedance.sdk.openadsdk.component.JG.pA
        public void pA(int i, int i2, boolean z) {
            if (TTAppOpenAdActivity.this.Mc != null) {
                TTAppOpenAdActivity.this.Mc.pA(i, i2, z || i == 0);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.component.pA
        public void KZx() {
            TTAppOpenAdActivity.this.JG();
            TTAppOpenAdActivity.this.Sn.ML();
            TTAppOpenAdActivity.this.aBv();
            if (TTAppOpenAdActivity.this.XT) {
                TTAppOpenAdActivity.this.WV();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.component.pA
        public void ZZv() {
            TTAppOpenAdActivity.this.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.component.pA
        public void ML() {
            TTAppOpenAdActivity.this.yFO();
        }
    };
    private final Runnable xy = new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.5
        @Override // java.lang.Runnable
        public void run() {
            if (TTAppOpenAdActivity.this.Wx.get()) {
                return;
            }
            if (TTAppOpenAdActivity.this.Sd != null && TTAppOpenAdActivity.this.Sd.rjD() && TTAppOpenAdActivity.this.Sd.dGZ() != null && TTAppOpenAdActivity.this.Sd.dGZ().pA() != null) {
                TTAppOpenAdActivity.this.Sd.dGZ().pA().pA(0L);
            }
            TTAppOpenAdActivity.this.DX = new SD();
            TTAppOpenAdActivity.this.DX.pA(System.currentTimeMillis(), 1.0f);
            TTAppOpenAdActivity.this.Sn.ML();
            if (TTAppOpenAdActivity.this.SGo != null) {
                TTAppOpenAdActivity.this.SGo.Og();
            }
            if (TTAppOpenAdActivity.this.Mc != null) {
                TTAppOpenAdActivity.this.Mc.ML();
            }
            TTAppOpenAdActivity.this.XT();
            View viewFindViewById = TTAppOpenAdActivity.this.findViewById(R.id.content);
            JSONObject jSONObject = new JSONObject();
            if (viewFindViewById != null) {
                try {
                    jSONObject.put("width", viewFindViewById.getWidth());
                    jSONObject.put("height", viewFindViewById.getHeight());
                    jSONObject.put("alpha", viewFindViewById.getAlpha());
                } catch (JSONException e) {
                    Log.e("TTAppOpenAdActivity", "run: ", e);
                    TTAppOpenAdActivity.this.finish();
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("root_view", jSONObject.toString());
            jSONObject2.put("ad_root", TTAppOpenAdActivity.this.TV);
            jSONObject2.put("openad_creative_type", TTAppOpenAdActivity.this.XT ? "video_normal_ad" : "image_normal_ad");
            if (omh.KZx() == null) {
                jSONObject2.put("appicon_acquirefail", "1");
            }
            if (TTAppOpenAdActivity.this.roi || TTAppOpenAdActivity.this.Sd.qQU()) {
                jSONObject2.put("dynamic_show_type", TTAppOpenAdActivity.this.oX());
                TTAppOpenAdActivity.this.pA(jSONObject2);
            }
            jSONObject2.put("is_icon_only", TTAppOpenAdActivity.this.Sd.zi() ? 1 : 0);
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(TTAppOpenAdActivity.this.Sd, "open_ad", jSONObject2);
            com.bytedance.sdk.openadsdk.BF.Og.ML.pA(TTAppOpenAdActivity.this.findViewById(R.id.content), TTAppOpenAdActivity.this.Sd, new com.bytedance.sdk.openadsdk.BF.Og.ML.pA(TTAppOpenAdActivity.this.oX()));
            com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(TTAppOpenAdActivity.this.Sd);
            TTAppOpenAdActivity.this.Wx.set(true);
        }
    };

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.u, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aBv.Og(getApplicationContext());
        if (!Og(bundle)) {
            finish();
            return;
        }
        if (!Sn.ML()) {
            finish();
            return;
        }
        if (bundle != null) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.ML(this.Sd, "open_ad", (JSONObject) null);
        }
        this.XT = yFO.ML(this.Sd);
        new Object[]{"open_ad", "onCreate: isVideo is " + this.XT};
        if (this.XT) {
            this.Bzk.pA((float) this.Sd.Bf().JG());
        } else {
            this.Bzk.pA(aBv.ZZv().BF(String.valueOf(this.yFO)));
        }
        com.bytedance.sdk.openadsdk.component.JG.Og og = new com.bytedance.sdk.openadsdk.component.JG.Og(this.Bzk);
        this.SGo = og;
        og.pA(this.rB);
        omh();
        FrameLayout frameLayout = new FrameLayout(this);
        this.eG = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        try {
            setContentView(this.eG);
            this.eG.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.2
                /* JADX WARN: Code duplicated, block: B:9:0x0023  */
                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    try {
                        int iDu = TTAppOpenAdActivity.this.Sd.du();
                        TTAppOpenAdActivity tTAppOpenAdActivity = TTAppOpenAdActivity.this;
                        if (tTAppOpenAdActivity.Sd == null || TTAppOpenAdActivity.this.Sd.BF() != 2) {
                            z = false;
                        } else {
                            z = true;
                            if (iDu == 1) {
                                z = false;
                            }
                        }
                        tTAppOpenAdActivity.roi = z;
                        if (TTAppOpenAdActivity.this.roi) {
                            TTAppOpenAdActivity tTAppOpenAdActivity2 = TTAppOpenAdActivity.this;
                            TTAppOpenAdActivity tTAppOpenAdActivity3 = TTAppOpenAdActivity.this;
                            tTAppOpenAdActivity2.Mc = new com.bytedance.sdk.openadsdk.component.Og(tTAppOpenAdActivity3, tTAppOpenAdActivity3.Sd, TTAppOpenAdActivity.this.eG, TTAppOpenAdActivity.this.rB, TTAppOpenAdActivity.this.du, TTAppOpenAdActivity.this.XT, TTAppOpenAdActivity.this.Bzk, TTAppOpenAdActivity.this.SGo);
                        } else {
                            TTAppOpenAdActivity tTAppOpenAdActivity4 = TTAppOpenAdActivity.this;
                            TTAppOpenAdActivity tTAppOpenAdActivity5 = TTAppOpenAdActivity.this;
                            tTAppOpenAdActivity4.Mc = new com.bytedance.sdk.openadsdk.component.KZx(tTAppOpenAdActivity5, tTAppOpenAdActivity5.Sd, TTAppOpenAdActivity.this.eG, TTAppOpenAdActivity.this.rB, TTAppOpenAdActivity.this.du, TTAppOpenAdActivity.this.XT, TTAppOpenAdActivity.this.Bzk);
                            TTAppOpenAdActivity.this.Mc.pA(TTAppOpenAdActivity.this.aBv, TTAppOpenAdActivity.this.oX);
                        }
                        TTAppOpenAdActivity.this.Mc.pA((ViewGroup) TTAppOpenAdActivity.this.eG);
                        TTAppOpenAdActivity.this.Mc.pA();
                        TTAppOpenAdActivity.this.Mc.Og();
                    } catch (Throwable th) {
                        TTAppOpenAdActivity.this.finish();
                        WV.pA("TTAppOpenAdActivity", th.getMessage());
                    }
                }
            });
            try {
                final View decorView = getWindow().getDecorView();
                if (Build.VERSION.SDK_INT >= 35) {
                    decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.3
                        @Override // android.view.View.OnApplyWindowInsetsListener
                        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                            List<Rect> boundingRects;
                            try {
                                DisplayCutout displayCutout = windowInsets.getDisplayCutout();
                                if (displayCutout != null && (boundingRects = displayCutout.getBoundingRects()) != null && !boundingRects.isEmpty()) {
                                    decorView.setPadding(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom());
                                }
                            } catch (Throwable unused) {
                            }
                            return windowInsets;
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            com.bytedance.sdk.openadsdk.Sn.KZx.Og();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JG() {
        Log.d("TTAppOpenAdActivity", "startCountDownTimer() called");
        this.SGo.Og(aBv.ZZv().TX(String.valueOf(this.yFO)));
        this.SGo.pA(this.Bzk.pA());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SD() {
        TX.pA("TTAppOpenAdActivity", "invoke callback onAdDismiss, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA("onAdTimeOver");
            return;
        }
        com.bytedance.sdk.openadsdk.pA.ZZv.Og og = this.BF;
        if (og != null) {
            og.KZx();
        }
    }

    private void omh() {
        if (26 == Build.VERSION.SDK_INT) {
            if (getResources().getConfiguration().orientation == 1) {
                this.du = 1;
            } else {
                this.du = 2;
            }
        } else {
            this.du = this.Sd.rtW();
        }
        Bzk();
    }

    private void Bzk() {
        int iMin;
        int iMax;
        new Object[]{"open_ad", "changeScreenOrientation: mOrientation=" + this.du};
        if (Build.VERSION.SDK_INT != 26) {
            if (Build.VERSION.SDK_INT == 27) {
                try {
                    SGo();
                } catch (Throwable th) {
                    WV.pA("TTAppOpenAdActivity", th.getMessage());
                    return;
                }
            } else {
                SGo();
            }
        }
        Pair<Integer, Integer> pairOmh = Vgu.omh(getApplicationContext());
        if (this.du == 2) {
            iMin = Math.max(((Integer) pairOmh.first).intValue(), ((Integer) pairOmh.second).intValue());
            iMax = Math.min(((Integer) pairOmh.first).intValue(), ((Integer) pairOmh.second).intValue());
        } else {
            iMin = Math.min(((Integer) pairOmh.first).intValue(), ((Integer) pairOmh.second).intValue());
            iMax = Math.max(((Integer) pairOmh.first).intValue(), ((Integer) pairOmh.second).intValue());
        }
        this.oX = iMax;
        this.aBv = iMin;
        float fPA = Vgu.pA();
        if (Vgu.KZx((Activity) this)) {
            int i = this.du;
            if (i == 1) {
                this.oX -= fPA;
            } else if (i == 2) {
                this.aBv -= fPA;
            }
        }
        com.bytedance.sdk.openadsdk.component.KZx kZx = this.Mc;
        if (kZx != null) {
            kZx.pA(this.aBv, this.oX);
        }
    }

    private void SGo() {
        if (this.du == 2) {
            if (ML()) {
                setRequestedOrientation(8);
            } else {
                setRequestedOrientation(0);
            }
        } else {
            setRequestedOrientation(1);
        }
        if (this.du == 2 || !Vgu.KZx((Activity) this)) {
            getWindow().addFlags(1024);
        }
    }

    protected void pA() {
        if (isFinishing()) {
            return;
        }
        if (this.ZZv.get()) {
            Sn();
            return;
        }
        if (this.BSW == null) {
            try {
                BSW();
            } catch (Throwable th) {
                ApmHelper.reportCustomError("initDislike error", "TTAppOpenAdActivity", th);
            }
        }
        DX dx = this.BSW;
        if (dx != null) {
            dx.pA();
        }
    }

    private void BSW() {
        if (this.BSW == null) {
            DX dx = new DX(this, this.Sd);
            this.BSW = dx;
            dx.setDislikeSource("video_player");
            this.BSW.setCallback(new DX.pA() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.4
                @Override // com.bytedance.sdk.openadsdk.common.DX.pA
                public void pA(View view) {
                    TTAppOpenAdActivity.this.KZx.set(true);
                    TTAppOpenAdActivity.this.KZx();
                    com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(TTAppOpenAdActivity.this.Sd, 8);
                }

                @Override // com.bytedance.sdk.openadsdk.common.DX.pA
                public void Og(View view) {
                    TTAppOpenAdActivity.this.KZx.set(false);
                    TTAppOpenAdActivity.this.Og();
                    com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(TTAppOpenAdActivity.this.Sd, 4);
                }

                @Override // com.bytedance.sdk.openadsdk.common.DX.pA
                public void pA(FilterWord filterWord) {
                    if (TTAppOpenAdActivity.this.ZZv.get() || filterWord == null || filterWord.hasSecondOptions()) {
                        return;
                    }
                    TTAppOpenAdActivity.this.ZZv.set(true);
                    TTAppOpenAdActivity.this.DX();
                }
            });
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
        frameLayout.addView(this.BSW);
        if (this.WV == null) {
            TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this);
            this.WV = tTAdDislikeToast;
            frameLayout.addView(tTAdDislikeToast);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WV() {
        if (!this.XT || this.Sd.zi() || this.lT) {
            return;
        }
        this.Og.sendEmptyMessageDelayed(100, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wx() {
        if (!this.XT || this.Sd.zi()) {
            return;
        }
        this.Og.removeMessages(100);
    }

    private void Sn() {
        this.WV.show(TTAdDislikeToast.getDislikeTip());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DX() {
        this.WV.show(TTAdDislikeToast.getDislikeSendTip());
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (aBv.ZZv().Sd(String.valueOf(this.yFO)) == 1) {
            if (this.Bzk.Og() >= ((long) aBv.ZZv().TX(String.valueOf(this.yFO))) * 1000) {
                Sd();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            if (!this.roi) {
                this.Sn.ML();
            }
            yFO yfo = this.Sd;
            if (yfo != null && yfo.Dc() && !this.Sd.eUc()) {
                this.Sd.SD(true);
                yFO yfo2 = this.Sd;
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo2, "open_ad", yfo2.ZF());
            }
        } else if (this.Wx.get()) {
            if (this.Sn.JG()) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(String.valueOf(this.Sn.ZZv()), this.Sd, "open_ad", this.DX);
            }
            this.Sn = qmB.KZx();
        }
        com.bytedance.sdk.openadsdk.BF.Og.ML.pA(this.Sd, z ? 4 : 8);
        com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(this.Sd, z);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        com.bytedance.sdk.openadsdk.component.KZx kZx;
        super.onResume();
        this.ML = true;
        if (this.pA.getAndSet(true)) {
            if (this.WQf.get()) {
                vZF();
                if (this.XT && (kZx = this.Mc) != null && kZx.SD() != null) {
                    this.Mc.SD().pA(3);
                }
                finish();
                return;
            }
            Og();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.ML = false;
        KZx();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.Sd != null) {
            com.bytedance.sdk.openadsdk.JG.Og.pA().pA("videoForceBreak", this.Sd);
        }
        this.Og.removeCallbacksAndMessages(null);
        com.bytedance.sdk.openadsdk.component.JG.Og og = this.SGo;
        if (og != null) {
            og.ML();
        }
        com.bytedance.sdk.openadsdk.BF.Og.ML.pA(this.Sd);
        com.bytedance.sdk.openadsdk.BF.pA.KZx.Og(this.Sd);
        if (this.XT) {
            com.bytedance.sdk.openadsdk.component.ZZv.pA.pA(this.Sd, this.Bzk.Og(), this.Bzk.pA(), true);
        } else {
            com.bytedance.sdk.openadsdk.component.ZZv.pA.pA(this.Sd, -1L, this.Bzk.pA(), false);
        }
        if (this.Sn.JG() && this.Wx.get()) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(String.valueOf(this.Sn.ZZv()), this.Sd, "open_ad", this.DX);
            this.Sn = qmB.KZx();
        }
        com.bytedance.sdk.openadsdk.component.KZx kZx = this.Mc;
        if (kZx != null) {
            kZx.KZx();
        }
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA("recycleRes");
        }
        SD();
        omh = null;
        this.BF = null;
        DX dx = this.BSW;
        if (dx != null) {
            dx.setCallback(null);
        }
        if (oX.vkV().TV(String.valueOf(this.yFO)) != 1 || yFO.JG(this.Sd)) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.JG.pA(aBv.pA()).pA(this.IG);
    }

    void Og() {
        if (this.KZx.get()) {
            return;
        }
        if (this.XT) {
            com.bytedance.sdk.openadsdk.component.KZx kZx = this.Mc;
            if (kZx != null && kZx.SD() != null && this.Mc.SD().ML()) {
                this.Mc.SD().SGo();
            }
            WV();
        }
        com.bytedance.sdk.openadsdk.component.JG.Og og = this.SGo;
        if (og != null) {
            og.KZx();
        }
    }

    void KZx() {
        if (this.XT) {
            com.bytedance.sdk.openadsdk.component.KZx kZx = this.Mc;
            if (kZx != null && kZx.SD() != null && this.Mc.SD().ZZv()) {
                this.Mc.SD().SD();
            }
            Wx();
        }
        com.bytedance.sdk.openadsdk.component.JG.Og og = this.SGo;
        if (og != null) {
            og.ZZv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int oX() {
        if (this.Sd.qQU()) {
            return 5;
        }
        if (this.roi) {
            return this.Mc.ZZv();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject pA(JSONObject jSONObject) {
        if (oX() == 0) {
            return this.Mc.pA(jSONObject);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBv() {
        if (this.Wx.get()) {
            return;
        }
        try {
            getWindow().getDecorView().post(this.xy);
        } catch (Throwable unused) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XT() {
        new Object[]{"open_ad", "callbackAdShow() called"};
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA("onAdShow");
            return;
        }
        com.bytedance.sdk.openadsdk.pA.ZZv.Og og = this.BF;
        if (og != null) {
            og.pA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yFO() {
        new Object[]{"open_ad", "callbackAdClick() called"};
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA(nu.f);
        } else {
            com.bytedance.sdk.openadsdk.pA.ZZv.Og og = this.BF;
            if (og != null) {
                og.onAdClicked();
            }
        }
        if (oX.vkV().WQf(String.valueOf(this.yFO))) {
            this.WQf.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vZF() {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA("onAdSkip");
            return;
        }
        com.bytedance.sdk.openadsdk.pA.ZZv.Og og = this.BF;
        if (og != null) {
            og.Og();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sd() {
        com.bytedance.sdk.openadsdk.component.KZx kZx;
        new Object[]{"open_ad", "onUserWantSkip() called"};
        WQf.KZx(this.yFO);
        vZF();
        if (this.XT && (kZx = this.Mc) != null && kZx.SD() != null) {
            this.Mc.SD().pA(4);
        }
        com.bytedance.sdk.openadsdk.component.ZZv.pA.pA(this.Sd, (int) this.Bzk.Og(), this.SGo.pA(), this.Bzk.pA());
        yFO yfo = this.Sd;
        if (yfo != null && yfo.rjD() && this.Sd.dGZ() != null && this.Sd.dGZ().pA() != null) {
            com.bytedance.sdk.openadsdk.core.WV.ZZv zZvPA = this.Sd.dGZ().pA();
            com.bytedance.sdk.openadsdk.component.KZx kZx2 = this.Mc;
            long jWV = (kZx2 == null || kZx2.SD() == null) ? 0L : this.Mc.SD().WV();
            zZvPA.JG(jWV);
            zZvPA.ML(jWV);
        }
        finish();
    }

    private void pA(final String str) {
        xy.KZx(new com.bytedance.sdk.component.omh.omh("AppOpenAd_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTAppOpenAdActivity.this.ZZv().executeAppOpenAdCallback(TTAppOpenAdActivity.this.vZF, str);
                } catch (Throwable th) {
                    WV.pA("TTAppOpenAdActivity", "open_ad", "executeAppOpenAdCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    protected IListenerManager ZZv() {
        if (this.TX == null) {
            this.TX = com.bytedance.sdk.openadsdk.multipro.aidl.pA.pA.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.pA.pA().pA(7));
        }
        return this.TX;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Vgu.pA((Activity) this);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.7
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (i == 0) {
                    try {
                        if (TTAppOpenAdActivity.this.isFinishing()) {
                            return;
                        }
                        TTAppOpenAdActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Vgu.pA((Activity) TTAppOpenAdActivity.this);
                            }
                        }, 2500L);
                    } catch (Exception e) {
                        WV.pA("TTAppOpenAdActivity", e.getMessage());
                    }
                }
            }
        });
    }

    private boolean Og(Bundle bundle) {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            Intent intent = getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra != null) {
                    try {
                        this.Sd = com.bytedance.sdk.openadsdk.core.Og.pA(PangleNetworkBridge.jsonObjectInit(stringExtra));
                    } catch (Exception e) {
                        WV.pA("TTAppOpenAdActivity", "open_ad", "initData MultiGlobalInfo throws ", e);
                    }
                }
                this.vZF = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_META_MD5);
            }
        } else {
            this.Sd = com.bytedance.sdk.openadsdk.core.TV.pA().Og();
            this.BF = com.bytedance.sdk.openadsdk.core.TV.pA().ML();
            com.bytedance.sdk.openadsdk.core.TV.pA().JG();
        }
        pA(getIntent());
        pA(bundle);
        yFO yfo = this.Sd;
        if (yfo == null) {
            new Object[]{"open_ad", "mMaterialMeta is null , no data to display ,the TTOpenAdActivity finished !!"};
            finish();
            return false;
        }
        this.IG = yfo.rB();
        this.Sd.pA(this.JG);
        this.yFO = this.Sd.Wf();
        com.bytedance.sdk.openadsdk.utils.Og.pA(this.Sd);
        return true;
    }

    protected void pA(Intent intent) {
        if (intent != null) {
            this.TV = intent.getIntExtra(FirebaseAnalytics.Param.AD_SOURCE, 0);
            this.JG = intent.getLongExtra("start_show_time", 0L);
        }
    }

    protected void pA(Bundle bundle) {
        if (bundle != null) {
            if (this.BF == null) {
                this.BF = omh;
                omh = null;
            }
            try {
                String string = bundle.getString("material_meta");
                this.vZF = bundle.getString(TTAdConstant.MULTI_PROCESS_META_MD5);
                this.TV = bundle.getInt(FirebaseAnalytics.Param.AD_SOURCE, 0);
                this.JG = bundle.getLong("start_show_time", 0L);
                this.Sd = com.bytedance.sdk.openadsdk.core.Og.pA(PangleNetworkBridge.jsonObjectInit(string));
            } catch (Throwable th) {
                WV.pA("TTAppOpenAdActivity", th.getMessage());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            yFO yfo = this.Sd;
            bundle.putString("material_meta", yfo != null ? yfo.jO().toString() : null);
            bundle.putString(TTAdConstant.MULTI_PROCESS_META_MD5, this.vZF);
            bundle.putInt(FirebaseAnalytics.Param.AD_SOURCE, this.TV);
            bundle.putLong("start_show_time", this.JG);
        } catch (Throwable th) {
            WV.pA("TTAppOpenAdActivity", th.getMessage());
        }
        omh = this.BF;
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.component.utils.TV.pA
    public void pA(Message message) {
        com.bytedance.sdk.openadsdk.component.KZx kZx;
        if (message.what == 100) {
            if (this.XT && (kZx = this.Mc) != null && kZx.SD() != null) {
                this.Mc.SD().pA(1);
            }
            vZF();
            finish();
        }
    }

    protected boolean ML() {
        try {
            return getIntent().getIntExtra("orientation_angle", 0) == 3;
        } catch (Exception e) {
            WV.pA("TTAppOpenAdActivity", e.getMessage());
            return false;
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        com.bytedance.sdk.openadsdk.utils.KZx.pA(this, this.Sd);
    }
}
