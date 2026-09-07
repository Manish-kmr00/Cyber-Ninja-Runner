package com.yandex.mobile.ads.impl;

import android.os.IBinder;
import android.os.IInterface;
import com.monetization.ads.core.identifiers.ad.gms.service.GmsServiceAdvertisingInfoReader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class xe0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mc f10647a;
    private final se0 b;

    public final lc a(te0 connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        try {
            IBinder binder = connection.a();
            if (binder == null) {
                return null;
            }
            this.b.getClass();
            Intrinsics.checkNotNullParameter(binder, "binder");
            IInterface iInterfaceQueryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            rc gmsServiceAdvertisingInfoReader = iInterfaceQueryLocalInterface instanceof rc ? (rc) iInterfaceQueryLocalInterface : null;
            if (gmsServiceAdvertisingInfoReader == null) {
                gmsServiceAdvertisingInfoReader = new GmsServiceAdvertisingInfoReader(binder);
            }
            String advertisingId = gmsServiceAdvertisingInfoReader.readAdvertisingId();
            Boolean adTrackingLimited = gmsServiceAdvertisingInfoReader.readAdTrackingLimited();
            this.f10647a.getClass();
            lc lcVar = (adTrackingLimited == null || advertisingId == null) ? null : new lc(advertisingId, adTrackingLimited.booleanValue());
            op0.a(new Object[0]);
            return lcVar;
        } catch (InterruptedException unused) {
            op0.c(new Object[0]);
            return null;
        }
    }

    public /* synthetic */ xe0() {
        this(new mc(), new se0());
    }

    public xe0(mc advertisingInfoCreator, se0 gmsAdvertisingInfoReaderProvider) {
        Intrinsics.checkNotNullParameter(advertisingInfoCreator, "advertisingInfoCreator");
        Intrinsics.checkNotNullParameter(gmsAdvertisingInfoReaderProvider, "gmsAdvertisingInfoReaderProvider");
        this.f10647a = advertisingInfoCreator;
        this.b = gmsAdvertisingInfoReaderProvider;
    }
}
