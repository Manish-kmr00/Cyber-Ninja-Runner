package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes8.dex */
public final class qq1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f10044a;
    public final sm.a b;
    public final ki2 c;
    public boolean d;

    public interface a {
        void a(ki2 ki2Var);
    }

    public interface b<T> {
        void a(T t);
    }

    public static <T> qq1<T> a(T t, sm.a aVar) {
        return new qq1<>(t, aVar);
    }

    public static <T> qq1<T> a(ki2 ki2Var) {
        return new qq1<>(ki2Var);
    }

    private qq1(ki2 ki2Var) {
        this.d = false;
        this.f10044a = null;
        this.b = null;
        this.c = ki2Var;
    }

    private qq1(T t, sm.a aVar) {
        this.d = false;
        this.f10044a = t;
        this.b = aVar;
        this.c = null;
    }
}
