package com.ogury.ad.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.ogury.core.internal.IntegrationLogger;
import com.ogury.core.internal.network.NetworkClient;
import com.ogury.core.internal.network.NetworkResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class u7 {
    public static final a i = new a();
    public static u7 j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7413a;
    public final s7 b;
    public final x5 c;
    public final t2 d;
    public final z e;
    public final v1 f;
    public final d4 g;
    public boolean h;

    public static final class a {
        public static u7 b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (s7.c == null) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                s7.c = new s7(applicationContext);
            }
            s7 s7Var = s7.c;
            Intrinsics.checkNotNull(s7Var);
            Intrinsics.checkNotNullParameter(context, "context");
            if (x5.c == null) {
                int millis = (int) TimeUnit.SECONDS.toMillis(t7.b.b.f7468a);
                Context context2 = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getApplicationContext(...)");
                Intrinsics.checkNotNullParameter(context2, "context");
                Context applicationContext2 = context2.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                x5.c = new x5(new m2(applicationContext2), new NetworkClient(millis, millis * 5));
            }
            x5 x5Var = x5.c;
            Intrinsics.checkNotNull(x5Var);
            t7 t7Var = t7.f7405a;
            t2 t2Var = new t2();
            z zVar = new z(context);
            v1 v1Var = new v1();
            d4.a aVar = d4.e;
            Context applicationContext3 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
            return new u7(context, s7Var, x5Var, t2Var, zVar, v1Var, aVar.a(applicationContext3));
        }

        @JvmStatic
        public final u7 a(Context context) {
            u7 u7Var;
            Intrinsics.checkNotNullParameter(context, "context");
            synchronized (this) {
                if (u7.j == null) {
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    u7.j = b(applicationContext);
                }
                u7Var = u7.j;
                Intrinsics.checkNotNull(u7Var);
            }
            return u7Var;
        }
    }

    public u7(Context context, s7 s7Var, x5 x5Var, t2 t2Var, z zVar, v1 v1Var, d4 d4Var) {
        t7 t7Var = t7.f7405a;
        this.f7413a = context;
        this.b = s7Var;
        this.c = x5Var;
        this.d = t2Var;
        this.e = zVar;
        this.f = v1Var;
        this.g = d4Var;
    }

    public final void a(x7 x7Var, String serializedProfigResponse) throws JSONException {
        z7 profig;
        String str = x7Var.b;
        String str2 = x7Var.c;
        s7 s7Var = this.b;
        s7Var.a(s7Var.f7401a.getInt("numberOfProfigApiCalls", 0) + 1);
        this.b.c();
        if (str != null) {
            this.b.c(str);
        }
        if (str2 != null) {
            this.b.b(str2);
        }
        Intrinsics.checkNotNullParameter(serializedProfigResponse, "serializedProfigResponse");
        try {
            profig = v7.a(new JSONObject(serializedProfigResponse));
        } catch (Exception unused) {
            u3.f7411a.getClass();
            profig = new z7();
        }
        if (!profig.f7463a) {
            throw new JSONException("Invalid configuration received");
        }
        IntegrationLogger.d("[Ads][setup] Saving configuration...");
        t7 t7Var = t7.f7405a;
        Intrinsics.checkNotNullParameter(profig, "newCachedProfigResponse");
        t7.b = profig;
        this.b.d(serializedProfigResponse);
        IntegrationLogger.d("[Ads][setup] Configuration saved");
        u3.f7411a.getClass();
        d4 d4Var = this.g;
        d4Var.getClass();
        Intrinsics.checkNotNullParameter(profig, "profig");
        if (profig.e.d.f7464a) {
            d4Var.a(d4Var.a());
        } else {
            d4Var.f7279a.a();
        }
    }

    public final z7 b() {
        z7 newCachedProfigResponse;
        c9.a("loadProfigResponseFromCache");
        SharedPreferences sharedPref = this.b.f7401a;
        Intrinsics.checkNotNullExpressionValue(sharedPref, "sharedPref");
        String serializedProfigResponse = p8.a(sharedPref, "fullProfigResponseJson");
        Intrinsics.checkNotNullParameter(serializedProfigResponse, "serializedProfigResponse");
        try {
            newCachedProfigResponse = v7.a(new JSONObject(serializedProfigResponse));
        } catch (Exception unused) {
            u3.f7411a.getClass();
            newCachedProfigResponse = new z7();
        }
        t7 t7Var = t7.f7405a;
        Intrinsics.checkNotNullParameter(newCachedProfigResponse, "newCachedProfigResponse");
        t7.b = newCachedProfigResponse;
        return newCachedProfigResponse;
    }

    public final void c() {
        IntegrationLogger.d("[Ads][setup] Configuration has just been marked as obsolete");
        this.b.b(0L);
    }

    public static void b(String str) {
        IntegrationLogger.d("[Ads][setup] Configuration needs to be synchronized with servers due to " + str + ".\n Proceeding with server synchronization...");
    }

    public final boolean a() {
        long j2 = this.b.f7401a.getLong("CACHE_MAX_AGE", 0L) + this.b.f7401a.getLong("CACHE_LAST_UPDATE_DATE", 0L);
        this.e.b.getClass();
        return j2 <= TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    /* JADX WARN: Code duplicated, block: B:39:0x017c  */
    /* JADX WARN: Code duplicated, block: B:41:0x018d  */
    /* JADX WARN: Code duplicated, block: B:42:0x01a2  */
    public final z7 a(boolean z) throws Exception {
        String string;
        SharedPreferences sharedPref;
        IntegrationLogger.d("[Ads][setup] Synchronizing configuration...");
        c9.a("syncProfigIfNecessary");
        JSONObject jSONObjectA = new y7(this.f7413a).a().a();
        String string2 = jSONObjectA.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        String strA = x3.a(string2);
        try {
            string = jSONObjectA.getJSONObject("privacy_compliancy").toString();
        } catch (JSONException unused) {
            u3.f7411a.getClass();
            string = "";
        }
        String strA2 = x3.a(string);
        z7 z7VarB = b();
        boolean zA = a();
        long j2 = this.b.f7401a.getLong("numberOfDays", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        TimeUnit timeUnit = TimeUnit.DAYS;
        if (j2 != jCurrentTimeMillis / timeUnit.toMillis(1L)) {
            this.b.a(0);
            s7 s7Var = this.b;
            s7Var.getClass();
            s7Var.f7401a.edit().putLong("numberOfDays", System.currentTimeMillis() / timeUnit.toMillis(1L)).apply();
        }
        if (!this.d.a(this.f7413a)) {
            IntegrationLogger.d("[Ads][setup] Impossible to join Ogury servers. No Internet connection");
            this.h = false;
        } else if (this.h && !zA) {
            IntegrationLogger.d("[Ads][setup] Configuration is already synchronizing");
            u3.f7411a.getClass();
        } else if (this.b.f7401a.getInt("numberOfProfigApiCalls", 0) >= z7VarB.c.f7466a) {
            IntegrationLogger.d("[Ads][setup] Too many synchronization");
            u3 u3Var = u3.f7411a;
            String str = "api calls reached " + (this.b.f7401a.getInt("numberOfProfigApiCalls", 0) >= z7VarB.c.f7466a);
            u3Var.getClass();
        } else if (!this.b.f7401a.contains("fullProfigResponseJson")) {
            b("a missing configuration");
            x7 x7Var = new x7(jSONObjectA, strA, strA2);
            this.h = true;
            IntegrationLogger.d("[Ads][setup] Synchronizing configuration from servers...");
            a(x7Var, z);
            this.h = false;
        } else if (!z7VarB.f7463a) {
            b("no profig synced");
            x7 x7Var2 = new x7(jSONObjectA, strA, strA2);
            this.h = true;
            IntegrationLogger.d("[Ads][setup] Synchronizing configuration from servers...");
            a(x7Var2, z);
            this.h = false;
        } else if (zA) {
            b("an obsolete configuration");
            x7 x7Var3 = new x7(jSONObjectA, strA, strA2);
            this.h = true;
            IntegrationLogger.d("[Ads][setup] Synchronizing configuration from servers...");
            a(x7Var3, z);
            this.h = false;
        } else {
            String string3 = this.b.f7401a.getString("appVersion", "5.0.1-404010");
            if (!Intrinsics.areEqual(string3 != null ? string3 : "", "5.0.1-404010")) {
                SharedPreferences sharedPref2 = this.b.f7401a;
                Intrinsics.checkNotNullExpressionValue(sharedPref2, "sharedPref");
                if (!Intrinsics.areEqual(p8.a(sharedPref2, "md5Profig"), strA)) {
                    b("the detection of a new SDK version");
                    x7 x7Var4 = new x7(jSONObjectA, strA, strA2);
                    this.h = true;
                    IntegrationLogger.d("[Ads][setup] Synchronizing configuration from servers...");
                    a(x7Var4, z);
                    this.h = false;
                } else {
                    sharedPref = this.b.f7401a;
                    Intrinsics.checkNotNullExpressionValue(sharedPref, "sharedPref");
                    if (!Intrinsics.areEqual(p8.a(sharedPref, "md5Profig"), strA2)) {
                        b("New Privacy Data");
                        x7 x7Var5 = new x7(jSONObjectA, strA, strA2);
                        this.h = true;
                        IntegrationLogger.d("[Ads][setup] Synchronizing configuration from servers...");
                        a(x7Var5, z);
                        this.h = false;
                    } else {
                        IntegrationLogger.d("[Ads][setup] Local configuration is up to date");
                    }
                }
            } else {
                sharedPref = this.b.f7401a;
                Intrinsics.checkNotNullExpressionValue(sharedPref, "sharedPref");
                if (!Intrinsics.areEqual(p8.a(sharedPref, "md5Profig"), strA2)) {
                    b("New Privacy Data");
                    x7 x7Var6 = new x7(jSONObjectA, strA, strA2);
                    this.h = true;
                    IntegrationLogger.d("[Ads][setup] Synchronizing configuration from servers...");
                    a(x7Var6, z);
                    this.h = false;
                } else {
                    IntegrationLogger.d("[Ads][setup] Local configuration is up to date");
                }
            }
        }
        t7 t7Var = t7.f7405a;
        return t7.a();
    }

    public final void a(x7 x7Var, boolean z) throws Exception {
        String str = "making profig api call " + x7Var;
        u3.f7411a.getClass();
        try {
            NetworkResponse networkResponseB = this.c.b(x7Var.a());
            if (networkResponseB instanceof NetworkResponse.Success) {
                a(((NetworkResponse.Success) networkResponseB).getResponseHeaders());
                v7.a(((NetworkResponse.Success) networkResponseB).getResponseBody());
                a(x7Var, ((NetworkResponse.Success) networkResponseB).getResponseBody());
                IntegrationLogger.d("[Ads][setup] Configuration synchronized");
                this.h = false;
                return;
            }
            if (networkResponseB instanceof NetworkResponse.Failure) {
                v1 v1Var = this.f;
                String responseBody = ((NetworkResponse.Failure) networkResponseB).getResponseBody();
                v1Var.getClass();
                w1 w1VarA = v1.a(responseBody);
                this.h = false;
                String message = ((NetworkResponse.Failure) networkResponseB).getException().getMessage();
                if (message == null) {
                    message = w1VarA.a().a();
                }
                throw new d9(new y5(message, 3), b9.REQUEST_FAILURE);
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            a(e.getMessage());
            u3.f7411a.getClass();
            this.h = false;
            if (z) {
                throw e;
            }
        }
    }

    public final void a(Map<String, List<String>> map) {
        List list;
        Map mutableMap = map != null ? MapsKt.toMutableMap(map) : null;
        long j2 = 43200;
        if (mutableMap != null && (list = (List) mutableMap.get("Cache-Control")) != null) {
            Matcher matcher = Pattern.compile("max-age=(\\d+)").matcher((CharSequence) CollectionsKt.first(list));
            while (matcher.find()) {
                String strGroup = matcher.group(1);
                Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
                j2 = Long.parseLong(strGroup);
            }
        }
        this.b.b(j2);
        s7 s7Var = this.b;
        this.e.b.getClass();
        s7Var.a(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
    }

    public final void a(String str) {
        IntegrationLogger.d("[Ads][setup] Failed to synchronize configuration (" + str + ")");
        t7 t7Var = t7.f7405a;
        t7.a(new z7());
        this.b.a();
        s7 s7Var = this.b;
        s7Var.a(s7Var.f7401a.getInt("numberOfProfigApiCalls", 0) + 1);
        this.b.c();
    }
}
