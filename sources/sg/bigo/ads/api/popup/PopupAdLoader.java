package sg.bigo.ads.api.popup;

import sg.bigo.ads.ad.d.a;
import sg.bigo.ads.ad.interstitial.k;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdLoadListener;
import sg.bigo.ads.api.AdLoader;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.controller.loader.AbstractAdLoader;

/* JADX INFO: loaded from: classes11.dex */
public class PopupAdLoader extends AbstractAdLoader<PopupAd, PopupAdRequest> {

    public static class Builder implements AdLoader.Builder<PopupAd, Builder, PopupAdLoader> {
        private AdLoadListener<PopupAd> mAdLoadListener;
        private String mExt;

        @Override // sg.bigo.ads.api.AdLoader.Builder
        public PopupAdLoader build() {
            return new PopupAdLoader(this);
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        public /* bridge */ /* synthetic */ AdLoader.Builder withAdLoadListener(AdLoadListener adLoadListener) {
            return withAdLoadListener((AdLoadListener<PopupAd>) adLoadListener);
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        public Builder withAdLoadListener(AdLoadListener<PopupAd> adLoadListener) {
            this.mAdLoadListener = adLoadListener;
            return this;
        }

        @Override // sg.bigo.ads.api.AdLoader.Builder
        public Builder withExt(String str) {
            this.mExt = str;
            return this;
        }
    }

    public PopupAdLoader(Builder builder) {
        super(builder.mAdLoadListener, builder.mExt);
    }

    @Override // sg.bigo.ads.controller.loader.AbstractAdLoader
    public final /* synthetic */ Ad a(g gVar) {
        Ad adInstance;
        if (gVar.f13106a.x() != 20) {
            return (PopupAd) super.a(gVar);
        }
        if (gVar.f13106a.x() != 20) {
            return null;
        }
        int iW = gVar.f13106a.w();
        if (iW == 1 || iW == 2) {
            if (a.f12585a == null) {
                a.f12585a = (k.a) sg.bigo.ads.common.r.a.a("sg.bigo.ads.api.INAdCreator", k.a.class);
            }
            if (a.f12585a == null) {
                return null;
            }
            adInstance = a.f12585a.getAdInstance(gVar);
            if (!(adInstance instanceof PopupAd)) {
                return null;
            }
        } else {
            if (iW != 3) {
                return null;
            }
            if (a.b == null) {
                a.b = (k.a) sg.bigo.ads.common.r.a.a("sg.bigo.ads.api.IBAdCreator", k.a.class);
            }
            if (a.b == null) {
                return null;
            }
            adInstance = a.b.getAdInstance(gVar);
            if (!(adInstance instanceof PopupAd)) {
                return null;
            }
        }
        return (PopupAd) adInstance;
    }
}
