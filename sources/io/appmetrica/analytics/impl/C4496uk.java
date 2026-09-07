package io.appmetrica.analytics.impl;

import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.uk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4496uk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Un f11805a;

    public C4496uk(Un un) {
        this.f11805a = un;
    }

    public final long a() {
        long jOptLong;
        Un un = this.f11805a;
        synchronized (un) {
            jOptLong = un.f11384a.a().optLong(SDKAnalyticsEvents.PARAMETER_SESSION_ID, -1L);
        }
        long j = jOptLong >= 10000000000L ? 1 + jOptLong : 10000000000L;
        this.f11805a.c(j);
        return j;
    }
}
