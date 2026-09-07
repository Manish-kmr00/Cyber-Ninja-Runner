package com.json;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.model.Placement;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.unity3d.mediation.LevelPlayAdSize;
import com.vungle.ads.internal.protos.Sdk;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bB\t\b\u0010¢\u0006\u0004\b\u001a\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/ironsource/j6;", "Lcom/ironsource/f1;", "Lcom/unity3d/mediation/LevelPlayAdSize;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/unity3d/mediation/LevelPlayAdSize;", "g", "()Lcom/unity3d/mediation/LevelPlayAdSize;", "adSize", "", "Ljava/lang/Boolean;", "h", "()Ljava/lang/Boolean;", "autoRefresh", "", "Ljava/lang/Long;", "i", "()Ljava/lang/Long;", POBConstants.KEY_REFRESH_INTERVAL, "Ljava/util/UUID;", "adId", "", "adUnitId", "Lcom/ironsource/mediationsdk/model/Placement;", "placement", "Lcom/ironsource/eu;", "testSuiteLoadAdConfig", "<init>", "(Ljava/util/UUID;Ljava/lang/String;Lcom/ironsource/mediationsdk/model/Placement;Lcom/unity3d/mediation/LevelPlayAdSize;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/ironsource/eu;)V", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class j6 extends f1 {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final LevelPlayAdSize adSize;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final Boolean autoRefresh;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Long refreshInterval;

    public j6() {
        this(lf.f3858a.a(), "", null, null, null, null, null, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j6(UUID adId, String adUnitId, Placement placement, LevelPlayAdSize adSize, Boolean bool, Long l, eu euVar) {
        super(IronSource.AD_UNIT.BANNER, adId, adUnitId, placement, euVar);
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        this.adSize = adSize;
        this.autoRefresh = bool;
        this.refreshInterval = l;
    }

    public /* synthetic */ j6(UUID uuid, String str, Placement placement, LevelPlayAdSize levelPlayAdSize, Boolean bool, Long l, eu euVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uuid, str, (i & 4) != 0 ? null : placement, (i & 8) != 0 ? LevelPlayAdSize.BANNER : levelPlayAdSize, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : l, (i & 64) != 0 ? null : euVar);
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final LevelPlayAdSize getAdSize() {
        return this.adSize;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final Boolean getAutoRefresh() {
        return this.autoRefresh;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final Long getRefreshInterval() {
        return this.refreshInterval;
    }
}
