package io.bidmachine;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public interface NetworkConfigParams {
    String getFromNetworkParams(String str);

    EnumMap<AdsFormat, List<Map<String, String>>> obtainNetworkMediationConfigs(AdsFormat... adsFormatArr);

    Map<String, String> obtainNetworkParams();

    String removeFromNetworkParams(String str);
}
