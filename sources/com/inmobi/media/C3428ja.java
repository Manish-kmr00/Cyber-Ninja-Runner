package com.inmobi.media;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;

/* JADX INFO: renamed from: com.inmobi.media.ja, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3428ja extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3428ja f3348a = new C3428ja();

    public C3428ja() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws JSONException {
        N1 it = (N1) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        int i = it.f3141a;
        if (i != 1 && i != 2) {
            switch (i) {
                case 150:
                case 151:
                case 152:
                    Map map = it.c;
                    if (map != null && map.containsKey("data")) {
                        Object obj2 = it.c.get("data");
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.inmobi.commons.core.incident.IncidentEvent");
                        C3353e5 incident = (C3353e5) obj2;
                        EnumC3396h6 enumC3396h6 = C3442ka.f3360a;
                        Intrinsics.checkNotNullParameter(incident, "incident");
                        boolean z = incident instanceof R2;
                        if (z || (incident instanceof gd)) {
                            for (C3302ab c3302ab : P4.a()) {
                                EnumC3396h6 logLevel = EnumC3396h6.ERROR;
                                String message = "TYPE - " + incident.f3054a + ", TIMESTAMP - " + incident.b + ", PAYLOAD - " + incident.a();
                                c3302ab.getClass();
                                Intrinsics.checkNotNullParameter(logLevel, "logLevel");
                                Intrinsics.checkNotNullParameter("LOGGER CRASH", "tag");
                                Intrinsics.checkNotNullParameter(message, "message");
                                c3302ab.f3269a.a(logLevel, "LOGGER CRASH", message);
                                if (z) {
                                    c3302ab.f3269a.b();
                                }
                            }
                        } else if (C3442ka.e.getAnr().getAppExitReason().getReportToLogs() && (incident instanceof N0)) {
                            new C3437k5(C3442ka.e.getAnr().getAppExitReason().getIncompleteLogThresholdTime()).a(incident.f3054a, incident.a(), ((N0) incident).g, incident.b);
                        }
                    }
                    break;
            }
        } else {
            EnumC3396h6 enumC3396h7 = C3442ka.f3360a;
            for (C3302ab c3302ab2 : P4.a()) {
                EnumC3396h6 logLevel2 = EnumC3396h6.ERROR;
                String message2 = "SYSTEM SHUTDOWN RECEIVED - " + i;
                c3302ab2.getClass();
                Intrinsics.checkNotNullParameter(logLevel2, "logLevel");
                Intrinsics.checkNotNullParameter("LOGGER CRASH", "tag");
                Intrinsics.checkNotNullParameter(message2, "message");
                c3302ab2.f3269a.a(logLevel2, "LOGGER CRASH", message2);
                c3302ab2.f3269a.b();
            }
            AtomicBoolean atomicBoolean = C3442ka.c;
            atomicBoolean.set(false);
            P6 p6F = C3517pb.f();
            C3428ja c3428ja = C3442ka.g;
            p6F.a(c3428ja);
            C3442ka.b = null;
            EnumC3396h6 enumC3396h8 = C3442ka.f3360a;
            atomicBoolean.set(false);
            C3517pb.f().a(c3428ja);
            C3442ka.b = null;
        }
        return Unit.INSTANCE;
    }
}
