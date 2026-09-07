package net.pubnative.lite.sdk.rewarded.activity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import net.pubnative.lite.sdk.models.APIAsset;
import net.pubnative.lite.sdk.mraid.MRAIDBanner;
import net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener;
import net.pubnative.lite.sdk.mraid.MRAIDView;
import net.pubnative.lite.sdk.mraid.MRAIDViewCloseLayoutListener;
import net.pubnative.lite.sdk.mraid.MRAIDViewListener;
import net.pubnative.lite.sdk.rewarded.HyBidRewardedBroadcastReceiver;
import net.pubnative.lite.sdk.utils.SkipOffsetManager;

/* JADX INFO: loaded from: classes9.dex */
public class MraidRewardedActivity extends HyBidRewardedActivity implements MRAIDViewListener, MRAIDNativeFeatureListener, MRAIDViewCloseLayoutListener {
    private final String[] mSupportedNativeFeatures = {"calendar", "inlineVideo", "sms", "storePicture", "tel", "location"};
    private MRAIDBanner mView;

    @Override // net.pubnative.lite.sdk.rewarded.activity.HyBidRewardedActivity, android.app.Activity, android.view.Window.Callback
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

    @Override // net.pubnative.lite.sdk.rewarded.activity.HyBidRewardedActivity
    protected boolean shouldShowContentInfo() {
        return false;
    }

    @Override // net.pubnative.lite.sdk.rewarded.activity.HyBidRewardedActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (getResources().getConfiguration().orientation == 2) {
            setRequestedOrientation(0);
        }
        if (getResources().getConfiguration().orientation == 1) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        hideRewardedCloseButton();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0091  */
    @Override // net.pubnative.lite.sdk.rewarded.activity.HyBidRewardedActivity
    public View getAdView() {
        MRAIDBanner mRAIDBanner;
        Integer nativeCloseButtonDelay;
        MRAIDBanner mRAIDBanner2 = null;
        if (getAd() != null) {
            Integer hTMLSkipOffset = SkipOffsetManager.getHTMLSkipOffset(getAd().getMraidRewardedSkipOffset(), false);
            boolean z = true;
            if (hTMLSkipOffset != null && hTMLSkipOffset.intValue() > 0) {
                this.mIsSkippable = false;
            } else {
                this.mIsSkippable = true;
                showRewardedCloseButton();
                z = false;
            }
            if (getAd().getAssetUrl(APIAsset.HTML_BANNER) != null) {
                mRAIDBanner = new MRAIDBanner(this, getAd().getAssetUrl(APIAsset.HTML_BANNER), "", Boolean.valueOf(z), false, this.mSupportedNativeFeatures, this, this, getAd().getContentInfoContainer(this, this));
            } else if (getAd().getAssetHtml(APIAsset.HTML_BANNER) != null) {
                mRAIDBanner = new MRAIDBanner(this, "", getAd().getAssetHtml(APIAsset.HTML_BANNER), Boolean.valueOf(z), false, this.mSupportedNativeFeatures, this, this, getAd().getContentInfoContainer(this, this));
            } else {
                if (mRAIDBanner2 != null) {
                    mRAIDBanner2.setCloseLayoutListener(this);
                }
                if (hTMLSkipOffset != null && hTMLSkipOffset.intValue() >= 0 && mRAIDBanner2 != null) {
                    mRAIDBanner2.setSkipOffset(hTMLSkipOffset);
                }
                nativeCloseButtonDelay = SkipOffsetManager.getNativeCloseButtonDelay(getAd().getNativeCloseButtonDelay());
                if (nativeCloseButtonDelay != null && nativeCloseButtonDelay.intValue() > 0 && mRAIDBanner2 != null) {
                    mRAIDBanner2.setNativeCloseButtonDelay(nativeCloseButtonDelay);
                }
                if (getAd().isLandingPage() != null && mRAIDBanner2 != null) {
                    mRAIDBanner2.setIsLandingPageEnabled(getAd().isLandingPage().booleanValue());
                }
            }
            mRAIDBanner2 = mRAIDBanner;
            if (mRAIDBanner2 != null) {
                mRAIDBanner2.setCloseLayoutListener(this);
            }
            if (hTMLSkipOffset != null) {
                mRAIDBanner2.setSkipOffset(hTMLSkipOffset);
            }
            nativeCloseButtonDelay = SkipOffsetManager.getNativeCloseButtonDelay(getAd().getNativeCloseButtonDelay());
            if (nativeCloseButtonDelay != null) {
                mRAIDBanner2.setNativeCloseButtonDelay(nativeCloseButtonDelay);
            }
            if (getAd().isLandingPage() != null) {
                mRAIDBanner2.setIsLandingPageEnabled(getAd().isLandingPage().booleanValue());
            }
        }
        this.mView = mRAIDBanner2;
        return mRAIDBanner2;
    }

    @Override // net.pubnative.lite.sdk.rewarded.activity.HyBidRewardedActivity, android.app.Activity
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
            getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.OPEN);
        }
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidViewError(MRAIDView mRAIDView) {
        if (getBroadcastSender() != null) {
            getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.ERROR);
        }
        dismiss();
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidShowCloseButton() {
        this.mIsSkippable = true;
        showRewardedCloseButton();
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeatureCallTel(String str) {
        if (getBroadcastSender() != null) {
            getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.CLICK);
        }
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeatureOpenBrowser(String str) {
        if (getBroadcastSender() != null) {
            getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.CLICK);
        }
        getUrlHandler().handleUrl(str, getAd() != null ? getAd().getNavigationMode() : null);
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeatureSendSms(String str) {
        if (getBroadcastSender() != null) {
            getBroadcastSender().sendBroadcast(HyBidRewardedBroadcastReceiver.Action.CLICK);
        }
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewCloseLayoutListener
    public void onShowCloseLayout() {
        this.mIsSkippable = true;
        showRewardedCloseButton();
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewCloseLayoutListener
    public void onRemoveCloseLayout() {
        hideRewardedCloseButton();
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewCloseLayoutListener
    public void onClose() {
        dismiss();
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

    @Override // net.pubnative.lite.sdk.rewarded.activity.HyBidRewardedActivity
    protected void pauseAd() {
        MRAIDBanner mRAIDBanner = this.mView;
        if (mRAIDBanner != null) {
            mRAIDBanner.pause();
        }
    }

    @Override // net.pubnative.lite.sdk.rewarded.activity.HyBidRewardedActivity
    protected void resumeAd() {
        MRAIDBanner mRAIDBanner;
        if (this.mIsFeedbackFormOpen || (mRAIDBanner = this.mView) == null) {
            return;
        }
        mRAIDBanner.resume();
    }
}
