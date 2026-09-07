package com.bykv.vk.openvk.preload.b;

/* JADX INFO: compiled from: Pipe.java */
/* JADX INFO: loaded from: classes11.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Class<? extends d> f901a;
    private com.bykv.vk.openvk.preload.b.b.a b;
    private Object[] c;

    /* synthetic */ h(a aVar, byte b) {
        this(aVar);
    }

    private h(a aVar) {
        this.f901a = aVar.f902a;
        this.b = aVar.b;
        this.c = aVar.c;
        if (this.f901a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }

    final com.bykv.vk.openvk.preload.b.b.a a() {
        return this.b;
    }

    final Object[] b() {
        return this.c;
    }

    /* JADX INFO: compiled from: Pipe.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Class<? extends d> f902a;
        private com.bykv.vk.openvk.preload.b.b.a b;
        private Object[] c;

        private a() {
        }

        public static a a() {
            return new a();
        }

        public final a a(Class<? extends d> cls) {
            if (cls == null) {
                throw new IllegalArgumentException("interceptor class == null");
            }
            this.f902a = cls;
            return this;
        }

        public final a a(com.bykv.vk.openvk.preload.b.b.a aVar) {
            this.b = aVar;
            return this;
        }

        public final a a(Object... objArr) {
            this.c = objArr;
            return this;
        }

        public final h b() {
            return new h(this, (byte) 0);
        }
    }
}
