package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class Cd implements ProtobufConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bd f11088a = new Bd();
    public static final Map b = MapsKt.mapOf(TuplesKt.to(NativeCrashSource.UNKNOWN, 0), TuplesKt.to(NativeCrashSource.CRASHPAD, 3));

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4134g6 fromModel(Fd fd) {
        C4134g6 c4134g6 = new C4134g6();
        c4134g6.f = 1;
        C4109f6 c4109f6 = new C4109f6();
        c4109f6.f11545a = fd.f11140a;
        C4208j6 c4208j6 = new C4208j6();
        Integer num = (Integer) b.get(fd.b.f11122a);
        if (num != null) {
            c4208j6.f11612a = num.intValue();
        }
        String str = fd.b.b;
        if (str == null) {
            str = "";
        }
        c4208j6.b = str;
        c4109f6.b = c4208j6;
        c4134g6.g = c4109f6;
        return c4134g6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final Fd a(C4134g6 c4134g6) {
        throw new UnsupportedOperationException();
    }
}
