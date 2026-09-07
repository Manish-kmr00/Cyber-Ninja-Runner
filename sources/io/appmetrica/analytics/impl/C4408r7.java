package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.r7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4408r7 implements Converter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4067de f11745a;

    public C4408r7() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4508v7 fromModel(C4384q7 c4384q7) {
        C4508v7 c4508v7 = new C4508v7();
        Boolean bool = c4384q7.f11732a;
        if (bool != null) {
            c4508v7.f11812a = this.f11745a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Double d = c4384q7.c;
        if (d != null) {
            c4508v7.c = d.doubleValue();
        }
        Double d2 = c4384q7.b;
        if (d2 != null) {
            c4508v7.b = d2.doubleValue();
        }
        Long l = c4384q7.h;
        if (l != null) {
            c4508v7.h = l.longValue();
        }
        Integer num = c4384q7.f;
        if (num != null) {
            c4508v7.f = num.intValue();
        }
        Integer num2 = c4384q7.e;
        if (num2 != null) {
            c4508v7.e = num2.intValue();
        }
        Integer num3 = c4384q7.g;
        if (num3 != null) {
            c4508v7.g = num3.intValue();
        }
        Integer num4 = c4384q7.d;
        if (num4 != null) {
            c4508v7.d = num4.intValue();
        }
        String str = c4384q7.i;
        if (str != null) {
            c4508v7.i = str;
        }
        String str2 = c4384q7.j;
        if (str2 != null) {
            c4508v7.j = str2;
        }
        return c4508v7;
    }

    public C4408r7(C4067de c4067de) {
        this.f11745a = c4067de;
    }

    public /* synthetic */ C4408r7(C4067de c4067de, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C4067de() : c4067de);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4384q7 toModel(C4508v7 c4508v7) {
        if (c4508v7 == null) {
            return new C4384q7(null, null, null, null, null, null, null, null, null, null);
        }
        C4508v7 c4508v8 = new C4508v7();
        Boolean boolA = this.f11745a.a(c4508v7.f11812a);
        Double dValueOf = Double.valueOf(c4508v7.c);
        if (dValueOf.doubleValue() == c4508v8.c) {
            dValueOf = null;
        }
        Double dValueOf2 = Double.valueOf(c4508v7.b);
        Double d = !(dValueOf2.doubleValue() == c4508v8.b) ? dValueOf2 : null;
        Long lValueOf = Long.valueOf(c4508v7.h);
        Long l = lValueOf.longValue() != c4508v8.h ? lValueOf : null;
        Integer numValueOf = Integer.valueOf(c4508v7.f);
        Integer num = numValueOf.intValue() != c4508v8.f ? numValueOf : null;
        Integer numValueOf2 = Integer.valueOf(c4508v7.e);
        Integer num2 = numValueOf2.intValue() != c4508v8.e ? numValueOf2 : null;
        Integer numValueOf3 = Integer.valueOf(c4508v7.g);
        Integer num3 = numValueOf3.intValue() != c4508v8.g ? numValueOf3 : null;
        Integer numValueOf4 = Integer.valueOf(c4508v7.d);
        Integer num4 = numValueOf4.intValue() != c4508v8.d ? numValueOf4 : null;
        String str = c4508v7.i;
        String str2 = !Intrinsics.areEqual(str, c4508v8.i) ? str : null;
        String str3 = c4508v7.j;
        return new C4384q7(boolA, d, dValueOf, num4, num2, num, num3, l, str2, !Intrinsics.areEqual(str3, c4508v8.j) ? str3 : null);
    }
}
