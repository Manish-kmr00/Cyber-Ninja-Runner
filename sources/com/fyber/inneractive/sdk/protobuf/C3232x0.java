package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.x0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3232x0 implements C0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0[] f2302a;

    public C3232x0(C0... c0Arr) {
        this.f2302a = c0Arr;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.C0
    public final boolean a(Class cls) {
        for (C0 c0 : this.f2302a) {
            if (c0.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.C0
    public final S0 b(Class cls) {
        for (C0 c0 : this.f2302a) {
            if (c0.a(cls)) {
                return c0.b(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
