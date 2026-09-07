package io.bidmachine.displays;

import com.explorestack.protobuf.adcom.Ad;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingAd;

/* JADX INFO: loaded from: classes13.dex */
class HeaderBiddingAdObjectParams extends AdObjectParams {
    @Override // io.bidmachine.models.AdObjectParams
    public boolean isValid() {
        return true;
    }

    HeaderBiddingAdObjectParams(Ad ad, HeaderBiddingAd headerBiddingAd) {
        super(ad);
        getData().putAll(headerBiddingAd.getClientParamsMap());
        getData().putAll(headerBiddingAd.getServerParamsMap());
    }
}
