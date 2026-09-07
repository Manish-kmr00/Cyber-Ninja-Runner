package net.pubnative.lite.sdk.contentinfo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.HyBidError;
import net.pubnative.lite.sdk.HyBidErrorCode;
import net.pubnative.lite.sdk.contentinfo.listeners.AdFeedbackLoadListener;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.IntegrationType;

/* JADX INFO: loaded from: classes8.dex */
public class AdFeedbackFormHelper extends ResultReceiver {
    private static final String TAG = "AdFeedbackFormHelper";
    private AdFeedbackLoadListener mListener;

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.C);
        p0.startActivity(p1);
    }

    public AdFeedbackFormHelper() {
        super(null);
    }

    public void showFeedbackForm(Context context, String str, Ad ad, String str2, IntegrationType integrationType) {
        showFeedbackForm(context, str, ad, str2, integrationType, null);
    }

    public synchronized void showFeedbackForm(Context context, String str, Ad ad, String str2, IntegrationType integrationType, AdFeedbackLoadListener adFeedbackLoadListener) {
        this.mListener = adFeedbackLoadListener;
        String url = parseUrl(str);
        if (url == null) {
            AdFeedbackLoadListener adFeedbackLoadListener2 = this.mListener;
            if (adFeedbackLoadListener2 != null) {
                adFeedbackLoadListener2.onLoadFailed(new HyBidError(HyBidErrorCode.ERROR_LOADING_FEEDBACK));
            }
            return;
        }
        AdFeedbackData adFeedbackDataCollectData = new AdFeedbackDataCollector(integrationType).collectData(ad, str2, integrationType);
        String strProcessUrl = new FeedbackMacros().processUrl(url, adFeedbackDataCollectData);
        try {
            Intent intent = new Intent(context, (Class<?>) AdFeedbackActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(AdFeedbackActivity.EXTRA_FEEDBACK_FORM_URL, strProcessUrl);
            intent.putExtra(AdFeedbackActivity.EXTRA_FEEDBACK_FORM_CALLBACK, this);
            intent.putExtra(AdFeedbackActivity.EXTRA_FEEDBACK_FORM_DATA, adFeedbackDataCollectData);
            intent.addFlags(65536);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
        } catch (Exception unused) {
            AdFeedbackLoadListener adFeedbackLoadListener3 = this.mListener;
            if (adFeedbackLoadListener3 != null) {
                adFeedbackLoadListener3.onLoadFailed(new HyBidError(HyBidErrorCode.ERROR_LOADING_FEEDBACK, "The feedback form requires an Activity context"));
            }
        }
    }

    private String parseUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri == null || !TextUtils.isEmpty(uri.getQueryParameter("apptoken"))) {
                return null;
            }
            return uri.buildUpon().appendQueryParameter("apptoken", "token_macro").build().toString().replace("token_macro", FeedbackMacros.MACRO_APP_TOKEN);
        } catch (RuntimeException e) {
            net.pubnative.lite.sdk.utils.Logger.e(TAG, e.getMessage());
            HyBid.reportException((Exception) e);
            return null;
        }
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i, Bundle bundle) {
        super.onReceiveResult(i, bundle);
        handleResult(i, bundle);
    }

    private void handleResult(int i, Bundle bundle) {
        AdFeedbackLoadListener adFeedbackLoadListener;
        if (i == FeedbackFormAction.OPEN.code) {
            AdFeedbackLoadListener adFeedbackLoadListener2 = this.mListener;
            if (adFeedbackLoadListener2 != null) {
                adFeedbackLoadListener2.onLoad("");
                return;
            }
            return;
        }
        if (i == FeedbackFormAction.CLOSE.code) {
            AdFeedbackLoadListener adFeedbackLoadListener3 = this.mListener;
            if (adFeedbackLoadListener3 != null) {
                adFeedbackLoadListener3.onFormClosed();
                return;
            }
            return;
        }
        if (i != FeedbackFormAction.ERROR.code || (adFeedbackLoadListener = this.mListener) == null) {
            return;
        }
        adFeedbackLoadListener.onLoadFailed(new HyBidError(HyBidErrorCode.ERROR_LOADING_FEEDBACK));
    }

    enum FeedbackFormAction {
        OPEN(1),
        ERROR(-1),
        CLOSE(0);

        final int code;

        FeedbackFormAction(int i) {
            this.code = i;
        }
    }
}
