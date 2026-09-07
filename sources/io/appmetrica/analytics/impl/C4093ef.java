package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ef, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4093ef implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Integer fromModel(X7 x7) {
        int iOrdinal = x7.ordinal();
        if (iOrdinal == 1) {
            return 1;
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? 0 : 2;
        }
        return 3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final X7 toModel(Integer num) {
        int iIntValue = num.intValue();
        if (iIntValue == 1) {
            return X7.c;
        }
        if (iIntValue == 2) {
            return X7.e;
        }
        if (iIntValue != 3) {
            return X7.b;
        }
        return X7.d;
    }
}
