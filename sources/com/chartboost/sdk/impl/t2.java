package com.chartboost.sdk.impl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class t2 {
    public JSONObject a(r2 r2Var) {
        if (r2Var == null) {
            return new JSONObject();
        }
        return z1.a(z1.a("carrier-name", r2Var.d()), z1.a("mobile-country-code", r2Var.a()), z1.a("mobile-network-code", r2Var.b()), z1.a("iso-country-code", r2Var.c()), z1.a("phone-type", Integer.valueOf(r2Var.e())));
    }
}
