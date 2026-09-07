package com.yandex.mobile.ads.impl;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes11.dex */
final class gt1 implements ke2, vn {
    private int j;
    private SurfaceTexture k;
    private byte[] n;
    private final AtomicBoolean b = new AtomicBoolean();
    private final AtomicBoolean c = new AtomicBoolean(true);
    private final fm1 d = new fm1();
    private final nc0 e = new nc0();
    private final a52<Long> f = new a52<>();
    private final a52<dm1> g = new a52<>();
    private final float[] h = new float[16];
    private final float[] i = new float[16];
    private volatile int l = 0;
    private int m = -1;

    public final void a(float[] fArr) {
        GLES20.glClear(16384);
        ne0.a();
        if (this.b.compareAndSet(true, false)) {
            SurfaceTexture surfaceTexture = this.k;
            surfaceTexture.getClass();
            surfaceTexture.updateTexImage();
            ne0.a();
            if (this.c.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.h, 0);
            }
            long timestamp = this.k.getTimestamp();
            Long lA = this.f.a(timestamp);
            if (lA != null) {
                this.e.a(lA.longValue(), this.h);
            }
            dm1 dm1VarB = this.g.b(timestamp);
            if (dm1VarB != null) {
                this.d.a(dm1VarB);
            }
        }
        Matrix.multiplyMM(this.i, 0, fArr, 0, this.h, 0);
        this.d.a(this.j, this.i);
    }

    public final SurfaceTexture a() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        ne0.a();
        this.d.a();
        ne0.a();
        this.j = ne0.b();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.j);
        this.k = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.yandex.mobile.ads.impl.gt1$$ExternalSyntheticLambda0
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                this.f$0.a(surfaceTexture2);
            }
        });
        return this.k;
    }

    @Override // com.yandex.mobile.ads.impl.vn
    public final void f() {
        this.f.a();
        this.e.a();
        this.c.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(SurfaceTexture surfaceTexture) {
        this.b.set(true);
    }

    @Override // com.yandex.mobile.ads.impl.vn
    public final void a(long j, float[] fArr) {
        this.e.b(j, fArr);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x005d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0087  */
    /* JADX WARN: Code duplicated, block: B:30:0x009c  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:41:0x0111  */
    /* JADX WARN: Code duplicated, block: B:43:0x0119  */
    @Override // com.yandex.mobile.ads.impl.ke2
    public final void a(long j, long j2, gc0 gc0Var, MediaFormat mediaFormat) {
        int i;
        float radians;
        float radians2;
        int i2;
        float f;
        float f2;
        float[] fArr;
        float[] fArr2;
        int i3;
        int i4;
        int i5;
        float f3;
        int i6;
        float f4;
        int i7;
        float f5;
        int i8;
        int i9;
        float f6;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        gt1 gt1Var = this;
        gt1Var.f.a(Long.valueOf(j), j2);
        byte[] bArr = gc0Var.w;
        int i16 = gc0Var.x;
        byte[] bArr2 = gt1Var.n;
        int i17 = gt1Var.m;
        gt1Var.n = bArr;
        if (i16 == -1) {
            i16 = gt1Var.l;
        }
        gt1Var.m = i16;
        if (i17 == i16 && Arrays.equals(bArr2, gt1Var.n)) {
            return;
        }
        byte[] bArr3 = gt1Var.n;
        dm1 dm1VarA = bArr3 != null ? em1.a(gt1Var.m, bArr3) : null;
        if (dm1VarA != null) {
            dm1.a aVar = dm1VarA.f8710a;
            dm1.a aVar2 = dm1VarA.b;
            if (aVar.b() != 1 || aVar.a().f8712a != 0 || aVar2.b() != 1 || aVar2.a().f8712a != 0) {
                i = gt1Var.m;
                radians = (float) Math.toRadians(180.0f);
                radians2 = (float) Math.toRadians(360.0f);
                f = radians / 36;
                f2 = radians2 / 72;
                fArr = new float[15984];
                fArr2 = new float[10656];
                i3 = 0;
                i4 = 0;
                i5 = 0;
                for (i2 = 36; i3 < i2; i2 = 36) {
                    float f7 = radians / 2.0f;
                    f3 = (i3 * f) - f7;
                    i6 = i3 + 1;
                    f4 = (i6 * f) - f7;
                    i7 = 0;
                    while (i7 < 73) {
                        f5 = f3;
                        int i18 = i6;
                        i8 = i5;
                        i9 = 0;
                        while (i9 < 2) {
                            if (i9 == 0) {
                                f6 = f5;
                            } else {
                                f6 = f4;
                            }
                            float f8 = i7 * f2;
                            float f9 = f2;
                            i10 = i7;
                            double d = 50.0f;
                            int i19 = i;
                            double d2 = (3.1415927f + f8) - (radians2 / 2.0f);
                            i11 = i9;
                            float f10 = f;
                            double d3 = f6;
                            int i20 = i3;
                            fArr[i4] = -((float) (Math.cos(d3) * Math.sin(d2) * d));
                            fArr[i4 + 1] = (float) (Math.sin(d3) * d);
                            i12 = i4 + 3;
                            fArr[i4 + 2] = (float) (Math.cos(d3) * Math.cos(d2) * d);
                            fArr2[i8] = f8 / radians2;
                            i13 = i8 + 2;
                            fArr2[i8 + 1] = ((i20 + i11) * f10) / radians;
                            if (i10 == 0 || i11 != 0) {
                                i14 = i10;
                                i15 = i11;
                                if (i14 == 72 || i15 != 1) {
                                    i4 = i12;
                                    i8 = i13;
                                }
                                i9 = i15 + 1;
                                i7 = i14;
                                f2 = f9;
                                i = i19;
                                f = f10;
                                i3 = i20;
                            } else {
                                i14 = i10;
                                i15 = i11;
                            }
                            System.arraycopy(fArr, i4, fArr, i12, 3);
                            i4 += 6;
                            System.arraycopy(fArr2, i8, fArr2, i13, 2);
                            i8 += 4;
                            i9 = i15 + 1;
                            i7 = i14;
                            f2 = f9;
                            i = i19;
                            f = f10;
                            i3 = i20;
                        }
                        i7++;
                        i5 = i8;
                        f3 = f5;
                        i6 = i18;
                        i = i;
                    }
                    i3 = i6;
                }
                dm1.a aVar3 = new dm1.a(new dm1.b(0, fArr, fArr2, 1));
                dm1VarA = new dm1(aVar3, aVar3, i);
                gt1Var = this;
            }
        } else {
            i = gt1Var.m;
            radians = (float) Math.toRadians(180.0f);
            radians2 = (float) Math.toRadians(360.0f);
            f = radians / 36;
            f2 = radians2 / 72;
            fArr = new float[15984];
            fArr2 = new float[10656];
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (i3 < i2) {
                float f11 = radians / 2.0f;
                f3 = (i3 * f) - f11;
                i6 = i3 + 1;
                f4 = (i6 * f) - f11;
                i7 = 0;
                while (i7 < 73) {
                    f5 = f3;
                    int i110 = i6;
                    i8 = i5;
                    i9 = 0;
                    while (i9 < 2) {
                        if (i9 == 0) {
                            f6 = f5;
                        } else {
                            f6 = f4;
                        }
                        float f12 = i7 * f2;
                        float f13 = f2;
                        i10 = i7;
                        double d4 = 50.0f;
                        int i111 = i;
                        double d5 = (3.1415927f + f12) - (radians2 / 2.0f);
                        i11 = i9;
                        float f14 = f;
                        double d6 = f6;
                        int i21 = i3;
                        fArr[i4] = -((float) (Math.cos(d6) * Math.sin(d5) * d4));
                        fArr[i4 + 1] = (float) (Math.sin(d6) * d4);
                        i12 = i4 + 3;
                        fArr[i4 + 2] = (float) (Math.cos(d6) * Math.cos(d5) * d4);
                        fArr2[i8] = f12 / radians2;
                        i13 = i8 + 2;
                        fArr2[i8 + 1] = ((i21 + i11) * f14) / radians;
                        if (i10 == 0) {
                            i14 = i10;
                            i15 = i11;
                            if (i14 == 72) {
                            }
                            i4 = i12;
                            i8 = i13;
                        } else {
                            i14 = i10;
                            i15 = i11;
                            if (i14 == 72) {
                            }
                            i4 = i12;
                            i8 = i13;
                        }
                        i9 = i15 + 1;
                        i7 = i14;
                        f2 = f13;
                        i = i111;
                        f = f14;
                        i3 = i21;
                    }
                    i7++;
                    i5 = i8;
                    f3 = f5;
                    i6 = i110;
                    i = i;
                }
                i3 = i6;
            }
            dm1.a aVar4 = new dm1.a(new dm1.b(0, fArr, fArr2, 1));
            dm1VarA = new dm1(aVar4, aVar4, i);
            gt1Var = this;
        }
        gt1Var.g.a(dm1VarA, j2);
    }

    public final void a(int i) {
        this.l = i;
    }
}
