package sg.bigo.ads.common.w;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.ArrayMap;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    static final b b = new b() { // from class: sg.bigo.ads.common.w.c.1
        @Override // sg.bigo.ads.common.w.c.b
        public final boolean a(float[] fArr) {
            float f = fArr[2];
            if (f < 0.95f && f > 0.05f) {
                float f2 = fArr[1];
                if ((f2 > 0.1f || f < 0.55f) && ((f2 > 0.5f || f < 0.75f) && (f2 > 0.2f || f < 0.7f))) {
                    float f3 = fArr[0];
                    if (f3 < 10.0f || f3 > 37.0f || f2 > 0.82f) {
                        return true;
                    }
                }
            }
            return false;
        }
    };
    private final List<C0881c> c;
    private final List<d> d;
    private final SparseBooleanArray f = new SparseBooleanArray();
    private final Map<d, C0881c> e = new ArrayMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final C0881c f13356a = b();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Bitmap f13357a;
        final List<d> b;
        int c;
        int d;
        int e;
        final List<b> f;

        public a(Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            this.c = 16;
            this.d = 12544;
            this.e = -1;
            ArrayList arrayList2 = new ArrayList();
            this.f = arrayList2;
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            arrayList2.add(c.b);
            this.f13357a = bitmap;
            arrayList.add(d.f13359a);
        }
    }

    interface b {
        boolean a(float[] fArr);
    }

    /* JADX INFO: renamed from: sg.bigo.ads.common.w.c$c, reason: collision with other inner class name */
    public static final class C0881c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f13358a;
        final int b;
        private final int c;
        private final int d;
        private final int e;
        private float[] f;

        public C0881c(int i, int i2) {
            this.c = Color.red(i);
            this.d = Color.green(i);
            this.e = Color.blue(i);
            this.f13358a = i;
            this.b = i2;
        }

        public final float[] a() {
            if (this.f == null) {
                this.f = new float[3];
            }
            sg.bigo.ads.common.w.b.a(this.c, this.d, this.e, this.f);
            return this.f;
        }
    }

    c(List<C0881c> list, List<d> list2) {
        this.c = list;
        this.d = list2;
    }

    public static a a(Bitmap bitmap) {
        return new a(bitmap);
    }

    private C0881c b() {
        int size = this.c.size();
        int i = Integer.MIN_VALUE;
        C0881c c0881c = null;
        for (int i2 = 0; i2 < size; i2++) {
            C0881c c0881c2 = this.c.get(i2);
            if (c0881c2.b > i) {
                i = c0881c2.b;
                c0881c = c0881c2;
            }
        }
        return c0881c;
    }

    final void a() {
        float f;
        int size = this.d.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            d dVar = this.d.get(i2);
            int length = dVar.d.length;
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (int i3 = i; i3 < length; i3++) {
                float f4 = dVar.d[i3];
                if (f4 > 0.0f) {
                    f3 += f4;
                }
            }
            if (f3 != 0.0f) {
                int length2 = dVar.d.length;
                for (int i4 = i; i4 < length2; i4++) {
                    if (dVar.d[i4] > 0.0f) {
                        float[] fArr = dVar.d;
                        fArr[i4] = fArr[i4] / f3;
                    }
                }
            }
            Map<d, C0881c> map = this.e;
            int size2 = this.c.size();
            C0881c c0881c = null;
            int i5 = i;
            float f5 = 0.0f;
            while (i5 < size2) {
                C0881c c0881c2 = this.c.get(i5);
                float[] fArrA = c0881c2.a();
                if (fArrA[1] < dVar.b[i] || fArrA[1] > dVar.b[2] || fArrA[2] < dVar.c[i] || fArrA[2] > dVar.c[2] || this.f.get(c0881c2.f13358a)) {
                    f = f2;
                } else {
                    float[] fArrA2 = c0881c2.a();
                    C0881c c0881c3 = this.f13356a;
                    int i6 = c0881c3 != null ? c0881c3.b : 1;
                    float fAbs = dVar.d[i] > f2 ? dVar.d[i] * (1.0f - Math.abs(fArrA2[1] - dVar.b[1])) : f2;
                    float fAbs2 = dVar.d[1] > f2 ? dVar.d[1] * (1.0f - Math.abs(fArrA2[2] - dVar.c[1])) : 0.0f;
                    f = 0.0f;
                    float f6 = fAbs + fAbs2 + (dVar.d[2] > 0.0f ? dVar.d[2] * (c0881c2.b / i6) : 0.0f);
                    if (c0881c == null || f6 > f5) {
                        c0881c = c0881c2;
                        f5 = f6;
                    }
                }
                i5++;
                f2 = f;
                i = 0;
            }
            if (c0881c != null && dVar.e) {
                this.f.append(c0881c.f13358a, true);
            }
            map.put(dVar, c0881c);
            i2++;
            i = 0;
        }
        this.f.clear();
    }
}
