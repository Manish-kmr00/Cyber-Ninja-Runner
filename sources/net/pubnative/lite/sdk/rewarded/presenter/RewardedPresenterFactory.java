package net.pubnative.lite.sdk.rewarded.presenter;

import android.content.Context;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.utils.AdTracker;
import net.pubnative.lite.sdk.utils.Logger;

/* JADX INFO: loaded from: classes12.dex */
public class RewardedPresenterFactory {
    private static final String TAG = "RewardedPresenterFactory";
    private final Context mContext;
    private final String mZoneId;

    public RewardedPresenterFactory(Context context, String str) {
        this.mContext = context;
        this.mZoneId = str;
    }

    public RewardedPresenter createRewardedPresenter(Ad ad, RewardedPresenter.Listener listener, IntegrationType integrationType) {
        RewardedPresenter rewardedPresenterFromCreativeType = fromCreativeType(ad.assetgroupid, ad, integrationType);
        if (rewardedPresenterFromCreativeType == null) {
            return null;
        }
        RewardedPresenterDecorator rewardedPresenterDecorator = new RewardedPresenterDecorator(rewardedPresenterFromCreativeType, new AdTracker(ad.getBeacons("impression"), ad.getBeacons("click"), ad.getBeacons(Ad.Beacon.SDK_EVENT), ad.getBeacons(Ad.Beacon.COMPANION_AD_EVENT), ad.getBeacons(Ad.Beacon.CUSTOM_ENDCARD_EVENT)), new AdTracker(ad.getBeacons("custom_endcard_impression"), ad.getBeacons("custom_endcard_click")), HyBid.getReportingController(), listener, integrationType);
        rewardedPresenterFromCreativeType.setListener(rewardedPresenterDecorator);
        rewardedPresenterFromCreativeType.setCustomEndCardListener(rewardedPresenterDecorator);
        return rewardedPresenterDecorator;
    }

    RewardedPresenter fromCreativeType(int i, Ad ad, IntegrationType integrationType) {
        if (i != 15) {
            if (i != 27 && i != 29) {
                switch (i) {
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        Logger.e(TAG, "Incompatible asset group type: " + i + ", for rewarded ad format.");
                        return null;
                }
            }
            return new MraidRewardedPresenter(this.mContext, ad, this.mZoneId);
        }
        return new VastRewardedPresenter(this.mContext, ad, this.mZoneId, integrationType);
    }
}
