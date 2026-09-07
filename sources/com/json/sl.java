package com.json;

import android.app.Activity;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/ironsource/sl;", "", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Landroid/app/Activity;", "activity", "", "placementName", "a", "Lcom/unity3d/mediation/rewarded/LevelPlayRewardedAdListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/gl;", "Lcom/ironsource/gl;", "fullScreenAdInternal", "()Ljava/lang/String;", "adId", "adUnitId", "Lcom/ironsource/o1;", "adTools", "Lcom/ironsource/ed;", "adControllerFactory", "Lcom/ironsource/xf;", IronSourceConstants.EVENTS_PROVIDER, "Lcom/ironsource/q9;", "currentTimeProvider", "Lcom/ironsource/lf;", "idFactory", "<init>", "(Ljava/lang/String;Lcom/ironsource/o1;Lcom/ironsource/ed;Lcom/ironsource/xf;Lcom/ironsource/q9;Lcom/ironsource/lf;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class sl {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final gl fullScreenAdInternal;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/ironsource/sl$a", "Lcom/ironsource/x1;", "", "isPublisherLoad", "Lcom/ironsource/f1;", "adProperties", "Lcom/ironsource/w1;", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements x1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ xf f4426a;

        a(xf xfVar) {
            this.f4426a = xfVar;
        }

        @Override // com.json.x1
        public w1 a(boolean isPublisherLoad, f1 adProperties) {
            Intrinsics.checkNotNullParameter(adProperties, "adProperties");
            return sq.INSTANCE.a(adProperties, this.f4426a.t().a(), isPublisherLoad);
        }
    }

    public sl(String adUnitId, o1 adTools, ed adControllerFactory, xf provider, q9 currentTimeProvider, lf idFactory) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adControllerFactory, "adControllerFactory");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        Intrinsics.checkNotNullParameter(idFactory, "idFactory");
        this.fullScreenAdInternal = new gl(LevelPlay.AdFormat.REWARDED, adUnitId, adTools, adControllerFactory, new a(provider), provider, currentTimeProvider, idFactory);
    }

    public final String a() {
        String string = this.fullScreenAdInternal.getAdId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "fullScreenAdInternal.adId.toString()");
        return string;
    }

    public final void a(Activity activity, String placementName) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.fullScreenAdInternal.a(activity, placementName);
    }

    public final void a(LevelPlayRewardedAdListener listener) {
        this.fullScreenAdInternal.a(listener != null ? tl.b(listener) : null);
    }

    public final boolean b() {
        return this.fullScreenAdInternal.l();
    }

    public final void c() {
        this.fullScreenAdInternal.m();
    }
}
