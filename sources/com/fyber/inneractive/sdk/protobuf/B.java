package com.fyber.inneractive.sdk.protobuf;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes13.dex */
public abstract class B extends AbstractC3198k {
    public static final Logger b = Logger.getLogger(B.class.getName());
    public static final boolean c = y1.e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C f2250a;

    public static int a(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static long b(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int c(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int d(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract void a(byte b2);

    public abstract void a(int i, int i2);

    public abstract void a(int i, long j);

    public abstract void a(int i, E0 e0);

    public abstract void a(int i, E0 e0, U0 u0);

    public abstract void a(int i, AbstractC3221s abstractC3221s);

    public abstract void a(int i, boolean z);

    public abstract void a(String str, int i);

    public abstract void b(int i, int i2);

    public abstract void b(int i, long j);

    public abstract void b(int i, AbstractC3221s abstractC3221s);

    public abstract void c(int i, int i2);

    public abstract void c(long j);

    public abstract void d(int i, int i2);

    public abstract void d(long j);

    public abstract void e(int i);

    public abstract void f(int i);

    public abstract void g(int i);

    public static int a(int i) {
        if (i >= 0) {
            return c(i);
        }
        return 10;
    }

    public static int b(int i) {
        return c(i << 3);
    }

    public static int a(String str) {
        int length;
        try {
            length = E1.a(str);
        } catch (C1 unused) {
            length = str.getBytes(AbstractC3205m0.f2291a).length;
        }
        return c(length) + length;
    }

    public static int a(AbstractC3221s abstractC3221s) {
        int size = abstractC3221s.size();
        return c(size) + size;
    }

    public final void a(String str, C1 c1) throws C3235z {
        b.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) c1);
        byte[] bytes = str.getBytes(AbstractC3205m0.f2291a);
        try {
            g(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (C3235z e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new C3235z(e2);
        }
    }
}
