package com.amazon.aps.ads.model;

import com.amazon.aps.ads.ApsMigrationUtil;
import com.amazon.device.ads.DtbPricePoint;

/* JADX INFO: loaded from: classes14.dex */
public class ApsPricepoint extends DtbPricePoint {
    private ApsAdType apsAdType;

    public ApsPricepoint(String str, String str2, String str3, ApsAdType apsAdType) {
        super(str, str2, str3, ApsMigrationUtil.getAdType(apsAdType));
        this.apsAdType = apsAdType;
    }
}
