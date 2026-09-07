package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public final class w52 implements jm {
    public static final jm.a<w52> d = new jm.a() { // from class: com.yandex.mobile.ads.impl.w52$$ExternalSyntheticLambda0
        @Override // com.yandex.mobile.ads.impl.jm.a
        public final jm fromBundle(Bundle bundle) {
            return w52.a(bundle);
        }
    };
    public final r52 b;
    public final hk0<Integer> c;

    /* JADX INFO: Access modifiers changed from: private */
    public static w52 a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(Integer.toString(0, 36));
        bundle2.getClass();
        r52 r52Var = (r52) r52.g.fromBundle(bundle2);
        int[] intArray = bundle.getIntArray(Integer.toString(1, 36));
        intArray.getClass();
        return new w52(r52Var, dq0.a(intArray));
    }

    public w52(r52 r52Var, List<Integer> list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= r52Var.b)) {
            throw new IndexOutOfBoundsException();
        }
        this.b = r52Var;
        this.c = hk0.a((Collection) list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w52.class != obj.getClass()) {
            return false;
        }
        w52 w52Var = (w52) obj;
        return this.b.equals(w52Var.b) && this.c.equals(w52Var.c);
    }

    public final int hashCode() {
        return (this.c.hashCode() * 31) + this.b.hashCode();
    }
}
