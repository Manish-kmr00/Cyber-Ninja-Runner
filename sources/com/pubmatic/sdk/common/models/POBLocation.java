package com.pubmatic.sdk.common.models;

import android.location.Location;
import android.os.SystemClock;
import com.json.x8;
import com.pubmatic.sdk.common.log.POBLog;

/* JADX INFO: loaded from: classes7.dex */
public class POBLocation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f7584a;
    private float b;
    private double c;
    private double d;
    private Source e;

    public enum Source {
        GPS(1),
        IP_ADDRESS(2),
        USER(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f7585a;

        Source(int i) {
            this.f7585a = i;
        }

        public int getValue() {
            return this.f7585a;
        }
    }

    public POBLocation(Source source, double d, double d2) {
        this.e = source;
        this.c = d;
        this.d = d2;
    }

    public float getAccuracy() {
        return this.b;
    }

    public long getLastFixInMillis() {
        return this.f7584a;
    }

    public double getLatitude() {
        return this.c;
    }

    public double getLongitude() {
        return this.d;
    }

    public Source getSource() {
        return this.e;
    }

    public POBLocation(Location location) {
        if (location != null) {
            this.c = location.getLatitude();
            this.d = location.getLongitude();
            String provider = location.getProvider();
            if (provider != null && (provider.equalsIgnoreCase("network") || provider.equalsIgnoreCase("gps") || provider.equalsIgnoreCase(x8.b))) {
                this.e = Source.GPS;
            } else {
                this.e = Source.USER;
            }
            this.b = location.getAccuracy();
            this.f7584a = (SystemClock.elapsedRealtimeNanos() - location.getElapsedRealtimeNanos()) / 1000000;
            return;
        }
        POBLog.debug("POBLocation", "Provided location object is null", new Object[0]);
    }
}
