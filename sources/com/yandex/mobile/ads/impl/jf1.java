package com.yandex.mobile.ads.impl;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: loaded from: classes5.dex */
final class jf1 implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f9314a = new float[16];
    private final float[] b = new float[16];
    private final float[] c = new float[16];
    private final float[] d = new float[3];
    private final Display e;
    private final a[] f;
    private boolean g;

    public interface a {
        void a(float[] fArr, float f);
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public jf1(Display display, a... aVarArr) {
        this.e = display;
        this.f = aVarArr;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i;
        SensorManager.getRotationMatrixFromVector(this.f9314a, sensorEvent.values);
        float[] fArr = this.f9314a;
        int rotation = this.e.getRotation();
        if (rotation != 0) {
            int i2 = 129;
            if (rotation != 1) {
                i = 130;
                if (rotation != 2) {
                    if (rotation != 3) {
                        throw new IllegalStateException();
                    }
                    i2 = 130;
                    i = 1;
                }
            } else {
                i = 129;
                i2 = 2;
            }
            float[] fArr2 = this.b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.b, i2, i, fArr);
        }
        SensorManager.remapCoordinateSystem(this.f9314a, 1, Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, this.b);
        SensorManager.getOrientation(this.b, this.d);
        float f = this.d[2];
        Matrix.rotateM(this.f9314a, 0, 90.0f, 1.0f, 0.0f, 0.0f);
        float[] fArr3 = this.f9314a;
        if (!this.g) {
            nc0.a(this.c, fArr3);
            this.g = true;
        }
        float[] fArr4 = this.b;
        System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
        Matrix.multiplyMM(fArr3, 0, this.b, 0, this.c, 0);
        float[] fArr5 = this.f9314a;
        for (a aVar : this.f) {
            aVar.a(fArr5, f);
        }
    }
}
