package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes13.dex */
public final class Y extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E0 f2274a;
    public final Object b;
    public final E0 c;
    public final X d;

    public Y(E0 e0, Object obj, E0 e1, X x) {
        if (e0 == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
        if (x.c == K1.MESSAGE && e1 == null) {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        this.f2274a = e0;
        this.b = obj;
        this.c = e1;
        this.d = x;
    }
}
