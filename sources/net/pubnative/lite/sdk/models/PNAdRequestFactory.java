package net.pubnative.lite.sdk.models;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import net.pubnative.lite.sdk.DeviceInfo;
import net.pubnative.lite.sdk.DisplayManager;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.TopicManager;
import net.pubnative.lite.sdk.UserDataManager;
import net.pubnative.lite.sdk.location.HyBidLocationManager;
import net.pubnative.lite.sdk.models.bidstream.GeoLocation;
import net.pubnative.lite.sdk.models.bidstream.Impression;
import net.pubnative.lite.sdk.models.bidstream.ImpressionBanner;
import net.pubnative.lite.sdk.models.bidstream.ImpressionVideo;
import net.pubnative.lite.sdk.models.bidstream.Signal;
import net.pubnative.lite.sdk.prefs.HyBidPreferences;
import net.pubnative.lite.sdk.prefs.SessionImpressionPrefs;
import net.pubnative.lite.sdk.utils.HyBidAdvertisingId;
import net.pubnative.lite.sdk.utils.HyBidTimeUtils;
import net.pubnative.lite.sdk.utils.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class PNAdRequestFactory extends BaseRequestFactory implements AdRequestFactory {
    private static final String TAG = "PNAdRequestFactory";
    private DeviceInfo mDeviceInfo;
    private final DisplayManager mDisplayManager;
    private IntegrationType mIntegrationType;
    private boolean mIsRewarded;
    private HyBidLocationManager mLocationManager;
    private String mMediationVendor;
    private final TopicManager mTopicManager;
    private UserDataManager mUserDataManager;
    private HyBidPreferences prefs;

    @Override // net.pubnative.lite.sdk.models.AdRequestFactory
    public void setAdFormat(String str) {
    }

    public PNAdRequestFactory() {
        this(HyBid.getDeviceInfo(), HyBid.getLocationManager(), HyBid.getUserDataManager(), new DisplayManager(), HyBid.getTopicManager());
    }

    PNAdRequestFactory(DeviceInfo deviceInfo, HyBidLocationManager hyBidLocationManager, UserDataManager userDataManager, DisplayManager displayManager, TopicManager topicManager) {
        this.mIntegrationType = IntegrationType.HEADER_BIDDING;
        this.mDeviceInfo = deviceInfo;
        this.mLocationManager = hyBidLocationManager;
        this.mUserDataManager = userDataManager;
        this.mDisplayManager = displayManager;
        this.mTopicManager = topicManager;
    }

    @Override // net.pubnative.lite.sdk.models.AdRequestFactory
    public void createAdRequest(final String str, final String str2, final AdSize adSize, boolean z, final boolean z2, final AdRequestFactory.Callback callback) {
        Context context;
        boolean z3;
        String str3;
        if (this.mDeviceInfo == null) {
            this.mDeviceInfo = HyBid.getDeviceInfo();
        }
        DeviceInfo deviceInfo = this.mDeviceInfo;
        if (deviceInfo != null) {
            String advertisingId = deviceInfo.getAdvertisingId();
            boolean zLimitTracking = this.mDeviceInfo.limitTracking();
            context = this.mDeviceInfo.getContext();
            str3 = advertisingId;
            z3 = zLimitTracking;
        } else {
            context = null;
            z3 = false;
            str3 = null;
        }
        this.mIsRewarded = z;
        if (TextUtils.isEmpty(str3) && context != null) {
            try {
                final int iIntValue = new SessionImpressionPrefs(this.mDeviceInfo.getContext()).getImpressionDepth(str2).intValue();
                new HyBidAdvertisingId(context).execute(new HyBidAdvertisingId.Listener() { // from class: net.pubnative.lite.sdk.models.PNAdRequestFactory$$ExternalSyntheticLambda0
                    @Override // net.pubnative.lite.sdk.utils.HyBidAdvertisingId.Listener
                    public final void onHyBidAdvertisingIdFinish(String str4, Boolean bool) {
                        this.f$0.m9640x40ef433b(str, str2, adSize, iIntValue, z2, callback, str4, bool);
                    }
                });
                return;
            } catch (RejectedExecutionException e) {
                Logger.e(TAG, "createAdRequest", e);
                return;
            } catch (Exception unused) {
                Logger.e(TAG, "Error executing HyBidAdvertisingId AsyncTask");
                return;
            }
        }
        DeviceInfo deviceInfo2 = this.mDeviceInfo;
        if (deviceInfo2 == null || deviceInfo2.getContext() == null) {
            return;
        }
        processAdvertisingId(str, str2, adSize, str3, z3, new SessionImpressionPrefs(this.mDeviceInfo.getContext()).getImpressionDepth(str2).intValue(), z2, callback);
    }

    /* JADX INFO: renamed from: lambda$createAdRequest$0$net-pubnative-lite-sdk-models-PNAdRequestFactory, reason: not valid java name */
    /* synthetic */ void m9640x40ef433b(String str, String str2, AdSize adSize, int i, boolean z, AdRequestFactory.Callback callback, String str3, Boolean bool) {
        processAdvertisingId(str, str2, adSize, str3, bool.booleanValue(), i, z, callback);
    }

    private void processAdvertisingId(String str, String str2, AdSize adSize, String str3, boolean z, int i, boolean z2, AdRequestFactory.Callback callback) {
        if (callback != null) {
            callback.onRequestCreated(buildRequest(str, str2, adSize, str3, z, this.mIntegrationType, this.mMediationVendor, Integer.valueOf(i), z2));
        }
    }

    @Override // net.pubnative.lite.sdk.models.AdRequestFactory
    public AdRequest buildRequest(String str, String str2, AdSize adSize, String str3, boolean z, IntegrationType integrationType, String str4, Integer num, boolean z2) {
        return buildRequest(null, str, str2, adSize, str3, z, integrationType, str4, num, z2);
    }

    public AdRequest buildRequest(Context context, String str, String str2, AdSize adSize, String str3, boolean z, IntegrationType integrationType, String str4, Integer num, boolean z2) {
        boolean zIsCCPAOptOut;
        Location userLocation;
        UserDataManager userDataManager;
        UserDataManager userDataManager2;
        UserDataManager userDataManager3;
        int i;
        if (this.mUserDataManager == null && context != null) {
            this.mUserDataManager = new UserDataManager(context);
        }
        if (this.mDeviceInfo == null && context != null) {
            this.mDeviceInfo = new DeviceInfo(context);
        }
        if (this.mLocationManager == null && context != null) {
            this.mLocationManager = new HyBidLocationManager(context);
        }
        PNAdRequest pNAdRequest = new PNAdRequest();
        UserDataManager userDataManager4 = this.mUserDataManager;
        if (userDataManager4 != null) {
            zIsCCPAOptOut = userDataManager4.isCCPAOptOut();
            String iABUSPrivacyString = this.mUserDataManager.getIABUSPrivacyString();
            if (!TextUtils.isEmpty(iABUSPrivacyString)) {
                pNAdRequest.usprivacy = iABUSPrivacyString;
            }
            String iABGDPRConsentString = this.mUserDataManager.getIABGDPRConsentString();
            if (!TextUtils.isEmpty(iABGDPRConsentString)) {
                pNAdRequest.userconsent = iABGDPRConsentString;
            }
            String gppString = this.mUserDataManager.getGppString();
            if (!TextUtils.isEmpty(gppString)) {
                pNAdRequest.gppstring = gppString;
            }
            String gppSid = this.mUserDataManager.getGppSid();
            if (!TextUtils.isEmpty(gppSid)) {
                pNAdRequest.gppsid = gppSid.replace("_", StringUtils.COMMA);
            }
        } else {
            zIsCCPAOptOut = false;
        }
        pNAdRequest.zoneId = str2;
        pNAdRequest.appToken = TextUtils.isEmpty(str) ? HyBid.getAppToken() : str;
        pNAdRequest.os = "android";
        pNAdRequest.osver = this.mDeviceInfo.getOSVersion();
        pNAdRequest.coppa = HyBid.isCoppaEnabled() ? "1" : "0";
        pNAdRequest.omidpn = "pubnativenet";
        pNAdRequest.omidpv = "1.5.1";
        pNAdRequest.isInterstitial = Boolean.valueOf(adSize == AdSize.SIZE_INTERSTITIAL);
        pNAdRequest.ae = z2 ? "1" : "0";
        Integer num2 = null;
        if (adSize != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (!pNAdRequest.isInterstitial.booleanValue()) {
                arrayList.add(5);
                arrayList.add(6);
                arrayList2.add(5);
                arrayList2.add(6);
                i = 4;
            } else {
                num2 = 5;
                arrayList2.add(1);
                arrayList2.add(2);
                i = 3;
            }
            int i2 = pNAdRequest.isInterstitial.booleanValue() ? 7 : 0;
            pNAdRequest.addSignal(new ImpressionBanner(i2, arrayList));
            pNAdRequest.addSignal(new ImpressionVideo(num2, Integer.valueOf(i), i2, arrayList2));
            pNAdRequest.addSignal(new Impression(Integer.valueOf(pNAdRequest.isInterstitial.booleanValue() ? 1 : 0), 1));
        } else {
            pNAdRequest.addSignal(new Impression(null, 1));
        }
        if (HyBid.isCoppaEnabled() || z || TextUtils.isEmpty(str3) || zIsCCPAOptOut || ((userDataManager3 = this.mUserDataManager) != null && userDataManager3.isConsentDenied())) {
            pNAdRequest.dnt = "1";
        } else {
            pNAdRequest.gid = str3;
            DeviceInfo deviceInfo = this.mDeviceInfo;
            if (deviceInfo != null) {
                pNAdRequest.gidmd5 = deviceInfo.getAdvertisingIdMd5();
                pNAdRequest.gidsha1 = this.mDeviceInfo.getAdvertisingIdSha1();
            }
        }
        DeviceInfo deviceInfo2 = this.mDeviceInfo;
        if (deviceInfo2 != null) {
            pNAdRequest.devicemodel = deviceInfo2.getModel();
            pNAdRequest.make = this.mDeviceInfo.getMake();
            pNAdRequest.deviceType = String.valueOf(this.mDeviceInfo.getDeviceType());
            if (this.mDeviceInfo.getLocale() != null && this.mDeviceInfo.getLocale().getLanguage() != null && !this.mDeviceInfo.getLocale().getLanguage().isEmpty()) {
                pNAdRequest.locale = this.mDeviceInfo.getLocale().getLanguage();
                pNAdRequest.language = this.mDeviceInfo.getLocale().getLanguage();
            } else if (this.mDeviceInfo.getLangb() != null && !this.mDeviceInfo.getLangb().isEmpty()) {
                pNAdRequest.langb = this.mDeviceInfo.getLangb();
            }
            pNAdRequest.deviceHeight = this.mDeviceInfo.getDeviceHeight();
            pNAdRequest.deviceWidth = this.mDeviceInfo.getDeviceWidth();
            pNAdRequest.orientation = this.mDeviceInfo.getOrientation().toString();
            pNAdRequest.ppi = this.mDeviceInfo.getPpi();
            pNAdRequest.pxratio = this.mDeviceInfo.getPxratio();
            pNAdRequest.soundSetting = this.mDeviceInfo.getSoundSetting();
            pNAdRequest.js = "1";
            if (this.mDeviceInfo.getCarrier() != null && !this.mDeviceInfo.getCarrier().isEmpty()) {
                pNAdRequest.carrier = this.mDeviceInfo.getCarrier();
            }
            if (this.mDeviceInfo.getConnectionType() != null) {
                pNAdRequest.connectiontype = String.valueOf(this.mDeviceInfo.getConnectionType());
            }
            if (this.mDeviceInfo.getMccmnc() != null && !this.mDeviceInfo.getMccmnc().isEmpty()) {
                pNAdRequest.mccmnc = this.mDeviceInfo.getMccmnc();
            }
            if (this.mDeviceInfo.getMccmncsim() != null && !this.mDeviceInfo.getMccmncsim().isEmpty()) {
                pNAdRequest.mccmncsim = this.mDeviceInfo.getMccmncsim();
            }
            if (this.mDeviceInfo.getStructuredUserAgent() != null) {
                try {
                    JSONObject json = this.mDeviceInfo.getStructuredUserAgent().toJson();
                    if (json != null) {
                        pNAdRequest.sua = Base64.encodeToString(json.toString().getBytes(), 2);
                    }
                } catch (Exception unused) {
                }
            }
            pNAdRequest.geofetch = "1";
        }
        if (!HyBid.isCoppaEnabled() && !z && !zIsCCPAOptOut && ((userDataManager2 = this.mUserDataManager) == null || !userDataManager2.isConsentDenied())) {
            pNAdRequest.age = HyBid.getAge();
            pNAdRequest.gender = HyBid.getGender();
            pNAdRequest.keywords = HyBid.getKeywords();
        }
        pNAdRequest.bundleid = HyBid.getBundleId();
        pNAdRequest.testMode = HyBid.isTestMode() ? "1" : "0";
        if (adSize == null) {
            pNAdRequest.af = getDefaultNativeAssetFields();
        } else {
            pNAdRequest.al = adSize.getAdLayoutSize();
            if (adSize.getWidth() != 0) {
                pNAdRequest.width = String.valueOf(adSize.getWidth());
            }
            if (adSize.getHeight() != 0) {
                pNAdRequest.height = String.valueOf(adSize.getHeight());
            }
        }
        pNAdRequest.mf = getDefaultMetaFields();
        String supportedProtocols = getSupportedProtocols();
        if (!TextUtils.isEmpty(supportedProtocols)) {
            pNAdRequest.protocol = supportedProtocols;
        }
        String supportedApis = getSupportedApis();
        if (!TextUtils.isEmpty(supportedApis)) {
            pNAdRequest.api = supportedApis;
        }
        pNAdRequest.displaymanager = this.mDisplayManager.getDisplayManager();
        pNAdRequest.displaymanagerver = this.mDisplayManager.getDisplayManagerVersion(str4, integrationType);
        HyBidLocationManager hyBidLocationManager = this.mLocationManager;
        if (hyBidLocationManager != null && (userLocation = hyBidLocationManager.getUserLocation()) != null && !HyBid.isCoppaEnabled() && !z && (((userDataManager = this.mUserDataManager) == null || !userDataManager.isConsentDenied()) && !zIsCCPAOptOut && HyBid.isLocationTrackingEnabled())) {
            pNAdRequest.latitude = String.format(Locale.ENGLISH, "%.2f", Double.valueOf(userLocation.getLatitude()));
            pNAdRequest.longitude = String.format(Locale.ENGLISH, "%.2f", Double.valueOf(userLocation.getLongitude()));
            if (userLocation.hasAccuracy() && userLocation.getAccuracy() != 0.0f) {
                pNAdRequest.addSignal(new GeoLocation(Integer.valueOf((int) userLocation.getAccuracy()), formatUTCTime()));
            }
        }
        Signal signalFillExtensionsObject = fillExtensionsObject(this.mDeviceInfo);
        if (signalFillExtensionsObject != null) {
            pNAdRequest.addSignal(signalFillExtensionsObject);
        }
        if (this.mIsRewarded) {
            pNAdRequest.rv = "1";
        } else {
            pNAdRequest.rv = "0";
        }
        pNAdRequest.impdepth = String.valueOf(num);
        try {
            pNAdRequest.ageofapp = new HyBidTimeUtils().getDaysSince(Long.parseLong(getAgeOfApp()));
        } catch (NumberFormatException unused2) {
        }
        pNAdRequest.sessionduration = new HyBidTimeUtils().getSeconds(calculateSessionDuration());
        TopicManager topicManager = this.mTopicManager;
        if (topicManager != null) {
            pNAdRequest.topics = topicManager.getTopics();
        }
        return pNAdRequest;
    }

    private String getAgeOfApp() {
        if (this.prefs == null) {
            this.prefs = new HyBidPreferences(this.mDeviceInfo.getContext());
        }
        return this.prefs.getAppFirstInstalledTime();
    }

    private long calculateSessionDuration() {
        if (this.prefs == null) {
            this.prefs = new HyBidPreferences(this.mDeviceInfo.getContext());
        }
        return System.currentTimeMillis() - this.prefs.getSessionTimeStamp();
    }

    @Override // net.pubnative.lite.sdk.models.AdRequestFactory
    public void setMediationVendor(String str) {
        this.mMediationVendor = str;
    }

    @Override // net.pubnative.lite.sdk.models.AdRequestFactory
    public void setIntegrationType(IntegrationType integrationType) {
        this.mIntegrationType = integrationType;
    }

    private String getDefaultMetaFields() {
        return TextUtils.join(StringUtils.COMMA, new String[]{APIMeta.POINTS, APIMeta.REVENUE_MODEL, APIMeta.CONTENT_INFO, APIMeta.CREATIVE_ID, APIMeta.CAMPAIGN_ID, "bundleid", APIMeta.AD_EXPERIENCE});
    }

    private String getDefaultNativeAssetFields() {
        return TextUtils.join(StringUtils.COMMA, new String[]{"icon", "title", "banner", "cta", "rating", "description"});
    }

    private String getSupportedProtocols() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add(Protocol.VAST_1_0_WRAPPER);
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add(Protocol.VAST_4_1);
        arrayList.add(Protocol.VAST_4_1_WRAPPER);
        arrayList.add(Protocol.VAST_4_2);
        arrayList.add(Protocol.VAST_4_2_WRAPPER);
        return TextUtils.join(StringUtils.COMMA, arrayList.toArray(new String[0]));
    }

    private String getSupportedApis() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("3");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        return TextUtils.join(StringUtils.COMMA, arrayList.toArray(new String[0]));
    }
}
