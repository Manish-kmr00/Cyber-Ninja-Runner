package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes5.dex */
public final class L8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Jc f11240a;
    public final Jc b;

    public L8() {
        this(new C4011b8(), new S9(), new C4002b());
    }

    public L8(C4011b8 c4011b8, S9 s9, C4002b c4002b) {
        Jc jc = new Jc(c4011b8);
        this.f11240a = jc;
        jc.a(M8.NONE, c4011b8);
        jc.a(M8.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER, s9);
        jc.a(M8.AES_VALUE_ENCRYPTION, c4002b);
        this.b = new Jc(c4011b8);
    }
}
