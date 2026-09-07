package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.g3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4131g3 implements BillingInfoSender {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Wa f11561a;
    public final ICommonExecutor b;

    public C4131g3(Wa wa) {
        this(wa, C4486ua.j().w().e());
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender
    public final void sendInfo(List<ProductInfo> list) {
        Iterator<ProductInfo> it = list.iterator();
        while (it.hasNext()) {
            this.b.execute(new C4106f3(this, it.next()));
        }
    }

    public C4131g3(Wa wa, ICommonExecutor iCommonExecutor) {
        this.f11561a = wa;
        this.b = iCommonExecutor;
    }
}
