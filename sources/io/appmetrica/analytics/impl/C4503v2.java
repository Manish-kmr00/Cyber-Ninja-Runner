package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.v2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4503v2 implements ProtobufConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4081e3 f11809a;

    public C4503v2() {
        this(new C4081e3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4553x2 fromModel(C4478u2 c4478u2) {
        C4553x2 c4553x2 = new C4553x2();
        c4553x2.f11838a = new C4528w2[c4478u2.f11789a.size()];
        int i = 0;
        for (BillingInfo billingInfo : c4478u2.f11789a) {
            C4528w2[] c4528w2Arr = c4553x2.f11838a;
            this.f11809a.getClass();
            c4528w2Arr[i] = C4081e3.a(billingInfo);
            i++;
        }
        c4553x2.b = c4478u2.b;
        return c4553x2;
    }

    public C4503v2(C4081e3 c4081e3) {
        this.f11809a = c4081e3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4478u2 toModel(C4553x2 c4553x2) {
        ProductType productType;
        ArrayList arrayList = new ArrayList(c4553x2.f11838a.length);
        for (C4528w2 c4528w2 : c4553x2.f11838a) {
            this.f11809a.getClass();
            int i = c4528w2.f11824a;
            if (i == 2) {
                productType = ProductType.INAPP;
            } else if (i != 3) {
                productType = ProductType.UNKNOWN;
            } else {
                productType = ProductType.SUBS;
            }
            arrayList.add(new BillingInfo(productType, c4528w2.b, c4528w2.c, c4528w2.d, c4528w2.e));
        }
        return new C4478u2(arrayList, c4553x2.b);
    }
}
