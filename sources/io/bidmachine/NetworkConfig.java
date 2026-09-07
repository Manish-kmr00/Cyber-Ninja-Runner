package io.bidmachine;

import io.bidmachine.core.Logger;
import io.bidmachine.unified.UnifiedAdRequestParams;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public abstract class NetworkConfig {
    static final String CONFIG_SKIP_INITIALIZATION = "skip_initialization";
    private Map<String, String> baseMediationConfig;
    private AdsType[] mergedAdsTypes;
    private final String networkKey;
    private AdsType[] supportedAdsTypes;
    private EnumMap<AdsFormat, List<Map<String, String>>> typedMediationConfigs;
    private final NetworkConfigParams networkConfigParams = new NetworkConfigParams() { // from class: io.bidmachine.NetworkConfig.1
        @Override // io.bidmachine.NetworkConfigParams
        public Map<String, String> obtainNetworkParams() {
            return new HashMap(NetworkConfig.this.networkParams);
        }

        @Override // io.bidmachine.NetworkConfigParams
        public String removeFromNetworkParams(String str) {
            return (String) NetworkConfig.this.networkParams.remove(str);
        }

        @Override // io.bidmachine.NetworkConfigParams
        public String getFromNetworkParams(String str) {
            return (String) NetworkConfig.this.networkParams.get(str);
        }

        @Override // io.bidmachine.NetworkConfigParams
        public EnumMap<AdsFormat, List<Map<String, String>>> obtainNetworkMediationConfigs(AdsFormat... adsFormatArr) {
            ArrayList arrayList;
            List list;
            if (adsFormatArr == null || adsFormatArr.length <= 0) {
                return null;
            }
            EnumMap<AdsFormat, List<Map<String, String>>> enumMap = null;
            for (AdsFormat adsFormat : adsFormatArr) {
                if (NetworkConfig.this.typedMediationConfigs == null || (list = (List) NetworkConfig.this.typedMediationConfigs.get(adsFormat)) == null) {
                    arrayList = null;
                } else {
                    arrayList = null;
                    for (int i = 0; i < list.size(); i++) {
                        Map map = (Map) list.get(i);
                        Map<String, String> mapPrepareTypedMediationConfig = map != null ? NetworkConfig.this.prepareTypedMediationConfig(map) : null;
                        if (mapPrepareTypedMediationConfig != null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(mapPrepareTypedMediationConfig);
                        }
                    }
                }
                if (arrayList != null) {
                    if (enumMap == null) {
                        enumMap = new EnumMap<>(AdsFormat.class);
                    }
                    enumMap.put(adsFormat, arrayList);
                }
            }
            return enumMap;
        }
    };
    private final Map<String, String> networkParams = new HashMap();

    protected abstract NetworkAdapter createNetworkAdapter();

    protected boolean useNetworkParamsAsMediationBase() {
        return true;
    }

    protected NetworkConfig(String str, Map<String, String> map) {
        this.networkKey = str;
        withNetworkParams(map);
    }

    public String getNetworkKey() {
        return this.networkKey;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends NetworkConfig> T withNetworkParams(Map<String, String> map) {
        this.networkParams.clear();
        if (map != null) {
            this.networkParams.putAll(map);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends NetworkConfig> T setNetworkParam(String str, String str2) {
        this.networkParams.put(str, str2);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends NetworkConfig> T withBaseMediationConfig(Map<String, String> map) {
        this.baseMediationConfig = map;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends NetworkConfig> T setBaseMediationParam(String str, String str2) {
        if (this.baseMediationConfig == null) {
            this.baseMediationConfig = new HashMap();
        }
        this.baseMediationConfig.put(str, str2);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <T extends NetworkConfig> T internalSetSkipInitialization(boolean z) {
        setNetworkParam(CONFIG_SKIP_INITIALIZATION, String.valueOf(z));
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends NetworkConfig> T withMediationConfig(AdsFormat adsFormat, Map<String, String> map) {
        if (map == null) {
            EnumMap<AdsFormat, List<Map<String, String>>> enumMap = this.typedMediationConfigs;
            if (enumMap != null) {
                enumMap.remove(adsFormat);
            }
        } else {
            if (this.typedMediationConfigs == null) {
                this.typedMediationConfigs = new EnumMap<>(AdsFormat.class);
            }
            List<Map<String, String>> arrayList = this.typedMediationConfigs.get(adsFormat);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.typedMediationConfigs.put(adsFormat, arrayList);
            }
            arrayList.add(map);
        }
        return this;
    }

    @Deprecated
    public <T extends NetworkConfig> T withMediationConfig(AdsFormat adsFormat, Map<String, String> map, Orientation orientation) {
        Logger.w("The parameter 'orientation' is no longer supported and has no effect.");
        return (T) withMediationConfig(adsFormat, map);
    }

    public NetworkConfig forAdTypes(AdsType... adsTypeArr) {
        this.supportedAdsTypes = adsTypeArr;
        return this;
    }

    public <T extends UnifiedAdRequestParams> List<NetworkAdUnit> createNetworkAdUnitList(AdsType adsType, T t, AdContentType adContentType, NetworkAdapter networkAdapter) {
        List list;
        ArrayList arrayList = new ArrayList();
        EnumMap<AdsFormat, List<Map<String, String>>> enumMap = this.typedMediationConfigs;
        if (enumMap != null) {
            Iterator it = enumMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                AdsFormat adsFormat = (AdsFormat) entry.getKey();
                if (adsFormat.isMatch(adsType, t, adContentType) && (list = (List) entry.getValue()) != null) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(new NetworkAdUnit(networkAdapter, adsFormat, prepareTypedMediationConfig((Map) it2.next())));
                    }
                }
            }
        }
        return arrayList;
    }

    AdsType[] getSupportedAdsTypes(NetworkAdapter networkAdapter) {
        if (this.mergedAdsTypes == null) {
            ArrayList arrayList = new ArrayList();
            for (AdsType adsType : networkAdapter.getSupportedTypes()) {
                AdsType[] adsTypeArr = this.supportedAdsTypes;
                if (adsTypeArr == null || contains(adsTypeArr, adsType)) {
                    arrayList.add(adsType);
                }
            }
            this.mergedAdsTypes = (AdsType[]) arrayList.toArray(new AdsType[0]);
        }
        return this.mergedAdsTypes;
    }

    NetworkConfigParams getNetworkConfigParams() {
        return this.networkConfigParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> prepareTypedMediationConfig(Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (useNetworkParamsAsMediationBase()) {
            map2.putAll(this.networkParams);
        }
        Map<String, String> map3 = this.baseMediationConfig;
        if (map3 != null) {
            map2.putAll(map3);
        }
        map2.putAll(map);
        return map2;
    }

    private boolean contains(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (obj2 == obj) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return getNetworkKey().equals(((NetworkConfig) obj).getNetworkKey());
    }

    public int hashCode() {
        return getNetworkKey().hashCode();
    }
}
