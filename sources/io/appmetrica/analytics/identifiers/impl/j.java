package io.appmetrica.analytics.identifiers.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;

/* JADX INFO: loaded from: classes12.dex */
public final class j implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f11041a;

    public j(f fVar) {
        this.f11041a = fVar;
    }

    @Override // io.appmetrica.analytics.identifiers.impl.b
    public final c a(Context context) {
        c cVar;
        f fVar;
        try {
            try {
                try {
                    m mVar = (m) ((o) this.f11041a.a(context));
                    cVar = new c(IdentifierStatus.OK, new a("huawei", mVar.a(), Boolean.valueOf(mVar.b())), null, 4);
                    fVar = this.f11041a;
                } catch (g e) {
                    String message = e.getMessage();
                    if (message == null) {
                        message = "unknown exception during binding huawei services";
                    }
                    cVar = new c(IdentifierStatus.IDENTIFIER_PROVIDER_UNAVAILABLE, null, message);
                    fVar = this.f11041a;
                } catch (Throwable th) {
                    cVar = new c(IdentifierStatus.IDENTIFIER_PROVIDER_UNAVAILABLE, null, "exception while fetching hoaid: " + th.getMessage());
                    fVar = this.f11041a;
                }
                fVar.b(context);
            } catch (Throwable unused) {
            }
            return cVar;
        } catch (Throwable th2) {
            try {
                this.f11041a.b(context);
            } catch (Throwable unused2) {
            }
            throw th2;
        }
    }

    public j() {
        this(new f(k.f11042a, i.f11040a, "huawei"));
    }
}
