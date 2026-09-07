package sg.bigo.ads.common.u.a;

import android.net.TrafficStats;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import sg.bigo.ads.common.g;
import sg.bigo.ads.common.u.h;
import sg.bigo.ads.common.u.i;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements sg.bigo.ads.common.u.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f13262a = new b();
    private final g b;

    /* JADX INFO: renamed from: sg.bigo.ads.common.u.a.a$a, reason: collision with other inner class name */
    static class C0873a implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f13265a;

        public C0873a(d dVar) {
            this.f13265a = dVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            d dVar = this.f13265a;
            if (dVar != null) {
                dVar.f13268a.disconnect();
            }
        }
    }

    public a(g gVar) {
        this.b = gVar;
        e.k();
    }

    private void a(c cVar, sg.bigo.ads.common.u.b<sg.bigo.ads.common.u.b.c, sg.bigo.ads.common.u.c.c> bVar, boolean z) {
        InputStream inputStreamA;
        int i;
        TrafficStats.setThreadStatsTag(9999000);
        d dVar = null;
        boolean z2 = false;
        try {
            d dVar2 = new d(cVar);
            try {
                d.a aVarB = dVar2.b();
                if (aVarB != null) {
                    bVar.a(cVar.f13267a, aVarB.b, aVarB.e);
                    if (aVarB.c == 0 && aVarB.f13269a != null) {
                        this.f13262a.a(cVar.b, aVarB.f13269a);
                        try {
                            c cVarA = cVar.a(aVarB.f13269a);
                            sg.bigo.ads.common.t.a.a(0, 3, "AndroidNetClient", "process redirect, " + aVarB.f13269a);
                            if (cVar.c) {
                                cVar.f13267a.a(HttpHeaders.ACCEPT_ENCODING);
                            }
                            a(cVarA, bVar, z);
                            sg.bigo.ads.common.utils.g.a((Closeable) null);
                            dVar2.f13268a.disconnect();
                            TrafficStats.clearThreadStatsTag();
                            return;
                        } catch (i unused) {
                        }
                    }
                }
                if (bVar.a(cVar.f13267a, dVar2.b)) {
                    sg.bigo.ads.common.t.a.a(0, 3, "AndroidNetClient", cVar + ", responseCode = " + dVar2.b + ", is valid.");
                    inputStreamA = dVar2.a();
                    try {
                        a(bVar, cVar, bVar.a(new sg.bigo.ads.common.u.c.a(cVar.f13267a.i, dVar2.b, inputStreamA, dVar2.c, z ? null : new C0873a(dVar2))));
                    } catch (Throwable th) {
                        th = th;
                        dVar = dVar2;
                        try {
                            if (th instanceof SocketTimeoutException) {
                                i = 702;
                            } else {
                                i = th instanceof ConnectTimeoutException ? 701 : 700;
                            }
                            a(bVar, cVar, new h(i, th.getMessage()));
                            sg.bigo.ads.common.t.a.a(0, "AndroidNetClient", cVar + ", error = " + th.getMessage());
                            sg.bigo.ads.common.utils.g.a((Closeable) inputStreamA);
                            if (dVar != null) {
                                dVar.f13268a.disconnect();
                            }
                            return;
                        } finally {
                            if (z) {
                                sg.bigo.ads.common.utils.g.a((Closeable) inputStreamA);
                                if (dVar != null) {
                                    dVar.f13268a.disconnect();
                                }
                            }
                            TrafficStats.clearThreadStatsTag();
                        }
                    }
                } else {
                    String strA = aVarB != null ? aVarB.d : null;
                    InputStream errorStream = dVar2.f13268a.getErrorStream();
                    if (TextUtils.isEmpty(strA)) {
                        strA = sg.bigo.ads.common.utils.g.a(errorStream);
                    }
                    StringBuilder sb = new StringBuilder();
                    if (!TextUtils.isEmpty(strA)) {
                        sb.append(strA).append(", ");
                    }
                    sb.append("responseCode is ").append(dVar2.b).append(", validate fail.");
                    sg.bigo.ads.common.t.a.a(0, "AndroidNetClient", cVar + ", responseCode = " + dVar2.b + ", is invalid.");
                    a(bVar, cVar, new sg.bigo.ads.common.u.e(dVar2.b, sb.toString()));
                    z2 = true;
                    inputStreamA = errorStream;
                }
                if (z || z2) {
                    sg.bigo.ads.common.utils.g.a((Closeable) inputStreamA);
                    dVar2.f13268a.disconnect();
                }
                TrafficStats.clearThreadStatsTag();
            } catch (Throwable th2) {
                th = th2;
                inputStreamA = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamA = null;
        }
    }

    private static void a(sg.bigo.ads.common.u.b<sg.bigo.ads.common.u.b.c, sg.bigo.ads.common.u.c.c> bVar, c cVar, sg.bigo.ads.common.u.c.c cVar2) {
        if (!cVar.b()) {
            cVar.f13267a.j.c();
        }
        bVar.a(cVar.f13267a, cVar2);
    }

    private static void a(sg.bigo.ads.common.u.b<sg.bigo.ads.common.u.b.c, sg.bigo.ads.common.u.c.c> bVar, c cVar, h hVar) {
        if (!cVar.b()) {
            T t = cVar.f13267a.j;
            if (hVar.getClass() == h.class) {
                t.b();
            } else if (hVar.getClass() == sg.bigo.ads.common.u.e.class) {
                t.c();
            }
        }
        bVar.a(cVar.f13267a, hVar);
    }

    @Override // sg.bigo.ads.common.u.d
    public final void a(sg.bigo.ads.common.u.b.c cVar, sg.bigo.ads.common.u.b bVar) {
        new e(cVar.k, cVar, bVar) { // from class: sg.bigo.ads.common.u.a.a.1
            @Override // sg.bigo.ads.common.u.a.e
            protected final void a(sg.bigo.ads.common.u.b.c cVar2, sg.bigo.ads.common.u.b bVar2) {
                a.this.a(cVar2, (sg.bigo.ads.common.u.b<sg.bigo.ads.common.u.b.c, sg.bigo.ads.common.u.c.c>) bVar2, true);
            }
        }.l();
    }

    final void a(sg.bigo.ads.common.u.b.c cVar, sg.bigo.ads.common.u.b<sg.bigo.ads.common.u.b.c, sg.bigo.ads.common.u.c.c> bVar, boolean z) {
        a(new c(cVar, this.f13262a, this.b), bVar, z);
    }

    @Override // sg.bigo.ads.common.u.d
    public final void b(sg.bigo.ads.common.u.b.c cVar, sg.bigo.ads.common.u.b bVar) {
        new e(cVar.k, cVar, bVar) { // from class: sg.bigo.ads.common.u.a.a.2
            @Override // sg.bigo.ads.common.u.a.e
            protected final void a(sg.bigo.ads.common.u.b.c cVar2, sg.bigo.ads.common.u.b bVar2) {
                a.this.a(cVar2, (sg.bigo.ads.common.u.b<sg.bigo.ads.common.u.b.c, sg.bigo.ads.common.u.c.c>) bVar2, true);
            }
        }.l();
    }

    @Override // sg.bigo.ads.common.u.d
    public final void c(sg.bigo.ads.common.u.b.c cVar, sg.bigo.ads.common.u.b bVar) {
        a(cVar, (sg.bigo.ads.common.u.b<sg.bigo.ads.common.u.b.c, sg.bigo.ads.common.u.c.c>) bVar, false);
    }
}
