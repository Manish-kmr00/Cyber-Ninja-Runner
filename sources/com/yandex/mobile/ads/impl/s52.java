package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public final class s52 implements jm {
    public static final s52 e = new s52(new r52[0]);
    public static final jm.a<s52> f = new jm.a() { // from class: com.yandex.mobile.ads.impl.s52$$ExternalSyntheticLambda0
        @Override // com.yandex.mobile.ads.impl.jm.a
        public final jm fromBundle(Bundle bundle) {
            return s52.a(bundle);
        }
    };
    public final int b;
    private final hk0<r52> c;
    private int d;

    public s52(r52... r52VarArr) {
        this.c = hk0.b(r52VarArr);
        this.b = r52VarArr.length;
        a();
    }

    public final r52 a(int i) {
        return this.c.get(i);
    }

    public final int hashCode() {
        if (this.d == 0) {
            this.d = this.c.hashCode();
        }
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s52.class != obj.getClass()) {
            return false;
        }
        s52 s52Var = (s52) obj;
        return this.b == s52Var.b && this.c.equals(s52Var.c);
    }

    public final int a(r52 r52Var) {
        int iIndexOf = this.c.indexOf(r52Var);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static s52 a(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(Integer.toString(0, 36));
        if (parcelableArrayList == null) {
            return new s52(new r52[0]);
        }
        return new s52((r52[]) km.a(r52.g, parcelableArrayList).toArray(new r52[0]));
    }

    private void a() {
        int i = 0;
        while (i < this.c.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.c.size(); i3++) {
                if (this.c.get(i).equals(this.c.get(i3))) {
                    at0.a("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i2;
        }
    }
}
