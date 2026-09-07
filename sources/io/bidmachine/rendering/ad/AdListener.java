package io.bidmachine.rendering.ad;

import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.PrivacySheetParams;

/* JADX INFO: loaded from: classes10.dex */
public interface AdListener<Ad> {
    void onAdAppeared(Ad ad);

    void onAdClicked(Ad ad);

    void onAdDisappeared(Ad ad);

    void onAdExpired(Ad ad);

    void onAdFailToLoad(Ad ad, Error error);

    void onAdFailToShow(Ad ad, Error error);

    void onAdFinished(Ad ad);

    void onAdLoaded(Ad ad);

    void onAdShown(Ad ad);

    void onOpenPrivacySheet(Ad ad, PrivacySheetParams privacySheetParams);
}
