package com.applovin.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.adview.AppLovinFullscreenImmersiveActivity;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class v1 implements AppLovinBroadcastManager.Receiver, com.applovin.impl.adview.a.b {
    protected int A;
    protected boolean B;
    private ContentObserver C;
    private Float D;
    protected AppLovinAdClickListener E;
    protected AppLovinAdDisplayListener F;
    protected AppLovinAdVideoPlaybackListener G;
    protected d7 H;
    protected d7 I;
    protected boolean J;
    private final h0 K;
    private boolean L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.ad.b f715a;
    protected final com.applovin.impl.sdk.k b;
    protected final com.applovin.impl.sdk.o c;
    protected Activity d;
    private final int e;
    private final Handler f;
    private final com.applovin.impl.b g;
    private final com.applovin.impl.sdk.i.a h;
    protected AppLovinAdView i;
    protected com.applovin.impl.adview.k j;
    protected final com.applovin.impl.adview.g k;
    protected final com.applovin.impl.adview.g l;
    protected final long m;
    private final AtomicBoolean n;
    private final AtomicBoolean o;
    private boolean p;
    protected long q;
    protected long r;
    private boolean s;
    protected boolean t;
    protected int u;
    protected boolean v;
    private int w;
    private final ArrayList x;
    protected int y;
    protected int z;

    class a implements AppLovinAdDisplayListener {
        a() {
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adDisplayed(AppLovinAd appLovinAd) {
            com.applovin.impl.sdk.o oVar = v1.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                v1.this.c.a("AppLovinFullscreenActivity", "Web content rendered");
            }
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adHidden(AppLovinAd appLovinAd) {
            com.applovin.impl.sdk.o oVar = v1.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                v1.this.c.a("AppLovinFullscreenActivity", "Closing from WebView");
            }
            v1.this.a("web_view");
        }
    }

    class b implements com.applovin.impl.sdk.i.a {
        b() {
        }

        @Override // com.applovin.impl.sdk.i.a
        public void a(int i) {
            v1 v1Var = v1.this;
            if (v1Var.A != com.applovin.impl.sdk.i.h) {
                v1Var.B = true;
            }
            com.applovin.impl.adview.b bVarF = v1Var.i.getController().f();
            if (bVarF == null) {
                com.applovin.impl.sdk.o oVar = v1.this.c;
                if (com.applovin.impl.sdk.o.a()) {
                    v1.this.c.k("AppLovinFullscreenActivity", "Unable to handle ringer mode change: no valid web view.");
                }
            } else if (com.applovin.impl.sdk.i.a(i) && !com.applovin.impl.sdk.i.a(v1.this.A)) {
                bVarF.a("javascript:al_muteSwitchOn();");
            } else if (i == 2) {
                bVarF.a("javascript:al_muteSwitchOff();");
            }
            v1.this.A = i;
        }
    }

    class c extends com.applovin.impl.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.k f718a;

        c(com.applovin.impl.sdk.k kVar) {
            this.f718a = kVar;
        }

        private boolean a(Activity activity) {
            return activity.getClass().getName().equals(k7.a(activity.getApplicationContext(), "AppLovinFullscreenActivity", this.f718a));
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (!v1.this.y() && a(activity)) {
                v1.this.c();
            }
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (v1.this.y() && a(activity)) {
                v1.this.c();
            }
        }
    }

    class d extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.k f719a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Handler handler, com.applovin.impl.sdk.k kVar) {
            super(handler);
            this.f719a = kVar;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Float fB = this.f719a.q().b();
            if (fB == null || v1.this.D == null || fB.equals(v1.this.D)) {
                return;
            }
            String str = fB.floatValue() > v1.this.D.floatValue() ? "volume_up" : "volume_down";
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putDouble(jSONObject, "volume", fB.floatValue());
            v1.this.e("javascript:al_onVolumeChangedEvent('" + str + "'," + jSONObject + ");");
            v1.this.D = fB;
        }
    }

    class e extends com.applovin.impl.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q4 f720a;

        e(q4 q4Var) {
            this.f720a = q4Var;
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (activity instanceof AppLovinFullscreenActivity) {
                this.f720a.b(null);
                v1.this.b.e().b(this);
            }
        }
    }

    public interface g {
        void a(v1 v1Var);

        void a(String str, Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class h implements AppLovinAdClickListener, View.OnClickListener {
        private h() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            v1.this.q = SystemClock.elapsedRealtime();
        }

        @Override // com.applovin.sdk.AppLovinAdClickListener
        public void adClicked(AppLovinAd appLovinAd) {
            com.applovin.impl.sdk.o oVar = v1.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                v1.this.c.a("AppLovinFullscreenActivity", "Clicking through graphic");
            }
            q2.a(v1.this.E, appLovinAd);
            v1.this.z++;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v1 v1Var = v1.this;
            if (view != v1Var.k || !((Boolean) v1Var.b.a(v4.V1)).booleanValue()) {
                com.applovin.impl.sdk.o oVar = v1.this.c;
                if (com.applovin.impl.sdk.o.a()) {
                    v1.this.c.b("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
                    return;
                }
                return;
            }
            v1.e(v1.this);
            if (v1.this.f715a.b1()) {
                v1.this.e("javascript:al_onCloseButtonTapped(" + v1.this.w + StringUtils.COMMA + v1.this.y + StringUtils.COMMA + v1.this.z + ");");
            }
            List listP = v1.this.f715a.P();
            com.applovin.impl.sdk.o oVar2 = v1.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                v1.this.c.a("AppLovinFullscreenActivity", "Handling close button tap " + v1.this.w + " with multi close delay: " + listP);
            }
            if (listP == null || listP.size() <= v1.this.w) {
                v1.this.a("native_close_button");
                return;
            }
            v1.this.x.add(Long.valueOf(SystemClock.elapsedRealtime() - v1.this.q));
            List listN = v1.this.f715a.N();
            if (listN != null && listN.size() > v1.this.w) {
                v1 v1Var2 = v1.this;
                v1Var2.k.a((com.applovin.impl.adview.e.a) listN.get(v1Var2.w));
            }
            com.applovin.impl.sdk.o oVar3 = v1.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                v1.this.c.a("AppLovinFullscreenActivity", "Scheduling next close button with delay: " + listP.get(v1.this.w));
            }
            v1.this.k.setVisibility(8);
            v1 v1Var3 = v1.this;
            v1Var3.a(v1Var3.k, ((Integer) listP.get(v1Var3.w)).intValue(), new Runnable() { // from class: com.applovin.impl.v1$h$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a();
                }
            });
        }

        /* synthetic */ h(v1 v1Var, a aVar) {
            this();
        }
    }

    v1(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.k kVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        Handler handler = new Handler(Looper.getMainLooper());
        this.f = handler;
        this.m = SystemClock.elapsedRealtime();
        this.n = new AtomicBoolean();
        this.o = new AtomicBoolean();
        this.q = -1L;
        this.w = 0;
        this.x = new ArrayList();
        this.y = 0;
        this.z = 0;
        this.A = com.applovin.impl.sdk.i.h;
        this.L = false;
        this.f715a = bVar;
        this.b = kVar;
        this.c = kVar.O();
        this.d = activity;
        this.e = bVar.b0();
        this.E = appLovinAdClickListener;
        this.F = appLovinAdDisplayListener;
        this.G = appLovinAdVideoPlaybackListener;
        this.K = new h0(kVar);
        h hVar = new h(this, null);
        if (((Boolean) kVar.a(v4.l2)).booleanValue()) {
            AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
        }
        if (((Boolean) kVar.a(v4.r2)).booleanValue()) {
            AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.al_onPoststitialShow_evaluation_error"));
        }
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.custom_tabs_shown"));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.custom_tabs_hidden"));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.custom_tabs_failure"));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.custom_intent_launch_success"));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.custom_intent_launch_failure"));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.external_redirect_success"));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.external_redirect_failure"));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.preload_success"));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.preload_failure"));
        t1 t1Var = new t1(kVar.z0(), AppLovinAdSize.INTERSTITIAL, activity);
        this.i = t1Var;
        t1Var.setAdClickListener(hVar);
        this.i.setAdDisplayListener(new a());
        bVar.h().putString("ad_view_address", b8.a(this.i));
        this.i.getController().a(this);
        b2 b2Var = new b2(map, kVar);
        if (b2Var.c()) {
            this.j = new com.applovin.impl.adview.k(b2Var, activity);
        }
        kVar.k().trackImpression(bVar);
        List listP = bVar.P();
        if (bVar.s() >= 0 || listP != null) {
            com.applovin.impl.adview.g gVar = new com.applovin.impl.adview.g(bVar.q(), activity);
            this.k = gVar;
            gVar.setVisibility(8);
            gVar.setOnClickListener(hVar);
        } else {
            this.k = null;
        }
        com.applovin.impl.adview.g gVar2 = new com.applovin.impl.adview.g(com.applovin.impl.adview.e.a.WHITE_ON_TRANSPARENT, activity);
        this.l = gVar2;
        gVar2.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.v1$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        if (bVar.i1()) {
            this.h = new b();
        } else {
            this.h = null;
        }
        this.g = new c(kVar);
        if (bVar.e1()) {
            this.D = kVar.q().b();
            this.C = new d(handler, kVar);
            activity.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI.buildUpon().appendPath("volume_music_speaker").build(), false, this.C);
        }
    }

    private void A() {
        if (this.h != null) {
            this.b.q().a(this.h);
        }
        if (this.g != null) {
            this.b.e().a(this.g);
        }
    }

    static /* synthetic */ int e(v1 v1Var) {
        int i = v1Var.w;
        v1Var.w = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        if (this.f715a.b0() <= this.e && !com.applovin.impl.d.d(this.d)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.d("AppLovinFullscreenActivity", "Ad reshow timed out. Will attempt to bring existing ad activity to front.");
            }
            this.p = false;
            long jC = this.f715a.c();
            if (jC > 0) {
                a(jC).a(q4.h, new q4.b() { // from class: com.applovin.impl.v1$$ExternalSyntheticLambda9
                    @Override // com.applovin.impl.q4.b
                    public final void a(boolean z, Object obj, Object obj2) {
                        this.f$0.a(z, (Void) obj, (Void) obj2);
                    }
                });
            } else {
                f("app_relaunch_reshow_timed_out");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        if (this.f715a.L0().getAndSet(true)) {
            return;
        }
        this.b.r0().a((g5) new k6(this.f715a, this.b), b6.b.OTHER);
    }

    public static void safedk_Activity_startActivity_9d898b58165fa4ba0e12c3900a2b8533(Activity p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.f8160a);
        p0.startActivity(p1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y() {
        return a() >= 0;
    }

    public abstract void a(ViewGroup viewGroup);

    public abstract void b(long j);

    protected boolean g() {
        return AppLovinAdType.INCENTIVIZED == this.f715a.getType();
    }

    protected boolean h() {
        return this.d instanceof AppLovinFullscreenActivity;
    }

    protected void k() {
        if (!this.p && this.o.compareAndSet(false, true)) {
            q2.b(this.F, this.f715a);
            this.b.I().b(this.f715a);
            HashMap map = new HashMap();
            com.applovin.impl.sdk.ad.b bVar = this.f715a;
            if (bVar != null) {
                CollectionUtils.putStringIfValid("source", bVar.F(), map);
                CollectionUtils.putStringIfValid("details", e2.b(this.f715a), map);
            }
            this.b.g().a(c2.t, this.f715a, map);
        }
    }

    protected abstract void l();

    protected void m() {
        d7 d7Var = this.H;
        if (d7Var != null) {
            d7Var.d();
        }
    }

    protected void n() {
        d7 d7Var = this.H;
        if (d7Var != null) {
            d7Var.e();
        }
    }

    protected void o() {
        com.applovin.impl.adview.b bVarF;
        if (this.i == null || !this.f715a.D0() || (bVarF = this.i.getController().f()) == null) {
            return;
        }
        this.K.a(bVarF, new f());
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (action == null) {
        }
        action.hashCode();
        switch (action) {
            case "com.applovin.al_onPoststitialShow_evaluation_error":
                d();
                break;
            case "com.applovin.custom_intent_launch_failure":
            case "com.applovin.custom_intent_launch_success":
                a(action, map);
                break;
            case "com.applovin.external_redirect_success":
            case "com.applovin.external_redirect_failure":
                c(action, map);
                break;
            case "com.applovin.custom_tabs_failure":
            case "com.applovin.custom_tabs_hidden":
            case "com.applovin.custom_tabs_shown":
                b(action, map);
                break;
            case "com.applovin.render_process_gone":
                if (!this.t) {
                    e();
                    break;
                }
                break;
            case "com.applovin.preload_success":
            case "com.applovin.preload_failure":
                d(action, map);
                break;
        }
    }

    public void p() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d("AppLovinFullscreenActivity", "onBackPressed()");
        }
        if (this.L) {
            a("back_button");
        }
        if (this.f715a.b1()) {
            e("javascript:onBackPressed();");
        }
    }

    public void q() {
        AppLovinAdView appLovinAdView = this.i;
        if (appLovinAdView != null) {
            ViewParent parent = appLovinAdView.getParent();
            this.i.destroy();
            this.i = null;
            if ((parent instanceof ViewGroup) && h()) {
                ((ViewGroup) parent).removeAllViews();
            }
        }
        l();
        k();
        this.E = null;
        this.F = null;
        this.G = null;
        this.d = null;
        AppLovinBroadcastManager.unregisterReceiver(this);
    }

    public void r() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d("AppLovinFullscreenActivity", "onPause()");
        }
        d("javascript:al_onAppPaused();");
        m();
    }

    public void s() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d("AppLovinFullscreenActivity", "onResume()");
        }
        d("javascript:al_onAppResumed();");
        n();
    }

    public void t() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d("AppLovinFullscreenActivity", "onStop()");
        }
    }

    public abstract void u();

    public abstract void v();

    protected void w() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d("AppLovinFullscreenActivity", "Setting ad fully watched");
        }
        this.J = true;
    }

    public boolean x() {
        return this.p;
    }

    protected abstract void z();

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!y()) {
            f("app_relaunch");
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d("AppLovinFullscreenActivity", "App relaunch detected with launcher activity. Will attempt to re-show the ad");
        }
        this.p = true;
        long jF = this.f715a.f();
        if (jF < 0) {
            return;
        }
        a(new Runnable() { // from class: com.applovin.impl.v1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.i();
            }
        }, jF);
    }

    private void f(final String str) {
        if (this.o.get()) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.v1$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(str);
            }
        });
    }

    public void b(boolean z) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d("AppLovinFullscreenActivity", "onWindowFocusChanged(boolean) - " + z);
        }
        d("javascript:al_onWindowFocusChanged( " + z + " );");
        d7 d7Var = this.I;
        if (d7Var != null) {
            if (z) {
                d7Var.e();
            } else {
                d7Var.d();
            }
        }
    }

    public void d(boolean z) {
        this.p = z;
    }

    public void e(String str) {
        a(str, 0L);
    }

    protected void d(String str) {
        if (this.f715a.H0()) {
            a(str, 0L);
        }
    }

    public void e() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d("AppLovinFullscreenActivity", "Handling render process crash");
        }
        this.t = true;
    }

    class f implements h0.c {
        f() {
        }

        @Override // com.applovin.impl.h0.c
        public void a(int i, int i2) {
            Map mapA = e2.a((AppLovinAdImpl) v1.this.f715a);
            mapA.putAll(e2.a(v1.this.f715a));
            mapA.put("details", "detection_count=" + i + ",total_checks=" + i2);
            v1.this.b.E().d(c2.x0, mapA);
        }

        @Override // com.applovin.impl.h0.c
        public void a(int i, int i2, int i3) {
            Map mapA = e2.a((AppLovinAdImpl) v1.this.f715a);
            mapA.putAll(e2.a(v1.this.f715a));
            mapA.put("details", "detections_to_report=" + i + ",detection_count=" + i2 + ",total_checks=" + i3);
            v1.this.b.E().d(c2.y0, mapA);
            if (((Boolean) v1.this.b.a(v4.f6)).booleanValue()) {
                v1.this.w();
            }
            if (((Boolean) v1.this.b.a(v4.P0)).booleanValue()) {
                v1.this.b.H().c(v1.this.f715a, com.applovin.impl.sdk.k.o());
            }
            if (((Boolean) v1.this.b.a(v4.b6)).booleanValue()) {
                v1.this.a("black_view_auto_dismiss");
                return;
            }
            v1 v1Var = v1.this;
            v1Var.L = ((Boolean) v1Var.b.a(v4.c6)).booleanValue();
            if (((Boolean) v1.this.b.a(v4.d6)).booleanValue()) {
                v1.this.z();
            }
        }
    }

    public static void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, Map map, com.applovin.impl.sdk.k kVar, Activity activity, g gVar) {
        v1 y1Var;
        if (bVar instanceof l7) {
            try {
                y1Var = new y1(bVar, activity, map, kVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th) {
                gVar.a("Failed to create FullscreenVastVideoAdPresenter with sdk: " + kVar + " and throwable: " + th.getMessage(), th);
                return;
            }
        } else if (bVar.hasVideoUrl()) {
            try {
                y1Var = new z1(bVar, activity, map, kVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th2) {
                gVar.a("Failed to create FullscreenVideoAdPresenter with sdk: " + kVar + " and throwable: " + th2.getMessage(), th2);
                return;
            }
        } else {
            try {
                y1Var = new w1(bVar, activity, map, kVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th3) {
                gVar.a("Failed to create FullscreenGraphicAdPresenter with sdk: " + kVar + " and throwable: " + th3.getMessage(), th3);
                return;
            }
        }
        y1Var.A();
        gVar.a(y1Var);
    }

    public boolean f() {
        return this.s;
    }

    public void d() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d("AppLovinFullscreenActivity", "Handling al_onPoststitialShow evaluation error");
        }
    }

    private void d(String str, Map map) {
        e(l8.d(str, map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        com.applovin.impl.adview.b bVarF;
        AppLovinAdView appLovinAdView = this.i;
        if (appLovinAdView == null || (bVarF = appLovinAdView.getController().f()) == null) {
            return;
        }
        bVarF.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(final com.applovin.impl.adview.g gVar, final Runnable runnable) {
        b8.a(gVar, 400L, new Runnable() { // from class: com.applovin.impl.v1$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                v1.a(gVar, runnable);
            }
        });
    }

    protected int b() {
        int iU = this.f715a.u();
        return (iU <= 0 && ((Boolean) this.b.a(v4.j2)).booleanValue()) ? this.u + 1 : iU;
    }

    private void b(String str, Map map) {
        e(l8.b(str, map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        com.applovin.impl.sdk.o.h("AppLovinFullscreenActivity", "Dismissing on-screen ad due to " + str);
        try {
            a(str);
        } catch (Throwable th) {
            com.applovin.impl.sdk.o.c("AppLovinFullscreenActivity", "Failed to dismiss ad.", th);
            try {
                k();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a("backup_close_button");
    }

    public long a() {
        com.applovin.impl.sdk.ad.b bVar = this.f715a;
        if (bVar == null) {
            return -1L;
        }
        return bVar.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, Void r2, Void r3) {
        if (z) {
            return;
        }
        f("app_relaunch_bring_to_front_failed");
    }

    private q4 a(long j) {
        final q4 q4Var = new q4("bringAdActivityToFront");
        final e eVar = new e(q4Var);
        this.b.e().a(eVar);
        Intent intent = new Intent(this.d, (Class<?>) (this.f715a.X0() ? AppLovinFullscreenImmersiveActivity.class : AppLovinFullscreenActivity.class));
        intent.setFlags(131072);
        safedk_Activity_startActivity_9d898b58165fa4ba0e12c3900a2b8533(this.d, intent);
        a(new Runnable() { // from class: com.applovin.impl.v1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(eVar, q4Var);
            }
        }, j);
        return q4Var;
    }

    protected void c(boolean z) {
        a(z, ((Long) this.b.a(v4.k2)).longValue());
        if (!this.f715a.C0()) {
            q2.a(this.F, this.f715a);
        }
        this.b.I().a(this.f715a);
        if (!this.f715a.C0() && (this.f715a.hasVideoUrl() || g())) {
            q2.a(this.G, this.f715a);
        }
        new k4(this.d).a(this.f715a);
        this.f715a.setHasShown(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.b bVar, q4 q4Var) {
        this.b.e().b(bVar);
        if (q4Var.c()) {
            return;
        }
        q4Var.a((Object) null);
    }

    protected boolean a(boolean z) {
        List listA = k7.a(z, this.f715a, this.b, this.d);
        if (listA.isEmpty()) {
            return false;
        }
        String str = "Missing ad resources: " + listA;
        Map mapA = e2.a((AppLovinAdImpl) this.f715a);
        if (((Boolean) this.b.a(v4.H5)).booleanValue()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b("AppLovinFullscreenActivity", "Dismissing ad due to missing resources: " + listA);
            }
            if (((Boolean) this.b.a(v4.K5)).booleanValue()) {
                AppLovinAdDisplayListener appLovinAdDisplayListener = this.F;
                if (appLovinAdDisplayListener instanceof k2) {
                    q2.a(appLovinAdDisplayListener, "Missing ad resources");
                }
            } else {
                m2.a(this.f715a, this.F, "Missing ad resources", (Throwable) null, (AppLovinFullscreenActivity) null);
            }
            a("missing_ad_resources");
            a(str, "Failing ad display", mapA);
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("source", "missingCachedAdResources");
            CollectionUtils.putStringIfValid("error_message", str, mapHashMap);
            this.b.g().a(c2.s, this.f715a, mapHashMap);
            return ((Boolean) this.b.a(v4.J5)).booleanValue();
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b("AppLovinFullscreenActivity", "Streaming ad due to missing ad resources: " + listA);
        }
        this.f715a.Q0();
        a(str, "Streaming ad", mapA);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(final com.applovin.impl.adview.g gVar, final Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.v1$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                v1.b(gVar, runnable);
            }
        });
    }

    protected void c(long j) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a("AppLovinFullscreenActivity", "Scheduling report reward in " + TimeUnit.MILLISECONDS.toSeconds(j) + " seconds...");
        }
        this.H = d7.a(j, this.b, new Runnable() { // from class: com.applovin.impl.v1$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.j();
            }
        });
    }

    private void c(String str, Map map) {
        e(l8.c(str, map));
    }

    public void a(o0.a aVar, o0.a aVar2, o0.a aVar3) {
        if (((Boolean) this.b.a(v4.B4)).booleanValue()) {
            HashMap map = new HashMap();
            map.put("orientation", k7.b(this.d));
            if (aVar != null) {
                map.put("display_cutout_insets", aVar.e());
            }
            if (aVar2 != null) {
                map.put("status_bar_insets", aVar2.e());
            }
            if (aVar3 != null) {
                map.put("nav_bar_insets", aVar3.e());
            }
            e(l8.a(map));
        }
    }

    public void a(String str) {
        this.s = true;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.m;
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d("AppLovinFullscreenActivity", "Dismissing ad after " + TimeUnit.MILLISECONDS.toSeconds(jElapsedRealtime) + " seconds from source: " + str);
        }
        com.applovin.impl.sdk.ad.b bVar = this.f715a;
        if (bVar != null) {
            bVar.getAdEventTracker().f();
        }
        this.f.removeCallbacksAndMessages(null);
        com.applovin.impl.sdk.ad.b bVar2 = this.f715a;
        a("javascript:al_onPoststitialDismiss();", bVar2 != null ? bVar2.G() : 0L);
        if (((Boolean) this.b.a(v4.D6)).booleanValue()) {
            com.applovin.impl.sdk.ad.b bVar3 = this.f715a;
            if (bVar3 != null) {
                bVar3.a(str);
            }
            l();
        }
        k();
        this.K.b();
        if (this.h != null) {
            this.b.q().b(this.h);
        }
        if (this.g != null) {
            this.b.e().b(this.g);
        }
        if (this.C != null) {
            this.d.getContentResolver().unregisterContentObserver(this.C);
            this.C = null;
        }
        if (h()) {
            this.d.finish();
            return;
        }
        this.b.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.b.O().a("AppLovinFullscreenActivity", "Fullscreen ad shown in container view dismissed, destroying the presenter.");
        }
        q();
    }

    public void a(Configuration configuration) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d("AppLovinFullscreenActivity", "onConfigurationChanged(Configuration) -  " + configuration);
        }
    }

    public void a(int i, KeyEvent keyEvent) {
        if (this.c == null || !com.applovin.impl.sdk.o.a()) {
            return;
        }
        this.c.d("AppLovinFullscreenActivity", "onKeyDown(int, KeyEvent) -  " + i + ", " + keyEvent);
    }

    protected void a(final String str, long j) {
        if (j < 0 || !com.applovin.impl.sdk.utils.StringUtils.isValidString(str)) {
            return;
        }
        a(new Runnable() { // from class: com.applovin.impl.v1$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(str);
            }
        }, j);
    }

    protected void a(final com.applovin.impl.adview.g gVar, long j, final Runnable runnable) {
        if (j >= ((Long) this.b.a(v4.U1)).longValue()) {
            return;
        }
        this.I = d7.a(TimeUnit.SECONDS.toMillis(j), this.b, new Runnable() { // from class: com.applovin.impl.v1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                v1.c(gVar, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.applovin.impl.adview.g gVar, Runnable runnable) {
        gVar.bringToFront();
        runnable.run();
    }

    protected void a(int i, boolean z, boolean z2, long j) {
        if (!this.p && this.n.compareAndSet(false, true)) {
            if (this.f715a.hasVideoUrl() || g()) {
                q2.a(this.G, this.f715a, i, z2);
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.m;
            this.b.k().trackVideoEnd(this.f715a, TimeUnit.MILLISECONDS.toSeconds(jElapsedRealtime), i, z);
            long jElapsedRealtime2 = this.q != -1 ? SystemClock.elapsedRealtime() - this.q : -1L;
            this.b.k().trackFullScreenAdClosed(this.f715a, jElapsedRealtime2, this.x, j, this.B, this.A);
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a("AppLovinFullscreenActivity", "Video ad ended at percent: " + i + "%, elapsedTime: " + jElapsedRealtime + "ms, skipTimeMillis: " + j + "ms, closeTimeMillis: " + jElapsedRealtime2 + "ms");
            }
        }
    }

    private void a(String str, String str2, Map map) {
        HashMap map2 = new HashMap(map);
        CollectionUtils.putStringIfValid("error_message", str, map2);
        CollectionUtils.putStringIfValid("details", str2, map2);
        this.b.E().a(c2.z0, "missingCachedAdResources", map2);
    }

    @Override // com.applovin.impl.adview.a.b
    public void a(com.applovin.impl.adview.a aVar) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a("AppLovinFullscreenActivity", "Fully watched from ad web view...");
        }
        this.J = true;
    }

    protected void a(boolean z, long j) {
        if (this.f715a.T0()) {
            a(z ? "javascript:al_mute();" : "javascript:al_unmute();", j);
        }
    }

    private void a(String str, Map map) {
        e(l8.a(str, map));
    }

    protected void a(Runnable runnable, long j) {
        AppLovinSdkUtils.runOnUiThreadDelayed(runnable, j, this.f);
    }
}
