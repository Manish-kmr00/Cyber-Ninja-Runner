package com.json;

import android.app.Activity;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u001c2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0007B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\u0006\u0010\u001e\u001a\u00020\u001a¢\u0006\u0004\b \u0010!J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\u0019\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001f¨\u0006\""}, d2 = {"Lcom/ironsource/ud;", "Lcom/ironsource/td;", "Lcom/ironsource/pd$a;", "Lcom/ironsource/y1;", "Lcom/ironsource/n2;", "adUnitLoadStrategyListener", "", "a", "Landroid/app/Activity;", "activity", "Lcom/ironsource/z1;", "adUnitDisplayStrategyListener", "Lcom/ironsource/ae;", "state", "", "message", "Lcom/unity3d/mediation/LevelPlayAdInfo;", "adInfo", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "Lcom/ironsource/o1;", "Lcom/ironsource/o1;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Lcom/ironsource/o1;", "adTools", "Lcom/ironsource/qd;", "Lcom/ironsource/qd;", "d", "()Lcom/ironsource/qd;", "factory", "Lcom/ironsource/ae;", "<init>", "(Lcom/ironsource/o1;Lcom/ironsource/qd;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class ud implements td, pd.a, y1 {
    public static final String e = "Fullscreen Progressive Strategy";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final o1 adTools;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final qd factory;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private ae state;

    public ud(o1 adTools, qd factory) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.adTools = adTools;
        this.factory = factory;
        this.state = new vd(this, null, false, 4, null);
    }

    @Override // com.ironsource.pd.a
    public void a() {
        this.state.a();
    }

    @Override // com.json.td
    public void a(Activity activity, z1 adUnitDisplayStrategyListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adUnitDisplayStrategyListener, "adUnitDisplayStrategyListener");
        this.state.a(activity, adUnitDisplayStrategyListener);
    }

    public final void a(ae state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
    }

    @Override // com.ironsource.pd.a
    public void a(IronSourceError error) {
        this.state.a(error);
    }

    @Override // com.json.td
    public void a(n2 adUnitLoadStrategyListener) {
        Intrinsics.checkNotNullParameter(adUnitLoadStrategyListener, "adUnitLoadStrategyListener");
        this.state.a(adUnitLoadStrategyListener);
    }

    @Override // com.ironsource.pd.a
    public void a(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.state.a(adInfo);
    }

    public final void a(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.adTools.getEventSender().getTroubleshoot().f("Fullscreen Progressive Strategy - " + message);
    }

    @Override // com.json.y1
    public void b() {
        this.state.b();
    }

    @Override // com.json.y1
    public void b(IronSourceError error) {
        this.state.b(error);
    }

    @Override // com.ironsource.pd.a
    public void b(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.state.b(adInfo);
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final o1 getAdTools() {
        return this.adTools;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final qd getFactory() {
        return this.factory;
    }
}
