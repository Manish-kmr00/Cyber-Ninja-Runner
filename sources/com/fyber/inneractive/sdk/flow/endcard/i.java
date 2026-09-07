package com.fyber.inneractive.sdk.flow.endcard;

import android.content.Context;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.flow.S;
import com.fyber.inneractive.sdk.flow.V;
import com.fyber.inneractive.sdk.network.F;
import com.fyber.inneractive.sdk.network.L;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V f1793a;
    public final j b;
    public final F c;
    public final boolean d;
    public final h e;

    public i(Context context, S s) {
        L l = IAConfigManager.O.s;
        V v = new V(context, s);
        this.b = new j();
        this.e = new h();
        this.f1793a = v;
        this.c = l;
        this.d = !TextUtils.equals(v.d.E, "1");
    }

    public final b a() {
        j jVar = this.b;
        int i = jVar.c;
        if (i >= 0) {
            return (b) jVar.f1794a.get(i);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        if (r0.c >= 0) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.fyber.inneractive.sdk.flow.endcard.b b() {
        /*
            r7 = this;
            com.fyber.inneractive.sdk.flow.endcard.j r0 = r7.b
            java.util.ArrayList r1 = r0.f1794a
            int r1 = r1.size()
            int r2 = r0.c
        La:
            int r2 = r2 + 1
            if (r2 >= r1) goto L7a
            java.util.ArrayList r3 = r0.f1794a
            java.lang.Object r3 = r3.get(r2)
            com.fyber.inneractive.sdk.flow.endcard.b r3 = (com.fyber.inneractive.sdk.flow.endcard.b) r3
            boolean r4 = r3.j()
            if (r4 == 0) goto La
            com.fyber.inneractive.sdk.model.vast.i r1 = r3.h()
            com.fyber.inneractive.sdk.model.vast.i r4 = com.fyber.inneractive.sdk.model.vast.i.Default_End_Card
            if (r1 != r4) goto L43
            java.util.ArrayList r1 = r0.b
            int r1 = r1.size()
            int r1 = r1 + (-1)
        L2c:
            if (r1 < 0) goto L3e
            java.util.ArrayList r4 = r0.b
            java.lang.Object r4 = r4.get(r1)
            com.fyber.inneractive.sdk.flow.endcard.b r4 = (com.fyber.inneractive.sdk.flow.endcard.b) r4
            boolean r4 = r4 instanceof com.fyber.inneractive.sdk.flow.endcard.n
            if (r4 == 0) goto L3b
            goto L7a
        L3b:
            int r1 = r1 + (-1)
            goto L2c
        L3e:
            int r1 = r0.c
            if (r1 < 0) goto L6a
            goto L7a
        L43:
            boolean r1 = r3 instanceof com.fyber.inneractive.sdk.flow.endcard.c
            if (r1 == 0) goto L6a
            int r1 = r2 + 1
            java.util.ArrayList r4 = r0.f1794a
            int r4 = r4.size()
            int r4 = r4 + (-1)
        L51:
            if (r4 < r1) goto L6a
            java.util.ArrayList r5 = r0.f1794a
            java.lang.Object r5 = r5.get(r4)
            com.fyber.inneractive.sdk.flow.endcard.b r5 = (com.fyber.inneractive.sdk.flow.endcard.b) r5
            boolean r6 = r5 instanceof com.fyber.inneractive.sdk.flow.endcard.c
            if (r6 == 0) goto L67
            r5.destroy()
            java.util.ArrayList r5 = r0.f1794a
            r5.remove(r4)
        L67:
            int r4 = r4 + (-1)
            goto L51
        L6a:
            r0.c = r2
            java.util.ArrayList r1 = r0.b
            r1.add(r3)
            java.util.ArrayList r0 = r0.b
            int r0 = r0.size()
            r3.d = r0
            goto L7b
        L7a:
            r3 = 0
        L7b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.endcard.i.b():com.fyber.inneractive.sdk.flow.endcard.b");
    }
}
