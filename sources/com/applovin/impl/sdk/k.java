package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.impl.a6;
import com.applovin.impl.b6;
import com.applovin.impl.c2;
import com.applovin.impl.c7;
import com.applovin.impl.d1;
import com.applovin.impl.e1;
import com.applovin.impl.e8;
import com.applovin.impl.g4;
import com.applovin.impl.g5;
import com.applovin.impl.h3;
import com.applovin.impl.i1;
import com.applovin.impl.i3;
import com.applovin.impl.i7;
import com.applovin.impl.i8;
import com.applovin.impl.j2;
import com.applovin.impl.j7;
import com.applovin.impl.k7;
import com.applovin.impl.m3;
import com.applovin.impl.mediation.MaxSegmentCollectionImpl;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.o3;
import com.applovin.impl.o4;
import com.applovin.impl.p6;
import com.applovin.impl.privacy.cmp.CmpServiceImpl;
import com.applovin.impl.q0;
import com.applovin.impl.q1;
import com.applovin.impl.q2;
import com.applovin.impl.r0;
import com.applovin.impl.r3;
import com.applovin.impl.r5;
import com.applovin.impl.s3;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdService;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t0;
import com.applovin.impl.t3;
import com.applovin.impl.u4;
import com.applovin.impl.v3;
import com.applovin.impl.v4;
import com.applovin.impl.w2;
import com.applovin.impl.w4;
import com.applovin.impl.w6;
import com.applovin.impl.x4;
import com.applovin.impl.y4;
import com.applovin.impl.z3;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxSegmentCollection;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkInitializationConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class k {
    public static k D0;
    protected static Context E0;
    private static boolean F0;
    private static final boolean H0;
    private static volatile com.applovin.impl.c I0;
    private AppLovinSdk.SdkInitializationListener A0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f655a;
    private String b;
    private WeakReference c;
    private final long d;
    private long e;
    private long f;
    private Long g;
    private long h;
    private final AppLovinSdkSettings j;
    private com.applovin.impl.mediation.e j0;
    private MaxSegmentCollection k;
    private String l;
    private List l0;
    private volatile AppLovinSdk q;
    private boolean q0;
    private String v0;
    private AppLovinSdkInitializationConfiguration w0;
    private AppLovinSdk.SdkInitializationListener z0;
    private static final Object J0 = new Object();
    private static final long G0 = System.currentTimeMillis();
    private final AtomicBoolean i = new AtomicBoolean();
    private final AtomicReference m = new AtomicReference();
    private final AtomicReference n = new AtomicReference();
    private final AtomicReference o = new AtomicReference();
    private final AtomicReference p = new AtomicReference();
    private final o r = new o(this);
    private final com.applovin.impl.f s = new com.applovin.impl.f(this);
    private final w2 t = new w2(this);
    private final q1 u = new q1(this);
    private final i7 v = new i7(this);
    private final AtomicReference w = new AtomicReference();
    private final AtomicReference x = new AtomicReference();
    private final AtomicReference y = new AtomicReference();
    private final AtomicReference z = new AtomicReference();
    private final AtomicReference A = new AtomicReference();
    private final AtomicReference B = new AtomicReference();
    private final AtomicReference C = new AtomicReference();
    private final AtomicReference D = new AtomicReference();
    private final AtomicReference E = new AtomicReference();
    private final AtomicReference F = new AtomicReference();
    private final AtomicReference G = new AtomicReference();
    private final AtomicReference H = new AtomicReference();
    private final AtomicReference I = new AtomicReference();
    private final AtomicReference J = new AtomicReference();
    private final AtomicReference K = new AtomicReference();
    private final AtomicReference L = new AtomicReference();
    private final AtomicReference M = new AtomicReference();
    private final AtomicReference N = new AtomicReference();
    private final AtomicReference O = new AtomicReference();
    private final AtomicReference P = new AtomicReference();
    private final AtomicReference Q = new AtomicReference();
    private final AtomicReference R = new AtomicReference();
    private final AtomicReference S = new AtomicReference();
    private final AtomicReference T = new AtomicReference();
    private final AtomicReference U = new AtomicReference();
    private final AtomicReference V = new AtomicReference();
    private final AtomicReference W = new AtomicReference();
    private final AtomicReference X = new AtomicReference();
    private final AtomicReference Y = new AtomicReference();
    private final AtomicReference Z = new AtomicReference();
    private final AtomicReference a0 = new AtomicReference();
    private final AtomicReference b0 = new AtomicReference();
    private final AtomicReference c0 = new AtomicReference();
    private final AtomicReference d0 = new AtomicReference();
    private final AtomicReference e0 = new AtomicReference();
    private final AtomicReference f0 = new AtomicReference();
    private final AtomicReference g0 = new AtomicReference();
    private final AtomicReference h0 = new AtomicReference();
    private final AtomicReference i0 = new AtomicReference();
    private final AtomicReference k0 = new AtomicReference();
    private final Object m0 = new Object();
    private final AtomicBoolean n0 = new AtomicBoolean(true);
    private final AtomicBoolean o0 = new AtomicBoolean();
    private final AtomicBoolean p0 = new AtomicBoolean();
    private boolean r0 = false;
    private boolean s0 = false;
    private boolean t0 = false;
    private int u0 = 0;
    private final Object x0 = new Object();
    private SdkConfigurationImpl y0 = new SdkConfigurationImpl(this);
    private final g5 B0 = new p6(this, true, "scheduleAdLoadIntegrationError", new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda6
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.L0();
        }
    });
    private final g5 C0 = new p6(this, true, "sdkInit", new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda7
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.M0();
        }
    });

    class a implements r5.b {
        a() {
        }

        @Override // com.applovin.impl.r5.b
        public void a(JSONObject jSONObject) {
            boolean zIsValid = JsonUtils.isValid(jSONObject);
            k.this.c(jSONObject);
            if (((Boolean) k.this.a(o3.V7)).booleanValue()) {
                k kVar = k.this;
                kVar.j0 = new com.applovin.impl.mediation.e(kVar);
            }
            k.this.m().a();
            r0.a(jSONObject, zIsValid, k.this);
            Boolean bool = JsonUtils.getBoolean(jSONObject, "smd", Boolean.FALSE);
            k.this.U().a(bool.booleanValue(), JsonUtils.getInt(jSONObject, "smd_delay_sec", 2));
            k.this.E().b();
            k kVar2 = k.this;
            kVar2.l0 = kVar2.a(jSONObject);
            if (zIsValid) {
                k.this.y0.setEnabledAmazonAdUnitIds(CollectionUtils.explode(JsonUtils.getString(jSONObject, "eaaui", "")));
            }
            k.this.t0().a(jSONObject);
            k.this.b(jSONObject);
            q2.b(((Boolean) k.this.a(v4.k6)).booleanValue());
            q2.a(((Boolean) k.this.a(v4.l6)).booleanValue());
            k.this.R0();
            if (!((Boolean) k.this.a(v4.b3)).booleanValue() || zIsValid || !r0.a(k.o())) {
                k.this.P0();
                return;
            }
            k.this.O();
            if (o.a()) {
                k.this.O().d("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
            }
            k.this.U0();
        }
    }

    class b implements t0.c {
        b() {
        }

        @Override // com.applovin.impl.t0.c
        public void a(t0.b bVar) {
            k.this.O();
            if (o.a()) {
                k.this.O().a("AppLovinSdk", "Terms and Privacy Policy flow completed with status: " + bVar);
            }
            k.this.p0.set(bVar.b());
            if (!bVar.a()) {
                k.this.c("Initializing SDK in MAX environment...");
                return;
            }
            k.this.O();
            if (o.a()) {
                k.this.O().a("AppLovinSdk", "Re-initializing SDK with the updated privacy settings...");
            }
            k.this.T0();
            k.this.S0();
        }
    }

    class c implements r5.b {
        c() {
        }

        @Override // com.applovin.impl.r5.b
        public void a(JSONObject jSONObject) {
            k.this.c(jSONObject);
            k.this.i.set(false);
            k.this.P0();
        }
    }

    class d implements v3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v3 f659a;

        d(v3 v3Var) {
            this.f659a = v3Var;
        }

        @Override // com.applovin.impl.v3.a
        public void a() {
            k.this.O();
            if (o.a()) {
                k.this.O().d("AppLovinSdk", "Connected to internet - re-initializing SDK");
            }
            synchronized (k.this.m0) {
                if (!k.this.q0) {
                    k.this.T0();
                }
            }
            this.f659a.b(this);
        }

        @Override // com.applovin.impl.v3.a
        public void b() {
        }
    }

    static {
        try {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    k7.c();
                }
            });
            H0 = true;
        } catch (Throwable unused) {
            H0 = false;
        }
    }

    public k(AppLovinSdkSettings appLovinSdkSettings, Context context) {
        this.q0 = false;
        D0 = this;
        this.j = appLovinSdkSettings;
        this.d = System.currentTimeMillis();
        this.q0 = true;
        if (!G0()) {
            throw new RuntimeException("As of version 12.0.0, the AppLovin MAX SDK requires Java 8. For more information visit our docs: https://developers.applovin.com/en/android/overview/integration");
        }
        E0 = context.getApplicationContext();
        if (context instanceof Activity) {
            this.c = new WeakReference((Activity) context);
        }
    }

    private void B0() {
        Context context = E0;
        o oVarO = O();
        y4 y4VarQ0 = q0();
        t0 t0VarY = y();
        a(context);
        n0();
        j();
        p();
        c0();
        S().a(MaxAdapter.InitializationStatus.INITIALIZING);
        NativeCrashReporter.a(this);
        String str = this.f655a;
        if (str == null || str.length() != 86) {
            o.h("AppLovinSdk", "SDK key provided is invalid (" + this.f655a + "). Expected length: 86 characters.\n\nStack trace:\n" + Log.getStackTraceString(new Throwable()));
        }
        if (StringUtils.isValidString(this.b) && this.b.length() != 36) {
            String str2 = "Axon event key length " + this.b + " is invalid - expected 36";
            if (k7.c(this)) {
                throw new IllegalArgumentException(str2);
            }
            o.h("AppLovinSdk", str2);
        }
        if (t0VarY.l()) {
            String str3 = "Terms Flow has been replaced. " + t0VarY.g();
            if (k7.c(this)) {
                throw new IllegalStateException(str3);
            }
            o.h("AppLovinSdk", str3);
        }
        if (k7.i()) {
            o.h("AppLovinSdk", "Failed to find class for name: com.applovin.sdk.AppLovinSdk. Please ensure proguard rules have not been omitted from the build.");
        }
        if (!k7.b(this)) {
            o.h("AppLovinSdk", "Detected non-Android core JSON library. Please double-check that none of your third party libraries include custom implementation of org.json.JSONObject.");
        }
        if (k7.m(context)) {
            this.j.setVerboseLogging(true);
        }
        p0().a(v4.k, Boolean.valueOf(this.j.isVerboseLoggingEnabled()));
        t3.e(this);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        x4 x4Var = x4.c;
        if (TextUtils.isEmpty((String) y4VarQ0.a(x4Var, (Object) null, defaultSharedPreferences))) {
            this.s0 = true;
            y4VarQ0.b(x4Var, Boolean.toString(true), defaultSharedPreferences);
        } else {
            y4VarQ0.b(x4Var, Boolean.toString(false), defaultSharedPreferences);
        }
        x4 x4Var2 = x4.d;
        if (((Boolean) y4VarQ0.a(x4Var2, Boolean.FALSE)).booleanValue()) {
            if (o.a()) {
                oVarO.a("AppLovinSdk", "Initializing SDK for non-maiden launch");
            }
            this.t0 = true;
        } else {
            if (o.a()) {
                oVarO.a("AppLovinSdk", "Initializing SDK for maiden launch");
            }
            y4VarQ0.b(x4Var2, Boolean.TRUE);
            y4VarQ0.b(x4.s, Boolean.valueOf(t0VarY.j()));
        }
        x4 x4Var3 = x4.e;
        this.f = ((Long) y4VarQ0.a(x4Var3, 0L)).longValue() + 1;
        q0().b(x4Var3, Long.valueOf(this.f));
        x4 x4Var4 = x4.f;
        this.g = (Long) y4VarQ0.a(x4Var4, null);
        q0().b(x4Var4, Long.valueOf(G0));
        x4 x4Var5 = x4.g;
        String str4 = (String) y4VarQ0.a(x4Var5, null);
        if (StringUtils.isValidString(str4)) {
            if (AppLovinSdk.VERSION_CODE > k7.g(str4)) {
                y4VarQ0.b(x4Var5, AppLovinSdk.VERSION);
            }
        } else {
            y4VarQ0.b(x4Var5, AppLovinSdk.VERSION);
        }
        w0().d(c2.e, CollectionUtils.map("details", "isInitProviderContextSet=" + F0));
    }

    public static boolean G0() {
        return H0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0() {
        if (r0().g()) {
            return;
        }
        O();
        if (o.a()) {
            O().a("AppLovinSdk", "Timing out adapters init...");
        }
        r0().h();
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0() {
        b6 b6VarR0 = r0();
        int i = this.u0 + 1;
        this.u0 = i;
        b6VarR0.a((g5) new r5(i, this, new c()), b6.b.CORE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0() {
        if (H0()) {
            j2.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0() {
        synchronized (this.m0) {
            boolean zA = r0.a(o());
            if (!H0()) {
                O();
                if (o.a()) {
                    O().a("AppLovinSdk", "non-MAX mediation detected, mediation provider is: " + V());
                }
            }
            if (!((Boolean) a(v4.c3)).booleanValue() || zA) {
                T0();
            }
            if (((Boolean) a(v4.b3)).booleanValue() && !zA) {
                O();
                if (o.a()) {
                    O().d("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
                }
                U0();
            }
        }
    }

    private r O0() {
        if (!o4.f(E0)) {
            return null;
        }
        try {
            return new r(this);
        } catch (Throwable th) {
            o.b("AppLovinSdk", "Failed to initialize Privacy Sandbox Service", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        Long l = (Long) a(v4.k3);
        if (l.longValue() >= 0 && this.i.compareAndSet(false, true)) {
            e8.a(l.longValue(), false, this, new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.K0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        if (!H0()) {
            c("Initializing SDK in non-MAX environment...");
            return;
        }
        if (!this.o0.compareAndSet(false, true)) {
            c("Consent flow is already shown. Initializing SDK in MAX environment...");
        } else if (!y().j()) {
            c("Consent flow is not enabled. Initializing SDK in MAX environment...");
        } else {
            y().a(v0(), new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        v3 v3VarC0 = c0();
        v3VarC0.a(new d(v3VarC0));
    }

    private Map W() {
        try {
            return JsonUtils.toStringMap(new JSONObject((String) a(v4.f4)));
        } catch (JSONException unused) {
            return Collections.emptyMap();
        }
    }

    public static long n() {
        return G0;
    }

    public static Context o() {
        return E0;
    }

    public e1 A() {
        Object e1Var = this.V.get();
        if (e1Var == null) {
            synchronized (this.V) {
                e1Var = this.V.get();
                if (e1Var == null) {
                    e1Var = new e1(this);
                    this.V.set(e1Var);
                }
            }
        }
        if (e1Var == this.V) {
            e1Var = null;
        }
        return (e1) e1Var;
    }

    public boolean A0() {
        return this.t0;
    }

    public l B() {
        Object lVar = this.A.get();
        if (lVar == null) {
            synchronized (this.A) {
                lVar = this.A.get();
                if (lVar == null) {
                    lVar = new l(this);
                    this.A.set(lVar);
                }
            }
        }
        if (lVar == this.A) {
            lVar = null;
        }
        return (l) lVar;
    }

    public i1 C() {
        Object i1Var = this.E.get();
        if (i1Var == null) {
            synchronized (this.E) {
                i1Var = this.E.get();
                if (i1Var == null) {
                    i1Var = new i1(this);
                    this.E.set(i1Var);
                }
            }
        }
        if (i1Var == this.E) {
            i1Var = null;
        }
        return (i1) i1Var;
    }

    public boolean C0() {
        boolean z;
        synchronized (this.m0) {
            z = this.r0;
        }
        return z;
    }

    public String D() {
        return this.v0;
    }

    public boolean D0() {
        return this.s0;
    }

    public q1 E() {
        return this.u;
    }

    public boolean E0() {
        boolean z;
        synchronized (this.x0) {
            z = this.w0 != null;
        }
        return z;
    }

    public String F() {
        return x0().d();
    }

    public boolean F0() {
        boolean z;
        synchronized (this.m0) {
            z = this.q0;
        }
        return z;
    }

    public EventServiceImpl G() {
        Object eventServiceImpl = this.o.get();
        if (eventServiceImpl == null) {
            synchronized (this.o) {
                eventServiceImpl = this.o.get();
                if (eventServiceImpl == null) {
                    eventServiceImpl = new EventServiceImpl(this);
                    this.o.set(eventServiceImpl);
                }
            }
        }
        if (eventServiceImpl == this.o) {
            eventServiceImpl = null;
        }
        return (EventServiceImpl) eventServiceImpl;
    }

    public m H() {
        Object mVar = this.H.get();
        if (mVar == null) {
            synchronized (this.H) {
                mVar = this.H.get();
                if (mVar == null) {
                    mVar = new m(this);
                    this.H.set(mVar);
                }
            }
        }
        if (mVar == this.H) {
            mVar = null;
        }
        return (m) mVar;
    }

    public boolean H0() {
        return StringUtils.containsIgnoreCase(V(), "max");
    }

    public n I() {
        Object nVar = this.J.get();
        if (nVar == null) {
            synchronized (this.J) {
                nVar = this.J.get();
                if (nVar == null) {
                    nVar = new n(this);
                    this.J.set(nVar);
                }
            }
        }
        if (nVar == this.J) {
            nVar = null;
        }
        return (n) nVar;
    }

    public boolean I0() {
        return k7.a("com.unity3d.player.UnityPlayerActivity");
    }

    public Activity J() {
        WeakReference weakReference;
        if (!((Boolean) a(v4.v4)).booleanValue() || (weakReference = this.c) == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public AppLovinSdkInitializationConfiguration K() {
        return this.w0;
    }

    public long L() {
        return this.d;
    }

    public Long M() {
        return this.g;
    }

    public long N() {
        return this.f;
    }

    protected void N0() {
        b(false);
    }

    public o O() {
        return this.r;
    }

    public w2 P() {
        return this.t;
    }

    public com.applovin.impl.mediation.d Q() {
        Object dVar = this.i0.get();
        if (dVar == null) {
            synchronized (this.i0) {
                dVar = this.i0.get();
                if (dVar == null) {
                    dVar = new com.applovin.impl.mediation.d(this);
                    this.i0.set(dVar);
                }
            }
        }
        if (dVar == this.i0) {
            dVar = null;
        }
        return (com.applovin.impl.mediation.d) dVar;
    }

    public void Q0() {
        if (StringUtils.isValidString(this.l)) {
            return;
        }
        this.l = "max";
    }

    public com.applovin.impl.mediation.e R() {
        return this.j0;
    }

    public com.applovin.impl.mediation.f S() {
        Object fVar = this.d0.get();
        if (fVar == null) {
            synchronized (this.d0) {
                fVar = this.d0.get();
                if (fVar == null) {
                    fVar = new com.applovin.impl.mediation.f(this);
                    this.d0.set(fVar);
                }
            }
        }
        if (fVar == this.d0) {
            fVar = null;
        }
        return (com.applovin.impl.mediation.f) fVar;
    }

    public void S0() {
        u().a();
    }

    public com.applovin.impl.mediation.g T() {
        Object gVar = this.c0.get();
        if (gVar == null) {
            synchronized (this.c0) {
                gVar = this.c0.get();
                if (gVar == null) {
                    gVar = new com.applovin.impl.mediation.g(this);
                    this.c0.set(gVar);
                }
            }
        }
        if (gVar == this.c0) {
            gVar = null;
        }
        return (com.applovin.impl.mediation.g) gVar;
    }

    public void T0() {
        synchronized (this.m0) {
            this.q0 = true;
            r0().i();
            d();
        }
    }

    public m3 U() {
        Object m3Var = this.g0.get();
        if (m3Var == null) {
            synchronized (this.g0) {
                m3Var = this.g0.get();
                if (m3Var == null) {
                    m3Var = new m3(this);
                    this.g0.set(m3Var);
                }
            }
        }
        if (m3Var == this.g0) {
            m3Var = null;
        }
        return (m3) m3Var;
    }

    public String V() {
        return this.l;
    }

    public void V0() {
        o.h("AppLovinSdk", "Resetting SDK state...");
        p0().a();
        p0().e();
        if (this.n0.compareAndSet(true, false)) {
            T0();
        } else {
            this.n0.set(true);
        }
    }

    public void W0() {
        if (StringUtils.isValidString(this.v0)) {
            return;
        }
        this.v0 = "max";
        O();
        if (o.a()) {
            O().a("AppLovinSdk", "Detected mediation provider: MAX");
        }
    }

    public MediationServiceImpl X() {
        Object mediationServiceImpl = this.e0.get();
        if (mediationServiceImpl == null) {
            synchronized (this.e0) {
                mediationServiceImpl = this.e0.get();
                if (mediationServiceImpl == null) {
                    mediationServiceImpl = new MediationServiceImpl(this);
                    this.e0.set(mediationServiceImpl);
                }
            }
        }
        if (mediationServiceImpl == this.e0) {
            mediationServiceImpl = null;
        }
        return (MediationServiceImpl) mediationServiceImpl;
    }

    public void X0() {
        z().n();
    }

    public r3 Y() {
        Object r3Var = this.z.get();
        if (r3Var == null) {
            synchronized (this.z) {
                r3Var = this.z.get();
                if (r3Var == null) {
                    r3Var = new r3(this);
                    this.z.set(r3Var);
                }
            }
        }
        if (r3Var == this.z) {
            r3Var = null;
        }
        return (r3) r3Var;
    }

    public void Y0() {
        a((Map) null);
    }

    public s3 Z() {
        Object s3Var = this.f0.get();
        if (s3Var == null) {
            synchronized (this.f0) {
                s3Var = this.f0.get();
                if (s3Var == null) {
                    s3Var = new s3();
                    this.f0.set(s3Var);
                }
            }
        }
        if (s3Var == this.f0) {
            s3Var = null;
        }
        return (s3) s3Var;
    }

    public void Z0() {
        if ("admob".equalsIgnoreCase(this.l) && ((Boolean) a(v4.J3)).booleanValue()) {
            String str = (String) a(v4.I3);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            String str2 = AppLovinSdk.VERSION;
            if (str.startsWith(sb.append(str2).append(".").toString())) {
                return;
            }
            final String str3 = "Mismatched AdMob adapter (" + str + ") and AppLovin SDK (" + str2 + ") versions detected, which may cause compatibility issues.";
            o.h("AppLovinSdk", str3);
            AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(str3);
                }
            });
        }
    }

    public p a0() {
        Object pVar = this.h0.get();
        if (pVar == null) {
            synchronized (this.h0) {
                pVar = this.h0.get();
                if (pVar == null) {
                    pVar = new p(this);
                    this.h0.set(pVar);
                }
            }
        }
        if (pVar == this.h0) {
            pVar = null;
        }
        return (p) pVar;
    }

    public AppLovinNativeAdService b0() {
        Object appLovinNativeAdService = this.n.get();
        if (appLovinNativeAdService == null) {
            synchronized (this.n) {
                appLovinNativeAdService = this.n.get();
                if (appLovinNativeAdService == null) {
                    appLovinNativeAdService = new AppLovinNativeAdService(this);
                    this.n.set(appLovinNativeAdService);
                }
            }
        }
        if (appLovinNativeAdService == this.n) {
            appLovinNativeAdService = null;
        }
        return (AppLovinNativeAdService) appLovinNativeAdService;
    }

    public v3 c0() {
        Object v3Var = this.M.get();
        if (v3Var == null) {
            synchronized (this.M) {
                v3Var = this.M.get();
                if (v3Var == null) {
                    v3Var = new v3(o());
                    this.M.set(v3Var);
                }
            }
        }
        if (v3Var == this.M) {
            v3Var = null;
        }
        return (v3) v3Var;
    }

    public z3 d0() {
        Object z3Var = this.Y.get();
        if (z3Var == null) {
            synchronized (this.Y) {
                z3Var = this.Y.get();
                if (z3Var == null) {
                    z3Var = new z3(this);
                    this.Y.set(z3Var);
                }
            }
        }
        if (z3Var == this.Y) {
            z3Var = null;
        }
        return (z3) z3Var;
    }

    public g4 e0() {
        Object g4Var = this.T.get();
        if (g4Var == null) {
            synchronized (this.T) {
                g4Var = this.T.get();
                if (g4Var == null) {
                    g4Var = new g4(this);
                    this.T.set(g4Var);
                }
            }
        }
        if (g4Var == this.T) {
            g4Var = null;
        }
        return (g4) g4Var;
    }

    public com.applovin.impl.sdk.network.b f0() {
        Object bVar = this.a0.get();
        if (bVar == null) {
            synchronized (this.a0) {
                bVar = this.a0.get();
                if (bVar == null) {
                    bVar = new com.applovin.impl.sdk.network.b(this);
                    this.a0.set(bVar);
                }
            }
        }
        if (bVar == this.a0) {
            bVar = null;
        }
        return (com.applovin.impl.sdk.network.b) bVar;
    }

    public PostbackServiceImpl g0() {
        Object postbackServiceImpl = this.Z.get();
        if (postbackServiceImpl == null) {
            synchronized (this.Z) {
                postbackServiceImpl = this.Z.get();
                if (postbackServiceImpl == null) {
                    postbackServiceImpl = new PostbackServiceImpl(this);
                    this.Z.set(postbackServiceImpl);
                }
            }
        }
        if (postbackServiceImpl == this.Z) {
            postbackServiceImpl = null;
        }
        return (PostbackServiceImpl) postbackServiceImpl;
    }

    public r h0() {
        Object objO0 = this.B.get();
        if (objO0 == null) {
            synchronized (this.B) {
                objO0 = this.B.get();
                if (objO0 == null) {
                    objO0 = O0();
                    if (objO0 == null) {
                        objO0 = this.B;
                    }
                    this.B.set(objO0);
                }
            }
        }
        if (objO0 == this.B) {
            objO0 = null;
        }
        return (r) objO0;
    }

    public e i() {
        Object eVar = this.F.get();
        if (eVar == null) {
            synchronized (this.F) {
                eVar = this.F.get();
                if (eVar == null) {
                    eVar = new e(this);
                    this.F.set(eVar);
                }
            }
        }
        if (eVar == this.F) {
            eVar = null;
        }
        return (e) eVar;
    }

    public String i0() {
        return x0().a();
    }

    public com.applovin.impl.j j() {
        Object jVar = this.b0.get();
        if (jVar == null) {
            synchronized (this.b0) {
                jVar = this.b0.get();
                if (jVar == null) {
                    jVar = new com.applovin.impl.j(this);
                    this.b0.set(jVar);
                }
            }
        }
        if (jVar == this.b0) {
            jVar = null;
        }
        return (com.applovin.impl.j) jVar;
    }

    public String j0() {
        return this.f655a;
    }

    public AppLovinAdServiceImpl k() {
        Object appLovinAdServiceImpl = this.m.get();
        if (appLovinAdServiceImpl == null) {
            synchronized (this.m) {
                appLovinAdServiceImpl = this.m.get();
                if (appLovinAdServiceImpl == null) {
                    appLovinAdServiceImpl = new AppLovinAdServiceImpl(this);
                    this.m.set(appLovinAdServiceImpl);
                }
            }
        }
        if (appLovinAdServiceImpl == this.m) {
            appLovinAdServiceImpl = null;
        }
        return (AppLovinAdServiceImpl) appLovinAdServiceImpl;
    }

    public MaxSegmentCollectionImpl k0() {
        return (MaxSegmentCollectionImpl) this.k;
    }

    public g l() {
        Object gVar = this.K.get();
        if (gVar == null) {
            synchronized (this.K) {
                gVar = this.K.get();
                if (gVar == null) {
                    gVar = new g(this);
                    this.K.set(gVar);
                }
            }
        }
        if (gVar == this.K) {
            gVar = null;
        }
        return (g) gVar;
    }

    public Map l0() {
        MaxSegmentCollectionImpl maxSegmentCollectionImplK0 = k0();
        if (maxSegmentCollectionImplK0 == null) {
            return null;
        }
        return maxSegmentCollectionImplK0.getJsonData();
    }

    public h m() {
        Object hVar = this.X.get();
        if (hVar == null) {
            synchronized (this.X) {
                hVar = this.X.get();
                if (hVar == null) {
                    hVar = new h(this);
                    this.X.set(hVar);
                }
            }
        }
        if (hVar == this.X) {
            hVar = null;
        }
        return (h) hVar;
    }

    public u4 m0() {
        Object u4Var = this.O.get();
        if (u4Var == null) {
            synchronized (this.O) {
                u4Var = this.O.get();
                if (u4Var == null) {
                    u4Var = new u4(this);
                    this.O.set(u4Var);
                }
            }
        }
        if (u4Var == this.O) {
            u4Var = null;
        }
        return (u4) u4Var;
    }

    public SessionTracker n0() {
        Object sessionTracker = this.I.get();
        if (sessionTracker == null) {
            synchronized (this.I) {
                sessionTracker = this.I.get();
                if (sessionTracker == null) {
                    sessionTracker = new SessionTracker(this);
                    this.I.set(sessionTracker);
                }
            }
        }
        if (sessionTracker == this.I) {
            sessionTracker = null;
        }
        return (SessionTracker) sessionTracker;
    }

    public AppLovinSdkSettings o0() {
        return this.j;
    }

    public ArrayService p() {
        Object arrayService = this.U.get();
        if (arrayService == null) {
            synchronized (this.U) {
                arrayService = this.U.get();
                if (arrayService == null) {
                    arrayService = new ArrayService(this);
                    this.U.set(arrayService);
                }
            }
        }
        if (arrayService == this.U) {
            arrayService = null;
        }
        return (ArrayService) arrayService;
    }

    public w4 p0() {
        Object w4Var = this.x.get();
        if (w4Var == null) {
            synchronized (this.x) {
                w4Var = this.x.get();
                if (w4Var == null) {
                    w4Var = new w4(this);
                    this.x.set(w4Var);
                }
            }
        }
        if (w4Var == this.x) {
            w4Var = null;
        }
        return (w4) w4Var;
    }

    public i q() {
        Object iVar = this.P.get();
        if (iVar == null) {
            synchronized (this.P) {
                iVar = this.P.get();
                if (iVar == null) {
                    iVar = new i(this);
                    this.P.set(iVar);
                }
            }
        }
        if (iVar == this.P) {
            iVar = null;
        }
        return (i) iVar;
    }

    public y4 q0() {
        Object y4Var = this.C.get();
        if (y4Var == null) {
            synchronized (this.C) {
                y4Var = this.C.get();
                if (y4Var == null) {
                    y4Var = new y4(this);
                    this.C.set(y4Var);
                }
            }
        }
        if (y4Var == this.C) {
            y4Var = null;
        }
        return (y4) y4Var;
    }

    public String r() {
        return this.b;
    }

    public b6 r0() {
        Object b6Var = this.w.get();
        if (b6Var == null) {
            synchronized (this.w) {
                b6Var = this.w.get();
                if (b6Var == null) {
                    b6Var = new b6(this);
                    this.w.set(b6Var);
                }
            }
        }
        if (b6Var == this.w) {
            b6Var = null;
        }
        return (b6) b6Var;
    }

    public String s() {
        return x0().b();
    }

    public w6 s0() {
        Object w6Var = this.R.get();
        if (w6Var == null) {
            synchronized (this.R) {
                w6Var = this.R.get();
                if (w6Var == null) {
                    w6Var = new w6(this);
                    this.R.set(w6Var);
                }
            }
        }
        if (w6Var == this.R) {
            w6Var = null;
        }
        return (w6) w6Var;
    }

    public CmpServiceImpl t() {
        Object cmpServiceImpl = this.p.get();
        if (cmpServiceImpl == null) {
            synchronized (this.p) {
                cmpServiceImpl = this.p.get();
                if (cmpServiceImpl == null) {
                    cmpServiceImpl = new CmpServiceImpl(this);
                    this.p.set(cmpServiceImpl);
                }
            }
        }
        if (cmpServiceImpl == this.p) {
            cmpServiceImpl = null;
        }
        return (CmpServiceImpl) cmpServiceImpl;
    }

    public c7 t0() {
        Object c7Var = this.k0.get();
        if (c7Var == null) {
            synchronized (this.k0) {
                c7Var = this.k0.get();
                if (c7Var == null) {
                    c7Var = new c7(this);
                    this.k0.set(c7Var);
                }
            }
        }
        if (c7Var == this.k0) {
            c7Var = null;
        }
        return (c7) c7Var;
    }

    public String toString() {
        return "CoreSdk{sdkKey='" + this.f655a + "', enabled=" + this.r0 + ", isFirstSession=" + this.s0 + AbstractJsonLexerKt.END_OBJ;
    }

    public j u() {
        Object jVar = this.N.get();
        if (jVar == null) {
            synchronized (this.N) {
                jVar = this.N.get();
                if (jVar == null) {
                    jVar = new j(this);
                    this.N.set(jVar);
                }
            }
        }
        if (jVar == this.N) {
            jVar = null;
        }
        return (j) jVar;
    }

    public long u0() {
        if (this.h == 0) {
            return -1L;
        }
        return System.currentTimeMillis() - this.h;
    }

    public String v() {
        return x0().c();
    }

    public Activity v0() {
        Activity activityB = a(o()).b();
        return activityB != null ? activityB : J();
    }

    public SdkConfigurationImpl w() {
        return this.y0;
    }

    public i7 w0() {
        return this.v;
    }

    public q0 x() {
        Object q0Var = this.y.get();
        if (q0Var == null) {
            synchronized (this.y) {
                q0Var = this.y.get();
                if (q0Var == null) {
                    q0Var = new q0(this);
                    this.y.set(q0Var);
                }
            }
        }
        if (q0Var == this.y) {
            q0Var = null;
        }
        return (q0) q0Var;
    }

    public j7 x0() {
        Object j7Var = this.D.get();
        if (j7Var == null) {
            synchronized (this.D) {
                j7Var = this.D.get();
                if (j7Var == null) {
                    j7Var = new j7(this);
                    this.D.set(j7Var);
                }
            }
        }
        if (j7Var == this.D) {
            j7Var = null;
        }
        return (j7) j7Var;
    }

    public t0 y() {
        Object t0Var = this.Q.get();
        if (t0Var == null) {
            synchronized (this.Q) {
                t0Var = this.Q.get();
                if (t0Var == null) {
                    t0Var = new t0(this);
                    this.Q.set(t0Var);
                }
            }
        }
        if (t0Var == this.Q) {
            t0Var = null;
        }
        return (t0) t0Var;
    }

    public i8 y0() {
        Object i8Var = this.L.get();
        if (i8Var == null) {
            synchronized (this.L) {
                i8Var = this.L.get();
                if (i8Var == null) {
                    i8Var = new i8(this);
                    this.L.set(i8Var);
                }
            }
        }
        if (i8Var == this.L) {
            i8Var = null;
        }
        return (i8) i8Var;
    }

    public d1 z() {
        Object d1Var = this.S.get();
        if (d1Var == null) {
            synchronized (this.S) {
                d1Var = this.S.get();
                if (d1Var == null) {
                    d1Var = new d1(this);
                    this.S.set(d1Var);
                }
            }
        }
        if (d1Var == this.S) {
            d1Var = null;
        }
        return (d1) d1Var;
    }

    public AppLovinSdk z0() {
        return this.q;
    }

    private void d() {
        b6 b6VarR0 = r0();
        int i = this.u0 + 1;
        this.u0 = i;
        b6VarR0.a((g5) new r5(i, this, new a()), b6.b.CORE);
    }

    public com.applovin.impl.c e() {
        return a(E0);
    }

    public com.applovin.impl.sdk.a f() {
        Object aVar = this.G.get();
        if (aVar == null) {
            synchronized (this.G) {
                aVar = this.G.get();
                if (aVar == null) {
                    aVar = new com.applovin.impl.sdk.a(this);
                    this.G.set(aVar);
                }
            }
        }
        if (aVar == this.G) {
            aVar = null;
        }
        return (com.applovin.impl.sdk.a) aVar;
    }

    public com.applovin.impl.f g() {
        return this.s;
    }

    public com.applovin.impl.sdk.d h() {
        Object dVar = this.W.get();
        if (dVar == null) {
            synchronized (this.W) {
                dVar = this.W.get();
                if (dVar == null) {
                    dVar = new com.applovin.impl.sdk.d(this);
                    this.W.set(dVar);
                }
            }
        }
        if (dVar == this.W) {
            dVar = null;
        }
        return (com.applovin.impl.sdk.d) dVar;
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        E0 = context.getApplicationContext();
        F0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject) {
        if (JsonUtils.isValid(jSONObject)) {
            this.h = System.currentTimeMillis();
            r0.c(jSONObject, this);
            r0.b(jSONObject, this);
            r0.a(jSONObject, this);
            i3.f(jSONObject, this);
            i3.d(jSONObject, this);
            i3.e(jSONObject, this);
            i3.g(jSONObject, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(AppLovinSdkInitializationConfiguration appLovinSdkInitializationConfiguration) {
        B0();
        this.j.attachAppLovinSdk(this);
        String pluginVersion = appLovinSdkInitializationConfiguration.getPluginVersion();
        if (pluginVersion != null) {
            o.g("AppLovinSdk", "Setting plugin version: " + pluginVersion);
            p0().a(v4.I3, pluginVersion);
        }
        if (appLovinSdkInitializationConfiguration.isExceptionHandlerEnabled() && ((Boolean) a(v4.s)).booleanValue()) {
            AppLovinExceptionHandler.shared().addSdk(this);
            AppLovinExceptionHandler.shared().enable();
        }
        b6 b6VarR0 = r0();
        g5 g5Var = this.B0;
        b6.b bVar = b6.b.CORE;
        b6VarR0.a(g5Var, bVar);
        r0().a(this.C0, bVar);
    }

    public void a(AppLovinSdk appLovinSdk) {
        this.q = appLovinSdk;
    }

    public static String a(String str) {
        return a(str, (List) null);
    }

    public static String a(int i) {
        return a(i, (List) null);
    }

    public static String a(String str, List list) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Context contextO = o();
        return a(contextO.getResources().getIdentifier(str, "string", contextO.getPackageName()), list);
    }

    public static String a(int i, List list) {
        String string = o().getResources().getString(i);
        return list != null ? String.format(string, list.toArray()) : string;
    }

    public static com.applovin.impl.c a(Context context) {
        if (I0 == null) {
            synchronized (J0) {
                if (I0 == null) {
                    I0 = new com.applovin.impl.c(context);
                }
            }
        }
        return I0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        O();
        if (o.a()) {
            O().a("AppLovinSdk", str);
        }
        r0().a(new a6(this));
    }

    public void c() {
        synchronized (this.m0) {
            if (!this.q0 && !this.r0) {
                T0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        Iterator it = JsonUtils.getList(jSONObject, "error_messages", Collections.emptyList()).iterator();
        while (it.hasNext()) {
            o.h("AppLovinSdk", (String) it.next());
        }
    }

    public void a(final AppLovinSdkInitializationConfiguration appLovinSdkInitializationConfiguration, final AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        synchronized (this.x0) {
            if (this.w0 != null) {
                o.h("AppLovinSdk", "AppLovin SDK already initialized with configuration: " + this.w0 + ". Ignoring the provided initialization configuration.");
                if (!C0() || sdkInitializationListener == null) {
                    return;
                }
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(sdkInitializationListener);
                    }
                });
                return;
            }
            this.e = System.currentTimeMillis();
            this.w0 = appLovinSdkInitializationConfiguration;
            this.z0 = sdkInitializationListener;
            this.f655a = appLovinSdkInitializationConfiguration.getSdkKey();
            this.b = appLovinSdkInitializationConfiguration.getAxonEventKey();
            this.l = appLovinSdkInitializationConfiguration.getMediationProvider();
            this.k = appLovinSdkInitializationConfiguration.getSegmentCollection();
            k7.a(new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(appLovinSdkInitializationConfiguration);
                }
            });
        }
    }

    public List c(v4 v4Var) {
        return p0().c(v4Var);
    }

    public void c(x4 x4Var) {
        q0().b(x4Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        if (!k7.c(this)) {
            HashMap map = new HashMap();
            map.put("details", "admob");
            map.put("error_message", str);
            E().a(c2.E0, "adapterVersionMismatch", map);
            return;
        }
        throw new IllegalStateException(str);
    }

    protected void b(boolean z) {
        final AppLovinSdk.SdkInitializationListener sdkInitializationListener;
        if (y().i() || (sdkInitializationListener = this.z0) == null) {
            return;
        }
        if (C0()) {
            this.z0 = null;
            this.A0 = null;
            S().a(MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS);
        } else {
            if (this.A0 == sdkInitializationListener) {
                return;
            }
            S().a(MaxAdapter.InitializationStatus.INITIALIZED_FAILURE);
            if (((Boolean) a(v4.p)).booleanValue()) {
                this.z0 = null;
            } else {
                this.A0 = sdkInitializationListener;
            }
        }
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putBoolean(jSONObject, "enabled", C0());
        JsonUtils.putBoolean(jSONObject, "timeout", z);
        JsonUtils.putBoolean(jSONObject, "consent_flow_shown", this.p0.get());
        long jCurrentTimeMillis = System.currentTimeMillis() - this.e;
        HashMap map = new HashMap();
        map.put("duration_ms", String.valueOf(jCurrentTimeMillis));
        map.put("details", jSONObject.toString());
        this.v.d(c2.i, map);
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(sdkInitializationListener);
            }
        }, Math.max(0L, ((Long) a(v4.q)).longValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        sdkInitializationListener.onSdkInitialized(this.y0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a(JSONObject jSONObject) {
        List listAsList = Arrays.asList(JsonUtils.getString(jSONObject, "eaf", "").split(io.appmetrica.analytics.coreutils.internal.StringUtils.COMMA));
        ArrayList arrayList = new ArrayList(listAsList.size());
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            MaxAdFormat fromString = MaxAdFormat.formatFromString((String) it.next());
            if (fromString != null) {
                arrayList.add(fromString);
            }
        }
        return arrayList;
    }

    public void a(boolean z) {
        synchronized (this.m0) {
            this.q0 = false;
            this.r0 = z;
        }
        if (z) {
            List listA = t3.a(this);
            if (listA.isEmpty()) {
                r0().h();
                N0();
                return;
            }
            Long l = (Long) a(o3.f7);
            p6 p6Var = new p6(this, true, "timeoutInitAdapters", new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.J0();
                }
            });
            O();
            if (o.a()) {
                O().a("AppLovinSdk", "Waiting for required adapters to init: " + listA + " - timing out in " + l + "ms...");
            }
            r0().a(p6Var, b6.b.TIMEOUT, l.longValue(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        O();
        if (o.a()) {
            O().a("AppLovinSdk", "Calling back publisher's initialization completion handler...");
        }
        sdkInitializationListener.onSdkInitialized(this.y0);
    }

    public List b(v4 v4Var) {
        return p0().b(v4Var);
    }

    public void b(x4 x4Var, Object obj) {
        q0().b(x4Var, obj);
    }

    public Object b(x4 x4Var) {
        return q0().a(x4Var);
    }

    public String b() {
        if (StringUtils.isValidString(this.v0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Map mapW = W();
        List listC = c(v4.h4);
        Boolean bool = (Boolean) a(v4.i4);
        if (mapW.isEmpty() && !bool.booleanValue()) {
            return null;
        }
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            Integer numValueOf = (Integer) a(v4.g4);
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (numValueOf.intValue() <= 0) {
                    break;
                }
                String className = stackTraceElement.getClassName();
                Iterator it = listC.iterator();
                do {
                    if (!it.hasNext()) {
                        for (Map.Entry entry : mapW.entrySet()) {
                            if (className.startsWith((String) entry.getKey())) {
                                this.v0 = (String) entry.getValue();
                                O();
                                if (o.a()) {
                                    O().a("AppLovinSdk", "Detected mediation provider: " + this.v0);
                                }
                                return null;
                            }
                        }
                        if (bool.booleanValue()) {
                            arrayList.add(className);
                        }
                        numValueOf = Integer.valueOf(numValueOf.intValue() - 1);
                        break;
                    }
                } while (!className.startsWith((String) it.next()));
            }
        } catch (Throwable th) {
            E().a("AppLovinSdk", "detectMediationProvider", th);
        }
        this.v0 = "unknown";
        O();
        if (o.a()) {
            O().k("AppLovinSdk", "Unable to detect mediation provider");
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        String strJoin = StringUtils.join(io.appmetrica.analytics.coreutils.internal.StringUtils.COMMA, arrayList);
        if (!((Boolean) a(v4.j4)).booleanValue()) {
            return strJoin;
        }
        E().a(c2.d, "detectMediationProvider", CollectionUtils.hashMap("details", strJoin));
        return null;
    }

    public void a(h3 h3Var) {
        if (r0().g()) {
            return;
        }
        List listA = t3.a(this);
        if (listA.size() <= 0 || !S().a().containsAll(listA)) {
            return;
        }
        O();
        if (o.a()) {
            O().a("AppLovinSdk", "All required adapters initialized");
        }
        r0().h();
        N0();
    }

    public boolean a(MaxAdFormat maxAdFormat) {
        List list = this.l0;
        return (list == null || list.size() <= 0 || this.l0.contains(maxAdFormat)) ? false : true;
    }

    public void a() {
        String str = (String) q0().a(x4.g, null);
        if (StringUtils.isValidString(str)) {
            if (AppLovinSdk.VERSION_CODE < k7.g(str)) {
                o.h("AppLovinSdk", "Current version (" + AppLovinSdk.VERSION + ") is older than earlier installed version (" + str + "), which may cause compatibility issues.");
            }
        }
    }

    public Object a(v4 v4Var) {
        return p0().a(v4Var);
    }

    public boolean a(v4 v4Var, MaxAdFormat maxAdFormat) {
        return b(v4Var).contains(maxAdFormat);
    }

    public void a(Map map) {
        U().a(map);
    }

    public void a(Uri uri) {
        C().a(uri);
    }

    public void a(String str, Object obj, SharedPreferences.Editor editor) {
        q0().a(str, obj, editor);
    }

    public Object a(x4 x4Var) {
        return a(x4Var, (Object) null);
    }

    public Object a(x4 x4Var, Object obj) {
        return q0().a(x4Var, obj);
    }

    public Object a(String str, Object obj, Class cls, SharedPreferences sharedPreferences) {
        return y4.a(str, obj, cls, sharedPreferences);
    }

    public void a(SharedPreferences sharedPreferences) {
        q0().a(sharedPreferences);
    }
}
