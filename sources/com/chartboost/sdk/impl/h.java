package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.Mediation;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.smaato.sdk.video.vast.model.Ad;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B}\u0012\u0006\u0010:\u001a\u000209\u0012X\u0010\u0013\u001aT\u0012F\u0012D\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u00000\u00060\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0011\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b;\u0010<J\r\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004Rf\u0010\u0013\u001aT\u0012F\u0012D\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u00000\u00060\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0015\u0010\u001fR\u0014\u0010#\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R!\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u001e\u001a\u0004\b\u0019\u0010+R\u0014\u0010/\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006="}, d2 = {"Lcom/chartboost/sdk/impl/h;", "T", "", "a", "()Ljava/lang/Object;", "Lkotlin/Function0;", "Lkotlin/Function9;", "Lcom/chartboost/sdk/impl/y;", "Lcom/chartboost/sdk/impl/g0;", "Lcom/chartboost/sdk/impl/sa;", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/chartboost/sdk/impl/o9;", "Ljava/util/concurrent/ScheduledExecutorService;", "Lcom/chartboost/sdk/impl/d;", "Lcom/chartboost/sdk/impl/s9;", "Lcom/chartboost/sdk/impl/n1;", "Lcom/chartboost/sdk/impl/m4;", "Lcom/chartboost/sdk/internal/di/ApiFactoryGet;", "Lkotlin/jvm/functions/Function0;", "get", "Lcom/chartboost/sdk/Mediation;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/Mediation;", "mediation", "Lcom/chartboost/sdk/impl/y2;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/y2;", "dependencyContainer", "Lcom/chartboost/sdk/impl/d0;", "d", "Lkotlin/Lazy;", "()Lcom/chartboost/sdk/impl/d0;", "adUnitManagerModule", "e", "Lcom/chartboost/sdk/impl/y;", "adUnitLoader", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/chartboost/sdk/impl/g0;", "adUnitRenderer", "g", "Lcom/chartboost/sdk/impl/sa;", "uiPoster", "h", "()Ljava/util/concurrent/atomic/AtomicReference;", "sdkConfig", "i", "Ljava/util/concurrent/ScheduledExecutorService;", "executor", "j", "Lcom/chartboost/sdk/impl/s9;", "session", CampaignEx.JSON_KEY_AD_K, "Lcom/chartboost/sdk/impl/n1;", "base64Wrapper", "l", "Lcom/chartboost/sdk/impl/d;", "adApiCallbackSender", "Lcom/chartboost/sdk/impl/u;", Ad.AD_TYPE, "<init>", "(Lcom/chartboost/sdk/impl/u;Lkotlin/jvm/functions/Function0;Lcom/chartboost/sdk/Mediation;Lcom/chartboost/sdk/impl/y2;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Function0<Function9<y, g0, sa, AtomicReference<o9>, ScheduledExecutorService, d, s9, n1, m4, T>> get;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Mediation mediation;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final y2 dependencyContainer;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Lazy adUnitManagerModule;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final y adUnitLoader;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final g0 adUnitRenderer;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final sa uiPoster;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final Lazy sdkConfig;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final ScheduledExecutorService executor;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final s9 session;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final n1 base64Wrapper;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final d adApiCallbackSender;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "Lcom/chartboost/sdk/impl/d0;", "a", "()Lcom/chartboost/sdk/impl/d0;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<d0> {
        public final /* synthetic */ h<T> b;
        public final /* synthetic */ u c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h<T> hVar, u uVar) {
            super(0);
            this.b = hVar;
            this.c = uVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d0 invoke() {
            return new d0(this.b.dependencyContainer.a(), this.b.dependencyContainer.d(), this.c, this.b.dependencyContainer.j(), this.b.dependencyContainer.h(), this.b.mediation, this.b.dependencyContainer.f(), this.b.dependencyContainer.m());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(u adType, Function0<? extends Function9<? super y, ? super g0, ? super sa, ? super AtomicReference<o9>, ? super ScheduledExecutorService, ? super d, ? super s9, ? super n1, ? super m4, ? extends T>> get, Mediation mediation, y2 dependencyContainer) {
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(get, "get");
        Intrinsics.checkNotNullParameter(dependencyContainer, "dependencyContainer");
        this.get = get;
        this.mediation = mediation;
        this.dependencyContainer = dependencyContainer;
        this.adUnitManagerModule = LazyKt.lazy(new a(this, adType));
        this.adUnitLoader = b().b();
        this.adUnitRenderer = b().c();
        this.uiPoster = dependencyContainer.a().e();
        this.sdkConfig = LazyKt.lazy(new b(this));
        this.executor = dependencyContainer.e().a();
        this.session = dependencyContainer.d().s();
        this.base64Wrapper = dependencyContainer.a().a();
        this.adApiCallbackSender = new e(dependencyContainer.a()).a();
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/chartboost/sdk/impl/o9;", "a", "()Ljava/util/concurrent/atomic/AtomicReference;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function0<AtomicReference<o9>> {
        public final /* synthetic */ h<T> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h<T> hVar) {
            super(0);
            this.b = hVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AtomicReference<o9> invoke() {
            return this.b.dependencyContainer.d().b();
        }
    }

    public final AtomicReference<o9> c() {
        return (AtomicReference) this.sdkConfig.getValue();
    }

    public final d0 b() {
        return (d0) this.adUnitManagerModule.getValue();
    }

    public final T a() {
        return this.get.invoke().invoke(this.adUnitLoader, this.adUnitRenderer, this.uiPoster, c(), this.executor, this.adApiCallbackSender, this.session, this.base64Wrapper, this.dependencyContainer.m().a());
    }

    public /* synthetic */ h(u uVar, Function0 function0, Mediation mediation, y2 y2Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uVar, function0, mediation, (i & 8) != 0 ? y2.b : y2Var);
    }
}
