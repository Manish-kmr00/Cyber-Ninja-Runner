package com.inmobi.media;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class Pa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3170a;
    public final Ma b;
    public final HashMap c;
    public final HashMap d;
    public final String e;
    public final Na f;
    public final boolean g;
    public final Oa h;
    public final int i;
    public final int j;
    public final boolean k;
    public R8 l;
    public int m;

    public Pa(La la) {
        Intrinsics.checkNotNullExpressionValue("Pa", "getSimpleName(...)");
        this.f3170a = la.f3127a;
        this.b = la.b;
        this.c = la.c;
        this.d = la.d;
        String str = la.e;
        this.e = str == null ? "" : str;
        this.f = Na.LOW;
        Boolean bool = la.f;
        this.g = bool != null ? bool.booleanValue() : true;
        this.h = la.g;
        Integer num = la.h;
        this.i = num != null ? num.intValue() : 60000;
        Integer num2 = la.i;
        this.j = num2 != null ? num2.intValue() : 60000;
        Boolean bool2 = la.j;
        this.k = bool2 != null ? bool2.booleanValue() : false;
    }

    public final String toString() {
        return "URL:" + Q8.a(this.f3170a, this.d) + " | TAG:null | METHOD:" + this.b + " | PAYLOAD:" + this.e + " | HEADERS:" + this.c + " | RETRY_POLICY:" + this.h;
    }
}
