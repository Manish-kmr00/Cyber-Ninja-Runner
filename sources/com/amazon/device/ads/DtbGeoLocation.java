package com.amazon.device.ads;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.amazon.aps.ads.privacy.ApsPrivacyManager;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes3.dex */
class DtbGeoLocation {
    private static final float ACCURACY_IN_METERS_COARSE_PERMISSION_FIX_MODE = 2000.0f;
    private static final float ACCURACY_IN_METERS_FINE_PERMISSION_FIX_MODE = 1.0f;
    private static final int GEO_LOCATION_LAST_KNOWN_LOCATION_DURATION_IN_SECONDS = 86400;
    private static final String LOG_TAG = "DtbGeoLocation";
    private static final float THRESHOLD_DISTANCE_IN_KILOMETERS = 3.0f;
    private static final float[] distanceStandardInComputeMode = {111000.0f, 11100.0f, 1110.0f, 111.0f, 11.1f, 1.11f, 0.111f};

    DtbGeoLocation() {
        if (AdRegistration.getContext() != null) {
            return;
        }
        DtbLog.debugError(LOG_TAG, "unable to initialize DtbGeoLocation without setting app context");
        throw new IllegalArgumentException("unable to initialize DtbGeoLocation without setting app context");
    }

    public String getLocationParam() {
        Location locationRetrieveGeoLocationWithMode;
        if (!ApsPrivacyManager.INSTANCE.isSystemResourceAccessAllowed() || (locationRetrieveGeoLocationWithMode = retrieveGeoLocationWithMode()) == null) {
            return null;
        }
        long jCurrentTimeMillis = (System.currentTimeMillis() - locationRetrieveGeoLocationWithMode.getTime()) / 1000;
        if (jCurrentTimeMillis > 86400) {
            return null;
        }
        return locationRetrieveGeoLocationWithMode.getLatitude() + StringUtils.COMMA + locationRetrieveGeoLocationWithMode.getLongitude() + StringUtils.COMMA + locationRetrieveGeoLocationWithMode.getAccuracy() + StringUtils.COMMA + jCurrentTimeMillis;
    }

    Location retrieveGeoLocationWithMode() {
        try {
            DtbSharedPreferences dtbSharedPreferences = DtbSharedPreferences.getInstance();
            if (dtbSharedPreferences == null) {
                return null;
            }
            PrivacyLocationMode privacyLocationConfigMode = dtbSharedPreferences.getPrivacyLocationConfigMode();
            float privacyLocationConfigAccuracyInMeters = dtbSharedPreferences.getPrivacyLocationConfigAccuracyInMeters();
            long configTtlInMilliSeconds = DtbSharedPreferences.getInstance().getConfigTtlInMilliSeconds();
            long jLongValue = DtbSharedPreferences.getInstance().getConfigLastCheckIn().longValue();
            if (!DTBMetricsConfiguration.getInstance().isFeatureEnabled("config_check_in_ttl_feature_v2")) {
                configTtlInMilliSeconds = 172800000;
            }
            if (System.currentTimeMillis() - jLongValue > configTtlInMilliSeconds || !hasLocationPermission(AdRegistration.getContext())) {
                return null;
            }
            int i = AnonymousClass1.$SwitchMap$com$amazon$device$ads$PrivacyLocationMode[privacyLocationConfigMode.ordinal()];
            if (i == 1) {
                return getLocationInFixMode(privacyLocationConfigAccuracyInMeters);
            }
            if (i != 2) {
                return null;
            }
            return getLocationInComputeMode(privacyLocationConfigAccuracyInMeters);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute retrieveGeoLocationWithMode method", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: com.amazon.device.ads.DtbGeoLocation$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazon$device$ads$PrivacyLocationMode;

        static {
            int[] iArr = new int[PrivacyLocationMode.values().length];
            $SwitchMap$com$amazon$device$ads$PrivacyLocationMode = iArr;
            try {
                iArr[PrivacyLocationMode.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$PrivacyLocationMode[PrivacyLocationMode.COMPUTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$PrivacyLocationMode[PrivacyLocationMode.RESTRICTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    Location getLocationInFixMode(float f) {
        float f2;
        Context context = AdRegistration.getContext();
        if (hasLocationFinePermission(context)) {
            f2 = 1.0f;
        } else {
            f2 = hasLocationCoarsePermission(context) ? ACCURACY_IN_METERS_COARSE_PERMISSION_FIX_MODE : 0.0f;
        }
        if (f > f2) {
            return null;
        }
        return getLocation();
    }

    Location getLocationInComputeMode(float f) {
        Location location = getLocation();
        if (location == null) {
            return null;
        }
        float accuracy = location.getAccuracy();
        if (f <= accuracy) {
            return location;
        }
        float f2 = f - accuracy;
        for (int length = distanceStandardInComputeMode.length - 1; length >= 0; length--) {
            float[] fArr = distanceStandardInComputeMode;
            if (f2 <= fArr[length]) {
                BigDecimal bigDecimalValueOf = BigDecimal.valueOf(location.getLatitude());
                BigDecimal bigDecimalValueOf2 = BigDecimal.valueOf(location.getLongitude());
                BigDecimal scale = bigDecimalValueOf.setScale(length, RoundingMode.HALF_UP);
                BigDecimal scale2 = bigDecimalValueOf2.setScale(length, RoundingMode.HALF_UP);
                location.setLatitude(scale.doubleValue());
                location.setLongitude(scale2.doubleValue());
                location.setAccuracy(fArr[length]);
                return location;
            }
        }
        return null;
    }

    Location getLocation() {
        Context context = AdRegistration.getContext();
        Location lastLocation = getLastLocation(context, "gps");
        Location lastLocation2 = getLastLocation(context, "network");
        if (lastLocation == null || lastLocation2 == null) {
            if (lastLocation != null) {
                DtbLog.debug(LOG_TAG, "Setting location using gps, network not available");
                return lastLocation;
            }
            if (lastLocation2 == null) {
                return null;
            }
            DtbLog.debug(LOG_TAG, "Setting location using network, gps not available");
        } else if (lastLocation.distanceTo(lastLocation2) / 1000.0f <= 3.0f) {
            if ((lastLocation.hasAccuracy() ? lastLocation.getAccuracy() : Float.MAX_VALUE) < (lastLocation2.hasAccuracy() ? lastLocation2.getAccuracy() : Float.MAX_VALUE)) {
                DtbLog.debug(LOG_TAG, "Setting location using GPS determined by accuracy");
                return lastLocation;
            }
            DtbLog.debug(LOG_TAG, "Setting location using network determined by accuracy");
        } else {
            if (lastLocation.getTime() > lastLocation2.getTime()) {
                DtbLog.debug(LOG_TAG, "Setting location using GPS determined by time");
                return lastLocation;
            }
            DtbLog.debug(LOG_TAG, "Setting location using network determined by time");
        }
        return lastLocation2;
    }

    Location getLastLocation(Context context, String str) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager == null) {
            return null;
        }
        try {
            return locationManager.getLastKnownLocation(str);
        } catch (IllegalArgumentException unused) {
            DtbLog.warn(LOG_TAG, "Failed to retrieve location: " + str + "not found");
            return null;
        } catch (SecurityException unused2) {
            DtbLog.warn(LOG_TAG, "Failed to retrieve location: No permissions to access " + str);
            return null;
        }
    }

    private boolean hasLocationPermission(Context context) {
        return hasLocationFinePermission(context) || hasLocationCoarsePermission(context);
    }

    private boolean hasLocationFinePermission(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private boolean hasLocationCoarsePermission(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }
}
