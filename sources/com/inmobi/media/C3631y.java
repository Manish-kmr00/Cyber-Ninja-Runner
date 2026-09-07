package com.inmobi.media;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes7.dex */
public final class C3631y extends J1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3645z f3480a;
    public final Yb b;

    public C3631y(C3645z adImpressionCallbackHandler, Yb yb) {
        Intrinsics.checkNotNullParameter(adImpressionCallbackHandler, "adImpressionCallbackHandler");
        this.f3480a = adImpressionCallbackHandler;
        this.b = yb;
    }

    @Override // com.inmobi.media.J1
    public final void a(T1 click) {
        Intrinsics.checkNotNullParameter(click, "click");
        this.f3480a.a(this.b);
    }

    @Override // com.inmobi.media.J1
    public final void a(T1 click, String reason) {
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullParameter(reason, "error");
        Yb yb = this.b;
        Intrinsics.checkNotNullParameter(reason, "reason");
        LinkedHashMap linkedHashMapA = yb.a();
        linkedHashMapA.put("networkType", C3435k3.q());
        linkedHashMapA.put("errorCode", (short) 2178);
        linkedHashMapA.put("reason", reason);
        Ob ob = Ob.f3160a;
        Ob.b("AdImpressionSuccessful", linkedHashMapA, Sb.SDK);
    }
}
