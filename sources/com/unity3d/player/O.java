package com.unity3d.player;

import com.json.mediationsdk.logger.IronSourceError;
import java.lang.reflect.Member;

/* JADX INFO: loaded from: classes12.dex */
final class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f8238a;
    private final String b;
    private final String c;
    private final int d;
    public volatile Member e;

    O(Class cls, String str, String str2) {
        this.f8238a = cls;
        this.b = str;
        this.c = str2;
        this.d = str2.hashCode() + ((str.hashCode() + ((cls.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31)) * 31);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof O)) {
            return false;
        }
        O o = (O) obj;
        return this.d == o.d && this.c.equals(o.c) && this.b.equals(o.b) && this.f8238a.equals(o.f8238a);
    }

    public final int hashCode() {
        return this.d;
    }
}
