package com.pubmatic.sdk.openwrap.core;

import com.json.m5;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.log.POBLogConstants;
import com.pubmatic.sdk.common.models.POBDSATransparencyInfo;
import com.pubmatic.sdk.common.models.POBImpressionCountingMethod;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class POBBid implements POBAdDescriptor {
    private boolean C;
    private String D;
    private List E;
    private String b;
    private String c;
    private double d;
    private int e;
    private int f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private int m;
    private int n;
    private List o;
    private Map p;
    private JSONObject q;
    private String r;
    private String s;
    private String t;
    private String u;
    private boolean v;
    private List w;
    private boolean x;
    private long y;
    private boolean z;
    private POBImpressionCountingMethod B = POBImpressionCountingMethod.ON_LOAD;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f7724a = System.currentTimeMillis();
    private String A = POBAdDescriptor.DYNAMIC_PRICE_BID;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final POBBid f7725a;
        private String b;
        private String c;
        private int d;
        private int e;
        private String f;
        private int g;

        public Builder(POBBid pOBBid) {
            this.f7725a = pOBBid;
            this.b = pOBBid.s;
            this.c = pOBBid.h;
            this.d = pOBBid.m;
            this.e = pOBBid.n;
            this.f = pOBBid.A;
            this.g = pOBBid.e;
        }

        public POBBid build() {
            POBBid pOBBid = this.f7725a;
            POBBid pOBBidCreate = POBBid.create(pOBBid, pOBBid.p);
            pOBBidCreate.s = this.b;
            pOBBidCreate.h = this.c;
            pOBBidCreate.m = this.d;
            pOBBidCreate.n = this.e;
            pOBBidCreate.A = this.f;
            pOBBidCreate.e = this.g;
            return pOBBidCreate;
        }

        public Builder setBidStatus(int i) {
            this.g = i;
            return this;
        }

        public Builder setBidType(String str) {
            this.f = str;
            return this;
        }

        public Builder setCreativeType(String str) {
            this.b = str;
            return this;
        }

        public Builder setHeight(int i) {
            this.e = i;
            return this;
        }

        public Builder setPartnerId(String str) {
            this.c = str;
            return this;
        }

        public Builder setWidth(int i) {
            this.d = i;
            return this;
        }
    }

    private POBBid() {
    }

    public static POBBid build(String str, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        JSONArray jSONArrayOptJSONArray;
        int i;
        List list;
        POBBid pOBBid = new POBBid();
        pOBBid.q = jSONObject;
        pOBBid.b = jSONObject.optString(POBConstants.KEY_IMPRESSION_ID);
        pOBBid.c = jSONObject.optString("id");
        pOBBid.j = jSONObject.optString("adm");
        pOBBid.i = jSONObject.optString("crid");
        pOBBid.g = str;
        double dOptDouble = jSONObject.optDouble("price", 0.0d);
        pOBBid.d = dOptDouble;
        pOBBid.e = dOptDouble > 0.0d ? 1 : 0;
        String strOptString = jSONObject.optString("dealid");
        if (!POBUtils.isNullOrEmpty(strOptString)) {
            pOBBid.k = strOptString;
        }
        pOBBid.l = jSONObject.optString(m5.A);
        pOBBid.m = jSONObject.optInt("w");
        pOBBid.n = jSONObject.optInt("h");
        pOBBid.r = jSONObject.optString(m5.z);
        pOBBid.D = jSONObject.optString(POBConstants.KEY_BUNDLE, null);
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("ext");
        if (jSONObjectOptJSONObject4 != null) {
            pOBBid.z = jSONObjectOptJSONObject4.optInt(Reporting.EventType.WINNER) == 1;
            String strOptString2 = jSONObjectOptJSONObject4.optString("crtype");
            pOBBid.s = strOptString2;
            pOBBid.x = "video".equals(strOptString2);
            if (jSONObjectOptJSONObject4.optInt(POBConstants.KEY_IMP_CT_MTHD, 0) == 1) {
                pOBBid.B = POBImpressionCountingMethod.ONE_PX_VIEWABLE;
            } else {
                pOBBid.B = POBImpressionCountingMethod.ON_LOAD;
            }
            int iOptInt = jSONObjectOptJSONObject4.optInt(POBConstants.KEY_REFRESH_INTERVAL, 0);
            JSONObject jSONObjectOptJSONObject5 = pOBBid.x ? jSONObjectOptJSONObject4.optJSONObject("video") : jSONObjectOptJSONObject4.optJSONObject("banner");
            if (jSONObjectOptJSONObject5 != null && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject5.optJSONObject(POBConstants.KEY_CLIENT_CONFIG)) != null) {
                iOptInt = jSONObjectOptJSONObject2.optInt("refreshinterval", iOptInt);
                if (pOBBid.x && (jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("reward")) != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray("rewards")) != null && jSONArrayOptJSONArray.length() > 0) {
                    pOBBid.o = new ArrayList(jSONArrayOptJSONArray.length());
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray.optJSONObject(i2);
                        if (jSONObjectOptJSONObject6 != null && jSONObjectOptJSONObject6.has("type") && jSONObjectOptJSONObject6.has("value")) {
                            String strOptString3 = jSONObjectOptJSONObject6.optString("type", "");
                            try {
                                i = Integer.parseInt(jSONObjectOptJSONObject6.optString("value"));
                            } catch (NumberFormatException unused) {
                                POBLog.warn("POBBid", POBLogConstants.MSG_INVALID_REWARD_RECEIVED, new Object[0]);
                                i = 0;
                            }
                            if (i > 0 && (list = pOBBid.o) != null) {
                                list.add(new POBReward(strOptString3, i));
                            }
                        }
                    }
                }
            }
            pOBBid.f = POBUtils.getValidRefreshInterval(iOptInt, 5);
            JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject4.optJSONObject(POBConstants.KEY_PREBID);
            if (jSONObjectOptJSONObject7 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject7.optJSONObject("targeting")) != null) {
                try {
                    pOBBid.p = new HashMap(4);
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String string = jSONObjectOptJSONObject.getString(next);
                        Map map = pOBBid.p;
                        if (map != null) {
                            map.put(next, string);
                        }
                    }
                } catch (JSONException e) {
                    POBLog.error("POBBid", "Exception on parsing prebid object : " + e.getMessage(), new Object[0]);
                }
            }
            JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject4.optJSONObject(POBConstants.KEY_DSA);
            if (jSONObjectOptJSONObject8 != null) {
                pOBBid.t = jSONObjectOptJSONObject8.optString("behalf");
                pOBBid.u = jSONObjectOptJSONObject8.optString(POBConstants.KEY_PAID);
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject8.optJSONArray("transparency");
                if (jSONArrayOptJSONArray2 != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                        POBDSATransparencyInfo pOBDSATransparencyInfoBuild = POBDSATransparencyInfo.build(jSONArrayOptJSONArray2.optJSONObject(i3));
                        if (pOBDSATransparencyInfoBuild != null) {
                            arrayList.add(pOBDSATransparencyInfoBuild);
                        }
                    }
                    pOBBid.w = arrayList;
                }
                pOBBid.v = jSONObjectOptJSONObject8.optInt("adrender", 0) == 0;
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject4.optJSONArray(POBNativeConstants.NATIVE_CLICK_TRACKER);
            if (!POBUtils.isJsonArrayNullOrEmpty(jSONArrayOptJSONArray3)) {
                pOBBid.E = new ArrayList(jSONArrayOptJSONArray3.length());
                for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                    pOBBid.E.add(jSONArrayOptJSONArray3.optString(i4));
                }
            }
        }
        return pOBBid;
    }

    public static POBBid create(POBBid pOBBid, Map<String, String> map) {
        POBBid pOBBid2 = new POBBid();
        a(pOBBid2, pOBBid);
        Map map2 = pOBBid.p;
        if (map2 == null || map2.isEmpty()) {
            pOBBid2.p = map;
        } else {
            pOBBid2.p = pOBBid.p;
        }
        return pOBBid2;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public POBAdDescriptor buildWithRefreshAndExpiryTimeout(int i, int i2) {
        POBBid pOBBidCreate = create(this, this.p);
        pOBBidCreate.f = i;
        pOBBidCreate.y = i2;
        return pOBBidCreate;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public boolean enableDsaInfoIcon() {
        return this.v && !(POBUtils.isNullOrEmpty(this.t) && POBUtils.isNullOrEmpty(this.u));
    }

    public boolean equals(Object obj) {
        String str;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof POBBid) || (str = this.c) == null) {
            return false;
        }
        return str.equals(((POBBid) obj).getId());
    }

    public List<POBReward> getAllRewards() {
        return this.o;
    }

    public String getBidType() {
        return this.A;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public String getBundle() {
        return this.D;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public List<String> getClickTrackers() {
        return this.E;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public int getContentHeight() {
        return this.n;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public int getContentWidth() {
        return this.m;
    }

    public String getCreative() {
        return this.j;
    }

    public String getCreativeId() {
        return this.i;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public String getCreativeType() {
        return this.s;
    }

    public String getDealId() {
        return this.k;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public String getDisplayedOnBehalfOf() {
        return this.t;
    }

    public POBReward getFirstReward() {
        List list = this.o;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (POBReward) this.o.get(0);
    }

    public int getHeight() {
        return this.n;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public String getId() {
        return this.c;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public POBImpressionCountingMethod getImpressionCountingMethod() {
        return this.B;
    }

    public String getImpressionId() {
        return this.b;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public String getPaidBy() {
        return this.u;
    }

    public String getPartnerId() {
        return this.h;
    }

    public String getPartnerName() {
        return this.g;
    }

    public double getPrice() {
        return this.d;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public JSONObject getRawBid() {
        return this.q;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public int getRefreshInterval() {
        return this.f;
    }

    public int getRemainingExpirationTime() {
        return (int) (this.y - (System.currentTimeMillis() - this.f7724a));
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public String getRenderableContent() {
        return this.j;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public int getStatus() {
        return this.e;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public Map<String, String> getTargetingInfo() {
        if (this.e == 1) {
            return this.p;
        }
        return null;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public List<POBDSATransparencyInfo> getTransparencyData() {
        return this.w;
    }

    public int getWidth() {
        return this.m;
    }

    public String getlURL() {
        return this.r;
    }

    public String getnURL() {
        return this.l;
    }

    public boolean hasWon() {
        return this.C;
    }

    public int hashCode() {
        return (this.q + this.b + this.e).hashCode();
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public boolean isCompanion() {
        return false;
    }

    public boolean isExpired() {
        return getRemainingExpirationTime() <= 0;
    }

    public boolean isServerSideAuctionWinner() {
        return this.z;
    }

    public boolean isStaticBid() {
        return "static".equals(this.A);
    }

    @Override // com.pubmatic.sdk.common.base.POBAdDescriptor
    public boolean isVideo() {
        return this.x;
    }

    public void setHasWon(boolean z) {
        this.C = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Price=");
        sb.append(this.d);
        sb.append("PartnerName=");
        sb.append(this.g);
        sb.append("impressionId");
        sb.append(this.b);
        sb.append("bidId");
        sb.append(this.c);
        sb.append("creativeId=");
        sb.append(this.i);
        if (this.o != null) {
            sb.append("Reward List:");
            sb.append(this.o.toString());
        }
        if (this.p != null) {
            sb.append(" Prebid targeting Info:");
            sb.append(this.p.toString());
        }
        return sb.toString();
    }

    private static void a(POBBid pOBBid, POBBid pOBBid2) {
        pOBBid.b = pOBBid2.b;
        pOBBid.c = pOBBid2.c;
        pOBBid.d = pOBBid2.d;
        pOBBid.e = pOBBid2.e;
        pOBBid.f = pOBBid2.f;
        pOBBid.y = pOBBid2.y;
        pOBBid.g = pOBBid2.g;
        pOBBid.i = pOBBid2.i;
        pOBBid.j = pOBBid2.j;
        pOBBid.k = pOBBid2.k;
        pOBBid.l = pOBBid2.l;
        pOBBid.m = pOBBid2.m;
        pOBBid.n = pOBBid2.n;
        pOBBid.o = pOBBid2.o;
        pOBBid.x = pOBBid2.x;
        pOBBid.s = pOBBid2.s;
        pOBBid.h = pOBBid2.h;
        pOBBid.z = pOBBid2.z;
        pOBBid.q = pOBBid2.q;
        pOBBid.r = pOBBid2.r;
        pOBBid.A = pOBBid2.A;
        pOBBid.D = pOBBid2.D;
        pOBBid.C = pOBBid2.C;
        pOBBid.p = pOBBid2.p;
        pOBBid.t = pOBBid2.t;
        pOBBid.u = pOBBid2.u;
        pOBBid.v = pOBBid2.v;
        pOBBid.w = pOBBid2.w;
        pOBBid.B = pOBBid2.B;
        pOBBid.E = pOBBid2.E;
    }
}
