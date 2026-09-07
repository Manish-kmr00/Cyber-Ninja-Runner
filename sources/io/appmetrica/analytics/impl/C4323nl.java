package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.StartupParamsCallback;
import java.util.HashMap;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.nl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4323nl extends HashMap {
    public C4323nl() {
        put(EnumC4273ll.UNKNOWN, StartupParamsCallback.Reason.UNKNOWN);
        put(EnumC4273ll.NETWORK, StartupParamsCallback.Reason.NETWORK);
        put(EnumC4273ll.PARSE, StartupParamsCallback.Reason.INVALID_RESPONSE);
    }
}
