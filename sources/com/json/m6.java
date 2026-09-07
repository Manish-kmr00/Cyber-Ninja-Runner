package com.json;

import androidx.exifinterface.media.ExifInterface;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.environment.ContextProvider;
import com.json.mediationsdk.IronSourceBannerLayout;
import com.json.mediationsdk.adunit.adapter.utility.AdData;
import com.json.mediationsdk.model.NetworkSettings;
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

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0019\b\u0086\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0007B'\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\r\u001a\u00020\fHÆ\u0003J\t\u0010\u000f\u001a\u00020\u000eHÆ\u0003J1\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u000eHÆ\u0001J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003R\u001a\u0010\u0010\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0011\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R\u0017\u0010\u0012\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010,\u001a\u00020\u00148\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010.\u001a\u00020\u00148\u0016X\u0096D¢\u0006\f\n\u0004\b\r\u0010)\u001a\u0004\b-\u0010+¨\u00061"}, d2 = {"Lcom/ironsource/m6;", "Lcom/ironsource/w1;", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", tr.b, "Lorg/json/JSONObject;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdData;", "a", "Lcom/ironsource/j6;", "w", "", VastAttributes.HORIZONTAL_POSITION, "Lcom/ironsource/v1;", VastAttributes.VERTICAL_POSITION, "Lcom/ironsource/u6;", "z", "adProperties", "isPublisherLoad", "adUnitCommonData", ug.p, "", "toString", "", "hashCode", "", "other", "equals", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "Lcom/ironsource/j6;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/ironsource/j6;", ApsMetricsDataMap.APSMETRICS_FIELD_URL, "Z", "()Z", "v", "Lcom/ironsource/v1;", "B", "()Lcom/ironsource/v1;", "Lcom/ironsource/u6;", "C", "()Lcom/ironsource/u6;", "Ljava/lang/String;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Ljava/lang/String;", "adUnitPrefix", "j", "managerName", "<init>", "(Lcom/ironsource/j6;ZLcom/ironsource/v1;Lcom/ironsource/u6;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class m6 extends w1 {

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private final j6 adProperties;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    private final boolean isPublisherLoad;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    private final v1 adUnitCommonData;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    private final u6 configs;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    private final String adUnitPrefix;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    private final String managerName;

    /* JADX INFO: renamed from: com.ironsource.m6$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/ironsource/m6$a;", "", "Lcom/ironsource/j6;", "adProperties", "Lcom/ironsource/el;", "levelPlayConfig", "", "isPublisherLoad", "Lcom/ironsource/m6;", "a", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final m6 a(j6 adProperties, el levelPlayConfig, boolean isPublisherLoad) {
            List<zn> listEmptyList;
            ls lsVarD;
            Intrinsics.checkNotNullParameter(adProperties, "adProperties");
            w1.Companion companion = w1.INSTANCE;
            s8 s8VarC = (levelPlayConfig == null || (lsVarD = levelPlayConfig.d()) == null) ? null : lsVarD.c();
            u6 bannerConfigurations = s8VarC != null ? s8VarC.getBannerConfigurations() : null;
            if (bannerConfigurations == null) {
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
            return new m6(adProperties, isPublisherLoad, new v1(userIdForNetworks, arrayList, qkVarB), bannerConfigurations);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public m6(j6 adProperties, boolean z, v1 adUnitCommonData, u6 configs) {
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        Intrinsics.checkNotNullParameter(adUnitCommonData, "adUnitCommonData");
        Intrinsics.checkNotNullParameter(configs, "configs");
        String strF = adUnitCommonData.f();
        List<NetworkSettings> listD = adUnitCommonData.d();
        qk qkVarE = adUnitCommonData.e();
        o5 o5VarD = configs.d();
        Intrinsics.checkNotNullExpressionValue(o5VarD, "configs.bannerAuctionSettings");
        super(adProperties, z, strF, listD, qkVarE, o5VarD, configs.a(), (int) (configs.b() / ((long) 1000)), configs.c(), configs.f(), -1, new o2(o2.a.MANUAL_WITH_AUTOMATIC_RELOAD, configs.d().j(), configs.d().b(), 1000 * ((long) configs.h())), configs.e(), configs.l(), configs.n(), configs.m(), false, 65536, null);
        this.adProperties = adProperties;
        this.isPublisherLoad = z;
        this.adUnitCommonData = adUnitCommonData;
        this.configs = configs;
        this.adUnitPrefix = "BN";
        this.managerName = fl.MADU_BN_MANAGER_NAME;
    }

    public static /* synthetic */ m6 a(m6 m6Var, j6 j6Var, boolean z, v1 v1Var, u6 u6Var, int i, Object obj) {
        if ((i & 1) != 0) {
            j6Var = m6Var.adProperties;
        }
        if ((i & 2) != 0) {
            z = m6Var.isPublisherLoad;
        }
        if ((i & 4) != 0) {
            v1Var = m6Var.adUnitCommonData;
        }
        if ((i & 8) != 0) {
            u6Var = m6Var.configs;
        }
        return m6Var.a(j6Var, z, v1Var, u6Var);
    }

    @Override // com.json.w1
    /* JADX INFO: renamed from: A, reason: from getter */
    public j6 getAdProperties() {
        return this.adProperties;
    }

    /* JADX INFO: renamed from: B, reason: from getter */
    public final v1 getAdUnitCommonData() {
        return this.adUnitCommonData;
    }

    /* JADX INFO: renamed from: C, reason: from getter */
    public final u6 getConfigs() {
        return this.configs;
    }

    public final m6 a(j6 adProperties, boolean isPublisherLoad, v1 adUnitCommonData, u6 configs) {
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        Intrinsics.checkNotNullParameter(adUnitCommonData, "adUnitCommonData");
        Intrinsics.checkNotNullParameter(configs, "configs");
        return new m6(adProperties, isPublisherLoad, adUnitCommonData, configs);
    }

    @Override // com.json.w1
    public AdData a(NetworkSettings providerSettings) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        AdData adDataCreateAdDataForNetworkAdapter = AdData.createAdDataForNetworkAdapter(b(providerSettings), getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String(), getUserId(), new IronSourceBannerLayout(ContextProvider.getInstance().getCurrentActiveActivity(), new l1().b(getAdProperties().getAdSize())));
        Intrinsics.checkNotNullExpressionValue(adDataCreateAdDataForNetworkAdapter, "createAdDataForNetworkAd…ze(adProperties.adSize)))");
        return adDataCreateAdDataForNetworkAdapter;
    }

    @Override // com.json.w1
    public JSONObject b(NetworkSettings providerSettings) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        JSONObject bannerSettings = providerSettings.getBannerSettings();
        Intrinsics.checkNotNullExpressionValue(bannerSettings, "providerSettings.bannerSettings");
        return bannerSettings;
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
        if (!(other instanceof m6)) {
            return false;
        }
        m6 m6Var = (m6) other;
        return Intrinsics.areEqual(this.adProperties, m6Var.adProperties) && this.isPublisherLoad == m6Var.isPublisherLoad && Intrinsics.areEqual(this.adUnitCommonData, m6Var.adUnitCommonData) && Intrinsics.areEqual(this.configs, m6Var.configs);
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
        return "BannerAdUnitData(adProperties=" + this.adProperties + ", isPublisherLoad=" + this.isPublisherLoad + ", adUnitCommonData=" + this.adUnitCommonData + ", configs=" + this.configs + ')';
    }

    @Override // com.json.w1
    /* JADX INFO: renamed from: u, reason: from getter */
    public boolean getIsPublisherLoad() {
        return this.isPublisherLoad;
    }

    public final j6 w() {
        return this.adProperties;
    }

    public final boolean x() {
        return this.isPublisherLoad;
    }

    public final v1 y() {
        return this.adUnitCommonData;
    }

    public final u6 z() {
        return this.configs;
    }
}
