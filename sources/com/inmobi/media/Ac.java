package com.inmobi.media;

import android.content.ComponentName;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import android.webkit.WebView;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.window.embedding.ActivityFilter;
import androidx.window.embedding.ActivityRule;
import androidx.window.embedding.RuleController;
import com.facebook.AuthenticationTokenClaims;
import com.google.android.gms.appset.AppSetIdInfo;
import com.iab.omid.library.inmobi.Omid;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class Ac {
    public static boolean b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Ac f3028a = new Ac();
    public static final C3658zc c = new C3658zc();

    public static final /* synthetic */ void a(Ac ac) {
        ac.getClass();
        b();
    }

    public static final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullExpressionValue("Ac", "TAG");
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            WebView webView = new WebView(context);
            webView.setWebViewClient(new pd());
            webView.clearCache(true);
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    public static final void d(Context context) {
        K5 k5A;
        String string;
        Context contextD;
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(context, "$context");
        C3531qb c3531qb = C3531qb.f3411a;
        if (c3531qb.b(context) && W3.a(context).isEmpty()) {
            c3531qb.a(context, false);
        }
        M2 m2 = M2.f3131a;
        Intrinsics.checkNotNull("M2");
        LinkedList linkedList = new LinkedList(D1.a((I2) AbstractC3415ib.d.getValue(), null, null, null, null, null, null, 63));
        M2.b = linkedList;
        Object objClone = linkedList.clone();
        Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type java.util.LinkedList<com.inmobi.signals.contextualdata.EncryptedContextualData>");
        M2.c = (LinkedList) objClone;
        ScheduledExecutorService scheduledExecutorService = P.f3162a;
        Intrinsics.checkNotNullParameter("AdQualityComponent", "tag");
        Intrinsics.checkNotNullParameter("starting", "message");
        Log.i("AdQualityComponent", "starting");
        if (P.d == null) {
            P.d = new N(P.e);
        }
        N n = P.d;
        if (n == null) {
            Intrinsics.throwUninitializedPropertyAccessException("executor");
            n = null;
        }
        if (n.b.get()) {
            Intrinsics.checkNotNullParameter("AdQualityComponent", "tag");
            Intrinsics.checkNotNullParameter("already started", "message");
            Log.i("AdQualityComponent", "already started");
        } else {
            N n2 = P.d;
            if (n2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("executor");
                n2 = null;
            }
            n2.a();
        }
        AbstractC3296a5.b();
        AbstractC3296a5.a();
        C3579u3 c3579u3 = AbstractC3565t3.f3431a;
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        AdConfig adConfig = (AdConfig) B4.a("ads", "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig", null);
        C3306b0 adReqDeprecateChecker = adConfig.getAdReqDeprecateChecker();
        AbstractC3565t3.e = adReqDeprecateChecker != null ? adReqDeprecateChecker.a(true) : true;
        AbstractC3565t3.e();
        if (adConfig.getRendering().getEnableImmersive()) {
            if (AbstractC3565t3.i && (contextD = C3517pb.d()) != null) {
                ConcurrentHashMap concurrentHashMap = K5.b;
                K5 k5A2 = J5.a(contextD, "display_info_store");
                Intrinsics.checkNotNullParameter("safe_area", "key");
                String string2 = k5A2.f3112a.getString("safe_area", null);
                if (string2 != null) {
                    try {
                        jSONObject = new JSONObject(string2);
                    } catch (JSONException unused) {
                        Intrinsics.checkNotNullExpressionValue("t3", "TAG");
                        jSONObject = null;
                    }
                } else {
                    jSONObject = null;
                }
                AbstractC3565t3.f = jSONObject;
                Intrinsics.checkNotNullExpressionValue("t3", "TAG");
                Objects.toString(AbstractC3565t3.f);
            }
            if (AbstractC3565t3.i) {
                if (AbstractC3565t3.f() != null) {
                    Intrinsics.checkNotNullExpressionValue("t3", "TAG");
                } else {
                    Context contextD2 = C3517pb.d();
                    if (contextD2 != null) {
                        ConcurrentHashMap concurrentHashMap2 = K5.b;
                        K5 k5A3 = J5.a(contextD2, "display_info_store");
                        Intrinsics.checkNotNullParameter("nav_bar_type", "key");
                        int i = k5A3.f3112a.getInt("nav_bar_type", -1);
                        Integer numValueOf = Integer.valueOf(i);
                        AbstractC3565t3.g = numValueOf;
                        if (i == -1) {
                            numValueOf = null;
                        }
                        AbstractC3565t3.g = numValueOf;
                        Intrinsics.checkNotNullExpressionValue("t3", "TAG");
                    }
                }
            }
        }
        String str = L9.f3126a;
        try {
            Context contextD3 = C3517pb.d();
            if (contextD3 != null && L9.c.getPurchases().getInapp()) {
                Context contextD4 = C3517pb.d();
                if (contextD4 != null) {
                    ConcurrentHashMap concurrentHashMap3 = K5.b;
                    k5A = J5.a(contextD4, "purchase_store");
                } else {
                    k5A = null;
                }
                if (k5A != null) {
                    Intrinsics.checkNotNullParameter("purchase_pref", "key");
                    string = k5A.f3112a.getString("purchase_pref", null);
                } else {
                    string = null;
                }
                if (string != null) {
                    L9.f3126a = string;
                }
                if (L9.a(contextD3)) {
                    L9.d = 1;
                    C3330ca c3330ca = new C3330ca();
                    L9.b = c3330ca;
                    c3330ca.a(contextD3, new J9());
                }
            }
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
        b();
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Reflection.getOrCreateKotlinClass(ActivityFilter.class).getSimpleName();
            Reflection.getOrCreateKotlinClass(ActivityRule.class).getSimpleName();
            Reflection.getOrCreateKotlinClass(RuleController.class).getSimpleName();
            RuleController.Companion.getInstance(context).addRule(new ActivityRule.Builder(SetsKt.setOf(new ActivityFilter(new ComponentName(context, (Class<?>) InMobiAdActivity.class), null))).setAlwaysExpand(true).build());
        } catch (NoClassDefFoundError unused2) {
        }
        try {
            C3335d1.f3289a.c();
            C3335d1.a();
        } catch (Exception unused3) {
            Intrinsics.checkNotNullExpressionValue("Ac", "TAG");
        }
        C3531qb.f3411a.a(context, "10.8.2");
        b = true;
    }

    public final boolean c() {
        try {
            Reflection.getOrCreateKotlinClass(CustomTabsClient.class).getSimpleName();
            Reflection.getOrCreateKotlinClass(Omid.class).getSimpleName();
            return false;
        } catch (NoClassDefFoundError unused) {
            return true;
        }
    }

    public final void e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        U0.f3208a.a(context, c);
    }

    public final void a(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            C3531qb c3531qb = C3531qb.f3411a;
            if (c3531qb.a(context) == null || !Intrinsics.areEqual(c3531qb.a(context), "10.8.2")) {
                ExecutorC3596v6 executorC3596v6 = (ExecutorC3596v6) S3.d.getValue();
                Runnable runnable = new Runnable() { // from class: com.inmobi.media.Ac$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Ac.b(context);
                    }
                };
                executorC3596v6.getClass();
                Intrinsics.checkNotNullParameter(runnable, "runnable");
                executorC3596v6.f3456a.post(runnable);
                c3531qb.a(context, W3.b(context));
                C3517pb c3517pb = C3517pb.f3400a;
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                c3517pb.a(applicationContext);
            }
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    /* JADX WARN: Code duplicated, block: B:69:0x019f  */
    public final void c(final Context context) {
        String string;
        String string2;
        String string3;
        int i;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        Intrinsics.checkNotNullParameter(context, "context");
        if (b) {
            return;
        }
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        C3549s2.a();
        Ob.c();
        C3532qc.f3412a.a();
        AppSetIdInfo appSetIdInfo = Q0.f3171a;
        Lazy lazy = T4.f3200a;
        C3435k3.f3355a.v();
        int i2 = I9.f3097a;
        Context contextD = C3517pb.d();
        if (i2 != Integer.MIN_VALUE) {
            I9.f3097a = i2;
            if (contextD != null) {
                ConcurrentHashMap concurrentHashMap = K5.b;
                J5.a(contextD, "user_info_store").a("user_age", i2);
            }
        }
        String str = I9.c;
        Context contextD2 = C3517pb.d();
        if (str != null) {
            I9.c = str;
            if (contextD2 != null) {
                ConcurrentHashMap concurrentHashMap2 = K5.b;
                J5.a(contextD2, "user_info_store").a("user_age_group", str);
            }
        }
        String str2 = I9.d;
        Context contextD3 = C3517pb.d();
        I9.d = str2;
        if (contextD3 != null && str2 != null) {
            ConcurrentHashMap concurrentHashMap3 = K5.b;
            J5.a(contextD3, "user_info_store").a("user_area_code", str2);
        }
        String str3 = I9.e;
        Context contextD4 = C3517pb.d();
        if (str3 != null) {
            I9.e = str3;
            if (contextD4 != null) {
                ConcurrentHashMap concurrentHashMap4 = K5.b;
                J5.a(contextD4, "user_info_store").a("user_post_code", str3);
            }
        }
        String str4 = I9.f;
        Context contextD5 = C3517pb.d();
        if (str4 != null) {
            I9.f = str4;
            if (contextD5 != null) {
                ConcurrentHashMap concurrentHashMap5 = K5.b;
                J5.a(contextD5, "user_info_store").a("user_city_code", str4);
            }
        }
        String str5 = I9.g;
        Context contextD6 = C3517pb.d();
        if (str5 != null) {
            I9.g = str5;
            if (contextD6 != null) {
                ConcurrentHashMap concurrentHashMap6 = K5.b;
                J5.a(contextD6, "user_info_store").a("user_state_code", str5);
            }
        }
        String str6 = I9.h;
        Context contextD7 = C3517pb.d();
        if (str6 != null) {
            I9.h = str6;
            if (contextD7 != null) {
                ConcurrentHashMap concurrentHashMap7 = K5.b;
                J5.a(contextD7, "user_info_store").a("user_country_code", str6);
            }
        }
        int i3 = I9.i;
        Context contextD8 = C3517pb.d();
        if (i3 != Integer.MIN_VALUE) {
            I9.i = i3;
            if (contextD8 != null) {
                ConcurrentHashMap concurrentHashMap8 = K5.b;
                J5.a(contextD8, "user_info_store").a("user_yob", i3);
            }
        }
        String str7 = I9.j;
        Context contextD9 = C3517pb.d();
        if (str7 != null) {
            I9.j = str7;
            if (contextD9 != null) {
                ConcurrentHashMap concurrentHashMap9 = K5.b;
                J5.a(contextD9, "user_info_store").a(AuthenticationTokenClaims.JSON_KEY_USER_GENDER, str7);
            }
        }
        String str8 = I9.k;
        Context contextD10 = C3517pb.d();
        if (str8 != null) {
            I9.k = str8;
            if (contextD10 != null) {
                ConcurrentHashMap concurrentHashMap10 = K5.b;
                J5.a(contextD10, "user_info_store").a("user_education", str8);
            }
        }
        String str9 = I9.l;
        Context contextD11 = C3517pb.d();
        if (str9 != null) {
            I9.l = str9;
            if (contextD11 != null) {
                ConcurrentHashMap concurrentHashMap11 = K5.b;
                J5.a(contextD11, "user_info_store").a("user_language", str9);
            }
        }
        String str10 = I9.m;
        Context contextD12 = C3517pb.d();
        if (str10 != null) {
            I9.m = str10;
            if (contextD12 != null) {
                ConcurrentHashMap concurrentHashMap12 = K5.b;
                J5.a(contextD12, "user_info_store").a("user_interest", str10);
            }
        }
        Location location = I9.n;
        Context contextD13 = C3517pb.d();
        if (location != null) {
            I9.n = location;
            if (contextD13 != null) {
                String string10 = new StringBuilder().append(location.getLatitude()).append(AbstractJsonLexerKt.COMMA).append(location.getLongitude()).append(AbstractJsonLexerKt.COMMA).append((int) location.getAccuracy()).append(AbstractJsonLexerKt.COMMA).append(location.getTime()).toString();
                ConcurrentHashMap concurrentHashMap13 = K5.b;
                J5.a(contextD13, "user_info_store").a(AuthenticationTokenClaims.JSON_KEY_USER_LOCATION, string10);
            }
        }
        int i4 = Integer.MIN_VALUE;
        if (I9.f3097a == Integer.MIN_VALUE) {
            Context contextD14 = C3517pb.d();
            if (contextD14 != null) {
                ConcurrentHashMap concurrentHashMap14 = K5.b;
                K5 k5A = J5.a(contextD14, "user_info_store");
                Intrinsics.checkNotNullParameter("user_age", "key");
                i4 = k5A.f3112a.getInt("user_age", Integer.MIN_VALUE);
            }
            I9.f3097a = i4;
        }
        String string11 = null;
        if (I9.c == null) {
            Context contextD15 = C3517pb.d();
            if (contextD15 == null) {
                string9 = null;
            } else {
                ConcurrentHashMap concurrentHashMap15 = K5.b;
                K5 k5A2 = J5.a(contextD15, "user_info_store");
                Intrinsics.checkNotNullParameter("user_age_group", "key");
                string9 = k5A2.f3112a.getString("user_age_group", null);
            }
            I9.c = string9;
        }
        if (I9.d == null) {
            Context contextD16 = C3517pb.d();
            if (contextD16 == null) {
                string8 = null;
            } else {
                ConcurrentHashMap concurrentHashMap16 = K5.b;
                K5 k5A3 = J5.a(contextD16, "user_info_store");
                Intrinsics.checkNotNullParameter("user_area_code", "key");
                string8 = k5A3.f3112a.getString("user_area_code", null);
            }
            I9.d = string8;
        }
        if (I9.e == null) {
            Context contextD17 = C3517pb.d();
            if (contextD17 == null) {
                string7 = null;
            } else {
                ConcurrentHashMap concurrentHashMap17 = K5.b;
                K5 k5A4 = J5.a(contextD17, "user_info_store");
                Intrinsics.checkNotNullParameter("user_post_code", "key");
                string7 = k5A4.f3112a.getString("user_post_code", null);
            }
            I9.e = string7;
        }
        if (I9.f == null) {
            Context contextD18 = C3517pb.d();
            if (contextD18 == null) {
                string6 = null;
            } else {
                ConcurrentHashMap concurrentHashMap18 = K5.b;
                K5 k5A5 = J5.a(contextD18, "user_info_store");
                Intrinsics.checkNotNullParameter("user_city_code", "key");
                string6 = k5A5.f3112a.getString("user_city_code", null);
            }
            I9.f = string6;
        }
        if (I9.g == null) {
            Context contextD19 = C3517pb.d();
            if (contextD19 == null) {
                string5 = null;
            } else {
                ConcurrentHashMap concurrentHashMap19 = K5.b;
                K5 k5A6 = J5.a(contextD19, "user_info_store");
                Intrinsics.checkNotNullParameter("user_state_code", "key");
                string5 = k5A6.f3112a.getString("user_state_code", null);
            }
            I9.g = string5;
        }
        if (I9.h == null) {
            Context contextD20 = C3517pb.d();
            if (contextD20 == null) {
                string4 = null;
            } else {
                ConcurrentHashMap concurrentHashMap20 = K5.b;
                K5 k5A7 = J5.a(contextD20, "user_info_store");
                Intrinsics.checkNotNullParameter("user_country_code", "key");
                string4 = k5A7.f3112a.getString("user_country_code", null);
            }
            I9.h = string4;
        }
        if (I9.i == Integer.MIN_VALUE) {
            Context contextD21 = C3517pb.d();
            if (contextD21 == null) {
                i = Integer.MIN_VALUE;
            } else {
                ConcurrentHashMap concurrentHashMap21 = K5.b;
                K5 k5A8 = J5.a(contextD21, "user_info_store");
                Intrinsics.checkNotNullParameter("user_yob", "key");
                i = k5A8.f3112a.getInt("user_yob", Integer.MIN_VALUE);
            }
            I9.i = i;
        }
        if (I9.j == null) {
            Context contextD22 = C3517pb.d();
            if (contextD22 == null) {
                string3 = null;
            } else {
                ConcurrentHashMap concurrentHashMap22 = K5.b;
                K5 k5A9 = J5.a(contextD22, "user_info_store");
                Intrinsics.checkNotNullParameter(AuthenticationTokenClaims.JSON_KEY_USER_GENDER, "key");
                string3 = k5A9.f3112a.getString(AuthenticationTokenClaims.JSON_KEY_USER_GENDER, null);
            }
            I9.j = string3;
        }
        if (I9.k == null) {
            Context contextD23 = C3517pb.d();
            if (contextD23 == null) {
                string2 = null;
            } else {
                ConcurrentHashMap concurrentHashMap23 = K5.b;
                K5 k5A10 = J5.a(contextD23, "user_info_store");
                Intrinsics.checkNotNullParameter("user_education", "key");
                string2 = k5A10.f3112a.getString("user_education", null);
            }
            I9.k = string2;
        }
        if (I9.l == null) {
            Context contextD24 = C3517pb.d();
            if (contextD24 == null) {
                string = null;
            } else {
                ConcurrentHashMap concurrentHashMap24 = K5.b;
                K5 k5A11 = J5.a(contextD24, "user_info_store");
                Intrinsics.checkNotNullParameter("user_language", "key");
                string = k5A11.f3112a.getString("user_language", null);
            }
            I9.l = string;
        }
        if (I9.m == null) {
            Context contextD25 = C3517pb.d();
            if (contextD25 != null) {
                ConcurrentHashMap concurrentHashMap25 = K5.b;
                K5 k5A12 = J5.a(contextD25, "user_info_store");
                Intrinsics.checkNotNullParameter("user_interest", "key");
                string11 = k5A12.f3112a.getString("user_interest", null);
            }
            I9.m = string11;
        }
        I9.b();
        I9.c();
        C3517pb.a(new Runnable() { // from class: com.inmobi.media.Ac$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Ac.d(context);
            }
        });
    }

    public static void b() {
        try {
            C3532qc.f3412a.a();
            AppSetIdInfo appSetIdInfo = Q0.f3171a;
            LinkedHashMap linkedHashMap = C3578u2.f3440a;
            C3549s2.a();
            C3364f2.f3308a.h();
            Ob.c();
            C3601vb.f3460a.b();
            md mdVar = md.f3377a;
            C3335d1.f3289a.c();
            EnumC3396h6 enumC3396h6 = C3442ka.f3360a;
            C3442ka.c.set(true);
            C3442ka.b();
            C3517pb.f().a(new int[]{2, 1, 100, 151, 150, 152}, C3442ka.g);
            C3379g3 c3379g3 = C3339d5.b;
            if (c3379g3 != null) {
                Iterator it = c3379g3.c.iterator();
                while (it.hasNext()) {
                    ((AbstractC3365f3) it.next()).a();
                }
            }
            M5 m5 = C3339d5.c;
            m5.c();
            C3517pb.f().a(new int[]{2, 1, 152, 150, 151}, m5.d);
            Ob.b("SessionStarted", new HashMap(), Sb.SDK);
            ConcurrentHashMap concurrentHashMap = Ib.f3099a;
            Ib.b();
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("Ac", "TAG");
            Intrinsics.checkNotNullExpressionValue("Ac", "TAG");
            AbstractC3498o6.a((byte) 2, "Ac", "SDK encountered unexpected error while starting internal components");
        }
    }

    @JvmStatic
    public static final void a() {
        try {
            LinkedHashMap linkedHashMap = C3578u2.f3440a;
            if (C3578u2.c.getAndSet(false)) {
                Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
                ((HandlerC3494o2) C3578u2.b.getValue()).sendEmptyMessage(5);
            }
            Ob.d.set(false);
            M3 m3 = Ob.f;
            if (m3 != null) {
                ScheduledExecutorService scheduledExecutorService = m3.h;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
                m3.h = null;
                m3.e.set(false);
                m3.f.set(true);
                m3.g.clear();
                m3.i = null;
            }
            Ob.f = null;
            Ob.i = null;
            C3517pb.f().a(Ob.h);
            C3601vb.f3460a.d();
            C3335d1 c3335d1 = C3335d1.f3289a;
            C3335d1.j.set(true);
            C3335d1.d();
            EnumC3396h6 enumC3396h6 = C3442ka.f3360a;
            C3442ka.c.set(false);
            C3517pb.f().a(C3442ka.g);
            C3442ka.b = null;
            C3379g3 c3379g3 = C3339d5.b;
            if (c3379g3 != null) {
                Iterator it = c3379g3.c.iterator();
                while (it.hasNext()) {
                    ((AbstractC3365f3) it.next()).b();
                }
            }
            M5 m5 = C3339d5.c;
            M3 m4 = m5.b;
            if (m4 != null) {
                ScheduledExecutorService scheduledExecutorService2 = m4.h;
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdownNow();
                }
                m4.h = null;
                m4.e.set(false);
                m4.f.set(true);
                m4.g.clear();
                m4.i = null;
            }
            C3517pb.f().a(m5.d);
            ConcurrentHashMap concurrentHashMap = Ib.f3099a;
            Ib.a();
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("Ac", "TAG");
            Intrinsics.checkNotNullExpressionValue("Ac", "TAG");
            AbstractC3498o6.a((byte) 1, "Ac", "SDK encountered unexpected error while stopping internal components");
        }
    }
}
