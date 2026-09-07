package com.inmobi.media;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.inmobi.media.g5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3381g5 {
    private final boolean GPID;

    public C3381g5() {
        this(false, 1, null);
    }

    public final boolean a() {
        return this.GPID;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C3381g5) && this.GPID == ((C3381g5) obj).GPID;
    }

    public final int hashCode() {
        boolean z = this.GPID;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final String toString() {
        return "IncludeIdParams(GPID=" + this.GPID + ')';
    }

    public C3381g5(boolean z) {
        this.GPID = z;
    }

    public /* synthetic */ C3381g5(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }
}
