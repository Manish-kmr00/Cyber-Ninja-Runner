package com.json;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ironsource/bv;", "", "<init>", "()V", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class bv {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] b = {fe.Y, fe.b, fe.c, fe.d, fe.e, "bid", fe.h, fe.i, fe.j, fe.k, fe.f3694a, fe.N, fe.m, fe.q, fe.r, "make", "model", "os", "osv", fe.I, fe.v, fe.w, fe.x, fe.y, fe.z, fe.W, fe.d0, fe.O, fe.X, fe.n, fe.o, fe.p, fe.g, "lat", fe.Z, "md", fe.A, fe.C, fe.D, fe.J, fe.K, fe.L, "rt", fe.Q, fe.R, fe.U, fe.S, fe.V, "ua", fe.b0, fe.Q0, fe.F0, "auid", "idfi", fe.M0, fe.N0, "gpi", "icc", fe.T0, fe.U0, "carrier", "mcc", "mnc", "sid", fe.a1, "tz", fe.c1, "vpn", "debug", fe.l, fe.P, fe.f1, fe.g1, fe.G0, fe.c0, "stid", fe.s1, "do", "mt", fe.t1, fe.O0, fe.u1, fe.v1, fe.w1};

    /* JADX INFO: renamed from: com.ironsource.bv$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\tR&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/ironsource/bv$a;", "", "", "", "baseKeys", "[Ljava/lang/String;", "a", "()[Ljava/lang/String;", "getBaseKeys$annotations", "()V", "<init>", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void b() {
        }

        public final String[] a() {
            return bv.b;
        }
    }

    public static final String[] b() {
        return INSTANCE.a();
    }
}
