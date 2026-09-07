package com.inmobi.media;

import java.util.BitSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class V3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K1 f3216a;

    public V3(String b64feature) {
        Intrinsics.checkNotNullParameter(b64feature, "b64feature");
        K1 k1 = new K1();
        this.f3216a = k1;
        k1.a(b64feature);
    }

    public final boolean a(boolean z) {
        BitSet bitSet = this.f3216a.f3110a;
        return bitSet != null ? bitSet.get(0) : z;
    }
}
