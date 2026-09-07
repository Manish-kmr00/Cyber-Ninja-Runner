package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.j7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4209j7 implements ProtobufConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4067de f11613a;
    public final C4408r7 b;

    public C4209j7() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4483u7 fromModel(C4259l7 c4259l7) {
        C4483u7 c4483u7 = new C4483u7();
        Integer num = c4259l7.f11646a;
        if (num != null) {
            c4483u7.f11794a = num.intValue();
        }
        String str = c4259l7.b;
        if (str != null) {
            c4483u7.b = StringUtils.correctIllFormedString(str);
        }
        String str2 = c4259l7.c;
        if (str2 != null) {
            c4483u7.c = StringUtils.correctIllFormedString(str2);
        }
        Long l = c4259l7.d;
        if (l != null) {
            c4483u7.d = l.longValue();
        }
        C4384q7 c4384q7 = c4259l7.e;
        if (c4384q7 != null) {
            c4483u7.e = this.b.fromModel(c4384q7);
        }
        String str3 = c4259l7.f;
        if (str3 != null) {
            c4483u7.f = str3;
        }
        String str4 = c4259l7.g;
        if (str4 != null) {
            c4483u7.g = str4;
        }
        Long l2 = c4259l7.h;
        if (l2 != null) {
            c4483u7.h = l2.longValue();
        }
        Integer num2 = c4259l7.i;
        if (num2 != null) {
            c4483u7.i = num2.intValue();
        }
        Integer num3 = c4259l7.j;
        if (num3 != null) {
            c4483u7.j = num3.intValue();
        }
        String str5 = c4259l7.k;
        if (str5 != null) {
            c4483u7.k = str5;
        }
        M8 m8 = c4259l7.l;
        if (m8 != null) {
            c4483u7.l = m8.f11256a;
        }
        String str6 = c4259l7.m;
        if (str6 != null) {
            c4483u7.m = str6;
        }
        EnumC4237ka enumC4237ka = c4259l7.n;
        if (enumC4237ka != null) {
            c4483u7.n = enumC4237ka.f11635a;
        }
        EnumC4435s9 enumC4435s9 = c4259l7.o;
        if (enumC4435s9 != null) {
            c4483u7.o = enumC4435s9.f11762a;
        }
        Boolean bool = c4259l7.p;
        if (bool != null) {
            c4483u7.p = this.f11613a.fromModel(Boolean.valueOf(bool.booleanValue())).intValue();
        }
        Integer num4 = c4259l7.q;
        if (num4 != null) {
            c4483u7.q = num4.intValue();
        }
        byte[] bArr = c4259l7.r;
        if (bArr != null) {
            c4483u7.r = bArr;
        }
        return c4483u7;
    }

    public C4209j7(C4067de c4067de, C4408r7 c4408r7) {
        this.f11613a = c4067de;
        this.b = c4408r7;
    }

    public /* synthetic */ C4209j7(C4067de c4067de, C4408r7 c4408r7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C4067de() : c4067de, (i & 2) != 0 ? new C4408r7(null, 1, null) : c4408r7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4259l7 toModel(C4483u7 c4483u7) {
        EnumC4435s9 enumC4435s9;
        C4483u7 c4483u8 = new C4483u7();
        Integer numValueOf = Integer.valueOf(c4483u7.f11794a);
        Integer num = numValueOf.intValue() != c4483u8.f11794a ? numValueOf : null;
        String str = c4483u7.b;
        String str2 = !Intrinsics.areEqual(str, c4483u8.b) ? str : null;
        String str3 = c4483u7.c;
        String str4 = !Intrinsics.areEqual(str3, c4483u8.c) ? str3 : null;
        Long lValueOf = Long.valueOf(c4483u7.d);
        Long l = lValueOf.longValue() != c4483u8.d ? lValueOf : null;
        C4384q7 model = this.b.toModel(c4483u7.e);
        String str5 = c4483u7.f;
        String str6 = !Intrinsics.areEqual(str5, c4483u8.f) ? str5 : null;
        String str7 = c4483u7.g;
        String str8 = !Intrinsics.areEqual(str7, c4483u8.g) ? str7 : null;
        Long lValueOf2 = Long.valueOf(c4483u7.h);
        if (lValueOf2.longValue() == c4483u8.h) {
            lValueOf2 = null;
        }
        Integer numValueOf2 = Integer.valueOf(c4483u7.i);
        Integer num2 = numValueOf2.intValue() != c4483u8.i ? numValueOf2 : null;
        Integer numValueOf3 = Integer.valueOf(c4483u7.j);
        Integer num3 = numValueOf3.intValue() != c4483u8.j ? numValueOf3 : null;
        String str9 = c4483u7.k;
        String str10 = !Intrinsics.areEqual(str9, c4483u8.k) ? str9 : null;
        Integer numValueOf4 = Integer.valueOf(c4483u7.l);
        if (numValueOf4.intValue() == c4483u8.l) {
            numValueOf4 = null;
        }
        M8 m8A = numValueOf4 != null ? M8.a(Integer.valueOf(numValueOf4.intValue())) : null;
        String str11 = c4483u7.m;
        String str12 = !Intrinsics.areEqual(str11, c4483u8.m) ? str11 : null;
        Integer numValueOf5 = Integer.valueOf(c4483u7.n);
        if (numValueOf5.intValue() == c4483u8.n) {
            numValueOf5 = null;
        }
        EnumC4237ka enumC4237kaA = numValueOf5 != null ? EnumC4237ka.a(Integer.valueOf(numValueOf5.intValue())) : null;
        Integer numValueOf6 = Integer.valueOf(c4483u7.o);
        if (numValueOf6.intValue() == c4483u8.o) {
            numValueOf6 = null;
        }
        if (numValueOf6 != null) {
            int iIntValue = numValueOf6.intValue();
            EnumC4435s9[] enumC4435s9ArrValues = EnumC4435s9.values();
            int length = enumC4435s9ArrValues.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    EnumC4435s9 enumC4435s10 = enumC4435s9ArrValues[i];
                    EnumC4435s9[] enumC4435s9Arr = enumC4435s9ArrValues;
                    if (enumC4435s10.f11762a == iIntValue) {
                        enumC4435s9 = enumC4435s10;
                        break;
                    }
                    i++;
                    enumC4435s9ArrValues = enumC4435s9Arr;
                } else {
                    enumC4435s9 = EnumC4435s9.NATIVE;
                    break;
                }
            }
        } else {
            enumC4435s9 = null;
        }
        Boolean boolA = this.f11613a.a(c4483u7.p);
        Integer numValueOf7 = Integer.valueOf(c4483u7.q);
        Integer num4 = numValueOf7.intValue() != c4483u8.q ? numValueOf7 : null;
        byte[] bArr = c4483u7.r;
        return new C4259l7(num, str2, str4, l, model, str6, str8, lValueOf2, num2, num3, str10, m8A, str12, enumC4237kaA, enumC4435s9, boolA, num4, !Arrays.equals(bArr, c4483u8.r) ? bArr : null);
    }
}
