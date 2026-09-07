package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class og1 extends dn1 {
    public static final jm.a<og1> d = new jm.a() { // from class: com.yandex.mobile.ads.impl.og1$$ExternalSyntheticLambda0
        @Override // com.yandex.mobile.ads.impl.jm.a
        public final jm fromBundle(Bundle bundle) {
            return og1.b(bundle);
        }
    };
    private final float c;

    /* JADX INFO: Access modifiers changed from: private */
    public static og1 b(Bundle bundle) {
        if (bundle.getInt(Integer.toString(0, 36), -1) != 1) {
            throw new IllegalArgumentException();
        }
        float f = bundle.getFloat(Integer.toString(1, 36), -1.0f);
        return f == -1.0f ? new og1() : new og1(f);
    }

    public og1() {
        this.c = -1.0f;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.c)});
    }

    public final boolean equals(Object obj) {
        return (obj instanceof og1) && this.c == ((og1) obj).c;
    }

    public og1(float f) {
        hg.a("percent must be in the range of [0, 100]", f >= 0.0f && f <= 100.0f);
        this.c = f;
    }
}
