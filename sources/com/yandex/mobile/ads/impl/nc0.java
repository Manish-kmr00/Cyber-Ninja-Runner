package com.yandex.mobile.ads.impl;

import android.opengl.Matrix;

/* JADX INFO: loaded from: classes10.dex */
final class nc0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f9720a = new float[16];
    private final float[] b = new float[16];
    private final a52<float[]> c = new a52<>();
    private boolean d;

    public final void b(long j, float[] fArr) {
        this.c.a(fArr, j);
    }

    public static void a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float f = fArr2[10];
        float f2 = fArr2[8];
        float fSqrt = (float) Math.sqrt((f2 * f2) + (f * f));
        float f3 = fArr2[10] / fSqrt;
        fArr[0] = f3;
        float f4 = fArr2[8];
        fArr[2] = f4 / fSqrt;
        fArr[8] = (-f4) / fSqrt;
        fArr[10] = f3;
    }

    public final void a(long j, float[] fArr) {
        float[] fArrB = this.c.b(j);
        if (fArrB == null) {
            return;
        }
        float[] fArr2 = this.b;
        float f = fArrB[0];
        float f2 = -fArrB[1];
        float f3 = -fArrB[2];
        float length = Matrix.length(f, f2, f3);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr2, 0, (float) Math.toDegrees(length), f / length, f2 / length, f3 / length);
        } else {
            Matrix.setIdentityM(fArr2, 0);
        }
        if (!this.d) {
            a(this.f9720a, this.b);
            this.d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f9720a, 0, this.b, 0);
    }

    public final void a() {
        this.c.a();
        this.d = false;
    }
}
