package sg.bigo.ads.common.view.a;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes11.dex */
public class b {
    protected final float d;
    protected final float e;
    protected final float f;
    protected final float g;
    protected final Rect h;
    protected final int i;
    protected final int j;
    protected final float k;
    protected final float l;
    protected final float m;
    protected final Drawable n;

    public b() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 1291845632, 0, 0.0f);
    }

    public b(float f, float f2, float f3, float f4, int i, int i2, float f5) {
        this(f, f2, f3, f4, null, i, i2, f5, null);
    }

    public b(float f, float f2, float f3, float f4, Rect rect, int i, int i2, float f5, boolean[] zArr) {
        this.d = f;
        this.e = f2;
        this.f = f3;
        this.g = f4;
        this.h = rect;
        this.i = i;
        this.j = i2;
        this.k = f5;
        this.l = Math.max(0.0f, Math.min(25.0f, 23.0f));
        this.m = 4.0f;
        this.n = (i2 == 0 || f5 <= 0.0f) ? null : sg.bigo.ads.common.utils.d.a(f, f2, f3, f4, i2, f5, zArr);
    }

    public final void a(Rect rect) {
        Rect rect2 = this.h;
        if (rect2 == null) {
            rect2 = new Rect();
        }
        rect.left = rect2.left;
        rect.top = rect2.top;
        rect.right = rect2.right;
        rect.bottom = rect2.bottom;
    }

    public final void a(float[] fArr) {
        float f = this.d;
        fArr[0] = f;
        fArr[1] = f;
        float f2 = this.e;
        fArr[2] = f2;
        fArr[3] = f2;
        float f3 = this.f;
        fArr[4] = f3;
        fArr[5] = f3;
        float f4 = this.g;
        fArr[6] = f4;
        fArr[7] = f4;
    }

    public final int b() {
        return this.i;
    }

    public final float c() {
        return this.l;
    }

    public final float d() {
        return this.m;
    }

    public final Drawable e() {
        return this.n;
    }
}
