package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: loaded from: classes8.dex */
public final class s42 extends dn1 {
    public static final jm.a<s42> e = new jm.a() { // from class: com.yandex.mobile.ads.impl.s42$$ExternalSyntheticLambda0
        @Override // com.yandex.mobile.ads.impl.jm.a
        public final jm fromBundle(Bundle bundle) {
            return s42.b(bundle);
        }
    };
    private final boolean c;
    private final boolean d;

    /* JADX INFO: Access modifiers changed from: private */
    public static s42 b(Bundle bundle) {
        if (bundle.getInt(Integer.toString(0, 36), -1) == 3) {
            return bundle.getBoolean(Integer.toString(1, 36), false) ? new s42(bundle.getBoolean(Integer.toString(2, 36), false)) : new s42();
        }
        throw new IllegalArgumentException();
    }

    public s42() {
        this.c = false;
        this.d = false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.c), Boolean.valueOf(this.d)});
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof s42)) {
            return false;
        }
        s42 s42Var = (s42) obj;
        return this.d == s42Var.d && this.c == s42Var.c;
    }

    public s42(boolean z) {
        this.c = true;
        this.d = z;
    }
}
