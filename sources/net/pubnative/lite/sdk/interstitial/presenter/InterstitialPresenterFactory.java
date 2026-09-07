package net.pubnative.lite.sdk.interstitial.presenter;

import android.content.Context;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.models.SkipOffset;
import net.pubnative.lite.sdk.utils.AdEndCardManager;
import net.pubnative.lite.sdk.utils.AdTracker;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.utils.SkipOffsetManager;

/* JADX INFO: loaded from: classes5.dex */
public class InterstitialPresenterFactory {
    private static final String TAG = "InterstitialPresenterFactory";
    private final Context mContext;
    private final String mZoneId;

    public InterstitialPresenterFactory(Context context, String str) {
        this.mContext = context;
        this.mZoneId = str;
    }

    public InterstitialPresenter createInterstitialPresenter(Ad ad, InterstitialPresenter.Listener listener, IntegrationType integrationType) {
        return createInterstitialPresenter(ad, new SkipOffset(SkipOffsetManager.getDefaultHtmlInterstitialSkipOffset().intValue(), false), new SkipOffset((ad.hasEndCard() ? SkipOffsetManager.getDefaultVideoWithEndCardSkipOffset() : SkipOffsetManager.getDefaultVideoWithoutEndCardSkipOffset()).intValue(), false), listener, integrationType);
    }

    public InterstitialPresenter createInterstitialPresenter(Ad ad, SkipOffset skipOffset, SkipOffset skipOffset2, InterstitialPresenter.Listener listener, IntegrationType integrationType) {
        InterstitialPresenter interstitialPresenterFromCreativeType = fromCreativeType(ad.assetgroupid, ad, skipOffset, skipOffset2, integrationType);
        if (interstitialPresenterFromCreativeType == null) {
            return null;
        }
        InterstitialPresenterDecorator interstitialPresenterDecorator = new InterstitialPresenterDecorator(interstitialPresenterFromCreativeType, new AdTracker(ad.getBeacons("impression"), ad.getBeacons("click"), ad.getBeacons(Ad.Beacon.SDK_EVENT), ad.getBeacons(Ad.Beacon.COMPANION_AD_EVENT), ad.getBeacons(Ad.Beacon.CUSTOM_ENDCARD_EVENT)), new AdTracker(ad.getBeacons("custom_endcard_impression"), ad.getBeacons("custom_endcard_click")), HyBid.getReportingController(), listener, integrationType);
        interstitialPresenterFromCreativeType.setListener(interstitialPresenterDecorator);
        interstitialPresenterFromCreativeType.setVideoListener(interstitialPresenterDecorator);
        interstitialPresenterFromCreativeType.setCustomEndCardListener(interstitialPresenterDecorator);
        return interstitialPresenterDecorator;
    }

    InterstitialPresenter fromCreativeType(int i, Ad ad, SkipOffset skipOffset, SkipOffset skipOffset2, IntegrationType integrationType) {
        if (i != 15) {
            if (i != 27 && i != 29) {
                switch (i) {
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        Logger.e(TAG, "Incompatible asset group type: " + i + ", for interstitial ad format.");
                        return null;
                }
            }
            return new MraidInterstitialPresenter(this.mContext, ad, this.mZoneId, Integer.valueOf(skipOffset.getOffset()));
        }
        int offset = skipOffset2.getOffset();
        if (!skipOffset2.isCustom()) {
            Boolean boolIsEndCardEnabled = AdEndCardManager.isEndCardEnabled(ad);
            if (ad.hasEndCard() && boolIsEndCardEnabled.booleanValue()) {
                offset = SkipOffsetManager.getDefaultVideoWithEndCardSkipOffset().intValue();
            } else {
                offset = SkipOffsetManager.getDefaultVideoWithoutEndCardSkipOffset().intValue();
            }
        }
        return new VastInterstitialPresenter(this.mContext, ad, this.mZoneId, offset, integrationType);
    }
}
