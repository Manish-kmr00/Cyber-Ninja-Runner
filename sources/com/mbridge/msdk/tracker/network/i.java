package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.foundation.tools.o0;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MBridgeJsonRequest.java */
/* JADX INFO: loaded from: classes6.dex */
public class i extends h<JSONObject> implements v.a {
    private final j<JSONObject> C;

    public i(int i, String str, String str2, long j, j<JSONObject> jVar) {
        super(i, str, 0, str2, j);
        this.C = jVar;
        a((v.a) this);
    }

    private void b(v<JSONObject> vVar) {
        j<JSONObject> jVar = this.C;
        if (jVar != null) {
            try {
                jVar.b(this, vVar, vVar.c.f5628a);
            } catch (Exception e) {
                o0.b(h.B, e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.tracker.network.t
    public void a(JSONObject jSONObject) {
    }

    @Override // com.mbridge.msdk.tracker.network.t
    protected v<JSONObject> a(q qVar) {
        try {
            String str = new String(qVar.b, StandardCharsets.UTF_8);
            if (qVar.f5638a == 204) {
                v<JSONObject> vVarA = v.a(new JSONObject(), com.mbridge.msdk.tracker.network.toolbox.f.a(qVar));
                a(vVarA, qVar);
                return vVarA;
            }
            v<JSONObject> vVarA2 = v.a(MintegralNetworkBridge.jsonObjectInit(str), com.mbridge.msdk.tracker.network.toolbox.f.a(qVar));
            a(vVarA2, qVar);
            return vVarA2;
        } catch (JSONException e) {
            o0.b(h.B, e.getMessage());
            v<JSONObject> vVarA3 = v.a(new s(e));
            b(vVarA3);
            return vVarA3;
        } catch (Throwable th) {
            v<JSONObject> vVarA4 = v.a(new a0(th));
            b(vVarA4);
            return vVarA4;
        }
    }

    private void a(v<JSONObject> vVar, q qVar) {
        j<JSONObject> jVar = this.C;
        if (jVar != null) {
            try {
                jVar.a(this, vVar, qVar);
            } catch (Exception e) {
                o0.b(h.B, e.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.tracker.network.v.a
    public void a(b0 b0Var) {
        b(v.a(b0Var));
    }
}
