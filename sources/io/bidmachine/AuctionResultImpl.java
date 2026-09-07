package io.bidmachine;

import android.text.TextUtils;
import com.explorestack.protobuf.adcom.Ad;
import com.explorestack.protobuf.openrtb.Response;
import io.bidmachine.models.AuctionResult;
import io.bidmachine.protobuf.AdExtension;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingAd;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class AuctionResultImpl implements AuctionResult {
    private final String[] adDomains;
    private final String cid;
    private final CreativeFormat creativeFormat;
    private final String creativeId;
    private final Map<String, String> customParams;
    private final String deal;
    private final String demandSource;
    private final String id;
    private final String networkKey;
    private final Map<String, String> networkParams;
    private final double price;

    AuctionResultImpl(AdsType adsType, Response.Seatbid seatbid, Response.Seatbid.Bid bid, Ad ad, NetworkAdapter networkAdapter, AdExtension adExtension) {
        this.id = bid.getId();
        this.demandSource = seatbid.getSeat();
        this.price = bid.getPrice();
        this.deal = bid.getDeal();
        this.creativeId = ad.getId();
        this.cid = bid.getCid();
        if (ad.getAdomainCount() > 0) {
            this.adDomains = (String[]) ad.getAdomainList().toArray(new String[0]);
        } else {
            this.adDomains = null;
        }
        this.customParams = createCustomParams(adExtension);
        this.networkKey = networkAdapter.getKey();
        this.networkParams = createClientParams(adsType.obtainHeaderBiddingAd(ad));
        this.creativeFormat = identifyCreativeFormat(ad);
    }

    @Override // io.bidmachine.models.AuctionResult
    public String getId() {
        return this.id;
    }

    @Override // io.bidmachine.models.AuctionResult
    public String getDemandSource() {
        return this.demandSource;
    }

    @Override // io.bidmachine.models.AuctionResult
    public double getPrice() {
        return this.price;
    }

    @Override // io.bidmachine.models.AuctionResult
    public String getDeal() {
        return this.deal;
    }

    @Override // io.bidmachine.models.AuctionResult
    public String getCreativeId() {
        return this.creativeId;
    }

    @Override // io.bidmachine.models.AuctionResult
    public String getCid() {
        return this.cid;
    }

    @Override // io.bidmachine.models.AuctionResult
    public String[] getAdDomains() {
        return this.adDomains;
    }

    @Override // io.bidmachine.models.AuctionResult
    public String getNetworkKey() {
        return this.networkKey;
    }

    @Override // io.bidmachine.models.AuctionResult
    public Map<String, String> getNetworkParams() {
        return this.networkParams;
    }

    @Override // io.bidmachine.models.AuctionResult
    public CreativeFormat getCreativeFormat() {
        return this.creativeFormat;
    }

    @Override // io.bidmachine.models.AuctionResult
    public Map<String, String> getCustomParams() {
        return this.customParams;
    }

    public String toString() {
        return "id=" + this.id + ", demandSource=" + this.demandSource + ", price=" + this.price + ", creativeId=" + this.creativeId + ", cid=" + this.cid;
    }

    private Map<String, String> createCustomParams(AdExtension adExtension) {
        HashMap map = new HashMap();
        if (adExtension != null) {
            try {
                map.putAll(adExtension.getCustomParamsMap());
            } catch (Exception unused) {
            }
        }
        return map;
    }

    Map<String, String> createClientParams(HeaderBiddingAd headerBiddingAd) {
        Map<String, String> clientParamsMap;
        HashMap map = new HashMap();
        if (headerBiddingAd != null && (clientParamsMap = headerBiddingAd.getClientParamsMap()) != null) {
            map.putAll(clientParamsMap);
        }
        return map;
    }

    static CreativeFormat identifyCreativeFormat(Ad ad) {
        if (ad.hasDisplay()) {
            Ad.Display display = ad.getDisplay();
            if (display.hasBanner() || !TextUtils.isEmpty(display.getAdm())) {
                return CreativeFormat.Banner;
            }
            if (display.hasNative()) {
                return CreativeFormat.Native;
            }
            return null;
        }
        if (ad.hasVideo()) {
            return CreativeFormat.Video;
        }
        return null;
    }
}
