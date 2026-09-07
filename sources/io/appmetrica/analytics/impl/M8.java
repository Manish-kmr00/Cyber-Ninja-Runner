package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes5.dex */
public enum M8 {
    NONE(0),
    EXTERNALLY_ENCRYPTED_EVENT_CRYPTER(1),
    AES_VALUE_ENCRYPTION(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11256a;

    M8(int i) {
        this.f11256a = i;
    }

    public static M8 a(Integer num) {
        if (num != null) {
            for (M8 m8 : values()) {
                if (m8.f11256a == num.intValue()) {
                    return m8;
                }
            }
        }
        return NONE;
    }
}
