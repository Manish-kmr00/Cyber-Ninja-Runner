package com.yandex.mobile.ads.impl;

import android.graphics.Matrix;
import android.view.TextureView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes7.dex */
public final class of2 implements di1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private yy1 f9813a;
    private yy1 b;
    private TextureView c;
    private qf2 d;

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void a(uf2 videoSize) {
        Matrix matrixA;
        Intrinsics.checkNotNullParameter(videoSize, "videoSize");
        int iRoundToInt = videoSize.b;
        float f = videoSize.e;
        if (f > 0.0f) {
            iRoundToInt = MathKt.roundToInt(iRoundToInt * f);
        }
        yy1 yy1Var = new yy1(iRoundToInt, videoSize.c);
        this.f9813a = yy1Var;
        yy1 yy1Var2 = this.b;
        qf2 qf2Var = this.d;
        TextureView textureView = this.c;
        if (yy1Var2 == null || qf2Var == null || textureView == null || (matrixA = new pf2(yy1Var2, yy1Var).a(qf2Var)) == null) {
            return;
        }
        textureView.setTransform(matrixA);
    }

    @Override // com.yandex.mobile.ads.impl.di1.b
    public final void onSurfaceSizeChanged(int i, int i2) {
        Matrix matrixA;
        yy1 yy1Var = new yy1(i, i2);
        this.b = yy1Var;
        qf2 qf2Var = this.d;
        yy1 yy1Var2 = this.f9813a;
        TextureView textureView = this.c;
        if (yy1Var2 == null || qf2Var == null || textureView == null || (matrixA = new pf2(yy1Var, yy1Var2).a(qf2Var)) == null) {
            return;
        }
        textureView.setTransform(matrixA);
    }

    public final void a(qf2 qf2Var) {
        this.d = qf2Var;
        TextureView textureView = this.c;
        if (qf2Var == null || textureView == null) {
            return;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(0.0f, 0.0f, 0.0f, 0.0f);
        textureView.setTransform(matrix);
    }

    public final void a(TextureView textureView) {
        this.c = textureView;
        if (this.d == null || textureView == null) {
            return;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(0.0f, 0.0f, 0.0f, 0.0f);
        textureView.setTransform(matrix);
    }
}
