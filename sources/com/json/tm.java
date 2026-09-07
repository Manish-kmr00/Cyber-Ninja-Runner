package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b&\u0010'J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\n\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\rJ\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\n\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/ironsource/tm;", "Lcom/ironsource/n;", "Lcom/ironsource/hn;", "Lcom/ironsource/m2;", "Lcom/ironsource/y1;", "Lcom/ironsource/o1;", "tools", "Lcom/ironsource/dn;", "adProperties", "Lcom/ironsource/fn;", "a", "Lcom/unity3d/mediation/LevelPlayAdInfo;", "i", "", CampaignEx.JSON_KEY_AD_K, "Lcom/ironsource/qm;", "nativeAdBinder", "j", "Lcom/ironsource/t1;", "adUnitCallback", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "Lcom/ironsource/wm;", "Lcom/ironsource/wm;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/ironsource/o1;", "adTools", "d", "Lcom/ironsource/dn;", "nativeAdProperties", "e", "Lcom/ironsource/fn;", "nativeAdUnit", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/unity3d/mediation/LevelPlayAdInfo;", "adInfo", "<init>", "(Lcom/ironsource/wm;Lcom/ironsource/o1;Lcom/ironsource/dn;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class tm extends n implements hn, m2, y1 {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final wm listener;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final o1 adTools;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final dn nativeAdProperties;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private fn nativeAdUnit;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private LevelPlayAdInfo adInfo;

    public tm(wm listener, o1 adTools, dn nativeAdProperties) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(nativeAdProperties, "nativeAdProperties");
        this.listener = listener;
        this.adTools = adTools;
        this.nativeAdProperties = nativeAdProperties;
        this.adInfo = i();
    }

    private final fn a(o1 tools, dn adProperties) {
        IronLog.INTERNAL.verbose();
        return new fn(tools, gn.INSTANCE.a(adProperties, getSdkConfigService().a()), this);
    }

    private final LevelPlayAdInfo i() {
        String string = this.nativeAdProperties.getAdId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "nativeAdProperties.adId.toString()");
        String adUnitId = this.nativeAdProperties.getAdUnitId();
        String string2 = this.nativeAdProperties.getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "nativeAdProperties.adFormat.toString()");
        return new LevelPlayAdInfo(string, adUnitId, string2, null, null, null, null, 120, null);
    }

    @Override // com.json.m2
    public void a(IronSourceError error) {
        this.listener.onNativeAdLoadFailed(error);
    }

    public final void a(qm nativeAdBinder) {
        Intrinsics.checkNotNullParameter(nativeAdBinder, "nativeAdBinder");
        fn fnVar = this.nativeAdUnit;
        if (fnVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeAdUnit");
            fnVar = null;
        }
        fnVar.a(new ym(nativeAdBinder), this);
    }

    @Override // com.json.y1
    public void b() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.json.y1
    public void b(IronSourceError error) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.json.k2
    public void c() {
        this.listener.f(this.adInfo);
    }

    @Override // com.json.m2
    public void c(t1 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        LevelPlayAdInfo levelPlayAdInfoC = adUnitCallback.c();
        if (levelPlayAdInfoC != null) {
            this.adInfo = levelPlayAdInfoC;
            this.listener.b(levelPlayAdInfoC);
        }
    }

    public final void j() {
        this.adInfo = i();
        fn fnVar = this.nativeAdUnit;
        if (fnVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeAdUnit");
            fnVar = null;
        }
        fnVar.a(true);
    }

    public final void k() {
        fn fnVarA = a(this.adTools, this.nativeAdProperties);
        this.nativeAdUnit = fnVarA;
        if (fnVarA == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeAdUnit");
            fnVarA = null;
        }
        fnVarA.a((m2) this);
    }
}
