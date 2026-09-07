package com.yandex.mobile.ads.impl;

import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class bl {
    public static ip1 a(cl clVar) {
        qs qsVarA;
        ip1 ip1Var = new ip1((Map) null, 3);
        ip1Var.a((clVar == null || (qsVarA = clVar.a()) == null) ? null : qsVarA.a(), "ad_type");
        ip1Var.a(clVar != null ? clVar.b() : null, "parameters");
        zy1 zy1VarC = clVar != null ? clVar.c() : null;
        if (zy1VarC != null) {
            ip1Var.b(zy1VarC.a().a(), "size_type");
            ip1Var.b(Integer.valueOf(zy1VarC.getWidth()), "width");
            ip1Var.b(Integer.valueOf(zy1VarC.getHeight()), "height");
        }
        return ip1Var;
    }
}
