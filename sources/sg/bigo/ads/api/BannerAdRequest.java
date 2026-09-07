package sg.bigo.ads.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes8.dex */
public class BannerAdRequest extends b<BannerAdRequest> {
    public final List<AdSize> h;

    public static class Builder extends c<Builder, BannerAdRequest> {
        private List<AdSize> mAdSizes;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // sg.bigo.ads.api.c
        public BannerAdRequest createAdRequest() {
            return new BannerAdRequest(this.mSlotId, this.mAdSizes, this.mServerBidPayload);
        }

        public Builder withAdSizes(AdSize... adSizeArr) {
            this.mAdSizes = Arrays.asList(adSizeArr);
            return this;
        }
    }

    BannerAdRequest(String str, List<AdSize> list, String str2) {
        super(str, str2);
        this.h = new ArrayList();
        if (list != null) {
            for (AdSize adSize : list) {
                if (adSize != null) {
                    this.h.add(adSize);
                }
            }
        }
    }

    @Override // sg.bigo.ads.api.b
    public final /* synthetic */ b a() {
        BannerAdRequest bannerAdRequest = new BannerAdRequest(this.f13094a, new ArrayList(this.h), this.b);
        bannerAdRequest.a(this.g.f13095a);
        bannerAdRequest.c = this.c;
        return bannerAdRequest;
    }

    @Override // sg.bigo.ads.api.b
    public final sg.bigo.ads.api.core.d b() {
        sg.bigo.ads.api.core.d dVarB = super.b();
        if (dVarB != null) {
            return dVarB;
        }
        if (this.h.isEmpty()) {
            return new sg.bigo.ads.api.core.d(1001, 10003, "Ad sizes cannot be empty.");
        }
        return null;
    }

    @Override // sg.bigo.ads.api.b
    public int c() {
        return 2;
    }

    @Override // sg.bigo.ads.api.b
    public final Map<String, Object> d() {
        HashMap map = new HashMap();
        map.put(Reporting.Key.AD_SIZE, sg.bigo.ads.ad.banner.a.a(this.h));
        return map;
    }
}
