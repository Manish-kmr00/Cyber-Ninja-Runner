package com.json;

import com.json.mediationsdk.e;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class h5 extends e.a {
    public h5(s4 s4Var, URL url, JSONObject jSONObject, boolean z, int i, long j, boolean z2, boolean z3, int i2) {
        super(s4Var, url, jSONObject, z, i, j, z2, z3, i2);
    }

    @Override // com.ironsource.mediationsdk.e.a
    protected void a(boolean z, s4 s4Var, long j) {
        try {
            if (z) {
                ((a5) s4Var).a(this.b, this.f + 1, j, this.j, this.i);
            } else {
                s4Var.a(this.c, this.d, this.f + 1, this.g, j);
            }
        } catch (Exception e) {
            o9.d().a(e);
            s4Var.a(1009, e.getMessage(), this.f + 1, this.g, j);
        }
    }
}
