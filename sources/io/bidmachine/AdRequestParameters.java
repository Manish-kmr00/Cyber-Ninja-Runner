package io.bidmachine;

import com.explorestack.protobuf.adcom.Placement;
import io.bidmachine.protobuf.ResponsePayload;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AdRequestParameters {
    private final AdsFormat adsFormat;
    private ResponsePayload bidPayload;
    private CustomParams customParams;
    private List<NetworkConfig> networkConfigList;
    private String placementId;
    private PriceFloorParams priceFloorParams;
    private SessionAdParams sessionAdParams;
    private TargetingParams targetingParams;
    private Integer timeOutMs;

    public abstract boolean isPlacementObjectValid(Placement placement) throws Throwable;

    protected AdRequestParameters(AdsFormat adsFormat) {
        this.adsFormat = adsFormat;
    }

    public AdsType getAdsType() {
        return this.adsFormat.getAdsType();
    }

    public AdsFormat getAdsFormat() {
        return this.adsFormat;
    }

    public PriceFloorParams getPriceFloorParams() {
        return this.priceFloorParams;
    }

    void setPriceFloorParams(PriceFloorParams priceFloorParams) {
        this.priceFloorParams = priceFloorParams;
    }

    public TargetingParams getTargetingParams() {
        return this.targetingParams;
    }

    void setTargetingParams(TargetingParams targetingParams) {
        this.targetingParams = targetingParams;
    }

    public SessionAdParams getSessionAdParams() {
        return this.sessionAdParams;
    }

    void setSessionAdParams(SessionAdParams sessionAdParams) {
        this.sessionAdParams = sessionAdParams;
    }

    public List<NetworkConfig> getNetworkConfigList() {
        return this.networkConfigList;
    }

    void setNetworkConfigList(List<NetworkConfig> list) {
        this.networkConfigList = list;
    }

    public Integer getTimeOutMs() {
        return this.timeOutMs;
    }

    void setTimeOutMs(Integer num) {
        this.timeOutMs = num;
    }

    public ResponsePayload getBidPayload() {
        return this.bidPayload;
    }

    void setBidPayload(ResponsePayload responsePayload) {
        this.bidPayload = responsePayload;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    void setPlacementId(String str) {
        this.placementId = str;
    }

    public CustomParams getCustomParams() {
        return this.customParams;
    }

    void setCustomParams(CustomParams customParams) {
        this.customParams = customParams;
    }

    public boolean isParametersMatched(AdRequestParameters adRequestParameters) {
        return getAdsType() == adRequestParameters.getAdsType();
    }

    public boolean isPricePassedByPriceFloor(double d) {
        PriceFloorParams priceFloorParams = this.priceFloorParams;
        if (priceFloorParams == null) {
            return true;
        }
        Map<String, Double> priceFloors = priceFloorParams.getPriceFloors();
        if (priceFloors.isEmpty()) {
            return true;
        }
        Iterator<Double> it = priceFloors.values().iterator();
        while (it.hasNext()) {
            if (d > it.next().doubleValue()) {
                return true;
            }
        }
        return false;
    }
}
