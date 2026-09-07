package com.fyber.inneractive.sdk.flow.endcard;

import com.fyber.inneractive.sdk.flow.V;
import com.fyber.inneractive.sdk.network.F;
import com.fyber.inneractive.sdk.util.AbstractC3257v;
import com.fyber.inneractive.sdk.util.EnumC3259x;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes.dex */
public final class q extends c {
    public q(V v, com.fyber.inneractive.sdk.model.vast.c cVar) {
        super(v, cVar);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void a(F f) {
        boolean zContainsKey;
        String str = this.e.f;
        int i = AbstractC3257v.f2379a[EnumC3259x.Mraid.ordinal()];
        if (i == 1) {
            com.fyber.inneractive.sdk.factories.f fVar = com.fyber.inneractive.sdk.factories.d.f1768a;
            zContainsKey = fVar.f1769a.containsKey(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_HTML);
        } else if (i != 2) {
            zContainsKey = false;
        } else {
            com.fyber.inneractive.sdk.factories.f fVar2 = com.fyber.inneractive.sdk.factories.d.f1768a;
            zContainsKey = fVar2.f1769a.containsKey(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_VAST);
        }
        if (!zContainsKey) {
            IAlog.f("%s MRAID required", this.f1789a);
            return;
        }
        l();
        s sVar = (s) f();
        sVar.e = str;
        sVar.e();
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final k c() {
        return new s(this);
    }
}
