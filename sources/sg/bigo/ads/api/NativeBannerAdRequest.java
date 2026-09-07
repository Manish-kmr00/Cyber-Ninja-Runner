package sg.bigo.ads.api;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class NativeBannerAdRequest extends BannerAdRequest {

    public static class Builder extends c<Builder, NativeBannerAdRequest> {
        private List<AdSize> mAdSizes;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // sg.bigo.ads.api.c
        public NativeBannerAdRequest createAdRequest() {
            return new NativeBannerAdRequest(this.mSlotId, this.mAdSizes);
        }

        public Builder withAdSizes(AdSize... adSizeArr) {
            this.mAdSizes = Arrays.asList(adSizeArr);
            return this;
        }
    }

    NativeBannerAdRequest(String str, List<AdSize> list) {
        super(str, list, null);
    }

    @Override // sg.bigo.ads.api.BannerAdRequest, sg.bigo.ads.api.b
    public final int c() {
        return 0;
    }
}
