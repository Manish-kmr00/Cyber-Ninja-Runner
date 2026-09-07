package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class uu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j80 f10421a;
    private final List<e62> b;
    private final mr0 c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private j80 f10422a;
        private List<e62> b;
        private mr0 c;

        public final void a(j80 j80Var) {
            this.f10422a = j80Var;
        }

        public final void a(mr0 mr0Var) {
            this.c = mr0Var;
        }

        public final void a(List list) {
            this.b = list;
        }

        public final uu a() {
            return new uu(this.f10422a, this.b, this.c);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uu)) {
            return false;
        }
        uu uuVar = (uu) obj;
        return Intrinsics.areEqual(this.f10421a, uuVar.f10421a) && Intrinsics.areEqual(this.b, uuVar.b) && Intrinsics.areEqual(this.c, uuVar.c);
    }

    public final int hashCode() {
        j80 j80Var = this.f10421a;
        int iHashCode = (j80Var == null ? 0 : j80Var.hashCode()) * 31;
        List<e62> list = this.b;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        mr0 mr0Var = this.c;
        return iHashCode2 + (mr0Var != null ? mr0Var.hashCode() : 0);
    }

    public final String toString() {
        return "CreativeExtensions(falseClick=" + this.f10421a + ", trackingEvents=" + this.b + ", linearCreativeInfo=" + this.c + ")";
    }

    public uu(j80 j80Var, List<e62> list, mr0 mr0Var) {
        this.f10421a = j80Var;
        this.b = list;
        this.c = mr0Var;
    }

    public final j80 a() {
        return this.f10421a;
    }

    public final List<e62> c() {
        return this.b;
    }

    public final mr0 b() {
        return this.c;
    }
}
