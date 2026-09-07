package sg.bigo.ads.common.a;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;

/* JADX INFO: loaded from: classes5.dex */
public class a extends TranslateAnimation implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13123a;
    private int b;
    public int c;
    public int d;
    private int e;
    private int f;
    private Animation.AnimationListener g;

    public a(float f) {
        super(0.0f, 0.0f, 0.0f, f);
    }

    public a(float f, float f2) {
        super(1, 0.0f, 1, 0.0f, 1, f, 1, f2);
    }

    protected void a(float f, float f2, int i, int i2) {
    }

    @Override // android.view.animation.TranslateAnimation, android.view.animation.Animation
    protected final void applyTransformation(float f, Transformation transformation) {
        Transformation transformation2 = new Transformation();
        super.applyTransformation(f, transformation2);
        Matrix matrix = transformation2.getMatrix();
        Matrix matrix2 = transformation != null ? transformation.getMatrix() : null;
        if (matrix == null || matrix2 == null) {
            return;
        }
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        fArr[2] = fArr[2] - this.f;
        fArr[5] = fArr[5] - this.d;
        matrix2.setValues(fArr);
        a(fArr[2], fArr[5], this.f13123a, this.b);
    }

    @Override // android.view.animation.TranslateAnimation, android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        super.setAnimationListener(this);
        this.f13123a = i;
        this.b = i2;
    }

    public void onAnimationEnd(Animation animation) {
        Animation.AnimationListener animationListener = this.g;
        if (animationListener != null) {
            animationListener.onAnimationEnd(animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        this.f = this.e;
        this.d = this.c;
        Animation.AnimationListener animationListener = this.g;
        if (animationListener != null) {
            animationListener.onAnimationRepeat(animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        Animation.AnimationListener animationListener = this.g;
        if (animationListener != null) {
            animationListener.onAnimationStart(animation);
        }
    }

    @Override // android.view.animation.Animation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.g = animationListener;
    }
}
