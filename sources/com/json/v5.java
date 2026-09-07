package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010!\u001a\u00020\u0006\u0012\u0006\u0010#\u001a\u00020\b\u0012\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\b\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0010J\u0010\u0010\r\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\u0012\u0010\u001b\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0016R\u0014\u0010!\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\"R\"\u0010(\u001a\u0010\u0012\f\u0012\n &*\u0004\u0018\u00010%0%0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010'R\u0016\u0010+\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010*R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/ironsource/v5;", "Lcom/ironsource/n;", "Lcom/ironsource/o6;", "Lcom/ironsource/j7;", "Lcom/ironsource/n6;", "i", "Lcom/ironsource/o1;", "tools", "Lcom/ironsource/j6;", "adProperties", "", "isPublisherLoad", "Lcom/ironsource/l6;", "a", "Lcom/unity3d/mediation/LevelPlayAdInfo;", "j", "", "l", CampaignEx.JSON_KEY_AD_K, "p", CampaignEx.JSON_KEY_AD_Q, "Lcom/ironsource/t1;", "adUnitCallback", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, InneractiveMediationDefs.GENDER_FEMALE, "d", "o", "n", "m", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/o1;", "adTools", "Lcom/ironsource/j6;", "bannerAdProperties", "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/w5;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "e", "Lcom/unity3d/mediation/LevelPlayAdInfo;", "currentAdInfo", "nextAdInfo", "Lcom/ironsource/i7;", "g", "Lcom/ironsource/i7;", "bannerStrategy", "Lcom/ironsource/w6;", "bannerViewContainer", "<init>", "(Lcom/ironsource/w5;Lcom/ironsource/o1;Lcom/ironsource/j6;Lcom/ironsource/w6;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class v5 extends n implements o6, j7 {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final o1 adTools;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final j6 bannerAdProperties;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final WeakReference<w5> listener;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private LevelPlayAdInfo currentAdInfo;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private LevelPlayAdInfo nextAdInfo;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final i7 bannerStrategy;

    public v5(w5 listener, o1 adTools, j6 bannerAdProperties, w6 bannerViewContainer) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(bannerAdProperties, "bannerAdProperties");
        Intrinsics.checkNotNullParameter(bannerViewContainer, "bannerViewContainer");
        this.adTools = adTools;
        this.bannerAdProperties = bannerAdProperties;
        this.listener = new WeakReference<>(listener);
        this.currentAdInfo = j();
        this.nextAdInfo = j();
        this.bannerStrategy = i7.INSTANCE.a(adTools, bannerViewContainer, adTools.b(bannerAdProperties.getAdUnitId()), bannerAdProperties, this, i());
    }

    private final l6 a(o1 tools, j6 adProperties, boolean isPublisherLoad) {
        IronLog.INTERNAL.verbose();
        return new l6(tools, m6.INSTANCE.a(adProperties, getSdkConfigService().a(), isPublisherLoad), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l6 a(v5 this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.a(this$0.adTools, this$0.bannerAdProperties, z);
    }

    private final n6 i() {
        return new n6() { // from class: com.ironsource.v5$$ExternalSyntheticLambda0
            @Override // com.json.n6
            public final l6 a(boolean z) {
                return v5.a(this.f$0, z);
            }
        };
    }

    private final LevelPlayAdInfo j() {
        String string = this.bannerAdProperties.getAdId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "bannerAdProperties.adId.toString()");
        String adUnitId = this.bannerAdProperties.getAdUnitId();
        String string2 = this.bannerAdProperties.getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "bannerAdProperties.adFormat.toString()");
        return new LevelPlayAdInfo(string, adUnitId, string2, null, null, null, null, 120, null);
    }

    @Override // com.json.j7
    public void a(t1 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC != null) {
            this.nextAdInfo = levelPlayAdInfoC;
            w5 w5Var = this.listener.get();
            if (w5Var != null) {
                w5Var.a(levelPlayAdInfoC, false);
            }
        }
    }

    @Override // com.json.k2
    public void c() {
        w5 w5Var = this.listener.get();
        if (w5Var != null) {
            w5Var.e(this.currentAdInfo);
        }
    }

    @Override // com.json.j7
    public void c(IronSourceError error) {
        w5 w5Var = this.listener.get();
        if (w5Var != null) {
            String string = this.bannerAdProperties.getAdId().toString();
            Intrinsics.checkNotNullExpressionValue(string, "bannerAdProperties.adId.toString()");
            w5Var.a(new LevelPlayAdError(error, string, this.bannerAdProperties.getAdUnitId()));
        }
    }

    @Override // com.json.o6
    public /* bridge */ /* synthetic */ Unit d() {
        m();
        return Unit.INSTANCE;
    }

    @Override // com.json.j7
    public void d(IronSourceError error) {
        w5 w5Var = this.listener.get();
        if (w5Var != null) {
            LevelPlayAdInfo levelPlayAdInfo = this.currentAdInfo;
            String string = this.bannerAdProperties.getAdId().toString();
            Intrinsics.checkNotNullExpressionValue(string, "bannerAdProperties.adId.toString()");
            w5Var.a(levelPlayAdInfo, new LevelPlayAdError(error, string, this.bannerAdProperties.getAdUnitId()));
        }
    }

    @Override // com.json.o6
    public /* bridge */ /* synthetic */ Unit e() {
        o();
        return Unit.INSTANCE;
    }

    @Override // com.json.j7
    public void f() {
        this.currentAdInfo = this.nextAdInfo;
        this.nextAdInfo = j();
        w5 w5Var = this.listener.get();
        if (w5Var != null) {
            w5Var.c(this.currentAdInfo);
        }
    }

    @Override // com.json.o6
    public /* bridge */ /* synthetic */ Unit g() {
        n();
        return Unit.INSTANCE;
    }

    public final void k() {
        this.bannerStrategy.c();
    }

    public final void l() {
        this.bannerStrategy.f();
    }

    public void m() {
        w5 w5Var = this.listener.get();
        if (w5Var != null) {
            w5Var.g(this.currentAdInfo);
        }
    }

    public void n() {
        w5 w5Var = this.listener.get();
        if (w5Var != null) {
            w5Var.d(this.currentAdInfo);
        }
    }

    public void o() {
        w5 w5Var = this.listener.get();
        if (w5Var != null) {
            w5Var.a(this.currentAdInfo);
        }
    }

    public final void p() {
        this.bannerStrategy.g();
    }

    public final void q() {
        this.bannerStrategy.h();
    }
}
