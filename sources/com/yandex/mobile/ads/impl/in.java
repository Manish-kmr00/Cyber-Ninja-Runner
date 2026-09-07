package com.yandex.mobile.ads.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
final class in {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9245a;
    public final String b;
    private final TreeSet<hy1> c = new TreeSet<>();
    private final ArrayList<a> d = new ArrayList<>();
    private kz e;

    public in(int i, String str, kz kzVar) {
        this.f9245a = i;
        this.b = str;
        this.e = kzVar;
    }

    public final boolean d() {
        return this.d.isEmpty();
    }

    public final void a(hy1 hy1Var) {
        this.c.add(hy1Var);
    }

    public final hy1 b(long j, long j2) {
        hy1 hy1VarA = hy1.a(this.b, j);
        hy1 hy1VarFloor = this.c.floor(hy1VarA);
        if (hy1VarFloor != null && hy1VarFloor.c + hy1VarFloor.d > j) {
            return hy1VarFloor;
        }
        hy1 hy1VarCeiling = this.c.ceiling(hy1VarA);
        if (hy1VarCeiling != null) {
            long j3 = hy1VarCeiling.c - j;
            j2 = j2 == -1 ? j3 : Math.min(j3, j2);
        }
        return hy1.a(this.b, j, j2);
    }

    public final boolean d(long j, long j2) {
        for (int i = 0; i < this.d.size(); i++) {
            a aVar = this.d.get(i);
            long j3 = aVar.f9246a;
            if (j3 <= j) {
                long j4 = aVar.b;
                if (j4 == -1 || j3 + j4 > j) {
                    return false;
                }
            } else {
                if (j2 == -1 || j + j2 > j3) {
                    return false;
                }
            }
        }
        this.d.add(new a(j, j2));
        return true;
    }

    public final boolean a(bs bsVar) {
        kz kzVar = this.e;
        kz kzVarA = kzVar.a(bsVar);
        this.e = kzVarA;
        return !kzVarA.equals(kzVar);
    }

    public final boolean c() {
        return this.c.isEmpty();
    }

    public final int hashCode() {
        return this.e.hashCode() + v3.a(this.b, this.f9245a * 31, 31);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || in.class != obj.getClass()) {
            return false;
        }
        in inVar = (in) obj;
        return this.f9245a == inVar.f9245a && this.b.equals(inVar.b) && this.c.equals(inVar.c) && this.e.equals(inVar.e);
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f9246a;
        public final long b;

        public a(long j, long j2) {
            this.f9246a = j;
            this.b = j2;
        }
    }

    public final TreeSet<hy1> b() {
        return this.c;
    }

    public final boolean c(long j, long j2) {
        for (int i = 0; i < this.d.size(); i++) {
            a aVar = this.d.get(i);
            long j3 = aVar.b;
            if (j3 == -1) {
                if (j >= aVar.f9246a) {
                    return true;
                }
            } else if (j2 == -1) {
                continue;
            } else {
                long j4 = aVar.f9246a;
                if (j4 <= j && j + j2 <= j4 + j3) {
                    return true;
                }
            }
        }
        return false;
    }

    public final long a(long j, long j2) {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        if (j2 >= 0) {
            hy1 hy1VarB = b(j, j2);
            if (!hy1VarB.e) {
                long j3 = hy1VarB.d;
                return -Math.min(j3 != -1 ? j3 : Long.MAX_VALUE, j2);
            }
            long j4 = j + j2;
            long j5 = j4 >= 0 ? j4 : Long.MAX_VALUE;
            long jMax = hy1VarB.c + hy1VarB.d;
            if (jMax < j5) {
                for (hy1 hy1Var : this.c.tailSet(hy1VarB, false)) {
                    long j6 = hy1Var.c;
                    if (j6 > jMax) {
                        break;
                    }
                    jMax = Math.max(jMax, j6 + hy1Var.d);
                    if (jMax >= j5) {
                        break;
                    }
                }
            }
            return Math.min(jMax - j, j2);
        }
        throw new IllegalArgumentException();
    }

    public final kz a() {
        return this.e;
    }

    public final boolean a(en enVar) {
        if (!this.c.remove(enVar)) {
            return false;
        }
        File file = enVar.f;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    public final hy1 a(hy1 hy1Var, long j, boolean z) {
        if (this.c.remove(hy1Var)) {
            File file = hy1Var.f;
            file.getClass();
            if (z) {
                File parentFile = file.getParentFile();
                parentFile.getClass();
                long j2 = hy1Var.c;
                int i = this.f9245a;
                int i2 = hy1.k;
                File file2 = new File(parentFile, i + "." + j2 + "." + j + ".v3.exo");
                if (file.renameTo(file2)) {
                    file = file2;
                } else {
                    at0.d("CachedContent", "Failed to rename " + file + " to " + file2);
                }
            }
            hy1 hy1VarA = hy1Var.a(file, j);
            this.c.add(hy1VarA);
            return hy1VarA;
        }
        throw new IllegalStateException();
    }

    public final void a(long j) {
        for (int i = 0; i < this.d.size(); i++) {
            if (this.d.get(i).f9246a == j) {
                this.d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }
}
