package net.pubnative.lite.sdk.models.bidstream;

import com.pubmatic.sdk.openwrap.core.POBConstants;

/* JADX INFO: loaded from: classes13.dex */
public class GeoLocation extends Signal {

    @BidParam(name = POBConstants.KEY_ACCURACY)
    public Integer accuracy;

    @BidParam(name = POBConstants.KEY_UTC_OFFSET)
    public Integer utcoffset;

    public GeoLocation() {
    }

    public GeoLocation(Integer num, Integer num2) {
        this.accuracy = num;
        this.utcoffset = num2;
    }
}
