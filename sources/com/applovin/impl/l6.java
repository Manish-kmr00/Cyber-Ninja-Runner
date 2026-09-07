package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class l6 extends m6 {
    private final z2 g;

    public l6(z2 z2Var, com.applovin.impl.sdk.k kVar) {
        super("TaskReportMaxReward", kVar);
        this.g = z2Var;
    }

    @Override // com.applovin.impl.o6
    protected void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.g.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.g.getPlacement());
        JsonUtils.putString(jSONObject, "custom_data", this.g.e());
        String strM0 = this.g.m0();
        if (!StringUtils.isValidString(strM0)) {
            strM0 = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", strM0);
        String strC = this.g.C();
        if (!StringUtils.isValidString(strC)) {
            strC = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", strC);
    }

    @Override // com.applovin.impl.m6
    protected void b(JSONObject jSONObject) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Reported reward successfully for mediated ad: " + this.g);
        }
    }

    @Override // com.applovin.impl.o6
    protected String f() {
        return "2.0/mcr";
    }

    @Override // com.applovin.impl.m6
    protected l4 h() {
        return this.g.i0();
    }

    @Override // com.applovin.impl.m6
    protected void i() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "No reward result was found for mediated ad: " + this.g);
        }
    }

    @Override // com.applovin.impl.o6
    protected void a(int i) {
        super.a(i);
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Failed to report reward for mediated ad: " + this.g + " - error code: " + i);
        }
        this.f424a.P().a(c2.g0, this.g);
    }
}
