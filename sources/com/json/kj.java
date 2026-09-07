package com.json;

import androidx.exifinterface.media.ExifInterface;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0018\b\u0086\b\u0018\u0000 \r2\u00020\u0001:\u0001\u0012B'\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\r\u001a\u00020\fHÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\fHÆ\u0001J\t\u0010\u0014\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003R\u001a\u0010\u000e\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0005\u0010\u001cR\u001a\u0010\u000f\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001fR\u0017\u0010\u0010\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010*\u001a\u00020\u00138\u0016X\u0096D¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010,\u001a\u00020\u00138\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010'\u001a\u0004\b+\u0010)¨\u0006/"}, d2 = {"Lcom/ironsource/kj;", "Lcom/ironsource/w1;", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", tr.b, "Lorg/json/JSONObject;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/f1;", "w", "", VastAttributes.HORIZONTAL_POSITION, "Lcom/ironsource/v1;", VastAttributes.VERTICAL_POSITION, "Lcom/ironsource/mj;", "z", "adProperties", "isPublisherLoad", "adUnitCommonData", ug.p, "a", "", "toString", "", "hashCode", "", "other", "equals", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "Lcom/ironsource/f1;", "()Lcom/ironsource/f1;", ApsMetricsDataMap.APSMETRICS_FIELD_URL, "Z", "()Z", "v", "Lcom/ironsource/v1;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/ironsource/v1;", "Lcom/ironsource/mj;", "B", "()Lcom/ironsource/mj;", "Ljava/lang/String;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Ljava/lang/String;", "adUnitPrefix", "j", "managerName", "<init>", "(Lcom/ironsource/f1;ZLcom/ironsource/v1;Lcom/ironsource/mj;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class kj extends w1 {

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private final f1 adProperties;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    private final boolean isPublisherLoad;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    private final v1 adUnitCommonData;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    private final mj configs;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    private final String adUnitPrefix;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    private final String managerName;

    /* JADX INFO: renamed from: com.ironsource.kj$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/ironsource/kj$a;", "", "Lcom/ironsource/f1;", "adProperties", "Lcom/ironsource/el;", "levelPlayConfig", "", "isPublisherLoad", "Lcom/ironsource/kj;", "a", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final kj a(f1 adProperties, el levelPlayConfig, boolean isPublisherLoad) {
            List<zn> listEmptyList;
            ls lsVarD;
            Intrinsics.checkNotNullParameter(adProperties, "adProperties");
            w1.Companion companion = w1.INSTANCE;
            s8 s8VarC = (levelPlayConfig == null || (lsVarD = levelPlayConfig.d()) == null) ? null : lsVarD.c();
            mj interstitialConfigurations = s8VarC != null ? s8VarC.getInterstitialConfigurations() : null;
            if (interstitialConfigurations == null) {
                throw new IllegalStateException("Error getting " + adProperties.getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String() + " configurations");
            }
            if (levelPlayConfig == null || (listEmptyList = levelPlayConfig.c(adProperties.d(), adProperties.getAdUnitId())) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            String userIdForNetworks = IronSourceUtils.getUserIdForNetworks();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listEmptyList, 10));
            Iterator<T> it = listEmptyList.iterator();
            while (it.hasNext()) {
                arrayList.add(((zn) it.next()).f());
            }
            qk qkVarB = qk.b();
            Intrinsics.checkNotNullExpressionValue(qkVarB, "getInstance()");
            return new kj(adProperties, isPublisherLoad, new v1(userIdForNetworks, arrayList, qkVarB), interstitialConfigurations);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public kj(f1 adProperties, boolean z, v1 adUnitCommonData, mj configs) {
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        Intrinsics.checkNotNullParameter(adUnitCommonData, "adUnitCommonData");
        Intrinsics.checkNotNullParameter(configs, "configs");
        String strF = adUnitCommonData.f();
        List<NetworkSettings> listD = adUnitCommonData.d();
        qk qkVarE = adUnitCommonData.e();
        o5 o5VarG = configs.g();
        Intrinsics.checkNotNullExpressionValue(o5VarG, "configs.interstitialAuctionSettings");
        super(adProperties, z, strF, listD, qkVarE, o5VarG, configs.c(), configs.d(), configs.f(), configs.b(), -1, new o2(o2.a.MANUAL, configs.g().j(), configs.g().b(), -1L), configs.h(), configs.k(), configs.m(), configs.l(), false, 65536, null);
        this.adProperties = adProperties;
        this.isPublisherLoad = z;
        this.adUnitCommonData = adUnitCommonData;
        this.configs = configs;
        this.adUnitPrefix = IronSourceConstants.INTERSTITIAL_EVENT_TYPE;
        this.managerName = fl.MADU_IS_MANAGER_NAME;
    }

    public static /* synthetic */ kj a(kj kjVar, f1 f1Var, boolean z, v1 v1Var, mj mjVar, int i, Object obj) {
        if ((i & 1) != 0) {
            f1Var = kjVar.adProperties;
        }
        if ((i & 2) != 0) {
            z = kjVar.isPublisherLoad;
        }
        if ((i & 4) != 0) {
            v1Var = kjVar.adUnitCommonData;
        }
        if ((i & 8) != 0) {
            mjVar = kjVar.configs;
        }
        return kjVar.a(f1Var, z, v1Var, mjVar);
    }

    /* JADX INFO: renamed from: A, reason: from getter */
    public final v1 getAdUnitCommonData() {
        return this.adUnitCommonData;
    }

    /* JADX INFO: renamed from: B, reason: from getter */
    public final mj getConfigs() {
        return this.configs;
    }

    public final kj a(f1 adProperties, boolean isPublisherLoad, v1 adUnitCommonData, mj configs) {
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        Intrinsics.checkNotNullParameter(adUnitCommonData, "adUnitCommonData");
        Intrinsics.checkNotNullParameter(configs, "configs");
        return new kj(adProperties, isPublisherLoad, adUnitCommonData, configs);
    }

    @Override // com.json.w1
    /* JADX INFO: renamed from: b, reason: from getter */
    public f1 getAdProperties() {
        return this.adProperties;
    }

    @Override // com.json.w1
    public JSONObject b(NetworkSettings providerSettings) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        JSONObject interstitialSettings = providerSettings.getInterstitialSettings();
        Intrinsics.checkNotNullExpressionValue(interstitialSettings, "providerSettings.interstitialSettings");
        return interstitialSettings;
    }

    @Override // com.json.w1
    /* JADX INFO: renamed from: c, reason: from getter */
    public String getAdUnitPrefix() {
        return this.adUnitPrefix;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof kj)) {
            return false;
        }
        kj kjVar = (kj) other;
        return Intrinsics.areEqual(this.adProperties, kjVar.adProperties) && this.isPublisherLoad == kjVar.isPublisherLoad && Intrinsics.areEqual(this.adUnitCommonData, kjVar.adUnitCommonData) && Intrinsics.areEqual(this.configs, kjVar.configs);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = this.adProperties.hashCode() * 31;
        boolean z = this.isPublisherLoad;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((iHashCode + r1) * 31) + this.adUnitCommonData.hashCode()) * 31) + this.configs.hashCode();
    }

    @Override // com.json.w1
    /* JADX INFO: renamed from: j, reason: from getter */
    public String getManagerName() {
        return this.managerName;
    }

    public String toString() {
        return "InterstitialAdUnitData(adProperties=" + this.adProperties + ", isPublisherLoad=" + this.isPublisherLoad + ", adUnitCommonData=" + this.adUnitCommonData + ", configs=" + this.configs + ')';
    }

    @Override // com.json.w1
    /* JADX INFO: renamed from: u, reason: from getter */
    public boolean getIsPublisherLoad() {
        return this.isPublisherLoad;
    }

    public final f1 w() {
        return this.adProperties;
    }

    public final boolean x() {
        return this.isPublisherLoad;
    }

    public final v1 y() {
        return this.adUnitCommonData;
    }

    public final mj z() {
        return this.configs;
    }
}
