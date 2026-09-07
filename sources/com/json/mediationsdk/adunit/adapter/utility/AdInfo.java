package com.json.mediationsdk.adunit.adapter.utility;

import com.json.am;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.json.mediationsdk.logger.IronLog;
import com.json.o9;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class AdInfo {
    private final ImpressionData mImpressionData;
    private final am mLoadArmData;

    public AdInfo() {
        this.mImpressionData = null;
        this.mLoadArmData = null;
    }

    public AdInfo(ImpressionData impressionData) {
        this.mImpressionData = impressionData;
        this.mLoadArmData = null;
    }

    public AdInfo(ImpressionData impressionData, am amVar) {
        this.mImpressionData = impressionData;
        this.mLoadArmData = amVar;
    }

    public String getAb() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getAb() == null) ? "" : this.mImpressionData.getAb();
    }

    public String getAdNetwork() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getAdNetwork() == null) ? "" : this.mImpressionData.getAdNetwork();
    }

    public String getAdUnit() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getAdUnit() == null) ? "" : this.mImpressionData.getAdUnit();
    }

    public String getAuctionId() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getAuctionId() == null) ? "" : this.mImpressionData.getAuctionId();
    }

    public String getCountry() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getCountry() == null) ? "" : this.mImpressionData.getCountry();
    }

    public String getEncryptedCPM() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getEncryptedCPM() == null) ? "" : this.mImpressionData.getEncryptedCPM();
    }

    public String getInstanceId() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getInstanceId() == null) ? "" : this.mImpressionData.getInstanceId();
    }

    public String getInstanceName() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getInstanceName() == null) ? "" : this.mImpressionData.getInstanceName();
    }

    public Double getLifetimeRevenue() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getLifetimeRevenue() == null) ? Double.valueOf(0.0d) : this.mImpressionData.getLifetimeRevenue();
    }

    public String getPrecision() {
        am amVar = this.mLoadArmData;
        if (amVar != null) {
            return amVar.c();
        }
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getPrecision() == null) ? "" : this.mImpressionData.getPrecision();
    }

    public Double getRevenue() {
        am amVar = this.mLoadArmData;
        if (amVar != null) {
            return Double.valueOf(amVar.d());
        }
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getRevenue() == null) ? Double.valueOf(0.0d) : this.mImpressionData.getRevenue();
    }

    public String getSegmentName() {
        ImpressionData impressionData = this.mImpressionData;
        return (impressionData == null || impressionData.getSegmentName() == null) ? "" : this.mImpressionData.getSegmentName();
    }

    public String toString() {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        try {
            jSONObjectJsonObjectInit.put("auctionId", getAuctionId());
            jSONObjectJsonObjectInit.put("adUnit", getAdUnit());
            jSONObjectJsonObjectInit.put("country", getCountry());
            jSONObjectJsonObjectInit.put(ImpressionData.IMPRESSION_DATA_KEY_ABTEST, getAb());
            jSONObjectJsonObjectInit.put(ImpressionData.IMPRESSION_DATA_KEY_SEGMENT_NAME, getSegmentName());
            jSONObjectJsonObjectInit.put(ImpressionData.IMPRESSION_DATA_KEY_AD_NETWORK, getAdNetwork());
            jSONObjectJsonObjectInit.put("instanceName", getInstanceName());
            jSONObjectJsonObjectInit.put("instanceId", getInstanceId());
            jSONObjectJsonObjectInit.put("revenue", getRevenue());
            jSONObjectJsonObjectInit.put("precision", getPrecision());
            jSONObjectJsonObjectInit.put(ImpressionData.IMPRESSION_DATA_KEY_LIFETIME_REVENUE, getLifetimeRevenue());
            jSONObjectJsonObjectInit.put(ImpressionData.IMPRESSION_DATA_KEY_ENCRYPTED_CPM, getEncryptedCPM());
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error("error while parsing ad info " + e.getMessage());
        }
        return jSONObjectJsonObjectInit.toString();
    }
}
