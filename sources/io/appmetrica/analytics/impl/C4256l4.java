package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.l4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4256l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4075dm f11643a;
    public final Q b;

    public C4256l4(C4075dm c4075dm, Q q) {
        this.f11643a = c4075dm;
        this.b = q;
    }

    public final C4231k4 a(HashMap map) {
        AdvertisingIdsHolder advertisingIdsHolderA;
        Hl hlE = this.f11643a.e();
        Q q = this.b;
        synchronized (q) {
            advertisingIdsHolderA = q.a(new Pd());
        }
        return new C4231k4(C4231k4.a(hlE.d), C4231k4.a(hlE.f11181a), C4231k4.a(hlE.b), C4231k4.a(hlE.j), C4231k4.a(hlE.i), C4231k4.a(AbstractC4288mb.a(AbstractC4199im.a(hlE.k))), C4231k4.a(AbstractC4288mb.a(map)), new IdentifiersResult(advertisingIdsHolderA.getGoogle().mAdTrackingInfo == null ? null : advertisingIdsHolderA.getGoogle().mAdTrackingInfo.advId, advertisingIdsHolderA.getGoogle().mStatus, advertisingIdsHolderA.getGoogle().mErrorExplanation), new IdentifiersResult(advertisingIdsHolderA.getHuawei().mAdTrackingInfo == null ? null : advertisingIdsHolderA.getHuawei().mAdTrackingInfo.advId, advertisingIdsHolderA.getHuawei().mStatus, advertisingIdsHolderA.getHuawei().mErrorExplanation), new IdentifiersResult(advertisingIdsHolderA.getYandex().mAdTrackingInfo == null ? null : advertisingIdsHolderA.getYandex().mAdTrackingInfo.advId, advertisingIdsHolderA.getYandex().mStatus, advertisingIdsHolderA.getYandex().mErrorExplanation), C4231k4.a(AbstractC4288mb.a(hlE.h)), AbstractC4126fn.a(), hlE.o + ((long) hlE.A.f11557a), C4231k4.a(hlE.n.f), new Bundle());
    }
}
