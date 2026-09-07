package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes6.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator<y> f6824a = new Comparator() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return g.a((y) obj, (y) obj2);
        }
    };
    public static final Comparator<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l> b = new Comparator() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g$$ExternalSyntheticLambda1
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return g.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l) obj, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l) obj2);
        }
    };

    public static final class a extends Lambda implements Function1<y, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6825a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(y it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof y.c);
        }
    }

    public static final class b extends Lambda implements Function1<Pair<? extends Boolean, ? extends Boolean>, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f6826a;
        public final /* synthetic */ Ref.IntRef b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.IntRef intRef, Ref.IntRef intRef2) {
            super(1);
            this.f6826a = intRef;
            this.b = intRef2;
        }

        public final void a(Pair<Boolean, Boolean> pair) {
            Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
            boolean zBooleanValue = pair.component1().booleanValue();
            boolean zBooleanValue2 = pair.component2().booleanValue();
            if (zBooleanValue) {
                this.f6826a.element++;
            }
            if (zBooleanValue2) {
                this.b.element++;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends Boolean> pair) {
            a(pair);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Pair<? extends Boolean, ? extends Boolean>, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f6827a;
        public final /* synthetic */ Ref.IntRef b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Ref.IntRef intRef, Ref.IntRef intRef2) {
            super(1);
            this.f6827a = intRef;
            this.b = intRef2;
        }

        public final void a(Pair<Boolean, Boolean> pair) {
            Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
            boolean zBooleanValue = pair.component1().booleanValue();
            boolean zBooleanValue2 = pair.component2().booleanValue();
            if (zBooleanValue) {
                this.f6827a.element++;
            }
            if (zBooleanValue2) {
                this.b.element++;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends Boolean> pair) {
            a(pair);
            return Unit.INSTANCE;
        }
    }

    public static final Comparator<y> b() {
        return f6824a;
    }

    public static final Pair<Boolean, Boolean> c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar2, Integer num, Integer num2) {
        return a(b(eVar.i(), eVar.f(), num, num2), b(eVar2.i(), eVar2.f(), num, num2));
    }

    public static final Pair<Integer, Integer> d(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar2, Integer num, Integer num2) {
        Ref.IntRef intRef = new Ref.IntRef();
        Ref.IntRef intRef2 = new Ref.IntRef();
        b bVar = new b(intRef, intRef2);
        bVar.invoke(b(eVar, eVar2, num, num2));
        bVar.invoke(c(eVar, eVar2, num, num2));
        bVar.invoke(a(eVar, eVar2));
        return TuplesKt.to(Integer.valueOf(intRef.element), Integer.valueOf(intRef2.element));
    }

    public static final Pair<Integer, Integer> b(q qVar, q qVar2, double d, Long l, Integer num, Integer num2) {
        Ref.IntRef intRef = new Ref.IntRef();
        Ref.IntRef intRef2 = new Ref.IntRef();
        c cVar = new c(intRef, intRef2);
        cVar.invoke(a(qVar, qVar2, num, num2));
        cVar.invoke(b(qVar, qVar2, num, num2));
        cVar.invoke(a(qVar, qVar2, d, l));
        return TuplesKt.to(Integer.valueOf(intRef.element), Integer.valueOf(intRef2.element));
    }

    public static final Comparator<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e> a(Integer num, Integer num2) {
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.a(num, num2);
    }

    public static final Comparator<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l> a() {
        return b;
    }

    public static final Comparator<q> a(double d, Long l, Integer num, Integer num2) {
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.b(d, l, num, num2);
    }

    public static final int a(y vr1, y vr2) {
        Intrinsics.checkNotNullExpressionValue(vr2, "vr2");
        int iA = a(vr2);
        Intrinsics.checkNotNullExpressionValue(vr1, "vr1");
        return Intrinsics.compare(iA, a(vr1));
    }

    public static final int a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l lVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l lVar2) {
        return f6824a.compare(lVar.g(), lVar2.g());
    }

    public static /* synthetic */ Pair a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar2, Integer num, Integer num2, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            num2 = null;
        }
        return d(eVar, eVar2, num, num2);
    }

    public static final Pair<Boolean, Boolean> a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar2) {
        Object obj;
        Object next;
        a aVar = a.f6825a;
        Iterator<T> it = eVar.h().iterator();
        do {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!aVar.invoke(next).booleanValue());
        boolean z = next != null;
        for (Object obj2 : eVar2.h()) {
            if (aVar.invoke(obj2).booleanValue()) {
                obj = obj2;
                break;
            }
        }
        return TuplesKt.to(Boolean.valueOf(z), Boolean.valueOf(obj != null));
    }

    public static final Pair<Boolean, Boolean> b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar2, Integer num, Integer num2) {
        return a(a(eVar.i(), eVar.f(), num, num2), a(eVar2.i(), eVar2.f(), num, num2));
    }

    public static final Pair<Boolean, Boolean> b(q qVar, q qVar2, Integer num, Integer num2) {
        return a(b(qVar.j(), qVar.d(), num, num2), b(qVar2.j(), qVar2.d(), num, num2));
    }

    public static final Double b(Integer num, Integer num2, Integer num3, Integer num4) {
        if (num == null || num.intValue() == 0 || num2 == null || num2.intValue() == 0 || num3 == null || num3.intValue() == 0 || num4 == null || num4.intValue() == 0) {
            return null;
        }
        return Double.valueOf((((double) num.intValue()) / ((double) num2.intValue())) - (((double) num3.intValue()) / ((double) num4.intValue())));
    }

    public static final Pair<Boolean, Boolean> a(q qVar, q qVar2, Integer num, Integer num2) {
        return a(a(qVar.j(), qVar.d(), num, num2), a(qVar2.j(), qVar2.d(), num, num2));
    }

    public static final Pair<Boolean, Boolean> a(q qVar, q qVar2, double d, Long l) {
        return a(a(qVar, d, l), a(qVar2, d, l));
    }

    public static final Pair<Boolean, Boolean> a(Double d, Double d2) {
        if (d == null || d2 == null) {
            return TuplesKt.to(Boolean.valueOf(d != null), Boolean.valueOf(d2 != null));
        }
        if (Intrinsics.areEqual(d, d2)) {
            Boolean bool = Boolean.TRUE;
            return TuplesKt.to(bool, bool);
        }
        if (Math.abs(d.doubleValue()) == Math.abs(d2.doubleValue())) {
            return TuplesKt.to(Boolean.valueOf(d.doubleValue() < 0.0d), Boolean.valueOf(d2.doubleValue() < 0.0d));
        }
        if (Double.compare(Math.abs(d.doubleValue()), Math.abs(d2.doubleValue())) < 0) {
            return TuplesKt.to(Boolean.TRUE, Boolean.FALSE);
        }
        return TuplesKt.to(Boolean.FALSE, Boolean.TRUE);
    }

    public static final Double a(Integer num, Integer num2, Integer num3, Integer num4) {
        if (num == null || num.intValue() == 0 || num2 == null || num2.intValue() == 0 || num3 == null || num3.intValue() == 0 || num4 == null || num4.intValue() == 0) {
            return null;
        }
        return Double.valueOf((((double) num.intValue()) * ((double) num2.intValue())) - (((double) num3.intValue()) * ((double) num4.intValue())));
    }

    public static final Double a(q qVar, double d, Long l) {
        Double dA = a(qVar, l);
        if (dA != null) {
            return Double.valueOf(dA.doubleValue() - d);
        }
        return null;
    }

    public static final Double a(q qVar, Long l) {
        Double dValueOf;
        if (l == null) {
            return null;
        }
        if (qVar.b() != null) {
            dValueOf = Double.valueOf(qVar.b().intValue());
        } else {
            dValueOf = (qVar.f() == null || qVar.h() == null) ? null : Double.valueOf(((double) (qVar.f().intValue() - qVar.h().intValue())) / 2.0d);
        }
        if (dValueOf != null) {
            return Double.valueOf((dValueOf.doubleValue() / ((double) 8192)) * (l.longValue() / 1000.0d));
        }
        return null;
    }

    public static final int a(y yVar) {
        if (yVar instanceof y.a) {
            return 4;
        }
        if (yVar instanceof y.c) {
            return ((y.c) yVar).a().a() == com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i.JS ? 3 : 2;
        }
        if (yVar instanceof y.b) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }
}
