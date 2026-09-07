package io.bidmachine.iab.utils;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes13.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final Interpolator g = new LinearInterpolator();
    private static final Interpolator h = new a();
    private static final int[] i = {ViewCompat.MEASURED_STATE_MASK};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f12232a;
    final d b;
    private float c;
    private Animator d;
    private float e;
    private boolean f;

    class a implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float[] f12233a = {0.0f, 1.0E-4f, 2.0E-4f, 5.0E-4f, 9.0E-4f, 0.0014f, 0.002f, 0.0027f, 0.0036f, 0.0046f, 0.0058f, 0.0071f, 0.0085f, 0.0101f, 0.0118f, 0.0137f, 0.0158f, 0.018f, 0.0205f, 0.0231f, 0.0259f, 0.0289f, 0.0321f, 0.0355f, 0.0391f, 0.043f, 0.0471f, 0.0514f, 0.056f, 0.0608f, 0.066f, 0.0714f, 0.0771f, 0.083f, 0.0893f, 0.0959f, 0.1029f, 0.1101f, 0.1177f, 0.1257f, 0.1339f, 0.1426f, 0.1516f, 0.161f, 0.1707f, 0.1808f, 0.1913f, 0.2021f, 0.2133f, 0.2248f, 0.2366f, 0.2487f, 0.2611f, 0.2738f, 0.2867f, 0.2998f, 0.3131f, 0.3265f, 0.34f, 0.3536f, 0.3673f, 0.381f, 0.3946f, 0.4082f, 0.4217f, 0.4352f, 0.4485f, 0.4616f, 0.4746f, 0.4874f, 0.5f, 0.5124f, 0.5246f, 0.5365f, 0.5482f, 0.5597f, 0.571f, 0.582f, 0.5928f, 0.6033f, 0.6136f, 0.6237f, 0.6335f, 0.6431f, 0.6525f, 0.6616f, 0.6706f, 0.6793f, 0.6878f, 0.6961f, 0.7043f, 0.7122f, 0.7199f, 0.7275f, 0.7349f, 0.7421f, 0.7491f, 0.7559f, 0.7626f, 0.7692f, 0.7756f, 0.7818f, 0.7879f, 0.7938f, 0.7996f, 0.8053f, 0.8108f, 0.8162f, 0.8215f, 0.8266f, 0.8317f, 0.8366f, 0.8414f, 0.8461f, 0.8507f, 0.8551f, 0.8595f, 0.8638f, 0.8679f, 0.872f, 0.876f, 0.8798f, 0.8836f, 0.8873f, 0.8909f, 0.8945f, 0.8979f, 0.9013f, 0.9046f, 0.9078f, 0.9109f, 0.9139f, 0.9169f, 0.9198f, 0.9227f, 0.9254f, 0.9281f, 0.9307f, 0.9333f, 0.9358f, 0.9382f, 0.9406f, 0.9429f, 0.9452f, 0.9474f, 0.9495f, 0.9516f, 0.9536f, 0.9556f, 0.9575f, 0.9594f, 0.9612f, 0.9629f, 0.9646f, 0.9663f, 0.9679f, 0.9695f, 0.971f, 0.9725f, 0.9739f, 0.9753f, 0.9766f, 0.9779f, 0.9791f, 0.9803f, 0.9815f, 0.9826f, 0.9837f, 0.9848f, 0.9858f, 0.9867f, 0.9877f, 0.9885f, 0.9894f, 0.9902f, 0.991f, 0.9917f, 0.9924f, 0.9931f, 0.9937f, 0.9944f, 0.9949f, 0.9955f, 0.996f, 0.9964f, 0.9969f, 0.9973f, 0.9977f, 0.998f, 0.9984f, 0.9986f, 0.9989f, 0.9991f, 0.9993f, 0.9995f, 0.9997f, 0.9998f, 0.9999f, 0.9999f, 1.0f, 1.0f};
        private final float b = 1.0f / 200;

        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f >= 1.0f) {
                return 1.0f;
            }
            if (f <= 0.0f) {
                return 0.0f;
            }
            float[] fArr = this.f12233a;
            int iMin = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
            float f2 = this.b;
            float f3 = (f - (iMin * f2)) / f2;
            float[] fArr2 = this.f12233a;
            float f4 = fArr2[iMin];
            return f4 + (f3 * (fArr2[iMin + 1] - f4));
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f12234a;

        b(d dVar) {
            this.f12234a = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            CircularProgressDrawable.this.b(fFloatValue, this.f12234a);
            CircularProgressDrawable.this.a(fFloatValue, this.f12234a, false);
            CircularProgressDrawable.this.invalidateSelf();
        }
    }

    class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f12235a;

        c(d dVar) {
            this.f12235a = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            CircularProgressDrawable.this.a(1.0f, this.f12235a, true);
            this.f12235a.m();
            this.f12235a.k();
            if (!CircularProgressDrawable.this.f) {
                CircularProgressDrawable.this.e += 1.0f;
            } else {
                CircularProgressDrawable.this.f = false;
                animator.cancel();
                animator.setDuration(1332L);
                animator.start();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            CircularProgressDrawable.this.e = 0.0f;
        }
    }

    static class d {
        final Paint b;
        final Paint c;
        final Paint d;
        final Paint e;
        int[] j;
        int k;
        float l;
        float m;
        float n;
        float o;
        int q;
        float f = 0.0f;
        float g = 0.0f;
        float h = 0.0f;
        float i = 5.0f;
        int p = 255;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final RectF f12236a = new RectF();

        d() {
            Paint paint = new Paint();
            this.b = paint;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.c = paint2;
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.d = paint3;
            paint3.setColor(0);
            Paint paint4 = new Paint();
            this.e = paint4;
            paint4.setColor(0);
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f12236a;
            float f = this.o;
            float fMin = (this.i / 2.0f) + f;
            if (f <= 0.0f) {
                fMin = (Math.min(rect.width(), rect.height()) / 2.0f) - (this.i / 2.0f);
            }
            rectF.set(rect.centerX() - fMin, rect.centerY() - fMin, rect.centerX() + fMin, rect.centerY() + fMin);
            float f2 = this.f;
            float f3 = this.h;
            float f4 = (f2 + f3) * 360.0f;
            float f5 = ((this.g + f3) * 360.0f) - f4;
            this.b.setColor(this.q);
            this.b.setAlpha(this.p);
            float f6 = this.i / 2.0f;
            rectF.inset(f6, f6);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.d);
            float f7 = -f6;
            rectF.inset(f7, f7);
            canvas.drawArc(rectF, f4, f5, false, this.b);
        }

        int b() {
            return this.d.getColor();
        }

        float c() {
            return this.g;
        }

        int d() {
            return this.j[e()];
        }

        int e() {
            return (this.k + 1) % this.j.length;
        }

        float f() {
            return this.f;
        }

        int g() {
            return this.j[this.k];
        }

        float h() {
            return this.m;
        }

        float i() {
            return this.n;
        }

        float j() {
            return this.l;
        }

        void k() {
            d(e());
        }

        void l() {
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 0.0f;
            d(0.0f);
            b(0.0f);
            c(0.0f);
        }

        void m() {
            this.l = this.f;
            this.m = this.g;
            this.n = this.h;
        }

        int a() {
            return this.p;
        }

        void b(int i) {
            this.d.setColor(i);
        }

        void c(int i) {
            this.q = i;
        }

        void d(int i) {
            this.k = i;
            this.q = this.j[i];
        }

        void e(float f) {
            this.i = f;
            this.b.setStrokeWidth(f);
        }

        void a(int i) {
            this.p = i;
        }

        void b(float f) {
            this.g = f;
        }

        void c(float f) {
            this.h = f;
        }

        void d(float f) {
            this.f = f;
        }

        void a(float f) {
            this.o = f;
        }

        void a(ColorFilter colorFilter) {
            this.b.setColorFilter(colorFilter);
        }

        void a(int[] iArr) {
            this.j = iArr;
            d(0);
        }

        void a(Paint.Cap cap) {
            this.b.setStrokeCap(cap);
        }
    }

    public CircularProgressDrawable(Context context) {
        this.f12232a = context.getResources();
        d dVar = new d();
        this.b = dVar;
        dVar.a(i);
        setStrokeWidth(2.5f);
        a();
    }

    private int a(float f, int i2, int i3) {
        int i4 = (i2 >> 24) & 255;
        int i5 = (i2 >> 16) & 255;
        int i6 = (i2 >> 8) & 255;
        int i7 = i2 & 255;
        return ((i4 + ((int) ((((i3 >> 24) & 255) - i4) * f))) << 24) | ((i5 + ((int) ((((i3 >> 16) & 255) - i5) * f))) << 16) | ((i6 + ((int) ((((i3 >> 8) & 255) - i6) * f))) << 8) | (i7 + ((int) (f * ((i3 & 255) - i7))));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.c, bounds.exactCenterX(), bounds.exactCenterY());
        this.b.a(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.b.a();
    }

    public int getBackgroundColor() {
        return this.b.b();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getStrokeWidth() {
        return this.b.i;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.d.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.b.a(alpha);
        invalidateSelf();
    }

    public void setBackgroundColor(int color) {
        this.b.b(color);
        invalidateSelf();
    }

    public void setCenterRadius(float centerRadius) {
        this.b.a(centerRadius);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.a(colorFilter);
        invalidateSelf();
    }

    public void setColorSchemeColors(int... colors) {
        this.b.a(colors);
        this.b.d(0);
        invalidateSelf();
    }

    public void setStrokeCap(Paint.Cap strokeCap) {
        this.b.a(strokeCap);
        invalidateSelf();
    }

    public void setStrokeWidth(float strokeWidth) {
        this.b.e(strokeWidth);
        invalidateSelf();
    }

    public void setStyle(int size) {
        float f;
        float f2;
        float f3;
        float f4;
        if (size == 0) {
            f = 12.0f;
            f2 = 6.0f;
            f3 = 11.0f;
            f4 = 3.0f;
        } else {
            f = 10.0f;
            f2 = 5.0f;
            f3 = 7.5f;
            f4 = 2.5f;
        }
        a(f3, f4, f, f2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Animator animator;
        long j;
        this.d.cancel();
        this.b.m();
        if (this.b.c() != this.b.f()) {
            this.f = true;
            animator = this.d;
            j = 666;
        } else {
            this.b.d(0);
            this.b.l();
            animator = this.d;
            j = 1332;
        }
        animator.setDuration(j);
        this.d.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.d.cancel();
        a(0.0f);
        this.b.d(0);
        this.b.l();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f, d dVar) {
        dVar.c(f > 0.75f ? a((f - 0.75f) / 0.25f, dVar.g(), dVar.d()) : dVar.g());
    }

    private void a(float f, d dVar) {
        b(f, dVar);
        float fFloor = (float) (Math.floor(dVar.i() / 0.8f) + 1.0d);
        dVar.d(dVar.j() + (((dVar.h() - 0.01f) - dVar.j()) * f));
        dVar.b(dVar.h());
        dVar.c(dVar.i() + ((fFloor - dVar.i()) * f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, d dVar, boolean z) {
        float interpolation;
        float interpolation2;
        if (this.f) {
            a(f, dVar);
            return;
        }
        if (f != 1.0f || z) {
            float fI = dVar.i();
            if (f < 0.5f) {
                interpolation = dVar.j();
                interpolation2 = (h.getInterpolation(f / 0.5f) * 0.79f) + interpolation + 0.01f;
            } else {
                float fJ = dVar.j() + 0.79f;
                interpolation = fJ - (((1.0f - h.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                interpolation2 = fJ;
            }
            float f2 = fI + (0.20999998f * f);
            float f3 = (f + this.e) * 216.0f;
            dVar.d(interpolation);
            dVar.b(interpolation2);
            dVar.c(f2);
            a(f3);
        }
    }

    private void a(float f) {
        this.c = f;
    }

    private void a(float f, float f2, float f3, float f4) {
        d dVar = this.b;
        float f5 = this.f12232a.getDisplayMetrics().density;
        dVar.e(f2 * f5);
        dVar.a(f * f5);
        dVar.d(0);
    }

    private void a() {
        d dVar = this.b;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new b(dVar));
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(g);
        valueAnimatorOfFloat.addListener(new c(dVar));
        this.d = valueAnimatorOfFloat;
    }
}
