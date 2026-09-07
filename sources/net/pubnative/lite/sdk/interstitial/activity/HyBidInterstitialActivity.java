package net.pubnative.lite.sdk.interstitial.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.analytics.Reporting;
import net.pubnative.lite.sdk.analytics.ReportingController;
import net.pubnative.lite.sdk.analytics.ReportingEvent;
import net.pubnative.lite.sdk.contentinfo.AdFeedbackFormHelper;
import net.pubnative.lite.sdk.contentinfo.listeners.AdFeedbackLoadListener;
import net.pubnative.lite.sdk.interstitial.HyBidInterstitialBroadcastReceiver;
import net.pubnative.lite.sdk.interstitial.HyBidInterstitialBroadcastSender;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.AdExperience;
import net.pubnative.lite.sdk.models.ContentInfo;
import net.pubnative.lite.sdk.models.ContentInfoIconXPosition;
import net.pubnative.lite.sdk.models.ContentInfoIconYPosition;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.models.PositionX;
import net.pubnative.lite.sdk.models.PositionY;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.utils.URLValidator;
import net.pubnative.lite.sdk.utils.UrlHandler;
import net.pubnative.lite.sdk.views.CloseableContainer;
import net.pubnative.lite.sdk.views.PNAPIContentInfoView;
import net.pubnative.lite.sdk.vpaid.VideoAd;
import net.pubnative.lite.sdk.vpaid.helpers.EventTracker;
import net.pubnative.lite.sdk.vpaid.models.vast.Icon;
import net.pubnative.lite.sdk.vpaid.utils.Utils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class HyBidInterstitialActivity extends Activity implements PNAPIContentInfoView.ContentInfoListener {
    public static final String EXTRA_BROADCAST_ID = "extra_pn_broadcast_id";
    public static final String EXTRA_SKIP_OFFSET = "extra_pn_skip_offset";
    public static final String EXTRA_ZONE_ID = "extra_pn_zone_id";
    public static final String INTEGRATION_TYPE = "integration_type";
    private static final int REDUCED_CLOSE_BUTTON_SIZE = 20;
    private static final String TAG = "HyBidInterstitialActivity";
    protected AdFeedbackFormHelper adFeedbackFormHelper;
    private Ad mAd;
    private HyBidInterstitialBroadcastSender mBroadcastSender;
    private CloseableContainer mCloseableContainer;
    protected IntegrationType mIntegrationType;
    private ProgressBar mProgressBar;
    ReportingController mReportingController;
    private UrlHandler mUrlHandlerDelegate;
    protected VideoAd mVideoAd;
    private String mZoneId;
    private boolean mIsVast = false;
    protected boolean mIsFeedbackFormOpen = false;
    private boolean mIsFeedbackFormLoading = false;
    protected Boolean mIsSkippable = false;
    protected Boolean mIsBackEnabled = false;
    protected Boolean mDefaultEndCardClickTracked = false;
    protected Boolean mCustomEndCardClickTracked = false;
    protected List<String> mCustomCTAClickTrackedEvents = new ArrayList();
    protected Boolean mDefaultEndCardImpressionTracked = false;
    protected Boolean mCustomEndCardImpressionTracked = false;
    protected Boolean mLoadDefaultEndCardTracked = false;
    protected Boolean mLoadCustomEndCardTracked = false;
    protected Boolean mLoadEndCardFailTracked = false;
    protected Boolean mCustomCTAImpressionTracked = false;
    protected Boolean mDefaultEndCardSkipTracked = false;
    protected Boolean mCustomEndCardSkipTracked = false;
    protected Boolean mCustomEndCardCloseTracked = false;
    protected Boolean mDefaultEndCardCloseTracked = false;
    protected View mContentInfoView = null;
    protected boolean mIsFinishing = false;
    protected boolean mIsVideoFinished = false;
    protected boolean mIsContentInfoIconClickTracked = false;
    private final CloseableContainer.OnCloseListener mCloseListener = new CloseableContainer.OnCloseListener() { // from class: net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity$$ExternalSyntheticLambda0
        @Override // net.pubnative.lite.sdk.views.CloseableContainer.OnCloseListener
        public final void onClose() {
            this.f$0.closeButtonClicked();
        }
    };
    String processedURL = "";
    public boolean isLinkClickRunning = false;

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.C, me);
        return super.dispatchTouchEvent(me);
    }

    public abstract View getAdView();

    protected abstract void pauseAd();

    protected abstract void resumeAd();

    protected abstract boolean shouldShowContentInfo();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        FrameLayout contentInfoContainer;
        super.onCreate(bundle);
        Intent intent = getIntent();
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        this.mUrlHandlerDelegate = new UrlHandler(this);
        this.mZoneId = intent.getStringExtra("extra_pn_zone_id");
        validateIntegrationType(intent.getStringExtra("integration_type"));
        this.mReportingController = HyBid.getReportingController();
        long longExtra = intent.getLongExtra("extra_pn_broadcast_id", -1L);
        if (!TextUtils.isEmpty(this.mZoneId) && longExtra != -1) {
            this.mBroadcastSender = new HyBidInterstitialBroadcastSender(this, longExtra);
            View adView = getAdView();
            if (adView != null) {
                this.mCloseableContainer = new CloseableContainer(this);
                if (hasReducedCloseSize()) {
                    this.mCloseableContainer.setCloseSize(20);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                this.mProgressBar = new ProgressBar(this);
                setProgressBarInvisible();
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 17;
                this.mCloseableContainer.addView(this.mProgressBar, layoutParams2);
                this.mCloseableContainer.addView(adView, layoutParams);
                this.mCloseableContainer.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                showInterstitialCloseButton();
                if (!this.mIsVast && shouldShowContentInfo() && getAd() != null && (contentInfoContainer = getAd().getContentInfoContainer(this, this)) != null) {
                    this.mCloseableContainer.addView(contentInfoContainer);
                }
                setContentView(this.mCloseableContainer);
                return;
            }
            this.mIsFinishing = true;
            finish();
            return;
        }
        this.mIsFinishing = true;
        finish();
    }

    private void validateIntegrationType(String str) {
        if (str == null) {
            this.mIntegrationType = IntegrationType.IN_APP_BIDDING;
            return;
        }
        if (str.equals(IntegrationType.HEADER_BIDDING.getCode())) {
            this.mIntegrationType = IntegrationType.HEADER_BIDDING;
            return;
        }
        if (str.equals(IntegrationType.MEDIATION.getCode())) {
            this.mIntegrationType = IntegrationType.MEDIATION;
        } else if (str.equals(IntegrationType.STANDALONE.getCode())) {
            this.mIntegrationType = IntegrationType.STANDALONE;
        } else {
            this.mIntegrationType = IntegrationType.IN_APP_BIDDING;
        }
    }

    protected void setupContentInfo() {
        setupContentInfo(null);
    }

    protected void setupContentInfo(Icon icon) {
        if (getAd() == null || this.mCloseableContainer == null) {
            return;
        }
        ContentInfo contentInfo = Utils.parseContentInfo(icon);
        View contentInfo2 = getContentInfo(this, getAd(), contentInfo);
        this.mContentInfoView = contentInfo2;
        if (contentInfo2 != null) {
            if (contentInfo != null) {
                ContentInfoIconXPosition contentInfoIconXPosition = getAd().getContentInfoIconXPosition();
                int i = GravityCompat.START;
                if (contentInfoIconXPosition == null ? contentInfo.getPositionX() == PositionX.RIGHT : getAd().getContentInfoIconXPosition() == ContentInfoIconXPosition.RIGHT) {
                    i = 8388613;
                }
                int i2 = 80;
                if (getAd().getContentInfoIconYPosition() == null ? contentInfo.getPositionY() != PositionY.BOTTOM : getAd().getContentInfoIconYPosition() != ContentInfoIconYPosition.BOTTOM) {
                    i2 = 48;
                }
                if (i2 == 48 && i == 8388613) {
                    this.mCloseableContainer.setClosePosition(CloseableContainer.ClosePosition.TOP_LEFT);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = i | i2;
                this.mCloseableContainer.addView(this.mContentInfoView, layoutParams);
            } else {
                this.mCloseableContainer.addView(contentInfo2);
                if (getAd().getContentInfoIconYPosition() == ContentInfoIconYPosition.TOP && getAd().getContentInfoIconXPosition() == ContentInfoIconXPosition.RIGHT) {
                    this.mCloseableContainer.setClosePosition(CloseableContainer.ClosePosition.TOP_LEFT);
                }
            }
            if (contentInfo == null || contentInfo.getViewTrackers() == null || contentInfo.getViewTrackers().isEmpty()) {
                return;
            }
            Iterator<String> it = contentInfo.getViewTrackers().iterator();
            while (it.hasNext()) {
                EventTracker.post(this, it.next(), null, true);
            }
        }
    }

    private View getContentInfo(Context context, Ad ad, ContentInfo contentInfo) {
        return contentInfo == null ? ad.getContentInfoContainer(context, this) : ad.getContentInfoContainer(context, contentInfo, this);
    }

    public void hideContentInfo() {
        CloseableContainer closeableContainer;
        View view = this.mContentInfoView;
        if (view == null || (closeableContainer = this.mCloseableContainer) == null) {
            return;
        }
        closeableContainer.removeView(view);
    }

    protected void closeButtonClicked() {
        if (getBroadcastSender() != null) {
            boolean z = this.mIsVast;
            if (z && !this.mIsVideoFinished) {
                this.mVideoAd.skip();
                return;
            }
            if (z) {
                this.mVideoAd.closeVideo();
            }
            getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.DISMISS);
            this.mIsFinishing = true;
            finish();
        }
    }

    protected void dismiss() {
        if (getBroadcastSender() != null) {
            getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.DISMISS);
        }
        this.mIsFinishing = true;
        finish();
    }

    protected String getZoneId() {
        return this.mZoneId;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        CloseableContainer closeableContainer = this.mCloseableContainer;
        if (closeableContainer != null) {
            closeableContainer.removeAllViews();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (!this.mIsBackEnabled.booleanValue()) {
                return false;
            }
            dismiss();
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected CloseableContainer getCloseableContainer() {
        return this.mCloseableContainer;
    }

    protected void showInterstitialCloseButton() {
        if (this.mCloseableContainer == null || isFinishing()) {
            return;
        }
        this.mCloseableContainer.setCloseVisible(true);
        this.mCloseableContainer.setOnCloseListener(this.mCloseListener);
        this.mIsBackEnabled = true;
    }

    protected void hideInterstitialCloseButton() {
        CloseableContainer closeableContainer = this.mCloseableContainer;
        if (closeableContainer != null) {
            closeableContainer.setCloseVisible(false);
            this.mCloseableContainer.setOnCloseListener(null);
            this.mIsBackEnabled = false;
        }
    }

    protected void setClosePosition(CloseableContainer.ClosePosition closePosition) {
        this.mCloseableContainer.setClosePosition(closePosition);
    }

    protected UrlHandler getUrlHandler() {
        return this.mUrlHandlerDelegate;
    }

    protected Ad getAd() {
        if (this.mAd == null) {
            synchronized (this) {
                if (HyBid.getAdCache() != null) {
                    this.mAd = HyBid.getAdCache().remove(this.mZoneId);
                }
            }
        }
        return this.mAd;
    }

    @Override // net.pubnative.lite.sdk.views.PNAPIContentInfoView.ContentInfoListener
    public void onIconClicked(List<String> list) {
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                EventTracker.post(this, list.get(i), null, false);
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
        reportingEvent.setAdFormat("fullscreen");
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

    @Override // net.pubnative.lite.sdk.views.PNAPIContentInfoView.ContentInfoListener
    public synchronized void onLinkClicked(String str) {
        if (!this.isLinkClickRunning) {
            this.isLinkClickRunning = true;
            if (!this.mIsFeedbackFormOpen && !this.mIsFeedbackFormLoading) {
                this.adFeedbackFormHelper = new AdFeedbackFormHelper();
                if (URLValidator.isValidURL(str)) {
                    this.adFeedbackFormHelper.showFeedbackForm(this, str, this.mAd, "rewarded", IntegrationType.STANDALONE, new AdFeedbackLoadListener() { // from class: net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity.1
                        @Override // net.pubnative.lite.sdk.contentinfo.listeners.AdFeedbackLoadListener
                        public void onLoad(String str2) {
                            HyBidInterstitialActivity.this.mIsFeedbackFormLoading = true;
                        }

                        @Override // net.pubnative.lite.sdk.contentinfo.listeners.AdFeedbackLoadListener
                        public void onLoadFinished() {
                            HyBidInterstitialActivity.this.isLinkClickRunning = false;
                            HyBidInterstitialActivity.this.mIsFeedbackFormLoading = false;
                            HyBidInterstitialActivity.this.mIsFeedbackFormOpen = true;
                        }

                        @Override // net.pubnative.lite.sdk.contentinfo.listeners.AdFeedbackLoadListener
                        public void onLoadFailed(Throwable th) {
                            HyBidInterstitialActivity.this.isLinkClickRunning = false;
                            HyBidInterstitialActivity.this.mIsFeedbackFormLoading = false;
                            if (HyBidInterstitialActivity.this.mIsFeedbackFormOpen) {
                                HyBidInterstitialActivity.this.mIsFeedbackFormOpen = false;
                            }
                            Logger.e(HyBidInterstitialActivity.TAG, th.getMessage());
                        }

                        @Override // net.pubnative.lite.sdk.contentinfo.listeners.AdFeedbackLoadListener
                        public void onFormClosed() {
                            HyBidInterstitialActivity.this.isLinkClickRunning = false;
                            HyBidInterstitialActivity.this.mIsFeedbackFormOpen = false;
                            HyBidInterstitialActivity.this.mIsFeedbackFormLoading = false;
                        }
                    });
                } else {
                    this.isLinkClickRunning = false;
                    this.mIsFeedbackFormOpen = false;
                    this.mIsFeedbackFormLoading = false;
                    Logger.e(TAG, "Content Info URL is invalid");
                }
            }
        }
    }

    protected HyBidInterstitialBroadcastSender getBroadcastSender() {
        return this.mBroadcastSender;
    }

    protected void setProgressBarVisible() {
        this.mProgressBar.setVisibility(0);
    }

    protected void setProgressBarInvisible() {
        this.mProgressBar.setVisibility(4);
    }

    protected void setIsVast(Boolean bool) {
        this.mIsVast = bool.booleanValue();
    }

    private boolean hasReducedCloseSize() {
        Ad ad = this.mAd;
        if (ad == null) {
            return false;
        }
        Boolean boolIsIconSizeReduced = ad.isIconSizeReduced();
        return this.mAd.getAdExperience().equalsIgnoreCase(AdExperience.PERFORMANCE) && boolIsIconSizeReduced != null && boolIsIconSizeReduced.booleanValue();
    }
}
