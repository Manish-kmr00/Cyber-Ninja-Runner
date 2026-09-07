package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.d;
import com.json.mediationsdk.model.NetworkSettings;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\b\u0016\u0018\u0000 \u00072\u00020\u0001:\u0001\u0005B\u0093\u0001\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\u001d\u0012\u0006\u0010&\u001a\u00020\u001d\u0012\u0006\u0010+\u001a\u00020\u0006\u0012\u0006\u0010-\u001a\u00020\u001d\u0012\u0006\u0010.\u001a\u00020\u001d\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u00107\u001a\u000203\u0012\u0006\u0010<\u001a\u000208\u0012\u0006\u0010>\u001a\u00020\u0006\u0012\u0006\u0010@\u001a\u00020\u0006\u0012\u0006\u0010A\u001a\u00020\u0006\u0012\b\b\u0002\u0010B\u001a\u00020\u0006¢\u0006\u0004\bC\u0010DJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0002R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\"\u0010#\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\u0005\u0010\"R\u0017\u0010&\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!R\"\u0010+\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b\u0013\u0010)\"\u0004\b\u0005\u0010*R\u0017\u0010-\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b,\u0010\u001f\u001a\u0004\b$\u0010!R\u0017\u0010.\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b \u0010\u001f\u001a\u0004\b\u0005\u0010!R\u0017\u00102\u001a\u00020/8\u0006¢\u0006\f\n\u0004\b\u0015\u00100\u001a\u0004\b,\u00101R\u0017\u00107\u001a\u0002038\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b'\u00106R\u0017\u0010<\u001a\u0002088\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b\u001e\u0010;R\u0017\u0010>\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b=\u0010(\u001a\u0004\b4\u0010)R\u0017\u0010@\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b%\u0010(\u001a\u0004\b?\u0010)R\u0017\u0010A\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b9\u0010)R\"\u0010B\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010(\u001a\u0004\b=\u0010)\"\u0004\b\u000b\u0010*¨\u0006E"}, d2 = {"Lcom/ironsource/u0;", "", "", "instanceName", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", "a", "", CampaignEx.JSON_KEY_AD_Q, "r", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "adUnit", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "userId", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/util/List;", "j", "()Ljava/util/List;", "providerList", "Lcom/ironsource/o5;", "d", "Lcom/ironsource/o5;", "()Lcom/ironsource/o5;", "auctionSettings", "", "e", "I", "i", "()I", "(I)V", "maxSmashesToLoad", InneractiveMediationDefs.GENDER_FEMALE, "n", "smashLoadTimeout", "g", "Z", "()Z", "(Z)V", "advancedLoading", "h", "delayLoadFailure", "adExpirationInMinutes", "Lcom/ironsource/o2;", "Lcom/ironsource/o2;", "()Lcom/ironsource/o2;", "loadingData", "Lcom/ironsource/i2;", CampaignEx.JSON_KEY_AD_K, "Lcom/ironsource/i2;", "()Lcom/ironsource/i2;", "interactionData", "", "l", "J", "()J", "collectBiddingDataTimeout", "m", "providersParallelInit", "p", "waitUntilAllProvidersFinishInit", "sharedManagersThread", d.z, "<init>", "(Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;Ljava/lang/String;Ljava/util/List;Lcom/ironsource/o5;IIZIILcom/ironsource/o2;Lcom/ironsource/i2;JZZZZ)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public class u0 {
    public static final int r = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final IronSource.AD_UNIT adUnit;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String userId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final List<NetworkSettings> providerList;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final o5 auctionSettings;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private int maxSmashesToLoad;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final int smashLoadTimeout;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private boolean advancedLoading;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final int delayLoadFailure;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final int adExpirationInMinutes;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final o2 loadingData;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final i2 interactionData;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final long collectBiddingDataTimeout;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final boolean providersParallelInit;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final boolean waitUntilAllProvidersFinishInit;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final boolean sharedManagersThread;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private boolean showPriorityEnabled;

    /* JADX WARN: Multi-variable type inference failed */
    public u0(IronSource.AD_UNIT adUnit, String str, List<? extends NetworkSettings> list, o5 auctionSettings, int i, int i2, boolean z, int i3, int i4, o2 loadingData, i2 interactionData, long j, boolean z2, boolean z3, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(auctionSettings, "auctionSettings");
        Intrinsics.checkNotNullParameter(loadingData, "loadingData");
        Intrinsics.checkNotNullParameter(interactionData, "interactionData");
        this.adUnit = adUnit;
        this.userId = str;
        this.providerList = list;
        this.auctionSettings = auctionSettings;
        this.maxSmashesToLoad = i;
        this.smashLoadTimeout = i2;
        this.advancedLoading = z;
        this.delayLoadFailure = i3;
        this.adExpirationInMinutes = i4;
        this.loadingData = loadingData;
        this.interactionData = interactionData;
        this.collectBiddingDataTimeout = j;
        this.providersParallelInit = z2;
        this.waitUntilAllProvidersFinishInit = z3;
        this.sharedManagersThread = z4;
        this.showPriorityEnabled = z5;
    }

    public /* synthetic */ u0(IronSource.AD_UNIT ad_unit, String str, List list, o5 o5Var, int i, int i2, boolean z, int i3, int i4, o2 o2Var, i2 i2Var, long j, boolean z2, boolean z3, boolean z4, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(ad_unit, str, list, o5Var, i, i2, z, i3, i4, o2Var, i2Var, j, z2, z3, z4, (i5 & 32768) != 0 ? false : z5);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getAdExpirationInMinutes() {
        return this.adExpirationInMinutes;
    }

    public final NetworkSettings a(String instanceName) {
        Intrinsics.checkNotNullParameter(instanceName, "instanceName");
        List<NetworkSettings> listJ = j();
        Object obj = null;
        if (listJ == null) {
            return null;
        }
        for (Object obj2 : listJ) {
            if (((NetworkSettings) obj2).getProviderInstanceName().equals(instanceName)) {
                obj = obj2;
                break;
            }
        }
        return (NetworkSettings) obj;
    }

    public final void a(int i) {
        this.maxSmashesToLoad = i;
    }

    public final void a(boolean z) {
        this.advancedLoading = z;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final IronSource.AD_UNIT getAdUnit() {
        return this.adUnit;
    }

    public final void b(boolean z) {
        this.showPriorityEnabled = z;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final boolean getAdvancedLoading() {
        return this.advancedLoading;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final o5 getAuctionSettings() {
        return this.auctionSettings;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final long getCollectBiddingDataTimeout() {
        return this.collectBiddingDataTimeout;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getDelayLoadFailure() {
        return this.delayLoadFailure;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final i2 getInteractionData() {
        return this.interactionData;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final o2 getLoadingData() {
        return this.loadingData;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final int getMaxSmashesToLoad() {
        return this.maxSmashesToLoad;
    }

    public List<NetworkSettings> j() {
        return this.providerList;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final boolean getProvidersParallelInit() {
        return this.providersParallelInit;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final boolean getSharedManagersThread() {
        return this.sharedManagersThread;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final boolean getShowPriorityEnabled() {
        return this.showPriorityEnabled;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final int getSmashLoadTimeout() {
        return this.smashLoadTimeout;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final boolean getWaitUntilAllProvidersFinishInit() {
        return this.waitUntilAllProvidersFinishInit;
    }

    public final boolean q() {
        return this.auctionSettings.g() > 0;
    }

    public final String r() {
        String str = String.format(Locale.getDefault(), "%s: %d, %s: %b, %s: %b", d.x, Integer.valueOf(this.maxSmashesToLoad), d.y, Boolean.valueOf(this.advancedLoading), d.z, Boolean.valueOf(this.showPriorityEnabled));
        Intrinsics.checkNotNullExpressionValue(str, "format(\n          Locale…     showPriorityEnabled)");
        return str;
    }
}
