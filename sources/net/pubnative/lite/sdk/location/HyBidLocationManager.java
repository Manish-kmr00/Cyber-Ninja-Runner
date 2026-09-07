package net.pubnative.lite.sdk.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.unity3d.services.UnityAdsConstants;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.utils.PNPermissionUtil;

/* JADX INFO: loaded from: classes6.dex */
public class HyBidLocationManager implements LocationListener {
    private static final int LOCATION_UPDATE_TIMEOUT = 10000;
    private static final String TAG = "HyBidLocationManager";
    private static final int TWO_MINUTES = 120000;
    private final Context mContext;
    private Location mCurrentBestLocation;
    private final LocationManager mManager;
    private final Runnable mStopUpdatesRunnable = new Runnable() { // from class: net.pubnative.lite.sdk.location.HyBidLocationManager$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.stopLocationUpdates();
        }
    };

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public HyBidLocationManager(Context context) {
        this.mManager = (LocationManager) context.getSystemService("location");
        this.mContext = context;
    }

    private Location getLastKnownNetworkLocation() {
        if (hasNetworkProvider()) {
            return this.mManager.getLastKnownLocation("network");
        }
        return null;
    }

    private boolean hasCoarsePermission() {
        return PNPermissionUtil.hasPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION");
    }

    private boolean hasPermission() {
        return hasCoarsePermission();
    }

    private boolean hasNetworkProvider() {
        LocationManager locationManager = this.mManager;
        return (locationManager == null || locationManager.getProvider("network") == null) ? false : true;
    }

    public void startLocationUpdates() {
        Handler handler = new Handler(Looper.getMainLooper());
        try {
            if (hasCoarsePermission() && hasNetworkProvider()) {
                handler.post(new Runnable() { // from class: net.pubnative.lite.sdk.location.HyBidLocationManager$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m9637x73be7283();
                    }
                });
            }
        } catch (Exception e) {
            Logger.e(TAG, "Can't request location updates: ".concat(String.valueOf(e.getMessage())));
        }
        handler.postDelayed(this.mStopUpdatesRunnable, 10000L);
    }

    /* JADX INFO: renamed from: lambda$startLocationUpdates$0$net-pubnative-lite-sdk-location-HyBidLocationManager, reason: not valid java name */
    /* synthetic */ void m9637x73be7283() {
        this.mManager.requestLocationUpdates("network", 0L, 0.0f, this);
    }

    public void stopLocationUpdates() {
        LocationManager locationManager = this.mManager;
        if (locationManager != null) {
            locationManager.removeUpdates(this);
        }
    }

    protected boolean isBetterLocation(Location location, Location location2) {
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > UnityAdsConstants.Timeout.INIT_TIMEOUT_MS;
        boolean z2 = time < -120000;
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = accuracy > 200;
        boolean zIsSameProvider = isSameProvider(location.getProvider(), location2.getProvider());
        if (z5) {
            return true;
        }
        if (!z3 || z4) {
            return z3 && !z6 && zIsSameProvider;
        }
        return true;
    }

    private boolean isSameProvider(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    private Location getLocationFromProviders() {
        Location lastKnownNetworkLocation = hasCoarsePermission() ? getLastKnownNetworkLocation() : null;
        if (lastKnownNetworkLocation != null) {
            return lastKnownNetworkLocation;
        }
        return null;
    }

    public Location getUserLocation() {
        if (!hasPermission()) {
            return null;
        }
        Location locationFromProviders = getLocationFromProviders();
        if (locationFromProviders != null && isBetterLocation(locationFromProviders, this.mCurrentBestLocation)) {
            this.mCurrentBestLocation = locationFromProviders;
        }
        Location location = this.mCurrentBestLocation;
        if (!HyBid.isLocationTrackingEnabled() || !HyBid.areLocationUpdatesEnabled()) {
            return location;
        }
        startLocationUpdates();
        return location;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (isBetterLocation(location, this.mCurrentBestLocation)) {
            this.mCurrentBestLocation = location;
            stopLocationUpdates();
        }
    }
}
