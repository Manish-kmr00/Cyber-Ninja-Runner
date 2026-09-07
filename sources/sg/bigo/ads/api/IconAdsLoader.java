package sg.bigo.ads.api;

import sg.bigo.ads.api.core.g;
import sg.bigo.ads.controller.loader.AbstractAdLoader;

/* JADX INFO: loaded from: classes7.dex */
public class IconAdsLoader extends AbstractAdLoader<IconAds, IconAdsRequest> {

    public static class a implements AdLoader.Builder<IconAds, a, IconAdsLoader> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AdLoadListener<IconAds> f13084a;
        private String b;

        @Override // sg.bigo.ads.api.AdLoader.Builder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IconAdsLoader build() {
            return new IconAdsLoader(this);
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        public final /* bridge */ /* synthetic */ AdLoader.Builder withAdLoadListener(AdLoadListener adLoadListener) {
            this.f13084a = adLoadListener;
            return this;
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        public final /* bridge */ /* synthetic */ AdLoader.Builder withExt(String str) {
            this.b = str;
            return this;
        }
    }

    public IconAdsLoader(a aVar) {
        super(aVar.f13084a, aVar.b);
    }

    @Override // sg.bigo.ads.controller.loader.AbstractAdLoader
    public final /* synthetic */ Ad a(b bVar, g[] gVarArr) {
        return new sg.bigo.ads.ad.a.a(bVar, gVarArr);
    }
}
