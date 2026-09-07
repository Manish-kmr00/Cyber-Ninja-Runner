package com.pubmatic.sdk.common.models;

import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.base.POBBidsProvider;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.utility.POBUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class POBAdResponse<T extends POBAdDescriptor> implements POBBidsProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f7573a;
    private Integer b;
    private List c;
    private POBAdDescriptor d;
    private POBAdDescriptor e;
    private int f;
    private JSONObject g;
    private boolean h;

    public static <T extends POBAdDescriptor> POBAdResponse<T> defaultResponse() {
        POBAdResponse<T> pOBAdResponse = new POBAdResponse<>();
        ((POBAdResponse) pOBAdResponse).f7573a = new ArrayList();
        ((POBAdResponse) pOBAdResponse).f = 30;
        return pOBAdResponse;
    }

    public POBAdDescriptor getBid(String str) {
        if (POBUtils.isNullOrEmpty(str)) {
            return null;
        }
        for (POBAdDescriptor pOBAdDescriptor : this.f7573a) {
            if (str.equals(pOBAdDescriptor.getId())) {
                return pOBAdDescriptor;
            }
        }
        return null;
    }

    public List<T> getBids() {
        return this.f7573a;
    }

    public JSONObject getCustomData() {
        return this.g;
    }

    @Override // com.pubmatic.sdk.common.base.POBBidsProvider
    public Integer getNbrCode() {
        return this.b;
    }

    public T getNextHighestDynamicBid() {
        return (T) this.e;
    }

    public int getRefreshInterval() {
        return this.f;
    }

    public List<T> getServerSidePartnerBids() {
        return this.c;
    }

    @Override // com.pubmatic.sdk.common.base.POBBidsProvider
    public Map<String, String> getTargetingInfo() {
        Map<String, String> targetingInfo;
        Map<String, String> targetingInfo2;
        HashMap map = new HashMap();
        if (this.h) {
            for (T t : getBids()) {
                if (t != null && (targetingInfo2 = t.getTargetingInfo()) != null) {
                    try {
                        map.putAll(targetingInfo2);
                    } catch (ClassCastException | IllegalArgumentException | NullPointerException | UnsupportedOperationException unused) {
                        POBLog.error("POBAdResponse", "Failed to add targeting info", new Object[0]);
                    }
                }
            }
        } else {
            POBAdDescriptor pOBAdDescriptor = this.d;
            if (pOBAdDescriptor != null && (targetingInfo = pOBAdDescriptor.getTargetingInfo()) != null) {
                map.putAll(targetingInfo);
            }
        }
        if (map.size() == 0) {
            return null;
        }
        return map;
    }

    public T getWinningBid() {
        return (T) this.d;
    }

    public boolean isSendAllBidsEnabled() {
        return this.h;
    }

    public static class Builder<T extends POBAdDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f7574a;
        private Integer b;
        private List c;
        private POBAdDescriptor d;
        private POBAdDescriptor e;
        private int f;
        private JSONObject g;
        private boolean h;

        public Builder(List<T> list) {
            this.f7574a = list;
        }

        private List a(List list, String str) {
            POBAdDescriptor pOBAdDescriptorBuildWithRefreshAndExpiryTimeout;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                POBAdDescriptor pOBAdDescriptor = (POBAdDescriptor) it.next();
                if (pOBAdDescriptor != null && (pOBAdDescriptorBuildWithRefreshAndExpiryTimeout = pOBAdDescriptor.buildWithRefreshAndExpiryTimeout(this.f, a(pOBAdDescriptor, str))) != null) {
                    arrayList.add(pOBAdDescriptorBuildWithRefreshAndExpiryTimeout);
                }
            }
            list.clear();
            list.addAll(arrayList);
            return list;
        }

        public POBAdResponse<T> build() {
            POBAdResponse<T> pOBAdResponse = new POBAdResponse<>();
            ((POBAdResponse) pOBAdResponse).f7573a = this.f7574a;
            ((POBAdResponse) pOBAdResponse).b = this.b;
            ((POBAdResponse) pOBAdResponse).c = this.c;
            ((POBAdResponse) pOBAdResponse).d = this.d;
            ((POBAdResponse) pOBAdResponse).f = this.f;
            ((POBAdResponse) pOBAdResponse).g = this.g;
            ((POBAdResponse) pOBAdResponse).h = this.h;
            ((POBAdResponse) pOBAdResponse).e = this.e;
            return pOBAdResponse;
        }

        public Builder<T> setNbrCode(Integer num) {
            this.b = num;
            return this;
        }

        public Builder<T> setNextHighestDynamicBid(T t) {
            this.e = t;
            return this;
        }

        public Builder<T> setRefreshInterval(int i) {
            this.f = i;
            return this;
        }

        public Builder<T> setSendAllBidsState(boolean z) {
            this.h = z;
            return this;
        }

        public Builder<T> setServerSidePartnerBids(List<T> list) {
            this.c = list;
            return this;
        }

        public Builder<T> setWinningBid(T t) {
            this.d = t;
            return this;
        }

        public Builder<T> updateWinningBid(T t) {
            if (this.f7574a.remove(t)) {
                this.f7574a.add(t);
            }
            List list = this.c;
            if (list != null && list.remove(t)) {
                this.c.add(t);
            }
            this.d = t;
            return this;
        }

        public Builder<T> updateWithRefreshIntervalAndExpiryTimeout(String str) {
            List list = this.c;
            if (list != null) {
                a(list, str);
            }
            a(this.f7574a, str);
            POBAdDescriptor pOBAdDescriptor = this.d;
            if (pOBAdDescriptor != null) {
                this.d = pOBAdDescriptor.buildWithRefreshAndExpiryTimeout(this.f, a(pOBAdDescriptor, str));
            }
            return this;
        }

        public Builder(POBAdResponse<T> pOBAdResponse) {
            this.f7574a = ((POBAdResponse) pOBAdResponse).f7573a;
            this.b = ((POBAdResponse) pOBAdResponse).b;
            this.c = ((POBAdResponse) pOBAdResponse).c;
            this.d = ((POBAdResponse) pOBAdResponse).d;
            this.f = ((POBAdResponse) pOBAdResponse).f;
            this.g = ((POBAdResponse) pOBAdResponse).g;
            this.h = ((POBAdResponse) pOBAdResponse).h;
            this.e = ((POBAdResponse) pOBAdResponse).e;
        }

        public Builder(JSONObject jSONObject) {
            this.f7574a = new ArrayList();
            this.g = jSONObject;
        }

        private int a(POBAdDescriptor pOBAdDescriptor, String str) {
            String str2;
            int iHashCode = str.hashCode();
            if (iHashCode != -1183997287) {
                if (iHashCode != -1052618729) {
                    str2 = iHashCode == 604727084 ? "interstitial" : "native";
                }
                str.equals(str2);
            } else if (str.equals(POBCommonConstants.BANNER_PLACEMENT_TYPE) && !pOBAdDescriptor.isVideo()) {
                return POBCommonConstants.BANNER_BID_EXPIRE_TIME_IN_MILLIS;
            }
            return 3600000;
        }
    }

    private POBAdResponse() {
        this.f7573a = new ArrayList();
    }
}
