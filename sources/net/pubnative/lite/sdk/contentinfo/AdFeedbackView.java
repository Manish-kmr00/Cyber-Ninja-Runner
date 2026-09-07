package net.pubnative.lite.sdk.contentinfo;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.HyBidError;
import net.pubnative.lite.sdk.HyBidErrorCode;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.mraid.MRAIDInterstitial;
import net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener;
import net.pubnative.lite.sdk.mraid.MRAIDView;
import net.pubnative.lite.sdk.mraid.MRAIDViewListener;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.utils.URLValidator;
import net.pubnative.lite.sdk.utils.UrlHandler;

/* JADX INFO: loaded from: classes12.dex */
public class AdFeedbackView implements MRAIDViewListener, MRAIDNativeFeatureListener {
    private static final String TAG = "AdFeedbackView";
    private AdFeedbackData mAdFeedbackData;
    private boolean mIsReady = false;
    private AdFeedbackLoadListener mListener;
    private UrlHandler mUrlHandlerDelegate;
    private MRAIDInterstitial mViewContainer;

    public interface AdFeedbackLoadListener {
        void onFormClosed();

        void onLoad(String str);

        void onLoadFailed(Throwable th);

        void onLoadFinished();
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeatureCallTel(String str) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeatureCreateCalendarEvent(String str) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeaturePlayVideo(String str) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeatureSendSms(String str) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeatureStorePicture(String str) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidShowCloseButton() {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidViewExpand(MRAIDView mRAIDView) {
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public boolean mraidViewResize(MRAIDView mRAIDView, int i, int i2, int i3, int i4) {
        return false;
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void onExpandedAdClosed() {
    }

    public void prepare(Context context, String str, AdFeedbackLoadListener adFeedbackLoadListener) {
        prepare(context, str, null, null, null, adFeedbackLoadListener);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0049  */
    public void prepare(Context context, String str, Ad ad, String str2, IntegrationType integrationType, AdFeedbackLoadListener adFeedbackLoadListener) {
        String string;
        String strReplace;
        if (TextUtils.isEmpty(str)) {
            strReplace = str;
        } else {
            try {
                Uri uri = Uri.parse(str);
                if (uri == null || !TextUtils.isEmpty(uri.getQueryParameter("apptoken"))) {
                    strReplace = str;
                } else {
                    string = uri.buildUpon().appendQueryParameter("apptoken", "token_macro").build().toString();
                    try {
                        strReplace = string.replace("token_macro", FeedbackMacros.MACRO_APP_TOKEN);
                    } catch (RuntimeException e) {
                        e = e;
                        Logger.e(TAG, e.getMessage());
                        HyBid.reportException((Exception) e);
                        strReplace = string;
                    }
                }
            } catch (RuntimeException e2) {
                e = e2;
                string = str;
            }
        }
        this.mUrlHandlerDelegate = new UrlHandler(context);
        this.mAdFeedbackData = new AdFeedbackDataCollector(integrationType).collectData(ad, str2, integrationType);
        String strProcessUrl = new FeedbackMacros().processUrl(strReplace, this.mAdFeedbackData);
        if (!TextUtils.isEmpty(strProcessUrl)) {
            strReplace = strProcessUrl;
        }
        MRAIDInterstitial mRAIDInterstitial = new MRAIDInterstitial(context, strReplace, null, true, true, new String[]{"calendar", "inlineVideo", "sms", "storePicture", "tel", "location"}, this, this, null);
        this.mViewContainer = mRAIDInterstitial;
        mRAIDInterstitial.markCreativeAdComingFromFeedbackForm();
        this.mListener = adFeedbackLoadListener;
        adFeedbackLoadListener.onLoad(strReplace);
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDNativeFeatureListener
    public void mraidNativeFeatureOpenBrowser(String str) {
        this.mUrlHandlerDelegate.handleUrl(str, null);
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidViewLoaded(MRAIDView mRAIDView) {
        new FeedbackJSInterface().submitData(this.mAdFeedbackData, mRAIDView);
        this.mIsReady = true;
        AdFeedbackLoadListener adFeedbackLoadListener = this.mListener;
        if (adFeedbackLoadListener != null) {
            adFeedbackLoadListener.onLoadFinished();
            Logger.d(TAG, "Feedback form loaded");
        }
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidViewError(MRAIDView mRAIDView) {
        this.mIsReady = false;
        AdFeedbackLoadListener adFeedbackLoadListener = this.mListener;
        if (adFeedbackLoadListener != null) {
            adFeedbackLoadListener.onLoadFailed(new HyBidError(HyBidErrorCode.ERROR_LOADING_FEEDBACK));
        }
    }

    @Override // net.pubnative.lite.sdk.mraid.MRAIDViewListener
    public void mraidViewClose(MRAIDView mRAIDView) {
        AdFeedbackLoadListener adFeedbackLoadListener = this.mListener;
        if (adFeedbackLoadListener != null) {
            adFeedbackLoadListener.onFormClosed();
        }
    }

    public void showFeedbackForm(Context context, String str) {
        if (context instanceof Activity) {
            showFeedbackForm((Activity) context, str);
            return;
        }
        AdFeedbackLoadListener adFeedbackLoadListener = this.mListener;
        if (adFeedbackLoadListener != null) {
            adFeedbackLoadListener.onLoadFailed(new HyBidError(HyBidErrorCode.ERROR_LOADING_FEEDBACK, "The feedback form requires an Activity context"));
        }
    }

    public synchronized void showFeedbackForm(Activity activity, String str) {
        MRAIDInterstitial mRAIDInterstitial = this.mViewContainer;
        if (mRAIDInterstitial != null && mRAIDInterstitial.isLoaded() && this.mIsReady) {
            if (URLValidator.isValidURL(str)) {
                this.mViewContainer.show(activity, new MRAIDView.OnExpandCreativeFailListener() { // from class: net.pubnative.lite.sdk.contentinfo.AdFeedbackView$$ExternalSyntheticLambda0
                    @Override // net.pubnative.lite.sdk.mraid.MRAIDView.OnExpandCreativeFailListener
                    public final void onExpandFailed() {
                        this.f$0.m9608xd43bab07();
                    }
                }, str);
            } else {
                AdFeedbackLoadListener adFeedbackLoadListener = this.mListener;
                if (adFeedbackLoadListener != null) {
                    adFeedbackLoadListener.onLoadFailed(new HyBidError(HyBidErrorCode.ERROR_LOADING_FEEDBACK));
                }
            }
        } else {
            AdFeedbackLoadListener adFeedbackLoadListener2 = this.mListener;
            if (adFeedbackLoadListener2 != null) {
                adFeedbackLoadListener2.onLoadFailed(new HyBidError(HyBidErrorCode.ERROR_LOADING_FEEDBACK));
            }
        }
    }

    /* JADX INFO: renamed from: lambda$showFeedbackForm$0$net-pubnative-lite-sdk-contentinfo-AdFeedbackView, reason: not valid java name */
    /* synthetic */ void m9608xd43bab07() {
        this.mViewContainer.showDefaultContentInfoURL(Ad.CONTENT_INFO_LINK_URL);
        this.mListener.onLoadFailed(new HyBidError(HyBidErrorCode.ERROR_LOADING_FEEDBACK));
    }
}
