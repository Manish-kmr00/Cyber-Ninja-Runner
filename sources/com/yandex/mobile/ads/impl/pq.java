package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import com.json.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class pq implements jm {
    public static final jm.a<pq> g = new jm.a() { // from class: com.yandex.mobile.ads.impl.pq$$ExternalSyntheticLambda0
        @Override // com.yandex.mobile.ads.impl.jm.a
        public final jm fromBundle(Bundle bundle) {
            return pq.a(bundle);
        }
    };
    public final int b;
    public final int c;
    public final int d;
    public final byte[] e;
    private int f;

    /* JADX INFO: Access modifiers changed from: private */
    public static pq a(Bundle bundle) {
        return new pq(bundle.getInt(Integer.toString(0, 36), -1), bundle.getInt(Integer.toString(1, 36), -1), bundle.getInt(Integer.toString(2, 36), -1), bundle.getByteArray(Integer.toString(3, 36)));
    }

    public pq(int i, int i2, int i3, byte[] bArr) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || pq.class != obj.getClass()) {
            return false;
        }
        pq pqVar = (pq) obj;
        return this.b == pqVar.b && this.c == pqVar.c && this.d == pqVar.d && Arrays.equals(this.e, pqVar.e);
    }

    public final String toString() {
        return "ColorInfo(" + this.b + ", " + this.c + ", " + this.d + ", " + (this.e != null) + ")";
    }

    public final int hashCode() {
        if (this.f == 0) {
            this.f = Arrays.hashCode(this.e) + ((((((this.b + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.c) * 31) + this.d) * 31);
        }
        return this.f;
    }
}
