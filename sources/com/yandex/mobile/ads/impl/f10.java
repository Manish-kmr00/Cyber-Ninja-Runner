package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import com.json.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes8.dex */
public final class f10 implements jm {
    public final int b;
    public final int c;
    public final int d;

    static {
        new jm.a() { // from class: com.yandex.mobile.ads.impl.f10$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.jm.a
            public final jm fromBundle(Bundle bundle) {
                return f10.a(bundle);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static f10 a(Bundle bundle) {
        return new f10(bundle.getInt(Integer.toString(0, 36), 0), bundle.getInt(Integer.toString(1, 36), 0), bundle.getInt(Integer.toString(2, 36), 0));
    }

    public f10(int i, int i2, int i3) {
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f10)) {
            return false;
        }
        f10 f10Var = (f10) obj;
        return this.b == f10Var.b && this.c == f10Var.c && this.d == f10Var.d;
    }

    public final int hashCode() {
        return ((((this.b + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.c) * 31) + this.d;
    }
}
