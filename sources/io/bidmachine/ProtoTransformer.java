package io.bidmachine;

import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.adcom.Ad;
import com.explorestack.protobuf.openrtb.Response;
import io.bidmachine.core.Logger;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes9.dex */
class ProtoTransformer {

    interface Listener<AdResponse> {
        void onFail(BMError bMError);

        void onSuccess(AdResponse adresponse);
    }

    ProtoTransformer() {
    }

    static void toAdResponse(AdRequestParameters adRequestParameters, NetworkAdUnitManager networkAdUnitManager, Response response, Listener<AdResponse> listener) {
        if (response == null || response.getSeatbidCount() == 0) {
            listener.onFail(BMError.notFound("Response"));
            return;
        }
        Response.Seatbid seatbid = response.getSeatbid(0);
        if (seatbid == null || seatbid.getBidCount() == 0) {
            listener.onFail(BMError.notFound("Seatbid"));
            return;
        }
        Response.Seatbid.Bid bid = seatbid.getBid(0);
        if (bid == null) {
            listener.onFail(BMError.notFound("Bid"));
            return;
        }
        Any media = bid.getMedia();
        if (media == null) {
            listener.onFail(BMError.notFound("Media"));
            return;
        }
        if (!media.is(Ad.class)) {
            listener.onFail(BMError.incorrectContent("Media not valid"));
            return;
        }
        try {
            Ad ad = (Ad) media.unpack(Ad.class);
            if (ad == null) {
                listener.onFail(BMError.notFound("Ad"));
                return;
            }
            NetworkAdapter networkAdapterFindNetworkAdapter = adRequestParameters.getAdsType().findNetworkAdapter(ad);
            if (networkAdapterFindNetworkAdapter == null) {
                listener.onFail(BMError.notFound("NetworkAdapter"));
            } else {
                listener.onSuccess(new AdResponse(adRequestParameters, networkAdUnitManager, response, seatbid, bid, ad, networkAdapterFindNetworkAdapter));
            }
        } catch (Throwable th) {
            Logger.w(th);
            listener.onFail(BMError.throwable("Failed to process response", th));
        }
    }
}
