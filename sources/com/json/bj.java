package com.json;

import android.app.Activity;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.ironsourceads.interstitial.InterstitialAdInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001Be\b\u0000\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010%\u001a\u00020#\u0012\b\b\u0002\u0010)\u001a\u00020&\u0012\b\b\u0002\u0010-\u001a\u00020*\u0012\b\b\u0002\u00101\u001a\u00020.\u0012\b\b\u0002\u00105\u001a\u000202\u0012\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000006¢\u0006\u0004\bF\u0010GJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000f\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0005\u0010\u000bJ\b\u0010\f\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u001a\u0010\u0016\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0004R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R \u00109\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0000068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010?\u001a\u00020:8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b\u001c\u0010=\"\u0004\b\u0005\u0010>R$\u0010E\u001a\u0004\u0018\u00010@8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\b \u0010C\"\u0004\b\u0005\u0010D¨\u0006H"}, d2 = {"Lcom/ironsource/bj;", "Lcom/ironsource/cd;", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "", "a", "", "d", "()Z", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;)V", "onAdInstanceDidShow", "", "description", "onAdInstanceDidBecomeVisible", "()V", "onAdInstanceDidClick", "onAdInstanceDidDismiss", "demandSourceId", "", "amount", "onAdInstanceDidReward", "finalize", "Lcom/ironsource/rj;", "Lcom/ironsource/rj;", b9.h.p0, "Lcom/ironsource/a1;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/a1;", "adNetworkShow", "Lcom/ironsource/x4;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/x4;", "auctionDataReporter", "Lcom/ironsource/q3;", "Lcom/ironsource/q3;", "analytics", "Lcom/ironsource/mn;", "e", "Lcom/ironsource/mn;", "networkDestroyAPI", "Lcom/ironsource/uu;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/ironsource/uu;", "threadManager", "Lcom/ironsource/ai;", "g", "Lcom/ironsource/ai;", "sessionDepthService", "Lcom/ironsource/ai$a;", "h", "Lcom/ironsource/ai$a;", "sessionDepthServiceEditor", "", "i", "Ljava/util/Map;", "retainer", "Lcom/unity3d/ironsourceads/interstitial/InterstitialAdInfo;", "j", "Lcom/unity3d/ironsourceads/interstitial/InterstitialAdInfo;", "()Lcom/unity3d/ironsourceads/interstitial/InterstitialAdInfo;", "(Lcom/unity3d/ironsourceads/interstitial/InterstitialAdInfo;)V", "adInfo", "Lcom/ironsource/cj;", CampaignEx.JSON_KEY_AD_K, "Lcom/ironsource/cj;", "()Lcom/ironsource/cj;", "(Lcom/ironsource/cj;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lcom/ironsource/rj;Lcom/ironsource/a1;Lcom/ironsource/x4;Lcom/ironsource/q3;Lcom/ironsource/mn;Lcom/ironsource/uu;Lcom/ironsource/ai;Lcom/ironsource/ai$a;Ljava/util/Map;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class bj implements cd {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private rj adInstance;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private a1 adNetworkShow;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private x4 auctionDataReporter;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private q3 analytics;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private mn networkDestroyAPI;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private uu threadManager;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private ai sessionDepthService;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private ai.a sessionDepthServiceEditor;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final Map<String, bj> retainer;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private InterstitialAdInfo adInfo;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private cj listener;

    public bj(rj adInstance, a1 adNetworkShow, x4 auctionDataReporter, q3 analytics, mn networkDestroyAPI, uu threadManager, ai sessionDepthService, ai.a sessionDepthServiceEditor, Map<String, bj> retainer) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        Intrinsics.checkNotNullParameter(adNetworkShow, "adNetworkShow");
        Intrinsics.checkNotNullParameter(auctionDataReporter, "auctionDataReporter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(networkDestroyAPI, "networkDestroyAPI");
        Intrinsics.checkNotNullParameter(threadManager, "threadManager");
        Intrinsics.checkNotNullParameter(sessionDepthService, "sessionDepthService");
        Intrinsics.checkNotNullParameter(sessionDepthServiceEditor, "sessionDepthServiceEditor");
        Intrinsics.checkNotNullParameter(retainer, "retainer");
        this.adInstance = adInstance;
        this.adNetworkShow = adNetworkShow;
        this.auctionDataReporter = auctionDataReporter;
        this.analytics = analytics;
        this.networkDestroyAPI = networkDestroyAPI;
        this.threadManager = threadManager;
        this.sessionDepthService = sessionDepthService;
        this.sessionDepthServiceEditor = sessionDepthServiceEditor;
        this.retainer = retainer;
        String strF = adInstance.f();
        Intrinsics.checkNotNullExpressionValue(strF, "adInstance.instanceId");
        String strE = this.adInstance.e();
        Intrinsics.checkNotNullExpressionValue(strE, "adInstance.id");
        this.adInfo = new InterstitialAdInfo(strF, strE);
        ad adVar = new ad();
        this.adInstance.a(adVar);
        adVar.a(this);
    }

    public /* synthetic */ bj(rj rjVar, a1 a1Var, x4 x4Var, q3 q3Var, mn mnVar, uu uuVar, ai aiVar, ai.a aVar, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(rjVar, a1Var, x4Var, q3Var, (i & 16) != 0 ? new nn() : mnVar, (i & 32) != 0 ? hg.f3748a : uuVar, (i & 64) != 0 ? mm.INSTANCE.d().k() : aiVar, (i & 128) != 0 ? mm.INSTANCE.a().e() : aVar, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(bj this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        j3.d.INSTANCE.b().a(this$0.analytics);
        this$0.networkDestroyAPI.a(this$0.adInstance);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(bj this$0, IronSourceError error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        cj cjVar = this$0.listener;
        if (cjVar != null) {
            cjVar.onAdInstanceDidFailedToShow(error);
        }
    }

    private final void a(final IronSourceError error) {
        this.retainer.remove(this.adInfo.getAdId());
        j3.a.INSTANCE.a(new m3.j(error.getErrorCode()), new m3.k(error.getErrorMessage())).a(this.analytics);
        this.threadManager.a(new Runnable() { // from class: com.ironsource.bj$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                bj.a(this.f$0, error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(bj this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cj cjVar = this$0.listener;
        if (cjVar != null) {
            cjVar.onAdInstanceDidClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(bj this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cj cjVar = this$0.listener;
        if (cjVar != null) {
            cjVar.onAdInstanceDidDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(bj this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cj cjVar = this$0.listener;
        if (cjVar != null) {
            cjVar.onAdInstanceDidShow();
        }
    }

    public final void a() {
        uu.a(this.threadManager, new Runnable() { // from class: com.ironsource.bj$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                bj.a(this.f$0);
            }
        }, 0L, 2, null);
    }

    public final void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.retainer.put(this.adInfo.getAdId(), this);
        if (!this.adNetworkShow.a(this.adInstance)) {
            a(wb.f4558a.t());
        } else {
            j3.a.INSTANCE.d(new n3[0]).a(this.analytics);
            this.adNetworkShow.a(activity, this.adInstance);
        }
    }

    public final void a(cj cjVar) {
        this.listener = cjVar;
    }

    public final void a(InterstitialAdInfo interstitialAdInfo) {
        Intrinsics.checkNotNullParameter(interstitialAdInfo, "<set-?>");
        this.adInfo = interstitialAdInfo;
    }

    @Override // com.json.cd
    public void a(String description) {
        a(wb.f4558a.c(new IronSourceError(0, description)));
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final InterstitialAdInfo getAdInfo() {
        return this.adInfo;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final cj getListener() {
        return this.listener;
    }

    public final boolean d() {
        boolean zA = this.adNetworkShow.a(this.adInstance);
        j3.a.INSTANCE.a(zA).a(this.analytics);
        return zA;
    }

    protected final void finalize() {
        a();
    }

    @Override // com.json.cd
    public void onAdInstanceDidBecomeVisible() {
        j3.a.INSTANCE.f(new n3[0]).a(this.analytics);
    }

    @Override // com.json.cd
    public void onAdInstanceDidClick() {
        j3.a.INSTANCE.a().a(this.analytics);
        this.threadManager.a(new Runnable() { // from class: com.ironsource.bj$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                bj.b(this.f$0);
            }
        });
    }

    @Override // com.json.cd
    public void onAdInstanceDidDismiss() {
        this.retainer.remove(this.adInfo.getAdId());
        j3.a.INSTANCE.a(new n3[0]).a(this.analytics);
        this.threadManager.a(new Runnable() { // from class: com.ironsource.bj$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                bj.c(this.f$0);
            }
        });
    }

    @Override // com.json.cd
    public void onAdInstanceDidReward(String demandSourceId, int amount) {
    }

    @Override // com.json.cd
    public void onAdInstanceDidShow() {
        ai aiVar = this.sessionDepthService;
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
        j3.a.INSTANCE.b(new m3.w(aiVar.a(ad_unit))).a(this.analytics);
        this.sessionDepthServiceEditor.b(ad_unit);
        this.auctionDataReporter.c("onAdInstanceDidShow");
        this.threadManager.a(new Runnable() { // from class: com.ironsource.bj$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                bj.d(this.f$0);
            }
        });
    }
}
