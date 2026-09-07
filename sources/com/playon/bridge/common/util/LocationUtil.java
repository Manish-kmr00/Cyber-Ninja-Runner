package com.playon.bridge.common.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.playon.bridge.common.Log;

/* JADX INFO: loaded from: classes5.dex */
public final class LocationUtil {
    private static final String ACCESS_COARSE_LOCATION_MSG = "Missing ACCESS_COARSE_LOCATION permission.";
    private static final String TAG = Log.makeTag("LocationUtil");

    private LocationUtil() {
    }

    public static void prefetchNetworkLocation(Context context) {
        if (context == null) {
            return;
        }
        try {
            final LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager == null || !locationManager.isProviderEnabled("network")) {
                return;
            }
            locationManager.requestLocationUpdates("network", 0L, 0.0f, new LocationListener() { // from class: com.playon.bridge.common.util.LocationUtil.1
                @Override // android.location.LocationListener
                public void onProviderEnabled(String str) {
                }

                @Override // android.location.LocationListener
                public void onStatusChanged(String str, int i, Bundle bundle) {
                }

                @Override // android.location.LocationListener
                public void onProviderDisabled(String str) {
                    locationManager.removeUpdates(this);
                }

                @Override // android.location.LocationListener
                public void onLocationChanged(Location location) {
                    locationManager.removeUpdates(this);
                }
            });
        } catch (SecurityException unused) {
            Log.d(TAG, ACCESS_COARSE_LOCATION_MSG);
        } catch (Exception e) {
            Log.w(TAG, "Prefetch network provider location exception: " + e);
        }
    }

    public static Location getLastKnownNetworkLocation(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return ((LocationManager) context.getSystemService("location")).getLastKnownLocation("network");
        } catch (SecurityException unused) {
            Log.d(TAG, ACCESS_COARSE_LOCATION_MSG);
            return null;
        }
    }

    public static boolean isAnyLocationProviderEnabled(Context context) {
        boolean zIsProviderEnabled;
        boolean zIsProviderEnabled2;
        if (context == null) {
            return false;
        }
        try {
            zIsProviderEnabled = ((LocationManager) context.getSystemService("location")).isProviderEnabled("gps");
        } catch (SecurityException e) {
            Log.d(TAG, "GPS permission exception: " + e);
            zIsProviderEnabled = false;
        }
        try {
            zIsProviderEnabled2 = ((LocationManager) context.getSystemService("location")).isProviderEnabled("network");
        } catch (SecurityException e2) {
            Log.d(TAG, "Network location permission exception: " + e2);
            zIsProviderEnabled2 = false;
        }
        return zIsProviderEnabled || zIsProviderEnabled2;
    }
}
