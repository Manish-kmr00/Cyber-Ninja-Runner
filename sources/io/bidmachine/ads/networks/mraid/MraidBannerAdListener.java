package io.bidmachine.ads.networks.mraid;

import android.content.Context;
import io.bidmachine.Executable;
import io.bidmachine.core.Utils;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.mraid.MraidView;
import io.bidmachine.iab.mraid.MraidViewListener;
import io.bidmachine.iab.utils.IabClickCallback;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.utils.UrlHandler;
import io.bidmachine.rendering.view.PrivacySheetDialog;
import io.bidmachine.unified.UnifiedBannerAdCallback;
import io.bidmachine.util.SafeExecutable;
import io.bidmachine.utils.IabUtils;

/* JADX INFO: loaded from: classes11.dex */
class MraidBannerAdListener implements MraidViewListener {
    private final UnifiedBannerAdCallback callback;

    @Override // io.bidmachine.iab.mraid.MraidViewListener
    public void onClose(MraidView mraidView) {
    }

    @Override // io.bidmachine.iab.mraid.MraidViewListener
    public void onExpand(MraidView mraidView) {
    }

    @Override // io.bidmachine.iab.mraid.MraidViewListener
    public void onPlayVideo(MraidView mraidView, String str) {
    }

    MraidBannerAdListener(UnifiedBannerAdCallback unifiedBannerAdCallback) {
        this.callback = unifiedBannerAdCallback;
    }

    @Override // io.bidmachine.iab.mraid.MraidViewListener
    public void onLoaded(MraidView mraidView) {
        this.callback.onAdLoaded(mraidView);
    }

    @Override // io.bidmachine.iab.mraid.MraidViewListener
    public void onLoadFailed(MraidView mraidView, IabError iabError) {
        this.callback.onAdLoadFailed(IabUtils.mapError(iabError));
    }

    @Override // io.bidmachine.iab.mraid.MraidViewListener
    public void onShown(MraidView mraidView) {
        this.callback.onAdShown();
    }

    @Override // io.bidmachine.iab.mraid.MraidViewListener
    public void onShowFailed(MraidView mraidView, IabError iabError) {
        this.callback.onAdShowFailed(IabUtils.mapError(iabError));
    }

    @Override // io.bidmachine.iab.mraid.MraidViewListener
    public void onExpired(MraidView mraidView, IabError iabError) {
        this.callback.onAdExpired();
    }

    @Override // io.bidmachine.iab.mraid.MraidViewListener
    public void onOpenUrl(MraidView mraidView, String str, final IabClickCallback iabClickCallback) {
        this.callback.onAdClicked();
        UrlHandler.openUrl(mraidView.getContext(), str, new SafeExecutable() { // from class: io.bidmachine.ads.networks.mraid.MraidBannerAdListener$$ExternalSyntheticLambda0
            @Override // io.bidmachine.util.SafeExecutable
            public final void onExecute(Object obj) {
                iabClickCallback.clickHandled();
            }
        });
    }

    @Override // io.bidmachine.iab.mraid.MraidViewListener
    public void onOpenPrivacySheet(MraidView mraidView, final PrivacySheetParams privacySheetParams) {
        Utils.ifNotNull(Utils.findDialogContext(mraidView.peekContext(), mraidView), new Executable() { // from class: io.bidmachine.ads.networks.mraid.MraidBannerAdListener$$ExternalSyntheticLambda3
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                PrivacySheetDialog.show((Context) obj, privacySheetParams);
            }
        });
    }

    @Override // io.bidmachine.iab.mraid.MraidViewListener
    public void onCalendarEvent(MraidView mraidView, String str, final IabClickCallback iabClickCallback) {
        this.callback.onAdClicked();
        UrlHandler.openCalendar(mraidView.getContext(), str, new SafeExecutable() { // from class: io.bidmachine.ads.networks.mraid.MraidBannerAdListener$$ExternalSyntheticLambda2
            @Override // io.bidmachine.util.SafeExecutable
            public final void onExecute(Object obj) {
                iabClickCallback.clickHandled();
            }
        });
    }

    @Override // io.bidmachine.iab.mraid.MraidViewListener
    public void onStorePicture(MraidView mraidView, String str, final IabClickCallback iabClickCallback) {
        this.callback.onAdClicked();
        UrlHandler.storePicture(mraidView.getContext(), str, new SafeExecutable() { // from class: io.bidmachine.ads.networks.mraid.MraidBannerAdListener$$ExternalSyntheticLambda1
            @Override // io.bidmachine.util.SafeExecutable
            public final void onExecute(Object obj) {
                iabClickCallback.clickHandled();
            }
        });
    }
}
