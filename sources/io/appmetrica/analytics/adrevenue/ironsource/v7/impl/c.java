package io.appmetrica.analytics.adrevenue.ironsource.v7.impl;

import com.json.mediationsdk.impressionData.ImpressionData;
import com.json.mediationsdk.impressionData.ImpressionDataListener;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenue;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueReporter;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdType;
import java.math.BigDecimal;
import java.util.Currency;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements ImpressionDataListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClientContext f10932a;
    public final b b = new b();

    public c(ClientContext clientContext) {
        this.f10932a = clientContext;
    }

    @Override // com.json.mediationsdk.impressionData.ImpressionDataListener
    public final void onImpressionSuccess(ImpressionData impressionData) {
        ModuleAdType moduleAdType;
        if (impressionData != null) {
            ModuleAdRevenueReporter adRevenueReporter = this.f10932a.getModuleAdRevenueContext().getAdRevenueReporter();
            this.b.getClass();
            String adUnit = impressionData.getAdUnit();
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(WrapUtils.getFiniteDoubleOrDefault(impressionData.getRevenue().doubleValue(), 0.0d));
            Currency currency = Currency.getInstance("USD");
            if (adUnit != null) {
                adUnit.hashCode();
                switch (adUnit) {
                    case "Rewarded Video":
                        moduleAdType = ModuleAdType.REWARDED;
                        break;
                    case "Interstitial":
                        moduleAdType = ModuleAdType.INTERSTITIAL;
                        break;
                    case "Banner":
                        moduleAdType = ModuleAdType.BANNER;
                        break;
                    default:
                        moduleAdType = ModuleAdType.OTHER;
                        break;
                }
            } else {
                moduleAdType = null;
            }
            adRevenueReporter.reportAutoAdRevenue(new ModuleAdRevenue(bigDecimalValueOf, currency, moduleAdType, impressionData.getAdNetwork(), null, null, null, impressionData.getPlacement(), impressionData.getPrecision(), new a(adUnit), true));
        }
    }
}
