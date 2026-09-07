package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes9.dex */
public interface d40 {
    void a(e40.a aVar);

    void b(e40.a aVar);

    cv getCryptoConfig();

    a getError();

    UUID getSchemeUuid();

    int getState();

    default boolean playClearSamplesWithoutKeys() {
        return false;
    }

    Map<String, String> queryKeyStatus();

    boolean requiresSecureDecoder(String str);

    static void a(d40 d40Var, d40 d40Var2) {
        if (d40Var == d40Var2) {
            return;
        }
        if (d40Var2 != null) {
            d40Var2.b(null);
        }
        if (d40Var != null) {
            d40Var.a(null);
        }
    }

    public static class a extends IOException {
        public final int b;

        public a(Throwable th, int i) {
            super(th);
            this.b = i;
        }
    }
}
