package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
public final class o0 {
    static final /* synthetic */ KProperty<Object>[] m = {ta.a(o0.class, "activityInteractionEventListener", "getActivityInteractionEventListener()Lcom/monetization/ads/base/tracker/interaction/ActivityInteractionEventListener;", 0)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9765a;
    private final o8<?> b;
    private final j80 c;
    private final c8 d;
    private final lp1 e;
    private final q80 f;
    private final m80 g;
    private final boolean h;
    private final zn1 i;
    private a j;
    private t71 k;
    private long l;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.o0$a[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.o0$a[]) from 0x002b: INVOKE (r0v1 com.yandex.mobile.ads.impl.o0$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class a {
        c("browser"),
        d(com.ironsource.b9.h.K),
        e("custom");

        private final String b;

        static {
            EnumEntriesKt.enumEntries(aVarArr);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f.clone();
        }

        private a(String str) {
            super(str, i);
            this.b = str;
        }

        public final String a() {
            return this.b;
        }
    }

    public final void b(a type) {
        Intrinsics.checkNotNullParameter(type, "type");
        String str = "startActivityInteraction, type = " + type;
        op0.a(new Object[0]);
        this.l = System.currentTimeMillis();
        this.j = type;
        if (type == a.c && this.h) {
            Map<String, Object> mapB = a(type, null).b();
            o8<?> o8Var = this.b;
            this.g.a(new k80(this.f9765a.b(), this.l, type, this.c, mapB, o8Var != null ? o8Var.a() : null));
        }
    }

    public /* synthetic */ o0(Context context, o3 o3Var, o8 o8Var, n0 n0Var, j80 j80Var) {
        c8 c8Var = new c8();
        o3Var.q().f();
        o01 o01VarA = nd.a(context, bn2.f8524a, o3Var.q().b());
        q80 q80Var = j80Var != null ? new q80(context, o3Var, j80Var) : null;
        m80 m80VarA = m80.a.a(context);
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        this(context, o3Var, o8Var, n0Var, j80Var, c8Var, o01VarA, q80Var, m80VarA, cu1VarA != null && cu1VarA.q0());
    }

    public o0(Context context, o3 adConfiguration, o8 o8Var, n0 activityInteractionEventListener, j80 j80Var, c8 adRequestReportDataProvider, lp1 metricaReporter, q80 q80Var, m80 falseClickDataStorage, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(activityInteractionEventListener, "activityInteractionEventListener");
        Intrinsics.checkNotNullParameter(adRequestReportDataProvider, "adRequestReportDataProvider");
        Intrinsics.checkNotNullParameter(metricaReporter, "metricaReporter");
        Intrinsics.checkNotNullParameter(falseClickDataStorage, "falseClickDataStorage");
        this.f9765a = adConfiguration;
        this.b = o8Var;
        this.c = j80Var;
        this.d = adRequestReportDataProvider;
        this.e = metricaReporter;
        this.f = q80Var;
        this.g = falseClickDataStorage;
        this.h = z;
        this.i = ao1.a(activityInteractionEventListener);
    }

    private final hp1 a(a aVar, String str) {
        ip1 ip1VarA = this.d.a(this.f9765a.a());
        ip1VarA.b(aVar.a(), "type");
        ip1VarA.b(this.f9765a.b().a(), "ad_type");
        ip1VarA.b(this.f9765a.c(), "block_id");
        ip1VarA.b(this.f9765a.c(), "ad_unit_id");
        ip1VarA.b(str, "interval");
        t71 t71Var = this.k;
        if (t71Var != null) {
            ip1VarA = jp1.a(ip1VarA, t71Var.a());
        }
        hp1.b reportType = hp1.b.M;
        Map<String, Object> reportData = ip1VarA.b();
        o8<?> o8Var = this.b;
        f fVarA = o8Var != null ? o8Var.a() : null;
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        return new hp1(reportType.a(), (Map<String, Object>) MapsKt.toMutableMap(reportData), fVarA);
    }

    public final void a(a type) {
        Intrinsics.checkNotNullParameter(type, "type");
        String str = "finishActivityInteraction, type = " + type;
        op0.a(new Object[0]);
        if (this.l == 0 || this.j != type) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.l;
        String interval = cq0.a(jCurrentTimeMillis);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(interval, "interval");
        this.e.a(a(type, interval));
        op0.d(type.a(), interval);
        n0 n0Var = (n0) this.i.getValue(this, m[0]);
        if (n0Var != null) {
            n0Var.onReturnedToApplication();
        }
        q80 q80Var = this.f;
        if (q80Var != null) {
            q80Var.a(jCurrentTimeMillis);
            if (this.h) {
                this.g.a(this.l);
            }
        }
        this.l = 0L;
        this.j = null;
    }

    public final void a(t71 t71Var) {
        this.k = t71Var;
    }
}
