package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.fg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4119fg implements Zf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f11552a;
    public boolean b;
    public C4044cg c;

    public C4119fg() {
        this(C4486ua.j().t());
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0027 A[Catch: all -> 0x003a, LOOP:0: B:6:0x0021->B:8:0x0027, LOOP_END, TryCatch #0 {, blocks: (B:4:0x0003, B:5:0x0016, B:6:0x0021, B:8:0x0027, B:9:0x0033), top: B:15:0x0003 }] */
    @Override // io.appmetrica.analytics.impl.Zf
    public final synchronized void a(C4044cg c4044cg) {
        Iterator it;
        if (c4044cg != null) {
            LoggerStorage.getMainPublicOrAnonymousLogger().info("Received referrer from source %s: %s", c4044cg.d.f11480a, c4044cg.f11496a);
            this.c = c4044cg;
            this.b = true;
            it = this.f11552a.iterator();
            while (it.hasNext()) {
                ((Sf) it.next()).a(this.c);
            }
            this.f11552a.clear();
        } else {
            this.c = c4044cg;
            this.b = true;
            it = this.f11552a.iterator();
            while (it.hasNext()) {
                ((Sf) it.next()).a(this.c);
            }
            this.f11552a.clear();
        }
        throw th;
    }

    public C4119fg(C3994ag c3994ag) {
        this.f11552a = new HashSet();
        c3994ag.a(new Zk(this));
        c3994ag.a();
    }

    public final synchronized void a(Sf sf) {
        this.f11552a.add(sf);
        if (this.b) {
            sf.a(this.c);
            this.f11552a.remove(sf);
        }
    }
}
