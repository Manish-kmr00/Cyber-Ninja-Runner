package com.fyber.inneractive.sdk.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.s0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3222s0 extends AbstractC3226u0 {
    public static final Class c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3226u0
    public final void a(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) y1.e(obj, j);
        if (list instanceof InterfaceC3219r0) {
            objUnmodifiableList = ((InterfaceC3219r0) list).a();
        } else {
            if (c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof O0) && (list instanceof InterfaceC3202l0)) {
                AbstractC3174c abstractC3174c = (AbstractC3174c) ((InterfaceC3202l0) list);
                if (abstractC3174c.f2277a) {
                    abstractC3174c.f2277a = false;
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        y1.a(j, obj, objUnmodifiableList);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3226u0
    public final List b(Object obj, long j) {
        return a(obj, j, 10);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3226u0
    public final void a(long j, Object obj, Object obj2) {
        List list = (List) y1.e(obj2, j);
        List listA = a(obj, j, list.size());
        int size = listA.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listA.addAll(list);
        }
        if (size > 0) {
            list = listA;
        }
        y1.a(j, obj, list);
    }

    public static List a(Object obj, long j, int i) {
        List list;
        List arrayList;
        List list2 = (List) y1.e(obj, j);
        if (list2.isEmpty()) {
            if (list2 instanceof InterfaceC3219r0) {
                arrayList = new C3217q0(i);
            } else if ((list2 instanceof O0) && (list2 instanceof InterfaceC3202l0)) {
                arrayList = ((InterfaceC3202l0) list2).b(i);
            } else {
                arrayList = new ArrayList(i);
            }
            y1.a(j, obj, arrayList);
            return arrayList;
        }
        if (c.isAssignableFrom(list2.getClass())) {
            ArrayList arrayList2 = new ArrayList(list2.size() + i);
            arrayList2.addAll(list2);
            y1.a(j, obj, arrayList2);
            list = arrayList2;
        } else if (list2 instanceof s1) {
            C3217q0 c3217q0 = new C3217q0(list2.size() + i);
            c3217q0.addAll((s1) list2);
            y1.a(j, obj, c3217q0);
            list = c3217q0;
        } else {
            if (!(list2 instanceof O0) || !(list2 instanceof InterfaceC3202l0)) {
                return list2;
            }
            InterfaceC3202l0 interfaceC3202l0 = (InterfaceC3202l0) list2;
            if (((AbstractC3174c) interfaceC3202l0).f2277a) {
                return list2;
            }
            InterfaceC3202l0 interfaceC3202l0B = interfaceC3202l0.b(list2.size() + i);
            y1.a(j, obj, interfaceC3202l0B);
            return interfaceC3202l0B;
        }
        return list;
    }
}
