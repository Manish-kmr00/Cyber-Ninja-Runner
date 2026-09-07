package com.applovin.impl;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes7.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SensorManager f410a = (SensorManager) com.applovin.impl.sdk.k.o().getSystemService("sensor");
    private Handler b;

    public f0() {
        HandlerThread handlerThread = new HandlerThread("AppLovinSdk:background_sensor_manager");
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper());
    }

    public Sensor a(int i) {
        return this.f410a.getDefaultSensor(i);
    }

    public void b(final SensorEventListener sensorEventListener, final Sensor sensor, final int i, final com.applovin.impl.sdk.o oVar) {
        this.b.post(new Runnable() { // from class: com.applovin.impl.f0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(sensorEventListener, sensor, i, oVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(SensorEventListener sensorEventListener, Sensor sensor, int i, com.applovin.impl.sdk.o oVar) {
        try {
            this.f410a.registerListener(sensorEventListener, sensor, i, this.b);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                oVar.a("BackgroundSensorManager", "Unable to register sensor listener", th);
            }
        }
    }

    public void b(final SensorEventListener sensorEventListener) {
        this.b.post(new Runnable() { // from class: com.applovin.impl.f0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(sensorEventListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(SensorEventListener sensorEventListener) {
        this.f410a.unregisterListener(sensorEventListener);
    }
}
