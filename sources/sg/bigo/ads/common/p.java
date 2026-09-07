package sg.bigo.ads.common;

import io.bidmachine.iab.vast.tags.VastAttributes;

/* JADX INFO: loaded from: classes3.dex */
public class p {
    public final int b;
    public final int c;

    public p(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    public static p a(int i, int i2, int i3) {
        return new p((int) (((i3 * 1.0f) * i) / i2), i3);
    }

    public static p a(int i, int i2, int i3, int i4) {
        float f = i;
        float f2 = i2;
        float f3 = i3;
        float f4 = i4;
        if ((f * 1.0f) / f2 > (1.0f * f3) / f4) {
            f4 = (f3 / f) * f2;
        } else {
            f3 = (f4 / f2) * f;
        }
        return new p((int) f3, (int) f4);
    }

    public static p b(int i, int i2, int i3) {
        return new p(i3, (int) (((i3 * 1.0f) * i2) / i));
    }

    public final boolean a() {
        return this.b > 0 && this.c > 0;
    }

    public final boolean a(int i, int i2) {
        int i3;
        int i4;
        return (i == 0 || i2 == 0 || (i3 = this.b) == 0 || (i4 = this.c) == 0 || i * i4 != i2 * i3) ? false : true;
    }

    public final boolean a(p pVar) {
        return pVar != null && this.b * this.c > pVar.b * pVar.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (pVar.c == this.c && pVar.b == this.b) {
                return true;
            }
        }
        return false;
    }

    public int getHeight() {
        return this.c;
    }

    public int getWidth() {
        return this.b;
    }

    public String toString() {
        return this.b + VastAttributes.HORIZONTAL_POSITION + this.c;
    }
}
