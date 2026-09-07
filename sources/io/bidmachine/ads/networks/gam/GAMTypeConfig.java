package io.bidmachine.ads.networks.gam;

import io.bidmachine.AdsFormat;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class GAMTypeConfig {
    private final AdsFormat adsFormat;
    private final int cacheSize;
    private final List<GAMUnitData> gamUnitDataList;

    public GAMTypeConfig(AdsFormat adsFormat, List<GAMUnitData> list, int i) {
        this.adsFormat = adsFormat;
        this.cacheSize = i;
        this.gamUnitDataList = list;
    }

    public AdsFormat getAdsFormat() {
        return this.adsFormat;
    }

    public List<GAMUnitData> getGAMUnitDataList() {
        return this.gamUnitDataList;
    }

    public int getCacheSize() {
        return this.cacheSize;
    }
}
