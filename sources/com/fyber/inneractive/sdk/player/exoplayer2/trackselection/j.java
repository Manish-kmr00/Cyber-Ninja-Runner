package com.fyber.inneractive.sdk.player.exoplayer2.trackselection;

import com.fyber.inneractive.sdk.player.exoplayer2.source.z;
import com.fyber.inneractive.sdk.player.exoplayer2.t;

/* JADX INFO: loaded from: classes10.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f2144a;
    public final h b;
    public final Object c;
    public final t[] d;

    public j(z zVar, h hVar, f fVar, t[] tVarArr) {
        this.f2144a = zVar;
        this.b = hVar;
        this.c = fVar;
        this.d = tVarArr;
    }

    public final boolean a(j jVar, int i) {
        return jVar != null && com.fyber.inneractive.sdk.player.exoplayer2.util.z.a(this.b.b[i], jVar.b.b[i]) && com.fyber.inneractive.sdk.player.exoplayer2.util.z.a(this.d[i], jVar.d[i]);
    }
}
