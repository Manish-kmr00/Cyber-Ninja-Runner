package com.ogury.ad.internal;

import android.content.Context;
import com.ogury.core.internal.network.NetworkClient;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class g implements d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x5 f7299a;
    public final v4 b;
    public final z3 c;
    public final d4 d;
    public boolean e;
    public c f;
    public c2 g;

    public g(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        if (x5.c == null) {
            int millis = (int) TimeUnit.SECONDS.toMillis(t7.b.b.f7468a);
            Context context2 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getApplicationContext(...)");
            Intrinsics.checkNotNullParameter(context2, "context");
            Context applicationContext = context2.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            x5.c = new x5(new m2(applicationContext), new NetworkClient(millis, millis * 5));
        }
        x5 oguryApi = x5.c;
        Intrinsics.checkNotNull(oguryApi);
        v4 mraidEventBus = v4.f7421a;
        z3 measurementsEventLogger = z3.f7460a;
        d4.a aVar = d4.e;
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        d4 monitoringEventLogger = aVar.a(applicationContext2);
        Intrinsics.checkNotNullParameter(oguryApi, "oguryApi");
        Intrinsics.checkNotNullParameter(mraidEventBus, "mraidEventBus");
        Intrinsics.checkNotNullParameter(measurementsEventLogger, "measurementsEventLogger");
        Intrinsics.checkNotNullParameter(monitoringEventLogger, "monitoringEventLogger");
        this.f7299a = oguryApi;
        this.b = mraidEventBus;
        this.c = measurementsEventLogger;
        this.d = monitoringEventLogger;
    }

    @Override // com.ogury.ad.internal.d2
    public final void a(float f) {
        Object obj;
        Object obj2;
        Object obj3;
        c cVar = this.f;
        if (cVar == null || this.e || f < 50.0f) {
            return;
        }
        this.e = true;
        u3 u3Var = u3.f7411a;
        String str = "new impression: " + cVar.e();
        u3Var.getClass();
        c2 c2Var = this.g;
        if (c2Var != null) {
            c2Var.a(null);
        }
        d4 d4Var = this.d;
        o7 o7Var = o7.SI_004_SDK_EVENT_AD_CONTAINER_DISPLAYED;
        Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(cVar.H));
        Pair pair2 = TuplesKt.to("impression_source", p2.a(cVar.z.b));
        Pair pair3 = TuplesKt.to("exposure", Float.valueOf(f));
        r3 r3Var = cVar.A.f7388a;
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
        Pair pair4 = TuplesKt.to("loaded_source", obj);
        Pair pair5 = TuplesKt.to("reload", Boolean.valueOf(cVar.J));
        int i = cVar.K;
        d4Var.a(o7Var, cVar, p7.a(pair, pair2, pair3, pair4, pair5, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)));
        if (cVar.e.length() > 0) {
            this.f7299a.a(cVar.e);
        } else {
            z3 z3Var = this.c;
            h9 h9Var = new h9("shown", cVar);
            z3Var.getClass();
            z3.a(h9Var);
        }
        v4 v4Var = this.b;
        u4 u4Var = new u4(cVar.b, "adDisplayed");
        v4Var.getClass();
        v4.a(u4Var);
        if (cVar.z.b == o2.IMPRESSION_SOURCE_SDK) {
            d4 d4Var2 = this.d;
            o7 o7Var2 = o7.SI_006_SDK_EVENT_AD_DISPLAYED;
            Pair pair6 = TuplesKt.to("from_ad_markup", Boolean.valueOf(cVar.H));
            Pair pair7 = TuplesKt.to("impression_source", p2.a(cVar.z.b));
            Pair pair8 = TuplesKt.to("is_paid", Boolean.valueOf(cVar.z.f7362a));
            r3 r3Var2 = cVar.A.f7388a;
            Intrinsics.checkNotNullParameter(r3Var2, "<this>");
            int iOrdinal2 = r3Var2.ordinal();
            if (iOrdinal2 == 0) {
                obj2 = r14;
            } else {
                if (iOrdinal2 != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                obj2 = "sdk";
            }
            Pair pair9 = TuplesKt.to("loaded_source", obj2);
            Pair pair10 = TuplesKt.to("reload", Boolean.valueOf(cVar.J));
            int i2 = cVar.K;
            d4Var2.a(o7Var2, cVar, p7.a(pair6, pair7, pair8, pair9, pair10, TuplesKt.to("webview_termination", i2 > 0 ? Integer.valueOf(i2) : null)));
            if (cVar.z.f7362a) {
                d4 d4Var3 = this.d;
                o7 o7Var3 = o7.SI_007_SDK_EVENT_AD_IMPRESSION;
                Pair pair11 = TuplesKt.to("from_ad_markup", Boolean.valueOf(cVar.H));
                Pair pair12 = TuplesKt.to("impression_source", p2.a(cVar.z.b));
                r3 r3Var3 = cVar.A.f7388a;
                Intrinsics.checkNotNullParameter(r3Var3, "<this>");
                int iOrdinal3 = r3Var3.ordinal();
                if (iOrdinal3 == 0) {
                    obj3 = "format";
                } else {
                    if (iOrdinal3 != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    obj3 = "sdk";
                }
                Pair pair13 = TuplesKt.to("loaded_source", obj3);
                Pair pair14 = TuplesKt.to("reload", Boolean.valueOf(cVar.J));
                int i3 = cVar.K;
                d4Var3.a(o7Var3, cVar, p7.a(pair11, pair12, pair13, pair14, TuplesKt.to("webview_termination", i3 > 0 ? Integer.valueOf(i3) : null)));
                v4 v4Var2 = this.b;
                u4 u4Var2 = new u4(cVar.b, "adImpression");
                v4Var2.getClass();
                v4.a(u4Var2);
            }
        }
    }
}
