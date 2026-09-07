package com.pgl.ssdk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.firebase.crashlytics.internal.common.IdManager;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class j0 implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static j0 f7518a;
    private SensorManager b;
    private int c;
    private int d = 0;
    private float[] e = new float[3];
    private List<String> f = new ArrayList();

    private j0(Context context) {
        this.b = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            try {
                this.b = (SensorManager) applicationContext.getSystemService("sensor");
            } catch (Throwable unused) {
            }
        }
    }

    public static j0 a(Context context) {
        if (f7518a == null) {
            synchronized (j0.class) {
                if (f7518a == null) {
                    f7518a = new j0(context);
                }
            }
        }
        return f7518a;
    }

    private synchronized void d() {
        try {
            SensorManager sensorManager = this.b;
            if (sensorManager != null) {
                if (this.c == 0) {
                    if (!this.b.registerListener(this, sensorManager.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.c++;
            }
        } catch (Exception unused) {
        }
    }

    private synchronized void e() {
        try {
            SensorManager sensorManager = this.b;
            if (sensorManager != null) {
                int i = this.c - 1;
                this.c = i;
                if (i == 0) {
                    sensorManager.unregisterListener(this);
                }
            }
        } catch (Exception unused) {
        }
    }

    public synchronized String b() {
        String strSubstring = "";
        int size = this.f.size();
        if (size <= 0) {
            return "";
        }
        if (size == 1) {
            return this.f.get(0);
        }
        try {
            List<String> list = this.f;
            int i = size - 10;
            if (i <= 0) {
                i = 0;
            }
            List<String> listSubList = list.subList(i, size);
            for (int i2 = 0; i2 < listSubList.size(); i2++) {
                strSubstring = strSubstring + listSubList.get(i2) + com.safedk.android.analytics.brandsafety.l.ad;
            }
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        } catch (Throwable unused) {
        }
        return strSubstring;
    }

    public String c() {
        String str;
        try {
            try {
                d();
                synchronized (this) {
                    int i = 0;
                    while (this.d == 0 && i < 10) {
                        i++;
                        wait(100L);
                    }
                }
                DecimalFormat decimalFormat = new DecimalFormat(IdManager.DEFAULT_VERSION_NAME);
                str = decimalFormat.format(this.e[0]) + StringUtils.COMMA + decimalFormat.format(this.e[1]) + StringUtils.COMMA + decimalFormat.format(this.e[2]);
            } catch (Throwable unused) {
                DecimalFormat decimalFormat2 = new DecimalFormat(IdManager.DEFAULT_VERSION_NAME);
                str = decimalFormat2.format(this.e[0]) + StringUtils.COMMA + decimalFormat2.format(this.e[1]) + StringUtils.COMMA + decimalFormat2.format(this.e[2]);
            }
        } catch (Throwable unused2) {
            str = null;
        }
        e();
        this.d = 0;
        return str;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.e = sensorEvent.values;
        this.d = 1;
    }

    public void a() {
        String strC = c();
        if (strC == null) {
            return;
        }
        this.f.add(strC);
        try {
            int size = this.f.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.f.subList(size - 10, size));
                this.f.clear();
                this.f = arrayList;
            }
        } catch (Throwable unused) {
        }
    }
}
