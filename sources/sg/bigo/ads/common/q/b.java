package sg.bigo.ads.common.q;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f13259a;
    public a b;
    public SensorManager c;
    public final List<Integer> f;
    long d = 0;
    final float[] e = new float[3];
    private final float h = 1.0E-9f;
    public SensorEventListener g = new SensorEventListener() { // from class: sg.bigo.ads.common.q.b.1
        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent == null || sensorEvent.sensor == null || sensorEvent.values.length < 3) {
                return;
            }
            int type = sensorEvent.sensor.getType();
            if (type != 4) {
                if (type == 9 || type == 1) {
                    b.this.b.a(type, sensorEvent.values, new float[3]);
                    return;
                }
                return;
            }
            float[] fArr = new float[3];
            if (b.this.d != 0) {
                float f = (sensorEvent.timestamp - b.this.d) * 1.0E-9f;
                float[] fArr2 = b.this.e;
                fArr2[0] = fArr2[0] + (sensorEvent.values[0] * f);
                float[] fArr3 = b.this.e;
                fArr3[1] = fArr3[1] + (sensorEvent.values[1] * f);
                float[] fArr4 = b.this.e;
                fArr4[2] = fArr4[2] + (sensorEvent.values[2] * f);
                float fAbs = Math.abs((float) Math.toDegrees(b.this.e[0]));
                float fAbs2 = Math.abs((float) Math.toDegrees(b.this.e[1]));
                float fAbs3 = Math.abs((float) Math.toDegrees(b.this.e[2]));
                fArr[0] = fAbs;
                fArr[1] = fAbs2;
                fArr[2] = fAbs3;
            }
            b.this.d = sensorEvent.timestamp;
            b.this.b.a(type, sensorEvent.values, fArr);
        }
    };

    public b(Context context, List<Integer> list, a aVar) {
        this.f13259a = new WeakReference<>(context);
        this.f = list;
        this.b = aVar;
    }
}
