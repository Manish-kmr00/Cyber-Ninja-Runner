package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes9.dex */
public final class v91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f10464a;
    private final u91 b;
    private final e51 c;

    public interface b {
        void a(m61 m61Var);

        void a(w3 w3Var);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ v91(Context context, uu1 uu1Var, o3 o3Var, g5 g5Var) {
        CoroutineScope coroutineScopeA = pu.a();
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, uu1Var, o3Var, g5Var, coroutineScopeA, applicationContext, new u91(context, uu1Var.c()), new e51(applicationContext, uu1Var, o3Var, g5Var, coroutineScopeA));
    }

    public v91(Context context, uu1 sdkEnvironmentModule, o3 adConfiguration, g5 adLoadingPhasesManager, CoroutineScope coroutineScope, Context appContext, u91 nativeResponseConverter, e51 nativeAdCreationManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(nativeResponseConverter, "nativeResponseConverter");
        Intrinsics.checkNotNullParameter(nativeAdCreationManager, "nativeAdCreationManager");
        this.f10464a = sdkEnvironmentModule;
        this.b = nativeResponseConverter;
        this.c = nativeAdCreationManager;
        adConfiguration.a(y91.c);
    }

    public final void a(o8<String> adResponse, b responseCreationListener, wq1 converterListener) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(responseCreationListener, "responseCreationListener");
        Intrinsics.checkNotNullParameter(converterListener, "converterListener");
        this.b.a(adResponse, new a(this, adResponse, responseCreationListener, converterListener, new zv1(this.f10464a)));
    }

    private final class a implements wq1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final o8<String> f10465a;
        private final b b;
        private final wq1 c;
        private final zv1 d;
        final /* synthetic */ v91 e;

        public a(v91 v91Var, o8<String> adResponse, b responseCreationListener, wq1 responseConverterListener, zv1 sdkNativeAdFactoriesProviderCreator) {
            Intrinsics.checkNotNullParameter(adResponse, "adResponse");
            Intrinsics.checkNotNullParameter(responseCreationListener, "responseCreationListener");
            Intrinsics.checkNotNullParameter(responseConverterListener, "responseConverterListener");
            Intrinsics.checkNotNullParameter(sdkNativeAdFactoriesProviderCreator, "sdkNativeAdFactoriesProviderCreator");
            this.e = v91Var;
            this.f10465a = adResponse;
            this.b = responseCreationListener;
            this.c = responseConverterListener;
            this.d = sdkNativeAdFactoriesProviderCreator;
        }

        @Override // com.yandex.mobile.ads.impl.wq1
        public final void a(w3 adRequestError) {
            Intrinsics.checkNotNullParameter(adRequestError, "adRequestError");
            this.c.a(adRequestError);
            this.b.a(adRequestError);
        }

        @Override // com.yandex.mobile.ads.impl.wq1
        public final void a(u61 nativeAdResponse) {
            Intrinsics.checkNotNullParameter(nativeAdResponse, "nativeAdResponse");
            this.c.a(nativeAdResponse);
            o8<String> o8Var = this.f10465a;
            b bVar = this.b;
            this.e.c.a(o8Var, nativeAdResponse, this.d.a(o8Var), new j81(bVar));
        }
    }

    public final void a() {
        this.c.a();
    }
}
