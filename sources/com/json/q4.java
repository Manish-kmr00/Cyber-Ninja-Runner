package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.json.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.json.mediationsdk.adunit.adapter.utility.AdData;
import com.json.mediationsdk.logger.IronSourceLogger;
import com.json.mediationsdk.logger.IronSourceLoggerManager;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0006\u0018\u00002\u00020\u0001:\u0001'B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001c\u0012\u0006\u0010!\u001a\u00020\u001f¢\u0006\u0004\b5\u00106J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J4\u0010\u0005\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\n\u001a\u00020\tH\u0002J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J*\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u001c\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0019J\u000e\u0010\u0005\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010 R&\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$R\u0017\u0010*\u001a\u00020&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020,0+8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b-\u0010/R\u0017\u00104\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001b\u00101\u001a\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/ironsource/q4;", "", "", "", "Lcom/ironsource/h0;", "a", "com/ironsource/q4$b", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lcom/ironsource/q4$b;", "Lcom/ironsource/q4$d;", "biddingDataListener", "Lcom/ironsource/z7$b;", "", "duration", "", "Lcom/ironsource/a8;", "biddingDataList", "reachedTimeout", "", "instanceName", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", tr.b, "Lcom/ironsource/mediationsdk/adunit/adapter/internal/AdapterBaseInterface;", "networkAdapter", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;", "", "g", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/ironsource/w2;", "Lcom/ironsource/w2;", "adTools", "Lcom/ironsource/w1;", "Lcom/ironsource/w1;", "adUnitData", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/util/Map;", "()Ljava/util/Map;", "adInstancePayloads", "Lcom/ironsource/e5;", "d", "Lcom/ironsource/e5;", "()Lcom/ironsource/e5;", "auctionRequestData", "", "Lcom/ironsource/w7;", "e", "Ljava/util/List;", "()Ljava/util/List;", "callableList", "Z", "h", "()Z", "isTokenPerAdapter", "<init>", "(Lcom/ironsource/w2;Lcom/ironsource/w1;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final w2 adTools;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final w1 adUnitData;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Map<String, h0> adInstancePayloads;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final e5 auctionRequestData;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final List<w7> callableList;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final boolean isTokenPerAdapter;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/ironsource/q4$a", "Lcom/ironsource/hr;", "", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends hr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z7 f4181a;
        final /* synthetic */ q4 b;
        final /* synthetic */ z7.b c;

        a(z7 z7Var, q4 q4Var, z7.b bVar) {
            this.f4181a = z7Var;
            this.b = q4Var;
            this.c = bVar;
        }

        @Override // com.json.hr
        public void a() {
            this.f4181a.a(this.b.e(), this.c, this.b.adUnitData.getCollectBiddingDataTimeout(), TimeUnit.MILLISECONDS);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"com/ironsource/q4$b", "Lcom/ironsource/x7;", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", tr.b, "", "a", "", "message", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements x7 {
        b() {
        }

        @Override // com.json.x7
        public void a(NetworkSettings providerSettings) {
            AdapterBaseInterface adapterBaseInterfaceA;
            if (q4.this.getIsTokenPerAdapter()) {
                adapterBaseInterfaceA = null;
                BaseAdAdapter baseAdAdapterB = q4.this.b(providerSettings != null ? providerSettings.getProviderName() : null);
                if (baseAdAdapterB != null) {
                    adapterBaseInterfaceA = baseAdAdapterB.getNetworkAdapter();
                }
            } else {
                adapterBaseInterfaceA = q4.this.a(providerSettings);
            }
            if (adapterBaseInterfaceA != null) {
                q4.this.adTools.getEventSender().getToken().a(q4.this.a(providerSettings, adapterBaseInterfaceA));
            }
        }

        @Override // com.json.x7
        public void a(String message) {
            q4.this.adTools.getEventSender().getTroubleshoot().g(message);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"com/ironsource/q4$c", "Lcom/ironsource/z7$b;", "", "Lcom/ironsource/a8;", "biddingDataList", "", "duration", "", "reachedTimeout", "", "a", "error", "onFailure", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements z7.b {
        final /* synthetic */ d b;

        c(d dVar) {
            this.b = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(q4 this$0, long j, List biddingDataList, List reachedTimeout, d biddingDataListener) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(biddingDataList, "$biddingDataList");
            Intrinsics.checkNotNullParameter(reachedTimeout, "$reachedTimeout");
            Intrinsics.checkNotNullParameter(biddingDataListener, "$biddingDataListener");
            this$0.a(j, biddingDataList, reachedTimeout, biddingDataListener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(q4 this$0, String error, d biddingDataListener) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(error, "$error");
            Intrinsics.checkNotNullParameter(biddingDataListener, "$biddingDataListener");
            this$0.adTools.getEventSender().getToken().a(error);
            biddingDataListener.a(this$0, error);
        }

        @Override // com.ironsource.z7.b
        public void a(final List<? extends a8> biddingDataList, final long duration, final List<String> reachedTimeout) {
            Intrinsics.checkNotNullParameter(biddingDataList, "biddingDataList");
            Intrinsics.checkNotNullParameter(reachedTimeout, "reachedTimeout");
            w2 w2Var = q4.this.adTools;
            final q4 q4Var = q4.this;
            final d dVar = this.b;
            w2Var.a(new Runnable() { // from class: com.ironsource.q4$c$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    q4.c.a(q4Var, duration, biddingDataList, reachedTimeout, dVar);
                }
            });
        }

        @Override // com.ironsource.z7.b
        public void onFailure(final String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            w2 w2Var = q4.this.adTools;
            final q4 q4Var = q4.this;
            final d dVar = this.b;
            w2Var.a(new Runnable() { // from class: com.ironsource.q4$c$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    q4.c.a(q4Var, error, dVar);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/ironsource/q4$d;", "", "Lcom/ironsource/q4;", b4.f, "", "a", "", "error", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public interface d {
        void a(q4 auction);

        void a(q4 auction, String error);
    }

    public q4(w2 adTools, w1 adUnitData) {
        StringBuilder sbAppend;
        String providerName;
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        this.adTools = adTools;
        this.adUnitData = adUnitData;
        this.adInstancePayloads = a();
        this.auctionRequestData = new e5(adUnitData);
        this.callableList = new ArrayList();
        this.isTokenPerAdapter = adUnitData.getAuctionSettings().p();
        b bVarB = b();
        eu testSuiteLoadAdConfig = adUnitData.getAdProperties().getTestSuiteLoadAdConfig();
        for (NetworkSettings networkSettings : adUnitData.m()) {
            if (testSuiteLoadAdConfig == null || testSuiteLoadAdConfig.a(networkSettings, this.adUnitData.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String())) {
                AdData adDataA = this.adUnitData.a(networkSettings);
                if (networkSettings.isBidder(this.adUnitData.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String())) {
                    Object objB = this.isTokenPerAdapter ? b(networkSettings.getProviderName()) : a(networkSettings);
                    if (objB instanceof y7) {
                        this.callableList.add(new w7(networkSettings.getInstanceType(this.adUnitData.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String()), networkSettings.getProviderInstanceName(), adDataA, (y7) objB, bVarB, networkSettings));
                    } else {
                        if (objB == null) {
                            sbAppend = new StringBuilder("prepareAuctionCandidates - could not load network adapter ");
                            providerName = networkSettings.getProviderName();
                        } else {
                            sbAppend = new StringBuilder("network adapter ").append(networkSettings.getProviderName());
                            providerName = " does not implementing BiddingDataInterface";
                        }
                        this.adTools.getEventSender().getTroubleshoot().g(sbAppend.append(providerName).toString());
                    }
                } else {
                    this.auctionRequestData.a(networkSettings);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdapterBaseInterface a(NetworkSettings providerSettings) {
        return com.json.mediationsdk.c.b().b(providerSettings, this.adUnitData.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String(), this.adUnitData.getAdProperties().getAdId());
    }

    private final Map<String, h0> a() {
        List<NetworkSettings> listM = this.adUnitData.m();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listM, 10)), 16));
        Iterator<T> it = listM.iterator();
        while (it.hasNext()) {
            h0 h0Var = new h0(this.adTools, this.adUnitData, (NetworkSettings) it.next());
            Pair pair = TuplesKt.to(h0Var.c(), h0Var);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> a(NetworkSettings providerSettings, AdapterBaseInterface networkAdapter) {
        String providerDefaultInstance;
        HashMap map = new HashMap();
        if (providerSettings != null) {
            try {
                providerDefaultInstance = providerSettings.getProviderDefaultInstance();
            } catch (Exception e) {
                o9.d().a(e);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "getProviderEventData " + (providerSettings != null ? providerSettings.getProviderDefaultInstance() : null), e);
            }
        } else {
            providerDefaultInstance = null;
        }
        map.put(IronSourceConstants.EVENTS_PROVIDER, providerDefaultInstance);
        map.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, networkAdapter != null ? networkAdapter.getAdapterVersion() : null);
        map.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, networkAdapter != null ? networkAdapter.getNetworkSDKVersion() : null);
        map.put("spId", providerSettings != null ? providerSettings.getSubProviderId() : null);
        map.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        map.put("instanceType", providerSettings != null ? Integer.valueOf(providerSettings.getInstanceType(this.adUnitData.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String())) : null);
        return map;
    }

    private final Map<String, Object> a(String instanceName) {
        AdapterBaseInterface adapterBaseInterfaceA;
        NetworkSettings networkSettingsA = this.adUnitData.a(instanceName);
        if (this.isTokenPerAdapter) {
            BaseAdAdapter<?, ?> baseAdAdapterB = b(instanceName);
            adapterBaseInterfaceA = baseAdAdapterB != null ? baseAdAdapterB.getNetworkAdapter() : null;
        } else {
            adapterBaseInterfaceA = a(networkSettingsA);
        }
        return a(networkSettingsA, adapterBaseInterfaceA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(long duration, List<? extends a8> biddingDataList, List<String> reachedTimeout, d biddingDataListener) {
        this.adTools.getEventSender().getToken().a(duration);
        for (a8 a8Var : biddingDataList) {
            String strC = a8Var.c();
            Intrinsics.checkNotNullExpressionValue(strC, "biddingResponse.instanceName");
            Map<String, Object> mapA = a(strC);
            if (a8Var.a() != null) {
                this.auctionRequestData.a(a8Var);
                this.adTools.getEventSender().getToken().a(mapA, a8Var.e());
            } else {
                this.adTools.getEventSender().getToken().a(mapA, a8Var.e(), a8Var.b());
            }
        }
        Iterator<String> it = reachedTimeout.iterator();
        while (it.hasNext()) {
            this.adTools.getEventSender().getToken().b(a(it.next()), duration);
        }
        biddingDataListener.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseAdAdapter<?, ?> b(String instanceName) {
        h0 h0Var = this.adInstancePayloads.get(instanceName);
        if (h0Var != null) {
            return h0Var.b();
        }
        return null;
    }

    private final b b() {
        return new b();
    }

    private final z7.b b(d biddingDataListener) {
        return new c(biddingDataListener);
    }

    public final void a(d biddingDataListener) {
        Intrinsics.checkNotNullParameter(biddingDataListener, "biddingDataListener");
        z7 z7Var = new z7();
        z7.b bVarB = b(biddingDataListener);
        this.adTools.getEventSender().getToken().a();
        this.adTools.c((hr) new a(z7Var, this, bVarB));
    }

    public final Map<String, h0> c() {
        return this.adInstancePayloads;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final e5 getAuctionRequestData() {
        return this.auctionRequestData;
    }

    public final List<w7> e() {
        return this.callableList;
    }

    public final boolean f() {
        return !this.callableList.isEmpty();
    }

    public final boolean g() {
        return this.auctionRequestData.d();
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final boolean getIsTokenPerAdapter() {
        return this.isTokenPerAdapter;
    }
}
