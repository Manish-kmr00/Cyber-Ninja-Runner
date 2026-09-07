package com.safedk.android.analytics.brandsafety;

import com.safedk.android.analytics.events.MaxEvents;
import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes6.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f8115a = 50;
    public static final int b = 10;
    public static final int c = 30000;
    private static final String d = "MaxEventsManager";
    private static final Object e = new Object();
    private static p f;
    private MaxEvents g = new MaxEvents(50);
    private MaxEvents h = new MaxEvents(5);

    private p() {
    }

    public static p a() {
        p pVar;
        synchronized (e) {
            if (f == null) {
                f = new p();
            }
            pVar = f;
        }
        return pVar;
    }

    public synchronized void a(com.safedk.android.analytics.events.a aVar) {
        this.g.add(aVar);
    }

    public void b(com.safedk.android.analytics.events.a aVar) {
        Logger.d(d, "Adding MAX Will display event. #event is " + this.h.size() + ",  maxEvent=" + aVar.toString());
        this.h.add(aVar);
    }

    public MaxEvents b() {
        MaxEvents maxEventsD = d();
        return maxEventsD.size() >= 10 ? maxEventsD : a(10);
    }

    private synchronized MaxEvents d() {
        MaxEvents maxEvents;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Logger.d(d, "");
        maxEvents = new MaxEvents(50);
        for (com.safedk.android.analytics.events.a aVar : this.g) {
            if (jCurrentTimeMillis - (aVar.c() * 1000) < 30000) {
                Logger.d(d, "getEventFromLastInterval Adding max event ts = " + jCurrentTimeMillis + ", " + aVar.toString());
                maxEvents.add(aVar);
            }
        }
        return maxEvents;
    }

    public synchronized MaxEvents a(int i) {
        MaxEvents maxEvents;
        maxEvents = new MaxEvents(i);
        for (int size = this.g.size() < 10 ? 0 : this.g.size() - 10; size < this.g.size(); size++) {
            Logger.d(d, "getLastXEvents adding max event index " + size + " " + this.g.get(size).toString());
            maxEvents.add(new com.safedk.android.analytics.events.a(this.g.get(size)));
        }
        return maxEvents;
    }

    public MaxEvents c() {
        return this.h;
    }
}
