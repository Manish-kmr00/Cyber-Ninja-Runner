package com.json;

import android.app.Activity;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/ironsource/hd;", "Lcom/ironsource/od;", "", "e", "Lcom/ironsource/dd;", "d", "", "loadAd", "Landroid/app/Activity;", "activity", "", "placementName", "a", "Lcom/ironsource/j1;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/unity3d/mediation/LevelPlayAdInfo;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/gl;", "Lcom/ironsource/gl;", "adInternal", "Z", "isExpired", "Lcom/unity3d/mediation/LevelPlayAdInfo;", "adInfo", "Lcom/ironsource/fi;", "Lcom/ironsource/fi;", "testSuiteLoadConfigService", "<init>", "(Lcom/ironsource/gl;Z)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class hd implements od {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final gl adInternal;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final boolean isExpired;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final LevelPlayAdInfo adInfo;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final fi testSuiteLoadConfigService;

    public hd(gl adInternal, boolean z) {
        Intrinsics.checkNotNullParameter(adInternal, "adInternal");
        this.adInternal = adInternal;
        this.isExpired = z;
        String string = adInternal.getAdId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "adInternal.adId.toString()");
        this.adInfo = new LevelPlayAdInfo(string, adInternal.getAdUnitId(), adInternal.getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String().toString(), null, null, null, null, 120, null);
        this.testSuiteLoadConfigService = adInternal.getMediationServicesProvider().o();
    }

    public /* synthetic */ hd(gl glVar, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(glVar, (i & 2) != 0 ? false : z);
    }

    private final dd d() {
        dd ddVarC = this.adInternal.getAdController();
        if (ddVarC != null) {
            return ddVarC;
        }
        f1 f1Var = new f1(a.a(this.adInternal.getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String()), this.adInternal.getAdId(), this.adInternal.getAdUnitId(), null, this.testSuiteLoadConfigService.getTestSuiteLoadAdConfigInternal(), 8, null);
        this.adInternal.getAdTools().getEventSender().a(new c2(this.adInternal.getAdTools(), f1Var, this.adInternal.getAdTools().b(this.adInternal.getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String(), this.adInternal.getAdUnitId()).b().getDescription()));
        ed edVarI = this.adInternal.getFullscreenAdControllerFactory();
        gl glVar = this.adInternal;
        return edVarI.a(glVar, glVar.getAdTools(), f1Var, this.adInternal.getAdUnitDataFactory());
    }

    private final boolean e() {
        if (this.adInternal.getAdUnitId().length() == 0) {
            gl glVar = this.adInternal;
            String string = this.adInternal.getAdId().toString();
            Intrinsics.checkNotNullExpressionValue(string, "adInternal.adId.toString()");
            glVar.onAdLoadFailed(new LevelPlayAdError(string, this.adInternal.getAdUnitId(), LevelPlayAdError.ERROR_CODE_NO_AD_UNIT_ID_SPECIFIED, "Ad unit ID should be specified"));
            return false;
        }
        if (!this.adInternal.getAdTools().g()) {
            gl glVar2 = this.adInternal;
            String string2 = this.adInternal.getAdId().toString();
            Intrinsics.checkNotNullExpressionValue(string2, "adInternal.adId.toString()");
            glVar2.onAdLoadFailed(new LevelPlayAdError(string2, this.adInternal.getAdUnitId(), LevelPlayAdError.ERROR_CODE_LOAD_BEFORE_INIT_SUCCESS_CALLBACK, "Load must be called after init success callback"));
            return false;
        }
        el elVarA = this.adInternal.getMediationServicesProvider().t().a();
        if (elVarA != null && elVarA.a(this.adInternal.getAdUnitId(), this.adInternal.getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String())) {
            return true;
        }
        gl glVar3 = this.adInternal;
        String string3 = this.adInternal.getAdId().toString();
        Intrinsics.checkNotNullExpressionValue(string3, "adInternal.adId.toString()");
        glVar3.b(new LevelPlayAdError(string3, this.adInternal.getAdUnitId(), LevelPlayAdError.ERROR_CODE_INVALID_AD_UNIT_ID, "Invalid ad unit id"));
        return false;
    }

    @Override // com.json.od
    public void a(Activity activity, String placementName) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String str = this.isExpired ? "Show called on expired ad" : "Show called before load success";
        String string = this.adInternal.getAdId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "adInternal.adId.toString()");
        this.adInternal.a(new LevelPlayAdError(string, this.adInternal.getAdUnitId(), LevelPlayAdError.ERROR_CODE_SHOW_BEFORE_LOAD_SUCCESS_CALLBACK, str));
    }

    @Override // com.json.od
    /* JADX INFO: renamed from: b, reason: from getter */
    public LevelPlayAdInfo getAdInfo() {
        return this.adInfo;
    }

    @Override // com.json.od
    public j1 c() {
        return new j1.a(this.isExpired ? "ad is invalid due to loading time" : "load ad was not called");
    }

    @Override // com.json.od
    public void loadAd() {
        if (e()) {
            this.adInternal.a(d());
            this.adInternal.n();
        }
    }
}
