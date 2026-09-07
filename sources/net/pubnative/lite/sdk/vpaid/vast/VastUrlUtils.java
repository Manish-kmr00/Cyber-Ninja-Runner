package net.pubnative.lite.sdk.vpaid.vast;

import android.text.TextUtils;
import com.json.x8;
import java.util.Locale;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.models.VASTtag;

/* JADX INFO: loaded from: classes12.dex */
public class VastUrlUtils {
    public static String formatURL(String str) {
        boolean zIsCCPAOptOut;
        String str2;
        boolean zIsConsentDenied;
        String str3;
        String str4;
        if (HyBid.getUserDataManager() != null) {
            String str5 = HyBid.getUserDataManager().gdprApplies() ? "1" : "0";
            zIsCCPAOptOut = HyBid.getUserDataManager().isCCPAOptOut();
            zIsConsentDenied = HyBid.getUserDataManager().isConsentDenied();
            str2 = str5;
        } else {
            zIsCCPAOptOut = false;
            str2 = "0";
            zIsConsentDenied = false;
        }
        String str6 = (HyBid.isCoppaEnabled() || zIsCCPAOptOut || zIsConsentDenied || HyBid.getDeviceInfo().limitTracking() || TextUtils.isEmpty(HyBid.getDeviceInfo().getAdvertisingId())) ? "1" : "0";
        if (HyBid.getLocationManager() == null || HyBid.getLocationManager().getUserLocation() == null) {
            str3 = null;
            str4 = null;
        } else {
            str3 = HyBid.getLocationManager().getUserLocation().getLatitude() != 0.0d ? String.format(Locale.ENGLISH, "%.2f", Double.valueOf(HyBid.getLocationManager().getUserLocation().getLatitude())) : null;
            str4 = HyBid.getLocationManager().getUserLocation().getLongitude() != 0.0d ? String.format(Locale.ENGLISH, "%.2f", Double.valueOf(HyBid.getLocationManager().getUserLocation().getLongitude())) : null;
        }
        return getVastURL(str, HyBid.getDeviceInfo().getAdvertisingId(), HyBid.getBundleId(), str6, str3, str4, HyBid.getDeviceInfo().getUserAgent(), HyBid.getDeviceInfo().getDeviceWidth(), HyBid.getDeviceInfo().getDeviceHeight(), str2, HyBid.getUserDataManager().getIABGDPRConsentString(), HyBid.getUserDataManager().getIABUSPrivacyString());
    }

    private static String getVastURL(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        return new VASTtag.VASTtagBuilder(str).adId(str2).bundle(str3).connection(x8.b).dnt(str4).gdpr(str10).gdprConsent(str11).width(str8).height(str9).lat(str5).lon(str6).userAgent(str7).usPrivacy(str12).build().getFormattedURL();
    }
}
