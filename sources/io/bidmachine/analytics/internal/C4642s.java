package io.bidmachine.analytics.internal;

/* JADX INFO: renamed from: io.bidmachine.analytics.internal.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C4642s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC4626b f12175a;
    private final C b;

    public C4642s(InterfaceC4626b interfaceC4626b, C c) {
        this.f12175a = interfaceC4626b;
        this.b = c;
    }

    public final byte[] a(byte[] bArr) {
        return this.f12175a.a(this.b.a(), bArr);
    }

    public final C a() {
        return this.b;
    }
}
