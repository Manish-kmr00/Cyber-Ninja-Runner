package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes8.dex */
public abstract class Q1 {
    public static Object a(AbstractC3229w abstractC3229w, K1 k1, P1 p1) {
        switch (F1.f2255a[k1.ordinal()]) {
            case 1:
                return Double.valueOf(abstractC3229w.f());
            case 2:
                return Float.valueOf(abstractC3229w.j());
            case 3:
                return Long.valueOf(abstractC3229w.l());
            case 4:
                return Long.valueOf(abstractC3229w.v());
            case 5:
                return Integer.valueOf(abstractC3229w.k());
            case 6:
                return Long.valueOf(abstractC3229w.i());
            case 7:
                return Integer.valueOf(abstractC3229w.h());
            case 8:
                return Boolean.valueOf(abstractC3229w.d());
            case 9:
                return abstractC3229w.e();
            case 10:
                return Integer.valueOf(abstractC3229w.u());
            case 11:
                return Integer.valueOf(abstractC3229w.n());
            case 12:
                return Long.valueOf(abstractC3229w.o());
            case 13:
                return Integer.valueOf(abstractC3229w.p());
            case 14:
                return Long.valueOf(abstractC3229w.q());
            case 15:
                return p1.a(abstractC3229w);
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}
