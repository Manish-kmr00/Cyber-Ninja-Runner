package com.json;

import androidx.exifinterface.media.ExifInterface;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
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

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000fB\u001f\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\nHÆ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003R\u001a\u0010\f\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0005\u0010\u001aR\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u000e\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010&\u001a\u00020\u00108\u0016X\u0096D¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010(\u001a\u00020\u00108\u0016X\u0096D¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b'\u0010%¨\u0006+"}, d2 = {"Lcom/ironsource/gn;", "Lcom/ironsource/w1;", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", tr.b, "Lorg/json/JSONObject;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/f1;", "w", "Lcom/ironsource/v1;", VastAttributes.HORIZONTAL_POSITION, "Lcom/ironsource/rm;", VastAttributes.VERTICAL_POSITION, "adProperties", "adUnitCommonData", ug.p, "a", "", "toString", "", "hashCode", "", "other", "", "equals", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "Lcom/ironsource/f1;", "()Lcom/ironsource/f1;", ApsMetricsDataMap.APSMETRICS_FIELD_URL, "Lcom/ironsource/v1;", "z", "()Lcom/ironsource/v1;", "v", "Lcom/ironsource/rm;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/ironsource/rm;", "Ljava/lang/String;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Ljava/lang/String;", "adUnitPrefix", "j", "managerName", "<init>", "(Lcom/ironsource/f1;Lcom/ironsource/v1;Lcom/ironsource/rm;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class gn extends w1 {

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private final f1 adProperties;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    private final v1 adUnitCommonData;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    private final rm configs;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    private final String adUnitPrefix;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    private final String managerName;

    /* JADX INFO: renamed from: com.ironsource.gn$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\n"}, d2 = {"Lcom/ironsource/gn$a;", "", "Lcom/ironsource/f1;", "adProperties", "Lcom/ironsource/el;", "levelPlayConfig", "Lcom/ironsource/gn;", "a", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final gn a(f1 adProperties, el levelPlayConfig) {
            List<zn> listEmptyList;
            ls lsVarD;
            Intrinsics.checkNotNullParameter(adProperties, "adProperties");
            w1.Companion companion = w1.INSTANCE;
            s8 s8VarC = (levelPlayConfig == null || (lsVarD = levelPlayConfig.d()) == null) ? null : lsVarD.c();
            rm nativeAdConfigurations = s8VarC != null ? s8VarC.getNativeAdConfigurations() : null;
            if (nativeAdConfigurations == null) {
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
            return new gn(adProperties, new v1(userIdForNetworks, arrayList, qkVarB), nativeAdConfigurations);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gn(f1 adProperties, v1 adUnitCommonData, rm configs) {
        super(adProperties, true, adUnitCommonData.f(), adUnitCommonData.d(), adUnitCommonData.e(), configs.getAuctionSettings(), configs.getAdaptersSmartLoadAmount(), (int) (configs.getAdaptersSmartLoadTimeoutInMills() / ((long) 1000)), configs.getAdapterAdvancedLoading(), configs.getDelayLoadFailure(), -1, new o2(o2.a.MANUAL, configs.getAuctionSettings().j(), configs.getAuctionSettings().b(), -1L), configs.getMCollectBiddingDataTimeout(), configs.getMProvidersParallelInit(), configs.getMWaitUntilAllProvidersFinishInit(), configs.getMSharedManagersThread(), false, 65536, null);
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        Intrinsics.checkNotNullParameter(adUnitCommonData, "adUnitCommonData");
        Intrinsics.checkNotNullParameter(configs, "configs");
        this.adProperties = adProperties;
        this.adUnitCommonData = adUnitCommonData;
        this.configs = configs;
        this.adUnitPrefix = "NA";
        this.managerName = fl.MADU_NT_MANAGER_NAME;
    }

    public static /* synthetic */ gn a(gn gnVar, f1 f1Var, v1 v1Var, rm rmVar, int i, Object obj) {
        if ((i & 1) != 0) {
            f1Var = gnVar.adProperties;
        }
        if ((i & 2) != 0) {
            v1Var = gnVar.adUnitCommonData;
        }
        if ((i & 4) != 0) {
            rmVar = gnVar.configs;
        }
        return gnVar.a(f1Var, v1Var, rmVar);
    }

    /* JADX INFO: renamed from: A, reason: from getter */
    public final rm getConfigs() {
        return this.configs;
    }

    public final gn a(f1 adProperties, v1 adUnitCommonData, rm configs) {
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        Intrinsics.checkNotNullParameter(adUnitCommonData, "adUnitCommonData");
        Intrinsics.checkNotNullParameter(configs, "configs");
        return new gn(adProperties, adUnitCommonData, configs);
    }

    @Override // com.json.w1
    /* JADX INFO: renamed from: b, reason: from getter */
    public f1 getAdProperties() {
        return this.adProperties;
    }

    @Override // com.json.w1
    public JSONObject b(NetworkSettings providerSettings) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        JSONObject nativeAdSettings = providerSettings.getNativeAdSettings();
        Intrinsics.checkNotNullExpressionValue(nativeAdSettings, "providerSettings.nativeAdSettings");
        return nativeAdSettings;
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
        if (!(other instanceof gn)) {
            return false;
        }
        gn gnVar = (gn) other;
        return Intrinsics.areEqual(this.adProperties, gnVar.adProperties) && Intrinsics.areEqual(this.adUnitCommonData, gnVar.adUnitCommonData) && Intrinsics.areEqual(this.configs, gnVar.configs);
    }

    public int hashCode() {
        return (((this.adProperties.hashCode() * 31) + this.adUnitCommonData.hashCode()) * 31) + this.configs.hashCode();
    }

    @Override // com.json.w1
    /* JADX INFO: renamed from: j, reason: from getter */
    public String getManagerName() {
        return this.managerName;
    }

    public String toString() {
        return "NativeAdUnitData(adProperties=" + this.adProperties + ", adUnitCommonData=" + this.adUnitCommonData + ", configs=" + this.configs + ')';
    }

    public final f1 w() {
        return this.adProperties;
    }

    /* JADX INFO: renamed from: x, reason: from getter */
    public final v1 getAdUnitCommonData() {
        return this.adUnitCommonData;
    }

    public final rm y() {
        return this.configs;
    }

    public final v1 z() {
        return this.adUnitCommonData;
    }
}
