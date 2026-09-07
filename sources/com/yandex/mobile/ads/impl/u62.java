package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: loaded from: classes7.dex */
public final class u62 implements jm {
    public static final u62 c = new u62(hk0.h());
    private final hk0<a> b;

    static {
        new jm.a() { // from class: com.yandex.mobile.ads.impl.u62$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.jm.a
            public final jm fromBundle(Bundle bundle) {
                return u62.a(bundle);
            }
        };
    }

    public u62(hk0 hk0Var) {
        this.b = hk0.a((Collection) hk0Var);
    }

    public static final class a implements jm {
        public static final jm.a<a> g = new jm.a() { // from class: com.yandex.mobile.ads.impl.u62$a$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.jm.a
            public final jm fromBundle(Bundle bundle) {
                return u62.a.a(bundle);
            }
        };
        public final int b;
        private final r52 c;
        private final boolean d;
        private final int[] e;
        private final boolean[] f;

        public a(r52 r52Var, boolean z, int[] iArr, boolean[] zArr) {
            int i = r52Var.b;
            this.b = i;
            boolean z2 = false;
            hg.a(i == iArr.length && i == zArr.length);
            this.c = r52Var;
            if (z && i > 1) {
                z2 = true;
            }
            this.d = z2;
            this.e = (int[]) iArr.clone();
            this.f = (boolean[]) zArr.clone();
        }

        public final gc0 a(int i) {
            return this.c.a(i);
        }

        public final boolean b() {
            for (boolean z : this.f) {
                if (z) {
                    return true;
                }
            }
            return false;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.d == aVar.d && this.c.equals(aVar.c) && Arrays.equals(this.e, aVar.e) && Arrays.equals(this.f, aVar.f);
        }

        public final int hashCode() {
            return Arrays.hashCode(this.f) + ((Arrays.hashCode(this.e) + (((this.c.hashCode() * 31) + (this.d ? 1 : 0)) * 31)) * 31);
        }

        public final int a() {
            return this.c.d;
        }

        public final boolean b(int i) {
            return this.f[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a a(Bundle bundle) {
            jm.a<r52> aVar = r52.g;
            Bundle bundle2 = bundle.getBundle(Integer.toString(0, 36));
            bundle2.getClass();
            r52 r52Var = (r52) aVar.fromBundle(bundle2);
            int[] intArray = bundle.getIntArray(Integer.toString(1, 36));
            int[] iArr = new int[r52Var.b];
            if (intArray == null) {
                intArray = iArr;
            }
            boolean[] booleanArray = bundle.getBooleanArray(Integer.toString(3, 36));
            boolean[] zArr = new boolean[r52Var.b];
            if (booleanArray == null) {
                booleanArray = zArr;
            }
            return new a(r52Var, bundle.getBoolean(Integer.toString(4, 36), false), intArray, booleanArray);
        }
    }

    public final hk0<a> a() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u62.class != obj.getClass()) {
            return false;
        }
        return this.b.equals(((u62) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final boolean a(int i) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            a aVar = this.b.get(i2);
            if (aVar.b() && aVar.a() == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static u62 a(Bundle bundle) {
        hk0 hk0VarA;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(Integer.toString(0, 36));
        if (parcelableArrayList == null) {
            hk0VarA = hk0.h();
        } else {
            hk0VarA = km.a(a.g, parcelableArrayList);
        }
        return new u62(hk0VarA);
    }
}
