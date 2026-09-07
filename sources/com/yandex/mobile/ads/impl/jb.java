package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class jb implements fk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9299a;
    private final String b;
    private final String c;
    private final List<String> d;

    public jb(String actionType, String adtuneUrl, String optOutUrl, ArrayList trackingUrls) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(adtuneUrl, "adtuneUrl");
        Intrinsics.checkNotNullParameter(optOutUrl, "optOutUrl");
        Intrinsics.checkNotNullParameter(trackingUrls, "trackingUrls");
        this.f9299a = actionType;
        this.b = adtuneUrl;
        this.c = optOutUrl;
        this.d = trackingUrls;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jb)) {
            return false;
        }
        jb jbVar = (jb) obj;
        return Intrinsics.areEqual(this.f9299a, jbVar.f9299a) && Intrinsics.areEqual(this.b, jbVar.b) && Intrinsics.areEqual(this.c, jbVar.c) && Intrinsics.areEqual(this.d, jbVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + v3.a(this.c, v3.a(this.b, this.f9299a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        return "AdtuneAction(actionType=" + this.f9299a + ", adtuneUrl=" + this.b + ", optOutUrl=" + this.c + ", trackingUrls=" + this.d + ")";
    }

    @Override // com.yandex.mobile.ads.impl.x
    public final String a() {
        return this.f9299a;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.c;
    }

    @Override // com.yandex.mobile.ads.impl.fk
    public final List<String> b() {
        return this.d;
    }
}
