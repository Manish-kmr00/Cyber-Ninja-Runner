package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.foundation.tools.o0;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: MBridgeStringRequest.java */
/* JADX INFO: loaded from: classes6.dex */
public class k extends h<String> implements v.a {
    private final j<String> C;

    public k(int i, String str, String str2, long j, j<String> jVar) {
        super(i, str, 0, str2, j);
        this.C = jVar;
        a((v.a) this);
    }

    private void b(v<String> vVar) {
        j<String> jVar = this.C;
        if (jVar != null) {
            try {
                jVar.b(this, vVar, vVar.c.f5628a);
            } catch (Exception e) {
                o0.b(h.B, "parseNetworkResponse error: ", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.tracker.network.t
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void a(String str) {
    }

    @Override // com.mbridge.msdk.tracker.network.t
    protected v<String> a(q qVar) {
        try {
            v<String> vVarA = v.a(new String(qVar.b, StandardCharsets.UTF_8), com.mbridge.msdk.tracker.network.toolbox.f.a(qVar));
            a(vVarA, qVar);
            return vVarA;
        } catch (Throwable th) {
            o0.b(h.B, "parseNetworkResponse error: ", th);
            v<String> vVarA2 = v.a(new a0(th));
            b(vVarA2);
            return vVarA2;
        }
    }

    private void a(v<String> vVar, q qVar) {
        j<String> jVar = this.C;
        if (jVar != null) {
            try {
                jVar.a(this, vVar, qVar);
            } catch (Exception e) {
                o0.b(h.B, "parseNetworkResponse error: ", e);
            }
        }
    }

    @Override // com.mbridge.msdk.tracker.network.v.a
    public void a(b0 b0Var) {
        b(v.a(b0Var));
    }
}
