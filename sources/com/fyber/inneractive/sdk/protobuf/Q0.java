package com.fyber.inneractive.sdk.protobuf;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public final class Q0 {
    public static final Q0 c = new Q0();
    public final ConcurrentHashMap b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3234y0 f2266a = new C3234y0();

    public final U0 a(Class cls) {
        U0 u0A;
        K0 k0;
        Class cls2;
        Charset charset = AbstractC3205m0.f2291a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        U0 u0 = (U0) this.b.get(cls);
        if (u0 != null) {
            return u0;
        }
        C3234y0 c3234y0 = this.f2266a;
        c3234y0.getClass();
        Class cls3 = V0.f2271a;
        if (!AbstractC3169a0.class.isAssignableFrom(cls) && (cls2 = V0.f2271a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        S0 s0B = c3234y0.f2304a.b(cls);
        if ((s0B.d & 2) == 2) {
            if (AbstractC3169a0.class.isAssignableFrom(cls)) {
                k0 = new K0(V0.d, K.f2260a, s0B.f2268a);
            } else {
                C3215p1 c3215p1 = V0.b;
                J j = K.b;
                if (j == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                k0 = new K0(c3215p1, j, s0B.f2268a);
            }
            u0A = k0;
        } else if (AbstractC3169a0.class.isAssignableFrom(cls)) {
            u0A = ((s0B.d & 1) == 1 ? P0.PROTO2 : P0.PROTO3) == P0.PROTO2 ? J0.a(s0B, M0.b, AbstractC3226u0.b, V0.d, K.f2260a, B0.b) : J0.a(s0B, M0.b, AbstractC3226u0.b, V0.d, (J) null, B0.b);
        } else {
            if (((s0B.d & 1) == 1 ? P0.PROTO2 : P0.PROTO3) == P0.PROTO2) {
                L0 l0 = M0.f2263a;
                C3222s0 c3222s0 = AbstractC3226u0.f2299a;
                C3215p1 c3215p2 = V0.b;
                J j2 = K.b;
                if (j2 == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                u0A = J0.a(s0B, l0, c3222s0, c3215p2, j2, B0.f2251a);
            } else {
                u0A = J0.a(s0B, M0.f2263a, AbstractC3226u0.f2299a, V0.c, (J) null, B0.f2251a);
            }
        }
        U0 u1 = (U0) this.b.putIfAbsent(cls, u0A);
        return u1 != null ? u1 : u0A;
    }
}
