package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.BatteryInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeType;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.b3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4006b3 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4031c3 f11473a;

    public C4006b3(C4031c3 c4031c3) {
        this.f11473a = c4031c3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    public final void consume(Object obj) {
        Intent intent = (Intent) obj;
        BatteryInfo batteryInfo = this.f11473a.b;
        ChargeType chargeType = batteryInfo == null ? null : batteryInfo.chargeType;
        this.f11473a.getClass();
        BatteryInfo batteryInfoA = C4031c3.a(intent);
        this.f11473a.b = batteryInfoA;
        if (chargeType != batteryInfoA.chargeType) {
            this.f11473a.f11488a.execute(new C3981a3(this, batteryInfoA));
        }
    }
}
