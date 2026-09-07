package com.amazon.device.ads;

import android.content.ContentResolver;
import android.provider.Settings;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;

/* JADX INFO: loaded from: classes10.dex */
public class DtbFireOSServiceAdapter {
    private static final String LOG_TAG = "DtbFireOSServiceAdapter";

    public static DtbFireOSServiceAdapter newAdapter() {
        return new DtbFireOSServiceAdapter();
    }

    private DtbFireOSServiceAdapter() {
    }

    public DtbGooglePlayServices.AdvertisingInfo getAdvertisingIdentifierInfo() {
        boolean z;
        try {
            ContentResolver contentResolver = AdRegistration.getContext().getContentResolver();
            int i = Settings.Secure.getInt(contentResolver, CommonUrlParts.LIMIT_AD_TRACKING);
            String string = Settings.Secure.getString(contentResolver, "advertising_id");
            String str = LOG_TAG;
            DtbLog.debug(str, " FireID retrieved : " + string);
            if (i != 0) {
                DtbLog.debug(str, " Fire device does not allow AdTracking,");
                z = true;
            } else {
                z = false;
            }
            DtbGooglePlayServices.AdvertisingInfo advertisingInfo = new DtbGooglePlayServices.AdvertisingInfo();
            advertisingInfo.setAdvertisingIdentifier(string);
            advertisingInfo.setLimitAdTrackingEnabled(Boolean.valueOf(z));
            return advertisingInfo;
        } catch (Settings.SettingNotFoundException e) {
            DtbLog.debug(LOG_TAG, " Advertising setting not found on this device " + e.getLocalizedMessage());
            return new DtbGooglePlayServices.AdvertisingInfo();
        } catch (Exception e2) {
            DtbLog.debug(LOG_TAG, " Attempt to retrieve fireID failed. Reason : " + e2.getLocalizedMessage());
            return new DtbGooglePlayServices.AdvertisingInfo();
        }
    }
}
