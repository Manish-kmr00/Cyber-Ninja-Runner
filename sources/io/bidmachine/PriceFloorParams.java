package io.bidmachine;

import io.bidmachine.models.IPriceFloorParams;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes8.dex */
public final class PriceFloorParams implements IPriceFloorParams<PriceFloorParams> {
    private final Map<String, Double> priceFloorsMap = new HashMap();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.IPriceFloorParams
    public PriceFloorParams addPriceFloor(double d) {
        addPriceFloor(UUID.randomUUID().toString(), d);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.IPriceFloorParams
    public PriceFloorParams addPriceFloor(String str, double d) {
        this.priceFloorsMap.put(str, Double.valueOf(d));
        return this;
    }

    Map<String, Double> getPriceFloors() {
        return this.priceFloorsMap;
    }
}
