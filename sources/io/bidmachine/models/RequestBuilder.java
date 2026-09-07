package io.bidmachine.models;

import io.bidmachine.AdRequest;
import io.bidmachine.CustomParams;
import io.bidmachine.NetworkConfig;
import io.bidmachine.PriceFloorParams;
import io.bidmachine.SessionAdParams;
import io.bidmachine.TargetingParams;
import io.bidmachine.models.RequestBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface RequestBuilder<SelfType extends RequestBuilder, ReturnType extends AdRequest> {
    ReturnType build();

    SelfType setBidPayload(String str);

    SelfType setCustomParams(CustomParams customParams);

    SelfType setListener(AdRequest.AdRequestListener<ReturnType> adRequestListener);

    SelfType setLoadingTimeOut(Integer num);

    SelfType setNetworks(String str);

    SelfType setNetworks(List<NetworkConfig> list);

    SelfType setPlacementId(String str);

    SelfType setPriceFloorParams(PriceFloorParams priceFloorParams);

    SelfType setSessionAdParams(SessionAdParams sessionAdParams);

    SelfType setTargetingParams(TargetingParams targetingParams);
}
