package com.yandex.mobile.ads.impl;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ik implements qv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f9230a;
    private final ArrayList<w62> b = new ArrayList<>(1);
    private int c;
    private uv d;

    @Override // com.yandex.mobile.ads.impl.qv
    public final void a(w62 w62Var) {
        w62Var.getClass();
        if (this.b.contains(w62Var)) {
            return;
        }
        this.b.add(w62Var);
        this.c++;
    }

    protected ik(boolean z) {
        this.f9230a = z;
    }

    protected final void b(uv uvVar) {
        for (int i = 0; i < this.c; i++) {
            this.b.get(i).getClass();
        }
    }

    protected final void c(int i) {
        uv uvVar = this.d;
        int i2 = x82.f10629a;
        for (int i3 = 0; i3 < this.c; i3++) {
            this.b.get(i3).a(uvVar, this.f9230a, i);
        }
    }

    protected final void e() {
        uv uvVar = this.d;
        int i = x82.f10629a;
        for (int i2 = 0; i2 < this.c; i2++) {
            this.b.get(i2).a(uvVar, this.f9230a);
        }
        this.d = null;
    }

    protected final void c(uv uvVar) {
        this.d = uvVar;
        for (int i = 0; i < this.c; i++) {
            this.b.get(i).b(uvVar, this.f9230a);
        }
    }
}
