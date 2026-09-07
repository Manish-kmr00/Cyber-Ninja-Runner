package com.inmobi.media;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class T6 extends J1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3313b7 f3202a;

    public T6(C3313b7 c3313b7) {
        this.f3202a = c3313b7;
    }

    @Override // com.inmobi.media.J1
    public final void a(T1 click) {
        Intrinsics.checkNotNullParameter(click, "click");
        C3313b7 c3313b7 = this.f3202a;
        LinkedHashMap linkedHashMap = c3313b7.R;
        Yb telemetryOnAdImpression = new Yb(linkedHashMap != null ? (E0) linkedHashMap.get("AdImpressionSuccessful") : null, c3313b7.i.f, c3313b7.getCreativeId(), "inmobiJson");
        Intrinsics.checkNotNullParameter("nativeBeacon", "<set-?>");
        telemetryOnAdImpression.e = "nativeBeacon";
        A0 a0 = this.f3202a.w;
        if (a0 != null) {
            Intrinsics.checkNotNullParameter(telemetryOnAdImpression, "telemetryOnAdImpression");
            Intrinsics.checkNotNullParameter("nativeBeacon", "<set-?>");
            telemetryOnAdImpression.e = "nativeBeacon";
            if (a0.f3025a.Z()) {
                telemetryOnAdImpression.b();
            } else {
                a0.f3025a.D.a(telemetryOnAdImpression);
            }
        }
    }

    @Override // com.inmobi.media.J1
    public final void a(T1 click, String reason) {
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullParameter(reason, "error");
        C3313b7 c3313b7 = this.f3202a;
        LinkedHashMap linkedHashMap = c3313b7.R;
        Yb yb = new Yb(linkedHashMap != null ? (E0) linkedHashMap.get("AdImpressionSuccessful") : null, c3313b7.i.f, c3313b7.getCreativeId(), "inmobiJson");
        Intrinsics.checkNotNullParameter("nativeBeacon", "<set-?>");
        yb.e = "nativeBeacon";
        Intrinsics.checkNotNullParameter(reason, "reason");
        LinkedHashMap linkedHashMapA = yb.a();
        linkedHashMapA.put("networkType", C3435k3.q());
        linkedHashMapA.put("errorCode", (short) 2178);
        linkedHashMapA.put("reason", reason);
        Ob ob = Ob.f3160a;
        Ob.b("AdImpressionSuccessful", linkedHashMapA, Sb.SDK);
    }
}
