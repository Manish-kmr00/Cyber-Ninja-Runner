package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class D7 implements ProtobufConverter {
    public final BigDecimal a(C4285m8 c4285m8) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4285m8 fromModel(BigDecimal bigDecimal) {
        BigInteger bigInteger = F7.f11136a;
        int i = -bigDecimal.scale();
        BigInteger bigIntegerUnscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (bigIntegerUnscaledValue.compareTo(F7.f11136a) <= 0 && bigIntegerUnscaledValue.compareTo(F7.b) >= 0) {
                Pair pair = TuplesKt.to(Long.valueOf(bigIntegerUnscaledValue.longValue()), Integer.valueOf(i));
                E7 e7 = new E7(((Number) pair.getSecond()).intValue(), ((Number) pair.getFirst()).longValue());
                C4285m8 c4285m8 = new C4285m8();
                c4285m8.f11667a = e7.f11118a;
                c4285m8.b = e7.b;
                return c4285m8;
            }
            bigIntegerUnscaledValue = bigIntegerUnscaledValue.divide(BigInteger.TEN);
            i++;
        }
    }
}
