package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes12.dex */
public interface xw1 {

    public static class b implements xw1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f10683a;
        private final a b;

        @Override // com.yandex.mobile.ads.impl.xw1
        public final boolean b() {
            return false;
        }

        public b() {
            this(-9223372036854775807L, 0L);
        }

        public b(long j, long j2) {
            this.f10683a = j;
            this.b = new a(j2 == 0 ? zw1.c : new zw1(0L, j2));
        }

        @Override // com.yandex.mobile.ads.impl.xw1
        public final long c() {
            return this.f10683a;
        }

        @Override // com.yandex.mobile.ads.impl.xw1
        public final a b(long j) {
            return this.b;
        }
    }

    a b(long j);

    boolean b();

    long c();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final zw1 f10682a;
        public final zw1 b;

        public a(zw1 zw1Var) {
            this(zw1Var, zw1Var);
        }

        public final String toString() {
            return com.ironsource.b9.i.d + this.f10682a + (this.f10682a.equals(this.b) ? "" : ", " + this.b) + com.ironsource.b9.i.e;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f10682a.equals(aVar.f10682a) && this.b.equals(aVar.b);
        }

        public final int hashCode() {
            return this.b.hashCode() + (this.f10682a.hashCode() * 31);
        }

        public a(zw1 zw1Var, zw1 zw1Var2) {
            this.f10682a = (zw1) hg.a(zw1Var);
            this.b = (zw1) hg.a(zw1Var2);
        }
    }
}
