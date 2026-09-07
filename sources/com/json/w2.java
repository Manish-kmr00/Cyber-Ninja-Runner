package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.IronSourceSegment;
import com.json.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.json.mediationsdk.c;
import com.json.mediationsdk.d;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.p;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u0001\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100B\u0019\b\u0016\u0012\u0006\u00101\u001a\u00020\u0000\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00102J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u000e\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bJ(\u0010\u000e\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0015J\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0017J\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\bJ\b\u0010\u001c\u001a\u0004\u0018\u00010\bR\u0014\u0010\u001f\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0017\u0010$\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#R$\u0010*\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b&\u0010(\"\u0004\b\u000e\u0010)¨\u00063"}, d2 = {"Lcom/ironsource/w2;", "Lcom/ironsource/o1;", "Lcom/ironsource/hr;", "task", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/mediationsdk/IronSourceSegment;", "l", "", m5.s, "e", "Lcom/ironsource/b0;", "instanceData", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;", "a", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", tr.b, "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "Ljava/util/UUID;", "adId", "Lcom/ironsource/ai$a;", "m", "", CampaignEx.JSON_KEY_AD_K, "", "timeStamp", "instanceName", "j", "g", "Lcom/ironsource/o1;", "adTools", "Lcom/ironsource/s2;", "h", "Lcom/ironsource/s2;", "()Lcom/ironsource/s2;", "auctionHistory", "Lcom/ironsource/g5;", "i", "Lcom/ironsource/g5;", "()Lcom/ironsource/g5;", "(Lcom/ironsource/g5;)V", "auctionRequestEnricher", "Lcom/ironsource/w1;", "adUnitData", "Lcom/ironsource/e2$b;", "level", "<init>", "(Lcom/ironsource/o1;Lcom/ironsource/w1;Lcom/ironsource/e2$b;)V", "adUnitTools", "(Lcom/ironsource/w2;Lcom/ironsource/e2$b;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public class w2 extends o1 {

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final o1 adTools;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final s2 auctionHistory;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private g5 auctionRequestEnricher;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w2(o1 adTools, w1 adUnitData, e2.b level) {
        super(adTools, level);
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(level, "level");
        this.adTools = adTools;
        s2 s2VarA = vt.a(adUnitData, adUnitData.getAuctionSettings().c());
        Intrinsics.checkNotNullExpressionValue(s2VarA, "getAdUnitPerformance(\n  …auctionSavedHistoryLimit)");
        this.auctionHistory = s2VarA;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w2(w2 adUnitTools, e2.b level) {
        super(adUnitTools, level);
        Intrinsics.checkNotNullParameter(adUnitTools, "adUnitTools");
        Intrinsics.checkNotNullParameter(level, "level");
        this.adTools = adUnitTools.adTools;
        this.auctionHistory = adUnitTools.auctionHistory;
        this.auctionRequestEnricher = adUnitTools.auctionRequestEnricher;
    }

    public final BaseAdAdapter<?, ?> a(b0 instanceData) {
        Intrinsics.checkNotNullParameter(instanceData, "instanceData");
        return c.b().a(instanceData.u(), instanceData.getAdFormat(), instanceData.i().getAdProperties().getAdId());
    }

    public final BaseAdAdapter<?, ?> a(NetworkSettings providerSettings, IronSource.AD_UNIT adFormat, UUID adId) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adId, "adId");
        return c.b().a(providerSettings, adFormat, adId);
    }

    public final String a(long timeStamp, String instanceName) {
        Intrinsics.checkNotNullParameter(instanceName, "instanceName");
        String transId = IronSourceUtils.getTransId(timeStamp, instanceName);
        Intrinsics.checkNotNullExpressionValue(transId, "getTransId(timeStamp, instanceName)");
        return transId;
    }

    public final void a(g5 g5Var) {
        this.auctionRequestEnricher = g5Var;
    }

    public final void c(hr task) {
        Intrinsics.checkNotNullParameter(task, "task");
        wt.a(wt.f4570a, task, 0L, 2, null);
    }

    public final String e(String serverData) {
        Intrinsics.checkNotNullParameter(serverData, "serverData");
        String strC = d.b().c(serverData);
        Intrinsics.checkNotNullExpressionValue(strC, "getInstance().getDynamic…romServerData(serverData)");
        return strC;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final s2 getAuctionHistory() {
        return this.auctionHistory;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final g5 getAuctionRequestEnricher() {
        return this.auctionRequestEnricher;
    }

    public final String j() {
        return p.m().l();
    }

    public final Map<String, String> k() {
        return p.m().s();
    }

    public final IronSourceSegment l() {
        return vt.a();
    }

    public final ai.a m() {
        return mm.INSTANCE.a().e();
    }
}
