package com.mbridge.msdk.shake;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* JADX INFO: compiled from: ShakeSensorEventListener.java */
/* JADX INFO: loaded from: classes10.dex */
public abstract class b implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5407a = 0;
    public float b = 0.0f;
    public float c = 0.0f;
    public float d = 0.0f;
    private int e;
    private int f;

    public b(int i, int i2) {
        this.e = i;
        this.f = i2;
    }

    public abstract void a();

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0048  */
    /* JADX WARN: Code duplicated, block: B:16:0x0057  */
    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        long jCurrentTimeMillis;
        float[] fArr = sensorEvent.values;
        float f = -fArr[0];
        float f2 = -fArr[1];
        float f3 = -fArr[2];
        float f4 = this.b;
        if (f4 == 0.0f || Math.abs(f - f4) <= this.e) {
            float f5 = this.c;
            if (f5 == 0.0f || Math.abs(f2 - f5) <= this.e) {
                float f6 = this.d;
                if (f6 != 0.0f && Math.abs(f3 - f6) > this.e) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - this.f5407a > this.f) {
                        this.f5407a = jCurrentTimeMillis;
                        a();
                    }
                }
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.f5407a > this.f) {
                    this.f5407a = jCurrentTimeMillis;
                    a();
                }
            }
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f5407a > this.f) {
                this.f5407a = jCurrentTimeMillis;
                a();
            }
        }
        this.b = f;
        this.c = f2;
        this.d = f3;
    }
}
