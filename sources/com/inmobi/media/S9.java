package com.inmobi.media;

import com.yandex.div.core.DivActionHandler;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class S9 {
    public static final void a(R9 telemetryType) {
        Intrinsics.checkNotNullParameter(telemetryType, "telemetryType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (telemetryType instanceof N9) {
            linkedHashMap.put(DivActionHandler.DivActionReason.TRIGGER, ((N9) telemetryType).f3148a);
            Ob ob = Ob.f3160a;
            Ob.b("BillingClientConnectionError", linkedHashMap, Sb.SDK);
            return;
        }
        if (telemetryType instanceof O9) {
            linkedHashMap.put("errorCode", Short.valueOf(((O9) telemetryType).f3158a));
            Ob ob2 = Ob.f3160a;
            Ob.b("IAPFetchFailed", linkedHashMap, Sb.SDK);
        } else {
            if (!(telemetryType instanceof Q9)) {
                if (telemetryType instanceof P9) {
                    Ob ob3 = Ob.f3160a;
                    Ob.b("IAPFetchSuccess", linkedHashMap, Sb.SDK);
                    return;
                }
                return;
            }
            String str = ((Q9) telemetryType).f3175a;
            if (str != null) {
                linkedHashMap.put(DivActionHandler.DivActionReason.TRIGGER, str);
            }
            Ob ob4 = Ob.f3160a;
            Ob.b("BillingClientNotCompatible", linkedHashMap, Sb.SDK);
        }
    }
}
