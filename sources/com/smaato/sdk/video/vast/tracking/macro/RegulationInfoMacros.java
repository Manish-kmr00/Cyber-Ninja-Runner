package com.smaato.sdk.video.vast.tracking.macro;

import com.smaato.sdk.core.datacollector.DataCollector;
import com.smaato.sdk.core.gdpr.SomaGdprData;
import com.smaato.sdk.core.gdpr.SomaGdprDataSource;
import com.smaato.sdk.core.util.Joiner;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.collections.Maps;
import com.smaato.sdk.core.util.fi.Supplier;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
final class RegulationInfoMacros {
    private final CoppaProvider coppaProvider;
    private final DataCollector dataCollector;
    private final SomaGdprDataSource somaGdprDataSource;

    interface CoppaProvider extends Supplier<Boolean> {
    }

    RegulationInfoMacros(SomaGdprDataSource somaGdprDataSource, DataCollector dataCollector, CoppaProvider coppaProvider) {
        this.somaGdprDataSource = (SomaGdprDataSource) Objects.requireNonNull(somaGdprDataSource);
        this.dataCollector = (DataCollector) Objects.requireNonNull(dataCollector);
        this.coppaProvider = (CoppaProvider) Objects.requireNonNull(coppaProvider);
    }

    Map<String, String> toMap() {
        SomaGdprData somaGdprData = this.somaGdprDataSource.getSomaGdprData();
        return Maps.mapOf(Maps.entryOf("[LIMITADTRACKING]", getGoogleLimitAdTrackingEnabled()), Maps.entryOf("[REGULATIONS]", getRegulations(somaGdprData)), Maps.entryOf("[GDPRCONSENT]", getConsent(somaGdprData)));
    }

    private String getGoogleLimitAdTrackingEnabled() {
        Boolean boolIsGoogleLimitAdTrackingEnabled = this.dataCollector.getSystemInfo().isGoogleLimitAdTrackingEnabled();
        if (boolIsGoogleLimitAdTrackingEnabled == null) {
            return "-2";
        }
        return boolIsGoogleLimitAdTrackingEnabled.booleanValue() ? "1" : "0";
    }

    private String getRegulations(SomaGdprData somaGdprData) {
        ArrayList arrayList = new ArrayList();
        if (this.coppaProvider.get().booleanValue()) {
            arrayList.add("coppa");
        }
        Boolean boolIsGdprEnabled = somaGdprData.isGdprEnabled();
        if (!somaGdprData.getConsentString().isEmpty() || (boolIsGdprEnabled != null && boolIsGdprEnabled.booleanValue())) {
            arrayList.add("gdpr");
        }
        return arrayList.isEmpty() ? "-2" : Joiner.join(StringUtils.COMMA, arrayList);
    }

    private String getConsent(SomaGdprData somaGdprData) {
        String consentString = somaGdprData.getConsentString();
        return TextUtils.isEmpty(consentString) ? "-2" : consentString;
    }
}
