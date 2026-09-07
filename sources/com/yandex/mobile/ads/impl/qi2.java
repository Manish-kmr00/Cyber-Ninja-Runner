package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class qi2 implements pk.a<tc1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wp1<tc1> f10022a = null;

    @Override // com.yandex.mobile.ads.impl.qq1.a
    public final void a(ki2 error) {
        kb2 kb2Var;
        Intrinsics.checkNotNullParameter(error, "error");
        if (error.b == null) {
            String message = error.getMessage();
            if (message == null) {
                message = "Ad request failed with network error";
            }
            kb2Var = new kb2(2, message);
        } else {
            Intrinsics.checkNotNullParameter("Ping error", "description");
            kb2Var = new kb2(1, "Ping error");
        }
        wp1<tc1> wp1Var = this.f10022a;
        if (wp1Var != null) {
            wp1Var.a(kb2Var);
        }
    }

    @Override // com.yandex.mobile.ads.impl.qq1.b
    public final void a(Object obj) {
        tc1 response = (tc1) obj;
        Intrinsics.checkNotNullParameter(response, "response");
        wp1<tc1> wp1Var = this.f10022a;
        if (wp1Var != null) {
            wp1Var.a(response);
        }
    }
}
