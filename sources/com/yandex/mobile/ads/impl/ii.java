package com.yandex.mobile.ads.impl;

import com.json.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes2.dex */
public final class ii {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9222a = 0;
    public final float b = 0.0f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ii.class != obj.getClass()) {
            return false;
        }
        ii iiVar = (ii) obj;
        return this.f9222a == iiVar.f9222a && Float.compare(iiVar.b, this.b) == 0;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.b) + ((this.f9222a + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31);
    }
}
