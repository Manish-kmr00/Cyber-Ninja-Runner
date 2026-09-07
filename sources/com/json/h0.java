package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.json.mediationsdk.model.NetworkSettings;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR%\u0010\u0010\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\f8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0007\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0012R\u0011\u0010\u0016\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0015R\u0011\u0010\u001a\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/ironsource/h0;", "", "Lcom/ironsource/w1;", "a", "Lcom/ironsource/w1;", "adUnitData", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/ironsource/mediationsdk/model/NetworkSettings;", "e", "()Lcom/ironsource/mediationsdk/model/NetworkSettings;", tr.b, "Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lkotlin/Lazy;", "()Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;", "adapter", "", "()Ljava/lang/String;", "instanceName", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "()Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, "Ljava/util/UUID;", "d", "()Ljava/util/UUID;", "levelPlayAdId", "Lcom/ironsource/w2;", "adTools", "<init>", "(Lcom/ironsource/w2;Lcom/ironsource/w1;Lcom/ironsource/mediationsdk/model/NetworkSettings;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final w1 adUnitData;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final NetworkSettings providerSettings;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Lazy adapter;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;", "a", "()Lcom/ironsource/mediationsdk/adunit/adapter/internal/BaseAdAdapter;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function0<BaseAdAdapter<?, ?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ w2 f3735a;
        final /* synthetic */ h0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(w2 w2Var, h0 h0Var) {
            super(0);
            this.f3735a = w2Var;
            this.b = h0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BaseAdAdapter<?, ?> invoke() {
            return this.f3735a.a(this.b.getProviderSettings(), this.b.a(), this.b.d());
        }
    }

    public h0(w2 adTools, w1 adUnitData, NetworkSettings providerSettings) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        this.adUnitData = adUnitData;
        this.providerSettings = providerSettings;
        this.adapter = LazyKt.lazy(new a(adTools, this));
    }

    public final IronSource.AD_UNIT a() {
        return this.adUnitData.getAdProperties().getAdFormat();
    }

    public final BaseAdAdapter<?, ?> b() {
        return (BaseAdAdapter) this.adapter.getValue();
    }

    public final String c() {
        String providerName = this.providerSettings.getProviderName();
        Intrinsics.checkNotNullExpressionValue(providerName, "providerSettings.providerName");
        return providerName;
    }

    public final UUID d() {
        return this.adUnitData.getAdProperties().getAdId();
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final NetworkSettings getProviderSettings() {
        return this.providerSettings;
    }
}
