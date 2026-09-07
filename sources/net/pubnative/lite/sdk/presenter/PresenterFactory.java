package net.pubnative.lite.sdk.presenter;

import android.content.Context;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.AdSize;
import net.pubnative.lite.sdk.models.ImpressionTrackingMethod;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.utils.AdTracker;

/* JADX INFO: loaded from: classes6.dex */
public abstract class PresenterFactory {
    private final Context mContext;
    protected final IntegrationType mIntegrationType;

    protected abstract AdPresenter fromCreativeType(int i, Ad ad, AdSize adSize);

    protected abstract AdPresenter fromCreativeType(int i, Ad ad, AdSize adSize, ImpressionTrackingMethod impressionTrackingMethod);

    public PresenterFactory(Context context, IntegrationType integrationType) {
        this.mContext = context;
        this.mIntegrationType = integrationType;
    }

    public AdPresenter createPresenter(Ad ad, AdSize adSize, AdPresenter.Listener listener) {
        return createPresenter(ad, adSize, listener, null);
    }

    public AdPresenter createPresenter(Ad ad, AdSize adSize, AdPresenter.Listener listener, AdPresenter.ImpressionListener impressionListener) {
        return createPresenter(ad, null, adSize, ImpressionTrackingMethod.AD_VIEWABLE, listener, impressionListener);
    }

    public AdPresenter createPresenter(Ad ad, AdTracker adTracker, AdSize adSize, ImpressionTrackingMethod impressionTrackingMethod, AdPresenter.Listener listener, AdPresenter.ImpressionListener impressionListener) {
        AdPresenter adPresenterFromCreativeType;
        if (ad == null || (adPresenterFromCreativeType = fromCreativeType(ad.assetgroupid, ad, adSize, impressionTrackingMethod)) == null) {
            return null;
        }
        if (adTracker == null) {
            adTracker = new AdTracker(ad.getBeacons("impression"), ad.getBeacons("click"), ad.getBeacons(Ad.Beacon.SDK_EVENT), ad.getBeacons(Ad.Beacon.COMPANION_AD_EVENT), ad.getBeacons(Ad.Beacon.CUSTOM_ENDCARD_EVENT));
        }
        AdPresenterDecorator adPresenterDecorator = new AdPresenterDecorator(adPresenterFromCreativeType, adTracker, HyBid.getReportingController(), listener, impressionListener, this.mIntegrationType);
        adPresenterFromCreativeType.setListener(adPresenterDecorator);
        adPresenterFromCreativeType.setImpressionListener(adPresenterDecorator);
        adPresenterFromCreativeType.setVideoListener(adPresenterDecorator);
        adPresenterFromCreativeType.setMRaidListener(adPresenterDecorator);
        return adPresenterDecorator;
    }

    protected Context getContext() {
        return this.mContext;
    }
}
