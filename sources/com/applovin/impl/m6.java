package com.applovin.impl;

import com.amazon.aps.shared.util.APSSharedUtil;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m6 extends o6 {
    protected m6(String str, com.applovin.impl.sdk.k kVar) {
        super(str, kVar);
    }

    private JSONObject a(l4 l4Var) {
        JSONObject jSONObjectE = e();
        JsonUtils.putString(jSONObjectE, "result", l4Var.b());
        Map mapA = l4Var.a();
        if (mapA != null) {
            JsonUtils.putJSONObject(jSONObjectE, "params", new JSONObject(mapA));
        }
        return jSONObjectE;
    }

    protected abstract void b(JSONObject jSONObject);

    @Override // com.applovin.impl.o6
    protected int g() {
        return ((Integer) this.f424a.a(v4.e1)).intValue();
    }

    protected abstract l4 h();

    protected abstract void i();

    @Override // java.lang.Runnable
    public void run() {
        l4 l4VarH = h();
        if (l4VarH != null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Reporting pending reward: " + l4VarH + APSSharedUtil.TRUNCATE_SEPARATOR);
            }
            a(a(l4VarH), new a());
        } else {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Pending reward not found");
            }
            i();
        }
    }

    class a implements q0.e {
        a() {
        }

        @Override // com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            m6.this.b(jSONObject);
        }

        @Override // com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            m6.this.a(i);
        }
    }
}
