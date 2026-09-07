package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.identifiers.ad.huawei.OpenDeviceIdentifierService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class tf0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mc f10295a;

    public final lc a(com.monetization.ads.core.identifiers.ad.huawei.a serviceConnection) {
        Intrinsics.checkNotNullParameter(serviceConnection, "serviceConnection");
        try {
            OpenDeviceIdentifierService openDeviceIdentifierServiceA = serviceConnection.a();
            if (openDeviceIdentifierServiceA == null) {
                return null;
            }
            String oaid = openDeviceIdentifierServiceA.getOaid();
            boolean oaidTrackLimited = openDeviceIdentifierServiceA.getOaidTrackLimited();
            this.f10295a.getClass();
            if (oaid != null) {
                return new lc(oaid, oaidTrackLimited);
            }
            return null;
        } catch (Exception unused) {
            op0.c(new Object[0]);
            return null;
        }
    }

    public /* synthetic */ tf0() {
        this(new mc());
    }

    public tf0(mc advertisingInfoCreator) {
        Intrinsics.checkNotNullParameter(advertisingInfoCreator, "advertisingInfoCreator");
        this.f10295a = advertisingInfoCreator;
    }
}
