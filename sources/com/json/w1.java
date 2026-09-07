package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.adunit.adapter.utility.AdData;
import com.json.mediationsdk.d;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.model.Placement;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\b&\u0018\u0000 \u00182\u00020\u0001:\u0001\u0006B\u0099\u0001\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u001b\u0012\u0006\u0010&\u001a\u00020!\u0012\u0006\u0010+\u001a\u00020'\u0012\u0006\u00102\u001a\u00020,\u0012\u0006\u00104\u001a\u00020,\u0012\u0006\u00107\u001a\u00020\u0007\u0012\u0006\u00109\u001a\u00020,\u0012\u0006\u0010:\u001a\u00020,\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010D\u001a\u00020\u0007\u0012\u0006\u0010F\u001a\u00020\u0007\u0012\u0006\u0010H\u001a\u00020\u0007\u0012\b\b\u0002\u0010J\u001a\u00020\u0007¢\u0006\u0004\bM\u0010NJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0005H\u0016R\u001a\u0010\u0011\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\f\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010&\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010+\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b\"\u0010*R\"\u00102\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b\u0006\u00101R\u0017\u00104\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b3\u00100R\"\u00107\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u0006\u00106R\u0017\u00109\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b8\u0010.\u001a\u0004\b-\u00100R\u0017\u0010:\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b/\u0010.\u001a\u0004\b\u0006\u00100R\u0017\u0010>\u001a\u00020;8\u0006¢\u0006\f\n\u0004\b\u0003\u0010<\u001a\u0004\b5\u0010=R\u0017\u0010B\u001a\u00020?8\u0006¢\u0006\f\n\u0004\b\u001e\u0010@\u001a\u0004\b(\u0010AR\u0017\u0010D\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\bC\u0010\u0012\u001a\u0004\bC\u0010\u0014R\u0017\u0010F\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\bE\u0010\u0014R\u0017\u0010H\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\bG\u0010\u0012\u001a\u0004\bG\u0010\u0014R\"\u0010J\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010\u0012\u001a\u0004\bI\u0010\u0014\"\u0004\b\f\u00106R\u0014\u0010K\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0019R\u0014\u0010L\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0019¨\u0006O"}, d2 = {"Lcom/ironsource/w1;", "", "", "l", "instanceName", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", "a", "", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "v", tr.b, "Lorg/json/JSONObject;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdData;", "Lcom/ironsource/f1;", "Lcom/ironsource/f1;", "()Lcom/ironsource/f1;", "adProperties", "Z", ApsMetricsDataMap.APSMETRICS_FIELD_URL, "()Z", "isPublisherLoad", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/lang/String;", "r", "()Ljava/lang/String;", "userId", "", "d", "Ljava/util/List;", "m", "()Ljava/util/List;", "providerList", "Lcom/ironsource/qk;", "e", "Lcom/ironsource/qk;", "o", "()Lcom/ironsource/qk;", "publisherDataHolder", "Lcom/ironsource/o5;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/ironsource/o5;", "()Lcom/ironsource/o5;", "auctionSettings", "", "g", "I", CampaignEx.JSON_KEY_AD_K, "()I", "(I)V", "maxInstancesToLoad", "h", "instanceLoadTimeout", "i", "(Z)V", "advancedLoading", "j", "delayLoadFailure", "adExpirationInMinutes", "Lcom/ironsource/o2;", "Lcom/ironsource/o2;", "()Lcom/ironsource/o2;", "loadingData", "", "J", "()J", "collectBiddingDataTimeout", "n", "providersParallelInit", "s", "waitUntilAllProvidersFinishInit", "p", "sharedManagersThread", CampaignEx.JSON_KEY_AD_Q, d.z, "adUnitPrefix", "managerName", "<init>", "(Lcom/ironsource/f1;ZLjava/lang/String;Ljava/util/List;Lcom/ironsource/qk;Lcom/ironsource/o5;IIZIILcom/ironsource/o2;JZZZZ)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public abstract class w1 {

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int s = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final f1 adProperties;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final boolean isPublisherLoad;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String userId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final List<NetworkSettings> providerList;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final qk publisherDataHolder;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final o5 auctionSettings;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private int maxInstancesToLoad;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final int instanceLoadTimeout;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private boolean advancedLoading;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final int delayLoadFailure;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final int adExpirationInMinutes;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final o2 loadingData;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final long collectBiddingDataTimeout;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final boolean providersParallelInit;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final boolean waitUntilAllProvidersFinishInit;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final boolean sharedManagersThread;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private boolean showPriorityEnabled;

    /* JADX INFO: renamed from: com.ironsource.w1$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014Jc\u0010\u000e\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0016\u0010\n\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00018\u00000\b2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"Lcom/ironsource/w1$a;", "", "AdFormatConfig", "AdUnitData", "Lcom/ironsource/f1;", "adProperties", "Lcom/ironsource/el;", "levelPlayConfig", "Lkotlin/Function1;", "Lcom/ironsource/s8;", "getAdFormatConfig", "Lkotlin/Function2;", "Lcom/ironsource/v1;", "createAdUnitData", "a", "(Lcom/ironsource/f1;Lcom/ironsource/el;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "", "DISABLED", "I", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <AdFormatConfig, AdUnitData> AdUnitData a(f1 adProperties, el levelPlayConfig, Function1<? super s8, ? extends AdFormatConfig> getAdFormatConfig, Function2<? super v1, ? super AdFormatConfig, ? extends AdUnitData> createAdUnitData) {
            List<zn> listEmptyList;
            ls lsVarD;
            Intrinsics.checkNotNullParameter(adProperties, "adProperties");
            Intrinsics.checkNotNullParameter(getAdFormatConfig, "getAdFormatConfig");
            Intrinsics.checkNotNullParameter(createAdUnitData, "createAdUnitData");
            AdFormatConfig adformatconfigInvoke = getAdFormatConfig.invoke((levelPlayConfig == null || (lsVarD = levelPlayConfig.d()) == null) ? null : lsVarD.c());
            if (adformatconfigInvoke == null) {
                throw new IllegalStateException("Error getting " + adProperties.getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String() + " configurations");
            }
            if (levelPlayConfig == null || (listEmptyList = levelPlayConfig.c(adProperties.d(), adProperties.getAdUnitId())) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            String userIdForNetworks = IronSourceUtils.getUserIdForNetworks();
            List<zn> list = listEmptyList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((zn) it.next()).f());
            }
            qk qkVarB = qk.b();
            Intrinsics.checkNotNullExpressionValue(qkVarB, "getInstance()");
            return createAdUnitData.invoke(new v1(userIdForNetworks, arrayList, qkVarB), adformatconfigInvoke);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w1(f1 adProperties, boolean z, String str, List<? extends NetworkSettings> providerList, qk publisherDataHolder, o5 auctionSettings, int i, int i2, boolean z2, int i3, int i4, o2 loadingData, long j, boolean z3, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        Intrinsics.checkNotNullParameter(providerList, "providerList");
        Intrinsics.checkNotNullParameter(publisherDataHolder, "publisherDataHolder");
        Intrinsics.checkNotNullParameter(auctionSettings, "auctionSettings");
        Intrinsics.checkNotNullParameter(loadingData, "loadingData");
        this.adProperties = adProperties;
        this.isPublisherLoad = z;
        this.userId = str;
        this.providerList = providerList;
        this.publisherDataHolder = publisherDataHolder;
        this.auctionSettings = auctionSettings;
        this.maxInstancesToLoad = i;
        this.instanceLoadTimeout = i2;
        this.advancedLoading = z2;
        this.delayLoadFailure = i3;
        this.adExpirationInMinutes = i4;
        this.loadingData = loadingData;
        this.collectBiddingDataTimeout = j;
        this.providersParallelInit = z3;
        this.waitUntilAllProvidersFinishInit = z4;
        this.sharedManagersThread = z5;
        this.showPriorityEnabled = z6;
    }

    public /* synthetic */ w1(f1 f1Var, boolean z, String str, List list, qk qkVar, o5 o5Var, int i, int i2, boolean z2, int i3, int i4, o2 o2Var, long j, boolean z3, boolean z4, boolean z5, boolean z6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(f1Var, z, str, list, qkVar, o5Var, i, i2, z2, i3, i4, o2Var, j, z3, z4, z5, (i5 & 65536) != 0 ? false : z6);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getAdExpirationInMinutes() {
        return this.adExpirationInMinutes;
    }

    public AdData a(NetworkSettings providerSettings) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        AdData adDataCreateAdDataForNetworkAdapter = AdData.createAdDataForNetworkAdapter(b(providerSettings), getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String(), this.userId);
        Intrinsics.checkNotNullExpressionValue(adDataCreateAdDataForNetworkAdapter, "createAdDataForNetworkAd…perties.adFormat, userId)");
        return adDataCreateAdDataForNetworkAdapter;
    }

    public final NetworkSettings a(String instanceName) {
        Object next;
        Intrinsics.checkNotNullParameter(instanceName, "instanceName");
        Iterator<T> it = this.providerList.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((NetworkSettings) next).getProviderInstanceName().equals(instanceName)) {
                return (NetworkSettings) next;
            }
        }
        next = null;
        return (NetworkSettings) next;
    }

    public final void a(int i) {
        this.maxInstancesToLoad = i;
    }

    public final void a(boolean z) {
        this.advancedLoading = z;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public f1 getAdProperties() {
        return this.adProperties;
    }

    public abstract JSONObject b(NetworkSettings providerSettings);

    public final void b(boolean z) {
        this.showPriorityEnabled = z;
    }

    public abstract String c();

    /* JADX INFO: renamed from: d, reason: from getter */
    public final boolean getAdvancedLoading() {
        return this.advancedLoading;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final o5 getAuctionSettings() {
        return this.auctionSettings;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final long getCollectBiddingDataTimeout() {
        return this.collectBiddingDataTimeout;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final int getDelayLoadFailure() {
        return this.delayLoadFailure;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final int getInstanceLoadTimeout() {
        return this.instanceLoadTimeout;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final o2 getLoadingData() {
        return this.loadingData;
    }

    public abstract String j();

    /* JADX INFO: renamed from: k, reason: from getter */
    public final int getMaxInstancesToLoad() {
        return this.maxInstancesToLoad;
    }

    public final String l() {
        String placementName;
        Placement placement = getAdProperties().getPlacement();
        return (placement == null || (placementName = placement.getPlacementName()) == null) ? "" : placementName;
    }

    public final List<NetworkSettings> m() {
        return this.providerList;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final boolean getProvidersParallelInit() {
        return this.providersParallelInit;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final qk getPublisherDataHolder() {
        return this.publisherDataHolder;
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final boolean getSharedManagersThread() {
        return this.sharedManagersThread;
    }

    /* JADX INFO: renamed from: q, reason: from getter */
    public final boolean getShowPriorityEnabled() {
        return this.showPriorityEnabled;
    }

    /* JADX INFO: renamed from: r, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: s, reason: from getter */
    public final boolean getWaitUntilAllProvidersFinishInit() {
        return this.waitUntilAllProvidersFinishInit;
    }

    public final boolean t() {
        return this.auctionSettings.g() > 0;
    }

    /* JADX INFO: renamed from: u, reason: from getter */
    public boolean getIsPublisherLoad() {
        return this.isPublisherLoad;
    }

    public final String v() {
        String str = String.format(Locale.getDefault(), "%s: %d, %s: %b, %s: %b", d.x, Integer.valueOf(this.maxInstancesToLoad), d.y, Boolean.valueOf(this.advancedLoading), d.z, Boolean.valueOf(this.showPriorityEnabled));
        Intrinsics.checkNotNullExpressionValue(str, "format(\n          Locale…     showPriorityEnabled)");
        return str;
    }
}
