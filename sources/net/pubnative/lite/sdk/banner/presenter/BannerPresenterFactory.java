package net.pubnative.lite.sdk.banner.presenter;

import android.content.Context;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.AdSize;
import net.pubnative.lite.sdk.models.ImpressionTrackingMethod;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.presenter.AdPresenter;
import net.pubnative.lite.sdk.presenter.PresenterFactory;
import net.pubnative.lite.sdk.utils.Logger;

/* JADX INFO: loaded from: classes7.dex */
public class BannerPresenterFactory extends PresenterFactory {
    private static final String TAG = "BannerPresenterFactory";

    public BannerPresenterFactory(Context context, IntegrationType integrationType) {
        super(context, integrationType);
    }

    @Override // net.pubnative.lite.sdk.presenter.PresenterFactory
    public AdPresenter fromCreativeType(int i, Ad ad, AdSize adSize) {
        return fromCreativeType(i, ad, adSize, ImpressionTrackingMethod.AD_VIEWABLE);
    }

    @Override // net.pubnative.lite.sdk.presenter.PresenterFactory
    protected AdPresenter fromCreativeType(int i, Ad ad, AdSize adSize, ImpressionTrackingMethod impressionTrackingMethod) {
        if (ad != null && ad.getImpressionTrackingMethod() != null && ImpressionTrackingMethod.fromString(ad.getImpressionTrackingMethod()) != null) {
            impressionTrackingMethod = ImpressionTrackingMethod.fromString(ad.getImpressionTrackingMethod());
        }
        ImpressionTrackingMethod impressionTrackingMethod2 = impressionTrackingMethod;
        if (i != 4) {
            if (i != 8 && i != 10 && i != 12) {
                switch (i) {
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                        break;
                    default:
                        Logger.e(TAG, "Incompatible asset group type: " + i + ", for banner ad format.");
                        return null;
                }
            }
            return new MraidAdPresenter(getContext(), ad, adSize, impressionTrackingMethod2);
        }
        return new VastAdPresenter(getContext(), ad, adSize, impressionTrackingMethod2, this.mIntegrationType);
    }
}
