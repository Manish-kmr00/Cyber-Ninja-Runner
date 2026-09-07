package sg.bigo.ads.api;

import sg.bigo.ads.ad.banner.e;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.controller.loader.AbstractAdLoader;

/* JADX INFO: loaded from: classes9.dex */
public class NativeBannerAdLoader extends AbstractAdLoader<Ad, NativeBannerAdRequest> {

    public static class Builder implements AdLoader.Builder<Ad, Builder, NativeBannerAdLoader> {
        private AdLoadListener<BannerAd> mBannerAdLoader;
        private String mExt;
        private AdLoadListener<NativeAd> mNativeAdLoader;

        /* JADX INFO: Access modifiers changed from: private */
        public AdLoadListener<Ad> createMixAdLoadListener() {
            return new AdLoadListener<Ad>() { // from class: sg.bigo.ads.api.NativeBannerAdLoader.Builder.1
                @Override // sg.bigo.ads.api.AdLoadListener
                public final void onAdLoaded(Ad ad) {
                    if ((ad instanceof NativeAd) && Builder.this.mNativeAdLoader != null) {
                        Builder.this.mNativeAdLoader.onAdLoaded((NativeAd) ad);
                    } else {
                        if (!(ad instanceof BannerAd) || Builder.this.mBannerAdLoader == null) {
                            return;
                        }
                        Builder.this.mBannerAdLoader.onAdLoaded((BannerAd) ad);
                    }
                }

                @Override // sg.bigo.ads.api.AdLoadListener
                public final void onError(AdError adError) {
                    if (Builder.this.mNativeAdLoader != null) {
                        Builder.this.mNativeAdLoader.onError(adError);
                    } else if (Builder.this.mBannerAdLoader != null) {
                        Builder.this.mBannerAdLoader.onError(adError);
                    }
                }
            };
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        public NativeBannerAdLoader build() {
            return new NativeBannerAdLoader(this);
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ AdLoader.Builder withAdLoadListener(AdLoadListener adLoadListener) {
            return withAdLoadListener((AdLoadListener<Ad>) adLoadListener);
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        @Deprecated
        public Builder withAdLoadListener(AdLoadListener<Ad> adLoadListener) {
            return this;
        }

        public Builder withBannerAdLoadListener(AdLoadListener<BannerAd> adLoadListener) {
            this.mBannerAdLoader = adLoadListener;
            return this;
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        public Builder withExt(String str) {
            this.mExt = str;
            return this;
        }

        public Builder withNativeAdLoadListener(AdLoadListener<NativeAd> adLoadListener) {
            this.mNativeAdLoader = adLoadListener;
            return this;
        }
    }

    public NativeBannerAdLoader(Builder builder) {
        super(builder.createMixAdLoadListener(), builder.mExt);
    }

    @Override // sg.bigo.ads.controller.loader.AbstractAdLoader
    public final Ad a(g gVar) {
        int iX = gVar.f13106a.x();
        int iW = gVar.f13106a.w();
        if (iX == 2 || iW == 3) {
            return new e(gVar);
        }
        return iX == 1 ? sg.bigo.ads.ad.b.a.a(gVar) : super.a(gVar);
    }
}
