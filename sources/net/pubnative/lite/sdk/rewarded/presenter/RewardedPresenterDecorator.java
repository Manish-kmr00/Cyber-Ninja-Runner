package net.pubnative.lite.sdk.rewarded.presenter;

import android.text.TextUtils;
import net.pubnative.lite.sdk.CustomEndCardListener;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.HyBidErrorCode;
import net.pubnative.lite.sdk.VideoListener;
import net.pubnative.lite.sdk.analytics.Reporting;
import net.pubnative.lite.sdk.analytics.ReportingController;
import net.pubnative.lite.sdk.analytics.ReportingEvent;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.utils.AdTracker;
import net.pubnative.lite.sdk.utils.CheckUtils;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.utils.json.JsonOperations;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class RewardedPresenterDecorator implements RewardedPresenter, RewardedPresenter.Listener, VideoListener, CustomEndCardListener {
    private static final String TAG = "RewardedPresenterDecorator";
    private final AdTracker mAdTrackingDelegate;
    private final AdTracker mCustomEndCardTrackingDelegate;
    private final IntegrationType mIntegrationType;
    private final RewardedPresenter.Listener mListener;
    private final ReportingController mReportingController;
    private final RewardedPresenter mRewardedPresenter;
    private VideoListener mVideoListener;
    private boolean mIsDestroyed = false;
    private boolean mImpressionTracked = false;
    private boolean mClickTracked = false;
    private boolean mFinishTracked = false;
    private boolean mDefaultEndCardImpressionTracked = false;
    private boolean mDefaultEndCardClickTracked = false;
    private boolean mCustomEndCardImpressionTracked = false;
    private boolean mCustomEndCardClickTracked = false;
    private boolean mVideoAdSkipped = false;

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter
    public void setCustomEndCardListener(CustomEndCardListener customEndCardListener) {
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter
    public void setListener(RewardedPresenter.Listener listener) {
    }

    public RewardedPresenterDecorator(RewardedPresenter rewardedPresenter, AdTracker adTracker, AdTracker adTracker2, ReportingController reportingController, RewardedPresenter.Listener listener, IntegrationType integrationType) {
        this.mRewardedPresenter = rewardedPresenter;
        rewardedPresenter.setVideoListener(this);
        this.mAdTrackingDelegate = adTracker;
        this.mCustomEndCardTrackingDelegate = adTracker2;
        this.mReportingController = reportingController;
        this.mListener = listener;
        this.mIntegrationType = integrationType;
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter
    public Ad getAd() {
        return this.mRewardedPresenter.getAd();
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter
    public void load() {
        if (CheckUtils.NoThrow.checkArgument(!this.mIsDestroyed, "RewardedPresenterDecorator is destroyed")) {
            this.mRewardedPresenter.load();
        }
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter
    public boolean isReady() {
        return this.mRewardedPresenter.isReady();
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter
    public void show() {
        if (CheckUtils.NoThrow.checkArgument(!this.mIsDestroyed, "RewardedPresenterDecorator is destroyed")) {
            this.mRewardedPresenter.show();
        }
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter
    public void destroy() {
        this.mRewardedPresenter.destroy();
        this.mIsDestroyed = true;
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter
    public JSONObject getPlacementParams() {
        JSONObject placementParams;
        JSONObject placementParams2;
        JSONObject jSONObject = new JSONObject();
        RewardedPresenter rewardedPresenter = this.mRewardedPresenter;
        if (rewardedPresenter != null && (placementParams2 = rewardedPresenter.getPlacementParams()) != null) {
            JsonOperations.mergeJsonObjects(jSONObject, placementParams2);
        }
        AdTracker adTracker = this.mAdTrackingDelegate;
        if (adTracker != null && (placementParams = adTracker.getPlacementParams()) != null) {
            JsonOperations.mergeJsonObjects(jSONObject, placementParams);
        }
        return jSONObject;
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter.Listener
    public void onRewardedLoaded(RewardedPresenter rewardedPresenter) {
        if (this.mIsDestroyed) {
            return;
        }
        this.mAdTrackingDelegate.trackSdkEvent(1, null);
        this.mListener.onRewardedLoaded(rewardedPresenter);
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter.Listener
    public void onRewardedOpened(RewardedPresenter rewardedPresenter) {
        if (this.mIsDestroyed || this.mImpressionTracked) {
            return;
        }
        if (this.mReportingController != null && HyBid.isReportingEnabled().booleanValue()) {
            ReportingEvent reportingEvent = new ReportingEvent();
            reportingEvent.setEventType("impression");
            reportingEvent.setTimestamp(System.currentTimeMillis());
            reportingEvent.setAdFormat("rewarded");
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
        this.mAdTrackingDelegate.trackImpression();
        this.mAdTrackingDelegate.trackSdkEvent(2, null);
        this.mListener.onRewardedOpened(rewardedPresenter);
        this.mImpressionTracked = true;
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter.Listener
    public void onRewardedClicked(RewardedPresenter rewardedPresenter) {
        if (this.mIsDestroyed || this.mClickTracked) {
            return;
        }
        if (this.mReportingController != null && HyBid.isReportingEnabled().booleanValue()) {
            ReportingEvent reportingEvent = new ReportingEvent();
            reportingEvent.setEventType("click");
            reportingEvent.setTimestamp(System.currentTimeMillis());
            reportingEvent.setAdFormat("rewarded");
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
        this.mListener.onRewardedClicked(rewardedPresenter);
        this.mClickTracked = true;
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter.Listener
    public void onRewardedClosed(RewardedPresenter rewardedPresenter) {
        if (this.mIsDestroyed) {
            return;
        }
        this.mListener.onRewardedClosed(rewardedPresenter);
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter.Listener
    public void onRewardedFinished(RewardedPresenter rewardedPresenter) {
        if (this.mIsDestroyed || this.mFinishTracked) {
            return;
        }
        if (this.mReportingController != null && HyBid.isReportingEnabled().booleanValue()) {
            ReportingEvent reportingEvent = new ReportingEvent();
            reportingEvent.setEventType(Reporting.EventType.REWARDED_CLOSED);
            reportingEvent.setTimestamp(System.currentTimeMillis());
            reportingEvent.setAdFormat("rewarded");
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
        this.mListener.onRewardedFinished(rewardedPresenter);
        this.mFinishTracked = true;
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter
    public void setVideoListener(VideoListener videoListener) {
        this.mVideoListener = videoListener;
    }

    @Override // net.pubnative.lite.sdk.VideoListener
    public void onVideoError(int i) {
        VideoListener videoListener = this.mVideoListener;
        if (videoListener != null) {
            videoListener.onVideoError(i);
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
        VideoListener videoListener;
        if (this.mIsDestroyed || this.mVideoAdSkipped || (videoListener = this.mVideoListener) == null) {
            return;
        }
        this.mVideoAdSkipped = true;
        videoListener.onVideoSkipped();
    }

    @Override // net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenter.Listener
    public void onRewardedError(RewardedPresenter rewardedPresenter) {
        String str;
        if (this.mIsDestroyed) {
            return;
        }
        if (this.mReportingController != null && HyBid.isReportingEnabled().booleanValue()) {
            ReportingEvent reportingEvent = new ReportingEvent();
            reportingEvent.setEventType("error");
            reportingEvent.setTimestamp(System.currentTimeMillis());
            reportingEvent.setAdFormat("rewarded");
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
        String zoneId = getAd().getZoneId();
        if (TextUtils.isEmpty(zoneId)) {
            str = "Rewarded error";
        } else {
            str = "Rewarded error for zone id: " + zoneId;
        }
        Logger.d(TAG, str);
        this.mAdTrackingDelegate.trackSdkEvent(1, Integer.valueOf(HyBidErrorCode.UNKNOWN_ERROR.getCode()));
        this.mListener.onRewardedError(rewardedPresenter);
    }

    @Override // net.pubnative.lite.sdk.CustomEndCardListener
    public void onCustomEndCardShow() {
        if (this.mIsDestroyed || this.mCustomEndCardImpressionTracked) {
            return;
        }
        if (this.mReportingController != null && HyBid.isReportingEnabled().booleanValue()) {
            ReportingEvent reportingEvent = new ReportingEvent();
            reportingEvent.setEventType("custom_endcard_impression");
            reportingEvent.setTimestamp(System.currentTimeMillis());
            reportingEvent.setAdFormat("rewarded");
            reportingEvent.setPlatform("android");
            reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(this.mIntegrationType));
            Ad ad = getAd();
            if (ad != null) {
                reportingEvent.setImpId(ad.getSessionId());
                reportingEvent.setCampaignId(ad.getCampaignId());
                reportingEvent.setConfigId(ad.getConfigId());
            }
            reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, "custom");
            this.mReportingController.reportEvent(reportingEvent);
        }
        this.mAdTrackingDelegate.trackCustomEndcardEvent(1, null);
        this.mCustomEndCardTrackingDelegate.trackImpression();
        this.mCustomEndCardImpressionTracked = true;
    }

    @Override // net.pubnative.lite.sdk.CustomEndCardListener
    public void onCustomEndCardClick() {
        if (this.mIsDestroyed || this.mCustomEndCardClickTracked) {
            return;
        }
        if (this.mReportingController != null && HyBid.isReportingEnabled().booleanValue()) {
            ReportingEvent reportingEvent = new ReportingEvent();
            reportingEvent.setEventType("custom_endcard_click");
            reportingEvent.setTimestamp(System.currentTimeMillis());
            reportingEvent.setAdFormat("rewarded");
            reportingEvent.setPlatform("android");
            reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(this.mIntegrationType));
            Ad ad = getAd();
            if (ad != null) {
                reportingEvent.setImpId(ad.getSessionId());
                reportingEvent.setCampaignId(ad.getCampaignId());
                reportingEvent.setConfigId(ad.getConfigId());
            }
            reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, "custom");
            this.mReportingController.reportEvent(reportingEvent);
        }
        this.mAdTrackingDelegate.trackClick();
        this.mAdTrackingDelegate.trackCustomEndcardEvent(4, null);
        this.mCustomEndCardTrackingDelegate.trackClick();
        this.mCustomEndCardClickTracked = true;
    }

    @Override // net.pubnative.lite.sdk.CustomEndCardListener
    public void onDefaultEndCardShow() {
        if (this.mIsDestroyed || this.mDefaultEndCardImpressionTracked) {
            return;
        }
        if (this.mReportingController != null && HyBid.isReportingEnabled().booleanValue()) {
            reportCompanionView();
            ReportingEvent reportingEvent = new ReportingEvent();
            reportingEvent.setEventType(Reporting.EventType.DEFAULT_ENDCARD_IMPRESSION);
            reportingEvent.setTimestamp(System.currentTimeMillis());
            reportingEvent.setAdFormat("rewarded");
            reportingEvent.setPlatform("android");
            reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(this.mIntegrationType));
            Ad ad = getAd();
            if (ad != null) {
                reportingEvent.setImpId(ad.getSessionId());
                reportingEvent.setCampaignId(ad.getCampaignId());
                reportingEvent.setConfigId(ad.getConfigId());
            }
            reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, "default");
            this.mReportingController.reportEvent(reportingEvent);
        }
        this.mAdTrackingDelegate.trackCompanionAdEvent(1, null);
        this.mDefaultEndCardImpressionTracked = true;
    }

    @Override // net.pubnative.lite.sdk.CustomEndCardListener
    public void onDefaultEndCardClick() {
        if (this.mIsDestroyed || this.mDefaultEndCardClickTracked) {
            return;
        }
        if (this.mReportingController != null && HyBid.isReportingEnabled().booleanValue()) {
            ReportingEvent reportingEvent = new ReportingEvent();
            reportingEvent.setEventType(Reporting.EventType.DEFAULT_ENDCARD_CLICK);
            reportingEvent.setTimestamp(System.currentTimeMillis());
            reportingEvent.setAdFormat("rewarded");
            reportingEvent.setPlatform("android");
            reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(this.mIntegrationType));
            Ad ad = getAd();
            if (ad != null) {
                reportingEvent.setImpId(ad.getSessionId());
                reportingEvent.setCampaignId(ad.getCampaignId());
                reportingEvent.setConfigId(ad.getConfigId());
            }
            reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, "default");
            this.mReportingController.reportEvent(reportingEvent);
        }
        this.mAdTrackingDelegate.trackCompanionAdEvent(4, null);
        this.mDefaultEndCardClickTracked = true;
    }

    @Override // net.pubnative.lite.sdk.CustomEndCardListener
    public void onEndCardLoadSuccess(boolean z) {
        String str;
        if (this.mIsDestroyed) {
            return;
        }
        if (z) {
            str = Reporting.EventType.CUSTOM_END_CARD_LOAD_SUCCESS;
        } else {
            str = Reporting.EventType.DEFAULT_END_CARD_LOAD_SUCCESS;
        }
        if (this.mReportingController == null || !HyBid.isReportingEnabled().booleanValue()) {
            return;
        }
        ReportingEvent reportingEvent = new ReportingEvent();
        reportingEvent.setEventType(str);
        reportingEvent.setTimestamp(System.currentTimeMillis());
        reportingEvent.setAdFormat("rewarded");
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

    @Override // net.pubnative.lite.sdk.CustomEndCardListener
    public void onEndCardLoadFailure(boolean z) {
        String str;
        if (this.mIsDestroyed) {
            return;
        }
        if (z) {
            this.mAdTrackingDelegate.trackCustomEndcardEvent(5, Integer.valueOf(HyBidErrorCode.UNKNOWN_ERROR.getCode()));
            str = Reporting.EventType.CUSTOM_END_CARD_LOAD_FAILURE;
        } else {
            this.mAdTrackingDelegate.trackCompanionAdEvent(5, Integer.valueOf(HyBidErrorCode.UNKNOWN_ERROR.getCode()));
            str = Reporting.EventType.DEFAULT_END_CARD_LOAD_FAILURE;
        }
        if (this.mReportingController == null || !HyBid.isReportingEnabled().booleanValue()) {
            return;
        }
        ReportingEvent reportingEvent = new ReportingEvent();
        reportingEvent.setEventType(str);
        reportingEvent.setTimestamp(System.currentTimeMillis());
        reportingEvent.setAdFormat("rewarded");
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

    private void reportCompanionView() {
        if (HyBid.getReportingController() == null || !HyBid.isReportingEnabled().booleanValue()) {
            return;
        }
        ReportingEvent reportingEvent = new ReportingEvent();
        reportingEvent.setEventType(Reporting.EventType.COMPANION_VIEW);
        reportingEvent.setAdFormat("banner");
        reportingEvent.setCreativeType("video");
        reportingEvent.setPlatform("android");
        reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(IntegrationType.STANDALONE));
        Ad ad = getAd();
        if (ad != null) {
            reportingEvent.setImpId(ad.getSessionId());
            reportingEvent.setCampaignId(ad.getCampaignId());
            reportingEvent.setConfigId(ad.getConfigId());
        }
        reportingEvent.setTimestamp(System.currentTimeMillis());
        HyBid.getReportingController().reportEvent(reportingEvent);
    }
}
