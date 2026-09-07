package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class Ei {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Revenue f11124a;
    public final C4548wm b;
    public final Em c;
    public final Em d;
    public final PublicLogger e;

    public Ei(Revenue revenue, PublicLogger publicLogger) {
        this.e = publicLogger;
        this.f11124a = revenue;
        this.b = new C4548wm(30720, "revenue payload", publicLogger);
        this.c = new Em(new C4548wm(184320, "receipt data", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
        this.d = new Em(new C4598ym(1000, "receipt signature", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
    }
}
