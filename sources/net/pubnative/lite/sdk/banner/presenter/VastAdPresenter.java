package net.pubnative.lite.sdk.banner.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.VideoListener;
import net.pubnative.lite.sdk.analytics.Reporting;
import net.pubnative.lite.sdk.analytics.ReportingController;
import net.pubnative.lite.sdk.analytics.ReportingEvent;
import net.pubnative.lite.sdk.contentinfo.AdFeedbackFormHelper;
import net.pubnative.lite.sdk.contentinfo.listeners.AdFeedbackLoadListener;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.AdSize;
import net.pubnative.lite.sdk.models.ContentInfo;
import net.pubnative.lite.sdk.models.ContentInfoIconXPosition;
import net.pubnative.lite.sdk.models.ContentInfoIconYPosition;
import net.pubnative.lite.sdk.models.ImpressionTrackingMethod;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.models.PositionX;
import net.pubnative.lite.sdk.models.PositionY;
import net.pubnative.lite.sdk.mraid.MRAIDViewListener;
import net.pubnative.lite.sdk.presenter.AdPresenter;
import net.pubnative.lite.sdk.utils.AdTracker;
import net.pubnative.lite.sdk.utils.CheckUtils;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.utils.URLValidator;
import net.pubnative.lite.sdk.views.PNAPIContentInfoView;
import net.pubnative.lite.sdk.visibility.ImpressionManager;
import net.pubnative.lite.sdk.visibility.ImpressionTracker;
import net.pubnative.lite.sdk.vpaid.CloseButtonListener;
import net.pubnative.lite.sdk.vpaid.PlayerInfo;
import net.pubnative.lite.sdk.vpaid.VideoAd;
import net.pubnative.lite.sdk.vpaid.VideoAdCacheItem;
import net.pubnative.lite.sdk.vpaid.VideoAdListener;
import net.pubnative.lite.sdk.vpaid.VideoAdView;
import net.pubnative.lite.sdk.vpaid.VideoVisibilityListener;
import net.pubnative.lite.sdk.vpaid.VideoVisibilityManager;
import net.pubnative.lite.sdk.vpaid.helpers.EventTracker;
import net.pubnative.lite.sdk.vpaid.models.vast.Icon;
import net.pubnative.lite.sdk.vpaid.utils.Utils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class VastAdPresenter implements AdPresenter, ImpressionTracker.Listener, PNAPIContentInfoView.ContentInfoListener, VideoVisibilityListener {
    private static final String TAG = "VastAdPresenter";
    private final Ad mAd;
    private AdTracker mAdEventTracker;
    private AdSize mAdSize;
    private View mContentInfo;
    private final Context mContext;
    private AdTracker mCustomCTAEndcardTracker;
    private AdTracker mCustomCTATracker;
    private AdPresenter.ImpressionListener mImpressionListener;
    private IntegrationType mIntegrationType;
    private boolean mIsDestroyed;
    private AdPresenter.Listener mListener;
    private final ImpressionTrackingMethod mTrackingMethod;
    private Icon mVastIcon;
    private VideoAd mVideoAd;
    private VideoListener mVideoListener;
    private VideoAdView mVideoPlayer;
    private VideoVisibilityManager videoVisibilityManager;
    private boolean mLoaded = false;
    private boolean isFeedbackFormVisible = false;
    private Boolean mDefaultEndCardClickTracked = false;
    private Boolean mCustomEndCardClickTracked = false;
    private List<String> mCustomCTAClickTrackedEvents = new ArrayList();
    private Boolean mDefaultEndCardImpressionTracked = false;
    private Boolean mCustomEndCardImpressionTracked = false;
    private Boolean mLoadDefaultEndCardTracked = false;
    private Boolean mLoadCustomEndCardTracked = false;
    private Boolean mCustomCTAImpressionTracked = false;
    private Boolean mDefaultEndCardSkipTracked = false;
    private Boolean mCustomEndCardSkipTracked = false;
    private Boolean mDefaultEndCardCloseTracked = false;
    private Boolean mCustomEndCardCloseTracked = false;
    private final ImpressionTracker.Listener mNativeTrackerListener = new ImpressionTracker.Listener() { // from class: net.pubnative.lite.sdk.banner.presenter.VastAdPresenter.1
        @Override // net.pubnative.lite.sdk.visibility.ImpressionTracker.Listener
        public void onImpression(View view) {
            if (VastAdPresenter.this.mVideoAd != null) {
                VastAdPresenter.this.mVideoAd.show();
            }
        }
    };
    private final AdPresenter.ImpressionListener mVideoImpressionListener = new AdPresenter.ImpressionListener() { // from class: net.pubnative.lite.sdk.banner.presenter.VastAdPresenter.2
        @Override // net.pubnative.lite.sdk.presenter.AdPresenter.ImpressionListener
        public void onImpression() {
            if (VastAdPresenter.this.mImpressionListener != null) {
                VastAdPresenter.this.mImpressionListener.onImpression();
            }
        }
    };
    private final CloseButtonListener mAdCloseButtonListener = new CloseButtonListener() { // from class: net.pubnative.lite.sdk.banner.presenter.VastAdPresenter.3
        @Override // net.pubnative.lite.sdk.vpaid.CloseButtonListener
        public void onCloseButtonVisible() {
        }
    };
    private final VideoAdListener mVideoAdListener = new VideoAdListener() { // from class: net.pubnative.lite.sdk.banner.presenter.VastAdPresenter.4
        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdCustomEndCardFound() {
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdLoadSuccess() {
            if (VastAdPresenter.this.mIsDestroyed || VastAdPresenter.this.mLoaded) {
                return;
            }
            VastAdPresenter.this.mLoaded = true;
            if (VastAdPresenter.this.mListener != null) {
                AdPresenter.Listener listener = VastAdPresenter.this.mListener;
                VastAdPresenter vastAdPresenter = VastAdPresenter.this;
                listener.onAdLoaded(vastAdPresenter, vastAdPresenter.buildView());
            }
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdLoadFail(PlayerInfo playerInfo) {
            if (VastAdPresenter.this.mListener != null) {
                VastAdPresenter.this.mListener.onAdError(VastAdPresenter.this);
            }
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdClicked() {
            if (VastAdPresenter.this.mIsDestroyed || VastAdPresenter.this.mListener == null) {
                return;
            }
            VastAdPresenter.this.mListener.onAdClicked(VastAdPresenter.this);
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdDidReachEnd() {
            if (VastAdPresenter.this.mVideoListener != null) {
                VastAdPresenter.this.mVideoListener.onVideoFinished();
            }
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdSkipped() {
            if (VastAdPresenter.this.mVideoListener != null) {
                VastAdPresenter.this.mVideoListener.onVideoSkipped();
            }
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdDismissed() {
            onAdDismissed(-1);
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdDismissed(int i) {
            VastAdPresenter.this.hideContentInfo();
            if (VastAdPresenter.this.mVideoListener != null) {
                VastAdPresenter.this.mVideoListener.onVideoDismissed(i);
            }
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onAdStarted() {
            if (VastAdPresenter.this.mVideoListener != null) {
                VastAdPresenter.this.mVideoListener.onVideoStarted();
            }
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public synchronized void onEndCardLoadSuccess(Boolean bool) {
            if (bool.booleanValue() && VastAdPresenter.this.mLoadCustomEndCardTracked.booleanValue()) {
                return;
            }
            if (bool.booleanValue() || !VastAdPresenter.this.mLoadDefaultEndCardTracked.booleanValue()) {
                if (!bool.booleanValue()) {
                    VastAdPresenter.this.mLoadDefaultEndCardTracked = true;
                } else {
                    VastAdPresenter.this.mLoadCustomEndCardTracked = true;
                }
                if (HyBid.getReportingController() != null && HyBid.isReportingEnabled().booleanValue()) {
                    ReportingEvent reportingEvent = new ReportingEvent();
                    reportingEvent.setTimestamp(System.currentTimeMillis());
                    reportingEvent.setAdFormat("banner");
                    reportingEvent.setPlatform("android");
                    reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(VastAdPresenter.this.mIntegrationType));
                    if (VastAdPresenter.this.mAd != null) {
                        reportingEvent.setImpId(VastAdPresenter.this.mAd.getSessionId());
                        reportingEvent.setCampaignId(VastAdPresenter.this.mAd.getCampaignId());
                        reportingEvent.setConfigId(VastAdPresenter.this.mAd.getConfigId());
                    }
                    if (VastAdPresenter.this.mLoadDefaultEndCardTracked.booleanValue()) {
                        reportingEvent.setEventType(Reporting.EventType.DEFAULT_END_CARD_LOAD_SUCCESS);
                        reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, "default");
                    } else {
                        reportingEvent.setEventType(Reporting.EventType.CUSTOM_END_CARD_LOAD_SUCCESS);
                        reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, "custom");
                    }
                    HyBid.getReportingController().reportEvent(reportingEvent);
                }
            }
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onEndCardLoadFail(Boolean bool) {
            if (HyBid.getReportingController() == null || !HyBid.isReportingEnabled().booleanValue()) {
                return;
            }
            ReportingEvent reportingEvent = new ReportingEvent();
            reportingEvent.setTimestamp(System.currentTimeMillis());
            reportingEvent.setAdFormat("banner");
            reportingEvent.setPlatform("android");
            reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(VastAdPresenter.this.mIntegrationType));
            if (VastAdPresenter.this.mAd != null) {
                reportingEvent.setImpId(VastAdPresenter.this.mAd.getSessionId());
                reportingEvent.setCampaignId(VastAdPresenter.this.mAd.getCampaignId());
                reportingEvent.setConfigId(VastAdPresenter.this.mAd.getConfigId());
            }
            if (!bool.booleanValue()) {
                reportingEvent.setEventType(Reporting.EventType.DEFAULT_END_CARD_LOAD_FAILURE);
                reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, "default");
            } else {
                reportingEvent.setEventType(Reporting.EventType.CUSTOM_END_CARD_LOAD_FAILURE);
                reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, "custom");
            }
            HyBid.getReportingController().reportEvent(reportingEvent);
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onDefaultEndCardShow(String str) {
            if (VastAdPresenter.this.mDefaultEndCardImpressionTracked.booleanValue()) {
                return;
            }
            VastAdPresenter.this.reportCompanionView();
            if (HyBid.getReportingController() != null && HyBid.isReportingEnabled().booleanValue()) {
                ReportingEvent reportingEvent = new ReportingEvent();
                reportingEvent.setTimestamp(System.currentTimeMillis());
                reportingEvent.setAdFormat("banner");
                reportingEvent.setPlatform("android");
                reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(VastAdPresenter.this.mIntegrationType));
                if (VastAdPresenter.this.mAd != null) {
                    reportingEvent.setImpId(VastAdPresenter.this.mAd.getSessionId());
                    reportingEvent.setCampaignId(VastAdPresenter.this.mAd.getCampaignId());
                    reportingEvent.setConfigId(VastAdPresenter.this.mAd.getConfigId());
                }
                reportingEvent.setEventType(Reporting.EventType.DEFAULT_ENDCARD_IMPRESSION);
                reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, str);
                HyBid.getReportingController().reportEvent(reportingEvent);
            }
            VastAdPresenter.this.mAdEventTracker.trackCompanionAdEvent(1, null);
            VastAdPresenter.this.mDefaultEndCardImpressionTracked = true;
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onCustomEndCardShow(String str) {
            if (VastAdPresenter.this.mCustomEndCardImpressionTracked.booleanValue()) {
                return;
            }
            VastAdPresenter.this.hideContentInfo();
            if (HyBid.getReportingController() != null && HyBid.isReportingEnabled().booleanValue()) {
                ReportingEvent reportingEvent = new ReportingEvent();
                reportingEvent.setTimestamp(System.currentTimeMillis());
                reportingEvent.setAdFormat("banner");
                reportingEvent.setPlatform("android");
                reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(VastAdPresenter.this.mIntegrationType));
                if (VastAdPresenter.this.mAd != null) {
                    reportingEvent.setImpId(VastAdPresenter.this.mAd.getSessionId());
                    reportingEvent.setCampaignId(VastAdPresenter.this.mAd.getCampaignId());
                    reportingEvent.setConfigId(VastAdPresenter.this.mAd.getConfigId());
                }
                reportingEvent.setEventType("custom_endcard_impression");
                reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, str);
                HyBid.getReportingController().reportEvent(reportingEvent);
            }
            VastAdPresenter.this.mAdEventTracker.trackCustomEndcardEvent(1, null);
            VastAdPresenter.this.mCustomEndCardImpressionTracked = true;
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onDefaultEndCardClick(String str) {
            if (VastAdPresenter.this.mDefaultEndCardClickTracked.booleanValue()) {
                return;
            }
            if (HyBid.getReportingController() != null && HyBid.isReportingEnabled().booleanValue()) {
                ReportingEvent reportingEvent = new ReportingEvent();
                reportingEvent.setEventType(Reporting.EventType.DEFAULT_ENDCARD_CLICK);
                reportingEvent.setTimestamp(System.currentTimeMillis());
                reportingEvent.setAdFormat("banner");
                reportingEvent.setPlatform("android");
                reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(VastAdPresenter.this.mIntegrationType));
                if (VastAdPresenter.this.mAd != null) {
                    reportingEvent.setImpId(VastAdPresenter.this.mAd.getSessionId());
                    reportingEvent.setCampaignId(VastAdPresenter.this.mAd.getCampaignId());
                    reportingEvent.setConfigId(VastAdPresenter.this.mAd.getConfigId());
                }
                reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, "default");
                HyBid.getReportingController().reportEvent(reportingEvent);
            }
            VastAdPresenter.this.mAdEventTracker.trackCompanionAdEvent(4, null);
            VastAdPresenter.this.mDefaultEndCardClickTracked = true;
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onCustomEndCardClick(String str) {
            if (VastAdPresenter.this.mCustomEndCardClickTracked.booleanValue()) {
                return;
            }
            if (HyBid.getReportingController() != null && HyBid.isReportingEnabled().booleanValue()) {
                ReportingEvent reportingEvent = new ReportingEvent();
                reportingEvent.setEventType("custom_endcard_click");
                reportingEvent.setTimestamp(System.currentTimeMillis());
                reportingEvent.setAdFormat("banner");
                reportingEvent.setPlatform("android");
                reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(VastAdPresenter.this.mIntegrationType));
                if (VastAdPresenter.this.mAd != null) {
                    reportingEvent.setImpId(VastAdPresenter.this.mAd.getSessionId());
                    reportingEvent.setCampaignId(VastAdPresenter.this.mAd.getCampaignId());
                    reportingEvent.setConfigId(VastAdPresenter.this.mAd.getConfigId());
                }
                reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, "custom");
                HyBid.getReportingController().reportEvent(reportingEvent);
            }
            VastAdPresenter.this.mAdEventTracker.trackCustomEndcardEvent(4, null);
            VastAdPresenter.this.mCustomEndCardClickTracked = true;
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onCustomCTACLick(boolean z) {
            String str = z ? "custom_cta_endcard_click" : "custom_cta_click";
            if (VastAdPresenter.this.mCustomCTAClickTrackedEvents.contains(str)) {
                return;
            }
            if (HyBid.getReportingController() != null && HyBid.isReportingEnabled().booleanValue()) {
                ReportingEvent reportingEvent = new ReportingEvent();
                reportingEvent.setEventType(str);
                reportingEvent.setPlatform("android");
                reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(VastAdPresenter.this.mIntegrationType));
                reportingEvent.setTimestamp(System.currentTimeMillis());
                if (VastAdPresenter.this.mAd != null) {
                    reportingEvent.setImpId(VastAdPresenter.this.mAd.getSessionId());
                    reportingEvent.setCampaignId(VastAdPresenter.this.mAd.getCampaignId());
                    reportingEvent.setConfigId(VastAdPresenter.this.mAd.getConfigId());
                }
                HyBid.getReportingController().reportEvent(reportingEvent);
            }
            if (str.equals("custom_cta_endcard_click")) {
                if (VastAdPresenter.this.mCustomCTAEndcardTracker != null) {
                    VastAdPresenter.this.mCustomCTAEndcardTracker.trackClick();
                }
            } else if (VastAdPresenter.this.mCustomCTATracker != null) {
                VastAdPresenter.this.mCustomCTATracker.trackImpression();
            }
            VastAdPresenter.this.mCustomCTAClickTrackedEvents.add(str);
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onCustomCTAShow() {
            if (VastAdPresenter.this.mCustomCTAImpressionTracked.booleanValue()) {
                return;
            }
            if (HyBid.getReportingController() != null && HyBid.isReportingEnabled().booleanValue()) {
                ReportingEvent reportingEvent = new ReportingEvent();
                reportingEvent.setEventType("custom_cta_show");
                reportingEvent.setPlatform("android");
                reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(VastAdPresenter.this.mIntegrationType));
                reportingEvent.setTimestamp(System.currentTimeMillis());
                if (VastAdPresenter.this.mAd != null) {
                    reportingEvent.setImpId(VastAdPresenter.this.mAd.getSessionId());
                    reportingEvent.setCampaignId(VastAdPresenter.this.mAd.getCampaignId());
                    reportingEvent.setConfigId(VastAdPresenter.this.mAd.getConfigId());
                }
                HyBid.getReportingController().reportEvent(reportingEvent);
            }
            if (VastAdPresenter.this.mCustomCTATracker != null) {
                VastAdPresenter.this.mCustomCTATracker.trackImpression();
            }
            VastAdPresenter.this.mCustomCTAImpressionTracked = true;
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onCustomCTALoadFail() {
            Logger.e("onCustomCTALoadFail", "CTA Failed to load");
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onEndCardSkipped(Boolean bool) {
            if (bool.booleanValue() && VastAdPresenter.this.mCustomEndCardSkipTracked.booleanValue()) {
                return;
            }
            if (bool.booleanValue() || !VastAdPresenter.this.mDefaultEndCardSkipTracked.booleanValue()) {
                if (!bool.booleanValue()) {
                    VastAdPresenter.this.mDefaultEndCardSkipTracked = true;
                    VastAdPresenter.this.mAdEventTracker.trackCompanionAdEvent(2, null);
                } else {
                    VastAdPresenter.this.mAdEventTracker.trackCustomEndcardEvent(2, null);
                }
                if (HyBid.getReportingController() == null || !HyBid.isReportingEnabled().booleanValue()) {
                    return;
                }
                ReportingEvent reportingEvent = new ReportingEvent();
                reportingEvent.setTimestamp(System.currentTimeMillis());
                if (VastAdPresenter.this.mDefaultEndCardSkipTracked.booleanValue()) {
                    reportingEvent.setEventType(Reporting.EventType.DEFAULT_ENDCARD_SKIP);
                    reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, "default");
                }
                HyBid.getReportingController().reportEvent(reportingEvent);
            }
        }

        @Override // net.pubnative.lite.sdk.vpaid.VideoAdListener
        public void onEndCardClosed(Boolean bool) {
            if (bool.booleanValue() && VastAdPresenter.this.mCustomEndCardCloseTracked.booleanValue()) {
                return;
            }
            if (bool.booleanValue() || !VastAdPresenter.this.mDefaultEndCardCloseTracked.booleanValue()) {
                if (!bool.booleanValue()) {
                    VastAdPresenter.this.mDefaultEndCardCloseTracked = true;
                    VastAdPresenter.this.mAdEventTracker.trackCompanionAdEvent(3, null);
                } else {
                    VastAdPresenter.this.mCustomEndCardCloseTracked = true;
                    VastAdPresenter.this.mAdEventTracker.trackCustomEndcardEvent(3, null);
                }
                if (HyBid.getReportingController() == null || !HyBid.isReportingEnabled().booleanValue()) {
                    return;
                }
                ReportingEvent reportingEvent = new ReportingEvent();
                reportingEvent.setTimestamp(System.currentTimeMillis());
                if (!VastAdPresenter.this.mDefaultEndCardCloseTracked.booleanValue()) {
                    reportingEvent.setEventType(Reporting.EventType.DEFAULT_ENDCARD_CLOSE);
                    reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, "default");
                } else {
                    reportingEvent.setEventType(Reporting.EventType.CUSTOM_ENDCARD_CLOSE);
                    reportingEvent.setCustomString(Reporting.Key.END_CARD_TYPE, "custom");
                }
                HyBid.getReportingController().reportEvent(reportingEvent);
            }
        }
    };
    public boolean isLinkClickRunning = false;
    private ReportingController mReportingController = HyBid.getReportingController();

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public JSONObject getPlacementParams() {
        return null;
    }

    @Override // net.pubnative.lite.sdk.visibility.ImpressionTracker.Listener
    public void onImpression(View view) {
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public void setMRaidListener(MRAIDViewListener mRAIDViewListener) {
    }

    public VastAdPresenter(Context context, Ad ad, AdSize adSize, ImpressionTrackingMethod impressionTrackingMethod, IntegrationType integrationType) {
        this.mContext = context;
        this.mAdSize = adSize;
        this.mAd = ad;
        ImpressionTrackingMethod impressionTrackingMethodFromString = (ad == null || ad.getImpressionTrackingMethod() == null || ImpressionTrackingMethod.fromString(ad.getImpressionTrackingMethod()) == null) ? null : ImpressionTrackingMethod.fromString(ad.getImpressionTrackingMethod());
        if (impressionTrackingMethodFromString != null) {
            this.mTrackingMethod = impressionTrackingMethodFromString;
        } else if (impressionTrackingMethod != null) {
            this.mTrackingMethod = impressionTrackingMethod;
        } else {
            this.mTrackingMethod = ImpressionTrackingMethod.AD_VIEWABLE;
        }
        VideoVisibilityManager videoVisibilityManager = VideoVisibilityManager.getInstance();
        this.videoVisibilityManager = videoVisibilityManager;
        videoVisibilityManager.addCallback(this);
        this.mIntegrationType = integrationType;
        initiateCustomCTAAdTrackers();
        initiateEventTrackers();
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public void setListener(AdPresenter.Listener listener) {
        this.mListener = listener;
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public void setImpressionListener(AdPresenter.ImpressionListener impressionListener) {
        this.mImpressionListener = impressionListener;
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public void setVideoListener(VideoListener videoListener) {
        this.mVideoListener = videoListener;
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public Ad getAd() {
        return this.mAd;
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public void load() {
        VideoAdCacheItem videoAdCacheItemRemove;
        if (CheckUtils.NoThrow.checkArgument(!this.mIsDestroyed, "VastMRectPresenter is destroyed")) {
            try {
                if (this.mAd != null) {
                    this.mVideoAd = new VideoAd(this.mContext, this.mAd, false, false, this.mVideoImpressionListener);
                    VideoAdView videoAdView = new VideoAdView(this.mContext);
                    this.mVideoPlayer = videoAdView;
                    this.mVideoAd.bindView(videoAdView);
                    this.mVideoAd.setAdListener(this.mVideoAdListener);
                    this.mVideoAd.setAdCloseButtonListener(this.mAdCloseButtonListener);
                    this.mDefaultEndCardClickTracked = false;
                    this.mCustomEndCardClickTracked = false;
                    this.mDefaultEndCardImpressionTracked = false;
                    this.mCustomEndCardImpressionTracked = false;
                    this.mLoadDefaultEndCardTracked = false;
                    this.mLoadCustomEndCardTracked = false;
                    if (!TextUtils.isEmpty(getAd().getZoneId()) && (videoAdCacheItemRemove = HyBid.getVideoAdCache().remove(getAd().getZoneId())) != null) {
                        this.mVideoAd.setVideoCacheItem(videoAdCacheItemRemove);
                        if (videoAdCacheItemRemove.getAdParams() != null && videoAdCacheItemRemove.getAdParams().getAdIcon() != null) {
                            this.mVastIcon = videoAdCacheItemRemove.getAdParams().getAdIcon();
                        }
                    }
                    this.mVideoAd.load(this.mIntegrationType);
                }
            } catch (Exception e) {
                Logger.e(TAG, e.getMessage());
                AdPresenter.Listener listener = this.mListener;
                if (listener != null) {
                    listener.onAdError(this);
                }
                VideoListener videoListener = this.mVideoListener;
                if (videoListener != null) {
                    videoListener.onVideoError(0);
                }
            }
        }
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public void destroy() {
        VideoAd videoAd = this.mVideoAd;
        if (videoAd != null) {
            videoAd.destroy();
        }
        this.videoVisibilityManager.removeCallback(this);
        this.mListener = null;
        this.mIsDestroyed = true;
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public void startTracking() {
        Ad ad;
        if (this.mTrackingMethod == ImpressionTrackingMethod.AD_VIEWABLE && (ad = this.mAd) != null) {
            ImpressionManager.startTrackingView(this.mVideoPlayer, this.mAdSize, ad.getImpressionMinVisibleTime(), this.mAd.getImpressionVisiblePercent(), this.mNativeTrackerListener);
            return;
        }
        VideoAd videoAd = this.mVideoAd;
        if (videoAd != null) {
            videoAd.show();
        }
    }

    @Override // net.pubnative.lite.sdk.presenter.AdPresenter
    public void stopTracking() {
        if (this.mTrackingMethod == ImpressionTrackingMethod.AD_VIEWABLE) {
            ImpressionManager.stopTrackingView(this.mVideoPlayer);
        }
        this.mVideoAd.dismiss();
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoVisibilityListener
    public void pauseAd() {
        VideoAd videoAd = this.mVideoAd;
        if (videoAd == null || !videoAd.isShowing()) {
            return;
        }
        this.mVideoAd.pause();
    }

    @Override // net.pubnative.lite.sdk.vpaid.VideoVisibilityListener
    public void resumeAd() {
        VideoAd videoAd = this.mVideoAd;
        if (videoAd == null || !videoAd.isShowing() || this.isFeedbackFormVisible) {
            return;
        }
        this.mVideoAd.resume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View buildView() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        frameLayout.addView(this.mVideoPlayer, layoutParams);
        setupContentInfo(frameLayout);
        return frameLayout;
    }

    private void setupContentInfo(ViewGroup viewGroup) {
        if (getAd() == null || viewGroup == null) {
            return;
        }
        ContentInfo contentInfo = Utils.parseContentInfo(this.mVastIcon);
        View contentInfo2 = getContentInfo(viewGroup.getContext(), getAd(), contentInfo);
        this.mContentInfo = contentInfo2;
        if (contentInfo2 != null) {
            if (contentInfo != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) contentInfo2.getLayoutParams();
                ContentInfoIconXPosition contentInfoIconXPosition = getAd().getContentInfoIconXPosition();
                int i = GravityCompat.END;
                if (contentInfoIconXPosition == null ? contentInfo.getPositionX() != PositionX.RIGHT : getAd().getContentInfoIconXPosition() != ContentInfoIconXPosition.RIGHT) {
                    i = 8388611;
                }
                int i2 = 80;
                if (getAd().getContentInfoIconYPosition() == null ? contentInfo.getPositionY() != PositionY.BOTTOM : getAd().getContentInfoIconYPosition() != ContentInfoIconYPosition.BOTTOM) {
                    i2 = 48;
                }
                layoutParams.gravity = i | i2;
                viewGroup.addView(this.mContentInfo, layoutParams);
            } else {
                viewGroup.addView(contentInfo2);
            }
            if (contentInfo == null || contentInfo.getViewTrackers() == null || contentInfo.getViewTrackers().isEmpty()) {
                return;
            }
            Iterator<String> it = contentInfo.getViewTrackers().iterator();
            while (it.hasNext()) {
                EventTracker.post(viewGroup.getContext(), it.next(), null, true);
            }
        }
    }

    private View getContentInfo(Context context, Ad ad, ContentInfo contentInfo) {
        return contentInfo == null ? ad.getContentInfoContainer(context, this) : ad.getContentInfoContainer(context, contentInfo, this);
    }

    @Override // net.pubnative.lite.sdk.views.PNAPIContentInfoView.ContentInfoListener
    public void onIconClicked(List<String> list) {
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                EventTracker.post(this.mContext, list.get(i), null, false);
            }
        }
        invokeOnContentInfoClick();
    }

    private void invokeOnContentInfoClick() {
        if (this.mReportingController == null || !HyBid.isReportingEnabled().booleanValue()) {
            return;
        }
        ReportingEvent reportingEvent = new ReportingEvent();
        reportingEvent.setEventType(Reporting.EventType.CONTENT_INFO_CLICK);
        reportingEvent.setTimestamp(System.currentTimeMillis());
        reportingEvent.setPlatform("android");
        Ad ad = this.mAd;
        if (ad != null) {
            reportingEvent.setImpId(ad.getSessionId());
            reportingEvent.setCampaignId(this.mAd.getCampaignId());
            reportingEvent.setConfigId(this.mAd.getConfigId());
        }
        this.mReportingController.reportEvent(reportingEvent);
    }

    @Override // net.pubnative.lite.sdk.views.PNAPIContentInfoView.ContentInfoListener
    public synchronized void onLinkClicked(String str) {
        Ad ad;
        if (!this.isLinkClickRunning) {
            this.isLinkClickRunning = true;
            AdFeedbackFormHelper adFeedbackFormHelper = new AdFeedbackFormHelper();
            if (URLValidator.isValidURL(str) && (ad = this.mAd) != null) {
                adFeedbackFormHelper.showFeedbackForm(this.mContext, str, ad, "banner", IntegrationType.STANDALONE, new AdFeedbackLoadListener() { // from class: net.pubnative.lite.sdk.banner.presenter.VastAdPresenter.5
                    @Override // net.pubnative.lite.sdk.contentinfo.listeners.AdFeedbackLoadListener
                    public void onLoad(String str2) {
                    }

                    @Override // net.pubnative.lite.sdk.contentinfo.listeners.AdFeedbackLoadListener
                    public void onLoadFinished() {
                        VastAdPresenter.this.isFeedbackFormVisible = true;
                        VastAdPresenter.this.isLinkClickRunning = false;
                    }

                    @Override // net.pubnative.lite.sdk.contentinfo.listeners.AdFeedbackLoadListener
                    public void onLoadFailed(Throwable th) {
                        Logger.e(VastAdPresenter.TAG, th.getMessage());
                        VastAdPresenter.this.isLinkClickRunning = false;
                    }

                    @Override // net.pubnative.lite.sdk.contentinfo.listeners.AdFeedbackLoadListener
                    public void onFormClosed() {
                        VastAdPresenter.this.isFeedbackFormVisible = false;
                        VastAdPresenter.this.isLinkClickRunning = false;
                    }
                });
            } else {
                Logger.e(TAG, "URL is invalid");
                this.isLinkClickRunning = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportCompanionView() {
        if (HyBid.getReportingController() == null || !HyBid.isReportingEnabled().booleanValue()) {
            return;
        }
        ReportingEvent reportingEvent = new ReportingEvent();
        reportingEvent.setEventType(Reporting.EventType.COMPANION_VIEW);
        reportingEvent.setAdFormat("banner");
        reportingEvent.setCreativeType("video");
        reportingEvent.setPlatform("android");
        reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(IntegrationType.STANDALONE));
        Ad ad = this.mAd;
        if (ad != null) {
            reportingEvent.setImpId(ad.getSessionId());
            reportingEvent.setCampaignId(this.mAd.getCampaignId());
            reportingEvent.setConfigId(this.mAd.getConfigId());
        }
        reportingEvent.setTimestamp(System.currentTimeMillis());
        HyBid.getReportingController().reportEvent(reportingEvent);
    }

    private void initiateCustomCTAAdTrackers() {
        if (this.mAd != null) {
            this.mCustomCTATracker = new AdTracker(this.mAd.getBeacons("custom_cta_show"), this.mAd.getBeacons("custom_cta_click"), false);
            this.mCustomCTAEndcardTracker = new AdTracker(null, this.mAd.getBeacons("custom_cta_endcard_click"), false);
        }
    }

    private void initiateEventTrackers() {
        if (this.mAd != null) {
            this.mAdEventTracker = new AdTracker(null, null, null, this.mAd.getBeacons(Ad.Beacon.COMPANION_AD_EVENT), this.mAd.getBeacons(Ad.Beacon.CUSTOM_ENDCARD_EVENT));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideContentInfo() {
        View view = this.mContentInfo;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
