package sg.bigo.ads.common.w;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import sg.bigo.ads.common.utils.k;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f13348a = "adview_background_color_animator_tag".hashCode();

    public static class a {
        public long a() {
            return -1L;
        }

        public boolean a(int i) {
            return false;
        }

        public void b(int i) {
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.common.w.b$b, reason: collision with other inner class name */
    static class C0880b extends d<ColorDrawable> {
        private final int d;

        /* JADX WARN: Multi-variable type inference failed */
        private C0880b(View view, ColorDrawable colorDrawable, int i) {
            super(view, colorDrawable, i, 0 == true ? 1 : 0);
            this.d = this.b != 0 ? ((ColorDrawable) this.b).getColor() : 0;
        }

        /* synthetic */ C0880b(View view, ColorDrawable colorDrawable, int i, byte b) {
            this(view, colorDrawable, i);
        }

        @Override // sg.bigo.ads.common.w.b.d
        protected final int a() {
            return this.d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // sg.bigo.ads.common.w.b.d
        public final void a(int i) {
            if (this.f13355a == null || this.b == 0) {
                return;
            }
            ((ColorDrawable) this.b).setColor(i);
            ((ColorDrawable) this.b).invalidateSelf();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // sg.bigo.ads.common.w.b.d
        public final void a(boolean z) {
            if (this.f13355a == null || this.b == 0) {
                return;
            }
            ((ColorDrawable) this.b).setColor(z ? this.d : this.c);
            ((ColorDrawable) this.b).invalidateSelf();
        }
    }

    static class c extends d<Paint> {
        private final int d;

        /* JADX WARN: Multi-variable type inference failed */
        public c(View view, Paint paint, int i) {
            super(view, paint, i, 0 == true ? 1 : 0);
            this.d = this.b != 0 ? ((Paint) this.b).getColor() : 0;
        }

        @Override // sg.bigo.ads.common.w.b.d
        public final int a() {
            return this.d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // sg.bigo.ads.common.w.b.d
        public final void a(int i) {
            if (this.f13355a == null || this.b == 0) {
                return;
            }
            ((Paint) this.b).setColor(i);
            this.f13355a.getBackground().invalidateSelf();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // sg.bigo.ads.common.w.b.d
        public final void a(boolean z) {
            if (this.f13355a == null || this.b == 0) {
                return;
            }
            ((Paint) this.b).setColor(z ? this.d : this.c);
            this.f13355a.getBackground().invalidateSelf();
        }
    }

    static abstract class d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final View f13355a;
        protected final T b;
        protected final int c;

        private d(View view, T t, int i) {
            this.f13355a = view;
            this.b = t;
            this.c = i;
        }

        /* synthetic */ d(View view, Object obj, int i, byte b) {
            this(view, obj, i);
        }

        protected abstract int a();

        public int a(float f) {
            return b.a(f, a(), this.c);
        }

        protected abstract void a(int i);

        public abstract void a(boolean z);
    }

    static class e extends d<Drawable> {
        private Drawable d;
        private final ColorDrawable e;
        private int f;

        public e(View view, int i) {
            super(view, null, i, (byte) 0);
            ColorDrawable colorDrawable = new ColorDrawable(i);
            this.e = colorDrawable;
            if (view != null) {
                Drawable background = view.getBackground();
                this.d = background;
                if (background != null) {
                    view.setBackground(new LayerDrawable(new Drawable[]{this.d, colorDrawable}));
                } else {
                    colorDrawable.setColor(0);
                    view.setBackground(colorDrawable);
                }
            }
        }

        @Override // sg.bigo.ads.common.w.b.d
        protected final int a() {
            return 0;
        }

        @Override // sg.bigo.ads.common.w.b.d
        public final int a(float f) {
            this.f = Math.max((int) ((255.0f - (f * 255.0f)) + 0.5f), 255);
            return super.a(f);
        }

        @Override // sg.bigo.ads.common.w.b.d
        public final void a(int i) {
            if (this.f13355a != null) {
                ColorDrawable colorDrawable = this.e;
                if (colorDrawable != null) {
                    colorDrawable.setColor(i);
                    this.e.invalidateSelf();
                }
                Drawable drawable = this.d;
                if (drawable != null) {
                    drawable.setAlpha(this.f);
                    this.d.invalidateSelf();
                }
            }
        }

        @Override // sg.bigo.ads.common.w.b.d
        public final void a(boolean z) {
            if (this.f13355a != null) {
                this.f13355a.setBackground(z ? this.d : this.e);
            }
        }
    }

    public static double a(int i) {
        double dA = a((16711680 & i) >> 16, (65280 & i) >> 8, i & 255);
        double dA2 = a(255, 255, 255);
        return (Math.max(dA, dA2) + 0.05000000074505806d) / (Math.min(dA, dA2) + 0.05000000074505806d);
    }

    private static double a(int i, int i2, int i3) {
        double[] dArr = new double[3];
        dArr[0] = i / 255.0f;
        dArr[1] = i2 / 255.0f;
        dArr[2] = i3 / 255.0f;
        for (int i4 = 0; i4 < 3; i4++) {
            double d2 = dArr[i4];
            dArr[i4] = d2 <= 0.0392800010740757d ? d2 / 12.920000076293945d : Math.pow((d2 + 0.054999999701976776d) / 1.0549999475479126d, 2.4000000953674316d);
        }
        return (dArr[0] * 0.2125999927520752d) + (dArr[1] * 0.7152000069618225d) + (dArr[2] * 0.0722000002861023d);
    }

    private static float a(float f, float f2) {
        if (f < 0.0f) {
            return 0.0f;
        }
        return f > f2 ? f2 : f;
    }

    static /* synthetic */ float a(ValueAnimator valueAnimator) {
        if (valueAnimator == null) {
            return 1.0f;
        }
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Float) {
            return ((Float) animatedValue).floatValue();
        }
        return 1.0f;
    }

    public static int a(float f, int i, int i2) {
        float f2 = ((i >> 24) & 255) / 255.0f;
        float fPow = (float) Math.pow(((i >> 16) & 255) / 255.0f, 2.2d);
        float fPow2 = (float) Math.pow(((i >> 8) & 255) / 255.0f, 2.2d);
        float fPow3 = (float) Math.pow((i & 255) / 255.0f, 2.2d);
        float fPow4 = (float) Math.pow(((i2 >> 16) & 255) / 255.0f, 2.2d);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f);
        float fPow5 = fPow2 + ((((float) Math.pow(((i2 >> 8) & 255) / 255.0f, 2.2d)) - fPow2) * f);
        float fPow6 = fPow3 + (f * (((float) Math.pow((i2 & 255) / 255.0f, 2.2d)) - fPow3));
        return (Math.round(((float) Math.pow(fPow + ((fPow4 - fPow) * f), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round(f3 * 255.0f) << 24) | (Math.round(((float) Math.pow(fPow5, 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow(fPow6, 0.45454545454545453d)) * 255.0f);
    }

    public static int a(int i, float f) {
        return a(i, (int) (f * 255.0f));
    }

    public static int a(int i, int i2) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | ((Math.max(0, Math.min(255, i2)) & 255) << 24);
    }

    public static int a(Bitmap bitmap, int i) {
        Integer numA = a(bitmap);
        return numA != null ? numA.intValue() : i;
    }

    public static ValueAnimator a(final View view, final int i, final a aVar) {
        if (view == null) {
            return null;
        }
        final d dVarA = a(view, i);
        int i2 = f13348a;
        Object tag = view.getTag(i2);
        if (tag instanceof ValueAnimator) {
            ((ValueAnimator) tag).cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        long jA = aVar.a();
        if (jA != -1) {
            valueAnimatorOfFloat.setDuration(jA);
        }
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: sg.bigo.ads.common.w.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iA = dVarA.a(b.a(valueAnimator));
                a aVar2 = aVar;
                if (aVar2 != null ? aVar2.a(iA) : false) {
                    return;
                }
                dVarA.a(iA);
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: sg.bigo.ads.common.w.b.5
            private boolean e = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.e = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b(i);
                }
                dVarA.a(this.e);
                view.setTag(b.f13348a, null);
            }
        });
        valueAnimatorOfFloat.start();
        view.setTag(i2, valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    public static ValueAnimator a(final View view, final Drawable drawable, long j) {
        if (view == null) {
            return null;
        }
        int i = f13348a;
        Object tag = view.getTag(i);
        if (tag instanceof ValueAnimator) {
            ((ValueAnimator) tag).cancel();
        }
        final Drawable background = view.getBackground();
        if (background == null) {
            view.setBackground(drawable);
        } else {
            view.setBackground(new LayerDrawable(new Drawable[]{background, drawable}));
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (j != -1) {
            valueAnimatorOfFloat.setDuration(j);
        }
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: sg.bigo.ads.common.w.b.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iMax = Math.max((int) ((b.a(valueAnimator) * 255.0f) + 0.5f), 255);
                drawable.setAlpha(iMax);
                drawable.invalidateSelf();
                Drawable drawable2 = background;
                if (drawable2 != null) {
                    drawable2.setAlpha(255 - iMax);
                    background.invalidateSelf();
                }
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: sg.bigo.ads.common.w.b.7
            private boolean d = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                this.d = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                view.setBackground(this.d ? background : drawable);
                view.setTag(b.f13348a, null);
            }
        });
        valueAnimatorOfFloat.start();
        view.setTag(i, valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    public static Integer a(Bitmap bitmap) {
        int iMax;
        if (bitmap == null) {
            return null;
        }
        try {
            sg.bigo.ads.common.w.c.a aVarA = sg.bigo.ads.common.w.c.a(bitmap);
            if (aVarA.f13357a == null) {
                throw new AssertionError();
            }
            Bitmap bitmapA = aVarA.f13357a;
            double dSqrt = -1.0d;
            if (aVarA.d > 0) {
                int width = bitmapA.getWidth() * bitmapA.getHeight();
                if (width > aVarA.d) {
                    dSqrt = Math.sqrt(((double) aVarA.d) / ((double) width));
                }
            } else if (aVarA.e > 0 && (iMax = Math.max(bitmapA.getWidth(), bitmapA.getHeight())) > aVarA.e) {
                dSqrt = ((double) aVarA.e) / ((double) iMax);
            }
            if (dSqrt > 0.0d) {
                bitmapA = sg.bigo.ads.common.utils.d.a(bitmapA, (int) Math.ceil(((double) bitmapA.getWidth()) * dSqrt), (int) Math.ceil(((double) bitmapA.getHeight()) * dSqrt));
            }
            int width2 = bitmapA.getWidth();
            int height = bitmapA.getHeight();
            int[] iArr = new int[width2 * height];
            bitmapA.getPixels(iArr, 0, width2, 0, 0, width2, height);
            sg.bigo.ads.common.w.a aVar = new sg.bigo.ads.common.w.a(iArr, aVarA.c, aVarA.f.isEmpty() ? null : (sg.bigo.ads.common.w.c.b[]) aVarA.f.toArray(new sg.bigo.ads.common.w.c.b[aVarA.f.size()]));
            if (bitmapA != aVarA.f13357a) {
                bitmapA.recycle();
            }
            sg.bigo.ads.common.w.c cVar = new sg.bigo.ads.common.w.c(aVar.c, aVarA.b);
            cVar.a();
            sg.bigo.ads.common.w.c.C0881c c0881c = cVar.f13356a;
            if (c0881c != null) {
                return Integer.valueOf(c0881c.f13358a);
            }
            return null;
        } catch (Exception unused) {
        }
    }

    private static d a(View view, int i) {
        Drawable drawableFindDrawableByLayerId;
        Drawable background = view.getBackground();
        if ((background instanceof LayerDrawable) && (drawableFindDrawableByLayerId = ((LayerDrawable) background).findDrawableByLayerId(sg.bigo.ads.common.utils.d.f13285a)) != null) {
            background = drawableFindDrawableByLayerId;
        }
        byte b = 0;
        int i2 = 0;
        while (true) {
            if (i2 < 10 && background != null) {
                i2++;
                Object objA = sg.bigo.ads.common.r.a.a(background, "getDrawable", Drawable.class);
                if (!(objA instanceof Drawable)) {
                    break;
                }
                background = (Drawable) objA;
            } else {
                background = null;
                break;
            }
        }
        if (background instanceof ColorDrawable) {
            return new C0880b(view, (ColorDrawable) background, i, b);
        }
        if (!(background instanceof ShapeDrawable)) {
            return new e(view, i);
        }
        Paint paint = ((ShapeDrawable) background).getPaint();
        Paint.Style style = paint.getStyle();
        return (style == Paint.Style.FILL || style == Paint.Style.FILL_AND_STROKE) ? new c(view, paint, i) : new e(view, i);
    }

    public static void a(int i, int i2, int i3, float[] fArr) {
        float f;
        float fAbs;
        float f2 = i / 255.0f;
        float f3 = i2 / 255.0f;
        float f4 = i3 / 255.0f;
        float fMax = Math.max(f2, Math.max(f3, f4));
        float fMin = Math.min(f2, Math.min(f3, f4));
        float f5 = fMax - fMin;
        float f6 = (fMax + fMin) / 2.0f;
        if (fMax == fMin) {
            f = 0.0f;
            fAbs = 0.0f;
        } else {
            if (fMax == f2) {
                f = ((f3 - f4) / f5) % 6.0f;
            } else {
                f = fMax == f3 ? ((f4 - f2) / f5) + 2.0f : 4.0f + ((f2 - f3) / f5);
            }
            fAbs = f5 / (1.0f - Math.abs((2.0f * f6) - 1.0f));
        }
        float f7 = (f * 60.0f) % 360.0f;
        if (f7 < 0.0f) {
            f7 += 360.0f;
        }
        fArr[0] = a(f7, 360.0f);
        fArr[1] = a(fAbs, 1.0f);
        fArr[2] = a(f6, 1.0f);
    }

    public static void a(final int i, final int i2, long j, final TextView... textViewArr) {
        if (k.a(textViewArr)) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (j >= 0) {
            valueAnimatorOfFloat.setDuration(j);
        }
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: sg.bigo.ads.common.w.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iA = b.a(b.a(valueAnimator), i, i2);
                for (TextView textView : textViewArr) {
                    textView.setTextColor(iA);
                }
            }
        });
        valueAnimatorOfFloat.start();
    }

    public static void a(int i, float[] fArr) {
        a(Color.red(i), Color.green(i), Color.blue(i), fArr);
    }

    public static void a(View view) {
        a(view, -1, new a() { // from class: sg.bigo.ads.common.w.b.3
            @Override // sg.bigo.ads.common.w.b.a
            public final long a() {
                return 0L;
            }
        });
    }

    public static void a(Interpolator interpolator, final View view) {
        if (view == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.setInterpolator(interpolator);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: sg.bigo.ads.common.w.b.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f13350a = 0;
            final /* synthetic */ int b = -1291845632;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setBackgroundColor(b.a(b.a(valueAnimator), this.f13350a, this.b));
            }
        });
        valueAnimatorOfFloat.start();
    }

    public static int b(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        float f = fArr[2];
        if (f > 0.3f) {
            fArr[2] = ((f - 1.0f) * 0.6857143f) + 0.93f;
        } else {
            fArr[2] = f * 1.5f;
        }
        return Color.HSVToColor(fArr);
    }
}
