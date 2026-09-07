package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import java.util.List;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.h3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4156h3 implements BillingInfoStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProtobufStateStorage f11578a;
    public C4478u2 b;

    public C4156h3(Context context) {
        this(C4448sm.a(C4478u2.class).a(context));
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage
    public final List<BillingInfo> getBillingInfo() {
        return this.b.f11789a;
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage
    public final boolean isFirstInappCheckOccurred() {
        return this.b.b;
    }

    @Override // io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage
    public final void saveInfo(List<BillingInfo> list, boolean z) {
        for (BillingInfo billingInfo : list) {
        }
        C4478u2 c4478u2 = new C4478u2(list, z);
        this.b = c4478u2;
        this.f11578a.save(c4478u2);
    }

    public C4156h3(ProtobufStateStorage protobufStateStorage) {
        this.f11578a = protobufStateStorage;
        this.b = (C4478u2) protobufStateStorage.read();
    }
}
