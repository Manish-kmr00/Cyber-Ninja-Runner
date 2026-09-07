package net.pubnative.lite.sdk.rewarded.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.analytics.Reporting;
import net.pubnative.lite.sdk.analytics.ReportingEvent;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.presenter.AdPresenter;
import net.pubnative.lite.sdk.rewarded.HyBidRewardedBroadcastReceiver;
import net.pubnative.lite.sdk.utils.AdEndCardManager;
import net.pubnative.lite.sdk.utils.AdTracker;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.views.CloseableContainer;
import net.pubnative.lite.sdk.vpaid.AdCloseButtonListener;
import net.pubnative.lite.sdk.vpaid.CloseButtonListener;
import net.pubnative.lite.sdk.vpaid.PlayerInfo;
import net.pubnative.lite.sdk.vpaid.VastActivityInteractor;
import net.pubnative.lite.sdk.vpaid.VideoAd;
import net.pubnative.lite.sdk.vpaid.VideoAdCacheItem;
import net.pubnative.lite.sdk.vpaid.VideoAdListener;
import net.pubnative.lite.sdk.vpaid.VideoAdView;

/* JADX INFO: loaded from: classes7.dex */
public class VastRewardedActivity extends HyBidRewardedActivity implements AdPresenter.ImpressionListener, AdCloseButtonListener {
    private static final String TAG = "VastRewardedActivity";
    private AdTracker mAdEventTracker;
    private AdTracker mCustomCTAEndcardTracker;
    private AdTracker mCustomCTATracker;
    private VideoAdView mVideoPlayer;
    VastActivityInteractor vastActivityInteractor;
    private boolean mReady = false;
    private boolean mHasEndCard = false;
    private final VideoAdListener mVideoAdListener = new AnonymousClass1();
    private final CloseButtonListener mAdCloseButtonListener = new CloseButtonListener() { // from class: net.pubnative.lite.sdk.rewarded.activity.VastRewardedActivity$$ExternalSyntheticLambda0
        @Override // net.pubnative.lite.sdk.vpaid.CloseButtonListener
        public final void onCloseButtonVisible() {
            this.f$0.m9739x6236047d();
        }
    };

    @Override // net.pubnative.lite.sdk.rewarded.activity.HyBidRewardedActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.C, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // net.pubnative.lite.sdk.rewarded.activity.HyBidRewardedActivity
    protected boolean shouldShowContentInfo() {
        return true;
    }

    @Override // net.pubnative.lite.sdk.rewarded.activity.HyBidRewardedActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (getResources().getConfiguration().orientation == 2) {
            setRequestedOrientation(0);
        }
        if (getResources().getConfiguration().orientation == 1) {
            setRequestedOrientation(1);
        }
        setIsVast(true);
        super.onCreate(bundle);
        VastActivityInteractor vastActivityInteractor = VastActivityInteractor.getInstance();
        this.vastActivityInteractor = vastActivityInteractor;
        vastActivityInteractor.activityStarted();
        initiateCustomCTAAdTrackers();
        initiateEventTrackers();
        try {
            if (getAd() != null) {
                this.mVideoAd = new VideoAd(this, getAd(), false, true, this, this);
                this.mVideoAd.setRewarded(true);
                this.mVideoAd.bindView(this.mVideoPlayer);
                this.mVideoAd.setAdListener(this.mVideoAdListener);
                this.mVideoAd.setAdCloseButtonListener(this.mAdCloseButtonListener);
                setProgressBarVisible();
                VideoAdCacheItem videoAdCacheItemRemove = HyBid.getVideoAdCache().remove(getZoneId());
                if (videoAdCacheItemRemove != null) {
                    this.mVideoAd.setVideoCacheItem(videoAdCacheItemRemove);
                    if (videoAdCacheItemRemove.getAdParams() != null && videoAdCacheItemRemove.getAdParams().getAdIcon() != null) {
                        setupContentInfo(videoAdCacheItemRemove.getAdParams().getAdIcon());
                    } else {
                        setupContentInfo();
                    }
                } else {
                    setupContentInfo();
                }
                if (videoAdCacheItemRemove != null && videoAdCacheItemRemove.getEndCardData() != null && !TextUtils.isEmpty(videoAdCacheItemRemove.getEndCardData().getContent())) {
                    this.mHasEndCard = AdEndCardManager.isEndCardEnabled(getAd()).booleanValue();
                } else if (getAd().isEndCardEnabled() != null && getAd().isEndCardEnabled().booleanValue() && getAd().isCustomEndCardEnabled() != null && getAd().isCustomEndCardEnabled().booleanValue() && getAd().hasCustomEndCard()) {
                    this.mHasEndCard = true;
                }
                this.mVideoPlayer.postDelayed(new Runnable() { // from class: net.pubnative.lite.sdk.rewarded.activity.VastRewardedActivity$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m9740xde1548f1();
                    }
                }, 1000L);
                return;
            }
            if (getBroadcastSender() != null) {
                Bundle bundle2 = new Bundle();
                getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.ERROR);
                bundle2.putInt("pn_video_progress", 0);
                getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.VIDEO_ERROR, bundle2);
            }
            this.mIsFinishing = true;
            finish();
        } catch (Exception e) {
            Logger.e(TAG, e.getMessage());
            if (getBroadcastSender() != null) {
                Bundle bundle3 = new Bundle();
                getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.ERROR);
                bundle3.putInt("pn_video_progress", 0);
                getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.VIDEO_ERROR, bundle3);
            }
            this.mIsFinishing = true;
            finish();
        }
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$net-pubnative-lite-sdk-rewarded-activity-VastRewardedActivity, reason: not valid java name */
    /* synthetic */ void m9740xde1548f1() {
        this.mVideoAd.load(this.mIntegrationType);
    }

    @Override // net.pubnative.lite.sdk.rewarded.activity.HyBidRewardedActivity
    public View getAdView() {
        if (getAd() == null) {
            return null;
        }
        VideoAdView videoAdView = new VideoAdView(this);
        this.mVideoPlayer = videoAdView;
        return videoAdView;
    }

    @Override // net.pubnative.lite.sdk.rewarded.activity.HyBidRewardedActivity, android.app.Activity
    protected void onDestroy() {
        this.vastActivityInteractor.activityDestroyed();
        super.onDestroy();
        if (this.mVideoAd != null) {
            this.mVideoAd.destroy();
            this.mReady = false;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.vastActivityInteractor.activityResumed();
        super.onResume();
        resumeAd();
    }

    @Override // android.app.Activity
    protected void onPause() {
        if (!this.mIsFinishing) {
            this.vastActivityInteractor.activityPaused();
            pauseAd();
        }
        super.onPause();
    }

    @Override // net.pubnative.lite.sdk.rewarded.activity.HyBidRewardedActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (!this.mIsBackEnabled) {
                return false;
            }
            dismiss();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // net.pubnative.lite.sdk.rewarded.activity.HyBidRewardedActivity
    protected void resumeAd() {
        if (this.mIsFeedbackFormOpen || this.mVideoAd == null) {
            return;
        }
        if (this.mReady) {
            if (this.mVideoAd.isAdStarted()) {
                this.mVideoAd.resume();
            } else {
                setProgressBarInvisible();
                this.mVideoAd.show();
            }
        }
        if (this.mIsVideoFinished) {
            this.mVideoAd.resumeEndCardCloseButtonTimer();
        }
    }

    @Override // net.pubnative.lite.sdk.rewarded.activity.HyBidRewardedActivity
    protected void pauseAd() {
        if (this.mVideoAd != null) {
            if (this.mReady && this.mVideoAd.isAdStarted()) {
                this.mVideoAd.pause();
            }
            if (this.mIsVideoFinished) {
                this.mVideoAd.pauseEndCardCloseButtonTimer();
            }
        }
    }

    /* JADX INFO: renamed from: net.pubnative.lite.sdk.rewarded.activity.VastRewardedActivity$1, reason: invalid class name */
    class AnonymousClass1 extends VideoAdListener {
        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdExpired() {
        }

        AnonymousClass1() {
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdLoadSuccess() {
            if (VastRewardedActivity.this.mReady) {
                return;
            }
            VastRewardedActivity.this.mReady = true;
            VastRewardedActivity.this.setProgressBarInvisible();
            VastRewardedActivity.this.mVideoAd.show();
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdLoadFail(PlayerInfo playerInfo) {
            VastRewardedActivity.this.setProgressBarInvisible();
            if (VastRewardedActivity.this.getBroadcastSender() != null) {
                Bundle bundle = new Bundle();
                VastRewardedActivity.this.getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.ERROR);
                bundle.putInt("pn_video_progress", 0);
                VastRewardedActivity.this.getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.VIDEO_ERROR, bundle);
            }
            VastRewardedActivity.this.mIsFinishing = true;
            VastRewardedActivity.this.finish();
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdClicked() {
            if (VastRewardedActivity.this.getBroadcastSender() != null) {
                VastRewardedActivity.this.getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.CLICK);
            }
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdDidReachEnd() {
            VastRewardedActivity.this.mReady = false;
            VastRewardedActivity.this.mIsVideoFinished = true;
            if (!VastRewardedActivity.this.mHasEndCard) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: net.pubnative.lite.sdk.rewarded.activity.VastRewardedActivity$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m9741xb8e136ae();
                    }
                }, 600L);
            }
            if (VastRewardedActivity.this.getBroadcastSender() != null) {
                VastRewardedActivity.this.getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.VIDEO_FINISH);
            }
        }

        /* JADX INFO: renamed from: lambda$onAdDidReachEnd$0$net-pubnative-lite-sdk-rewarded-activity-VastRewardedActivity$1, reason: not valid java name */
        /* synthetic */ void m9741xb8e136ae() {
            VastRewardedActivity.this.showRewardedCloseButton();
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onCustomEndCardShow(String str) {
            if (VastRewardedActivity.this.mCustomEndCardImpressionTracked.booleanValue()) {
                return;
            }
            if (VastRewardedActivity.this.getBroadcastSender() != null) {
                Bundle bundle = new Bundle();
                bundle.putString(Reporting.Key.END_CARD_TYPE, str);
                bundle.putString(Reporting.Key.CLICK_SOURCE_TYPE, Reporting.Key.CLICK_SOURCE_TYPE_END_CARD);
                VastRewardedActivity.this.getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.CUSTOM_END_CARD_SHOW, bundle);
            }
            VastRewardedActivity.this.mCustomEndCardImpressionTracked = true;
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onCustomEndCardClick(String str) {
            if (VastRewardedActivity.this.mCustomEndCardClickTracked.booleanValue()) {
                return;
            }
            if (VastRewardedActivity.this.getBroadcastSender() != null) {
                Bundle bundle = new Bundle();
                bundle.putString(Reporting.Key.END_CARD_TYPE, str);
                bundle.putString("click", str);
                bundle.putString(Reporting.Key.CLICK_SOURCE_TYPE, Reporting.Key.CLICK_SOURCE_TYPE_END_CARD);
                VastRewardedActivity.this.getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.CUSTOM_END_CARD_CLICK, bundle);
            }
            VastRewardedActivity.this.mCustomEndCardClickTracked = true;
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onDefaultEndCardShow(String str) {
            if (VastRewardedActivity.this.mDefaultEndCardImpressionTracked.booleanValue()) {
                return;
            }
            if (VastRewardedActivity.this.getBroadcastSender() != null) {
                Bundle bundle = new Bundle();
                bundle.putString(Reporting.Key.END_CARD_TYPE, str);
                bundle.putString(Reporting.Key.CLICK_SOURCE_TYPE, Reporting.Key.CLICK_SOURCE_TYPE_END_CARD);
                VastRewardedActivity.this.getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.DEFAULT_END_CARD_SHOW, bundle);
            }
            VastRewardedActivity.this.mDefaultEndCardImpressionTracked = true;
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onDefaultEndCardClick(String str) {
            if (VastRewardedActivity.this.mDefaultEndCardClickTracked.booleanValue()) {
                return;
            }
            if (VastRewardedActivity.this.getBroadcastSender() != null) {
                Bundle bundle = new Bundle();
                bundle.putString(Reporting.Key.END_CARD_TYPE, str);
                bundle.putString(Reporting.Key.CLICK_SOURCE_TYPE, Reporting.Key.CLICK_SOURCE_TYPE_END_CARD);
                VastRewardedActivity.this.getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.DEFAULT_END_CARD_CLICK, bundle);
            }
            VastRewardedActivity.this.mDefaultEndCardClickTracked = true;
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onEndCardLoadSuccess(Boolean bool) {
            if (bool.booleanValue() && VastRewardedActivity.this.mLoadCustomEndCardTracked.booleanValue()) {
                return;
            }
            if ((bool.booleanValue() || !VastRewardedActivity.this.mLoadDefaultEndCardTracked.booleanValue()) && VastRewardedActivity.this.getBroadcastSender() != null) {
                if (bool.booleanValue()) {
                    VastRewardedActivity.this.mLoadCustomEndCardTracked = true;
                    VastRewardedActivity.this.hideContentInfo();
                } else {
                    VastRewardedActivity.this.mLoadDefaultEndCardTracked = true;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean(Reporting.Key.IS_CUSTOM_END_CARD, bool.booleanValue());
                VastRewardedActivity.this.getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.END_CARD_LOAD_SUCCESS, bundle);
            }
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onEndCardLoadFail(Boolean bool) {
            if (VastRewardedActivity.this.mLoadEndCardFailTracked.booleanValue()) {
                return;
            }
            if (VastRewardedActivity.this.getBroadcastSender() != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(Reporting.Key.IS_CUSTOM_END_CARD, bool.booleanValue());
                VastRewardedActivity.this.getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.END_CARD_LOAD_FAILURE, bundle);
            }
            VastRewardedActivity.this.mLoadEndCardFailTracked = true;
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onCustomCTACLick(boolean z) {
            String str = z ? "custom_cta_endcard_click" : "custom_cta_click";
            if (VastRewardedActivity.this.mCustomCTAClickTrackedEvents.contains(str)) {
                return;
            }
            if (HyBid.getReportingController() != null && HyBid.isReportingEnabled().booleanValue()) {
                ReportingEvent reportingEvent = new ReportingEvent();
                reportingEvent.setEventType(str);
                reportingEvent.setAdFormat("rewarded");
                reportingEvent.setCreativeType("video");
                reportingEvent.setPlatform("android");
                reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(IntegrationType.STANDALONE));
                if (VastRewardedActivity.this.getAd() != null) {
                    reportingEvent.setImpId(VastRewardedActivity.this.getAd().getSessionId());
                    reportingEvent.setCampaignId(VastRewardedActivity.this.getAd().getCampaignId());
                    reportingEvent.setConfigId(VastRewardedActivity.this.getAd().getConfigId());
                }
                reportingEvent.setTimestamp(System.currentTimeMillis());
                HyBid.getReportingController().reportEvent(reportingEvent);
            }
            if (str.equals("custom_cta_endcard_click")) {
                if (VastRewardedActivity.this.mCustomCTAEndcardTracker != null) {
                    VastRewardedActivity.this.mCustomCTAEndcardTracker.trackClick();
                }
            } else if (VastRewardedActivity.this.mCustomCTATracker != null) {
                VastRewardedActivity.this.mCustomCTATracker.trackImpression();
            }
            VastRewardedActivity.this.mCustomCTAClickTrackedEvents.add(str);
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onCustomCTAShow() {
            if (VastRewardedActivity.this.mCustomCTAImpressionTracked.booleanValue()) {
                return;
            }
            if (HyBid.getReportingController() != null && HyBid.isReportingEnabled().booleanValue()) {
                ReportingEvent reportingEvent = new ReportingEvent();
                reportingEvent.setEventType("custom_cta_show");
                reportingEvent.setAdFormat("rewarded");
                reportingEvent.setCreativeType("video");
                reportingEvent.setPlatform("android");
                reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(VastRewardedActivity.this.mIntegrationType));
                if (VastRewardedActivity.this.getAd() != null) {
                    reportingEvent.setImpId(VastRewardedActivity.this.getAd().getSessionId());
                    reportingEvent.setCampaignId(VastRewardedActivity.this.getAd().getCampaignId());
                    reportingEvent.setConfigId(VastRewardedActivity.this.getAd().getConfigId());
                }
                reportingEvent.setTimestamp(System.currentTimeMillis());
                HyBid.getReportingController().reportEvent(reportingEvent);
            }
            if (VastRewardedActivity.this.mCustomCTATracker != null) {
                VastRewardedActivity.this.mCustomCTATracker.trackImpression();
            }
            VastRewardedActivity.this.mCustomCTAImpressionTracked = true;
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onCustomCTALoadFail() {
            Logger.e("onCustomCTALoadFail", "CTA Failed to load");
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdDismissed() {
            onAdDismissed(-1);
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdDismissed(int i) {
            VastRewardedActivity.this.dismissVideo(i);
            VastRewardedActivity.this.dismiss();
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public synchronized void onAdSkipped() {
            VastRewardedActivity.this.mIsVideoFinished = true;
            if (VastRewardedActivity.this.getBroadcastSender() != null) {
                VastRewardedActivity.this.getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.VIDEO_SKIP);
            }
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdCustomEndCardFound() {
            VastRewardedActivity.this.mHasEndCard = true;
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdStarted() {
            if (VastRewardedActivity.this.getBroadcastSender() != null) {
                VastRewardedActivity.this.getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.VIDEO_START);
            }
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onEndCardSkipped(Boolean bool) {
            if (bool.booleanValue() && VastRewardedActivity.this.mCustomEndCardSkipTracked.booleanValue()) {
                return;
            }
            if (bool.booleanValue() || !VastRewardedActivity.this.mDefaultEndCardSkipTracked.booleanValue()) {
                if (!bool.booleanValue()) {
                    VastRewardedActivity.this.mDefaultEndCardSkipTracked = true;
                    VastRewardedActivity.this.mAdEventTracker.trackCompanionAdEvent(2, null);
                } else {
                    VastRewardedActivity.this.mAdEventTracker.trackCustomEndcardEvent(2, null);
                }
                if (HyBid.getReportingController() == null || !HyBid.isReportingEnabled().booleanValue()) {
                    return;
                }
                ReportingEvent reportingEvent = new ReportingEvent();
                reportingEvent.setTimestamp(System.currentTimeMillis());
                if (VastRewardedActivity.this.mDefaultEndCardSkipTracked.booleanValue()) {
                    reportingEvent.setEventType(Reporting.EventType.DEFAULT_ENDCARD_SKIP);
                    reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, "default");
                }
                HyBid.getReportingController().reportEvent(reportingEvent);
            }
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onEndCardClosed(Boolean bool) {
            if (bool.booleanValue() && VastRewardedActivity.this.mCustomEndCardCloseTracked.booleanValue()) {
                return;
            }
            if (bool.booleanValue() || !VastRewardedActivity.this.mDefaultEndCardCloseTracked.booleanValue()) {
                if (!bool.booleanValue()) {
                    VastRewardedActivity.this.mDefaultEndCardCloseTracked = true;
                    VastRewardedActivity.this.mAdEventTracker.trackCompanionAdEvent(3, null);
                } else {
                    VastRewardedActivity.this.mCustomEndCardCloseTracked = true;
                    VastRewardedActivity.this.mAdEventTracker.trackCustomEndcardEvent(3, null);
                }
                if (HyBid.getReportingController() == null || !HyBid.isReportingEnabled().booleanValue()) {
                    return;
                }
                ReportingEvent reportingEvent = new ReportingEvent();
                reportingEvent.setTimestamp(System.currentTimeMillis());
                if (VastRewardedActivity.this.mDefaultEndCardCloseTracked.booleanValue()) {
                    reportingEvent.setEventType(Reporting.EventType.DEFAULT_ENDCARD_CLOSE);
                    reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, "default");
                } else {
                    reportingEvent.setEventType(Reporting.EventType.CUSTOM_ENDCARD_CLOSE);
                    reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, "custom");
                }
                HyBid.getReportingController().reportEvent(reportingEvent);
            }
        }
    }

    /* JADX INFO: renamed from: lambda$new$1$net-pubnative-lite-sdk-rewarded-activity-VastRewardedActivity, reason: not valid java name */
    /* synthetic */ void m9739x6236047d() {
        this.mIsVideoFinished = true;
        this.mIsSkippable = true;
        this.mIsBackEnabled = true;
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter.ImpressionListener
    public void onImpression() {
        if (getBroadcastSender() != null) {
            getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.OPEN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissVideo(int i) {
        if (getBroadcastSender() != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("pn_video_progress", i);
            getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.VIDEO_DISMISS, bundle);
        }
    }

    @Override // net.pubnative.lite.sdk.vpaid.AdCloseButtonListener
    public void showButton() {
        showRewardedCloseButton();
    }

    @Override // net.pubnative.lite.sdk.vpaid.AdCloseButtonListener
    public void hideButton() {
        CloseableContainer closeableContainer = getCloseableContainer();
        if (closeableContainer != null) {
            closeableContainer.setCloseVisible(true);
        }
    }

    private void initiateCustomCTAAdTrackers() {
        if (getAd() != null) {
            this.mCustomCTATracker = new AdTracker(getAd().getBeacons("custom_cta_show"), getAd().getBeacons("custom_cta_click"), false);
            this.mCustomCTAEndcardTracker = new AdTracker(null, getAd().getBeacons("custom_cta_endcard_click"), false);
        }
    }

    private void initiateEventTrackers() {
        if (getAd() != null) {
            this.mAdEventTracker = new AdTracker(null, null, null, getAd().getBeacons(Ad.Beacon.COMPANION_AD_EVENT), getAd().getBeacons(Ad.Beacon.CUSTOM_ENDCARD_EVENT));
        }
    }
}
