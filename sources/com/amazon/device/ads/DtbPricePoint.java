package com.amazon.device.ads;

import com.json.b9;
import io.bidmachine.iab.vast.tags.VastAttributes;

/* JADX INFO: loaded from: classes12.dex */
public class DtbPricePoint {
    private final DTBAdSize adSize;
    private final String pricePoint;

    public DtbPricePoint(String str, String str2, String str3, AdType adType) {
        this.pricePoint = str;
        String[] strArrSplit = str2.split(VastAttributes.HORIZONTAL_POSITION);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("AdSize " + str2 + " is not valid");
        }
        this.adSize = new DTBAdSize(DtbCommonUtils.parseInt(strArrSplit[0], 0), DtbCommonUtils.parseInt(strArrSplit[1], 0), adType, str3);
    }

    public String getPricePoint() {
        return this.pricePoint;
    }

    public DTBAdSize getAdSize() {
        return this.adSize;
    }

    public String toString() {
        return "DtbPricePoint [pricePoint=" + this.pricePoint + ", adSize=" + this.adSize + b9.i.e;
    }
}
