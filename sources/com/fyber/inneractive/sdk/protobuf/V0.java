package com.fyber.inneractive.sdk.protobuf;

import java.util.AbstractList;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes6.dex */
public abstract class V0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f2271a;
    public static final C3215p1 b;
    public static final C3215p1 c;
    public static final C3215p1 d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        f2271a = cls;
        b = a(false);
        c = a(true);
        d = new C3215p1();
    }

    public static Object a(int i, List list, Object obj, C3215p1 c3215p1) {
        return obj;
    }

    public static void a(int i, List list, C c2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c2.getClass();
            while (i2 < list.size()) {
                c2.f2252a.a(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        c2.f2252a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).getClass();
            Logger logger = B.b;
            i3++;
        }
        c2.f2252a.g(i3);
        while (i2 < list.size()) {
            c2.f2252a.a(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public static void b(int i, List list, C c2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c2.getClass();
            while (i2 < list.size()) {
                B b2 = c2.f2252a;
                double dDoubleValue = ((Double) list.get(i2)).doubleValue();
                b2.getClass();
                b2.a(i, Double.doubleToRawLongBits(dDoubleValue));
                i2++;
            }
            return;
        }
        c2.f2252a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            Logger logger = B.b;
            i3 += 8;
        }
        c2.f2252a.g(i3);
        while (i2 < list.size()) {
            B b3 = c2.f2252a;
            double dDoubleValue2 = ((Double) list.get(i2)).doubleValue();
            b3.getClass();
            b3.c(Double.doubleToRawLongBits(dDoubleValue2));
            i2++;
        }
    }

    public static void c(int i, List list, C c2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c2.getClass();
            while (i2 < list.size()) {
                c2.f2252a.b(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        c2.f2252a.c(i, 2);
        int iA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iA += B.a(((Integer) list.get(i3)).intValue());
        }
        c2.f2252a.g(iA);
        while (i2 < list.size()) {
            c2.f2252a.f(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void d(int i, List list, C c2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c2.getClass();
            while (i2 < list.size()) {
                c2.f2252a.a(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        c2.f2252a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            Logger logger = B.b;
            i3 += 4;
        }
        c2.f2252a.g(i3);
        while (i2 < list.size()) {
            c2.f2252a.e(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void e(int i, List list, C c2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c2.getClass();
            while (i2 < list.size()) {
                c2.f2252a.a(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        c2.f2252a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            Logger logger = B.b;
            i3 += 8;
        }
        c2.f2252a.g(i3);
        while (i2 < list.size()) {
            c2.f2252a.c(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void f(int i, List list, C c2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c2.getClass();
            while (i2 < list.size()) {
                B b2 = c2.f2252a;
                float fFloatValue = ((Float) list.get(i2)).floatValue();
                b2.getClass();
                b2.a(i, Float.floatToRawIntBits(fFloatValue));
                i2++;
            }
            return;
        }
        c2.f2252a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).getClass();
            Logger logger = B.b;
            i3 += 4;
        }
        c2.f2252a.g(i3);
        while (i2 < list.size()) {
            B b3 = c2.f2252a;
            float fFloatValue2 = ((Float) list.get(i2)).floatValue();
            b3.getClass();
            b3.e(Float.floatToRawIntBits(fFloatValue2));
            i2++;
        }
    }

    public static void g(int i, List list, C c2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c2.getClass();
            while (i2 < list.size()) {
                c2.f2252a.b(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        c2.f2252a.c(i, 2);
        int iC = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int iIntValue = ((Integer) list.get(i3)).intValue();
            iC += iIntValue >= 0 ? B.c(iIntValue) : 10;
        }
        c2.f2252a.g(iC);
        while (i2 < list.size()) {
            c2.f2252a.f(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void h(int i, List list, C c2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c2.getClass();
            while (i2 < list.size()) {
                c2.f2252a.b(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        c2.f2252a.c(i, 2);
        int iA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iA += B.a(((Long) list.get(i3)).longValue());
        }
        c2.f2252a.g(iA);
        while (i2 < list.size()) {
            c2.f2252a.d(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void i(int i, List list, C c2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c2.getClass();
            while (i2 < list.size()) {
                c2.f2252a.a(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        c2.f2252a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            Logger logger = B.b;
            i3 += 4;
        }
        c2.f2252a.g(i3);
        while (i2 < list.size()) {
            c2.f2252a.e(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void j(int i, List list, C c2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c2.getClass();
            while (i2 < list.size()) {
                c2.f2252a.a(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        c2.f2252a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            Logger logger = B.b;
            i3 += 8;
        }
        c2.f2252a.g(i3);
        while (i2 < list.size()) {
            c2.f2252a.c(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void k(int i, List list, C c2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c2.getClass();
            while (i2 < list.size()) {
                c2.f2252a.d(i, B.d(((Integer) list.get(i2)).intValue()));
                i2++;
            }
            return;
        }
        c2.f2252a.c(i, 2);
        int iC = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iC += B.c(B.d(((Integer) list.get(i3)).intValue()));
        }
        c2.f2252a.g(iC);
        while (i2 < list.size()) {
            c2.f2252a.g(B.d(((Integer) list.get(i2)).intValue()));
            i2++;
        }
    }

    public static void l(int i, List list, C c2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c2.getClass();
            while (i2 < list.size()) {
                c2.f2252a.b(i, B.b(((Long) list.get(i2)).longValue()));
                i2++;
            }
            return;
        }
        c2.f2252a.c(i, 2);
        int iA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iA += B.a(B.b(((Long) list.get(i3)).longValue()));
        }
        c2.f2252a.g(iA);
        while (i2 < list.size()) {
            c2.f2252a.d(B.b(((Long) list.get(i2)).longValue()));
            i2++;
        }
    }

    public static void m(int i, List list, C c2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c2.getClass();
            while (i2 < list.size()) {
                c2.f2252a.d(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        c2.f2252a.c(i, 2);
        int iC = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iC += B.c(((Integer) list.get(i3)).intValue());
        }
        c2.f2252a.g(iC);
        while (i2 < list.size()) {
            c2.f2252a.g(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void n(int i, List list, C c2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        if (!z) {
            c2.getClass();
            while (i2 < list.size()) {
                c2.f2252a.b(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        c2.f2252a.c(i, 2);
        int iA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iA += B.a(((Long) list.get(i3)).longValue());
        }
        c2.f2252a.g(iA);
        while (i2 < list.size()) {
            c2.f2252a.d(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static int d(List list) {
        int iC;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3172b0) {
            C3172b0 c3172b0 = (C3172b0) list;
            iC = 0;
            while (i < size) {
                c3172b0.d(i);
                iC += B.c(B.d(c3172b0.b[i]));
                i++;
            }
        } else {
            iC = 0;
            while (i < size) {
                iC += B.c(B.d(((Integer) list.get(i)).intValue()));
                i++;
            }
        }
        return iC;
    }

    public static int e(List list) {
        int iA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3228v0) {
            C3228v0 c3228v0 = (C3228v0) list;
            iA = 0;
            while (i < size) {
                c3228v0.c(i);
                iA += B.a(B.b(c3228v0.b[i]));
                i++;
            }
        } else {
            iA = 0;
            while (i < size) {
                iA += B.a(B.b(((Long) list.get(i)).longValue()));
                i++;
            }
        }
        return iA;
    }

    public static int g(List list) {
        int iA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3228v0) {
            C3228v0 c3228v0 = (C3228v0) list;
            iA = 0;
            while (i < size) {
                c3228v0.c(i);
                iA += B.a(c3228v0.b[i]);
                i++;
            }
        } else {
            iA = 0;
            while (i < size) {
                iA += B.a(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iA;
    }

    public static void a(int i, List list, C c2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c2.getClass();
        for (int i2 = 0; i2 < list.size(); i2++) {
            c2.f2252a.a(i, (AbstractC3221s) list.get(i2));
        }
    }

    public static void b(int i, List list, C c2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c2.getClass();
        int i2 = 0;
        if (list instanceof InterfaceC3219r0) {
            InterfaceC3219r0 interfaceC3219r0 = (InterfaceC3219r0) list;
            while (i2 < list.size()) {
                Object objA = interfaceC3219r0.a(i2);
                if (objA instanceof String) {
                    c2.f2252a.a((String) objA, i);
                } else {
                    c2.f2252a.a(i, (AbstractC3221s) objA);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            c2.f2252a.a((String) list.get(i2), i);
            i2++;
        }
    }

    public static int c(List list) {
        int iA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3228v0) {
            C3228v0 c3228v0 = (C3228v0) list;
            iA = 0;
            while (i < size) {
                c3228v0.c(i);
                iA += B.a(c3228v0.b[i]);
                i++;
            }
        } else {
            iA = 0;
            while (i < size) {
                iA += B.a(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iA;
    }

    public static int f(List list) {
        int iC;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3172b0) {
            C3172b0 c3172b0 = (C3172b0) list;
            iC = 0;
            while (i < size) {
                c3172b0.d(i);
                iC += B.c(c3172b0.b[i]);
                i++;
            }
        } else {
            iC = 0;
            while (i < size) {
                iC += B.c(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iC;
    }

    public static void a(int i, List list, C c2, U0 u0) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c2.getClass();
        for (int i2 = 0; i2 < list.size(); i2++) {
            c2.a(i, list.get(i2), u0);
        }
    }

    public static int a(List list) {
        int iA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3172b0) {
            C3172b0 c3172b0 = (C3172b0) list;
            iA = 0;
            while (i < size) {
                c3172b0.d(i);
                iA += B.a(c3172b0.b[i]);
                i++;
            }
        } else {
            iA = 0;
            while (i < size) {
                iA += B.a(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iA;
    }

    public static void b(int i, List list, C c2, U0 u0) {
        if (list == null || list.isEmpty()) {
            return;
        }
        c2.getClass();
        for (int i2 = 0; i2 < list.size(); i2++) {
            c2.f2252a.a(i, (E0) list.get(i2), u0);
        }
    }

    public static int c(int i, List list) {
        int iA;
        int iA2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iB = B.b(i) * size;
        if (list instanceof InterfaceC3219r0) {
            InterfaceC3219r0 interfaceC3219r0 = (InterfaceC3219r0) list;
            while (i2 < size) {
                Object objA = interfaceC3219r0.a(i2);
                if (objA instanceof AbstractC3221s) {
                    iA2 = B.a((AbstractC3221s) objA);
                } else {
                    iA2 = B.a((String) objA);
                }
                iB = iA2 + iB;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof AbstractC3221s) {
                    iA = B.a((AbstractC3221s) obj);
                } else {
                    iA = B.a((String) obj);
                }
                iB = iA + iB;
                i2++;
            }
        }
        return iB;
    }

    public static int b(List list) {
        int i;
        int iC;
        int iC2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3172b0) {
            C3172b0 c3172b0 = (C3172b0) list;
            i = 0;
            while (i2 < size) {
                c3172b0.d(i2);
                int i3 = c3172b0.b[i2];
                if (i3 >= 0) {
                    iC2 = B.c(i3);
                } else {
                    Logger logger = B.b;
                    iC2 = 10;
                }
                i += iC2;
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                if (iIntValue >= 0) {
                    iC = B.c(iIntValue);
                } else {
                    Logger logger2 = B.b;
                    iC = 10;
                }
                i += iC;
                i2++;
            }
        }
        return i;
    }

    public static int a(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (B.b(i) + 4) * size;
    }

    public static C3215p1 a(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (C3215p1) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static Object a(int i, AbstractList abstractList, InterfaceC3184f0 interfaceC3184f0, Object obj, C3215p1 c3215p1) {
        if (interfaceC3184f0 == null) {
            return obj;
        }
        int size = abstractList.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Integer num = (Integer) abstractList.get(i3);
            int iIntValue = num.intValue();
            if (interfaceC3184f0.a(iIntValue) != null) {
                if (i3 != i2) {
                    abstractList.set(i2, num);
                }
                i2++;
            } else {
                obj = a(i, iIntValue, obj, c3215p1);
            }
        }
        if (i2 != size) {
            abstractList.subList(i2, size).clear();
        }
        return obj;
    }

    public static int b(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (B.b(i) + 8) * size;
    }

    public static Object a(int i, int i2, Object obj, C3215p1 c3215p1) {
        if (obj == null) {
            c3215p1.getClass();
            obj = new C3212o1();
        }
        c3215p1.getClass();
        ((C3212o1) obj).a(i << 3, Long.valueOf(i2));
        return obj;
    }
}
