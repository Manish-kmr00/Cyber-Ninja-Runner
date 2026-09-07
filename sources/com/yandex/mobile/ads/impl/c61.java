package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
public final class c61 extends bk<u61> {
    private final c32 A;
    private final e51 B;
    private final a C;
    private final r51 D;
    private final q61 w;
    private final l61 x;
    private final w61 y;
    private final z61 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c61(Context context, uu1 sdkEnvironmentModule, q61 requestData, o3 adConfiguration, l61 nativeAdOnLoadListener, g5 adLoadingPhasesManager, CoroutineScope coroutineScope, w61 adResponseControllerFactoryCreator, z61 nativeAdResponseReportManager, c32 strongReferenceKeepingManager, e51 nativeAdCreationManager) {
        super(context, adLoadingPhasesManager, adConfiguration, coroutineScope);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(nativeAdOnLoadListener, "nativeAdOnLoadListener");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(adResponseControllerFactoryCreator, "adResponseControllerFactoryCreator");
        Intrinsics.checkNotNullParameter(nativeAdResponseReportManager, "nativeAdResponseReportManager");
        Intrinsics.checkNotNullParameter(strongReferenceKeepingManager, "strongReferenceKeepingManager");
        Intrinsics.checkNotNullParameter(nativeAdCreationManager, "nativeAdCreationManager");
        this.w = requestData;
        this.x = nativeAdOnLoadListener;
        this.y = adResponseControllerFactoryCreator;
        this.z = nativeAdResponseReportManager;
        this.A = strongReferenceKeepingManager;
        this.B = nativeAdCreationManager;
        this.C = new a();
        this.D = new r51(context, this, this);
        nativeAdOnLoadListener.a(nativeAdResponseReportManager);
    }

    @Override // com.yandex.mobile.ads.impl.bk
    protected final boolean a(v7 v7Var) {
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.bk
    public final synchronized void b(v7 v7Var) {
        throw null;
    }

    @Override // com.yandex.mobile.ads.impl.bk
    protected final zj<u61> a(String url, String query) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(query, "query");
        return this.D.a(this.w.d(), f(), this.w.a(), url, query);
    }

    public final void z() {
        v7 v7VarA = this.w.a();
        if (this.w.d().a()) {
            g5 g5VarI = i();
            f5 f5Var = f5.e;
            ak.a(g5VarI, f5Var, "adLoadingPhaseType", f5Var, null);
            this.A.b(tq0.b, this);
            f().a(Integer.valueOf(this.w.b()));
            f().a(v7VarA.a());
            f().a(this.w.c());
            f().a(v7VarA.k());
            f().a(this.w.e());
            synchronized (this) {
                c(v7VarA);
            }
            return;
        }
        b(w7.q());
    }

    public final void a(o8<u61> adResponse, o51 adFactoriesProvider) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adFactoriesProvider, "adFactoriesProvider");
        if (h()) {
            return;
        }
        this.B.a(adResponse, adResponse.I(), adFactoriesProvider, this.C);
    }

    @Override // com.yandex.mobile.ads.impl.bk
    protected final w3 x() {
        return n().c();
    }

    public final void y() {
        c();
        p().a();
        g().a();
        this.x.a();
        this.A.a(tq0.b, this);
        a(j5.b);
        this.B.a();
    }

    public final class a implements c51 {
        @Override // com.yandex.mobile.ads.impl.c51
        public final void a(w3 error) {
            Intrinsics.checkNotNullParameter(error, "error");
            c61.this.i().a(f5.e);
            c61.this.b(error);
        }

        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.c51
        public final void a(m61 nativeAd) {
            Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
            c61.this.t();
            c61.this.x.a(nativeAd);
        }

        @Override // com.yandex.mobile.ads.impl.c51
        public final void a(ArrayList nativeAds) {
            Intrinsics.checkNotNullParameter(nativeAds, "nativeAds");
            c61.this.t();
            c61.this.x.a(nativeAds);
        }

        @Override // com.yandex.mobile.ads.impl.c51
        public final void a(g81 sliderAd) {
            Intrinsics.checkNotNullParameter(sliderAd, "sliderAd");
            c61.this.t();
            c61.this.x.a(sliderAd);
        }
    }

    @Override // com.yandex.mobile.ads.impl.bk
    public final void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.x.b(error);
    }

    @Override // com.yandex.mobile.ads.impl.bk, com.yandex.mobile.ads.impl.qq1.b
    public final void a(o8<u61> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        super.a((o8) adResponse);
        this.z.a(adResponse);
        if (h()) {
            return;
        }
        h81 h81VarA = this.y.a(adResponse).a(this);
        Context contextA = p0.a();
        if (contextA != null) {
            op0.a(new Object[0]);
        }
        if (contextA == null) {
            contextA = l();
        }
        h81VarA.a(contextA, adResponse);
    }

    public final void a(st stVar) {
        this.x.a(stVar);
    }

    public final void a(yt ytVar) {
        this.x.a(ytVar);
    }

    public final void a(hu huVar) {
        this.x.a(huVar);
    }
}
