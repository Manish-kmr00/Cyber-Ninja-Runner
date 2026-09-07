package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.mf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4292mf extends C4561xa {
    public C4292mf(int i) {
        super(i);
    }

    @Override // io.appmetrica.analytics.impl.C4561xa
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int b(V v) {
        if (v == null) {
            return 0;
        }
        return StringUtils.getUtf8BytesLength(v.b) + 12;
    }
}
