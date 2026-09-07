package net.pubnative.lite.sdk.models;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.analytics.Reporting;
import net.pubnative.lite.sdk.analytics.ReportingController;
import net.pubnative.lite.sdk.analytics.ReportingEvent;
import net.pubnative.lite.sdk.contentinfo.AdFeedbackFormHelper;
import net.pubnative.lite.sdk.contentinfo.listeners.AdFeedbackLoadListener;
import net.pubnative.lite.sdk.prefs.SessionImpressionPrefs;
import net.pubnative.lite.sdk.utils.URLValidator;
import net.pubnative.lite.sdk.views.PNAPIContentInfoView;
import net.pubnative.lite.sdk.views.PNBeaconWebView;
import net.pubnative.lite.sdk.visibility.ImpressionManager;
import net.pubnative.lite.sdk.visibility.ImpressionTracker;
import net.pubnative.lite.sdk.visibility.TrackingManager;
import net.pubnative.lite.sdk.vpaid.helpers.EventTracker;

/* JADX INFO: loaded from: classes10.dex */
public class NativeAd implements ImpressionTracker.Listener, PNAPIContentInfoView.ContentInfoListener {
    private static final String TAG = "NativeAd";
    private Bitmap bannerBitmap;
    private Bitmap iconBitmap;
    public boolean isLinkClickRunning;
    protected Ad mAd;
    private View mAdView;
    private View mClickableView;
    private boolean mIsImpressionConfirmed;
    protected Listener mListener;
    private ReportingController mReportingController;
    private Map<String, String> mTrackingExtras;
    private List<String> mUsedAssets;
    String processedURL;

    public interface Listener {
        void onAdClick(NativeAd nativeAd, View view);

        void onAdImpression(NativeAd nativeAd, View view);
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.C);
        p0.startActivity(p1);
    }

    public NativeAd() {
        this.processedURL = "";
        this.isLinkClickRunning = false;
        this.mAd = null;
        this.mReportingController = HyBid.getReportingController();
    }

    public NativeAd(Ad ad) {
        this.processedURL = "";
        this.isLinkClickRunning = false;
        this.mAd = ad;
        this.mReportingController = HyBid.getReportingController();
    }

    public String getTitle() {
        AdData asset = this.mAd.getAsset("title");
        if (asset != null) {
            return asset.getText();
        }
        return null;
    }

    public String getDescription() {
        AdData asset = this.mAd.getAsset("description");
        if (asset != null) {
            return asset.getText();
        }
        return null;
    }

    public String getCallToActionText() {
        AdData asset = this.mAd.getAsset("cta");
        if (asset != null) {
            return asset.getText();
        }
        return null;
    }

    public String getIconUrl() {
        AdData asset = this.mAd.getAsset("icon");
        if (asset != null) {
            return asset.getURL();
        }
        return null;
    }

    public Bitmap getIconBitmap() {
        return this.iconBitmap;
    }

    public void setIconBitmap(Bitmap bitmap) {
        this.iconBitmap = bitmap;
    }

    public String getBannerUrl() {
        AdData asset = this.mAd.getAsset("banner");
        if (asset != null) {
            return asset.getURL();
        }
        return null;
    }

    public Bitmap getBannerBitmap() {
        return this.bannerBitmap;
    }

    public void setBannerBitmap(Bitmap bitmap) {
        this.bannerBitmap = bitmap;
    }

    private String getClickUrl() {
        return injectExtras(this.mAd.link);
    }

    public int getRating() {
        Double number;
        AdData asset = this.mAd.getAsset("rating");
        if (asset == null || (number = asset.getNumber()) == null) {
            return 0;
        }
        return number.intValue();
    }

    public String getContentInfoIconUrl() {
        return this.mAd.getContentInfoIconUrl();
    }

    public String getContentInfoClickUrl() {
        return this.mAd.getContentInfoClickUrl();
    }

    public String getContentInfoText() {
        return this.mAd.getContentInfoText();
    }

    public View getContentInfo(Context context) {
        return this.mAd.getContentInfo(context, this);
    }

    public String getImpressionId() {
        Ad ad = this.mAd;
        if (ad != null) {
            return ad.getImpressionId();
        }
        return null;
    }

    public String getCreativeId() {
        Ad ad = this.mAd;
        if (ad != null) {
            return ad.getCreativeId();
        }
        return null;
    }

    public Integer getBidPoints() {
        Ad ad = this.mAd;
        return Integer.valueOf(ad != null ? ad.getECPM().intValue() : 0);
    }

    private String injectExtras(String str) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || (map = this.mTrackingExtras) == null || map.size() <= 0) {
            return str;
        }
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry<String, String> entry : this.mTrackingExtras.entrySet()) {
            builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getKey());
        }
        return builderBuildUpon.build().toString();
    }

    public void startTracking(View view, Listener listener) {
        startTracking(view, view, listener);
    }

    public void startTracking(View view, View view2, Listener listener) {
        startTracking(view, view2, null, listener);
    }

    public void startTracking(View view, View view2, Map<String, String> map, Listener listener) {
        if (listener == null) {
            Log.w(TAG, "startTracking - listener is null, start tracking without callbacks");
        }
        this.mListener = listener;
        this.mTrackingExtras = map;
        stopTracking();
        startTrackingImpression(view);
        startTrackingClicks(view2);
    }

    private void startTrackingImpression(View view) {
        if (view == null) {
            Log.w(TAG, "ad view is null, cannot start tracking");
        } else if (this.mIsImpressionConfirmed) {
            Log.i(TAG, "impression is already confirmed, dropping impression tracking");
        } else {
            this.mAdView = view;
            ImpressionManager.startTrackingView(view, this.mAd.getImpressionMinVisibleTime(), this.mAd.getImpressionVisiblePercent(), this);
        }
    }

    private void startTrackingClicks(View view) {
        if (TextUtils.isEmpty(getClickUrl())) {
            Log.w(TAG, "click url is empty, clicks won't be tracked");
        } else if (view == null) {
            Log.w(TAG, "click view is null, clicks won't be tracked");
        } else {
            this.mClickableView = view;
            view.setOnClickListener(new View.OnClickListener() { // from class: net.pubnative.lite.sdk.models.NativeAd$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.onNativeClick(view2);
                }
            });
        }
    }

    public void stopTracking() {
        stopTrackingImpression();
        stopTrackingClicks();
    }

    private void stopTrackingImpression() {
        ImpressionManager.stopTrackingAll(this);
    }

    private void stopTrackingClicks() {
        View view = this.mClickableView;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    protected void openURL(String str, boolean z) {
        View view;
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "Error: ending URL cannot be opened - " + str);
            return;
        }
        if (!z && this.mClickableView == null) {
            Log.w(TAG, "Error: clickable view not set");
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            if (z && (view = this.mAdView) != null) {
                safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(view.getContext(), intent);
            } else {
                safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.mClickableView.getContext(), intent);
            }
        } catch (Exception e) {
            Log.w(TAG, "openURL: Error - " + e.getMessage());
        }
    }

    private void confirmImpressionBeacons(Context context) {
        List<String> list = this.mUsedAssets;
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                TrackingManager.track(context, it.next());
            }
        }
        confirmBeacons("impression", context);
    }

    private void confirmClickBeacons(Context context) {
        confirmBeacons("click", context);
    }

    private void confirmBeacons(String str, Context context) {
        Ad ad = this.mAd;
        if (ad == null) {
            Log.w(TAG, "confirmBeacons - Error: ad data not present");
            return;
        }
        List<AdData> beacons = ad.getBeacons(str);
        if (beacons == null) {
            return;
        }
        for (AdData adData : beacons) {
            String strInjectExtras = injectExtras(adData.getURL());
            String stringField = adData.getStringField(POBConstants.KEY_JS);
            if (!TextUtils.isEmpty(strInjectExtras)) {
                TrackingManager.track(context, strInjectExtras);
            } else if (!TextUtils.isEmpty(stringField)) {
                try {
                    new PNBeaconWebView(context).loadBeacon(stringField);
                } catch (Exception e) {
                    Log.e(TAG, "confirmImpressionBeacons - JS Error: " + e);
                }
            }
        }
    }

    public synchronized void invokeOnImpression(View view) {
        this.mIsImpressionConfirmed = true;
        if (view.getContext() != null) {
            new SessionImpressionPrefs(view.getContext()).insert(this.mAd.getZoneId());
            Listener listener = this.mListener;
            if (listener != null) {
                listener.onAdImpression(this, view);
            }
        }
    }

    protected void invokeOnClick(View view) {
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onAdClick(this, view);
        }
    }

    @Override // net.pubnative.lite.sdk.visibility.ImpressionTracker.Listener
    public void onImpression(View view) {
        confirmImpressionBeacons(view.getContext());
        invokeOnImpression(view);
    }

    public void onNativeClick() {
        View view = this.mAdView;
        if (view != null) {
            confirmClickBeacons(view.getContext());
            openURL(getClickUrl(), true);
        }
    }

    public void onNativeClick(View view) {
        invokeOnClick(view);
        confirmClickBeacons(view.getContext());
        openURL(getClickUrl(), false);
    }

    @Override // net.pubnative.lite.sdk.views.PNAPIContentInfoView.ContentInfoListener
    public void onIconClicked(List<String> list) {
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                EventTracker.post(this.mAdView.getContext(), list.get(i), null, false);
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
        reportingEvent.setAdFormat("native");
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
        View view = this.mAdView;
        if (view != null && view.getContext() != null && !this.isLinkClickRunning) {
            this.isLinkClickRunning = true;
            AdFeedbackFormHelper adFeedbackFormHelper = new AdFeedbackFormHelper();
            if (URLValidator.isValidURL(str)) {
                adFeedbackFormHelper.showFeedbackForm(this.mAdView.getContext(), str, this.mAd, "native", IntegrationType.STANDALONE, new AdFeedbackLoadListener() { // from class: net.pubnative.lite.sdk.models.NativeAd.1
                    @Override // net.pubnative.lite.sdk.contentinfo.listeners.AdFeedbackLoadListener
                    public void onLoad(String str2) {
                        NativeAd.this.processedURL = str2;
                    }

                    @Override // net.pubnative.lite.sdk.contentinfo.listeners.AdFeedbackLoadListener
                    public void onLoadFinished() {
                        NativeAd.this.isLinkClickRunning = false;
                    }

                    @Override // net.pubnative.lite.sdk.contentinfo.listeners.AdFeedbackLoadListener
                    public void onLoadFailed(Throwable th) {
                        NativeAd.this.isLinkClickRunning = false;
                        net.pubnative.lite.sdk.utils.Logger.e(NativeAd.TAG, th.getMessage());
                    }

                    @Override // net.pubnative.lite.sdk.contentinfo.listeners.AdFeedbackLoadListener
                    public void onFormClosed() {
                        NativeAd.this.isLinkClickRunning = false;
                    }
                });
            } else {
                net.pubnative.lite.sdk.utils.Logger.e(TAG, "Content info url is invalid");
                this.isLinkClickRunning = false;
            }
        }
    }
}
