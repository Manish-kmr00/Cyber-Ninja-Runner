package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class b62<R, T> extends pk<T> {
    private final id A;
    private final e8 B;
    private final R x;
    private final eq1<R, T> y;
    private final lp1 z;

    @Override // com.yandex.mobile.ads.impl.np1
    public final qq1<T> a(tc1 networkResponse) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        int i = networkResponse.f10286a;
        qq1<T> qq1VarA = a(networkResponse, i);
        hp1 hp1VarA = this.y.a(qq1VarA, i, this.x);
        ip1 ip1Var = new ip1(hp1VarA.b(), 2);
        ip1Var.a(kf0.a(networkResponse.c, sh0.y), "server_log_id");
        Map<String, String> map = networkResponse.c;
        if (map != null) {
            ip1Var.a(p8.a(map));
        }
        this.z.a(hp1VarA);
        return qq1VarA;
    }

    protected abstract qq1<T> a(tc1 tc1Var, int i);

    @Override // com.yandex.mobile.ads.impl.pk, com.yandex.mobile.ads.impl.np1
    public ki2 b(ki2 requestError) {
        Intrinsics.checkNotNullParameter(requestError, "requestError");
        tc1 tc1Var = requestError.b;
        this.z.a(this.y.a(null, tc1Var != null ? tc1Var.f10286a : -1, this.x));
        return super.b(requestError);
    }

    public /* synthetic */ b62(Context context, o3 o3Var, int i, String str, pk.a aVar, Object obj, eq1 eq1Var, xp1 xp1Var, int i2) {
        this(context, o3Var, i, str, aVar, obj, eq1Var, (i2 & 128) != 0 ? null : xp1Var, o3Var.q().c(), new id(context), new e8());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b62(Context context, o3 adConfiguration, int i, String url, pk.a<T> listener, R r, eq1<R, T> requestReporter, xp1 xp1Var, lp1 metricaReporter, id metricaLibraryEventReporter, e8 adRequestRetryPolicyCreator) {
        super(context, i, url, listener, xp1Var);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(requestReporter, "requestReporter");
        Intrinsics.checkNotNullParameter(metricaReporter, "metricaReporter");
        Intrinsics.checkNotNullParameter(metricaLibraryEventReporter, "metricaLibraryEventReporter");
        Intrinsics.checkNotNullParameter(adRequestRetryPolicyCreator, "adRequestRetryPolicyCreator");
        this.x = r;
        this.y = requestReporter;
        this.z = metricaReporter;
        this.A = metricaLibraryEventReporter;
        this.B = adRequestRetryPolicyCreator;
        a(context);
        r();
        s();
        y();
    }

    private final void a(Context context) {
        Integer numR;
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        a(this.B.a(context, (cu1VarA == null || (numR = cu1VarA.R()) == null) ? yh0.a() : numR.intValue()));
    }

    private final void y() {
        hp1 hp1VarA = this.y.a(this.x);
        this.z.a(hp1VarA);
        String strC = hp1VarA.c();
        hp1.b bVar = hp1.b.k;
        if (Intrinsics.areEqual(strC, bVar.a())) {
            this.A.a(bVar, hp1VarA.b(), null, null);
        }
    }
}
