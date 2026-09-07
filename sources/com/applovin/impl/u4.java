package com.applovin.impl;

import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class u4 implements SensorEventListener, AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f710a;
    private final float b;
    private final f0 c;
    private final Sensor d;
    private final Sensor e;
    private final com.applovin.impl.sdk.k f;
    private float[] g;
    private float h;

    public u4(com.applovin.impl.sdk.k kVar) {
        this.f = kVar;
        f0 f0Var = new f0();
        this.c = f0Var;
        this.d = f0Var.a(9);
        this.e = f0Var.a(4);
        this.f710a = ((Integer) kVar.a(v4.e4)).intValue();
        this.b = ((Float) kVar.a(v4.d4)).floatValue();
    }

    public float a() {
        float[] fArr = this.g;
        if (fArr == null) {
            return 0.0f;
        }
        return (float) Math.toDegrees(Math.acos(fArr[2] / 9.81f));
    }

    public float b() {
        return this.h;
    }

    public void c() {
        if (Boolean.parseBoolean(this.f.o0().getExtraParameters().get("disable_sensor_data_collection"))) {
            return;
        }
        this.c.b(this);
        if (((Boolean) this.f.p0().a(v4.b4)).booleanValue()) {
            this.c.b(this, this.d, (int) TimeUnit.MILLISECONDS.toMicros(this.f710a), this.f.O());
        }
        if (((Boolean) this.f.p0().a(v4.c4)).booleanValue()) {
            this.c.b(this, this.e, (int) TimeUnit.MILLISECONDS.toMicros(this.f710a), this.f.O());
        }
        AppLovinBroadcastManager.unregisterReceiver(this);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.c.b(this);
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            c();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 9) {
            this.g = sensorEvent.values;
        } else if (sensorEvent.sensor.getType() == 4) {
            float f = this.h * this.b;
            this.h = f;
            this.h = f + Math.abs(sensorEvent.values[0]) + Math.abs(sensorEvent.values[1]) + Math.abs(sensorEvent.values[2]);
        }
    }
}
