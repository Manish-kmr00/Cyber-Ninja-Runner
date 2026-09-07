package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.p1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3215p1 {
    public static void a(Object obj, Object obj2) {
        ((AbstractC3169a0) obj).unknownFields = (C3212o1) obj2;
    }

    public static boolean a(Object obj, T0 t0) throws C3211o0 {
        int iE = t0.e();
        int i = iE >>> 3;
        int i2 = iE & 7;
        if (i2 == 0) {
            ((C3212o1) obj).a(i << 3, Long.valueOf(t0.o()));
            return true;
        }
        if (i2 == 1) {
            ((C3212o1) obj).a((i << 3) | 1, Long.valueOf(t0.g()));
            return true;
        }
        if (i2 == 2) {
            ((C3212o1) obj).a((i << 3) | 2, t0.a());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                int i3 = C3211o0.f2292a;
                throw new C3208n0();
            }
            ((C3212o1) obj).a((i << 3) | 5, Integer.valueOf(t0.q()));
            return true;
        }
        C3212o1 c3212o1 = new C3212o1();
        int i4 = i << 3;
        int i5 = i4 | 4;
        while (t0.s() != Integer.MAX_VALUE && a((Object) c3212o1, t0)) {
        }
        if (i5 == t0.e()) {
            c3212o1.e = false;
            ((C3212o1) obj).a(i4 | 3, c3212o1);
            return true;
        }
        throw new C3211o0("Protocol message end-group tag did not match expected tag.");
    }
}
