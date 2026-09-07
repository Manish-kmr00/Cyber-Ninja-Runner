package io.bidmachine.displays;

import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.adcom.Ad;
import io.bidmachine.AdContentType;
import io.bidmachine.AdsType;
import io.bidmachine.ContextProvider;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.NetworkConfig;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingAd;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacement;
import io.bidmachine.unified.UnifiedAdRequestParams;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public abstract class PlacementBuilder<UnifiedAdRequestParamsType extends UnifiedAdRequestParams> {
    private final AdContentType contentType;
    private final HeaderBiddingPlacementBuilder<UnifiedAdRequestParamsType> headerBiddingPlacementBuilder = new HeaderBiddingPlacementBuilder<>();

    public abstract AdObjectParams createAdObjectParams(Ad ad);

    public abstract Message.Builder createPlacement(ContextProvider contextProvider, UnifiedAdRequestParamsType unifiedadrequestparamstype, AdsType adsType, Collection<NetworkConfig> collection, List<NetworkAdUnit> list, int i) throws Exception;

    PlacementBuilder(AdContentType adContentType) {
        this.contentType = adContentType;
    }

    public AdContentType getAdContentType() {
        return this.contentType;
    }

    public HeaderBiddingAd obtainHeaderBiddingAd(Ad ad) {
        return this.headerBiddingPlacementBuilder.obtainHeaderBiddingAd(ad);
    }

    HeaderBiddingPlacement.Builder createHeaderBiddingPlacement(ContextProvider contextProvider, UnifiedAdRequestParamsType unifiedadrequestparamstype, AdsType adsType, Collection<NetworkConfig> collection, List<NetworkAdUnit> list, int i) {
        return this.headerBiddingPlacementBuilder.createPlacement(contextProvider, unifiedadrequestparamstype, adsType, getAdContentType(), collection, list, i);
    }

    AdObjectParams createHeaderBiddingAdObjectParams(Ad ad) {
        return this.headerBiddingPlacementBuilder.createAdObjectParams(ad);
    }
}
