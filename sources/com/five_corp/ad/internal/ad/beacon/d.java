package com.five_corp.ad.internal.ad.beacon;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f1269a;
    public final String b;
    public final a c;

    public d(e eVar, String str, a aVar) {
        this.f1269a = eVar;
        this.b = str;
        this.c = aVar;
    }

    public final String toString() {
        return "ExtraTrackingBeacon{extraTrackingEventType=" + this.f1269a + ", beaconCondition=" + String.valueOf(this.c) + ", url='" + this.b + "'}";
    }
}
