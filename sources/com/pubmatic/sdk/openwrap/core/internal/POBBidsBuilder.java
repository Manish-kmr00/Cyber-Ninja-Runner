package com.pubmatic.sdk.openwrap.core.internal;

import com.pubmatic.sdk.common.base.POBAdBuilding;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.models.POBAdResponse;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.openwrap.core.POBBid;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class POBBidsBuilder implements POBAdBuilding<POBBid> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7743a;
    private String b;
    private int c;
    private int d;
    private String e;
    private POBAdBuilding.POBAdBuilderListener f;

    private JSONArray a(JSONObject jSONObject) {
        if (POBUtils.isJsonObjectNullOrEmpty(jSONObject)) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(POBConstants.KEY_PREBID);
        if (POBUtils.isJsonObjectNullOrEmpty(jSONObjectOptJSONObject)) {
            return null;
        }
        return jSONObjectOptJSONObject.optJSONArray("seatnonbid");
    }

    @Override // com.pubmatic.sdk.common.base.POBAdBuilding
    public void build(POBAdResponse<POBBid> pOBAdResponse) {
        JSONObject jSONObject;
        if (this.f == null) {
            POBLog.error("POBBidsBuilder", "Listener is null, execution of Wrapper ad builder gets break.", new Object[0]);
            return;
        }
        POBAdResponse.Builder builder = new POBAdResponse.Builder(pOBAdResponse);
        JSONObject customData = pOBAdResponse.getCustomData();
        if (customData != null) {
            try {
                builder.setNbrCode(Integer.valueOf(customData.getInt("nbr")));
            } catch (ClassCastException | JSONException unused) {
                POBLog.info("POBBidsBuilder", "Unable to fetch nbr error code from the ad response", new Object[0]);
            }
            try {
                jSONObject = customData.getJSONObject("ext");
                try {
                    builder.setSendAllBidsState(jSONObject.optInt("sendallbids") != 0);
                } catch (JSONException unused2) {
                    POBLog.error("POBBidsBuilder", "Unable to fetch logger and tracker details", new Object[0]);
                }
            } catch (JSONException unused3) {
                jSONObject = null;
            }
            List<T> bids = pOBAdResponse.getBids();
            JSONArray jSONArrayOptJSONArray = customData.optJSONArray("seatbid");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("bid");
                        String strOptString = jSONObjectOptJSONObject.optString("seat");
                        if (strOptString.isEmpty()) {
                            strOptString = this.f7743a;
                        }
                        if (jSONArrayOptJSONArray2 != null) {
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                POBBid pOBBidBuild = POBBid.build(strOptString, jSONArrayOptJSONArray2.optJSONObject(i2));
                                if (POBUtils.isNullOrEmpty(pOBBidBuild.getId())) {
                                    POBLog.warn("POBBidsBuilder", "Bid id is invalid and hence ignoring this OW bid.", new Object[0]);
                                } else {
                                    POBBid.Builder builder2 = new POBBid.Builder(pOBBidBuild);
                                    if (POBUtils.isNullOrEmpty(pOBBidBuild.getCreativeType())) {
                                        builder2.setCreativeType(this.e);
                                    }
                                    if (POBUtils.isNullOrEmpty(pOBBidBuild.getPartnerId())) {
                                        builder2.setPartnerId(this.b);
                                    }
                                    if (pOBBidBuild.getWidth() == 0) {
                                        builder2.setWidth(this.c);
                                    }
                                    if (pOBBidBuild.getHeight() == 0) {
                                        builder2.setHeight(this.d);
                                    }
                                    bids.add(builder2.build());
                                }
                            }
                        }
                    }
                }
            }
            JSONArray jSONArrayA = a(jSONObject);
            if (!POBUtils.isJsonArrayNullOrEmpty(jSONArrayA)) {
                POBLog.debug("POBBidsBuilder", "Received Seat Non Bids: %s", jSONArrayA.toString());
            }
            if (bids.size() > 0) {
                builder.setRefreshInterval(((POBBid) bids.get(0)).getRefreshInterval());
            }
            this.f.adBuilderOnSuccess(builder.build());
        }
    }

    public String getPartnerId() {
        return this.b;
    }

    public void setCreativeType(String str) {
        this.e = str;
    }

    public void setHeight(int i) {
        this.d = i;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdBuilding
    public void setListener(POBAdBuilding.POBAdBuilderListener<POBBid> pOBAdBuilderListener) {
        this.f = pOBAdBuilderListener;
    }

    public void setPartnerId(String str) {
        this.b = str;
    }

    public void setPartnerName(String str) {
        this.f7743a = str;
    }

    public void setWidth(int i) {
        this.c = i;
    }
}
