package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.aa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3988aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4522vl f11461a = new C4522vl();
    public C4038ca b = new C4038ca();

    public final synchronized void a(C4038ca c4038ca) {
        this.b = c4038ca;
    }

    public final synchronized void a(List list, HashMap map) {
        Boolean bool;
        String str;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), "appmetrica_lib_ssl_enabled") && (bool = this.b.f11492a) != null) {
                boolean zBooleanValue = bool.booleanValue();
                C4038ca c4038ca = this.b;
                IdentifierStatus identifierStatus = c4038ca.b;
                String str2 = c4038ca.c;
                if (zBooleanValue) {
                    str = "true";
                } else {
                    if (zBooleanValue) {
                        throw new NoWhenBranchMatchedException();
                    }
                    str = "false";
                }
                map.put("appmetrica_lib_ssl_enabled", this.f11461a.a(new IdentifiersResult(str, identifierStatus, str2)));
            }
        }
    }
}
