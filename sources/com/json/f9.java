package com.json;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class f9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3691a = "SSA_CORE.SDKController.runFunction";

    public static String a(g9 g9Var) {
        return String.format("%1$s('%2$s%3$s'%4$s)", f3691a, g9Var.b(), a(g9Var.c()), b(g9Var));
    }

    private static String a(JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0) ? "" : jSONObject.toString();
    }

    private static String b(g9 g9Var) {
        return (g9Var.d() == null || g9Var.a() == null) ? "" : String.format(", '%1$s', '%2$s'", g9Var.d(), g9Var.a());
    }
}
