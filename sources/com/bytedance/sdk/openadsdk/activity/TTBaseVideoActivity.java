package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.utils.TV;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.component.reward.Og.SD;
import com.bytedance.sdk.openadsdk.component.reward.pA.omh;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.TX;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.Wx;
import com.bytedance.sdk.openadsdk.utils.du;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes12.dex */
public abstract class TTBaseVideoActivity extends TTBaseActivity implements TV.pA, com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og {
    private boolean BSW;
    int Bzk;
    int JG;
    protected com.bytedance.sdk.openadsdk.component.reward.Og.Og KZx;
    protected IListenerManager ML;
    com.bytedance.sdk.openadsdk.component.reward.pA.pA Og;
    protected com.bytedance.sdk.openadsdk.WV.ML SGo;
    private int WV;
    private final AtomicBoolean Wx;
    final TV ZZv;
    boolean omh;
    public final String pA;

    protected abstract void ML();

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void WV() {
    }

    public boolean XT() {
        return false;
    }

    public abstract boolean aBv();

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.u, me);
        return super.dispatchTouchEvent(me);
    }

    protected abstract void oX();

    protected abstract void pA();

    protected void pA(Intent intent) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void pA(Bundle bundle) {
    }

    public TTBaseVideoActivity() {
        this.pA = aBv() ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.ZZv = new TV(Looper.getMainLooper(), this);
        this.BSW = false;
        this.WV = 0;
        this.Bzk = 1;
        this.Wx = new AtomicBoolean(false);
        this.SGo = new com.bytedance.sdk.openadsdk.WV.ML() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.2
            @Override // com.bytedance.sdk.openadsdk.WV.ML
            public void pA() {
                TTBaseVideoActivity.this.Sn();
            }
        };
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar;
        super.onCreate(bundle);
        TX.pA("BVA", "onCreate ".concat(String.valueOf(this)));
        aBv.Og(getApplicationContext());
        if (!Sn.ML()) {
            finish();
            return;
        }
        yFO yfoPA = com.bytedance.sdk.openadsdk.component.reward.pA.Og.pA(getIntent(), bundle, this);
        if (yfoPA == null) {
            finish();
            return;
        }
        com.bytedance.sdk.openadsdk.utils.Og.pA(yfoPA);
        this.Bzk = yfoPA.rtW();
        pA(yfoPA, bundle);
        if (bundle != null) {
            if (yfoPA.Evs()) {
                this.Wx.set(true);
            }
            if (yfoPA.boc() && (pAVar = this.Og) != null) {
                pAVar.Wx.set(true);
            }
            com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar2 = this.Og;
            if (pAVar2 != null) {
                pAVar2.roi.SD();
            }
        }
        try {
            yFO();
            vZF();
        } catch (Throwable th) {
            WV.pA("TTAD.BVA", "onCreate: ", th);
            com.bytedance.sdk.openadsdk.Sn.KZx.Og();
            finish();
        }
    }

    private void pA(yFO yfo, Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = new com.bytedance.sdk.openadsdk.component.reward.pA.pA(this, this.ZZv, yfo, this, 0);
        this.Og = pAVar;
        com.bytedance.sdk.openadsdk.component.reward.pA.Og.pA(pAVar, getIntent(), bundle);
        Intent intent = getIntent();
        if (intent != null) {
            pA(intent);
            yfo.pA(intent.getLongExtra("start_show_time", 0L));
        }
        if (bundle != null && this.Og.cFQ) {
            pA();
        }
        com.bytedance.sdk.openadsdk.component.reward.Og.Og ogPA = SD.pA(this.Og);
        this.KZx = ogPA;
        this.Og.nCO = ogPA;
        Wx.pA(this.Og);
        new StringBuilder("init: mAdType = ").append(this.KZx);
    }

    private void yFO() {
        setContentView(this.Og.CIG);
        this.Og.CIG.pA(this.KZx);
        this.KZx.pA(this, this.ZZv);
        this.KZx.BSW();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = this.Og;
        if (pAVar == null || pAVar.Og == null) {
            return;
        }
        yFO yfo = this.Og.Og;
        if (this.SD && !yfo.xkn() && !TextUtils.isEmpty(yFO.pA(this, yfo))) {
            finish();
        }
        if (yfo.xkn()) {
            yfo.ML(false);
        }
    }

    private void vZF() {
        this.KZx.pA(this.SGo);
        this.JG = (int) this.Og.BF.roi();
        oX();
        KZx();
        if (this.Og.Og.dGZ() == null || this.Og.Og.dGZ().pA() == null) {
            return;
        }
        this.Og.Og.dGZ().pA().pA(0L);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = this.Og;
        if (pAVar != null && pAVar.roi != null) {
            this.Og.roi.Og(z);
            this.Og.roi.KZx(z);
        }
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar2 = this.Og;
        if (pAVar2 == null || !(pAVar2.nCO instanceof com.bytedance.sdk.openadsdk.component.reward.Og.JG)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.component.reward.Og.JG) this.Og.nCO).Og(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void BSW() {
        if (!this.Og.Sn.getAndSet(true) || WQf.KZx(this.Og.Og)) {
            this.Og.roi.pA();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void omh() {
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.KZx;
        if (og == null) {
            return;
        }
        og.Wx();
    }

    public void pA(boolean z, int i) {
        pA(z, false, i);
    }

    public void pA(boolean z, boolean z2, int i) {
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.KZx;
        if (og == null) {
            return;
        }
        og.pA(z, z2, false, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public void Bzk() {
        this.Og.BF.Mc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public View SGo() {
        return this.Og.BF.IG();
    }

    protected void KZx() {
        if (WQf.KZx(this.Og.Og)) {
            pA(false, com.bytedance.sdk.openadsdk.ZZv.Og.C0216Og.KZx);
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.KZx;
        if (og != null) {
            og.pA(this.Og.Vgu.JG());
            this.KZx.du();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        TX.pA("BVA", "onStart ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = this.Og;
        if (pAVar == null) {
            return;
        }
        pAVar.rB.rB();
        com.bytedance.sdk.openadsdk.utils.KZx.pA(this, this.Og.Og);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og;
        super.onResume();
        TX.pA("BVA", "onResume ".concat(String.valueOf(this)));
        if (this.Og == null || (og = this.KZx) == null) {
            return;
        }
        og.aBv();
        this.Og.fN = true;
        this.Og.eG.Og(this.ZZv);
        if (Sd()) {
            this.Og.qmB.pA(this.Og.Og.uQ());
        }
        this.Og.Vgu.DX();
        this.Og.rB.TX();
        this.Og.TV.Wx();
        if (this.KZx.Og()) {
            this.Og.BF.pA(this.KZx);
            this.Og.BF.pA(false, this, this.WV != 0);
        }
        this.WV++;
        SD();
        if (this.Og.du != null) {
            this.Og.du.SD();
        }
        this.Og.eG.pA(this.ZZv);
        this.KZx.yFO();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        TX.pA("BVA", "onPause ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.KZx;
        if (og == null) {
            return;
        }
        og.vZF();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        TX.pA("BVA", "onStop ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.KZx;
        if (og == null) {
            return;
        }
        og.Sd();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        TX.pA("BVA", "onDestroy ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = this.Og;
        if (pAVar == null || this.KZx == null) {
            return;
        }
        if (pAVar.SXO > 0 && this.Og.Wx.get()) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(String.valueOf(SystemClock.elapsedRealtime() - this.Og.SXO), this.Og.Og, this.pA, this.Og.BF.pA());
            this.Og.SXO = 0L;
        }
        this.Og.IG.Og();
        this.ZZv.removeCallbacksAndMessages(null);
        this.KZx.TX();
        com.bytedance.sdk.openadsdk.BF.Og.ML.pA(this.Og.Og);
        com.bytedance.sdk.openadsdk.BF.pA.KZx.Og(this.Og.Og);
        final AdSlot adSlotRB = this.Og.Og.rB();
        if (!this.Og.BF.WQf() && adSlotRB != null && TextUtils.isEmpty(adSlotRB.getBidAdm())) {
            Sn.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TTBaseVideoActivity.this.aBv()) {
                        com.bytedance.sdk.openadsdk.component.reward.WV.pA(aBv.pA()).pA(adSlotRB);
                    } else {
                        com.bytedance.sdk.openadsdk.component.reward.ML.pA(aBv.pA()).pA(adSlotRB);
                    }
                }
            });
        }
        Wx.pA();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = this.Og;
        if (pAVar == null) {
            super.onSaveInstanceState(bundle);
            return;
        }
        if (pAVar.Wx.get()) {
            this.Og.Og.omh(true);
        }
        if (this.Wx.get()) {
            this.Og.Og.Xe();
        }
        com.bytedance.sdk.openadsdk.component.reward.pA.Og.pA(this.Og, bundle);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og;
        if (this.Og == null || (og = this.KZx) == null) {
            super.onBackPressed();
        } else {
            og.BF();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar = this.Og;
        if (pAVar == null) {
            return;
        }
        pAVar.eG.pA();
    }

    @Override // com.bytedance.sdk.component.utils.TV.pA
    public void pA(Message message) {
        com.bytedance.sdk.openadsdk.component.reward.Og.Og og = this.KZx;
        if (og == null) {
            return;
        }
        og.pA(message);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og
    public final void JG() {
        if (this.Wx.compareAndSet(false, true)) {
            TX.pA("BVA", "invoke callback onShow, ".concat(String.valueOf(this)));
            ML();
        }
    }

    protected IListenerManager Og(int i) {
        if (this.ML == null) {
            this.ML = com.bytedance.sdk.openadsdk.multipro.aidl.pA.pA.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.pA.pA().pA(i));
        }
        return this.ML;
    }

    protected void SD() {
        if (XT() && !this.BSW) {
            this.BSW = true;
            getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.3
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.component.reward.pA.JG jg = TTBaseVideoActivity.this.Og.Mc;
                    float[] fArrPA = TTBaseVideoActivity.this.Og.eG.pA(TTBaseVideoActivity.this.Bzk);
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    jg.pA(fArrPA, tTBaseVideoActivity, tTBaseVideoActivity.KZx);
                }
            });
        }
    }

    protected void Wx() {
        Message message = new Message();
        message.what = 400;
        if (aBv()) {
            pA(10000);
        }
        this.ZZv.sendMessageDelayed(message, 2000L);
    }

    protected void DX() {
        this.ZZv.removeMessages(400);
    }

    private boolean Sd() {
        if (this.Og.SGo.get() && this.Og.SD) {
            return false;
        }
        if ((this instanceof TTFullScreenExpressVideoActivity) || (this instanceof TTRewardExpressVideoActivity)) {
            return this.Og.SGo.get();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (this.Og == null) {
            return;
        }
        if (du.ML()) {
            Vgu.Og((Activity) this);
        }
        if (WQf.SD(this.Og.Og) && !this.Og.SGo.get()) {
            ApmHelper.reportCustomError("invalid finish", "playable", new RuntimeException());
        } else {
            if (!WQf.ML(this.Og.Og) || this.Og.TV.omh(omh.Og)) {
                return;
            }
            ApmHelper.reportCustomError("invalid finish", "playable", new RuntimeException());
        }
    }
}
