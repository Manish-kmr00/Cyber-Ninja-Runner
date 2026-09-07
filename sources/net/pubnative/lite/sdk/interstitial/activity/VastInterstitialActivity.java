package net.pubnative.lite.sdk.interstitial.activity;

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
import net.pubnative.lite.sdk.interstitial.HyBidInterstitialBroadcastReceiver;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.presenter.AdPresenter;
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

/* JADX INFO: loaded from: classes12.dex */
public class VastInterstitialActivity extends HyBidInterstitialActivity implements AdPresenter.ImpressionListener, AdCloseButtonListener {
    private static final String TAG = "VastInterstitialActivity";
    private AdTracker mAdEventTracker;
    private AdTracker mCustomCTAEndcardTracker;
    private AdTracker mCustomCTATracker;
    private VideoAdView mVideoPlayer;
    VastActivityInteractor vastActivityInteractor;
    private boolean mReady = false;
    private boolean mHasEndCard = false;
    private final VideoAdListener mVideoAdListener = new AnonymousClass1();
    private final CloseButtonListener mCloseButtonListener = new CloseButtonListener() { // from class: net.pubnative.lite.sdk.interstitial.activity.VastInterstitialActivity$$ExternalSyntheticLambda0
        @Override // net.pubnative.lite.sdk.vpaid.CloseButtonListener
        public final void onCloseButtonVisible() {
            this.f$0.m9634xb7fb72b9();
        }
    };

    @Override // net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.C, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity
    protected boolean shouldShowContentInfo() {
        return true;
    }

    @Override // net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity, android.app.Activity
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
            hideInterstitialCloseButton();
            if (getAd() != null) {
                int intExtra = getIntent().getIntExtra("extra_pn_skip_offset", -1);
                this.mIsSkippable = Boolean.valueOf(intExtra == 0);
                this.mVideoAd = new VideoAd(this, getAd(), true, true, this, this);
                this.mVideoAd.useMobileNetworkForCaching(true);
                this.mVideoAd.bindView(this.mVideoPlayer);
                this.mVideoAd.setAdListener(this.mVideoAdListener);
                this.mVideoAd.setAdCloseButtonListener(this.mCloseButtonListener);
                setProgressBarVisible();
                VideoAdCacheItem videoAdCacheItemRemove = HyBid.getVideoAdCache().remove(getZoneId());
                if (videoAdCacheItemRemove != null) {
                    if (videoAdCacheItemRemove.getAdParams() != null) {
                        videoAdCacheItemRemove.getAdParams().setPublisherSkipSeconds(intExtra);
                        if (videoAdCacheItemRemove.getEndCardData() != null && !TextUtils.isEmpty(videoAdCacheItemRemove.getEndCardData().getContent())) {
                            this.mHasEndCard = AdEndCardManager.isEndCardEnabled(getAd()).booleanValue();
                        } else if (getAd().isEndCardEnabled() != null && getAd().isEndCardEnabled().booleanValue() && getAd().isCustomEndCardEnabled() != null && getAd().isCustomEndCardEnabled().booleanValue() && getAd().hasCustomEndCard()) {
                            this.mHasEndCard = true;
                        }
                        if (videoAdCacheItemRemove.getAdParams().getAdIcon() != null) {
                            setupContentInfo(videoAdCacheItemRemove.getAdParams().getAdIcon());
                        } else {
                            setupContentInfo();
                        }
                    }
                    this.mVideoAd.setVideoCacheItem(videoAdCacheItemRemove);
                } else {
                    setupContentInfo();
                }
                this.mVideoPlayer.postDelayed(new Runnable() { // from class: net.pubnative.lite.sdk.interstitial.activity.VastInterstitialActivity$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m9635x4159032d();
                    }
                }, 1000L);
                return;
            }
            if (getBroadcastSender() != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("pn_video_progress", 0);
                getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.ERROR);
                getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.VIDEO_ERROR, bundle2);
                getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.DISMISS);
            }
            this.mIsFinishing = true;
            finish();
        } catch (Exception e) {
            Logger.e(TAG, e.getMessage());
            if (getBroadcastSender() != null) {
                Bundle bundle3 = new Bundle();
                bundle3.putInt("pn_video_progress", 0);
                getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.ERROR);
                getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.VIDEO_ERROR, bundle3);
                getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.DISMISS);
            }
            this.mIsFinishing = true;
            finish();
        }
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$net-pubnative-lite-sdk-interstitial-activity-VastInterstitialActivity, reason: not valid java name */
    /* synthetic */ void m9635x4159032d() {
        this.mVideoAd.load(this.mIntegrationType);
    }

    @Override // net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity
    public View getAdView() {
        if (getAd() == null) {
            return null;
        }
        VideoAdView videoAdView = new VideoAdView(this);
        this.mVideoPlayer = videoAdView;
        return videoAdView;
    }

    @Override // net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity, android.app.Activity
    protected void onDestroy() {
        this.vastActivityInteractor.activityDestroyed();
        if (this.mVideoAd != null) {
            this.mVideoAd.destroy();
            this.mReady = false;
        }
        super.onDestroy();
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

    @Override // net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (!this.mIsBackEnabled.booleanValue()) {
                return false;
            }
            dismiss();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity
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

    @Override // net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity
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

    /* JADX INFO: renamed from: net.pubnative.lite.sdk.interstitial.activity.VastInterstitialActivity$1, reason: invalid class name */
    class AnonymousClass1 extends VideoAdListener {
        AnonymousClass1() {
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdLoadSuccess() {
            if (VastInterstitialActivity.this.mReady) {
                return;
            }
            VastInterstitialActivity.this.mReady = true;
            VastInterstitialActivity.this.setProgressBarInvisible();
            VastInterstitialActivity.this.mVideoAd.show();
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdLoadFail(PlayerInfo playerInfo) {
            VastInterstitialActivity.this.setProgressBarInvisible();
            if (VastInterstitialActivity.this.getBroadcastSender() != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("pn_video_progress", 0);
                VastInterstitialActivity.this.getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.ERROR);
                VastInterstitialActivity.this.getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.VIDEO_ERROR, bundle);
                VastInterstitialActivity.this.getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.DISMISS);
            }
            VastInterstitialActivity.this.mIsFinishing = true;
            VastInterstitialActivity.this.finish();
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdClicked() {
            VastInterstitialActivity.this.getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.CLICK);
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdDidReachEnd() {
            VastInterstitialActivity.this.mReady = false;
            if (!VastInterstitialActivity.this.mHasEndCard) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: net.pubnative.lite.sdk.interstitial.activity.VastInterstitialActivity$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m9636x8c1ee1ea();
                    }
                }, 100L);
                VastInterstitialActivity.this.mIsSkippable = true;
            }
            VastInterstitialActivity.this.mIsVideoFinished = true;
            if (VastInterstitialActivity.this.getBroadcastSender() != null) {
                VastInterstitialActivity.this.getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.VIDEO_FINISH);
            }
        }

        /* JADX INFO: renamed from: lambda$onAdDidReachEnd$0$net-pubnative-lite-sdk-interstitial-activity-VastInterstitialActivity$1, reason: not valid java name */
        /* synthetic */ void m9636x8c1ee1ea() {
            VastInterstitialActivity.this.showInterstitialCloseButton();
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public synchronized void onAdSkipped() {
            VastInterstitialActivity.this.mIsVideoFinished = true;
            if (VastInterstitialActivity.this.getBroadcastSender() != null) {
                VastInterstitialActivity.this.getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.VIDEO_SKIP);
            }
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdCustomEndCardFound() {
            VastInterstitialActivity.this.mHasEndCard = true;
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onCustomEndCardShow(String str) {
            if (VastInterstitialActivity.this.mCustomEndCardImpressionTracked.booleanValue()) {
                return;
            }
            if (VastInterstitialActivity.this.getBroadcastSender() != null) {
                Bundle bundle = new Bundle();
                bundle.putString(Reporting.Key.END_CARD_TYPE, str);
                bundle.putString(Reporting.Key.CLICK_SOURCE_TYPE, Reporting.Key.CLICK_SOURCE_TYPE_END_CARD);
                VastInterstitialActivity.this.getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.CUSTOM_END_CARD_SHOW, bundle);
            }
            VastInterstitialActivity.this.mCustomEndCardImpressionTracked = true;
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onCustomEndCardClick(String str) {
            if (VastInterstitialActivity.this.mCustomEndCardClickTracked.booleanValue()) {
                return;
            }
            if (VastInterstitialActivity.this.getBroadcastSender() != null) {
                Bundle bundle = new Bundle();
                bundle.putString(Reporting.Key.END_CARD_TYPE, str);
                bundle.putString("click", str);
                bundle.putString(Reporting.Key.CLICK_SOURCE_TYPE, Reporting.Key.CLICK_SOURCE_TYPE_END_CARD);
                VastInterstitialActivity.this.getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.CUSTOM_END_CARD_CLICK, bundle);
            }
            VastInterstitialActivity.this.mCustomEndCardClickTracked = true;
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onDefaultEndCardShow(String str) {
            if (VastInterstitialActivity.this.mDefaultEndCardImpressionTracked.booleanValue()) {
                return;
            }
            if (VastInterstitialActivity.this.getBroadcastSender() != null) {
                Bundle bundle = new Bundle();
                bundle.putString(Reporting.Key.END_CARD_TYPE, str);
                bundle.putString(Reporting.Key.CLICK_SOURCE_TYPE, Reporting.Key.CLICK_SOURCE_TYPE_END_CARD);
                VastInterstitialActivity.this.getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.DEFAULT_END_CARD_SHOW, bundle);
            }
            VastInterstitialActivity.this.mDefaultEndCardImpressionTracked = true;
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onDefaultEndCardClick(String str) {
            if (VastInterstitialActivity.this.mDefaultEndCardClickTracked.booleanValue()) {
                return;
            }
            if (VastInterstitialActivity.this.getBroadcastSender() != null) {
                Bundle bundle = new Bundle();
                bundle.putString(Reporting.Key.END_CARD_TYPE, str);
                bundle.putString(Reporting.Key.CLICK_SOURCE_TYPE, Reporting.Key.CLICK_SOURCE_TYPE_END_CARD);
                VastInterstitialActivity.this.getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.DEFAULT_END_CARD_CLICK, bundle);
            }
            VastInterstitialActivity.this.mDefaultEndCardClickTracked = true;
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public synchronized void onEndCardLoadSuccess(Boolean bool) {
            if (bool.booleanValue() && VastInterstitialActivity.this.mLoadCustomEndCardTracked.booleanValue()) {
                return;
            }
            if (bool.booleanValue() || !VastInterstitialActivity.this.mLoadDefaultEndCardTracked.booleanValue()) {
                if (VastInterstitialActivity.this.getBroadcastSender() != null) {
                    if (bool.booleanValue()) {
                        VastInterstitialActivity.this.hideContentInfo();
                        VastInterstitialActivity.this.mLoadCustomEndCardTracked = true;
                    } else {
                        VastInterstitialActivity.this.mLoadDefaultEndCardTracked = true;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(Reporting.Key.IS_CUSTOM_END_CARD, bool.booleanValue());
                    VastInterstitialActivity.this.getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.END_CARD_LOAD_SUCCESS, bundle);
                }
            }
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onEndCardLoadFail(Boolean bool) {
            if (VastInterstitialActivity.this.mLoadEndCardFailTracked.booleanValue()) {
                return;
            }
            if (VastInterstitialActivity.this.getBroadcastSender() != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(Reporting.Key.IS_CUSTOM_END_CARD, bool.booleanValue());
                VastInterstitialActivity.this.getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.END_CARD_LOAD_FAILURE, bundle);
            }
            VastInterstitialActivity.this.mLoadEndCardFailTracked = true;
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onCustomCTACLick(boolean z) {
            String str = z ? "custom_cta_endcard_click" : "custom_cta_click";
            if (VastInterstitialActivity.this.mCustomCTAClickTrackedEvents.contains(str)) {
                return;
            }
            if (HyBid.getReportingController() != null && HyBid.isReportingEnabled().booleanValue()) {
                ReportingEvent reportingEvent = new ReportingEvent();
                reportingEvent.setEventType(str);
                reportingEvent.setAdFormat("fullscreen");
                reportingEvent.setCreativeType("video");
                reportingEvent.setPlatform("android");
                reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(IntegrationType.STANDALONE));
                if (VastInterstitialActivity.this.getAd() != null) {
                    reportingEvent.setImpId(VastInterstitialActivity.this.getAd().getSessionId());
                    reportingEvent.setCampaignId(VastInterstitialActivity.this.getAd().getCampaignId());
                    reportingEvent.setConfigId(VastInterstitialActivity.this.getAd().getConfigId());
                }
                reportingEvent.setTimestamp(System.currentTimeMillis());
                HyBid.getReportingController().reportEvent(reportingEvent);
            }
            if (str.equals("custom_cta_endcard_click")) {
                if (VastInterstitialActivity.this.mCustomCTAEndcardTracker != null) {
                    VastInterstitialActivity.this.mCustomCTAEndcardTracker.trackClick();
                }
            } else if (VastInterstitialActivity.this.mCustomCTATracker != null) {
                VastInterstitialActivity.this.mCustomCTATracker.trackClick();
            }
            VastInterstitialActivity.this.mCustomCTAClickTrackedEvents.add(str);
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onCustomCTAShow() {
            if (VastInterstitialActivity.this.mCustomCTAImpressionTracked.booleanValue()) {
                return;
            }
            if (HyBid.getReportingController() != null && HyBid.isReportingEnabled().booleanValue()) {
                ReportingEvent reportingEvent = new ReportingEvent();
                reportingEvent.setEventType("custom_cta_show");
                reportingEvent.setAdFormat("fullscreen");
                reportingEvent.setCreativeType("video");
                reportingEvent.setPlatform("android");
                reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(IntegrationType.STANDALONE));
                if (VastInterstitialActivity.this.getAd() != null) {
                    reportingEvent.setImpId(VastInterstitialActivity.this.getAd().getSessionId());
                    reportingEvent.setCampaignId(VastInterstitialActivity.this.getAd().getCampaignId());
                    reportingEvent.setConfigId(VastInterstitialActivity.this.getAd().getConfigId());
                }
                reportingEvent.setTimestamp(System.currentTimeMillis());
                HyBid.getReportingController().reportEvent(reportingEvent);
            }
            if (VastInterstitialActivity.this.mCustomCTATracker != null) {
                VastInterstitialActivity.this.mCustomCTATracker.trackImpression();
            }
            VastInterstitialActivity.this.mCustomCTAImpressionTracked = true;
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
            VastInterstitialActivity vastInterstitialActivity = VastInterstitialActivity.this;
            if (vastInterstitialActivity.mIsSkippable.booleanValue()) {
                i = 100;
            }
            vastInterstitialActivity.dismissVideo(i);
            VastInterstitialActivity.this.dismiss();
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdStarted() {
            if (VastInterstitialActivity.this.getBroadcastSender() != null) {
                VastInterstitialActivity.this.getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.VIDEO_START);
            }
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onEndCardSkipped(Boolean bool) {
            if (bool.booleanValue() && VastInterstitialActivity.this.mCustomEndCardSkipTracked.booleanValue()) {
                return;
            }
            if (bool.booleanValue() || !VastInterstitialActivity.this.mDefaultEndCardSkipTracked.booleanValue()) {
                if (!bool.booleanValue()) {
                    VastInterstitialActivity.this.mDefaultEndCardSkipTracked = true;
                    VastInterstitialActivity.this.mAdEventTracker.trackCompanionAdEvent(2, null);
                } else {
                    VastInterstitialActivity.this.mAdEventTracker.trackCustomEndcardEvent(2, null);
                }
                if (HyBid.getReportingController() == null || !HyBid.isReportingEnabled().booleanValue()) {
                    return;
                }
                ReportingEvent reportingEvent = new ReportingEvent();
                reportingEvent.setTimestamp(System.currentTimeMillis());
                if (VastInterstitialActivity.this.mDefaultEndCardSkipTracked.booleanValue()) {
                    reportingEvent.setEventType(Reporting.EventType.DEFAULT_ENDCARD_SKIP);
                    reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, "default");
                }
                HyBid.getReportingController().reportEvent(reportingEvent);
            }
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onEndCardClosed(Boolean bool) {
            if (bool.booleanValue() && VastInterstitialActivity.this.mCustomEndCardCloseTracked.booleanValue()) {
                return;
            }
            if (bool.booleanValue() || !VastInterstitialActivity.this.mDefaultEndCardCloseTracked.booleanValue()) {
                if (!bool.booleanValue()) {
                    VastInterstitialActivity.this.mDefaultEndCardCloseTracked = true;
                    VastInterstitialActivity.this.mAdEventTracker.trackCompanionAdEvent(3, null);
                } else {
                    VastInterstitialActivity.this.mCustomEndCardCloseTracked = true;
                    VastInterstitialActivity.this.mAdEventTracker.trackCustomEndcardEvent(3, null);
                }
                if (HyBid.getReportingController() == null || !HyBid.isReportingEnabled().booleanValue()) {
                    return;
                }
                ReportingEvent reportingEvent = new ReportingEvent();
                reportingEvent.setTimestamp(System.currentTimeMillis());
                if (VastInterstitialActivity.this.mDefaultEndCardCloseTracked.booleanValue()) {
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

    /* JADX INFO: renamed from: lambda$new$1$net-pubnative-lite-sdk-interstitial-activity-VastInterstitialActivity, reason: not valid java name */
    /* synthetic */ void m9634xb7fb72b9() {
        this.mIsVideoFinished = true;
        this.mIsSkippable = true;
        this.mIsBackEnabled = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissVideo(int i) {
        if (getBroadcastSender() != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("pn_video_progress", i);
            getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.VIDEO_DISMISS, bundle);
        }
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter.ImpressionListener
    public void onImpression() {
        if (getBroadcastSender() != null) {
            getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.SHOW);
        }
    }

    @Override // net.pubnative.lite.sdk.vpaid.AdCloseButtonListener
    public void showButton() {
        showInterstitialCloseButton();
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
