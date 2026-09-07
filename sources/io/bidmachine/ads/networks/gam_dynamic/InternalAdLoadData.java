package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.protobuf.Waterfall;

/* JADX INFO: loaded from: classes8.dex */
public class InternalAdLoadData {
    private final String adResponse;
    private final Waterfall.Result.EstimatedPrice price;

    public InternalAdLoadData(Waterfall.Result.EstimatedPrice estimatedPrice, String str) {
        this.price = estimatedPrice;
        this.adResponse = str;
    }

    public Waterfall.Result.EstimatedPrice getPrice() {
        return this.price;
    }

    public String getAdResponse() {
        return this.adResponse;
    }
}
