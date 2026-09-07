package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.AbstractC3110o;
import com.fyber.inneractive.sdk.flow.EnumC3104i;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.FileNotFoundException;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.network.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3141q implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3142s f1930a;

    public C3141q(C3142s c3142s) {
        this.f1930a = c3142s;
    }

    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        InneractiveErrorCode inneractiveErrorCode;
        AbstractC3110o abstractC3110o;
        com.fyber.inneractive.sdk.response.e eVar = (com.fyber.inneractive.sdk.response.e) obj;
        if (exc == null) {
            C3142s c3142s = this.f1930a;
            c3142s.a(c3142s.e, eVar);
            return;
        }
        this.f1930a.getClass();
        if (exc instanceof k0) {
            inneractiveErrorCode = ((k0) exc).f1923a == 204 ? InneractiveErrorCode.NO_FILL : InneractiveErrorCode.SERVER_INTERNAL_ERROR;
        } else {
            inneractiveErrorCode = (!(exc instanceof FileNotFoundException) && (exc instanceof N)) ? InneractiveErrorCode.SERVER_INVALID_RESPONSE : InneractiveErrorCode.CONNECTION_ERROR;
        }
        C3142s c3142s2 = this.f1930a;
        InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(inneractiveErrorCode, EnumC3104i.NETWORK_ERROR, exc);
        InneractiveAdRequest inneractiveAdRequest = c3142s2.e;
        if (c3142s2.f1926a == null) {
            return;
        }
        if (c3142s2.b) {
            IAlog.e("IARemoteAdFetcher: ignoring response. Previous request was cancelled", new Object[0]);
        } else {
            if (c3142s2.b || (abstractC3110o = c3142s2.f1926a) == null) {
                return;
            }
            abstractC3110o.a(inneractiveAdRequest, eVar, inneractiveInfrastructureError);
        }
    }
}
