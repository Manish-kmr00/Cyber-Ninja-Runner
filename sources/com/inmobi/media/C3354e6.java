package com.inmobi.media;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import android.provider.Settings;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;
import com.unity3d.services.UnityAdsConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: renamed from: com.inmobi.media.e6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3354e6 implements LocationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3354e6 f3300a = new C3354e6();
    public static final LocationManager b;
    public static final HandlerThread c;
    public static GoogleApiClient d;
    public static final String e;
    public static boolean f;

    static {
        HandlerThread handlerThread = new HandlerThread("LThread");
        c = handlerThread;
        e = "e6";
        U3.a(handlerThread, "LThread");
        Context contextD = C3517pb.d();
        if (contextD != null) {
            Object systemService = contextD.getSystemService("location");
            b = systemService instanceof LocationManager ? (LocationManager) systemService : null;
        }
    }

    public static boolean c() {
        try {
            return AbstractC3599v9.a(C3517pb.d(), "android.permission.ACCESS_FINE_LOCATION") || AbstractC3599v9.a(C3517pb.d(), "android.permission.ACCESS_COARSE_LOCATION");
        } catch (Exception unused) {
            String TAG = e;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            return false;
        }
    }

    public static boolean e() {
        int i;
        Context contextD = C3517pb.d();
        if (contextD == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            LocationManager locationManager = b;
            return locationManager != null && locationManager.isLocationEnabled();
        }
        try {
            i = Settings.Secure.getInt(contextD.getContentResolver(), "location_mode");
        } catch (Settings.SettingNotFoundException unused) {
            i = 0;
        }
        return i != 0;
    }

    public final void a() {
        LocationManager locationManager = b;
        if (locationManager != null) {
            Criteria criteria = new Criteria();
            criteria.setBearingAccuracy(2);
            criteria.setPowerRequirement(2);
            criteria.setCostAllowed(false);
            String bestProvider = locationManager.getBestProvider(criteria, true);
            if (bestProvider != null) {
                Intrinsics.checkNotNullExpressionValue(e, "TAG");
                locationManager.requestSingleUpdate(bestProvider, this, c.getLooper());
            } else {
                String TAG = e;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            }
        }
        Unit unit = Unit.INSTANCE;
    }

    public final synchronized HashMap b() {
        HashMap map;
        Location result;
        Location locationA;
        map = new HashMap();
        String strH = C3517pb.f3400a.h();
        if (strH == null || C3601vb.a(strH).getLocationEnabled()) {
            try {
                if (e() && c()) {
                    if (f) {
                        try {
                            Context contextD = C3517pb.d();
                            Intrinsics.checkNotNull(contextD);
                            FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(contextD);
                            Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClient, "getFusedLocationProviderClient(...)");
                            Task<Location> lastLocation = fusedLocationProviderClient.getLastLocation();
                            Intrinsics.checkNotNullExpressionValue(lastLocation, "getLastLocation(...)");
                            result = lastLocation.getResult();
                        } catch (Exception unused) {
                            result = null;
                        } catch (IncompatibleClassChangeError e2) {
                            String TAG = e;
                            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                            e2.toString();
                            result = null;
                        }
                    } else {
                        result = null;
                    }
                    try {
                        locationA = (b == null || !AbstractC3599v9.a(C3517pb.d(), "android.permission.ACCESS_COARSE_LOCATION")) ? null : a(2, 2);
                    } catch (Exception unused2) {
                        String TAG2 = e;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    }
                } else {
                    result = null;
                    locationA = null;
                }
            } catch (Exception unused3) {
                result = null;
            }
            if (result == null && locationA == null) {
                String TAG3 = e;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                result = null;
            } else {
                if (result == null) {
                    String TAG4 = e;
                    Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                    Objects.toString(locationA);
                    if (locationA != null) {
                        locationA.getTime();
                    }
                } else if (locationA == null) {
                    String TAG5 = e;
                    Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                    result.toString();
                    result.getTime();
                } else {
                    long time = result.getTime() - locationA.getTime();
                    boolean z = time > UnityAdsConstants.Timeout.INIT_TIMEOUT_MS;
                    boolean z2 = time < -120000;
                    boolean z3 = time > 0;
                    if (z) {
                        String TAG6 = e;
                        Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
                        result.toString();
                        result.getTime();
                    } else if (z2) {
                        String TAG7 = e;
                        Intrinsics.checkNotNullExpressionValue(TAG7, "TAG");
                        locationA.toString();
                        locationA.getTime();
                    } else {
                        int accuracy = (int) (result.getAccuracy() - locationA.getAccuracy());
                        boolean z4 = accuracy > 0;
                        boolean z5 = accuracy < 0;
                        boolean z6 = accuracy > 200;
                        if (z5 || (z3 && !(z4 && z6))) {
                            String TAG8 = e;
                            Intrinsics.checkNotNullExpressionValue(TAG8, "TAG");
                            result.toString();
                            result.getTime();
                        } else {
                            String TAG9 = e;
                            Intrinsics.checkNotNullExpressionValue(TAG9, "TAG");
                            locationA.toString();
                            locationA.getTime();
                        }
                    }
                }
                result = locationA;
            }
        } else {
            result = null;
        }
        HashMap mapA = result != null ? a(result, true, AbstractC3599v9.a(C3517pb.d(), "android.permission.ACCESS_FINE_LOCATION") ? a(1, 3) : null) : a(I9.b(), false, null);
        for (Map.Entry entry : mapA.entrySet()) {
            map.put((String) entry.getKey(), entry.getValue().toString());
        }
        return map;
    }

    public final synchronized void d() {
        try {
            if (c() && e()) {
                a();
                try {
                    Reflection.getOrCreateKotlinClass(GoogleApiClient.class).getSimpleName();
                    Reflection.getOrCreateKotlinClass(FusedLocationProviderClient.class).getSimpleName();
                    Reflection.getOrCreateKotlinClass(LocationServices.class).getSimpleName();
                    a(C3517pb.d());
                } catch (NoClassDefFoundError unused) {
                }
            }
        } catch (Exception unused2) {
            String TAG = e;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        }
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        LocationManager locationManager;
        Intrinsics.checkNotNullParameter(location, "location");
        try {
            String TAG = e;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            location.getTime();
            location.getLatitude();
            location.getLongitude();
            location.getAccuracy();
            if (!c() || (locationManager = b) == null) {
                return;
            }
            locationManager.removeUpdates(this);
        } catch (Exception e2) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e2, "event"));
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public static void a(Context context) {
        try {
            GoogleApiClient googleApiClient = d;
            if (googleApiClient == null) {
                String TAG = e;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                Intrinsics.checkNotNull(context);
                GoogleApiClient googleApiClientBuild = new GoogleApiClient.Builder(context).addConnectionCallbacks(new C3340d6()).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() { // from class: com.inmobi.media.e6$$ExternalSyntheticLambda0
                    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
                    public final void onConnectionFailed(ConnectionResult connectionResult) {
                        C3354e6.a(connectionResult);
                    }
                }).addApi(LocationServices.API).build();
                d = googleApiClientBuild;
                if (googleApiClientBuild != null) {
                    googleApiClientBuild.connect();
                }
            } else {
                googleApiClient.connect();
            }
        } catch (Exception unused) {
            String TAG2 = e;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        }
    }

    public static final void a(ConnectionResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        f = false;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0056 A[DONT_INVERT, PHI: r1
  0x0056: PHI (r1v5 android.location.Location) = 
  (r1v3 android.location.Location)
  (r1v3 android.location.Location)
  (r1v3 android.location.Location)
  (r1v7 android.location.Location)
 binds: [B:30:0x0056, B:17:0x0047, B:19:0x004d, B:21:0x0053] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x0059 A[LOOP:0: B:15:0x003d->B:25:0x0059, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:37:0x005c A[EDGE_INSN: B:37:0x005c->B:27:0x005c BREAK  A[LOOP:0: B:15:0x003d->B:25:0x0059], SYNTHETIC] */
    public static Location a(int i, int i2) {
        String bestProvider;
        Location lastKnownLocation;
        Criteria criteria = new Criteria();
        criteria.setAccuracy(i);
        criteria.setPowerRequirement(i2);
        criteria.setCostAllowed(false);
        LocationManager locationManager = b;
        Location lastKnownLocation2 = null;
        if (locationManager != null && (bestProvider = locationManager.getBestProvider(criteria, true)) != null) {
            try {
                lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
            } catch (Exception unused) {
                lastKnownLocation = null;
            }
            if (lastKnownLocation != null || i == 1) {
                lastKnownLocation2 = lastKnownLocation;
            } else {
                LocationManager locationManager2 = b;
                if (locationManager2 != null) {
                    Intrinsics.checkNotNull(locationManager2);
                    List<String> providers = locationManager2.getProviders(true);
                    Intrinsics.checkNotNullExpressionValue(providers, "getProviders(...)");
                    int size = providers.size() - 1;
                    if (size >= 0) {
                        while (true) {
                            int i3 = size - 1;
                            String str = providers.get(size);
                            try {
                                LocationManager locationManager3 = b;
                                if (locationManager3 != null && locationManager3.isProviderEnabled(str)) {
                                    try {
                                        lastKnownLocation2 = locationManager3.getLastKnownLocation(str);
                                    } catch (SecurityException unused2) {
                                    }
                                    if (lastKnownLocation2 != null) {
                                        break;
                                    }
                                    if (i3 < 0) {
                                        break;
                                        break;
                                    }
                                    size = i3;
                                } else {
                                    if (i3 < 0) {
                                        break;
                                    }
                                    size = i3;
                                }
                            } catch (Exception unused3) {
                            }
                        }
                    }
                }
            }
        }
        String TAG = e;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        return lastKnownLocation2;
    }

    public static HashMap a(Location location, boolean z, Location location2) {
        HashMap map = new HashMap();
        Context contextD = C3517pb.d();
        if (contextD == null) {
            return map;
        }
        if (location != null) {
            if (location.getTime() > 0) {
                map.put("u-ll-ts", Long.valueOf(location.getTime()));
            }
            map.put("u-latlong-accu", new StringBuilder().append(location.getLatitude()).append(AbstractJsonLexerKt.COMMA).append(location.getLongitude()).append(AbstractJsonLexerKt.COMMA).append((int) location.getAccuracy()).toString());
            map.put("sdk-collected", Integer.valueOf(z ? 1 : 0));
        }
        String strH = C3517pb.f3400a.h();
        if (strH == null || C3601vb.a(strH).getLocationEnabled()) {
            map.put("loc-allowed", Integer.valueOf(e() ? 1 : 0));
        }
        if (location2 != null) {
            map.put("u-latlong-accu-fine", new StringBuilder().append(location2.getLatitude()).append(AbstractJsonLexerKt.COMMA).append(location2.getLongitude()).append(AbstractJsonLexerKt.COMMA).append((int) location2.getAccuracy()).toString());
            map.put("u-ll-ts-fine", Long.valueOf(location2.getTime()));
        }
        if (e() && c()) {
            if (AbstractC3599v9.a(contextD, "android.permission.ACCESS_COARSE_LOCATION")) {
                map.put("loc-granularity", "coarse");
            }
        } else {
            map.put("loc-granularity", "none");
        }
        return map;
    }
}
