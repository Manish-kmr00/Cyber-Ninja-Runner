package com.inmobi.media;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.c9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3329c9 extends S8 {
    public final C3315b9 y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3329c9(C3315b9 novatiqData, L4 l4) {
        super(novatiqData.c.getBeaconUrl(), l4);
        Intrinsics.checkNotNullParameter(novatiqData, "novatiqData");
        this.y = novatiqData;
        this.t = false;
        this.u = false;
        this.x = false;
    }

    @Override // com.inmobi.media.S8
    public final void f() {
        L4 l4 = this.e;
        if (l4 != null) {
            StringBuilder sbAppend = new StringBuilder("preparing Novatiq request with data - hyperId - ").append(this.y.f3276a).append(" - sspHost - ").append(this.y.b).append(" - pubId - inmobi");
            this.y.getClass();
            ((M4) l4).a("Novatiq", sbAppend.toString());
        }
        super.f();
        HashMap map = this.j;
        if (map != null) {
            map.put("sptoken", this.y.f3276a);
        }
        HashMap map2 = this.j;
        if (map2 != null) {
            this.y.getClass();
            map2.put("sspid", "i6i");
        }
        HashMap map3 = this.j;
        if (map3 != null) {
            map3.put("ssphost", this.y.b);
        }
        HashMap map4 = this.j;
        if (map4 != null) {
            this.y.getClass();
            map4.put("pubid", "inmobi");
        }
    }
}
