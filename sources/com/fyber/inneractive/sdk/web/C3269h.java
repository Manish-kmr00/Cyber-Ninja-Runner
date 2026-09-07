package com.fyber.inneractive.sdk.web;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.web.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3269h implements InterfaceC3267f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2410a;
    public final com.fyber.inneractive.sdk.util.h0 b;
    public final /* synthetic */ AbstractC3270i c;

    public C3269h(AbstractC3270i abstractC3270i, String str, com.fyber.inneractive.sdk.util.h0 h0Var) {
        this.c = abstractC3270i;
        this.b = h0Var;
        this.f2410a = str;
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3267f
    public final String a() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3267f
    public final void b() {
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3267f
    public final String c() {
        return "open";
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3267f
    public final void d() {
        AbstractC3270i abstractC3270i = this.c;
        String str = this.f2410a;
        com.fyber.inneractive.sdk.util.h0 h0Var = this.b;
        k0 k0Var = abstractC3270i.g;
        if (k0Var != null) {
            com.fyber.inneractive.sdk.util.G g = k0Var.a(str, h0Var).f2344a;
        }
    }

    public final String toString() {
        return "action: open url: " + this.f2410a;
    }
}
