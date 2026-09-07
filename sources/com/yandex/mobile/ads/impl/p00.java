package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public final class p00 extends yt0 {
    private static final ff1<Integer> i = ff1.a(new Comparator() { // from class: com.yandex.mobile.ads.impl.p00$$ExternalSyntheticLambda3
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return p00.a((Integer) obj, (Integer) obj2);
        }
    });
    private static final ff1<Integer> j = ff1.a(new Comparator() { // from class: com.yandex.mobile.ads.impl.p00$$ExternalSyntheticLambda4
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return p00.b((Integer) obj, (Integer) obj2);
        }
    });
    private final Object c;
    private final e70.b d;
    private final boolean e;
    private c f;
    private e g;
    private oh h;

    public static final class d implements jm {
        public static final jm.a<d> e = new jm.a() { // from class: com.yandex.mobile.ads.impl.p00$d$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.jm.a
            public final jm fromBundle(Bundle bundle) {
                return p00.d.a(bundle);
            }
        };
        public final int b;
        public final int[] c;
        public final int d;

        public d(int i, int i2, int[] iArr) {
            this.b = i;
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.c = iArrCopyOf;
            this.d = i2;
            Arrays.sort(iArrCopyOf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static d a(Bundle bundle) {
            int i = bundle.getInt(Integer.toString(0, 36), -1);
            int[] intArray = bundle.getIntArray(Integer.toString(1, 36));
            int i2 = bundle.getInt(Integer.toString(2, 36), -1);
            if (i < 0 || i2 < 0) {
                throw new IllegalArgumentException();
            }
            intArray.getClass();
            return new d(i, i2, intArray);
        }

        public final int hashCode() {
            return ((Arrays.hashCode(this.c) + (this.b * 31)) * 31) + this.d;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.b == dVar.b && Arrays.equals(this.c, dVar.c) && this.d == dVar.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Spatializer f9881a;
        private final boolean b;
        private Handler c;
        private Spatializer.OnSpatializerStateChangedListener d;

        final class a implements Spatializer.OnSpatializerStateChangedListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ p00 f9882a;

            a(p00 p00Var) {
                this.f9882a = p00Var;
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
                this.f9882a.e();
            }

            @Override // android.media.Spatializer.OnSpatializerStateChangedListener
            public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
                this.f9882a.e();
            }
        }

        public final boolean a(gc0 gc0Var, oh ohVar) {
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(x82.a(("audio/eac3-joc".equals(gc0Var.m) && gc0Var.z == 16) ? 12 : gc0Var.z));
            int i = gc0Var.A;
            if (i != -1) {
                channelMask.setSampleRate(i);
            }
            return this.f9881a.canBeSpatialized(ohVar.a().f9816a, channelMask.build());
        }

        private e(Spatializer spatializer) {
            this.f9881a = spatializer;
            this.b = spatializer.getImmersiveAudioLevel() != 0;
        }

        public final void a(p00 p00Var, Looper looper) {
            if (this.d == null && this.c == null) {
                this.d = new a(p00Var);
                final Handler handler = new Handler(looper);
                this.c = handler;
                this.f9881a.addOnSpatializerStateChangedListener(new Executor() { // from class: com.yandex.mobile.ads.impl.p00$e$$ExternalSyntheticLambda0
                    @Override // java.util.concurrent.Executor
                    public final void execute(Runnable runnable) {
                        handler.post(runnable);
                    }
                }, this.d);
            }
        }

        public final boolean b() {
            return this.f9881a.isEnabled();
        }

        public final void c() {
            Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.d;
            if (onSpatializerStateChangedListener == null || this.c == null) {
                return;
            }
            this.f9881a.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
            Handler handler = this.c;
            int i = x82.f10629a;
            handler.removeCallbacksAndMessages(null);
            this.c = null;
            this.d = null;
        }

        public final boolean a() {
            return this.f9881a.isAvailable();
        }

        public static e a(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                return null;
            }
            return new e(audioManager.getSpatializer());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class g<T extends g<T>> {
        public final int b;
        public final r52 c;
        public final int d;
        public final gc0 e;

        public interface a<T extends g<T>> {
            List<T> a(int i, r52 r52Var, int[] iArr);
        }

        public abstract int a();

        public abstract boolean a(T t);

        public g(int i, int i2, r52 r52Var) {
            this.b = i;
            this.c = r52Var;
            this.d = i2;
            this.e = r52Var.a(i2);
        }
    }

    protected static boolean a(boolean z, int i2) {
        int i3 = i2 & 7;
        return i3 == 4 || (z && i3 == 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(Integer num, Integer num2) {
        return 0;
    }

    public p00(Context context, c cVar, za.b bVar) {
        this(cVar, bVar, context);
    }

    private static void a(s52 s52Var, c cVar, HashMap map) {
        w52 w52Var;
        for (int i2 = 0; i2 < s52Var.b; i2++) {
            w52 w52Var2 = cVar.z.get(s52Var.a(i2));
            if (w52Var2 != null && ((w52Var = (w52) map.get(Integer.valueOf(w52Var2.b.d))) == null || (w52Var.c.isEmpty() && !w52Var2.c.isEmpty()))) {
                map.put(Integer.valueOf(w52Var2.b.d), w52Var2);
            }
        }
    }

    private p00(c cVar, za.b bVar, Context context) {
        this.c = new Object();
        if (context != null) {
            context.getApplicationContext();
        }
        this.d = bVar;
        this.f = cVar;
        this.h = oh.h;
        boolean z = context != null && x82.d(context);
        this.e = z;
        if (!z && context != null && x82.f10629a >= 32) {
            this.g = e.a(context);
        }
        if (this.f.L && context == null) {
            at0.d("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    public static final class c extends x52 {
        public static final c R = new c(new a());
        public final boolean C;
        public final boolean D;
        public final boolean E;
        public final boolean F;
        public final boolean G;
        public final boolean H;
        public final boolean I;
        public final boolean J;
        public final boolean K;
        public final boolean L;
        public final boolean M;
        public final boolean N;
        public final boolean O;
        private final SparseArray<Map<s52, d>> P;
        private final SparseBooleanArray Q;

        public static final class a extends x52.a {
            private boolean A;
            private boolean B;
            private boolean C;
            private boolean D;
            private boolean E;
            private boolean F;
            private boolean G;
            private boolean H;
            private boolean I;
            private boolean J;
            private boolean K;
            private boolean L;
            private boolean M;
            private final SparseArray<Map<s52, d>> N;
            private final SparseBooleanArray O;

            public final void b(boolean z) {
                this.I = z;
            }

            public final void c(boolean z) {
                this.F = z;
            }

            public final void d(boolean z) {
                this.G = z;
            }

            public final void e(boolean z) {
                this.M = z;
            }

            public final void f(boolean z) {
                this.D = z;
            }

            public final void g(boolean z) {
                this.B = z;
            }

            public final void h(boolean z) {
                this.C = z;
            }

            public final void i(boolean z) {
                this.J = z;
            }

            public final void j(boolean z) {
                this.E = z;
            }

            public final void k(boolean z) {
                this.K = z;
            }

            public final void l(boolean z) {
                this.A = z;
            }

            public final void m(boolean z) {
                this.L = z;
            }

            @Override // com.yandex.mobile.ads.impl.x52.a
            public final void b(Context context) {
                Point pointC = x82.c(context);
                super.a(pointC.x, pointC.y);
            }

            @Deprecated
            public a() {
                this.N = new SparseArray<>();
                this.O = new SparseBooleanArray();
                a();
            }

            private void a() {
                this.A = true;
                this.B = false;
                this.C = true;
                this.D = false;
                this.E = true;
                this.F = false;
                this.G = false;
                this.H = false;
                this.I = false;
                this.J = true;
                this.K = true;
                this.L = false;
                this.M = true;
            }

            private static SparseBooleanArray a(int[] iArr) {
                if (iArr == null) {
                    return new SparseBooleanArray();
                }
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
                for (int i : iArr) {
                    sparseBooleanArray.append(i, true);
                }
                return sparseBooleanArray;
            }

            public a(Context context) {
                super(context);
                this.N = new SparseArray<>();
                this.O = new SparseBooleanArray();
                a();
            }

            public final void a(boolean z) {
                this.H = z;
            }

            @Override // com.yandex.mobile.ads.impl.x52.a
            public final void a(Context context) {
                super.a(context);
            }

            /* JADX WARN: Multi-variable type inference failed */
            private void a(Bundle bundle) {
                hk0 hk0VarA;
                SparseArray sparseArray;
                int[] intArray = bundle.getIntArray(Integer.toString(1010, 36));
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(Integer.toString(1011, 36));
                if (parcelableArrayList == null) {
                    hk0VarA = hk0.h();
                } else {
                    hk0VarA = km.a(s52.f, parcelableArrayList);
                }
                SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(Integer.toString(1012, 36));
                if (sparseParcelableArray == null) {
                    sparseArray = new SparseArray();
                } else {
                    jm.a<d> aVar = d.e;
                    SparseArray sparseArray2 = new SparseArray(sparseParcelableArray.size());
                    for (int i = 0; i < sparseParcelableArray.size(); i++) {
                        sparseArray2.put(sparseParcelableArray.keyAt(i), aVar.fromBundle((Bundle) sparseParcelableArray.valueAt(i)));
                    }
                    sparseArray = sparseArray2;
                }
                if (intArray == null || intArray.length != hk0VarA.size()) {
                    return;
                }
                for (int i2 = 0; i2 < intArray.length; i2++) {
                    int i3 = intArray[i2];
                    s52 s52Var = (s52) hk0VarA.get(i2);
                    d dVar = (d) sparseArray.get(i2);
                    Map<s52, d> map = this.N.get(i3);
                    if (map == null) {
                        map = new HashMap<>();
                        this.N.put(i3, map);
                    }
                    if (!map.containsKey(s52Var) || !x82.a(map.get(s52Var), dVar)) {
                        map.put(s52Var, dVar);
                    }
                }
            }

            @Override // com.yandex.mobile.ads.impl.x52.a
            public final x52.a a(int i, int i2) {
                super.a(i, i2);
                return this;
            }

            private a(Bundle bundle) {
                super(bundle);
                a();
                c cVar = c.R;
                l(bundle.getBoolean(x52.a(1000), cVar.C));
                g(bundle.getBoolean(x52.a(1001), cVar.D));
                h(bundle.getBoolean(x52.a(1002), cVar.E));
                f(bundle.getBoolean(x52.a(1014), cVar.F));
                j(bundle.getBoolean(x52.a(1003), cVar.G));
                c(bundle.getBoolean(x52.a(1004), cVar.H));
                d(bundle.getBoolean(x52.a(1005), cVar.I));
                a(bundle.getBoolean(x52.a(1006), cVar.J));
                b(bundle.getBoolean(x52.a(1015), cVar.K));
                i(bundle.getBoolean(x52.a(1016), cVar.L));
                k(bundle.getBoolean(x52.a(1007), cVar.M));
                m(bundle.getBoolean(x52.a(1008), cVar.N));
                e(bundle.getBoolean(x52.a(1009), cVar.O));
                this.N = new SparseArray<>();
                a(bundle);
                this.O = a(bundle.getIntArray(x52.a(1013)));
            }
        }

        static {
            new jm.a() { // from class: com.yandex.mobile.ads.impl.p00$c$$ExternalSyntheticLambda0
                @Override // com.yandex.mobile.ads.impl.jm.a
                public final jm fromBundle(Bundle bundle) {
                    return p00.c.b(bundle);
                }
            };
        }

        public static c a(Context context) {
            return new c(new a(context));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c b(Bundle bundle) {
            return new c(new a(bundle));
        }

        private c(a aVar) {
            super(aVar);
            this.C = aVar.A;
            this.D = aVar.B;
            this.E = aVar.C;
            this.F = aVar.D;
            this.G = aVar.E;
            this.H = aVar.F;
            this.I = aVar.G;
            this.J = aVar.H;
            this.K = aVar.I;
            this.L = aVar.J;
            this.M = aVar.K;
            this.N = aVar.L;
            this.O = aVar.M;
            this.P = aVar.N;
            this.Q = aVar.O;
        }

        @Override // com.yandex.mobile.ads.impl.x52
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (super.equals(cVar) && this.C == cVar.C && this.D == cVar.D && this.E == cVar.E && this.F == cVar.F && this.G == cVar.G && this.H == cVar.H && this.I == cVar.I && this.J == cVar.J && this.K == cVar.K && this.L == cVar.L && this.M == cVar.M && this.N == cVar.N && this.O == cVar.O) {
                SparseBooleanArray sparseBooleanArray = this.Q;
                SparseBooleanArray sparseBooleanArray2 = cVar.Q;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    for (int i = 0; i < size; i++) {
                        if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) >= 0) {
                        }
                    }
                    SparseArray<Map<s52, d>> sparseArray = this.P;
                    SparseArray<Map<s52, d>> sparseArray2 = cVar.P;
                    int size2 = sparseArray.size();
                    if (sparseArray2.size() == size2) {
                        for (int i2 = 0; i2 < size2; i2++) {
                            int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                            if (iIndexOfKey >= 0) {
                                Map<s52, d> mapValueAt = sparseArray.valueAt(i2);
                                Map<s52, d> mapValueAt2 = sparseArray2.valueAt(iIndexOfKey);
                                if (mapValueAt2.size() == mapValueAt.size()) {
                                    for (Map.Entry<s52, d> entry : mapValueAt.entrySet()) {
                                        s52 key = entry.getKey();
                                        if (!mapValueAt2.containsKey(key) || !x82.a(entry.getValue(), mapValueAt2.get(key))) {
                                        }
                                    }
                                }
                            }
                        }
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // com.yandex.mobile.ads.impl.x52
        public final int hashCode() {
            return ((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.C ? 1 : 0)) * 31) + (this.D ? 1 : 0)) * 31) + (this.E ? 1 : 0)) * 31) + (this.F ? 1 : 0)) * 31) + (this.G ? 1 : 0)) * 31) + (this.H ? 1 : 0)) * 31) + (this.I ? 1 : 0)) * 31) + (this.J ? 1 : 0)) * 31) + (this.K ? 1 : 0)) * 31) + (this.L ? 1 : 0)) * 31) + (this.M ? 1 : 0)) * 31) + (this.N ? 1 : 0)) * 31) + (this.O ? 1 : 0);
        }
    }

    @Override // com.yandex.mobile.ads.impl.y52
    public final void d() {
        e eVar;
        synchronized (this.c) {
            if (x82.f10629a >= 32 && (eVar = this.g) != null) {
                eVar.c();
            }
        }
        super.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        boolean z;
        e eVar;
        synchronized (this.c) {
            z = this.f.L && !this.e && x82.f10629a >= 32 && (eVar = this.g) != null && eVar.b;
        }
        if (z) {
            b();
        }
    }

    protected static String b(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    protected static int a(gc0 gc0Var, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(gc0Var.d)) {
            return 4;
        }
        String strB = b(str);
        String strB2 = b(gc0Var.d);
        if (strB2 == null || strB == null) {
            return (z && strB2 == null) ? 1 : 0;
        }
        if (strB2.startsWith(strB) || strB.startsWith(strB2)) {
            return 3;
        }
        int i2 = x82.f10629a;
        return strB2.split("-", 2)[0].equals(strB.split("-", 2)[0]) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class h extends g<h> {
        private final boolean f;
        private final c g;
        private final boolean h;
        private final boolean i;
        private final int j;
        private final int k;
        private final int l;
        private final int m;
        private final boolean n;
        private final boolean o;
        private final int p;
        private final boolean q;
        private final boolean r;
        private final int s;

        /* JADX WARN: Code duplicated, block: B:31:0x004b  */
        /* JADX WARN: Code duplicated, block: B:51:0x0079  */
        public h(int i, r52 r52Var, int i2, c cVar, int i3, int i4, boolean z) {
            boolean z2;
            boolean z3;
            gc0 gc0Var;
            int i5;
            int i6;
            int i7;
            gc0 gc0Var2;
            int i8;
            int i9;
            int i10;
            super(i, i2, r52Var);
            this.g = cVar;
            int i11 = cVar.E ? 24 : 16;
            this.o = cVar.D && (i4 & i11) != 0;
            if (!z || (((i8 = (gc0Var2 = this.e).r) != -1 && i8 > cVar.b) || ((i9 = gc0Var2.s) != -1 && i9 > cVar.c))) {
                z2 = false;
            } else {
                float f = gc0Var2.t;
                if ((f == -1.0f || f <= cVar.d) && ((i10 = gc0Var2.i) == -1 || i10 <= cVar.e)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            this.f = z2;
            if (!z || (((i5 = (gc0Var = this.e).r) != -1 && i5 < cVar.f) || ((i6 = gc0Var.s) != -1 && i6 < cVar.g))) {
                z3 = false;
            } else {
                float f2 = gc0Var.t;
                if ((f2 == -1.0f || f2 >= cVar.h) && ((i7 = gc0Var.i) == -1 || i7 >= cVar.i)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            }
            this.h = z3;
            this.i = p00.a(false, i3);
            gc0 gc0Var3 = this.e;
            this.j = gc0Var3.i;
            this.k = gc0Var3.b();
            this.m = p00.a(this.e.f, cVar.n);
            int i12 = this.e.f;
            this.n = i12 == 0 || (i12 & 1) != 0;
            int i13 = 0;
            while (true) {
                if (i13 >= cVar.m.size()) {
                    i13 = Integer.MAX_VALUE;
                    break;
                }
                String str = this.e.m;
                if (str != null && str.equals(cVar.m.get(i13))) {
                    break;
                } else {
                    i13++;
                }
            }
            this.l = i13;
            this.q = so1.a(i3) == 128;
            this.r = so1.b(i3) == 64;
            this.s = p00.a(this.e.m);
            this.p = a(i3, i11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int a(h hVar, h hVar2) {
            wq wqVarA = wq.b().a(hVar.i, hVar2.i).a(hVar.m, hVar2.m).a(hVar.n, hVar2.n).a(hVar.f, hVar2.f).a(hVar.h, hVar2.h).a(Integer.valueOf(hVar.l), Integer.valueOf(hVar2.l), ff1.a().b()).a(hVar.q, hVar2.q).a(hVar.r, hVar2.r);
            if (hVar.q && hVar.r) {
                wqVarA = wqVarA.a(hVar.s, hVar2.s);
            }
            return wqVarA.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int b(h hVar, h hVar2) {
            ff1 ff1VarB;
            if (hVar.f && hVar.i) {
                ff1VarB = p00.i;
            } else {
                ff1VarB = p00.i.b();
            }
            return wq.b().a(Integer.valueOf(hVar.j), Integer.valueOf(hVar2.j), hVar.g.x ? p00.i.b() : p00.j).a(Integer.valueOf(hVar.k), Integer.valueOf(hVar2.k), ff1VarB).a(Integer.valueOf(hVar.j), Integer.valueOf(hVar2.j), ff1VarB).a();
        }

        private int a(int i, int i2) {
            if ((this.e.f & 16384) != 0 || !p00.a(this.g.M, i)) {
                return 0;
            }
            if (!this.f && !this.g.C) {
                return 0;
            }
            if (p00.a(false, i) && this.h && this.f && this.e.i != -1) {
                c cVar = this.g;
                if (!cVar.y && !cVar.x && (i & i2) != 0) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // com.yandex.mobile.ads.impl.p00.g
        public final int a() {
            return this.p;
        }

        @Override // com.yandex.mobile.ads.impl.p00.g
        public final boolean a(g gVar) {
            h hVar = (h) gVar;
            return (this.o || x82.a(this.e.m, hVar.e.m)) && (this.g.F || (this.q == hVar.q && this.r == hVar.r));
        }

        public static int a(List<h> list, List<h> list2) {
            return wq.b().a((h) Collections.max(list, new Comparator() { // from class: com.yandex.mobile.ads.impl.p00$h$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return p00.h.a((p00.h) obj, (p00.h) obj2);
                }
            }), (h) Collections.max(list2, new Comparator() { // from class: com.yandex.mobile.ads.impl.p00$h$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return p00.h.a((p00.h) obj, (p00.h) obj2);
                }
            }), new Comparator() { // from class: com.yandex.mobile.ads.impl.p00$h$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return p00.h.a((p00.h) obj, (p00.h) obj2);
                }
            }).a(list.size(), list2.size()).a((h) Collections.max(list, new Comparator() { // from class: com.yandex.mobile.ads.impl.p00$h$$ExternalSyntheticLambda1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return p00.h.b((p00.h) obj, (p00.h) obj2);
                }
            }), (h) Collections.max(list2, new Comparator() { // from class: com.yandex.mobile.ads.impl.p00$h$$ExternalSyntheticLambda1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return p00.h.b((p00.h) obj, (p00.h) obj2);
                }
            }), new Comparator() { // from class: com.yandex.mobile.ads.impl.p00$h$$ExternalSyntheticLambda1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return p00.h.b((p00.h) obj, (p00.h) obj2);
                }
            }).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class a extends g<a> implements Comparable<a> {
        private final int f;
        private final boolean g;
        private final String h;
        private final c i;
        private final boolean j;
        private final int k;
        private final int l;
        private final int m;
        private final boolean n;
        private final int o;
        private final int p;
        private final boolean q;
        private final int r;
        private final int s;
        private final int t;
        private final int u;
        private final boolean v;
        private final boolean w;

        public a(int i, r52 r52Var, int i2, c cVar, int i3, boolean z, sj1<gc0> sj1Var) {
            int i4;
            int iA;
            int iA2;
            super(i, i2, r52Var);
            this.i = cVar;
            this.h = p00.b(this.e.d);
            this.j = p00.a(false, i3);
            int i5 = 0;
            while (true) {
                i4 = Integer.MAX_VALUE;
                if (i5 >= cVar.o.size()) {
                    iA = 0;
                    i5 = Integer.MAX_VALUE;
                    break;
                } else {
                    iA = p00.a(this.e, cVar.o.get(i5), false);
                    if (iA > 0) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            this.l = i5;
            this.k = iA;
            this.m = p00.a(this.e.f, cVar.p);
            gc0 gc0Var = this.e;
            int i6 = gc0Var.f;
            this.n = i6 == 0 || (i6 & 1) != 0;
            this.q = (gc0Var.e & 1) != 0;
            int i7 = gc0Var.z;
            this.r = i7;
            this.s = gc0Var.A;
            int i8 = gc0Var.i;
            this.t = i8;
            this.g = (i8 == -1 || i8 <= cVar.r) && (i7 == -1 || i7 <= cVar.q) && sj1Var.apply(gc0Var);
            String[] strArrD = x82.d();
            int i9 = 0;
            while (true) {
                if (i9 >= strArrD.length) {
                    iA2 = 0;
                    i9 = Integer.MAX_VALUE;
                    break;
                } else {
                    iA2 = p00.a(this.e, strArrD[i9], false);
                    if (iA2 > 0) {
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            this.o = i9;
            this.p = iA2;
            for (int i10 = 0; i10 < cVar.s.size(); i10++) {
                String str = this.e.m;
                if (str != null && str.equals(cVar.s.get(i10))) {
                    i4 = i10;
                    break;
                }
            }
            this.u = i4;
            this.v = so1.a(i3) == 128;
            this.w = so1.b(i3) == 64;
            this.f = a(z, i3);
        }

        public static int a(List<a> list, List<a> list2) {
            return ((a) Collections.max(list)).compareTo((a) Collections.max(list2));
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compareTo(a aVar) {
            ff1 ff1VarB;
            if (this.g && this.j) {
                ff1VarB = p00.i;
            } else {
                ff1VarB = p00.i.b();
            }
            wq wqVarA = wq.b().a(this.j, aVar.j).a(Integer.valueOf(this.l), Integer.valueOf(aVar.l), ff1.a().b()).a(this.k, aVar.k).a(this.m, aVar.m).a(this.q, aVar.q).a(this.n, aVar.n).a(Integer.valueOf(this.o), Integer.valueOf(aVar.o), ff1.a().b()).a(this.p, aVar.p).a(this.g, aVar.g).a(Integer.valueOf(this.u), Integer.valueOf(aVar.u), ff1.a().b()).a(Integer.valueOf(this.t), Integer.valueOf(aVar.t), this.i.x ? p00.i.b() : p00.j).a(this.v, aVar.v).a(this.w, aVar.w).a(Integer.valueOf(this.r), Integer.valueOf(aVar.r), ff1VarB).a(Integer.valueOf(this.s), Integer.valueOf(aVar.s), ff1VarB);
            Integer numValueOf = Integer.valueOf(this.t);
            Integer numValueOf2 = Integer.valueOf(aVar.t);
            if (!x82.a(this.h, aVar.h)) {
                ff1VarB = p00.j;
            }
            return wqVarA.a(numValueOf, numValueOf2, ff1VarB).a();
        }

        private int a(boolean z, int i) {
            if (!p00.a(this.i.M, i)) {
                return 0;
            }
            if (!this.g && !this.i.G) {
                return 0;
            }
            if (p00.a(false, i) && this.g && this.e.i != -1) {
                c cVar = this.i;
                if (!cVar.y && !cVar.x && (cVar.O || !z)) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // com.yandex.mobile.ads.impl.p00.g
        public final int a() {
            return this.f;
        }

        @Override // com.yandex.mobile.ads.impl.p00.g
        public final boolean a(g gVar) {
            int i;
            String str;
            int i2;
            a aVar = (a) gVar;
            c cVar = this.i;
            if ((cVar.J || ((i2 = this.e.z) != -1 && i2 == aVar.e.z)) && (cVar.H || ((str = this.e.m) != null && TextUtils.equals(str, aVar.e.m)))) {
                c cVar2 = this.i;
                if ((cVar2.I || ((i = this.e.A) != -1 && i == aVar.e.A)) && (cVar2.K || (this.v == aVar.v && this.w == aVar.w))) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class f extends g<f> implements Comparable<f> {
        private final int f;
        private final boolean g;
        private final boolean h;
        private final boolean i;
        private final int j;
        private final int k;
        private final int l;
        private final int m;
        private final boolean n;

        public f(int i, r52 r52Var, int i2, c cVar, int i3, String str) {
            hk0<String> hk0VarA;
            int iA;
            super(i, i2, r52Var);
            int i4 = 0;
            this.g = p00.a(false, i3);
            int i5 = this.e.e & (~cVar.v);
            this.h = (i5 & 1) != 0;
            this.i = (i5 & 2) != 0;
            if (cVar.t.isEmpty()) {
                hk0VarA = hk0.a("");
            } else {
                hk0VarA = cVar.t;
            }
            int i6 = 0;
            while (true) {
                if (i6 >= hk0VarA.size()) {
                    i6 = Integer.MAX_VALUE;
                    iA = 0;
                    break;
                } else {
                    iA = p00.a(this.e, hk0VarA.get(i6), cVar.w);
                    if (iA > 0) {
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            this.j = i6;
            this.k = iA;
            int iA2 = p00.a(this.e.f, cVar.u);
            this.l = iA2;
            this.n = (this.e.f & 1088) != 0;
            int iA3 = p00.a(this.e, str, p00.b(str) == null);
            this.m = iA3;
            boolean z = iA > 0 || (cVar.t.isEmpty() && iA2 > 0) || this.h || (this.i && iA3 > 0);
            if (p00.a(cVar.M, i3) && z) {
                i4 = 1;
            }
            this.f = i4;
        }

        public static int a(List<f> list, List<f> list2) {
            return list.get(0).compareTo(list2.get(0));
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compareTo(f fVar) {
            wq wqVarA = wq.b().a(this.g, fVar.g).a(Integer.valueOf(this.j), Integer.valueOf(fVar.j), ff1.a().b()).a(this.k, fVar.k).a(this.l, fVar.l).a(this.h, fVar.h).a(Boolean.valueOf(this.i), Boolean.valueOf(fVar.i), this.k == 0 ? ff1.a() : ff1.a().b()).a(this.m, fVar.m);
            if (this.l == 0) {
                wqVarA = wqVarA.b(this.n, fVar.n);
            }
            return wqVarA.a();
        }

        @Override // com.yandex.mobile.ads.impl.p00.g
        public final int a() {
            return this.f;
        }

        @Override // com.yandex.mobile.ads.impl.p00.g
        public final /* bridge */ /* synthetic */ boolean a(g gVar) {
            return false;
        }
    }

    private static final class b implements Comparable<b> {
        private final boolean b;
        private final boolean c;

        @Override // java.lang.Comparable
        public final int compareTo(b bVar) {
            b bVar2 = bVar;
            return wq.b().a(this.c, bVar2.c).a(this.b, bVar2.b).a();
        }

        public b(gc0 gc0Var, int i) {
            this.b = (gc0Var.e & 1) != 0;
            this.c = p00.a(false, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(int i2, int i3) {
        if (i2 == 0 || i2 != i3) {
            return Integer.bitCount(i2 & i3);
        }
        return Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(String str) {
        if (str == null) {
            return 0;
        }
        str.hashCode();
        switch (str) {
            case "video/av01":
                return 4;
            case "video/hevc":
                return 3;
            case "video/avc":
                return 1;
            case "video/x-vnd.on2.vp9":
                return 2;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x0063 A[Catch: all -> 0x008d, FALL_THROUGH, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:8:0x000e, B:10:0x0013, B:34:0x0055, B:36:0x0059, B:38:0x005d, B:40:0x0063, B:42:0x0067, B:44:0x006b, B:46:0x0071, B:48:0x0077, B:50:0x007f, B:54:0x008b), top: B:59:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x008a  */
    public boolean a(gc0 gc0Var) {
        boolean z;
        e eVar;
        e eVar2;
        synchronized (this.c) {
            z = true;
            if (this.f.L && !this.e) {
                if (gc0Var.z > 2) {
                    String str = gc0Var.m;
                    if (str != null) {
                        str.hashCode();
                        switch (str) {
                            case "audio/eac3-joc":
                            case "audio/ac3":
                            case "audio/ac4":
                            case "audio/eac3":
                                if (x82.f10629a >= 32 && (eVar2 = this.g) != null && eVar2.b) {
                                }
                            default:
                                if (x82.f10629a < 32) {
                                    z = false;
                                    break;
                                } else {
                                    z = false;
                                    break;
                                }
                                break;
                        }
                    } else if (x82.f10629a < 32 || (eVar = this.g) == null || !eVar.b || !eVar.a() || !this.g.b() || !this.g.a(gc0Var, this.h)) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a(c cVar, boolean z, int i2, r52 r52Var, int[] iArr) {
        sj1 sj1Var = new sj1() { // from class: com.yandex.mobile.ads.impl.p00$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.sj1
            public final boolean apply(Object obj) {
                return this.f$0.a((gc0) obj);
            }
        };
        int i3 = hk0.d;
        hk0.a aVar = new hk0.a();
        for (int i4 = 0; i4 < r52Var.b; i4++) {
            aVar.b(new a(i2, r52Var, i4, cVar, iArr[i4], z, sj1Var));
        }
        return aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0039  */
    public static List a(c cVar, int[] iArr, int i2, r52 r52Var, int[] iArr2) {
        int i3;
        int i4;
        int i5;
        int i6;
        Point point;
        int i7 = iArr[i2];
        int i8 = cVar.j;
        int i9 = cVar.k;
        boolean z = cVar.l;
        boolean z2 = true;
        if (i8 == Integer.MAX_VALUE || i9 == Integer.MAX_VALUE) {
            i3 = Integer.MAX_VALUE;
        } else {
            int i10 = Integer.MAX_VALUE;
            for (int i11 = 0; i11 < r52Var.b; i11++) {
                gc0 gc0VarA = r52Var.a(i11);
                int i12 = gc0VarA.r;
                if (i12 > 0 && (i4 = gc0VarA.s) > 0) {
                    if (!z) {
                        i5 = i8;
                        i6 = i9;
                    } else if ((i12 > i4) != (i8 > i9)) {
                        i6 = i8;
                        i5 = i9;
                    } else {
                        i5 = i8;
                        i6 = i9;
                    }
                    int i13 = i12 * i6;
                    int i14 = i4 * i5;
                    if (i13 >= i14) {
                        int i15 = x82.f10629a;
                        point = new Point(i5, ((i14 + i12) - 1) / i12);
                    } else {
                        int i16 = x82.f10629a;
                        point = new Point(((i13 + i4) - 1) / i4, i6);
                    }
                    int i17 = gc0VarA.r;
                    int i18 = gc0VarA.s;
                    int i19 = i17 * i18;
                    if (i17 >= ((int) (point.x * 0.98f)) && i18 >= ((int) (point.y * 0.98f)) && i19 < i10) {
                        i10 = i19;
                    }
                }
            }
            i3 = i10;
        }
        int i20 = hk0.d;
        hk0.a aVar = new hk0.a();
        int i21 = 0;
        while (i21 < r52Var.b) {
            int iB = r52Var.a(i21).b();
            aVar.b(new h(i2, r52Var, i21, cVar, iArr2[i21], i7, (i3 == Integer.MAX_VALUE || (iB != -1 && iB <= i3)) ? z2 : false));
            i21++;
            z2 = true;
        }
        return aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    protected final Pair a(yt0.a aVar, int[][][] iArr, final c cVar) throws j60 {
        final boolean z = false;
        for (int i2 = 0; i2 < aVar.a(); i2++) {
            if (2 == aVar.a(i2) && aVar.b(i2).b > 0) {
                z = true;
                break;
            }
        }
        return a(1, aVar, iArr, new g.a() { // from class: com.yandex.mobile.ads.impl.p00$$ExternalSyntheticLambda7
            @Override // com.yandex.mobile.ads.impl.p00.g.a
            public final List a(int i3, r52 r52Var, int[] iArr2) {
                return this.f$0.a(cVar, z, i3, r52Var, iArr2);
            }
        }, new Comparator() { // from class: com.yandex.mobile.ads.impl.p00$$ExternalSyntheticLambda8
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return p00.a.a((List<p00.a>) obj, (List<p00.a>) obj2);
            }
        });
    }

    protected static Pair a(yt0.a aVar, int[][][] iArr, final c cVar, final String str) throws j60 {
        return a(3, aVar, iArr, new g.a() { // from class: com.yandex.mobile.ads.impl.p00$$ExternalSyntheticLambda1
            @Override // com.yandex.mobile.ads.impl.p00.g.a
            public final List a(int i2, r52 r52Var, int[] iArr2) {
                return p00.a(cVar, str, i2, r52Var, iArr2);
            }
        }, new Comparator() { // from class: com.yandex.mobile.ads.impl.p00$$ExternalSyntheticLambda2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return p00.f.a((List) obj, (List) obj2);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.yt0
    protected final Pair<to1[], e70[]> a(yt0.a aVar, int[][][] iArr, int[] iArr2, rw0.b bVar, b52 b52Var) throws j60 {
        c cVar;
        String str;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        r52 r52Var;
        s52 s52Var;
        e eVar;
        synchronized (this.c) {
            cVar = this.f;
            if (cVar.L && x82.f10629a >= 32 && (eVar = this.g) != null) {
                Looper looperMyLooper = Looper.myLooper();
                if (looperMyLooper != null) {
                    eVar.a(this, looperMyLooper);
                } else {
                    throw new IllegalStateException();
                }
            }
        }
        int iA = aVar.a();
        int iA2 = aVar.a();
        e70.a[] aVarArr = new e70.a[iA2];
        Pair pairA = a(aVar, iArr, iArr2, cVar);
        if (pairA != null) {
            aVarArr[((Integer) pairA.second).intValue()] = (e70.a) pairA.first;
        }
        Pair pairA2 = a(aVar, iArr, cVar);
        if (pairA2 != null) {
            aVarArr[((Integer) pairA2.second).intValue()] = (e70.a) pairA2.first;
        }
        int i6 = 0;
        if (pairA2 == null) {
            str = null;
        } else {
            e70.a aVar2 = (e70.a) pairA2.first;
            str = aVar2.f8769a.a(aVar2.b[0]).d;
        }
        Pair pairA3 = a(aVar, iArr, cVar, str);
        if (pairA3 != null) {
            aVarArr[((Integer) pairA3.second).intValue()] = (e70.a) pairA3.first;
        }
        int i7 = 0;
        while (true) {
            i2 = 2;
            if (i7 >= iA2) {
                break;
            }
            int iA3 = aVar.a(i7);
            if (iA3 == 2 || iA3 == 1 || iA3 == 3) {
                i5 = iA2;
            } else {
                s52 s52VarB = aVar.b(i7);
                int[][] iArr3 = iArr[i7];
                int i8 = i6;
                int i9 = i8;
                r52 r52Var2 = null;
                b bVar2 = null;
                while (i8 < s52VarB.b) {
                    r52 r52VarA = s52VarB.a(i8);
                    int[] iArr4 = iArr3[i8];
                    int i10 = i6;
                    while (i10 < r52VarA.b) {
                        int i11 = iA2;
                        if (a(cVar.M, iArr4[i10])) {
                            r52Var = r52VarA;
                            b bVar3 = new b(r52VarA.a(i10), iArr4[i10]);
                            if (bVar2 != null) {
                                s52Var = s52VarB;
                                if (wq.b().a(bVar3.c, bVar2.c).a(bVar3.b, bVar2.b).a() > 0) {
                                }
                            } else {
                                s52Var = s52VarB;
                            }
                            i9 = i10;
                            bVar2 = bVar3;
                            r52Var2 = r52Var;
                        } else {
                            r52Var = r52VarA;
                            s52Var = s52VarB;
                        }
                        i10++;
                        iA2 = i11;
                        r52VarA = r52Var;
                        s52VarB = s52Var;
                    }
                    i8++;
                    i6 = 0;
                }
                i5 = iA2;
                aVarArr[i7] = r52Var2 == null ? null : new e70.a(0, r52Var2, new int[]{i9});
            }
            i7++;
            iA2 = i5;
            i6 = 0;
        }
        int iA4 = aVar.a();
        HashMap map = new HashMap();
        for (int i12 = 0; i12 < iA4; i12++) {
            a(aVar.b(i12), cVar, map);
        }
        a(aVar.b(), cVar, map);
        int i13 = 0;
        while (true) {
            i3 = -1;
            if (i13 >= iA4) {
                break;
            }
            w52 w52Var = (w52) map.get(Integer.valueOf(aVar.a(i13)));
            if (w52Var != null) {
                aVarArr[i13] = (w52Var.c.isEmpty() || aVar.b(i13).a(w52Var.b) == -1) ? null : new e70.a(0, w52Var.b, dq0.a(w52Var.c));
            }
            i13++;
        }
        int i14 = 0;
        int iA5 = aVar.a();
        for (int i15 = 0; i15 < iA5; i15++) {
            s52 s52VarB2 = aVar.b(i15);
            Map map2 = (Map) cVar.P.get(i15);
            if (map2 != null && map2.containsKey(s52VarB2)) {
                Map map3 = (Map) cVar.P.get(i15);
                d dVar = map3 != null ? (d) map3.get(s52VarB2) : null;
                aVarArr[i15] = (dVar == null || dVar.c.length == 0) ? null : new e70.a(dVar.d, s52VarB2.a(dVar.b), dVar.c);
            }
        }
        for (int i16 = 0; i16 < iA; i16++) {
            int iA6 = aVar.a(i16);
            if (cVar.Q.get(i16) || cVar.A.contains(Integer.valueOf(iA6))) {
                aVarArr[i16] = null;
            }
        }
        e70[] e70VarArrA = ((za.b) this.d).a(aVarArr, a());
        to1[] to1VarArr = new to1[iA];
        for (int i17 = 0; i17 < iA; i17++) {
            to1VarArr[i17] = (cVar.Q.get(i17) || cVar.A.contains(Integer.valueOf(aVar.a(i17))) || (aVar.a(i17) != -2 && e70VarArrA[i17] == null)) ? null : to1.b;
        }
        if (cVar.N) {
            int i18 = -1;
            int i19 = -1;
            int i20 = 0;
            while (true) {
                if (i20 >= aVar.a()) {
                    i4 = i3;
                    z = true;
                    break;
                }
                int iA7 = aVar.a(i20);
                e70 e70Var = e70VarArrA[i20];
                if ((iA7 == 1 || iA7 == i2) && e70Var != null) {
                    int[][] iArr5 = iArr[i20];
                    int iA8 = aVar.b(i20).a(e70Var.a());
                    int i21 = i14;
                    while (true) {
                        if (i21 >= e70Var.b()) {
                            if (iA7 != 1) {
                                i4 = -1;
                                if (i19 == -1) {
                                    i19 = i20;
                                    break;
                                }
                                z = false;
                                break;
                            }
                            i4 = -1;
                            if (i18 == -1) {
                                i18 = i20;
                                break;
                            }
                            z = false;
                            break;
                        }
                        if ((iArr5[iA8][e70Var.b(i21)] & 32) != 32) {
                            i4 = -1;
                            break;
                        }
                        i21++;
                    }
                } else {
                    i4 = i3;
                }
                i20++;
                i3 = i4;
                i2 = 2;
                i14 = 0;
            }
            if (z & ((i18 == i4 || i19 == i4) ? false : true)) {
                to1 to1Var = new to1(true);
                to1VarArr[i18] = to1Var;
                to1VarArr[i19] = to1Var;
            }
        }
        return Pair.create(to1VarArr, e70VarArrA);
    }

    private static Pair a(int i2, yt0.a aVar, int[][][] iArr, g.a aVar2, Comparator comparator) {
        int i3;
        RandomAccess randomAccessA;
        ArrayList arrayList = new ArrayList();
        int iA = aVar.a();
        int i4 = 0;
        while (i4 < iA) {
            if (i2 == aVar.a(i4)) {
                s52 s52VarB = aVar.b(i4);
                for (int i5 = 0; i5 < s52VarB.b; i5++) {
                    r52 r52VarA = s52VarB.a(i5);
                    List listA = aVar2.a(i4, r52VarA, iArr[i4][i5]);
                    boolean[] zArr = new boolean[r52VarA.b];
                    int i6 = 0;
                    while (i6 < r52VarA.b) {
                        g gVar = (g) listA.get(i6);
                        int iA2 = gVar.a();
                        if (zArr[i6] || iA2 == 0) {
                            i3 = iA;
                        } else {
                            if (iA2 == 1) {
                                randomAccessA = hk0.a(gVar);
                                i3 = iA;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(gVar);
                                int i7 = i6 + 1;
                                while (i7 < r52VarA.b) {
                                    g gVar2 = (g) listA.get(i7);
                                    int i8 = iA;
                                    if (gVar2.a() == 2 && gVar.a(gVar2)) {
                                        arrayList2.add(gVar2);
                                        zArr[i7] = true;
                                    }
                                    i7++;
                                    iA = i8;
                                }
                                i3 = iA;
                                randomAccessA = arrayList2;
                            }
                            arrayList.add(randomAccessA);
                        }
                        i6++;
                        iA = i3;
                    }
                }
            }
            i4++;
            iA = iA;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i9 = 0; i9 < list.size(); i9++) {
            iArr2[i9] = ((g) list.get(i9)).d;
        }
        g gVar3 = (g) list.get(0);
        return Pair.create(new e70.a(0, gVar3.c, iArr2), Integer.valueOf(gVar3.b));
    }

    protected static Pair a(yt0.a aVar, int[][][] iArr, final int[] iArr2, final c cVar) throws j60 {
        return a(2, aVar, iArr, new g.a() { // from class: com.yandex.mobile.ads.impl.p00$$ExternalSyntheticLambda5
            @Override // com.yandex.mobile.ads.impl.p00.g.a
            public final List a(int i2, r52 r52Var, int[] iArr3) {
                return p00.a(cVar, iArr2, i2, r52Var, iArr3);
            }
        }, new Comparator() { // from class: com.yandex.mobile.ads.impl.p00$$ExternalSyntheticLambda6
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return p00.h.a((List<p00.h>) obj, (List<p00.h>) obj2);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.y52
    public final void a(oh ohVar) {
        boolean zEquals;
        synchronized (this.c) {
            zEquals = this.h.equals(ohVar);
            this.h = ohVar;
        }
        if (zEquals) {
            return;
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List a(c cVar, String str, int i2, r52 r52Var, int[] iArr) {
        int i3 = hk0.d;
        hk0.a aVar = new hk0.a();
        for (int i4 = 0; i4 < r52Var.b; i4++) {
            aVar.b(new f(i2, r52Var, i4, cVar, iArr[i4], str));
        }
        return aVar.a();
    }
}
