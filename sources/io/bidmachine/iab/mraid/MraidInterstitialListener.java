package io.bidmachine.iab.mraid;

import io.bidmachine.iab.IabError;
import io.bidmachine.iab.utils.IabClickCallback;
import io.bidmachine.rendering.model.PrivacySheetParams;

/* JADX INFO: loaded from: classes11.dex */
public interface MraidInterstitialListener {
    void onCalendarEvent(MraidInterstitial mraidInterstitial, String url, IabClickCallback iabClickCallback);

    void onClose(MraidInterstitial mraidInterstitial);

    void onExpired(MraidInterstitial mraidInterstitial, IabError iabError);

    void onLoadFailed(MraidInterstitial mraidInterstitial, IabError iabError);

    void onLoaded(MraidInterstitial mraidInterstitial);

    void onOpenPrivacySheet(MraidInterstitial mraidInterstitial, PrivacySheetParams privacySheetParams);

    void onOpenUrl(MraidInterstitial mraidInterstitial, String url, IabClickCallback iabClickCallback);

    void onPlayVideo(MraidInterstitial mraidInterstitial, String url);

    void onShowFailed(MraidInterstitial mraidInterstitial, IabError iabError);

    void onShown(MraidInterstitial mraidInterstitial);

    void onStorePicture(MraidInterstitial mraidInterstitial, String url, IabClickCallback iabClickCallback);
}
