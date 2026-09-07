package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.web.I;
import com.fyber.inneractive.sdk.web.k0;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class w extends AbstractC3123f {
    public w(LinkedHashMap linkedHashMap, I i, h0 h0Var) {
        super(linkedHashMap, i, h0Var);
    }

    @Override // com.fyber.inneractive.sdk.mraid.AbstractC3123f
    public final void a() {
        boolean zEquals = "true".equals(this.b.get("shouldUseCustomClose"));
        if (InneractiveAdManager.isCurrentUserAChild()) {
            zEquals = false;
        }
        I i = this.c;
        i.X = zEquals;
        k0 k0Var = i.g;
        if (k0Var != null) {
            ((com.fyber.inneractive.sdk.web.B) k0Var).b(zEquals);
        }
    }

    @Override // com.fyber.inneractive.sdk.mraid.AbstractC3123f
    public final boolean b() {
        return false;
    }
}
