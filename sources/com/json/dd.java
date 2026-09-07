package com.json;

import android.app.Activity;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.model.Placement;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004Bo\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\b\b\u0002\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$\u0012<\b\u0002\u0010-\u001a6\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020+0&j\u0002`,¢\u0006\u0004\b.\u0010/J\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u00060"}, d2 = {"Lcom/ironsource/dd;", "Lcom/ironsource/n;", "Lcom/ironsource/sd;", "Lcom/ironsource/n2;", "Lcom/ironsource/z1;", "", "i", "Landroid/app/Activity;", "activity", "Lcom/ironsource/mediationsdk/model/Placement;", "placement", "a", "Lcom/unity3d/mediation/LevelPlayAdInfo;", "adInfo", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "onAdInfoChanged", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "onClosed", "Lcom/unity3d/mediation/rewarded/LevelPlayReward;", "reward", "Lcom/ironsource/gd;", "Lcom/ironsource/gd;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/ironsource/f1;", "Lcom/ironsource/f1;", "adProperties", "Lcom/ironsource/td;", "d", "Lcom/ironsource/td;", "adUnitStrategy", "Lcom/ironsource/o1;", "adTools", "Lcom/ironsource/td$b;", "adUnitStrategyFactory", "Lcom/ironsource/x1;", "adUnitDataFactory", "Lkotlin/Function2;", "Lcom/ironsource/w1;", "Lkotlin/ParameterName;", "name", "adUnitData", "Lcom/ironsource/pd;", "Lcom/unity3d/mediation/internal/ads/controllers/CreateFullscreenAdUnitFn;", "createFullscreenAdUnit", "<init>", "(Lcom/ironsource/gd;Lcom/ironsource/o1;Lcom/ironsource/f1;Lcom/ironsource/td$b;Lcom/ironsource/x1;Lkotlin/jvm/functions/Function2;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class dd extends n implements sd, n2, z1 {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final gd listener;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final f1 adProperties;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final td adUnitStrategy;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/ironsource/w1;", "adUnitData", "Lcom/ironsource/sd;", "fullscreenAdUnitListener", "Lcom/ironsource/pd;", "a", "(Lcom/ironsource/w1;Lcom/ironsource/sd;)Lcom/ironsource/pd;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function2<w1, sd, pd> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o1 f3607a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(o1 o1Var) {
            super(2);
            this.f3607a = o1Var;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final pd invoke(w1 adUnitData, sd fullscreenAdUnitListener) {
            Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
            Intrinsics.checkNotNullParameter(fullscreenAdUnitListener, "fullscreenAdUnitListener");
            return new pd(mm.INSTANCE.c(), new w2(this.f3607a, adUnitData, e2.b.MEDIATION), adUnitData, fullscreenAdUnitListener, null, null, null, null, 240, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/ironsource/dd$b", "Lcom/ironsource/qd;", "", "isPublisherLoad", "Lcom/ironsource/pd;", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements qd {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x1 f3608a;
        final /* synthetic */ dd b;
        final /* synthetic */ Function2<w1, sd, pd> c;

        /* JADX WARN: Multi-variable type inference failed */
        b(x1 x1Var, dd ddVar, Function2<? super w1, ? super sd, pd> function2) {
            this.f3608a = x1Var;
            this.b = ddVar;
            this.c = function2;
        }

        @Override // com.json.qd
        public pd a(boolean isPublisherLoad) {
            return this.c.invoke(this.f3608a.a(isPublisherLoad, this.b.adProperties), this.b);
        }
    }

    public dd(gd listener, o1 adTools, f1 adProperties, td.b adUnitStrategyFactory, x1 adUnitDataFactory, Function2<? super w1, ? super sd, pd> createFullscreenAdUnit) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        Intrinsics.checkNotNullParameter(adUnitStrategyFactory, "adUnitStrategyFactory");
        Intrinsics.checkNotNullParameter(adUnitDataFactory, "adUnitDataFactory");
        Intrinsics.checkNotNullParameter(createFullscreenAdUnit, "createFullscreenAdUnit");
        this.listener = listener;
        this.adProperties = adProperties;
        this.adUnitStrategy = adUnitStrategyFactory.a(adTools, adTools.b(adProperties.d(), adProperties.getAdUnitId()), new b(adUnitDataFactory, this, createFullscreenAdUnit));
    }

    public /* synthetic */ dd(gd gdVar, o1 o1Var, f1 f1Var, td.b bVar, x1 x1Var, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(gdVar, o1Var, f1Var, (i & 8) != 0 ? new td.b() : bVar, x1Var, (i & 32) != 0 ? new a(o1Var) : function2);
    }

    @Override // com.json.n2
    public void a() {
        this.listener.a();
    }

    public final void a(Activity activity, Placement placement) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.adProperties.a(placement);
        this.adUnitStrategy.a(activity, this);
    }

    @Override // com.json.n2
    public void a(IronSourceError error) {
        gd gdVar = this.listener;
        String string = this.adProperties.getAdId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "adProperties.adId.toString()");
        gdVar.onAdLoadFailed(new LevelPlayAdError(error, string, this.adProperties.getAdUnitId()));
    }

    @Override // com.json.n2
    public void a(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.listener.onAdLoaded(adInfo);
    }

    @Override // com.json.sd
    public void a(LevelPlayReward reward) {
        Intrinsics.checkNotNullParameter(reward, "reward");
        this.listener.a(reward);
    }

    @Override // com.json.z1
    public void b() {
        this.listener.b();
    }

    @Override // com.json.z1
    public void b(IronSourceError error) {
        gd gdVar = this.listener;
        String string = this.adProperties.getAdId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "adProperties.adId.toString()");
        gdVar.a(new LevelPlayAdError(error, string, this.adProperties.getAdUnitId()));
    }

    @Override // com.json.k2
    public void c() {
        this.listener.onAdClicked();
    }

    public final void i() {
        this.adUnitStrategy.a(this);
    }

    @Override // com.json.n2
    public void onAdInfoChanged(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.listener.onAdInfoChanged(adInfo);
    }

    @Override // com.json.sd
    public void onClosed() {
        this.listener.onAdClosed();
    }
}
