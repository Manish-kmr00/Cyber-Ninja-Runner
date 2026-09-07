package com.amazon.device.ads;

import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
class DtbGooglePlayServicesAdapter {
    DtbGooglePlayServicesAdapter() {
    }

    public static DtbGooglePlayServicesAdapter newAdapter() {
        return new DtbGooglePlayServicesAdapter();
    }

    public DtbGooglePlayServices.AdvertisingInfo getAdvertisingIdentifierInfo() {
        AdvertisingIdClient.Info advertisingIdInfo;
        try {
            advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(AdRegistration.getContext());
        } catch (GooglePlayServicesNotAvailableException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesNotAvailableException.", e);
            return DtbGooglePlayServices.AdvertisingInfo.createNotAvailable();
        } catch (GooglePlayServicesRepairableException e2) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesRepairableException.", e2);
            advertisingIdInfo = null;
        } catch (IOException e3) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Retrieving the Google Play Services Advertising Identifier caused an IOException.", e3);
            advertisingIdInfo = null;
        } catch (IllegalArgumentException e4) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Illegal Argument passed to getAdvertisingIdInfo", e4);
            advertisingIdInfo = null;
        } catch (IllegalStateException e5) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Retrieving the Google Play Services  caused Illegal State Exception ( be sure the call was made from a non-background thread).", e5);
            advertisingIdInfo = null;
        } catch (Exception e6) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Exception Occurred while retrieve Google Play Services Advertising Identifier", e6);
            advertisingIdInfo = null;
        }
        if (advertisingIdInfo == null) {
            DtbLog.debug("The Google Play Services Advertising Identifier could not be retrieved.");
            return new DtbGooglePlayServices.AdvertisingInfo();
        }
        DtbLog.debug("The Google Play Services Advertising Identifier was successfully retrieved.");
        String id = advertisingIdInfo.getId();
        boolean zIsLimitAdTrackingEnabled = advertisingIdInfo.isLimitAdTrackingEnabled();
        DtbLog.debug(" Retrieved google ad id " + advertisingIdInfo.getId() + " and tracking enabled : " + advertisingIdInfo.isLimitAdTrackingEnabled());
        return new DtbGooglePlayServices.AdvertisingInfo().setAdvertisingIdentifier(id).setLimitAdTrackingEnabled(Boolean.valueOf(zIsLimitAdTrackingEnabled));
    }
}
