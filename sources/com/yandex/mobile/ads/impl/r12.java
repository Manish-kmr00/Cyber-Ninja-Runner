package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class r12 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jo f10066a;
    private final b b;

    /* JADX INFO: Access modifiers changed from: private */
    interface b {
    }

    private r12(q12 q12Var, jo joVar) {
        this.b = q12Var;
        this.f10066a = joVar;
    }

    public final List<String> a(CharSequence charSequence) {
        charSequence.getClass();
        q12 q12Var = (q12) this.b;
        q12Var.getClass();
        p12 p12Var = new p12(q12Var, this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (p12Var.hasNext()) {
            arrayList.add(p12Var.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static r12 a(char c) {
        return new r12(new q12(new jo.b(c)), jo.d.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class a extends l<String> {
        final CharSequence d;
        final jo e;
        int g = 0;
        final boolean f = false;
        int h = Integer.MAX_VALUE;

        protected a(r12 r12Var, CharSequence charSequence) {
            this.e = r12Var.f10066a;
            this.d = charSequence;
        }
    }
}
