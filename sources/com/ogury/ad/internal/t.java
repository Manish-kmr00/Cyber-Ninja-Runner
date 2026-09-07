package com.ogury.ad.internal;

import com.ogury.ad.OguryAdError;
import com.ogury.core.internal.IntegrationLogger;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f7402a;
    public int b;
    public boolean c = true;
    public boolean d = true;
    public boolean e = true;
    public final ArrayList f = new ArrayList();
    public int g;
    public boolean h;

    public final void a(x.c cVar) {
        this.f7402a = cVar;
    }

    public final void b(o oVar, d dVar, s sVar) {
        if (this.c) {
            this.c = false;
            IntegrationLogger.d("[Ads][" + oVar.b() + "][show][" + (dVar != null ? dVar.a() : null) + "] Ad successfully shown!");
            a(sVar, oVar.b(), dVar != null ? dVar.a() : null);
        }
    }

    public final void c(o oVar, d dVar, s sVar) {
        if (this.e) {
            if (this.g == this.b || this.h) {
                this.e = false;
                IntegrationLogger.d("[Ads][" + oVar.b() + "][show][" + (dVar != null ? dVar.a() : null) + "] Ad closed");
                IntegrationLogger.d("[Ads][" + oVar.b() + "][show][" + (dVar != null ? dVar.a() : null) + "] Triggering onAdClosed() callback");
                a(sVar, oVar.b(), dVar != null ? dVar.a() : null);
                if (sVar != null) {
                    sVar.c();
                }
                Function0<Unit> function0 = this.f7402a;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void a(o oVar, d dVar, String str, s sVar) {
        if (this.f.contains(str)) {
            return;
        }
        this.f.add(str);
        IntegrationLogger.d("[Ads][" + oVar.b() + "][show][" + (dVar != null ? dVar.a() : null) + "] Impression");
        IntegrationLogger.d("[Ads][" + oVar.b() + "][show][" + (dVar != null ? dVar.a() : null) + "] Triggering onAdImpression() callback");
        a(sVar, oVar.b(), dVar != null ? dVar.a() : null);
        if (sVar != null) {
            sVar.f();
        }
    }

    public final void a(o oVar, d dVar, s sVar) {
        if (this.d) {
            this.d = false;
            IntegrationLogger.d("[Ads][" + oVar.b() + "][show][" + (dVar != null ? dVar.a() : null) + "] Ad clicked");
            IntegrationLogger.d("[Ads][" + oVar.b() + "][show][" + (dVar != null ? dVar.a() : null) + "] Triggering onAdClicked() callback");
            a(sVar, oVar.b(), dVar != null ? dVar.a() : null);
            if (sVar != null) {
                sVar.d();
            }
        }
    }

    public static void a(a5 a5Var, o oVar, d dVar, Function1 function1) {
        IntegrationLogger.d("[Ads][" + oVar.b() + "][show][" + (dVar != null ? dVar.a() : null) + "] Reward: " + a5Var.a().b() + " " + a5Var.a().a());
        IntegrationLogger.d("[Ads][" + oVar.b() + "][show][" + (dVar != null ? dVar.a() : null) + "] Triggering onAdRewarded() callback");
        a(function1, oVar.b(), dVar != null ? dVar.a() : null);
        if (function1 != null) {
            function1.invoke(a5Var.a());
        }
    }

    public static void a(t4 t4Var, o oVar, d dVar, s sVar) {
        IntegrationLogger.e("[Ads][" + oVar.b() + "][show][" + (dVar != null ? dVar.a() : null) + "]* Failed to show (error code: " + t4Var.a() + ")");
        IntegrationLogger.d("[Ads][" + oVar.b() + "][show][" + (dVar != null ? dVar.a() : null) + "] Triggering onAdError() callback");
        a(sVar, oVar.b(), dVar != null ? dVar.a() : null);
        if (sVar != null) {
            sVar.a(new OguryAdError(OguryAdError.Type.SHOW_ERROR, t4Var.a(), "No ad has been loaded."));
        }
    }

    public static void a(s sVar, String str, String str2) {
        if (sVar == null) {
            IntegrationLogger.d("[Ads][" + str + "][show][" + str2 + "] No ad listener registered");
        }
    }

    public static void a(Function1 function1, String str, String str2) {
        if (function1 == null) {
            IntegrationLogger.d("[Ads][" + str + "][show][" + str2 + "] No ad listener registered");
        }
    }
}
