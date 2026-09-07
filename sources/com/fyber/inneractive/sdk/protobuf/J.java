package com.fyber.inneractive.sdk.protobuf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class J {
    public static void a(C c, Map.Entry entry) {
        X x = (X) entry.getKey();
        if (x.d) {
            switch (I.f2258a[x.c.ordinal()]) {
                case 1:
                    V0.b(x.b, (List) entry.getValue(), c, x.e);
                    break;
                case 2:
                    V0.f(x.b, (List) entry.getValue(), c, x.e);
                    break;
                case 3:
                    V0.h(x.b, (List) entry.getValue(), c, x.e);
                    break;
                case 4:
                    V0.n(x.b, (List) entry.getValue(), c, x.e);
                    break;
                case 5:
                    V0.g(x.b, (List) entry.getValue(), c, x.e);
                    break;
                case 6:
                    V0.e(x.b, (List) entry.getValue(), c, x.e);
                    break;
                case 7:
                    V0.d(x.b, (List) entry.getValue(), c, x.e);
                    break;
                case 8:
                    V0.a(x.b, (List) entry.getValue(), c, x.e);
                    break;
                case 9:
                    V0.m(x.b, (List) entry.getValue(), c, x.e);
                    break;
                case 10:
                    V0.i(x.b, (List) entry.getValue(), c, x.e);
                    break;
                case 11:
                    V0.j(x.b, (List) entry.getValue(), c, x.e);
                    break;
                case 12:
                    V0.k(x.b, (List) entry.getValue(), c, x.e);
                    break;
                case 13:
                    V0.l(x.b, (List) entry.getValue(), c, x.e);
                    break;
                case 14:
                    V0.g(x.b, (List) entry.getValue(), c, x.e);
                    break;
                case 15:
                    V0.a(x.b, (List) entry.getValue(), c);
                    break;
                case 16:
                    V0.b(x.b, (List) entry.getValue(), c);
                    break;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        V0.a(x.b, (List) entry.getValue(), c, Q0.c.a(list.get(0).getClass()));
                        break;
                    }
                    break;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        V0.b(x.b, (List) entry.getValue(), c, Q0.c.a(list2.get(0).getClass()));
                        break;
                    }
                    break;
            }
        }
        switch (I.f2258a[x.c.ordinal()]) {
            case 1:
                c.a(x.b, ((Double) entry.getValue()).doubleValue());
                break;
            case 2:
                c.a(x.b, ((Float) entry.getValue()).floatValue());
                break;
            case 3:
                c.f2252a.b(x.b, ((Long) entry.getValue()).longValue());
                break;
            case 4:
                c.f2252a.b(x.b, ((Long) entry.getValue()).longValue());
                break;
            case 5:
                c.f2252a.b(x.b, ((Integer) entry.getValue()).intValue());
                break;
            case 6:
                c.f2252a.a(x.b, ((Long) entry.getValue()).longValue());
                break;
            case 7:
                c.f2252a.a(x.b, ((Integer) entry.getValue()).intValue());
                break;
            case 8:
                c.f2252a.a(x.b, ((Boolean) entry.getValue()).booleanValue());
                break;
            case 9:
                c.f2252a.d(x.b, ((Integer) entry.getValue()).intValue());
                break;
            case 10:
                c.f2252a.a(x.b, ((Integer) entry.getValue()).intValue());
                break;
            case 11:
                c.f2252a.a(x.b, ((Long) entry.getValue()).longValue());
                break;
            case 12:
                c.a(x.b, ((Integer) entry.getValue()).intValue());
                break;
            case 13:
                c.a(x.b, ((Long) entry.getValue()).longValue());
                break;
            case 14:
                c.f2252a.b(x.b, ((Integer) entry.getValue()).intValue());
                break;
            case 15:
                c.f2252a.a(x.b, (AbstractC3221s) entry.getValue());
                break;
            case 16:
                int i = x.b;
                c.f2252a.a((String) entry.getValue(), i);
                break;
            case 17:
                c.a(x.b, entry.getValue(), Q0.c.a(entry.getValue().getClass()));
                break;
            case 18:
                int i2 = x.b;
                Object value = entry.getValue();
                c.f2252a.a(i2, (E0) value, Q0.c.a(entry.getValue().getClass()));
                break;
        }
    }

    public static Object a(T0 t0, Y y, H h, N n, Object obj, C3215p1 c3215p1) {
        Object objValueOf;
        ArrayList arrayList;
        X x = y.d;
        int i = x.b;
        if (x.d && x.e) {
            switch (I.f2258a[x.c.ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    t0.j(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    t0.d(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    t0.k(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    t0.a(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    t0.o(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    t0.n(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    t0.e(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    t0.l(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    t0.i(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    t0.f(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    t0.m(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    t0.c(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    t0.g(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    t0.p(arrayList);
                    obj = V0.a(i, arrayList, y.d.f2272a, obj, c3215p1);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + y.d.c);
            }
            n.c(y.d, arrayList);
        } else {
            K1 k1 = x.c;
            if (k1 == K1.ENUM) {
                int iD = t0.d();
                if (y.d.f2272a.a(iD) == null) {
                    return V0.a(i, iD, obj, c3215p1);
                }
                objValueOf = Integer.valueOf(iD);
            } else {
                switch (I.f2258a[k1.ordinal()]) {
                    case 1:
                        objValueOf = Double.valueOf(t0.h());
                        break;
                    case 2:
                        objValueOf = Float.valueOf(t0.k());
                        break;
                    case 3:
                        objValueOf = Long.valueOf(t0.o());
                        break;
                    case 4:
                        objValueOf = Long.valueOf(t0.f());
                        break;
                    case 5:
                        objValueOf = Integer.valueOf(t0.d());
                        break;
                    case 6:
                        objValueOf = Long.valueOf(t0.g());
                        break;
                    case 7:
                        objValueOf = Integer.valueOf(t0.q());
                        break;
                    case 8:
                        objValueOf = Boolean.valueOf(t0.r());
                        break;
                    case 9:
                        objValueOf = Integer.valueOf(t0.c());
                        break;
                    case 10:
                        objValueOf = Integer.valueOf(t0.m());
                        break;
                    case 11:
                        objValueOf = Long.valueOf(t0.t());
                        break;
                    case 12:
                        objValueOf = Integer.valueOf(t0.j());
                        break;
                    case 13:
                        objValueOf = Long.valueOf(t0.l());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        objValueOf = t0.a();
                        break;
                    case 16:
                        objValueOf = t0.n();
                        break;
                    case 17:
                        objValueOf = t0.a(y.c.getClass(), h);
                        break;
                    case 18:
                        objValueOf = t0.b(y.c.getClass(), h);
                        break;
                    default:
                        objValueOf = null;
                        break;
                }
            }
            X x2 = y.d;
            if (x2.d) {
                n.a(x2, objValueOf);
            } else {
                int i2 = I.f2258a[x2.c.ordinal()];
                if (i2 == 17 || i2 == 18) {
                    Object obj2 = n.f2264a.get(y.d);
                    if (obj2 != null) {
                        objValueOf = AbstractC3205m0.a(obj2, objValueOf);
                    }
                }
                n.c(y.d, objValueOf);
            }
        }
        return obj;
    }
}
