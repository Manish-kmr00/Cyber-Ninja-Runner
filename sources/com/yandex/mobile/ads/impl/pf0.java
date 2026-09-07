package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: loaded from: classes13.dex */
public final class pf0 extends dn1 {
    public static final jm.a<pf0> e = new jm.a() { // from class: com.yandex.mobile.ads.impl.pf0$$ExternalSyntheticLambda0
        @Override // com.yandex.mobile.ads.impl.jm.a
        public final jm fromBundle(Bundle bundle) {
            return pf0.b(bundle);
        }
    };
    private final boolean c;
    private final boolean d;

    /* JADX INFO: Access modifiers changed from: private */
    public static pf0 b(Bundle bundle) {
        if (bundle.getInt(Integer.toString(0, 36), -1) == 0) {
            return bundle.getBoolean(Integer.toString(1, 36), false) ? new pf0(bundle.getBoolean(Integer.toString(2, 36), false)) : new pf0();
        }
        throw new IllegalArgumentException();
    }

    public pf0() {
        this.c = false;
        this.d = false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.c), Boolean.valueOf(this.d)});
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof pf0)) {
            return false;
        }
        pf0 pf0Var = (pf0) obj;
        return this.d == pf0Var.d && this.c == pf0Var.c;
    }

    public pf0(boolean z) {
        this.c = true;
        this.d = z;
    }
}
