package net.pubnative.lite.sdk.vpaid;

import android.content.Context;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.presenter.AdPresenter;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.vpaid.helpers.EventTracker;
import net.pubnative.lite.sdk.vpaid.helpers.FileLoader;
import net.pubnative.lite.sdk.vpaid.utils.FileUtils;
import net.pubnative.lite.sdk.vpaid.utils.Utils;

/* JADX INFO: loaded from: classes12.dex */
abstract class BaseVideoAd extends BaseVideoAdInternal {
    private static final String LOG_TAG = "BaseVideoAd";

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal
    public abstract void dismiss();

    BaseVideoAd(Context context, Ad ad, boolean z, boolean z2, AdPresenter.ImpressionListener impressionListener, AdCloseButtonListener adCloseButtonListener) throws Exception {
        super(context, ad, z, z2, impressionListener, adCloseButtonListener);
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal
    public boolean isRewarded() {
        return super.isRewarded();
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal
    public void setRewarded(boolean z) {
        super.setRewarded(z);
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal
    public boolean isReady() {
        return super.isReady();
    }

    public boolean isShowing() {
        return getAdState() == 202;
    }

    public boolean isLoading() {
        return getAdState() == 201;
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal
    public void setAdListener(VideoAdListener videoAdListener) {
        super.setAdListener(videoAdListener);
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal
    public void setAdCloseButtonListener(CloseButtonListener closeButtonListener) {
        super.setAdCloseButtonListener(closeButtonListener);
    }

    public void useMobileNetworkForCaching(boolean z) {
        FileLoader.setUseMobileNetworkForCaching(z);
    }

    public void setDebugMode(boolean z) {
        Utils.setDebugMode(z);
    }

    public void clearCache() {
        FileUtils.clearCache(getContext());
    }

    public void load(final IntegrationType integrationType) {
        runOnUiThread(new Runnable() { // from class: net.pubnative.lite.sdk.vpaid.BaseVideoAd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9832lambda$load$0$netpubnativelitesdkvpaidBaseVideoAd(integrationType);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$load$0$net-pubnative-lite-sdk-vpaid-BaseVideoAd, reason: not valid java name */
    /* synthetic */ void m9832lambda$load$0$netpubnativelitesdkvpaidBaseVideoAd(IntegrationType integrationType) {
        String str = LOG_TAG;
        Logger.d(str, "Start loading ad");
        if (getAdState() == 201 || getAdState() == 202) {
            Logger.d(str, "Ad already loading or showing");
            return;
        }
        EventTracker.clear();
        setAdState(201);
        initAdLoadingStartTime();
        startFetcherTimer();
        FileUtils.deleteExpiredFiles(getContext());
        if (isReady()) {
            Logger.d(str, "Ad already loaded");
            onAdLoadSuccessInternal();
        } else if (Utils.isOnline(getContext())) {
            proceedLoad(integrationType);
        } else {
            onAdLoadFailInternal(new PlayerInfo("No connection"));
        }
    }

    public void destroy() {
        Logger.d(LOG_TAG, "Ad will be destroyed");
        setReady();
        stopExpirationTimer();
        stopFetcherTimer();
        setAdState(200);
        cancelFetcher();
        releaseAdController();
        getViewabilityAdSession().stopAdSession();
    }
}
