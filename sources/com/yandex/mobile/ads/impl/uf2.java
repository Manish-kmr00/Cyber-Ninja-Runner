package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: loaded from: classes11.dex */
public final class uf2 implements jm {
    public static final /* synthetic */ int f = 0;
    public final int b;
    public final int c;
    public final int d;
    public final float e;

    static {
        new jm.a() { // from class: com.yandex.mobile.ads.impl.uf2$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.jm.a
            public final jm fromBundle(Bundle bundle) {
                return uf2.a(bundle);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static uf2 a(Bundle bundle) {
        return new uf2(bundle.getInt(Integer.toString(0, 36), 0), bundle.getInt(Integer.toString(1, 36), 0), bundle.getInt(Integer.toString(2, 36), 0), bundle.getFloat(Integer.toString(3, 36), 1.0f));
    }

    public uf2(int i, int i2, int i3, float f2) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uf2)) {
            return false;
        }
        uf2 uf2Var = (uf2) obj;
        return this.b == uf2Var.b && this.c == uf2Var.c && this.d == uf2Var.d && this.e == uf2Var.e;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.e) + ((((((this.b + Sdk.SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE) * 31) + this.c) * 31) + this.d) * 31);
    }
}
