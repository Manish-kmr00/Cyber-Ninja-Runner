package net.pubnative.lite.sdk.interstitial.activity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import net.pubnative.lite.sdk.interstitial.HyBidInterstitialBroadcastReceiver;
import net.pubnative.lite.sdk.models.APIAsset;
import net.pubnative.lite.sdk.mraid.MRAIDBanner;
import net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener;
import net.pubnative.lite.sdk.mraid.MRAIDView;
import net.pubnative.lite.sdk.mraid.MRAIDViewCloseLayoutListener;
import net.pubnative.lite.sdk.mraid.MRAIDViewListener;
import net.pubnative.lite.sdk.utils.SkipOffsetManager;

/* JADX INFO: loaded from: classes11.dex */
public class MraidInterstitialActivity extends HyBidInterstitialActivity implements MRAIDViewListener, MRAIDNativeFeatureListener, MRAIDViewCloseLayoutListener {
    private final String[] mSupportedNativeFeatures = {"calendar", "inlineVideo", "sms", "storePicture", "tel", "location"};
    private MRAIDBanner mView;

    @Override // net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.C, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeatureCreateCalendarEvent(String str) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeaturePlayVideo(String str) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeatureStorePicture(String str) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidViewClose(MRAIDView mRAIDView) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidViewExpand(MRAIDView mRAIDView) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public boolean mraidViewResize(MRAIDView mRAIDView, int i, int i2, int i3, int i4) {
        return true;
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void onExpandedAdClosed() {
    }

    @Override // net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity
    protected boolean shouldShowContentInfo() {
        return false;
    }

    @Override // net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (getResources().getConfiguration().orientation == 2) {
            setRequestedOrientation(0);
        }
        if (getResources().getConfiguration().orientation == 1) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        hideInterstitialCloseButton();
    }

    @Override // net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity
    public View getAdView() {
        MRAIDBanner mRAIDBanner = null;
        if (getAd() != null) {
            boolean z = false;
            if (getAd().getAssetUrl(APIAsset.HTML_BANNER) != null) {
                mRAIDBanner = new MRAIDBanner(this, getAd().getAssetUrl(APIAsset.HTML_BANNER), "", true, false, this.mSupportedNativeFeatures, this, this, getAd().getContentInfoContainer(this, this));
            } else if (getAd().getAssetHtml(APIAsset.HTML_BANNER) != null) {
                mRAIDBanner = new MRAIDBanner(this, "", getAd().getAssetHtml(APIAsset.HTML_BANNER), true, false, this.mSupportedNativeFeatures, this, this, getAd().getContentInfoContainer(this, this));
            }
            if (mRAIDBanner != null) {
                Integer hTMLSkipOffset = SkipOffsetManager.getHTMLSkipOffset(getAd().getHtmlSkipOffset(), true);
                Integer nativeCloseButtonDelay = SkipOffsetManager.getNativeCloseButtonDelay(getAd().getNativeCloseButtonDelay());
                mRAIDBanner.setCloseLayoutListener(this);
                if (hTMLSkipOffset != null && hTMLSkipOffset.intValue() == 0) {
                    z = true;
                }
                this.mIsSkippable = Boolean.valueOf(z);
                mRAIDBanner.setSkipOffset(hTMLSkipOffset);
                mRAIDBanner.setNativeCloseButtonDelay(nativeCloseButtonDelay);
                if (getAd().isLandingPage() != null) {
                    mRAIDBanner.setIsLandingPageEnabled(getAd().isLandingPage().booleanValue());
                }
            }
        }
        this.mView = mRAIDBanner;
        return mRAIDBanner;
    }

    @Override // net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity, android.app.Activity
    protected void onDestroy() {
        MRAIDBanner mRAIDBanner = this.mView;
        if (mRAIDBanner != null) {
            mRAIDBanner.stopAdSession();
            this.mView.destroy();
        }
        super.onDestroy();
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidViewLoaded(MRAIDView mRAIDView) {
        if (getBroadcastSender() != null) {
            getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.SHOW);
        }
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidViewError(MRAIDView mRAIDView) {
        if (getBroadcastSender() != null) {
            getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.ERROR);
        }
        dismiss();
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidShowCloseButton() {
        this.mIsSkippable = true;
        showInterstitialCloseButton();
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeatureCallTel(String str) {
        if (getBroadcastSender() != null) {
            getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.CLICK);
        }
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeatureOpenBrowser(String str) {
        if (getBroadcastSender() != null) {
            getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.CLICK);
        }
        getUrlHandler().handleUrl(str, getAd() != null ? getAd().getNavigationMode() : null);
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeatureSendSms(String str) {
        if (getBroadcastSender() != null) {
            getBroadcastSender().sendBroadcast(HyBidInterstitialBroadcastReceiver.Action.CLICK);
        }
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewCloseLayoutListener
    public void onShowCloseLayout() {
        this.mIsSkippable = true;
        showInterstitialCloseButton();
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewCloseLayoutListener
    public void onRemoveCloseLayout() {
        hideInterstitialCloseButton();
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewCloseLayoutListener
    public void onClose() {
        dismiss();
    }

    @Override // net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity
    protected void dismiss() {
        super.dismiss();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        pauseAd();
    }

    @Override // android.app.Activity
    protected void onResume() {
        resumeAd();
        super.onResume();
    }

    @Override // net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity
    protected void pauseAd() {
        MRAIDBanner mRAIDBanner = this.mView;
        if (mRAIDBanner != null) {
            mRAIDBanner.pause();
        }
    }

    @Override // net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity
    protected void resumeAd() {
        MRAIDBanner mRAIDBanner;
        if (this.mIsFeedbackFormOpen || (mRAIDBanner = this.mView) == null) {
            return;
        }
        mRAIDBanner.resume();
    }
}
