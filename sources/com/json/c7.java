package com.json;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.environment.ContextProvider;
import com.json.mediationsdk.AdapterUtils;
import com.json.mediationsdk.d;
import com.json.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.ironsourceads.AdSize;
import com.unity3d.ironsourceads.banner.BannerAdRequest;
import com.unity3d.ironsourceads.banner.BannerAdView;
import io.ktor.http.ContentDisposition;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002Ba\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020)0(\u0012\u0006\u00100\u001a\u00020-\u0012\b\b\u0002\u00104\u001a\u000201\u0012\b\b\u0002\u00108\u001a\u000205¢\u0006\u0004\bI\u0010JJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006K"}, d2 = {"Lcom/ironsource/c7;", "Lcom/ironsource/bm;", "Lcom/ironsource/a6;", "", "start", "Lcom/ironsource/rj;", b9.h.p0, "Lcom/ironsource/vg;", "adContainer", "onBannerLoadSuccess", "", "description", "onBannerLoadFail", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "a", "(Lcom/ironsource/mediationsdk/logger/IronSourceError;)V", "Lcom/unity3d/ironsourceads/banner/BannerAdRequest;", "Lcom/unity3d/ironsourceads/banner/BannerAdRequest;", "adRequest", "Lcom/unity3d/ironsourceads/AdSize;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/unity3d/ironsourceads/AdSize;", ContentDisposition.Parameters.Size, "Lcom/ironsource/l5;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/l5;", "auctionResponseFetcher", "Lcom/ironsource/cm;", "d", "Lcom/ironsource/cm;", "loadTaskConfig", "Lcom/ironsource/vn;", "e", "Lcom/ironsource/vn;", "networkLoadApi", "Lcom/ironsource/q3;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/ironsource/q3;", "analytics", "Lcom/ironsource/t0;", "Lcom/unity3d/ironsourceads/banner/BannerAdView;", "g", "Lcom/ironsource/t0;", "adLoadTaskListener", "Lcom/ironsource/d6;", "h", "Lcom/ironsource/d6;", "adLayoutFactory", "Lcom/ironsource/xu$c;", "i", "Lcom/ironsource/xu$c;", "timerFactory", "Ljava/util/concurrent/Executor;", "j", "Ljava/util/concurrent/Executor;", "taskFinishedExecutor", "Lcom/ironsource/ib;", CampaignEx.JSON_KEY_AD_K, "Lcom/ironsource/ib;", "taskStartedTime", "Lcom/ironsource/xu;", "l", "Lcom/ironsource/xu;", "loadTimeoutTimer", "Lcom/ironsource/w4;", "m", "Lcom/ironsource/w4;", "auctionDataReporter", "", "n", "Z", "isTaskFinished", "<init>", "(Lcom/unity3d/ironsourceads/banner/BannerAdRequest;Lcom/unity3d/ironsourceads/AdSize;Lcom/ironsource/l5;Lcom/ironsource/cm;Lcom/ironsource/vn;Lcom/ironsource/q3;Lcom/ironsource/t0;Lcom/ironsource/d6;Lcom/ironsource/xu$c;Ljava/util/concurrent/Executor;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class c7 implements bm, a6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final BannerAdRequest adRequest;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final AdSize size;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final l5 auctionResponseFetcher;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final cm loadTaskConfig;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final vn networkLoadApi;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final q3 analytics;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final t0<BannerAdView> adLoadTaskListener;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final d6 adLayoutFactory;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final xu.c timerFactory;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final Executor taskFinishedExecutor;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private ib taskStartedTime;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private xu loadTimeoutTimer;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private w4 auctionDataReporter;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private boolean isTaskFinished;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/ironsource/c7$a", "Lcom/ironsource/xu$a;", "", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements xu.a {
        a() {
        }

        @Override // com.ironsource.xu.a
        public void a() {
            c7.this.a(wb.f4558a.s());
        }
    }

    public c7(BannerAdRequest adRequest, AdSize size, l5 auctionResponseFetcher, cm loadTaskConfig, vn networkLoadApi, q3 analytics, t0<BannerAdView> adLoadTaskListener, d6 adLayoutFactory, xu.c timerFactory, Executor taskFinishedExecutor) {
        Intrinsics.checkNotNullParameter(adRequest, "adRequest");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(auctionResponseFetcher, "auctionResponseFetcher");
        Intrinsics.checkNotNullParameter(loadTaskConfig, "loadTaskConfig");
        Intrinsics.checkNotNullParameter(networkLoadApi, "networkLoadApi");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(adLoadTaskListener, "adLoadTaskListener");
        Intrinsics.checkNotNullParameter(adLayoutFactory, "adLayoutFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "timerFactory");
        Intrinsics.checkNotNullParameter(taskFinishedExecutor, "taskFinishedExecutor");
        this.adRequest = adRequest;
        this.size = size;
        this.auctionResponseFetcher = auctionResponseFetcher;
        this.loadTaskConfig = loadTaskConfig;
        this.networkLoadApi = networkLoadApi;
        this.analytics = analytics;
        this.adLoadTaskListener = adLoadTaskListener;
        this.adLayoutFactory = adLayoutFactory;
        this.timerFactory = timerFactory;
        this.taskFinishedExecutor = taskFinishedExecutor;
    }

    public /* synthetic */ c7(BannerAdRequest bannerAdRequest, AdSize adSize, l5 l5Var, cm cmVar, vn vnVar, q3 q3Var, t0 t0Var, d6 d6Var, xu.c cVar, Executor executor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bannerAdRequest, adSize, l5Var, cmVar, vnVar, q3Var, t0Var, d6Var, (i & 256) != 0 ? new xu.d() : cVar, (i & 512) != 0 ? hg.f3748a.c() : executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(c7 this$0, IronSourceError error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        if (this$0.isTaskFinished) {
            return;
        }
        this$0.isTaskFinished = true;
        xu xuVar = this$0.loadTimeoutTimer;
        if (xuVar != null) {
            xuVar.cancel();
        }
        j3.c.Companion companion = j3.c.INSTANCE;
        m3.j jVar = new m3.j(error.getErrorCode());
        m3.k kVar = new m3.k(error.getErrorMessage());
        ib ibVar = this$0.taskStartedTime;
        if (ibVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskStartedTime");
            ibVar = null;
        }
        companion.a(jVar, kVar, new m3.f(ib.a(ibVar))).a(this$0.analytics);
        w4 w4Var = this$0.auctionDataReporter;
        if (w4Var != null) {
            w4Var.a("onBannerLoadFail");
        }
        this$0.adLoadTaskListener.onAdLoadFailed(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(c7 this$0, rj adInstance, vg adContainer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInstance, "$adInstance");
        Intrinsics.checkNotNullParameter(adContainer, "$adContainer");
        if (this$0.isTaskFinished) {
            return;
        }
        this$0.isTaskFinished = true;
        xu xuVar = this$0.loadTimeoutTimer;
        if (xuVar != null) {
            xuVar.cancel();
        }
        ib ibVar = this$0.taskStartedTime;
        if (ibVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskStartedTime");
            ibVar = null;
        }
        j3.c.INSTANCE.a(new m3.f(ib.a(ibVar))).a(this$0.analytics);
        w4 w4Var = this$0.auctionDataReporter;
        if (w4Var != null) {
            w4Var.b("onBannerLoadSuccess");
        }
        d6 d6Var = this$0.adLayoutFactory;
        w4 w4Var2 = this$0.auctionDataReporter;
        Intrinsics.checkNotNull(w4Var2);
        this$0.adLoadTaskListener.a(d6Var.a(adInstance, adContainer, w4Var2));
    }

    public final void a(final IronSourceError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.taskFinishedExecutor.execute(new Runnable() { // from class: com.ironsource.c7$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                c7.a(this.f$0, error);
            }
        });
    }

    @Override // com.json.a6
    public void onBannerLoadFail(String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        a(wb.f4558a.c(description));
    }

    @Override // com.json.a6
    public void onBannerLoadSuccess(final rj adInstance, final vg adContainer) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        Intrinsics.checkNotNullParameter(adContainer, "adContainer");
        this.taskFinishedExecutor.execute(new Runnable() { // from class: com.ironsource.c7$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                c7.a(this.f$0, adInstance, adContainer);
            }
        });
    }

    @Override // com.json.bm
    public void start() {
        this.taskStartedTime = new ib();
        this.analytics.a(new m3.s(this.loadTaskConfig.f()), new m3.n(this.loadTaskConfig.g().getValue()), new m3.c(this.size), new m3.b(this.adRequest.getAdId()));
        j3.c.INSTANCE.a().a(this.analytics);
        long jH = this.loadTaskConfig.h();
        xu.c cVar = this.timerFactory;
        xu.b bVar = new xu.b();
        bVar.b(jH);
        Unit unit = Unit.INSTANCE;
        xu xuVarA = cVar.a(bVar);
        this.loadTimeoutTimer = xuVarA;
        if (xuVarA != null) {
            xuVarA.a(new a());
        }
        Object objA = this.auctionResponseFetcher.a();
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objA);
        if (thM7907exceptionOrNullimpl != null) {
            Intrinsics.checkNotNull(thM7907exceptionOrNullimpl, "null cannot be cast to non-null type com.unity3d.ironsourceads.internal.error.ISException");
            a(((qg) thM7907exceptionOrNullimpl).getError());
            objA = null;
        }
        i5 i5Var = (i5) objA;
        if (i5Var == null) {
            return;
        }
        q3 q3Var = this.analytics;
        String auctionId = i5Var.getAuctionId();
        if (auctionId != null) {
            q3Var.a(new m3.d(auctionId));
        }
        JSONObject genericParams = i5Var.getGenericParams();
        if (genericParams != null) {
            q3Var.a(new m3.m(genericParams));
        }
        String strA = i5Var.a();
        if (strA != null) {
            q3Var.a(new m3.g(strA));
        }
        wi wiVarG = this.loadTaskConfig.g();
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        tg tgVar = new tg(AdapterUtils.dpToPixels(applicationContext, this.size.getWidth()), AdapterUtils.dpToPixels(applicationContext, this.size.getHeight()), this.size.getSizeDescription());
        ko koVar = new ko();
        koVar.a(this);
        rj adInstance = new sj(this.adRequest.getProviderName().value(), koVar).a(wiVarG.b(wi.Bidder)).a(tgVar).b(this.loadTaskConfig.i()).a(this.adRequest.getAdId()).a(new on().a()).a();
        xn xnVar = new xn(i5Var, this.loadTaskConfig.j());
        this.auctionDataReporter = new w4(new vi(this.adRequest.getInstanceId(), wiVarG.getValue(), i5Var.a()), new d(), i5Var.getAuctionReportUrls());
        j3.d.INSTANCE.c().a(this.analytics);
        vn vnVar = this.networkLoadApi;
        Intrinsics.checkNotNullExpressionValue(adInstance, "adInstance");
        vnVar.a(adInstance, xnVar);
    }
}
