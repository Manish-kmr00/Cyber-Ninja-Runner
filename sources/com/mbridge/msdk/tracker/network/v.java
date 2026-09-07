package com.mbridge.msdk.tracker.network;

/* JADX INFO: compiled from: Response.java */
/* JADX INFO: loaded from: classes4.dex */
public class v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f5654a;
    public final com.mbridge.msdk.tracker.network.b.a b;
    public final b0 c;
    public boolean d;

    /* JADX INFO: compiled from: Response.java */
    public interface a {
        void a(b0 b0Var);
    }

    /* JADX INFO: compiled from: Response.java */
    public interface b<T> {
        void a(T t);
    }

    private v(T t, com.mbridge.msdk.tracker.network.b.a aVar) {
        this.d = false;
        this.f5654a = t;
        this.b = aVar;
        this.c = null;
    }

    public static <T> v<T> a(T t, com.mbridge.msdk.tracker.network.b.a aVar) {
        return new v<>(t, aVar);
    }

    public static <T> v<T> a(b0 b0Var) {
        return new v<>(b0Var);
    }

    public boolean a() {
        return this.c == null;
    }

    private v(b0 b0Var) {
        this.d = false;
        this.f5654a = null;
        this.b = null;
        this.c = b0Var;
    }
}
