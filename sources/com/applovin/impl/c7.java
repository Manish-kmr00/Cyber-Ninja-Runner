package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class c7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f382a;
    private boolean b;
    private List c;

    public c7(com.applovin.impl.sdk.k kVar) {
        this.f382a = kVar;
        x4 x4Var = x4.H;
        this.b = ((Boolean) kVar.a(x4Var, Boolean.FALSE)).booleanValue() || y.a(com.applovin.impl.sdk.k.o()).a("applovin.sdk.is_test_environment") || AppLovinSdkUtils.isEmulator() || kVar.B().R();
        kVar.c(x4Var);
    }

    private void e() {
        com.applovin.impl.sdk.j jVarU = this.f382a.u();
        if (this.b) {
            jVarU.b(this.c);
        } else {
            jVarU.a(this.c);
        }
    }

    public void a(String str) {
        if (StringUtils.isValidString(str)) {
            a(Collections.singletonList(str));
        } else {
            a((List) null);
        }
    }

    public List b() {
        return this.c;
    }

    public boolean c() {
        return this.b;
    }

    public boolean d() {
        List list = this.c;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void a(List list) {
        if (list == null && this.c == null) {
            return;
        }
        if (list == null || !list.equals(this.c)) {
            this.c = list;
            e();
        }
    }

    public void a() {
        this.f382a.b(x4.H, Boolean.TRUE);
    }

    public void a(JSONObject jSONObject) {
        if (this.b) {
            return;
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "test_mode_idfas", new JSONArray());
        com.applovin.impl.sdk.l lVarB = this.f382a.B();
        boolean zR = lVarB.R();
        String strA = lVarB.f().a();
        com.applovin.impl.sdk.l.b bVarF = lVarB.F();
        this.b = zR || JsonUtils.containsCaseInsensitiveString(strA, jSONArray) || JsonUtils.containsCaseInsensitiveString(bVarF != null ? bVarF.f662a : null, jSONArray);
    }
}
