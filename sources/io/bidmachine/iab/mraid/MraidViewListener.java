package io.bidmachine.iab.mraid;

import io.bidmachine.iab.IabError;
import io.bidmachine.iab.utils.IabClickCallback;
import io.bidmachine.rendering.model.PrivacySheetParams;

/* JADX INFO: loaded from: classes13.dex */
public interface MraidViewListener {
    void onCalendarEvent(MraidView mraidView, String url, IabClickCallback iabClickCallback);

    void onClose(MraidView mraidView);

    void onExpand(MraidView mraidView);

    void onExpired(MraidView mraidView, IabError iabError);

    void onLoadFailed(MraidView mraidView, IabError iabError);

    void onLoaded(MraidView mraidView);

    void onOpenPrivacySheet(MraidView mraidView, PrivacySheetParams privacySheetParams);

    void onOpenUrl(MraidView mraidView, String url, IabClickCallback iabClickCallback);

    void onPlayVideo(MraidView mraidView, String url);

    void onShowFailed(MraidView mraidView, IabError iabError);

    void onShown(MraidView mraidView);

    void onStorePicture(MraidView mraidView, String url, IabClickCallback iabClickCallback);
}
