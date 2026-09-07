package com.applovin.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class r2 implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f603a;
    private final String b;
    private final boolean c;
    private final b3 d;

    r2(String str, String str2, boolean z, b3 b3Var) {
        this.f603a = str;
        this.b = str2;
        this.c = z;
        this.d = b3Var;
    }

    public String a() {
        return this.b;
    }

    public List b() {
        List listL = this.d.l();
        return (listL == null || listL.isEmpty()) ? Collections.singletonList(this.f603a) : listL;
    }

    public String c() {
        return this.f603a;
    }

    public b3 d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        r2 r2Var = (r2) obj;
        String str = this.f603a;
        if (str == null ? r2Var.f603a != null : !str.equals(r2Var.f603a)) {
            return false;
        }
        String str2 = this.b;
        if (str2 == null ? r2Var.b == null : str2.equals(r2Var.b)) {
            return this.c == r2Var.c;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f603a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + (this.c ? 1 : 0);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(r2 r2Var) {
        return this.b.compareToIgnoreCase(r2Var.b);
    }
}
