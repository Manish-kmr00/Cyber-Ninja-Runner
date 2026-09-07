package com.inmobi.media;

/* JADX INFO: renamed from: com.inmobi.media.u3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3579u3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3441a;
    public final int b;
    public final float c;

    public C3579u3(int i, float f, int i2) {
        this.f3441a = i;
        this.b = i2;
        this.c = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3579u3)) {
            return false;
        }
        C3579u3 c3579u3 = (C3579u3) obj;
        return this.f3441a == c3579u3.f3441a && this.b == c3579u3.b && Float.compare(this.c, c3579u3.c) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.c) + ((Integer.hashCode(this.b) + (Integer.hashCode(this.f3441a) * 31)) * 31);
    }

    public final String toString() {
        return "DisplayProperties(width=" + this.f3441a + ", height=" + this.b + ", density=" + this.c + ')';
    }
}
