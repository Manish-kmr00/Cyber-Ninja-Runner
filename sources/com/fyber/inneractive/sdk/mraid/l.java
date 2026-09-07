package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.web.I;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class l extends AbstractC3123f {
    public l(LinkedHashMap linkedHashMap, I i, h0 h0Var) {
        super(linkedHashMap, i, h0Var);
    }

    @Override // com.fyber.inneractive.sdk.mraid.AbstractC3123f
    public final void a() {
        this.c.a(k.GET_CURRENT_POSITION, "Unsupported action getCurrentPosition");
    }

    @Override // com.fyber.inneractive.sdk.mraid.AbstractC3123f
    public final boolean b() {
        return false;
    }
}
