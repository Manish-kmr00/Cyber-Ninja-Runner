package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/ironsource/fo;", "Lcom/ironsource/xv;", "Lcom/ironsource/yv;", "waterfallFetcherListener", "Lcom/ironsource/j5;", "auctionData", "Lcom/ironsource/d0;", "adInstanceFactory", "", "a", "", "Lcom/ironsource/m5;", "e", "", "", "Lcom/ironsource/h0;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "auctionTrial", IronSourceConstants.AUCTION_FALLBACK, "Lcom/ironsource/w2;", "Lcom/ironsource/w2;", "tools", "Lcom/ironsource/w1;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/ironsource/w1;", "adUnitData", "<init>", "(Lcom/ironsource/w2;Lcom/ironsource/w1;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class fo extends xv {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final w2 tools;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final w1 adUnitData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fo(w2 tools, w1 adUnitData) {
        super(tools, adUnitData);
        Intrinsics.checkNotNullParameter(tools, "tools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        this.tools = tools;
        this.adUnitData = adUnitData;
    }

    private final void a(yv waterfallFetcherListener, j5 auctionData, d0 adInstanceFactory) {
        IronLog.INTERNAL.verbose(o1.a(this.tools, (String) null, (String) null, 3, (Object) null));
        waterfallFetcherListener.a(a(e(), c(), auctionData, adInstanceFactory));
    }

    private final j5 b() {
        return new j5("", IronSourceNetworkBridge.jsonObjectInit(), null, 0, "");
    }

    private final Map<String, h0> c() {
        eu testSuiteLoadAdConfig = this.adUnitData.getAdProperties().getTestSuiteLoadAdConfig();
        List<NetworkSettings> listM = this.adUnitData.m();
        ArrayList<NetworkSettings> arrayList = new ArrayList();
        for (Object obj : listM) {
            NetworkSettings networkSettings = (NetworkSettings) obj;
            if (testSuiteLoadAdConfig == null || testSuiteLoadAdConfig.a(networkSettings, this.adUnitData.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String())) {
                if (!networkSettings.isBidder(this.adUnitData.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String())) {
                    arrayList.add(obj);
                }
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (NetworkSettings networkSettings2 : arrayList) {
            Pair pair = TuplesKt.to(networkSettings2.getProviderInstanceName(), new h0(this.tools, this.adUnitData, networkSettings2));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    private final String d() {
        return "fallback_" + System.currentTimeMillis();
    }

    private final List<m5> e() {
        eu testSuiteLoadAdConfig = this.adUnitData.getAdProperties().getTestSuiteLoadAdConfig();
        List<NetworkSettings> listM = this.adUnitData.m();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM) {
            NetworkSettings networkSettings = (NetworkSettings) obj;
            if (testSuiteLoadAdConfig == null || testSuiteLoadAdConfig.a(networkSettings, this.adUnitData.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String())) {
                if (!networkSettings.isBidder(this.adUnitData.getAdProperties().getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String())) {
                    arrayList.add(obj);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new m5(((NetworkSettings) it.next()).getProviderInstanceName()));
        }
        return arrayList2;
    }

    @Override // com.json.xv
    public void a(d0 adInstanceFactory, yv waterfallFetcherListener) {
        Intrinsics.checkNotNullParameter(adInstanceFactory, "adInstanceFactory");
        Intrinsics.checkNotNullParameter(waterfallFetcherListener, "waterfallFetcherListener");
        IronLog.INTERNAL.verbose(o1.a(this.tools, "auction disabled", (String) null, 2, (Object) null));
        a(waterfallFetcherListener, b(), adInstanceFactory);
    }

    public final void a(yv waterfallFetcherListener, int auctionTrial, String auctionFallback, d0 adInstanceFactory) {
        Intrinsics.checkNotNullParameter(waterfallFetcherListener, "waterfallFetcherListener");
        Intrinsics.checkNotNullParameter(auctionFallback, "auctionFallback");
        Intrinsics.checkNotNullParameter(adInstanceFactory, "adInstanceFactory");
        a(waterfallFetcherListener, new j5(d(), IronSourceNetworkBridge.jsonObjectInit(), null, auctionTrial, auctionFallback), adInstanceFactory);
    }
}
