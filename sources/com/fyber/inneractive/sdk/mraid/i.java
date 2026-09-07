package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.web.I;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class i extends AbstractC3122e {
    public i(LinkedHashMap linkedHashMap, I i, h0 h0Var) {
        super(linkedHashMap, i, h0Var);
    }

    @Override // com.fyber.inneractive.sdk.mraid.AbstractC3123f
    public final void a() {
        int iA = a("w");
        int iA2 = a("h");
        this.c.a((String) this.b.get("url"), iA <= 0 ? -1 : iA, iA2 <= 0 ? -1 : iA2, "true".equals(this.b.get("shouldUseCustomClose")), "true".equals(this.b.get("lockOrientation")));
    }

    @Override // com.fyber.inneractive.sdk.mraid.AbstractC3122e
    public final String c() {
        return (String) this.b.get("url");
    }
}
