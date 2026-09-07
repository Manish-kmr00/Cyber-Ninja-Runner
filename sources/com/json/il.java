package com.json;

import android.app.Activity;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0017\u001a\u00020\n\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0015¨\u0006\""}, d2 = {"Lcom/ironsource/il;", "", "Lcom/ironsource/x1;", "a", "", "d", "Lcom/unity3d/mediation/interstitial/LevelPlayInterstitialAdListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/app/Activity;", "activity", "", "placementName", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/xf;", "Lcom/ironsource/xf;", IronSourceConstants.EVENTS_PROVIDER, "Lcom/ironsource/gl;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/gl;", "fullScreenAdInternal", "()Ljava/lang/String;", "adId", "adUnitId", "Lcom/ironsource/o1;", "adTools", "Lcom/ironsource/ed;", "adControllerFactory", "Lcom/ironsource/q9;", "currentTimeProvider", "Lcom/ironsource/lf;", "idFactory", "<init>", "(Ljava/lang/String;Lcom/ironsource/o1;Lcom/ironsource/ed;Lcom/ironsource/xf;Lcom/ironsource/q9;Lcom/ironsource/lf;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class il {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final xf provider;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final gl fullScreenAdInternal;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/ironsource/il$a", "Lcom/ironsource/x1;", "", "isPublisherLoad", "Lcom/ironsource/f1;", "adProperties", "Lcom/ironsource/w1;", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements x1 {
        a() {
        }

        @Override // com.json.x1
        public w1 a(boolean isPublisherLoad, f1 adProperties) {
            Intrinsics.checkNotNullParameter(adProperties, "adProperties");
            return kj.INSTANCE.a(adProperties, il.this.provider.t().a(), isPublisherLoad);
        }
    }

    public il(String adUnitId, o1 adTools, ed adControllerFactory, xf provider, q9 currentTimeProvider, lf idFactory) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adControllerFactory, "adControllerFactory");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        Intrinsics.checkNotNullParameter(idFactory, "idFactory");
        this.provider = provider;
        this.fullScreenAdInternal = new gl(LevelPlay.AdFormat.INTERSTITIAL, adUnitId, adTools, adControllerFactory, a(), provider, currentTimeProvider, idFactory);
    }

    private final x1 a() {
        return new a();
    }

    public final void a(Activity activity, String placementName) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.fullScreenAdInternal.a(activity, placementName);
    }

    public final void a(LevelPlayInterstitialAdListener listener) {
        this.fullScreenAdInternal.a(listener != null ? jl.b(listener) : null);
    }

    public final String b() {
        String string = this.fullScreenAdInternal.getAdId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "fullScreenAdInternal.adId.toString()");
        return string;
    }

    public final boolean c() {
        return this.fullScreenAdInternal.l();
    }

    public final void d() {
        this.fullScreenAdInternal.m();
    }
}
