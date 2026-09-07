package com.json;

import android.app.Activity;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/ironsource/wd;", "Lcom/ironsource/ae;", "Lcom/ironsource/n2;", "adUnitLoadStrategyListener", "", "a", "Landroid/app/Activity;", "activity", "Lcom/ironsource/z1;", "adUnitDisplayStrategyListener", "Lcom/unity3d/mediation/LevelPlayAdInfo;", "adInfo", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "Lcom/ironsource/ud;", "Lcom/ironsource/ud;", "strategy", "Lcom/ironsource/pd;", "Lcom/ironsource/pd;", "currentAdUnit", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "progressiveAdUnit", "d", "Lcom/unity3d/mediation/LevelPlayAdInfo;", "<init>", "(Lcom/ironsource/ud;Lcom/ironsource/pd;Lcom/ironsource/pd;Lcom/unity3d/mediation/LevelPlayAdInfo;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class wd implements ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ud strategy;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final pd currentAdUnit;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final pd progressiveAdUnit;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private LevelPlayAdInfo adInfo;

    public wd(ud strategy, pd currentAdUnit, pd progressiveAdUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(currentAdUnit, "currentAdUnit");
        Intrinsics.checkNotNullParameter(progressiveAdUnit, "progressiveAdUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.strategy = strategy;
        this.currentAdUnit = currentAdUnit;
        this.progressiveAdUnit = progressiveAdUnit;
        this.adInfo = adInfo;
    }

    @Override // com.json.ae
    public void a() {
        ud udVar = this.strategy;
        udVar.a(new vd(udVar, this.currentAdUnit, true));
    }

    @Override // com.json.ae
    public void a(Activity activity, z1 adUnitDisplayStrategyListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adUnitDisplayStrategyListener, "adUnitDisplayStrategyListener");
        adUnitDisplayStrategyListener.b(new IronSourceError(LevelPlayAdError.ERROR_CODE_SHOW_BEFORE_LOAD_SUCCESS_CALLBACK, "Show called before load success"));
    }

    @Override // com.json.ae
    public void a(IronSourceError error) {
        this.strategy.a("load failed on progressive ad unit that already loaded");
    }

    @Override // com.json.ae
    public void a(n2 adUnitLoadStrategyListener) {
        Intrinsics.checkNotNullParameter(adUnitLoadStrategyListener, "adUnitLoadStrategyListener");
        adUnitLoadStrategyListener.a(this.adInfo);
        ud udVar = this.strategy;
        udVar.a(new yd(udVar, this.progressiveAdUnit, adUnitLoadStrategyListener));
    }

    @Override // com.json.ae
    public void a(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.adInfo = adInfo;
    }

    @Override // com.json.ae
    public void b() {
        this.strategy.a("show success on progressive ad unit that already loaded");
    }

    @Override // com.json.ae
    public void b(IronSourceError error) {
        this.strategy.a("show failed on progressive ad unit that already loaded");
    }

    @Override // com.json.ae
    public void b(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.strategy.a("load success on progressive ad unit is already loaded");
    }
}
