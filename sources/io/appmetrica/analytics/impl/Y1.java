package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionState;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
public final class Y1 implements ProtobufConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F2 f11427a;

    public Y1() {
        this(new F2());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4005b2 fromModel(X1 x1) {
        C4005b2 c4005b2 = new C4005b2();
        c4005b2.f11472a = new C3980a2[x1.f11411a.size()];
        int i = 0;
        int i2 = 0;
        for (PermissionState permissionState : x1.f11411a) {
            C3980a2[] c3980a2Arr = c4005b2.f11472a;
            C3980a2 c3980a2 = new C3980a2();
            c3980a2.f11456a = permissionState.name;
            c3980a2.b = permissionState.granted;
            c3980a2Arr[i2] = c3980a2;
            i2++;
        }
        H2 h2 = x1.b;
        if (h2 != null) {
            c4005b2.b = this.f11427a.fromModel(h2);
        }
        c4005b2.c = new String[x1.c.size()];
        Iterator it = x1.c.iterator();
        while (it.hasNext()) {
            c4005b2.c[i] = (String) it.next();
            i++;
        }
        return c4005b2;
    }

    public Y1(F2 f2) {
        this.f11427a = f2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final X1 toModel(C4005b2 c4005b2) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            C3980a2[] c3980a2Arr = c4005b2.f11472a;
            if (i2 >= c3980a2Arr.length) {
                break;
            }
            C3980a2 c3980a2 = c3980a2Arr[i2];
            arrayList.add(new PermissionState(c3980a2.f11456a, c3980a2.b));
            i2++;
        }
        Z1 z1 = c4005b2.b;
        H2 model = z1 != null ? this.f11427a.toModel(z1) : null;
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            String[] strArr = c4005b2.c;
            if (i < strArr.length) {
                arrayList2.add(strArr[i]);
                i++;
            } else {
                return new X1(arrayList, model, arrayList2);
            }
        }
    }
}
