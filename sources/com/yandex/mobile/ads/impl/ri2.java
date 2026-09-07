package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes10.dex */
public final class ri2<T> implements pk.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wp1<T> f10112a;

    public static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static kb2 b(ki2 ki2Var) {
            if (ki2Var instanceof d50) {
                return kb2.a.a((d50) ki2Var);
            }
            if (ki2Var instanceof yf1) {
                return kb2.a.a();
            }
            tc1 tc1Var = ki2Var.b;
            if (tc1Var == null) {
                return kb2.a.a(ki2Var.getMessage());
            }
            int i = tc1Var.f10286a;
            if (i >= 500) {
                return kb2.a.b();
            }
            byte[] data = tc1Var.b;
            Intrinsics.checkNotNullExpressionValue(data, "data");
            String str = ("Network Error.  Code: " + i + ".") + " Data: \n" + new String(data, Charsets.UTF_8);
            op0.c(new Object[0]);
            return kb2.a.b(str);
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }

    @Override // com.yandex.mobile.ads.impl.qq1.a
    public final void a(ki2 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (this.f10112a != null) {
            this.f10112a.a(a.b(error));
        }
    }

    public ri2(wp1<T> wp1Var) {
        this.f10112a = wp1Var;
    }

    @Override // com.yandex.mobile.ads.impl.qq1.b
    public final void a(T response) {
        Intrinsics.checkNotNullParameter(response, "response");
        wp1<T> wp1Var = this.f10112a;
        if (wp1Var != null) {
            wp1Var.a(response);
        }
    }
}
