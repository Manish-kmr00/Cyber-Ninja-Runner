package com.fyber.inneractive.sdk.flow.endcard;

import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.AbstractC3270i;
import com.fyber.inneractive.sdk.web.InterfaceC3268g;

/* JADX INFO: loaded from: classes.dex */
public final class r implements InterfaceC3268g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f1798a;

    public r(s sVar) {
        this.f1798a = sVar;
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3268g
    public final void a(AbstractC3270i abstractC3270i) {
        IAlog.a("%s End-Card loaded", this.f1798a.f1788a);
        s sVar = this.f1798a;
        sVar.f = abstractC3270i != null;
        sVar.b.k();
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3268g
    public final void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
        IAlog.f("%s End-Card failed to load!", this.f1798a.f1788a);
        s sVar = this.f1798a;
        sVar.f = false;
        sVar.b.a(inneractiveInfrastructureError);
    }
}
