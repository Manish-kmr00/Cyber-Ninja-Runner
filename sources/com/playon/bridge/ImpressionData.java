package com.playon.bridge;

/* JADX INFO: loaded from: classes6.dex */
public class ImpressionData {
    AdUnit.AdUnitType adType;
    String country;
    String placementID;
    double revenue;
    String sessionID;

    ImpressionData(AdUnit.AdUnitType adUnitType, String str, String str2, String str3, double d) {
        this.adType = adUnitType;
        this.placementID = str;
        this.sessionID = str2;
        this.country = str3;
        this.revenue = d;
    }

    public AdUnit.AdUnitType getAdType() {
        return this.adType;
    }

    public String getPlacementID() {
        return this.placementID;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public String getCountry() {
        return this.country;
    }

    public double getRevenue() {
        return this.revenue;
    }
}
