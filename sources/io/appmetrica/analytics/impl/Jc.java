package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class Jc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11206a;
    public final Object b;

    public Jc(Object obj) {
        this(new HashMap(), obj);
    }

    public final void a(Object obj, Object obj2) {
        this.f11206a.put(obj, obj2);
    }

    public Jc(HashMap map, Object obj) {
        this.f11206a = map;
        this.b = obj;
    }

    public final Object a(Object obj) {
        Object obj2 = this.f11206a.get(obj);
        return obj2 == null ? this.b : obj2;
    }
}
