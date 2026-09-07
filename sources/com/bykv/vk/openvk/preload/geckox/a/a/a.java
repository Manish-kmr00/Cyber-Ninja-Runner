package com.bykv.vk.openvk.preload.geckox.a.a;

/* JADX INFO: compiled from: CacheConfig.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f913a;
    private final b b;
    private c c;

    /* synthetic */ a(C0163a c0163a, byte b) {
        this(c0163a);
    }

    private a(C0163a c0163a) {
        this.f913a = c0163a.f914a;
        this.b = c0163a.b;
        this.c = null;
    }

    public final b a() {
        return this.b;
    }

    /* JADX INFO: renamed from: com.bykv.vk.openvk.preload.geckox.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CacheConfig.java */
    public static final class C0163a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f914a;
        private b b = b.f915a;

        public final C0163a a() {
            this.f914a = 20;
            return this;
        }

        public final C0163a a(b bVar) {
            if (bVar == null) {
                bVar = b.f915a;
            }
            this.b = bVar;
            return this;
        }

        public final a b() {
            return new a(this, (byte) 0);
        }
    }
}
