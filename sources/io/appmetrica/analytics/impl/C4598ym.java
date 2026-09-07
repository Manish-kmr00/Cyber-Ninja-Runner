package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ym, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4598ym extends X2 {
    public C4598ym(int i, String str) {
        this(i, str, PublicLogger.getAnonymousInstance());
    }

    public final int b() {
        return this.f11412a;
    }

    public C4598ym(int i, String str, PublicLogger publicLogger) {
        super(i, str, publicLogger);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4200in
    public final String a(String str) {
        if (str != null) {
            int length = str.length();
            int i = this.f11412a;
            if (length > i) {
                String strSubstring = str.substring(0, i);
                this.c.warning("\"%s\" %s size exceeded limit of %d characters", this.b, str, Integer.valueOf(this.f11412a));
                return strSubstring;
            }
        }
        return str;
    }

    public final String a() {
        return this.b;
    }
}
