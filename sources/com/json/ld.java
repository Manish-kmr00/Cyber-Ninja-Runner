package com.json;

import android.app.Activity;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.model.Placement;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/ironsource/ld;", "Lcom/ironsource/od;", "", "d", "", "loadAd", "Landroid/app/Activity;", "activity", "", "placementName", "a", "Lcom/ironsource/j1;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/unity3d/mediation/LevelPlayAdInfo;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "adInfo", "onAdInfoChanged", "Lcom/ironsource/gl;", "Lcom/ironsource/gl;", "adInternal", "Lcom/unity3d/mediation/LevelPlayAdInfo;", "Lcom/ironsource/q9;", "Lcom/ironsource/q9;", "currentTimeProvider", "J", "loadSuccessTimestamp", "<init>", "(Lcom/ironsource/gl;Lcom/unity3d/mediation/LevelPlayAdInfo;Lcom/ironsource/q9;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class ld implements od {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final gl adInternal;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private LevelPlayAdInfo adInfo;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final q9 currentTimeProvider;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final long loadSuccessTimestamp;

    public ld(gl adInternal, LevelPlayAdInfo adInfo, q9 currentTimeProvider) {
        Intrinsics.checkNotNullParameter(adInternal, "adInternal");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        this.adInternal = adInternal;
        this.adInfo = adInfo;
        this.currentTimeProvider = currentTimeProvider;
        this.loadSuccessTimestamp = currentTimeProvider.a();
    }

    private final long d() {
        return this.currentTimeProvider.a() - this.loadSuccessTimestamp;
    }

    @Override // com.json.od
    public void a() {
        gl glVar = this.adInternal;
        glVar.a(new hd(glVar, true));
    }

    @Override // com.json.od
    public void a(Activity activity, String placementName) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Placement placementA = this.adInternal.getAdTools().a(this.adInternal.getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String(), placementName);
        dd ddVarC = this.adInternal.getAdController();
        if (ddVarC == null) {
            gl glVar = this.adInternal;
            String string = this.adInternal.getAdId().toString();
            Intrinsics.checkNotNullExpressionValue(string, "adInternal.adId.toString()");
            glVar.b(new LevelPlayAdError(string, this.adInternal.getAdUnitId(), IronSourceError.ERROR_IS_SHOW_EXCEPTION, "Internal Error, Illegal state"), this.adInfo);
            return;
        }
        LevelPlayAdInfo levelPlayAdInfo = new LevelPlayAdInfo(this.adInfo, placementName);
        this.adInfo = levelPlayAdInfo;
        gl glVar2 = this.adInternal;
        glVar2.a(new nd(glVar2, levelPlayAdInfo));
        ddVarC.a(activity, placementA);
    }

    @Override // com.json.od
    /* JADX INFO: renamed from: b, reason: from getter */
    public LevelPlayAdInfo getAdInfo() {
        return this.adInfo;
    }

    @Override // com.json.od
    public j1 c() {
        l8 l8VarA = this.adInternal.getMediationServicesProvider().u().a(this.adInternal.getAdUnitId());
        return l8VarA.d() ? j1.a.INSTANCE.a(l8VarA.e()) : j1.b.f3794a;
    }

    @Override // com.json.od
    public void loadAd() {
        this.adInternal.getAdTools().getEventSender().getTroubleshoot().a(Long.valueOf(d()));
        this.adInternal.a(this.adInfo);
    }

    @Override // com.json.od
    public void onAdInfoChanged(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.adInfo = adInfo;
    }
}
