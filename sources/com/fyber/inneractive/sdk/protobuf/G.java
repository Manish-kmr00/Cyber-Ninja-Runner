package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes13.dex */
public final class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2256a;
    public final int b;

    public G(int i, Object obj) {
        this.f2256a = obj;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof G)) {
            return false;
        }
        G g = (G) obj;
        return this.f2256a == g.f2256a && this.b == g.b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f2256a) * 65535) + this.b;
    }
}
