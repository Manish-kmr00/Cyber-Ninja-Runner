package com.applovin.mediation.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.adapters.inmobi.BuildConfig;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.InMobiNative;
import com.inmobi.ads.listeners.BannerAdEventListener;
import com.inmobi.ads.listeners.InterstitialAdEventListener;
import com.inmobi.ads.listeners.NativeAdEventListener;
import com.inmobi.compliance.InMobiPrivacyCompliance;
import com.inmobi.sdk.InMobiSdk;
import com.inmobi.sdk.SdkInitializationListener;
import com.safedk.android.internal.special.SpecialsBridge;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class InMobiMediationAdapter extends MediationAdapterBase implements MaxAdViewAdapter, MaxInterstitialAdapter, MaxRewardedAdapter, MaxSignalProvider {
    private static final int DEFAULT_IMAGE_TASK_TIMEOUT_SECONDS = 5;
    private static final float DEFAULT_MEDIA_CONTENT_ASPECT_RATIO = 1.9050859f;
    private static final String KEY_PARTNER_GDPR_APPLIES = "partner_gdpr_applies";
    private static final String KEY_PARTNER_GDPR_CONSENT = "partner_gdpr_consent_available";
    private static final AtomicBoolean initialized = new AtomicBoolean();
    private static MaxAdapter.InitializationStatus status;
    private InMobiBanner adView;
    private InMobiInterstitial interstitialAd;
    private InMobiNative nativeAd;
    private InMobiInterstitial rewardedAd;

    public InMobiMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        return InMobiSdk.getVersion();
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.applovin.mediation.adapter.MaxSignalProvider
    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        if (!InMobiSdk.isSDKInitialized()) {
            maxSignalCollectionListener.onSignalCollectionFailed("InMobi SDK initialization failed.");
        } else {
            updatePrivacySettings(maxAdapterSignalCollectionParameters);
            maxSignalCollectionListener.onSignalCollected(InMobiSdk.getToken(getExtras(), null));
        }
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxAdapter
    public Boolean shouldInitializeOnUiThread() {
        return true;
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() {
        InMobiBanner inMobiBanner = this.adView;
        if (inMobiBanner != null) {
            inMobiBanner.destroy();
            this.adView = null;
        }
        InMobiNative inMobiNative = this.nativeAd;
        if (inMobiNative != null) {
            inMobiNative.destroy();
            this.nativeAd = null;
        }
        this.interstitialAd = null;
        this.rewardedAd = null;
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, final MaxAdapter.OnCompletionListener onCompletionListener) {
        if (initialized.compareAndSet(false, true)) {
            final String string = maxAdapterInitializationParameters.getServerParameters().getString("account_id");
            log("Initializing InMobi SDK with account id: " + string + APSSharedUtil.TRUNCATE_SEPARATOR);
            final Context context = getContext(activity);
            status = MaxAdapter.InitializationStatus.INITIALIZING;
            final JSONObject consentJSONObject = getConsentJSONObject(maxAdapterInitializationParameters);
            if (string == null) {
                log("InMobi SDK initialization failed with null account id");
                MaxAdapter.InitializationStatus initializationStatus = MaxAdapter.InitializationStatus.INITIALIZED_FAILURE;
                status = initializationStatus;
                onCompletionListener.onCompletion(initializationStatus, "Account id is null");
                return;
            }
            initializeSdkOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.InMobiMediationAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    InMobiSdk.init(context, string, consentJSONObject, new SdkInitializationListener() { // from class: com.applovin.mediation.adapters.InMobiMediationAdapter.1.1
                        @Override // com.inmobi.sdk.SdkInitializationListener
                        public void onInitializationComplete(Error error) {
                            if (error != null) {
                                InMobiMediationAdapter.this.log("InMobi SDK initialization failed with error: " + error.getMessage());
                                MaxAdapter.InitializationStatus unused = InMobiMediationAdapter.status = MaxAdapter.InitializationStatus.INITIALIZED_FAILURE;
                                onCompletionListener.onCompletion(InMobiMediationAdapter.status, error.getMessage());
                            } else {
                                InMobiMediationAdapter.this.log("InMobi SDK successfully initialized.");
                                MaxAdapter.InitializationStatus unused2 = InMobiMediationAdapter.status = MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS;
                                onCompletionListener.onCompletion(InMobiMediationAdapter.status, null);
                            }
                        }
                    });
                }
            });
            InMobiSdk.setLogLevel(maxAdapterInitializationParameters.isTesting() ? InMobiSdk.LogLevel.DEBUG : InMobiSdk.LogLevel.ERROR);
            return;
        }
        onCompletionListener.onCompletion(status, null);
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        int i;
        int i2;
        long j = Long.parseLong(maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        boolean z = maxAdapterResponseParameters.getServerParameters().getBoolean("is_native");
        log("Loading" + (z ? " native " : " ") + maxAdFormat.getLabel() + " AdView ad for placement: " + j + APSSharedUtil.TRUNCATE_SEPARATOR);
        if (!InMobiSdk.isSDKInitialized()) {
            log("InMobi SDK not successfully initialized: failing " + maxAdFormat.getLabel() + " ad load...");
            maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.NOT_INITIALIZED);
            return;
        }
        updatePrivacySettings(maxAdapterResponseParameters);
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        boolean zIsValidString = AppLovinSdkUtils.isValidString(bidResponse);
        Context context = getContext(activity);
        if (z) {
            InMobiNative inMobiNative = new InMobiNative(context, j, new NativeAdViewListener(maxAdapterResponseParameters, maxAdFormat, activity, maxAdViewAdapterListener));
            this.nativeAd = inMobiNative;
            inMobiNative.setExtras(getExtras());
            if (zIsValidString) {
                this.nativeAd.load(bidResponse.getBytes());
                return;
            } else {
                this.nativeAd.load();
                return;
            }
        }
        InMobiBanner inMobiBanner = new InMobiBanner(context, j);
        this.adView = inMobiBanner;
        inMobiBanner.setExtras(getExtras());
        this.adView.setAnimationType(InMobiBanner.AnimationType.ANIMATION_OFF);
        this.adView.setEnableAutoRefresh(false);
        this.adView.setListener(new AdViewListener(maxAdViewAdapterListener));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        if (maxAdFormat == MaxAdFormat.BANNER) {
            i = 320;
            i2 = 50;
        } else if (maxAdFormat == MaxAdFormat.LEADER) {
            i = 728;
            i2 = 90;
        } else {
            if (maxAdFormat != MaxAdFormat.MREC) {
                throw new IllegalArgumentException("Unsupported ad format: " + maxAdFormat);
            }
            i = 300;
            i2 = 250;
        }
        this.adView.setLayoutParams(new LinearLayout.LayoutParams(Math.round(i * displayMetrics.density), Math.round(i2 * displayMetrics.density)));
        if (zIsValidString) {
            this.adView.load(bidResponse.getBytes());
        } else {
            this.adView.load();
        }
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        long j = Long.parseLong(maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        log("Loading interstitial ad for placement: " + j + APSSharedUtil.TRUNCATE_SEPARATOR);
        if (!InMobiSdk.isSDKInitialized()) {
            log("InMobi SDK not successfully initialized: failing interstitial ad load...");
            maxInterstitialAdapterListener.onInterstitialAdLoadFailed(MaxAdapterError.NOT_INITIALIZED);
        } else {
            this.interstitialAd = loadFullscreenAd(j, maxAdapterResponseParameters, new InterstitialListener(maxInterstitialAdapterListener), activity);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        log("Showing interstitial ad...");
        if (showFullscreenAd(this.interstitialAd)) {
            return;
        }
        log("Interstitial ad not ready");
        maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Interstitial ad not ready"));
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        long j = Long.parseLong(maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        log("Loading rewarded ad for placement: " + j + APSSharedUtil.TRUNCATE_SEPARATOR);
        if (!InMobiSdk.isSDKInitialized()) {
            log("InMobi SDK not successfully initialized: failing rewarded ad load...");
            maxRewardedAdapterListener.onRewardedAdLoadFailed(MaxAdapterError.NOT_INITIALIZED);
        } else {
            this.rewardedAd = loadFullscreenAd(j, maxAdapterResponseParameters, new RewardedAdListener(maxRewardedAdapterListener), activity);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        log("Showing rewarded ad...");
        configureReward(maxAdapterResponseParameters);
        if (showFullscreenAd(this.rewardedAd)) {
            return;
        }
        log("Rewarded ad not ready");
        maxRewardedAdapterListener.onRewardedAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed", 0, "Rewarded ad not ready"));
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxNativeAdAdapter
    public void loadNativeAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
        if (!InMobiSdk.isSDKInitialized()) {
            log("InMobi SDK not successfully initialized: failing native ad load...");
            maxNativeAdAdapterListener.onNativeAdLoadFailed(MaxAdapterError.NOT_INITIALIZED);
            return;
        }
        updatePrivacySettings(maxAdapterResponseParameters);
        long j = Long.parseLong(maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        boolean zIsValidString = AppLovinSdkUtils.isValidString(bidResponse);
        log("Loading " + (zIsValidString ? "bidding " : "") + "native ad for placement: " + j + APSSharedUtil.TRUNCATE_SEPARATOR);
        Context context = getContext(activity);
        InMobiNative inMobiNative = new InMobiNative(context, j, new NativeAdListener(maxAdapterResponseParameters, context, maxNativeAdAdapterListener));
        this.nativeAd = inMobiNative;
        inMobiNative.setExtras(getExtras());
        if (zIsValidString) {
            this.nativeAd.load(bidResponse.getBytes());
        } else {
            this.nativeAd.load();
        }
    }

    private void initializeSdkOnUiThread(Runnable runnable) {
        if (AppLovinSdk.VERSION_CODE >= 11090000) {
            runnable.run();
        } else {
            AppLovinSdkUtils.runOnUiThread(runnable);
        }
    }

    private InMobiInterstitial loadFullscreenAd(long j, MaxAdapterResponseParameters maxAdapterResponseParameters, InterstitialAdEventListener interstitialAdEventListener, Activity activity) {
        InMobiInterstitial inMobiInterstitial = new InMobiInterstitial(getContext(activity), j, interstitialAdEventListener);
        inMobiInterstitial.setExtras(getExtras());
        updatePrivacySettings(maxAdapterResponseParameters);
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        if (!TextUtils.isEmpty(bidResponse)) {
            inMobiInterstitial.load(bidResponse.getBytes());
        } else {
            inMobiInterstitial.load();
        }
        return inMobiInterstitial;
    }

    private boolean showFullscreenAd(InMobiInterstitial inMobiInterstitial) {
        if (!inMobiInterstitial.isReady()) {
            return false;
        }
        inMobiInterstitial.show();
        return true;
    }

    private JSONObject getConsentJSONObject(MaxAdapterParameters maxAdapterParameters) {
        JSONObject jSONObject = new JSONObject();
        try {
            Boolean boolHasUserConsent = maxAdapterParameters.hasUserConsent();
            if (boolHasUserConsent != null) {
                jSONObject.put(KEY_PARTNER_GDPR_CONSENT, boolHasUserConsent);
            }
        } catch (JSONException e) {
            log("Failed to create consent JSON object", e);
        }
        return jSONObject;
    }

    private void updatePrivacySettings(MaxAdapterParameters maxAdapterParameters) {
        InMobiSdk.setPartnerGDPRConsent(getConsentJSONObject(maxAdapterParameters));
        Boolean boolIsDoNotSell = maxAdapterParameters.isDoNotSell();
        if (boolIsDoNotSell != null) {
            InMobiPrivacyCompliance.setDoNotSell(boolIsDoNotSell.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext(Activity activity) {
        return activity != null ? activity.getApplicationContext() : getApplicationContext();
    }

    private Map<String, String> getExtras() {
        HashMap map = new HashMap(2);
        map.put("tp", "c_applovin");
        map.put("tp-ver", AppLovinSdk.VERSION);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getNativeAdMediaContentAspectRatio(MaxAdapterParameters maxAdapterParameters) {
        Object obj = maxAdapterParameters.getLocalExtraParameters().get("native_ad_media_content_aspect_ratio");
        return obj instanceof Number ? ((Number) obj).floatValue() : DEFAULT_MEDIA_CONTENT_ASPECT_RATIO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable fetchNativeAdIcon(String str, Bundle bundle, Context context) {
        if (TextUtils.isEmpty(str)) {
            log("Native ad icon url " + str + " is not valid");
            return null;
        }
        log("Adding native ad icon (" + str + ") to queue to be fetched");
        try {
            return createDrawableFuture(str, context.getResources()).get(BundleUtils.getInt("image_task_timeout_seconds", 5, bundle), TimeUnit.SECONDS);
        } catch (Throwable th) {
            e("Failed to fetch icon image from URL: " + str, th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MaxNativeAdView createMaxNativeAdView(MaxNativeAd maxNativeAd, String str) {
        return new MaxNativeAdView(maxNativeAd, str, getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MaxAdapterError toMaxError(InMobiAdRequestStatus inMobiAdRequestStatus) {
        InMobiAdRequestStatus.StatusCode statusCode = inMobiAdRequestStatus.getStatusCode();
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        switch (AnonymousClass2.$SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[statusCode.ordinal()]) {
            case 1:
                maxAdapterError = MaxAdapterError.UNSPECIFIED;
                break;
            case 2:
                maxAdapterError = MaxAdapterError.NO_CONNECTION;
                break;
            case 3:
                maxAdapterError = MaxAdapterError.NO_FILL;
                break;
            case 4:
                maxAdapterError = MaxAdapterError.BAD_REQUEST;
                break;
            case 5:
                maxAdapterError = MaxAdapterError.TIMEOUT;
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                break;
            case 13:
                maxAdapterError = MaxAdapterError.SERVER_ERROR;
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                maxAdapterError = MaxAdapterError.INVALID_LOAD_STATE;
                break;
            case 19:
                maxAdapterError = MaxAdapterError.AD_EXPIRED;
                break;
            case 20:
            case 21:
                maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                break;
        }
        return new MaxAdapterError(maxAdapterError.getErrorCode(), maxAdapterError.getErrorMessage(), statusCode.ordinal(), inMobiAdRequestStatus.getMessage());
    }

    /* JADX INFO: renamed from: com.applovin.mediation.adapters.InMobiMediationAdapter$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode;

        static {
            int[] iArr = new int[InMobiAdRequestStatus.StatusCode.values().length];
            $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode = iArr;
            try {
                iArr[InMobiAdRequestStatus.StatusCode.NO_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.NO_FILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.REQUEST_INVALID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.REQUEST_TIMED_OUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.GDPR_COMPLIANCE_ENFORCED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.GET_SIGNALS_CALLED_WHILE_LOADING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.CALLED_FROM_WRONG_THREAD.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.LOW_MEMORY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.INVALID_RESPONSE_IN_LOAD.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.SERVER_ERROR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.AD_ACTIVE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.EARLY_REFRESH_REQUEST.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.REPETITIVE_LOAD.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.LOAD_WITH_RESPONSE_CALLED_WHILE_LOADING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.REQUEST_PENDING.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.AD_NO_LONGER_AVAILABLE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.MONETIZATION_DISABLED.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[InMobiAdRequestStatus.StatusCode.CONFIGURATION_ERROR.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<View> getClickableViews(MaxNativeAdView maxNativeAdView) {
        if (AppLovinSdk.VERSION_CODE < 11050300) {
            ArrayList arrayList = new ArrayList(5);
            if (maxNativeAdView.getTitleTextView() != null) {
                arrayList.add(maxNativeAdView.getTitleTextView());
            }
            if (maxNativeAdView.getAdvertiserTextView() != null) {
                arrayList.add(maxNativeAdView.getAdvertiserTextView());
            }
            if (maxNativeAdView.getBodyTextView() != null) {
                arrayList.add(maxNativeAdView.getBodyTextView());
            }
            if (maxNativeAdView.getCallToActionButton() != null) {
                arrayList.add(maxNativeAdView.getCallToActionButton());
            }
            if (maxNativeAdView.getIconImageView() != null) {
                arrayList.add(maxNativeAdView.getIconImageView());
            }
            return arrayList;
        }
        return maxNativeAdView.getClickableViews();
    }

    private class AdViewListener extends BannerAdEventListener {
        final MaxAdViewAdapterListener listener;

        @Override // com.inmobi.ads.listeners.AdEventListener
        public /* bridge */ /* synthetic */ void onAdClicked(InMobiBanner inMobiBanner, Map map) {
            onAdClicked2(inMobiBanner, (Map<Object, Object>) map);
        }

        AdViewListener(MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.listener = maxAdViewAdapterListener;
        }

        @Override // com.inmobi.ads.listeners.AdEventListener
        public void onAdLoadSucceeded(InMobiBanner inMobiBanner, AdMetaInfo adMetaInfo) {
            InMobiMediationAdapter.this.log("AdView loaded");
            if (!TextUtils.isEmpty(adMetaInfo.getCreativeID())) {
                Bundle bundle = new Bundle(1);
                bundle.putString("creative_id", adMetaInfo.getCreativeID());
                this.listener.onAdViewAdLoaded(inMobiBanner, bundle);
                return;
            }
            this.listener.onAdViewAdLoaded(inMobiBanner);
        }

        @Override // com.inmobi.ads.listeners.AdEventListener
        public void onAdLoadFailed(InMobiBanner inMobiBanner, InMobiAdRequestStatus inMobiAdRequestStatus) {
            InMobiMediationAdapter.this.log("AdView failed to load with error code " + inMobiAdRequestStatus.getStatusCode() + " and message: " + inMobiAdRequestStatus.getMessage());
            this.listener.onAdViewAdLoadFailed(InMobiMediationAdapter.toMaxError(inMobiAdRequestStatus));
        }

        @Override // com.inmobi.ads.listeners.BannerAdEventListener
        public void onAdDisplayed(InMobiBanner inMobiBanner) {
            InMobiMediationAdapter.this.log("AdView expanded");
            this.listener.onAdViewAdExpanded();
        }

        @Override // com.inmobi.ads.listeners.AdEventListener
        public void onAdImpression(InMobiBanner inMobiBanner) {
            InMobiMediationAdapter.this.log("AdView impression tracked");
            this.listener.onAdViewAdDisplayed();
        }

        @Override // com.inmobi.ads.listeners.BannerAdEventListener
        public void onAdDismissed(InMobiBanner inMobiBanner) {
            InMobiMediationAdapter.this.log("AdView collapsed");
            this.listener.onAdViewAdCollapsed();
        }

        /* JADX INFO: renamed from: onAdClicked, reason: avoid collision after fix types in other method */
        public void onAdClicked2(InMobiBanner inMobiBanner, Map<Object, Object> map) {
            InMobiMediationAdapter.this.log("AdView clicked");
            this.listener.onAdViewAdClicked();
        }

        @Override // com.inmobi.ads.listeners.BannerAdEventListener
        public void onUserLeftApplication(InMobiBanner inMobiBanner) {
            InMobiMediationAdapter.this.log("AdView will leave application");
        }
    }

    private class InterstitialListener extends InterstitialAdEventListener {
        final MaxInterstitialAdapterListener listener;

        @Override // com.inmobi.ads.listeners.AdEventListener
        public /* bridge */ /* synthetic */ void onAdClicked(InMobiInterstitial inMobiInterstitial, Map map) {
            onAdClicked2(inMobiInterstitial, (Map<Object, Object>) map);
        }

        InterstitialListener(MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
            this.listener = maxInterstitialAdapterListener;
        }

        @Override // com.inmobi.ads.listeners.AdEventListener
        public void onAdFetchSuccessful(InMobiInterstitial inMobiInterstitial, AdMetaInfo adMetaInfo) {
            InMobiMediationAdapter.this.log("Interstitial request succeeded");
        }

        @Override // com.inmobi.ads.listeners.AdEventListener
        public void onAdLoadSucceeded(InMobiInterstitial inMobiInterstitial, AdMetaInfo adMetaInfo) {
            InMobiMediationAdapter.this.log("Interstitial loaded");
            if (!TextUtils.isEmpty(adMetaInfo.getCreativeID())) {
                Bundle bundle = new Bundle(1);
                bundle.putString("creative_id", adMetaInfo.getCreativeID());
                this.listener.onInterstitialAdLoaded(bundle);
                return;
            }
            this.listener.onInterstitialAdLoaded();
        }

        @Override // com.inmobi.ads.listeners.AdEventListener
        public void onAdLoadFailed(InMobiInterstitial inMobiInterstitial, InMobiAdRequestStatus inMobiAdRequestStatus) {
            InMobiMediationAdapter.this.log("Interstitial failed to load with error code " + inMobiAdRequestStatus.getStatusCode() + " and message: " + inMobiAdRequestStatus.getMessage());
            this.listener.onInterstitialAdLoadFailed(InMobiMediationAdapter.toMaxError(inMobiAdRequestStatus));
        }

        @Override // com.inmobi.ads.listeners.InterstitialAdEventListener
        public void onAdDisplayFailed(InMobiInterstitial inMobiInterstitial) {
            InMobiMediationAdapter.this.log("Interstitial failed to display");
            this.listener.onInterstitialAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Ad Display Failed"));
        }

        @Override // com.inmobi.ads.listeners.InterstitialAdEventListener
        public void onAdWillDisplay(InMobiInterstitial inMobiInterstitial) {
            InMobiMediationAdapter.this.log("Interstitial will show");
        }

        @Override // com.inmobi.ads.listeners.InterstitialAdEventListener
        public void onAdDisplayed(InMobiInterstitial inMobiInterstitial, AdMetaInfo adMetaInfo) {
            InMobiMediationAdapter.this.log("Interstitial did show");
        }

        @Override // com.inmobi.ads.listeners.AdEventListener
        public void onAdImpression(InMobiInterstitial inMobiInterstitial) {
            InMobiMediationAdapter.this.log("Interstitial impression tracked");
            this.listener.onInterstitialAdDisplayed();
        }

        /* JADX INFO: renamed from: onAdClicked, reason: avoid collision after fix types in other method */
        public void onAdClicked2(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
            InMobiMediationAdapter.this.log("Interstitial clicked");
            this.listener.onInterstitialAdClicked();
        }

        @Override // com.inmobi.ads.listeners.InterstitialAdEventListener
        public void onAdDismissed(InMobiInterstitial inMobiInterstitial) {
            InMobiMediationAdapter.this.log("Interstitial hidden");
            this.listener.onInterstitialAdHidden();
        }

        @Override // com.inmobi.ads.listeners.InterstitialAdEventListener
        public void onUserLeftApplication(InMobiInterstitial inMobiInterstitial) {
            InMobiMediationAdapter.this.log("Interstitial will leave application");
        }
    }

    private class RewardedAdListener extends InterstitialAdEventListener {
        private boolean hasGrantedReward;
        final MaxRewardedAdapterListener listener;

        @Override // com.inmobi.ads.listeners.AdEventListener
        public /* bridge */ /* synthetic */ void onAdClicked(InMobiInterstitial inMobiInterstitial, Map map) {
            onAdClicked2(inMobiInterstitial, (Map<Object, Object>) map);
        }

        RewardedAdListener(MaxRewardedAdapterListener maxRewardedAdapterListener) {
            this.listener = maxRewardedAdapterListener;
        }

        @Override // com.inmobi.ads.listeners.AdEventListener
        public void onAdFetchSuccessful(InMobiInterstitial inMobiInterstitial, AdMetaInfo adMetaInfo) {
            InMobiMediationAdapter.this.log("Rewarded ad request succeeded");
        }

        @Override // com.inmobi.ads.listeners.AdEventListener
        public void onAdLoadSucceeded(InMobiInterstitial inMobiInterstitial, AdMetaInfo adMetaInfo) {
            InMobiMediationAdapter.this.log("Rewarded ad loaded");
            if (!TextUtils.isEmpty(adMetaInfo.getCreativeID())) {
                Bundle bundle = new Bundle(1);
                bundle.putString("creative_id", adMetaInfo.getCreativeID());
                this.listener.onRewardedAdLoaded(bundle);
                return;
            }
            this.listener.onRewardedAdLoaded();
        }

        @Override // com.inmobi.ads.listeners.AdEventListener
        public void onAdLoadFailed(InMobiInterstitial inMobiInterstitial, InMobiAdRequestStatus inMobiAdRequestStatus) {
            InMobiMediationAdapter.this.log("Rewarded ad failed to load with error code " + inMobiAdRequestStatus.getStatusCode() + " and message: " + inMobiAdRequestStatus.getMessage());
            this.listener.onRewardedAdLoadFailed(InMobiMediationAdapter.toMaxError(inMobiAdRequestStatus));
        }

        @Override // com.inmobi.ads.listeners.InterstitialAdEventListener
        public void onAdDisplayFailed(InMobiInterstitial inMobiInterstitial) {
            InMobiMediationAdapter.this.log("Rewarded ad failed to display");
            this.listener.onRewardedAdDisplayFailed(MaxAdapterError.UNSPECIFIED);
        }

        @Override // com.inmobi.ads.listeners.InterstitialAdEventListener
        public void onAdWillDisplay(InMobiInterstitial inMobiInterstitial) {
            InMobiMediationAdapter.this.log("Rewarded ad did show");
        }

        @Override // com.inmobi.ads.listeners.InterstitialAdEventListener
        public void onAdDisplayed(InMobiInterstitial inMobiInterstitial, AdMetaInfo adMetaInfo) {
            InMobiMediationAdapter.this.log("Rewarded ad did show");
        }

        @Override // com.inmobi.ads.listeners.AdEventListener
        public void onAdImpression(InMobiInterstitial inMobiInterstitial) {
            InMobiMediationAdapter.this.log("Rewarded ad impression tracked");
            this.listener.onRewardedAdDisplayed();
        }

        /* JADX INFO: renamed from: onAdClicked, reason: avoid collision after fix types in other method */
        public void onAdClicked2(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
            InMobiMediationAdapter.this.log("Rewarded ad clicked");
            this.listener.onRewardedAdClicked();
        }

        @Override // com.inmobi.ads.listeners.InterstitialAdEventListener
        public void onAdDismissed(InMobiInterstitial inMobiInterstitial) {
            InMobiMediationAdapter.this.log("Rewarded ad hidden");
            if (this.hasGrantedReward || InMobiMediationAdapter.this.shouldAlwaysRewardUser()) {
                MaxReward reward = InMobiMediationAdapter.this.getReward();
                InMobiMediationAdapter.this.log("Rewarded user with reward: " + reward);
                this.listener.onUserRewarded(reward);
            }
            this.listener.onRewardedAdHidden();
        }

        @Override // com.inmobi.ads.listeners.InterstitialAdEventListener
        public void onUserLeftApplication(InMobiInterstitial inMobiInterstitial) {
            InMobiMediationAdapter.this.log("Rewarded ad will leave application");
        }

        @Override // com.inmobi.ads.listeners.InterstitialAdEventListener
        public void onRewardsUnlocked(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
            InMobiMediationAdapter.this.log("Rewarded ad granted reward");
            this.hasGrantedReward = true;
        }
    }

    private class NativeAdViewListener extends NativeAdEventListener {
        private final WeakReference<Activity> activityRef;
        private final MaxAdFormat adFormat;
        private final MaxAdViewAdapterListener listener;
        private final float mediaContentAspectRatio;
        private final String placementId;
        private final Bundle serverParameters;

        NativeAdViewListener(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.placementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            this.serverParameters = maxAdapterResponseParameters.getServerParameters();
            this.mediaContentAspectRatio = InMobiMediationAdapter.this.getNativeAdMediaContentAspectRatio(maxAdapterResponseParameters);
            this.adFormat = maxAdFormat;
            this.activityRef = new WeakReference<>(activity);
            this.listener = maxAdViewAdapterListener;
        }

        @Override // com.inmobi.ads.listeners.AdEventListener
        public void onAdLoadSucceeded(final InMobiNative inMobiNative, final AdMetaInfo adMetaInfo) {
            if (InMobiMediationAdapter.this.nativeAd == null || inMobiNative == null || InMobiMediationAdapter.this.nativeAd != inMobiNative) {
                InMobiMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad failed to load: no fill");
                this.listener.onAdViewAdLoadFailed(MaxAdapterError.NO_FILL);
            } else if (TextUtils.isEmpty(inMobiNative.getAdTitle())) {
                InMobiMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad does not have required assets.");
                this.listener.onAdViewAdLoadFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_MISSING_REQUIRED_NATIVE_AD_ASSETS, "Missing Native Ad Assets"));
            } else {
                InMobiMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad loaded: " + this.placementId);
                final Context context = InMobiMediationAdapter.this.getContext(this.activityRef.get());
                InMobiMediationAdapter.this.getCachingExecutorService().execute(new Runnable() { // from class: com.applovin.mediation.adapters.InMobiMediationAdapter.NativeAdViewListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final Drawable drawableFetchNativeAdIcon = InMobiMediationAdapter.this.fetchNativeAdIcon(inMobiNative.getAdIconUrl(), NativeAdViewListener.this.serverParameters, context);
                        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.InMobiMediationAdapter.NativeAdViewListener.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MaxNativeAdView maxNativeAdViewCreateMaxNativeAdView;
                                new ImageView(context).setImageDrawable(drawableFetchNativeAdIcon);
                                MaxInMobiNativeAd maxInMobiNativeAd = InMobiMediationAdapter.this.new MaxInMobiNativeAd(NativeAdViewListener.this.listener, new MaxNativeAd.Builder().setAdFormat(NativeAdViewListener.this.adFormat).setTitle(inMobiNative.getAdTitle()).setBody(inMobiNative.getAdDescription()).setCallToAction(inMobiNative.getAdCtaText()).setIcon(new MaxNativeAd.MaxNativeAdImage(drawableFetchNativeAdIcon)).setMediaView(new FrameLayout(context)).setMediaContentAspectRatio(NativeAdViewListener.this.mediaContentAspectRatio), NativeAdViewListener.this.adFormat);
                                String string = BundleUtils.getString("template", "", NativeAdViewListener.this.serverParameters);
                                if (string.contains("vertical")) {
                                    if (string.equals("vertical")) {
                                        maxNativeAdViewCreateMaxNativeAdView = InMobiMediationAdapter.this.createMaxNativeAdView(maxInMobiNativeAd, NativeAdViewListener.this.adFormat == MaxAdFormat.LEADER ? "vertical_leader_template" : "vertical_media_banner_template");
                                    } else {
                                        maxNativeAdViewCreateMaxNativeAdView = InMobiMediationAdapter.this.createMaxNativeAdView(maxInMobiNativeAd, string);
                                    }
                                } else {
                                    InMobiMediationAdapter inMobiMediationAdapter = InMobiMediationAdapter.this;
                                    if (!AppLovinSdkUtils.isValidString(string)) {
                                        string = "media_banner_template";
                                    }
                                    maxNativeAdViewCreateMaxNativeAdView = inMobiMediationAdapter.createMaxNativeAdView(maxInMobiNativeAd, string);
                                }
                                maxInMobiNativeAd.prepareForInteraction(InMobiMediationAdapter.this.getClickableViews(maxNativeAdViewCreateMaxNativeAdView), maxNativeAdViewCreateMaxNativeAdView);
                                if (!AppLovinSdkUtils.isValidString(adMetaInfo.getCreativeID())) {
                                    NativeAdViewListener.this.listener.onAdViewAdLoaded(maxNativeAdViewCreateMaxNativeAdView);
                                    return;
                                }
                                Bundle bundle = new Bundle(1);
                                bundle.putString("creative_id", adMetaInfo.getCreativeID());
                                NativeAdViewListener.this.listener.onAdViewAdLoaded(maxNativeAdViewCreateMaxNativeAdView, bundle);
                            }
                        });
                    }
                });
            }
        }

        @Override // com.inmobi.ads.listeners.AdEventListener
        public void onAdLoadFailed(InMobiNative inMobiNative, InMobiAdRequestStatus inMobiAdRequestStatus) {
            MaxAdapterError maxError = InMobiMediationAdapter.toMaxError(inMobiAdRequestStatus);
            InMobiMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad failed to load with error " + maxError);
            this.listener.onAdViewAdLoadFailed(maxError);
        }

        @Override // com.inmobi.ads.listeners.AdEventListener
        public void onAdImpression(InMobiNative inMobiNative) {
            InMobiMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad shown");
            this.listener.onAdViewAdDisplayed();
        }

        @Override // com.inmobi.ads.listeners.NativeAdEventListener
        public void onAdClicked(InMobiNative inMobiNative) {
            InMobiMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad clicked");
            this.listener.onAdViewAdClicked();
        }

        @Override // com.inmobi.ads.listeners.NativeAdEventListener
        public void onUserWillLeaveApplication(InMobiNative inMobiNative) {
            InMobiMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad user will leave application");
        }

        @Override // com.inmobi.ads.listeners.NativeAdEventListener
        public void onAdFullScreenWillDisplay(InMobiNative inMobiNative) {
            InMobiMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad fullscreen will display");
        }

        @Override // com.inmobi.ads.listeners.NativeAdEventListener
        public void onAdFullScreenDisplayed(InMobiNative inMobiNative) {
            InMobiMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad fullscreen displayed");
        }

        @Override // com.inmobi.ads.listeners.NativeAdEventListener
        public void onAdFullScreenDismissed(InMobiNative inMobiNative) {
            InMobiMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad fullscreen dismissed");
        }

        @Override // com.inmobi.ads.listeners.NativeAdEventListener
        public void onAdStatusChanged(InMobiNative inMobiNative) {
            InMobiMediationAdapter.this.log("Native " + this.adFormat.getLabel() + " ad status changed");
        }
    }

    private class NativeAdListener extends NativeAdEventListener {
        private final Context context;
        private final MaxNativeAdAdapterListener listener;
        private final float mediaContentAspectRatio;
        private final String placementId;
        private final Bundle serverParameters;

        NativeAdListener(MaxAdapterResponseParameters maxAdapterResponseParameters, Context context, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
            this.placementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            this.serverParameters = maxAdapterResponseParameters.getServerParameters();
            this.mediaContentAspectRatio = InMobiMediationAdapter.this.getNativeAdMediaContentAspectRatio(maxAdapterResponseParameters);
            this.context = context;
            this.listener = maxNativeAdAdapterListener;
        }

        @Override // com.inmobi.ads.listeners.AdEventListener
        public void onAdLoadSucceeded(final InMobiNative inMobiNative, final AdMetaInfo adMetaInfo) {
            if (InMobiMediationAdapter.this.nativeAd == null || inMobiNative == null || InMobiMediationAdapter.this.nativeAd != inMobiNative) {
                InMobiMediationAdapter.this.log("Native ad failed to load: no fill");
                this.listener.onNativeAdLoadFailed(MaxAdapterError.NO_FILL);
            } else if (AppLovinSdkUtils.isValidString(BundleUtils.getString("template", "", this.serverParameters)) && TextUtils.isEmpty(inMobiNative.getAdTitle())) {
                InMobiMediationAdapter.this.e("Native ad (" + inMobiNative + ") does not have required assets.");
                this.listener.onNativeAdLoadFailed(MaxAdapterError.MISSING_REQUIRED_NATIVE_AD_ASSETS);
            } else {
                InMobiMediationAdapter.this.log("Native ad loaded: " + this.placementId);
                InMobiMediationAdapter.this.getCachingExecutorService().execute(new Runnable() { // from class: com.applovin.mediation.adapters.InMobiMediationAdapter.NativeAdListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Drawable drawableFetchNativeAdIcon = InMobiMediationAdapter.this.fetchNativeAdIcon(inMobiNative.getAdIconUrl(), NativeAdListener.this.serverParameters, NativeAdListener.this.context);
                        NativeAdListener nativeAdListener = NativeAdListener.this;
                        nativeAdListener.handleNativeAdLoaded(inMobiNative, adMetaInfo, drawableFetchNativeAdIcon, nativeAdListener.context);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleNativeAdLoaded(final InMobiNative inMobiNative, final AdMetaInfo adMetaInfo, final Drawable drawable, final Context context) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.InMobiMediationAdapter.NativeAdListener.2
                @Override // java.lang.Runnable
                public void run() {
                    new ImageView(context).setImageDrawable(drawable);
                    MaxNativeAd.Builder mediaContentAspectRatio = new MaxNativeAd.Builder().setAdFormat(MaxAdFormat.NATIVE).setTitle(inMobiNative.getAdTitle()).setBody(inMobiNative.getAdDescription()).setCallToAction(inMobiNative.getAdCtaText()).setIcon(new MaxNativeAd.MaxNativeAdImage(drawable)).setMediaView(new FrameLayout(context)).setMediaContentAspectRatio(NativeAdListener.this.mediaContentAspectRatio);
                    if (AppLovinSdk.VERSION_CODE >= 11070000) {
                        mediaContentAspectRatio.setStarRating(Double.valueOf(inMobiNative.getAdRating()));
                    }
                    MaxInMobiNativeAd maxInMobiNativeAd = InMobiMediationAdapter.this.new MaxInMobiNativeAd(NativeAdListener.this.listener, mediaContentAspectRatio, MaxAdFormat.NATIVE);
                    if (!AppLovinSdkUtils.isValidString(adMetaInfo.getCreativeID())) {
                        NativeAdListener.this.listener.onNativeAdLoaded(maxInMobiNativeAd, null);
                        return;
                    }
                    Bundle bundle = new Bundle(1);
                    bundle.putString("creative_id", adMetaInfo.getCreativeID());
                    NativeAdListener.this.listener.onNativeAdLoaded(maxInMobiNativeAd, bundle);
                }
            });
        }

        @Override // com.inmobi.ads.listeners.AdEventListener
        public void onAdLoadFailed(InMobiNative inMobiNative, InMobiAdRequestStatus inMobiAdRequestStatus) {
            MaxAdapterError maxError = InMobiMediationAdapter.toMaxError(inMobiAdRequestStatus);
            InMobiMediationAdapter.this.log("Native ad failed to load with error " + maxError);
            this.listener.onNativeAdLoadFailed(maxError);
        }

        @Override // com.inmobi.ads.listeners.AdEventListener
        public void onAdImpression(InMobiNative inMobiNative) {
            InMobiMediationAdapter.this.log("Native ad shown");
            this.listener.onNativeAdDisplayed(null);
        }

        @Override // com.inmobi.ads.listeners.NativeAdEventListener
        public void onAdClicked(InMobiNative inMobiNative) {
            InMobiMediationAdapter.this.log("Native ad clicked");
            this.listener.onNativeAdClicked();
        }

        @Override // com.inmobi.ads.listeners.NativeAdEventListener
        public void onUserWillLeaveApplication(InMobiNative inMobiNative) {
            InMobiMediationAdapter.this.log("Native ad user will leave application");
        }

        @Override // com.inmobi.ads.listeners.NativeAdEventListener
        public void onAdFullScreenWillDisplay(InMobiNative inMobiNative) {
            InMobiMediationAdapter.this.log("Native ad fullscreen will display");
        }

        @Override // com.inmobi.ads.listeners.NativeAdEventListener
        public void onAdFullScreenDisplayed(InMobiNative inMobiNative) {
            InMobiMediationAdapter.this.log("Native ad fullscreen displayed");
        }

        @Override // com.inmobi.ads.listeners.NativeAdEventListener
        public void onAdFullScreenDismissed(InMobiNative inMobiNative) {
            InMobiMediationAdapter.this.log("Native ad fullscreen dismissed");
        }

        @Override // com.inmobi.ads.listeners.NativeAdEventListener
        public void onAdStatusChanged(InMobiNative inMobiNative) {
            InMobiMediationAdapter.this.log("Native ad status changed");
        }
    }

    private class MaxInMobiNativeAd extends MaxNativeAd {
        private final MaxAdFormat format;
        private final MaxAdapterListener listener;

        public MaxInMobiNativeAd(MaxAdapterListener maxAdapterListener, MaxNativeAd.Builder builder, MaxAdFormat maxAdFormat) {
            super(builder);
            this.listener = maxAdapterListener;
            this.format = maxAdFormat;
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAd
        public boolean prepareForInteraction(List<View> list, ViewGroup viewGroup) {
            final InMobiNative inMobiNative = InMobiMediationAdapter.this.nativeAd;
            if (inMobiNative == null) {
                InMobiMediationAdapter.this.e("Failed to register native ad views: native ad is null.");
                return false;
            }
            final FrameLayout frameLayout = (FrameLayout) getMediaView();
            frameLayout.post(new Runnable() { // from class: com.applovin.mediation.adapters.InMobiMediationAdapter.MaxInMobiNativeAd.1
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int width = frameLayout.getWidth();
                    int height = frameLayout.getHeight();
                    boolean z = MaxInMobiNativeAd.this.format == MaxAdFormat.BANNER && width > height;
                    if (AppLovinSdk.VERSION_CODE < 11060000 && z) {
                        width = (int) (height * MaxInMobiNativeAd.this.getMediaContentAspectRatio());
                    }
                    ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                    if (width == 0 && layoutParams != null && ((i = layoutParams.width) == -2 || i == -1)) {
                        width = (int) (height * MaxInMobiNativeAd.this.getMediaContentAspectRatio());
                    }
                    View primaryViewOfWidth = inMobiNative.getPrimaryViewOfWidth(frameLayout.getContext(), null, frameLayout, width);
                    if (primaryViewOfWidth == null) {
                        return;
                    }
                    frameLayout.addView(primaryViewOfWidth);
                    if (AppLovinSdk.VERSION_CODE >= 11060000 || !z) {
                        return;
                    }
                    ((FrameLayout.LayoutParams) primaryViewOfWidth.getLayoutParams()).gravity = 17;
                }
            });
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.applovin.mediation.adapters.InMobiMediationAdapter.MaxInMobiNativeAd.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    InMobiMediationAdapter.this.log("Native ad clicked from click listener");
                    SpecialsBridge.nativeAdEventListenerOnAdClicked(inMobiNative);
                }
            };
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(onClickListener);
                }
            }
            return true;
        }
    }
}
