package com.json;

import android.app.Activity;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/ironsource/vd;", "Lcom/ironsource/ae;", "Lcom/ironsource/n2;", "adUnitLoadStrategyListener", "", "a", "Landroid/app/Activity;", "activity", "Lcom/ironsource/z1;", "adUnitDisplayStrategyListener", "Lcom/unity3d/mediation/LevelPlayAdInfo;", "adInfo", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "Lcom/ironsource/ud;", "Lcom/ironsource/ud;", "strategy", "Lcom/ironsource/pd;", "Lcom/ironsource/pd;", "currentAdUnit", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Z", "isExpired", "<init>", "(Lcom/ironsource/ud;Lcom/ironsource/pd;Z)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class vd implements ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ud strategy;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final pd currentAdUnit;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final boolean isExpired;

    public vd(ud strategy, pd pdVar, boolean z) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.strategy = strategy;
        this.currentAdUnit = pdVar;
        this.isExpired = z;
    }

    public /* synthetic */ vd(ud udVar, pd pdVar, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(udVar, pdVar, (i & 4) != 0 ? false : z);
    }

    @Override // com.json.ae
    public void a() {
        this.strategy.a(this.isExpired ? "ad expired on expired ad" : "ad expired before load called");
    }

    @Override // com.json.ae
    public void a(Activity activity, z1 adUnitDisplayStrategyListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adUnitDisplayStrategyListener, "adUnitDisplayStrategyListener");
        adUnitDisplayStrategyListener.b(new IronSourceError(LevelPlayAdError.ERROR_CODE_SHOW_BEFORE_LOAD_SUCCESS_CALLBACK, this.isExpired ? "Show called on expired ad" : "Show called before load success"));
    }

    @Override // com.json.ae
    public void a(IronSourceError error) {
        this.strategy.a(this.isExpired ? "load failed on expired ad" : "load failed before load called");
    }

    @Override // com.json.ae
    public void a(n2 adUnitLoadStrategyListener) {
        Intrinsics.checkNotNullParameter(adUnitLoadStrategyListener, "adUnitLoadStrategyListener");
        pd pdVarA = this.strategy.getFactory().a(true);
        ud udVar = this.strategy;
        udVar.a(new zd(udVar, pdVarA, adUnitLoadStrategyListener));
        pdVarA.a(this.strategy);
    }

    @Override // com.json.ae
    public void a(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.strategy.a(this.isExpired ? "load with better ad on expired ad" : "load success with better ad before load success");
    }

    @Override // com.json.ae
    public void b() {
        this.strategy.a(this.isExpired ? "show success on expired ad" : "show success before load called");
    }

    @Override // com.json.ae
    public void b(IronSourceError error) {
        this.strategy.a(this.isExpired ? "show failed on expired ad" : "show failed before load called");
    }

    @Override // com.json.ae
    public void b(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.strategy.a(this.isExpired ? "load success on expired ad" : "load success before load called");
    }
}
