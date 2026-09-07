package com.json;

import android.app.Activity;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001b¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0017\u0010\u0015\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u001fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/ironsource/be;", "Lcom/ironsource/td;", "Lcom/ironsource/pd$a;", "Lcom/ironsource/y1;", "Lcom/ironsource/n2;", "adUnitLoadStrategyListener", "", "a", "Landroid/app/Activity;", "activity", "Lcom/ironsource/z1;", "adUnitDisplayStrategyListener", "Lcom/unity3d/mediation/LevelPlayAdInfo;", "adInfo", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "Lcom/ironsource/o1;", "Lcom/ironsource/o1;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/ironsource/o1;", "adTools", "Lcom/ironsource/td$a;", "Lcom/ironsource/td$a;", "d", "()Lcom/ironsource/td$a;", DTBMetricsConfiguration.CONFIG_DIR, "Lcom/ironsource/qd;", "Lcom/ironsource/qd;", "fullscreenAdUnitFactory", "Lcom/ironsource/pd;", "Lcom/ironsource/pd;", "fullscreenAdUnit", "e", "Lcom/ironsource/z1;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/ironsource/n2;", "<init>", "(Lcom/ironsource/o1;Lcom/ironsource/td$a;Lcom/ironsource/qd;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class be implements td, pd.a, y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final o1 adTools;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final td.a config;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final qd fullscreenAdUnitFactory;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private pd fullscreenAdUnit;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private z1 adUnitDisplayStrategyListener;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private n2 adUnitLoadStrategyListener;

    public be(o1 adTools, td.a config, qd fullscreenAdUnitFactory) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(fullscreenAdUnitFactory, "fullscreenAdUnitFactory");
        this.adTools = adTools;
        this.config = config;
        this.fullscreenAdUnitFactory = fullscreenAdUnitFactory;
    }

    @Override // com.ironsource.pd.a
    public void a() {
        this.fullscreenAdUnit = null;
        n2 n2Var = this.adUnitLoadStrategyListener;
        if (n2Var != null) {
            n2Var.a();
        }
    }

    @Override // com.json.td
    public void a(Activity activity, z1 adUnitDisplayStrategyListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adUnitDisplayStrategyListener, "adUnitDisplayStrategyListener");
        this.adUnitDisplayStrategyListener = adUnitDisplayStrategyListener;
        pd pdVar = this.fullscreenAdUnit;
        if (pdVar != null) {
            pdVar.a(activity, this);
        }
    }

    @Override // com.ironsource.pd.a
    public void a(IronSourceError error) {
        n2 n2Var = this.adUnitLoadStrategyListener;
        if (n2Var != null) {
            n2Var.a(error);
        }
    }

    @Override // com.json.td
    public void a(n2 adUnitLoadStrategyListener) {
        Intrinsics.checkNotNullParameter(adUnitLoadStrategyListener, "adUnitLoadStrategyListener");
        this.adUnitLoadStrategyListener = adUnitLoadStrategyListener;
        pd pdVarA = this.fullscreenAdUnitFactory.a(true);
        pdVarA.a(this);
        this.fullscreenAdUnit = pdVarA;
    }

    @Override // com.ironsource.pd.a
    public void a(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        n2 n2Var = this.adUnitLoadStrategyListener;
        if (n2Var != null) {
            n2Var.onAdInfoChanged(adInfo);
        }
    }

    @Override // com.json.y1
    public void b() {
        z1 z1Var = this.adUnitDisplayStrategyListener;
        if (z1Var != null) {
            z1Var.b();
        }
    }

    @Override // com.json.y1
    public void b(IronSourceError error) {
        z1 z1Var = this.adUnitDisplayStrategyListener;
        if (z1Var != null) {
            z1Var.b(error);
        }
    }

    @Override // com.ironsource.pd.a
    public void b(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        n2 n2Var = this.adUnitLoadStrategyListener;
        if (n2Var != null) {
            n2Var.a(adInfo);
        }
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final o1 getAdTools() {
        return this.adTools;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final td.a getConfig() {
        return this.config;
    }
}
