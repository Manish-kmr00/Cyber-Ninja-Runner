package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import com.json.mediationsdk.logger.IronSourceError;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public final class xh1 implements jm {
    public static final xh1 e = new xh1(1.0f, 1.0f);
    public final float b;
    public final float c;
    private final int d;

    static {
        new jm.a() { // from class: com.yandex.mobile.ads.impl.xh1$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.jm.a
            public final jm fromBundle(Bundle bundle) {
                return xh1.a(bundle);
            }
        };
    }

    public xh1(float f, float f2) {
        hg.a(f > 0.0f);
        hg.a(f2 > 0.0f);
        this.b = f;
        this.c = f2;
        this.d = Math.round(f * 1000.0f);
    }

    public final long a(long j) {
        return j * ((long) this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static xh1 a(Bundle bundle) {
        return new xh1(bundle.getFloat(Integer.toString(0, 36), 1.0f), bundle.getFloat(Integer.toString(1, 36), 1.0f));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || xh1.class != obj.getClass()) {
            return false;
        }
        xh1 xh1Var = (xh1) obj;
        return this.b == xh1Var.b && this.c == xh1Var.c;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.c) + ((Float.floatToRawIntBits(this.b) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31);
    }

    public final String toString() {
        Object[] objArr = {Float.valueOf(this.b), Float.valueOf(this.c)};
        int i = x82.f10629a;
        return String.format(Locale.US, "PlaybackParameters(speed=%.2f, pitch=%.2f)", objArr);
    }
}
