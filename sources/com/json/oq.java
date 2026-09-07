package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.d;
import com.json.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.ironsourceads.rewarded.RewardedAd;
import com.unity3d.ironsourceads.rewarded.RewardedAdRequest;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B_\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020!\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00150%\u0012\b\b\u0002\u0010,\u001a\u00020)\u0012\b\b\u0002\u00100\u001a\u00020-¢\u0006\u0004\bA\u0010BJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0007\u0010\fR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00150%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006C"}, d2 = {"Lcom/ironsource/oq;", "Lcom/ironsource/bm;", "Lcom/ironsource/bd;", "", "start", "Lcom/ironsource/rj;", b9.h.p0, "a", "", "description", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "(Lcom/ironsource/mediationsdk/logger/IronSourceError;)V", "Lcom/unity3d/ironsourceads/rewarded/RewardedAdRequest;", "Lcom/unity3d/ironsourceads/rewarded/RewardedAdRequest;", "adRequest", "Lcom/ironsource/cm;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/cm;", "loadTaskConfig", "Lcom/ironsource/t0;", "Lcom/unity3d/ironsourceads/rewarded/RewardedAd;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/t0;", "adLoadTaskListener", "Lcom/ironsource/l5;", "d", "Lcom/ironsource/l5;", "auctionResponseFetcher", "Lcom/ironsource/vn;", "e", "Lcom/ironsource/vn;", "networkLoadApi", "Lcom/ironsource/q3;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/ironsource/q3;", "analytics", "Lcom/ironsource/c1;", "g", "Lcom/ironsource/c1;", "adObjectFactory", "Lcom/ironsource/xu$c;", "h", "Lcom/ironsource/xu$c;", "timerFactory", "Ljava/util/concurrent/Executor;", "i", "Ljava/util/concurrent/Executor;", "taskFinishedExecutor", "Lcom/ironsource/ib;", "j", "Lcom/ironsource/ib;", "taskStartedTime", "Lcom/ironsource/xu;", CampaignEx.JSON_KEY_AD_K, "Lcom/ironsource/xu;", "loadTimeoutTimer", "Lcom/ironsource/w4;", "l", "Lcom/ironsource/w4;", "auctionDataReporter", "", "m", "Z", "isTaskFinished", "<init>", "(Lcom/unity3d/ironsourceads/rewarded/RewardedAdRequest;Lcom/ironsource/cm;Lcom/ironsource/t0;Lcom/ironsource/l5;Lcom/ironsource/vn;Lcom/ironsource/q3;Lcom/ironsource/c1;Lcom/ironsource/xu$c;Ljava/util/concurrent/Executor;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class oq implements bm, bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final RewardedAdRequest adRequest;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final cm loadTaskConfig;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final t0<RewardedAd> adLoadTaskListener;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final l5 auctionResponseFetcher;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final vn networkLoadApi;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final q3 analytics;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final c1<RewardedAd> adObjectFactory;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final xu.c timerFactory;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final Executor taskFinishedExecutor;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private ib taskStartedTime;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private xu loadTimeoutTimer;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private w4 auctionDataReporter;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private boolean isTaskFinished;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/ironsource/oq$a", "Lcom/ironsource/xu$a;", "", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements xu.a {
        a() {
        }

        @Override // com.ironsource.xu.a
        public void a() {
            oq.this.a(wb.f4558a.s());
        }
    }

    public oq(RewardedAdRequest adRequest, cm loadTaskConfig, t0<RewardedAd> adLoadTaskListener, l5 auctionResponseFetcher, vn networkLoadApi, q3 analytics, c1<RewardedAd> adObjectFactory, xu.c timerFactory, Executor taskFinishedExecutor) {
        Intrinsics.checkNotNullParameter(adRequest, "adRequest");
        Intrinsics.checkNotNullParameter(loadTaskConfig, "loadTaskConfig");
        Intrinsics.checkNotNullParameter(adLoadTaskListener, "adLoadTaskListener");
        Intrinsics.checkNotNullParameter(auctionResponseFetcher, "auctionResponseFetcher");
        Intrinsics.checkNotNullParameter(networkLoadApi, "networkLoadApi");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(adObjectFactory, "adObjectFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "timerFactory");
        Intrinsics.checkNotNullParameter(taskFinishedExecutor, "taskFinishedExecutor");
        this.adRequest = adRequest;
        this.loadTaskConfig = loadTaskConfig;
        this.adLoadTaskListener = adLoadTaskListener;
        this.auctionResponseFetcher = auctionResponseFetcher;
        this.networkLoadApi = networkLoadApi;
        this.analytics = analytics;
        this.adObjectFactory = adObjectFactory;
        this.timerFactory = timerFactory;
        this.taskFinishedExecutor = taskFinishedExecutor;
    }

    public /* synthetic */ oq(RewardedAdRequest rewardedAdRequest, cm cmVar, t0 t0Var, l5 l5Var, vn vnVar, q3 q3Var, c1 c1Var, xu.c cVar, Executor executor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(rewardedAdRequest, cmVar, t0Var, l5Var, vnVar, q3Var, c1Var, (i & 128) != 0 ? new xu.d() : cVar, (i & 256) != 0 ? hg.f3748a.c() : executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(oq this$0, IronSourceError error) {
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
            w4Var.a("onAdInstanceLoadFail");
        }
        this$0.adLoadTaskListener.onAdLoadFailed(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(oq this$0, rj adInstance) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInstance, "$adInstance");
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
            w4Var.b("onAdInstanceLoadSuccess");
        }
        c1<RewardedAd> c1Var = this$0.adObjectFactory;
        w4 w4Var2 = this$0.auctionDataReporter;
        Intrinsics.checkNotNull(w4Var2);
        this$0.adLoadTaskListener.a(c1Var.a(adInstance, w4Var2));
    }

    public final void a(final IronSourceError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.taskFinishedExecutor.execute(new Runnable() { // from class: com.ironsource.oq$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                oq.a(this.f$0, error);
            }
        });
    }

    @Override // com.json.bd
    public void a(final rj adInstance) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        this.taskFinishedExecutor.execute(new Runnable() { // from class: com.ironsource.oq$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                oq.a(this.f$0, adInstance);
            }
        });
    }

    @Override // com.json.bd
    public void a(String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        a(wb.f4558a.c(description));
    }

    @Override // com.json.bm
    public void start() {
        this.taskStartedTime = new ib();
        this.analytics.a(new m3.s(this.loadTaskConfig.f()), new m3.n(this.loadTaskConfig.g().getValue()), new m3.b(this.adRequest.getAdId()));
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
        ad adVar = new ad();
        adVar.a(this);
        rj adInstance = new sj(this.adRequest.getProviderName().value(), adVar).a(wiVarG.b(wi.Bidder)).b(this.loadTaskConfig.i()).c().a(this.adRequest.getAdId()).a(MapsKt.plus(new on().a(), qc.f4199a.a(this.adRequest.getExtraParams()))).a();
        q3 q3Var2 = this.analytics;
        String strE = adInstance.e();
        Intrinsics.checkNotNullExpressionValue(strE, "adInstance.id");
        q3Var2.a(new m3.b(strE));
        xn xnVar = new xn(i5Var, this.loadTaskConfig.j());
        this.auctionDataReporter = new w4(new vi(this.adRequest.getInstanceId(), wiVarG.getValue(), i5Var.a()), new d(), i5Var.getAuctionReportUrls());
        j3.d.INSTANCE.c().a(this.analytics);
        vn vnVar = this.networkLoadApi;
        Intrinsics.checkNotNullExpressionValue(adInstance, "adInstance");
        vnVar.a(adInstance, xnVar);
    }
}
