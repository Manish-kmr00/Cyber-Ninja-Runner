package io.bidmachine.iab.mraid;

import android.content.Context;
import android.graphics.Rect;
import io.bidmachine.iab.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class MraidScreenMetrics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f12206a;
    private final Rect b = new Rect();
    private final Rect c = new Rect();
    private final Rect d = new Rect();
    private final Rect e = new Rect();
    private final Rect f = new Rect();
    private final Rect g = new Rect();
    private final Rect h = new Rect();
    private final Rect i = new Rect();

    public MraidScreenMetrics(Context context) {
        this.f12206a = context.getResources().getDisplayMetrics().density;
    }

    void a(Rect rect, Rect rect2) {
        rect2.set(Utils.pixelsToIntDips(rect.left, this.f12206a), Utils.pixelsToIntDips(rect.top, this.f12206a), Utils.pixelsToIntDips(rect.right, this.f12206a), Utils.pixelsToIntDips(rect.bottom, this.f12206a));
    }

    Rect b() {
        return this.h;
    }

    Rect c() {
        return this.i;
    }

    Rect d() {
        return this.e;
    }

    Rect e() {
        return this.c;
    }

    public float getDensity() {
        return this.f12206a;
    }

    Rect a() {
        return this.g;
    }

    boolean b(int i, int i2, int i3, int i4) {
        return a(this.h, this.i, i, i2, i3, i4);
    }

    boolean c(int i, int i2, int i3, int i4) {
        return a(this.d, this.e, i, i2, i3, i4);
    }

    boolean a(int i, int i2, int i3, int i4) {
        return a(this.f, this.g, i, i2, i3, i4);
    }

    private boolean a(Rect rect, Rect rect2, int i, int i2, int i3, int i4) {
        if (rect.left == i && rect.top == i2 && i + i3 == rect.right && i2 + i4 == rect.bottom) {
            return false;
        }
        rect.set(i, i2, i3 + i, i4 + i2);
        a(rect, rect2);
        return true;
    }

    boolean a(int i, int i2) {
        if (this.b.width() == i && this.b.height() == i2) {
            return false;
        }
        this.b.set(0, 0, i, i2);
        a(this.b, this.c);
        return true;
    }
}
