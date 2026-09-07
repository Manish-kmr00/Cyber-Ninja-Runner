package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class g22 extends dn1 {
    public static final jm.a<g22> e = new jm.a() { // from class: com.yandex.mobile.ads.impl.g22$$ExternalSyntheticLambda0
        @Override // com.yandex.mobile.ads.impl.jm.a
        public final jm fromBundle(Bundle bundle) {
            return g22.b(bundle);
        }
    };
    private final int c;
    private final float d;

    /* JADX INFO: Access modifiers changed from: private */
    public static g22 b(Bundle bundle) {
        if (bundle.getInt(Integer.toString(0, 36), -1) != 2) {
            throw new IllegalArgumentException();
        }
        int i = bundle.getInt(Integer.toString(1, 36), 5);
        float f = bundle.getFloat(Integer.toString(2, 36), -1.0f);
        return f == -1.0f ? new g22(i) : new g22(i, f);
    }

    public g22(int i) {
        hg.a("maxStars must be a positive integer", i > 0);
        this.c = i;
        this.d = -1.0f;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.c), Float.valueOf(this.d)});
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g22)) {
            return false;
        }
        g22 g22Var = (g22) obj;
        return this.c == g22Var.c && this.d == g22Var.d;
    }

    public g22(int i, float f) {
        hg.a("maxStars must be a positive integer", i > 0);
        hg.a("starRating is out of range [0, maxStars]", f >= 0.0f && f <= ((float) i));
        this.c = i;
        this.d = f;
    }
}
