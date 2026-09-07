package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.web.I;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class t extends AbstractC3123f {
    public t(LinkedHashMap linkedHashMap, I i, h0 h0Var) {
        super(linkedHashMap, i, h0Var);
    }

    @Override // com.fyber.inneractive.sdk.mraid.AbstractC3123f
    public final void a() {
        Map map = this.b;
        this.c.setOrientationProperties((map != null && map.containsKey("allowOrientationChange") && "false".equals(this.b.get("allowOrientationChange"))) ? false : true, (String) this.b.get("forceOrientation"));
    }

    @Override // com.fyber.inneractive.sdk.mraid.AbstractC3123f
    public final boolean b() {
        return false;
    }
}
