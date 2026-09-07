package net.pubnative.lite.sdk.presenter;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.VideoListener;
import net.pubnative.lite.sdk.analytics.Reporting;
import net.pubnative.lite.sdk.analytics.ReportingController;
import net.pubnative.lite.sdk.analytics.ReportingEvent;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.mraid.MRAIDView;
import net.pubnative.lite.sdk.mraid.MRAIDViewListener;
import net.pubnative.lite.sdk.utils.AdTracker;
import net.pubnative.lite.sdk.utils.CheckUtils;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.utils.json.JsonOperations;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class AdPresenterDecorator implements AdPresenter, AdPresenter.Listener, AdPresenter.ImpressionListener, VideoListener, MRAIDViewListener {
    private static final String ERROR_DECORATOR_DESTROYED = "AdPresenterDecorator is destroyed";
    private static final String TAG = "AdPresenterDecorator";
    private final AdPresenter mAdPresenter;
    private final AdTracker mAdTrackingDelegate;
    private final AdPresenter.ImpressionListener mImpressionListener;
    private IntegrationType mIntegrationType;
    private final AdPresenter.Listener mListener;
    private MRAIDViewListener mMraidListener;
    private final ReportingController mReportingController;
    private VideoListener mVideoListener;
    private boolean mIsDestroyed = false;
    private boolean mImpressionTracked = false;
    private boolean mClickTracked = false;

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidShowCloseButton() {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidViewClose(MRAIDView mRAIDView) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidViewError(MRAIDView mRAIDView) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidViewExpand(MRAIDView mRAIDView) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidViewLoaded(MRAIDView mRAIDView) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public boolean mraidViewResize(MRAIDView mRAIDView, int i, int i2, int i3, int i4) {
        return false;
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public void setImpressionListener(AdPresenter.ImpressionListener impressionListener) {
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public void setListener(AdPresenter.Listener listener) {
    }

    public AdPresenterDecorator(AdPresenter adPresenter, AdTracker adTracker, ReportingController reportingController, AdPresenter.Listener listener, AdPresenter.ImpressionListener impressionListener, IntegrationType integrationType) {
        this.mAdPresenter = adPresenter;
        this.mAdTrackingDelegate = adTracker;
        this.mReportingController = reportingController;
        this.mListener = listener;
        this.mImpressionListener = impressionListener;
        this.mIntegrationType = integrationType;
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public void setVideoListener(VideoListener videoListener) {
        this.mVideoListener = videoListener;
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public void setMRaidListener(MRAIDViewListener mRAIDViewListener) {
        this.mMraidListener = mRAIDViewListener;
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public Ad getAd() {
        return this.mAdPresenter.getAd();
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public void load() {
        if (CheckUtils.NoThrow.checkArgument(!this.mIsDestroyed, ERROR_DECORATOR_DESTROYED)) {
            this.mAdPresenter.load();
        }
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public void destroy() {
        this.mAdPresenter.destroy();
        this.mIsDestroyed = true;
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public void startTracking() {
        if (CheckUtils.NoThrow.checkArgument(!this.mIsDestroyed, ERROR_DECORATOR_DESTROYED)) {
            this.mAdPresenter.startTracking();
        }
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public void stopTracking() {
        if (CheckUtils.NoThrow.checkArgument(!this.mIsDestroyed, ERROR_DECORATOR_DESTROYED)) {
            this.mAdPresenter.stopTracking();
        }
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public JSONObject getPlacementParams() {
        JSONObject placementParams;
        JSONObject placementParams2;
        JSONObject jSONObject = new JSONObject();
        AdPresenter adPresenter = this.mAdPresenter;
        if (adPresenter != null && (placementParams2 = adPresenter.getPlacementParams()) != null) {
            JsonOperations.mergeJsonObjects(jSONObject, placementParams2);
        }
        AdTracker adTracker = this.mAdTrackingDelegate;
        if (adTracker != null && (placementParams = adTracker.getPlacementParams()) != null) {
            JsonOperations.mergeJsonObjects(jSONObject, placementParams);
        }
        return jSONObject;
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter.Listener
    public void onAdLoaded(AdPresenter adPresenter, View view) {
        if (this.mIsDestroyed) {
            return;
        }
        this.mListener.onAdLoaded(adPresenter, view);
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter.Listener
    public void onAdClicked(AdPresenter adPresenter) {
        if (this.mIsDestroyed || this.mClickTracked) {
            return;
        }
        if (this.mReportingController != null && HyBid.isReportingEnabled().booleanValue()) {
            ReportingEvent reportingEvent = new ReportingEvent();
            reportingEvent.setEventType("click");
            reportingEvent.setTimestamp(String.valueOf(System.currentTimeMillis()));
            reportingEvent.setAdFormat("banner");
            reportingEvent.setPlatform("android");
            reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(this.mIntegrationType));
            Ad ad = getAd();
            if (ad != null) {
                reportingEvent.setImpId(ad.getSessionId());
                reportingEvent.setCampaignId(ad.getCampaignId());
                reportingEvent.setConfigId(ad.getConfigId());
            }
            reportingEvent.setCustomString(Reporting.Key.CLICK_SOURCE_TYPE, Reporting.Key.CLICK_SOURCE_TYPE_AD);
            this.mReportingController.reportEvent(reportingEvent);
        }
        this.mAdTrackingDelegate.trackClick();
        this.mListener.onAdClicked(adPresenter);
        this.mClickTracked = true;
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter.Listener
    public void onAdError(AdPresenter adPresenter) {
        if (this.mIsDestroyed) {
            return;
        }
        if (this.mReportingController != null) {
            ReportingEvent reportingEvent = new ReportingEvent();
            reportingEvent.setEventType("error");
            reportingEvent.setTimestamp(String.valueOf(System.currentTimeMillis()));
            reportingEvent.setAdFormat("banner");
            reportingEvent.setPlatform("android");
            reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(this.mIntegrationType));
            Ad ad = getAd();
            if (ad != null) {
                reportingEvent.setImpId(ad.getSessionId());
                reportingEvent.setCampaignId(ad.getCampaignId());
                reportingEvent.setConfigId(ad.getConfigId());
            }
            if (getAd() != null && !TextUtils.isEmpty(getAd().getVast())) {
                reportingEvent.setVast(getAd().getVast());
            }
            this.mReportingController.reportEvent(reportingEvent);
        }
        Logger.d(TAG, "Banner error for zone id: ");
        this.mListener.onAdError(adPresenter);
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter.ImpressionListener
    public void onImpression() {
        if (this.mIsDestroyed) {
            return;
        }
        if (this.mImpressionTracked) {
            Log.i(TAG, "impression is already confirmed, dropping impression tracking");
            return;
        }
        if (this.mReportingController != null && HyBid.isReportingEnabled().booleanValue()) {
            ReportingEvent reportingEvent = new ReportingEvent();
            reportingEvent.setEventType("impression");
            reportingEvent.setTimestamp(String.valueOf(System.currentTimeMillis()));
            reportingEvent.setAdFormat("banner");
            reportingEvent.setPlatform("android");
            reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(this.mIntegrationType));
            Ad ad = getAd();
            if (ad != null) {
                reportingEvent.setImpId(ad.getSessionId());
                reportingEvent.setCampaignId(ad.getCampaignId());
                reportingEvent.setConfigId(ad.getConfigId());
            }
            this.mReportingController.reportEvent(reportingEvent);
        }
        this.mImpressionTracked = true;
        this.mAdTrackingDelegate.trackImpression();
        AdPresenter.ImpressionListener impressionListener = this.mImpressionListener;
        if (impressionListener != null) {
            impressionListener.onImpression();
        }
    }

    @Override // net.pubnative.lite.sdk.VideoListener
    public void onVideoError(int i) {
        VideoListener videoListener = this.mVideoListener;
        if (videoListener != null) {
            videoListener.onVideoDismissed(i);
        }
    }

    @Override // net.pubnative.lite.sdk.VideoListener
    public void onVideoStarted() {
        VideoListener videoListener = this.mVideoListener;
        if (videoListener != null) {
            videoListener.onVideoStarted();
        }
    }

    @Override // net.pubnative.lite.sdk.VideoListener
    public void onVideoDismissed(int i) {
        VideoListener videoListener = this.mVideoListener;
        if (videoListener != null) {
            videoListener.onVideoDismissed(i);
        }
    }

    @Override // net.pubnative.lite.sdk.VideoListener
    public void onVideoFinished() {
        VideoListener videoListener = this.mVideoListener;
        if (videoListener != null) {
            videoListener.onVideoFinished();
        }
    }

    @Override // net.pubnative.lite.sdk.VideoListener
    public void onVideoSkipped() {
        VideoListener videoListener = this.mVideoListener;
        if (videoListener != null) {
            videoListener.onVideoSkipped();
        }
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void onExpandedAdClosed() {
        MRAIDViewListener mRAIDViewListener = this.mMraidListener;
        if (mRAIDViewListener != null) {
            mRAIDViewListener.onExpandedAdClosed();
        }
    }
}
