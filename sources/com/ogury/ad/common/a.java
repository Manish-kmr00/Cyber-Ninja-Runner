package com.ogury.ad.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.iab.omid.library.ogury.Omid;
import com.ogury.ad.internal.b6;
import com.ogury.ad.internal.f6;
import com.ogury.ad.internal.g9;
import com.ogury.ad.internal.h1;
import com.ogury.ad.internal.l8;
import com.ogury.ad.internal.m1;
import com.ogury.ad.internal.r7;
import com.ogury.ad.internal.s7;
import com.ogury.ad.internal.u3;
import com.ogury.ad.internal.u7;
import com.ogury.ad.internal.v;
import com.ogury.ad.internal.v8;
import com.ogury.ad.internal.z3;
import com.ogury.ad.internal.z7;
import com.ogury.core.internal.GppConsentConstants;
import com.ogury.core.internal.IntegrationLogger;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h1.a f7255a;
    public final s7.a b;
    public final u7.a c;
    public final z3 d;
    public final f6 e;
    public final l8 f;
    public final g9 g;
    public int h;
    public Throwable i;
    public final List<b6> j;
    public SharedPreferences.OnSharedPreferenceChangeListener k;
    public SharedPreferences.OnSharedPreferenceChangeListener l;

    public a() {
        h1.a completableFactory = h1.d;
        s7.a profigDaoFactory = s7.b;
        u7.a profigHandlerFactory = u7.i;
        z3 measurementsEventsLogger = z3.f7460a;
        f6 omidSdk = f6.f7297a;
        l8 sdkIntegrationChecker = l8.f7347a;
        g9 topActivityMonitor = g9.f7309a;
        Intrinsics.checkNotNullParameter(completableFactory, "completableFactory");
        Intrinsics.checkNotNullParameter(profigDaoFactory, "profigDaoFactory");
        Intrinsics.checkNotNullParameter(profigHandlerFactory, "profigHandlerFactory");
        Intrinsics.checkNotNullParameter(measurementsEventsLogger, "measurementsEventsLogger");
        Intrinsics.checkNotNullParameter(omidSdk, "omidSdk");
        Intrinsics.checkNotNullParameter(sdkIntegrationChecker, "sdkIntegrationChecker");
        Intrinsics.checkNotNullParameter(topActivityMonitor, "topActivityMonitor");
        this.f7255a = completableFactory;
        this.b = profigDaoFactory;
        this.c = profigHandlerFactory;
        this.d = measurementsEventsLogger;
        this.e = omidSdk;
        this.f = sdkIntegrationChecker;
        this.g = topActivityMonitor;
        this.h = 1;
        List<b6> listSynchronizedList = Collections.synchronizedList(new LinkedList());
        Intrinsics.checkNotNullExpressionValue(listSynchronizedList, "synchronizedList(...)");
        this.j = listSynchronizedList;
    }

    public final void a(final v adsConfig) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(adsConfig, "adsConfig");
        IntegrationLogger.d("[Ads][setup] Starting...");
        final Context contextB = adsConfig.b();
        this.b.getClass();
        final s7 s7VarA = s7.a.a(contextB);
        try {
            this.g.a(contextB);
        } catch (Throwable th) {
            Intrinsics.checkNotNullParameter(th, "<this>");
            u3.f7411a.getClass();
        }
        this.f.getClass();
        l8.a(contextB);
        int i = this.h;
        if (i != 1 && i != 4) {
            IntegrationLogger.d("[Ads][setup] Already setting up or set up");
            return;
        }
        this.h = 3;
        String strA = adsConfig.a();
        if (strA != null && strA.length() != 0) {
            h1.a aVar = this.f7255a;
            Function0 function0 = new Function0() { // from class: com.ogury.ad.common.a$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return a.a(this.f$0, s7VarA, adsConfig, contextB);
                }
            };
            aVar.getClass();
            h1.a.a(function0).a(new Function1() { // from class: com.ogury.ad.common.a$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return a.a(this.f$0, adsConfig, (Throwable) obj);
                }
            }).b(new Function0() { // from class: com.ogury.ad.common.a$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return a.a(this.f$0, adsConfig, contextB);
                }
            });
            return;
        }
        IntegrationLogger.e("[Ads][setup] Failed to set up (invalid asset key: \"" + adsConfig.a() + "\")");
        Log.e("Ogury", "OgurySdk.init() error", new IllegalArgumentException("The api key is null empty. Please provide a valid api key"));
        this.h = 1;
        adsConfig.c().onFailed(null);
    }

    public final boolean b() {
        return this.h == 2;
    }

    public final boolean c() {
        return this.h == 1;
    }

    public static final void b(a aVar, u7 u7Var, SharedPreferences sharedPreferences, String str) {
        IntegrationLogger.d("[Ads][setup] Privacy data changed : " + str);
        aVar.getClass();
        IntegrationLogger.d("[Ads][setup] Current configuration is obsolete");
        u7Var.c();
    }

    public static final Unit a(a aVar, s7 s7Var, v vVar, Context context) throws Exception {
        aVar.getClass();
        String str = vVar.b;
        Intrinsics.checkNotNull(str);
        s7Var.a(str);
        aVar.a(context, s7Var);
        return Unit.INSTANCE;
    }

    public static final Unit a(a aVar, v vVar, Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        aVar.i = it;
        aVar.h = 4;
        IntegrationLogger.e("[Ads][setup] Failed to set up " + it.getMessage());
        u3.f7411a.getClass();
        vVar.c().onFailed(null);
        Iterator<b6> it2 = aVar.j.iterator();
        while (it2.hasNext()) {
            it2.next().a(it);
        }
        aVar.j.clear();
        return Unit.INSTANCE;
    }

    public static final Unit a(a aVar, v vVar, Context context) {
        IntegrationLogger.d("[Ads][setup] Completed!");
        u3.f7411a.getClass();
        aVar.h = 2;
        vVar.c.onInit();
        Iterator<b6> it = aVar.j.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        aVar.j.clear();
        aVar.a(context);
        return Unit.INSTANCE;
    }

    public final boolean a() {
        return this.h == 4;
    }

    public static final void a(a aVar, u7 u7Var, SharedPreferences sharedPreferences, String str) {
        if (CollectionsKt.contains(GppConsentConstants.INSTANCE.getCONSENT_KEYS(), str)) {
            IntegrationLogger.d("[Ads][setup] Consent data changed : " + str);
            aVar.getClass();
            IntegrationLogger.d("[Ads][setup] Current configuration is obsolete");
            u7Var.c();
        }
    }

    public final void a(final Context context) {
        Function0 callable = new Function0() { // from class: com.ogury.ad.common.a$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.a(this.f$0, context);
            }
        };
        Intrinsics.checkNotNullParameter(callable, "callable");
        new v8(callable, 0).b(new Function1() { // from class: com.ogury.ad.common.a$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return a.a(this.f$0, context, (z7) obj);
            }
        });
    }

    public static final z7 a(a aVar, Context context) {
        return aVar.c.a(context).b();
    }

    public static final Unit a(a aVar, Context context, z7 it) {
        Intrinsics.checkNotNullParameter(it, "it");
        aVar.getClass();
        if (it.f.f7470a) {
            aVar.e.getClass();
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Omid.activate(context.getApplicationContext());
            } catch (IllegalArgumentException error) {
                Intrinsics.checkNotNullParameter(error, "error");
            }
        }
        return Unit.INSTANCE;
    }

    public final void a(Context context, s7 s7Var) throws Exception {
        if (!b() && !r7.a(context)) {
            IntegrationLogger.e("[Ads][setup] The app is not in main application process");
            u3.f7411a.getClass();
            throw new IllegalStateException("The app is not in main application process".toString());
        }
        Context applicationContext = context.getApplicationContext();
        String strB = s7Var.b();
        if (!Intrinsics.areEqual(strB, "")) {
            u7.a aVar = this.c;
            Intrinsics.checkNotNull(applicationContext);
            final u7 u7VarA = aVar.a(applicationContext);
            u7VarA.a(false);
            this.k = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.ogury.ad.common.a$$ExternalSyntheticLambda5
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    a.a(this.f$0, u7VarA, sharedPreferences, str);
                }
            };
            this.l = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.ogury.ad.common.a$$ExternalSyntheticLambda6
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    a.b(this.f$0, u7VarA, sharedPreferences, str);
                }
            };
            m1 m1Var = new m1(context);
            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.k;
            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener2 = null;
            if (onSharedPreferenceChangeListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onConsentDataChanged");
                onSharedPreferenceChangeListener = null;
            }
            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener3 = this.l;
            if (onSharedPreferenceChangeListener3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onPrivacyDataChanged");
            } else {
                onSharedPreferenceChangeListener2 = onSharedPreferenceChangeListener3;
            }
            m1Var.a(onSharedPreferenceChangeListener, onSharedPreferenceChangeListener2);
            this.d.getClass();
            z3.a(applicationContext);
            return;
        }
        IntegrationLogger.e("[Ads][setup] Failed to set up (invalid asset key: \"" + strB + "\")");
        IllegalStateException illegalStateException = new IllegalStateException("There is no api key. Please call OgurySdk.init(context, apiKey) before trying to load or display an ad");
        Log.e("Ogury", "Init Error", illegalStateException);
        throw illegalStateException;
    }
}
