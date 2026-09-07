package com.yandex.mobile.ads.impl;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class c8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ya f8576a = new ya();
    private final fj1 b = new fj1();

    public final ip1 a(v7 v7Var) {
        ip1 ip1Var = new ip1((Map) null, 3);
        if (v7Var != null) {
            Map<String, String> mapH = v7Var.h();
            this.f8576a.getClass();
            ip1 ip1Var2 = new ip1(new HashMap(), 2);
            if (mapH != null) {
                Object obj = (String) mapH.get("adapter_network_name");
                Object obj2 = (String) mapH.get("adapter_version");
                Object obj3 = (String) mapH.get("adapter_network_sdk_version");
                ip1Var2.a(obj, "adapter_network_name");
                ip1Var2.a(obj2, "adapter_version");
                ip1Var2.a(obj3, "adapter_network_sdk_version");
            }
            Map<String, Object> mapB = ip1Var2.b();
            this.b.getClass();
            ip1 ip1Var3 = new ip1(new HashMap(), 2);
            if (mapH != null) {
                Object obj4 = (String) mapH.get("plugin_type");
                Object obj5 = (String) mapH.get("plugin_version");
                ip1Var3.a(obj4, "plugin_type");
                ip1Var3.a(obj5, "plugin_version");
            }
            Map<String, Object> mapB2 = ip1Var3.b();
            String strJ = v7Var.j();
            ip1Var.a((Map<String, ? extends Object>) mapB);
            ip1Var.a((Map<String, ? extends Object>) mapB2);
            ip1Var.a(strJ, "preload_type");
        }
        String strG = v7Var != null ? v7Var.g() : null;
        boolean z = strG == null || strG.length() == 0;
        ip1Var.b(Boolean.valueOf(!z), "open_bidding");
        if (!z) {
            ip1Var.a("openbidding", "integration_type");
        }
        return ip1Var;
    }
}
