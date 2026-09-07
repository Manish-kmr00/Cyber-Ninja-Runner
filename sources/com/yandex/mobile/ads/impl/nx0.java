package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import com.monetization.ads.mediation.base.MediatedAdapterInfo;
import com.monetization.ads.mediation.base.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class nx0<T extends com.monetization.ads.mediation.base.a, L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9763a;
    private final g5 b;
    private final ux0<T, L> c;
    private final cy0 d;
    private final ox0<T> e;
    private final eg1 f;
    private final zx0 g;
    private mx0<T> h;

    public final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        mx0<T> mx0Var = this.h;
        if (mx0Var != null) {
            Map<String, ? extends Object> mapMapOf = MapsKt.mapOf(TuplesKt.to("status", "success"));
            this.d.f(context, mx0Var.c(), mapMapOf, mx0Var.a().b().getNetworkName());
        }
    }

    public final void c(Context context, Map<String, ? extends Object> mediatedReportData) {
        hz0 hz0VarC;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediatedReportData, "mediatedReportData");
        mx0<T> mx0Var = this.h;
        List<String> listD = (mx0Var == null || (hz0VarC = mx0Var.c()) == null) ? null : hz0VarC.d();
        v9 v9Var = new v9(context, this.f9763a);
        if (listD != null) {
            Iterator<T> it = listD.iterator();
            while (it.hasNext()) {
                v9Var.a((String) it.next(), s62.g);
            }
        }
        Map<String, ? extends Object> mutableMap = MapsKt.toMutableMap(mediatedReportData);
        mutableMap.put("status", "success");
        mx0<T> mx0Var2 = this.h;
        if (mx0Var2 != null) {
            px0 px0VarA = mx0Var2.a();
            this.g.getClass();
            mutableMap.putAll(zx0.a(px0VarA));
            this.d.g(context, mx0Var2.c(), mutableMap, mx0Var2.a().b().getNetworkName());
        }
    }

    public final void d(Context context, Map<String, ? extends Object> additionalReportData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(additionalReportData, "additionalReportData");
        mx0<T> mx0Var = this.h;
        if (mx0Var != null) {
            this.d.e(context, mx0Var.c(), additionalReportData, mx0Var.a().b().getNetworkName());
        }
    }

    public final void e(Context context, Map<String, ? extends Object> additionalReportData) {
        px0 px0VarA;
        MediatedAdapterInfo mediatedAdapterInfoB;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(additionalReportData, "additionalReportData");
        mx0<T> mx0Var = this.h;
        String networkName = null;
        hz0 hz0VarC = mx0Var != null ? mx0Var.c() : null;
        if (hz0VarC != null) {
            cy0 cy0Var = this.d;
            mx0<T> mx0Var2 = this.h;
            if (mx0Var2 != null && (px0VarA = mx0Var2.a()) != null && (mediatedAdapterInfoB = px0VarA.b()) != null) {
                networkName = mediatedAdapterInfoB.getNetworkName();
            }
            cy0Var.b(context, hz0VarC, additionalReportData, networkName);
        }
    }

    public /* synthetic */ nx0(o3 o3Var, g5 g5Var, ux0 ux0Var, cy0 cy0Var, ox0 ox0Var, eg1 eg1Var) {
        this(o3Var, g5Var, ux0Var, cy0Var, ox0Var, eg1Var, new zx0());
    }

    public nx0(o3 adConfiguration, g5 adLoadingPhasesManager, ux0<T, L> mediatedAdLoader, cy0 mediatedAdapterReporter, ox0<T> mediatedAdCreator, eg1 passbackAdLoader, zx0 mediatedAdapterInfoReportDataProvider) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(mediatedAdLoader, "mediatedAdLoader");
        Intrinsics.checkNotNullParameter(mediatedAdapterReporter, "mediatedAdapterReporter");
        Intrinsics.checkNotNullParameter(mediatedAdCreator, "mediatedAdCreator");
        Intrinsics.checkNotNullParameter(passbackAdLoader, "passbackAdLoader");
        Intrinsics.checkNotNullParameter(mediatedAdapterInfoReportDataProvider, "mediatedAdapterInfoReportDataProvider");
        this.f9763a = adConfiguration;
        this.b = adLoadingPhasesManager;
        this.c = mediatedAdLoader;
        this.d = mediatedAdapterReporter;
        this.e = mediatedAdCreator;
        this.f = passbackAdLoader;
        this.g = mediatedAdapterInfoReportDataProvider;
    }

    public final mx0<T> a() {
        return this.h;
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        mx0<T> mx0Var = this.h;
        if (mx0Var != null) {
            try {
                this.c.a(mx0Var.b());
            } catch (Throwable th) {
                hz0 hz0VarC = mx0Var.c();
                String networkName = mx0Var.a().b().getNetworkName();
                op0.c(new Object[0]);
                this.d.a(context, hz0VarC, MapsKt.mapOf(TuplesKt.to("reason", MapsKt.mapOf(TuplesKt.to("exception_in_adapter", th.toString())))), networkName);
            }
        }
    }

    public final void a(Context context, L l) {
        hz0 hz0VarC;
        Intrinsics.checkNotNullParameter(context, "context");
        mx0<T> mx0VarA = this.e.a(context);
        this.h = mx0VarA;
        if (mx0VarA != null) {
            this.f9763a.a(mx0VarA.c());
            this.f9763a.c(mx0VarA.a().b().getNetworkName());
            g5 g5Var = this.b;
            f5 f5Var = f5.c;
            ak.a(g5Var, f5Var, "adLoadingPhaseType", f5Var, null);
            hz0 hz0VarC2 = mx0VarA.c();
            String networkName = mx0VarA.a().b().getNetworkName();
            this.d.b(context, hz0VarC2, networkName);
            try {
                this.c.a(context, mx0VarA.b(), l, mx0VarA.a(context), mx0VarA.d());
                return;
            } catch (Throwable th) {
                op0.c(new Object[0]);
                this.d.a(context, hz0VarC2, MapsKt.mapOf(TuplesKt.to("reason", MapsKt.mapOf(TuplesKt.to("exception_in_adapter", th.toString())))), networkName);
                mx0<T> mx0Var = this.h;
                xa parametersProvider = new xa(hp1.c.d, (mx0Var == null || (hz0VarC = mx0Var.c()) == null) ? null : hz0VarC.e());
                g5 g5Var2 = this.b;
                f5 adLoadingPhaseType = f5.c;
                g5Var2.getClass();
                Intrinsics.checkNotNullParameter(adLoadingPhaseType, "adLoadingPhaseType");
                Intrinsics.checkNotNullParameter(parametersProvider, "parametersProvider");
                g5Var2.a(adLoadingPhaseType, parametersProvider, null);
                a(context, l);
                return;
            }
        }
        this.f.a();
    }

    public final void b(Context context, w3 adFetchRequestError, L l) {
        hz0 hz0VarC;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adFetchRequestError, "adFetchRequestError");
        mx0<T> mx0Var = this.h;
        xa parametersProvider = new xa(hp1.c.d, (mx0Var == null || (hz0VarC = mx0Var.c()) == null) ? null : hz0VarC.e());
        g5 g5Var = this.b;
        f5 adLoadingPhaseType = f5.c;
        g5Var.getClass();
        Intrinsics.checkNotNullParameter(adLoadingPhaseType, "adLoadingPhaseType");
        Intrinsics.checkNotNullParameter(parametersProvider, "parametersProvider");
        g5Var.a(adLoadingPhaseType, parametersProvider, null);
        Map<String, ? extends Object> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("status", "error"), TuplesKt.to("error_code", Integer.valueOf(adFetchRequestError.b())), TuplesKt.to(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION, adFetchRequestError.c()));
        mx0<T> mx0Var2 = this.h;
        if (mx0Var2 != null) {
            px0 px0VarA = mx0Var2.a();
            this.g.getClass();
            mapMutableMapOf.putAll(zx0.a(px0VarA));
            this.d.g(context, mx0Var2.c(), mapMutableMapOf, mx0Var2.a().b().getNetworkName());
        }
        a(context);
        a(context, l);
    }

    public final void b(Context context, Map<String, ? extends Object> additionalReportData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(additionalReportData, "additionalReportData");
        mx0<T> mx0Var = this.h;
        if (mx0Var != null) {
            hz0 hz0VarC = mx0Var.c();
            String networkName = mx0Var.a().b().getNetworkName();
            List<String> listH = hz0VarC.h();
            if (listH != null) {
                Iterator<String> it = listH.iterator();
                while (it.hasNext()) {
                    new v9(context, this.f9763a).a(it.next(), s62.f);
                }
            }
            this.d.d(context, hz0VarC, additionalReportData, networkName);
        }
    }

    public final void c(Context context) {
        px0 px0VarA;
        MediatedAdapterInfo mediatedAdapterInfoB;
        Intrinsics.checkNotNullParameter(context, "context");
        mx0<T> mx0Var = this.h;
        String networkName = null;
        hz0 hz0VarC = mx0Var != null ? mx0Var.c() : null;
        if (hz0VarC != null) {
            cy0 cy0Var = this.d;
            mx0<T> mx0Var2 = this.h;
            if (mx0Var2 != null && (px0VarA = mx0Var2.a()) != null && (mediatedAdapterInfoB = px0VarA.b()) != null) {
                networkName = mediatedAdapterInfoB.getNetworkName();
            }
            cy0Var.a(context, hz0VarC, networkName);
        }
    }

    public final void a(Context context, Map<String, ? extends Object> additionalReportData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(additionalReportData, "additionalReportData");
        mx0<T> mx0Var = this.h;
        if (mx0Var != null) {
            hz0 hz0VarC = mx0Var.c();
            String networkName = mx0Var.a().b().getNetworkName();
            List<String> listG = hz0VarC.g();
            if (listG != null) {
                Iterator<String> it = listG.iterator();
                while (it.hasNext()) {
                    new v9(context, this.f9763a).a(it.next(), s62.d);
                }
            }
            Map<String, ? extends Object> mutableMap = MapsKt.toMutableMap(additionalReportData);
            mutableMap.put("click_type", "default");
            this.d.c(context, hz0VarC, mutableMap, networkName);
        }
    }

    public final void a(Context context, w3 adFetchRequestError, L l) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adFetchRequestError, "adFetchRequestError");
        mx0<T> mx0Var = this.h;
        if (mx0Var != null) {
            this.d.f(context, mx0Var.c(), MapsKt.mapOf(TuplesKt.to("status", "error"), TuplesKt.to("error_code", Integer.valueOf(adFetchRequestError.b()))), mx0Var.a().b().getNetworkName());
        }
        a(context);
        a(context, l);
    }

    public final void a(Context context, o8<String> o8Var) {
        px0 px0VarA;
        MediatedAdapterInfo mediatedAdapterInfoB;
        Intrinsics.checkNotNullParameter(context, "context");
        mx0<T> mx0Var = this.h;
        String networkName = null;
        hz0 hz0VarC = mx0Var != null ? mx0Var.c() : null;
        if (hz0VarC != null) {
            cy0 cy0Var = this.d;
            mx0<T> mx0Var2 = this.h;
            if (mx0Var2 != null && (px0VarA = mx0Var2.a()) != null && (mediatedAdapterInfoB = px0VarA.b()) != null) {
                networkName = mediatedAdapterInfoB.getNetworkName();
            }
            cy0Var.a(context, hz0VarC, o8Var, networkName);
        }
    }

    public final boolean b() {
        px0 px0VarA;
        mx0<T> mx0Var = this.h;
        if (mx0Var == null || (px0VarA = mx0Var.a()) == null) {
            return true;
        }
        return px0VarA.c();
    }
}
