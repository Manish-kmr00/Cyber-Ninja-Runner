package com.fyber.inneractive.sdk.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes10.dex */
public abstract class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f2305a;
    public static final Class b;
    public static final x1 c;
    public static final boolean d;
    public static final boolean e;
    public static final long f;
    public static final long g;
    public static final boolean h;

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a4 A[PHI: r3
  0x00a4: PHI (r3v21 java.lang.reflect.Field) = (r3v19 java.lang.reflect.Field), (r3v24 java.lang.reflect.Field) binds: [B:39:0x00b8, B:31:0x00a2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:33:0x00a6  */
    static {
        Unsafe unsafe;
        x1 w1Var;
        Field declaredField;
        Field field = null;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new t1());
        } catch (Throwable unused) {
            unsafe = null;
        }
        f2305a = unsafe;
        b = AbstractC3177d.f2279a;
        boolean zC = c(Long.TYPE);
        boolean zC2 = c(Integer.TYPE);
        if (unsafe == null) {
            w1Var = null;
        } else if (!AbstractC3177d.a()) {
            w1Var = new w1(unsafe);
        } else if (zC) {
            w1Var = new v1(unsafe);
        } else if (zC2) {
            w1Var = new u1(unsafe);
        } else {
            w1Var = null;
        }
        c = w1Var;
        d = w1Var == null ? false : w1Var.b();
        e = w1Var == null ? false : w1Var.a();
        f = a(byte[].class);
        a(boolean[].class);
        b(boolean[].class);
        a(int[].class);
        b(int[].class);
        a(long[].class);
        b(long[].class);
        a(float[].class);
        b(float[].class);
        a(double[].class);
        b(double[].class);
        a(Object[].class);
        b(Object[].class);
        if (AbstractC3177d.a()) {
            try {
                declaredField = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused2) {
                declaredField = null;
            }
            if (declaredField != null) {
                field = declaredField;
            } else {
                try {
                    declaredField = Buffer.class.getDeclaredField("address");
                } catch (Throwable unused3) {
                    declaredField = null;
                }
                if (declaredField != null && declaredField.getType() == Long.TYPE) {
                    field = declaredField;
                }
            }
        } else {
            declaredField = Buffer.class.getDeclaredField("address");
            if (declaredField != null) {
                field = declaredField;
            }
        }
        g = (field == null || w1Var == null) ? -1L : w1Var.f2303a.objectFieldOffset(field);
        h = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static int a(Class cls) {
        if (e) {
            return c.f2303a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static void b(Class cls) {
        if (e) {
            c.f2303a.arrayIndexScale(cls);
        }
    }

    public static int c(Object obj, long j) {
        return c.f2303a.getInt(obj, j);
    }

    public static long d(Object obj, long j) {
        return c.f2303a.getLong(obj, j);
    }

    public static Object e(Object obj, long j) {
        return c.f2303a.getObject(obj, j);
    }

    public static void a(Object obj, long j, int i) {
        c.f2303a.putInt(obj, j, i);
    }

    public static byte b(Object obj, long j) {
        return (byte) ((c(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean c(Class cls) {
        if (!AbstractC3177d.a()) {
            return false;
        }
        try {
            Class cls2 = b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void b(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        a(obj, j2, ((255 & b2) << i) | (c(obj, j2) & (~(255 << i))));
    }

    public static void a(Object obj, long j, long j2) {
        c.f2303a.putLong(obj, j, j2);
    }

    public static void a(long j, Object obj, Object obj2) {
        c.f2303a.putObject(obj, j, obj2);
    }

    public static byte a(Object obj, long j) {
        return (byte) ((c(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255);
    }

    public static void a(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int iC = c(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        a(obj, j2, ((255 & b2) << i) | (iC & (~(255 << i))));
    }

    public static void a(Throwable th) {
        Logger.getLogger(y1.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }
}
