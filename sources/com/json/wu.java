package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\tB7\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010C\u001a\u00020B\u0012\u0006\u0010!\u001a\u00020\u001f\u0012\u0006\u0010$\u001a\u00020\"¢\u0006\u0004\bD\u0010EJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J#\u0010\t\u001a\u00020\u00042\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010/R\u001c\u00103\u001a\b\u0018\u000101R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u00102R\u001a\u00105\u001a\u000601R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00102R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00108R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006F"}, d2 = {"Lcom/ironsource/wu;", "Lcom/ironsource/i7;", "Lcom/ironsource/m2;", "Lcom/ironsource/y1;", "", "j", "", "Lcom/ironsource/gp;", "triggers", "a", "([Lcom/ironsource/gp;)V", "l", "i", CampaignEx.JSON_KEY_AD_K, InneractiveMediationDefs.GENDER_FEMALE, "Lcom/ironsource/t1;", "adUnitCallback", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "g", "h", "Lcom/ironsource/o1;", "d", "Lcom/ironsource/o1;", "adTools", "Lcom/ironsource/w6;", "e", "Lcom/ironsource/w6;", "bannerContainer", "Lcom/ironsource/j7;", "Lcom/ironsource/j7;", "bannerStrategyListener", "Lcom/ironsource/n6;", "Lcom/ironsource/n6;", "bannerAdUnitFactory", "Lcom/ironsource/ev;", "Lcom/ironsource/ev;", "taskScheduler", "Lcom/ironsource/w3;", "Lcom/ironsource/w3;", "appLifecycleTrigger", "Lcom/ironsource/rv;", "Lcom/ironsource/rv;", "viewVisibilityTrigger", "Lcom/ironsource/km;", "Lcom/ironsource/km;", "manualTrigger", "Lcom/ironsource/wu$a;", "Lcom/ironsource/wu$a;", "currentBanner", "m", "nextBanner", "", "n", "Z", "isShowCountdownFinished", "o", "isFirstShow", "p", "Lcom/ironsource/t1;", CampaignEx.JSON_KEY_AD_Q, "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "Lcom/ironsource/i7$b;", DTBMetricsConfiguration.CONFIG_DIR, "Lcom/ironsource/j6;", "bannerAdProperties", "<init>", "(Lcom/ironsource/o1;Lcom/ironsource/w6;Lcom/ironsource/i7$b;Lcom/ironsource/j6;Lcom/ironsource/j7;Lcom/ironsource/n6;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class wu extends i7 implements m2, y1 {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final o1 adTools;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final w6 bannerContainer;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final j7 bannerStrategyListener;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final n6 bannerAdUnitFactory;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private ev taskScheduler;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final w3 appLifecycleTrigger;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final rv viewVisibilityTrigger;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final km manualTrigger;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private a currentBanner;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private a nextBanner;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private boolean isShowCountdownFinished;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private boolean isFirstShow;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private t1 adUnitCallback;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private IronSourceError error;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0011\u001a\u00020\r8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u0006\u0010\u000f\"\u0004\b\u0006\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\n\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/ironsource/wu$a;", "", "", "e", "", "isPublisherDestroy", "a", "d", "Lcom/ironsource/l6;", "Lcom/ironsource/l6;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lcom/ironsource/l6;", "bannerAdUnit", "Lcom/ironsource/t1;", "Lcom/ironsource/t1;", "()Lcom/ironsource/t1;", "(Lcom/ironsource/t1;)V", "adUnitCallback", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Z", "()Z", "(Z)V", "isLoading", "Lcom/ironsource/n6;", "bannerAdUnitFactory", "isPublisherLoad", "<init>", "(Lcom/ironsource/wu;Lcom/ironsource/n6;Z)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    private final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final l6 bannerAdUnit;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public t1 adUnitCallback;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private boolean isLoading;
        final /* synthetic */ wu d;

        public a(wu wuVar, n6 bannerAdUnitFactory, boolean z) {
            Intrinsics.checkNotNullParameter(bannerAdUnitFactory, "bannerAdUnitFactory");
            this.d = wuVar;
            this.bannerAdUnit = bannerAdUnitFactory.a(z);
            this.isLoading = true;
        }

        public final t1 a() {
            t1 t1Var = this.adUnitCallback;
            if (t1Var != null) {
                return t1Var;
            }
            Intrinsics.throwUninitializedPropertyAccessException("adUnitCallback");
            return null;
        }

        public final void a(t1 t1Var) {
            Intrinsics.checkNotNullParameter(t1Var, "<set-?>");
            this.adUnitCallback = t1Var;
        }

        public final void a(boolean isPublisherDestroy) {
            this.bannerAdUnit.a(isPublisherDestroy);
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final l6 getBannerAdUnit() {
            return this.bannerAdUnit;
        }

        public final void b(boolean z) {
            this.isLoading = z;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public final boolean d() {
            return this.bannerAdUnit.d().getIsReady();
        }

        public final void e() {
            this.bannerAdUnit.a((m2) this.d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wu(o1 adTools, w6 bannerContainer, i7.b config, j6 bannerAdProperties, j7 bannerStrategyListener, n6 bannerAdUnitFactory) {
        super(config, bannerAdProperties);
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(bannerContainer, "bannerContainer");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(bannerAdProperties, "bannerAdProperties");
        Intrinsics.checkNotNullParameter(bannerStrategyListener, "bannerStrategyListener");
        Intrinsics.checkNotNullParameter(bannerAdUnitFactory, "bannerAdUnitFactory");
        this.adTools = adTools;
        this.bannerContainer = bannerContainer;
        this.bannerStrategyListener = bannerStrategyListener;
        this.bannerAdUnitFactory = bannerAdUnitFactory;
        IronLog.INTERNAL.verbose(o1.a(adTools, "refresh interval: " + d() + ", auto refresh: " + e(), (String) null, 2, (Object) null));
        this.appLifecycleTrigger = new w3(adTools.b());
        this.viewVisibilityTrigger = new rv(bannerContainer);
        this.manualTrigger = new km(!e());
        this.nextBanner = new a(this, bannerAdUnitFactory, true);
        this.isFirstShow = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(wu this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isShowCountdownFinished = true;
        if (this$0.nextBanner.d()) {
            this$0.l();
            return;
        }
        this$0.k();
        if (this$0.nextBanner.getIsLoading()) {
            return;
        }
        this$0.i();
        this$0.a(this$0.appLifecycleTrigger, this$0.manualTrigger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final wu this$0, gp[] triggers) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(triggers, "$triggers");
        this$0.isShowCountdownFinished = false;
        ev evVar = this$0.taskScheduler;
        if (evVar != null) {
            evVar.c();
        }
        this$0.taskScheduler = new ev(this$0.adTools, new Runnable() { // from class: com.ironsource.wu$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                wu.b(this.f$0);
            }
        }, this$0.d(), ArraysKt.toList(triggers));
    }

    private final void a(final gp... triggers) {
        this.adTools.c(new Runnable() { // from class: com.ironsource.wu$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                wu.a(this.f$0, triggers);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(wu this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j();
    }

    private final void i() {
        if (e()) {
            a aVar = new a(this, this.bannerAdUnitFactory, false);
            this.nextBanner = aVar;
            aVar.e();
        }
    }

    private final void j() {
        this.adTools.a(new Runnable() { // from class: com.ironsource.wu$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                wu.a(this.f$0);
            }
        });
    }

    private final void k() {
        this.bannerStrategyListener.c(this.error);
        this.adUnitCallback = null;
        this.error = null;
    }

    private final void l() {
        this.isFirstShow = false;
        this.nextBanner.getBannerAdUnit().a(this.bannerContainer.getViewBinder(), this);
        this.bannerStrategyListener.a(this.nextBanner.a());
        a aVar = this.currentBanner;
        if (aVar != null) {
            aVar.a(false);
        }
        this.currentBanner = this.nextBanner;
        i();
        a(this.viewVisibilityTrigger, this.appLifecycleTrigger, this.manualTrigger);
    }

    @Override // com.json.m2
    public void a(IronSourceError error) {
        this.nextBanner.b(false);
        this.error = error;
        if (this.isFirstShow) {
            k();
            a(this.appLifecycleTrigger, this.manualTrigger);
        } else if (this.isShowCountdownFinished) {
            k();
            i();
            a(this.appLifecycleTrigger, this.manualTrigger);
        }
    }

    @Override // com.json.y1
    public void b() {
        this.bannerStrategyListener.f();
    }

    @Override // com.json.y1
    public void b(IronSourceError error) {
        this.bannerStrategyListener.d(error);
    }

    @Override // com.json.i7
    public void c() {
        this.appLifecycleTrigger.e();
        this.viewVisibilityTrigger.e();
        ev evVar = this.taskScheduler;
        if (evVar != null) {
            evVar.c();
        }
        this.taskScheduler = null;
        a aVar = this.currentBanner;
        if (aVar != null) {
            aVar.a(true);
        }
        this.nextBanner.a(true);
    }

    @Override // com.json.m2
    public void c(t1 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        this.nextBanner.a(adUnitCallback);
        this.nextBanner.b(false);
        if (this.isShowCountdownFinished || this.isFirstShow) {
            l();
        }
    }

    @Override // com.json.i7
    public void f() {
        this.nextBanner.e();
    }

    @Override // com.json.i7
    public void g() {
        if (e()) {
            this.manualTrigger.e();
        }
    }

    @Override // com.json.i7
    public void h() {
        if (e()) {
            this.manualTrigger.f();
        }
    }
}
