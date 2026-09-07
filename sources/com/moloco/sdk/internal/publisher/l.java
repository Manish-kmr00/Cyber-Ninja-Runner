package com.moloco.sdk.internal.publisher;

import android.content.Context;
import com.moloco.sdk.publisher.Banner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes11.dex */
public final class l {

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function8<Context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a, com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t, com.moloco.sdk.internal.a0, com.moloco.sdk.internal.services.s, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6199a = new a();

        public a() {
            super(8, l.class, "createXenossAggregatedBanner", "createXenossAggregatedBanner(Landroid/content/Context;Lcom/moloco/sdk/xenoss/sdkdevkit/android/core/services/CustomUserEventBuilderService;Lcom/moloco/sdk/internal/ortb/model/Bid;Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/ExternalLinkHandler;Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/Watermark;Lcom/moloco/sdk/internal/ViewLifecycleOwner;Lcom/moloco/sdk/internal/services/ClickthroughService;Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/ui/ButtonTracker;)Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/XenossBannerView;", 1);
        }

        @Override // kotlin.jvm.functions.Function8
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> invoke(Context p0, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a p1, com.moloco.sdk.internal.ortb.model.c p2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m p3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t p4, com.moloco.sdk.internal.a0 p5, com.moloco.sdk.internal.services.s p6, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h p7) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            Intrinsics.checkNotNullParameter(p2, "p2");
            Intrinsics.checkNotNullParameter(p3, "p3");
            Intrinsics.checkNotNullParameter(p4, "p4");
            Intrinsics.checkNotNullParameter(p5, "p5");
            Intrinsics.checkNotNullParameter(p6, "p6");
            Intrinsics.checkNotNullParameter(p7, "p7");
            return l.b(p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r, c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6200a = new b();

        public b() {
            super(1, l.class, "createXenossAggregatedAdShowListener", "createXenossAggregatedAdShowListener(Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/VastAdShowListener;)Lcom/moloco/sdk/internal/publisher/BannerKt$createXenossAggregatedAdShowListener$1;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return l.b(p0);
        }
    }

    public static final class c implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r f6201a;

        public c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r rVar) {
            this.f6201a = rVar;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d
        public void a() {
            this.f6201a.a();
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d
        public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalShowError) {
            Intrinsics.checkNotNullParameter(internalShowError, "internalShowError");
            this.f6201a.a(internalShowError);
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r
        public void a(boolean z) {
            this.f6201a.a(z);
        }
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> b(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, com.moloco.sdk.internal.ortb.model.c cVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t tVar, com.moloco.sdk.internal.a0 a0Var, com.moloco.sdk.internal.services.s sVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h hVar) {
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b(context, aVar, null, cVar, a(cVar.e().e()), mVar, tVar, a0Var, CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), sVar, hVar);
    }

    public static final Banner a(Context context, com.moloco.sdk.internal.services.f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, String adUnitId, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t watermark, com.moloco.sdk.internal.publisher.a adCreateLoadTimeoutManager, com.moloco.sdk.internal.a0 viewLifecycleOwnerSingleton, com.moloco.sdk.internal.i bannerSize, com.moloco.sdk.internal.services.s clickthroughService) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        Intrinsics.checkNotNullParameter(viewLifecycleOwnerSingleton, "viewLifecycleOwnerSingleton");
        Intrinsics.checkNotNullParameter(bannerSize, "bannerSize");
        Intrinsics.checkNotNullParameter(clickthroughService, "clickthroughService");
        return new m(context, appLifecycleTrackerService, customUserEventBuilderService, adUnitId, z, externalLinkHandler, a.f6199a, b.f6200a, watermark, adCreateLoadTimeoutManager, viewLifecycleOwnerSingleton, bannerSize, clickthroughService);
    }

    public static final c b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r rVar) {
        return new c(rVar);
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g a(com.moloco.sdk.internal.ortb.model.o oVar) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g gVarA;
        return (oVar == null || (gVarA = com.moloco.sdk.internal.d.a(oVar)) == null) ? com.moloco.sdk.internal.d.a() : gVarA;
    }
}
