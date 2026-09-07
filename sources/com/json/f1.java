package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.json.mediationsdk.model.Placement;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.mediation.LevelPlay;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0005\u0010\u0017R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/ironsource/f1;", "", "Lcom/unity3d/mediation/LevelPlay$AdFormat;", "d", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "a", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "()Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "Ljava/util/UUID;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/util/UUID;", "()Ljava/util/UUID;", "adId", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/lang/String;", "()Ljava/lang/String;", "adUnitId", "Lcom/ironsource/mediationsdk/model/Placement;", "Lcom/ironsource/mediationsdk/model/Placement;", "e", "()Lcom/ironsource/mediationsdk/model/Placement;", "(Lcom/ironsource/mediationsdk/model/Placement;)V", "placement", "Lcom/ironsource/eu;", "Lcom/ironsource/eu;", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/ironsource/eu;", "testSuiteLoadAdConfig", "<init>", "(Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;Ljava/util/UUID;Ljava/lang/String;Lcom/ironsource/mediationsdk/model/Placement;Lcom/ironsource/eu;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final IronSource.AD_UNIT adFormat;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final UUID adId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String adUnitId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private Placement placement;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final eu testSuiteLoadAdConfig;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3683a;

        static {
            int[] iArr = new int[IronSource.AD_UNIT.values().length];
            try {
                iArr[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IronSource.AD_UNIT.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IronSource.AD_UNIT.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f3683a = iArr;
        }
    }

    public f1(IronSource.AD_UNIT adFormat, UUID adId, String adUnitId, Placement placement, eu euVar) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        this.adFormat = adFormat;
        this.adId = adId;
        this.adUnitId = adUnitId;
        this.placement = placement;
        this.testSuiteLoadAdConfig = euVar;
    }

    public /* synthetic */ f1(IronSource.AD_UNIT ad_unit, UUID uuid, String str, Placement placement, eu euVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ad_unit, uuid, str, (i & 8) != 0 ? null : placement, (i & 16) != 0 ? null : euVar);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final IronSource.AD_UNIT getAdFormat() {
        return this.adFormat;
    }

    public final void a(Placement placement) {
        this.placement = placement;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final UUID getAdId() {
        return this.adId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getAdUnitId() {
        return this.adUnitId;
    }

    public final LevelPlay.AdFormat d() {
        int i = a.f3683a[this.adFormat.ordinal()];
        if (i == 1) {
            return LevelPlay.AdFormat.REWARDED;
        }
        if (i == 2) {
            return LevelPlay.AdFormat.INTERSTITIAL;
        }
        if (i == 3) {
            return LevelPlay.AdFormat.BANNER;
        }
        if (i == 4) {
            return LevelPlay.AdFormat.NATIVE_AD;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final Placement getPlacement() {
        return this.placement;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final eu getTestSuiteLoadAdConfig() {
        return this.testSuiteLoadAdConfig;
    }
}
