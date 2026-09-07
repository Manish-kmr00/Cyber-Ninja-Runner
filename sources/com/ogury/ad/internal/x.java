package com.ogury.ad.internal;

import android.content.Context;
import android.net.Uri;
import com.json.nu;
import com.ogury.ad.OguryAdError;
import com.ogury.ad.common.OguryMediation;
import com.ogury.core.internal.IntegrationLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class x implements u5 {
    public int A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7435a;
    public final com.ogury.ad.internal.d b;
    public final u7 c;
    public final z3 d;
    public final d4 e;
    public final v4 f;
    public final z4 g;
    public final j h;
    public final u i;
    public final s7 j;
    public final o k;
    public final t l;
    public final String m;
    public final OguryMediation n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public List<com.ogury.ad.internal.c> s;
    public s t;
    public final a6 u;
    public Function1<? super g8, Unit> v;
    public n6 w;
    public boolean x;
    public String y;
    public int z;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function0<z7> {
        public a(x xVar) {
            super(0, xVar, x.class, "getProfigAndSyncIfNeeded", "getProfigAndSyncIfNeeded()Lcom/ogury/ad/common/profig/data/ProfigResponse;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final z7 invoke() {
            x xVar = (x) this.receiver;
            z7 z7VarB = xVar.c.b();
            if (z7VarB.f7463a && !xVar.c.a()) {
                return z7VarB;
            }
            xVar.c("Configuration need to be synced");
            return xVar.c.a(true);
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function0<Unit> {
        public c(Object obj) {
            super(0, obj, x.class, nu.g, "onAdClosed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            x xVar = (x) this.receiver;
            for (com.ogury.ad.internal.c cVar : xVar.s) {
                v4 v4Var = xVar.f;
                String adId = cVar.b;
                v4Var.getClass();
                Intrinsics.checkNotNullParameter(adId, "adId");
                v4.b.remove(adId);
            }
            xVar.t = null;
            xVar.v = null;
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function1<u4, Unit> {
        public d(Object obj) {
            super(1, obj, x.class, "sendShowEvent", "sendShowEvent(Lcom/ogury/ad/mraid/MraidEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(u4 u4Var) {
            u4 event = u4Var;
            Intrinsics.checkNotNullParameter(event, "p0");
            x xVar = (x) this.receiver;
            t tVar = xVar.l;
            o adType = xVar.k;
            com.ogury.ad.internal.d dVar = xVar.b;
            s sVar = xVar.t;
            Function1<? super g8, Unit> function1 = xVar.v;
            tVar.getClass();
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(adType, "adType");
            if (Intrinsics.areEqual(event.b, "adDisplayed")) {
                tVar.b(adType, dVar, sVar);
            } else if (Intrinsics.areEqual(event.b, "adImpression")) {
                tVar.a(adType, dVar, event.f7412a, sVar);
            } else if (Intrinsics.areEqual(event.b, "adClosed")) {
                tVar.g++;
                tVar.c(adType, dVar, sVar);
            } else if (Intrinsics.areEqual(event.b, "closeWhithoutShowNextAd")) {
                tVar.h = true;
                tVar.c(adType, dVar, sVar);
            } else if (event instanceof a5) {
                t.a((a5) event, adType, dVar, function1);
            } else if (event instanceof i4) {
                tVar.a(adType, dVar, sVar);
            } else if (event instanceof t4) {
                t.a((t4) event, adType, dVar, sVar);
            }
            return Unit.INSTANCE;
        }
    }

    public x(Context context, String sessionId, OguryMediation oguryMediation, com.ogury.ad.internal.d adConfig, o adType, boolean z) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        c0 c0Var = new c0();
        t2 t2Var = new t2();
        m4 m4Var = m4.f7354a;
        u adsConditionsChecker = new u(applicationContext, c0Var, t2Var, adType, sessionId, oguryMediation);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(adsConditionsChecker, "adsConditionsChecker");
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        u7 u7VarA = u7.i.a(context);
        z3 z3Var = z3.f7460a;
        d4.a aVar = d4.e;
        Context applicationContext3 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
        d4 d4VarA = aVar.a(applicationContext3);
        v4 v4Var = v4.f7421a;
        Intrinsics.checkNotNullParameter(context, "context");
        z4 z4Var = new z4(context);
        j jVar = new j(context);
        Intrinsics.checkNotNullParameter(context, "context");
        if (s7.c == null) {
            Context applicationContext4 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext4, "getApplicationContext(...)");
            s7.c = new s7(applicationContext4);
        }
        s7 s7Var = s7.c;
        Intrinsics.checkNotNull(s7Var);
        t tVar = new t();
        this.f7435a = applicationContext2;
        this.b = adConfig;
        this.c = u7VarA;
        this.d = z3Var;
        this.e = d4VarA;
        this.f = v4Var;
        this.g = z4Var;
        this.h = jVar;
        this.i = adsConditionsChecker;
        this.j = s7Var;
        this.k = adType;
        this.l = tVar;
        this.m = sessionId;
        this.n = oguryMediation;
        this.o = z;
        this.r = true;
        this.s = new ArrayList();
        this.u = a6.f7259a;
    }

    public final boolean d() {
        return this.o;
    }

    public final boolean e() {
        return this.r;
    }

    public final void f() {
        c("Loading ads from servers...");
        this.e.a(o7.LI_002_SDK_EVENT_SEND_ADSYNC_REQUEST, this.b.f7276a, this.m, this.n, p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(this.y != null)), TuplesKt.to("reload", Boolean.valueOf(this.p))));
        v8<l> v8VarA = this.h.a(this.k, this.b, this.w, this.m, this.n, this.p, this.z);
        Function1<? super d9, Unit> consumer = new Function1() { // from class: com.ogury.ad.internal.x$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return x.b(this.f$0, (d9) obj);
            }
        };
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        v8VarA.c = consumer;
        v8VarA.b(new Function1() { // from class: com.ogury.ad.internal.x$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return x.a(this.f$0, (l) obj);
            }
        });
    }

    public final void g() throws JSONException {
        d4 d4Var = this.e;
        n7 n7Var = n7.LE_019_AD_ERROR_LOAD_DROPPED;
        String str = this.b.f7276a;
        String str2 = this.m;
        OguryMediation oguryMediation = this.n;
        Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(this.y != null));
        Pair pair2 = TuplesKt.to("reload", Boolean.valueOf(this.p));
        int i = this.z;
        d4Var.a(n7Var, str, str2, oguryMediation, p7.a(pair, pair2, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)), (JSONObject) null);
    }

    public final void h() {
        a(new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2300, "The ad could not be loaded due to a failure in ad precaching."));
    }

    @Override // com.ogury.ad.internal.u5
    public final void b(com.ogury.ad.internal.c ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        c("Ad " + ad.c() + " expired");
        this.s.remove(ad);
        int size = this.s.size();
        int i = 0;
        while (i < size) {
            com.ogury.ad.internal.c cVar = this.s.get(i);
            i++;
            cVar.getClass();
        }
    }

    public final boolean c() {
        return this.q;
    }

    public final void d(String str) {
        IntegrationLogger.e("[Ads][" + this.k.b() + "][load][" + this.b.a() + "] " + str);
    }

    public static final Unit c(x xVar, d9 errorThrowable) {
        Intrinsics.checkNotNullParameter(errorThrowable, "errorThrowable");
        xVar.d("Failed to load (" + errorThrowable.getMessage() + ")");
        xVar.a(new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2202, "The ad could not be loaded due to a failure in parsing."));
        return Unit.INSTANCE;
    }

    public static final void d(x xVar) {
        int size = xVar.s.size();
        int i = 0;
        while (i < size) {
            com.ogury.ad.internal.c cVar = xVar.s.get(i);
            i++;
            cVar.getClass();
        }
    }

    public final void a(s sVar) {
        this.t = sVar;
    }

    public final void a(String str) {
        this.q = true;
        this.p = this.o;
        c("Loading ad unit [" + this.b.a() + "]...");
        this.y = str;
        this.e.a(o7.LI_001_SDK_EVENT_LOAD, this.b.a(), this.m, this.n, p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(str != null)), TuplesKt.to("reload", Boolean.valueOf(this.p))));
        c("Waiting for module setup...");
        a6 a6Var = this.u;
        w ogurySdkInitCallback = new w(this);
        a6Var.getClass();
        Intrinsics.checkNotNullParameter(ogurySdkInitCallback, "ogurySdkInitCallback");
        com.ogury.ad.common.a aVar = a6.b;
        aVar.getClass();
        Intrinsics.checkNotNullParameter(ogurySdkInitCallback, "ogurySdkInitCallback");
        if (aVar.b()) {
            ogurySdkInitCallback.a();
            return;
        }
        if (aVar.h == 3) {
            aVar.j.add(ogurySdkInitCallback);
        } else if (aVar.c()) {
            ogurySdkInitCallback.b();
        } else if (aVar.a()) {
            ogurySdkInitCallback.a(aVar.i);
        }
    }

    public static final Unit b(x xVar, d9 throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        int iOrdinal = throwable.a().ordinal();
        if (iOrdinal == 0) {
            xVar.d("Failed to load (" + throwable.b().getMessage() + ")");
            xVar.a(new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2200, "The load failed because the ad request encountered an error, and the server returned an unexpected response: " + throwable.b().getMessage() + "."));
        } else if (iOrdinal == 1) {
            xVar.d("Failed to load (" + throwable.b().getMessage() + ")");
            xVar.a(new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2202, "The ad could not be loaded due to a failure in parsing."));
        } else if (iOrdinal == 2) {
            xVar.d("Failed to load (no ad available)");
            xVar.c("Triggering onAdError() callback");
            if (xVar.t == null) {
                xVar.c("No ad listener registered");
            }
            s sVar = xVar.t;
            if (sVar != null) {
                sVar.g();
            }
            xVar.q = false;
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            xVar.d("Failed to load (" + throwable.getMessage() + ")");
            xVar.a(new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2200, "The load failed because the ad request encountered an error, and the server returned an unexpected response: " + throwable.b().getMessage() + "."));
        }
        return Unit.INSTANCE;
    }

    public final void c(String str) {
        IntegrationLogger.d("[Ads][" + this.k.b() + "][load][" + this.b.a() + "] " + str);
    }

    public final void b(String str) {
        v8<l> v8VarA = this.h.a(str, this.k, this.b, this.m, this.n, this.p, this.z);
        Function1<? super d9, Unit> consumer = new Function1() { // from class: com.ogury.ad.internal.x$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return x.c(this.f$0, (d9) obj);
            }
        };
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        v8VarA.c = consumer;
        v8VarA.b(new Function1() { // from class: com.ogury.ad.internal.x$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return x.b(this.f$0, (l) obj);
            }
        });
    }

    public static final Unit b(x xVar, l adResponse) throws JSONException {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        z3 z3Var = xVar.d;
        com.ogury.ad.internal.c cVar = (com.ogury.ad.internal.c) CollectionsKt.firstOrNull((List) adResponse.f7342a);
        k7 k7Var = new k7("LOAD", cVar != null ? cVar.D : null);
        z3Var.getClass();
        z3.a(k7Var);
        xVar.c("LOAD event");
        if (!xVar.x) {
            xVar.c("Ads available");
            s sVar = xVar.t;
            if (sVar != null) {
                sVar.b();
            }
            xVar.a(CollectionsKt.toMutableList((Collection) adResponse.f7342a));
        }
        return Unit.INSTANCE;
    }

    public final void b() {
        c("Reset existing cache");
        this.x = true;
        for (com.ogury.ad.internal.c cVar : this.s) {
            v4 v4Var = this.f;
            String adId = cVar.b;
            v4Var.getClass();
            Intrinsics.checkNotNullParameter(adId, "adId");
            v4.b.remove(adId);
        }
        z4 z4Var = this.g;
        z4Var.getClass();
        Intrinsics.checkNotNullParameter(this, "oguryAdGateway");
        w9 w9Var = z4Var.b;
        w9Var.m = null;
        w9Var.i.removeCallbacksAndMessages(null);
        Iterator it = w9Var.b.iterator();
        while (it.hasNext()) {
            ((v9) it.next()).a();
        }
        w9Var.b.clear();
        w9Var.f = 0;
        w9Var.g = 0;
        w9Var.h = false;
        z4Var.f7461a.getClass();
        Intrinsics.checkNotNullParameter(this, "oguryAdGateway");
        Iterator it2 = m4.b.entrySet().iterator();
        while (it2.hasNext()) {
            if (Intrinsics.areEqual(((l4) ((Map.Entry) it2.next()).getValue()).f7343a.get(), this)) {
                it2.remove();
            }
        }
        this.t = null;
        this.v = null;
    }

    public final void a() throws JSONException {
        u uVar = this.i;
        if (!uVar.c.a(uVar.f7408a)) {
            d("Impossible to join Ogury servers. No Internet connection");
            d4 d4Var = this.e;
            n7 n7Var = n7.LE_001_CONDITIONS_NOT_MET_NO_INTERNET_CONNECTION;
            String str = this.b.f7276a;
            String str2 = this.m;
            OguryMediation oguryMediation = this.n;
            Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(this.y != null));
            Pair pair2 = TuplesKt.to("reload", Boolean.valueOf(this.p));
            int i = this.z;
            d4Var.a(n7Var, str, str2, oguryMediation, p7.a(pair, pair2, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)), (JSONObject) null);
            a(new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2002, "The load could not proceed because there is no active Internet connection."));
            return;
        }
        c("Retrieving configuration...");
        a callable = new a(this);
        Intrinsics.checkNotNullParameter(callable, "callable");
        v8 v8Var = new v8(callable, 0);
        Function1<? super d9, Unit> consumer = new Function1() { // from class: com.ogury.ad.internal.x$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return x.a(this.f$0, (d9) obj);
            }
        };
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        v8Var.c = consumer;
        v8Var.b(new Function1() { // from class: com.ogury.ad.internal.x$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return x.a(this.f$0, (z7) obj);
            }
        });
    }

    public static final Unit a(x xVar, d9 it) throws JSONException {
        Intrinsics.checkNotNullParameter(it, "it");
        xVar.d("Failed. Configuration not synced");
        d4 d4Var = xVar.e;
        n7 n7Var = n7.LE_016_SDK_CONFIGURATION_SYNCHRONIZATION_FAILED;
        String str = xVar.b.f7276a;
        String str2 = xVar.m;
        OguryMediation oguryMediation = xVar.n;
        JSONObject jSONObjectPut = new JSONObject().put("stacktrace", it.getMessage());
        Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(xVar.y != null));
        Pair pair2 = TuplesKt.to("reload", Boolean.valueOf(xVar.p));
        int i = xVar.z;
        d4Var.a(n7Var, str, str2, oguryMediation, p7.a(pair, pair2, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)), jSONObjectPut);
        xVar.a(new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2100, "The load could not proceed due to an invalid SDK configuration."));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0121  */
    public static final Unit a(x xVar, z7 profigResponse) throws JSONException {
        Intrinsics.checkNotNullParameter(profigResponse, "profigResponse");
        xVar.getClass();
        if (!profigResponse.f7463a) {
            xVar.d("Failed. Configuration not synced");
            d4 d4Var = xVar.e;
            n7 n7Var = n7.LE_016_SDK_CONFIGURATION_NOT_SYNCED;
            String str = xVar.b.f7276a;
            String str2 = xVar.m;
            OguryMediation oguryMediation = xVar.n;
            Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(xVar.y != null));
            Pair pair2 = TuplesKt.to("reload", Boolean.valueOf(xVar.p));
            int i = xVar.z;
            d4Var.a(n7Var, str, str2, oguryMediation, p7.a(pair, pair2, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)), (JSONObject) null);
            xVar.a(new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2100, "The load could not proceed due to an invalid SDK configuration."));
        } else if (!profigResponse.d.f7465a) {
            xVar.d("Failed. Ad serving has been disabled");
            d4 d4Var2 = xVar.e;
            n7 n7Var2 = n7.LE_008_CONFIG_RESTRICTIONS_AD_DISABLED;
            String str3 = xVar.b.f7276a;
            String str4 = xVar.m;
            OguryMediation oguryMediation2 = xVar.n;
            Pair pair3 = TuplesKt.to("from_ad_markup", Boolean.valueOf(xVar.y != null));
            Pair pair4 = TuplesKt.to("reload", Boolean.valueOf(xVar.p));
            int i2 = xVar.z;
            d4Var2.a(n7Var2, str3, str4, oguryMediation2, p7.a(pair3, pair4, TuplesKt.to("webview_termination", i2 > 0 ? Integer.valueOf(i2) : null)), p7.b(TuplesKt.to("disabling_reason", profigResponse.d.c)));
            xVar.q = false;
            String str5 = profigResponse.d.c;
            int iHashCode = str5.hashCode();
            if (iHashCode != -1984720000) {
                if (iHashCode != -1879742975) {
                    if (iHashCode == 659206911 && str5.equals("COUNTRY_NOT_OPEN")) {
                        xVar.a(new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2101, "The load could not proceed because ads are disabled; the user’s country is not yet available for advertising."));
                    } else {
                        xVar.a(new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2104, "The load could not proceed because ads are disabled for an unspecified reason."));
                    }
                } else if (str5.equals("CONSENT_MISSING")) {
                    xVar.a(new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2103, "The load could not proceed because ads are disabled; the user consent is missing or has not been provided."));
                } else {
                    xVar.a(new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2104, "The load could not proceed because ads are disabled for an unspecified reason."));
                }
            } else if (!str5.equals("CONSENT_DENIED")) {
                xVar.a(new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2104, "The load could not proceed because ads are disabled for an unspecified reason."));
            } else {
                xVar.a(new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2102, " The load could not proceed because ads are disabled; the user has denied consent for advertising."));
            }
        } else {
            xVar.c("Configuration successfully retrieved");
            z3 z3Var = xVar.d;
            k7 k7Var = new k7("LOAD", null);
            z3Var.getClass();
            z3.a(k7Var);
            xVar.c("LOAD event");
            String str6 = xVar.y;
            if (str6 != null) {
                Intrinsics.checkNotNull(str6);
                xVar.b(str6);
            } else {
                xVar.f();
            }
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(x xVar, l adResponse) throws JSONException {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        if (!xVar.x) {
            xVar.c("Ads available");
            s sVar = xVar.t;
            if (sVar != null) {
                sVar.b();
            }
            xVar.a(CollectionsKt.toMutableList((Collection) adResponse.f7342a));
        }
        return Unit.INSTANCE;
    }

    public final void a(List<com.ogury.ad.internal.c> ads) throws JSONException {
        o3 q2Var;
        Object obj;
        q3 q3Var;
        r3 r3Var;
        c("Precaching available ads...");
        String str = "format";
        if (this.z == 0) {
            d4 d4Var = this.e;
            o7 o7Var = o7.LI_004_SDK_EVENT_PRECACHE;
            com.ogury.ad.internal.c cVar = (com.ogury.ad.internal.c) CollectionsKt.first((List) ads);
            Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(this.y != null));
            com.ogury.ad.internal.c cVar2 = (com.ogury.ad.internal.c) CollectionsKt.firstOrNull((List) ads);
            if (cVar2 == null || (q3Var = cVar2.A) == null || (r3Var = q3Var.f7388a) == null) {
                obj = null;
            } else {
                Intrinsics.checkNotNullParameter(r3Var, "<this>");
                int iOrdinal = r3Var.ordinal();
                if (iOrdinal == 0) {
                    obj = "format";
                } else {
                    if (iOrdinal != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    obj = "sdk";
                }
            }
            Pair pair2 = TuplesKt.to("loaded_source", obj);
            Pair pair3 = TuplesKt.to("reload", Boolean.valueOf(this.p));
            int i = this.z;
            d4Var.a(o7Var, cVar, p7.a(pair, pair2, pair3, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)));
        }
        for (com.ogury.ad.internal.c cVar3 : ads) {
            this.A = cVar3.L;
            if (cVar3.c.length() == 0) {
                d("Failed to load (invalid ad)");
                c("Triggering onAdError() callback");
                if (this.t == null) {
                    c("No ad listener registered");
                }
                d4 d4Var2 = this.e;
                n7 n7Var = n7.LE_018_EMPTY_AD_HTML;
                Pair pair4 = TuplesKt.to("from_ad_markup", Boolean.valueOf(cVar3.H));
                Pair pair5 = TuplesKt.to("reload", Boolean.valueOf(cVar3.J));
                r3 r3Var2 = cVar3.A.f7388a;
                Intrinsics.checkNotNullParameter(r3Var2, "<this>");
                int iOrdinal2 = r3Var2.ordinal();
                if (iOrdinal2 != 0) {
                    if (iOrdinal2 != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    str = "sdk";
                }
                Pair pair6 = TuplesKt.to("loaded_source", str);
                int i2 = this.z;
                d4Var2.a(n7Var, cVar3, p7.a(pair4, pair5, pair6, TuplesKt.to("webview_termination", i2 > 0 ? Integer.valueOf(i2) : null)), (JSONObject) null);
                this.q = false;
                h();
                return;
            }
        }
        this.s = CollectionsKt.toMutableList((Collection) ads);
        z4 z4Var = this.g;
        b preCacheListener = new b();
        int i3 = this.z;
        z4Var.getClass();
        Intrinsics.checkNotNullParameter(this, "oguryAdGateway");
        Intrinsics.checkNotNullParameter(ads, "ads");
        Intrinsics.checkNotNullParameter(preCacheListener, "preCacheListener");
        w9 w9Var = z4Var.b;
        w9Var.m = preCacheListener;
        w9Var.i.removeCallbacksAndMessages(null);
        Iterator it = w9Var.b.iterator();
        while (it.hasNext()) {
            ((v9) it.next()).a();
        }
        w9Var.b.clear();
        w9Var.f = 0;
        w9Var.g = 0;
        w9Var.h = false;
        z4Var.f7461a.getClass();
        Intrinsics.checkNotNullParameter(this, "oguryAdGateway");
        Iterator it2 = m4.b.entrySet().iterator();
        while (it2.hasNext()) {
            if (Intrinsics.areEqual(((l4) ((Map.Entry) it2.next()).getValue()).f7343a.get(), this)) {
                it2.remove();
            }
        }
        for (com.ogury.ad.internal.c cVar4 : ads) {
            Context context = z4Var.e;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            d5 d5VarA = h5.a(context, cVar4);
            if (d5VarA != null) {
                z4Var.c.a(d5VarA);
                ca.a(d5VarA);
                w9 w9Var2 = z4Var.b;
                m4 m4Var = z4Var.f7461a;
                d4.a aVar = d4.e;
                Context applicationContext = z4Var.e.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                j3 command = new j3(d5VarA, cVar4, m4Var, this, aVar.a(applicationContext));
                w9Var2.getClass();
                Intrinsics.checkNotNullParameter(command, "command");
                w9Var2.b.add(command);
                if (cVar4.s.length() > 0) {
                    Context context2 = z4Var.e;
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    d5 d5VarA2 = h5.a(context2, cVar4);
                    if (d5VarA2 != null) {
                        ca.a(d5VarA2);
                    }
                    if (d5VarA2 != null) {
                        z0.a(d5VarA2);
                        w9 w9Var3 = z4Var.b;
                        n3 command2 = new n3(d5VarA2, cVar4);
                        w9Var3.getClass();
                        Intrinsics.checkNotNullParameter(command2, "command");
                        w9Var3.b.add(command2);
                    }
                }
            } else {
                l7.a.a(preCacheListener, cVar4, l7.b.WEBVIEW_NULL, null, 60);
                return;
            }
        }
        w9 w9Var4 = z4Var.b;
        b1 chromeVersionHelper = z4Var.c;
        z4Var.d.getClass();
        long millis = TimeUnit.SECONDS.toMillis(t7.b.d.e.c);
        w9Var4.getClass();
        Intrinsics.checkNotNullParameter(chromeVersionHelper, "chromeVersionHelper");
        w9Var4.l = Long.valueOf(System.currentTimeMillis());
        w9Var4.e = w9Var4.b.size();
        w9Var4.f = 0;
        w9Var4.g = 0;
        p3 p3Var = w9Var4.f7433a;
        x9 loadCallback = w9Var4.c;
        p3Var.getClass();
        Intrinsics.checkNotNullParameter(loadCallback, "loadCallback");
        Intrinsics.checkNotNullParameter(chromeVersionHelper, "chromeVersionHelper");
        if (chromeVersionHelper.b <= 57) {
            q2Var = new n8(loadCallback);
        } else {
            q2Var = new q2(loadCallback);
        }
        w9Var4.j = q2Var;
        q2Var.a(w9Var4.b, i3);
        w9Var4.a(millis);
    }

    public static final class b implements l7 {
        public b() {
        }

        @Override // com.ogury.ad.internal.l7
        public final void a(com.ogury.ad.internal.c ad, l7.b preCacheError, List<? extends w9.a> list, Long l, Long l2, String str) throws JSONException {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(ad, "ad");
            Intrinsics.checkNotNullParameter(preCacheError, "preCacheError");
            int iOrdinal = preCacheError.ordinal();
            String str2 = "sdk";
            String str3 = "format";
            if (iOrdinal == 0) {
                d4 d4Var = x.this.e;
                n7 n7Var = n7.LE_018_TIMEOUT;
                if (list != null) {
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((w9.a) it.next()).f7434a);
                    }
                } else {
                    arrayList = null;
                }
                JSONObject jSONObjectB = p7.b(TuplesKt.to("accomplished", arrayList), TuplesKt.to("time_span", l2), TuplesKt.to("timeout_duration", l), TuplesKt.to("stacktrace", str));
                Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(ad.H));
                Pair pair2 = TuplesKt.to("reload", Boolean.valueOf(ad.J));
                r3 r3Var = ad.A.f7388a;
                Intrinsics.checkNotNullParameter(r3Var, "<this>");
                int iOrdinal2 = r3Var.ordinal();
                if (iOrdinal2 != 0) {
                    if (iOrdinal2 != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    str3 = "sdk";
                }
                Pair pair3 = TuplesKt.to("loaded_source", str3);
                int i = x.this.z;
                d4Var.a(n7Var, ad, p7.a(pair, pair2, pair3, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)), jSONObjectB);
                x.this.a(new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2301, "The ad could not be loaded as precaching exceeded the time limit and timed out."));
            } else if (iOrdinal == 1) {
                d4 d4Var2 = x.this.e;
                n7 n7Var2 = n7.LE_018_WEBVIEW_NULL;
                JSONObject jSONObjectB2 = p7.b(TuplesKt.to("stacktrace", str));
                Pair pair4 = TuplesKt.to("from_ad_markup", Boolean.valueOf(ad.H));
                Pair pair5 = TuplesKt.to("reload", Boolean.valueOf(ad.J));
                r3 r3Var2 = ad.A.f7388a;
                Intrinsics.checkNotNullParameter(r3Var2, "<this>");
                int iOrdinal3 = r3Var2.ordinal();
                if (iOrdinal3 == 0) {
                    str2 = "format";
                } else if (iOrdinal3 != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                Pair pair6 = TuplesKt.to("loaded_source", str2);
                int i2 = x.this.z;
                d4Var2.a(n7Var2, ad, p7.a(pair4, pair5, pair6, TuplesKt.to("webview_termination", i2 > 0 ? Integer.valueOf(i2) : null)), jSONObjectB2);
                x.this.h();
            } else if (iOrdinal == 2) {
                d4 d4Var3 = x.this.e;
                n7 n7Var3 = n7.LE_018_WEBVIEW_AD_CONTENT_EMBEDDING_ERROR;
                JSONObject jSONObjectB3 = p7.b(TuplesKt.to("stacktrace", str));
                Pair pair7 = TuplesKt.to("from_ad_markup", Boolean.valueOf(ad.H));
                Pair pair8 = TuplesKt.to("reload", Boolean.valueOf(ad.J));
                r3 r3Var3 = ad.A.f7388a;
                Intrinsics.checkNotNullParameter(r3Var3, "<this>");
                int iOrdinal4 = r3Var3.ordinal();
                if (iOrdinal4 == 0) {
                    str2 = "format";
                } else if (iOrdinal4 != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                Pair pair9 = TuplesKt.to("loaded_source", str2);
                int i3 = x.this.z;
                d4Var3.a(n7Var3, ad, p7.a(pair7, pair8, pair9, TuplesKt.to("webview_termination", i3 > 0 ? Integer.valueOf(i3) : null)), jSONObjectB3);
                x.this.h();
            } else if (iOrdinal == 3) {
                d4 d4Var4 = x.this.e;
                n7 n7Var4 = n7.LE_018_NO_WEBVIEW_LOADED;
                JSONObject jSONObjectB4 = p7.b(TuplesKt.to("stacktrace", str));
                Pair pair10 = TuplesKt.to("from_ad_markup", Boolean.valueOf(ad.H));
                Pair pair11 = TuplesKt.to("reload", Boolean.valueOf(ad.J));
                r3 r3Var4 = ad.A.f7388a;
                Intrinsics.checkNotNullParameter(r3Var4, "<this>");
                int iOrdinal5 = r3Var4.ordinal();
                if (iOrdinal5 == 0) {
                    str2 = "format";
                } else if (iOrdinal5 != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                Pair pair12 = TuplesKt.to("loaded_source", str2);
                int i4 = x.this.z;
                d4Var4.a(n7Var4, ad, p7.a(pair10, pair11, pair12, TuplesKt.to("webview_termination", i4 > 0 ? Integer.valueOf(i4) : null)), jSONObjectB4);
                x.this.h();
            } else if (iOrdinal != 4) {
                d4 d4Var5 = x.this.e;
                n7 n7Var5 = n7.LE_018_UNKNOWN;
                JSONObject jSONObjectB5 = p7.b(TuplesKt.to("stacktrace", str));
                Pair pair13 = TuplesKt.to("from_ad_markup", Boolean.valueOf(ad.H));
                Pair pair14 = TuplesKt.to("reload", Boolean.valueOf(ad.J));
                r3 r3Var5 = ad.A.f7388a;
                Intrinsics.checkNotNullParameter(r3Var5, "<this>");
                int iOrdinal6 = r3Var5.ordinal();
                if (iOrdinal6 == 0) {
                    str2 = "format";
                } else if (iOrdinal6 != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                Pair pair15 = TuplesKt.to("loaded_source", str2);
                int i5 = x.this.z;
                d4Var5.a(n7Var5, ad, p7.a(pair13, pair14, pair15, TuplesKt.to("webview_termination", i5 > 0 ? Integer.valueOf(i5) : null)), jSONObjectB5);
                x.this.h();
            } else {
                x.this.c("Ad unloaded");
                x.this.h();
            }
            x xVar = x.this;
            xVar.q = false;
            xVar.d("Failed to load (precaching failed)");
        }

        @Override // com.ogury.ad.internal.l7
        public final void b(com.ogury.ad.internal.c cVar) {
            q3 q3Var;
            r3 r3Var;
            q3 q3Var2;
            r3 r3Var2;
            x xVar = x.this;
            xVar.q = false;
            xVar.o = true;
            if (xVar.t == null) {
                xVar.c("No ad listener registered");
            }
            x xVar2 = x.this;
            if (xVar2.z == 0) {
                xVar2.c("Ads successfully loaded!");
                x.this.c("Triggering onAdLoaded() callback");
                String str = "sdk";
                if (cVar != null) {
                    x xVar3 = x.this;
                    d4 d4Var = xVar3.e;
                    o7 o7Var = o7.LI_009_SDK_EVENT_LOADED;
                    Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(xVar3.y != null));
                    com.ogury.ad.internal.c cVar2 = (com.ogury.ad.internal.c) CollectionsKt.firstOrNull((List) x.this.s);
                    if (cVar2 == null || (q3Var2 = cVar2.A) == null || (r3Var2 = q3Var2.f7388a) == null) {
                        str = null;
                    } else {
                        Intrinsics.checkNotNullParameter(r3Var2, "<this>");
                        int iOrdinal = r3Var2.ordinal();
                        if (iOrdinal == 0) {
                            str = "format";
                        } else if (iOrdinal != 1) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    Pair pair2 = TuplesKt.to("loaded_source", str);
                    Pair pair3 = TuplesKt.to("reload", Boolean.valueOf(x.this.p));
                    int i = x.this.z;
                    d4Var.a(o7Var, cVar, p7.a(pair, pair2, pair3, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)));
                } else {
                    x xVar4 = x.this;
                    d4 d4Var2 = xVar4.e;
                    o7 o7Var2 = o7.LI_009_SDK_EVENT_LOADED;
                    String str2 = xVar4.b.f7276a;
                    String str3 = xVar4.m;
                    OguryMediation oguryMediation = xVar4.n;
                    Pair pair4 = TuplesKt.to("from_ad_markup", Boolean.valueOf(xVar4.y != null));
                    com.ogury.ad.internal.c cVar3 = (com.ogury.ad.internal.c) CollectionsKt.firstOrNull((List) x.this.s);
                    if (cVar3 == null || (q3Var = cVar3.A) == null || (r3Var = q3Var.f7388a) == null) {
                        str = null;
                    } else {
                        Intrinsics.checkNotNullParameter(r3Var, "<this>");
                        int iOrdinal2 = r3Var.ordinal();
                        if (iOrdinal2 == 0) {
                            str = "format";
                        } else if (iOrdinal2 != 1) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    Pair pair5 = TuplesKt.to("loaded_source", str);
                    Pair pair6 = TuplesKt.to("reload", Boolean.valueOf(x.this.p));
                    int i2 = x.this.z;
                    d4Var2.a(o7Var2, str2, str3, oguryMediation, p7.a(pair4, pair5, pair6, TuplesKt.to("webview_termination", i2 > 0 ? Integer.valueOf(i2) : null)));
                }
                s sVar = x.this.t;
                if (sVar != null) {
                    sVar.a();
                }
            }
        }

        @Override // com.ogury.ad.internal.l7
        public final void a(com.ogury.ad.internal.c ad) throws JSONException {
            Intrinsics.checkNotNullParameter(ad, "ad");
            x.this.c("Do not precache ad #" + ad.e());
            if (!x.this.d()) {
                x.this.e.a(n7.LE_018_AD_UNLOAD, ad, p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(ad.f())), TuplesKt.to("reload", Boolean.valueOf(ad.l())), TuplesKt.to("loaded_source", s3.a(ad.h().a())), TuplesKt.to("webview_termination", x.this.z > 0 ? Integer.valueOf(x.this.z) : null)), (JSONObject) null);
            } else {
                x.this.e.a(o7.LI_010_SDK_EVENT_BACKGROUND_UNLOAD, ad, p7.a(TuplesKt.to("from_ad_markup", Boolean.valueOf(ad.f())), TuplesKt.to("loaded_source", s3.a(ad.h().a())), TuplesKt.to("reload", Boolean.valueOf(ad.l())), TuplesKt.to("webview_termination", x.this.z > 0 ? Integer.valueOf(x.this.z) : null)));
            }
            x.this.s.remove(ad);
            x.d(x.this);
        }

        @Override // com.ogury.ad.internal.l7
        public final void a(com.ogury.ad.internal.c ad, boolean z, Uri failingUri) throws JSONException {
            Intrinsics.checkNotNullParameter(ad, "ad");
            Intrinsics.checkNotNullParameter(failingUri, "failingUri");
            x xVar = x.this;
            if (xVar.o) {
                xVar.a(ad, z, failingUri);
            } else {
                xVar.a(ad, z, failingUri, false);
            }
        }
    }

    @Override // com.ogury.ad.internal.u5
    public final void a(com.ogury.ad.internal.c ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        c("Unload ad " + ad.c());
        int i = 0;
        this.o = false;
        this.s.remove(ad);
        int size = this.s.size();
        while (i < size) {
            com.ogury.ad.internal.c cVar = this.s.get(i);
            i++;
            cVar.getClass();
        }
    }

    public final void a(q8 showAction) {
        q3 q3VarH;
        r3 r3VarA;
        q3 q3VarH2;
        r3 r3VarA2;
        Intrinsics.checkNotNullParameter(showAction, "showAction");
        IntegrationLogger.d("[Ads][" + this.k.b() + "][show] Showing ad unit [" + this.b.a() + "]...");
        Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(this.y != null));
        com.ogury.ad.internal.c cVar = (com.ogury.ad.internal.c) CollectionsKt.firstOrNull((List) this.s);
        Pair pair2 = TuplesKt.to("loaded_source", (cVar == null || (q3VarH2 = cVar.h()) == null || (r3VarA2 = q3VarH2.a()) == null) ? null : s3.a(r3VarA2));
        Pair pair3 = TuplesKt.to("reload", Boolean.valueOf(this.p));
        int i = this.z;
        JSONObject jSONObjectA = p7.a(pair, pair2, pair3, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null));
        if (this.s.isEmpty()) {
            this.e.a(o7.SI_001_SDK_EVENT_SHOW, this.b.a(), this.m, this.n, jSONObjectA);
        } else {
            this.e.a(o7.SI_001_SDK_EVENT_SHOW, (com.ogury.ad.internal.c) CollectionsKt.first((List) this.s), jSONObjectA);
        }
        if (this.i.a(this.t, this.o, this.b, this.s, this.y != null, this.p, this.z, this.A)) {
            this.r = false;
            d4 d4Var = this.e;
            o7 o7Var = o7.SI_002_SDK_EVENT_DISPLAY;
            com.ogury.ad.internal.c cVar2 = (com.ogury.ad.internal.c) CollectionsKt.first((List) this.s);
            Pair pair4 = TuplesKt.to("from_ad_markup", Boolean.valueOf(this.y != null));
            com.ogury.ad.internal.c cVar3 = (com.ogury.ad.internal.c) CollectionsKt.firstOrNull((List) this.s);
            Pair pair5 = TuplesKt.to("loaded_source", (cVar3 == null || (q3VarH = cVar3.h()) == null || (r3VarA = q3VarH.a()) == null) ? null : s3.a(r3VarA));
            Pair pair6 = TuplesKt.to("reload", Boolean.valueOf(this.p));
            int i2 = this.z;
            d4Var.a(o7Var, cVar2, p7.a(pair4, pair5, pair6, TuplesKt.to("webview_termination", i2 > 0 ? Integer.valueOf(i2) : null)));
            IntegrationLogger.d("[Ads][" + this.k.b() + "][show][" + this.b.a() + "] SHOW event");
            z3 z3Var = this.d;
            com.ogury.ad.internal.c cVar4 = (com.ogury.ad.internal.c) CollectionsKt.firstOrNull((List) this.s);
            k7 k7Var = new k7("SHOW", cVar4 != null ? cVar4.a() : null);
            z3Var.getClass();
            z3.a(k7Var);
            this.o = false;
            List<com.ogury.ad.internal.c> list = this.s;
            this.l.a(list.size());
            this.l.a(new c(this));
            for (com.ogury.ad.internal.c cVar5 : list) {
                cVar5.c(this.y != null);
                cVar5.a(this.n);
                v4 v4Var = this.f;
                String strG = cVar5.g();
                d dVar = new d(this);
                v4Var.getClass();
                v4.a(strG, dVar);
                cVar5.b(this.z);
            }
            showAction.a(this.f7435a, CollectionsKt.toMutableList((Collection) list));
            return;
        }
        if (this.z > this.A) {
            this.o = false;
        }
    }

    public final void a(OguryAdError oguryAdError) {
        c("Triggering onAdError() callback");
        if (this.t == null) {
            c("No ad listener registered");
        }
        s sVar = this.t;
        if (sVar != null) {
            sVar.a(oguryAdError);
        }
        this.q = false;
        this.o = false;
    }

    public final void a(com.ogury.ad.internal.c cVar, boolean z, Uri uri) throws JSONException {
        this.z++;
        d4 d4Var = this.e;
        o7 o7Var = o7.LI_011_SDK_EVENT_WEBVIEW_TERMINATED;
        Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(cVar.f()));
        Pair pair2 = TuplesKt.to("loaded_source", s3.a(cVar.h().a()));
        Pair pair3 = TuplesKt.to("reload", Boolean.valueOf(cVar.l()));
        Pair pair4 = TuplesKt.to("maxReloadAttemptsReached", Boolean.valueOf(this.z > this.A));
        int i = this.z;
        Uri uriBuild = null;
        Pair pair5 = TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null);
        Pair pair6 = TuplesKt.to("cause", z ? "WebView crash" : "WebView removed");
        if (z) {
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(uri.getScheme());
            builder.authority(uri.getAuthority());
            builder.path(uri.getPath());
            Unit unit = Unit.INSTANCE;
            uriBuild = builder.build();
        }
        d4Var.a(o7Var, cVar, p7.a(pair, pair2, pair3, pair4, pair5, pair6, TuplesKt.to("failing_url", uriBuild)));
        if (this.z <= cVar.i() && !this.s.isEmpty()) {
            d("Render process gone. Did crash: " + z + ", Failing URI: " + uri + ". Trying to reload ad...");
            ((com.ogury.ad.internal.c) CollectionsKt.first((List) this.s)).b(this.z);
            a(this.s);
            return;
        }
        a(cVar, z, uri, true);
    }

    public final void a(com.ogury.ad.internal.c cVar, boolean z, Uri uri, boolean z2) throws JSONException {
        String str;
        this.q = false;
        if (z2) {
            str = !this.s.isEmpty() ? "Maximum reached after " + cVar.i() + " tries. " : "Ads list is empty before reaching max attempts.";
        } else {
            str = "Removing ad from cache.";
        }
        d("Render process gone. Did crash: " + z + ", Failing URI: " + uri + ". " + str);
        if (z2) {
            return;
        }
        d4 d4Var = this.e;
        n7 n7Var = n7.LE_018_RENDER_PROCESS_GONE;
        Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(cVar.f()));
        Pair pair2 = TuplesKt.to("reload", Boolean.valueOf(cVar.l()));
        Pair pair3 = TuplesKt.to("loaded_source", s3.a(cVar.h().a()));
        int i = this.z;
        d4Var.a(n7Var, cVar, p7.a(pair, pair2, pair3, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)), (JSONObject) null);
        h();
    }
}
