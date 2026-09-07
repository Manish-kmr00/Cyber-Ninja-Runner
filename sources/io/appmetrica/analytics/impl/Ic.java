package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* JADX INFO: loaded from: classes5.dex */
public final class Ic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4598ym f11194a;
    public final C4598ym b;
    public final D4 c;
    public final PublicLogger d;
    public final String e;

    public Ic(String str, PublicLogger publicLogger) {
        this(new D4(30), new C4598ym(50, str.concat("map key"), publicLogger), new C4598ym(4000, str.concat("map value"), publicLogger), str, publicLogger);
    }

    public Ic(D4 d4, C4598ym c4598ym, C4598ym c4598ym2, String str, PublicLogger publicLogger) {
        this.c = d4;
        this.f11194a = c4598ym;
        this.b = c4598ym2;
        this.e = str;
        this.d = publicLogger;
    }
}
