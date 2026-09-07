package com.chartboost.sdk.impl;

import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.internal.Networking.EndpointRepository;
import io.ktor.http.LinkHeader;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class j8 implements i2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g4 f1051a;
    public final f5 b;
    public final g2 c;
    public final d9 d;
    public final AtomicReference<o9> e;
    public final l4 f;
    public final EndpointRepository g;
    public int h = 1;
    public int i = 0;
    public long j = 0;
    public i2 k = null;
    public AtomicInteger l = null;

    public synchronized void b() {
        try {
            b7.c("Sdk Version = 9.8.3, Commit: f26a21259cbb49878f66b4d3322adcd53d3eaf74", null);
            o9 o9Var = this.e.get();
            a(o9Var);
            if (!o9Var.e() && !o9Var.d()) {
                if (this.h == 3) {
                    if (this.l.get() > 0) {
                        return;
                    }
                    b7.a("Change state to COOLDOWN", null);
                    this.h = 4;
                    this.l = null;
                }
                if (this.h == 4) {
                    if (this.j - System.nanoTime() > 0) {
                        b7.a("Prefetch session is still active. Won't be making any new prefetch until the prefetch session expires", null);
                        return;
                    }
                    b7.a("Change state to IDLE", null);
                    this.h = 1;
                    this.i = 0;
                    this.j = 0L;
                }
                if (this.h != 1) {
                    return;
                }
                if (!o9Var.h()) {
                    b7.b("Did not prefetch because neither native nor webview are enabled.", null);
                    return;
                }
                URL endPointUrl = this.g.getEndPointUrl(EndpointRepository.EndPoint.PREFETCH);
                q2 q2Var = new q2(c2.c.POST, com.chartboost.sdk.internal.Networking.b.a(endPointUrl), endPointUrl.getPath(), this.d.a(), k8.NORMAL, null, this, this.f);
                q2Var.b("cache_assets", this.b.e());
                q2Var.checkStatusInResponseBody = true;
                b7.a("Change state to AWAIT_PREFETCH_RESPONSE", null);
                this.h = 2;
                this.i = 2;
                this.j = System.nanoTime() + TimeUnit.MINUTES.toNanos(o9Var.v);
                this.k = q2Var;
                this.c.a(q2Var);
                return;
            }
            a();
        } catch (Exception e) {
            if (this.h == 2) {
                b7.a("Change state to COOLDOWN", null);
                this.h = 4;
                this.k = null;
            }
            b7.b(LinkHeader.Rel.Prefetch, e);
        }
    }

    public j8(g4 g4Var, f5 f5Var, g2 g2Var, d9 d9Var, AtomicReference<o9> atomicReference, l4 l4Var, EndpointRepository endpointRepository) {
        this.f1051a = g4Var;
        this.b = f5Var;
        this.c = g2Var;
        this.d = d9Var;
        this.e = atomicReference;
        this.f = l4Var;
        this.g = endpointRepository;
    }

    public final synchronized void a() {
        int i = this.h;
        if (i == 2) {
            b7.a("Change state to COOLDOWN", null);
            this.h = 4;
            this.k = null;
        } else if (i == 3) {
            b7.a("Change state to COOLDOWN", null);
            this.h = 4;
            AtomicInteger atomicInteger = this.l;
            this.l = null;
            if (atomicInteger != null) {
                this.f1051a.a(atomicInteger);
            }
        }
    }

    public final void a(o9 o9Var) {
        boolean z = o9Var.q;
        if (this.i != 2 || z) {
            return;
        }
        b7.a("Change state to IDLE", null);
        this.h = 1;
        this.i = 0;
        this.j = 0L;
        this.k = null;
        AtomicInteger atomicInteger = this.l;
        this.l = null;
        if (atomicInteger != null) {
            this.f1051a.a(atomicInteger);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0023 A[Catch: all -> 0x0036, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x0009, B:11:0x0023, B:16:0x002a), top: B:22:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:13:0x0027 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:15:0x0029  */
    /* JADX WARN: Code duplicated, block: B:9:0x0021 A[DONT_GENERATE] */
    /* JADX WARN: Instruction removed from duplicated block: B:13:0x0027, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:9:0x0021, please report this as an issue */
    @Override // com.chartboost.sdk.impl.i2.a
    public synchronized void a(i2 i2Var, CBError cBError) {
        String errorDesc = "Prefetch failure";
        if (cBError != null) {
            errorDesc = cBError.getErrorDesc();
            this.f.mo4741track(new j4(ma.f.PREFETCH_REQUEST_ERROR, errorDesc, "", "", null));
            if (this.h != 2) {
                return;
            }
            if (i2Var != this.k) {
                return;
            }
            this.k = null;
            b7.a("Change state to COOLDOWN", null);
            this.h = 4;
            return;
        }
        this.f.mo4741track(new j4(ma.f.PREFETCH_REQUEST_ERROR, errorDesc, "", "", null));
        if (this.h != 2) {
            return;
        }
        if (i2Var != this.k) {
            return;
        }
        this.k = null;
        b7.a("Change state to COOLDOWN", null);
        this.h = 4;
        return;
        throw th;
    }

    @Override // com.chartboost.sdk.impl.i2.a
    public synchronized void a(i2 i2Var, JSONObject jSONObject) {
        try {
            if (this.h != 2) {
                return;
            }
            if (i2Var != this.k) {
                return;
            }
            b7.a("Change state to DOWNLOAD_ASSETS", null);
            this.h = 3;
            this.k = null;
            this.l = new AtomicInteger();
            if (jSONObject != null) {
                b7.a("Got Asset list for Prefetch from server: " + jSONObject, null);
                this.f1051a.a(k8.LOW, c1.b(jSONObject, this.e.get().n), this.l, null, "");
            }
        } catch (Exception e) {
            b7.b("prefetch onSuccess", e);
        }
    }
}
