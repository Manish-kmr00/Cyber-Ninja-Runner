package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.e3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4081e3 implements ProtobufConverter {
    public static C4528w2 a(BillingInfo billingInfo) {
        C4528w2 c4528w2 = new C4528w2();
        int i = AbstractC4056d3.f11507a[billingInfo.type.ordinal()];
        int i2 = 2;
        if (i != 1) {
            i2 = i != 2 ? 1 : 3;
        }
        c4528w2.f11824a = i2;
        c4528w2.b = billingInfo.productId;
        c4528w2.c = billingInfo.purchaseToken;
        c4528w2.d = billingInfo.purchaseTime;
        c4528w2.e = billingInfo.sendTime;
        return c4528w2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((BillingInfo) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        ProductType productType;
        C4528w2 c4528w2 = (C4528w2) obj;
        int i = c4528w2.f11824a;
        if (i != 2) {
            productType = i != 3 ? ProductType.UNKNOWN : ProductType.SUBS;
        } else {
            productType = ProductType.INAPP;
        }
        return new BillingInfo(productType, c4528w2.b, c4528w2.c, c4528w2.d, c4528w2.e);
    }
}
