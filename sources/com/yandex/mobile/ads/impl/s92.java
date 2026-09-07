package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class s92 implements wp1<r92> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z92 f10187a;
    private final g5 b;
    private final wp1<r92> c;
    private final qd2 d;

    public s92(Context context, o3 adConfiguration, z92 vastRequestConfiguration, aa2 requestConfigurationParametersProvider, g5 adLoadingPhasesManager, p92 reportParametersProvider, wp1 requestListener, qd2 responseHandler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(vastRequestConfiguration, "vastRequestConfiguration");
        Intrinsics.checkNotNullParameter(requestConfigurationParametersProvider, "requestConfigurationParametersProvider");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(reportParametersProvider, "reportParametersProvider");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        Intrinsics.checkNotNullParameter(responseHandler, "responseHandler");
        this.f10187a = vastRequestConfiguration;
        this.b = adLoadingPhasesManager;
        this.c = requestListener;
        this.d = responseHandler;
    }

    public static final void a(s92 s92Var, kb2 kb2Var) {
        s92Var.getClass();
        s92Var.b.a(f5.v, new x92("error", kb2Var), s92Var.f10187a);
    }

    public static final void a(s92 s92Var) {
        s92Var.getClass();
        s92Var.b.a(f5.v, new x92("success", null), s92Var.f10187a);
    }

    @Override // com.yandex.mobile.ads.impl.wp1
    public final void a(kb2 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.b.a(f5.v, new x92("error", error), this.f10187a);
        this.c.a(error);
    }

    @Override // com.yandex.mobile.ads.impl.wp1
    public final void a(r92 r92Var) {
        r92 result = r92Var;
        Intrinsics.checkNotNullParameter(result, "result");
        this.d.a(result.b().b(), new a(this, result, this.c));
    }

    public final class a implements wp1<List<? extends eb2>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r92 f10188a;
        private final wp1<r92> b;
        final /* synthetic */ s92 c;

        public a(s92 s92Var, r92 vastData, wp1<r92> requestListener) {
            Intrinsics.checkNotNullParameter(vastData, "vastData");
            Intrinsics.checkNotNullParameter(requestListener, "requestListener");
            this.c = s92Var;
            this.f10188a = vastData;
            this.b = requestListener;
        }

        @Override // com.yandex.mobile.ads.impl.wp1
        public final void a(kb2 error) {
            Intrinsics.checkNotNullParameter(error, "error");
            s92.a(this.c, error);
            this.b.a(error);
        }

        @Override // com.yandex.mobile.ads.impl.wp1
        public final void a(List<? extends eb2> list) {
            List<? extends eb2> result = list;
            Intrinsics.checkNotNullParameter(result, "result");
            s92.a(this.c);
            this.b.a(new r92(new m92(this.f10188a.b().a(), result), this.f10188a.a()));
        }
    }
}
