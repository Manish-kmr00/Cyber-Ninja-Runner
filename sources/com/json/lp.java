package com.json;

/* JADX INFO: loaded from: classes8.dex */
public class lp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3872a;
    private boolean b;
    private boolean c;
    private pp d;
    private int e;
    private int f;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f3873a = true;
        private boolean b = false;
        private boolean c = false;
        private pp d = null;
        private int e = 0;
        private int f = 0;

        public b a(boolean z) {
            this.f3873a = z;
            return this;
        }

        public b a(boolean z, int i) {
            this.c = z;
            this.f = i;
            return this;
        }

        public b a(boolean z, pp ppVar, int i) {
            this.b = z;
            if (ppVar == null) {
                ppVar = pp.PER_DAY;
            }
            this.d = ppVar;
            this.e = i;
            return this;
        }

        public lp a() {
            return new lp(this.f3873a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    private lp(boolean z, boolean z2, boolean z3, pp ppVar, int i, int i2) {
        this.f3872a = z;
        this.b = z2;
        this.c = z3;
        this.d = ppVar;
        this.e = i;
        this.f = i2;
    }

    public pp a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public boolean d() {
        return this.b;
    }

    public boolean e() {
        return this.f3872a;
    }

    public boolean f() {
        return this.c;
    }
}
