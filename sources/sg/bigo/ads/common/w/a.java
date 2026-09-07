package sg.bigo.ads.common.w;

import android.graphics.Color;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes5.dex */
final class a {
    private static final Comparator<C0879a> g = new Comparator<C0879a>() { // from class: sg.bigo.ads.common.w.a.1
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(C0879a c0879a, C0879a c0879a2) {
            return c0879a2.a() - c0879a.a();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int[] f13346a;
    final int[] b;
    final List<c.C0881c> c;
    final c.b[] e;
    private final float[] f = new float[3];
    final TimingLogger d = null;

    /* JADX INFO: renamed from: sg.bigo.ads.common.w.a$a, reason: collision with other inner class name */
    class C0879a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13347a;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;

        C0879a(int i, int i2) {
            this.c = i;
            this.f13347a = i2;
            c();
        }

        private int f() {
            return (this.f13347a + 1) - this.c;
        }

        final int a() {
            return ((this.f - this.e) + 1) * ((this.h - this.g) + 1) * ((this.j - this.i) + 1);
        }

        final boolean b() {
            return f() > 1;
        }

        final void c() {
            int[] iArr = a.this.f13346a;
            int[] iArr2 = a.this.b;
            int i = Integer.MAX_VALUE;
            int i2 = Integer.MIN_VALUE;
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = 0;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MAX_VALUE;
            for (int i8 = this.c; i8 <= this.f13347a; i8++) {
                int i9 = iArr[i8];
                i5 += iArr2[i9];
                int iA = a.a(i9);
                int iB = a.b(i9);
                int iC = a.c(i9);
                if (iA > i2) {
                    i2 = iA;
                }
                if (iA < i) {
                    i = iA;
                }
                if (iB > i3) {
                    i3 = iB;
                }
                if (iB < i6) {
                    i6 = iB;
                }
                if (iC > i4) {
                    i4 = iC;
                }
                if (iC < i7) {
                    i7 = iC;
                }
            }
            this.e = i;
            this.f = i2;
            this.g = i6;
            this.h = i3;
            this.i = i7;
            this.j = i4;
            this.d = i5;
        }

        final int d() {
            int i;
            int i2 = this.f - this.e;
            int i3 = this.h - this.g;
            int i4 = this.j - this.i;
            if (i2 < i3 || i2 < i4) {
                i = (i3 < i2 || i3 < i4) ? -1 : -2;
            } else {
                i = -3;
            }
            int[] iArr = a.this.f13346a;
            int[] iArr2 = a.this.b;
            a.a(iArr, i, this.c, this.f13347a);
            Arrays.sort(iArr, this.c, this.f13347a + 1);
            a.a(iArr, i, this.c, this.f13347a);
            int i5 = this.d / 2;
            int i6 = this.c;
            int i7 = 0;
            while (true) {
                int i8 = this.f13347a;
                if (i6 > i8) {
                    return this.c;
                }
                i7 += iArr2[iArr[i6]];
                if (i7 >= i5) {
                    return Math.min(i8 - 1, i6);
                }
                i6++;
            }
        }

        final c.C0881c e() {
            int[] iArr = a.this.f13346a;
            int[] iArr2 = a.this.b;
            int i = 0;
            int iA = 0;
            int iB = 0;
            int iC = 0;
            for (int i2 = this.c; i2 <= this.f13347a; i2++) {
                int i3 = iArr[i2];
                int i4 = iArr2[i3];
                i += i4;
                iA += a.a(i3) * i4;
                iB += a.b(i3) * i4;
                iC += i4 * a.c(i3);
            }
            if (i == 0) {
                return new c.C0881c(a.a(0, 0, 0), i);
            }
            float f = i;
            return new c.C0881c(a.a(Math.round(iA / f), Math.round(iB / f), Math.round(iC / f)), i);
        }
    }

    a(int[] iArr, int i, c.b[] bVarArr) {
        this.e = bVarArr;
        int[] iArr2 = new int[32768];
        this.b = iArr2;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            int iB = b(Color.blue(i3), 8, 5) | (b(Color.red(i3), 8, 5) << 10) | (b(Color.green(i3), 8, 5) << 5);
            iArr[i2] = iB;
            iArr2[iB] = iArr2[iB] + 1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 32768; i5++) {
            if (iArr2[i5] > 0) {
                b.a(d(i5), this.f);
                if (a(this.f)) {
                    iArr2[i5] = 0;
                }
            }
            if (iArr2[i5] > 0) {
                i4++;
            }
        }
        int[] iArr3 = new int[i4];
        this.f13346a = iArr3;
        int i6 = 0;
        for (int i7 = 0; i7 < 32768; i7++) {
            if (iArr2[i7] > 0) {
                iArr3[i6] = i7;
                i6++;
            }
        }
        if (i4 > i) {
            PriorityQueue priorityQueue = new PriorityQueue(i, g);
            priorityQueue.offer(new C0879a(0, this.f13346a.length - 1));
            a(priorityQueue, i);
            this.c = a(priorityQueue);
            return;
        }
        this.c = new ArrayList();
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = iArr3[i8];
            this.c.add(new c.C0881c(d(i9), iArr2[i9]));
        }
    }

    static int a(int i) {
        return (i >> 10) & 31;
    }

    static int a(int i, int i2, int i3) {
        return Color.rgb(b(i, 5, 8), b(i2, 5, 8), b(i3, 5, 8));
    }

    private List<c.C0881c> a(Collection<C0879a> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<C0879a> it = collection.iterator();
        while (it.hasNext()) {
            c.C0881c c0881cE = it.next().e();
            if (!a(c0881cE.a())) {
                arrayList.add(c0881cE);
            }
        }
        return arrayList;
    }

    private static void a(PriorityQueue<C0879a> priorityQueue, int i) {
        C0879a c0879aPoll;
        while (priorityQueue.size() < i && (c0879aPoll = priorityQueue.poll()) != null && c0879aPoll.b()) {
            if (!c0879aPoll.b()) {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
            int iD = c0879aPoll.d();
            C0879a c0879a = a.this.new C0879a(iD + 1, c0879aPoll.f13347a);
            c0879aPoll.f13347a = iD;
            c0879aPoll.c();
            priorityQueue.offer(c0879a);
            priorityQueue.offer(c0879aPoll);
        }
    }

    static void a(int[] iArr, int i, int i2, int i3) {
        if (i == -2) {
            while (i2 <= i3) {
                int i4 = iArr[i2];
                iArr[i2] = (i4 & 31) | (((i4 >> 5) & 31) << 10) | (((i4 >> 10) & 31) << 5);
                i2++;
            }
            return;
        }
        if (i != -1) {
            return;
        }
        while (i2 <= i3) {
            int i5 = iArr[i2];
            iArr[i2] = ((i5 >> 10) & 31) | ((i5 & 31) << 10) | (((i5 >> 5) & 31) << 5);
            i2++;
        }
    }

    private boolean a(float[] fArr) {
        c.b[] bVarArr = this.e;
        if (bVarArr != null && bVarArr.length > 0) {
            int length = bVarArr.length;
            for (int i = 0; i < length; i++) {
                if (!this.e[i].a(fArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    static int b(int i) {
        return (i >> 5) & 31;
    }

    private static int b(int i, int i2, int i3) {
        return (i3 > i2 ? i << (i3 - i2) : i >> (i2 - i3)) & ((1 << i3) - 1);
    }

    static int c(int i) {
        return i & 31;
    }

    private static int d(int i) {
        return a((i >> 10) & 31, (i >> 5) & 31, i & 31);
    }
}
