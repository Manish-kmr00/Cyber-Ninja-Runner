package com.yandex.mobile.ads.impl;

import android.util.SparseBooleanArray;

/* JADX INFO: loaded from: classes10.dex */
public final class yb0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseBooleanArray f10719a;

    public final int hashCode() {
        if (x82.f10629a >= 24) {
            return this.f10719a.hashCode();
        }
        int size = this.f10719a.size();
        for (int i = 0; i < this.f10719a.size(); i++) {
            size = (size * 31) + b(i);
        }
        return size;
    }

    public final int b(int i) {
        hg.a(i, this.f10719a.size());
        return this.f10719a.keyAt(i);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SparseBooleanArray f10720a = new SparseBooleanArray();
        private boolean b;

        public final a a(int i) {
            if (!this.b) {
                this.f10720a.append(i, true);
                return this;
            }
            throw new IllegalStateException();
        }

        public final void a(yb0 yb0Var) {
            for (int i = 0; i < yb0Var.f10719a.size(); i++) {
                a(yb0Var.b(i));
            }
        }

        public final yb0 a() {
            if (!this.b) {
                this.b = true;
                return new yb0(this.f10720a);
            }
            throw new IllegalStateException();
        }
    }

    private yb0(SparseBooleanArray sparseBooleanArray) {
        this.f10719a = sparseBooleanArray;
    }

    public final boolean a(int i) {
        return this.f10719a.get(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yb0)) {
            return false;
        }
        yb0 yb0Var = (yb0) obj;
        if (x82.f10629a < 24) {
            if (this.f10719a.size() != yb0Var.f10719a.size()) {
                return false;
            }
            for (int i = 0; i < this.f10719a.size(); i++) {
                if (b(i) != yb0Var.b(i)) {
                    return false;
                }
            }
            return true;
        }
        return this.f10719a.equals(yb0Var.f10719a);
    }

    public final int a() {
        return this.f10719a.size();
    }
}
