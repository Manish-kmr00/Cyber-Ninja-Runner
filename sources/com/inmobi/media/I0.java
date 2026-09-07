package com.inmobi.media;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class I0 extends Animation {
    public final float b;
    public final float c;
    public Camera e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f3092a = 90.0f;
    public final boolean d = true;

    public I0(float f, float f2) {
        this.b = f;
        this.c = f2;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f, Transformation t) {
        Intrinsics.checkNotNullParameter(t, "t");
        float f2 = ((this.f3092a - 0.0f) * f) + 0.0f;
        float f3 = this.b;
        float f4 = this.c;
        Camera camera = this.e;
        Matrix matrix = t.getMatrix();
        if (camera != null) {
            camera.save();
            if (this.d) {
                camera.translate(0.0f, 0.0f, f * 0.0f);
            } else {
                camera.translate(0.0f, 0.0f, (1.0f - f) * 0.0f);
            }
            camera.rotateX(f2);
            camera.getMatrix(matrix);
            camera.restore();
        }
        matrix.preTranslate(-f3, -f4);
        matrix.postTranslate(f3, f4);
    }

    @Override // android.view.animation.Animation
    public final void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.e = new Camera();
    }
}
