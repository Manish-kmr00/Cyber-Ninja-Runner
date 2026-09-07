package io.bidmachine;

import android.content.Context;
import com.explorestack.protobuf.Struct;
import io.bidmachine.analytics.AnalyticsConfig;
import io.bidmachine.analytics.BidMachineAnalytics;
import io.bidmachine.analytics.MonitorConfig;
import io.bidmachine.analytics.ReaderConfig;
import io.bidmachine.protobuf.InitResponse;
import io.bidmachine.protobuf.sdk.Configuration;
import io.bidmachine.protobuf.sdk.Monitor;
import io.bidmachine.protobuf.sdk.Reader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class BidMachineAnalyticsInitializer {
    BidMachineAnalyticsInitializer() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void initialize(Context context) {
        try {
            BidMachineAnalytics.initialize(context);
        } catch (Throwable unused) {
        }
    }

    void configure(Context context, String str, InitResponse initResponse, String str2) {
        try {
            if (initResponse.hasSdkAnalyticConfigV2()) {
                Configuration sdkAnalyticConfigV2 = initResponse.getSdkAnalyticConfigV2();
                List<MonitorConfig> listMapMonitorConfigList = mapMonitorConfigList(sdkAnalyticConfigV2.getMonitorsList());
                List<ReaderConfig> listMapReaderConfigList = mapReaderConfigList(sdkAnalyticConfigV2.getReadersList());
                Struct struct = initResponse.getExtras().getPrivate();
                String value = sdkAnalyticConfigV2.getBpk().getValue();
                BidMachineAnalytics.configure(context, new AnalyticsConfig(str2, listMapMonitorConfigList, listMapReaderConfigList, value, struct));
                if (str.equals(str2)) {
                    return;
                }
                BidMachineAnalytics.configure(context, new AnalyticsConfig(str, listMapMonitorConfigList, listMapReaderConfigList, value, struct));
            }
        } catch (Throwable unused) {
        }
    }

    private List<MonitorConfig> mapMonitorConfigList(List<Monitor.Configuration> list) {
        ArrayList arrayList = new ArrayList();
        for (Monitor.Configuration configuration : list) {
            arrayList.add(new MonitorConfig(configuration.getName().getValue(), configuration.getUrl().getValue(), configuration.getBatchSize().getValue(), configuration.getInterval().getValue(), configuration.hasShouldReport() ? configuration.getShouldReport().getValue() : false));
        }
        return arrayList;
    }

    private List<ReaderConfig> mapReaderConfigList(List<Reader.Configuration> list) {
        ArrayList arrayList = new ArrayList();
        for (Reader.Configuration configuration : list) {
            arrayList.add(new ReaderConfig(configuration.getName().getValue(), configuration.getUrl().getValue(), configuration.getUpdateInterval().getValue(), configuration.hasUniqueOnly() ? configuration.getUniqueOnly().getValue() : true, mapReaderRuleList(configuration.getRulesList())));
        }
        return arrayList;
    }

    private List<ReaderConfig.Rule> mapReaderRuleList(List<Reader.Rule> list) {
        ArrayList arrayList = new ArrayList();
        for (Reader.Rule rule : list) {
            if (rule.hasGeneralRule()) {
                Reader.Rule.GeneralRule generalRule = rule.getGeneralRule();
                arrayList.add(new ReaderConfig.Rule(generalRule.getTag().getValue(), generalRule.getPath().getValue()));
            }
        }
        return arrayList;
    }
}
