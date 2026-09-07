package com.fyber.inneractive.sdk.flow.endcard;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class o extends s {
    public final String i;
    public String j;
    public boolean k;

    public o(n nVar) {
        super(nVar);
        com.fyber.inneractive.sdk.model.vast.o oVar = nVar.b.e.f;
        this.i = oVar != null ? oVar.f1884a : null;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.s
    public final p c() {
        b bVar = this.b;
        return new p(bVar.b.e, (n) bVar);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.s
    public final void e() {
        if (TextUtils.isEmpty(this.j)) {
            throw new com.fyber.inneractive.sdk.flow.vast.h("No icon", "FMP End-Card icon not loaded");
        }
        super.e();
    }
}
