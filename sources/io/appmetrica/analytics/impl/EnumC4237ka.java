package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ka, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public enum EnumC4237ka {
    UNKNOWN(0),
    FIRST_OCCURRENCE(1),
    NON_FIRST_OCCURENCE(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11635a;

    EnumC4237ka(int i) {
        this.f11635a = i;
    }

    public static EnumC4237ka a(Integer num) {
        if (num != null) {
            for (EnumC4237ka enumC4237ka : values()) {
                if (enumC4237ka.f11635a == num.intValue()) {
                    return enumC4237ka;
                }
            }
        }
        return UNKNOWN;
    }
}
