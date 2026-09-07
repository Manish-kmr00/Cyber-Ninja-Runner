package com.applovin.adview;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.webkit.WebView;
import android.window.OnBackInvokedCallback;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.b8;
import com.applovin.impl.c2;
import com.applovin.impl.d;
import com.applovin.impl.e;
import com.applovin.impl.e2;
import com.applovin.impl.g;
import com.applovin.impl.g0;
import com.applovin.impl.k7;
import com.applovin.impl.m1;
import com.applovin.impl.m2;
import com.applovin.impl.o0;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v1;
import com.applovin.impl.v4;
import com.applovin.impl.x4;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.json.b9;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class AppLovinFullscreenActivity extends Activity implements m1 {
    private static final Set h = Collections.newSetFromMap(new WeakHashMap());
    private static final Object i = new Object();
    public static m2 parentInterstitialWrapper;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private k f310a;
    private v1 b;
    private final AtomicBoolean c = new AtomicBoolean(true);
    private com.applovin.impl.adview.activity.a d;
    private c e;
    private g0 f;
    private long g;

    class a implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Boolean f311a;
        final /* synthetic */ boolean b;
        final /* synthetic */ com.applovin.impl.sdk.ad.b c;

        a(Boolean bool, boolean z, com.applovin.impl.sdk.ad.b bVar) {
            this.f311a = bool;
            this.b = z;
            this.c = bVar;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            if (this.f311a.booleanValue()) {
                AppLovinFullscreenActivity.this.a(windowInsets);
            }
            if (this.b) {
                int iIntValue = ((Integer) AppLovinFullscreenActivity.this.f310a.a(v4.s2)).intValue();
                Insets insets = windowInsets.getInsets(this.c.R0() ? iIntValue & (~WindowInsets.Type.displayCutout()) : iIntValue | WindowInsets.Type.displayCutout());
                view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
            } else {
                Insets insets2 = windowInsets.getInsets(((Integer) AppLovinFullscreenActivity.this.f310a.a(v4.s2)).intValue());
                view.setPadding(insets2.left, insets2.top, insets2.right, insets2.bottom);
            }
            return windowInsets;
        }
    }

    private static class c implements OnBackInvokedCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f313a;

        protected c(Runnable runnable) {
            this.f313a = runnable;
        }

        @Override // android.window.OnBackInvokedCallback
        public void onBackInvoked() {
            this.f313a.run();
        }
    }

    private void b() {
        k kVar = this.f310a;
        if (kVar == null || !((Boolean) kVar.a(v4.w2)).booleanValue()) {
            return;
        }
        final Long l = (Long) this.f310a.a(v4.x2);
        this.f = g0.a(l.longValue(), true, this.f310a, new Runnable() { // from class: com.applovin.adview.AppLovinFullscreenActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(l);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        v1 v1Var = this.b;
        if (v1Var != null) {
            v1Var.p();
        }
        if (k7.g(getApplicationContext())) {
            super.onBackPressed();
        }
    }

    @Override // com.applovin.impl.m1
    public void dismiss(String str) {
        if (o0.k() && this.e != null) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.e);
            this.e = null;
        }
        v1 v1Var = this.b;
        if (v1Var != null) {
            v1Var.a(str);
        } else {
            finish();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.f8160a, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        c();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v1 v1Var = this.b;
        if (v1Var != null) {
            v1Var.a(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && parentInterstitialWrapper == null) {
            o.j("AppLovinFullscreenActivity", "Dismissing ad. Activity was destroyed while in background.");
            dismiss("activity_destroyed_while_in_background");
            return;
        }
        try {
            requestWindowFeature(1);
        } catch (Throwable th) {
            o.c("AppLovinFullscreenActivity", "Failed to request window feature", th);
        }
        getWindow().addFlags(16777216);
        getWindow().addFlags(128);
        View viewFindViewById = findViewById(R.id.content);
        viewFindViewById.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        if (TextUtils.isEmpty(getIntent().getStringExtra("com.applovin.interstitial.sdk_key"))) {
            m2 m2Var = parentInterstitialWrapper;
            if (m2Var != null && m2Var.f() != null) {
                m2.a(parentInterstitialWrapper.f(), parentInterstitialWrapper.c(), "Empty SDK key", (Throwable) null, this);
            }
            finish();
            return;
        }
        this.f310a = AppLovinSdk.getInstance(this).a();
        m2 m2Var2 = parentInterstitialWrapper;
        com.applovin.impl.sdk.ad.b bVarF = m2Var2 != null ? m2Var2.f() : null;
        Boolean bool = (Boolean) this.f310a.a(v4.B4);
        boolean z = bVarF != null && bVarF.X0();
        if (o0.b() && (bool.booleanValue() || z)) {
            getWindow().setDecorFitsSystemWindows(false);
            viewFindViewById.setOnApplyWindowInsetsListener(new a(bool, z, bVarF));
            a(bVarF);
        } else {
            viewFindViewById.setFitsSystemWindows(true);
            if (o0.b()) {
                b8.a(viewFindViewById, this.f310a);
            }
            a(bVarF);
        }
        if (bVarF != null && bVarF.B0()) {
            g.a(bVarF, this, this.f310a);
        }
        if (o0.k() && ((Boolean) this.f310a.a(v4.U5)).booleanValue()) {
            this.e = new c(new Runnable() { // from class: com.applovin.adview.AppLovinFullscreenActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c();
                }
            });
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.e);
        }
        a();
        b();
        Integer num = (Integer) this.f310a.a(v4.v6);
        if (num.intValue() > 0) {
            synchronized (i) {
                Set set = h;
                set.add(this);
                k7.a("AppLovinFullscreenActivity", set.size(), num.intValue(), this.f310a.E());
            }
        }
        m2 m2Var3 = parentInterstitialWrapper;
        if (m2Var3 != null) {
            v1.a(m2Var3.f(), parentInterstitialWrapper.b(), parentInterstitialWrapper.c(), parentInterstitialWrapper.d(), parentInterstitialWrapper.h(), this.f310a, this, new b());
            return;
        }
        Intent intent = new Intent(this, (Class<?>) FullscreenAdService.class);
        com.applovin.impl.adview.activity.a aVar = new com.applovin.impl.adview.activity.a(this, this.f310a);
        this.d = aVar;
        bindService(intent, aVar, 1);
        if (o0.i()) {
            String str = this.f310a.o0().getExtraParameters().get("disable_set_data_dir_suffix");
            if (StringUtils.isValidString(str) && Boolean.parseBoolean(str)) {
                return;
            }
            try {
                WebView.setDataDirectorySuffix(String.valueOf(Process.myPid()));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        k kVar = this.f310a;
        if (kVar != null && ((Boolean) kVar.a(v4.v2)).booleanValue()) {
            this.f310a.q0().b(x4.M);
            this.f310a.q0().b(x4.O);
            this.f310a.q0().b(x4.P);
        }
        if (this.f != null) {
            this.f310a.q0().b(x4.N);
            this.f.a();
            this.f = null;
        }
        com.applovin.impl.adview.activity.a aVar = this.d;
        if (aVar != null) {
            try {
                unbindService(aVar);
            } catch (Throwable unused) {
            }
        }
        v1 v1Var = this.b;
        if (v1Var != null) {
            if (v1Var.f()) {
                this.b.q();
            } else {
                long jA = this.b.a();
                if (jA >= 0) {
                    if (jA == 0) {
                        this.b.d(true);
                    }
                    final m2 m2Var = parentInterstitialWrapper;
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.adview.AppLovinFullscreenActivity$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.a(m2Var);
                        }
                    }, jA);
                } else {
                    a(this.b, false, false);
                }
            }
        }
        parentInterstitialWrapper = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        v1 v1Var = this.b;
        if (v1Var != null) {
            v1Var.a(i2, keyEvent);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        v1 v1Var = this.b;
        if (v1Var != null) {
            v1Var.r();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        v1 v1Var;
        try {
            super.onResume();
            if (this.c.get() || (v1Var = this.b) == null) {
                return;
            }
            v1Var.s();
        } catch (IllegalArgumentException e) {
            this.f310a.O();
            if (o.a()) {
                this.f310a.O().a("AppLovinFullscreenActivity", "Error was encountered in onResume().", e);
            }
            this.f310a.E().a("AppLovinFullscreenActivity", b9.h.u0, e);
            dismiss("activity_on_resume_error");
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        v1 v1Var = this.b;
        if (v1Var != null) {
            v1Var.t();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (this.b != null) {
            if (!this.c.getAndSet(false)) {
                this.b.b(z);
            }
            if (z) {
                m2 m2Var = parentInterstitialWrapper;
                a(m2Var != null ? m2Var.f() : null);
            }
        }
        super.onWindowFocusChanged(z);
    }

    public void setPresenter(v1 v1Var) {
        this.b = v1Var;
    }

    class b implements v1.g {
        b() {
        }

        @Override // com.applovin.impl.v1.g
        public void a(v1 v1Var) {
            AppLovinFullscreenActivity.this.b = v1Var;
            v1Var.v();
        }

        @Override // com.applovin.impl.v1.g
        public void a(String str, Throwable th) {
            com.applovin.impl.sdk.ad.b bVarF = AppLovinFullscreenActivity.parentInterstitialWrapper.f();
            m2.a(bVarF, AppLovinFullscreenActivity.parentInterstitialWrapper.c(), str, th, AppLovinFullscreenActivity.this);
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("source", "createAppLovinFullscreenActivity");
            CollectionUtils.putStringIfValid("error_message", str, mapHashMap);
            CollectionUtils.putStringIfValid("top_main_method", th.toString(), mapHashMap);
            AppLovinFullscreenActivity.this.f310a.g().a(c2.s, bVarF, mapHashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WindowInsets windowInsets) {
        o0.a aVarA = o0.a(windowInsets, this.f310a);
        o0.a aVarC = o0.c(windowInsets, this.f310a);
        o0.a aVarB = o0.b(windowInsets, this.f310a);
        String strB = k7.b(this);
        o0.a(aVarA, strB);
        o0.c(aVarC, strB);
        o0.b(aVarB, strB);
        v1 v1Var = this.b;
        if (v1Var != null) {
            v1Var.a(aVarA, aVarC, aVarB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(m2 m2Var) {
        boolean zX = this.b.x();
        boolean zI = (m2Var == null || !zX) ? false : m2Var.i();
        if (!zI) {
            this.b.d(false);
        }
        a(this.b, zX, zI);
    }

    private void a(v1 v1Var, boolean z, boolean z2) {
        v1Var.a("activity_destroyed_by_app_relaunch");
        if (this.f310a != null) {
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("source", "onDestroyAppLovinFullScreenActivity");
            m2 m2Var = parentInterstitialWrapper;
            com.applovin.impl.sdk.ad.b bVarF = m2Var != null ? m2Var.f() : null;
            mapHashMap.putAll(e2.a((AppLovinAdImpl) bVarF));
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putBoolean(jSONObject, "reshow_attempted", z);
            JsonUtils.putBoolean(jSONObject, "reshow_success", z2);
            if (bVarF != null) {
                JsonUtils.putInt(jSONObject, "reshow_count", bVarF.b0());
            }
            mapHashMap.put("details", jSONObject.toString());
            this.f310a.E().d(c2.o0, mapHashMap);
        }
        v1Var.q();
    }

    private void a() {
        m2 m2Var;
        k kVar = this.f310a;
        if (kVar == null || !((Boolean) kVar.a(v4.v2)).booleanValue() || (m2Var = parentInterstitialWrapper) == null || m2Var.f() == null) {
            return;
        }
        com.applovin.impl.sdk.ad.b bVarF = parentInterstitialWrapper.f();
        List listJ = bVarF.j();
        if (CollectionUtils.isEmpty(listJ)) {
            return;
        }
        e eVar = (e) listJ.get(0);
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putStringIfValid(jSONObject, "app_killed_postback_url", eVar.c());
        JsonUtils.putStringIfValid(jSONObject, "app_killed_postback_backup_url", eVar.a());
        this.f310a.q0().b(x4.O, jSONObject.toString());
        this.f310a.q0().b(x4.M, Long.valueOf(System.currentTimeMillis()));
        this.f310a.q0().b(x4.P, CollectionUtils.toJsonString(e2.a((AppLovinAdImpl) bVarF), JsonUtils.EMPTY_JSON));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Long l) {
        this.g += l.longValue();
        this.f310a.q0().b(x4.N, Long.valueOf(this.g));
    }

    private void a(com.applovin.impl.sdk.ad.b bVar) {
        if (o0.b() && bVar != null && bVar.X0()) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
            if (bVar.h1() && bVar.f1()) {
                d.c(this);
                return;
            } else if (bVar.h1()) {
                d.b((Activity) this);
                return;
            } else {
                if (bVar.f1()) {
                    d.a((Activity) this);
                    return;
                }
                return;
            }
        }
        getWindow().setFlags(1024, 1024);
        d.c(this);
    }
}
