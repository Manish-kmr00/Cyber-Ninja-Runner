package com.pubmatic.sdk.common.utility;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import com.pubmatic.sdk.common.log.POBLog;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class POBLocationDetector implements LocationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f7635a;
    private Location b;
    private LocationManager c;
    private long d = 0;
    private long e = 600000;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7636a;

        static {
            int[] iArr = new int[b.values().length];
            f7636a = iArr;
            try {
                iArr[b.NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7636a[b.GPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7636a[b.PASSIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private enum b {
        NETWORK("network"),
        GPS("gps"),
        PASSIVE("passive");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7637a;

        b(String str) {
            this.f7637a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f7637a;
        }

        boolean a(Context context) {
            int i = a.f7636a[ordinal()];
            if (i == 1) {
                return POBUtils.hasPermission(context, "android.permission.ACCESS_FINE_LOCATION") || POBUtils.hasPermission(context, "android.permission.ACCESS_COARSE_LOCATION");
            }
            if (i == 2 || i == 3) {
                return POBUtils.hasPermission(context, "android.permission.ACCESS_FINE_LOCATION");
            }
            return false;
        }
    }

    public POBLocationDetector(Context context) {
        this.f7635a = context;
    }

    private void a() {
        LocationManager locationManagerA = a(this.f7635a);
        if (locationManagerA == null) {
            POBLog.info("PMLocationDetector", "Location Manager is not available to fetch GPS location", new Object[0]);
            return;
        }
        try {
            b bVar = b.NETWORK;
            if (!locationManagerA.isProviderEnabled(bVar.toString())) {
                bVar = b.GPS;
            }
            if (!bVar.a(this.f7635a)) {
                POBLog.info("PMLocationDetector", "No permission to fetch GPS location", new Object[0]);
                return;
            }
            try {
                POBLog.info("PMLocationDetector", "Requesting %s location", bVar.toString());
                locationManagerA.requestLocationUpdates(bVar.toString(), 0L, 0.0f, this);
            } catch (Exception e) {
                POBLog.info("PMLocationDetector", "Unable to request location updates. Error: %s", e.getMessage());
            }
        } catch (Exception e2) {
            POBLog.warn("PMLocationDetector", "Unable to check network provider status. Error : %s", e2.getMessage());
        }
    }

    private boolean b() {
        return this.d == 0 || SystemClock.elapsedRealtime() - this.d >= this.e;
    }

    private void c() {
        LocationManager locationManagerA = a(this.f7635a);
        if (locationManagerA != null) {
            try {
                locationManagerA.removeUpdates(this);
            } catch (Exception e) {
                POBLog.warn("PMLocationDetector", "Unable to remove location updates. Error : %s" + e.getMessage(), new Object[0]);
            }
        }
    }

    public Address getAddress() {
        Location location = getLocation();
        if (location == null) {
            return null;
        }
        try {
            List<Address> fromLocation = new Geocoder(this.f7635a, Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (fromLocation == null || fromLocation.isEmpty()) {
                return null;
            }
            return fromLocation.get(0);
        } catch (IOException unused) {
            return null;
        }
    }

    public String getISOAlpha2CountryCode() {
        Location location = getLocation();
        if (location == null) {
            return null;
        }
        try {
            List<Address> fromLocation = new Geocoder(this.f7635a, Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (fromLocation == null || fromLocation.isEmpty()) {
                return null;
            }
            return fromLocation.get(0).getCountryCode();
        } catch (IOException unused) {
            return null;
        }
    }

    public Location getLocation() {
        b bVar = b.GPS;
        if (!bVar.a(this.f7635a) && !b.NETWORK.a(this.f7635a)) {
            return null;
        }
        if (b()) {
            a();
            Location locationA = a(a(this.f7635a, bVar), a(this.f7635a, b.NETWORK));
            this.b = locationA;
            if (locationA == null) {
                this.b = a(this.f7635a, b.PASSIVE);
            }
            if (this.b != null) {
                this.d = SystemClock.elapsedRealtime();
            }
            c();
        }
        return this.b;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        POBLog.info("PMLocationDetector", "On location changed : %s on time : %s", location.toString(), Long.valueOf(location.getTime()));
        this.b = location;
        c();
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        POBLog.info("PMLocationDetector", "On location provider disabled", new Object[0]);
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        POBLog.info("PMLocationDetector", "On location provider enabled", new Object[0]);
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
        POBLog.info("PMLocationDetector", "On location provider status changed : %s", Integer.valueOf(i));
    }

    public void setLocationUpdateIntervalInMs(long j) {
        this.e = j;
    }

    private Location a(Context context, b bVar) {
        LocationManager locationManagerA;
        if (bVar.a(context) && (locationManagerA = a(context)) != null) {
            try {
                this.b = locationManagerA.getLastKnownLocation(bVar.toString());
            } catch (IllegalArgumentException e) {
                POBLog.error("PMLocationDetector", "Unable to fetch the location. Error : %s", e.getMessage());
            } catch (SecurityException unused) {
                POBLog.error("PMLocationDetector", "Unable to fetch the location as user has restricted/denied location access to this app.", new Object[0]);
            } catch (Exception e2) {
                POBLog.error("PMLocationDetector", "Unable to fetch the location due to unknown reason. Error : %s", e2.getMessage());
            }
        }
        return this.b;
    }

    private Location a(Location location, Location location2) {
        if (location == null) {
            return location2;
        }
        return (location2 != null && location.getTime() <= location2.getTime()) ? location2 : location;
    }

    private LocationManager a(Context context) {
        if (this.c == null) {
            try {
                this.c = (LocationManager) context.getSystemService("location");
            } catch (Exception e) {
                POBLog.warn("PMLocationDetector", "Unable to get location manager. Error : %s" + e.getMessage(), new Object[0]);
            }
        }
        return this.c;
    }
}
