package com.ogury.ad.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class d7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7282a;
    public final int b;
    public final int c;

    public d7(int i, int i2, int i3) {
        this.f7282a = i;
        this.b = i2;
        this.c = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d7)) {
            return false;
        }
        d7 d7Var = (d7) obj;
        return this.f7282a == d7Var.f7282a && this.b == d7Var.b && this.c == d7Var.c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.c) + ((Integer.hashCode(this.b) + (Integer.hashCode(this.f7282a) * 31)) * 31);
    }

    public final String toString() {
        return "OverlayPosition(gravity=" + this.f7282a + ", xMargin=" + this.b + ", yMargin=" + this.c + ")";
    }
}
