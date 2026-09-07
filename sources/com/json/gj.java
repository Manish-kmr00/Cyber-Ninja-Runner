package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.sdk.utils.SDKUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.ironsourceads.interstitial.InterstitialAdLoaderListener;
import com.unity3d.ironsourceads.interstitial.InterstitialAdRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/ironsource/gj;", "Lcom/ironsource/em;", "Lcom/ironsource/bm;", "a", "Lcom/unity3d/ironsourceads/interstitial/InterstitialAdRequest;", "Lcom/unity3d/ironsourceads/interstitial/InterstitialAdRequest;", "adRequest", "Lcom/unity3d/ironsourceads/interstitial/InterstitialAdLoaderListener;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/unity3d/ironsourceads/interstitial/InterstitialAdLoaderListener;", "publisherListener", "Lcom/ironsource/e3;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/e3;", "adapterConfigProvider", "Lcom/ironsource/p3;", "d", "Lcom/ironsource/p3;", "analyticsFactory", "<init>", "(Lcom/unity3d/ironsourceads/interstitial/InterstitialAdRequest;Lcom/unity3d/ironsourceads/interstitial/InterstitialAdLoaderListener;Lcom/ironsource/e3;Lcom/ironsource/p3;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class gj implements em {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final InterstitialAdRequest adRequest;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final InterstitialAdLoaderListener publisherListener;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final e3 adapterConfigProvider;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final p3 analyticsFactory;

    public gj(InterstitialAdRequest adRequest, InterstitialAdLoaderListener publisherListener, e3 adapterConfigProvider, p3 analyticsFactory) {
        Intrinsics.checkNotNullParameter(adRequest, "adRequest");
        Intrinsics.checkNotNullParameter(publisherListener, "publisherListener");
        Intrinsics.checkNotNullParameter(adapterConfigProvider, "adapterConfigProvider");
        Intrinsics.checkNotNullParameter(analyticsFactory, "analyticsFactory");
        this.adRequest = adRequest;
        this.publisherListener = publisherListener;
        this.adapterConfigProvider = adapterConfigProvider;
        this.analyticsFactory = analyticsFactory;
    }

    public /* synthetic */ gj(InterstitialAdRequest interstitialAdRequest, InterstitialAdLoaderListener interstitialAdLoaderListener, e3 e3Var, p3 p3Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interstitialAdRequest, interstitialAdLoaderListener, e3Var, (i & 8) != 0 ? new o3(IronSource.AD_UNIT.INTERSTITIAL) : p3Var);
    }

    @Override // com.json.em
    public bm a() throws Exception {
        IronSourceError ironSourceErrorB;
        String instanceId = this.adRequest.getInstanceId();
        String sDKVersion = SDKUtils.getSDKVersion();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
        Intrinsics.checkNotNullExpressionValue(sDKVersion, "getSDKVersion()");
        q3 q3VarA = this.analyticsFactory.a(new k3(sDKVersion, instanceId, ad_unit, false, false, false, 56, null));
        try {
            cm cmVarA = new dm(this.adRequest.getAdm(), this.adRequest.getProviderName(), this.adapterConfigProvider, kn.INSTANCE.a().getInitialized().get()).a();
            new ej(cmVarA).a();
            wn wnVar = new wn();
            k5 k5Var = new k5(this.adRequest.getAdm(), this.adRequest.getProviderName());
            InterstitialAdRequest interstitialAdRequest = this.adRequest;
            Intrinsics.checkNotNull(cmVarA);
            hg hgVar = hg.f3748a;
            return new dj(interstitialAdRequest, cmVarA, new fj(hgVar, this.publisherListener), k5Var, wnVar, q3VarA, new zi(q3VarA, hgVar.c()), null, null, 384, null);
        } catch (Exception e) {
            o9.d().a(e);
            if (e instanceof or) {
                ironSourceErrorB = ((or) e).getError();
            } else {
                wb wbVar = wb.f4558a;
                String message = e.getMessage();
                if (message == null) {
                    message = "unknown error";
                }
                ironSourceErrorB = wbVar.b(message);
            }
            return new xb(this.adRequest, new fj(hg.f3748a, this.publisherListener), q3VarA, ironSourceErrorB);
        }
    }
}
