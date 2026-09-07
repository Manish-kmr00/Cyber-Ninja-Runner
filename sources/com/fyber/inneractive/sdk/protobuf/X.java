package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes13.dex */
public final class X implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC3184f0 f2272a;
    public final int b;
    public final K1 c;
    public final boolean d;
    public final boolean e;

    public X(InterfaceC3184f0 interfaceC3184f0, int i, K1 k1, boolean z, boolean z2) {
        this.f2272a = interfaceC3184f0;
        this.b = i;
        this.c = k1;
        this.d = z;
        this.e = z2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.b - ((X) obj).b;
    }
}
