package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes11.dex */
public final class j12 extends GLSurfaceView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<b> f9278a;
    private final SensorManager b;
    private final Sensor c;
    private final jf1 d;
    private final Handler e;
    private final gt1 f;
    private SurfaceTexture g;
    private Surface h;
    private boolean i;
    private boolean j;
    private boolean k;

    public interface b {
        void a(Surface surface);

        void b();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.y, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public j12(Context context) {
        this(context, null);
    }

    public final ke2 b() {
        return this.f;
    }

    public final vn a() {
        return this.f;
    }

    public void setDefaultStereoMode(int i) {
        this.f.a(i);
    }

    public void setUseSensorRotation(boolean z) {
        this.i = z;
        d();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        this.j = true;
        d();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        this.j = false;
        d();
        super.onPause();
    }

    public j12(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9278a = new CopyOnWriteArrayList<>();
        this.e = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) hg.a(context.getSystemService("sensor"));
        this.b = sensorManager;
        Sensor defaultSensor = x82.f10629a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.c = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        gt1 gt1Var = new gt1();
        this.f = gt1Var;
        a aVar = new a(gt1Var);
        View.OnTouchListener m52Var = new m52(context, aVar);
        this.d = new jf1(((WindowManager) hg.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), m52Var, aVar);
        this.i = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(m52Var);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.j12$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Surface surface = this.h;
        if (surface != null) {
            Iterator<b> it = this.f9278a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
        SurfaceTexture surfaceTexture = this.g;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
        this.g = null;
        this.h = null;
    }

    private void d() {
        boolean z = this.i && this.j;
        Sensor sensor = this.c;
        if (sensor == null || z == this.k) {
            return;
        }
        if (z) {
            this.b.registerListener(this.d, sensor, 0);
        } else {
            this.b.unregisterListener(this.d);
        }
        this.k = z;
    }

    final class a implements GLSurfaceView.Renderer, m52.a, jf1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final gt1 f9279a;
        private final float[] d;
        private final float[] e;
        private final float[] f;
        private float g;
        private float h;
        private final float[] b = new float[16];
        private final float[] c = new float[16];
        private final float[] i = new float[16];
        private final float[] j = new float[16];

        public a(gt1 gt1Var) {
            float[] fArr = new float[16];
            this.d = fArr;
            float[] fArr2 = new float[16];
            this.e = fArr2;
            float[] fArr3 = new float[16];
            this.f = fArr3;
            this.f9279a = gt1Var;
            Matrix.setIdentityM(fArr, 0);
            Matrix.setIdentityM(fArr2, 0);
            Matrix.setIdentityM(fArr3, 0);
            this.h = 3.1415927f;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            j12.this.b(this.f9279a.a());
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
            float f = i / i2;
            Matrix.perspectiveM(this.b, 0, f > 1.0f ? (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f))) * 2.0d) : 90.0f, f, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.j, 0, this.d, 0, this.f, 0);
                Matrix.multiplyMM(this.i, 0, this.e, 0, this.j, 0);
            }
            Matrix.multiplyMM(this.c, 0, this.b, 0, this.i, 0);
            this.f9279a.a(this.c);
        }

        @Override // com.yandex.mobile.ads.impl.jf1.a
        public final synchronized void a(float[] fArr, float f) {
            float[] fArr2 = this.d;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            float f2 = -f;
            this.h = f2;
            Matrix.setRotateM(this.e, 0, -this.g, (float) Math.cos(f2), (float) Math.sin(this.h), 0.0f);
        }

        public final synchronized void a(PointF pointF) {
            float f = pointF.y;
            this.g = f;
            Matrix.setRotateM(this.e, 0, -f, (float) Math.cos(this.h), (float) Math.sin(this.h), 0.0f);
            Matrix.setRotateM(this.f, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        public final boolean a(MotionEvent motionEvent) {
            return j12.this.performClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final SurfaceTexture surfaceTexture) {
        this.e.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.j12$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(surfaceTexture);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.g;
        Surface surface = this.h;
        Surface surface2 = new Surface(surfaceTexture);
        this.g = surfaceTexture;
        this.h = surface2;
        Iterator<b> it = this.f9278a.iterator();
        while (it.hasNext()) {
            it.next().a(surface2);
        }
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
        }
        if (surface != null) {
            surface.release();
        }
    }
}
