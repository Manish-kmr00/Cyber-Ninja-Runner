package com.ogury.ad.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.ogury.ad.common.OguryMediation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d4 {
    public static final a e = new a();
    public static volatile d4 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g4 f7279a;
    public final f4 b;
    public final c4 c;
    public final p5 d;

    public static final class a {
        public final d4 a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            d4 d4Var = d4.f;
            if (d4Var == null) {
                synchronized (this) {
                    d4Var = d4.f;
                    if (d4Var == null) {
                        t7 t7Var = t7.f7405a;
                        SharedPreferences sharedPreferences = context.getSharedPreferences("ogy-ads-monitoring", 0);
                        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
                        d4Var = new d4(new g4(sharedPreferences), new f4(context), new c4(), new p5(context));
                        d4.f = d4Var;
                    }
                }
            }
            return d4Var;
        }
    }

    public d4(g4 g4Var, f4 f4Var, c4 c4Var, p5 p5Var) {
        t7 t7Var = t7.f7405a;
        this.f7279a = g4Var;
        this.b = f4Var;
        this.c = c4Var;
        this.d = p5Var;
    }

    public static void b(b4 b4Var) {
        String str;
        u3 u3Var = u3.f7411a;
        String strD = b4Var.d();
        String strE = b4Var.e();
        JSONObject jSONObjectB = b4Var.b();
        String strG = b4Var.g();
        OguryMediation oguryMediationF = b4Var.f();
        x1 x1VarA = b4Var.a();
        String str2 = null;
        if (x1VarA != null) {
            str = "\n       campaignId : " + x1VarA.a() + "\n       creativeId : " + x1VarA.b() + "\n       extras     : " + x1VarA.c() + "\n";
        } else {
            str = null;
        }
        y1 y1VarC = b4Var.c();
        if (y1VarC != null) {
            str2 = "\n       type   : " + y1VarC.b() + "\n       reason : " + y1VarC.a() + "\n";
        }
        String str3 = "[Ads][Monitoring] sending event --->\nid        : " + strD + "\nname      : " + strE + "\ndetails   : " + jSONObjectB + "\nsession   : " + strG + "\nmediation : " + oguryMediationF + "\nad        : " + str + "\nerror     : " + str2 + "\n ";
        u3Var.getClass();
    }

    public final void a(o7 predefinedMonitoringEvent, String adUnitId, String sessionId, OguryMediation oguryMediation, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(predefinedMonitoringEvent, "predefinedMonitoringEvent");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        c4 c4Var = this.c;
        c4Var.getClass();
        Intrinsics.checkNotNullParameter(predefinedMonitoringEvent, "predefinedMonitoringEvent");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        c4Var.f7274a.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = predefinedMonitoringEvent.f7376a;
        String str2 = predefinedMonitoringEvent.b;
        p1 p1Var = p1.IMMEDIATE_DISPATCH;
        a(new b4(jCurrentTimeMillis, sessionId, str, str2, jSONObject, (y1) null, adUnitId, (x1) null, oguryMediation, 160));
    }

    public final void c(b4 event) {
        p1 p1Var = p1.DEFERRED_DISPATCH;
        event.getClass();
        Intrinsics.checkNotNullParameter(p1Var, "<set-?>");
        event.i = p1Var;
        g4 g4Var = this.f7279a;
        g4Var.getClass();
        Intrinsics.checkNotNullParameter(event, "event");
        synchronized (g4Var.b) {
            g4Var.c.add(event);
            g4Var.a(g4Var.c);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(o7 predefinedMonitoringEvent, c ad, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(predefinedMonitoringEvent, "predefinedMonitoringEvent");
        Intrinsics.checkNotNullParameter(ad, "ad");
        c4 c4Var = this.c;
        c4Var.getClass();
        Intrinsics.checkNotNullParameter(predefinedMonitoringEvent, "predefinedMonitoringEvent");
        Intrinsics.checkNotNullParameter(ad, "ad");
        c4Var.f7274a.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = ad.F;
        OguryMediation oguryMediation = ad.I;
        String str2 = predefinedMonitoringEvent.f7376a;
        String str3 = predefinedMonitoringEvent.b;
        String str4 = ad.n.f7379a;
        String str5 = ad.g;
        String str6 = ad.h;
        String str7 = ad.B;
        x1 x1Var = new x1(str5, str6, str7 != null ? new JSONArray(str7) : null);
        p1 p1Var = p1.IMMEDIATE_DISPATCH;
        a(new b4(jCurrentTimeMillis, str, str2, str3, jSONObject, (y1) null, str4, x1Var, oguryMediation, 32));
    }

    public static final Unit b() {
        return Unit.INSTANCE;
    }

    public final void a(n7 predefinedMonitoringErrorEvent, String adUnitId, String sessionId, OguryMediation oguryMediation, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Intrinsics.checkNotNullParameter(predefinedMonitoringErrorEvent, "predefinedMonitoringErrorEvent");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        c4 c4Var = this.c;
        c4Var.getClass();
        Intrinsics.checkNotNullParameter(predefinedMonitoringErrorEvent, "predefinedMonitoringErrorEvent");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        c4Var.f7274a.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = predefinedMonitoringErrorEvent.f7367a;
        String str2 = predefinedMonitoringErrorEvent.b;
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject2 != null) {
            jSONObject3 = jSONObject2;
        }
        jSONObject3.put("reason", predefinedMonitoringErrorEvent.d);
        y1 y1Var = new y1(predefinedMonitoringErrorEvent.c, jSONObject3);
        p1 p1Var = p1.IMMEDIATE_DISPATCH;
        a(new b4(jCurrentTimeMillis, sessionId, str, str2, jSONObject, y1Var, adUnitId, (x1) null, oguryMediation, 128));
    }

    public final void a(n7 predefinedMonitoringErrorEvent, c ad, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Intrinsics.checkNotNullParameter(predefinedMonitoringErrorEvent, "predefinedMonitoringErrorEvent");
        Intrinsics.checkNotNullParameter(ad, "ad");
        c4 c4Var = this.c;
        c4Var.getClass();
        Intrinsics.checkNotNullParameter(predefinedMonitoringErrorEvent, "predefinedMonitoringErrorEvent");
        Intrinsics.checkNotNullParameter(ad, "ad");
        c4Var.f7274a.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = ad.F;
        OguryMediation oguryMediation = ad.I;
        String str2 = predefinedMonitoringErrorEvent.f7367a;
        String str3 = predefinedMonitoringErrorEvent.b;
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject2 != null) {
            jSONObject3 = jSONObject2;
        }
        jSONObject3.put("reason", predefinedMonitoringErrorEvent.d);
        y1 y1Var = new y1(predefinedMonitoringErrorEvent.c, jSONObject3);
        String str4 = ad.n.f7379a;
        String str5 = ad.g;
        String str6 = ad.h;
        String str7 = ad.B;
        a(new b4(jCurrentTimeMillis, str, str2, str3, jSONObject, y1Var, str4, new x1(str5, str6, str7 != null ? new JSONArray(str7) : null), p1.IMMEDIATE_DISPATCH, oguryMediation));
    }

    public final void a(b4 b4Var) {
        b(b4Var);
        z7 z7Var = t7.b;
        if (!z7Var.f7463a && !z7Var.e.d.f7464a) {
            c(b4Var);
            return;
        }
        z7.a aVar = z7Var.e.d;
        if (!aVar.f7464a || aVar.b.contains(b4Var.c)) {
            return;
        }
        ConnectivityManager connectivityManager = this.d.f7384a;
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            List<b4> listA = a();
            listA.add(b4Var);
            a(listA);
            return;
        }
        c(b4Var);
    }

    public final synchronized void a(final List<b4> events) {
        String str;
        Intrinsics.checkNotNullParameter(events, "events");
        if (events.isEmpty()) {
            return;
        }
        f4 f4Var = this.b;
        f4Var.getClass();
        Intrinsics.checkNotNullParameter(events, "events");
        x5 x5Var = f4Var.f7296a;
        h4 h4Var = f4Var.b;
        h4Var.getClass();
        Intrinsics.checkNotNullParameter(events, "events");
        b0 app = h4Var.f7314a;
        d8 permissionsHandler = h4Var.d;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(permissionsHandler, "permissionsHandler");
        String strB = app.b.b();
        String packageName = app.f7264a.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        Context context = app.f7264a;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            str = "";
        }
        d0 app2 = new d0(strB, packageName, str, null);
        m8 sdk = new m8("5.0.1");
        d8 permissionsHandler2 = h4Var.d;
        Intrinsics.checkNotNullParameter(permissionsHandler2, "permissionsHandler");
        j8 screen = new j8(permissionsHandler2.o(), permissionsHandler2.p(), permissionsHandler2.n(), null, permissionsHandler2.j(), permissionsHandler2.r());
        d8 permissionsHandler3 = h4Var.d;
        Intrinsics.checkNotNullParameter(permissionsHandler3, "permissionsHandler");
        t3 locale = new t3(permissionsHandler3.k(), permissionsHandler3.l());
        d8 permissionsHandler4 = h4Var.d;
        Intrinsics.checkNotNullParameter(permissionsHandler4, "permissionsHandler");
        String strQ = permissionsHandler4.q();
        Intrinsics.checkNotNullParameter(locale, "locale");
        o8 settings = new o8(strQ, locale, null, permissionsHandler4.a());
        d8 permissionsHandler5 = h4Var.d;
        Intrinsics.checkNotNullParameter(permissionsHandler5, "permissionsHandler");
        o5 network = new o5(permissionsHandler5.m(), permissionsHandler5.c());
        d8 permissionsHandler6 = h4Var.d;
        Intrinsics.checkNotNullParameter(permissionsHandler6, "permissionsHandler");
        da webview = new da(permissionsHandler6.s());
        d8 permissionsHandler7 = h4Var.d;
        Intrinsics.checkNotNullParameter(permissionsHandler7, "permissionsHandler");
        z8 system = new z8(permissionsHandler7.b(), permissionsHandler7.h());
        z androidDevice = h4Var.b;
        d8 permissionsHandler8 = h4Var.d;
        Intrinsics.checkNotNullParameter(androidDevice, "androidDevice");
        Intrinsics.checkNotNullParameter(permissionsHandler8, "permissionsHandler");
        androidDevice.getClass();
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        String strE = permissionsHandler8.e();
        String strF = permissionsHandler8.f();
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(webview, "webview");
        Intrinsics.checkNotNullParameter(system, "system");
        o1 device = new o1("android", RELEASE, strE, strF, screen, settings, network, webview, system);
        z androidDevice2 = h4Var.b;
        Intrinsics.checkNotNullParameter(androidDevice2, "androidDevice");
        androidDevice2.b.getClass();
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        k9 uuidUtils = h4Var.c;
        Intrinsics.checkNotNullParameter(uuidUtils, "uuidUtils");
        uuidUtils.getClass();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Intrinsics.checkNotNullParameter(app2, "app");
        Intrinsics.checkNotNullParameter(sdk, "sdk");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(events, "events");
        h1 h1VarA = x5Var.a(new c8(lValueOf, string, app2, sdk, device, null, null, null, events).a());
        Function1<? super Throwable, Unit> consumer = new Function1() { // from class: com.ogury.ad.internal.d4$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return d4.a(this.f$0, events, (Throwable) obj);
            }
        };
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        h1VarA.c = consumer;
        h1VarA.b(new Function0() { // from class: com.ogury.ad.internal.d4$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d4.b();
            }
        });
    }

    public static final Unit a(d4 d4Var, List list, Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String strValueOf = String.valueOf(it.getMessage());
        d4Var.getClass();
        if (new Regex("Received 5\\d\\d from the server").containsMatchIn(strValueOf)) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                d4Var.c((b4) it2.next());
            }
        }
        return Unit.INSTANCE;
    }

    public final List<b4> a() {
        g4 g4Var = this.f7279a;
        synchronized (g4Var.b) {
            if (g4Var.c.isEmpty()) {
                return new ArrayList();
            }
            List<b4> mutableList = CollectionsKt.toMutableList((Collection) g4Var.c);
            g4Var.c.clear();
            g4Var.a(g4Var.c);
            return mutableList;
        }
    }
}
