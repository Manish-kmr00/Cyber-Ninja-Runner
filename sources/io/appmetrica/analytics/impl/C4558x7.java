package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.x7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4558x7 implements ProtobufConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4067de f11841a;

    public C4558x7() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4533w7 fromModel(C4608z7 c4608z7) {
        C4533w7 c4533w7 = new C4533w7();
        Long l = c4608z7.f11871a;
        if (l != null) {
            c4533w7.f11828a = l.longValue();
        }
        Long l2 = c4608z7.b;
        if (l2 != null) {
            c4533w7.b = l2.longValue();
        }
        Boolean bool = c4608z7.c;
        if (bool != null) {
            c4533w7.c = this.f11841a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        return c4533w7;
    }

    public C4558x7(C4067de c4067de) {
        this.f11841a = c4067de;
    }

    public /* synthetic */ C4558x7(C4067de c4067de, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C4067de() : c4067de);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4608z7 toModel(C4533w7 c4533w7) {
        C4533w7 c4533w8 = new C4533w7();
        Long lValueOf = Long.valueOf(c4533w7.f11828a);
        if (lValueOf.longValue() == c4533w8.f11828a) {
            lValueOf = null;
        }
        Long lValueOf2 = Long.valueOf(c4533w7.b);
        return new C4608z7(lValueOf, lValueOf2.longValue() != c4533w8.b ? lValueOf2 : null, this.f11841a.a(c4533w7.c));
    }
}
