package io.bidmachine.ads.networks.gam;

import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class GAMUnitData {
    private final String adUnitId;
    private final Map<String, String> customTargeting;
    private final float price;
    private final float score;

    public GAMUnitData(String str, float f, float f2, Map<String, String> map) {
        this.adUnitId = str;
        this.score = f;
        this.price = f2;
        this.customTargeting = map;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public float getScore() {
        return this.score;
    }

    public float getPrice() {
        return this.price;
    }

    public Map<String, String> getCustomTargeting() {
        return this.customTargeting;
    }

    public String toString() {
        return "adUnitId - " + this.adUnitId + ", score - " + this.score + ", price - " + this.price;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GAMUnitData gAMUnitData = (GAMUnitData) obj;
        return this.adUnitId.equals(gAMUnitData.adUnitId) && Float.compare(gAMUnitData.score, this.score) == 0 && Float.compare(gAMUnitData.price, this.price) == 0;
    }

    public int hashCode() {
        return (((this.adUnitId.hashCode() * 31) + Float.floatToIntBits(this.score)) * 31) + Float.floatToIntBits(this.price);
    }
}
