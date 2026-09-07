package com.bytedance.sdk.openadsdk.yFO;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.os.Vibrator;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
public class SGo {
    public static WeakReference<pA> pA;
    protected static final float[] Og = new float[3];
    protected static final float[] KZx = new float[3];
    protected static final float[] ZZv = new float[9];
    protected static final float[] ML = new float[3];

    public static void pA(Context context, SensorEventListener sensorEventListener) {
    }

    public static void pA(pA pAVar) {
        pA = new WeakReference<>(pAVar);
    }

    public static void pA(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<pA> weakReference = pA;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th) {
            SD.pA("SensorHub", "startListenAccelerometer error", th);
        }
    }

    public static void Og(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<pA> weakReference = pA;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th) {
            SD.pA("SensorHub", "startListenGyroscope error", th);
        }
    }

    public static void KZx(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<pA> weakReference = pA;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th) {
            SD.pA("SensorHub", "startListenLinearAcceleration error", th);
        }
    }

    public static void ZZv(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<pA> weakReference = pA;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th) {
            SD.pA("SensorHub", "startListenRotationVector err", th);
        }
    }

    public static void pA(Context context, long j) {
        if (context == null) {
            return;
        }
        ((Vibrator) context.getSystemService("vibrator")).vibrate(j);
    }
}
