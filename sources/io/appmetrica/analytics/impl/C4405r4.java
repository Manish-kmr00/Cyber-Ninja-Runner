package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.r4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4405r4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11743a;
    public final Integer b;
    public final String c;

    public C4405r4(String str, Integer num, String str2) {
        this.f11743a = str;
        this.b = num;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C4405r4.class != obj.getClass()) {
            return false;
        }
        C4405r4 c4405r4 = (C4405r4) obj;
        if (!this.f11743a.equals(c4405r4.f11743a)) {
            return false;
        }
        Integer num = this.b;
        if (num == null ? c4405r4.b != null : !num.equals(c4405r4.b)) {
            return false;
        }
        String str = this.c;
        String str2 = c4405r4.c;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public final int hashCode() {
        int iHashCode = this.f11743a.hashCode() * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }
}
