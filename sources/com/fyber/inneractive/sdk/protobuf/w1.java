package com.fyber.inneractive.sdk.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes10.dex */
public final class w1 extends x1 {
    public w1(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final boolean a() {
        if (!super.a()) {
            return false;
        }
        try {
            Class<?> cls = this.f2303a.getClass();
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            y1.a(th);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003c A[PHI: r2
  0x003c: PHI (r2v9 java.lang.reflect.Field) = (r2v5 java.lang.reflect.Field), (r2v12 java.lang.reflect.Field) binds: [B:19:0x0050, B:11:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:13:0x003e  */
    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final boolean b() {
        Field declaredField;
        Unsafe unsafe = this.f2303a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getLong", Object.class, cls2);
                Field field = null;
                if (AbstractC3177d.a()) {
                    try {
                        declaredField = Buffer.class.getDeclaredField("effectiveDirectAddress");
                    } catch (Throwable unused) {
                        declaredField = null;
                    }
                    if (declaredField != null) {
                        field = declaredField;
                    } else {
                        try {
                            declaredField = Buffer.class.getDeclaredField("address");
                        } catch (Throwable unused2) {
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
                if (field != null) {
                    try {
                        Class<?> cls3 = this.f2303a.getClass();
                        cls3.getMethod("getByte", cls2);
                        cls3.getMethod("putByte", cls2, Byte.TYPE);
                        cls3.getMethod("getInt", cls2);
                        cls3.getMethod("putInt", cls2, Integer.TYPE);
                        cls3.getMethod("getLong", cls2);
                        cls3.getMethod("putLong", cls2, cls2);
                        cls3.getMethod("copyMemory", cls2, cls2, cls2);
                        cls3.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                        return true;
                    } catch (Throwable th) {
                        y1.a(th);
                        return false;
                    }
                }
            } catch (Throwable th2) {
                y1.a(th2);
            }
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final double c(Object obj, long j) {
        return this.f2303a.getDouble(obj, j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final float d(Object obj, long j) {
        return this.f2303a.getFloat(obj, j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final void a(Object obj, long j, byte b) {
        this.f2303a.putByte(obj, j, b);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final boolean a(Object obj, long j) {
        return this.f2303a.getBoolean(obj, j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final void a(Object obj, long j, boolean z) {
        this.f2303a.putBoolean(obj, j, z);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final void a(Object obj, long j, float f) {
        this.f2303a.putFloat(obj, j, f);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final void a(Object obj, long j, double d) {
        this.f2303a.putDouble(obj, j, d);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final byte a(long j) {
        return this.f2303a.getByte(j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final void a(long j, byte[] bArr, long j2) {
        this.f2303a.copyMemory((Object) null, j, bArr, y1.f, j2);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final byte b(Object obj, long j) {
        return this.f2303a.getByte(obj, j);
    }
}
