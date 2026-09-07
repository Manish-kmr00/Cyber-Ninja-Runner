package com.fyber.inneractive.sdk.flow.endcard;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.flow.V;
import com.fyber.inneractive.sdk.network.F;
import com.fyber.inneractive.sdk.network.L;
import com.fyber.inneractive.sdk.network.U;
import com.fyber.inneractive.sdk.network.e0;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class v extends c {
    public final com.fyber.inneractive.sdk.model.vast.k f;
    public final ArrayList g;

    public v(V v, com.fyber.inneractive.sdk.model.vast.c cVar) {
        super(v, cVar);
        this.g = new ArrayList();
        this.f = cVar.b;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void a(F f) {
        com.fyber.inneractive.sdk.model.vast.k kVar = this.f;
        int i = t.f1799a[kVar.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            IAlog.f("%s Invalid static type: %s", IAlog.a(this), kVar);
            return;
        }
        String str = this.e.f;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IAlog.c("%s load Static End-Card image %s", this.f1789a, str);
        l();
        e0 e0Var = new e0(new u(this, (w) f()), str, this.b.b.c);
        this.g.add(e0Var);
        ((L) f).b(e0Var);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final k c() {
        return new w(this);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b, com.fyber.inneractive.sdk.flow.endcard.k
    public final void destroy() {
        super.destroy();
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ((U) it.next()).f1914a = true;
        }
        this.g.clear();
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.c, com.fyber.inneractive.sdk.flow.endcard.b
    public final boolean j() {
        return super.j() && ((w) f()).c != null;
    }
}
