package com.json;

import android.app.Activity;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/ironsource/yd;", "Lcom/ironsource/ae;", "Lcom/ironsource/n2;", "adUnitLoadStrategyListener", "", "a", "Landroid/app/Activity;", "activity", "Lcom/ironsource/z1;", "adUnitDisplayStrategyListener", "Lcom/unity3d/mediation/LevelPlayAdInfo;", "adInfo", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "Lcom/ironsource/ud;", "Lcom/ironsource/ud;", "strategy", "Lcom/ironsource/pd;", "Lcom/ironsource/pd;", "adUnit", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/n2;", "loadListener", "d", "Lcom/ironsource/z1;", "showListener", "<init>", "(Lcom/ironsource/ud;Lcom/ironsource/pd;Lcom/ironsource/n2;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class yd implements ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ud strategy;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final pd adUnit;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final n2 loadListener;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private z1 showListener;

    public yd(ud strategy, pd adUnit, n2 loadListener) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(loadListener, "loadListener");
        this.strategy = strategy;
        this.adUnit = adUnit;
        this.loadListener = loadListener;
    }

    @Override // com.json.ae
    public void a() {
        ud udVar = this.strategy;
        udVar.a(new vd(udVar, null, true));
        this.loadListener.a();
    }

    @Override // com.json.ae
    public void a(Activity activity, z1 adUnitDisplayStrategyListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adUnitDisplayStrategyListener, "adUnitDisplayStrategyListener");
        this.showListener = adUnitDisplayStrategyListener;
        this.adUnit.a(activity, this.strategy);
    }

    @Override // com.json.ae
    public void a(IronSourceError error) {
        this.strategy.a("load failed after ad unit is already loaded");
    }

    @Override // com.json.ae
    public void a(n2 adUnitLoadStrategyListener) {
        Intrinsics.checkNotNullParameter(adUnitLoadStrategyListener, "adUnitLoadStrategyListener");
        ud udVar = this.strategy;
        udVar.a(new vd(udVar, null, false, 4, null));
        this.strategy.a(adUnitLoadStrategyListener);
    }

    @Override // com.json.ae
    public void a(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.loadListener.onAdInfoChanged(adInfo);
    }

    @Override // com.json.ae
    public void b() {
        z1 z1Var = this.showListener;
        if (z1Var != null) {
            z1Var.b();
        }
        pd pdVarA = this.strategy.getFactory().a(false);
        ud udVar = this.strategy;
        udVar.a(new xd(udVar, this.adUnit, pdVarA));
        pdVarA.a(this.strategy);
    }

    @Override // com.json.ae
    public void b(IronSourceError error) {
        if (!cb.f3577a.a(error)) {
            ud udVar = this.strategy;
            udVar.a(new vd(udVar, null, false, 4, null));
        }
        z1 z1Var = this.showListener;
        if (z1Var != null) {
            z1Var.b(error);
        }
    }

    @Override // com.json.ae
    public void b(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.strategy.a("Ad unit is already loaded");
    }
}
